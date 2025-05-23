package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.QQAudioHelper;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f196950a = "AREngine_ARPromotion";

    /* renamed from: b, reason: collision with root package name */
    static h f196951b;

    public static d a(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            return (d) ((QQAppInterface) appInterface).getManager(QQManagerFactory.ARPROMOTION_MANAGER);
        }
        if (!QQAudioHelper.f()) {
            return null;
        }
        throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.pfn));
    }

    public static h b(AppInterface appInterface) {
        if ((appInterface instanceof QQAppInterface) && QQAudioHelper.f()) {
            throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.pfl));
        }
        if (f196951b == null) {
            synchronized (d.class) {
                if (f196951b == null) {
                    f196951b = new h(appInterface);
                }
            }
        }
        return f196951b;
    }

    public static boolean c(long j3, long j16) {
        long e16 = QQAudioHelper.e();
        if (j3 < e16 && j16 > e16) {
            return true;
        }
        return false;
    }

    public static boolean d(long j3) {
        if (j3 < QQAudioHelper.e()) {
            return true;
        }
        return false;
    }
}
