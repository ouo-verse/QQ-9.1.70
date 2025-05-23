package com.tencent.mobileqq.leba.entity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\fH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/c;", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/view/View;", "view", "", "o", "", "resId", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "actionParam", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, tl.h.F, "", "e", "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "c", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Ljava/lang/Runnable;", "runnable", "k", "clickActionParam", "g", "<init>", "()V", "d", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class c extends DefaultClickProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/c$a;", "", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "b", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.entity.c$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

        private final String b() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(769);
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            return jSONArray2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(n item) {
            boolean z16 = false;
            if (item == null) {
                return false;
            }
            long j3 = item.f240504a;
            if (j3 <= 0) {
                return false;
            }
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) api;
            if (iUnitedConfigManager.isSwitchOn("leba_more_page_click_ignore_red_info", true)) {
                try {
                    int length = new JSONArray(iUnitedConfigManager.loadAsString("leba_more_page_click_ignore_red_info", b())).length();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        if (j3 == r3.optInt(i3, 0)) {
                            z16 = true;
                            break;
                        }
                        i3++;
                    }
                } catch (Exception e16) {
                    QLog.e("Leba.DefaultClickProcessor", 1, "moreClickIgnoreRedPointInfo exception", e16);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Leba.DefaultClickProcessor", 4, "moreClickIgnoreRedPointInfo [" + j3 + "] switch: " + z16);
            }
            return z16;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17715);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final BusinessInfoCheckUpdate.AppInfo n(long resId) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        return ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(resId));
    }

    private final boolean o(View view) {
        ViewGroup viewGroup;
        View view2;
        if (view instanceof RedTouch) {
            return ((RedTouch) view).hasLebaRedTouch();
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            if (viewGroup != null) {
                view2 = viewGroup.getChildAt(0);
            } else {
                view2 = null;
            }
            if (view2 instanceof RedTouch) {
                RedTouch redTouch = (RedTouch) view2;
                QLog.d("Leba.DefaultClickProcessor", 4, "getHasRedFlag " + viewGroup + ", " + view2 + " " + redTouch.hasLebaRedTouch());
                return redTouch.hasLebaRedTouch();
            }
            if (view2 instanceof ViewGroup) {
                viewGroup = (ViewGroup) view2;
            } else {
                viewGroup = null;
            }
        }
        return false;
    }

    private final void p(Activity activity, DefaultClickProcessor.a actionParam) {
        Long l3;
        String l16 = actionParam.l();
        if (l16 != null && !Intrinsics.areEqual("", l16)) {
            QRouteApi api = QRoute.api(IMiniAppService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
            IMiniAppService iMiniAppService = (IMiniAppService) api;
            String str = null;
            if (iMiniAppService.isMiniAppUrl(l16)) {
                iMiniAppService.startMiniApp(activity, l16, LaunchScene.LAUNCH_SCENE_DYNAMIC_MINIAPP, null);
                return;
            }
            String g16 = actionParam.g();
            actionParam.k();
            boolean n3 = actionParam.n();
            boolean c16 = actionParam.c();
            String i3 = actionParam.i();
            boolean d16 = actionParam.d();
            BusinessInfoCheckUpdate.AppInfo a16 = actionParam.a();
            actionParam.j();
            actionParam.h();
            n e16 = actionParam.e();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
            ax c17 = bi.c((BaseQQAppInterface) peekAppRuntime, activity, l16);
            if (c17 != null) {
                Intrinsics.checkNotNull(e16);
                f(e16, c17);
                c17.r("from_leba", "fromleba");
                LebaPluginInfo lebaPluginInfo = e16.f240505b;
                if (lebaPluginInfo != null) {
                    l3 = Long.valueOf(lebaPluginInfo.uiResId);
                } else {
                    l3 = null;
                }
                c17.r("leba_resid", String.valueOf(l3));
                c17.r("config_res_plugin_item_name", g16);
                c17.r("redtouch_click_timestamp", String.valueOf((int) (NetConnInfoCenter.getServerTimeMillis() / 1000)));
                c17.A(n3);
                LebaPluginInfo lebaPluginInfo2 = e16.f240505b;
                if (lebaPluginInfo2 != null) {
                    str = lebaPluginInfo2.strPkgName;
                }
                c17.B(str);
                c17.D(i3);
                c17.x(c16);
                c17.y(d16);
                c17.t(a16);
                c17.b();
            }
        }
    }

    private final void q(Activity activity, DefaultClickProcessor.a actionParam) {
        boolean contains$default;
        LebaPluginInfo lebaPluginInfo;
        boolean contains$default2;
        String l3 = actionParam.l();
        actionParam.g();
        actionParam.k();
        actionParam.n();
        boolean c16 = actionParam.c();
        String i3 = actionParam.i();
        boolean d16 = actionParam.d();
        BusinessInfoCheckUpdate.AppInfo a16 = actionParam.a();
        actionParam.j();
        actionParam.h();
        actionParam.m();
        actionParam.o();
        n e16 = actionParam.e();
        actionParam.f();
        if (l3 != null && !Intrinsics.areEqual("", l3)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Long l16 = null;
            String c17 = new com.tencent.mobileqq.leba.business.urlreport.c(d16, a16).c(new com.tencent.mobileqq.leba.business.urlreport.e(null).c(new com.tencent.mobileqq.leba.business.urlreport.d(peekAppRuntime.getCurrentAccountUin()).c(l3)));
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) c17, (CharSequence) "plg_nld=1", false, 2, (Object) null);
            if (contains$default) {
                intent.putExtra("reportNld", true);
            }
            if (!TextUtils.isEmpty(i3)) {
                intent.putExtra("redTouch", i3);
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) c17, (CharSequence) "red_touch=1", false, 2, (Object) null);
                if (contains$default2) {
                    c17 = c17 + ContainerUtils.FIELD_DELIMITER + i3;
                }
            }
            Bundle b16 = actionParam.b();
            if (b16 != null) {
                intent.putExtras(b16);
            }
            intent.putExtra("uin", peekAppRuntime.getCurrentAccountUin());
            intent.putExtra("plugin_start_time", System.nanoTime());
            intent.putExtra("click_start_time", System.currentTimeMillis());
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("is_from_leba", true);
            if (e16 != null && (lebaPluginInfo = e16.f240505b) != null) {
                l16 = Long.valueOf(lebaPluginInfo.uiResId);
            }
            intent.putExtra("leba_resid", l16);
            intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, c16);
            intent.putExtra("url", c17);
            activity.startActivity(intent);
            return;
        }
        QLog.e("Leba.DefaultClickProcessor", 1, "openUrl url is null or empty ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Activity activity, String businessName, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(businessName, "$businessName");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        try {
            DialogUtil.createDisclaimerDialog(activity, activity.getResources().getString(R.string.w19), activity.getResources().getString(R.string.w17, businessName), activity.getResources().getString(R.string.w18), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.leba.entity.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    c.s(runnable, dialogInterface, i3);
                }
            }).show();
        } catch (Exception e16) {
            QLog.e("Leba.DefaultClickProcessor", 1, "showDisclaimerDialog ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Runnable runnable, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.run();
    }

    @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
    @NotNull
    public DefaultClickProcessor.a c(@NotNull View view, @NotNull n item, @NotNull f reportInfo) {
        String str;
        boolean z16;
        int i3;
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DefaultClickProcessor.a) iPatchRedirector.redirect((short) 4, this, view, item, reportInfo);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        DefaultClickProcessor.a aVar = new DefaultClickProcessor.a();
        aVar.y(item.f240505b.sResSubType);
        if (reportInfo.f240481e && INSTANCE.c(item)) {
            aVar.z(item.f240505b.strGotoUrl);
        } else {
            BusinessInfoCheckUpdate.AppInfo n3 = n(item.f240504a);
            if (n3 != null && n3.iNewFlag.get() != 0) {
                str = ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).getStringWithRedAppinfo(item.f240505b.strGotoUrl, n3);
            } else {
                str = item.f240505b.strGotoUrl;
            }
            aVar.z(str);
            boolean z17 = true;
            if (reportInfo.f240479c != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (TianshuRedTouch.INSTANCE.j()) {
                aVar.s(z16);
            } else {
                aVar.s(o(view));
            }
            QLog.d("Leba.DefaultClickProcessor", 4, "ClickAction hasRedDot = " + z16);
            aVar.u(z16);
            aVar.p(n3);
            BusinessInfoCheckUpdate.AppInfo a16 = aVar.a();
            if (a16 != null && (pBUInt32Field = a16.type) != null) {
                i3 = pBUInt32Field.get();
            } else {
                i3 = -1;
            }
            if (i3 != 0) {
                z17 = false;
            }
            aVar.r(z17);
        }
        aVar.t(item);
        return aVar;
    }

    @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
    @NotNull
    public String e(@NotNull n item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        LebaPluginInfo lebaPluginInfo = item.f240505b;
        if (lebaPluginInfo != null) {
            str = lebaPluginInfo.strResName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
    public void g(@NotNull Activity activity, @NotNull DefaultClickProcessor.a clickActionParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) clickActionParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(clickActionParam, "clickActionParam");
        short k3 = clickActionParam.k();
        QLog.i("Leba.DefaultClickProcessor", 1, "jumpByClickAction clickActionParam [" + ((int) k3) + "]: " + clickActionParam.l() + "\u300d");
        short k16 = clickActionParam.k();
        if (k16 != 0) {
            if (k16 == 2) {
                p(activity, clickActionParam);
                return;
            }
            return;
        }
        q(activity, clickActionParam);
    }

    @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
    public boolean h(@NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }

    @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
    public void k(@NotNull final Activity activity, @NotNull final String businessName, @NotNull final Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, businessName, runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.entity.a
            @Override // java.lang.Runnable
            public final void run() {
                c.r(activity, businessName, runnable);
            }
        });
    }
}
