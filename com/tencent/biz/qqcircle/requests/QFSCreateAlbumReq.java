package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedAlbum$AlbumInfo;
import qqcircle.QQCircleFeedAlbum$CreateAlbumReq;
import qqcircle.QQCircleFeedAlbum$CreateAlbumRsp;
import qqcircle.QQCircleFeedAlbum$FeedSign;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSCreateAlbumReq extends QCircleBaseRequest {
    public QQCircleFeedAlbum$CreateAlbumReq request;

    public QFSCreateAlbumReq(QQCircleFeedAlbum$AlbumInfo qQCircleFeedAlbum$AlbumInfo, List<FeedCloudMeta$StFeed> list, boolean z16) {
        QQCircleFeedAlbum$CreateAlbumReq qQCircleFeedAlbum$CreateAlbumReq = new QQCircleFeedAlbum$CreateAlbumReq();
        this.request = qQCircleFeedAlbum$CreateAlbumReq;
        qQCircleFeedAlbum$CreateAlbumReq.album_info.set(qQCircleFeedAlbum$AlbumInfo);
        this.request.feed_signs.set(a(list));
        this.request.draft_album.set(z16);
    }

    private List<QQCircleFeedAlbum$FeedSign> a(List<FeedCloudMeta$StFeed> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(i3);
            QQCircleFeedAlbum$FeedSign qQCircleFeedAlbum$FeedSign = new QQCircleFeedAlbum$FeedSign();
            qQCircleFeedAlbum$FeedSign.f429304id.set(feedCloudMeta$StFeed.f398449id.get());
            qQCircleFeedAlbum$FeedSign.source_index.set(i3);
            qQCircleFeedAlbum$FeedSign.poster_id.set(feedCloudMeta$StFeed.poster.f398463id.get());
            qQCircleFeedAlbum$FeedSign.create_time.set(feedCloudMeta$StFeed.createTime.get());
            arrayList.add(qQCircleFeedAlbum$FeedSign);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.feed_album.Writer.CreateAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.request.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public QQCircleFeedAlbum$CreateAlbumRsp decode(byte[] bArr) {
        QQCircleFeedAlbum$CreateAlbumRsp qQCircleFeedAlbum$CreateAlbumRsp = new QQCircleFeedAlbum$CreateAlbumRsp();
        try {
            qQCircleFeedAlbum$CreateAlbumRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleFeedAlbum$CreateAlbumRsp;
    }
}
