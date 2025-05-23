package com.tencent.thumbplayer.core.codec.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.DirectCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.preload.PreloadCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReusePolicy;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TCodecManager {
    public static final String TAG = "TCodecManager";
    private static final TCodecManager mInstance = new TCodecManager();
    private static boolean mIsDebugVersion = false;
    private static boolean mIsLeakFixed = true;
    private boolean mConfigMethodCalled;
    private ReusePolicy mReusePolicy = ReusePolicy.DEFAULT;
    private boolean mGlobalReuseEnable = true;
    private final HashMap<TMediaCodec, CodecWrapper> mCodecMap = new HashMap<>();
    private final PreloadCodecManager mPreloadCodecManager = new PreloadCodecManager();
    private final CodecWrapperManager mVideoCodecManager = new CodecWrapperManager();
    private final CodecWrapperManager mAudioCodecManager = new CodecWrapperManager();
    private boolean mAllowKeepPool = true;

    private void changeToReuseDisable() {
        this.mVideoCodecManager.clearAndReleaseAll();
        this.mAudioCodecManager.clearAndReleaseAll();
    }

    private CodecWrapper createDirectCodecWrapper(MediaFormat mediaFormat, TMediaCodec tMediaCodec) throws IOException {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "createDirectCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + tMediaCodec.getCreateBy() + " nameOrType:" + tMediaCodec.getNameOrType());
        }
        if (tMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
            return new DirectCodecWrapper(MediaCodec.createByCodecName(tMediaCodec.getNameOrType()));
        }
        return new DirectCodecWrapper(MediaCodec.createDecoderByType(tMediaCodec.getNameOrType()));
    }

    @RequiresApi(api = 23)
    private CodecWrapper createNewReuseCodecWrapper(MediaFormat mediaFormat, TMediaCodec tMediaCodec) throws IOException {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "createNewReuseCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + tMediaCodec.getCreateBy() + " nameOrType:" + tMediaCodec.getNameOrType());
        }
        String string = mediaFormat.getString("mime");
        FormatWrapper create = FormatWrapper.create(mediaFormat);
        ReuseHelper.initFormatWrapper(create, mediaFormat);
        if (tMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
            return ReuseCodecWrapper.create(MediaCodec.createByCodecName(tMediaCodec.getNameOrType()), string, create);
        }
        return ReuseCodecWrapper.create(MediaCodec.createDecoderByType(string), string, create);
    }

    private CodecWrapper getCodec(MediaFormat mediaFormat, TMediaCodec tMediaCodec, Surface surface) throws IOException {
        boolean isVideo = tMediaCodec.isVideo();
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "getCodec isVideo:" + isVideo + " codecFinalReuseEnable:" + tMediaCodec.codecFinalReuseEnable);
        }
        if (!tMediaCodec.codecFinalReuseEnable) {
            tMediaCodec.isReUsed = false;
            if (LogUtils.isLogEnable()) {
                LogUtils.d("TCodecManager", "getCodec return DirectCodecWrapper for mediaFormat:" + mediaFormat + " codecFinalReuseEnable:false surface:" + surface);
            }
            return createDirectCodecWrapper(mediaFormat, tMediaCodec);
        }
        FormatWrapper create = FormatWrapper.create(mediaFormat);
        CodecWrapper obtainCodecWrapper = obtainCodecWrapper(isVideo, create);
        FormatWrapper.dumpCsdArray(create.initializationData);
        if (obtainCodecWrapper != null) {
            ReuseHelper.ReuseType canReuseType = obtainCodecWrapper.canReuseType(create);
            if (canReuseType != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION && canReuseType != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION) {
                if (canReuseType == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO && LogUtils.isLogEnable()) {
                    LogUtils.w("TCodecManager", "getCodec not reuse, isVideo:" + isVideo + " reuseType:" + canReuseType);
                }
            } else {
                if (LogUtils.isLogEnable()) {
                    LogUtils.d("TCodecManager", "getCodec reuse, isVideo:" + isVideo + " reuseType:" + canReuseType);
                }
                obtainCodecWrapper.attachThread();
                obtainCodecWrapper.prepareToReUse();
                tMediaCodec.isReUsed = true;
                return obtainCodecWrapper;
            }
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:" + isVideo);
        }
        tMediaCodec.isReUsed = false;
        CodecWrapper createNewReuseCodecWrapper = createNewReuseCodecWrapper(mediaFormat, tMediaCodec);
        createNewReuseCodecWrapper.attachThread();
        this.mCodecMap.put(tMediaCodec, createNewReuseCodecWrapper);
        return createNewReuseCodecWrapper;
    }

    public static TCodecManager getInstance() {
        return mInstance;
    }

    public static boolean isDebug() {
        return mIsDebugVersion;
    }

    public static boolean isLeakFixed() {
        return mIsLeakFixed;
    }

    private CodecWrapper obtainCodecWrapper(boolean z16, FormatWrapper formatWrapper) {
        CodecWrapperManager codecWrapperManager;
        if (z16) {
            codecWrapperManager = this.mVideoCodecManager;
        } else {
            codecWrapperManager = this.mAudioCodecManager;
        }
        return codecWrapperManager.obtainCodecWrapper(formatWrapper);
    }

    private void onCodecRunning(CodecWrapper codecWrapper) {
        if (isGlobalReuseEnable()) {
            if (codecWrapper instanceof VideoCodecWrapper) {
                this.mVideoCodecManager.transToRunning((ReuseCodecWrapper) codecWrapper);
            } else if (codecWrapper instanceof AudioCodecWrapper) {
                this.mAudioCodecManager.transToRunning((ReuseCodecWrapper) codecWrapper);
            }
        }
    }

    public static void setIsDebug(boolean z16) {
        mIsDebugVersion = z16;
    }

    public static void setLeakFixed(boolean z16) {
        mIsLeakFixed = z16;
    }

    public final void clearAndReleaseKeepPool() {
        this.mAllowKeepPool = false;
        this.mVideoCodecManager.clearAndReleaseKeepPool();
        this.mAudioCodecManager.clearAndReleaseKeepPool();
    }

    @NonNull
    public final CodecWrapper configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3, @NonNull TMediaCodec tMediaCodec) throws IOException {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
        }
        this.mConfigMethodCalled = true;
        this.mAllowKeepPool = true;
        CodecWrapper codec = getCodec(mediaFormat, tMediaCodec, surface);
        onCodecRunning(codec);
        codec.setCodecCallback(tMediaCodec.getCodecCallback());
        codec.configure(mediaFormat, surface, mediaCrypto, i3);
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
        }
        return codec;
    }

    @NonNull
    public final ReusePolicy getReusePolicy() {
        return this.mReusePolicy;
    }

    public final boolean isAllowKeepPool() {
        return this.mAllowKeepPool;
    }

    public final boolean isGlobalReuseEnable() {
        return this.mGlobalReuseEnable;
    }

    public final boolean isVideoKeepPoolFull() {
        return this.mVideoCodecManager.isKeepPoolFull();
    }

    public final void preloadCodec(@NonNull String str, @NonNull String str2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (PreloadCodecManager.isInvalidMimeType(str)) {
            linkedHashSet.add(str);
        }
        if (PreloadCodecManager.isInvalidMimeType(str2)) {
            linkedHashSet.add(str2);
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "preloadCodec mimeTypeSet:" + linkedHashSet);
        }
        this.mPreloadCodecManager.preload(linkedHashSet);
    }

    public final void recycleCodecFromRunning(@NonNull CodecWrapper codecWrapper) {
        if (isGlobalReuseEnable()) {
            if (codecWrapper instanceof VideoCodecWrapper) {
                this.mVideoCodecManager.transToKeep((ReuseCodecWrapper) codecWrapper);
            } else if (codecWrapper instanceof AudioCodecWrapper) {
                this.mAudioCodecManager.transToKeep((ReuseCodecWrapper) codecWrapper);
            }
        }
    }

    public final void removeCodecFromRunningPool(@NonNull CodecWrapper codecWrapper) {
        if (isGlobalReuseEnable()) {
            if (codecWrapper instanceof VideoCodecWrapper) {
                this.mVideoCodecManager.removeFromRunning((ReuseCodecWrapper) codecWrapper);
            } else if (codecWrapper instanceof AudioCodecWrapper) {
                this.mAudioCodecManager.removeFromRunning((ReuseCodecWrapper) codecWrapper);
            }
        }
    }

    public boolean reuseEnable(TMediaCodec tMediaCodec, Surface surface) {
        boolean z16;
        boolean z17;
        boolean isGlobalReuseEnable = isGlobalReuseEnable();
        boolean isReuseEnable = tMediaCodec.isReuseEnable();
        boolean isVideo = tMediaCodec.isVideo();
        if (isGlobalReuseEnable && isReuseEnable) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TUtils.codecNeedsSetOutputSurfaceWorkaround()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "reuseEnable getCodec isVideo:" + isVideo + " reuseEnable:" + z16 + TokenParser.SP + "globalReuseEnable:" + isGlobalReuseEnable + " mediaCodecReuseEnable:" + isReuseEnable + " canUseSetOutputSurfaceAPI:" + z17 + " ,surface:" + surface);
        }
        if (z16 && isVideo && z17 && surface != null) {
            return true;
        }
        return false;
    }

    public final void setGlobalReuseEnable(boolean z16) {
        if (this.mGlobalReuseEnable != z16) {
            this.mGlobalReuseEnable = z16;
            if (this.mConfigMethodCalled && !z16) {
                changeToReuseDisable();
            }
        }
    }

    public final void setLogEnable(boolean z16) {
        LogUtils.setLogEnable(z16);
    }

    public final void setLogLevel(int i3) {
        LogUtils.setLogLevel(i3);
    }

    public final void setLogProxy(@NonNull ILogProxy iLogProxy) {
        LogUtils.setLogProxy(iLogProxy);
    }

    public final void setReusePolicy(@NonNull ReusePolicy reusePolicy) {
        this.mReusePolicy = reusePolicy;
    }

    @NonNull
    @TargetApi(26)
    public final CodecWrapper configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler, @NonNull TMediaCodec tMediaCodec) throws IOException {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
        }
        this.mConfigMethodCalled = true;
        this.mAllowKeepPool = true;
        CodecWrapper codec = getCodec(mediaFormat, tMediaCodec, surface);
        codec.setCodecCallback(tMediaCodec.getCodecCallback());
        onCodecRunning(codec);
        codec.configure(mediaFormat, surface, i3, mediaDescrambler);
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
        }
        return codec;
    }

    public static void init() {
    }
}
