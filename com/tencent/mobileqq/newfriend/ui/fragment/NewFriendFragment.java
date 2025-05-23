package com.tencent.mobileqq.newfriend.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendFragment extends QPublicBaseFragment implements View.OnClickListener, BaseNewFriendView.a {
    static IPatchRedirector $redirector_ = null;
    public static final String ARGS_FROM = "from";
    public static final String ARGS_FROM_SUBTYPE = "fromSubType";
    static final int MSG_FINISH = 2;
    static final int MSG_PROGRESS = 1;
    private static final String TAG = "NewFriendFragment";
    private static int s_FromSysSubMsgType;
    private QUISecNavBar mQuiSecNavBar;
    private SystemMsgListView mSystemMsgView;
    private e mUiHandler;
    private FrameLayout mViewContainer;
    INewFriendService nfm;
    QQProgressDialog progressDialog;
    private View rootView;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            int i3 = d.f254149a[baseAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPageForResult(NewFriendFragment.this.getActivity(), 3, 6, 221);
                    NewFriendFragment.this.nfm.markAllDataReaded();
                    return null;
                }
                return null;
            }
            if (AppSetting.t(NewFriendFragment.this.getContext())) {
                NewFriendFragment.this.getQBaseActivity().doOnBackPressed();
                return null;
            }
            NewFriendFragment.this.getQBaseActivity().finish();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements FragmentResultListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendFragment.this);
            }
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            } else {
                NewFriendFragment.this.mSystemMsgView.c(221, -1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                NewFriendFragment.this.progressDialog = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f254149a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32903);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f254149a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f254149a[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class e extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NewFriendFragment> f254150a;

        public e(NewFriendFragment newFriendFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) newFriendFragment);
            } else {
                this.f254150a = new WeakReference<>(newFriendFragment);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            NewFriendFragment newFriendFragment = this.f254150a.get();
            if (newFriendFragment == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    newFriendFragment.getQBaseActivity().finish();
                    return;
                }
                throw new RuntimeException("Unknown message: " + message.what);
            }
            newFriendFragment.doShowProgressDialog(message.arg1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            s_FromSysSubMsgType = -1;
        }
    }

    public NewFriendFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getFromSysSubMsgType() {
        return s_FromSysSubMsgType;
    }

    private int getTitleBarHeight() {
        if (getQBaseActivity() == null) {
            return 0;
        }
        return getQBaseActivity().getTitleBarHeight();
    }

    public static void report(AppRuntime appRuntime, String str) {
        ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.newfriend.ui.fragment.NewFriendFragment.4
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f254145e;

            {
                this.f254145e = str;
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
                String str2 = this.f254145e;
                ReportController.o(appRuntime2, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }, 16, null, false);
    }

    public static void setFromSysSubMsgType(int i3) {
        s_FromSysSubMsgType = i3;
    }

    void doShowProgressDialog(int i3) {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && this.progressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext(), getTitleBarHeight());
            this.progressDialog = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new c());
            this.progressDialog.setMessage(i3);
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public AppRuntime getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return null;
        }
        return qBaseActivity.getAppRuntime();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
            this.mSystemMsgView.c(i3, i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ivTitleBtnLeft) {
            if (AppSetting.t(getContext())) {
                getQBaseActivity().doOnBackPressed();
            } else {
                getQBaseActivity().finish();
            }
        } else {
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPageForResult((Activity) getContext(), 3, 6, 221);
            this.nfm.markAllDataReaded();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            getParentFragmentManager().setFragmentResultListener(String.valueOf(221), this, new b());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.ayi, viewGroup, false);
            this.rootView = inflate;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.mSystemMsgView;
        if (systemMsgListView != null) {
            systemMsgListView.e();
            this.mSystemMsgView = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.mSystemMsgView;
        if (systemMsgListView != null) {
            systemMsgListView.f();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        SystemMsgListView systemMsgListView = this.mSystemMsgView;
        if (systemMsgListView != null) {
            systemMsgListView.g();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onStart();
        SystemMsgListView systemMsgListView = this.mSystemMsgView;
        if (systemMsgListView != null) {
            systemMsgListView.h();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        SystemMsgListView systemMsgListView = this.mSystemMsgView;
        if (systemMsgListView != null) {
            systemMsgListView.i();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        this.mUiHandler = new e(this);
        this.nfm = (INewFriendService) getApp().getRuntimeService(INewFriendService.class, "");
        this.mViewContainer = (FrameLayout) this.rootView.findViewById(R.id.dm6);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) this.rootView.findViewById(R.id.zps);
        this.mQuiSecNavBar = qUISecNavBar;
        qUISecNavBar.setOnBaseTitleBarClickListener(new a());
        this.mQuiSecNavBar.S(this);
        showSystemMsgView();
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getMayKnowRecommendRemoteFromNewFrd((AppInterface) getApp());
        ((INewFriendVerificationService) getApp().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedRedPoint(getApp().getCurrentAccountUin());
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("from");
            int i3 = arguments.getInt(ARGS_FROM_SUBTYPE, -1);
            if ("from_lsa".equals(string) || "from_notification".equals(string)) {
                if (i3 == -1) {
                    i3 = getFromSysSubMsgType();
                }
                if (i3 == 6) {
                    report(getApp(), "0X800A182");
                } else if (i3 == 9 || i3 == 10 || i3 == 1) {
                    report(getApp(), "0X8009CBC");
                }
            }
        }
        NewFriendServiceImpl newFriendServiceImpl = (NewFriendServiceImpl) getApp().getRuntimeService(INewFriendService.class, "");
        newFriendServiceImpl.setIsGuideBindReported(false);
        newFriendServiceImpl.setIsGuidePermissionReported(false);
    }

    void showSystemMsgView() {
        if (this.mSystemMsgView == null) {
            SystemMsgListView systemMsgListView = new SystemMsgListView(getContext(), GestureActivityModule.getFlingHandler(getQBaseActivity()));
            this.mSystemMsgView = systemMsgListView;
            systemMsgListView.d(getQBaseActivity().getIntent(), this);
        }
        SystemMsgListView systemMsgListView2 = this.mSystemMsgView;
        if (systemMsgListView2 != null) {
            systemMsgListView2.h();
            if (getQBaseActivity().isResume()) {
                this.mSystemMsgView.g();
            }
            this.mViewContainer.removeAllViews();
            ViewParent parent = this.mSystemMsgView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mSystemMsgView);
            }
            this.mViewContainer.addView(this.mSystemMsgView);
        }
    }

    public void showToast(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        } else {
            QQToast.makeText(getContext(), i3, str, 0).show(getTitleBarHeight());
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void startProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.mUiHandler.sendMessageDelayed(this.mUiHandler.obtainMessage(1, R.string.hex, 0), 1000L);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void startTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public boolean stopProgress() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.mUiHandler.hasMessages(1)) {
            this.mUiHandler.removeMessages(1);
            z16 = true;
        } else {
            z16 = false;
        }
        QQProgressDialog qQProgressDialog = this.progressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.cancel();
            this.progressDialog = null;
            return true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.a
    public void stopTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
