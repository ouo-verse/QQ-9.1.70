package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetNoticeCategoryDetailPageReq;
import feedcloud.FeedCloudRead$StGetNoticeCategoryDetailPageRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageNoticeCategoryDetailRequest extends QCircleBaseRequest {
    private int mListNum = 20;
    public FeedCloudRead$StGetNoticeCategoryDetailPageReq mRequest;

    public QFSMessageNoticeCategoryDetailRequest(String str, QCircleInitBean qCircleInitBean, int i3) {
        int launchTo;
        FeedCloudRead$StGetNoticeCategoryDetailPageReq feedCloudRead$StGetNoticeCategoryDetailPageReq = new FeedCloudRead$StGetNoticeCategoryDetailPageReq();
        this.mRequest = feedCloudRead$StGetNoticeCategoryDetailPageReq;
        feedCloudRead$StGetNoticeCategoryDetailPageReq.count.set(this.mListNum);
        if (i3 > 0) {
            this.mRequest.category_id.set(i3);
        } else {
            PBEnumField pBEnumField = this.mRequest.category_id;
            if (qCircleInitBean == null) {
                launchTo = 0;
            } else {
                launchTo = qCircleInitBean.getLaunchTo();
            }
            pBEnumField.set(launchTo);
        }
        QLog.d(BaseRequest.TAG, 1, "[QFSMessageNoticeCategoryDetailRequest] category_id: " + this.mRequest.category_id.get() + " | req num: " + this.mListNum + " | feedAttachInfo: " + str + " | subTabType: " + i3);
        if (qCircleInitBean != null) {
            setExtMapInfo("sub_msg_from", qCircleInitBean.getLaunchFrom());
            a(qCircleInitBean);
        }
        if (str != null) {
            this.mRequest.attach_info.set(str);
        }
    }

    private void a(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getCommonExtInfoByteArray() != null) {
            FeedCloudCommon$StCommonExt commonExtInfo = qCircleInitBean.getCommonExtInfo();
            if (!this.mRequest.ext.has()) {
                this.mRequest.ext.set(commonExtInfo);
                return;
            } else {
                this.mRequest.ext.mapBytesInfo.set(commonExtInfo.mapBytesInfo.get());
                return;
            }
        }
        QLog.d(BaseRequest.TAG, 1, "[setExtMapBytesInfo] initBean == null || initBean.getCommonExtInfoByteArray() == null).");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeCategoryDetailPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public void setExtMapInfo(String str, String str2) {
        if (this.mRequest != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!this.mRequest.ext.has()) {
                this.mRequest.ext.set(new FeedCloudCommon$StCommonExt());
            }
            bh.a(this.mRequest.ext.mapInfo, str, str2);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp = new FeedCloudRead$StGetNoticeCategoryDetailPageRsp();
        try {
            feedCloudRead$StGetNoticeCategoryDetailPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetNoticeCategoryDetailPageRsp;
    }
}
