package com.tencent.luggage.wxa.t7;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.wxa.e5.j;
import com.tencent.luggage.wxa.q7.y;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.d;
import com.tencent.xweb.WebDebugCfg;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxaapi.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f140885h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final j f140886i = new j("wxasnapshotdebug.cfg", Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    public final WxaApi f140887a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140888b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140889c;

    /* renamed from: d, reason: collision with root package name */
    public final String f140890d;

    /* renamed from: e, reason: collision with root package name */
    public final String f140891e;

    /* renamed from: f, reason: collision with root package name */
    public final String f140892f;

    /* renamed from: g, reason: collision with root package name */
    public final String f140893g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f140894a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isRunningWithJSCoverageCollect", "isRunningWithJSCoverageCollect()Z", 0))};

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            c().putBoolean("KEY_IS_DEBUG_IP", z16);
        }

        public final boolean b() {
            return c().getBoolean("KEY_IS_DEBUG_IP", false);
        }

        public final f0 c() {
            return f0.c("wxasnapshotdebug.cfg", 2);
        }

        public final boolean d() {
            return c().getBoolean("KEY_MULTI_TASK", false);
        }

        public final boolean e() {
            return ((Boolean) b.f140886i.a(this, f140894a[0])).booleanValue();
        }

        public final String a() {
            String string = c().getString("KEY_DEBUG_IP", "101.91.22.184");
            Intrinsics.checkNotNull(string);
            return string;
        }

        public final void b(boolean z16) {
            c().putBoolean("KEY_MULTI_TASK", z16);
        }

        public final void c(boolean z16) {
            b.f140886i.a(this, f140894a[0], Boolean.valueOf(z16));
        }

        public final void a(String ip5) {
            Intrinsics.checkNotNullParameter(ip5, "ip");
            c().putString("KEY_DEBUG_IP", ip5);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t7.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6742b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f140895a;

        public RunnableC6742b(boolean z16) {
            this.f140895a = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(z.c(), "DebugIP\u5df2\u8bbe\u7f6e\u4e3a" + this.f140895a + "\uff0c\u91cd\u542fAPP\u751f\u6548", 0).show();
        }
    }

    public b(WxaApi wxaApi) {
        Intrinsics.checkNotNullParameter(wxaApi, "wxaApi");
        this.f140887a = wxaApi;
        this.f140888b = "http://debugxweb.qq.com/?show_webview_version";
        this.f140889c = "http://debugxweb.qq.com/?check_xwalk_update";
        this.f140890d = "http://debugxweb.qq.com/?inspector=true";
        this.f140891e = "http://debugxweb.qq.com/?set_apkver=-1";
        this.f140892f = "http://debugxweb.qq.com/?set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateconfig_wmpftest.xml&check_xwalk_update&";
        this.f140893g = "http://debugxweb.qq.com/";
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void debugXWeb(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        w.d("Luggage.WxaDebugApiSnapshotIMPL", "debugXWeb type:" + i3);
        switch (i3) {
            case 0:
                WebDebugCfg.getInst().setEnableLocalDebug(true);
                return;
            case 1:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140888b);
                return;
            case 2:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140889c);
                return;
            case 3:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140890d);
                return;
            case 4:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140891e);
                return;
            case 5:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140892f);
                return;
            case 6:
                WxaSimpleWebViewActivity.INSTANCE.a(context, this.f140893g);
                return;
            case 7:
                WebDebugCfg.getInst().setEnableLocalDebug(false);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void deleteLibFile() {
        y.f138216a.c();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public String getDebugIP() {
        return f140885h.a();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean getIsDebugIP() {
        return f140885h.b();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean isMultiTaskModeEnabledForWxaApp() {
        return f140885h.d();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean isRunningWithJSCoverageCollect() {
        return f140885h.e();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public long launchByQRRawData(Context context, String codeRawData, d dVar) {
        Intrinsics.checkNotNullParameter(codeRawData, "codeRawData");
        return this.f140887a.launchByQRRawData(context, codeRawData, null, dVar);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setDebugIP(String ip5) {
        Intrinsics.checkNotNullParameter(ip5, "ip");
        f140885h.a(ip5);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setIsDebugIP(boolean z16) {
        f140885h.a(z16);
        c0.a(new RunnableC6742b(z16));
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setIsRunningWithJSCoverageCollect(boolean z16) {
        f140885h.c(z16);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setMultiTaskModeEnabledForWxaApp(boolean z16) {
        f140885h.b(z16);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void testIlinkProcessRecreate() {
        com.tencent.luggage.wxa.en.a.b(z.c(), "com.tencent.ilink.ServiceProcess");
    }
}
