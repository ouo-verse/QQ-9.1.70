package org.tencwebrtc;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.Nullable;
import java.util.List;
import org.tencwebrtc.Logging;
import org.tencwebrtc.NativeLibrary;
import org.tencwebrtc.PeerConnection;
import org.tencwebrtc.audio.AudioDeviceModule;
import org.tencwebrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes29.dex */
public class PeerConnectionFactory {
    private static final String TAG = "PeerConnectionFactory";
    public static final String TRIAL_ENABLED = "Enabled";
    private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";

    @Deprecated
    public static final String VIDEO_FRAME_EMIT_TRIAL = "VideoFrameEmit";
    private static volatile boolean internalTracerInitialized;

    @Nullable
    private static ThreadInfo staticNetworkThread;

    @Nullable
    private static ThreadInfo staticSignalingThread;

    @Nullable
    private static ThreadInfo staticWorkerThread;
    private long nativeFactory;

    @Nullable
    private volatile ThreadInfo networkThread;

    @Nullable
    private volatile ThreadInfo signalingThread;

    @Nullable
    private volatile ThreadInfo workerThread;

    /* loaded from: classes29.dex */
    public static class Builder {
        private AudioDecoderFactoryFactory audioDecoderFactoryFactory;

        @Nullable
        private AudioDeviceModule audioDeviceModule;
        private AudioEncoderFactoryFactory audioEncoderFactoryFactory;

        @Nullable
        private AudioProcessingFactory audioProcessingFactory;

        @Nullable
        private Integer audioSource;
        private boolean enableReadFile;

        @Nullable
        private FecControllerFactoryFactoryInterface fecControllerFactoryFactory;

        @Nullable
        private MediaTransportFactoryFactory mediaTransportFactoryFactory;

        @Nullable
        private NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory;

        @Nullable
        private Options options;
        private boolean useOpenSles;

        @Nullable
        private VideoDecoderFactory videoDecoderFactory;

        @Nullable
        private VideoEncoderFactory videoEncoderFactory;

        public PeerConnectionFactory createPeerConnectionFactory() {
            int i3;
            long createNative;
            long createNative2;
            long createNativeNetworkStatePredictorFactory;
            Integer num = this.audioSource;
            if (num != null) {
                i3 = num.intValue();
            } else {
                String str = Build.BRAND;
                if (!str.equalsIgnoreCase("toshiba") && !str.equalsIgnoreCase("hisense") && !str.equalsIgnoreCase("vidda") && !str.equalsIgnoreCase("vidaa")) {
                    i3 = 7;
                } else {
                    i3 = 1;
                }
            }
            PeerConnectionFactory.checkInitializeHasBeenCalled();
            if (this.audioDeviceModule == null) {
                this.audioDeviceModule = JavaAudioDeviceModule.builder(ContextUtils.getApplicationContext()).setUseStereoOutput(true).setUseOpenSlesPlayer(this.useOpenSles).setEnableReadFile(this.enableReadFile).setAudioSource(i3).createAudioDeviceModule();
            }
            Context applicationContext = ContextUtils.getApplicationContext();
            Options options = this.options;
            long nativeAudioDeviceModulePointer = this.audioDeviceModule.getNativeAudioDeviceModulePointer();
            long createNativeAudioEncoderFactory = this.audioEncoderFactoryFactory.createNativeAudioEncoderFactory();
            long createNativeAudioDecoderFactory = this.audioDecoderFactoryFactory.createNativeAudioDecoderFactory();
            VideoEncoderFactory videoEncoderFactory = this.videoEncoderFactory;
            VideoDecoderFactory videoDecoderFactory = this.videoDecoderFactory;
            AudioProcessingFactory audioProcessingFactory = this.audioProcessingFactory;
            long j3 = 0;
            if (audioProcessingFactory == null) {
                createNative = 0;
            } else {
                createNative = audioProcessingFactory.createNative();
            }
            FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface = this.fecControllerFactoryFactory;
            if (fecControllerFactoryFactoryInterface == null) {
                createNative2 = 0;
            } else {
                createNative2 = fecControllerFactoryFactoryInterface.createNative();
            }
            NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory = this.networkStatePredictorFactoryFactory;
            if (networkStatePredictorFactoryFactory == null) {
                createNativeNetworkStatePredictorFactory = 0;
            } else {
                createNativeNetworkStatePredictorFactory = networkStatePredictorFactoryFactory.createNativeNetworkStatePredictorFactory();
            }
            MediaTransportFactoryFactory mediaTransportFactoryFactory = this.mediaTransportFactoryFactory;
            if (mediaTransportFactoryFactory != null) {
                j3 = mediaTransportFactoryFactory.createNativeMediaTransportFactory();
            }
            return PeerConnectionFactory.nativeCreatePeerConnectionFactory(applicationContext, options, nativeAudioDeviceModulePointer, createNativeAudioEncoderFactory, createNativeAudioDecoderFactory, videoEncoderFactory, videoDecoderFactory, createNative, createNative2, createNativeNetworkStatePredictorFactory, j3);
        }

