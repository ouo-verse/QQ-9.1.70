package com.tencent.qimei.am;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.b;
import com.tencent.qimei.s.d;
import com.tencent.qimei.sdk.S.DataFormatter;
import com.tencent.qimei.sdk.S.SpreadValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final String f343072f;

    /* renamed from: a, reason: collision with root package name */
    public String f343073a;

    /* renamed from: b, reason: collision with root package name */
    public String f343074b;

    /* renamed from: c, reason: collision with root package name */
    public String f343075c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.qimei.s.d f343076d;

    /* renamed from: e, reason: collision with root package name */
    public final DataFormatter f343077e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final e f343078a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16878);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f343078a = new e();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int i3 = com.tencent.qimei.ab.a.f342921a;
        byte[] bArr = {IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 88, 103, 97, 73, 107, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 49, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, 76, 104, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 80, 65, 100};
        byte[] bArr2 = {27, 87, RegisterType.CONFLICTED, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 88, 13};
        for (int i16 = 0; i16 < 16; i16++) {
            bArr[i16] = (byte) (bArr[i16] ^ bArr2[i16 % 6]);
        }
        for (int i17 = 0; i17 < 16; i17++) {
            bArr[i17] = (byte) (bArr[i17] ^ bArr2[i17 % 6]);
        }
        f343072f = new String(bArr, Charset.forName("UTF-8"));
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        DataFormatter a16 = new b().a();
        this.f343077e = a16;
        com.tencent.qimei.ad.c.b("SpreadQM", "%s%s load current cache size: %s", this.f343073a, this.f343074b, Integer.valueOf(a16.a().size()));
    }

    public final Bundle a() {
        String str;
        String json;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Bundle bundle = new Bundle();
        DataFormatter dataFormatter = this.f343077e;
        String str2 = f343072f;
        try {
            json = new Gson().toJson(dataFormatter);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
        }
        if (!TextUtils.isEmpty(json)) {
            str = Base64.encodeToString(com.tencent.qimei.f.a.a(json.getBytes("UTF-8"), str2.getBytes("UTF-8"), 1), 2);
            bundle.putString("spread_data", str);
            bundle.putString(com.heytap.mcssdk.a.a.f36102l, this.f343073a);
            bundle.putString("source", this.f343074b);
            return bundle;
        }
        str = "";
        bundle.putString("spread_data", str);
        bundle.putString(com.heytap.mcssdk.a.a.f36102l, this.f343073a);
        bundle.putString("source", this.f343074b);
        return bundle;
    }

    public synchronized boolean a(HashMap<String, SpreadValue> hashMap, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, hashMap, str, str2)).booleanValue();
        }
        HashMap<String, SpreadValue> a16 = this.f343077e.a();
        boolean z16 = false;
        for (Map.Entry<String, SpreadValue> entry : hashMap.entrySet()) {
            if (!a16.containsKey(entry.getKey())) {
                entry.getValue().c(str);
                entry.getValue().d(str2);
                entry.getValue().b(System.currentTimeMillis());
                a16.put(entry.getKey(), entry.getValue());
            } else if (a16.get(entry.getKey()) != null && !a16.get(entry.getKey()).equals(entry.getValue())) {
                String key = entry.getKey();
                SpreadValue spreadValue = a16.get(key);
                spreadValue.e(entry.getValue().f());
                spreadValue.a(entry.getValue().a());
                spreadValue.f(entry.getValue().g());
                spreadValue.g(entry.getValue().h());
                spreadValue.c(str);
                spreadValue.d(str2);
                spreadValue.b(System.currentTimeMillis());
                a16.put(key, spreadValue);
            }
            z16 = true;
        }
        com.tencent.qimei.ad.c.b("SpreadQM", "update data,from:appKey:%s  source:%s  updateResult:%b", str, str2, Boolean.valueOf(z16));
        if (z16) {
            this.f343077e.a(a16);
            b.a.f342891a.a("sp_need_report", true);
            b bVar = new b();
            DataFormatter dataFormatter = this.f343077e;
            synchronized (DataFormatter.class) {
                com.tencent.qimei.ad.c.b("SpreadQM", "writeToCache blockWrite result %b", Boolean.valueOf(new com.tencent.qimei.v.b().a("spread_data", new com.tencent.qimei.am.a(bVar, bVar.a(), dataFormatter), 3)));
            }
        }
        return z16;
    }
}
