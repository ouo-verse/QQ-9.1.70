package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.hook.HookManager;
import com.tencent.tmediacodec.hook.PreloadSurface;
import com.tencent.tmediacodec.hook.PreloadSurfaceTexture;
import com.tencent.tmediacodec.hook.SurfaceCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class ReuseCodecWrapper implements CodecWrapper {
    static IPatchRedirector $redirector_ = null;
    public static final int CANT_REUSE_LIMIT = 3;
    public static final int ID_HISTORY_LIMIT = 100;
    public static final int METHOD_DEQUEUE_INPUT_BUFFER = 0;
    public static final int METHOD_DEQUEUE_OUTPUT_BUFFER = 1;
    public static final int TRY_AGAIN_LATER_LIMIT = 100;
    private static final Map<Surface, ReuseCodecWrapper> mSurfaceMap;
    public final String TAG;
    private final ReuseHelper.AdaptationWorkaroundMode adaptationMode;
    public boolean adaptive;

    @Nullable
    private CodecCallback callback;

    @Nullable
    private MediaCodecInfo.CodecCapabilities capabilities;

    @NonNull
    private final MediaCodec codec;

    @NonNull
    protected final CodecMaxValues codecMaxValues;
    protected final String codecName;

    @NonNull
    public DecodeState decodeState;

    @NonNull
    public final FormatWrapper format;
    private boolean hasReused;
    public boolean isRecycled;
    private int mCantReuseCount;
    private int[] mDequeueInOutputTryAgainCount;
    private boolean mErrorHappened;
    private boolean mHasAlwaysTryAgainError;
    private boolean mHasConfigureCalled;
    private final HashSet<Integer> mHoldBufferOutIndex;
    private boolean mReleaseCalled;
    private final Set<SurfaceTexture> mStoreToRelease;

    @Nullable
    protected Surface mSurface;
    private String mSurfaceTextureName;
    private long mThreadId;
    private final ArrayList<Long> mThreadIdHistory;

    @NonNull
    private ReuseHelper.ReuseType reuseType;
    public boolean secure;

    @NonNull
    private CodecState state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tmediacodec.codec.ReuseCodecWrapper$5, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61540);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ReuseHelper.ReuseType.values().length];
            $SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType = iArr;
            try {
                iArr[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_FLUSH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class CodecState {
        private static final /* synthetic */ CodecState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CodecState Configured;
        public static final CodecState EndOfStream;
        public static final CodecState Error;
        public static final CodecState Flushed;
        public static final CodecState Released;
        public static final CodecState Running;
        public static final CodecState Uninitialized;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61542);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CodecState codecState = new CodecState("Uninitialized", 0);
            Uninitialized = codecState;
            CodecState codecState2 = new CodecState("Configured", 1);
            Configured = codecState2;
            CodecState codecState3 = new CodecState("Error", 2);
            Error = codecState3;
            CodecState codecState4 = new CodecState("Flushed", 3);
            Flushed = codecState4;
            CodecState codecState5 = new CodecState("Running", 4);
            Running = codecState5;
            CodecState codecState6 = new CodecState("EndOfStream", 5);
            EndOfStream = codecState6;
            CodecState codecState7 = new CodecState("Released", 6);
            Released = codecState7;
            $VALUES = new CodecState[]{codecState, codecState2, codecState3, codecState4, codecState5, codecState6, codecState7};
        }

        CodecState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CodecState valueOf(String str) {
            return (CodecState) Enum.valueOf(CodecState.class, str);
        }

        public static CodecState[] values() {
            return (CodecState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class DecodeState {
        private static final /* synthetic */ DecodeState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DecodeState DequeueIn;
        public static final DecodeState DequeueOut;
        public static final DecodeState QueueIn;
        public static final DecodeState ReleaseOut;
        public static final DecodeState Started;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61546);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DecodeState decodeState = new DecodeState("Started", 0);
            Started = decodeState;
            DecodeState decodeState2 = new DecodeState("DequeueIn", 1);
            DequeueIn = decodeState2;
            DecodeState decodeState3 = new DecodeState("QueueIn", 2);
            QueueIn = decodeState3;
            DecodeState decodeState4 = new DecodeState("DequeueOut", 3);
            DequeueOut = decodeState4;
            DecodeState decodeState5 = new DecodeState("ReleaseOut", 4);
            ReleaseOut = decodeState5;
            $VALUES = new DecodeState[]{decodeState, decodeState2, decodeState3, decodeState4, decodeState5};
        }

        DecodeState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DecodeState valueOf(String str) {
            return (DecodeState) Enum.valueOf(DecodeState.class, str);
        }

        public static DecodeState[] values() {
            return (DecodeState[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            mSurfaceMap = new ConcurrentHashMap();
        }
    }

    public ReuseCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) mediaCodec, (Object) formatWrapper);
            return;
        }
        String str = "ReuseCodecWrapper[" + hashCode() + "]";
        this.TAG = str;
        this.decodeState = DecodeState.Started;
        this.mSurfaceTextureName = "";
        this.state = CodecState.Uninitialized;
        this.mHoldBufferOutIndex = new HashSet<>();
        this.mThreadIdHistory = new ArrayList<>();
        this.reuseType = ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
        this.mStoreToRelease = new LinkedHashSet();
        this.mDequeueInOutputTryAgainCount = new int[2];
        boolean z18 = false;
        this.mErrorHappened = false;
        this.mHasAlwaysTryAgainError = false;
        this.mCantReuseCount = 0;
        this.codec = mediaCodec;
        this.format = formatWrapper;
        this.codecMaxValues = new CodecMaxValues(formatWrapper.maxWidth, formatWrapper.maxHeight, formatWrapper.maxInputSize);
        String codeName = TUtils.getCodeName(mediaCodec);
        this.codecName = codeName;
        this.adaptationMode = ReuseHelper.codecAdaptationWorkaroundMode(codeName);
        if (Build.VERSION.SDK_INT == 29 && formatWrapper.rotationDegrees != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        LogUtils.d(str, "canCallGetCodecInfo:" + z16);
        if (z16) {
            this.capabilities = mediaCodec.getCodecInfo().getCapabilitiesForType(formatWrapper.sampleMimeType);
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities != null && TUtils.isAdaptive(codecCapabilities)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.adaptive = z17;
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.capabilities;
        if (codecCapabilities2 != null && TUtils.isSecure(codecCapabilities2)) {
            z18 = true;
        }
        this.secure = z18;
    }

    private void bindingSurface(Surface surface) {
        mSurfaceMap.put(surface, this);
    }

    private String byte2HexString(Byte b16) {
        return String.format("%02X", Integer.valueOf(b16.intValue() & 255));
    }

    private void checkSurfaceBindingAndRecycle(Surface surface) {
        boolean z16;
        if (LogUtils.isLogEnable()) {
            String str = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this);
            sb5.append(" checkSurfaceBinding size:");
            Map<Surface, ReuseCodecWrapper> map = mSurfaceMap;
            sb5.append(map.size());
            sb5.append(" mSurfaceMap:");
            sb5.append(map);
            LogUtils.d(str, sb5.toString());
        }
        Map<Surface, ReuseCodecWrapper> map2 = mSurfaceMap;
        if (map2.containsKey(surface)) {
            ReuseCodecWrapper reuseCodecWrapper = map2.get(surface);
            if (reuseCodecWrapper != null && reuseCodecWrapper.isReleaseCalled()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (LogUtils.isLogEnable()) {
                LogUtils.e(this.TAG, this + ", surface:" + surface + " has been used by " + reuseCodecWrapper + " isReleaseCalled:" + z16 + ", ignore but we can release it...");
            }
            if (z16) {
                reuseCodecWrapper.recycle();
            }
        }
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
            ByteBuffer byteBuffer = this.codec.getInputBuffers()[i3];
            StringBuilder sb5 = new StringBuilder("\n########################## " + this + " dumpInputBuffer ###################");
            for (int i19 = 0; i19 < 4; i19++) {
                sb5.append("\n");
                for (int i26 = 0; i26 < 16; i26++) {
                    sb5.append(" ");
                    sb5.append(byte2HexString(Byte.valueOf(byteBuffer.get((i19 * 4) + i16 + i26))));
                }
            }
            if (LogUtils.isLogEnable()) {
                LogUtils.v(this.TAG, sb5.toString());
            }
        } catch (Throwable th5) {
            LogUtils.e(this.TAG, "dumpInputBuffer error", th5);
        }
    }

    private void dumpSurfaceMap(String str) {
        LogUtils.i(this.TAG, this + "    " + str + "     dumpSurfaceMap:" + mSurfaceMap);
    }

    private void handleCoreAPIException(int i3, String str, Throwable th5) {
        handleCoreAPIException(i3, str, th5, false, this.mSurface);
    }

    private void hookSurfaceNotRelease() {
        HookManager.hookSurfaceCallback(this.mSurfaceTextureName, new SurfaceCallback() { // from class: com.tencent.tmediacodec.codec.ReuseCodecWrapper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReuseCodecWrapper.this);
                }
            }

            @Override // com.tencent.tmediacodec.hook.SurfaceCallback
            public void onDestroy(@NonNull SurfaceTexture surfaceTexture) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
                    return;
                }
                if (TextUtils.equals(ReuseCodecWrapper.this.mSurfaceTextureName, surfaceTexture.toString())) {
                    ReuseCodecWrapper.this.mStoreToRelease.add(surfaceTexture);
                    LogUtils.w(ReuseCodecWrapper.this.TAG, ReuseCodecWrapper.this + "      surfaceDestroyed ... surfaceTexture:" + surfaceTexture + "     mStoreToRelease.size:" + ReuseCodecWrapper.this.mStoreToRelease.size());
                }
            }
        });
    }

    @TargetApi(23)
    private void innerSetOutputSurface(Surface surface) {
        innerSetOutputSurface(surface, true);
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

    private final void markPreloadSurfaceTexture() {
        Surface surface = this.mSurface;
        try {
            if (surface instanceof PreloadSurface) {
                SurfaceTexture surfaceTexture = ((PreloadSurface) surface).getSurfaceTexture();
                if (surfaceTexture instanceof PreloadSurfaceTexture) {
                    this.mStoreToRelease.add(surfaceTexture);
                }
                if (LogUtils.isLogEnable()) {
                    LogUtils.d(this.TAG, "markPreloadSurfaceTexture oldSurface:" + surface + " success");
                }
            }
        } catch (Throwable th5) {
            LogUtils.e(this.TAG, "markPreloadSurfaceTexture oldSurface:" + surface + " failed", th5);
        }
    }

    private void onReuseCodec() {
        int[] iArr = this.mDequeueInOutputTryAgainCount;
        iArr[0] = 0;
        iArr[1] = 0;
    }

    private void onSurfaceTextureUnbinding(String str) {
        HookManager.unHookSurfaceCallback(str);
    }

    private final void processInputBufferWithReConfig(int i3, int i16, int i17, long j3, int i18) {
        this.codec.queueInputBuffer(i3, i16, i17, j3, i18);
    }

    private final void queueInputBufferForAdaptation(int i3, int i16, int i17, long j3, int i18) {
        int i19 = AnonymousClass5.$SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[this.reuseType.ordinal()];
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 == 3) {
                    this.codec.queueInputBuffer(i3, i16, i17, j3, i18);
                    return;
                }
                return;
            }
            processInputBufferWithReConfig(i3, i16, i17, j3, i18);
            return;
        }
        LogUtils.w(this.TAG, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
    }

    private void realConfigure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        int i16;
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", realConfigure mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i3 + " state:" + this.state + " mHasConfigureCalled\uff1a" + this.mHasConfigureCalled;
                LogUtils.d(this.TAG, str);
            }
            this.codec.configure(mediaFormat, surface, mediaCrypto, i3);
            setSurface(surface);
            this.state = CodecState.Configured;
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
            LogUtils.e(this.TAG, this + "    releaseCodecWhenError, errorCode:" + i3);
            release();
        }
    }

    private final void releaseOldSurface(Surface surface) {
        if (surface != null) {
            ThreadManager.execute(new Runnable(surface) { // from class: com.tencent.tmediacodec.codec.ReuseCodecWrapper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Surface val$surface;

                {
                    this.val$surface = surface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReuseCodecWrapper.this, (Object) surface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LogUtils.isLogEnable()) {
                        LogUtils.d(ReuseCodecWrapper.this.TAG, "releaseOldSurface " + this.val$surface);
                    }
                    this.val$surface.release();
                }
            });
        }
    }

    private void releaseStoreSurfaceTexture() {
        releaseStoreSurfaceTexture(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseSurfaceTexture(List<SurfaceTexture> list) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + ", releaseSurfaceTexture toReleaseSet:" + list);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (SurfaceTexture surfaceTexture : list) {
            HookManager.realReleaseSurfaceTexture(surfaceTexture);
            linkedHashSet.add(surfaceTexture.toString());
        }
        removeSurfaceBinding(linkedHashSet);
    }

    private final void removeStoreSurfaceTextureFromToReleaseSet(String str) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + ", removeStoreSurfaceTexture nameSurfaceTexture:" + str);
        }
        Iterator<SurfaceTexture> it = this.mStoreToRelease.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().toString(), str)) {
                it.remove();
                return;
            }
        }
    }

    private void removeSurfaceBinding(Set set) {
        removeSurfaceBinding(set, Collections.emptySet());
    }

    private void resetParam() {
        this.mHasAlwaysTryAgainError = false;
        this.mCantReuseCount = 0;
    }

    private final void setSurface(Surface surface) {
        if (LogUtils.isLogEnable()) {
            LogUtils.i(this.TAG, this + ", oldSurface:" + this.mSurface + " CodecWrapperSetSurface surface:" + surface);
        }
        HookManager.unHookSurfaceCallback(this.mSurfaceTextureName);
        removeSurfaceBinding(new HashSet(Collections.singletonList(this.mSurfaceTextureName)));
        markPreloadSurfaceTexture();
        setToMySurface(surface);
        removeStoreSurfaceTextureFromToReleaseSet(this.mSurfaceTextureName);
        if (surface != null) {
            checkSurfaceBindingAndRecycle(surface);
            bindingSurface(surface);
            hookSurfaceNotRelease();
        }
    }

    private void setToMySurface(Surface surface) {
        this.mSurface = surface;
        this.mSurfaceTextureName = "";
        if (surface != null) {
            this.mSurfaceTextureName = TUtils.getSurfaceTextureName(surface);
        }
    }

    private void trackDecodeApi(int i3, int i16) {
        Boolean bool;
        if (!this.mHasAlwaysTryAgainError && isAlwaysTryAgain(i3, i16)) {
            this.mHasAlwaysTryAgainError = true;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this);
            sb5.append(", trackDecodeApi state:");
            sb5.append(this.state);
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

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void attachThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
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

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, mediaFormat, surface, mediaCrypto, Integer.valueOf(i3));
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method configure for isNotMyThread");
            return;
        }
        this.mHasConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.state == CodecState.Uninitialized) {
            realConfigure(mediaFormat, surface, mediaCrypto, i3);
        } else if (surface != null) {
            onReuseCodec();
            innerSetOutputSurface(surface);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public int dequeueInputBuffer(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, j3)).intValue();
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method dequeueInputBuffer for isNotMyThread");
            return -1;
        }
        int i3 = 0;
        String str = null;
        try {
            int dequeueInputBuffer = this.codec.dequeueInputBuffer(j3);
            if (LogUtils.isLogEnable()) {
                str = this + ", dequeueInputBuffer state:" + this.state + " decodeState:" + this.decodeState + " , result=" + dequeueInputBuffer;
                LogUtils.v(this.TAG, str);
            }
            this.decodeState = DecodeState.DequeueIn;
            this.state = CodecState.Running;
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

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo bufferInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, bufferInfo, Long.valueOf(j3))).intValue();
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method dequeueOutputBuffer for isNotMyThread");
            return -1;
        }
        String str = null;
        try {
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, j3);
            if (LogUtils.isLogEnable()) {
                str = this + ", dequeueOutputBuffer outIndex:" + dequeueOutputBuffer;
                if (this instanceof VideoCodecWrapper) {
                    LogUtils.v(this.TAG, str);
                }
            }
            this.mHoldBufferOutIndex.add(Integer.valueOf(dequeueOutputBuffer));
            this.decodeState = DecodeState.DequeueOut;
            trackDecodeApi(1, dequeueOutputBuffer);
            return dequeueOutputBuffer;
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (th5 instanceof IllegalStateException) {
                    i3 = 60000;
                }
            } else {
                i3 = 60001;
            }
            handleCoreAPIException(i3, str, th5);
            throw th5;
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void flush() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "call method flush for isNotMyThread...");
        }
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", flush state:" + this.state;
                LogUtils.d(this.TAG, str);
            }
            this.codec.flush();
            this.state = CodecState.Flushed;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CodecCallback) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.callback;
    }

    @NonNull
    public final MediaCodec getCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (MediaCodec) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.codec;
    }

    public String getCodecName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.codecName;
    }

    @NonNull
    public final FormatWrapper getFormat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (FormatWrapper) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.format;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @NonNull
    public MediaCodec getMediaCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaCodec) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.codec;
    }

    public boolean isNeedKeep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mReleaseCalled;
    }

    public boolean needToErase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.mCantReuseCount >= 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void prepareToReUse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        resetParam();
        if (TCodecManager.isLeakFixed()) {
            if (this.state == CodecState.Running) {
                try {
                    flush();
                } catch (IllegalStateException e16) {
                    LogUtils.e(this.TAG, "flush failed in prepareToReUse", e16);
                }
            }
        } else if (this.state != CodecState.Flushed) {
            flush();
        }
        this.hasReused = true;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18));
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method queueInputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", queueInputBuffer index:" + i3 + " offset:" + i16 + " size:" + i17 + " presentationTimeUs:" + j3 + TokenParser.SP + "flags:" + i18 + " state:" + this.state + " decodeState:" + this.decodeState;
            LogUtils.v(this.TAG, str);
        } else {
            str = null;
        }
        try {
            if (this.hasReused) {
                queueInputBufferForAdaptation(i3, i16, i17, j3, i18);
            } else {
                this.codec.queueInputBuffer(i3, i16, i17, j3, i18);
            }
            this.decodeState = DecodeState.QueueIn;
        } catch (Throwable th5) {
            if (!(th5 instanceof MediaCodec.CodecException)) {
                if (!(th5 instanceof IllegalStateException)) {
                    if (th5 instanceof MediaCodec.CryptoException) {
                        i19 = 50002;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this);
        sb5.append(", recycle isRecycled:");
        sb5.append(this.isRecycled);
        sb5.append("  mSurfaceMap.size:");
        Map<Surface, ReuseCodecWrapper> map = mSurfaceMap;
        sb5.append(map.size());
        sb5.append("...... stack:");
        sb5.append(Log.getStackTraceString(new Throwable()));
        LogUtils.d(str, sb5.toString());
        if (this.isRecycled) {
            LogUtils.w(this.TAG, "ignore recycle for has isRecycled is true.");
            return;
        }
        this.mHasConfigureCalled = false;
        this.isRecycled = true;
        removeSurfaceBinding(Collections.emptySet(), Collections.singleton(this));
        ThreadManager.runOnSubThread(new Runnable() { // from class: com.tencent.tmediacodec.codec.ReuseCodecWrapper.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReuseCodecWrapper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    try {
                        ReuseCodecWrapper.this.codec.stop();
                        ReuseCodecWrapper.this.codec.release();
                        ReuseCodecWrapper.this.releaseStoreSurfaceTexture(false);
                    } catch (Throwable th5) {
                        ReuseCodecWrapper.this.codec.release();
                        throw th5;
                    }
                } catch (Throwable th6) {
                    LogUtils.w(ReuseCodecWrapper.this.TAG, "recycle codec ignore error,", th6);
                }
                if (ReuseCodecWrapper.this.callback != null) {
                    ReuseCodecWrapper.this.callback.onRealRelease();
                }
            }
        });
        map.remove(this.mSurface);
        this.state = CodecState.Uninitialized;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + " call release mHoldBufferOutIndex:" + this.mHoldBufferOutIndex + " mReleaseCalled:" + this.mReleaseCalled + " stack:" + Log.getStackTraceString(new Throwable()));
        }
        this.mReleaseCalled = true;
        this.mHasConfigureCalled = false;
        if (isNeedKeep()) {
            try {
                flush();
            } catch (IllegalStateException e16) {
                LogUtils.e(this.TAG, "flush failed for not in the Executing state.", e16);
            }
            TCodecManager.getInstance().recycleCodecFromRunning(this);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.w(this.TAG, "Don't not keep the codec, release it ..., mErrorHappened:" + this.mErrorHappened);
        }
        TCodecManager.getInstance().removeCodecFromRunningPool(this);
        recycle();
        this.state = CodecState.Released;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void releaseOutputBuffer(int i3, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", releaseOutputBuffer render:" + z16;
            LogUtils.v(this.TAG, str);
        } else {
            str = null;
        }
        try {
            this.mHoldBufferOutIndex.remove(Integer.valueOf(i3));
            this.codec.releaseOutputBuffer(i3, z16);
        } catch (Throwable th5) {
            if (this.state != CodecState.Flushed) {
                LogUtils.w(this.TAG, this + ", releaseOutputBuffer failed, ignore e:", th5);
            }
            if (th5 instanceof MediaCodec.CodecException) {
                i16 = 70002;
            } else if (th5 instanceof IllegalStateException) {
                i16 = 70001;
            }
            handleCoreAPIException(i16, str, th5);
        }
        this.decodeState = DecodeState.ReleaseOut;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void reset() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", callMsg state:" + this.state;
                LogUtils.d(this.TAG, str);
            }
            if (!isNeedKeep()) {
                this.codec.reset();
                this.state = CodecState.Uninitialized;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) codecCallback);
        } else {
            this.callback = codecCallback;
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @NonNull
    public ReuseHelper.ReuseType setCanReuseType(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReuseHelper.ReuseType) iPatchRedirector.redirect((short) 4, (Object) this, (Object) formatWrapper);
        }
        ReuseHelper.ReuseType canReuse = canReuse(formatWrapper);
        this.reuseType = canReuse;
        return canReuse;
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void setCodecCallback(@Nullable CodecCallback codecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) codecCallback);
        } else {
            this.callback = codecCallback;
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(23)
    public void setOutputSurface(@NonNull Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) surface);
        } else {
            innerSetOutputSurface(surface, false);
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void start() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        CodecState codecState = this.state;
        CodecState codecState2 = CodecState.Configured;
        if (codecState != codecState2) {
            LogUtils.d(this.TAG, "start ignore:" + this.state);
            return;
        }
        String str = null;
        try {
            if (LogUtils.isLogEnable()) {
                str = this + ", start state:" + this.state;
                LogUtils.d(this.TAG, str);
            }
            if (this.state == codecState2) {
                this.codec.start();
                this.state = CodecState.Running;
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

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + ", stop");
        }
        if (!isNeedKeep()) {
            if (LogUtils.isLogEnable()) {
                LogUtils.d(this.TAG, this + ", codec real stop");
            }
            try {
                this.codec.stop();
                this.state = CodecState.Uninitialized;
            } catch (IllegalStateException e16) {
                this.state = CodecState.Uninitialized;
                LogUtils.e(this.TAG, "stop failed", e16);
                throw e16;
            }
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return super.toString() + " mReleaseCalled:" + this.mReleaseCalled + " isRecycled:" + this.isRecycled;
    }

    public void trackCantReuse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mCantReuseCount++;
        }
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
            CodecCallback codecCallback = this.callback;
            if (codecCallback != null) {
                codecCallback.onReuseCodecAPIException(jSONObject.toString(), th5);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        LogUtils.e(this.TAG, "hasReused:" + this.hasReused + "    errorCode:" + i3 + ", " + str2, th5);
        releaseCodecWhenError(i3);
    }

    @TargetApi(23)
    private void innerSetOutputSurface(Surface surface, boolean z16) {
        String str;
        int i3;
        if (this.mSurface == surface) {
            LogUtils.w(this.TAG, this + ", innerSetOutputSurface error surface:" + surface + " is same, stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + " configure, call innerSetOutputSurface surface:" + surface + "  decodeState:" + this.decodeState + " callByInner:" + z16;
            LogUtils.d(this.TAG, str);
        } else {
            str = null;
        }
        String str2 = str;
        try {
            setSurface(surface);
            this.codec.setOutputSurface(surface);
            releaseStoreSurfaceTexture();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseStoreSurfaceTexture(boolean z16) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + ", releaseStoreSurfaceTexture mStoreToRelease:" + this.mStoreToRelease);
        }
        if (this.mStoreToRelease.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mStoreToRelease);
        this.mStoreToRelease.clear();
        if (z16) {
            ThreadManager.execute(new Runnable(arrayList) { // from class: com.tencent.tmediacodec.codec.ReuseCodecWrapper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ List val$toReleaseSet;

                {
                    this.val$toReleaseSet = arrayList;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReuseCodecWrapper.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ReuseCodecWrapper.this.releaseSurfaceTexture(this.val$toReleaseSet);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            releaseSurfaceTexture(arrayList);
        }
    }

    private void removeSurfaceBinding(Set set, Set set2) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d(this.TAG, this + ", removeSurfaceBinding toReleaseNameSet:" + set + " toReleaseCodecSet:" + set2);
        }
        Iterator<Map.Entry<Surface, ReuseCodecWrapper>> it = mSurfaceMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Surface, ReuseCodecWrapper> next = it.next();
            String surfaceTextureName = TUtils.getSurfaceTextureName(next.getKey());
            if (set.contains(surfaceTextureName) || set2.contains(next.getValue())) {
                it.remove();
                onSurfaceTextureUnbinding(surfaceTextureName);
            }
        }
    }

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(26)
    public void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, mediaFormat, surface, Integer.valueOf(i3), mediaDescrambler);
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method configure for isNotMyThread");
            return;
        }
        this.mHasConfigureCalled = true;
        this.mReleaseCalled = false;
        if (this.state == CodecState.Uninitialized) {
            realConfigure(mediaFormat, surface, i3, mediaDescrambler);
        } else if (surface != null) {
            onReuseCodec();
            innerSetOutputSurface(surface);
        }
    }

    private void realConfigure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler) {
        String str;
        int i16;
        if (LogUtils.isLogEnable()) {
            str = this + ", configure mediaFormat:" + mediaFormat + " surface:" + surface + " flags:" + i3 + " descrambler:" + mediaDescrambler + " state:" + this.state + " mHasConfigureCalled\uff1a" + this.mHasConfigureCalled;
            LogUtils.d(this.TAG, str);
        } else {
            str = null;
        }
        String str2 = str;
        try {
            this.codec.configure(mediaFormat, surface, i3, mediaDescrambler);
            setSurface(surface);
            this.state = CodecState.Configured;
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

    @Override // com.tencent.tmediacodec.codec.CodecWrapper
    @TargetApi(21)
    public void releaseOutputBuffer(int i3, long j3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (isNotMyThread()) {
            LogUtils.w(this.TAG, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        if (LogUtils.isLogEnable()) {
            str = this + ", releaseOutputBuffer API21" + i3;
            if (this instanceof VideoCodecWrapper) {
                LogUtils.v(this.TAG, str);
            }
        } else {
            str = null;
        }
        this.mHoldBufferOutIndex.remove(Integer.valueOf(i3));
        try {
            this.codec.releaseOutputBuffer(i3, j3);
            this.decodeState = DecodeState.ReleaseOut;
        } catch (Throwable th5) {
            if (th5 instanceof MediaCodec.CodecException) {
                i16 = 70002;
            } else if (th5 instanceof IllegalStateException) {
                i16 = 70001;
            }
            handleCoreAPIException(i16, str, th5);
            throw th5;
        }
    }
}
