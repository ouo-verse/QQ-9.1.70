package com.tencent.qqmini.sdk.manager;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE$StJudgeTimingRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameGrowthGuardianManager {
    private static final int GUARD_INSTRUCTION_TYPE_REAL_NAME_AUTHENTICATE = 7;
    private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_BEGIN = 11;
    private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_END = 13;
    private static final int JUDGE_TIMING_REQUEST_FACT_TYPE_HEARTBEAT = 12;
    private static final int MIN_HEART_BEAT_DURATION = 30;
    private static final String TAG = "GameGrowthGuardianManager";
    private static final int JUDGE_TIMING_REQUEST_BEGIN_DELAY = WnsConfig.getConfig("qqminiapp", "mini_game_judge_timing_request_begin_delay", 1000);
    private static final String ENABLE_HEART_BEAT_SCENE_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_scene_whitelist", "");
    private static final String ENABLE_HEART_BEAT_APPID_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_appid_whitelist", "");
    private static final String ENABLE_HEART_BEAT_VIA_WHITELIST = WnsConfig.getConfig("qqminiapp", "enable_heart_beat_via_whitelist", "");
    private static COMM.StCommonExt previousExtInfo = null;
    private static boolean isForeground = false;
    private static long beginExecuteMillis = 0;
    private static OnStopCallback sOnStopCallback = null;
    private static Runnable heartBeatRunnable = null;
    private static int sNextDuration = 30;
    private static long sLastDoJudgeTiming = 0;
    private static boolean sIsDialogShow = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DialogAction {
        private final DialogInterface.OnClickListener onClickListener;
        private final int stringResId;

        DialogAction(int i3, DialogInterface.OnClickListener onClickListener) {
            this.stringResId = i3;
            this.onClickListener = onClickListener;
        }

        public DialogInterface.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }

        int getStringResId() {
            return this.stringResId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogIncomeTips extends GuardInstructionDialog {
        GuardInstructionDialogIncomeTips(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getPositiveDialogAction() {
            return new DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogIncomeTips.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogIncomeTips.this.dismissInner();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogLogout extends GuardInstructionDialog implements b.InterfaceC9414b {
        private static final long DELAY_DO_EXIT = 1000;
        private final b mDialogStateChecker;

        GuardInstructionDialogLogout(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
            this.mDialogStateChecker = new b(this, this);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getPositiveDialogAction() {
            return new DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogLogout.this.performReport("click");
                    GuardInstructionDialogLogout.this.doExit();
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected String getReportSubActionType() {
            return "loginout";
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.b.InterfaceC9414b
        public void onDialogStateInvalid() {
            Context context = getContext();
            QMLog.d(GameGrowthGuardianManager.TAG, "onDialogStateInvalid: context=" + context + ", msg=" + getGuardInstruction().f24956msg.get());
            if (context != null) {
                MiniToast.makeText(context, R.string.mini_sdk_guard_force_logout, 1).show();
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.2
                @Override // java.lang.Runnable
                public void run() {
                    GuardInstructionDialogLogout.this.doExit();
                }
            }, 1000L);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onDismissDialogInner(Dialog dialog) {
            QMLog.d(GameGrowthGuardianManager.TAG, "onDismissDialogInner:" + dialog);
            this.mDialogStateChecker.e();
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onDismissForReport(DialogInterface dialogInterface) {
            QMLog.d(GameGrowthGuardianManager.TAG, "onDismissDialog:" + this);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onPreShowDialog(Dialog dialog) {
            QMLog.d(GameGrowthGuardianManager.TAG, "onPreShowDialog:" + this);
            this.mDialogStateChecker.b();
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onShowForReport(DialogInterface dialogInterface) {
            QMLog.d(GameGrowthGuardianManager.TAG, "onShowDialog:" + this);
            this.mDialogStateChecker.b();
            performReport("expo");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogOpenUrl extends GuardInstructionDialog {
        GuardInstructionDialogOpenUrl(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getNegativeDialogAction() {
            return new DialogAction(R.string.mini_sdk_cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogOpenUrl.this.dismissInner();
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getPositiveDialogAction() {
            return new DialogAction(R.string.mini_sdk_lite_open, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogOpenUrl.this.dismissInner();
                    Context context = GuardInstructionDialogOpenUrl.this.getContext();
                    if (context instanceof Activity) {
                        Intent intent = new Intent();
                        intent.putExtra("url", GuardInstructionDialogOpenUrl.this.getGuardInstruction().url.get());
                        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).startBrowserActivity((Activity) context, intent);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogRealNameAuthenticate extends GuardInstructionDialog implements b.InterfaceC9414b {
        private final b mDialogStateChecker;

        GuardInstructionDialogRealNameAuthenticate(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
            this.mDialogStateChecker = new b(this, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jumpToRealNameAuthPage() {
            Context context = getContext();
            if ((context instanceof Activity) && getGuardInstruction() != null) {
                Intent intent = new Intent();
                intent.putExtra("url", getGuardInstruction().url.get());
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).startBrowserActivity((Activity) context, intent);
            }
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getNegativeDialogAction() {
            return new DialogAction(R.string.mini_sdk_exit_game, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogRealNameAuthenticate.this.performReport("off_click");
                    GuardInstructionDialogRealNameAuthenticate.this.dismissInner();
                    GuardInstructionDialogRealNameAuthenticate.this.doExit();
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getPositiveDialogAction() {
            return new DialogAction(R.string.mini_sdk_qb_tenpay_tenpay_shiming_title, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogRealNameAuthenticate.this.performReport("identi_click");
                    GuardInstructionDialogRealNameAuthenticate.this.dismissInner();
                    GuardInstructionDialogRealNameAuthenticate.this.jumpToRealNameAuthPage();
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected String getReportSubActionType() {
            return "off_idAlert";
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.b.InterfaceC9414b
        public void onDialogStateInvalid() {
            Context context = getContext();
            if (context != null) {
                MiniToast.makeText(context, R.string.mini_sdk_real_name_toast_desc, 0).show();
            }
            jumpToRealNameAuthPage();
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onDismissDialogInner(Dialog dialog) {
            this.mDialogStateChecker.e();
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onPreShowDialog(Dialog dialog) {
            this.mDialogStateChecker.b();
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onShowForReport(DialogInterface dialogInterface) {
            performReport("expo");
            this.mDialogStateChecker.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogSkippedRealNameAuthenticate extends GuardInstructionDialogRealNameAuthenticate {
        GuardInstructionDialogSkippedRealNameAuthenticate(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate, com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getNegativeDialogAction() {
            return new DialogAction(R.string.mini_sdk_pretty_number_cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogSkippedRealNameAuthenticate.this.dismissInner();
                    GuardInstructionDialogSkippedRealNameAuthenticate.this.performReport("later_click");
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate, com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected String getReportSubActionType() {
            return "skip_idAlert";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class GuardInstructionDialogTips extends GuardInstructionDialog {
        GuardInstructionDialogTips(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            super(iNTERFACE$GuardInstruction, context, miniAppInfo);
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected DialogAction getPositiveDialogAction() {
            return new DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogTips.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    GuardInstructionDialogTips.this.performReport("click");
                    dialogInterface.dismiss();
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected String getReportSubActionType() {
            return "timeAlert";
        }

        @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
        protected void onShowForReport(DialogInterface dialogInterface) {
            performReport("expo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnStopCallback {
        void onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements AsyncResult {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.d(GameGrowthGuardianManager.TAG, "onReceived() called with: success = [" + z16 + "], stReportExecuteRsp = [" + jSONObject + "]");
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final GuardInstructionDialog f348122a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC9414b f348123b;

        /* renamed from: c, reason: collision with root package name */
        private int f348124c = 0;

        /* renamed from: d, reason: collision with root package name */
        private boolean f348125d = false;

        /* renamed from: e, reason: collision with root package name */
        private final Handler f348126e = new a(Looper.getMainLooper());

        /* compiled from: P */
        /* loaded from: classes23.dex */
        class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10001) {
                    b.this.c();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager$b$b, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public interface InterfaceC9414b {
            void onDialogStateInvalid();
        }

        public b(@NonNull GuardInstructionDialog guardInstructionDialog, @NonNull InterfaceC9414b interfaceC9414b) {
            this.f348122a = guardInstructionDialog;
            this.f348123b = interfaceC9414b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (!d()) {
                int i3 = this.f348124c + 1;
                this.f348124c = i3;
                if (i3 >= 4) {
                    this.f348123b.onDialogStateInvalid();
                    return;
                } else {
                    this.f348126e.sendEmptyMessageDelayed(10001, 2000L);
                    return;
                }
            }
            this.f348126e.sendEmptyMessageDelayed(10001, 5000L);
        }

        private boolean d() {
            boolean z16;
            boolean z17;
            Dialog dialog = this.f348122a.getDialog();
            if (dialog != null && dialog.isShowing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (dialog != null && dialog.getWindow() != null && dialog.getWindow().getDecorView().isShown()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 && z17) {
                return true;
            }
            return false;
        }

        void b() {
            if (!this.f348125d && !this.f348126e.hasMessages(10001)) {
                this.f348126e.sendEmptyMessageDelayed(10001, 2000L);
            }
        }

        void e() {
            this.f348126e.removeMessages(10001);
            this.f348124c = 0;
            this.f348125d = true;
        }
    }

    private static COMM.StCommonExt buildExtInfo(MiniAppInfo miniAppInfo) {
        String str = miniAppInfo.launchParam.spkTaskKey;
        QMLog.i(TAG, "buildExtInfo: spkTaskKey=" + str);
        if (TextUtils.isEmpty(str)) {
            return previousExtInfo;
        }
        COMM.StCommonExt stCommonExt = previousExtInfo;
        if (stCommonExt == null) {
            stCommonExt = new COMM.StCommonExt();
        }
        List<COMM.Entry> list = stCommonExt.mapInfo.get();
        if (list == null) {
            list = new ArrayList<>();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("spk_taskkey");
        entry.value.set(str);
        list.add(entry);
        return stCommonExt;
    }

    private static void doJudgeTiming(Context context, final MiniAppInfo miniAppInfo, @JudgeTimingRequestFactType final int i3, String str, String str2, int i16, int i17, int i18, int i19, String str3) {
        String str4;
        String str5;
        QMLog.i(TAG, "[doJudgeTiming] begin. fact type=" + i3 + ", durationTime=" + i18);
        final WeakReference weakReference = new WeakReference(context);
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        String str6 = miniAppInfo.via;
        if (str6 == null) {
            str5 = "";
        } else {
            str5 = str6;
        }
        channelProxy.judgeTiming(str2, i16, i17, i3, seconds, i18, i19, str4, 0, str5, miniAppInfo.gameAdsTotalTime, buildExtInfo(miniAppInfo), miniAppInfo.customInfo, str3, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                Context context2 = (Context) weakReference.get();
                if (context2 != null) {
                    GameGrowthGuardianManager.onReceiveJudgeTiming(context2, miniAppInfo, z16, jSONObject);
                    GameGrowthGuardianManager.nextHeartBeat(context2, i3, miniAppInfo);
                } else {
                    QMLog.e(GameGrowthGuardianManager.TAG, "onReceiveResult: ctx is null.");
                }
            }
        });
    }

    private static boolean enableHeartBeatAppIdWhiteList(MiniAppInfo miniAppInfo) {
        String[] split;
        if (miniAppInfo != null && miniAppInfo.appId != null) {
            String str = ENABLE_HEART_BEAT_APPID_WHITELIST;
            if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null) {
                for (String str2 : split) {
                    if (miniAppInfo.appId.equals(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean enableHeartBeatCheck(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null && qQCustomizedProxy.disableHeartBeatCheck(miniAppInfo)) {
            return false;
        }
        if (miniAppInfo.isEngineTypeMiniGame()) {
            return true;
        }
        if (miniAppInfo.isEngineTypeMiniGame() || !enableHeartBeatForMiniApp(miniAppInfo)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[Catch: Exception -> 0x0009, TryCatch #0 {Exception -> 0x0009, blocks: (B:26:0x0002, B:28:0x0006, B:4:0x000f, B:5:0x0013, B:9:0x001b, B:12:0x0022, B:15:0x0029), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean enableHeartBeatForMiniApp(MiniAppInfo miniAppInfo) {
        int i3;
        String str;
        if (miniAppInfo != null) {
            try {
                LaunchParam launchParam = miniAppInfo.launchParam;
                if (launchParam != null) {
                    i3 = launchParam.scene;
                    if (miniAppInfo == null) {
                        str = miniAppInfo.via;
                    } else {
                        str = null;
                    }
                    if (!isFromQQXMAN(i3, str) || enableHeartBeatSceneWhiteList(i3) || enableHeartBeatAppIdWhiteList(miniAppInfo)) {
                        return true;
                    }
                    if (!enableHeartBeatViaWhiteList(str)) {
                        return true;
                    }
                    return false;
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "enableHeartBeatForLaunchScene", e16);
                return false;
            }
        }
        i3 = 9999;
        if (miniAppInfo == null) {
        }
        if (!isFromQQXMAN(i3, str)) {
            return true;
        }
        if (!enableHeartBeatViaWhiteList(str)) {
        }
    }

    private static boolean enableHeartBeatSceneWhiteList(int i3) {
        String[] split;
        String str = ENABLE_HEART_BEAT_SCENE_WHITELIST;
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                if (i3 == Integer.parseInt(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean enableHeartBeatViaWhiteList(String str) {
        String[] split;
        String str2 = ENABLE_HEART_BEAT_VIA_WHITELIST;
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",")) != null) {
            for (String str3 : split) {
                if (str3 != null && str3.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void execute(Context context, MiniAppInfo miniAppInfo, @JudgeTimingRequestFactType int i3) {
        String str;
        int i16;
        int seconds;
        int i17;
        String str2;
        if (context != null && miniAppInfo != null) {
            if (!isForeground && (i3 == 11 || i3 == 12)) {
                QMLog.e(TAG, "not in foreground, not allowed to send begin or heartbeat protocol");
                return;
            }
            if (!enableHeartBeatCheck(miniAppInfo)) {
                return;
            }
            String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppInfo);
            String str3 = miniAppInfo.appId;
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            boolean isEngineTypeMiniGame = miniAppInfo.isEngineTypeMiniGame();
            LaunchParam launchParam = miniAppInfo.launchParam;
            if (launchParam != null) {
                i16 = launchParam.scene;
            } else {
                i16 = 0;
            }
            if (i3 == 11) {
                seconds = 0;
                i17 = 0;
            } else {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                int seconds2 = (int) timeUnit.toSeconds(System.currentTimeMillis() - beginExecuteMillis);
                seconds = (int) timeUnit.toSeconds(SystemClock.elapsedRealtime() - sLastDoJudgeTiming);
                i17 = seconds2;
            }
            sLastDoJudgeTiming = SystemClock.elapsedRealtime();
            EntryModel entryModel = miniAppInfo.launchParam.entryModel;
            if (entryModel == null || entryModel.type != 1) {
                str2 = "";
            } else {
                str2 = String.valueOf(entryModel.uin);
            }
            doJudgeTiming(context, miniAppInfo, i3, launchIdForMiniAppConfig, str, isEngineTypeMiniGame ? 1 : 0, i16, seconds, i17, str2);
        }
    }

    public static void executeBegin(final Context context, final MiniAppInfo miniAppInfo) {
        isForeground = true;
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                miniAppInfo2.gameAdsTotalTime = 0;
                GameGrowthGuardianManager.execute(context, miniAppInfo2, 11);
                long unused = GameGrowthGuardianManager.beginExecuteMillis = System.currentTimeMillis();
            }
        }, JUDGE_TIMING_REQUEST_BEGIN_DELAY);
    }

    public static void executeEnd(Context context, MiniAppInfo miniAppInfo) {
        isForeground = false;
        execute(context, miniAppInfo, 13);
        if (heartBeatRunnable != null) {
            ThreadManager.getUIHandler().removeCallbacks(heartBeatRunnable);
            heartBeatRunnable = null;
        }
        OnStopCallback onStopCallback = sOnStopCallback;
        if (onStopCallback != null) {
            onStopCallback.onStop();
        }
    }

    private static boolean isFromQQXMAN(int i3, String str) {
        if (i3 != 2093 && !"2016_4".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMiniAppNotShowDialog(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isEngineTypeMiniApp() && !GameWnsUtils.enableInstructionsForMiniApp()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nextHeartBeat(Context context, int i3, final MiniAppInfo miniAppInfo) {
        boolean isMiniAppNotShowDialog = isMiniAppNotShowDialog(miniAppInfo);
        QMLog.i(TAG, "[nextHeartBeat] requestType=" + i3 + " isForeground=" + isForeground + " isDialogShow=" + sIsDialogShow + " isNotShowDialog=" + isMiniAppNotShowDialog);
        if (isForeground && !sIsDialogShow && !isMiniAppNotShowDialog) {
            final WeakReference weakReference = new WeakReference(context);
            if (i3 == 11 || i3 == 12) {
                heartBeatRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Context context2 = (Context) weakReference.get();
                        if (context2 != null) {
                            GameGrowthGuardianManager.execute(context2, miniAppInfo, 12);
                        }
                    }
                };
                if (sNextDuration < 30) {
                    sNextDuration = 30;
                }
                ThreadManager.getUIHandler().postDelayed(heartBeatRunnable, TimeUnit.SECONDS.toMillis(sNextDuration));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onReceiveJudgeTiming(Context context, MiniAppInfo miniAppInfo, boolean z16, JSONObject jSONObject) {
        if (z16 && jSONObject != null) {
            try {
                INTERFACE$StJudgeTimingRsp parseJudgeTimingRsp = parseJudgeTimingRsp(jSONObject);
                if (parseJudgeTimingRsp == null) {
                    QMLog.e(TAG, "[onReceiveJudgeTiming] rsp is null");
                    return;
                } else {
                    showGuardDialogIfNeeded(context, miniAppInfo, parseJudgeTimingRsp);
                    return;
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "JudgeTiming error ", e16);
                return;
            }
        }
        QMLog.e(TAG, "[onReceiveJudgeTiming] result=" + jSONObject + " isSuccess=" + z16);
    }

    private static INTERFACE$StJudgeTimingRsp parseJudgeTimingRsp(JSONObject jSONObject) {
        INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp;
        try {
            iNTERFACE$StJudgeTimingRsp = (INTERFACE$StJudgeTimingRsp) jSONObject.get("response");
        } catch (JSONException e16) {
            QMLog.e(TAG, "[parseJudgeTimingRsp] error", e16);
            iNTERFACE$StJudgeTimingRsp = null;
        }
        if (iNTERFACE$StJudgeTimingRsp != null) {
            if (!iNTERFACE$StJudgeTimingRsp.loginInstructions.isEmpty()) {
                Iterator<INTERFACE$GuardInstruction> it = iNTERFACE$StJudgeTimingRsp.loginInstructions.get().iterator();
                while (it.hasNext()) {
                    it.next().type.set(7);
                }
                iNTERFACE$StJudgeTimingRsp.timingInstructions.get().addAll(0, iNTERFACE$StJudgeTimingRsp.loginInstructions.get());
            }
            sNextDuration = iNTERFACE$StJudgeTimingRsp.nextDuration.get();
            previousExtInfo = iNTERFACE$StJudgeTimingRsp.extInfo;
        }
        return iNTERFACE$StJudgeTimingRsp;
    }

    public static void registerActivityOnStopCallback(OnStopCallback onStopCallback) {
        sOnStopCallback = onStopCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportInstructionExecuteResult(MiniAppInfo miniAppInfo, INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp, INTERFACE$GuardInstruction iNTERFACE$GuardInstruction) {
        String str;
        String str2;
        if (miniAppInfo != null && iNTERFACE$StJudgeTimingRsp != null) {
            if (iNTERFACE$GuardInstruction != null && iNTERFACE$GuardInstruction.type.get() == 7) {
                str = iNTERFACE$StJudgeTimingRsp.loginTraceId.get();
            } else {
                str = iNTERFACE$StJudgeTimingRsp.timingTraceId.get();
            }
            String str3 = str;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            String str4 = miniAppInfo.appId;
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            if (iNTERFACE$GuardInstruction != null) {
                str2 = iNTERFACE$GuardInstruction.ruleName.get();
            } else {
                str2 = "";
            }
            channelProxy.reportExecute(str4, seconds, str3, str2, new a());
        }
    }

    private static void showGuardDialogIfNeeded(final Context context, final MiniAppInfo miniAppInfo, final INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp) {
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (!GameGrowthGuardianManager.isForeground) {
                    QMLog.e(GameGrowthGuardianManager.TAG, "not in foreground, not allowed to show dialog or send heartbeat");
                } else if (GameGrowthGuardianManager.isMiniAppNotShowDialog(MiniAppInfo.this)) {
                    QMLog.e(GameGrowthGuardianManager.TAG, "disable Instructions for miniApp!!");
                } else {
                    GuardInstructionDialog.tryBuildAndShow(context, MiniAppInfo.this, iNTERFACE$StJudgeTimingRsp, 0);
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public static void unregisterActivityOnStopCallback() {
        sOnStopCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class GuardInstructionDialog {
        private static GuardInstructionDialog sPreDialogWrapper;
        private final WeakReference<Context> ctxRef;
        private WeakReference<Dialog> dialogRef = new WeakReference<>(null);
        private final INTERFACE$GuardInstruction guardInstruction;
        private INTERFACE$StJudgeTimingRsp judgeTimingRsp;
        private final MiniAppInfo miniAppInfo;
        private DialogInterface.OnDismissListener onDismissListener;

        GuardInstructionDialog(INTERFACE$GuardInstruction iNTERFACE$GuardInstruction, Context context, MiniAppInfo miniAppInfo) {
            this.guardInstruction = iNTERFACE$GuardInstruction;
            this.ctxRef = new WeakReference<>(context);
            this.miniAppInfo = miniAppInfo;
        }

        private static void buildGuardianDialog(Context context, final MiniAppInfo miniAppInfo, final INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp, final int i3, INTERFACE$GuardInstruction iNTERFACE$GuardInstruction) {
            GuardInstructionDialog guardInstructionDialogRealNameAuthenticate;
            QMLog.i(GameGrowthGuardianManager.TAG, "[buildGuardianDialog] type=" + iNTERFACE$GuardInstruction.type.get());
            if (iNTERFACE$GuardInstruction.type.get() == 1) {
                guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogTips(iNTERFACE$GuardInstruction, context, miniAppInfo);
            } else if (iNTERFACE$GuardInstruction.type.get() == 2) {
                guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogLogout(iNTERFACE$GuardInstruction, context, miniAppInfo);
            } else if (iNTERFACE$GuardInstruction.type.get() == 3) {
                guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogOpenUrl(iNTERFACE$GuardInstruction, context, miniAppInfo);
            } else if (iNTERFACE$GuardInstruction.type.get() == 6) {
                guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogIncomeTips(iNTERFACE$GuardInstruction, context, miniAppInfo);
            } else if (iNTERFACE$GuardInstruction.type.get() == 7) {
                QMLog.d(GameGrowthGuardianManager.TAG, "tryBuildAndShow() called with: modal = " + iNTERFACE$GuardInstruction.modal.get());
                if (iNTERFACE$GuardInstruction.modal.get() == 0) {
                    guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogSkippedRealNameAuthenticate(iNTERFACE$GuardInstruction, context, miniAppInfo);
                } else {
                    guardInstructionDialogRealNameAuthenticate = new GuardInstructionDialogRealNameAuthenticate(iNTERFACE$GuardInstruction, context, miniAppInfo);
                }
            } else {
                QMLog.w(GameGrowthGuardianManager.TAG, "tryBuildAndShow not create and show dialog for " + iNTERFACE$GuardInstruction.type.get());
                tryBuildAndShow(context, miniAppInfo, iNTERFACE$StJudgeTimingRsp, i3 + 1);
                return;
            }
            GuardInstructionDialog guardInstructionDialog = sPreDialogWrapper;
            if (guardInstructionDialog != null) {
                guardInstructionDialog.dismissInner();
            }
            sPreDialogWrapper = guardInstructionDialogRealNameAuthenticate;
            guardInstructionDialogRealNameAuthenticate.setJudgeTimingRsp(iNTERFACE$StJudgeTimingRsp);
            final WeakReference weakReference = new WeakReference(context);
            guardInstructionDialogRealNameAuthenticate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        return;
                    }
                    GuardInstructionDialog.tryBuildAndShow(context2, miniAppInfo, iNTERFACE$StJudgeTimingRsp, i3 + 1);
                }
            });
            guardInstructionDialogRealNameAuthenticate.buildAndShow();
        }

        static void tryBuildAndShow(Context context, MiniAppInfo miniAppInfo, INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp, int i3) {
            INTERFACE$GuardInstruction iNTERFACE$GuardInstruction;
            if (context != null && iNTERFACE$StJudgeTimingRsp != null && !iNTERFACE$StJudgeTimingRsp.timingInstructions.isEmpty()) {
                try {
                } catch (Exception e16) {
                    QMLog.e(GameGrowthGuardianManager.TAG, "tryBuildAndShow", e16);
                    iNTERFACE$GuardInstruction = null;
                }
                if (i3 < iNTERFACE$StJudgeTimingRsp.timingInstructions.size()) {
                    iNTERFACE$GuardInstruction = iNTERFACE$StJudgeTimingRsp.timingInstructions.get(i3);
                    if (iNTERFACE$GuardInstruction != null) {
                        buildGuardianDialog(context, miniAppInfo, iNTERFACE$StJudgeTimingRsp, i3, iNTERFACE$GuardInstruction);
                    } else {
                        QMLog.i(GameGrowthGuardianManager.TAG, "[tryBuildAndShow] guardInstruction is null");
                    }
                }
            }
        }

        void buildAndShow() {
            final Context context = getContext();
            if (context != null && getGuardInstruction() != null) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                }
                MiniCustomDialog message = DialogUtil.createCustomDialog(context, 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().f24956msg.get());
                this.dialogRef = new WeakReference<>(message);
                if (getPositiveDialogAction() != null) {
                    message.setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
                }
                if (getNegativeDialogAction() != null) {
                    message.setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
                }
                final OnStopCallback onStopCallback = new OnStopCallback() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.2
                    @Override // com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.OnStopCallback
                    public void onStop() {
                        GuardInstructionDialog.this.onBackgroundForReport();
                    }
                };
                message.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.3
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        GuardInstructionDialog.this.onShowForReport(dialogInterface);
                        GameGrowthGuardianManager.reportInstructionExecuteResult(GuardInstructionDialog.this.getMiniAppInfo(), GuardInstructionDialog.this.judgeTimingRsp, GuardInstructionDialog.this.getGuardInstruction());
                        GameGrowthGuardianManager.registerActivityOnStopCallback(onStopCallback);
                    }
                });
                message.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        boolean unused = GameGrowthGuardianManager.sIsDialogShow = false;
                        GuardInstructionDialog.this.onDismissForReport(dialogInterface);
                        GameGrowthGuardianManager.unregisterActivityOnStopCallback();
                        if (GuardInstructionDialog.this.onDismissListener != null) {
                            GuardInstructionDialog.this.onDismissListener.onDismiss(dialogInterface);
                        }
                        GameGrowthGuardianManager.nextHeartBeat(context, 11, GuardInstructionDialog.this.miniAppInfo);
                    }
                });
                message.setCancelable(false);
                onPreShowDialog(message);
                message.show();
                boolean unused = GameGrowthGuardianManager.sIsDialogShow = true;
            }
        }

        protected final void dismissInner() {
            Dialog dialog = this.dialogRef.get();
            if (dialog != null) {
                dialog.dismiss();
                onDismissDialogInner(dialog);
            }
        }

        protected final void doExit() {
            IUIProxy uIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(this.miniAppInfo);
            if (uIProxy != null) {
                uIProxy.notifyExit(true, false, false);
            }
        }

        public Context getContext() {
            return this.ctxRef.get();
        }

        public Dialog getDialog() {
            return this.dialogRef.get();
        }

        INTERFACE$GuardInstruction getGuardInstruction() {
            return this.guardInstruction;
        }

        public MiniAppInfo getMiniAppInfo() {
            return this.miniAppInfo;
        }

        protected DialogAction getNegativeDialogAction() {
            return null;
        }

        protected DialogAction getPositiveDialogAction() {
            return null;
        }

        String getReportActionType() {
            return "sys_alert";
        }

        protected String getReportSubActionType() {
            return null;
        }

        protected void onBackgroundForReport() {
            QMLog.d(GameGrowthGuardianManager.TAG, "onBackgroundForReport() called");
            performReport("hide");
        }

        protected void performReport(String str) {
            GuardInstructionDialog guardInstructionDialog;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7 = null;
            if (getGuardInstruction() != null) {
                str2 = getGuardInstruction().ruleName.get();
                str3 = String.valueOf(getGuardInstruction().type.get());
                str4 = String.valueOf(getGuardInstruction().modal.get());
                str5 = getGuardInstruction().f24956msg.get();
                guardInstructionDialog = this;
            } else {
                guardInstructionDialog = this;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp = guardInstructionDialog.judgeTimingRsp;
            if (iNTERFACE$StJudgeTimingRsp != null) {
                str6 = String.valueOf(iNTERFACE$StJudgeTimingRsp.nextDuration.get());
            } else {
                str6 = null;
            }
            if (getMiniAppInfo() != null) {
                str7 = SDKMiniProgramLpReportDC04239.getAppType(getMiniAppInfo());
            }
            String str8 = str6;
            SDKMiniProgramLpReportDC04239.report(getMiniAppInfo(), str7, null, getReportActionType(), getReportSubActionType(), str, str2, str3, str4, str5, str8);
            QMLog.d(GameGrowthGuardianManager.TAG, "performReport called with action = " + getReportActionType() + ",subaction = " + getReportSubActionType() + ",reserves = " + str + ",reverses2 = " + str2 + ",reverses3 = " + str3 + ",reverses4 = " + str4 + ",reverses5 = " + str5 + ",reserves6 = " + str8);
        }

        public void setJudgeTimingRsp(INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp) {
            this.judgeTimingRsp = iNTERFACE$StJudgeTimingRsp;
        }

        public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
        }

        protected void onDismissDialogInner(Dialog dialog) {
        }

        protected void onDismissForReport(DialogInterface dialogInterface) {
        }

        protected void onPreShowDialog(Dialog dialog) {
        }

        protected void onShowForReport(DialogInterface dialogInterface) {
        }
    }
}
