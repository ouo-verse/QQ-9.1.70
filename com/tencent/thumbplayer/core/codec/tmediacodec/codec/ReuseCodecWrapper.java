package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.codec.tmediacodec.TCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.preload.glrender.OutputSurface;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ThreadManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RequiresApi(api = 23)
/* loaded from: classes26.dex */
public abstract class ReuseCodecWrapper implements CodecWrapper {
    public static final int CANT_REUSE_LIMIT = 3;
    public static final int ID_HISTORY_LIMIT = 100;
    public static final int METHOD_DEQUEUE_INPUT_BUFFER = 0;
    public static final int METHOD_DEQUEUE_OUTPUT_BUFFER = 1;
    public static final int TRY_AGAIN_LATER_LIMIT = 100;
    private static final Map<Surface, ReuseCodecWrapper> mSurfaceMap = new ConcurrentHashMap();
    private final ReuseHelper.AdaptationWorkaroundMode mAdaptationMode;
    public boolean mAdaptive;
    private OutputSurface mBackupSurface;

    @Nullable
    private CodecCallback mCallback;
    private int mCantReuseCount;

    @Nullable
    private MediaCodecInfo.CodecCapabilities mCapabilities;

    @NonNull
    private final MediaCodec mCodec;

    @NonNull
    protected final CodecMaxValues mCodecMaxValues;
    protected final String mCodecName;

    @NonNull
    public DecodeState mDecodeState = DecodeState.Started;
    private final int[] mDequeueInOutputTryAgainCount;
    private boolean mErrorHappened;

    @NonNull
    public final FormatWrapper mFormat;
    private boolean mHasAlwaysTryAgainError;
    private boolean mHasConfigureCalled;
    private boolean mHasReused;
    private final HashSet<Integer> mHoldBufferOutIndex;
    public boolean mIsRecycled;
    private boolean mReleaseCalled;

    @NonNull
    private ReuseHelper.ReuseType mReuseType;
    public boolean mSecure;

    @NonNull
    private CodecState mState;
    private final Set<SurfaceTexture> mStoreToRelease;

    @Nullable
    protected Surface mSurface;
    private final String mTag;
    private long mThreadId;
    private final ArrayList<Long> mThreadIdHistory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType;

