package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RiskHintDlgFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    String C;
    String D;
    String E;
    private String F;
    private String G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                RiskHintDlgFragment riskHintDlgFragment = RiskHintDlgFragment.this;
                riskHintDlgFragment.rh(riskHintDlgFragment.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                RiskHintDlgFragment riskHintDlgFragment = RiskHintDlgFragment.this;
                riskHintDlgFragment.rh(riskHintDlgFragment.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (RiskHintDlgFragment.this.getQBaseActivity() != null) {
                RiskHintDlgFragment.this.getQBaseActivity().finish();
                RiskHintDlgFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                RiskHintDlgFragment riskHintDlgFragment = RiskHintDlgFragment.this;
                riskHintDlgFragment.rh(riskHintDlgFragment.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                RiskHintDlgFragment riskHintDlgFragment = RiskHintDlgFragment.this;
                riskHintDlgFragment.rh(riskHintDlgFragment.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                RiskHintDlgFragment riskHintDlgFragment = RiskHintDlgFragment.this;
                riskHintDlgFragment.rh(riskHintDlgFragment.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskHintDlgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (RiskHintDlgFragment.this.getQBaseActivity() != null) {
                RiskHintDlgFragment.this.getQBaseActivity().finish();
                RiskHintDlgFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class h extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String f176976d;

        /* renamed from: e, reason: collision with root package name */
        private final QQCustomDialog f176977e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<QBaseActivity> f176978f;

        public h(String str, QQCustomDialog qQCustomDialog, WeakReference<QBaseActivity> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, qQCustomDialog, weakReference);
                return;
            }
            this.f176976d = str;
            this.f176977e = qQCustomDialog;
            this.f176978f = weakReference;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            WeakReference<QBaseActivity> weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            if (this.f176977e != null && !TextUtils.isEmpty(this.f176976d) && (weakReference = this.f176978f) != null) {
                QBaseActivity qBaseActivity = weakReference.get();
                if (qBaseActivity == null) {
                    QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan error: activity == null");
                    return;
                }
                ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).cancelVerifyRiskDialog(qBaseActivity.getAppRuntime().getCurrentAccountUin());
                if (this.f176976d.contains("1108149324")) {
                    ReportController.o(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B259", "0X800B259", 0, 0, "", "", "", "");
                }
                QLog.d("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: startMiniApp");
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, this.f176976d, 4010, null);
                this.f176977e.dismiss();
                return;
            }
            QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: params invalid");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#4D94FF"));
        }
    }

    public RiskHintDlgFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void sh(QQCustomDialog qQCustomDialog, String str, String str2, String str3) {
        if (qQCustomDialog != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: need to set");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) new SpannableString(str));
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new h(str3, qQCustomDialog, new WeakReference(getQBaseActivity())), 0, str2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            qQCustomDialog.setMessageWithoutAutoLink(spannableStringBuilder);
            return;
        }
        QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: not need to set");
    }

    private void th(QQCustomDialog qQCustomDialog) {
        String str;
        if (qQCustomDialog == null) {
            QLog.e("RiskHintDlgFragment", 1, "setDialogTextColor: dialog == null");
            return;
        }
        TextView titleTextView = qQCustomDialog.getTitleTextView();
        TextView messageTextView = qQCustomDialog.getMessageTextView();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        TextView btnight = qQCustomDialog.getBtnight();
        TextView textView = (TextView) qQCustomDialog.findViewById(R.id.biv);
        if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            str = "#FFFFFF";
        } else {
            str = "#000000";
        }
        try {
            uh(Color.parseColor(str), titleTextView, messageTextView, btnLeft, btnight, textView);
        } catch (Exception e16) {
            QLog.e("RiskHintDlgFragment", 1, "setDialogTextColor: parseColor error", e16);
        }
    }

    private void uh(int i3, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setTextColor(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            Bundle arguments = getArguments();
            long j3 = arguments.getLong("BusiType", 0L);
            String string = arguments.getString("Title", "\u98ce\u9669\u63d0\u793a");
            String string2 = arguments.getString("Message", "\u8be5\u8d26\u53f7\u88ab\u5b89\u5168\u626b\u63cf\u68c0\u6d4b\u5230\u5b58\u5728\u5bc6\u7801\u5916\u6cc4\u98ce\u9669\uff0c\u4e3a\u4fdd\u969c\u4f60\u7684\u8d26\u53f7\u8d22\u4ea7\u4e0e\u9690\u79c1\u5b89\u5168\uff0c\u8bf7\u5c3d\u5feb\u4fee\u6539\u5bc6\u7801\uff0c\u5e76\u5efa\u8bae\u5728\"\u8bbe\u7f6e\"-\"\u8d26\u53f7\u5b89\u5168\"-\"\u964c\u751f\u8bbe\u5907\u767b\u5f55\u4fdd\u62a4\"\u5f00\u542f\u767b\u5f55\u4fdd\u62a4\u3002");
            String string3 = arguments.getString("btnText1", "");
            String string4 = arguments.getString("btnText2", "");
            String string5 = arguments.getString("btnText3", "");
            this.C = arguments.getString("btnAction1", "");
            this.D = arguments.getString("btnAction2", "");
            this.E = arguments.getString("btnAction3", "");
            this.F = arguments.getString("contentUrlText", "");
            this.G = arguments.getString("contentUrlValue", "");
            if (j3 == 1062) {
                qh(string, string2, string3, string4);
            } else if (j3 != 1063 && j3 != 1123 && j3 != 1124) {
                QLog.e("RiskHintDlgFragment", 1, "error templateId:", Long.valueOf(j3));
                if (getActivity() != null) {
                    getActivity().finish();
                }
            } else {
                ph(string, string2, string3, string4, string5);
            }
            ((ILoginApi) QRoute.api(ILoginApi.class)).preloadThirdService();
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).doAfterPushRiskDialog(getQBaseActivity().getAppRuntime().getCurrentAccountUin(), System.currentTimeMillis());
            ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    void ph(String str, String str2, String str3, String str4, String str5) {
        try {
            QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(getQBaseActivity(), 0, str, str2, str3, str4, str5, new d(), new e(), new f());
            createVerticalThreeBtnDialog.setOnDismissListener(new g());
            th(createVerticalThreeBtnDialog);
            sh(createVerticalThreeBtnDialog, str2, this.F, this.G);
            createVerticalThreeBtnDialog.show();
        } catch (Throwable th5) {
            QLog.e("RiskHintDlgFragment", 1, th5, new Object[0]);
            getQBaseActivity().finish();
        }
    }

    void qh(String str, String str2, String str3, String str4) {
        try {
            QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(getQBaseActivity(), 0, str, str2, str3, str4, new a(), new b());
            createCenterTextDialog.setOnDismissListener(new c());
            createCenterTextDialog.show();
        } catch (Throwable th5) {
            QLog.e("RiskHintDlgFragment", 1, th5, new Object[0]);
            getQBaseActivity().finish();
        }
    }

    void rh(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).cancelVerifyRiskDialog(getQBaseActivity().getAppRuntime().getCurrentAccountUin());
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            if (str.contains("1109907872")) {
                ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
            } else if (str.contains("1108149324")) {
                ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800B258", "0X800B258", 0, 0, "", "", "", "");
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getQBaseActivity(), str, 4010, null);
            return;
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            intent.putExtra("from_risk_hint", true);
            RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        ReportController.o(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
