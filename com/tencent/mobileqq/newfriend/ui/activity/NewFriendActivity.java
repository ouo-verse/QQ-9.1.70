package com.tencent.mobileqq.newfriend.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.fragment.NewFriendFragment;
import com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendActivity extends QBaseActivity implements View.OnClickListener, BaseNewFriendView.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name */
    private static int f254045h0;

    /* renamed from: a0, reason: collision with root package name */
    private View f254046a0;

    /* renamed from: b0, reason: collision with root package name */
    private FrameLayout f254047b0;

    /* renamed from: c0, reason: collision with root package name */
    private QUISecNavBar f254048c0;

    /* renamed from: d0, reason: collision with root package name */
    INewFriendService f254049d0;

    /* renamed from: e0, reason: collision with root package name */
    private SystemMsgListView f254050e0;

    /* renamed from: f0, reason: collision with root package name */
    QQProgressDialog f254051f0;

    /* renamed from: g0, reason: collision with root package name */
    private d f254052g0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendActivity.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            int i3 = c.f254057a[baseAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPageForResult(NewFriendActivity.this.getActivity(), 3, 6, 221);
                    NewFriendActivity.this.f254049d0.markAllDataReaded();
                    return null;
                }
                return null;
            }
            NewFriendActivity.this.finish();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                NewFriendActivity.this.f254051f0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f254057a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28781);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f254057a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f254057a[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class d extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NewFriendActivity> f254058a;

        public d(NewFriendActivity newFriendActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) newFriendActivity);
            } else {
                this.f254058a = new WeakReference<>(newFriendActivity);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            NewFriendActivity newFriendActivity = this.f254058a.get();
            if (newFriendActivity == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    newFriendActivity.finish();
                    return;
                }
                throw new RuntimeException("Unknown message: " + message.what);
            }
            newFriendActivity.F2(message.arg1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f254045h0 = -1;
        }
    }

    public NewFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int G2() {
        return f254045h0;
    }

    private void H2() {
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.f254046a0, "pg_kl_new_friends");
    }

    public static void report(AppRuntime appRuntime, String str) {
        ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity.3
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f254054e;

            {
                this.f254054e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppRuntime.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime appRuntime2 = AppRuntime.this;
                String str2 = this.f254054e;
                ReportController.o(appRuntime2, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }, 16, null, false);
    }

    public static void setFromSysSubMsgType(int i3) {
        f254045h0 = i3;
    }

    public static void startActivity(Context context, Intent intent, int i3) {
        if (AppSetting.t(context) && (context instanceof l)) {
            Bundle bundle = new Bundle();
            if (intent != null) {
                bundle.putString("from", intent.getStringExtra("from"));
                bundle.putInt(NewFriendFragment.ARGS_FROM_SUBTYPE, intent.getIntExtra(NewFriendFragment.ARGS_FROM_SUBTYPE, -1));
            }
            bundle.putInt("EntranceId", i3);
            i.e(context, bundle, NewFriendFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, NewFriendActivity.class);
        intent.putExtra("EntranceId", i3);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    void F2(int i3) {
        if (!isFinishing() && this.f254051f0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.f254051f0 = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new b());
            this.f254051f0.setMessage(i3);
            this.f254051f0.setCanceledOnTouchOutside(false);
            this.f254051f0.setCancelable(false);
            this.f254051f0.show();
        }
    }

    void I2() {
        if (this.f254050e0 == null) {
            SystemMsgListView systemMsgListView = new SystemMsgListView(this, GestureActivityModule.getFlingHandler(this));
            this.f254050e0 = systemMsgListView;
            systemMsgListView.d(getIntent(), this);
        }
        SystemMsgListView systemMsgListView2 = this.f254050e0;
        if (systemMsgListView2 != null) {
            systemMsgListView2.h();
            if (isResume()) {
                this.f254050e0.g();
            }
            this.f254047b0.removeAllViews();
            this.f254047b0.addView(this.f254050e0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
            this.f254050e0.c(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        this.f254052g0 = new d(this);
        this.f254049d0 = (INewFriendService) getAppRuntime().getRuntimeService(INewFriendService.class, "");
        setContentView(R.layout.ayi);
        setContentBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        View findViewById = findViewById(R.id.root);
        this.f254046a0 = findViewById;
        if (findViewById == null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_relation_new_friend_background_crash", true)) {
            finish();
            return false;
        }
        this.f254047b0 = (FrameLayout) findViewById(R.id.dm6);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.zps);
        this.f254048c0 = qUISecNavBar;
        qUISecNavBar.setOnBaseTitleBarClickListener(new a());
        this.f254048c0.R(this);
        I2();
        ((INewFriendVerificationService) getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedRedPoint(getAppRuntime().getCurrentAccountUin());
        String stringExtra = getIntent().getStringExtra("from");
        int intExtra = getIntent().getIntExtra(NewFriendFragment.ARGS_FROM_SUBTYPE, -1);
        if ("from_lsa".equals(stringExtra) || "from_notification".equals(stringExtra)) {
            if (intExtra == -1) {
                intExtra = G2();
            }
            if (intExtra == 6) {
                report(getAppRuntime(), "0X800A182");
            } else if (intExtra == 9 || intExtra == 10 || intExtra == 1) {
                report(getAppRuntime(), "0X8009CBC");
            }
        }
        NewFriendServiceImpl newFriendServiceImpl = (NewFriendServiceImpl) getAppRuntime().getRuntimeService(INewFriendService.class, "");
        newFriendServiceImpl.setIsGuideBindReported(false);
        newFriendServiceImpl.setIsGuidePermissionReported(false);
        H2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.f254050e0;
        if (systemMsgListView != null) {
            systemMsgListView.e();
            this.f254050e0 = null;
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.f254050e0;
        if (systemMsgListView != null) {
            systemMsgListView.f();
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnResume();
        SystemMsgListView systemMsgListView = this.f254050e0;
        if (systemMsgListView != null) {
            systemMsgListView.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnStart();
        SystemMsgListView systemMsgListView = this.f254050e0;
        if (systemMsgListView != null) {
            systemMsgListView.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.f254050e0;
        if (systemMsgListView != null) {
            systemMsgListView.i();
        }
        super.doOnStop();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Activity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public AppRuntime getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return getAppRuntime();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
        } else {
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPageForResult(this, 3, 6, 221);
            this.f254049d0.markAllDataReaded();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void startProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f254052g0.sendMessageDelayed(this.f254052g0.obtainMessage(1, R.string.hex, 0), 1000L);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void startTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public boolean stopProgress() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.f254052g0.hasMessages(1)) {
            this.f254052g0.removeMessages(1);
            z16 = true;
        } else {
            z16 = false;
        }
        QQProgressDialog qQProgressDialog = this.f254051f0;
        if (qQProgressDialog != null) {
            qQProgressDialog.cancel();
            this.f254051f0 = null;
            return true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void stopTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }
}
