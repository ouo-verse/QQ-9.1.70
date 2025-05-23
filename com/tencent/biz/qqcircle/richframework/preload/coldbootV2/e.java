package com.tencent.biz.qqcircle.richframework.preload.coldbootV2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase$PrePullMetaData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    private static String a(int i3) {
        if (i3 == 10) {
            return "PrePullMetaDataV2";
        }
        return "PrePullMetaDataV2_" + i3;
    }

    public static QQCircleFeedBase$PrePullMetaData b(int i3) {
        QQCircleFeedBase$PrePullMetaData qQCircleFeedBase$PrePullMetaData = new QQCircleFeedBase$PrePullMetaData();
        qQCircleFeedBase$PrePullMetaData.isOpenPrePull.set(true);
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        if (C != null) {
            try {
                String a16 = a(i3);
                String string = C.getString(a16, "");
                if (!TextUtils.isEmpty(string)) {
                    byte[] decode = Base64.decode(string.getBytes(), 0);
                    QQCircleFeedBase$PrePullMetaData qQCircleFeedBase$PrePullMetaData2 = new QQCircleFeedBase$PrePullMetaData();
                    qQCircleFeedBase$PrePullMetaData2.mergeFrom(decode);
                    QLog.d("QCircleColdBootPreloadHelperV2", 1, "getPrePullMetaDataV2 success, key: ", a16);
                    return qQCircleFeedBase$PrePullMetaData2;
                }
            } catch (Exception e16) {
                QLog.e("QCircleColdBootPreloadHelperV2", 1, "getPrePullMetaDataV2 Exception:", e16.toString());
                return qQCircleFeedBase$PrePullMetaData;
            } catch (OutOfMemoryError e17) {
                QLog.e("QCircleColdBootPreloadHelperV2", 1, "getPrePullMetaDataV2 OOM:", e17.toString());
            }
        }
        return qQCircleFeedBase$PrePullMetaData;
    }

    public static void c(QQCircleFeedBase$PrePullMetaData qQCircleFeedBase$PrePullMetaData, int i3) {
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        try {
            String a16 = a(i3);
            if (C != null) {
                C.edit().putString(a16, new String(Base64.encode(qQCircleFeedBase$PrePullMetaData.toByteArray(), 0))).apply();
                QLog.d("QCircleColdBootPreloadHelperV2", 1, "savePrePullMetaDataV2 success, key: ", a16);
            }
        } catch (Exception e16) {
            QLog.e("QCircleColdBootPreloadHelperV2", 1, "savePrePullMetaDataV2 Exception:", e16.toString());
        } catch (OutOfMemoryError e17) {
            QLog.e("QCircleColdBootPreloadHelperV2", 1, "savePrePullMetaDataV2 OOM:", e17.toString());
        }
    }
}
