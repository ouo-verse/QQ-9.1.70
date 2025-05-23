package com.tencent.mobileqq.accountbinding.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.fragment.l;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\"\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J.\u0010(\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0004R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/accountbinding/fragment/WechatLoginBindingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "sh", "", "xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "needImmersive", "needStatusTrans", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onAccountChanged", "msgId", "yh", UIJsPlugin.EVENT_HIDE_LOADING, "", "uin", "rh", "mainTitleResId", "subTitleResId", "th", "vh", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "D", "Landroid/view/ViewGroup;", "containerView", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "loadingDialog", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class WechatLoginBindingFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static f G;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WechatInfo wechatInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewGroup containerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/fragment/WechatLoginBindingFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Lcom/tencent/mobileqq/accountbinding/fragment/f;", "callback", "", "a", "", "DELAY_TIME", "J", "", "REQ_CODE_DIRECT_JUMP_LOGIN", "I", "REQ_CODE_LOGIN", "", "TAG", "Ljava/lang/String;", "loginCallback", "Lcom/tencent/mobileqq/accountbinding/fragment/f;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@Nullable QBaseActivity activity, @Nullable WechatInfo wechatInfo, @Nullable f callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, wechatInfo, callback);
                return;
            }
            if (activity != null && wechatInfo != null) {
                Intent intent = new Intent();
                intent.putExtra("key_wechat_binding_info", wechatInfo);
                LoginPublicFragmentActivity.INSTANCE.a(activity, intent, WechatLoginBindingFragment.class);
                WechatLoginBindingFragment.G = callback;
                return;
            }
            QLog.e("WechatLoginBindingFragment", 1, "start failed");
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WechatLoginBindingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AppRuntime getAppRuntime() {
        if (getQBaseActivity() != null) {
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            Intrinsics.checkNotNullExpressionValue(appRuntime, "{\n            qBaseActivity.appRuntime\n        }");
            return appRuntime;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "{\n            MobileQQ.s\u2026eekAppRuntime()\n        }");
        return peekAppRuntime;
    }

    private final boolean sh() {
        String str;
        WechatInfo wechatInfo = this.wechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.f();
        } else {
            str = null;
        }
        return !TextUtils.isEmpty(str);
    }

    public static /* synthetic */ void uh(WechatLoginBindingFragment wechatLoginBindingFragment, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i3 = 100;
        }
        if ((i18 & 4) != 0) {
            i16 = R.string.zde;
        }
        if ((i18 & 8) != 0) {
            i17 = R.string.zdf;
        }
        wechatLoginBindingFragment.th(str, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(WechatLoginBindingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLoading();
        if (this$0.getQBaseActivity() != null && !this$0.getQBaseActivity().isFinishing()) {
            this$0.getQBaseActivity().finish();
        }
    }

    private final void xh() {
        String str;
        if (sh()) {
            str = "0X800C44B";
        } else {
            str = "0X800C44C";
        }
        String str2 = str;
        ReportController.r(getAppRuntime(), "dc00898", "", "", str2, str2, 0, 0, "", "", o.c(), "");
    }

    @JvmStatic
    public static final void zh(@Nullable QBaseActivity qBaseActivity, @Nullable WechatInfo wechatInfo, @Nullable f fVar) {
        INSTANCE.a(qBaseActivity, wechatInfo, fVar);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        WechatInfo wechatInfo = this.wechatInfo;
        if (wechatInfo != null) {
            arrayList.add(new com.tencent.mobileqq.accountbinding.part.d(wechatInfo));
            if (sh()) {
                arrayList.add(new com.tencent.mobileqq.accountbinding.part.b(wechatInfo));
            } else {
                if (MobileQQ.sMobileQQ.getAllAccounts() != null && (!r1.isEmpty())) {
                    arrayList.add(new com.tencent.mobileqq.accountbinding.part.e());
                }
            }
        }
        return arrayList;
    }

    public final void hideLoading() {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            try {
                Dialog dialog2 = this.loadingDialog;
                boolean z16 = false;
                if (dialog2 != null && dialog2.isShowing()) {
                    z16 = true;
                }
                if (z16 && (dialog = this.loadingDialog) != null) {
                    dialog.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("WechatLoginBindingFragment", 1, "hideLoading ", e16);
            }
            this.loadingDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onAccountChanged();
        QLog.i("WechatLoginBindingFragment", 1, "onAccountChanged");
        if (!com.tencent.mobileqq.phonelogin.a.a().c()) {
            QLog.d("WechatLoginBindingFragment", 1, "setProfileSig");
            WechatInfo wechatInfo = this.wechatInfo;
            if (wechatInfo != null) {
                str = wechatInfo.a();
            } else {
                str = null;
            }
            com.tencent.mobileqq.accountbinding.d.i(str);
        }
        String currentAccountUin = getAppRuntime().getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        f fVar = G;
        if (fVar != null) {
            fVar.a(currentAccountUin);
        }
        G = null;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                WechatLoginBindingFragment.wh(WechatLoginBindingFragment.this);
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            QLog.i("WechatLoginBindingFragment", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity != null) {
                qBaseActivity.doOnBackPressed();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        QLog.i("WechatLoginBindingFragment", 1, "onBackEvent");
        f fVar = G;
        if (fVar != null) {
            fVar.b();
        }
        G = null;
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        z.q(this.containerView, getQBaseActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WechatInfo wechatInfo;
        View inflate;
        boolean z16;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity != null && (intent = qBaseActivity.getIntent()) != null) {
                wechatInfo = (WechatInfo) intent.getParcelableExtra("key_wechat_binding_info");
            } else {
                wechatInfo = null;
            }
            this.wechatInfo = wechatInfo;
            if (wechatInfo == null) {
                QLog.e("WechatLoginBindingFragment", 1, "onCreateView wechatInfo is null");
            }
            List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
            if (!sh()) {
                List<SimpleAccount> list = allAccounts;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    th(null, 101, R.string.f200964tj, R.string.f200954ti);
                }
            }
            xh();
            if (needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
                ImmersiveUtils.setStatusTextColor(!ThemeUtil.isNowThemeIsNight(null, false, null), requireActivity().getWindow());
            }
            inflate = inflater.inflate(R.layout.gys, container, false);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f100805th);
            this.containerView = viewGroup;
            z.q(viewGroup, getQBaseActivity());
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
            hideLoading();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginPageExposure(16, 8);
        }
    }

    public final void rh(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) uin);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToastUtil.showQQToast(1, R.string.b3j);
            return;
        }
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null && !allAccounts.isEmpty()) {
            QRouteApi api = QRoute.api(IDirectLoginService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IDirectLoginService::class.java)");
            IDirectLoginService iDirectLoginService = (IDirectLoginService) api;
            if (uin != null && iDirectLoginService.canDirectLogin(uin)) {
                QLog.i("WechatLoginBindingFragment", 1, "directLogin uin=" + StringUtil.getSimpleUinForPrint(uin));
                yh(R.string.f211335kj);
                IDirectLoginService.a.a(iDirectLoginService, uin, 16, true, null, 8, null);
                return;
            }
            QLog.i("WechatLoginBindingFragment", 1, "directLogin fail, account is not login");
            uh(this, uin, 0, 0, 0, 14, null);
            return;
        }
        QLog.i("WechatLoginBindingFragment", 1, "directLogin fail, mAccountList is empty");
        uh(this, uin, 0, 0, 0, 14, null);
    }

    public final void th(@Nullable String uin, int requestCode, int mainTitleResId, int subTitleResId) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, uin, Integer.valueOf(requestCode), Integer.valueOf(mainTitleResId), Integer.valueOf(subTitleResId));
            return;
        }
        QLog.d("WechatLoginBindingFragment", 4, "jumpLoginFragment clicked uin=" + uin);
        Intent intent = new Intent(getActivity(), (Class<?>) LoginActivity.class);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("uin", uin);
        intent.putExtra("key_from_wx_login", true);
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null) {
            str = activity.getString(mainTitleResId);
        } else {
            str = null;
        }
        intent.putExtra("key_login_page_title", str);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            str2 = activity2.getString(subTitleResId);
        } else {
            str2 = null;
        }
        intent.putExtra("key_login_page_sub_title", str2);
        intent.putExtra("key_login_page_entrance", 16);
        intent.putExtra("key_login_nested_login", true);
        com.tencent.mobileqq.accountbinding.d dVar = com.tencent.mobileqq.accountbinding.d.f174609a;
        WechatInfo wechatInfo = this.wechatInfo;
        if (wechatInfo != null) {
            str3 = wechatInfo.f();
        }
        dVar.h(str3);
        LoginPublicFragmentActivity.INSTANCE.c(this, intent, l.f242160a.g(5), requestCode);
    }

    public final void vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("WechatLoginBindingFragment", 1, "commonProblem url is ", "https://kf.qq.com/touch/product/mobileqq_qqmp.html#showmenu=1007457");
        Intent intent = new Intent();
        intent.putExtra("uin", getAppRuntime().getAccount());
        intent.putExtra("url", "https://kf.qq.com/touch/product/mobileqq_qqmp.html#showmenu=1007457");
        z.z(getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public final void yh(int msgId) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, msgId);
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            if (this.loadingDialog == null) {
                this.loadingDialog = LoadingUtil.showLoadingDialog(getQBaseActivity(), BaseApplication.getContext().getString(msgId), false);
            }
            try {
                Dialog dialog2 = this.loadingDialog;
                if (dialog2 != null) {
                    dialog2.show();
                }
            } catch (Exception e16) {
                QLog.e("WechatLoginBindingFragment", 1, "showLoading ", e16);
            }
        }
    }
}
