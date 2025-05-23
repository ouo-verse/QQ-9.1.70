package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageReq;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageNoticeCategoriesRequest extends QCircleBaseRequest {
    private QCircleInitBean mInitBean;
    private int mListNum;
    public FeedCloudRead$StGetNoticeCategoriesPageReq mRequest;
    private boolean mUseNewCmd;

    public QFSMessageNoticeCategoriesRequest(String str) {
        this(str, null);
    }

    public void enableTransRedPointInfo() {
        if (this.mRequest == null) {
            QLog.e("QFSMessageNoticeCategoriesRequest", 1, "[setTransRedPointInfo] mRequest == null");
            return;
        }
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean != null && qCircleInitBean.getCommonExtInfo() != null && this.mInitBean.getCommonExtInfo().mapBytesInfo.has()) {
            if (!this.mRequest.ext.has()) {
                this.mRequest.ext.set(new FeedCloudCommon$StCommonExt());
            }
            this.mRequest.ext.mapBytesInfo.addAll(this.mInitBean.getCommonExtInfo().mapBytesInfo.get());
            return;
        }
        QLog.e("QFSMessageNoticeCategoriesRequest", 1, "[setTransRedPointInfo] mapBytesInfo not has");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        if (this.mUseNewCmd) {
            return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeByDrawer";
        }
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeCategoriesPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public void setQuickThankTimestamp(long j3) {
        FeedCloudRead$StGetNoticeCategoriesPageReq feedCloudRead$StGetNoticeCategoriesPageReq = this.mRequest;
        if (feedCloudRead$StGetNoticeCategoriesPageReq == null) {
            QLog.e("QFSMessageNoticeCategoriesRequest", 1, "[setQuickThankTimestamp] mRequest == null");
        } else {
            feedCloudRead$StGetNoticeCategoriesPageReq.quick_thank_timestamp.set(j3);
        }
    }

    public QFSMessageNoticeCategoriesRequest(String str, QCircleInitBean qCircleInitBean) {
        this.mListNum = 20;
        FeedCloudRead$StGetNoticeCategoriesPageReq feedCloudRead$StGetNoticeCategoriesPageReq = new FeedCloudRead$StGetNoticeCategoriesPageReq();
        this.mRequest = feedCloudRead$StGetNoticeCategoriesPageReq;
        feedCloudRead$StGetNoticeCategoriesPageReq.count.set(this.mListNum);
        if (str != null) {
            this.mRequest.attach_info.set(str);
        }
        if (qCircleInitBean != null && q.r().F(qCircleInitBean.getLaunchTo())) {
            this.mRequest.scene.set(1);
        }
        this.mInitBean = qCircleInitBean;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp = new FeedCloudRead$StGetNoticeCategoriesPageRsp();
        try {
            feedCloudRead$StGetNoticeCategoriesPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetNoticeCategoriesPageRsp;
    }

    public QFSMessageNoticeCategoriesRequest(String str, QCircleInitBean qCircleInitBean, int i3, int i16) {
        this(str, qCircleInitBean);
        this.mRequest.drawer_id.set(i3);
        this.mRequest.category_id.set(i16);
        this.mUseNewCmd = true;
    }
}
