package com.tencent.turingcam;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.turingface.sdk.mfa.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a2zkO {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements q9NV2 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xBpx1 f382129a;

        public spXPg(xBpx1 xbpx1) {
            this.f382129a = xbpx1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) xbpx1);
            }
        }
    }

    public static q9NV2 a(int i3, byte[] bArr) {
        Context context;
        jfo8q a16;
        String str;
        byte[] a17;
        Context context2;
        int i16;
        n nVar = n.f382543d;
        nVar.getClass();
        b0J7G b0j7g = new b0J7G();
        b0j7g.f382147a = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i3), bArr);
        b0j7g.f382148b = hashMap;
        b0j7g.f382149c = 0;
        tfWT8 tfwt8 = new tfWT8();
        tfwt8.f382391a = 91;
        tfwt8.f382392b = "91";
        tfwt8.f382393c = "FC6D5B0A7013DB60";
        StringBuilder a18 = tmnyR.a("");
        a18.append(WT9z5.f382088a);
        tfwt8.f382394d = a18.toString();
        tfwt8.f382395e = 2;
        b0j7g.f382150d = tfwt8;
        if (nVar.f382545b == null) {
            nVar.f382545b = new WOMZP();
            synchronized (eh5ma.class) {
                context2 = eh5ma.f382207a;
            }
            WOMZP womzp = nVar.f382545b;
            String packageName = context2.getPackageName();
            Random random = Ckq8l.f381753a;
            if (packageName == null) {
                packageName = "";
            }
            womzp.f382087b = packageName;
            String packageName2 = context2.getPackageName();
            String str2 = AEResManagerConfigBean.DEFAULT_VERSION;
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context2.getPackageManager(), packageName2, 64);
                str2 = packageInfo.versionName;
                i16 = packageInfo.versionCode;
            } catch (Throwable unused) {
                i16 = 0;
            }
            nVar.f382545b.f382086a = String.format("%s,%d", str2, Integer.valueOf(i16));
        }
        b0j7g.f382151e = nVar.f382545b;
        DdNBW ddNBW = new DdNBW();
        ddNBW.f381791h = nVar.f382544a.b();
        nVar.f382544a.getClass();
        byte[] bArr2 = null;
        ddNBW.f381785b = null;
        fBfpd fbfpd = nVar.f382544a;
        ddNBW.f381786c = fbfpd.f382223j;
        ddNBW.f381787d = 0;
        ddNBW.f381788e = fbfpd.f382224k;
        ddNBW.f381789f = fbfpd.f382225l;
        b0j7g.f382152f = ddNBW;
        HashMap hashMap2 = new HashMap();
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        int a19 = arWPM.a();
        if (a19 != 0) {
            a16 = jfo8q.a(a19);
        } else {
            a16 = T0QUa.f382050l.a(context, true, 1);
        }
        String str3 = a16.f382267a;
        Random random2 = Ckq8l.f381753a;
        if (str3 == null) {
            str3 = "";
        }
        hashMap2.put(1, str3);
        fBfpd fbfpd2 = nVar.f382544a;
        if (TextUtils.isEmpty(fbfpd2.f382218e)) {
            str = "";
        } else {
            str = fbfpd2.f382218e;
        }
        if (str == null) {
            str = "";
        }
        hashMap2.put(6, str);
        hashMap2.put(4, "");
        String str4 = a16.f382272f;
        if (str4 == null) {
            str4 = "";
        }
        hashMap2.put(3, str4);
        b0j7g.f382153g = hashMap2;
        HashMap hashMap3 = new HashMap();
        Context c16 = nVar.f382544a.c();
        String str5 = XStYH.f382092b;
        HashMap hashMap4 = new HashMap();
        HashSet hashSet = new HashSet();
        String b16 = XStYH.b(c16, "701");
        if (!TextUtils.isEmpty(b16)) {
            hashSet.addAll(Arrays.asList(b16.split("_")));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str6 = (String) it.next();
            hashMap4.put(str6, XStYH.b(c16, "TSS_" + str6));
        }
        for (String str7 : hashMap4.keySet()) {
            try {
                int parseInt = Integer.parseInt(str7);
                String str8 = (String) hashMap4.get(str7);
                if (str8 != null) {
                    hashMap3.put(Integer.valueOf(parseInt), str8);
                }
            } catch (Throwable unused2) {
            }
        }
        hashMap3.put(2, XStYH.b(nVar.f382544a.c(), "602"));
        hashMap3.put(3, XStYH.b(nVar.f382544a.c(), "702"));
        hashMap3.put(4, XStYH.b(nVar.f382544a.c(), "703"));
        b0j7g.f382154h = hashMap3;
        String str9 = n.f382542c;
        try {
            AV6dE aV6dE = new AV6dE();
            OF1Jz oF1Jz = aV6dE.f381724a;
            oF1Jz.f381967e = str9;
            oF1Jz.f381968f = str9;
            aV6dE.a("req", b0j7g);
            a17 = Bp8QH.a(aV6dE.a());
        } catch (Exception unused3) {
        }
        if (a17 != null) {
            bArr2 = VBlVU.b(a17, VBlVU.a());
            return new spXPg(new xBpx1(bArr2));
        }
        throw new RuntimeException("compress data fail");
    }
}