        static {
            int[] iArr = new int[ReuseHelper.ReuseType.values().length];
            $SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType = iArr;
            try {
                iArr[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_FLUSH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum CodecState {
        Uninitialized,
        Configured,
        Error,
        Flushed,
        Running,
        EndOfStream,
        Released
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum DecodeState {
        Started,
        DequeueIn,
        QueueIn,
        DequeueOut,
        ReleaseOut
    }

    public ReuseCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        boolean z16;
        boolean z17;
        String str = "ReuseCodecWrapper[" + hashCode() + "]";
        this.mTag = str;
        this.mHoldBufferOutIndex = new HashSet<>();
        this.mThreadIdHistory = new ArrayList<>();
        this.mStoreToRelease = new LinkedHashSet();
        this.mDequeueInOutputTryAgainCount = new int[2];
        this.mState = CodecState.Uninitialized;
        this.mReuseType = ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
        boolean z18 = false;
        this.mErrorHappened = false;
        this.mHasAlwaysTryAgainError = false;
        this.mCantReuseCount = 0;
        this.mCodec = mediaCodec;
        this.mFormat = formatWrapper;
        this.mCodecMaxValues = new CodecMaxValues(formatWrapper.maxWidth, formatWrapper.maxHeight, formatWrapper.maxInputSize);
        String codeName = TUtils.getCodeName(mediaCodec);
        this.mCodecName = codeName;
        this.mAdaptationMode = ReuseHelper.codecAdaptationWorkaroundMode(codeName);
        if (Build.VERSION.SDK_INT == 29 && formatWrapper.rotationDegrees != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        LogUtils.d(str, "canCallGetCodecInfo:" + z16);
        if (z16) {
            this.mCapabilities = mediaCodec.getCodecInfo().getCapabilitiesForType(formatWrapper.sampleMimeType);
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.mCapabilities;
        if (codecCapabilities != null && TUtils.isAdaptive(codecCapabilities)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mAdaptive = z17;
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.mCapabilities;
        if (codecCapabilities2 != null && TUtils.isSecure(codecCapabilities2)) {
            z18 = true;
        }
        this.mSecure = z18;
    }

    private void bindingToBackupSurface() {
        if (this.mBackupSurface != null) {
            return;
        }
        OutputSurface outputSurface = new OutputSurface(1, 1);
        this.mBackupSurface = outputSurface;
        innerSetOutputSurface(outputSurface.getSurface(), true, true);
    }

    private String byte2HexString(Byte b16) {
        return String.format("%02X", Integer.valueOf(b16.intValue() & 255));
    }

    private int checkSurfaceState(Surface surface) {
        if (surface == null) {
            return 10003;
        }
        if (!surface.isValid()) {
            return 10004;
        }
        return 0;
    }

    public static CodecWrapper create(@NonNull MediaCodec mediaCodec, @NonNull String str, @NonNull FormatWrapper formatWrapper) {
        if (TUtils.isVideo(str)) {
            return new VideoCodecWrapper(mediaCodec, formatWrapper);
        }
        return new AudioCodecWrapper(mediaCodec, formatWrapper);
    }

    private void dumpInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        if (!TCodecManager.isDebug()) {
            return;
        }
        try {
            ByteBuffer byteBuffer = this.mCodec.getInputBuffers()[i3];
            StringBuilder sb5 = new StringBuilder("\n########################## " + this + " dumpInputBuffer ###################");
            for (int i19 = 0; i19 < 4; i19++) {
                sb5.append("\n");
                for (int i26 = 0; i26 < 16; i26++) {
                    sb5.append(" ");
                    sb5.append(byte2HexString(Byte.valueOf(byteBuffer.get((i19 * 4) + i16 + i26))));
                }
            }
            if (LogUtils.isLogEnable()) {
                LogUtils.v(this.mTag, sb5.toString());
            }
        } catch (Throwable th5) {
            LogUtils.e(this.mTag, "dumpInputBuffer error", th5);
        }
    }

    private void handleCoreAPIException(int i3, String str, Throwable th5) {
        handleCoreAPIException(i3, str, th5, false, this.mSurface);
    }

    @TargetApi(23)
    private void innerSetOutputSurface(Surface surface) {
        innerSetOutputSurface(surface, true, false);
    }

    private boolean isAlwaysTryAgain(int i3, int i16) {
        if (i16 == -1) {
            int[] iArr = this.mDequeueInOutputTryAgainCount;
            int i17 = iArr[i3] + 1;
            iArr[i3] = i17;
            if (i17 <= 100) {
                return false;
            }
            return true;
        }
        this.mDequeueInOutputTryAgainCount[i3] = 0;
        return false;
    }

    private boolean isNotMyThread() {
        if (Thread.currentThread().getId() != this.mThreadId) {
            return true;
        }
        return false;
    }

    private void onReuseCodec() {
        int[] iArr = this.mDequeueInOutputTryAgainCount;
        iArr[0] = 0;
        iArr[1] = 0;
    }

    private final void processInputBufferWithReConfig(int i3, int i16, int i17, long j3, int i18) {
        this.mCodec.queueInputBuffer(i3, i16, i17, j3, i18);
    }

    private final void queueInputBufferForAdaptation(int i3, int i16, int i17, long j3, int i18) {
        int i19 = AnonymousClass2.$SwitchMap$com$tencent$thumbplayer$core$codec$tmediacodec$reuse$ReuseHelper$ReuseType[this.mReuseType.ordinal()];
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 == 3) {
                    this.mCodec.queueInputBuffer(i3, i16, i17, j3, i18);
                    return;
                }
                return;
            }
            processInputBufferWithReConfig(i3, i16, i17, j3, i18);
            return;
        }
        LogUtils.w(this.mTag, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
    }

    private void realConfigure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        int i16;
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", realConfigure mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i3 + " state:" + this.mState + " mHasConfigureCalled\uff1a" + this.mHasConfigureCalled;
                LogUtils.d(this.mTag, str);
            }
            this.mCodec.configure(mediaFormat, surface, mediaCrypto, i3);
            setSurface(surface);
            this.mState = CodecState.Configured;
        } catch (Throwable th5) {
            String str2 = str;
            if (th5 instanceof IllegalStateException) {
                i16 = 10000;
            } else {
                i16 = th5 instanceof MediaCodec.CryptoException ? 10001 : 0;
            }
            handleCoreAPIException(i16, str2, th5, true, surface);
            throw th5;
        }
    }

