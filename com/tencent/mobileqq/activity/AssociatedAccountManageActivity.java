package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u53f7\u52a9\u624b-\u5173\u8054\u8d26\u53f7\u7ba1\u7406\u9875\u9762", path = RouterConstants.UI_ROUTE_SUB_ACCOUNT_ASSOCIATED_ACCOUNT_MANAGE)
/* loaded from: classes9.dex */
public class AssociatedAccountManageActivity extends SubAccountBaseActivity implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_HIDE_LOADING = 8194;
    private static final int MSG_SHOW_LOADING = 8193;
    private static final int MSG_SHOW_TOAST = 8195;
    private static final String TAG = "AssociatedAccountManage";
    private static final int TYPE_ACCOUNT = 1;
    private static final int TYPE_SUBACCOUNT = 0;
    com.tencent.mobileqq.avatar.observer.a avatarObserver;
    private BusinessObserver cardObserver;
    private String delCurrentUin;
    BusinessObserver fob;
    private Toast lastToast;
    public List<SimpleAccount> mAccountList;
    public LinearLayout mAccountListView;
    public View mAccountTitle;
    public boolean mChanged;
    Dialog mDelAccountDialog;
    private FormSwitchItem mDisplayThirdQQCkb;
    private MqqHandler mHandler;
    private boolean mIsClearHistory;
    public boolean mIsDisplayThirdFuc;
    public boolean mIsFromAccountManage;
    private QQProgressDialog mProgressDialog;
    private com.tencent.mobileqq.app.dc mSubAccountBindObserver;
    public List<SubAccountInfo> mSubAccountList;
    public LinearLayout mSubAccountListView;
    public View mSubAccountTitle;
    ActionSheet menuDialog;
    ActionSheet menuUnbindDialog;
    private k onBtnClickLisForUnbind;
    private View.OnClickListener onDeleteClickListener;
    private View.OnClickListener onDeleteItemSelected;
    private View.OnClickListener onUnBindClickListener;
    private RotateSwitchImageView selectedAccountView;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.dc {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
            } else {
                AssociatedAccountManageActivity.this.hideJuhua();
                AssociatedAccountManageActivity.this.refreshAllAccount();
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
            } else {
                AssociatedAccountManageActivity.this.hideJuhua();
                AssociatedAccountManageActivity.this.refreshAllAccount();
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
            } else {
                AssociatedAccountManageActivity.this.hideJuhua();
                AssociatedAccountManageActivity.this.refreshAllAccount();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends MqqHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 8193:
                    if (AssociatedAccountManageActivity.this.mProgressDialog == null) {
                        AssociatedAccountManageActivity associatedAccountManageActivity = AssociatedAccountManageActivity.this;
                        AssociatedAccountManageActivity associatedAccountManageActivity2 = AssociatedAccountManageActivity.this;
                        associatedAccountManageActivity.mProgressDialog = new QQProgressDialog(associatedAccountManageActivity2, associatedAccountManageActivity2.getTitleBarHeight());
                    }
                    if (!AssociatedAccountManageActivity.this.isFinishing() && !AssociatedAccountManageActivity.this.mProgressDialog.isShowing()) {
                        try {
                            AssociatedAccountManageActivity.this.mProgressDialog.show();
                            break;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(AssociatedAccountManageActivity.TAG, 2, "QQProgressDialog show exception.", e16);
                                break;
                            }
                        }
                    }
                    break;
                case 8194:
                    if (AssociatedAccountManageActivity.this.mProgressDialog != null && AssociatedAccountManageActivity.this.mProgressDialog.isShowing()) {
                        AssociatedAccountManageActivity.this.mProgressDialog.dismiss();
                        AssociatedAccountManageActivity.this.mProgressDialog = null;
                        break;
                    }
                    break;
                case 8195:
                    if (AssociatedAccountManageActivity.this.lastToast != null) {
                        AssociatedAccountManageActivity.this.lastToast.cancel();
                    }
                    AssociatedAccountManageActivity associatedAccountManageActivity3 = AssociatedAccountManageActivity.this;
                    associatedAccountManageActivity3.lastToast = QQToast.makeText(associatedAccountManageActivity3, message.arg1, message.arg2, 0).show(AssociatedAccountManageActivity.this.getTitleBarHeight());
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements ISubAccountApi.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.a
        public void a(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            boolean isChecked = AssociatedAccountManageActivity.this.mDisplayThirdQQCkb.isChecked();
            AssociatedAccountManageActivity.this.mHandler.removeMessages(8193);
            AssociatedAccountManageActivity.this.mHandler.sendEmptyMessage(8194);
            Message obtainMessage = AssociatedAccountManageActivity.this.mHandler.obtainMessage(8195);
            if (!z16) {
                i16 = 1;
            }
            obtainMessage.arg1 = i16;
            if (z16) {
                if (isChecked) {
                    i3 = R.string.fu7;
                } else {
                    i3 = R.string.fu6;
                }
            } else if (isChecked) {
                i3 = R.string.hs8;
            } else {
                i3 = R.string.hs7;
            }
            obtainMessage.arg2 = i3;
            AssociatedAccountManageActivity.this.mHandler.sendMessage(obtainMessage);
            if (z16) {
                AssociatedAccountManageActivity.this.updateAccountViewAsDisplayChanged();
                com.tencent.mobileqq.subaccount.h.L((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), isChecked);
            } else {
                AssociatedAccountManageActivity.this.setSwitchChecked(!isChecked);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f174929d;

        d(AppInterface appInterface) {
            this.f174929d = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this, (Object) appInterface);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AssociatedAccountManageActivity.this.onBackEvent();
                ReportController.y(this.f174929d, "0X800C488");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view instanceof RotateSwitchImageView) {
                View theShader = AssociatedAccountManageActivity.this.getTheShader(view);
                View theName = AssociatedAccountManageActivity.this.getTheName(view);
                if (AssociatedAccountManageActivity.this.selectedAccountView == null) {
                    AssociatedAccountManageActivity.this.selectedAccountView = (RotateSwitchImageView) view;
                    AssociatedAccountManageActivity.this.selectedAccountView.c();
                    if (theName != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) theName.getLayoutParams();
                        layoutParams.rightMargin = (int) ((((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 12.0f) + (((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 75.0f));
                        theName.setLayoutParams(layoutParams);
                    }
                    if (theShader instanceof ShaderAnimLayout) {
                        ((ShaderAnimLayout) theShader).h();
                    }
                    if (AppSetting.f99565y) {
                        view.setContentDescription(AssociatedAccountManageActivity.this.getString(R.string.f170750a34));
                    }
                } else if (AssociatedAccountManageActivity.this.selectedAccountView == view) {
                    AssociatedAccountManageActivity.this.selectedAccountView.b();
                    if (theName != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) theName.getLayoutParams();
                        layoutParams2.rightMargin = (int) (((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 12.0f);
                        theName.setLayoutParams(layoutParams2);
                    }
                    if (theShader instanceof ShaderAnimLayout) {
                        ((ShaderAnimLayout) theShader).c();
                    }
                    AssociatedAccountManageActivity.this.selectedAccountView = null;
                    if (AppSetting.f99565y) {
                        view.setContentDescription(AssociatedAccountManageActivity.this.getString(R.string.i_z));
                    }
                } else {
                    AssociatedAccountManageActivity.this.selectedAccountView.b();
                    AssociatedAccountManageActivity associatedAccountManageActivity = AssociatedAccountManageActivity.this;
                    View theName2 = associatedAccountManageActivity.getTheName(associatedAccountManageActivity.selectedAccountView);
                    if (theName2 != null) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) theName2.getLayoutParams();
                        layoutParams3.rightMargin = (int) (((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 12.0f);
                        theName2.setLayoutParams(layoutParams3);
                    }
                    RotateSwitchImageView rotateSwitchImageView = (RotateSwitchImageView) view;
                    rotateSwitchImageView.c();
                    if (theName != null) {
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) theName.getLayoutParams();
                        layoutParams4.rightMargin = (int) ((((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 12.0f) + (((QIphoneTitleBarActivity) AssociatedAccountManageActivity.this).mDensity * 75.0f));
                        theName.setLayoutParams(layoutParams4);
                    }
                    if (AppSetting.f99565y) {
                        view.setContentDescription(AssociatedAccountManageActivity.this.getString(R.string.f170750a34));
                        AssociatedAccountManageActivity.this.selectedAccountView.setContentDescription(AssociatedAccountManageActivity.this.getString(R.string.i_z));
                    }
                    if (theShader instanceof ShaderAnimLayout) {
                        ((ShaderAnimLayout) theShader).h();
                    }
                    AssociatedAccountManageActivity associatedAccountManageActivity2 = AssociatedAccountManageActivity.this;
                    View theShader2 = associatedAccountManageActivity2.getTheShader(associatedAccountManageActivity2.selectedAccountView);
                    if (theShader2 instanceof ShaderAnimLayout) {
                        ((ShaderAnimLayout) theShader2).c();
                    }
                    AssociatedAccountManageActivity.this.selectedAccountView = rotateSwitchImageView;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                View view2 = (View) view.getParent();
                if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof SubAccountInfo)) {
                    AssociatedAccountManageActivity.this.showUnbindMenuDialog((SubAccountInfo) view2.getTag());
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C486", "0X800C486", 0, 0, ((SubAccountInfo) view2.getTag()).subuin, "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view.getParent() != null && (view2 = (View) view.getParent().getParent()) != null && view2.getTag() != null && (view2.getTag() instanceof SimpleAccount)) {
                AssociatedAccountManageActivity.this.showDeleteAccountPromptDialog((SimpleAccount) view2.getTag());
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C487", "0X800C487", 0, 0, ((SimpleAccount) view2.getTag()).getUin(), "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h implements ISubAccountApi.b {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.b
        public void a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountManageActivity.TAG, 2, "onUpdateFriendInfo  uin = " + str + " isSuccess = " + z16);
            }
            if (z16 && !TextUtils.isEmpty(str)) {
                View findItemViewByUin = AssociatedAccountManageActivity.this.findItemViewByUin(str, 0);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (findItemViewByUin != null) {
                    ((SingleLineTextView) findItemViewByUin.findViewById(R.id.f5e)).setText(((IContactUtils) QRoute.api(IContactUtils.class)).getAccountNickName(appInterface, str));
                    AssociatedAccountManageActivity.this.updateFace(str, findItemViewByUin);
                }
                View findItemViewByUin2 = AssociatedAccountManageActivity.this.findItemViewByUin(str, 1);
                if (findItemViewByUin2 != null) {
                    ((SingleLineTextView) findItemViewByUin2.findViewById(R.id.f5e)).setText(((IContactUtils) QRoute.api(IContactUtils.class)).getAccountNickName(appInterface, str));
                    AssociatedAccountManageActivity.this.updateFace(str, findItemViewByUin2);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16 && !TextUtils.isEmpty(str)) {
                View findItemViewByUin = AssociatedAccountManageActivity.this.findItemViewByUin(str, 0);
                if (findItemViewByUin != null) {
                    AssociatedAccountManageActivity.this.updateFace(str, findItemViewByUin);
                }
                View findItemViewByUin2 = AssociatedAccountManageActivity.this.findItemViewByUin(str, 1);
                if (findItemViewByUin2 != null) {
                    AssociatedAccountManageActivity.this.updateFace(str, findItemViewByUin2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j extends com.tencent.mobileqq.loginregister.servlet.b {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private String f174936e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f174937f;

        public j(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AssociatedAccountManageActivity.this, str, Boolean.valueOf(z16));
            } else {
                this.f174936e = str;
                this.f174937f = z16;
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.b
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountManageActivity.TAG, 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + z16 + ",peerUin:" + this.f174936e + ",isDeleteHistory:" + this.f174937f);
            }
            String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
            if (z16 && lastLoginUin != null && lastLoginUin.equals(this.f174936e)) {
                MobileQQ.sMobileQQ.setLastLoginUin("");
                if (QLog.isColorLevel()) {
                    QLog.d(AssociatedAccountManageActivity.TAG, 2, "delete Last_Login");
                }
            }
            if (z16 && this.f174937f) {
                AssociatedAccountManageActivity.this.deleteDataFromSP(this.f174936e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        SubAccountInfo f174939d;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountManageActivity.this);
            }
        }

        public void a(SubAccountInfo subAccountInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) subAccountInfo);
            } else {
                this.f174939d = subAccountInfo;
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
                return;
            }
            ActionSheet actionSheet = AssociatedAccountManageActivity.this.menuUnbindDialog;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
            if (i3 == 0) {
                AssociatedAccountManageActivity.this.unbindAccount(this.f174939d);
            }
        }
    }

    public AssociatedAccountManageActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsDisplayThirdFuc = true;
        this.mIsFromAccountManage = false;
        this.mChanged = false;
        this.mIsClearHistory = false;
        this.mHandler = new b();
        this.cardObserver = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getCardObserver(new c());
        this.onDeleteItemSelected = new e();
        this.onUnBindClickListener = new f();
        this.onDeleteClickListener = new g();
        this.menuUnbindDialog = null;
        this.menuDialog = null;
        this.onBtnClickLisForUnbind = new k();
        this.fob = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getFriendListObserver(new h());
        this.avatarObserver = new i();
        this.mSubAccountBindObserver = new a();
    }

    private void bindAccountListView() {
        this.mAccountListView.removeAllViews();
        List<SimpleAccount> list = this.mAccountList;
        if (list != null && !list.isEmpty()) {
            this.mAccountTitle.setVisibility(0);
            int size = this.mAccountList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "bindAccountListView i=" + i3 + ", account=" + this.mAccountList.get(i3));
                }
                SimpleAccount simpleAccount = this.mAccountList.get(i3);
                if (simpleAccount != null) {
                    View inflate = getLayoutInflater().inflate(R.layout.bzp, (ViewGroup) this.mAccountListView, false);
                    if (inflate instanceof FormItemRelativeLayout) {
                        FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) inflate;
                        formItemRelativeLayout.setNeedFocusBg(false);
                        if (size == 1) {
                            formItemRelativeLayout.setBGType(0);
                        } else if (i3 == 0) {
                            formItemRelativeLayout.setBGType(1);
                        } else if (i3 == size - 1) {
                            formItemRelativeLayout.setBGType(3);
                        } else {
                            formItemRelativeLayout.setBGType(2);
                        }
                        formItemRelativeLayout.setNeedFocusBg(true);
                    }
                    inflate.setTag(simpleAccount);
                    ((ImageView) inflate.findViewById(R.id.icon)).setScaleType(ImageView.ScaleType.FIT_CENTER);
                    RotateSwitchImageView rotateSwitchImageView = (RotateSwitchImageView) inflate.findViewById(R.id.bfn);
                    rotateSwitchImageView.setOnClickListener(this.onDeleteItemSelected);
                    VideoReport.setElementId(rotateSwitchImageView, "em_bas_select_delete_account");
                    EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
                    VideoReport.setElementEndExposePolicy(rotateSwitchImageView, endExposurePolicy);
                    Button button = (Button) inflate.findViewById(R.id.bex);
                    button.setOnClickListener(this.onDeleteClickListener);
                    VideoReport.setElementId(button, "em_bas_delete_other_account");
                    VideoReport.setElementEndExposePolicy(button, endExposurePolicy);
                    VideoReport.setElementParam(button, "em_bas_deleted_uin", simpleAccount.getUin());
                    this.mAccountListView.addView(inflate);
                }
            }
            updateAccountListView();
            return;
        }
        this.mAccountTitle.setVisibility(8);
    }

    private void bindSubAccountListView() {
        this.mSubAccountListView.removeAllViews();
        List<SubAccountInfo> list = this.mSubAccountList;
        if (list != null && !list.isEmpty()) {
            this.mSubAccountTitle.setVisibility(0);
            int size = this.mSubAccountList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "bindSubAccountListView i=" + i3 + ", subaccount=" + this.mSubAccountList.get(i3));
                }
                SubAccountInfo subAccountInfo = this.mSubAccountList.get(i3);
                if (subAccountInfo != null) {
                    View inflate = getLayoutInflater().inflate(R.layout.bzq, (ViewGroup) this.mSubAccountListView, false);
                    inflate.setTag(subAccountInfo);
                    Button button = (Button) inflate.findViewById(R.id.kh9);
                    button.setOnClickListener(this.onUnBindClickListener);
                    VideoReport.setElementId(button, "em_bas_disassociate");
                    VideoReport.setElementEndExposePolicy(button, EndExposurePolicy.REPORT_ALL);
                    VideoReport.setElementParam(button, "remove_uin", subAccountInfo.subuin);
                    if (inflate instanceof FormItemRelativeLayout) {
                        FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) inflate;
                        formItemRelativeLayout.setNeedFocusBg(false);
                        if (size == 1) {
                            formItemRelativeLayout.setBGType(0);
                        } else if (i3 == 0) {
                            formItemRelativeLayout.setBGType(1);
                        } else if (i3 == size - 1) {
                            formItemRelativeLayout.setBGType(3);
                        } else {
                            formItemRelativeLayout.setBGType(2);
                        }
                        formItemRelativeLayout.setNeedFocusBg(true);
                    }
                    this.mSubAccountListView.addView(inflate);
                }
            }
            updateSubAccountListView();
            return;
        }
        this.mSubAccountTitle.setVisibility(8);
    }

    private void delAccountRecord(String str, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ILoginServletService iLoginServletService = (ILoginServletService) peekAppRuntime.getRuntimeService(ILoginServletService.class, "all");
        String property = peekAppRuntime.getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + this.delCurrentUin);
        if (property == null || property.length() == 0) {
            property = this.delCurrentUin;
        }
        iLoginServletService.deleteAccount(this.delCurrentUin, property, new j(str, z16));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "am.deleteAccount " + this.delCurrentUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View findItemViewByUin(String str, int i3) {
        LinearLayout linearLayout;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 == 0) {
            linearLayout = this.mSubAccountListView;
        } else if (i3 == 1) {
            linearLayout = this.mAccountListView;
        } else {
            linearLayout = null;
        }
        if (linearLayout == null) {
            return null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayout.getChildAt(i16);
            Object tag = childAt.getTag();
            if (i3 == 0) {
                if (tag != null && (tag instanceof SubAccountInfo) && str.equals(((SubAccountInfo) tag).subuin)) {
                    return childAt;
                }
            } else if (i3 == 1 && tag != null && (tag instanceof SimpleAccount) && str.equals(((SimpleAccount) tag).getUin())) {
                return childAt;
            }
        }
        return null;
    }

    @NonNull
    private Map<String, Object> getCommonPageInfo() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("muin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        StringBuilder sb5 = new StringBuilder();
        for (SubAccountInfo subAccountInfo : this.mSubAccountList) {
            if (subAccountInfo != null) {
                sb5.append(subAccountInfo.subuin);
                sb5.append(" ");
            }
        }
        hashMap.put("correlation_uin", sb5.toString());
        if (this.mIsFromAccountManage) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("correlation_page_source", str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getTheName(View view) {
        View view2 = (View) view.getParent();
        if (view2 != null) {
            return view2.findViewById(R.id.f5e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getTheShader(View view) {
        View view2 = (View) view.getParent();
        if (view2 != null) {
            return view2.findViewById(R.id.iqk);
        }
        return null;
    }

    private void initAccountList() {
        Object obj;
        List<SimpleAccount> list = this.mAccountList;
        if (list == null) {
            this.mAccountList = new ArrayList();
        } else {
            list.clear();
        }
        if (this.mIsDisplayThirdFuc && !this.mIsFromAccountManage) {
            ArrayList<SimpleAccount> arrayList = new ArrayList();
            arrayList.addAll(getAppRuntime().getApplication().getAllAccounts());
            String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
            for (SimpleAccount simpleAccount : arrayList) {
                if (simpleAccount != null && !account.equals(simpleAccount.getUin())) {
                    List<SubAccountInfo> list2 = this.mSubAccountList;
                    boolean z16 = false;
                    if (list2 != null && list2.size() > 0) {
                        for (SubAccountInfo subAccountInfo : this.mSubAccountList) {
                            if (subAccountInfo != null && simpleAccount.getUin().equals(subAccountInfo.subuin)) {
                                z16 = true;
                            }
                        }
                    }
                    if (!z16) {
                        this.mAccountList.add(simpleAccount);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initAccountList mAccountList=");
            sb5.append(this.mAccountList);
            sb5.append(", size=");
            List<SimpleAccount> list3 = this.mAccountList;
            if (list3 != null) {
                obj = Integer.valueOf(list3.size());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        bindAccountListView();
        updateAccountViewAsDisplayChanged();
    }

    private void initSubAccountList() {
        Object obj;
        List<SubAccountInfo> list = this.mSubAccountList;
        if (list == null) {
            this.mSubAccountList = new ArrayList();
        } else {
            list.clear();
        }
        this.mSubAccountList.addAll(((SubAccountServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountService.class, "")).getAllSubAccountInfo());
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initSubAccountList subaccountList=");
            sb5.append(this.mSubAccountList);
            sb5.append(", size=");
            List<SubAccountInfo> list2 = this.mSubAccountList;
            if (list2 != null) {
                obj = Integer.valueOf(list2.size());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        bindSubAccountListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteAccountPromptDialog$0(AppRuntime appRuntime, SimpleAccount simpleAccount, DialogInterface dialogInterface, int i3) {
        int i16;
        if (this.mIsClearHistory) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ReportController.o(appRuntime, "dc00898", "", "", "0X800C21B", "0X800C21B", i16, 0, "3", "", "", "");
        deleteAccount(simpleAccount, this.mIsClearHistory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteAccountPromptDialog$2(QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        String str;
        this.mIsClearHistory = !this.mIsClearHistory;
        View findViewById = qQCustomDialog.findViewById(R.id.dialogRightBtn);
        if (this.mIsClearHistory) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(findViewById, "is_log_local_chat", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAllAccount() {
        List<SimpleAccount> list;
        initSubAccountList();
        initAccountList();
        List<SubAccountInfo> list2 = this.mSubAccountList;
        if ((list2 == null || list2.size() == 0) && ((list = this.mAccountList) == null || list.size() == 0)) {
            onBackEvent();
        }
        setManageAccountPageInfo();
    }

    private void setManageAccountPageInfo() {
        String str;
        Map<String, Object> commonPageInfo = getCommonPageInfo();
        List<SimpleAccount> list = this.mAccountList;
        if (list != null && !list.isEmpty()) {
            str = "1";
        } else {
            str = "2";
        }
        commonPageInfo.put("is_other_accounts", str);
        VideoReport.setPageParams(this.titleRoot, new PageParams((Map<String, ?>) commonPageInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwitchChecked(boolean z16) {
        String str;
        this.mDisplayThirdQQCkb.setOnCheckedChangeListener(null);
        this.mDisplayThirdQQCkb.setChecked(z16);
        this.mDisplayThirdQQCkb.setOnCheckedChangeListener(this);
        Switch r36 = this.mDisplayThirdQQCkb.getSwitch();
        if (this.mDisplayThirdQQCkb.getSwitch().isChecked()) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(r36, "switch_current_state", str);
    }

    private void showDelAccountDialog() {
        try {
            if (this.mDelAccountDialog == null) {
                ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
                this.mDelAccountDialog = reportDialog;
                reportDialog.setContentView(R.layout.account_wait);
                ((TextView) this.mDelAccountDialog.findViewById(R.id.dialogText)).setText(getString(R.string.akr));
                this.mDelAccountDialog.setCancelable(false);
            }
            this.mDelAccountDialog.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
    }

    private void updateAccountListView() {
        LinearLayout linearLayout = this.mAccountListView;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            int childCount = this.mAccountListView.getChildCount();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateAccountListView account size=" + childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mAccountListView.getChildAt(i3);
                SimpleAccount simpleAccount = (SimpleAccount) childAt.getTag();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "updateAccountListView i=" + i3 + ", view tag=" + simpleAccount);
                }
                if (simpleAccount != null) {
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.icon);
                    SingleLineTextView singleLineTextView = (SingleLineTextView) childAt.findViewById(R.id.f5e);
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    String u16 = com.tencent.mobileqq.subaccount.h.u(appInterface, simpleAccount);
                    singleLineTextView.setText(u16);
                    FaceDrawable userFaceDrawable = FaceDrawable.getUserFaceDrawable(appInterface, simpleAccount.getUin(), (byte) 3);
                    if (userFaceDrawable != null && imageView != null) {
                        imageView.setImageDrawable(userFaceDrawable);
                    }
                    if (AppSetting.f99565y) {
                        childAt.setContentDescription(u16);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateAccountListView mAccountListView is null or size is 0.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccountViewAsDisplayChanged() {
        List<SimpleAccount> list = this.mAccountList;
        if (list != null && list.size() > 0) {
            this.mAccountTitle.setVisibility(0);
            this.mAccountListView.setVisibility(0);
            this.mDisplayThirdQQCkb.setVisibility(0);
            findViewById(R.id.bml).setVisibility(0);
            return;
        }
        this.mDisplayThirdQQCkb.setVisibility(8);
        findViewById(R.id.bml).setVisibility(8);
    }

    private void updateSubAccountListView() {
        LinearLayout linearLayout = this.mSubAccountListView;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            int childCount = this.mSubAccountListView.getChildCount();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateSubAccountListView subaccount size=" + childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mSubAccountListView.getChildAt(i3);
                SubAccountInfo subAccountInfo = this.mSubAccountList.get(i3);
                if (subAccountInfo != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "updateSubAccountListView i=" + i3 + ", view tag=" + subAccountInfo);
                    }
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.icon);
                    ImageView imageView2 = (ImageView) childAt.findViewById(R.id.d_c);
                    SingleLineTextView singleLineTextView = (SingleLineTextView) childAt.findViewById(R.id.f5e);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    String a16 = com.tencent.mobileqq.imcore.proxy.utils.a.a((BaseQQAppInterface) peekAppRuntime, subAccountInfo.subuin, false);
                    if (TextUtils.isEmpty(a16)) {
                        a16 = subAccountInfo.subuin;
                    }
                    singleLineTextView.setText(a16);
                    FaceDrawable userFaceDrawable = FaceDrawable.getUserFaceDrawable((AppInterface) peekAppRuntime, subAccountInfo.subuin, (byte) 3);
                    if (userFaceDrawable != null) {
                        imageView.setImageDrawable(userFaceDrawable);
                    }
                    AccessibilityUtil.c(imageView, a16 + " \u5934\u50cf", null);
                    if (subAccountInfo.status == 1) {
                        imageView2.setBackgroundDrawable(null);
                    } else {
                        imageView2.setBackgroundResource(R.drawable.skin_subaccount_invalid_status_mask);
                    }
                    if (AppSetting.f99565y) {
                        childAt.setContentDescription(a16);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateSubAccountListView mSubAccountListView is null or size is 0.");
        }
    }

    void deleteAccount(SimpleAccount simpleAccount, boolean z16) {
        if (simpleAccount == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteAccount account == null");
                return;
            }
            return;
        }
        showDelAccountDialog();
        String uin = simpleAccount.getUin();
        this.delCurrentUin = uin;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (TextUtils.equals(uin, appInterface.getCurrentUin())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteAccount error delete current uin");
            }
        } else {
            this.mChanged = true;
            delAccountRecord(this.delCurrentUin, z16);
            com.tencent.mobileqq.utils.at.a(uin);
            this.mAccountList.remove(simpleAccount);
            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).clearGestureData(this, simpleAccount.getUin());
            ThreadManagerV2.post(new Runnable(z16, appInterface, uin) { // from class: com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f174922d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AppInterface f174923e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f174924f;

                {
                    this.f174922d = z16;
                    this.f174923e = appInterface;
                    this.f174924f = uin;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AssociatedAccountManageActivity.this, Boolean.valueOf(z16), appInterface, uin);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f174922d) {
                        ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).deleteHistory(this.f174923e, this.f174924f);
                    }
                    AssociatedAccountManageActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(AssociatedAccountManageActivity.TAG, 2, "deleteAccount begin to remove account view");
                            }
                            try {
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                View findItemViewByUin = AssociatedAccountManageActivity.this.findItemViewByUin(anonymousClass7.f174924f, 1);
                                if (findItemViewByUin != null) {
                                    AssociatedAccountManageActivity.this.mAccountListView.removeView(findItemViewByUin);
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.d(AssociatedAccountManageActivity.TAG, 2, "deleteAccount runOnUiThread removeView error");
                                }
                            }
                            AssociatedAccountManageActivity.this.hideDelAccountDialog();
                            List<SimpleAccount> list = AssociatedAccountManageActivity.this.mAccountList;
                            if (list != null && list.size() != 0) {
                                AssociatedAccountManageActivity.this.mAccountTitle.setVisibility(4);
                            } else {
                                AssociatedAccountManageActivity.this.mAccountTitle.setVisibility(8);
                            }
                            AssociatedAccountManageActivity.this.updateAccountViewAsDisplayChanged();
                            List<SubAccountInfo> list2 = AssociatedAccountManageActivity.this.mSubAccountList;
                            if (list2 == null || list2.size() == 0) {
                                List<SimpleAccount> list3 = AssociatedAccountManageActivity.this.mAccountList;
                                if (list3 == null || list3.size() == 0) {
                                    AssociatedAccountManageActivity.this.onBackEvent();
                                }
                            }
                        }
                    });
                }
            }, 8, null, true);
        }
    }

    void deleteDataFromSP(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "----clear_sp----deleteDataFromSP: uin:" + str);
        }
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.peekAppRuntime().getApp().getSharedPreferences(str, 0).edit();
        edit.clear();
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onDeleteAccount uin=", str, ", clean=", Boolean.TRUE);
        }
        try {
            String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(str);
            Intent intent = new Intent("qmmkv.action.account_cleanup");
            intent.setPackage(MobileQQ.PACKAGE_NAME);
            intent.putExtra("uin", str);
            intent.putExtra("uid", uid);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get uid error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.bzo);
        setContentBackgroundResource(R.drawable.bg_texture);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.mIsDisplayThirdFuc = com.tencent.mobileqq.subaccount.h.E(appInterface, false);
        if (getIntent() != null && TextUtils.equals(getIntent().getStringExtra("fromWhere"), ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName())) {
            this.mIsFromAccountManage = true;
        }
        initUI();
        initSubAccountList();
        initAccountList();
        addObserver(this.fob);
        addObserver(this.avatarObserver);
        addObserver(this.cardObserver);
        addObserver(this.mSubAccountBindObserver);
        appInterface.setHandler(getClass(), this.mHandler);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.titleRoot, "pg_bas_manage_QQ_account");
        setManageAccountPageInfo();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy");
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.removeHandler(getClass());
        }
        removeObserver(this.fob);
        removeObserver(this.avatarObserver);
        removeObserver(this.cardObserver);
        removeObserver(this.mSubAccountBindObserver);
        hideDelAccountDialog();
        hideJuhua();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
            ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0X800C484");
        }
    }

    public void hideDelAccountDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            Dialog dialog = this.mDelAccountDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mDelAccountDialog.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, e16.toString());
            }
        }
    }

    public void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        setTitle(R.string.f170474sc);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(R.string.b9f);
        this.rightViewText.setOnClickListener(new d(appInterface));
        VideoReport.setElementId(this.rightViewText, "em_bas_finish_button");
        TextView textView = this.rightViewText;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(textView, endExposurePolicy);
        this.mAccountTitle = findViewById(R.id.f163899bp);
        this.mSubAccountTitle = findViewById(R.id.j6d);
        this.mAccountListView = (LinearLayout) findViewById(R.id.accountLinearlayout);
        this.mSubAccountListView = (LinearLayout) findViewById(R.id.j5p);
        this.leftView.setText(R.string.button_back);
        this.leftView.setVisibility(4);
        this.mDisplayThirdQQCkb = (FormSwitchItem) findViewById(R.id.bmk);
        if (appInterface != null) {
            setSwitchChecked(com.tencent.mobileqq.subaccount.h.q(appInterface));
        }
        if (AppSetting.f99565y) {
            this.mDisplayThirdQQCkb.setContentDescription(getString(R.string.hs6));
            this.leftView.setContentDescription(getString(R.string.button_back));
            this.rightViewText.setContentDescription(getString(R.string.b9f));
        }
        VideoReport.setElementId(this.mDisplayThirdQQCkb.getSwitch(), "em_bas_displays_switches_other_accounts");
        VideoReport.setElementEndExposePolicy(this.mDisplayThirdQQCkb.getSwitch(), endExposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mChanged) {
            setResult(-1);
        } else {
            setResult(0);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onBackEvent, finish mChanged = " + this.mChanged);
        }
        boolean onBackEvent = super.onBackEvent();
        overridePendingTransition(R.anim.f154442w, R.anim.f154458a7);
        return onBackEvent;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.mDisplayThirdQQCkb.getSwitch()) {
            if (NetworkUtil.isNetworkAvailable(this)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).setDisplayThirdQQSwitch((AppInterface) peekAppRuntime, z16);
                this.mHandler.sendEmptyMessageDelayed(8193, 800L);
                String str2 = "1";
                if (z16) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C485", "0X800C485", 0, 0, "", str, "", "");
                Switch r46 = this.mDisplayThirdQQCkb.getSwitch();
                if (!this.mDisplayThirdQQCkb.getSwitch().isChecked()) {
                    str2 = "2";
                }
                VideoReport.setElementParam(r46, "switch_current_state", str2);
            } else {
                Message obtainMessage = this.mHandler.obtainMessage(8195);
                obtainMessage.arg1 = 0;
                obtainMessage.arg2 = R.string.b3j;
                this.mHandler.sendMessage(obtainMessage);
                setSwitchChecked(!z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void showDeleteAccountPromptDialog(final SimpleAccount simpleAccount) {
        String str;
        if (simpleAccount == null) {
            return;
        }
        this.mIsClearHistory = false;
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, String.format(getString(R.string.f211135k0), simpleAccount.getUin()), getString(R.string.f211115jy), getString(R.string.f211125jz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AssociatedAccountManageActivity.this.lambda$showDeleteAccountPromptDialog$0(peekAppRuntime, simpleAccount, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ReportController.o(AppRuntime.this, "dc00898", "", "", "0X800C21C", "0X800C21C", 0, 0, "3", "", "", "");
            }
        });
        createCustomDialog.setCheckBox(getString(R.string.f211145k1), this.mIsClearHistory, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AssociatedAccountManageActivity.this.lambda$showDeleteAccountPromptDialog$2(createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        VideoReport.setPageId(createCustomDialog, "pg_bas_delete_account_float");
        VideoReport.setPageParams(createCustomDialog, new PageParams((Map<String, ?>) getCommonPageInfo()));
        VideoReport.setElementId(createCustomDialog.findViewById(R.id.juo), "em_bas_delete_chat_history");
        View findViewById = createCustomDialog.findViewById(R.id.juo);
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(findViewById, endExposurePolicy);
        VideoReport.setElementId(createCustomDialog.findViewById(R.id.dialogLeftBtn), "em_bas_cancel_delete_account");
        VideoReport.setElementEndExposePolicy(createCustomDialog.findViewById(R.id.dialogLeftBtn), endExposurePolicy);
        VideoReport.setElementId(createCustomDialog.findViewById(R.id.dialogRightBtn), "em_bas_confirm_account_deletion");
        VideoReport.setElementEndExposePolicy(createCustomDialog.findViewById(R.id.dialogRightBtn), endExposurePolicy);
        View findViewById2 = createCustomDialog.findViewById(R.id.dialogRightBtn);
        if (this.mIsClearHistory) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(findViewById2, "is_log_local_chat", str);
    }

    void showUnbindMenuDialog(SubAccountInfo subAccountInfo) {
        if (subAccountInfo == null) {
            return;
        }
        this.menuUnbindDialog = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        for (String str : getResources().getStringArray(R.array.f155244bu)) {
            this.menuUnbindDialog.addButton(str, 3);
        }
        this.menuUnbindDialog.addCancelButton(R.string.cancel);
        this.menuUnbindDialog.setOnButtonClickListener(this.onBtnClickLisForUnbind);
        this.onBtnClickLisForUnbind.a(subAccountInfo);
        this.menuUnbindDialog.setMainTitle(getString(R.string.i_p));
        if (!this.menuUnbindDialog.isShowing()) {
            this.menuUnbindDialog.show();
        }
    }

    void unbindAccount(SubAccountInfo subAccountInfo) {
        if (subAccountInfo == null || TextUtils.isEmpty(subAccountInfo.subuin) || !isNetConnToast()) {
            return;
        }
        this.mChanged = true;
        showJuhua(R.string.htt);
        SubAccountProtocServiceImpl subAccountProtocServiceImpl = (SubAccountProtocServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountProtocService.class, "");
        if (subAccountProtocServiceImpl != null) {
            subAccountProtocServiceImpl.unBindAccount(subAccountInfo.subuin);
        }
    }

    void updateFace(String str, View view) {
        if (!TextUtils.isEmpty(str) && view != null) {
            runOnUiThread(new Runnable(str, view) { // from class: com.tencent.mobileqq.activity.AssociatedAccountManageActivity.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f174920d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f174921e;

                {
                    this.f174920d = str;
                    this.f174921e = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AssociatedAccountManageActivity.this, str, view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        FaceDrawable userFaceDrawable = FaceDrawable.getUserFaceDrawable((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), this.f174920d, (byte) 3);
                        ImageView imageView = (ImageView) this.f174921e.findViewById(R.id.icon);
                        if (imageView != null) {
                            imageView.setImageDrawable(userFaceDrawable);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }
}
