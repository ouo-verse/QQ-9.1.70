package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes11.dex */
public class PrivacyPolicyHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int FROM_LOGIN = 0;
    public static final int FROM_REDDOT = 1;
    private static final String MMKV_KEY_PRIVACY_POLICY_HAS_SHOWED = "about_page_privacy_policy_has_showed";
    private static final String MMKV_KEY_USER_AGREEMENT_HAS_SHOWED = "user_agreement_has_showed";
    private static final String PRIVACYPOLICY_KEY = "privacypolicy_state";
    public static final String PRIVACYPOLICY_NOT_SHOWDOT_STATE = "0";
    public static final String PRIVACYPOLICY_SHOWDOT_STATE = "1";
    public static final String PRIVACYPOLICY_STATE_ALLOW = "1";
    public static final String PRIVACYPOLICY_STATE_NOT_ALLOW = "0";
    private static final String PRIVACYPOLICY_UPDATE_KEY = "privacypolicy_update_state";
    private static final String PRIVACYPOLICY_UPDATE_STATE_NOT_SHOWN = "0";
    private static final String PRIVACYPOLICY_UPDATE_STATE_SHOWN = "1";
    public static final String TAG = "PrivacyPolicyHelper";
    private static boolean sHasShownPrivacyUpdateDlg;
    private static boolean sUserAllowed;

    /* loaded from: classes11.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f194947d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f194947d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            PrivacyPolicyHelper.setPrivacyPolicyStatus("1");
            PrivacyPolicyHelper.setPrivacyPolicyUpdateState("1");
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            DialogInterface.OnClickListener onClickListener = this.f194947d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f194948d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f194948d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.f194948d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f194949d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f194949d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.f194949d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    public PrivacyPolicyHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean aboutPageNeedShowPrivacyPolicyRedPoint() {
        return !QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(MMKV_KEY_PRIVACY_POLICY_HAS_SHOWED, false);
    }

    private static SpannableString buildPrivacyPolicySpannable(String str, Context context, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203164zg), AppConstants.URL.SERVICE_PROTOCOL));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203004z1), AppConstants.URL.PRIVATE_PROTOCOL));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203134zd), AppConstants.URL.PRIVATE_PROTOCOL));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203124zc), AppConstants.URL.PERMISSION_PROTOCOL));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203044z5), AppConstants.URL.PRIVACY_POLICY_KIDS));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203184zi), AppConstants.URL.THIRDPARTY_INFORMATION_SHARING));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203154zf), AppConstants.URL.PRIVACY_SUNMMARY));
        return RichTextHelper.buildSpannable(str, context, z16, arrayList);
    }

    public static void expandCheckBoxTouchDelegate(View view) {
        int dpToPx = ViewUtils.dpToPx(48.0f);
        expandViewTouchDelegate(view, dpToPx, dpToPx, ViewUtils.dpToPx(48.0f), ViewUtils.dpToPx(80.0f));
    }

    private static void expandViewTouchDelegate(View view, int i3, int i16, int i17, int i18) {
        if (view == null) {
            return;
        }
        view.post(new Runnable(view, i3, i16, i17, i18) { // from class: com.tencent.mobileqq.app.PrivacyPolicyHelper.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f194942d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f194943e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f194944f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f194945h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f194946i;

            {
                this.f194942d = view;
                this.f194943e = i3;
                this.f194944f = i16;
                this.f194945h = i17;
                this.f194946i = i18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Rect rect = new Rect();
                this.f194942d.setEnabled(true);
                this.f194942d.getHitRect(rect);
                rect.top -= this.f194943e;
                rect.bottom += this.f194944f;
                rect.left -= this.f194945h;
                rect.right += this.f194946i;
                if (QLog.isColorLevel()) {
                    QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                }
                TouchDelegate touchDelegate = new TouchDelegate(rect, this.f194942d);
                if (this.f194942d.getParent() instanceof View) {
                    ((View) this.f194942d.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    public static String getHasShowRedDotState() {
        String d16 = com.tencent.mobileqq.util.cl.d(BaseApplication.getContext(), "privacypolicy_show_reddot");
        if (TextUtils.isEmpty(d16)) {
            return "0";
        }
        return d16;
    }

    public static String getPrivacyPolicyStatus() {
        BaseApplication context = BaseApplication.getContext();
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        String decodeString = from.decodeString("privacypolicy_state", "");
        if (TextUtils.isEmpty(decodeString)) {
            String d16 = com.tencent.mobileqq.util.cl.d(context, "privacypolicy_state");
            if (TextUtils.isEmpty(d16)) {
                d16 = "0";
            } else {
                from.encodeString("privacypolicy_state", d16);
                QLog.d(TAG, 1, "migration privacy state: " + d16);
            }
            return d16;
        }
        return decodeString;
    }

    public static boolean hasShowRedDotState() {
        boolean equals = getHasShowRedDotState().equals("1");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasShowRedDotState, hasShow=" + equals);
        }
        return equals;
    }

    public static void initPrivacyPolicyTextView(TextView textView, String str, List<RichTextHelper.RichTextData> list) {
        textView.setText(RichTextHelper.buildSpannable(str, textView.getContext(), false, list));
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
    }

    public static boolean isUserAllow() {
        if (!sUserAllowed && getPrivacyPolicyStatus().equals("1")) {
            sUserAllowed = true;
        }
        return sUserAllowed;
    }

    public static boolean needShowPrivacyPolicy(int i3) {
        boolean equals = getPrivacyPolicyStatus().equals("0");
        if (i3 == 0) {
            if (equals && hasShowRedDotState()) {
                equals = false;
            }
        } else if (i3 == 1 && equals) {
            setHasShowRedDotState("1");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "needShowPrivacyPolicy, needShow=" + equals + ", from=" + i3);
        }
        return equals;
    }

    public static boolean needShowPrivacyPolicyOrUserAgreement(int i3) {
        return false;
    }

    public static String needShowPrivacyPolicyUpdate() {
        BaseApplication context = BaseApplication.getContext();
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        String decodeString = from.decodeString(PRIVACYPOLICY_UPDATE_KEY, "");
        if (TextUtils.isEmpty(decodeString)) {
            decodeString = com.tencent.mobileqq.util.cl.d(context, PRIVACYPOLICY_UPDATE_KEY);
            if (!TextUtils.isEmpty(decodeString)) {
                from.encodeString(PRIVACYPOLICY_UPDATE_KEY, decodeString);
                QLog.d(TAG, 1, "migration privacy update state: " + decodeString);
            }
        }
        return decodeString;
    }

    public static boolean needShowPrivacyPolicyUpdateDlg() {
        if (!sHasShownPrivacyUpdateDlg) {
            sHasShownPrivacyUpdateDlg = "1".equals(needShowPrivacyPolicyUpdate());
        }
        return !sHasShownPrivacyUpdateDlg;
    }

    public static boolean needShowUserAgreementRedPoint() {
        return !QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(MMKV_KEY_USER_AGREEMENT_HAS_SHOWED, false);
    }

    public static void preloadSP() {
        getPrivacyPolicyStatus();
    }

    public static void setAboutPageHasShownPrivacyPolicyRedPoint() {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(MMKV_KEY_PRIVACY_POLICY_HAS_SHOWED, true);
    }

    public static void setHasShowRedDotState(String str) {
        com.tencent.mobileqq.util.cl.j(BaseApplication.getContext(), "privacypolicy_show_reddot", str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setHasShowRedDotState, state=" + str);
        }
    }

    public static void setHasShownUserAgreementRedPoint() {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(MMKV_KEY_USER_AGREEMENT_HAS_SHOWED, true);
    }

    public static void setPrivacyPolicyStatus(String str) {
        BaseApplication context = BaseApplication.getContext();
        QMMKV.from(context, "common_mmkv_configurations").encodeString("privacypolicy_state", str);
        com.tencent.mobileqq.util.cl.j(context, "privacypolicy_state", str);
        QLog.d(TAG, 1, "setPrivacyPolicyStatus, state=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setPrivacyPolicyUpdateState(String str) {
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeString(PRIVACYPOLICY_UPDATE_KEY, str);
        com.tencent.mobileqq.util.cl.j(BaseApplication.getContext(), PRIVACYPOLICY_UPDATE_KEY, str);
        QLog.d(TAG, 1, "setPrivacyPolicyUpdateState, state=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showPrivacyPolicyAgainDlg(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        SpannableString buildPrivacyPolicySpannable = buildPrivacyPolicySpannable(context.getString(R.string.f203014z2), context, true);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, context.getString(R.string.f203024z3), buildPrivacyPolicySpannable.toString(), R.string.f203114zb, R.string.fpd, new c(onClickListener2), new d(onClickListener));
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setCancelable(true);
        TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
        textView.setText(buildPrivacyPolicySpannable);
        textView.setTextSize(1, 13.0f);
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        ((TextView) createCustomDialog.findViewById(R.id.dialogRightBtn)).setTextColor(Color.parseColor("#40A0FF"));
        createCustomDialog.show();
    }

    public static QQCustomDialog showPrivacyPolicyDlg(Context context, String str) {
        return showPrivacyPolicyDlgForCP(context, str, null, null);
    }

    public static QQCustomDialog showPrivacyPolicyDlgForCP(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i3;
        if (QQUIAppSetting.isGooglePlayVersion()) {
            i3 = R.string.f203064z7;
        } else {
            i3 = R.string.fpe;
        }
        SpannableString buildPrivacyPolicySpannable = buildPrivacyPolicySpannable(context.getString(i3), context, true);
        DialogInterface.OnClickListener onClickListener3 = new DialogInterface.OnClickListener(context, str, onClickListener, onClickListener2) { // from class: com.tencent.mobileqq.app.PrivacyPolicyHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f194933d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f194934e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ DialogInterface.OnClickListener f194935f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ DialogInterface.OnClickListener f194936h;

            /* renamed from: com.tencent.mobileqq.app.PrivacyPolicyHelper$2$a */
            /* loaded from: classes11.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DialogInterface f194938d;

                a(DialogInterface dialogInterface) {
                    this.f194938d = dialogInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) dialogInterface);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    DialogInterface.OnClickListener onClickListener = AnonymousClass2.this.f194935f;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f194938d, i3);
                    }
                }
            }

            /* renamed from: com.tencent.mobileqq.app.PrivacyPolicyHelper$2$b */
            /* loaded from: classes11.dex */
            class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DialogInterface f194940d;

                b(DialogInterface dialogInterface) {
                    this.f194940d = dialogInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) dialogInterface);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    PrivacyPolicyHelper.setPrivacyPolicyStatus("1");
                    PrivacyPolicyHelper.setPrivacyPolicyUpdateState("1");
                    DialogInterface.OnClickListener onClickListener = AnonymousClass2.this.f194936h;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f194940d, i3);
                    }
                }
            }

            {
                this.f194933d = context;
                this.f194934e = str;
                this.f194935f = onClickListener;
                this.f194936h = onClickListener2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, str, onClickListener, onClickListener2);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PrivacyPolicyHelper.showPrivacyPolicyAgainDlg(this.f194933d, this.f194934e, new a(dialogInterface), new b(dialogInterface));
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(dialogInterface) { // from class: com.tencent.mobileqq.app.PrivacyPolicyHelper.2.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ DialogInterface f194937d;

                        {
                            this.f194937d = dialogInterface;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) dialogInterface);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            DialogInterface dialogInterface2 = this.f194937d;
                            if (dialogInterface2 != null) {
                                dialogInterface2.dismiss();
                            }
                        }
                    }, 200L);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                }
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, context.getString(R.string.fpg), buildPrivacyPolicySpannable.toString(), R.string.fpf, R.string.fpd, new b(onClickListener2), onClickListener3);
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setCancelable(true);
        TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
        textView.setText(buildPrivacyPolicySpannable);
        textView.setTextSize(1, 13.0f);
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        ((TextView) createCustomDialog.findViewById(R.id.dialogRightBtn)).setTextColor(Color.parseColor("#40A0FF"));
        createCustomDialog.show();
        return createCustomDialog;
    }

    public static void showPrivacyPolicyDlgForWeChatLogin(boolean z16, Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createPrivacyPolicyDialog = DialogUtil.createPrivacyPolicyDialog(context, HardCodeUtil.qqStr(R.string.f203204zk), HardCodeUtil.qqStr(R.string.f203084z9), R.string.f203054z6, R.string.fpf, onClickListener, onClickListener2);
        createPrivacyPolicyDialog.setCanceledOnTouchOutside(false);
        createPrivacyPolicyDialog.setCancelable(false);
        if (!z16) {
            createPrivacyPolicyDialog.setTitle(HardCodeUtil.qqStr(R.string.f203194zj));
            createPrivacyPolicyDialog.setMessage(buildPrivacyPolicySpannable(HardCodeUtil.qqStr(R.string.f203074z8) + "\n" + HardCodeUtil.qqStr(R.string.f203084z9), context, false));
            createPrivacyPolicyDialog.getMessageTextView().setMovementMethod(RichTextHelper.getMovementMethodInstance());
        }
        createPrivacyPolicyDialog.show();
    }

    public static void showPrivacyPolicyUpdateDlg(Context context, String str) {
        SpannableString buildPrivacyPolicySpannable = buildPrivacyPolicySpannable(context.getString(R.string.f203214zl), context, false);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, context.getString(R.string.f203224zm), buildPrivacyPolicySpannable.toString(), 0, R.string.f203104za, new a(), (DialogInterface.OnClickListener) null);
        createCustomDialog.setCanceledOnTouchOutside(true);
        createCustomDialog.setCancelable(true);
        TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
        textView.setText(buildPrivacyPolicySpannable);
        textView.setTextSize(1, 13.0f);
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        createCustomDialog.show();
        setPrivacyPolicyUpdateState("1");
    }

    public static void initPrivacyPolicyTextView(TextView textView, String str, List<RichTextHelper.RichTextData> list, RichTextHelper.SpanColors spanColors) {
        textView.setText(RichTextHelper.buildSpannable(str, textView.getContext(), false, list, spanColors));
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
    }
}