    private void releaseCodecWhenError(int i3) {
        boolean z16;
        if (i3 < 40000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            LogUtils.e(this.mTag, this + "    releaseCodecWhenError, errorCode:" + i3);
            release();
        }
    }

    private void resetParam() {
        this.mHasAlwaysTryAgainError = false;
        this.mCantReuseCount = 0;
    }

    private void setSurface(Surface surface) {
        if (LogUtils.isLogEnable()) {
            LogUtils.i(this.mTag, this + ", oldSurface:" + this.mSurface + " CodecWrapperSetSurface surface:" + surface);
        }
        this.mSurface = surface;
    }

    private void trackDecodeApi(int i3, int i16) {
        Boolean bool;
        if (!this.mHasAlwaysTryAgainError && isAlwaysTryAgain(i3, i16)) {
            this.mHasAlwaysTryAgainError = true;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this);
            sb5.append(", trackDecodeApi state:");
            sb5.append(this.mState);
            sb5.append("  surfaceState:");
            Surface surface = this.mSurface;
            if (surface != null) {
                bool = Boolean.valueOf(surface.isValid());
            } else {
                bool = null;
            }
            sb5.append(bool);
            String sb6 = sb5.toString();
            if (i3 == 0) {
                handleCoreAPIException(40002, sb6, null);
            } else if (i3 == 1) {
                handleCoreAPIException(60002, sb6, null);
            }
        }
    }

    private void unBindingBackupSurface() {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.mTag, this + "unBindingBackupSurface");
        }
        OutputSurface outputSurface = this.mBackupSurface;
        if (outputSurface != null) {
            outputSurface.release();
        }
        this.mBackupSurface = null;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void attachThread() {
        long id5 = Thread.currentThread().getId();
        if (this.mThreadIdHistory.contains(Long.valueOf(id5))) {
            return;
        }
        this.mThreadId = id5;
        this.mThreadIdHistory.add(Long.valueOf(id5));
        if (this.mThreadIdHistory.size() > 100) {
            this.mThreadIdHistory.remove(0);
        }
    }

    @NonNull
    public abstract ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper formatWrapper);

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuseType(@NonNull FormatWrapper formatWrapper) {
        ReuseHelper.ReuseType canReuse = canReuse(formatWrapper);
        this.mReuseType = canReuse;
        return canReuse;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method configure for isNotMyThread");
            return;
        }
        this.mHasConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.mState == CodecState.Uninitialized) {
            realConfigure(mediaFormat, surface, mediaCrypto, i3);
        } else if (surface != null) {
            onReuseCodec();
            innerSetOutputSurface(surface);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public int dequeueInputBuffer(long j3) {
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method dequeueInputBuffer for isNotMyThread");
            return -1;
        }
        int i3 = 0;
        String str = null;
        try {
            int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(j3);
            if (LogUtils.isLogEnable()) {
                str = this + ", dequeueInputBuffer state:" + this.mState + " decodeState:" + this.mDecodeState + " , result=" + dequeueInputBuffer;
                LogUtils.v(this.mTag, str);
            }
            this.mDecodeState = DecodeState.DequeueIn;
            this.mState = CodecState.Running;
            trackDecodeApi(0, dequeueInputBuffer);
            return dequeueInputBuffer;
        } catch (Throwable th5) {
            if (!(th5 instanceof IllegalStateException)) {
                if (th5 instanceof IllegalArgumentException) {
                    i3 = 40001;
                }
            } else {
                i3 = 40000;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        int i3;
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method dequeueOutputBuffer for isNotMyThread");
            return -1;
        }
        String str = null;
        try {
            int dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(bufferInfo, j3);
            if (LogUtils.isLogEnable()) {
                str = this + ", dequeueOutputBuffer outIndex:" + dequeueOutputBuffer;
                if (this instanceof VideoCodecWrapper) {
                    LogUtils.v(this.mTag, str);
                }
            }
            this.mHoldBufferOutIndex.add(Integer.valueOf(dequeueOutputBuffer));
            this.mDecodeState = DecodeState.DequeueOut;
            trackDecodeApi(1, dequeueOutputBuffer);
            return dequeueOutputBuffer;
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (th5 instanceof IllegalStateException) {
                    i3 = 60000;
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 60001;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void flush() {
        int i3;
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "call method flush for isNotMyThread...");
        }
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", flush state:" + this.mState;
                LogUtils.d(this.mTag, str);
            }
            this.mCodec.flush();
            this.mState = CodecState.Flushed;
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (th5 instanceof IllegalStateException) {
                    i3 = 90000;
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 90001;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    @Nullable
    public final CodecCallback getCallback() {
        return this.mCallback;
    }

    @NonNull
    public final MediaCodec getCodec() {
        return this.mCodec;
    }

    public String getCodecName() {
        return this.mCodecName;
    }

    @NonNull
    public final FormatWrapper getFormat() {
        return this.mFormat;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @NonNull
    public MediaCodec getMediaCodec() {
        return this.mCodec;
    }

    public boolean isNeedKeep() {
        if (TCodecManager.isLeakFixed()) {
            if (!this.mErrorHappened && TCodecManager.getInstance().isGlobalReuseEnable() && TCodecManager.getInstance().isAllowKeepPool()) {
                return true;
            }
            return false;
        }
        if (!this.mErrorHappened && TCodecManager.getInstance().isGlobalReuseEnable()) {
            return true;
        }
        return false;
    }

    public final boolean isReleaseCalled() {
        return this.mReleaseCalled;
    }

    public boolean needToErase() {
        if (this.mCantReuseCount >= 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void prepareToReUse() {
        resetParam();
        if (TCodecManager.isLeakFixed()) {
            if (this.mState == CodecState.Running) {
                try {
                    flush();
                } catch (IllegalStateException e16) {
                    LogUtils.e(this.mTag, "flush failed in prepareToReUse", e16);
                }
            }
        } else if (this.mState != CodecState.Flushed) {
            flush();
        }
        this.mHasReused = true;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        String str;
        int i19;
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method queueInputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", queueInputBuffer index:" + i3 + " offset:" + i16 + " size:" + i17 + " presentationTimeUs:" + j3 + TokenParser.SP + "flags:" + i18 + " state:" + this.mState + " decodeState:" + this.mDecodeState;
            LogUtils.v(this.mTag, str);
        } else {
            str = null;
        }
        try {
            if (this.mHasReused) {
                queueInputBufferForAdaptation(i3, i16, i17, j3, i18);
            } else {
                this.mCodec.queueInputBuffer(i3, i16, i17, j3, i18);
            }
            this.mDecodeState = DecodeState.QueueIn;
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (!(th5 instanceof IllegalStateException)) {
                    if (th5 instanceof MediaCodec.CryptoException) {
                        i19 = 50002;
                    } else {
                        i19 = 0;
                    }
                } else {
                    i19 = 50000;
                }
            } else {
                i19 = 50001;
            }
            handleCoreAPIException(i19, str, th5);
            throw th5;
        }
    }

    public final void recycle() {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.mTag, this + ", recycle isRecycled:" + this.mIsRecycled + "  mSurfaceMap.size:" + mSurfaceMap.size() + "...... stack:" + Log.getStackTraceString(new Throwable()));
        }
        if (this.mIsRecycled) {
            LogUtils.w(this.mTag, "ignore recycle for has isRecycled is true.");
            return;
        }
        this.mHasConfigureCalled = false;
        this.mIsRecycled = true;
        ThreadManager.runOnSubThread(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        ReuseCodecWrapper.this.mCodec.stop();
                        ReuseCodecWrapper.this.mCodec.release();
                    } catch (Throwable th5) {
                        ReuseCodecWrapper.this.mCodec.release();
                        throw th5;
                    }
                } catch (Throwable th6) {
                    LogUtils.w(ReuseCodecWrapper.this.mTag, "recycle codec ignore error,", th6);
                }
                if (ReuseCodecWrapper.this.mCallback != null) {
                    ReuseCodecWrapper.this.mCallback.onRealRelease();
                }
            }
        });
        this.mState = CodecState.Uninitialized;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void release() {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.mTag, this + " call release mHoldBufferOutIndex:" + this.mHoldBufferOutIndex + " mReleaseCalled:" + this.mReleaseCalled + " stack:" + Log.getStackTraceString(new Throwable()));
        }
        this.mReleaseCalled = true;
        this.mHasConfigureCalled = false;
        if (isNeedKeep()) {
            try {
                flush();
            } catch (IllegalStateException e16) {
                LogUtils.e(this.mTag, "flush failed for not in the Executing state.", e16);
            }
            bindingToBackupSurface();
            TCodecManager.getInstance().recycleCodecFromRunning(this);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.w(this.mTag, "Don't not keep the codec, release it ..., mErrorHappened:" + this.mErrorHappened);
        }
        TCodecManager.getInstance().removeCodecFromRunningPool(this);
        recycle();
        this.mState = CodecState.Released;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void releaseOutputBuffer(int i3, boolean z16) {
        String str;
        int i16;
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", releaseOutputBuffer render:" + z16;
            LogUtils.v(this.mTag, str);
        } else {
            str = null;
        }
        try {
            this.mHoldBufferOutIndex.remove(Integer.valueOf(i3));
            this.mCodec.releaseOutputBuffer(i3, z16);
        } catch (Throwable th5) {
            if (this.mState != CodecState.Flushed) {
                LogUtils.w(this.mTag, this + ", releaseOutputBuffer failed, ignore e:", th5);
            }
            if (th5 instanceof MediaCodec.CodecException) {
                i16 = 70002;
            } else {
                i16 = th5 instanceof IllegalStateException ? 70001 : 0;
            }
            handleCoreAPIException(i16, str, th5);
        }
        this.mDecodeState = DecodeState.ReleaseOut;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void reset() {
        int i3;
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", callMsg state:" + this.mState;
                LogUtils.d(this.mTag, str);
            }
            if (!isNeedKeep()) {
                this.mCodec.reset();
                this.mState = CodecState.Uninitialized;
            }
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (th5 instanceof IllegalStateException) {
                    i3 = 80000;
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 80001;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    public final void setCallback(@Nullable CodecCallback codecCallback) {
        this.mCallback = codecCallback;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void setCodecCallback(@Nullable CodecCallback codecCallback) {
        this.mCallback = codecCallback;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(23)
    public void setOutputSurface(@NonNull Surface surface) {
        innerSetOutputSurface(surface, false, false);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void start() {
        int i3;
        CodecState codecState = this.mState;
        CodecState codecState2 = CodecState.Configured;
        if (codecState != codecState2) {
            LogUtils.d(this.mTag, "start ignore:" + this.mState);
            return;
        }
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", start state:" + this.mState;
                LogUtils.d(this.mTag, str);
            }
            if (this.mState == codecState2) {
                this.mCodec.start();
                this.mState = CodecState.Running;
            }
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (th5 instanceof IllegalStateException) {
                    i3 = 20000;
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 20001;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    public void stop() {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.mTag, this + ", stop");
        }
        if (!isNeedKeep()) {
            if (LogUtils.isLogEnable()) {
                LogUtils.d(this.mTag, this + ", codec real stop");
            }
            try {
                this.mCodec.stop();
                this.mState = CodecState.Uninitialized;
            } catch (IllegalStateException e16) {
                this.mState = CodecState.Uninitialized;
                LogUtils.e(this.mTag, "stop failed", e16);
                throw e16;
            }
        }
    }

    @NonNull
    public String toString() {
        return super.toString() + " mReleaseCalled:" + this.mReleaseCalled + " isRecycled:" + this.mIsRecycled;
    }

    public void trackCantReuse() {
        this.mCantReuseCount++;
    }

    private void handleCoreAPIException(int i3, String str, Throwable th5, boolean z16, Surface surface) {
        int checkSurfaceState;
        this.mErrorHappened = true;
        String str2 = str + " handleCoreAPIException exception:" + (th5 == null ? "" : th5.getLocalizedMessage());
        if (z16 && (checkSurfaceState = checkSurfaceState(surface)) != 0) {
            i3 = checkSurfaceState;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i3);
            jSONObject.put("exceptionMsg", str2);
            CodecCallback codecCallback = this.mCallback;
            if (codecCallback != null) {
                codecCallback.onReuseCodecAPIException(jSONObject.toString(), th5);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        LogUtils.e(this.mTag, "hasReused:" + this.mHasReused + "    errorCode:" + i3 + ", " + str2, th5);
        releaseCodecWhenError(i3);
    }

    @TargetApi(23)
    private void innerSetOutputSurface(Surface surface, boolean z16, boolean z17) {
        String str;
        int i3;
        if (this.mSurface == surface) {
            LogUtils.w(this.mTag, this + ", innerSetOutputSurface error surface:" + surface + " is same, stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + " configure, call innerSetOutputSurface surface:" + surface + "  decodeState:" + this.mDecodeState + " callByInner:" + z16;
            LogUtils.d(this.mTag, str);
        } else {
            str = null;
        }
        String str2 = str;
        try {
            setSurface(surface);
            this.mCodec.setOutputSurface(surface);
            if (z17) {
                return;
            }
            unBindingBackupSurface();
        } catch (Throwable th5) {
            if (th5 instanceof IllegalStateException) {
                i3 = 30000;
            } else {
                i3 = th5 instanceof IllegalArgumentException ? 30001 : 0;
            }
            handleCoreAPIException(i3, str2, th5, true, surface);
            throw th5;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method configure for isNotMyThread");
            return;
        }
        this.mHasConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.mState == CodecState.Uninitialized) {
            realConfigure(mediaFormat, surface, i3, mediaDescrambler);
        } else if (surface != null) {
            onReuseCodec();
            innerSetOutputSurface(surface);
        }
    }

    @TargetApi(26)
    private void realConfigure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        String str;
        int i16;
        if (LogUtils.isLogEnable()) {
            str = this + ", configure mediaFormat:" + mediaFormat + " surface:" + surface + " flags:" + i3 + " descrambler:" + mediaDescrambler + " state:" + this.mState + " mHasConfigureCalled\uff1a" + this.mHasConfigureCalled;
            LogUtils.d(this.mTag, str);
        } else {
            str = null;
        }
        String str2 = str;
        try {
            this.mCodec.configure(mediaFormat, surface, i3, mediaDescrambler);
            setSurface(surface);
            this.mState = CodecState.Configured;
        } catch (Throwable th5) {
            if (th5 instanceof MediaCodec.CodecException) {
                i16 = 10002;
            } else if (th5 instanceof IllegalStateException) {
                i16 = 10000;
            } else {
                i16 = th5 instanceof MediaCodec.CryptoException ? 10001 : 0;
            }
            handleCoreAPIException(i16, str2, th5, true, surface);
            throw th5;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.CodecWrapper
    @RequiresApi(api = 23)
    public void releaseOutputBuffer(int i3, long j3) {
        String str;
        int i16;
        if (isNotMyThread()) {
            LogUtils.w(this.mTag, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", releaseOutputBuffer API21" + i3;
            if (this instanceof VideoCodecWrapper) {
                LogUtils.v(this.mTag, str);
            }
        } else {
            str = null;
        }
        this.mHoldBufferOutIndex.remove(Integer.valueOf(i3));
        try {
            this.mCodec.releaseOutputBuffer(i3, j3);
            this.mDecodeState = DecodeState.ReleaseOut;
        } catch (Throwable th5) {
            if (th5 instanceof MediaCodec.CodecException) {
                i16 = 70002;
            } else {
                i16 = th5 instanceof IllegalStateException ? 70001 : 0;
            }
            handleCoreAPIException(i16, str, th5);
            throw th5;
        }
    }
}
