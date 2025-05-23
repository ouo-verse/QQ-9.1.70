package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicReq;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkSmartMatchMusicReq extends QCircleBaseRequest {
    private final QQCircleSmartMatchMusic$SmartMatchMusicReq mReq;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public @interface CameraType {
        public static final int BACK = 0;
        public static final int FRONT = 1;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public @interface DataType {
        public static final int BASE_64_BIT_DATA = 1;
        public static final int BIG_DATA = 0;
        public static final int PIC_PATH = 2;
        public static final int PIC_STRING = 4;
        public static final int PURE_STRING = 3;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public @interface SceneType {
        public static final int SCENE_QZONE = 2;
        public static final int SCENE_UNKNOWN = 0;
        public static final int SCENE_XWORLD = 1;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public @interface VideoType {
        public static final int LOCAL_FILE = 1;
        public static final int REAL_TIME = 0;
    }

    public QQWinkSmartMatchMusicReq(List<byte[]> list, SosoLocation sosoLocation, @VideoType int i3, @CameraType int i16, LocalMediaInfo localMediaInfo, String str, @DataType int i17, String str2, @SceneType int i18, boolean z16) {
        QQCircleSmartMatchMusic$SmartMatchMusicReq qQCircleSmartMatchMusic$SmartMatchMusicReq = new QQCircleSmartMatchMusic$SmartMatchMusicReq();
        this.mReq = qQCircleSmartMatchMusic$SmartMatchMusicReq;
        if (sosoLocation != null) {
            qQCircleSmartMatchMusic$SmartMatchMusicReq.fLat.set(sosoLocation.mLat02);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.fLon.set(sosoLocation.mLon02);
        }
        qQCircleSmartMatchMusic$SmartMatchMusicReq.dataType.set(i17);
        qQCircleSmartMatchMusic$SmartMatchMusicReq.videoType.set(i3);
        qQCircleSmartMatchMusic$SmartMatchMusicReq.cameraType.set(i16);
        if (i3 == 1 && localMediaInfo != null) {
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoLat.set(localMediaInfo.latitude / 1000000.0d);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoLon.set(localMediaInfo.longitude / 1000000.0d);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoTime.set(localMediaInfo.addedDate);
        }
        if (list != null && list.size() > 0) {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                this.mReq.vecPicBuffer.add(ByteStringMicro.copyFrom(it.next()));
            }
        }
        this.mReq.wording.set(str);
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("camera_id");
        feedCloudCommon$Entry.value.set(str2);
        feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        this.mReq.extInfo.set(feedCloudCommon$StCommonExt);
        this.mReq.scene.set(i18);
        this.mReq.requireLyrics.set(z16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMatchMusic";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2")) {
            return "GetSmartMatchMusic";
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return "trpc.videocircle.circlemusic.CircleSmartMatchMusic";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp = new QQCircleSmartMatchMusic$SmartMatchMusicRsp();
        try {
            qQCircleSmartMatchMusic$SmartMatchMusicRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$SmartMatchMusicRsp;
    }
}
