package com.tencent.biz.pubaccount.weishi.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import com.tencent.biz.pubaccount.weishi.util.s;
import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f80649a = new Object();

    public static d a(String str) {
        stGetAllABTestPolicyRsp stgetallabtestpolicyrsp = (stGetAllABTestPolicyRsp) s.c(new stGetAllABTestPolicyRsp(), b(str));
        if (stgetallabtestpolicyrsp == null) {
            return null;
        }
        return new d(str, stgetallabtestpolicyrsp);
    }

    private static String b(String str) {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_exp_data_" + str;
    }

    public static d d(String str) {
        d a16;
        synchronized (f80649a) {
            a16 = a(str);
        }
        return a16;
    }

    public static boolean e(d dVar) {
        boolean c16;
        synchronized (f80649a) {
            c16 = c(dVar);
        }
        return c16;
    }

    public static boolean c(d dVar) {
        if (dVar == null || dVar.d() == null) {
            return false;
        }
        return s.d(dVar.d(), b(dVar.g()));
    }
}
