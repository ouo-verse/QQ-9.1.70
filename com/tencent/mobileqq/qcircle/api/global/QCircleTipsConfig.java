package com.tencent.mobileqq.qcircle.api.global;

import android.util.SparseArray;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleEnvHub$ExposeTipsRsp;
import qqcircle.QQCircleEnvHub$GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub$Tips;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTipsConfig {
    private static final String TAG = "QCircleTipsConfig";
    private static volatile QCircleTipsConfig sInstance;
    private SparseArray<QQCircleEnvHub$Tips> mTipsSparseArray = new SparseArray<>();

    QCircleTipsConfig() {
    }

    public static QCircleTipsConfig getInstance() {
        if (sInstance == null) {
            synchronized (QCircleTipsConfig.class) {
                if (sInstance == null) {
                    sInstance = new QCircleTipsConfig();
                }
            }
        }
        return sInstance;
    }

    public byte[] getTipConfig(int i3) {
        QQCircleEnvHub$Tips qQCircleEnvHub$Tips = this.mTipsSparseArray.get(i3);
        if (qQCircleEnvHub$Tips != null) {
            return qQCircleEnvHub$Tips.toByteArray();
        }
        return null;
    }

    public void initTipsConfig(QQCircleEnvHub$GetUserFullEnvRsp qQCircleEnvHub$GetUserFullEnvRsp) {
        if (qQCircleEnvHub$GetUserFullEnvRsp == null) {
            QLog.d(TAG, 1, "saveTipsConfig() -> exposeTipsRsp is null");
            return;
        }
        List<QQCircleEnvHub$Tips> list = qQCircleEnvHub$GetUserFullEnvRsp.tipsList.get();
        if (list != null) {
            for (QQCircleEnvHub$Tips qQCircleEnvHub$Tips : list) {
                this.mTipsSparseArray.put(qQCircleEnvHub$Tips.f429302id.get(), qQCircleEnvHub$Tips);
            }
            return;
        }
        QLog.d(TAG, 1, "tipsInfoList is null");
    }

    public void updateTipsConfig(byte[] bArr) {
        QQCircleEnvHub$ExposeTipsRsp qQCircleEnvHub$ExposeTipsRsp = new QQCircleEnvHub$ExposeTipsRsp();
        try {
            qQCircleEnvHub$ExposeTipsRsp.mergeFrom(bArr);
            QQCircleEnvHub$Tips qQCircleEnvHub$Tips = qQCircleEnvHub$ExposeTipsRsp.tips.get();
            if (qQCircleEnvHub$Tips != null) {
                this.mTipsSparseArray.put(qQCircleEnvHub$Tips.f429302id.get(), qQCircleEnvHub$Tips);
            } else {
                QLog.d(TAG, 1, "tips is null");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }
}
