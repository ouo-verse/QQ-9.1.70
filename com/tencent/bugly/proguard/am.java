package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class am {
    public static cn a(UserInfoBean userInfoBean) {
        Map<String, String> map;
        String str = null;
        if (userInfoBean == null) {
            return null;
        }
        cn cnVar = new cn();
        cnVar.f98479a = userInfoBean.f97817e;
        cnVar.f98483e = userInfoBean.f97822j;
        cnVar.f98482d = userInfoBean.f97815c;
        cnVar.f98481c = userInfoBean.f97816d;
        cnVar.f98486h = userInfoBean.f97827o == 1;
        int i3 = userInfoBean.f97814b;
        if (i3 == 1) {
            cnVar.f98480b = (byte) 1;
        } else if (i3 == 2) {
            cnVar.f98480b = (byte) 4;
        } else if (i3 == 3) {
            cnVar.f98480b = (byte) 2;
        } else if (i3 == 4) {
            cnVar.f98480b = (byte) 3;
        } else if (i3 != 8) {
            if (i3 < 10 || i3 >= 20) {
                av.e("unknown uinfo type %d ", Integer.valueOf(i3));
                return null;
            }
            cnVar.f98480b = (byte) i3;
        } else {
            cnVar.f98480b = (byte) 8;
        }
        HashMap hashMap = new HashMap();
        cnVar.f98484f = hashMap;
        if (userInfoBean.f97828p >= 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(userInfoBean.f97828p);
            hashMap.put("C01", sb5.toString());
        }
        if (userInfoBean.f97829q >= 0) {
            Map<String, String> map2 = cnVar.f98484f;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(userInfoBean.f97829q);
            map2.put("C02", sb6.toString());
        }
        Map<String, String> map3 = userInfoBean.f97830r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f97830r.entrySet()) {
                cnVar.f98484f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f97831s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f97831s.entrySet()) {
                cnVar.f98484f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = cnVar.f98484f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(!userInfoBean.f97824l);
        map5.put("A36", sb7.toString());
        Map<String, String> map6 = cnVar.f98484f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(userInfoBean.f97819g);
        map6.put("F02", sb8.toString());
        Map<String, String> map7 = cnVar.f98484f;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(userInfoBean.f97820h);
        map7.put("F03", sb9.toString());
        cnVar.f98484f.put("F04", userInfoBean.f97822j);
        Map<String, String> map8 = cnVar.f98484f;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(userInfoBean.f97821i);
        map8.put("F05", sb10.toString());
        cnVar.f98484f.put("F06", userInfoBean.f97825m);
        Map<String, String> map9 = cnVar.f98484f;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(userInfoBean.f97823k);
        map9.put("F10", sb11.toString());
        if (!TextUtils.isEmpty(ReportDataBuilder.KEY_USER_CUSTOM) && (map = userInfoBean.f97832t) != null) {
            str = map.get(ReportDataBuilder.KEY_USER_CUSTOM);
        }
        if (!TextUtils.isEmpty(str)) {
            cnVar.f98484f.put("C04_user_custom", str);
        }
        av.c("summary type %d vm:%d", Byte.valueOf(cnVar.f98480b), Integer.valueOf(cnVar.f98484f.size()));
        return cnVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                newInstance.a(kVar);
                return newInstance;
            } catch (Throwable th5) {
                if (!av.b(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return null;
    }

    public static cj a(Context context, int i3, byte[] bArr) {
        String str;
        ai c16 = ai.c();
        StrategyBean c17 = ak.a().c();
        if (c16 != null && c17 != null) {
            try {
                cj cjVar = new cj();
                synchronized (c16) {
                    cjVar.f98427a = c16.f98014b;
                    cjVar.f98428b = c16.f();
                    cjVar.f98429c = c16.f98015c;
                    cjVar.f98430d = c16.f98032t;
                    cjVar.f98431e = c16.f98035w;
                    cjVar.f98432f = c16.f98020h;
                    cjVar.f98433g = i3;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    cjVar.f98434h = bArr;
                    cjVar.f98435i = c16.i();
                    cjVar.f98436j = c16.f98023k;
                    cjVar.f98437k = new HashMap();
                    cjVar.f98438l = c16.e();
                    cjVar.f98439m = c17.f97850o;
                    cjVar.f98441o = c16.h();
                    cjVar.f98442p = aj.b(context);
                    cjVar.f98443q = System.currentTimeMillis();
                    cjVar.f98445s = c16.j();
                    cjVar.f98448v = c16.h();
                    cjVar.f98449w = cjVar.f98442p;
                    cjVar.f98440n = "com.tencent.bugly";
                    cjVar.f98437k.put("A26", c16.t());
                    cjVar.f98437k.put(Constants.IS_VM_DEVICE, "");
                    Map<String, String> map = cjVar.f98437k;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(ai.F());
                    map.put(Constants.HAS_HOOK_FRAME, sb5.toString());
                    Map<String, String> map2 = cjVar.f98437k;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(c16.R);
                    map2.put(Constants.IS_FIRST_INSTALLATION, sb6.toString());
                    Map<String, String> map3 = cjVar.f98437k;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(c16.Q);
                    map3.put(Constants.IS_DEVELOPMENT_DEVICE, sb7.toString());
                    cjVar.f98437k.put(Constants.BASE_IN_APP_NAME, c16.f98034v);
                    List<o> list = p.f98528b;
                    if (list != null) {
                        for (o oVar : list) {
                            String str2 = oVar.versionKey;
                            if (str2 != null && (str = oVar.version) != null) {
                                cjVar.f98437k.put(str2, str);
                            }
                        }
                    }
                    cjVar.f98437k.put(Constants.HOT_PATCH_NUM, HotPatchWrapper.getInstance().getAppHotPatchNum());
                    cjVar.f98437k.put(Constants.BASE_IN_HOTFIX, HotPatchWrapper.getInstance().getBaseInHotfixRFix());
                    cjVar.f98437k.put("G10", ba.d("G10", ""));
                }
                Map<String, String> y16 = c16.y();
                if (y16 != null) {
                    for (Map.Entry<String, String> entry : y16.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            cjVar.f98437k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return cjVar;
            } catch (Throwable th5) {
                if (!av.b(th5)) {
                    th5.printStackTrace();
                }
                return null;
            }
        }
        av.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", (String) obj);
            return eVar.a();
        } catch (Throwable th5) {
            if (av.b(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    public static ck a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b16 = eVar.b("detail", new ck());
                if (ck.class.isInstance(b16)) {
                    return (ck) ck.class.cast(b16);
                }
                return null;
            } catch (Throwable th5) {
                if (!av.b(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.f98522a.position()];
            System.arraycopy(lVar.f98522a.array(), 0, bArr, 0, lVar.f98522a.position());
            return bArr;
        } catch (Throwable th5) {
            if (av.b(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }
}
