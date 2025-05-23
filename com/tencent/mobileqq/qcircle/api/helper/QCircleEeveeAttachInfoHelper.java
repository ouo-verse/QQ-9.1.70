package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeBase$StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg$FcUndealMsgsRsp;
import java.util.ArrayList;
import java.util.List;
import uq3.g;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleEeveeAttachInfoHelper {
    public static final String QCIRCLE_EEVEE_ATTACH_INFO_SP_KEY = "qcircle_eevee_attach_info_sp_key";
    private static final String TAG = "QCircleEeveeAttachInfoHelper";
    private static volatile QCircleEeveeAttachInfoHelper sInstance;
    private List<FeedCloudEeveeBase$StEeveeAttachInfo> mEeveeAttachInfos = new ArrayList();

    QCircleEeveeAttachInfoHelper() {
    }

    public static QCircleEeveeAttachInfoHelper getInstance() {
        if (sInstance == null) {
            synchronized (QCircleEeveeAttachInfoHelper.class) {
                if (sInstance == null) {
                    sInstance = new QCircleEeveeAttachInfoHelper();
                }
            }
        }
        return sInstance;
    }

    public synchronized void clearMemoryInfo() {
        QLog.d(TAG, 1, "clearMemoryInfo");
        this.mEeveeAttachInfos.clear();
    }

    public synchronized List<FeedCloudEeveeBase$StEeveeAttachInfo> getEeveeAttachInfos() {
        List<FeedCloudEeveeBase$StEeveeAttachInfo> list = this.mEeveeAttachInfos;
        if (list != null && list.size() != 0) {
            return new ArrayList(this.mEeveeAttachInfos);
        }
        FeedCloudEeveeUndealmsg$FcUndealMsgsRsp feedCloudEeveeUndealmsg$FcUndealMsgsRsp = new FeedCloudEeveeUndealmsg$FcUndealMsgsRsp();
        Object d16 = g.d(QCIRCLE_EEVEE_ATTACH_INFO_SP_KEY, "");
        if (!(d16 instanceof String)) {
            return new ArrayList();
        }
        if (Proto2JsonUtil.json2Pb((String) d16, feedCloudEeveeUndealmsg$FcUndealMsgsRsp)) {
            QLog.d(TAG, 1, "eeveeAttachInfos size = " + feedCloudEeveeUndealmsg$FcUndealMsgsRsp.attachInfo.size());
            return feedCloudEeveeUndealmsg$FcUndealMsgsRsp.attachInfo.get();
        }
        return new ArrayList();
    }

    public synchronized void setEeveeAttachInfos(List<FeedCloudEeveeBase$StEeveeAttachInfo> list) {
        if (list != null) {
            if (list.size() != 0) {
                this.mEeveeAttachInfos.clear();
                this.mEeveeAttachInfos.addAll(list);
                FeedCloudEeveeUndealmsg$FcUndealMsgsRsp feedCloudEeveeUndealmsg$FcUndealMsgsRsp = new FeedCloudEeveeUndealmsg$FcUndealMsgsRsp();
                feedCloudEeveeUndealmsg$FcUndealMsgsRsp.attachInfo.set(this.mEeveeAttachInfos);
                g.e(QCIRCLE_EEVEE_ATTACH_INFO_SP_KEY, Proto2JsonUtil.proto2Json(feedCloudEeveeUndealmsg$FcUndealMsgsRsp));
            }
        }
    }
}
