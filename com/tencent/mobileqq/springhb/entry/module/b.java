package com.tencent.mobileqq.springhb.entry.module;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.BreathLightData;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.mobileqq.springhb.entry.worker.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0014\u0010)\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/b;", "Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "", "isRed", "", ReportConstant.COSTREPORT_PREFIX, "l", "", "activityId", "t", "p", "e", "d", "b", tl.h.F, "Lcom/tencent/mobileqq/springhb/entry/model/BreathLightData;", "breathLightData", "Lcom/tencent/mobileqq/springhb/entry/model/UserData$UserDataItem;", "userDataItem", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "topMargin", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "Z", "isBreathShowing", "f", "isRedBreath", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/portal/BreathEffectView;", "k", "()Lcom/tencent/mobileqq/portal/BreathEffectView;", "mBreathEffectView", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends e.b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.worker.d springApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isBreathShowing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRedBreath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/b$a;", "", "", "BREATH_LIGHT_SHOW_DURATION", "J", "", "MSG_HIDE_NORMAL_BREATH_LIGHT", "I", "", "REPORT_VALUE_ENTRANCE", "Ljava/lang/String;", "REPORT_VALUE_ITEM", "REPORT_VALUE_SUBMODULE", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.module.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.mobileqq.springhb.entry.worker.d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
            return;
        }
        this.springApi = springApi;
        springApi.l().c(this);
        this.uiHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.springhb.entry.module.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean u16;
                u16 = b.u(b.this, message);
                return u16;
            }
        });
    }

    private final BreathEffectView k() {
        View findViewById = this.springApi.i().e().findViewById(R.id.d7a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "springApi.conversationAp\u2026ById(R.id.hongbao_breath)");
        return (BreathEffectView) findViewById;
    }

    private final void l() {
        if (QLog.isColorLevel()) {
            QLog.d("SpringBreathLightModule", 2, "stopNormalActivityBreath");
        }
        k().stop();
    }

    private final void p(String activityId) {
        boolean z16;
        ISpringHbReportApi iSpringHbReportApi;
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("module_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("submodule_id", "breathlight");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
        if (activityId != null && activityId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            hashMap.put("changci_id", activityId);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.reportForGameCenter(hashMap);
        }
    }

    private final void s(boolean isRed) {
        QLog.d("SpringBreathLightModule", 2, "showNormalActivityBreath isRed = " + isRed);
        if (isRed) {
            k().o(2);
        } else {
            k().o(1);
        }
    }

    private final void t(String activityId) {
        boolean z16;
        ISpringHbReportApi iSpringHbReportApi;
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_top_banner");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "em_imp");
        hashMap.put("item_id", "em_top_baner_breath_light");
        if (activityId != null && activityId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            hashMap.put("changci_id", activityId);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.reportForSpringHb(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(b this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("SpringBreathLightModule", 1, "handleMessage ,msg.what =  " + msg2.what);
        if (msg2.what == 2) {
            QLog.d("SpringBreathLightModule", 1, "handleMessage ,MSG_HIDE_NORMAL_BREATH_LIGHT");
            this$0.m();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.b();
        QLog.d("SpringBreathLightModule", 1, "onDrawerClose isBreathShowing:", Boolean.valueOf(this.isBreathShowing));
        if (this.isBreathShowing && k().getAnimation() == null) {
            QLog.d("SpringBreathLightModule", 1, "onDrawerClose aniamtion is null, restart animation.");
            s(this.isRedBreath);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 1, "onDesktopClosed isBreathShowing:" + this.isBreathShowing);
        if (this.isBreathShowing) {
            s(this.isRedBreath);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 1, "onMiniAppDesktopOpen isBreathShowing:" + this.isBreathShowing);
        if (this.isBreathShowing) {
            l();
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 1, "onResume isBreathShowing:", Boolean.valueOf(this.isBreathShowing));
        if (this.isBreathShowing && k().getAnimation() == null) {
            QLog.d("SpringBreathLightModule", 1, "onResume aniamtion is null, restart animation.");
            s(this.isRedBreath);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 2, "onBreathLightHide");
        l();
        this.isBreathShowing = false;
    }

    public final void n(@Nullable BreathLightData breathLightData, @NotNull UserData.UserDataItem userDataItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) breathLightData, (Object) userDataItem);
            return;
        }
        Intrinsics.checkNotNullParameter(userDataItem, "userDataItem");
        if (!this.springApi.l().e()) {
            this.springApi.r().o(true);
            return;
        }
        if (this.springApi.t()) {
            QLog.d("SpringBreathLightModule", 1, "onBreathLightShow return ,is study or elder mode");
            return;
        }
        if (this.springApi.s()) {
            QLog.d("SpringBreathLightModule", 1, "onBreathLightShow return ,is pad");
            return;
        }
        if (userDataItem.hasDisplayBreathLight) {
            QLog.i("SpringBreathLightModule", 1, "onBreathLightShow return , has display breath light");
            return;
        }
        if (this.isBreathShowing) {
            QLog.d("SpringBreathLightModule", 1, "onBreathLightShow return ,is Breath Showing");
            return;
        }
        boolean z16 = false;
        if (breathLightData != null && breathLightData.type == 1) {
            z16 = true;
        }
        this.isRedBreath = z16;
        userDataItem.hasDisplayBreathLight = true;
        this.springApi.n().g0();
        s(this.isRedBreath);
        this.isBreathShowing = true;
        q();
        this.uiHandler.sendEmptyMessageDelayed(2, 5000L);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.uiHandler.removeCallbacksAndMessages(null);
        m();
    }

    public final void q() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("SpringBreathLightModule", 2, "report");
        if (!this.isBreathShowing || !this.springApi.l().e()) {
            return;
        }
        BaseActivityData j3 = this.springApi.j();
        if (j3 != null) {
            str = j3.f289093id;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            UserData.UserDataItem O = this.springApi.n().O(str);
            Intrinsics.checkNotNullExpressionValue(O, "springApi.manager.getUserDataItem(activityId)");
            if (O.isReportBreath) {
                return;
            }
            O.isReportBreath = true;
            this.springApi.n().g0();
        }
        p(str);
        t(str);
    }

    public final void r(int topMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, topMargin);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringBreathLightModule", 2, "resetBreathEffectViewPosition topMargin:", Integer.valueOf(topMargin));
        }
        if (topMargin <= 0) {
            k().stop();
            return;
        }
        ViewGroup.LayoutParams layoutParams = k().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = topMargin;
        k().setLayoutParams(layoutParams2);
        if (this.isBreathShowing) {
            s(this.isRedBreath);
        }
    }
}
