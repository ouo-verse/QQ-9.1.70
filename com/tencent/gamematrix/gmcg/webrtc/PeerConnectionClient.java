package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import org.tencchromium.base.ThreadUtils;
import org.tencwebrtc.AudioSource;
import org.tencwebrtc.AudioTrack;
import org.tencwebrtc.DataChannel;
import org.tencwebrtc.DefaultVideoDecoderFactory;
import org.tencwebrtc.DefaultVideoEncoderFactory;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.FakeVideoEncoderFactory;
import org.tencwebrtc.FileVideoCapturer;
import org.tencwebrtc.IceCandidate;
import org.tencwebrtc.Loggable;
import org.tencwebrtc.Logging;
import org.tencwebrtc.MediaConstraints;
import org.tencwebrtc.MediaStream;
import org.tencwebrtc.MediaStreamTrack;
import org.tencwebrtc.PeerConnection;
import org.tencwebrtc.PeerConnectionFactory;
import org.tencwebrtc.RTCStatsCollectorCallback;
import org.tencwebrtc.RtpReceiver;
import org.tencwebrtc.RtpTransceiver;
import org.tencwebrtc.SdpObserver;
import org.tencwebrtc.SessionDescription;
import org.tencwebrtc.SurfaceTextureHelper;
import org.tencwebrtc.VideoCapturer;
import org.tencwebrtc.VideoDecoderFactory;
import org.tencwebrtc.VideoEncoderFactory;
import org.tencwebrtc.VideoSink;
import org.tencwebrtc.VideoSource;
import org.tencwebrtc.VideoTrack;

/* loaded from: classes6.dex */
public class PeerConnectionClient implements PeerConnection.Observer {
    static final int ADAPTER_TYPE_LOOPBACK = 16;
    public static final String AUDIO_TRACK_ID = "TencAudioTrackTenc";
    public static final String MEDIA_STREAM_ID = "TencStreamTenc";
    private static final String TAG = "PeerConnectionClient";
    public static final String VIDEO_TRACK_ID = "ARDAMSv0";
    private static String mClipName = "diguo_540x960x30.y4m";
    private static boolean mCompressedVideo = false;
    public static boolean mEnableIpv6OnlyFix = true;
    private static boolean mEnableLoopback = false;

    @Nullable
    private VideoTrack localVideoTrack;
    MediaConstraints mAudioConstraints;
    boolean mAudioFecOn;
    AudioSource mAudioSource;
    AudioTrack mAudioTrack;
    private boolean mClosed;
    boolean mCmLogOn;
    private Context mContext;
    private boolean mCustomizeDecoder;
    private DataChannel mDataChannel;
    private boolean mDisableMediaEncryption;
    private EglBase mEglBase;
    boolean mEnableAudioDump;
    private boolean mEnableKeepSession;
    boolean mEnablePassThrough;
    private boolean mEnableTrace;
    boolean mEnableVoice;
    boolean mFlexFecOn;
    boolean mForceFastRender;
    boolean mFrameFeedbackOn;
    private Vector mIceCandidates;
    private PeerConnection mLocalPeer;
    List<String> mMediaStreamLabels;
    private PeerConnection mPc;
    private PeerConnectionEvent mPcEvent;
    private PeerConnectionFactory mPcFactory;
    AudioTrack mRemoteAudioTrack;
    private PeerConnection mRemotePeer;
    boolean mRsFecOn;
    VideoCapturer mVideoCapturer;
    private VideoSink mVideoRender;

    @Nullable
    private VideoSource mVideoSource;

    @Nullable
    private VideoTrack mVideoTrack;
    private WebRTCParameters mWebRTCParameters;

