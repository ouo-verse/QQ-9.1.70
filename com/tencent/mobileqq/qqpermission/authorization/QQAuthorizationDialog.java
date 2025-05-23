package com.tencent.mobileqq.qqpermission.authorization;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.base.AuthorizationRequestInfo;
import com.tencent.mobileqq.qqpermission.base.MessageNotificationInfo;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.AuthorizationHintDialog;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestAdapter;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog;
import com.tencent.mobileqq.qqpermission.view.AuthorizationSupplementFragment;
import com.tencent.mobileqq.qqpermission.view.MessageNotificationAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQAuthorizationDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQAuthorizationDialog";
    public static final int TYPE_CHECK_TEXT_LIST_DIALOG = 2;
    public static final int TYPE_IMAGE_TEXT_DIALOG = 1;
    public static final int TYPE_MESSAGE_NOTIFICATION_DIALOG = 3;
    public static final int TYPE_PLAIN_TEXT_DIALOG = 0;
    private static AuthorizationListener mListener;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class AuthorizationListener {
        static IPatchRedirector $redirector_;

        public AuthorizationListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void bottomCheck(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "bottomCheck");
            }
        }

        public void onAllow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QPLog.i(QQAuthorizationDialog.TAG, "onAllow");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        public void onDialogDismiss(AuthorizationRequestDialog authorizationRequestDialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) authorizationRequestDialog);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onDialogDismiss");
            }
        }

        public void onDialogShow(AuthorizationRequestDialog authorizationRequestDialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) authorizationRequestDialog);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW);
            }
        }

        public void onHintDialogShow(AuthorizationHintDialog authorizationHintDialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) authorizationHintDialog);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onHintDialogShow");
            }
        }

        public void onRefuse() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onRefuse");
            }
        }

        public void onSubHintDialogHide(MessageNotificationInfo messageNotificationInfo, AuthorizationHintDialog authorizationHintDialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageNotificationInfo, (Object) authorizationHintDialog);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onSubHintDialogHide");
            }
        }

        public void onSupplementFragmentBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onSupplementFragmentBack");
            }
        }

        public void onSupplementTvClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            } else {
                QPLog.i(QQAuthorizationDialog.TAG, "onSupplementTvClick");
            }
        }

        public void onAllow(List<Boolean> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QPLog.i(QQAuthorizationDialog.TAG, "onAllow");
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements DialogInterface.OnShowListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AuthorizationRequestDialog f274296d;

        a(AuthorizationRequestDialog authorizationRequestDialog) {
            this.f274296d = authorizationRequestDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) authorizationRequestDialog);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QLog.d(QQAuthorizationDialog.TAG, 1, "AuthorizationRequestDialog height: " + this.f274296d.setAndGetDialogHeight());
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AuthorizationRequestDialog f274297d;

        b(AuthorizationRequestDialog authorizationRequestDialog) {
            this.f274297d = authorizationRequestDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) authorizationRequestDialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQAuthorizationDialog.mListener.onAllow();
                List<Boolean> listCheck = this.f274297d.getListCheck();
                if (listCheck != null) {
                    QQAuthorizationDialog.mListener.onAllow(listCheck);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQAuthorizationDialog.mListener.onRefuse();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QQAuthorizationDialog.mListener.onDialogDismiss((AuthorizationRequestDialog) dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQAuthorizationDialog.mListener.onSupplementTvClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class f extends MessageNotificationAdapter.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AuthorizationRequestDialog f274298a;

        f(AuthorizationRequestDialog authorizationRequestDialog) {
            this.f274298a = authorizationRequestDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) authorizationRequestDialog);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.view.MessageNotificationAdapter.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f274298a.disableAllowButton();
                super.a();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.view.MessageNotificationAdapter.b
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f274298a.enableAllowButton();
                super.b(i3);
            }
        }
    }

    public QQAuthorizationDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static AuthorizationRequestDialog buildCheckTextListDialog(AuthorizationRequestInfo authorizationRequestInfo, AuthorizationRequestDialog authorizationRequestDialog) {
        AuthorizationRequestAdapter authorizationRequestAdapter = new AuthorizationRequestAdapter();
        authorizationRequestAdapter.updateData(authorizationRequestInfo.messageList);
        authorizationRequestDialog.showListView(authorizationRequestAdapter);
        authorizationRequestDialog.setListViewCheckedListener();
        String str = authorizationRequestInfo.requestSupplement;
        if (str != null) {
            authorizationRequestDialog.setSupplementTv(str);
        }
        authorizationRequestDialog.hideDescriptionMessage();
        return authorizationRequestDialog;
    }

    private static AuthorizationRequestDialog buildImageTextDialog(AuthorizationRequestInfo authorizationRequestInfo, AuthorizationRequestDialog authorizationRequestDialog) {
        authorizationRequestDialog.setMessageContent(authorizationRequestInfo.messageContent);
        authorizationRequestDialog.setMessageSupplement(authorizationRequestInfo.messageSupplement);
        String str = authorizationRequestInfo.requestSupplement;
        if (str != null) {
            authorizationRequestDialog.setSupplementTv(str);
        }
        Drawable drawable = authorizationRequestInfo.messageIconDrawable;
        if (drawable != null) {
            authorizationRequestDialog.setMessageIcon(drawable);
        } else {
            authorizationRequestDialog.setMessageIcon(authorizationRequestInfo.messageIconResId);
        }
        authorizationRequestDialog.hideListView();
        return authorizationRequestDialog;
    }

    private static AuthorizationRequestDialog buildMessageNotificationDialog(Context context, AuthorizationRequestInfo authorizationRequestInfo, AuthorizationRequestDialog authorizationRequestDialog) {
        MessageNotificationAdapter messageNotificationAdapter = new MessageNotificationAdapter();
        messageNotificationAdapter.setAuthorizationListener(mListener);
        messageNotificationAdapter.setNotificationListener(new f(authorizationRequestDialog));
        messageNotificationAdapter.updateData(context, authorizationRequestInfo.notificationInfoList);
        authorizationRequestDialog.showListView(messageNotificationAdapter);
        String str = authorizationRequestInfo.requestSupplement;
        if (str != null) {
            authorizationRequestDialog.setSupplementTv(str);
        }
        authorizationRequestDialog.hideDescriptionMessage();
        return authorizationRequestDialog;
    }

    private static AuthorizationRequestDialog buildPlainTextDialog(AuthorizationRequestInfo authorizationRequestInfo, AuthorizationRequestDialog authorizationRequestDialog) {
        authorizationRequestDialog.setSupplementTv(authorizationRequestInfo.requestSupplement);
        authorizationRequestDialog.hideMessage();
        return authorizationRequestDialog;
    }

    private static AuthorizationRequestDialog createDialog(Context context) {
        AuthorizationRequestDialog authorizationRequestDialog = new AuthorizationRequestDialog(context, R.style.f243861y);
        authorizationRequestDialog.setCanceledOnTouchOutside(false);
        authorizationRequestDialog.setCancelable(true);
        return authorizationRequestDialog;
    }

    public static void destroyListener() {
        mListener = null;
    }

    public static AuthorizationListener getListener() {
        return mListener;
    }

    public static void showAuthorizationRequestDialog(Context context, AuthorizationRequestInfo authorizationRequestInfo) {
        if (context == null) {
            QLog.e(TAG, 1, "showAuthorizationRequestDialog context is null");
            return;
        }
        AuthorizationRequestDialog createDialog = createDialog(context);
        mListener = authorizationRequestInfo.listener;
        createDialog.setIconText(authorizationRequestInfo.iconText);
        createDialog.setRequestTitle(authorizationRequestInfo.requestContent);
        Drawable drawable = authorizationRequestInfo.businessIconDrawable;
        if (drawable != null) {
            createDialog.setBusinessIcon(drawable);
        } else {
            createDialog.setBusinessIcon(authorizationRequestInfo.businessIconResId);
        }
        int i3 = authorizationRequestInfo.dialogType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        createDialog = buildMessageNotificationDialog(context, authorizationRequestInfo, createDialog);
                    }
                } else {
                    createDialog = buildCheckTextListDialog(authorizationRequestInfo, createDialog);
                }
            } else {
                createDialog = buildImageTextDialog(authorizationRequestInfo, createDialog);
            }
        } else {
            createDialog = buildPlainTextDialog(authorizationRequestInfo, createDialog);
        }
        if (authorizationRequestInfo.isShowTitleHint) {
            createDialog.showHintDialog(context, authorizationRequestInfo.hintTitle, authorizationRequestInfo.hintContent);
            createDialog.setOnShowListener(new a(createDialog));
        } else {
            createDialog.hideHintImage();
        }
        if (authorizationRequestInfo.isShowBottomCheck) {
            createDialog.showBottomCheck(authorizationRequestInfo.bottomIsDefaultCheck, authorizationRequestInfo.bottomText);
        }
        if (!TextUtils.isEmpty(authorizationRequestInfo.subHead)) {
            createDialog.setSubHeadTv(authorizationRequestInfo.subHead);
        }
        if (mListener != null) {
            createDialog.setAllowClickListener(new b(createDialog));
            createDialog.setRefuseClickListener(new c());
            createDialog.setOnDismissListener(new d());
            createDialog.setSupplementTvClickListener(new e());
            if (Build.VERSION.SDK_INT != 23) {
                createDialog.getWindow().setWindowAnimations(R.style.f173293c);
            }
            mListener.onDialogShow(createDialog);
        }
        try {
            createDialog.show();
        } catch (WindowManager.BadTokenException e16) {
            QLog.e(TAG, 1, "toShowDialog e " + e16.getMessage());
        }
    }

    public static void showSupplementFragment(Activity activity, AuthorizationSupplementFragment authorizationSupplementFragment) {
        QPublicFragmentActivity.startForResult(activity, (Class<? extends QPublicBaseFragment>) authorizationSupplementFragment.getClass(), 0);
    }
}