        public Builder setAudioDecoderFactoryFactory(AudioDecoderFactoryFactory audioDecoderFactoryFactory) {
            if (audioDecoderFactoryFactory != null) {
                this.audioDecoderFactoryFactory = audioDecoderFactoryFactory;
                return this;
            }
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioDecoderFactoryFactory.");
        }

        public Builder setAudioDeviceModule(AudioDeviceModule audioDeviceModule) {
            this.audioDeviceModule = audioDeviceModule;
            return this;
        }

        public Builder setAudioEncoderFactoryFactory(AudioEncoderFactoryFactory audioEncoderFactoryFactory) {
            if (audioEncoderFactoryFactory != null) {
                this.audioEncoderFactoryFactory = audioEncoderFactoryFactory;
                return this;
            }
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioEncoderFactoryFactory.");
        }

        public Builder setAudioProcessingFactory(AudioProcessingFactory audioProcessingFactory) {
            if (audioProcessingFactory != null) {
                this.audioProcessingFactory = audioProcessingFactory;
                return this;
            }
            throw new NullPointerException("PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
        }

        public Builder setAudioSource(@Nullable Integer num) {
            this.audioSource = num;
            return this;
        }

        public Builder setEnableReadFile(boolean z16) {
            this.enableReadFile = z16;
            return this;
        }

        public Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface) {
            this.fecControllerFactoryFactory = fecControllerFactoryFactoryInterface;
            return this;
        }

        public Builder setMediaTransportFactoryFactory(MediaTransportFactoryFactory mediaTransportFactoryFactory) {
            this.mediaTransportFactoryFactory = mediaTransportFactoryFactory;
            return this;
        }

        public Builder setNetworkStatePredictorFactoryFactory(NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory) {
            this.networkStatePredictorFactoryFactory = networkStatePredictorFactoryFactory;
            return this;
        }

        public Builder setOptions(Options options) {
            this.options = options;
            return this;
        }

        public Builder setUseOpenSles(boolean z16) {
            this.useOpenSles = z16;
            return this;
        }

        public Builder setVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
            this.videoDecoderFactory = videoDecoderFactory;
            return this;
        }

