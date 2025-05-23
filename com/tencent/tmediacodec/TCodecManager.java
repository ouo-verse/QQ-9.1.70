package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmediacodec.TMediaCodec;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.codec.DirectCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.pools.CodecWrapperManager;
import com.tencent.tmediacodec.preload.PreloadCodecManager;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.ILogProxy;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TCodecManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TCodecManager";
    private static TCodecManager mInstance;
    private static boolean mIsDebugVersion;
    private static boolean mIsLeakFiexed;
    private boolean mAllowKeepPool;
    private final CodecWrapperManager mAudioCodecManager;
    private final HashMap<TMediaCodec, CodecWrapper> mCodecMap;
    private boolean mConfigMethodCalled;
    private boolean mGlobalReuseEnable;
    private final PreloadCodecManager mPreloadCodecManager;
    private ReusePolicy mReusePolicy;
    private final CodecWrapperManager mVideoCodecManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        mInstance = new TCodecManager();
        mIsDebugVersion = false;
        mIsLeakFiexed = true;
    }

    public TCodecManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mReusePolicy = ReusePolicy.DEFAULT;
        this.mGlobalReuseEnable = true;
        this.mCodecMap = new HashMap<>();
        this.mPreloadCodecManager = new PreloadCodecManager();
        this.mVideoCodecManager = new CodecWrapperManager();
        this.mAudioCodecManager = new CodecWrapperManager();
        this.mAllowKeepPool = true;
    }

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
            ReuseHelper.ReuseType canReuseType = obtainCodecWrapper.setCanReuseType(create);
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

    public static final boolean isDebug() {
        return mIsDebugVersion;
    }

    public static final boolean isLeakFixed() {
        return mIsLeakFiexed;
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

    public static final void setIsDebug(boolean z16) {
        mIsDebugVersion = z16;
    }

    public static final void setLeakFixed(boolean z16) {
        mIsLeakFiexed = z16;
    }

    public final void clearAndReleaseKeepPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mAllowKeepPool = false;
        this.mVideoCodecManager.clearAndReleaseKeepPool();
        this.mAudioCodecManager.clearAndReleaseKeepPool();
    }

    @NonNull
    public final CodecWrapper configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3, @NonNull TMediaCodec tMediaCodec) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (CodecWrapper) iPatchRedirector.redirect((short) 13, this, mediaFormat, surface, mediaCrypto, Integer.valueOf(i3), tMediaCodec);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReusePolicy) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mReusePolicy;
    }

    public final boolean isAllowKeepPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mAllowKeepPool;
    }

    public final boolean isGlobalReuseEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mGlobalReuseEnable;
    }

    public final boolean isVideoKeepPoolFull() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mVideoCodecManager.isKeepPoolFull();
    }

    public final void preloadCodec(@NonNull String str, @NonNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (PreloadCodecManager.isInvalideMimeType(str)) {
            linkedHashSet.add(str);
        }
        if (PreloadCodecManager.isInvalideMimeType(str2)) {
            linkedHashSet.add(str2);
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("TCodecManager", "preloadCodec mimeTypeSet:" + linkedHashSet);
        }
        this.mPreloadCodecManager.preload(linkedHashSet);
    }

    public final void recycleCodecFromRunning(@NonNull CodecWrapper codecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) codecWrapper);
            return;
        }
        if (isGlobalReuseEnable()) {
            if (codecWrapper instanceof VideoCodecWrapper) {
                this.mVideoCodecManager.transTokeep((ReuseCodecWrapper) codecWrapper);
            } else if (codecWrapper instanceof AudioCodecWrapper) {
                this.mAudioCodecManager.transTokeep((ReuseCodecWrapper) codecWrapper);
            }
        }
    }

    public final void removeCodecFromRunningPool(@NonNull CodecWrapper codecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) codecWrapper);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) tMediaCodec, (Object) surface)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (this.mGlobalReuseEnable != z16) {
            this.mGlobalReuseEnable = z16;
            if (this.mConfigMethodCalled && !z16) {
                changeToReuseDisable();
            }
        }
    }

    public final void setLogEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            LogUtils.setLogEnable(z16);
        }
    }

    public final void setLogLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            LogUtils.setLogLevel(i3);
        }
    }

    public final void setLogProxy(@NonNull ILogProxy iLogProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iLogProxy);
        } else {
            LogUtils.setLogProxy(iLogProxy);
        }
    }

    public final void setReusePolicy(@NonNull ReusePolicy reusePolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reusePolicy);
        } else {
            this.mReusePolicy = reusePolicy;
        }
    }

    @NonNull
    @TargetApi(26)
    public final CodecWrapper configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler, @NonNull TMediaCodec tMediaCodec) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (CodecWrapper) iPatchRedirector.redirect((short) 14, this, mediaFormat, surface, Integer.valueOf(i3), mediaDescrambler, tMediaCodec);
        }
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
