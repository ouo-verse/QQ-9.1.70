package com.tencent.live2;

import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TXLiveDef {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveAudioFrameObserverFormat {
        static IPatchRedirector $redirector_;
        public int channel;
        public V2TXLiveAudioFrameOperationMode mode;
        public int sampleRate;
        public int samplesPerCall;

        public V2TXLiveAudioFrameObserverFormat() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.sampleRate = 0;
            this.channel = 0;
            this.samplesPerCall = 0;
            this.mode = V2TXLiveAudioFrameOperationMode.V2TXLiveAudioFrameOperationModeReadOnly;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveAudioFrameOperationMode {
        private static final /* synthetic */ V2TXLiveAudioFrameOperationMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveAudioFrameOperationMode V2TXLiveAudioFrameOperationModeReadOnly;
        public static final V2TXLiveAudioFrameOperationMode V2TXLiveAudioFrameOperationModeReadWrite;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17456);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveAudioFrameOperationMode v2TXLiveAudioFrameOperationMode = new V2TXLiveAudioFrameOperationMode("V2TXLiveAudioFrameOperationModeReadWrite", 0);
            V2TXLiveAudioFrameOperationModeReadWrite = v2TXLiveAudioFrameOperationMode;
            V2TXLiveAudioFrameOperationMode v2TXLiveAudioFrameOperationMode2 = new V2TXLiveAudioFrameOperationMode("V2TXLiveAudioFrameOperationModeReadOnly", 1);
            V2TXLiveAudioFrameOperationModeReadOnly = v2TXLiveAudioFrameOperationMode2;
            $VALUES = new V2TXLiveAudioFrameOperationMode[]{v2TXLiveAudioFrameOperationMode, v2TXLiveAudioFrameOperationMode2};
        }

        V2TXLiveAudioFrameOperationMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveAudioFrameOperationMode valueOf(String str) {
            return (V2TXLiveAudioFrameOperationMode) Enum.valueOf(V2TXLiveAudioFrameOperationMode.class, str);
        }

        public static V2TXLiveAudioFrameOperationMode[] values() {
            return (V2TXLiveAudioFrameOperationMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveAudioQuality {
        private static final /* synthetic */ V2TXLiveAudioQuality[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveAudioQuality V2TXLiveAudioQualityDefault;
        public static final V2TXLiveAudioQuality V2TXLiveAudioQualityMusic;
        public static final V2TXLiveAudioQuality V2TXLiveAudioQualitySpeech;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17472);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveAudioQuality v2TXLiveAudioQuality = new V2TXLiveAudioQuality("V2TXLiveAudioQualitySpeech", 0);
            V2TXLiveAudioQualitySpeech = v2TXLiveAudioQuality;
            V2TXLiveAudioQuality v2TXLiveAudioQuality2 = new V2TXLiveAudioQuality("V2TXLiveAudioQualityDefault", 1);
            V2TXLiveAudioQualityDefault = v2TXLiveAudioQuality2;
            V2TXLiveAudioQuality v2TXLiveAudioQuality3 = new V2TXLiveAudioQuality("V2TXLiveAudioQualityMusic", 2);
            V2TXLiveAudioQualityMusic = v2TXLiveAudioQuality3;
            $VALUES = new V2TXLiveAudioQuality[]{v2TXLiveAudioQuality, v2TXLiveAudioQuality2, v2TXLiveAudioQuality3};
        }

        V2TXLiveAudioQuality(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveAudioQuality valueOf(String str) {
            return (V2TXLiveAudioQuality) Enum.valueOf(V2TXLiveAudioQuality.class, str);
        }

        public static V2TXLiveAudioQuality[] values() {
            return (V2TXLiveAudioQuality[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveBufferType {
        private static final /* synthetic */ V2TXLiveBufferType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveBufferType V2TXLiveBufferTypeByteArray;
        public static final V2TXLiveBufferType V2TXLiveBufferTypeByteBuffer;
        public static final V2TXLiveBufferType V2TXLiveBufferTypeTexture;
        public static final V2TXLiveBufferType V2TXLiveBufferTypeUnknown;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17382);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveBufferType v2TXLiveBufferType = new V2TXLiveBufferType("V2TXLiveBufferTypeUnknown", 0);
            V2TXLiveBufferTypeUnknown = v2TXLiveBufferType;
            V2TXLiveBufferType v2TXLiveBufferType2 = new V2TXLiveBufferType("V2TXLiveBufferTypeByteBuffer", 1);
            V2TXLiveBufferTypeByteBuffer = v2TXLiveBufferType2;
            V2TXLiveBufferType v2TXLiveBufferType3 = new V2TXLiveBufferType("V2TXLiveBufferTypeByteArray", 2);
            V2TXLiveBufferTypeByteArray = v2TXLiveBufferType3;
            V2TXLiveBufferType v2TXLiveBufferType4 = new V2TXLiveBufferType("V2TXLiveBufferTypeTexture", 3);
            V2TXLiveBufferTypeTexture = v2TXLiveBufferType4;
            $VALUES = new V2TXLiveBufferType[]{v2TXLiveBufferType, v2TXLiveBufferType2, v2TXLiveBufferType3, v2TXLiveBufferType4};
        }

        V2TXLiveBufferType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveBufferType valueOf(String str) {
            return (V2TXLiveBufferType) Enum.valueOf(V2TXLiveBufferType.class, str);
        }

        public static V2TXLiveBufferType[] values() {
            return (V2TXLiveBufferType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveFillMode {
        private static final /* synthetic */ V2TXLiveFillMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveFillMode V2TXLiveFillModeFill;
        public static final V2TXLiveFillMode V2TXLiveFillModeFit;
        public static final V2TXLiveFillMode V2TXLiveFillModeScaleFill;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17365);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveFillMode v2TXLiveFillMode = new V2TXLiveFillMode("V2TXLiveFillModeFill", 0);
            V2TXLiveFillModeFill = v2TXLiveFillMode;
            V2TXLiveFillMode v2TXLiveFillMode2 = new V2TXLiveFillMode("V2TXLiveFillModeFit", 1);
            V2TXLiveFillModeFit = v2TXLiveFillMode2;
            V2TXLiveFillMode v2TXLiveFillMode3 = new V2TXLiveFillMode("V2TXLiveFillModeScaleFill", 2);
            V2TXLiveFillModeScaleFill = v2TXLiveFillMode3;
            $VALUES = new V2TXLiveFillMode[]{v2TXLiveFillMode, v2TXLiveFillMode2, v2TXLiveFillMode3};
        }

        V2TXLiveFillMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveFillMode valueOf(String str) {
            return (V2TXLiveFillMode) Enum.valueOf(V2TXLiveFillMode.class, str);
        }

        public static V2TXLiveFillMode[] values() {
            return (V2TXLiveFillMode[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveLocalRecordingParams {
        static IPatchRedirector $redirector_;
        public String filePath;
        public int interval;
        public V2TXLiveRecordMode recordMode;

        public V2TXLiveLocalRecordingParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.recordMode = V2TXLiveRecordMode.V2TXLiveRecordModeBoth;
                this.interval = -1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveLogConfig {
        static IPatchRedirector $redirector_;
        public boolean enableConsole;
        public boolean enableLogFile;
        public boolean enableObserver;
        public int logLevel;
        public String logPath;

        public V2TXLiveLogConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.logLevel = 0;
            this.enableObserver = false;
            this.enableConsole = false;
            this.enableLogFile = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveLogLevel {
        static IPatchRedirector $redirector_ = null;
        public static final int V2TXLiveLogLevelAll = 0;
        public static final int V2TXLiveLogLevelDebug = 1;
        public static final int V2TXLiveLogLevelError = 4;
        public static final int V2TXLiveLogLevelFatal = 5;
        public static final int V2TXLiveLogLevelInfo = 2;
        public static final int V2TXLiveLogLevelNULL = 6;
        public static final int V2TXLiveLogLevelWarning = 3;

        public V2TXLiveLogLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveMirrorType {
        private static final /* synthetic */ V2TXLiveMirrorType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveMirrorType V2TXLiveMirrorTypeAuto;
        public static final V2TXLiveMirrorType V2TXLiveMirrorTypeDisable;
        public static final V2TXLiveMirrorType V2TXLiveMirrorTypeEnable;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17465);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveMirrorType v2TXLiveMirrorType = new V2TXLiveMirrorType("V2TXLiveMirrorTypeAuto", 0);
            V2TXLiveMirrorTypeAuto = v2TXLiveMirrorType;
            V2TXLiveMirrorType v2TXLiveMirrorType2 = new V2TXLiveMirrorType("V2TXLiveMirrorTypeEnable", 1);
            V2TXLiveMirrorTypeEnable = v2TXLiveMirrorType2;
            V2TXLiveMirrorType v2TXLiveMirrorType3 = new V2TXLiveMirrorType("V2TXLiveMirrorTypeDisable", 2);
            V2TXLiveMirrorTypeDisable = v2TXLiveMirrorType3;
            $VALUES = new V2TXLiveMirrorType[]{v2TXLiveMirrorType, v2TXLiveMirrorType2, v2TXLiveMirrorType3};
        }

        V2TXLiveMirrorType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveMirrorType valueOf(String str) {
            return (V2TXLiveMirrorType) Enum.valueOf(V2TXLiveMirrorType.class, str);
        }

        public static V2TXLiveMirrorType[] values() {
            return (V2TXLiveMirrorType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveMixInputType {
        private static final /* synthetic */ V2TXLiveMixInputType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveMixInputType V2TXLiveMixInputTypeAudioVideo;
        public static final V2TXLiveMixInputType V2TXLiveMixInputTypePureAudio;
        public static final V2TXLiveMixInputType V2TXLiveMixInputTypePureVideo;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17431);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveMixInputType v2TXLiveMixInputType = new V2TXLiveMixInputType("V2TXLiveMixInputTypeAudioVideo", 0);
            V2TXLiveMixInputTypeAudioVideo = v2TXLiveMixInputType;
            V2TXLiveMixInputType v2TXLiveMixInputType2 = new V2TXLiveMixInputType("V2TXLiveMixInputTypePureVideo", 1);
            V2TXLiveMixInputTypePureVideo = v2TXLiveMixInputType2;
            V2TXLiveMixInputType v2TXLiveMixInputType3 = new V2TXLiveMixInputType("V2TXLiveMixInputTypePureAudio", 2);
            V2TXLiveMixInputTypePureAudio = v2TXLiveMixInputType3;
            $VALUES = new V2TXLiveMixInputType[]{v2TXLiveMixInputType, v2TXLiveMixInputType2, v2TXLiveMixInputType3};
        }

        V2TXLiveMixInputType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveMixInputType valueOf(String str) {
            return (V2TXLiveMixInputType) Enum.valueOf(V2TXLiveMixInputType.class, str);
        }

        public static V2TXLiveMixInputType[] values() {
            return (V2TXLiveMixInputType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveMode {
        private static final /* synthetic */ V2TXLiveMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveMode TXLiveMode_RTC;
        public static final V2TXLiveMode TXLiveMode_RTMP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17325);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveMode v2TXLiveMode = new V2TXLiveMode("TXLiveMode_RTMP", 0);
            TXLiveMode_RTMP = v2TXLiveMode;
            V2TXLiveMode v2TXLiveMode2 = new V2TXLiveMode("TXLiveMode_RTC", 1);
            TXLiveMode_RTC = v2TXLiveMode2;
            $VALUES = new V2TXLiveMode[]{v2TXLiveMode, v2TXLiveMode2};
        }

        V2TXLiveMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveMode valueOf(String str) {
            return (V2TXLiveMode) Enum.valueOf(V2TXLiveMode.class, str);
        }

        public static V2TXLiveMode[] values() {
            return (V2TXLiveMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLivePixelFormat {
        private static final /* synthetic */ V2TXLivePixelFormat[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLivePixelFormat V2TXLivePixelFormatI420;
        public static final V2TXLivePixelFormat V2TXLivePixelFormatTexture2D;
        public static final V2TXLivePixelFormat V2TXLivePixelFormatUnknown;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_UPDATE_REPORT_PARAM);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLivePixelFormat v2TXLivePixelFormat = new V2TXLivePixelFormat("V2TXLivePixelFormatUnknown", 0);
            V2TXLivePixelFormatUnknown = v2TXLivePixelFormat;
            V2TXLivePixelFormat v2TXLivePixelFormat2 = new V2TXLivePixelFormat("V2TXLivePixelFormatI420", 1);
            V2TXLivePixelFormatI420 = v2TXLivePixelFormat2;
            V2TXLivePixelFormat v2TXLivePixelFormat3 = new V2TXLivePixelFormat("V2TXLivePixelFormatTexture2D", 2);
            V2TXLivePixelFormatTexture2D = v2TXLivePixelFormat3;
            $VALUES = new V2TXLivePixelFormat[]{v2TXLivePixelFormat, v2TXLivePixelFormat2, v2TXLivePixelFormat3};
        }

        V2TXLivePixelFormat(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLivePixelFormat valueOf(String str) {
            return (V2TXLivePixelFormat) Enum.valueOf(V2TXLivePixelFormat.class, str);
        }

        public static V2TXLivePixelFormat[] values() {
            return (V2TXLivePixelFormat[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLivePlayerStatistics {
        static IPatchRedirector $redirector_;
        public int appCpu;
        public int audioBitrate;
        public int audioBlockRate;
        public int audioPacketLoss;
        public int audioTotalBlockTime;
        public int fps;
        public int height;
        public int jitterBufferDelay;
        public int netSpeed;
        public int rtt;
        public int systemCpu;
        public int videoBitrate;
        public int videoBlockRate;
        public int videoPacketLoss;
        public int videoTotalBlockTime;
        public int width;

        public V2TXLivePlayerStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLivePushStatus {
        private static final /* synthetic */ V2TXLivePushStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLivePushStatus V2TXLivePushStatusConnectSuccess;
        public static final V2TXLivePushStatus V2TXLivePushStatusConnecting;
        public static final V2TXLivePushStatus V2TXLivePushStatusDisconnected;
        public static final V2TXLivePushStatus V2TXLivePushStatusReconnecting;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17477);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLivePushStatus v2TXLivePushStatus = new V2TXLivePushStatus("V2TXLivePushStatusDisconnected", 0);
            V2TXLivePushStatusDisconnected = v2TXLivePushStatus;
            V2TXLivePushStatus v2TXLivePushStatus2 = new V2TXLivePushStatus("V2TXLivePushStatusConnecting", 1);
            V2TXLivePushStatusConnecting = v2TXLivePushStatus2;
            V2TXLivePushStatus v2TXLivePushStatus3 = new V2TXLivePushStatus("V2TXLivePushStatusConnectSuccess", 2);
            V2TXLivePushStatusConnectSuccess = v2TXLivePushStatus3;
            V2TXLivePushStatus v2TXLivePushStatus4 = new V2TXLivePushStatus("V2TXLivePushStatusReconnecting", 3);
            V2TXLivePushStatusReconnecting = v2TXLivePushStatus4;
            $VALUES = new V2TXLivePushStatus[]{v2TXLivePushStatus, v2TXLivePushStatus2, v2TXLivePushStatus3, v2TXLivePushStatus4};
        }

        V2TXLivePushStatus(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLivePushStatus valueOf(String str) {
            return (V2TXLivePushStatus) Enum.valueOf(V2TXLivePushStatus.class, str);
        }

        public static V2TXLivePushStatus[] values() {
            return (V2TXLivePushStatus[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLivePusherStatistics {
        static IPatchRedirector $redirector_;
        public int appCpu;
        public int audioBitrate;
        public int fps;
        public int height;
        public int netSpeed;
        public int rtt;
        public int systemCpu;
        public int videoBitrate;
        public int width;

        public V2TXLivePusherStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveRecordMode {
        private static final /* synthetic */ V2TXLiveRecordMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveRecordMode V2TXLiveRecordModeBoth;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16570);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveRecordMode v2TXLiveRecordMode = new V2TXLiveRecordMode("V2TXLiveRecordModeBoth", 0);
            V2TXLiveRecordModeBoth = v2TXLiveRecordMode;
            $VALUES = new V2TXLiveRecordMode[]{v2TXLiveRecordMode};
        }

        V2TXLiveRecordMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveRecordMode valueOf(String str) {
            return (V2TXLiveRecordMode) Enum.valueOf(V2TXLiveRecordMode.class, str);
        }

        public static V2TXLiveRecordMode[] values() {
            return (V2TXLiveRecordMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveRotation {
        private static final /* synthetic */ V2TXLiveRotation[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveRotation V2TXLiveRotation0;
        public static final V2TXLiveRotation V2TXLiveRotation180;
        public static final V2TXLiveRotation V2TXLiveRotation270;
        public static final V2TXLiveRotation V2TXLiveRotation90;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17400);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveRotation v2TXLiveRotation = new V2TXLiveRotation("V2TXLiveRotation0", 0);
            V2TXLiveRotation0 = v2TXLiveRotation;
            V2TXLiveRotation v2TXLiveRotation2 = new V2TXLiveRotation("V2TXLiveRotation90", 1);
            V2TXLiveRotation90 = v2TXLiveRotation2;
            V2TXLiveRotation v2TXLiveRotation3 = new V2TXLiveRotation("V2TXLiveRotation180", 2);
            V2TXLiveRotation180 = v2TXLiveRotation3;
            V2TXLiveRotation v2TXLiveRotation4 = new V2TXLiveRotation("V2TXLiveRotation270", 3);
            V2TXLiveRotation270 = v2TXLiveRotation4;
            $VALUES = new V2TXLiveRotation[]{v2TXLiveRotation, v2TXLiveRotation2, v2TXLiveRotation3, v2TXLiveRotation4};
        }

        V2TXLiveRotation(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveRotation valueOf(String str) {
            return (V2TXLiveRotation) Enum.valueOf(V2TXLiveRotation.class, str);
        }

        public static V2TXLiveRotation[] values() {
            return (V2TXLiveRotation[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveSocks5ProxyConfig {
        static IPatchRedirector $redirector_;
        public boolean supportHttps;
        public boolean supportTcp;
        public boolean supportUdp;

        public V2TXLiveSocks5ProxyConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.supportHttps = true;
            this.supportTcp = true;
            this.supportUdp = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveStreamInfo {
        static IPatchRedirector $redirector_;
        public int bitrate;
        public float framerate;
        public int height;
        public String url;
        public int width;

        public V2TXLiveStreamInfo(int i3, int i16, int i17, float f16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16), str);
                return;
            }
            this.width = i3;
            this.height = i16;
            this.bitrate = i17;
            this.framerate = f16;
            this.url = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveTexture {
        static IPatchRedirector $redirector_;
        public EGLContext eglContext10;
        public android.opengl.EGLContext eglContext14;
        public int textureId;

        public V2TXLiveTexture() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveVideoEncoderParam {
        static IPatchRedirector $redirector_;
        public int minVideoBitrate;
        public int videoBitrate;
        public int videoFps;
        public V2TXLiveVideoResolution videoResolution;
        public V2TXLiveVideoResolutionMode videoResolutionMode;

        public V2TXLiveVideoEncoderParam(V2TXLiveVideoResolution v2TXLiveVideoResolution) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v2TXLiveVideoResolution);
                return;
            }
            this.videoResolution = v2TXLiveVideoResolution;
            this.videoResolutionMode = V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
            this.videoFps = 15;
            V2TXLiveUtils.a bitrateByResolution = V2TXLiveUtils.getBitrateByResolution(v2TXLiveVideoResolution);
            this.videoBitrate = bitrateByResolution.f119787b;
            this.minVideoBitrate = bitrateByResolution.f119786a;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "V2TXLiveVideoEncoderParam{videoResolution=" + this.videoResolution + ", videoResolutionMode=" + this.videoResolutionMode + ", videoFps=" + this.videoFps + ", videoBitrate=" + this.videoBitrate + ", minVideoBitrate=" + this.minVideoBitrate + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveVideoFrame {
        static IPatchRedirector $redirector_;
        public ByteBuffer buffer;
        public V2TXLiveBufferType bufferType;
        public byte[] data;
        public int height;
        public V2TXLivePixelFormat pixelFormat;
        public int rotation;
        public V2TXLiveTexture texture;
        public int width;

        public V2TXLiveVideoFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.pixelFormat = V2TXLivePixelFormat.V2TXLivePixelFormatUnknown;
                this.bufferType = V2TXLiveBufferType.V2TXLiveBufferTypeUnknown;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveVideoResolution {
        private static final /* synthetic */ V2TXLiveVideoResolution[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution1280x720;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution160x160;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution1920x1080;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution270x270;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution320x180;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution320x240;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution480x270;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution480x360;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution480x480;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution640x360;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution640x480;
        public static final V2TXLiveVideoResolution V2TXLiveVideoResolution960x540;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17435);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveVideoResolution v2TXLiveVideoResolution = new V2TXLiveVideoResolution("V2TXLiveVideoResolution160x160", 0);
            V2TXLiveVideoResolution160x160 = v2TXLiveVideoResolution;
            V2TXLiveVideoResolution v2TXLiveVideoResolution2 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution270x270", 1);
            V2TXLiveVideoResolution270x270 = v2TXLiveVideoResolution2;
            V2TXLiveVideoResolution v2TXLiveVideoResolution3 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution480x480", 2);
            V2TXLiveVideoResolution480x480 = v2TXLiveVideoResolution3;
            V2TXLiveVideoResolution v2TXLiveVideoResolution4 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution320x240", 3);
            V2TXLiveVideoResolution320x240 = v2TXLiveVideoResolution4;
            V2TXLiveVideoResolution v2TXLiveVideoResolution5 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution480x360", 4);
            V2TXLiveVideoResolution480x360 = v2TXLiveVideoResolution5;
            V2TXLiveVideoResolution v2TXLiveVideoResolution6 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution640x480", 5);
            V2TXLiveVideoResolution640x480 = v2TXLiveVideoResolution6;
            V2TXLiveVideoResolution v2TXLiveVideoResolution7 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution320x180", 6);
            V2TXLiveVideoResolution320x180 = v2TXLiveVideoResolution7;
            V2TXLiveVideoResolution v2TXLiveVideoResolution8 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution480x270", 7);
            V2TXLiveVideoResolution480x270 = v2TXLiveVideoResolution8;
            V2TXLiveVideoResolution v2TXLiveVideoResolution9 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution640x360", 8);
            V2TXLiveVideoResolution640x360 = v2TXLiveVideoResolution9;
            V2TXLiveVideoResolution v2TXLiveVideoResolution10 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution960x540", 9);
            V2TXLiveVideoResolution960x540 = v2TXLiveVideoResolution10;
            V2TXLiveVideoResolution v2TXLiveVideoResolution11 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution1280x720", 10);
            V2TXLiveVideoResolution1280x720 = v2TXLiveVideoResolution11;
            V2TXLiveVideoResolution v2TXLiveVideoResolution12 = new V2TXLiveVideoResolution("V2TXLiveVideoResolution1920x1080", 11);
            V2TXLiveVideoResolution1920x1080 = v2TXLiveVideoResolution12;
            $VALUES = new V2TXLiveVideoResolution[]{v2TXLiveVideoResolution, v2TXLiveVideoResolution2, v2TXLiveVideoResolution3, v2TXLiveVideoResolution4, v2TXLiveVideoResolution5, v2TXLiveVideoResolution6, v2TXLiveVideoResolution7, v2TXLiveVideoResolution8, v2TXLiveVideoResolution9, v2TXLiveVideoResolution10, v2TXLiveVideoResolution11, v2TXLiveVideoResolution12};
        }

        V2TXLiveVideoResolution(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveVideoResolution valueOf(String str) {
            return (V2TXLiveVideoResolution) Enum.valueOf(V2TXLiveVideoResolution.class, str);
        }

        public static V2TXLiveVideoResolution[] values() {
            return (V2TXLiveVideoResolution[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveVideoResolutionMode {
        private static final /* synthetic */ V2TXLiveVideoResolutionMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final V2TXLiveVideoResolutionMode V2TXLiveVideoResolutionModeLandscape;
        public static final V2TXLiveVideoResolutionMode V2TXLiveVideoResolutionModePortrait;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17321);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            V2TXLiveVideoResolutionMode v2TXLiveVideoResolutionMode = new V2TXLiveVideoResolutionMode("V2TXLiveVideoResolutionModeLandscape", 0);
            V2TXLiveVideoResolutionModeLandscape = v2TXLiveVideoResolutionMode;
            V2TXLiveVideoResolutionMode v2TXLiveVideoResolutionMode2 = new V2TXLiveVideoResolutionMode("V2TXLiveVideoResolutionModePortrait", 1);
            V2TXLiveVideoResolutionModePortrait = v2TXLiveVideoResolutionMode2;
            $VALUES = new V2TXLiveVideoResolutionMode[]{v2TXLiveVideoResolutionMode, v2TXLiveVideoResolutionMode2};
        }

        V2TXLiveVideoResolutionMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static V2TXLiveVideoResolutionMode valueOf(String str) {
            return (V2TXLiveVideoResolutionMode) Enum.valueOf(V2TXLiveVideoResolutionMode.class, str);
        }

        public static V2TXLiveVideoResolutionMode[] values() {
            return (V2TXLiveVideoResolutionMode[]) $VALUES.clone();
        }
    }

    public V2TXLiveDef() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveAudioFrame {
        static IPatchRedirector $redirector_;
        public int channel;
        public byte[] data;
        public int sampleRate;
        public long timestamp;

        public V2TXLiveAudioFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.data = null;
            this.sampleRate = 48000;
            this.channel = 1;
            this.timestamp = 0L;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "[data='" + this.data + "'][sampleRate='" + this.sampleRate + "'][channel=" + this.channel + "][timestamp=" + this.timestamp + "]";
        }

        public V2TXLiveAudioFrame(V2TXLiveAudioFrame v2TXLiveAudioFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v2TXLiveAudioFrame);
                return;
            }
            this.data = v2TXLiveAudioFrame.data;
            this.sampleRate = v2TXLiveAudioFrame.sampleRate;
            this.channel = v2TXLiveAudioFrame.channel;
            this.timestamp = v2TXLiveAudioFrame.timestamp;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class V2TXLiveMixStream {
        static IPatchRedirector $redirector_;
        public int height;
        public V2TXLiveMixInputType inputType;
        public String streamId;
        public String userId;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f119782x;

        /* renamed from: y, reason: collision with root package name */
        public int f119783y;
        public int zOrder;

        public V2TXLiveMixStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.userId = "";
            this.f119782x = 0;
            this.f119783y = 0;
            this.width = 0;
            this.height = 0;
            this.zOrder = 0;
            this.inputType = V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "[userId='" + this.userId + "'][streamId='" + this.streamId + "'][x=" + this.f119782x + "][y=" + this.f119783y + "][width=" + this.width + "][height=" + this.height + "][zOrder=" + this.zOrder + "][inputType=" + this.inputType + ']';
        }

        public V2TXLiveMixStream(String str, int i3, int i16, int i17, int i18, int i19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
                return;
            }
            this.userId = str;
            this.f119782x = i3;
            this.f119783y = i16;
            this.width = i17;
            this.height = i18;
            this.zOrder = i19;
            this.inputType = V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
        }

        public V2TXLiveMixStream(V2TXLiveMixStream v2TXLiveMixStream) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v2TXLiveMixStream);
                return;
            }
            this.userId = v2TXLiveMixStream.userId;
            this.streamId = v2TXLiveMixStream.streamId;
            this.f119782x = v2TXLiveMixStream.f119782x;
            this.f119783y = v2TXLiveMixStream.f119783y;
            this.width = v2TXLiveMixStream.width;
            this.height = v2TXLiveMixStream.height;
            this.zOrder = v2TXLiveMixStream.zOrder;
            this.inputType = v2TXLiveMixStream.inputType;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class V2TXLiveTranscodingConfig {
        static IPatchRedirector $redirector_;
        public int audioBitrate;
        public int audioChannels;
        public int audioSampleRate;
        public int backgroundColor;
        public String backgroundImage;
        public ArrayList<V2TXLiveMixStream> mixStreams;
        public String outputStreamId;
        public int videoBitrate;
        public int videoFramerate;
        public int videoGOP;
        public int videoHeight;
        public int videoWidth;

        public V2TXLiveTranscodingConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.videoBitrate = 0;
            this.videoFramerate = 15;
            this.videoGOP = 2;
            this.backgroundColor = 0;
            this.audioSampleRate = 48000;
            this.audioBitrate = 64;
            this.audioChannels = 1;
            this.outputStreamId = null;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "[videoWidth=" + this.videoWidth + "][videoHeight=" + this.videoHeight + "][videoBitrate=" + this.videoBitrate + "][videoFramerate=" + this.videoFramerate + "][videoGOP=" + this.videoGOP + "][backgroundColor=" + this.backgroundColor + "][backgroundImage='" + this.backgroundImage + "'][audioSampleRate=" + this.audioSampleRate + "][audioBitrate=" + this.audioBitrate + "][audioChannels=" + this.audioChannels + "][mixStreams=" + this.mixStreams + "][outputStreamId='" + this.outputStreamId + "']";
        }

        public V2TXLiveTranscodingConfig(V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v2TXLiveTranscodingConfig);
                return;
            }
            this.videoWidth = v2TXLiveTranscodingConfig.videoWidth;
            this.videoHeight = v2TXLiveTranscodingConfig.videoHeight;
            this.videoBitrate = v2TXLiveTranscodingConfig.videoBitrate;
            this.videoFramerate = v2TXLiveTranscodingConfig.videoFramerate;
            this.videoGOP = v2TXLiveTranscodingConfig.videoGOP;
            this.backgroundColor = v2TXLiveTranscodingConfig.backgroundColor;
            this.backgroundImage = v2TXLiveTranscodingConfig.backgroundImage;
            this.audioSampleRate = v2TXLiveTranscodingConfig.audioSampleRate;
            this.audioBitrate = v2TXLiveTranscodingConfig.audioBitrate;
            this.audioChannels = v2TXLiveTranscodingConfig.audioChannels;
            this.outputStreamId = v2TXLiveTranscodingConfig.outputStreamId;
            this.mixStreams = new ArrayList<>(v2TXLiveTranscodingConfig.mixStreams);
        }
    }
}