        public Builder setVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
            this.videoEncoderFactory = videoEncoderFactory;
            return this;
        }

        Builder() {
            this.audioEncoderFactoryFactory = new BuiltinAudioEncoderFactoryFactory();
            this.audioDecoderFactoryFactory = new BuiltinAudioDecoderFactoryFactory();
        }
    }

    /* loaded from: classes29.dex */
    public static class InitializationOptions {
        final Context applicationContext;
        final boolean enableInternalTracer;
        final String fieldTrials;

        @Nullable
        Loggable loggable;

        @Nullable
        Logging.Severity loggableSeverity;
        final NativeLibraryLoader nativeLibraryLoader;
        final String nativeLibraryName;

        /* loaded from: classes29.dex */
        public static class Builder {
            private final Context applicationContext;
            private boolean enableInternalTracer;

            @Nullable
            private Loggable loggable;

            @Nullable
            private Logging.Severity loggableSeverity;
            private String fieldTrials = "";
            private NativeLibraryLoader nativeLibraryLoader = new NativeLibrary.DefaultLoader();
            private String nativeLibraryName = "jingle_peerconnection_so_tenc";

            Builder(Context context) {
                this.applicationContext = context;
            }

            public InitializationOptions createInitializationOptions() {
                return new InitializationOptions(this.applicationContext, this.fieldTrials, this.enableInternalTracer, this.nativeLibraryLoader, this.nativeLibraryName, this.loggable, this.loggableSeverity);
            }

            public Builder setEnableInternalTracer(boolean z16) {
                this.enableInternalTracer = z16;
                return this;
            }

            public Builder setFieldTrials(String str) {
                this.fieldTrials = str;
                return this;
            }

            public Builder setInjectableLogger(Loggable loggable, Logging.Severity severity) {
                this.loggable = loggable;
                this.loggableSeverity = severity;
                return this;
            }

            public Builder setNativeLibraryLoader(NativeLibraryLoader nativeLibraryLoader) {
                this.nativeLibraryLoader = nativeLibraryLoader;
                return this;
            }

            public Builder setNativeLibraryName(String str) {
                this.nativeLibraryName = str;
                return this;
            }
        }

        public static Builder builder(Context context) {
            return new Builder(context);
        }

        InitializationOptions(Context context, String str, boolean z16, NativeLibraryLoader nativeLibraryLoader, String str2, @Nullable Loggable loggable, @Nullable Logging.Severity severity) {
            this.applicationContext = context;
            this.fieldTrials = str;
            this.enableInternalTracer = z16;
            this.nativeLibraryLoader = nativeLibraryLoader;
            this.nativeLibraryName = str2;
            this.loggable = loggable;
            this.loggableSeverity = severity;
        }
    }

    /* loaded from: classes29.dex */
    public static class Options {
        static final int ADAPTER_TYPE_ANY = 32;
        static final int ADAPTER_TYPE_CELLULAR = 4;
        static final int ADAPTER_TYPE_ETHERNET = 1;
        static final int ADAPTER_TYPE_LOOPBACK = 16;
        static final int ADAPTER_TYPE_UNKNOWN = 0;
        static final int ADAPTER_TYPE_VPN = 8;
        static final int ADAPTER_TYPE_WIFI = 2;
        public boolean disableEncryption;
        public boolean disableNetworkMonitor;
        public int networkIgnoreMask;

        @CalledByNative("Options")
        boolean getDisableEncryption() {
            return this.disableEncryption;
        }

        @CalledByNative("Options")
        boolean getDisableNetworkMonitor() {
            return this.disableNetworkMonitor;
        }

        @CalledByNative("Options")
        int getNetworkIgnoreMask() {
            return this.networkIgnoreMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class ThreadInfo {
        final Thread thread;
        final int tid;

        ThreadInfo(Thread thread, int i3) {
            this.thread = thread;
            this.tid = i3;
        }

        public static ThreadInfo getCurrent() {
            return new ThreadInfo(Thread.currentThread(), Process.myTid());
        }
    }

    @CalledByNative
    PeerConnectionFactory(long j3) {
        checkInitializeHasBeenCalled();
        if (j3 != 0) {
            this.nativeFactory = j3;
            return;
        }
        throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkInitializeHasBeenCalled() {
        if (NativeLibrary.isLoaded() && ContextUtils.getApplicationContext() != null) {
        } else {
            throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
        }
    }

    private void checkPeerConnectionFactoryExists() {
        if (this.nativeFactory != 0) {
        } else {
            throw new IllegalStateException("PeerConnectionFactory has been disposed.");
        }
    }

    public static String fieldTrialsFindFullName(String str) {
        if (NativeLibrary.isLoaded()) {
            return nativeFindFieldTrialsFullName(str);
        }
        return "";
    }

    public static void initialize(InitializationOptions initializationOptions) {
        ContextUtils.initialize(initializationOptions.applicationContext);
        NativeLibrary.initialize(initializationOptions.nativeLibraryLoader, initializationOptions.nativeLibraryName);
        nativeInitializeAndroidGlobals();
        nativeInitializeFieldTrials(initializationOptions.fieldTrials);
        if (initializationOptions.enableInternalTracer && !internalTracerInitialized) {
            initializeInternalTracer();
        }
        Loggable loggable = initializationOptions.loggable;
        if (loggable != null) {
            Logging.injectLoggable(loggable, initializationOptions.loggableSeverity);
            nativeInjectLoggable(new JNILogging(initializationOptions.loggable), initializationOptions.loggableSeverity.ordinal());
        } else {
            Logging.d(TAG, "PeerConnectionFactory was initialized without an injected Loggable. Any existing Loggable will be deleted.");
            Logging.deleteInjectedLoggable();
            nativeDeleteLoggable();
        }
    }

    @Deprecated
    public static void initializeFieldTrials(String str) {
        nativeInitializeFieldTrials(str);
    }

    private static void initializeInternalTracer() {
        internalTracerInitialized = true;
        nativeInitializeInternalTracer();
    }

    private static native long nativeCreateAudioSource(long j3, MediaConstraints mediaConstraints);

    private static native long nativeCreateAudioTrack(long j3, String str, long j16);

    private static native long nativeCreateLocalMediaStream(long j3, String str);

    private static native long nativeCreatePeerConnection(long j3, PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, long j16, SSLCertificateVerifier sSLCertificateVerifier);

    /* JADX INFO: Access modifiers changed from: private */
    public static native PeerConnectionFactory nativeCreatePeerConnectionFactory(Context context, Options options, long j3, long j16, long j17, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, long j18, long j19, long j26, long j27);

    private static native long nativeCreateVideoSource(long j3, boolean z16, boolean z17);

    private static native long nativeCreateVideoTrack(long j3, String str, long j16);

    private static native void nativeDeleteLoggable();

    private static native String nativeFindFieldTrialsFullName(String str);

    private static native void nativeFreeFactory(long j3);

    private static native long nativeGetNativePeerConnectionFactory(long j3);

    private static native void nativeInitializeAndroidGlobals();

    private static native void nativeInitializeFieldTrials(String str);

    private static native void nativeInitializeInternalTracer();

    private static native void nativeInjectLoggable(JNILogging jNILogging, int i3);

    private static native void nativePrintStackTrace(int i3);

    private static native void nativePrintStackTracesOfRegisteredThreads();

    private static native void nativeShutdownInternalTracer();

    private static native boolean nativeStartAecDump(long j3, int i3, int i16);

    private static native boolean nativeStartInternalTracingCapture(String str);

    private static native void nativeStopAecDump(long j3);

    private static native void nativeStopInternalTracingCapture();

    @CalledByNative
    private void onNetworkThreadReady() {
        this.networkThread = ThreadInfo.getCurrent();
        staticNetworkThread = this.networkThread;
        Logging.d(TAG, "onNetworkThreadReady");
    }

    @CalledByNative
    private void onSignalingThreadReady() {
        this.signalingThread = ThreadInfo.getCurrent();
        staticSignalingThread = this.signalingThread;
        Logging.d(TAG, "onSignalingThreadReady");
    }

    @CalledByNative
    private void onWorkerThreadReady() {
        this.workerThread = ThreadInfo.getCurrent();
        staticWorkerThread = this.workerThread;
        Logging.d(TAG, "onWorkerThreadReady");
    }

    private static void printStackTrace(@Nullable ThreadInfo threadInfo, boolean z16) {
        if (threadInfo == null) {
            return;
        }
        String name = threadInfo.thread.getName();
        StackTraceElement[] stackTrace = threadInfo.thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.w(TAG, name + " stacktrace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.w(TAG, stackTraceElement.toString());
            }
        }
        if (z16) {
            Logging.w(TAG, "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
            Logging.w(TAG, "pid: " + Process.myPid() + ", tid: " + threadInfo.tid + ", name: " + name + "  >>> WebRTC <<<");
            nativePrintStackTrace(threadInfo.tid);
        }
    }

    @Deprecated
    public static void printStackTraces() {
        printStackTrace(staticNetworkThread, false);
        printStackTrace(staticWorkerThread, false);
        printStackTrace(staticSignalingThread, false);
    }

    public static void shutdownInternalTracer() {
        internalTracerInitialized = false;
        nativeShutdownInternalTracer();
    }

    public static boolean startInternalTracingCapture(String str) {
        return nativeStartInternalTracingCapture(str);
    }

    public static void stopInternalTracingCapture() {
        nativeStopInternalTracingCapture();
    }

    public AudioSource createAudioSource(MediaConstraints mediaConstraints) {
        checkPeerConnectionFactoryExists();
        return new AudioSource(nativeCreateAudioSource(this.nativeFactory, mediaConstraints));
    }

    public AudioTrack createAudioTrack(String str, AudioSource audioSource) {
        checkPeerConnectionFactoryExists();
        return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, str, audioSource.getNativeAudioSource()));
    }

    public MediaStream createLocalMediaStream(String str) {
        checkPeerConnectionFactoryExists();
        return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, str));
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        return createPeerConnectionInternal(rTCConfiguration, mediaConstraints, observer, null);
    }

    @Nullable
    PeerConnection createPeerConnectionInternal(PeerConnection.RTCConfiguration rTCConfiguration, MediaConstraints mediaConstraints, PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        checkPeerConnectionFactoryExists();
        long createNativePeerConnectionObserver = PeerConnection.createNativePeerConnectionObserver(observer);
        if (createNativePeerConnectionObserver == 0) {
            return null;
        }
        long nativeCreatePeerConnection = nativeCreatePeerConnection(this.nativeFactory, rTCConfiguration, mediaConstraints, createNativePeerConnectionObserver, sSLCertificateVerifier);
        if (nativeCreatePeerConnection == 0) {
            return null;
        }
        return new PeerConnection(nativeCreatePeerConnection);
    }

    public VideoSource createVideoSource(boolean z16, boolean z17) {
        checkPeerConnectionFactoryExists();
        return new VideoSource(nativeCreateVideoSource(this.nativeFactory, z16, z17));
    }

    public VideoTrack createVideoTrack(String str, VideoSource videoSource) {
        checkPeerConnectionFactoryExists();
        return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, str, videoSource.getNativeVideoTrackSource()));
    }

    public void dispose() {
        checkPeerConnectionFactoryExists();
        nativeFreeFactory(this.nativeFactory);
        this.networkThread = null;
        this.workerThread = null;
        this.signalingThread = null;
        MediaCodecVideoEncoder.disposeEglContext();
        MediaCodecVideoDecoder.disposeEglContext();
        this.nativeFactory = 0L;
    }

    public long getNativeOwnedFactoryAndThreads() {
        checkPeerConnectionFactoryExists();
        return this.nativeFactory;
    }

    public long getNativePeerConnectionFactory() {
        checkPeerConnectionFactoryExists();
        return nativeGetNativePeerConnectionFactory(this.nativeFactory);
    }

    public void printInternalStackTraces(boolean z16) {
        printStackTrace(this.signalingThread, z16);
        printStackTrace(this.workerThread, z16);
        printStackTrace(this.networkThread, z16);
        if (z16) {
            nativePrintStackTracesOfRegisteredThreads();
        }
    }

    public boolean startAecDump(int i3, int i16) {
        checkPeerConnectionFactoryExists();
        return nativeStartAecDump(this.nativeFactory, i3, i16);
    }

    public void stopAecDump() {
        checkPeerConnectionFactoryExists();
        nativeStopAecDump(this.nativeFactory);
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, MediaConstraints mediaConstraints, PeerConnection.Observer observer) {
        return createPeerConnection(new PeerConnection.RTCConfiguration(list), mediaConstraints, observer);
    }

    public VideoSource createVideoSource(boolean z16) {
        return createVideoSource(z16, true);
    }

    @Nullable
    public PeerConnection createPeerConnection(List<PeerConnection.IceServer> list, PeerConnection.Observer observer) {
        return createPeerConnection(new PeerConnection.RTCConfiguration(list), observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer) {
        return createPeerConnection(rTCConfiguration, (MediaConstraints) null, observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnectionDependencies peerConnectionDependencies) {
        return createPeerConnectionInternal(rTCConfiguration, null, peerConnectionDependencies.getObserver(), peerConnectionDependencies.getSSLCertificateVerifier());
    }
}
