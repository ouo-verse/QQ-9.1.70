package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.b;
import com.qq.e.comm.plugin.base.ad.e.a;
import com.qq.e.comm.plugin.base.ad.model.f;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.k.i;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DirectLauncherNode extends AbsJumpNode {

    /* renamed from: e, reason: collision with root package name */
    private String f38557e;

    /* renamed from: f, reason: collision with root package name */
    private String f38558f;

    public DirectLauncherNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        String a16 = i.a(this.f38545c, this.f38544b.f());
        this.f38557e = a16;
        return ay.b(a16) || b();
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        String optString = this.f38545c.optString("cl");
        this.f38558f = d.c(this.f38545c).b();
        b a16 = z.a(this.f38544b, true);
        ClickInfo clickInfo = this.f38544b;
        if (clickInfo != null && !TextUtils.isEmpty(clickInfo.p())) {
            a16.a("act_code", 506);
        }
        Context b16 = this.f38544b.b().b();
        if (b16 == null) {
            return 2;
        }
        if (!TextUtils.isEmpty(this.f38557e)) {
            a.d(this.f38544b.e(), this.f38544b.d(), this.f38545c);
            boolean z16 = false;
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_TRY_TO_OPEN_APP_WITH_DEEPLINK, 0, a16);
            if (a(b16, this.f38558f, optString, this.f38557e)) {
                a.e(this.f38544b.e(), this.f38544b.d(), this.f38545c);
                a.h(this.f38544b.e(), this.f38544b.d(), this.f38545c);
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_SUCCESS, 0, a16);
            } else {
                a.i(this.f38544b.e(), this.f38544b.d(), this.f38545c);
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_FAILED, 0, a16);
                if (b() && !TextUtils.isEmpty(this.f38558f)) {
                    z16 = a(optString, this.f38558f, a16, b16);
                }
                if (!z16) {
                    return 2;
                }
            }
        } else if (TextUtils.isEmpty(this.f38558f) || !a(optString, this.f38558f, a16, b16)) {
            return 2;
        }
        return this.f38544b.r() ? 4 : 3;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public void a(AbsJumpNode.a aVar) {
        super.a(aVar);
    }

    private boolean a(String str, String str2, b bVar, Context context) {
        StatTracer.trackEvent(4002021, 0, bVar);
        boolean a16 = a(context, str2, str, (String) null);
        if (!a16) {
            StatTracer.trackEvent(4002023, 0, bVar);
        } else {
            StatTracer.trackEvent(4002022, 0, bVar);
        }
        return a16;
    }

    private boolean a(Context context, String str, String str2, String str3) {
        boolean z16 = false;
        if (!StringUtil.isEmpty(str3) && !com.qq.e.comm.plugin.base.ad.e.a.a.a(context, str, (String) null, str3)) {
            return false;
        }
        String a16 = com.qq.e.comm.plugin.base.ad.e.a.a.a(str3, str2, this.f38544b.e());
        try {
            Intent a17 = com.qq.e.comm.plugin.base.ad.e.a.a.a(context, str, (String) null, TextUtils.isEmpty(a16) ? null : Uri.parse(a16));
            if (a17 == null) {
                return false;
            }
            if (b(context)) {
                z16 = StubVisitor.getInstance().jumpToActivityAndRegisterCallback(context, a17);
                GDTLogger.i("DirectLauncherNode[tryLaunch] jumpToActivityAndRegisterCallback:" + z16);
            }
            if (!z16) {
                context.startActivity(a17);
            }
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            GDTLogger.report("ExceptionIn DownClickRunnable.startInstalledAPP", th5);
            return z16;
        }
    }

    private boolean a(Context context) {
        ClickInfo clickInfo = this.f38544b;
        if (clickInfo != null && clickInfo.d() != null) {
            if (!c.a("supportDualOpenH5", 1, 1)) {
                GDTLogger.i("[shouldStartSystemWindowCheck] sdk switch not open");
                return false;
            }
            if (!(context instanceof Activity)) {
                GDTLogger.e("DirectLauncherNodeDelayLandingPageManager[shouldStartSystemWindowCheck] context error");
                return false;
            }
            if (this.f38544b.d().a() && !this.f38544b.q()) {
                f d16 = this.f38544b.d();
                if (d16 != null && !d16.aq()) {
                    GDTLogger.i("DirectLauncherNodeDelayLandingPageManager[shouldStartSystemWindowCheck] is not isDeeplinkFallbackToH5 Ad");
                    return false;
                }
                GDTLogger.i("DirectLauncherNodeDelayLandingPageManager[shouldStartSystemWindowCheck] is isDeeplinkFallbackToH5 Ad");
                return com.qq.e.comm.plugin.base.ad.e.a.a.a(context, this.f38558f, (String) null, this.f38557e);
            }
            GDTLogger.i("[shouldStartSystemWindowCheck] ad type not match:DelayLandingPageManager,isContact:" + this.f38544b.d().a() + ",needReportContractRl" + this.f38544b.q());
            return false;
        }
        GDTLogger.e("DirectLauncherNodeDelayLandingPageManager[registerDelayWebView] clickInfo is null");
        return false;
    }

    private boolean b() {
        return com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(this.f38545c) && !this.f38544b.d().S();
    }

    private boolean b(Context context) {
        if (this.f38544b == null) {
            GDTLogger.e("DirectLauncherNodeDelayLandingPageManager[registerDelayWebView] clickInfo is null");
            return false;
        }
        if (!a(context)) {
            GDTLogger.e("DirectLauncherNodeDelayLandingPageManager[registerDelayWebView] not match");
            return false;
        }
        GDTLogger.i("DirectLauncherNodeDelayLandingPageManager[handleDelayWebView]");
        b.C0280b c0280b = new b.C0280b();
        c0280b.f38584b = this.f38545c;
        if (!TextUtils.isEmpty(this.f38544b.p())) {
            c0280b.f38583a = this.f38544b.p();
            c0280b.f38586d = 506;
            GDTLogger.i("DirectLauncherNodeDelayLandingPageManager[use reward landing page url]" + c0280b.f38583a);
        } else {
            c0280b.f38583a = this.f38544b.h();
            c0280b.f38586d = 502;
            GDTLogger.i("DirectLauncherNodeDelayLandingPageManager[use rl url]" + c0280b.f38583a);
        }
        c0280b.f38585c = new WeakReference<>((Activity) context);
        try {
            com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.a().a(c0280b);
            StatTracer.trackEvent(13200301, 0, (com.qq.e.comm.plugin.stat.b) null);
            return true;
        } catch (Throwable th5) {
            GDTLogger.e("DirectLauncherNodeDelayLandingPageManager[handleDelayWebView] error", th5);
            return false;
        }
    }
}