    @Nullable
    private VideoTrack remoteVideoTrack;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper;
    private RtcEventLog mRtcEventLog = null;
    private boolean mEnableRtcEventLog = true;
    private boolean mEnableRtcEventLogOutput = false;
    boolean mEnablePinchFace = false;
    private boolean mVoiceSwitchedOn = false;
    private boolean mAudioStatus = false;
    String mLocalPath = "/sdcard/";
    int videoWidth = 720;
    int videoHeight = 1520;
    int videoFps = 30;
    private boolean renderVideo = true;
    private SDPObserver mSdpObserver = new SDPObserver();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient$4, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass4 extends CustomPeerConnectionObserver {
        AnonymousClass4() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAddTrack$0(RtpReceiver rtpReceiver) {
            MediaStreamTrack track = rtpReceiver.track();
            if (track instanceof VideoTrack) {
                CGLog.i("onAddTrack VideoTrack");
                VideoTrack videoTrack = (VideoTrack) track;
                try {
                    videoTrack.setEnabled(true);
                } catch (Exception e16) {
                    CGLog.e("Failed to mAudioTrack.setEnabled, cause: " + e16);
                }
                if (PeerConnectionClient.this.mVideoRender != null) {
                    CGLog.i("onAddTrack VideoTrack: " + PeerConnectionClient.this.mVideoRender);
                    videoTrack.addSink(PeerConnectionClient.this.mVideoRender);
                    return;
                }
                CGLog.w("no VideoTrack to add!!!");
            }
        }

        @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomPeerConnectionObserver, org.tencwebrtc.PeerConnection.Observer
        public void onAddTrack(final RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.a
                @Override // java.lang.Runnable
                public final void run() {
                    PeerConnectionClient.AnonymousClass4.this.lambda$onAddTrack$0(rtpReceiver);
                }
            });
        }

        @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomPeerConnectionObserver, org.tencwebrtc.PeerConnection.Observer
        public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            if (!PeerConnectionClient.this.mClosed && PeerConnectionClient.this.mPc != null) {
                if (PeerConnectionClient.this.mPcEvent == null) {
                    CGLog.i("onConnectionChange: " + peerConnectionState + "mPcEvent = null, return");
                    return;
                }
                CGLog.i("PeerConnectionState: " + peerConnectionState);
                PeerConnectionClient.this.mPcEvent.onConnectionChange(peerConnectionState);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomPeerConnectionObserver, org.tencwebrtc.PeerConnection.Observer
        public void onIceCandidate(IceCandidate iceCandidate) {
            Log.d("sinkPeer", "ice candidate");
            PeerConnectionClient.this.mRemotePeer.addIceCandidate(iceCandidate);
        }
    }

    /* renamed from: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient$7, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$Logging$Severity;

        static {
            int[] iArr = new int[Logging.Severity.values().length];
            $SwitchMap$org$tencwebrtc$Logging$Severity = iArr;
            try {
                iArr[Logging.Severity.LS_VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class CustomPeerConnectionObserver implements PeerConnection.Observer {
        public CustomPeerConnectionObserver() {
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onAddStream(MediaStream mediaStream) {
            Log.d("PeerObserver", "stream added");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            Log.d("PeerObserver", "track added");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            org.tencwebrtc.s.a(this, peerConnectionState);
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onDataChannel(DataChannel dataChannel) {
            Log.d("PeerObserver", "data channel");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onIceCandidate(IceCandidate iceCandidate) {
            Log.d("PeerObserver", "ice candidate");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
            Log.d("PeerObserver", "ice candidates removed");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            Log.d("PeerObserver", "ice connection changed to " + iceConnectionState.toString());
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onIceConnectionReceivingChange(boolean z16) {
            Log.d("PeerObserver", "ice connection receiving change");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            Log.d("PeerObserver", "ice gathering changed");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onRemoveStream(MediaStream mediaStream) {
            Log.d("PeerObserver", "stream removed");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onRenegotiationNeeded() {
            Log.d("PeerObserver", "renegotiation needed");
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            Log.d("PeerObserver", "signaling state changed to " + signalingState.toString());
        }

        @Override // org.tencwebrtc.PeerConnection.Observer
        public /* synthetic */ void onTrack(RtpTransceiver rtpTransceiver) {
            org.tencwebrtc.s.b(this, rtpTransceiver);
        }
    }

    /* loaded from: classes6.dex */
    class CustomSdpObserver implements SdpObserver {
        private String tag;

        public CustomSdpObserver(String str) {
            this.tag = str;
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onCreateFailure(String str) {
            Log.e(this.tag, "onCreateFailure: " + str);
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            Log.d(this.tag, "onCreateSuccess: " + sessionDescription.description);
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onSetFailure(String str) {
            Log.e(this.tag, "onSetFailure:");
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onSetSuccess() {
            Log.d(this.tag, "onSetSuccess");
        }
    }

    /* loaded from: classes6.dex */
    public interface PeerConnectionEvent {
        void handleCumulativeDelayedInformation(ByteBuffer byteBuffer, int i3);

        void handleInputMethod(ByteBuffer byteBuffer);

        void handlePassThrough(ByteBuffer byteBuffer);

        void handlePriviledgeNotification(byte[] bArr);

        void handleTVScenesMonitor(ByteBuffer byteBuffer);

        void onChannelPong(String str);

        void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState);

        void onConnectionNotification(int i3, String str);

        void onCreateOfferSuccess(String str);

        void onDataChannelConnected();

        void onDataChannelDisconnected();

        void onDataChannelMessage(String str);

        void onGalleryOpen();

        void onGpsSwitched(boolean z16);

        void onIceCandidate(String str, String str2, int i3);

        void onInputMethod(String str);

        void onPassThrough(String str);

        void onPriviledgeNotification(String str);

        void onSetWebrtcNetworkBandWidth(int i3, String str);

        void onVirtualGamepadEvent(int i3, int i16, int i17, int i18);

        void onVirtualGamepadEvent(int i3, int i16, String str);

        void onVirtualGamepadParamsResp(byte[] bArr);

        void onVirtualGamepadSdkData(byte[] bArr);

        void onVoiceSwitched(boolean z16);

        void switchSdkSendChannel(String str);
    }

    /* loaded from: classes6.dex */
    private class SDPObserver implements SdpObserver {
        SDPObserver() {
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onCreateFailure(String str) {
            CGLog.e("SdpObserver onCreateFailure: " + str);
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            String str = "x-google-min-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMinBitRate() + ";x-google-start-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getStartBitRate() + ";x-google-max-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate() + ";";
            CGLog.i("SdpObserver onCreateSuccess desc=" + str);
            String replaceAll = sessionDescription.description.replaceAll("level-asymmetry-allowed=1;", "level-asymmetry-allowed=1;" + str);
            sessionDescription.description = replaceAll;
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            sessionDescription.description = peerConnectionClient.setBitrate("H265", replaceAll, peerConnectionClient.mWebRTCParameters.getStartBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMinBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate());
            if (PeerConnectionClient.this.mWebRTCParameters.isPreferH265()) {
                sessionDescription.description = PeerConnectionClient.this.preferCodec(sessionDescription.description, "H265", false);
            } else {
                sessionDescription.description = PeerConnectionClient.this.preferCodec(sessionDescription.description, "H264", false);
            }
            if (!PeerConnectionClient.this.mClosed && PeerConnectionClient.this.mPc != null) {
                PeerConnectionClient.this.mPc.setLocalDescription(PeerConnectionClient.this.mSdpObserver, sessionDescription);
                if (PeerConnectionClient.this.mPcEvent != null) {
                    PeerConnectionClient.this.mPcEvent.onCreateOfferSuccess(sessionDescription.description);
                }
            }
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onSetFailure(String str) {
            CGLog.e("SdpObserver onCreateFailure: " + str);
        }

        @Override // org.tencwebrtc.SdpObserver
        public void onSetSuccess() {
            CGLog.i("SdpObserver onSetSuccess");
        }
    }

    public PeerConnectionClient(Context context, EglBase eglBase, PeerConnectionEvent peerConnectionEvent, WebRTCParameters webRTCParameters, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, boolean z36, boolean z37, boolean z38, boolean z39, boolean z46, boolean z47) {
        this.mEnableTrace = false;
        this.mEnableVoice = false;
        this.mEnablePassThrough = false;
        this.mEnableAudioDump = false;
        this.mForceFastRender = true;
        this.mFlexFecOn = true;
        this.mAudioFecOn = true;
        this.mRsFecOn = true;
        this.mFrameFeedbackOn = false;
        this.mClosed = false;
        this.mEnableKeepSession = false;
        this.mCustomizeDecoder = false;
        this.mCmLogOn = false;
        this.mContext = context;
        this.mEglBase = eglBase;
        this.mPcEvent = peerConnectionEvent;
        this.mWebRTCParameters = webRTCParameters;
        this.mEnableVoice = z16;
        this.mEnablePassThrough = z19;
        this.mEnableAudioDump = z26;
        this.mForceFastRender = z27;
        this.mFlexFecOn = z29;
        this.mAudioFecOn = z36;
        this.mRsFecOn = z37;
        this.mFrameFeedbackOn = z38;
        this.mEnableKeepSession = z28;
        this.mCustomizeDecoder = z39;
        this.mCmLogOn = z46;
        this.mDisableMediaEncryption = z47;
        if (!mEnableLoopback) {
            initPeerConnectionFactory(context, z17, z18);
        } else {
            initPeerConnectionFactoryLoopback(context, z17, z18);
        }
        this.mClosed = false;
        if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
            this.mEnableTrace = true;
        }
        this.mIceCandidates = new Vector();
    }

    private void checkDataChannel(DataChannel dataChannel) {
        if (dataChannel == null) {
            CGLog.e("checkDataChannel: illegal DataChannel");
        }
    }

    private void checkPeerConnection(PeerConnection peerConnection) {
        if (peerConnection == null) {
            CGLog.e("checkPeerConnection: illegal PeerConnection");
        }
    }

    private AudioTrack createAudioTrack() {
        return this.mPcFactory.createAudioTrack("audio", this.mPcFactory.createAudioSource(new MediaConstraints()));
    }

    private VideoTrack createVideoTrack() {
        VideoSource createVideoSource = this.mPcFactory.createVideoSource(false);
        this.mVideoSource = createVideoSource;
        VideoTrack createVideoTrack = this.mPcFactory.createVideoTrack("video", createVideoSource);
        this.mVideoTrack = createVideoTrack;
        return createVideoTrack;
    }

    private int findMediaDescriptionLine(boolean z16, String[] strArr) {
        String str;
        if (z16) {
            str = "m=audio ";
        } else {
            str = "m=video ";
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].startsWith(str)) {
                return i3;
            }
        }
        return -1;
    }

    public static Long getmicTime() {
        Long valueOf = Long.valueOf(System.currentTimeMillis() * 1000);
        Long valueOf2 = Long.valueOf(System.nanoTime());
        return Long.valueOf(valueOf.longValue() + ((valueOf2.longValue() - ((valueOf2.longValue() / 1000000) * 1000000)) / 1000));
    }

    private void initPeerConnectionFactory(Context context, boolean z16, boolean z17) {
        VideoDecoderFactory videoDecoderFactory;
        String str;
        String str2;
        String str3;
        String str4;
        PeerConnectionFactory.Options options = null;
        if (this.mWebRTCParameters.isHwDecode()) {
            if (this.mCustomizeDecoder) {
                if (VideoFilterController.get().isUseShareEglContext()) {
                    videoDecoderFactory = new CustomizedVideoDecoderFactory(this.mEglBase.getEglBaseContext());
                } else {
                    videoDecoderFactory = new CustomizedVideoDecoderFactory(null);
                }
                CGLog.i("create CustomizedVideoDecoderFactory");
            } else {
                CGLog.i("isUseShareEglContext=" + VideoFilterController.get().isUseShareEglContext());
                if (VideoFilterController.get().isUseShareEglContext()) {
                    videoDecoderFactory = new DefaultVideoDecoderFactory(this.mEglBase.getEglBaseContext());
                } else {
                    videoDecoderFactory = new DefaultVideoDecoderFactory((EglBase.Context) null);
                }
                CGLog.i("create DefaultVideoDecoderFactory");
            }
        } else {
            videoDecoderFactory = null;
        }
        FakeVideoEncoderFactory fakeVideoEncoderFactory = new FakeVideoEncoderFactory(videoDecoderFactory);
        this.mEnableRtcEventLog = this.mWebRTCParameters.getRtcEventLogStatus();
        this.mEnableRtcEventLogOutput = this.mWebRTCParameters.getRtcEventLogOutputStatus();
        String str5 = "CM-SendSidePlayoutDelayEstimate/Enabled,HighPassJitterMs:33/CM-Bwe-SQRProbingConfiguration/allow_target_transfer_filter,allow_rapid_recovery,bw_up_intervel_ms:3000,LowRTTNackThresholdMs:0,allow_rapid_nack,nack_resend_ms:20,nack_verify_ms:1/WebRTC-KeyframeInterval/max_wait_for_frame_ms:800/WebRTC-Audio-Allocation/min:64,max:128,prio:1/CM-Audio-Jitter-buffer-Max-Packets/10/WebRTC-Bwe-TransportWideFeedbackIntervals/min:10,max:20,def:20/WebRTC-SpsPpsIdrIsH264Keyframe/Enabled/";
        if (this.mDisableMediaEncryption) {
            str5 = "CM-SendSidePlayoutDelayEstimate/Enabled,HighPassJitterMs:33/CM-Bwe-SQRProbingConfiguration/allow_target_transfer_filter,allow_rapid_recovery,bw_up_intervel_ms:3000,LowRTTNackThresholdMs:0,allow_rapid_nack,nack_resend_ms:20,nack_verify_ms:1/WebRTC-KeyframeInterval/max_wait_for_frame_ms:800/WebRTC-Audio-Allocation/min:64,max:128,prio:1/CM-Audio-Jitter-buffer-Max-Packets/10/WebRTC-Bwe-TransportWideFeedbackIntervals/min:10,max:20,def:20/WebRTC-SpsPpsIdrIsH264Keyframe/Enabled/WebRTC-DisableMediaEncryption/Enabled/";
        }
        if (this.mCmLogOn) {
            str5 = (str5 + "log_dir_path/cm_log/") + "cg_log_trial_enabled/Enabled/";
            CGLog.w("Enable CM logging!");
        }
        if (this.mForceFastRender) {
            CGLog.i("Force fastRender");
            str5 = str5 + "CM-ForceFastRender/Enabled/";
        }
        if (this.mFlexFecOn) {
            str = (str5 + "WebRTC-FlexFEC-03/Enabled/WebRTC-FlexFEC-03-Advertised/Enabled/") + "WebRTC-Audio-FlexFEC/Enabled/";
            CGLog.i("FlexFEC is enabled");
        } else {
            str = str5 + "WebRTC-FlexFEC-03/Disabled/WebRTC-FlexFEC-03-Advertised/Disabled/";
            CGLog.i("FlexFEC is disabled");
        }
        if (this.mAudioFecOn) {
            str2 = str + "WebRTC-Audio-FlexFEC/Enabled/";
            CGLog.i("AudioFEC is enabled");
        } else {
            str2 = str + "WebRTC-Audio-FlexFEC/Disabled/";
            CGLog.i("AudioFEC is disabled");
        }
        if (this.mRsFecOn) {
            str3 = str2 + "WebRTC-Video-RSFEC/Enabled/";
            CGLog.i("RS-FEC is enabled");
        } else {
            str3 = str2 + "WebRTC-Video-RSFEC/Disabled/";
            CGLog.i("RS-FEC is disabled");
        }
        if (this.mEnableRtcEventLog) {
            if (this.mEnableRtcEventLogOutput) {
                str3 = str3 + "CM-Log-Configuration/allow_event_log_datachannel,allow_get_remote,allow_local_event_log_record,allow_remote_event_log_record/WebRTC-RtcEventLogNewFormat/Enabled/";
            } else {
                str3 = str3 + "CM-Log-Configuration/allow_event_log_datachannel/WebRTC-RtcEventLogNewFormat/Enabled/";
            }
        }
        if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
            str4 = (str3 + "CM-Connection-VerboseLog-Enabled/Enabled/") + "CM-RtcEventLog-LogMessage-Enabled/Enabled/CM-LogMessage-Severity/LS_VERBOSE/";
        } else if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_INFO) {
            str4 = str3 + "CM-RtcEventLog-LogMessage-Enabled/Enabled/CM-LogMessage-Severity/LS_INFO/";
        } else {
            str4 = str3 + "CM-Connection-VerboseLog-Enabled/Disabled/";
        }
        if (this.mFrameFeedbackOn) {
            str4 = str4 + "WebRTC-FrameFeedbackAdvertised/Enabled/";
        }
        if (this.mEnableAudioDump) {
            str4 = str4 + "CM-Enable-Audio-Dump/Enabled/";
        }
        if (mEnableIpv6OnlyFix) {
            str4 = ((str4 + "WebRTC-AllowMACBasedIPv6/Enabled/") + "WebRTC-BindUsingInterfaceName/Enabled/") + "WebRTC-FindNetworkHandleWithoutIpv6TemporaryPart/Enabled/";
        }
        String str6 = str4 + "\n";
        CGLog.i("rtc config:" + str6);
        PeerConnectionFactory.InitializationOptions.Builder builder = PeerConnectionFactory.InitializationOptions.builder(context);
        builder.setFieldTrials(str6).setEnableInternalTracer(true);
        Loggable customLoggable = this.mWebRTCParameters.getCustomLoggable();
        Logging.Severity loggingSeverity = this.mWebRTCParameters.getLoggingSeverity();
        if (customLoggable == null) {
            customLoggable = new Loggable() { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.2
                @Override // org.tencwebrtc.Loggable
                public void onLogMessage(String str7, Logging.Severity severity, String str8) {
                    int i3 = AnonymousClass7.$SwitchMap$org$tencwebrtc$Logging$Severity[severity.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    CGLog.e(str8, str7);
                                    return;
                                }
                                return;
                            }
                            CGLog.w(str8, str7);
                            return;
                        }
                        CGLog.i(str8, str7);
                        return;
                    }
                    CGLog.v(str8, str7);
                }
            };
            loggingSeverity = Logging.Severity.LS_WARNING;
            CGLog.w("not set custom loggable, use default loggable and severity: " + loggingSeverity);
        }
        CGLog.i("enable inject loggable with severity " + loggingSeverity);
        builder.setInjectableLogger(customLoggable, loggingSeverity);
        PeerConnectionFactory.initialize(builder.createInitializationOptions());
        PeerConnectionFactory.Options options2 = new PeerConnectionFactory.Options();
        CGLog.i("options.networkIgnoreMask=" + this.mWebRTCParameters.getNetworkIgnoreMask());
        if (this.mWebRTCParameters.getNetworkIgnoreMask() != 0) {
            options2.networkIgnoreMask = this.mWebRTCParameters.getNetworkIgnoreMask() | 16;
            options = options2;
        }
        this.mPcFactory = PeerConnectionFactory.builder().setVideoEncoderFactory(fakeVideoEncoderFactory).setVideoDecoderFactory(videoDecoderFactory).setOptions(options).setUseOpenSles(z16).setEnableReadFile(z17).setAudioSource(this.mWebRTCParameters.getAudioSource()).createPeerConnectionFactory();
    }

    private void initPeerConnectionFactoryLoopback(Context context, boolean z16, boolean z17) {
        VideoDecoderFactory videoDecoderFactory;
        VideoEncoderFactory defaultVideoEncoderFactory;
        String str;
        String str2;
        String str3 = null;
        if (this.mWebRTCParameters.isHwDecode()) {
            if (this.mCustomizeDecoder) {
                if (VideoFilterController.get().isUseShareEglContext()) {
                    videoDecoderFactory = new CustomizedVideoDecoderFactory(this.mEglBase.getEglBaseContext());
                } else {
                    videoDecoderFactory = new CustomizedVideoDecoderFactory(null);
                }
                CGLog.i("create CustomizedVideoDecoderFactory");
            } else {
                CGLog.i("isUseShareEglContext=" + VideoFilterController.get().isUseShareEglContext());
                if (VideoFilterController.get().isUseShareEglContext()) {
                    videoDecoderFactory = new DefaultVideoDecoderFactory(this.mEglBase.getEglBaseContext());
                } else {
                    videoDecoderFactory = new DefaultVideoDecoderFactory((EglBase.Context) null);
                }
                CGLog.i("create DefaultVideoDecoderFactory");
            }
        } else {
            videoDecoderFactory = null;
        }
        if (mCompressedVideo) {
            defaultVideoEncoderFactory = new CustomizedVideoEncoderFactory(this.mEglBase.getEglBaseContext(), false, true);
        } else {
            defaultVideoEncoderFactory = new DefaultVideoEncoderFactory(this.mEglBase.getEglBaseContext(), false, true);
        }
        this.mEnableRtcEventLog = this.mWebRTCParameters.getRtcEventLogStatus();
        this.mEnableRtcEventLogOutput = this.mWebRTCParameters.getRtcEventLogOutputStatus();
        String str4 = "CM-SendSidePlayoutDelayEstimate/Enabled,HighPassJitterMs:33/CM-Bwe-SQRProbingConfiguration/allow_target_transfer_filter,allow_rapid_recovery,bw_up_intervel_ms:3000,LowRTTNackThresholdMs:0,allow_rapid_nack,nack_resend_ms:20,nack_verify_ms:1/WebRTC-KeyframeInterval/max_wait_for_frame_ms:800/WebRTC-Audio-Allocation/min:64,max:128,prio:1/log_dir_path/cm_log/cg_log_trial_enabled/Enabled/CM-Audio-Jitter-buffer-Max-Packets/10/WebRTC-Bwe-TransportWideFeedbackIntervals/min:10,max:20,def:20/";
        if (this.mForceFastRender) {
            CGLog.i("Force fastRender");
            str4 = "CM-SendSidePlayoutDelayEstimate/Enabled,HighPassJitterMs:33/CM-Bwe-SQRProbingConfiguration/allow_target_transfer_filter,allow_rapid_recovery,bw_up_intervel_ms:3000,LowRTTNackThresholdMs:0,allow_rapid_nack,nack_resend_ms:20,nack_verify_ms:1/WebRTC-KeyframeInterval/max_wait_for_frame_ms:800/WebRTC-Audio-Allocation/min:64,max:128,prio:1/log_dir_path/cm_log/cg_log_trial_enabled/Enabled/CM-Audio-Jitter-buffer-Max-Packets/10/WebRTC-Bwe-TransportWideFeedbackIntervals/min:10,max:20,def:20/CM-ForceFastRender/Enabled/";
        }
        if (this.mFlexFecOn) {
            str = (str4 + "WebRTC-FlexFEC-03/Enabled/WebRTC-FlexFEC-03-Advertised/Enabled/") + "WebRTC-Audio-FlexFEC/Enabled/";
            CGLog.i("FlexFEC is enabled");
        } else {
            str = str4 + "WebRTC-FlexFEC-03/Disabled/WebRTC-FlexFEC-03-Advertised/Disabled/";
            CGLog.i("FlexFEC is disabled");
        }
        if (this.mEnableRtcEventLog) {
            if (this.mEnableRtcEventLogOutput) {
                str = str + "CM-Log-Configuration/allow_event_log_datachannel,allow_get_remote,allow_local_event_log_record,allow_remote_event_log_record/WebRTC-RtcEventLogNewFormat/Enabled/";
            } else {
                str = str + "CM-Log-Configuration/allow_event_log_datachannel/WebRTC-RtcEventLogNewFormat/Enabled/";
            }
        }
        if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
            str2 = (str + "CM-Connection-VerboseLog-Enabled/Enabled/") + "CM-RtcEventLog-LogMessage-Enabled/Enabled/CM-LogMessage-Severity/LS_VERBOSE/";
        } else if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_INFO) {
            str2 = str + "CM-RtcEventLog-LogMessage-Enabled/Enabled/CM-LogMessage-Severity/LS_INFO/";
        } else {
            str2 = str + "CM-Connection-VerboseLog-Enabled/Disabled/";
        }
        if (this.mFrameFeedbackOn) {
            str2 = str2 + "WebRTC-FrameFeedbackAdvertised/Enabled/";
        }
        if (this.mEnableAudioDump) {
            str2 = str2 + "CM-Enable-Audio-Dump/Enabled/";
        }
        String str5 = (str2 + "WebRTC-FrameDropper/Disabled/") + "\n";
        CGLog.i("rtc config:" + str5);
        PeerConnectionFactory.InitializationOptions.Builder enableInternalTracer = PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str5).setEnableInternalTracer(true);
        WebRTCParameters webRTCParameters = this.mWebRTCParameters;
        if (webRTCParameters != null && webRTCParameters.getCustomLoggable() != null) {
            enableInternalTracer.setInjectableLogger(this.mWebRTCParameters.getCustomLoggable(), this.mWebRTCParameters.getCustomLoggingSeverity());
        }
        PeerConnectionFactory.initialize(enableInternalTracer.createInitializationOptions());
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        options.networkIgnoreMask = 2;
        this.mPcFactory = PeerConnectionFactory.builder().setVideoEncoderFactory(defaultVideoEncoderFactory).setVideoDecoderFactory(videoDecoderFactory).setOptions(options).setUseOpenSles(z16).setEnableReadFile(z17).createPeerConnectionFactory();
        if (this.mWebRTCParameters.getCustomLoggable() == null) {
            Logging.enableLogToDebugOutput(this.mWebRTCParameters.getLoggingSeverity());
        }
        if (this.mPc == null) {
            PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(new ArrayList());
            if (this.mEnableKeepSession) {
                rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
            }
            rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
            rTCConfiguration.audioJitterBufferMaxPackets = 10;
            rTCConfiguration.audioJitterBufferFastAccelerate = true;
            if (this.mPcFactory != null) {
                Log.i(TAG, "start to create pc");
                PeerConnection createPeerConnection = this.mPcFactory.createPeerConnection(rTCConfiguration, this);
                this.mPc = createPeerConnection;
                if (createPeerConnection != null && this.mEnableRtcEventLog) {
                    RtcEventLog rtcEventLog = new RtcEventLog(createPeerConnection);
                    this.mRtcEventLog = rtcEventLog;
                    rtcEventLog.start();
                }
            }
            CompressedVideoCapturer.setSinkReady(false);
            PeerConnection createPeerConnection2 = this.mPcFactory.createPeerConnection(rTCConfiguration, new CustomPeerConnectionObserver() { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.3
                @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomPeerConnectionObserver, org.tencwebrtc.PeerConnection.Observer
                public void onIceCandidate(IceCandidate iceCandidate) {
                    Log.d("sourcePeer", "received local ice candidate");
                    PeerConnectionClient.this.mLocalPeer.addIceCandidate(iceCandidate);
                }
            });
            this.mRemotePeer = createPeerConnection2;
            createPeerConnection2.addTrack(createVideoTrack());
            this.mLocalPeer = this.mPcFactory.createPeerConnection(rTCConfiguration, new AnonymousClass4());
            final MediaConstraints mediaConstraints = new MediaConstraints();
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(NodeProps.MAX_HEIGHT, "720"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(NodeProps.MAX_WIDTH, "1280"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("maxFrameRate", "30"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("videoCodec", "H264"));
            this.mLocalPeer.createOffer(new CustomSdpObserver(" mLocalPeer") { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.5
                @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomSdpObserver, org.tencwebrtc.SdpObserver
                public void onCreateSuccess(final SessionDescription sessionDescription) {
                    CGLog.i("Create Offer: " + sessionDescription.description);
                    String str6 = "x-google-min-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMinBitRate() + ";x-google-start-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getStartBitRate() + ";x-google-max-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate() + ";";
                    String replaceAll = sessionDescription.description.replaceAll("level-asymmetry-allowed=1;", "level-asymmetry-allowed=1;" + str6);
                    sessionDescription.description = replaceAll;
                    PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
                    sessionDescription.description = peerConnectionClient.setBitrate("H265", replaceAll, peerConnectionClient.mWebRTCParameters.getStartBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMinBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate());
                    if (PeerConnectionClient.this.mWebRTCParameters.isPreferH265()) {
                        sessionDescription.description = PeerConnectionClient.this.preferCodec(sessionDescription.description, "H265", false);
                    }
                    PeerConnectionClient.this.mLocalPeer.setLocalDescription(new CustomSdpObserver(" mLocalPeer"), sessionDescription);
                    PeerConnectionClient.this.mRemotePeer.setRemoteDescription(new CustomSdpObserver("mRemotePeer"), sessionDescription);
                    CGLog.i("Changed Offer: " + sessionDescription.description);
                    PeerConnectionClient.this.mRemotePeer.createAnswer(new CustomSdpObserver("mRemotePeer") { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.5.1
                        {
                            PeerConnectionClient peerConnectionClient2 = PeerConnectionClient.this;
                        }

                        @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.CustomSdpObserver, org.tencwebrtc.SdpObserver
                        public void onCreateSuccess(SessionDescription sessionDescription2) {
                            CGLog.i("Create Answer: " + sessionDescription2.description);
                            String str7 = "x-google-min-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMinBitRate() + ";x-google-start-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getStartBitRate() + ";x-google-max-bitrate=" + PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate() + ";";
                            String replaceAll2 = sessionDescription2.description.replaceAll("level-asymmetry-allowed=1;", "level-asymmetry-allowed=1;" + str7);
                            sessionDescription2.description = replaceAll2;
                            PeerConnectionClient peerConnectionClient2 = PeerConnectionClient.this;
                            sessionDescription2.description = peerConnectionClient2.setBitrate("H265", replaceAll2, peerConnectionClient2.mWebRTCParameters.getStartBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMinBitRate(), PeerConnectionClient.this.mWebRTCParameters.getMaxBitRate());
                            if (PeerConnectionClient.this.mWebRTCParameters.isPreferH265()) {
                                sessionDescription.description = PeerConnectionClient.this.preferCodec(sessionDescription2.description, "H265", false);
                            }
                            PeerConnectionClient.this.mRemotePeer.setLocalDescription(new CustomSdpObserver("mRemotePeer"), sessionDescription2);
                            PeerConnectionClient.this.mLocalPeer.setRemoteDescription(new CustomSdpObserver(" mLocalPeer"), sessionDescription2);
                            CompressedVideoCapturer.setSinkReady(true);
                            CGLog.i("Changed Answer: " + sessionDescription2.description);
                        }
                    }, mediaConstraints);
                }
            }, mediaConstraints);
            try {
                Matcher matcher = Pattern.compile("@(\\d+)(FPS)").matcher(mClipName);
                if (matcher.find()) {
                    str3 = matcher.group(1);
                }
                if (str3 != null) {
                    try {
                        this.videoFps = Integer.parseInt(str3);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                String str6 = TAG;
                Log.i(str6, "video fps: " + this.videoFps);
                String str7 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + mClipName;
                if (!mCompressedVideo) {
                    this.mVideoCapturer = new FileVideoCapturer(str7);
                } else {
                    this.mVideoCapturer = new CompressedVideoCapturer(str7);
                }
                SurfaceTextureHelper create = SurfaceTextureHelper.create("FileCaptureThread", this.mEglBase.getEglBaseContext());
                this.surfaceTextureHelper = create;
                this.mVideoCapturer.initialize(create, this.mContext, this.mVideoSource.getCapturerObserver());
                this.mVideoCapturer.startCapture(this.videoWidth, this.videoHeight, this.videoFps);
                Log.i(str6, "Loopback start file capture");
            } catch (Exception e17) {
                Log.i(TAG, "Failed to new FileVideoCapturer, Exception=" + e17);
            }
        }
    }

    private String joinString(Iterable<? extends CharSequence> iterable, String str, boolean z16) {
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb5.append(str);
            sb5.append(it.next());
        }
        if (z16) {
            sb5.append(str);
        }
        return sb5.toString();
    }

    @Nullable
    private String movePayloadTypesToFront(List<String> list, String str) {
        List asList = Arrays.asList(str.split(" "));
        if (asList.size() <= 3) {
            CGLog.e("Wrong SDP media description format: " + str);
            return null;
        }
        List subList = asList.subList(0, 3);
        ArrayList arrayList = new ArrayList(asList.subList(3, asList.size()));
        arrayList.removeAll(list);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(subList);
        arrayList2.addAll(list);
        arrayList2.addAll(arrayList);
        return joinString(arrayList2, " ", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String preferCodec(String str, String str2, boolean z16) {
        String[] split = str.split("\r\n");
        int findMediaDescriptionLine = findMediaDescriptionLine(z16, split);
        if (findMediaDescriptionLine == -1) {
            CGLog.w("No mediaDescription line, so can't prefer " + str2);
            return str;
        }
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str2 + "(/\\d+)+[\r]?$");
        for (String str3 : split) {
            Matcher matcher = compile.matcher(str3);
            if (matcher.matches()) {
                arrayList.add(matcher.group(1));
            }
        }
        if (arrayList.isEmpty()) {
            CGLog.w("No payload types with name " + str2);
            return str;
        }
        String movePayloadTypesToFront = movePayloadTypesToFront(arrayList, split[findMediaDescriptionLine]);
        if (movePayloadTypesToFront == null) {
            return str;
        }
        CGLog.d("Change media description from: " + split[findMediaDescriptionLine] + " to " + movePayloadTypesToFront);
        split[findMediaDescriptionLine] = movePayloadTypesToFront;
        return joinString(Arrays.asList(split), "\r\n", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String setBitrate(String str, String str2, int i3, int i16, int i17) {
        boolean z16;
        String str3;
        String[] split = str2.split("\r\n");
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str + "(/\\d+)+[\r]?$");
        int i18 = 0;
        while (true) {
            z16 = true;
            if (i18 >= split.length) {
                i18 = -1;
                str3 = null;
                break;
            }
            Matcher matcher = compile.matcher(split[i18]);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                break;
            }
            i18++;
        }
        if (str3 == null) {
            CGLog.w("No rtpmap for " + str + " codec");
            return str2;
        }
        CGLog.d("Found " + str + " rtpmap " + str3 + " at " + split[i18]);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("^a=fmtp:");
        sb5.append(str3);
        sb5.append(" \\w+=\\d+.*[\r]?$");
        Pattern compile2 = Pattern.compile(sb5.toString());
        int i19 = 0;
        while (true) {
            if (i19 >= split.length) {
                z16 = false;
                break;
            }
            if (compile2.matcher(split[i19]).matches()) {
                CGLog.d("Found " + str + " " + split[i19]);
                split[i19] = split[i19] + "; x-google-min-bitrate=" + i16 + ";x-google-start-bitrate=" + i3 + ";x-google-max-bitrate=" + i17 + ";";
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Update remote SDP line: ");
                sb6.append(split[i19]);
                CGLog.d(sb6.toString());
                break;
            }
            i19++;
        }
        StringBuilder sb7 = new StringBuilder();
        for (int i26 = 0; i26 < split.length; i26++) {
            sb7.append(split[i26]);
            sb7.append("\r\n");
            if (!z16 && i26 == i18) {
                String str4 = "a=fmtp:" + str3 + " x-google-min-bitrate=" + i16 + ";x-google-start-bitrate=" + i3 + ";x-google-max-bitrate=" + i17 + ";";
                CGLog.d("Add remote SDP line: " + str4);
                sb7.append(str4);
                sb7.append("\r\n");
            }
        }
        return sb7.toString();
    }

    public static void setClipname(String str) {
        mClipName = str;
        Log.i(TAG, "Set loopback clip name: " + str);
        if (mClipName.endsWith(".y4m")) {
            mCompressedVideo = false;
        } else if (mClipName.endsWith(".mp4")) {
            mCompressedVideo = true;
        }
    }

    public static void setLoopback(boolean z16) {
        mEnableLoopback = z16;
        Log.i(TAG, "Set loopback?: " + z16);
    }

    public int MethodCall(String str, List<String> list) {
        PeerConnection peerConnection;
        if (!this.mClosed && (peerConnection = this.mPc) != null) {
            return peerConnection.MethodCall(str, list);
        }
        return -1;
    }

    public void addRemoteIceCandidate(IceCandidate iceCandidate) {
        PeerConnection peerConnection;
        if (!this.mClosed && (peerConnection = this.mPc) != null) {
            peerConnection.addIceCandidate(iceCandidate);
            this.mIceCandidates.addElement(iceCandidate);
        }
    }

    public void close() {
        AudioSource audioSource;
        this.mClosed = true;
        DataChannel dataChannel = this.mDataChannel;
        if (dataChannel != null) {
            dataChannel.unregisterObserver();
            String str = TAG;
            Log.i(str, "datachannel starts to dispose");
            this.mDataChannel.dispose();
            Log.i(str, "datachannel disposed");
            this.mDataChannel = null;
            Log.i(str, "mDataChannel = null");
        }
        if (this.mPc != null) {
            String str2 = TAG;
            Log.i(str2, "pc starts to dispose");
            this.mPc.dispose();
            Log.i(str2, "pc disposed");
            this.mPc = null;
            Log.i(str2, "mPc = null");
        }
        if (mEnableLoopback) {
            VideoCapturer videoCapturer = this.mVideoCapturer;
            if (videoCapturer != null) {
                try {
                    videoCapturer.stopCapture();
                } catch (Exception unused) {
                    Log.e(TAG, "Failed to mFileVideoCapturer.stopCapture()");
                }
                this.mVideoCapturer.dispose();
                this.mVideoCapturer = null;
            }
            PeerConnection peerConnection = this.mLocalPeer;
            if (peerConnection != null) {
                peerConnection.dispose();
                this.mLocalPeer = null;
                Log.i(TAG, "mLocalPeer disposed");
            }
            PeerConnection peerConnection2 = this.mRemotePeer;
            if (peerConnection2 != null) {
                peerConnection2.dispose();
                this.mRemotePeer = null;
                Log.i(TAG, "mRemotePeer disposed");
            }
        }
        if (this.mEnableVoice && (audioSource = this.mAudioSource) != null) {
            audioSource.dispose();
            this.mAudioSource = null;
        }
        if (this.mPcFactory != null) {
            String str3 = TAG;
            Log.i(str3, "pc factory starts to dispose");
            this.mPcFactory.dispose();
            Log.i(str3, "pc factory disposed");
            this.mPcFactory = null;
            Log.i(str3, "mPcFactory = null");
        }
        if (this.mPcEvent != null) {
            this.mPcEvent = null;
        }
    }

    public void createDataChannel() {
        PeerConnection peerConnection;
        if (this.mDataChannel == null) {
            DataChannel.Init init = new DataChannel.Init();
            init.ordered = true;
            if (!this.mClosed && (peerConnection = this.mPc) != null) {
                DataChannel createDataChannel = peerConnection.createDataChannel("cirrus", init);
                this.mDataChannel = createDataChannel;
                createDataChannel.registerObserver(new DataChannel.Observer() { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.1
                    @Override // org.tencwebrtc.DataChannel.Observer
                    public void onMessage(DataChannel.Buffer buffer) {
                        ByteBuffer byteBuffer = buffer.data;
                        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                        byteBuffer.order(byteOrder);
                        byteBuffer.mark();
                        int capacity = byteBuffer.capacity();
                        byte[] bArr = new byte[capacity];
                        byteBuffer.get(bArr);
                        byteBuffer.reset();
                        byte b16 = byteBuffer.get();
                        int i3 = 0;
                        if (b16 == 2) {
                            int i16 = byteBuffer.getInt() & 255;
                            if (i16 != 5) {
                                if (i16 != 6) {
                                    if (i16 != 7) {
                                        if (i16 != 8) {
                                            if (i16 != 96) {
                                                if (i16 != 98) {
                                                    switch (i16) {
                                                        case 10:
                                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                                PeerConnectionClient.this.mPcEvent.handleInputMethod(byteBuffer);
                                                                return;
                                                            }
                                                            return;
                                                        case 11:
                                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                                PeerConnectionClient.this.mPcEvent.handlePriviledgeNotification(bArr);
                                                                return;
                                                            }
                                                            return;
                                                        case 12:
                                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                                PeerConnectionClient.this.mPcEvent.handleTVScenesMonitor(byteBuffer);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                }
                                                if (PeerConnectionClient.this.mPcEvent != null) {
                                                    PeerConnectionClient.this.mPcEvent.onVirtualGamepadParamsResp(bArr);
                                                    return;
                                                }
                                                return;
                                            }
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onVirtualGamepadSdkData(bArr);
                                                return;
                                            }
                                            return;
                                        }
                                        PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
                                        if (peerConnectionClient.mEnablePassThrough && peerConnectionClient.mPcEvent != null) {
                                            PeerConnectionClient.this.mPcEvent.handlePassThrough(byteBuffer);
                                            return;
                                        }
                                        return;
                                    }
                                    if (PeerConnectionClient.this.mEnablePinchFace) {
                                        int i17 = byteBuffer.getInt();
                                        int i18 = byteBuffer.getInt();
                                        int i19 = byteBuffer.getInt();
                                        int i26 = byteBuffer.getInt();
                                        byte[] bArr2 = new byte[i17];
                                        System.arraycopy(bArr, 21, bArr2, 0, i17);
                                        String str = new String(bArr2);
                                        CGLog.v("Received photo from game: " + str + ", nameLen=" + i17 + ", fileLen=" + i18 + ", segLen=" + i19 + ", isLast=" + i26 + ", channel capacity=" + byteBuffer.capacity());
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(PeerConnectionClient.this.mLocalPath);
                                        sb5.append(str.substring(14));
                                        File file = new File(sb5.toString());
                                        try {
                                            if (!file.exists()) {
                                                if (!file.getParentFile().exists()) {
                                                    file.getParentFile().mkdirs();
                                                }
                                                file.createNewFile();
                                            }
                                            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                                            int i27 = 21 + i17;
                                            if (byteBuffer.capacity() < i27 + i19) {
                                                CGLog.e("channel capacity less than expected");
                                            }
                                            fileOutputStream.write(bArr, i27, i19);
                                            fileOutputStream.close();
                                        } catch (IOException e16) {
                                            CGLog.e("Failed to write: " + e16);
                                        }
                                        if (i26 == 1) {
                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                            intent.setData(Uri.fromFile(file));
                                            PeerConnectionClient.this.mContext.sendBroadcast(intent);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (byteBuffer.getInt() == 0) {
                                    if (PeerConnectionClient.this.mPcEvent != null) {
                                        PeerConnectionClient.this.mPcEvent.onGpsSwitched(false);
                                    }
                                    CGLog.i("Received gps switching off message");
                                    return;
                                } else {
                                    if (PeerConnectionClient.this.mPcEvent != null) {
                                        PeerConnectionClient.this.mPcEvent.onGpsSwitched(true);
                                    }
                                    CGLog.i("Received gps switching on message");
                                    return;
                                }
                            }
                            if (PeerConnectionClient.this.mEnableVoice) {
                                if (byteBuffer.getInt() == 0) {
                                    if (PeerConnectionClient.this.mPcEvent != null) {
                                        PeerConnectionClient.this.mPcEvent.onVoiceSwitched(false);
                                    }
                                    CGLog.i("Received voice switching off message");
                                    return;
                                } else {
                                    if (PeerConnectionClient.this.mPcEvent != null) {
                                        PeerConnectionClient.this.mPcEvent.onVoiceSwitched(true);
                                    }
                                    CGLog.i("Received voice switching on message");
                                    return;
                                }
                            }
                            return;
                        }
                        if (b16 == 3) {
                            if (byteBuffer.get() == 107) {
                                try {
                                    try {
                                        int i28 = ((bArr[2] & 255) << 0) | ((bArr[3] & 255) << 8) | ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 24);
                                        if (i28 > 256) {
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onConnectionNotification(2, null);
                                                return;
                                            }
                                            return;
                                        }
                                        try {
                                            String str2 = new String(bArr, 6, i28);
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onConnectionNotification(1, str2);
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            i3 = 1;
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onConnectionNotification(i3, null);
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused) {
                                        if (PeerConnectionClient.this.mPcEvent != null) {
                                            PeerConnectionClient.this.mPcEvent.onConnectionNotification(3, null);
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        } else {
                            if (b16 == 108) {
                                try {
                                    int i29 = ((bArr[1] & 255) << 0) | ((bArr[2] & 255) << 8) | ((bArr[3] & 255) << 16) | ((bArr[4] & 255) << 24);
                                    if (i29 > 256) {
                                        return;
                                    }
                                    PeerConnectionClient.this.mPcEvent.switchSdkSendChannel(new String(bArr, 5, i29));
                                    return;
                                } catch (Exception unused2) {
                                    return;
                                } finally {
                                    PeerConnectionClient.this.mPcEvent.switchSdkSendChannel(null);
                                }
                            }
                            if (b16 == 4) {
                                long longValue = PeerConnectionClient.getmicTime().longValue();
                                byteBuffer.reset();
                                byteBuffer.get();
                                byteBuffer.getInt();
                                long j3 = byteBuffer.getLong();
                                long j16 = byteBuffer.getLong();
                                ByteBuffer order = ByteBuffer.allocate(byteBuffer.capacity() - 4).order(byteOrder);
                                order.mark();
                                order.put(0, (byte) -3);
                                order.putLong(1, j3);
                                order.putLong(9, j16);
                                order.putLong(17, longValue);
                                order.putLong(25, 0L);
                                PeerConnectionClient.this.sendMessageViaDataChannel(order);
                                return;
                            }
                            if (b16 == 109) {
                                try {
                                    try {
                                        int i36 = ((bArr[1] & 255) << 0) | ((bArr[2] & 255) << 8) | ((bArr[3] & 255) << 16) | ((bArr[4] & 255) << 24);
                                        if (i36 > 256) {
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onSetWebrtcNetworkBandWidth(2, null);
                                                return;
                                            }
                                            return;
                                        }
                                        try {
                                            String str3 = new String(bArr, 5, i36);
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onSetWebrtcNetworkBandWidth(1, str3);
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            i3 = 1;
                                            if (PeerConnectionClient.this.mPcEvent != null) {
                                                PeerConnectionClient.this.mPcEvent.onSetWebrtcNetworkBandWidth(i3, null);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                    }
                                } catch (Exception unused3) {
                                    if (PeerConnectionClient.this.mPcEvent != null) {
                                        PeerConnectionClient.this.mPcEvent.onSetWebrtcNetworkBandWidth(3, null);
                                    }
                                }
                            } else if (b16 == -126) {
                                if (PeerConnectionClient.this.mPcEvent != null) {
                                    PeerConnectionClient.this.mPcEvent.handleCumulativeDelayedInformation(byteBuffer, 1);
                                }
                            } else if (b16 == 5 && PeerConnectionClient.this.mPcEvent != null) {
                                try {
                                    PeerConnectionClient.this.mPcEvent.onChannelPong(new String(bArr, 5, capacity - 5));
                                } catch (Exception e17) {
                                    CGLog.e("handle channel pong type failed: " + e17);
                                }
                            }
                        }
                    }

                    @Override // org.tencwebrtc.DataChannel.Observer
                    public void onStateChange() {
                        if (PeerConnectionClient.this.mDataChannel == null) {
                            CGLog.i("DataChannel onStateChange: mDataChannel is null");
                            return;
                        }
                        CGLog.i("DataChannel onStateChange: data channel state = " + PeerConnectionClient.this.mDataChannel.state());
                        if (PeerConnectionClient.this.mDataChannel.state() == DataChannel.State.OPEN && PeerConnectionClient.this.mPcEvent != null) {
                            PeerConnectionClient.this.mPcEvent.onDataChannelConnected();
                        }
                        if (PeerConnectionClient.this.mDataChannel.state() == DataChannel.State.CLOSED && PeerConnectionClient.this.mPcEvent != null) {
                            PeerConnectionClient.this.mPcEvent.onDataChannelDisconnected();
                        }
                    }

                    @Override // org.tencwebrtc.DataChannel.Observer
                    public void onBufferedAmountChange(long j3) {
                    }
                });
            } else {
                return;
            }
        }
        checkDataChannel(this.mDataChannel);
    }

    public void createOffer() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        if (!this.mClosed && this.mPc != null) {
            try {
                if (this.mEnableVoice) {
                    this.mMediaStreamLabels = Collections.singletonList("ARDAMS");
                    MediaConstraints mediaConstraints2 = new MediaConstraints();
                    this.mAudioConstraints = mediaConstraints2;
                    PeerConnectionFactory peerConnectionFactory = this.mPcFactory;
                    if (peerConnectionFactory != null) {
                        AudioSource createAudioSource = peerConnectionFactory.createAudioSource(mediaConstraints2);
                        this.mAudioSource = createAudioSource;
                        this.mAudioTrack = this.mPcFactory.createAudioTrack("TencAudioTrackTenc", createAudioSource);
                        try {
                            PeerConnection peerConnection = this.mPc;
                            if (peerConnection != null) {
                                peerConnection.setAudioRecording(false);
                            }
                            this.mAudioTrack.setEnabled(false);
                        } catch (Exception e16) {
                            CGLog.e("Failed to mAudioTrack.setEnabled, cause: " + e16);
                        }
                        PeerConnection peerConnection2 = this.mPc;
                        if (peerConnection2 != null) {
                            peerConnection2.addTrack(this.mAudioTrack, this.mMediaStreamLabels);
                        }
                    }
                }
                PeerConnection peerConnection3 = this.mPc;
                if (peerConnection3 != null) {
                    peerConnection3.createOffer(this.mSdpObserver, mediaConstraints);
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public void createPeerConnection(JSONObject jSONObject) {
        if (this.mPc == null) {
            PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(new ArrayList());
            if (this.mEnableKeepSession) {
                rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
            }
            rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
            rTCConfiguration.audioJitterBufferMaxPackets = 10;
            rTCConfiguration.audioJitterBufferFastAccelerate = true;
            if (this.mPcFactory != null) {
                Log.i(TAG, "start to create pc");
                PeerConnection createPeerConnection = this.mPcFactory.createPeerConnection(rTCConfiguration, this);
                this.mPc = createPeerConnection;
                if (createPeerConnection != null && this.mEnableRtcEventLog) {
                    RtcEventLog rtcEventLog = new RtcEventLog(createPeerConnection);
                    this.mRtcEventLog = rtcEventLog;
                    rtcEventLog.start();
                }
            }
        }
        checkPeerConnection(this.mPc);
    }

    public void enablePinchFace(boolean z16) {
        this.mEnablePinchFace = z16;
    }

    public boolean getAudioStatus() {
        return this.mAudioStatus;
    }

    public void getStats(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        PeerConnection peerConnection;
        if (!this.mClosed && (peerConnection = this.mPc) != null) {
            if (mEnableLoopback) {
                this.mLocalPeer.getStats(rTCStatsCollectorCallback);
                CGLog.e("Loopback: mLocalPeer.getStats(callback)");
            } else {
                peerConnection.getStats(rTCStatsCollectorCallback);
            }
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
        CGLog.i("onAddStream");
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
        if (!this.mClosed && this.mPc != null) {
            MediaStreamTrack track = rtpReceiver.track();
            if (track instanceof VideoTrack) {
                CGLog.i("onAddTrack VideoTrack");
                VideoTrack videoTrack = (VideoTrack) track;
                try {
                    videoTrack.setEnabled(true);
                } catch (Exception e16) {
                    CGLog.e("Failed to mAudioTrack.setEnabled, cause: " + e16);
                }
                if (this.mVideoRender != null) {
                    CGLog.i("onAddTrack VideoTrack: " + this.mVideoRender);
                    videoTrack.addSink(this.mVideoRender);
                    return;
                }
                CGLog.w("no VideoTrack to add!!!");
                return;
            }
            if (track instanceof AudioTrack) {
                this.mRemoteAudioTrack = (AudioTrack) track;
                this.mAudioStatus = true;
                CGLog.i("onAddTrack AudioTrack");
            }
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        if (!this.mClosed && this.mPc != null) {
            if (this.mPcEvent == null) {
                CGLog.i("onConnectionChange: " + peerConnectionState + "mPcEvent = null, return");
                return;
            }
            CGLog.i("PeerConnectionState: " + peerConnectionState);
            this.mPcEvent.onConnectionChange(peerConnectionState);
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onDataChannel(final DataChannel dataChannel) {
        CGLog.i("onDataChannel");
        this.mDataChannel = dataChannel;
        dataChannel.registerObserver(new DataChannel.Observer() { // from class: com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.6
            @Override // org.tencwebrtc.DataChannel.Observer
            public void onBufferedAmountChange(long j3) {
                CGLog.i("DataChannel onBufferedAmountChange: " + j3);
            }

            @Override // org.tencwebrtc.DataChannel.Observer
            public void onMessage(DataChannel.Buffer buffer) {
                if (!PeerConnectionClient.this.mClosed && PeerConnectionClient.this.mPc != null) {
                    if (buffer.binary) {
                        CGLog.i("Received binary msg over " + dataChannel);
                        return;
                    }
                    ByteBuffer byteBuffer = buffer.data;
                    byte[] bArr = new byte[byteBuffer.capacity()];
                    byteBuffer.get(bArr);
                    String str = new String(bArr, Charset.forName("UTF-8"));
                    CGLog.i("DataChannel onMessage: " + str + " over " + dataChannel);
                    if (PeerConnectionClient.this.mPcEvent != null) {
                        PeerConnectionClient.this.mPcEvent.onDataChannelMessage(str);
                    }
                }
            }

            @Override // org.tencwebrtc.DataChannel.Observer
            public void onStateChange() {
                if (PeerConnectionClient.this.mDataChannel != null) {
                    CGLog.i("DataChannel onStateChange: " + PeerConnectionClient.this.mDataChannel.state());
                }
            }
        });
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate iceCandidate) {
        if (!this.mClosed && this.mPc != null) {
            CGLog.i("onIceCandidate: " + iceCandidate.toString());
            PeerConnectionEvent peerConnectionEvent = this.mPcEvent;
            if (peerConnectionEvent != null) {
                peerConnectionEvent.onIceCandidate(iceCandidate.sdp, iceCandidate.sdpMid, iceCandidate.sdpMLineIndex);
            }
            if (mEnableLoopback) {
                this.mLocalPeer.addIceCandidate(iceCandidate);
                this.mRemotePeer.addIceCandidate(iceCandidate);
            }
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        if (!this.mClosed && this.mPc != null) {
            CGLog.i("onIceCandidatesRemoved: ");
            for (IceCandidate iceCandidate : iceCandidateArr) {
                CGLog.i("removing: " + iceCandidate.toString());
            }
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        if (!this.mClosed && this.mPc != null) {
            CGLog.i("onIceConnectionChange " + iceConnectionState);
            if (iceConnectionState == PeerConnection.IceConnectionState.COMPLETED) {
                WebRTCClient.f108096cs = WebRTCEvents.ConnectionState.STATE_ICE_COMPLETED;
                if (this.mEnableTrace) {
                    TraceCompat.beginSection("STATE_ICE_COMPLETED");
                    TraceCompat.endSection();
                }
            }
        }
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z16) {
        CGLog.i("onIceConnectionReceivingChange " + z16);
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
        CGLog.i("onIceGatheringChange " + iceGatheringState);
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
        CGLog.i("onRemoveStream");
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        CGLog.i("onRenegotiationNeeded");
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        CGLog.i("onSignalingChange " + signalingState);
    }

    @Override // org.tencwebrtc.PeerConnection.Observer
    public void onTrack(RtpTransceiver rtpTransceiver) {
        CGLog.i("onTrack");
    }

    public void removeRemoteIceCandidate(IceCandidate iceCandidate) {
        CGLog.i("removeIceCandidate:" + iceCandidate);
        PeerConnection peerConnection = this.mPc;
        if (peerConnection != null) {
            peerConnection.removeIceCandidates(new IceCandidate[]{iceCandidate});
        }
    }

    public void removeThenAddBackCandidates() {
        IceCandidate[] iceCandidateArr = new IceCandidate[this.mIceCandidates.size()];
        for (int i3 = 0; i3 < this.mIceCandidates.size(); i3++) {
            iceCandidateArr[i3] = (IceCandidate) this.mIceCandidates.get(i3);
        }
        this.mPc.removeIceCandidates(iceCandidateArr);
        for (int i16 = 0; i16 < this.mIceCandidates.size(); i16++) {
            this.mPc.addIceCandidate((IceCandidate) this.mIceCandidates.get(i16));
        }
    }

    public void sendMessageViaDataChannel(ByteBuffer byteBuffer) {
        DataChannel dataChannel;
        if (!this.mClosed && (dataChannel = this.mDataChannel) != null && this.mPc != null) {
            try {
                if (dataChannel.state() == DataChannel.State.OPEN) {
                    this.mDataChannel.send(new DataChannel.Buffer(byteBuffer, true));
                }
            } catch (Exception e16) {
                CGLog.e("Failed to mDataChannel.send, cause: " + e16);
            }
        }
    }

    public void setAudioVolume(double d16) {
        AudioTrack audioTrack = this.mRemoteAudioTrack;
        if (audioTrack != null) {
            audioTrack.setVolume(d16);
            CGLog.i("mRemoteAudioTrack volume = " + d16);
        }
    }

    public void setRemoteSDP(String str) {
        PeerConnection peerConnection;
        SessionDescription sessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, str);
        if (!this.mClosed && (peerConnection = this.mPc) != null) {
            peerConnection.setRemoteDescription(this.mSdpObserver, sessionDescription);
        }
    }

    public void setVideoRender(VideoSink videoSink) {
        this.mVideoRender = videoSink;
    }

    public void switchOnAudio(boolean z16) {
        AudioTrack audioTrack = this.mRemoteAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.setEnabled(z16);
                this.mAudioStatus = z16;
                return;
            } catch (Exception e16) {
                CGLog.e("Failed to mRemoteAudioTrack.setEnabled, cause: " + e16);
                return;
            }
        }
        CGLog.i("Tried to switchOnAudio while mRemoteAudioTrack==null");
    }

    public void switchOnVoice(boolean z16) {
        if (!this.mClosed && this.mPc != null && this.mEnableVoice) {
            if (this.mAudioTrack != null) {
                if (z16) {
                    try {
                        CGLog.d("setAudioRecording : " + z16);
                        this.mPc.setAudioRecording(z16);
                    } catch (Exception e16) {
                        CGLog.e("Failed to mAudioTrack.setEnabled, cause: " + e16);
                    }
                }
                this.mAudioTrack.setEnabled(z16);
                this.mVoiceSwitchedOn = z16;
                return;
            }
            CGLog.i("Tried to switchOnVoice while mAudioTrack==null");
        }
    }
}
