package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.k;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@JNINamespace("liteav::trtc")
/* loaded from: classes7.dex */
public class TrtcCloudJni {
    private static final Object INIT_LOCK = new Object();
    private static final String TAG = "TrtcCloudJni";
    private static boolean mHasInited = false;
    private TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private TRTCCloudListener.TRTCVideoFrameListener mCalledGLCreatedFrameListener;
    private final HashSet<View> mFloatingWindowSet;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private TRTCCloudListener mListener;
    private Handler mListenerHandler;
    private List<TRTCCloudListener> mListenerList;
    private String mLocalUserId;
    private final a<TRTCCloudListener.TRTCVideoRenderListener> mLocalVideoRenderListenerWrapper;
    private long mNativeTrtcCloudJni;
    private final ReentrantReadWriteLock mReadWriteLock;
    private final Map<String, a<TRTCCloudListener.TRTCVideoRenderListener>> mRemoteVideoRenderListenerMap;
    private final a<TRTCCloudListener.TRTCVideoFrameListener> mVideoFrameListenerWrapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.trtc.TrtcCloudJni$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119166a;

        static {
            int[] iArr = new int[k.values().length];
            f119166a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119166a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119166a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class AudioFrame {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f119167a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f119167a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f119167a.channel;
        }

        public byte[] getData() {
            return this.f119167a.data;
        }

        public int getSampleRate() {
            return this.f119167a.sampleRate;
        }

        public long getTimestamp() {
            return this.f119167a.timestamp;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class AudioParallelParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioParallelParams f119168a;

        public AudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
            this.f119168a = tRTCAudioParallelParams;
        }

        public String[] getIncludeUsers() {
            ArrayList<String> arrayList = this.f119168a.includeUsers;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public int getMaxCount() {
            return this.f119168a.maxCount;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class AudioRecordingParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCAudioRecordingParams f119169a;

        public AudioRecordingParams(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
            this.f119169a = tRTCAudioRecordingParams;
        }

        public int getContent() {
            return this.f119169a.recordingContent;
        }

        public String getFilePath() {
            return this.f119169a.filePath;
        }

        public int getMaxDurationPerFile() {
            return this.f119169a.maxDurationPerFile;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class EnterRoomParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCParams f119170a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.f119170a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.f119170a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.f119170a.privateMapKey;
        }

        public String getRecordId() {
            return this.f119170a.userDefineRecordId;
        }

        public int getRole() {
            return this.f119170a.role;
        }

        public int getRoomId() {
            return this.f119170a.roomId;
        }

        public int getSdkAppId() {
            return this.f119170a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.f119170a.strRoomId;
        }

        public String getStreamId() {
            return this.f119170a.streamId;
        }

        public String getUserId() {
            return this.f119170a.userId;
        }

        public String getUserSig() {
            return this.f119170a.userSig;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class LocalRecordingParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCLocalRecordingParams f119171a;

        public LocalRecordingParams(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
            this.f119171a = tRTCLocalRecordingParams;
        }

        public String getFilePath() {
            return this.f119171a.filePath;
        }

        public int getInterval() {
            return this.f119171a.interval;
        }

        public int getMaxDurationPerFile() {
            return this.f119171a.maxDurationPerFile;
        }

        public int getRecordType() {
            return this.f119171a.recordType;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class LocalStatistics {

        /* renamed from: a, reason: collision with root package name */
        private TRTCStatistics.TRTCLocalStatistics f119172a = new TRTCStatistics.TRTCLocalStatistics();

        LocalStatistics() {
        }

        public static void addLocalStatistics(LocalStatistics localStatistics, ArrayList<LocalStatistics> arrayList) {
            arrayList.add(localStatistics);
        }

        public static LocalStatistics createLocalStatistics(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            LocalStatistics localStatistics = new LocalStatistics();
            TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics = localStatistics.f119172a;
            tRTCLocalStatistics.streamType = i3;
            tRTCLocalStatistics.width = i16;
            tRTCLocalStatistics.height = i17;
            tRTCLocalStatistics.frameRate = i18;
            tRTCLocalStatistics.videoBitrate = i19;
            tRTCLocalStatistics.audioBitrate = i27;
            tRTCLocalStatistics.audioSampleRate = i26;
            tRTCLocalStatistics.audioCaptureState = i28;
            return localStatistics;
        }

        public static ArrayList<LocalStatistics> createLocalStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class MixUser {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCMixUser f119173a;

        /* synthetic */ MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser, byte b16) {
            this(tRTCMixUser);
        }

        public int getHeight() {
            return this.f119173a.height;
        }

        public String getImage() {
            if (TextUtils.isEmpty(this.f119173a.image)) {
                return "";
            }
            return this.f119173a.image;
        }

        public int getInputType() {
            return this.f119173a.inputType;
        }

        public boolean getPureAudio() {
            return this.f119173a.pureAudio;
        }

        public int getRenderMode() {
            return this.f119173a.renderMode;
        }

        public String getRoomId() {
            if (TextUtils.isEmpty(this.f119173a.roomId)) {
                return "";
            }
            return this.f119173a.roomId;
        }

        public int getSoundLevel() {
            return this.f119173a.soundLevel;
        }

        public int getStreamType() {
            return this.f119173a.streamType;
        }

        public String getUserId() {
            if (TextUtils.isEmpty(this.f119173a.userId)) {
                return "";
            }
            return this.f119173a.userId;
        }

        public int getWidth() {
            return this.f119173a.width;
        }

        public int getX() {
            return this.f119173a.f381674x;
        }

        public int getY() {
            return this.f119173a.f381675y;
        }

        public int getZOrder() {
            return this.f119173a.zOrder;
        }

        MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            this.f119173a = tRTCMixUser;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class PayloadPrivateEncryptionConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig f119174a;

        public PayloadPrivateEncryptionConfig(TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
            this.f119174a = tRTCPayloadPrivateEncryptionConfig;
        }

        public int getEncryptionAlgorithm() {
            return this.f119174a.encryptionAlgorithm;
        }

        public String getEncryptionKey() {
            String str = this.f119174a.encryptionKey;
            if (str != null) {
                return str;
            }
            return "";
        }

        public byte[] getEncryptionSalt() {
            return this.f119174a.encryptionSalt;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class PublishCDNParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCDNParam f119175a;

        public PublishCDNParams(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
            this.f119175a = tRTCPublishCDNParam;
        }

        public int getAppId() {
            return this.f119175a.appId;
        }

        public int getBizId() {
            return this.f119175a.bizId;
        }

        public String getStreamId() {
            if (TextUtils.isEmpty(this.f119175a.streamId)) {
                return "";
            }
            return this.f119175a.streamId;
        }

        public String getUrl() {
            if (TextUtils.isEmpty(this.f119175a.url)) {
                return "";
            }
            return this.f119175a.url;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class PublishCdnUrl {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCdnUrl f119176a;

        public PublishCdnUrl(TRTCCloudDef.TRTCPublishCdnUrl tRTCPublishCdnUrl) {
            this.f119176a = tRTCPublishCdnUrl;
        }

        public boolean getIsInternalLine() {
            return this.f119176a.isInternalLine;
        }

        public String getRtmpUrl() {
            String str = this.f119176a.rtmpUrl;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class PublishTarget {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishTarget f119177a;

        public PublishTarget(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget) {
            this.f119177a = tRTCPublishTarget;
        }

        public int getMode() {
            return this.f119177a.mode;
        }

        public PublishCdnUrl[] getPublishCdnUrls() {
            ArrayList<TRTCCloudDef.TRTCPublishCdnUrl> arrayList = this.f119177a.cdnUrlList;
            if (arrayList == null) {
                return null;
            }
            PublishCdnUrl[] publishCdnUrlArr = new PublishCdnUrl[arrayList.size()];
            for (int i3 = 0; i3 < this.f119177a.cdnUrlList.size(); i3++) {
                publishCdnUrlArr[i3] = new PublishCdnUrl(this.f119177a.cdnUrlList.get(i3));
            }
            return publishCdnUrlArr;
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f119177a.mixStreamIdentity);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class RemoteStatistics {

        /* renamed from: a, reason: collision with root package name */
        public TRTCStatistics.TRTCRemoteStatistics f119178a = new TRTCStatistics.TRTCRemoteStatistics();

        RemoteStatistics() {
        }

        public static void addRemoteStatistics(RemoteStatistics remoteStatistics, ArrayList<RemoteStatistics> arrayList) {
            arrayList.add(remoteStatistics);
        }

        public static RemoteStatistics createRemoteStatistics(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56) {
            RemoteStatistics remoteStatistics = new RemoteStatistics();
            TRTCStatistics.TRTCRemoteStatistics tRTCRemoteStatistics = remoteStatistics.f119178a;
            tRTCRemoteStatistics.userId = str;
            tRTCRemoteStatistics.streamType = i3;
            tRTCRemoteStatistics.width = i16;
            tRTCRemoteStatistics.height = i17;
            tRTCRemoteStatistics.frameRate = i18;
            tRTCRemoteStatistics.audioPacketLoss = i37;
            tRTCRemoteStatistics.videoPacketLoss = i19;
            tRTCRemoteStatistics.videoBlockRate = i28;
            tRTCRemoteStatistics.videoTotalBlockTime = i27;
            tRTCRemoteStatistics.videoBitrate = i26;
            tRTCRemoteStatistics.audioBitrate = i36;
            tRTCRemoteStatistics.audioSampleRate = i29;
            tRTCRemoteStatistics.audioTotalBlockTime = i38;
            tRTCRemoteStatistics.audioBlockRate = i39;
            tRTCRemoteStatistics.jitterBufferDelay = i46;
            tRTCRemoteStatistics.point2PointDelay = i47;
            tRTCRemoteStatistics.finalLoss = i48;
            tRTCRemoteStatistics.remoteNetworkUplinkLoss = i49;
            tRTCRemoteStatistics.remoteNetworkRTT = i56;
            return remoteStatistics;
        }

        public static ArrayList<RemoteStatistics> createRemoteStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class ScreenShareParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCScreenShareParams f119179a;

        public ScreenShareParams(TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
            this.f119179a = tRTCScreenShareParams;
        }

        public Object getMediaProjection() {
            return this.f119179a.mediaProjection;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class SpeedTestResult {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCSpeedTestResult f119182a = new TRTCCloudDef.TRTCSpeedTestResult();

        SpeedTestResult() {
        }

        public static SpeedTestResult createSpeedTestResult(boolean z16, String str, String str2, int i3, float f16, float f17, int i16, int i17, int i18, int i19, int i26) {
            SpeedTestResult speedTestResult = new SpeedTestResult();
            TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult = speedTestResult.f119182a;
            tRTCSpeedTestResult.success = z16;
            tRTCSpeedTestResult.errMsg = str;
            tRTCSpeedTestResult.f381676ip = str2;
            tRTCSpeedTestResult.quality = i3;
            tRTCSpeedTestResult.upLostRate = f16;
            tRTCSpeedTestResult.downLostRate = f17;
            tRTCSpeedTestResult.rtt = i16;
            tRTCSpeedTestResult.availableUpBandwidth = i17;
            tRTCSpeedTestResult.availableDownBandwidth = i18;
            tRTCSpeedTestResult.upJitter = i19;
            tRTCSpeedTestResult.downJitter = i26;
            return speedTestResult;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class Statistics {

        /* renamed from: a, reason: collision with root package name */
        private TRTCStatistics f119183a = new TRTCStatistics();

        Statistics() {
        }

        public static Statistics createStatistics(int i3, int i16, int i17, int i18, int i19, int i26, long j3, long j16, ArrayList<LocalStatistics> arrayList, ArrayList<RemoteStatistics> arrayList2) {
            Statistics statistics = new Statistics();
            TRTCStatistics tRTCStatistics = statistics.f119183a;
            tRTCStatistics.appCpu = i3;
            tRTCStatistics.systemCpu = i16;
            tRTCStatistics.upLoss = i17;
            tRTCStatistics.downLoss = i18;
            tRTCStatistics.rtt = i19;
            tRTCStatistics.gatewayRtt = i26;
            tRTCStatistics.sendBytes = j3;
            tRTCStatistics.receiveBytes = j16;
            tRTCStatistics.localArray = new ArrayList<>();
            statistics.f119183a.remoteArray = new ArrayList<>();
            if (arrayList != null) {
                Iterator<LocalStatistics> it = arrayList.iterator();
                while (it.hasNext()) {
                    statistics.f119183a.localArray.add(it.next().f119172a);
                }
            }
            if (arrayList2 != null) {
                Iterator<RemoteStatistics> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    statistics.f119183a.remoteArray.add(it5.next().f119178a);
                }
            }
            return statistics;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class StreamEncoderParam {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamEncoderParam f119184a;

        public StreamEncoderParam(TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam) {
            this.f119184a = tRTCStreamEncoderParam;
        }

        public int getAudioEncodedChannelNum() {
            return this.f119184a.audioEncodedChannelNum;
        }

        public int getAudioEncodedCodecType() {
            return this.f119184a.audioEncodedCodecType;
        }

        public int getAudioEncodedKbps() {
            return this.f119184a.audioEncodedKbps;
        }

        public int getAudioEncodedSampleRate() {
            return this.f119184a.audioEncodedSampleRate;
        }

        public int getVideoEncodedCodecType() {
            return this.f119184a.videoEncodedCodecType;
        }

        public int getVideoEncodedFPS() {
            return this.f119184a.videoEncodedFPS;
        }

        public int getVideoEncodedGOP() {
            return this.f119184a.videoEncodedGOP;
        }

        public int getVideoEncodedHeight() {
            return this.f119184a.videoEncodedHeight;
        }

        public int getVideoEncodedKbps() {
            return this.f119184a.videoEncodedKbps;
        }

        public int getVideoEncodedWidth() {
            return this.f119184a.videoEncodedWidth;
        }

        public String getVideoSeiParams() {
            if (TextUtils.isEmpty(this.f119184a.videoSeiParams)) {
                return "";
            }
            return this.f119184a.videoSeiParams;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class StreamMixingConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamMixingConfig f119185a;

        public StreamMixingConfig(TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
            this.f119185a = tRTCStreamMixingConfig;
        }

        public TRTCUser[] getAudioMixUserList() {
            ArrayList<TRTCCloudDef.TRTCUser> arrayList = this.f119185a.audioMixUserList;
            if (arrayList == null) {
                return null;
            }
            TRTCUser[] tRTCUserArr = new TRTCUser[arrayList.size()];
            for (int i3 = 0; i3 < this.f119185a.audioMixUserList.size(); i3++) {
                tRTCUserArr[i3] = new TRTCUser(this.f119185a.audioMixUserList.get(i3));
            }
            return tRTCUserArr;
        }

        public int getBackgroundColor() {
            return this.f119185a.backgroundColor;
        }

        public String getBackgroundImage() {
            String str = this.f119185a.backgroundImage;
            if (str != null) {
                return str;
            }
            return "";
        }

        public VideoLayout[] getVideoLayoutList() {
            ArrayList<TRTCCloudDef.TRTCVideoLayout> arrayList = this.f119185a.videoLayoutList;
            if (arrayList == null) {
                return null;
            }
            VideoLayout[] videoLayoutArr = new VideoLayout[arrayList.size()];
            for (int i3 = 0; i3 < this.f119185a.videoLayoutList.size(); i3++) {
                videoLayoutArr[i3] = new VideoLayout(this.f119185a.videoLayoutList.get(i3));
            }
            return videoLayoutArr;
        }

        public Watermark[] getWatermarkList() {
            ArrayList<TRTCCloudDef.TRTCWatermark> arrayList = this.f119185a.watermarkList;
            if (arrayList == null) {
                return null;
            }
            Watermark[] watermarkArr = new Watermark[arrayList.size()];
            for (int i3 = 0; i3 < this.f119185a.watermarkList.size(); i3++) {
                watermarkArr[i3] = new Watermark(this.f119185a.watermarkList.get(i3));
            }
            return watermarkArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class SwitchRoomConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCSwitchRoomConfig f119186a;

        public SwitchRoomConfig(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
            this.f119186a = tRTCSwitchRoomConfig;
        }

        public String getPrivateMapKey() {
            String str = this.f119186a.privateMapKey;
            if (str != null) {
                return str;
            }
            return "";
        }

        public int getRoomId() {
            return this.f119186a.roomId;
        }

        public String getStringRoomId() {
            String str = this.f119186a.strRoomId;
            if (str != null) {
                return str;
            }
            return "";
        }

        public String getUserSig() {
            String str = this.f119186a.userSig;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class TRTCUser {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCUser f119187a;

        public TRTCUser(TRTCCloudDef.TRTCUser tRTCUser) {
            this.f119187a = tRTCUser;
        }

        public int getIntRoomId() {
            return this.f119187a.intRoomId;
        }

        public String getStrRoomId() {
            String str = this.f119187a.strRoomId;
            if (str != null) {
                return str;
            }
            return "";
        }

        public String getUserId() {
            String str = this.f119187a.userId;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class TranscodingConfig {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCTranscodingConfig f119188a;

        public TranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.f119188a = tRTCTranscodingConfig;
        }

        public int getAppId() {
            return this.f119188a.appId;
        }

        public int getAudioBitrate() {
            return this.f119188a.audioBitrate;
        }

        public int getAudioChannels() {
            return this.f119188a.audioChannels;
        }

        public int getAudioSampleRate() {
            return this.f119188a.audioSampleRate;
        }

        public int getBackgroundColor() {
            return this.f119188a.backgroundColor;
        }

        public String getBackgroundImage() {
            if (TextUtils.isEmpty(this.f119188a.backgroundImage)) {
                return "";
            }
            return this.f119188a.backgroundImage;
        }

        public int getBizId() {
            return this.f119188a.bizId;
        }

        public MixUser[] getMixUsers() {
            ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = this.f119188a.mixUsers;
            if (arrayList == null) {
                return null;
            }
            MixUser[] mixUserArr = new MixUser[arrayList.size()];
            byte b16 = 0;
            for (int i3 = 0; i3 < this.f119188a.mixUsers.size(); i3++) {
                mixUserArr[i3] = new MixUser(this.f119188a.mixUsers.get(i3), b16);
            }
            return mixUserArr;
        }

        public int getMode() {
            return this.f119188a.mode;
        }

        public String getStreamId() {
            if (TextUtils.isEmpty(this.f119188a.streamId)) {
                return "";
            }
            return this.f119188a.streamId;
        }

        public int getVideoBitrate() {
            return this.f119188a.videoBitrate;
        }

        public int getVideoFramerate() {
            return this.f119188a.videoFramerate;
        }

        public int getVideoGOP() {
            return this.f119188a.videoGOP;
        }

        public int getVideoHeight() {
            return this.f119188a.videoHeight;
        }

        public String getVideoSeiParams() {
            if (TextUtils.isEmpty(this.f119188a.videoSeiParams)) {
                return "";
            }
            return this.f119188a.videoSeiParams;
        }

        public int getVideoWidth() {
            return this.f119188a.videoWidth;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class VideoEncParams {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoEncParam f119189a;

        public VideoEncParams(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
            this.f119189a = tRTCVideoEncParam;
        }

        public int getMinVideoBitrate() {
            return this.f119189a.minVideoBitrate;
        }

        public int getVideoBitrate() {
            return this.f119189a.videoBitrate;
        }

        public int getVideoFps() {
            return this.f119189a.videoFps;
        }

        public int getVideoResolution() {
            return this.f119189a.videoResolution;
        }

        public int getVideoResolutionMode() {
            return this.f119189a.videoResolutionMode;
        }

        public boolean isEnableAdjustRes() {
            return this.f119189a.enableAdjustRes;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class VideoLayout {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoLayout f119190a;

        public VideoLayout(TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout) {
            this.f119190a = tRTCVideoLayout;
        }

        public int getBackgroundColor() {
            return this.f119190a.backgroundColor;
        }

        public int getFillMode() {
            return this.f119190a.fillMode;
        }

        public int getHeight() {
            return this.f119190a.height;
        }

        public String getPlaceHolderImage() {
            String str = this.f119190a.placeHolderImage;
            if (str != null) {
                return str;
            }
            return "";
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f119190a.fixedVideoUser);
        }

        public int getVideoStreamType() {
            return this.f119190a.fixedVideoStreamType;
        }

        public int getWidth() {
            return this.f119190a.width;
        }

        public int getX() {
            return this.f119190a.f381677x;
        }

        public int getY() {
            return this.f119190a.f381678y;
        }

        public int getZOrder() {
            return this.f119190a.zOrder;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class Watermark {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCWatermark f119191a;

        public Watermark(TRTCCloudDef.TRTCWatermark tRTCWatermark) {
            this.f119191a = tRTCWatermark;
        }

        public int getHeight() {
            return this.f119191a.height;
        }

        public String getWatermarkUrl() {
            String str = this.f119191a.watermarkUrl;
            if (str != null) {
                return str;
            }
            return "";
        }

        public int getWidth() {
            return this.f119191a.width;
        }

        public int getX() {
            return this.f119191a.f381679x;
        }

        public int getY() {
            return this.f119191a.f381680y;
        }

        public int getZOrder() {
            return this.f119191a.zOrder;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f119192a;

        /* renamed from: b, reason: collision with root package name */
        public int f119193b;

        /* renamed from: c, reason: collision with root package name */
        public int f119194c;

        /* renamed from: d, reason: collision with root package name */
        public T f119195d;

        a() {
        }

        /* synthetic */ a(byte b16) {
            this();
        }
    }

    static {
        SoLoader.loadAllLibraries();
    }

    public TrtcCloudJni(boolean z16) {
        this(0L, z16);
    }

    private List<TRTCCloudListener> CopyOnReadListeners() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.mListenerList);
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null && !copyOnWriteArrayList.contains(tRTCCloudListener)) {
            copyOnWriteArrayList.add(tRTCCloudListener);
        }
        return copyOnWriteArrayList;
    }

    private static int convertPixelFrameRotationToTRTCVideoRotation(k kVar) {
        int i3 = AnonymousClass1.f119166a[kVar.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    return 0;
                }
            }
        }
        return i16;
    }

    private static k covertTRTCVideoRotationToPixelFrameRotation(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_270;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_90;
    }

    public static Bundle createExtraInfoBundle(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i3);
        return bundle;
    }

    private Bundle extraToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object obj = jSONObject.get(str2);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    String[] strArr = new String[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        strArr[i3] = jSONArray.getString(i3);
                    }
                    bundle.putStringArray(str2, strArr);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return bundle;
    }

    public static long getGLContextNativeHandle(Object obj) {
        return TRTCDefConverter.getGLContextNativeHandle(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingWindow() {
        WindowManager windowManager;
        if (this.mFloatingWindowSet.isEmpty()) {
            return;
        }
        Iterator<View> it = this.mFloatingWindowSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next != null && (windowManager = (WindowManager) next.getContext().getSystemService("window")) != null) {
                windowManager.removeViewImmediate(next);
            }
        }
        this.mFloatingWindowSet.clear();
    }

    public static void init(int i3) {
        synchronized (INIT_LOCK) {
            if (!mHasInited) {
                mHasInited = true;
                nativeGlobalInit(i3);
            }
        }
    }

    private static boolean isCustomPreprocessSupportedBufferType(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    private static boolean isCustomPreprocessSupportedFormatType(int i3) {
        if (i3 == 1 || i3 == 4 || i3 == 5 || i3 == 2) {
            return true;
        }
        return false;
    }

    private static boolean isCustomRenderSupportedBufferType(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    private static boolean isCustomRenderSupportedFormatType(int i3) {
        if (i3 == 1 || i3 == 4 || i3 == 5 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean isInUIThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$enterRoom$0(TrtcCloudJni trtcCloudJni) {
        trtcCloudJni.onEnterRoom(-3316);
        trtcCloudJni.onError(-3316, "enter room param null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onSnapshotComplete$2(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        if (tRTCSnapshotListener != null) {
            tRTCSnapshotListener.onSnapshotComplete(bitmap);
        }
    }

    private static native String nativeCallExperimentalAPI(long j3, String str);

    private static native void nativeConnectOtherRoom(long j3, String str);

    private static native long nativeCreateAudioEffectManager(long j3);

    private static native long nativeCreateBeautyManager(long j3);

    private static native long nativeCreateDeviceManager(long j3);

    private static native long nativeCreatePipeline(TrtcCloudJni trtcCloudJni, boolean z16);

    private static native long nativeCreateSubCloud(TrtcCloudJni trtcCloudJni, long j3);

    private static native void nativeDestroyPipeline(long j3);

    private static native void nativeDisconnectOtherRoom(long j3);

    private static native void nativeEnable3DSpatialAudioEffect(long j3, boolean z16);

    private static native void nativeEnableAudioFrameNotification(long j3, boolean z16);

    private static native void nativeEnableAudioVolumeEvaluation(long j3, boolean z16, int i3, boolean z17, boolean z18, boolean z19);

    private static native void nativeEnableCustomAudioCapture(long j3, boolean z16);

    private static native void nativeEnableCustomAudioRendering(long j3, boolean z16);

    private static native void nativeEnableCustomVideoCapture(long j3, int i3, boolean z16);

    private static native void nativeEnableEncSmallVideoStream(long j3, boolean z16, VideoEncParams videoEncParams);

    private static native void nativeEnableMixExternalAudioFrame(long j3, boolean z16, boolean z17);

    private static native int nativeEnablePayloadPrivateEncryption(long j3, boolean z16, PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig);

    private static native void nativeEnableVideoCustomPreprocess(long j3, boolean z16, int i3, int i16, int i17);

    private static native void nativeEnableVideoCustomRender(long j3, boolean z16, String str, int i3, int i16, int i17);

    private static native void nativeEnterRoom(long j3, EnterRoomParams enterRoomParams, int i3);

    private static native void nativeExitRoom(long j3);

    private static native int nativeGetAudioCaptureVolume(long j3);

    private static native int nativeGetAudioPlayoutVolume(long j3);

    private static native void nativeGetCustomAudioRenderingFrame(long j3, byte[] bArr, int i3, int i16);

    private static native void nativeGlobalInit(int i3);

    private static native void nativeGlobalUninit();

    private static native int nativeMixExternalAudioFrame(long j3, AudioFrame audioFrame);

    private static native void nativeMuteAllRemoteAudio(long j3, boolean z16);

    private static native void nativeMuteAllRemoteVideoStreams(long j3, boolean z16);

    private static native void nativeMuteLocalAudio(long j3, boolean z16);

    private static native void nativeMuteLocalVideo(long j3, int i3, boolean z16);

    private static native void nativeMuteRemoteAudio(long j3, String str, boolean z16);

    private static native void nativeMuteRemoteVideoStream(long j3, String str, int i3, boolean z16);

    private static native void nativePauseScreenCapture(long j3, int i3);

    private static native void nativeResumeScreenCapture(long j3, int i3);

    private static native void nativeSendCustomAudioData(long j3, AudioFrame audioFrame);

    private static native boolean nativeSendCustomCmdMsg(long j3, int i3, byte[] bArr, boolean z16, boolean z17);

    private static native void nativeSendCustomVideoData(long j3, int i3, int i16, int i17, Object obj, int i18, int i19, int i26, int i27, long j16, byte[] bArr, ByteBuffer byteBuffer);

    private static native boolean nativeSendSEIMsg(long j3, byte[] bArr, int i3);

    private static native void nativeSet3DSpatialReceivingRange(long j3, String str, int i3);

    private static native void nativeSetAudioCaptureVolume(long j3, int i3);

    private static native void nativeSetAudioPlayoutVolume(long j3, int i3);

    private static native void nativeSetAudioQuality(long j3, int i3);

    private static native int nativeSetCapturedAudioFrameCallbackFormat(long j3, int i3, int i16, int i17, int i18);

    private static native void nativeSetConsoleEnabled(boolean z16);

    private static native void nativeSetDefaultStreamRecvMode(long j3, boolean z16, boolean z17);

    private static native void nativeSetGSensorMode(long j3, int i3, int i16);

    private static native void nativeSetGravitySensorAdaptiveMode(long j3, int i3);

    private static native void nativeSetListenerHandler(long j3, Handler handler);

    private static native int nativeSetLocalProcessedAudioFrameCallbackFormat(long j3, int i3, int i16, int i17, int i18);

    private static native void nativeSetLocalViewFillMode(long j3, int i3);

    private static native void nativeSetLocalViewMirror(long j3, int i3);

    private static native void nativeSetLocalViewRotation(long j3, int i3);

    private static native void nativeSetLogCompressEnabled(boolean z16);

    private static native void nativeSetLogLevel(int i3);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetMixExternalAudioVolume(long j3, int i3, int i16);

    private static native void nativeSetMixTranscodingConfig(long j3, TranscodingConfig transcodingConfig);

    private static native int nativeSetMixedPlayAudioFrameCallbackFormat(long j3, int i3, int i16, int i17, int i18);

    private static native void nativeSetNetworkQosParam(long j3, int i3, int i16);

    private static native void nativeSetPerspectiveCorrectionPoints(long j3, String str, float[] fArr, float[] fArr2);

    private static native void nativeSetPriorRemoteVideoStreamType(long j3, int i3);

    private static native void nativeSetRemoteAudioParallelParams(long j3, AudioParallelParams audioParallelParams);

    private static native void nativeSetRemoteAudioVolume(long j3, String str, int i3);

    private static native void nativeSetRemoteVideoStreamType(long j3, String str, int i3);

    private static native void nativeSetRemoteViewFillMode(long j3, String str, int i3, int i16);

    private static native void nativeSetRemoteViewMirror(long j3, String str, int i3, int i16);

    private static native void nativeSetRemoteViewRotation(long j3, String str, int i3, int i16);

    private static native void nativeSetVideoEncoderMirror(long j3, boolean z16);

    private static native void nativeSetVideoEncoderParams(long j3, int i3, VideoEncParams videoEncParams);

    private static native void nativeSetVideoEncoderRotation(long j3, int i3);

    private static native void nativeSetVideoMuteImage(long j3, Bitmap bitmap, int i3);

    private static native void nativeSetWatermark(long j3, Bitmap bitmap, int i3, float f16, float f17, float f18);

    private static native void nativeShowDashboardManager(long j3, int i3);

    private static native void nativeSnapshotVideo(long j3, String str, int i3, int i16, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    private static native int nativeStartAudioRecording(long j3, AudioRecordingParams audioRecordingParams);

    private static native void nativeStartLocalAudio(long j3);

    private static native void nativeStartLocalAudioWithQuality(long j3, int i3);

    private static native void nativeStartLocalPreview(long j3, boolean z16, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartLocalRecording(long j3, LocalRecordingParams localRecordingParams);

    private static native void nativeStartPublishCDNStream(long j3, PublishCDNParams publishCDNParams);

    private static native void nativeStartPublishMediaStream(long j3, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeStartPublishing(long j3, String str, int i3);

    private static native void nativeStartRemoteView(long j3, String str, int i3, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartRemoteViewWithoutStreamType(long j3, String str, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartScreenCapture(long j3, int i3, VideoEncParams videoEncParams, ScreenShareParams screenShareParams);

    private static native void nativeStartSpeedTest(long j3, SpeedTestParams speedTestParams);

    private static native void nativeStartSystemAudioLoopback(long j3);

    private static native void nativeStopAllRemoteView(long j3);

    private static native void nativeStopAudioRecording(long j3);

    private static native void nativeStopLocalAudio(long j3);

    private static native void nativeStopLocalPreview(long j3);

    private static native void nativeStopLocalRecording(long j3);

    private static native void nativeStopPublishCDNStream(long j3);

    private static native void nativeStopPublishMediaStream(long j3, String str);

    private static native void nativeStopPublishing(long j3);

    private static native void nativeStopRemoteView(long j3, String str, int i3);

    private static native void nativeStopRemoteViewWithoutStreamType(long j3, String str);

    private static native void nativeStopScreenCapture(long j3, int i3);

    private static native void nativeStopSpeedTest(long j3);

    private static native void nativeStopSystemAudioLoopback(long j3);

    private static native void nativeSwitchRole(long j3, int i3);

    private static native void nativeSwitchRoleWithPrivateMapKey(long j3, int i3, String str);

    private static native void nativeSwitchRoom(long j3, SwitchRoomConfig switchRoomConfig);

    private static native void nativeUpdateLocalView(long j3, TXCloudVideoView tXCloudVideoView);

    private static native void nativeUpdateOtherRoomForwardMode(long j3, String str);

    private static native void nativeUpdatePublishMediaStream(long j3, String str, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeUpdateRemote3DSpatialPosition(long j3, String str, int[] iArr);

    private static native void nativeUpdateRemoteView(long j3, String str, int i3, TXCloudVideoView tXCloudVideoView);

    private static native void nativeUpdateSelf3DSpatialPosition(long j3, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);

    private void runOnListenerThread(Runnable runnable) {
        Handler handler = this.mListenerHandler;
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void setConsoleEnabled(boolean z16) {
        nativeSetConsoleEnabled(z16);
    }

    public static void setLogCompressEnabled(boolean z16) {
        nativeSetLogCompressEnabled(z16);
    }

    public static void setLogDirPath(String str) {
        nativeSetLogPath(str);
    }

    public static void setLogLevel(int i3) {
        nativeSetLogLevel(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingWindow(View view) {
        int i3;
        if (view == null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && !Settings.canDrawOverlays(view.getContext())) {
            LiteavLog.e(TAG, "can't show floating window for no drawing overlay permission");
            return;
        }
        if (this.mFloatingWindowSet.contains(view)) {
            LiteavLog.i(TAG, "the window has been added");
            return;
        }
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            LiteavLog.e(TAG, "get windowManager error");
            return;
        }
        this.mFloatingWindowSet.add(view);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            i3 = 2038;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() > 24) {
            i3 = 2002;
        } else {
            i3 = 2005;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i3);
        layoutParams.flags = 8 | 262144;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        windowManager.addView(view, layoutParams);
    }

    public static void uninit() {
        synchronized (INIT_LOCK) {
            if (mHasInited) {
                mHasInited = false;
                nativeGlobalUninit();
            }
        }
    }

    public void addListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && !this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.add(tRTCCloudListener);
        }
    }

    public String callExperimentalAPI(String str) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                return nativeCallExperimentalAPI(j3, str);
            }
            this.mJniReadLock.unlock();
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void connectOtherRoom(String str) {
        long j3 = this.mNativeTrtcCloudJni;
        if (j3 != 0) {
            nativeConnectOtherRoom(j3, str);
        }
    }

    public long createAudioEffectManager() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            long j16 = 0;
            if (j3 != 0) {
                j16 = nativeCreateAudioEffectManager(j3);
            }
            return j16;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public long createBeautyManager() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            long j16 = 0;
            if (j3 != 0) {
                j16 = nativeCreateBeautyManager(j3);
            }
            return j16;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ByteBuffer createByteBuffer(int i3) {
        return ByteBuffer.allocateDirect(i3);
    }

    public long createDeviceManager() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            long j16 = 0;
            if (j3 != 0) {
                j16 = nativeCreateDeviceManager(j3);
            }
            return j16;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TRTCCloudDef.TRTCVideoFrame createTRTCVideoFrame(int i3, int i16, Object obj, int i17, int i18, int i19, int i26, long j3, byte[] bArr, ByteBuffer byteBuffer) {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        tRTCVideoFrame.pixelFormat = i3;
        tRTCVideoFrame.bufferType = i16;
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = i17;
        if (obj instanceof EGLContext) {
            tRTCTexture.eglContext10 = (EGLContext) obj;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        tRTCVideoFrame.data = bArr;
        tRTCVideoFrame.buffer = byteBuffer;
        tRTCVideoFrame.width = i18;
        tRTCVideoFrame.height = i19;
        tRTCVideoFrame.timestamp = j3;
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(k.a(i26));
        return tRTCVideoFrame;
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeDestroyPipeline(j3);
                this.mNativeTrtcCloudJni = 0L;
            }
            this.mListenerList.clear();
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    public void disconnectOtherRoom() {
        long j3 = this.mNativeTrtcCloudJni;
        if (j3 != 0) {
            nativeDisconnectOtherRoom(j3);
        }
    }

    public void enable3DSpatialAudioEffect(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnable3DSpatialAudioEffect(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableAudioVolumeEvaluation(boolean z16, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnableAudioVolumeEvaluation(j3, z16, tRTCAudioVolumeEvaluateParams.interval, tRTCAudioVolumeEvaluateParams.enableVadDetection, tRTCAudioVolumeEvaluateParams.enablePitchCalculation, tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioCapture(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnableCustomAudioCapture(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioRendering(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnableCustomAudioRendering(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomVideoCapture(int i3, boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnableCustomVideoCapture(j3, i3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enableEncSmallVideoStream(boolean z16, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        VideoEncParams videoEncParams;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                if (tRTCVideoEncParam == null) {
                    videoEncParams = null;
                } else {
                    videoEncParams = new VideoEncParams(tRTCVideoEncParam);
                }
                nativeEnableEncSmallVideoStream(j3, z16, videoEncParams);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th5) {
            this.mJniReadLock.unlock();
            throw th5;
        }
    }

    public void enableMixExternalAudioFrame(boolean z16, boolean z17) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnableMixExternalAudioFrame(j3, z16, z17);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enablePayloadPrivateEncryption(boolean z16, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        int i3;
        PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                if (tRTCPayloadPrivateEncryptionConfig == null) {
                    payloadPrivateEncryptionConfig = null;
                } else {
                    payloadPrivateEncryptionConfig = new PayloadPrivateEncryptionConfig(tRTCPayloadPrivateEncryptionConfig);
                }
                i3 = nativeEnablePayloadPrivateEncryption(j3, z16, payloadPrivateEncryptionConfig);
            } else {
                i3 = -1;
            }
            return i3;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i3) {
        if (tRTCParams == null) {
            LiteavLog.e(TAG, "enterRoom param is null");
            runOnListenerThread(com.tencent.liteav.trtc.a.a(this));
            return;
        }
        this.mJniReadLock.lock();
        try {
            this.mLocalUserId = tRTCParams.userId;
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeEnterRoom(j3, new EnterRoomParams(tRTCParams), i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void exitRoom() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeExitRoom(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioCaptureVolume() {
        int i3;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                i3 = nativeGetAudioCaptureVolume(j3);
            } else {
                i3 = 0;
            }
            return i3;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioPlayoutVolume() {
        int i3;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                i3 = nativeGetAudioPlayoutVolume(j3);
            } else {
                i3 = 0;
            }
            return i3;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeGetCustomAudioRenderingFrame(j3, tRTCAudioFrame.data, tRTCAudioFrame.sampleRate, tRTCAudioFrame.channel);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getFrameBufferType(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.bufferType;
    }

    public byte[] getFrameByteArray(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.data;
    }

    public ByteBuffer getFrameByteBuffer(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.buffer;
    }

    public Object getFrameEglContext(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return tRTCVideoFrame.texture.eglContext14;
        }
        return tRTCVideoFrame.texture.eglContext10;
    }

    public int getFrameHeight(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.height;
    }

    public int getFramePixelFormat(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.pixelFormat;
    }

    public long getFramePts(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.timestamp;
    }

    public int getFrameRotation(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue;
    }

    public int getFrameTextureId(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.texture.textureId;
    }

    public int getFrameWidth(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.width;
    }

    public long getTrtcCloudJni() {
        this.mJniReadLock.lock();
        try {
            return this.mNativeTrtcCloudJni;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                return nativeMixExternalAudioFrame(j3, new AudioFrame(tRTCAudioFrame));
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteAudio(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteAllRemoteAudio(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteVideoStreams(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteAllRemoteVideoStreams(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalAudio(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteLocalAudio(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalVideo(int i3, boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteLocalVideo(j3, i3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteAudio(String str, boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteRemoteAudio(j3, str, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteVideoStream(String str, int i3, boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeMuteRemoteVideoStream(j3, str, i3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void onAudioCaptureProcessedData(byte[] bArr, long j3, int i3, int i16) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j3;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrameListener.onCapturedAudioFrame(tRTCAudioFrame);
    }

    public void onAudioMixedAllData(byte[] bArr, int i3, int i16) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrameListener.onMixedAllAudioFrame(tRTCAudioFrame);
    }

    public void onAudioPlayoutData(byte[] bArr, long j3, int i3, int i16) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j3;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
    }

    public void onAudioRemoteStreamData(String str, byte[] bArr, long j3, int i3, int i16, byte[] bArr2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j3;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrame.extraData = bArr2;
        tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, str);
    }

    public void onAudioRouteChanged(int i3, int i16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onAudioRouteChanged(i3, i16);
        }
    }

    void onCameraDidReady() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onCameraDidReady();
        }
    }

    public void onCdnStreamStateChanged(String str, int i3, int i16, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onCdnStreamStateChanged(str, i3, i16, str2, null);
        }
    }

    public void onConnectOtherRoom(String str, int i3, String str2) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectOtherRoom(str, i3, str2);
        }
    }

    void onConnectionLost() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectionLost();
        }
    }

    void onConnectionRecovery() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectionRecovery();
        }
    }

    public void onDisConnectOtherRoom(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onDisConnectOtherRoom(i3, str);
        }
    }

    public void onEarMonitoringData(byte[] bArr, int i3, int i16) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrameListener.onVoiceEarMonitorAudioFrame(tRTCAudioFrame);
    }

    public void onEnterRoom(int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onEnterRoom(i3);
        }
    }

    public void onError(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onError(i3, str, null);
        }
    }

    public void onExitRoom(int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onExitRoom(i3);
        }
        synchronized (this.mLocalVideoRenderListenerWrapper) {
            this.mLocalVideoRenderListenerWrapper.f119195d = null;
        }
        synchronized (this.mRemoteVideoRenderListenerMap) {
            this.mRemoteVideoRenderListenerMap.clear();
        }
    }

    void onFirstAudioFrame(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onFirstAudioFrame(str);
        }
    }

    void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onFirstVideoFrame(str, i3, i16, i17);
        }
    }

    public void onGLContextCreated() {
        synchronized (this.mVideoFrameListenerWrapper) {
            this.mCalledGLCreatedFrameListener = this.mVideoFrameListenerWrapper.f119195d;
        }
        LiteavLog.i(TAG, "onGLContextCreated " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextCreated();
        }
    }

    public void onGLContextDestroy() {
        LiteavLog.i(TAG, "onGLContextDestroy " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextDestory();
            this.mCalledGLCreatedFrameListener = null;
        }
    }

    public byte[] onLocalAudioStreamData(byte[] bArr, long j3, int i3, int i16) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return null;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j3;
        tRTCAudioFrame.sampleRate = i3;
        tRTCAudioFrame.channel = i16;
        tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        byte[] bArr2 = tRTCAudioFrame.extraData;
        if (bArr2 == null) {
            return null;
        }
        if (bArr2.length > 100) {
            LiteavLog.w(TAG, "Audioframe.extraData length need to be under 100!");
            return null;
        }
        return bArr2;
    }

    public void onLocalRecordBegin(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordBegin(i3, str);
        }
    }

    public void onLocalRecordComplete(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordComplete(i3, str);
        }
    }

    public void onLocalRecordFragment(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordFragment(str);
        }
    }

    public void onLocalRecording(long j3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecording(j3, str);
        }
    }

    void onMicDidReady() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onMicDidReady();
        }
    }

    public void onMissCustomCmdMsg(String str, int i3, int i16, int i17) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onMissCustomCmdMsg(str, i3, i16, i17);
        }
    }

    public void onNetworkQuality(int i3, String[] strArr, int[] iArr) {
        if (CopyOnReadListeners().size() == 0) {
            return;
        }
        TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
        tRTCQuality.userId = "";
        tRTCQuality.quality = i3;
        ArrayList<TRTCCloudDef.TRTCQuality> arrayList = new ArrayList<>();
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0 && iArr.length == strArr.length) {
            for (int i16 = 0; i16 < strArr.length; i16++) {
                TRTCCloudDef.TRTCQuality tRTCQuality2 = new TRTCCloudDef.TRTCQuality();
                tRTCQuality2.userId = strArr[i16];
                tRTCQuality2.quality = iArr[i16];
                arrayList.add(tRTCQuality2);
            }
        }
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onNetworkQuality(tRTCQuality, arrayList);
        }
    }

    public void onPreprocessVideoFrame(int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null && tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onProcessVideoFrame(tRTCVideoFrame, tRTCVideoFrame2);
        }
    }

    public void onRecvCustomCmdMsg(String str, int i3, int i16, byte[] bArr) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRecvCustomCmdMsg(str, i3, i16, bArr);
        }
    }

    public void onRemoteAudioStatusUpdated(String str, int i3, int i16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteAudioStatusUpdated(str, i3, i16, null);
        }
    }

    public void onRemoteVideoStatusUpdated(String str, int i3, int i16, int i17) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteVideoStatusUpdated(str, i3, i16, i17, null);
        }
    }

    public void onRenderVideoFrame(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mLocalUserId;
            tRTCVideoRenderListener = this.mLocalVideoRenderListenerWrapper.f119195d;
        } else {
            a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
            if (aVar == null) {
                tRTCVideoRenderListener = null;
            } else {
                tRTCVideoRenderListener = aVar.f119195d;
            }
        }
        if (tRTCVideoRenderListener != null) {
            tRTCVideoRenderListener.onRenderVideoFrame(str, i3, tRTCVideoFrame);
        }
    }

    public void onSEIMessageReceived(byte[] bArr, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRecvSEIMsg(str, bArr);
        }
    }

    void onScreenCapturePaused() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCapturePaused();
        }
    }

    void onScreenCaptureResumed() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureResumed();
        }
    }

    void onScreenCaptureStarted() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureStarted();
        }
    }

    void onScreenCaptureStopped(int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureStopped(i3);
        }
    }

    void onSendFirstLocalAudioFrame() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSendFirstLocalAudioFrame();
        }
    }

    void onSendFirstLocalVideoFrame(int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSendFirstLocalVideoFrame(i3);
        }
    }

    void onSetMixTranscodingConfig(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSetMixTranscodingConfig(i3, str);
        }
    }

    public void onSnapshotComplete(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        runOnListenerThread(d.a(tRTCSnapshotListener, bitmap));
    }

    public void onSpeedTest(SpeedTestResult speedTestResult, int i3, int i16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSpeedTest(speedTestResult.f119182a, i3, i16);
        }
    }

    public void onSpeedTestResult(SpeedTestResult speedTestResult) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSpeedTestResult(speedTestResult.f119182a);
        }
    }

    void onStartPublishCDNStream(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishCDNStream(i3, str);
        }
    }

    public void onStartPublishMediaStream(String str, int i3, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishMediaStream(str, i3, str2, extraToBundle(str3));
        }
    }

    void onStartPublishing(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishing(i3, str);
        }
    }

    public void onStatistics(Statistics statistics) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStatistics(statistics.f119183a);
        }
    }

    void onStopPublishCDNStream(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishCDNStream(i3, str);
        }
    }

    public void onStopPublishMediaStream(String str, int i3, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishMediaStream(str, i3, str2, extraToBundle(str3));
        }
    }

    void onStopPublishing(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishing(i3, str);
        }
    }

    public void onSwitchRole(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSwitchRole(i3, str);
        }
    }

    public void onSwitchRoom(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSwitchRoom(i3, str);
        }
    }

    void onTryToReconnect() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onTryToReconnect();
        }
    }

    public void onUpdateOtherRoomForwardMode(int i3, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUpdateOtherRoomForwardMode(i3, str);
        }
    }

    public void onUpdatePublishMediaStream(String str, int i3, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUpdatePublishMediaStream(str, i3, str2, extraToBundle(str3));
        }
    }

    void onUserAudioAvailable(String str, boolean z16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserAudioAvailable(str, z16);
        }
    }

    public void onUserEnter(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserEnter(str);
        }
    }

    public void onUserExit(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserExit(str, 0);
        }
    }

    public void onUserOffline(String str, int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserLeaveRoom(str, i3);
        }
    }

    public void onUserOnline(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserEnterRoom(str);
        }
    }

    void onUserSubStreamAvailable(String str, boolean z16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserSubStreamAvailable(str, z16);
        }
    }

    void onUserVideoAvailable(String str, boolean z16) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserVideoAvailable(str, z16);
        }
    }

    public void onUserVideoSizeChanged(String str, int i3, int i16, int i17) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserVideoSizeChanged(str, i3, i16, i17);
        }
    }

    public void onUserVoiceVolume(String[] strArr, int[] iArr, int[] iArr2, float[] fArr, float[][] fArr2, int i3) {
        String str;
        if (strArr != null && iArr != null) {
            if (strArr.length == iArr.length) {
                ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList = new ArrayList<>();
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                    if (strArr[i16].isEmpty() && (str = this.mLocalUserId) != null && !str.isEmpty()) {
                        tRTCVolumeInfo.userId = this.mLocalUserId;
                    } else {
                        tRTCVolumeInfo.userId = strArr[i16];
                    }
                    tRTCVolumeInfo.volume = iArr[i16];
                    tRTCVolumeInfo.vad = iArr2[i16];
                    tRTCVolumeInfo.pitch = fArr[i16];
                    tRTCVolumeInfo.spectrumData = fArr2[i16];
                    arrayList.add(tRTCVolumeInfo);
                }
                Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
                while (it.hasNext()) {
                    it.next().onUserVoiceVolume(arrayList, i3);
                }
                return;
            }
            throw new IllegalArgumentException("Invalid parameter, userIds and volumes do not match.");
        }
    }

    public void onWarning(int i3, String str, Bundle bundle) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onWarning(i3, str, bundle);
        }
    }

    public void pauseScreenCapture(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativePauseScreenCapture(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.remove(tRTCCloudListener);
        }
    }

    public void resumeScreenCapture(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeResumeScreenCapture(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSendCustomAudioData(j3, new AudioFrame(tRTCAudioFrame));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendCustomCmdMsg(int i3, byte[] bArr, boolean z16, boolean z17) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                return nativeSendCustomCmdMsg(j3, i3, bArr, z16, z17);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomVideoData(int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        int i16;
        Object obj;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
                if (tRTCTexture != null) {
                    int i17 = tRTCTexture.textureId;
                    Object obj2 = tRTCTexture.eglContext10;
                    if (obj2 == null) {
                        obj2 = tRTCTexture.eglContext14;
                    }
                    i16 = i17;
                    obj = obj2;
                } else {
                    i16 = -1;
                    obj = null;
                }
                nativeSendCustomVideoData(j3, i3, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.bufferType, obj, i16, tRTCVideoFrame.width, tRTCVideoFrame.height, covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue, tRTCVideoFrame.timestamp, tRTCVideoFrame.data, tRTCVideoFrame.buffer);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendSEIMsg(byte[] bArr, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                return nativeSendSEIMsg(j3, bArr, i3);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void set3DSpatialReceivingRange(String str, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSet3DSpatialReceivingRange(j3, str, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioCaptureVolume(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetAudioCaptureVolume(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        boolean z16;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                this.mAudioFrameListener = tRTCAudioFrameListener;
                if (tRTCAudioFrameListener != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                nativeEnableAudioFrameNotification(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioPlayoutVolume(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetAudioPlayoutVolume(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioQuality(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetAudioQuality(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setCapturedAudioFrameCallbackFormat(int i3, int i16, int i17, int i18) {
        int i19;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                i19 = nativeSetCapturedAudioFrameCallbackFormat(j3, i3, i16, i17, i18);
            } else {
                i19 = 0;
            }
            return i19;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setDefaultStreamRecvMode(boolean z16, boolean z17) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetDefaultStreamRecvMode(j3, z16, z17);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGSensorMode(int i3, int i16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetGSensorMode(j3, i3, i16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGravitySensorAdaptiveMode(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetGravitySensorAdaptiveMode(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        this.mListener = tRTCCloudListener;
    }

    public void setListenerHandler(Handler handler) {
        this.mJniReadLock.lock();
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetListenerHandler(j3, handler);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalProcessedAudioFrameCallbackFormat(int i3, int i16, int i17, int i18) {
        int i19;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                i19 = nativeSetLocalProcessedAudioFrameCallbackFormat(j3, i3, i16, i17, i18);
            } else {
                i19 = 0;
            }
            return i19;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoProcessListener(int i3, int i16, int i17, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (!isCustomPreprocessSupportedFormatType(i16)) {
                    this.mJniReadLock.unlock();
                    return -1327;
                }
                if (!isCustomPreprocessSupportedBufferType(i17)) {
                    this.mJniReadLock.unlock();
                    return -1328;
                }
                synchronized (this.mVideoFrameListenerWrapper) {
                    a<TRTCCloudListener.TRTCVideoFrameListener> aVar = this.mVideoFrameListenerWrapper;
                    if (aVar.f119195d != null) {
                        nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, false, aVar.f119192a, aVar.f119193b, aVar.f119194c);
                    }
                    a<TRTCCloudListener.TRTCVideoFrameListener> aVar2 = this.mVideoFrameListenerWrapper;
                    aVar2.f119195d = tRTCVideoFrameListener;
                    aVar2.f119192a = i3;
                    aVar2.f119193b = i16;
                    aVar2.f119194c = i17;
                    if (tRTCVideoFrameListener != 0) {
                        nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, true, i3, i16, i17);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoRenderListener(int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z16;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (!isCustomRenderSupportedFormatType(i3)) {
                    this.mJniReadLock.unlock();
                    return -1327;
                }
                if (!isCustomRenderSupportedBufferType(i16)) {
                    this.mJniReadLock.unlock();
                    return -1328;
                }
                synchronized (this.mLocalVideoRenderListenerWrapper) {
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mLocalVideoRenderListenerWrapper;
                    if (aVar.f119195d != null) {
                        int i17 = aVar.f119193b;
                        if (i17 == i3 && aVar.f119194c == i16) {
                            z16 = false;
                            if (!z16 && tRTCVideoRenderListener != 0) {
                                aVar.f119195d = tRTCVideoRenderListener;
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, i17, aVar.f119194c);
                            long j3 = this.mNativeTrtcCloudJni;
                            a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = this.mLocalVideoRenderListenerWrapper;
                            nativeEnableVideoCustomRender(j3, false, "", 2, aVar2.f119193b, aVar2.f119194c);
                        }
                        z16 = true;
                        if (!z16) {
                            aVar.f119195d = tRTCVideoRenderListener;
                        }
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, i17, aVar.f119194c);
                        long j36 = this.mNativeTrtcCloudJni;
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar22 = this.mLocalVideoRenderListenerWrapper;
                        nativeEnableVideoCustomRender(j36, false, "", 2, aVar22.f119193b, aVar22.f119194c);
                    }
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar3 = this.mLocalVideoRenderListenerWrapper;
                    aVar3.f119195d = tRTCVideoRenderListener;
                    aVar3.f119193b = i3;
                    aVar3.f119194c = i16;
                    if (tRTCVideoRenderListener != 0) {
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 0, i3, i16);
                        long j16 = this.mNativeTrtcCloudJni;
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar4 = this.mLocalVideoRenderListenerWrapper;
                        nativeEnableVideoCustomRender(j16, true, "", 2, aVar4.f119193b, aVar4.f119194c);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewFillMode(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetLocalViewFillMode(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewMirror(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetLocalViewMirror(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewRotation(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetLocalViewRotation(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixExternalAudioVolume(int i3, int i16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetMixExternalAudioVolume(j3, i3, i16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        TranscodingConfig transcodingConfig;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                if (tRTCTranscodingConfig == null) {
                    transcodingConfig = null;
                } else {
                    transcodingConfig = new TranscodingConfig(tRTCTranscodingConfig);
                }
                nativeSetMixTranscodingConfig(j3, transcodingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setMixedPlayAudioFrameCallbackFormat(int i3, int i16, int i17, int i18) {
        int i19;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                i19 = nativeSetMixedPlayAudioFrameCallbackFormat(j3, i3, i16, i17, i18);
            } else {
                i19 = 0;
            }
            return i19;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetNetworkQosParam(j3, tRTCNetworkQosParam.preference, tRTCNetworkQosParam.controlMode);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        List asList;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                List list = null;
                if (pointFArr == null) {
                    asList = null;
                } else {
                    asList = Arrays.asList(pointFArr);
                }
                float[] a16 = f.a(asList);
                if (pointFArr2 != null) {
                    list = Arrays.asList(pointFArr2);
                }
                nativeSetPerspectiveCorrectionPoints(j3, str, a16, f.a(list));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setPriorRemoteVideoStreamType(int i3) {
        long j3 = this.mNativeTrtcCloudJni;
        if (j3 != 0) {
            nativeSetPriorRemoteVideoStreamType(j3, i3);
            return 0;
        }
        return 0;
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteAudioParallelParams(j3, new AudioParallelParams(tRTCAudioParallelParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteAudioVolume(String str, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteAudioVolume(j3, str, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setRemoteVideoRenderListener(String str, int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        boolean z16;
        this.mJniReadLock.lock();
        try {
            byte b16 = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                if (TextUtils.isEmpty(str)) {
                    this.mJniReadLock.unlock();
                    return -3319;
                }
                if (!isCustomRenderSupportedFormatType(i3)) {
                    this.mJniReadLock.unlock();
                    return -1327;
                }
                if (!isCustomRenderSupportedBufferType(i16)) {
                    this.mJniReadLock.unlock();
                    return -1328;
                }
                synchronized (this.mRemoteVideoRenderListenerMap) {
                    a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
                    if (aVar != null) {
                        int i17 = aVar.f119193b;
                        if (i17 == i3 && aVar.f119194c == i16) {
                            z16 = false;
                            if (!z16 && tRTCVideoRenderListener != 0) {
                                aVar.f119195d = tRTCVideoRenderListener;
                                this.mRemoteVideoRenderListenerMap.put(str, aVar);
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 0, i17, aVar.f119194c);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 2, aVar.f119193b, aVar.f119194c);
                        }
                        z16 = true;
                        if (!z16) {
                            aVar.f119195d = tRTCVideoRenderListener;
                            this.mRemoteVideoRenderListenerMap.put(str, aVar);
                        }
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 0, i17, aVar.f119194c);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 2, aVar.f119193b, aVar.f119194c);
                    }
                    if (tRTCVideoRenderListener != 0) {
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = new a<>(b16);
                        aVar2.f119195d = tRTCVideoRenderListener;
                        aVar2.f119193b = i3;
                        aVar2.f119194c = i16;
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 0, i3, i16);
                        nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 2, aVar2.f119193b, aVar2.f119194c);
                        this.mRemoteVideoRenderListenerMap.put(str, aVar2);
                    } else {
                        this.mRemoteVideoRenderListenerMap.remove(str);
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setRemoteVideoStreamType(String str, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteVideoStreamType(j3, str, i3);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th5) {
            this.mJniReadLock.unlock();
            throw th5;
        }
    }

    public void setRemoteViewFillMode(String str, int i3, int i16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteViewFillMode(j3, str, i3, i16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewMirror(String str, int i3, int i16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteViewMirror(j3, str, i3, i16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewRotation(String str, int i3, int i16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetRemoteViewRotation(j3, str, i3, i16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderMirror(boolean z16) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetVideoEncoderMirror(j3, z16);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderParams(int i3, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetVideoEncoderParams(j3, i3, new VideoEncParams(tRTCVideoEncParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderRotation(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetVideoEncoderRotation(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoMuteImage(Bitmap bitmap, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetVideoMuteImage(j3, bitmap, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setWatermark(Bitmap bitmap, int i3, float f16, float f17, float f18) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSetWatermark(j3, bitmap, i3, f16, f17, f18);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void showDashboardManager(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeShowDashboardManager(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void snapshotVideo(String str, int i3, int i16, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSnapshotVideo(j3, str, i3, i16, tRTCSnapshotListener);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 == 0) {
                this.mJniReadLock.unlock();
                return 0;
            }
            return nativeStartAudioRecording(j3, new AudioRecordingParams(tRTCAudioRecordingParams));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalAudio(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartLocalAudioWithQuality(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalPreview(boolean z16, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartLocalPreview(j3, z16, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartLocalRecording(j3, new LocalRecordingParams(tRTCLocalRecordingParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartPublishCDNStream(j3, new PublishCDNParams(tRTCPublishCDNParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        StreamEncoderParam streamEncoderParam;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                StreamMixingConfig streamMixingConfig = null;
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                if (tRTCStreamEncoderParam == null) {
                    streamEncoderParam = null;
                } else {
                    streamEncoderParam = new StreamEncoderParam(tRTCStreamEncoderParam);
                }
                if (tRTCStreamMixingConfig != null) {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeStartPublishMediaStream(j3, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishing(String str, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartPublishing(j3, str, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartRemoteView(j3, str, i3, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startScreenCapture(int i3, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        ScreenShareParams screenShareParams;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (tRTCScreenShareParams != null) {
                    screenShareParams = new ScreenShareParams(tRTCScreenShareParams);
                } else {
                    screenShareParams = null;
                }
                if (tRTCVideoEncParam == null) {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i3, null, screenShareParams);
                    LiteavLog.w(TAG, "startScreenCapture encParams is null");
                } else {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i3, new VideoEncParams(tRTCVideoEncParam), screenShareParams);
                }
            }
            if (tRTCScreenShareParams != null) {
                ThreadUtils.runOnUiThread(b.a(this, tRTCScreenShareParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartSpeedTest(j3, new SpeedTestParams(tRTCSpeedTestParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartSystemAudioLoopback(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAllRemoteView() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopAllRemoteView(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAudioRecording() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopAudioRecording(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopLocalAudio(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalPreview() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopLocalPreview(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalRecording() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopLocalRecording(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishCDNStream() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopPublishCDNStream(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishMediaStream(String str) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopPublishMediaStream(j3, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishing() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopPublishing(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str, int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopRemoteView(j3, str, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopScreenCapture(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopScreenCapture(j3, i3);
            }
            this.mJniReadLock.unlock();
            ThreadUtils.runOnUiThread(c.a(this));
        } catch (Throwable th5) {
            this.mJniReadLock.unlock();
            throw th5;
        }
    }

    public void stopSpeedTest() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopSpeedTest(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopSystemAudioLoopback(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSwitchRole(j3, i3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0 && tRTCSwitchRoomConfig != null) {
                nativeSwitchRoom(j3, new SwitchRoomConfig(tRTCSwitchRoomConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeUpdateLocalView(j3, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateOtherRoomForwardMode(String str) {
        long j3 = this.mNativeTrtcCloudJni;
        if (j3 != 0) {
            nativeUpdateOtherRoomForwardMode(j3, str);
        }
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        StreamEncoderParam streamEncoderParam;
        StreamMixingConfig streamMixingConfig;
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                if (tRTCStreamEncoderParam == null) {
                    streamEncoderParam = null;
                } else {
                    streamEncoderParam = new StreamEncoderParam(tRTCStreamEncoderParam);
                }
                if (tRTCStreamMixingConfig == null) {
                    streamMixingConfig = null;
                } else {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeUpdatePublishMediaStream(j3, str, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeUpdateRemote3DSpatialPosition(j3, str, iArr);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeUpdateRemoteView(j3, str, i3, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeUpdateSelf3DSpatialPosition(j3, iArr, fArr, fArr2, fArr3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TrtcCloudJni(long j3, boolean z16) {
        this.mNativeTrtcCloudJni = 0L;
        this.mLocalUserId = "";
        this.mListenerList = new CopyOnWriteArrayList();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mFloatingWindowSet = new HashSet<>();
        if (j3 == 0) {
            this.mNativeTrtcCloudJni = nativeCreatePipeline(this, z16);
        } else {
            this.mNativeTrtcCloudJni = nativeCreateSubCloud(this, j3);
        }
        byte b16 = 0;
        this.mVideoFrameListenerWrapper = new a<>(b16);
        this.mLocalVideoRenderListenerWrapper = new a<>(b16);
        this.mRemoteVideoRenderListenerMap = new HashMap();
        this.mListenerHandler = new Handler(Looper.getMainLooper());
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class SpeedTestParams {

        /* renamed from: a, reason: collision with root package name */
        private final TRTCCloudDef.TRTCSpeedTestParams f119180a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f119181b;

        public SpeedTestParams(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
            this.f119180a = tRTCSpeedTestParams;
            this.f119181b = false;
        }

        public int getExpectedDownBandwidth() {
            return this.f119180a.expectedDownBandwidth;
        }

        public int getExpectedUpBandwidth() {
            return this.f119180a.expectedUpBandwidth;
        }

        public boolean getIsCalledFromDeprecatedApi() {
            return this.f119181b;
        }

        public int getSDKAppId() {
            return this.f119180a.sdkAppId;
        }

        public int getScene() {
            return this.f119180a.scene;
        }

        public String getUserId() {
            return this.f119180a.userId;
        }

        public String getUserSig() {
            return this.f119180a.userSig;
        }

        public SpeedTestParams(int i3, String str, String str2) {
            TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams = new TRTCCloudDef.TRTCSpeedTestParams();
            this.f119180a = tRTCSpeedTestParams;
            tRTCSpeedTestParams.sdkAppId = i3;
            tRTCSpeedTestParams.userId = str;
            tRTCSpeedTestParams.userSig = str2;
            tRTCSpeedTestParams.scene = 1;
            this.f119181b = true;
        }
    }

    public void startLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartLocalAudio(j3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartRemoteViewWithoutStreamType(j3, str, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(int i3, String str, String str2) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStartSpeedTest(j3, new SpeedTestParams(i3, str, str2));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeStopRemoteViewWithoutStreamType(j3, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i3, String str) {
        this.mJniReadLock.lock();
        try {
            long j3 = this.mNativeTrtcCloudJni;
            if (j3 != 0) {
                nativeSwitchRoleWithPrivateMapKey(j3, i3, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
