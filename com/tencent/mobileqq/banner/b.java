package com.tencent.mobileqq.banner;

import android.support.annotation.IdRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_temp_inject.yml", version = 2)
    public static ArrayList<Class<? extends e>> f200245a;

    /* renamed from: b, reason: collision with root package name */
    public static int[] f200246b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Integer> f200247c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.banner.e
        public boolean isKandianHost(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends e>> arrayList = new ArrayList<>();
        f200245a = arrayList;
        arrayList.add(com.tencent.mobileqq.activity.recent.a.class);
        f200246b = new int[]{R.drawable.c4b, R.drawable.f160263c45, R.drawable.c47, R.drawable.c4c, R.drawable.c7b, R.drawable.d1q, R.drawable.c4d, R.drawable.f160262c44, R.drawable.c49, R.drawable.c46, R.drawable.f160261c43, R.drawable.c4_, R.drawable.c4a, R.drawable.hle, R.drawable.hlf, R.drawable.nho};
        HashMap hashMap = new HashMap();
        f200247c = hashMap;
        hashMap.put("m.ke.qq.com", 7);
        hashMap.put("ke.qq.com", 7);
        hashMap.put("fudao.qq.com", 9);
        hashMap.put("buluo.qq.com", 10);
        hashMap.put("m.gamecenter.qq.com", 2);
        hashMap.put("imgcache.qq.com", 2);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static e a() {
        e eVar;
        if (!f200245a.isEmpty() && f200245a.get(0) != null) {
            try {
                eVar = f200245a.get(0).newInstance();
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            }
            if (eVar != null) {
                QLog.d(b.class.getSimpleName(), 2, "getBannerTempInject: return null");
                return new a();
            }
            return eVar;
        }
        eVar = null;
        if (eVar != null) {
        }
    }

    @IdRes
    public static int b(int i3) {
        return f200246b[i3];
    }

    public static int c(String str) {
        Integer num = f200247c.get(str);
        if (num == null) {
            if (a().isKandianHost(str)) {
                num = 8;
            } else {
                num = 6;
            }
        }
        return num.intValue();
    }
}
