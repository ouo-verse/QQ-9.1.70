package lb3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$CommonExt;
import com.tencent.mobileqq.wxmini.wxacontainer.WxAppInterface;
import com.tencent.mobileqq.wxmini.wxacontainer.growth.GameGrowthDialog;
import com.tencent.mobileqq.wxmini.wxacontainer.growth.GameGrowthWebView;
import com.tencent.mobileqq.wxmini.wxacontainer.request.WxaSSOHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J \u0010\u001b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\bJ\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105\u00a8\u0006="}, d2 = {"Llb3/g;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "", "delay", "", "v", "l", "", "factType", "t", "Llb3/h;", "instruction", "", "p", DomainData.DOMAIN_NAME, "", "url", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "guardInstruction", "y", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, HippyTKDListViewAdapter.X, "B", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pageId", "k", "Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "b", "Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "previousJudgeExt", "c", "J", "startJudgeTime", "d", "lastJudgeTime", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "nextJudgeRunnable", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wxmini/wxacontainer/growth/GameGrowthDialog;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "dialogList", "g", "Z", "isDestroy", tl.h.F, "isStart", "i", "needExsit", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static UserGrowGuard$CommonExt previousJudgeExt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long startJudgeTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastJudgeTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Runnable nextJudgeRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean isDestroy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isStart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean needExsit;

    /* renamed from: a, reason: collision with root package name */
    public static final g f414306a = new g();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static ArrayList<GameGrowthDialog> dialogList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"lb3/g$a", "Lnb3/a;", "", "type", "", "isSuccess", "", "data", "", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends nb3.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f414315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f414316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WxaInfo f414317f;

        a(int i3, Activity activity, WxaInfo wxaInfo) {
            this.f414315d = i3;
            this.f414316e = activity;
            this.f414317f = wxaInfo;
        }

        @Override // nb3.a
        public void a(int type, boolean isSuccess, Object data) {
            int coerceAtLeast;
            QLog.i("[wxa-q]GameGrowthManager", 1, "judgeTiming onReceive type: " + type + ", isSuccess:" + isSuccess + ", data:" + data);
            if (type == 1 && (data instanceof JudgeTimingData)) {
                g gVar = g.f414306a;
                JudgeTimingData judgeTimingData = (JudgeTimingData) data;
                g.previousJudgeExt = judgeTimingData.getLastExt();
                List<GuardInstruction> a16 = judgeTimingData.a();
                Activity activity = this.f414316e;
                WxaInfo wxaInfo = this.f414317f;
                Iterator<T> it = a16.iterator();
                while (it.hasNext()) {
                    g.needExsit = g.f414306a.p(activity, wxaInfo, (GuardInstruction) it.next());
                    if (g.needExsit) {
                        return;
                    }
                }
                if (this.f414315d != 13) {
                    g gVar2 = g.f414306a;
                    Activity activity2 = this.f414316e;
                    WxaInfo wxaInfo2 = this.f414317f;
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(judgeTimingData.getNextDuration(), 30);
                    gVar2.v(activity2, wxaInfo2, coerceAtLeast * 1000);
                }
            }
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GuardInstruction instruction, WxaInfo wxaInfo, GameGrowthDialog dialog, Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (instruction.getModal() == 1) {
            f414306a.y(wxaInfo, instruction);
            dialog.dismissAllowingStateLoss();
            activity.finish();
            dialogList.remove(dialog);
            return;
        }
        f414306a.y(wxaInfo, instruction);
        dialog.dismissAllowingStateLoss();
        dialogList.remove(dialog);
    }

    private final void l() {
        Runnable runnable = nextJudgeRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 128);
            nextJudgeRunnable = null;
        }
    }

    private final void n(final Activity activity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: lb3.f
            @Override // java.lang.Runnable
            public final void run() {
                g.o(activity);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (isDestroy) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(final Activity activity, final WxaInfo wxaInfo, final GuardInstruction instruction) {
        QLog.i("[wxa-q]GameGrowthManager", 1, "doExecuteInstruction instruction:" + instruction);
        int type = instruction.getType();
        if (type == 1) {
            z(activity, wxaInfo, instruction);
            return instruction.getModal() == 1;
        }
        if (type != 2) {
            if (type != 3) {
                QLog.e("[wxa-q]GameGrowthManager", 1, "doExecuteInstruction not support");
                return false;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: lb3.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.q(GuardInstruction.this, activity, wxaInfo);
                }
            });
            return true;
        }
        String url = instruction.getUrl();
        if (url == null || url.length() == 0) {
            z(activity, wxaInfo, instruction);
            return instruction.getModal() == 1;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: lb3.d
            @Override // java.lang.Runnable
            public final void run() {
                g.r(GuardInstruction.this, activity, wxaInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuardInstruction instruction, Activity activity, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        g gVar = f414306a;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        gVar.x(instruction, decorView, wxaInfo);
        gVar.u(activity, instruction.getUrl());
        gVar.y(wxaInfo, instruction);
        gVar.n(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(GuardInstruction instruction, Activity activity, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        g gVar = f414306a;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        gVar.x(instruction, decorView, wxaInfo);
        gVar.u(activity, instruction.getUrl());
        gVar.y(wxaInfo, instruction);
        gVar.n(activity);
    }

    private final void u(Activity activity, String url) {
        boolean z16 = true;
        QLog.e("[wxa-q]GameGrowthManager", 1, "openUrl url:" + url);
        if (url != null && url.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", url);
        intent.putExtra("fragmentClass", GameGrowthWebView.class);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(final Activity activity, final WxaInfo wxaInfo, long delay) {
        QLog.i("[wxa-q]GameGrowthManager", 1, "pollJudgeTiming start delay:" + delay);
        l();
        nextJudgeRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: lb3.b
            @Override // java.lang.Runnable
            public final void run() {
                g.w(activity, wxaInfo);
            }
        }, 128, null, false, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Activity activity, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        f414306a.t(activity, wxaInfo, 12);
    }

    private final void x(GuardInstruction instruction, View rootView, WxaInfo wxaInfo) {
        String str;
        int reportScene = instruction.getReportScene();
        if (reportScene == 1) {
            str = "pg_applet_real_name_auth";
        } else if (reportScene == 2) {
            str = "pg_applet_underage_tips_proper_time";
        } else if (reportScene != 5) {
            QLog.e("[wxa-q]GameGrowthManager", 1, "error scene instruction:" + instruction);
            str = null;
        } else {
            str = "pg_applet_real_name_auth_doubt_minor";
        }
        if (str != null) {
            f414306a.k(rootView, str, wxaInfo);
            VideoReport.reportPgIn(rootView);
        }
    }

    private final void y(WxaInfo wxaInfo, GuardInstruction guardInstruction) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime instanceof WxAppInterface) {
            String wxAppId = wxaInfo.getWxAppId();
            if (!(wxAppId == null || wxAppId.length() == 0)) {
                BusinessHandler businessHandler = ((WxAppInterface) waitAppRuntime).getBusinessHandler(WxaSSOHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wxmini.wxacontainer.request.WxaSSOHandler");
                String wxAppId2 = wxaInfo.getWxAppId();
                Intrinsics.checkNotNull(wxAppId2);
                ((WxaSSOHandler) businessHandler).H2(wxAppId2, guardInstruction, null);
                return;
            }
        }
        QLog.e("[wxa-q]GameGrowthManager", 1, "reportExecute error appinterface:" + waitAppRuntime);
    }

    private final void z(final Activity activity, final WxaInfo wxaInfo, final GuardInstruction instruction) {
        String title = instruction.getTitle();
        if (!(title == null || title.length() == 0)) {
            String msg2 = instruction.getMsg();
            if (!(msg2 == null || msg2.length() == 0)) {
                String btnText = instruction.getBtnText();
                if (!(btnText == null || btnText.length() == 0)) {
                    if (isDestroy) {
                        return;
                    }
                    QLog.i("[wxa-q]GameGrowthManager", 1, "showDialog isLandscape:" + (activity.getRequestedOrientation() == 0));
                    final GameGrowthDialog gameGrowthDialog = new GameGrowthDialog();
                    gameGrowthDialog.setTitle(instruction.getTitle());
                    gameGrowthDialog.sh(instruction.getMsg());
                    gameGrowthDialog.rh(instruction.getBtnText());
                    gameGrowthDialog.uh(new DialogInterface.OnClickListener() { // from class: lb3.e
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            g.A(GuardInstruction.this, wxaInfo, gameGrowthDialog, activity, dialogInterface, i3);
                        }
                    });
                    if (!(activity instanceof FragmentActivity)) {
                        QLog.e("[wxa-q]GameGrowthManager", 1, "showDialog error activity not FragmentActivity");
                        return;
                    }
                    gameGrowthDialog.vh(wxaInfo);
                    gameGrowthDialog.th(instruction);
                    gameGrowthDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "GameGrowthDialog");
                    dialogList.add(gameGrowthDialog);
                    return;
                }
            }
        }
        QLog.e("[wxa-q]GameGrowthManager", 1, "showDialog error msg params");
    }

    public final void B(Activity activity, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        if (needExsit) {
            QLog.i("[wxa-q]GameGrowthManager", 1, "startJudgeTiming needExsit");
            return;
        }
        isDestroy = false;
        l();
        t(activity, wxaInfo, !isStart ? 11 : 12);
        isStart = true;
    }

    public final void k(View rootView, String pageId, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        VideoReport.setPageId(rootView, pageId);
        HashMap hashMap = new HashMap();
        String wxAppId = wxaInfo.getWxAppId();
        if (wxAppId == null) {
            wxAppId = "";
        }
        hashMap.put("applet_appid", wxAppId);
        hashMap.put("host_scene", String.valueOf(wxaInfo.getScene()));
        hashMap.put("applet_type", "1");
        String openId = wxaInfo.getOpenId();
        hashMap.put(StartupReportKey.WX_OPENID, openId != null ? openId : "");
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
    }

    public final void m() {
        QLog.i("[wxa-q]GameGrowthManager", 1, "destroy");
        Iterator<T> it = dialogList.iterator();
        while (it.hasNext()) {
            ((GameGrowthDialog) it.next()).dismissAllowingStateLoss();
        }
        dialogList.clear();
        isDestroy = true;
    }

    public final void s(Activity activity, WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        if (needExsit) {
            QLog.i("[wxa-q]GameGrowthManager", 1, "endJudgeTiming needExsit");
        } else {
            l();
            t(activity, wxaInfo, 13);
        }
    }

    private final void t(Activity activity, WxaInfo wxaInfo, int factType) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime instanceof WxAppInterface) {
            String wxAppId = wxaInfo.getWxAppId();
            if (!(wxAppId == null || wxAppId.length() == 0)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (factType == 11) {
                    startJudgeTime = currentTimeMillis;
                    lastJudgeTime = currentTimeMillis;
                }
                long j3 = 1000;
                int i3 = (int) ((currentTimeMillis - lastJudgeTime) / j3);
                int i16 = (int) ((currentTimeMillis - startJudgeTime) / j3);
                lastJudgeTime = currentTimeMillis;
                QLog.i("[wxa-q]GameGrowthManager", 1, "judgeTiming appId:" + wxaInfo.getWxAppId() + ", factType:" + factType + " duration:" + i3);
                BusinessHandler businessHandler = ((WxAppInterface) waitAppRuntime).getBusinessHandler(WxaSSOHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wxmini.wxacontainer.request.WxaSSOHandler");
                WxaSSOHandler wxaSSOHandler = (WxaSSOHandler) businessHandler;
                String wxAppId2 = wxaInfo.getWxAppId();
                Intrinsics.checkNotNull(wxAppId2);
                UserGrowGuard$CommonExt userGrowGuard$CommonExt = previousJudgeExt;
                if (userGrowGuard$CommonExt == null) {
                    userGrowGuard$CommonExt = new UserGrowGuard$CommonExt();
                }
                wxaSSOHandler.G2(wxAppId2, factType, userGrowGuard$CommonExt, i3, i16, new a(factType, activity, wxaInfo));
                return;
            }
        }
        QLog.e("[wxa-q]GameGrowthManager", 1, "judgeTiming error appinterface:" + waitAppRuntime);
    }
}
