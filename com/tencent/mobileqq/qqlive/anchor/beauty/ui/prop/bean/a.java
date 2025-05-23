package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f270491a;

    /* renamed from: b, reason: collision with root package name */
    public String f270492b;

    /* renamed from: c, reason: collision with root package name */
    public String f270493c;

    /* renamed from: d, reason: collision with root package name */
    public String f270494d;

    /* renamed from: e, reason: collision with root package name */
    public int f270495e;

    /* renamed from: f, reason: collision with root package name */
    public int f270496f;

    /* renamed from: g, reason: collision with root package name */
    public String f270497g;

    /* renamed from: h, reason: collision with root package name */
    public String f270498h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f270499i;

    /* renamed from: j, reason: collision with root package name */
    public int f270500j;

    /* renamed from: k, reason: collision with root package name */
    public int f270501k;

    /* renamed from: l, reason: collision with root package name */
    public String f270502l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f270503m;

    /* renamed from: n, reason: collision with root package name */
    private final IAegisLogApi f270504n;

    /* renamed from: o, reason: collision with root package name */
    private MaterialStatusItem f270505o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.a f270506p;

    public a(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f270491a = "";
        this.f270504n = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f270505o = new MaterialStatusItem();
        this.f270491a = str;
        this.f270506p = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache.a();
        e();
    }

    private void e() {
        this.f270505o.f270490c = this.f270506p.a("PROP_ITEM_SELECTED_" + this.f270491a, false);
        this.f270505o.f270488a = this.f270506p.b("PROP_ITEM_DOWN_LOAD_STATUS_PATH_" + this.f270491a, 0);
        this.f270505o.f270489b = this.f270506p.c("PROP_ITEM_LOCAL_PATH_" + this.f270491a, "");
    }

    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        a aVar = new a();
        aVar.f270491a = this.f270491a;
        aVar.f270492b = this.f270492b;
        aVar.f270493c = this.f270493c;
        aVar.f270494d = this.f270494d;
        aVar.f270495e = this.f270495e;
        aVar.f270496f = this.f270496f;
        aVar.f270497g = this.f270497g;
        aVar.f270498h = this.f270498h;
        aVar.f270499i = this.f270499i;
        aVar.f270500j = this.f270500j;
        aVar.f270501k = this.f270501k;
        aVar.f270502l = this.f270502l;
        aVar.f270491a = this.f270491a;
        aVar.f270503m = this.f270503m;
        return aVar;
    }

    public boolean b(@Nullable a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar)).booleanValue();
        }
        String str2 = aVar.f270491a;
        if (str2 != null && (str = this.f270491a) != null) {
            if (!str2.equalsIgnoreCase(str)) {
                return false;
            }
            return true;
        }
        this.f270504n.e("MaterialItem", "equals failed, newItem customId = " + aVar.f270491a + ", this customId = " + this.f270491a);
        return false;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f270505o.f270488a;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f270505o.f270490c;
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f270505o.f270488a = i3;
        if (i3 == 1) {
            i3 = 0;
        }
        this.f270506p.e("PROP_ITEM_DOWN_LOAD_STATUS_PATH_" + this.f270491a, i3);
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.f270505o.f270490c = z16;
        this.f270506p.d("PROP_ITEM_SELECTED_" + this.f270491a, z16);
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f270505o.f270489b = str;
        this.f270506p.f("PROP_ITEM_LOCAL_PATH_" + this.f270491a, str);
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("MaterialItem = [");
        stringBuffer.append("customId = ");
        stringBuffer.append(this.f270491a);
        stringBuffer.append(",");
        stringBuffer.append("name = ");
        stringBuffer.append(this.f270492b);
        stringBuffer.append(",");
        stringBuffer.append("sdkVersion = ");
        stringBuffer.append(this.f270493c);
        stringBuffer.append(",");
        stringBuffer.append("thumbUrl = ");
        stringBuffer.append(this.f270494d);
        stringBuffer.append(",");
        stringBuffer.append("thumbWidth = ");
        stringBuffer.append(this.f270495e);
        stringBuffer.append(",");
        stringBuffer.append("thumbHeight = ");
        stringBuffer.append(this.f270496f);
        stringBuffer.append(",");
        stringBuffer.append("packageUrl = ");
        stringBuffer.append(this.f270497g);
        stringBuffer.append(",");
        stringBuffer.append("checkSumMd5 = ");
        stringBuffer.append(this.f270498h);
        stringBuffer.append(",");
        stringBuffer.append("updateTime = ");
        stringBuffer.append(this.f270500j);
        stringBuffer.append(",");
        stringBuffer.append("onlineTime = ");
        stringBuffer.append(this.f270501k);
        stringBuffer.append(",");
        stringBuffer.append("displayName = ");
        stringBuffer.append(this.f270502l);
        stringBuffer.append(",");
        stringBuffer.append("customId = ");
        stringBuffer.append(this.f270491a);
        stringBuffer.append(",");
        stringBuffer.append("isCollected = ");
        stringBuffer.append(this.f270503m);
        stringBuffer.append(",");
        stringBuffer.append(this.f270505o.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f270491a = "";
        this.f270504n = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f270505o = new MaterialStatusItem();
    }
}
