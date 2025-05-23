package gu3;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.qqmini.sdk.action.RestartAction;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a implements Action<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f403374b = false;

    /* renamed from: a, reason: collision with root package name */
    private IMiniAppContext f403375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: gu3.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class DialogInterfaceOnClickListenerC10397a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC10397a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            if (a.f403374b) {
                a.this.f403375a.performAction(ServiceSubscribeEvent.obtain("onGameFix", "", 0));
                str = "2";
            } else {
                RestartAction.restart(a.this.f403375a);
                str = "1";
            }
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(a.this.f403375a.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(a.this.f403375a.getMiniAppInfo()), null, "page_view", "em_expo", SDKMiniProgramLpReportDC04239.RESERVERS_GAME_TIME_LOAD_POP, null, null, null, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(a.this.f403375a.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(a.this.f403375a.getMiniAppInfo()), null, "page_view", "em_expo", SDKMiniProgramLpReportDC04239.RESERVERS_GAME_TIME_LOAD_POP, null, null, null, "0");
        }
    }

    public static a c(IMiniAppContext iMiniAppContext) {
        a aVar = new a();
        aVar.f403375a = iMiniAppContext;
        return aVar;
    }

    public static void e() {
        f403374b = true;
        QMLog.d("GameInnerLoadingAction", "registerFixGame");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean perform(BaseRuntime baseRuntime) {
        String str;
        Activity attachActivity = baseRuntime.getAttachActivity();
        if (ViewUtils.isActivityInvalid(attachActivity)) {
            QMLog.e("GameInnerLoadingAction", "show dialog failed.");
            return Boolean.FALSE;
        }
        if (f403374b) {
            str = "\u7acb\u5373\u4fee\u590d";
        } else {
            str = "\u91cd\u65b0\u8fdb\u5165";
        }
        DialogUtil.createCustomDialog(attachActivity, 0, "\u5f53\u524d\u6e38\u620f\u52a0\u8f7d\u65f6\u95f4\u8fc7\u957f", (CharSequence) null, "\u518d\u7b49\u7b49", str, new DialogInterfaceOnClickListenerC10397a(), new b()).show();
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.f403375a.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(this.f403375a.getMiniAppInfo()), null, "page_view", "em_expo", SDKMiniProgramLpReportDC04239.RESERVERS_GAME_TIME_LOAD_POP, null);
        return null;
    }
}
