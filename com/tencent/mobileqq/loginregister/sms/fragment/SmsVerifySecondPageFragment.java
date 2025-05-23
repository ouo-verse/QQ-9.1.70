package com.tencent.mobileqq.loginregister.sms.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyBaseFragment;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.av;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u000bH\u0014J\u0012\u0010(\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u001a\u00101\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\rH\u0016J\"\u00106\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u0007H\u0016R\u0016\u0010;\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifySecondPageFragment;", "Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifyBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/VerifyCodeView$a;", "Lcom/tencent/mobileqq/loginregister/sms/c;", "Landroid/view/View;", "root", "", "initViews", "gi", "ii", "", "bi", "", "msg", UIJsPlugin.EVENT_SHOW_TOAST, "enable", "hi", "", "time", "restartTimer", "ci", "resId", WidgetCacheLunarData.JI, UIJsPlugin.EVENT_HIDE_LOADING, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onFinish", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qh", "v", NodeProps.ON_CLICK, "startTimer", "showLoadingDialog", "strResId", "Xc", "dismissDialog", "clearWrongCode", "isComplete", "code", "onVerifyCodeChanged", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onDetach", "onPostThemeChanged", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "mSecond", "Lcom/tencent/mobileqq/widget/VerifyCodeView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/VerifyCodeView;", "verifyCodeView", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "resendBtn", "T", "Landroid/view/View;", "otherVerificationLayout", "Landroid/app/Dialog;", "U", "Landroid/app/Dialog;", "mLoadingDialog", "Lcom/tencent/mobileqq/loginregister/sms/e;", "V", "Lcom/tencent/mobileqq/loginregister/sms/e;", "mVerifyProxy", "Landroid/os/Handler;", "W", "Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "X", "Ljava/lang/Runnable;", "runnableCountdown", "<init>", "()V", "Y", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SmsVerifySecondPageFragment extends SmsVerifyBaseFragment implements View.OnClickListener, VerifyCodeView.a, com.tencent.mobileqq.loginregister.sms.c {
    static IPatchRedirector $redirector_;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mSecond;

    /* renamed from: R, reason: from kotlin metadata */
    private VerifyCodeView verifyCodeView;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView resendBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private View otherVerificationLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.sms.e mVerifyProxy;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnableCountdown;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/loginregister/sms/fragment/SmsVerifySecondPageFragment$a;", "", "", "SECOND", "J", "", "SECONDS_60", "I", "", "TAG", "Ljava/lang/String;", "WHAT_LOADING", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifySecondPageFragment$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SmsVerifySecondPageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSecond = 1;
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean fi5;
                fi5 = SmsVerifySecondPageFragment.fi(SmsVerifySecondPageFragment.this, message);
                return fi5;
            }
        });
        this.runnableCountdown = new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifySecondPageFragment$runnableCountdown$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SmsVerifySecondPageFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                Handler handler;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    i3 = SmsVerifySecondPageFragment.this.mSecond;
                    if (i3 <= 1) {
                        SmsVerifySecondPageFragment.this.hi(true);
                        return;
                    }
                    SmsVerifySecondPageFragment smsVerifySecondPageFragment = SmsVerifySecondPageFragment.this;
                    i16 = smsVerifySecondPageFragment.mSecond;
                    smsVerifySecondPageFragment.mSecond = i16 - 1;
                    SmsVerifySecondPageFragment.this.hi(false);
                    handler = SmsVerifySecondPageFragment.this.mHandler;
                    handler.postDelayed(this, 1000L);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
    }

    private final boolean bi() {
        if (NetworkUtil.isNetSupport(xh())) {
            return true;
        }
        QLog.e("SmsVerifySecondPageFragment", 1, "checkNetworkAvailable false");
        String string = getString(R.string.b3j);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.failedconnection)");
        showToast(string);
        return false;
    }

    private final void ci() {
        CharSequence trim;
        if (!bi()) {
            return;
        }
        VerifyCodeView verifyCodeView = this.verifyCodeView;
        if (verifyCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView = null;
        }
        String i3 = verifyCodeView.i();
        if (i3 != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) i3);
            String obj = trim.toString();
            com.tencent.mobileqq.loginregister.sms.e eVar = this.mVerifyProxy;
            if (eVar != null) {
                eVar.c(xh(), this, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(SmsVerifySecondPageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Dialog dialog = this$0.mLoadingDialog;
            if (dialog != null) {
                Intrinsics.checkNotNull(dialog);
                if (dialog.isShowing()) {
                    Dialog dialog2 = this$0.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.dismiss();
                    Dialog dialog3 = this$0.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog3);
                    dialog3.cancel();
                }
            }
        } catch (Throwable th5) {
            QLog.e("SmsVerifySecondPageFragment", 1, "hideLoading exception", th5);
        }
        this$0.mLoadingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(SmsVerifySecondPageFragment this$0, InputMethodManager inputManager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inputManager, "$inputManager");
        VerifyCodeView verifyCodeView = this$0.verifyCodeView;
        if (verifyCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView = null;
        }
        verifyCodeView.k(inputManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fi(SmsVerifySecondPageFragment this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            this$0.ji(msg2.arg1);
        }
        return true;
    }

    private final void gi(View root) {
        if (z.b(getContext())) {
            z.w(root.findViewById(R.id.f86614s5));
        } else {
            z.A(root.findViewById(R.id.f86614s5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(boolean enable) {
        boolean z16 = false;
        TextView textView = null;
        if (enable) {
            TextView textView2 = this.resendBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                textView2 = null;
            }
            textView2.setEnabled(true);
            TextView textView3 = this.resendBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                textView3 = null;
            }
            textView3.setClickable(true);
            SmsVerifyBaseFragment.a Dh = Dh();
            if (Dh != null && Dh.L1()) {
                z16 = true;
            }
            if (z16) {
                TextView textView4 = this.resendBtn;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                    textView4 = null;
                }
                textView4.setText(R.string.f172945g10);
            } else {
                TextView textView5 = this.resendBtn;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                    textView5 = null;
                }
                textView5.setText(R.string.f216635yu);
            }
            TextView textView6 = this.resendBtn;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                textView6 = null;
            }
            TextView textView7 = this.resendBtn;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
            } else {
                textView = textView7;
            }
            textView6.setTextColor(ContextCompat.getColorStateList(textView.getContext(), R.color.qui_common_text_link));
            return;
        }
        TextView textView8 = this.resendBtn;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
            textView8 = null;
        }
        textView8.setEnabled(false);
        TextView textView9 = this.resendBtn;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
            textView9 = null;
        }
        textView9.setClickable(false);
        try {
            String str = getResources().getString(R.string.f172945g10) + "(" + this.mSecond + ")";
            TextView textView10 = this.resendBtn;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                textView10 = null;
            }
            textView10.setText(str);
            TextView textView11 = this.resendBtn;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
                textView11 = null;
            }
            TextView textView12 = this.resendBtn;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
            } else {
                textView = textView12;
            }
            textView11.setTextColor(ContextCompat.getColorStateList(textView.getContext(), R.color.qui_common_text_secondary));
        } catch (Exception e16) {
            QLog.e("SmsVerifySecondPageFragment", 1, "refreshSendCodeBtn ", e16);
        }
    }

    private final void hideLoading() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                SmsVerifySecondPageFragment.di(SmsVerifySecondPageFragment.this);
            }
        });
    }

    private final void ii() {
        boolean z16;
        int indexOf$default;
        String Ah = Ah();
        if (Ah != null) {
            if (Ah.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String string = getResources().getString(R.string.g1s, Ah);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026code_hint2, phoneNumText)");
                SpannableString spannableString = new SpannableString(string);
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, Ah, 0, false, 6, (Object) null);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.qui_common_text_primary)), indexOf$default, Ah.length() + indexOf$default, 17);
                Eh().setText(spannableString);
            }
        }
    }

    private final void initViews(View root) {
        List listOf;
        Intent intent;
        View findViewById = root.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.back_btn)");
        Jh(findViewById);
        View findViewById2 = root.findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.tv_tips)");
        Sh((TextView) findViewById2);
        View findViewById3 = root.findViewById(R.id.f116566z3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.verify_code_view)");
        this.verifyCodeView = (VerifyCodeView) findViewById3;
        View findViewById4 = root.findViewById(R.id.aji);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.btn_resend)");
        this.resendBtn = (TextView) findViewById4;
        View findViewById5 = root.findViewById(R.id.tfu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.b\u2026her_verification_methods)");
        Oh((TextView) findViewById5);
        View findViewById6 = root.findViewById(R.id.yex);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.l\u2026her_verification_methods)");
        this.otherVerificationLayout = findViewById6;
        View[] viewArr = new View[3];
        viewArr[0] = Bh();
        TextView textView = this.resendBtn;
        Object obj = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resendBtn");
            textView = null;
        }
        viewArr[1] = textView;
        viewArr[2] = sh();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        QBaseActivity xh5 = xh();
        if (xh5 != null) {
            intent = xh5.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            Ph(intent.getStringExtra(AppConstants.Key.PHONENUM));
            Mh(intent.getStringExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE));
            Nh(intent.getIntExtra("key_sms_verify_function_code", 0));
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            String string = extras.getString("key");
            if (!TextUtils.isEmpty(string)) {
                QLog.e("SmsVerifyFirstPageFragment", 1, "onCreateView countryCode is empty, use default");
                Intrinsics.checkNotNull(string);
                Lh(string);
            }
        }
        ii();
        Intrinsics.checkNotNull(intent);
        if (intent.getIntExtra("key_sms_verify_function_code", 0) == 3) {
            View view = this.otherVerificationLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherVerificationLayout");
                view = null;
            }
            view.setVisibility(0);
        } else {
            View view2 = this.otherVerificationLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherVerificationLayout");
                view2 = null;
            }
            view2.setVisibility(4);
        }
        VerifyCodeView verifyCodeView = this.verifyCodeView;
        if (verifyCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView = null;
        }
        VerifyCodeView verifyCodeView2 = this.verifyCodeView;
        if (verifyCodeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView2 = null;
        }
        verifyCodeView.setDigitTextColorNormal(ContextCompat.getColor(verifyCodeView2.getContext(), R.color.qui_common_text_primary));
        VerifyCodeView verifyCodeView3 = this.verifyCodeView;
        if (verifyCodeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView3 = null;
        }
        VerifyCodeView verifyCodeView4 = this.verifyCodeView;
        if (verifyCodeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView4 = null;
        }
        verifyCodeView3.setDigitTextColorWrong(ContextCompat.getColor(verifyCodeView4.getContext(), R.color.qui_common_feedback_error));
        VerifyCodeView verifyCodeView5 = this.verifyCodeView;
        if (verifyCodeView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView5 = null;
        }
        verifyCodeView5.e(this);
        QBaseActivity xh6 = xh();
        if (xh6 != null) {
            obj = xh6.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        final InputMethodManager inputMethodManager = (InputMethodManager) obj;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                SmsVerifySecondPageFragment.ei(SmsVerifySecondPageFragment.this, inputMethodManager);
            }
        }, 500L);
        long b16 = SmsVerifyComponent.b(yh(), uh(), Ch(), 0L);
        long currentTimeMillis = System.currentTimeMillis() - b16;
        if (b16 > 0 && currentTimeMillis < 60000) {
            int i3 = (int) ((60000 - currentTimeMillis) / 1000);
            this.mSecond = i3;
            this.mSecond = Math.max(i3, 1);
        }
        QLog.i("SmsVerifySecondPageFragment", 2, "initViews: second= " + this.mSecond);
        if (this.mSecond > 1) {
            hi(false);
            this.mHandler.postDelayed(this.runnableCountdown, 1000L);
            if (this.mSecond == 60) {
                SmsVerifyComponent.c(yh(), uh(), Ch(), System.currentTimeMillis());
            }
        } else {
            hi(true);
        }
        gi(root);
    }

    private final void ji(@StringRes final int resId) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.loginregister.sms.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                SmsVerifySecondPageFragment.ki(SmsVerifySecondPageFragment.this, resId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(SmsVerifySecondPageFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.mLoadingDialog == null) {
                QBaseActivity xh5 = this$0.xh();
                Intrinsics.checkNotNull(xh5);
                if (!xh5.isFinishing()) {
                    this$0.mLoadingDialog = LoadingUtil.showLoadingDialog(this$0.getActivity(), HardCodeUtil.qqStr(i3), false);
                }
            }
            Dialog dialog = this$0.mLoadingDialog;
            if (dialog != null) {
                Intrinsics.checkNotNull(dialog);
                if (!dialog.isShowing()) {
                    Dialog dialog2 = this$0.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.show();
                }
            }
        } catch (Throwable th5) {
            QLog.e("SmsVerifySecondPageFragment", 1, "showLoading exception", th5);
        }
    }

    private final void restartTimer(int time) {
        QLog.i("SmsVerifySecondPageFragment", 1, "restartTimer: " + time);
        this.mSecond = time;
        hi(false);
        SmsVerifyComponent.c(yh(), uh(), Ch(), System.currentTimeMillis());
        this.mHandler.postDelayed(this.runnableCountdown, 1000L);
    }

    private final void showToast(String msg2) {
        QQToast makeText = QQToast.makeText(xh(), msg2, 0);
        QBaseActivity xh5 = xh();
        Intrinsics.checkNotNull(xh5);
        makeText.show(xh5.getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void Xc(int strResId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, strResId);
            return;
        }
        QLog.d("SmsVerifySecondPageFragment", 1, "showLoadingDialog");
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1, strResId, 0), 1000L);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void clearWrongCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        VerifyCodeView verifyCodeView = this.verifyCodeView;
        if (verifyCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView = null;
        }
        verifyCodeView.g();
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("SmsVerifySecondPageFragment", 1, "dismissDialog");
        this.mHandler.removeMessages(1);
        hideLoading();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        com.tencent.mobileqq.loginregister.sms.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            eVar.a(xh(), requestCode, resultCode, data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        com.tencent.mobileqq.loginregister.sms.e eVar;
        com.tencent.mobileqq.loginregister.sms.e eVar2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.aji) {
                if (xh() != null && (eVar2 = this.mVerifyProxy) != null) {
                    eVar2.g(xh(), this);
                }
            } else if (num != null && num.intValue() == R.id.tfu) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - th() >= 500) {
                    Kh(currentTimeMillis);
                    if (xh() != null && (eVar = this.mVerifyProxy) != null) {
                        eVar.e(xh());
                    }
                }
            } else if (num != null && num.intValue() == R.id.a47) {
                qh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        gi(getRoot());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        SmsVerifyBaseFragment.a Dh;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            boolean z16 = false;
            View inflate = inflater.inflate(R.layout.gyp, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026d_page, container, false)");
            Qh(inflate);
            if (!Fh()) {
                root = getRoot();
            } else {
                com.tencent.mobileqq.loginregister.sms.e eVar = new com.tencent.mobileqq.loginregister.sms.e();
                this.mVerifyProxy = eVar;
                eVar.h(xh(), this);
                Rh((SmsVerifyBaseFragment.a) new ViewModelProvider(requireActivity()).get(SmsVerifyBaseFragment.a.class));
                QBaseActivity xh5 = xh();
                if (xh5 != null && (window = xh5.getWindow()) != null) {
                    window.setSoftInputMode(5);
                }
                initViews(getRoot());
                if (this.mSecond <= 1 && bi() && (Dh = Dh()) != null) {
                    com.tencent.mobileqq.loginregister.sms.e eVar2 = this.mVerifyProxy;
                    if (eVar2 != null && eVar2.b(xh(), this)) {
                        z16 = true;
                    }
                    Dh.N1(z16);
                }
                if (yh() == 1 || yh() == 6) {
                    ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) wh(), com.tencent.mobileqq.dt.api.c.f203656s, "");
                    ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiStartSensor((AppInterface) wh(), com.tencent.mobileqq.dt.api.c.f203638a);
                }
                root = getRoot();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        vh().removeCallbacksAndMessages(null);
        this.mHandler.removeCallbacksAndMessages(null);
        hideLoading();
        com.tencent.mobileqq.loginregister.sms.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            eVar.onActivityDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.onDetach();
            av.f306600a.a(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onFinish();
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) wh(), com.tencent.mobileqq.dt.api.c.f203657t, "");
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).uiEndSensor((AppInterface) wh(), com.tencent.mobileqq.dt.api.c.f203638a);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        if (getActivity() == null) {
            return;
        }
        ii();
        VerifyCodeView verifyCodeView = this.verifyCodeView;
        VerifyCodeView verifyCodeView2 = null;
        if (verifyCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView = null;
        }
        VerifyCodeView verifyCodeView3 = this.verifyCodeView;
        if (verifyCodeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView3 = null;
        }
        verifyCodeView.setDigitTextColorNormal(ContextCompat.getColor(verifyCodeView3.getContext(), R.color.qui_common_text_primary));
        VerifyCodeView verifyCodeView4 = this.verifyCodeView;
        if (verifyCodeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
            verifyCodeView4 = null;
        }
        VerifyCodeView verifyCodeView5 = this.verifyCodeView;
        if (verifyCodeView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeView");
        } else {
            verifyCodeView2 = verifyCodeView5;
        }
        verifyCodeView4.setDigitTextColorWrong(ContextCompat.getColor(verifyCodeView2.getContext(), R.color.qui_common_feedback_error));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.loginregister.sms.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            eVar.onActivityResume();
        }
    }

    @Override // com.tencent.mobileqq.widget.VerifyCodeView.a
    public void onVerifyCodeChanged(boolean isComplete, @Nullable String code) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(isComplete), code);
            return;
        }
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport((AppInterface) wh(), com.tencent.mobileqq.dt.api.c.f203658u, "");
        if (isComplete) {
            ci();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    @Override // com.tencent.mobileqq.loginregister.sms.fragment.SmsVerifyBaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean qh() {
        boolean z16;
        int i3;
        FragmentManager supportFragmentManager;
        InputMethodManager inputMethodManager;
        FragmentManager supportFragmentManager2;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.loginregister.sms.e eVar = this.mVerifyProxy;
        if (eVar != null) {
            QBaseActivity xh5 = xh();
            SmsVerifyBaseFragment.a Dh = Dh();
            if (Dh != null && Dh.L1()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (eVar.f(xh5, z17, th())) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                FragmentActivity activity = getActivity();
                if (activity != null && (supportFragmentManager2 = activity.getSupportFragmentManager()) != null) {
                    i3 = supportFragmentManager2.getBackStackEntryCount();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        Object systemService = activity2.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                        if (systemService instanceof InputMethodManager) {
                            inputMethodManager = (InputMethodManager) systemService;
                        } else {
                            inputMethodManager = null;
                        }
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(activity2.getWindow().getDecorView().getWindowToken(), 0);
                        }
                    }
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null && (supportFragmentManager = activity3.getSupportFragmentManager()) != null) {
                        supportFragmentManager.popBackStack();
                    }
                    return true;
                }
                Gh();
                finishActivity();
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            Xc(R.string.f211275kd);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.c
    public void startTimer(int time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, time);
        } else {
            restartTimer(time);
        }
    }
}
