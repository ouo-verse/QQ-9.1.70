package com.tencent.biz.richframework.network.request;

import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.open.business.base.MobileInfoUtil;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicReq;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SmartMusicMatchRequest extends VSBaseRequest {
    private static final int VIDEO_LOCATION_DIVIDE = 1000000;
    private static final long serialVersionUID = 6159666206339855822L;
    private final QQCircleSmartMatchMusic$SmartMatchMusicReq req;

    public SmartMusicMatchRequest(ArrayList<FrameVideoHelper.FrameBuffer> arrayList, SosoLocation sosoLocation, boolean z16, int i3, LocalMediaInfo localMediaInfo) {
        QQCircleSmartMatchMusic$SmartMatchMusicReq qQCircleSmartMatchMusic$SmartMatchMusicReq = new QQCircleSmartMatchMusic$SmartMatchMusicReq();
        this.req = qQCircleSmartMatchMusic$SmartMatchMusicReq;
        if (sosoLocation != null) {
            qQCircleSmartMatchMusic$SmartMatchMusicReq.fLat.set(sosoLocation.mLat02);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.fLon.set(sosoLocation.mLon02);
        }
        qQCircleSmartMatchMusic$SmartMatchMusicReq.videoType.set(z16 ? 1 : 0);
        qQCircleSmartMatchMusic$SmartMatchMusicReq.cameraType.set(i3);
        if (z16 && localMediaInfo != null) {
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoLat.set(localMediaInfo.latitude / 1000000.0d);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoLon.set(localMediaInfo.longitude / 1000000.0d);
            qQCircleSmartMatchMusic$SmartMatchMusicReq.videoTime.set(localMediaInfo.addedDate);
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<FrameVideoHelper.FrameBuffer> it = arrayList.iterator();
            while (it.hasNext()) {
                this.req.vecPicBuffer.add(ByteStringMicro.copyFrom(it.next().getData()));
            }
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("wifi_mac");
        feedCloudCommon$Entry.value.set(MobileInfoUtil.getLocalMacAddress());
        this.req.extInfo.mapInfo.add(feedCloudCommon$Entry);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMatchMusic";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
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
