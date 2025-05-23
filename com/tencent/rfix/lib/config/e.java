package com.tencent.rfix.lib.config;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.rdelivery.net.BaseProto$PullTarget;
import com.tencent.rdelivery.net.BaseProto$ServerType;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements iz3.e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f364942e;

    /* renamed from: f, reason: collision with root package name */
    public static int f364943f;

    /* renamed from: a, reason: collision with root package name */
    private final Context f364944a;

    /* renamed from: b, reason: collision with root package name */
    private final RFixParams f364945b;

    /* renamed from: c, reason: collision with root package name */
    private final a f364946c;

    /* renamed from: d, reason: collision with root package name */
    private RDelivery f364947d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f364942e = 0;
            f364943f = -1;
        }
    }

    public e(Context context, RFixParams rFixParams, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, rFixParams, aVar);
            return;
        }
        this.f364944a = context;
        this.f364945b = rFixParams;
        this.f364946c = aVar;
    }

    private int c(String str) {
        return Integer.parseInt(str.substring(0, str.indexOf(35)));
    }

    private Map<String, String> d(RFixParams rFixParams) {
        HashMap hashMap = new HashMap();
        for (String str : rFixParams.getCustomProperties()) {
            hashMap.put(str, rFixParams.getCustomProperty(str));
        }
        return hashMap;
    }

    private RDelivery e(RFixParams rFixParams) {
        if (this.f364947d != null) {
            this.f364947d.L(h(rFixParams.getUserId()));
            return this.f364947d;
        }
        if (rFixParams.getInitMMKVInternal()) {
            MMKV.T(this.f364944a);
        }
        RDelivery i3 = RDelivery.i(this.f364944a, new RDeliverySetting.a().N(rFixParams.getAppId()).O(rFixParams.getAppKey()).n0(h(rFixParams.getUserId())).X(h(rFixParams.getDeviceModel())).W(h(rFixParams.getDeviceManufacturer())).d0(h(rFixParams.getAppVersion(this.f364944a))).M(String.valueOf(Build.VERSION.SDK_INT)).S(d(rFixParams)).k0("10021").h0(BaseProto$PullTarget.APP).T(g()).Z(true).a(), new com.tencent.rdelivery.a(new f(this.f364944a), new MmkvStorage.b(), new com.tencent.rdelivery.dependencyimpl.a(), new d()), null);
        this.f364947d = i3;
        return i3;
    }

    private BaseProto$ServerType g() {
        if (new RFixGlobalPreferences(this.f364944a).testEnvEnable) {
            return BaseProto$ServerType.TEST;
        }
        return BaseProto$ServerType.RELEASE;
    }

    private String h(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private void i(RDeliveryData rDeliveryData) {
        c cVar;
        if (rDeliveryData.getConfigValue() == null) {
            RFixLog.e("RFix.RDeliveryManager", "processData config value is empty!");
            return;
        }
        try {
            cVar = new c(c(rDeliveryData.getDebugInfo()), rDeliveryData.getConfigValue());
        } catch (Exception e16) {
            RFixLog.e("RFix.RDeliveryManager", "processData fail!", e16);
            cVar = null;
        }
        if (cVar != null) {
            k(f364942e, cVar);
        }
    }

    private void k(int i3, c cVar) {
        try {
            this.f364946c.g(i3, cVar);
        } catch (Exception e16) {
            RFixLog.e("RFix.RDeliveryManager", "updateDeliveryConfig fail!", e16);
        }
    }

    @Override // iz3.e, iz3.m
    public /* synthetic */ void a(List list, List list2, List list3) {
        iz3.d.a(this, list, list2, list3);
    }

    public Pair<RDelivery, iz3.e> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Pair<>(e(this.f364945b), this);
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            e(this.f364945b).G(this);
        }
    }

    @Override // iz3.m
    public void onFail(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        RFixLog.d("RFix.RDeliveryManager", "onFail msg: " + str);
        if ("config result empty".equals(str)) {
            k(f364942e, null);
        } else {
            k(f364943f, null);
        }
    }

    @Override // iz3.e
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RDeliveryData x16 = this.f364947d.x("fix_portal_" + this.f364945b.getAppId());
        RFixLog.d("RFix.RDeliveryManager", "onSuccess data: " + x16);
        if (x16 != null) {
            i(x16);
        } else {
            k(f364942e, null);
        }
    }
}
