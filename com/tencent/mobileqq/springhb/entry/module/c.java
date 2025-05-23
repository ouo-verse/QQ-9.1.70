package com.tencent.mobileqq.springhb.entry.module;

import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoSmartRefreshLayout;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\b\t*\u00011\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002R\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00102R\u0011\u00106\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/c;", "", "", "f", "", "a", "", "e", "d", "itemId", "operId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "subModuleId", "l", "", tl.h.F, "pendantType", "Lcom/tencent/mobileqq/springhb/entry/model/PendantData;", "pendantData", "p", "g", "o", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/widget/HongBaoSmartRefreshLayout;", "c", "k", "j", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "I", "getCurPendantType", "()I", "setCurPendantType", "(I)V", "curPendantType", "Lcom/tencent/mobileqq/springhb/entry/model/PendantData;", "getCurPendantData", "()Lcom/tencent/mobileqq/springhb/entry/model/PendantData;", "setCurPendantData", "(Lcom/tencent/mobileqq/springhb/entry/model/PendantData;)V", "curPendantData", "", "Ljava/util/Map;", "typeToNeedShowPendantData", "com/tencent/mobileqq/springhb/entry/module/c$b", "Lcom/tencent/mobileqq/springhb/entry/module/c$b;", "prePendantListener", "i", "()Z", "isPendantShowing", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.worker.d springApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int curPendantType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PendantData curPendantData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, PendantData> typeToNeedShowPendantData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b prePendantListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/c$a;", "", "", "REPORT_VALUE_CLOSE_SUBMODULE", "Ljava/lang/String;", "REPORT_VALUE_ENTRANCE", "REPORT_VALUE_ITEM_PENDANT", "REPORT_VALUE_ITEM_PENDANT_CLOSE", "REPORT_VALUE_PENDANT_TYPE_NORMAL", "REPORT_VALUE_PENDANT_TYPE_PRE_ACTIVITY", "REPORT_VALUE_PENDANT_TYPE_RED_DOT", "REPORT_VALUE_SUBMODULE", "TAG", "", "TYPE_NO_PENDANT", "I", "TYPE_PRE_ACTIVITY_PENDANT", "TYPE_REAL_ACTIVITY_PENDANT", "TYPE_RED_DOT_PENDANT", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.module.c$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/springhb/entry/module/c$b", "Lcom/tencent/widget/i;", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.widget.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.widget.i
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                c.this.k();
            }
        }

        @Override // com.tencent.widget.i
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("SpringPendantModule", 2, "showNormalActivityPendant onPendentCloseBtnClick");
            c.this.n();
            c.this.j();
            c.this.g(1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull com.tencent.mobileqq.springhb.entry.worker.d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
            return;
        }
        this.springApi = springApi;
        this.typeToNeedShowPendantData = new HashMap();
        this.prePendantListener = new b();
    }

    private final boolean a() {
        String str;
        if (!this.springApi.l().e()) {
            return false;
        }
        BaseActivityData j3 = this.springApi.j();
        if (j3 != null) {
            str = j3.f289093id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (this.curPendantType != 3) {
            UserData.UserDataItem O = this.springApi.n().O(str);
            Intrinsics.checkNotNullExpressionValue(O, "springApi.manager.getUserDataItem(activityId)");
            if (O.isReportPendant) {
                return false;
            }
            O.isReportPendant = true;
            this.springApi.n().g0();
        }
        return true;
    }

    private final String d() {
        String str;
        boolean z16;
        BaseActivityData j3 = this.springApi.j();
        if (j3 != null) {
            str = j3.f289093id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (this.curPendantType == 3) {
            return "";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return "";
        }
        return str;
    }

    private final String e() {
        int i3 = this.curPendantType;
        if (i3 != 1) {
            if (i3 != 3) {
                return "red_packet";
            }
            return "lucky_bag";
        }
        return "preheat";
    }

    private final void f() {
        c().t0();
        this.springApi.i().c().changeThirdContainerOffset(false);
        this.curPendantType = 0;
        this.curPendantData = null;
        this.typeToNeedShowPendantData.clear();
    }

    private final boolean h(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private final void l(String subModuleId, String operId) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        QLog.d("SpringPendantModule", 2, "reportPendantExpose");
        if (this.curPendantType == 0) {
            return;
        }
        BaseActivityData j3 = this.springApi.j();
        String str3 = null;
        if (j3 != null) {
            str = j3.f289093id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean F = this.springApi.n().F();
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("module_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("submodule_id", subModuleId);
        PendantData pendantData = this.curPendantData;
        if (pendantData != null) {
            str2 = pendantData.zplanJumpUrl;
        } else {
            str2 = null;
        }
        boolean z18 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && F) {
            hashMap.put("oper_res", "1");
        } else {
            hashMap.put("oper_res", "2");
        }
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, operId);
        hashMap.put(QCircleQualityReporter.KEY_OBJ_ID, String.valueOf(this.curPendantType));
        if (this.curPendantType == 2 && !this.springApi.k().h0()) {
            hashMap.put(QCircleQualityReporter.KEY_OBJ_ID, "4");
        }
        if (this.curPendantType != 3) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                hashMap.put("changci_id", str);
            }
        }
        PendantData pendantData2 = this.curPendantData;
        if (pendantData2 != null) {
            str3 = pendantData2.jumpUrl;
        }
        if (str3 == null || str3.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            PendantData pendantData3 = this.curPendantData;
            Intrinsics.checkNotNull(pendantData3);
            String str4 = pendantData3.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "curPendantData!!.jumpUrl");
            hashMap.put("ext1", str4);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
        }
    }

    private final void q(String itemId, String operId) {
        Map<String, String> mapOf;
        ISpringHbReportApi iSpringHbReportApi;
        if (this.curPendantType != 0) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("buss_id", "mqq"), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list"), TuplesKt.to("module_id", "md_top_banner"), TuplesKt.to("item_id", itemId), TuplesKt.to(WadlReportBuilder.TableElem.OPER_ID, operId), TuplesKt.to("ext5", e()), TuplesKt.to("changci_id", d()));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.reportForSpringHb(mapOf);
            }
        }
    }

    public final void b() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        BaseActivityData j3 = this.springApi.j();
        if (j3 != null) {
            str = j3.f289093id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        UserData.UserDataItem O = this.springApi.n().O(str);
        Intrinsics.checkNotNullExpressionValue(O, "springApi.manager.getUserDataItem(activityId)");
        O.isReportPendant = false;
        this.springApi.n().g0();
    }

    @NotNull
    public final HongBaoSmartRefreshLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HongBaoSmartRefreshLayout) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        View findViewById = this.springApi.i().e().findViewById(R.id.f71863pa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "springApi.conversationAp\u2026yId(R.id.recycler_scroll)");
        return (HongBaoSmartRefreshLayout) findViewById;
    }

    public final void g(int pendantType) {
        PendantData pendantData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, pendantType);
            return;
        }
        int i3 = 2;
        QLog.i("SpringPendantModule", 2, "hidePendant: pendantType = " + pendantType + ", curPendant = " + this.curPendantType + ", typeToNeedShowPendantData = " + this.typeToNeedShowPendantData);
        if (pendantType == 0) {
            f();
            return;
        }
        if (pendantType == this.curPendantType) {
            if (h(pendantType)) {
                i3 = 3;
                pendantData = this.typeToNeedShowPendantData.get(3);
            } else {
                pendantData = this.typeToNeedShowPendantData.get(2);
                if (pendantData == null) {
                    i3 = 1;
                    pendantData = this.typeToNeedShowPendantData.get(1);
                }
            }
            f();
            if (pendantData != null) {
                p(i3, pendantData);
            }
        }
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        boolean z16 = c().f384588z1;
        QLog.d("SpringPendantModule", 2, "isPendantShowing = " + z16);
        return z16;
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringPendantModule", 2, "markClickedPendantCloseBtn");
        }
        BaseActivityData j3 = this.springApi.j();
        if (j3 == null) {
            QLog.d("SpringPendantModule", 2, "markClickedPendantCloseBtn return activityData = null");
            return;
        }
        UserData.UserDataItem O = this.springApi.n().O(j3.f289093id);
        Intrinsics.checkNotNullExpressionValue(O, "springApi.manager.getUserDataItem(activityData.id)");
        O.hasClickCloseBtn = true;
        this.springApi.n().g0();
    }

    public final void k() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.springApi.n().g0();
        boolean F = this.springApi.n().F();
        PendantData pendantData = this.curPendantData;
        String str2 = null;
        if (pendantData != null) {
            str = pendantData.jumpUrl;
        } else {
            str = null;
        }
        if (pendantData != null) {
            str2 = pendantData.zplanJumpUrl;
        }
        boolean z17 = false;
        if (F) {
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                SpringToMainHelper.k(this.springApi.i().a(), str2, "1");
                m();
                return;
            }
        }
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            SpringToMainHelper.k(this.springApi.i().a(), str, "1");
            m();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            l(IndividuationUrlHelper.UrlId.PENDANT_HOME, "clk");
            q("em_lucky_pendant", "em_clk");
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            l("pendant_close", "clk");
            q("em_lucky_pendant_close", "em_clk");
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (!a()) {
                return;
            }
            l(IndividuationUrlHelper.UrlId.PENDANT_HOME, "exp");
            q("em_lucky_pendant", "em_imp");
            QLog.d("SpringPendantModule", 2, "reportPendantExp");
        }
    }

    public final boolean p(int pendantType, @NotNull PendantData pendantData) {
        BaseActivityData j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, pendantType, (Object) pendantData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(pendantData, "pendantData");
        if (this.springApi.t()) {
            QLog.i("SpringPendantModule", 1, "showPendant return : springApi.isStudyOrElderMode");
            return false;
        }
        if (this.springApi.s()) {
            QLog.d("SpringPendantModule", 1, "showPendant return ,is pad");
            return false;
        }
        QLog.i("SpringPendantModule", 2, "showPendant: pendantType = " + pendantType + ", curPendant = " + this.curPendantType);
        if (pendantType == 3 && c().f384580r1) {
            return false;
        }
        int i3 = this.curPendantType;
        if (i3 == 3 && pendantType == 2) {
            this.typeToNeedShowPendantData.put(Integer.valueOf(pendantType), pendantData);
            g(3);
            return false;
        }
        if (i3 == 3 && pendantType == 1) {
            this.typeToNeedShowPendantData.put(Integer.valueOf(pendantType), pendantData);
            return false;
        }
        if (pendantType == 3 && i3 == 2) {
            this.typeToNeedShowPendantData.put(Integer.valueOf(pendantType), pendantData);
            return false;
        }
        if (pendantType == 3 && i3 == 1) {
            PendantData pendantData2 = this.curPendantData;
            this.typeToNeedShowPendantData.put(Integer.valueOf(pendantType), pendantData);
            g(1);
            if (pendantData2 != null) {
                this.typeToNeedShowPendantData.put(1, pendantData2);
            }
            return false;
        }
        if (!this.springApi.n().V()) {
            QLog.e("SpringPendantModule", 1, "showPendant return isPendantShowSwitchOn = false");
            return false;
        }
        if (h(pendantType)) {
            BaseActivityData j16 = this.springApi.j();
            if (j16 == null) {
                QLog.e("SpringPendantModule", 1, "showPendant return activityData = null");
                return false;
            }
            UserData.UserDataItem O = this.springApi.n().O(j16.f289093id);
            Intrinsics.checkNotNullExpressionValue(O, "springApi.manager.getUserDataItem(activityData.id)");
            if (O.hasClickCloseBtn) {
                QLog.e("SpringPendantModule", 1, "showPendant return hasClicked = true");
                return false;
            }
        } else if (pendantType == 3 && (j3 = this.springApi.j()) != null) {
            UserData.UserDataItem O2 = this.springApi.n().O(j3.f289093id);
            Intrinsics.checkNotNullExpressionValue(O2, "springApi.manager.getUserDataItem(activityData.id)");
            if (O2.hasClickCloseBtn) {
                QLog.e("SpringPendantModule", 1, "showPendant return hasClicked = true");
                return false;
            }
        }
        if (pendantType == 2 && this.springApi.k().f289415m == 4) {
            QLog.e("SpringPendantModule", 1, "showPendant return when ShuaYiShua mState:", Integer.valueOf(this.springApi.k().f289415m));
            return false;
        }
        this.curPendantType = pendantType;
        this.curPendantData = pendantData;
        c().B0(pendantData);
        this.springApi.i().c().changeThirdContainerOffset(true);
        if (pendantType != 1) {
            if (pendantType == 2) {
                c().setPendantListener(this.springApi.k().C0);
            }
        } else {
            c().setPendantListener(this.prePendantListener);
        }
        o();
        return true;
    }
}
