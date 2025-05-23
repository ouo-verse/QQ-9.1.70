package com.tencent.mobileqq.businessCard.activity;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BusinessCardEditActivity extends BaseActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    static IPatchRedirector $redirector_;
    boolean A0;
    BusinessCardManager B0;
    String C0;
    BusinessCard D0;
    CardOCRInfo E0;
    String F0;
    String G0;
    int H0;
    private List<WeakReference<FaceDrawable>> I0;
    int J0;
    int K0;
    boolean L0;
    private boolean M0;
    private boolean N0;
    private ContentObserver O0;
    ar P0;
    com.tencent.mobileqq.businessCard.a Q0;

    /* renamed from: a0, reason: collision with root package name */
    RelativeLayout f200780a0;

    /* renamed from: b0, reason: collision with root package name */
    QUISecNavBar f200781b0;

    /* renamed from: c0, reason: collision with root package name */
    LinearLayout f200782c0;

    /* renamed from: d0, reason: collision with root package name */
    Button f200783d0;

    /* renamed from: e0, reason: collision with root package name */
    ImageView f200784e0;

    /* renamed from: f0, reason: collision with root package name */
    ClearEllipsisEditText f200785f0;

    /* renamed from: g0, reason: collision with root package name */
    ClearEllipsisEditText f200786g0;

    /* renamed from: h0, reason: collision with root package name */
    RelativeLayout f200787h0;

    /* renamed from: i0, reason: collision with root package name */
    RelativeLayout f200788i0;

    /* renamed from: j0, reason: collision with root package name */
    LinearLayout f200789j0;

    /* renamed from: k0, reason: collision with root package name */
    LinearLayout f200790k0;

    /* renamed from: l0, reason: collision with root package name */
    LinearLayout f200791l0;

    /* renamed from: m0, reason: collision with root package name */
    TextView f200792m0;

    /* renamed from: n0, reason: collision with root package name */
    TextView f200793n0;

    /* renamed from: o0, reason: collision with root package name */
    TextView f200794o0;

    /* renamed from: p0, reason: collision with root package name */
    Dialog f200795p0;

    /* renamed from: q0, reason: collision with root package name */
    QQProgressDialog f200796q0;

    /* renamed from: r0, reason: collision with root package name */
    r f200797r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f200798s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f200799t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f200800u0;

    /* renamed from: v0, reason: collision with root package name */
    Intent f200801v0;

    /* renamed from: w0, reason: collision with root package name */
    int f200802w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f200803x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f200804y0;

    /* renamed from: z0, reason: collision with root package name */
    boolean f200805z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = (q) view.getTag();
                BusinessCardEditActivity.this.N2(qVar.f200826a, qVar.f200827b, qVar.f200828c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                String str = (String) view.getTag();
                if (!TextUtils.isEmpty(str)) {
                    BusinessCardEditActivity.this.p3(str);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                BusinessCardEditActivity.this.grant();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                BusinessCardEditActivity.this.denied();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f200811d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f200812e;

        d(String str, ActionSheet actionSheet) {
            this.f200811d = str;
            this.f200812e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BusinessCardEditActivity.this, str, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    String str = this.f200811d;
                    if (str != null && str.length() > 0) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SENDTO");
                        intent.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + this.f200811d));
                        BusinessCardEditActivity.this.getActivity().startActivity(intent);
                    } else {
                        BusinessCardEditActivity.this.notifyUser(R.string.buj, 1);
                    }
                }
            } else {
                String str2 = this.f200811d;
                if (str2 != null && str2.length() > 0) {
                    BusinessCardEditActivity.this.getActivity().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f200811d)));
                    BusinessCardEditActivity.this.app.getCallFacade().E(this.f200811d);
                } else {
                    BusinessCardEditActivity.this.notifyUser(R.string.buj, 1);
                }
            }
            this.f200812e.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Dialog dialog = BusinessCardEditActivity.this.f200795p0;
                if (dialog != null && dialog.isShowing()) {
                    BusinessCardEditActivity.this.f200795p0.dismiss();
                    BusinessCardEditActivity.this.f200795p0 = null;
                }
                BusinessCardEditActivity businessCardEditActivity = BusinessCardEditActivity.this;
                if (businessCardEditActivity.f200802w0 == 0) {
                    ReportController.o(businessCardEditActivity.app, "CliOper", "", "", "0X80064E3", "0X80064E3", 0, 0, "", "", "", "");
                } else if (businessCardEditActivity.getIntent().getIntExtra("source_activity", 0) == 1) {
                    ReportController.o(BusinessCardEditActivity.this.app, "CliOper", "", "", "0X80064EE", "0X80064EE", 0, 0, "", "", "", "");
                }
                BusinessCardEditActivity businessCardEditActivity2 = BusinessCardEditActivity.this;
                if (businessCardEditActivity2.f200803x0 && businessCardEditActivity2.f200804y0 && !businessCardEditActivity2.isFinishing()) {
                    BusinessCardEditActivity.this.finish();
                } else {
                    BusinessCardEditActivity businessCardEditActivity3 = BusinessCardEditActivity.this;
                    if (businessCardEditActivity3.f200805z0) {
                        BusinessCardUtils.e(businessCardEditActivity3.app.getCurrentAccountUin(), -1);
                        BusinessCardEditActivity.this.f200805z0 = false;
                    }
                    BusinessCard businessCard = BusinessCardEditActivity.this.D0;
                    if (businessCard != null && !TextUtils.isEmpty(businessCard.cardId)) {
                        BusinessCardEditActivity.this.t3(false, true, true);
                    } else {
                        BusinessCardEditActivity.this.finish();
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Dialog dialog = BusinessCardEditActivity.this.f200795p0;
                if (dialog != null && dialog.isShowing()) {
                    BusinessCardEditActivity.this.f200795p0.dismiss();
                    BusinessCardEditActivity.this.f200795p0 = null;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g extends ContentObserver {
        static IPatchRedirector $redirector_;

        g(Handler handler) {
            super(handler);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this, (Object) handler);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_EditActivity", 2, "Contact changed selfChange=" + z16);
            }
            if (BusinessCardEditActivity.this.N0) {
                BusinessCardEditActivity.this.notifyUser(R.string.fa7, 2);
                BusinessCardEditActivity.this.N0 = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class h extends ar {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16 && str != null) {
                String h16 = ac.h(BusinessCardEditActivity.this.app, str, false);
                for (int i3 = 0; i3 < BusinessCardEditActivity.this.f200790k0.getChildCount(); i3++) {
                    View childAt = BusinessCardEditActivity.this.f200790k0.getChildAt(i3);
                    if ((childAt instanceof ViewGroup) && (childAt.getTag() instanceof q) && str.equals(((q) childAt.getTag()).f200826a) && (textView = (TextView) childAt.findViewById(R.id.f9d)) != null) {
                        textView.setText(h16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class i extends com.tencent.mobileqq.businessCard.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void a(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_observer", 2, String.format("onAddCard isSuccess=%s cardId=%s result=%s", Boolean.valueOf(z16), str, Integer.valueOf(i3)));
            }
            BusinessCardEditActivity.this.dismissWaittingDialog();
            Resources resources = BusinessCardEditActivity.this.getResources();
            if (z16) {
                BusinessCardEditActivity.this.showWaitingDialog(resources.getString(R.string.ix9));
                if (TextUtils.isEmpty(BusinessCardEditActivity.this.C0)) {
                    BusinessCardEditActivity.this.C0 = str;
                    return;
                }
                return;
            }
            String string = resources.getString(R.string.f_4);
            if (i3 == 66) {
                string = resources.getString(R.string.f_5);
            }
            QQToast.makeText(BusinessCardEditActivity.this.getActivity(), 2, string, 0).show(BusinessCardEditActivity.this.getTitleBarHeight());
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void b(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_observer", 2, String.format("onDelCard isSuccess=%s cardId=%s", Boolean.valueOf(z16), str));
            }
            BusinessCardEditActivity.this.dismissWaittingDialog();
            if (z16) {
                QQToast.makeText(BusinessCardEditActivity.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.f171681k55), 0).show(BusinessCardEditActivity.this.getTitleBarHeight());
                BusinessCardEditActivity.this.finish();
            } else {
                QQToast.makeText(BusinessCardEditActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.f171676k50), 0).show(BusinessCardEditActivity.this.getTitleBarHeight());
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void c(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_observer", 2, String.format("onGetCardInfo isSuccess=%s cardId=%s queryType=%s", Boolean.valueOf(z16), str, Integer.valueOf(i3)));
            }
            BusinessCardEditActivity.this.dismissWaittingDialog();
            if (z16 && str.equals(BusinessCardEditActivity.this.C0)) {
                BusinessCardEditActivity businessCardEditActivity = BusinessCardEditActivity.this;
                if (businessCardEditActivity.f200803x0 && businessCardEditActivity.f200802w0 == 2 && businessCardEditActivity.J0 == 1) {
                    businessCardEditActivity.J0 = 0;
                    businessCardEditActivity.B0.u(false);
                }
                BusinessCardEditActivity businessCardEditActivity2 = BusinessCardEditActivity.this;
                if (businessCardEditActivity2.f200803x0 && businessCardEditActivity2.f200804y0 && !businessCardEditActivity2.isFinishing()) {
                    BusinessCardEditActivity.this.B0.i(str);
                    QLog.i("BusinessCard_observer", 4, "after edit and require : cardId = " + str);
                    BusinessCardEditActivity.this.finish();
                    return;
                }
                BusinessCard i16 = BusinessCardEditActivity.this.B0.i(str);
                if (i16 != null) {
                    BusinessCardEditActivity businessCardEditActivity3 = BusinessCardEditActivity.this;
                    businessCardEditActivity3.D0 = i16;
                    businessCardEditActivity3.t3(false, true, true);
                }
            }
        }

        @Override // com.tencent.mobileqq.businessCard.a
        public void e(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", Boolean.valueOf(z16), str));
            }
            BusinessCardEditActivity.this.dismissWaittingDialog();
            if (z16) {
                BusinessCardEditActivity.this.showWaitingDialog(HardCodeUtil.qqStr(R.string.f171678k52));
                BusinessCardEditActivity businessCardEditActivity = BusinessCardEditActivity.this;
                ReportController.o(businessCardEditActivity.app, "CliOper", "", "", "0X8007748", "0X8007748", businessCardEditActivity.K0, 0, "", "", "", "");
                return;
            }
            QQToast.makeText(BusinessCardEditActivity.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.k5_), 0).show(BusinessCardEditActivity.this.getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BusinessCardEditActivity.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BusinessCardEditActivity.this.onRightClick();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BusinessCardEditActivity.this.Q2(((Integer) view.getTag()).intValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = (q) view.getTag();
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(qVar.f200826a), "BusinessCard_EditActivity")) {
                    i3 = 35;
                } else {
                    i3 = 1;
                }
                ProfileUtils.openProfileCardForResult(BusinessCardEditActivity.this, new AllInOne(qVar.f200826a, i3), 1016);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class n implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = (q) view.getTag();
                BusinessCardEditActivity.this.N2(qVar.f200826a, qVar.f200827b, qVar.f200828c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = (q) view.getTag();
                if (!((FriendsManager) BusinessCardEditActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c0(qVar.f200826a)) {
                    i3 = 35;
                } else {
                    i3 = 1;
                }
                ProfileUtils.openProfileCardForResult(BusinessCardEditActivity.this, new AllInOne(qVar.f200826a, i3), 1016);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class p implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                q qVar = (q) view.getTag();
                BusinessCardEditActivity.this.N2(qVar.f200826a, qVar.f200827b, qVar.f200828c);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class q {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f200826a;

        /* renamed from: b, reason: collision with root package name */
        String f200827b;

        /* renamed from: c, reason: collision with root package name */
        boolean f200828c;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
            }
        }
    }

    public BusinessCardEditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200798s0 = 1;
        this.f200799t0 = 1;
        this.f200800u0 = 1;
        this.f200803x0 = false;
        this.f200804y0 = false;
        this.f200805z0 = false;
        this.A0 = false;
        this.J0 = -1;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        this.N0 = false;
        this.P0 = new h();
        this.Q0 = new i();
    }

    private void R2(BusinessCard businessCard, boolean z16) {
        String str;
        String str2;
        String str3;
        String str4;
        EditText editText;
        BusinessCard businessCard2 = this.D0;
        if (businessCard2 != null) {
            businessCard.cardId = businessCard2.cardId;
            businessCard.bindUin = businessCard2.bindUin;
            if (this.f200802w0 == 2) {
                businessCard.cardName = businessCard2.cardName;
            }
        }
        if (this.f200802w0 != 2) {
            businessCard.cardName = this.f200785f0.m();
        }
        CardOCRInfo cardOCRInfo = this.E0;
        if (cardOCRInfo != null) {
            businessCard.picUrl = cardOCRInfo.f200893e;
            businessCard.OCRInfo = cardOCRInfo;
        } else {
            BusinessCard businessCard3 = this.D0;
            if (businessCard3 != null) {
                businessCard.picUrl = businessCard3.picUrl;
                businessCard.OCRInfo = businessCard3.OCRInfo;
            }
        }
        if (this.L0) {
            businessCard.picUrl = null;
            businessCard.OCRInfo = null;
        }
        businessCard.company = this.f200786g0.m();
        businessCard.mobilesNum.clear();
        for (int i3 = 0; i3 < this.f200789j0.getChildCount(); i3++) {
            String trim = ((EditText) this.f200789j0.getChildAt(i3)).getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                businessCard.mobilesNum.add(trim);
            }
        }
        businessCard.qqNum.clear();
        for (int i16 = 0; i16 < this.f200790k0.getChildCount(); i16++) {
            View childAt = this.f200790k0.getChildAt(i16);
            if ((childAt instanceof RelativeLayout) && (editText = (EditText) childAt.findViewById(R.id.gr9)) != null) {
                String trim2 = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(trim2)) {
                    businessCard.qqNum.add(trim2);
                }
            }
        }
        businessCard.descs.clear();
        for (int i17 = 0; i17 < this.f200791l0.getChildCount(); i17++) {
            String trim3 = ((EditText) this.f200791l0.getChildAt(i17)).getText().toString().trim();
            if (!TextUtils.isEmpty(trim3)) {
                businessCard.descs.add(trim3);
            }
        }
        if (z16) {
            if (this.f200802w0 == 0) {
                if (TextUtils.isEmpty(businessCard.cardName)) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, str3, "", "", "");
                if (TextUtils.isEmpty(businessCard.company)) {
                    str4 = "1";
                } else {
                    str4 = "0";
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, str4, "", "", "");
                ReportController.o(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, businessCard.qqNum.size() + "", "", "", "");
                ReportController.o(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, businessCard.descs.size() + "", "", "", "");
                return;
            }
            if (getIntent().getIntExtra("source_activity", 0) == 1) {
                if (TextUtils.isEmpty(businessCard.cardName)) {
                    str = "0";
                } else {
                    ReportController.o(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.K0, 0, "", "", "", "");
                    str = "1";
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, str, "", "", "");
                if (TextUtils.isEmpty(businessCard.company)) {
                    str2 = "0";
                } else {
                    ReportController.o(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.K0, 0, "", "", "", "");
                    str2 = "1";
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, str2, "", "", "");
                ReportController.o(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, businessCard.qqNum.size() + "", "", "", "");
                int size = businessCard.descs.size();
                for (int i18 = 0; i18 < size; i18++) {
                    if (!TextUtils.isEmpty(businessCard.descs.get(i18))) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.K0, 0, "", "", "", "");
                    }
                }
                ReportController.o(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, businessCard.descs.size() + "", "", "", "");
                int size2 = businessCard.mobilesNum.size();
                for (int i19 = 0; i19 < size2; i19++) {
                    if (i19 == 0 && !TextUtils.isEmpty(businessCard.mobilesNum.get(i19))) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800774B", "0X800774B", this.K0, 0, "", "", "", "");
                    }
                    if (i19 == 1 && !TextUtils.isEmpty(businessCard.mobilesNum.get(i19))) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800774C", "0X800774C", this.K0, 0, "", "", "", "");
                    }
                    if (i19 == 2 && !TextUtils.isEmpty(businessCard.mobilesNum.get(i19))) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800774D", "0X800774D", this.K0, 0, "", "", "", "");
                    }
                }
            }
        }
    }

    private boolean S2(BusinessCard businessCard, BusinessCard businessCard2) {
        if (businessCard2 == null || !T2(businessCard2.cardName, businessCard.cardName) || !T2(businessCard2.picUrl, businessCard.picUrl) || !T2(businessCard2.company, businessCard.company) || businessCard.mobilesNum.size() != businessCard2.mobilesNum.size()) {
            return true;
        }
        for (int i3 = 0; i3 < businessCard2.mobilesNum.size(); i3++) {
            if (!businessCard.mobilesNum.get(i3).equals(businessCard2.mobilesNum.get(i3))) {
                return true;
            }
        }
        if (businessCard.descs.size() != businessCard2.descs.size()) {
            return true;
        }
        for (int i16 = 0; i16 < businessCard2.descs.size(); i16++) {
            if (!businessCard.descs.get(i16).equals(businessCard2.descs.get(i16))) {
                return true;
            }
        }
        if (businessCard.qqNum.size() != businessCard2.uinInfos.size()) {
            return true;
        }
        for (int i17 = 0; i17 < businessCard2.uinInfos.size(); i17++) {
            if (!businessCard.qqNum.get(i17).equals(businessCard2.uinInfos.get(i17).f200898d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean T2(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    private void Y2() {
        try {
            this.O0 = new g(new Handler(this.app.getApp().getMainLooper()));
            this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.O0);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCard_EditActivity", 2, th5.getMessage(), th5);
            }
            this.N0 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
    
        if (r2.isEmpty() != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Z2(CardOCRInfo cardOCRInfo) {
        boolean z16;
        if (cardOCRInfo == null) {
            return;
        }
        int i3 = 1;
        boolean z17 = !T2(this.f200785f0.m(), cardOCRInfo.f200892d);
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < this.f200789j0.getChildCount(); i16++) {
            String trim = ((EditText) this.f200789j0.getChildAt(i16)).getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                arrayList.add(trim);
            }
        }
        if (!cardOCRInfo.f200895h.isEmpty() && !arrayList.isEmpty()) {
            String str = cardOCRInfo.f200895h.get(0);
            if (!TextUtils.isEmpty(str)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
        } else {
            if (cardOCRInfo.f200895h.isEmpty()) {
            }
            z16 = true;
        }
        if (!z17 || !z16) {
            if (z17) {
                i3 = 2;
            } else if (z16) {
                i3 = 3;
            } else {
                i3 = 0;
            }
        }
        BusinessCardUtils.e(this.app.getCurrentAccountUin(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(String str, String str2, List<String> list) {
        ContentValues contentValues = new ContentValues();
        Uri insert = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
        if (insert != null && ContentUris.parseId(insert) > 0) {
            long parseId = ContentUris.parseId(insert);
            this.N0 = true;
            if (str != null && list != null && list.size() > 0) {
                contentValues.clear();
                contentValues.put("raw_contact_id", Long.valueOf(parseId));
                contentValues.put("mimetype", "vnd.android.cursor.item/name");
                contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, str);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
                if (str2 != null) {
                    contentValues.clear();
                    contentValues.put("raw_contact_id", Long.valueOf(parseId));
                    contentValues.put("mimetype", "vnd.android.cursor.item/organization");
                    contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str2);
                    contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 1);
                    getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
                }
                for (String str3 : list) {
                    contentValues.clear();
                    contentValues.put("raw_contact_id", Long.valueOf(parseId));
                    contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                    contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str3);
                    contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 2);
                    getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
                }
            }
            ReportController.o(this.app, "CliOper", "", "", "0X80064E4", "0X80064E4", 0, 0, "", "", "", "");
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.17
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    BusinessCardEditActivity.this.notifyUser(R.string.f171486fa4, 1);
                }
            }
        });
    }

    private void c3(String str, String str2, boolean z16) {
        Card r16;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.aqt);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.f164736aq3);
        TextView textView = (TextView) findViewById(R.id.f5o);
        if (this.f200802w0 == 2) {
            textView.setText(super.getResources().getString(R.string.bwt));
            if (z16 && (str = this.G0) == null) {
                BusinessCard businessCard = this.D0;
                String str3 = "";
                if (businessCard != null && !TextUtils.isEmpty(businessCard.bindUin)) {
                    FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    if (friendsManager == null) {
                        r16 = null;
                    } else {
                        r16 = friendsManager.r(this.D0.bindUin);
                    }
                    if (r16 != null && (!TextUtils.isEmpty(r16.strReMark) || !TextUtils.isEmpty(r16.strNick))) {
                        if (!TextUtils.isEmpty(r16.strReMark)) {
                            str3 = r16.strReMark;
                        }
                    } else {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.D0.bindUin), "BusinessCard_EditActivity");
                        if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                            str3 = friendsSimpleInfoWithUid.r();
                        }
                    }
                }
                str = str3;
            }
        } else {
            textView.setText(super.getResources().getString(R.string.f_w));
        }
        this.f200785f0.setEllipsisText(str);
        this.f200786g0.setEllipsisText(str2);
        if (this.f200803x0) {
            relativeLayout.setVisibility(0);
            this.f200785f0.setFocusable(true);
            this.f200785f0.setFocusableInTouchMode(true);
            if (this.f200802w0 == 2) {
                this.f200785f0.setHint(R.string.f171484fa0);
            } else {
                this.f200785f0.setHint(R.string.f_x);
            }
            r rVar = new r(120, this.f200785f0, 1);
            this.f200797r0 = rVar;
            this.f200785f0.addTextChangedListener(rVar);
            relativeLayout2.setVisibility(0);
            this.f200786g0.setFocusable(true);
            this.f200786g0.setFocusableInTouchMode(true);
            this.f200786g0.setHint(R.string.f_j);
            this.f200786g0.addTextChangedListener(new r(30, this.f200786g0));
            return;
        }
        this.f200785f0.setFocusable(false);
        this.f200785f0.setFocusableInTouchMode(false);
        this.f200785f0.setHint(HardCodeUtil.qqStr(R.string.f171679k53));
        if (TextUtils.isEmpty(str2)) {
            relativeLayout2.setVisibility(8);
            return;
        }
        relativeLayout2.setVisibility(0);
        this.f200786g0.setFocusable(false);
        this.f200786g0.setFocusableInTouchMode(false);
        this.f200786g0.setHint(HardCodeUtil.qqStr(R.string.k4y));
    }

    private void d3(BusinessCard businessCard) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (businessCard != null) {
            this.f200789j0.removeAllViews();
            ArrayList<String> stringArrayListExtra = this.f200801v0.getStringArrayListExtra("bind_phone_num");
            int i19 = 1;
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    P2(this.f200789j0, it.next(), 1);
                }
            }
            if (!businessCard.mobilesNum.isEmpty()) {
                Iterator<String> it5 = businessCard.mobilesNum.iterator();
                while (it5.hasNext()) {
                    P2(this.f200789j0, it5.next(), 1);
                }
            }
            ViewGroup viewGroup = null;
            if (stringArrayListExtra == null && businessCard.mobilesNum.isEmpty()) {
                P2(this.f200789j0, null, 1);
            }
            if (!W2()) {
                this.f200790k0.removeAllViews();
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                if (r3(arrayList, arrayList2, arrayList3, arrayList4)) {
                    Iterator<String> it6 = arrayList.iterator();
                    while (true) {
                        boolean hasNext = it6.hasNext();
                        i3 = R.id.f167078kh4;
                        i16 = R.id.icon;
                        i17 = R.layout.asd;
                        if (!hasNext) {
                            break;
                        }
                        String next = it6.next();
                        View inflate = LayoutInflater.from(this).inflate(R.layout.asd, viewGroup);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.app, i19, next);
                        this.I0.add(new WeakReference<>(faceDrawable));
                        imageView.setBackgroundDrawable(faceDrawable);
                        ((TextView) inflate.findViewById(R.id.f9d)).setText(ac.H(this.app, next));
                        ((TextView) inflate.findViewById(R.id.f167078kh4)).setText(next);
                        ((ImageView) inflate.findViewById(R.id.f164478z4)).setVisibility(0);
                        q qVar = new q();
                        qVar.f200826a = next;
                        qVar.f200827b = ac.H(this.app, next);
                        qVar.f200828c = false;
                        inflate.setTag(qVar);
                        inflate.setOnClickListener(new o());
                        this.f200790k0.addView(inflate, new LinearLayout.LayoutParams(-1, x.c(this, 70.0f)));
                        i19 = 1;
                        viewGroup = null;
                    }
                    Iterator<String> it7 = arrayList2.iterator();
                    while (true) {
                        boolean hasNext2 = it7.hasNext();
                        i18 = R.id.f164022h9;
                        if (!hasNext2) {
                            break;
                        }
                        String next2 = it7.next();
                        View inflate2 = LayoutInflater.from(this).inflate(i17, (ViewGroup) null);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(i16);
                        FaceDrawable faceDrawable2 = FaceDrawable.getFaceDrawable(this.app, 1, next2);
                        this.I0.add(new WeakReference<>(faceDrawable2));
                        imageView2.setBackgroundDrawable(faceDrawable2);
                        TextView textView = (TextView) inflate2.findViewById(R.id.f9d);
                        ((TextView) inflate2.findViewById(R.id.f167078kh4)).setText(next2);
                        Button button = (Button) inflate2.findViewById(R.id.f164022h9);
                        button.setVisibility(0);
                        q qVar2 = new q();
                        qVar2.f200826a = next2;
                        qVar2.f200827b = ac.h(this.app, next2, true);
                        qVar2.f200828c = false;
                        inflate2.setTag(qVar2);
                        textView.setText(qVar2.f200827b);
                        button.setTag(qVar2);
                        button.setOnClickListener(new p());
                        this.f200790k0.addView(inflate2, new LinearLayout.LayoutParams(-1, x.c(this, 70.0f)));
                        i16 = R.id.icon;
                        i17 = R.layout.asd;
                    }
                    Iterator<String> it8 = arrayList3.iterator();
                    while (it8.hasNext()) {
                        String next3 = it8.next();
                        View inflate3 = LayoutInflater.from(this).inflate(R.layout.asd, (ViewGroup) null);
                        ImageView imageView3 = (ImageView) inflate3.findViewById(R.id.icon);
                        TextView textView2 = (TextView) inflate3.findViewById(R.id.f9d);
                        TextView textView3 = (TextView) inflate3.findViewById(i3);
                        Button button2 = (Button) inflate3.findViewById(i18);
                        button2.setVisibility(0);
                        textView3.setText(next3);
                        CardMobileInfo mobileInfoByMobile = businessCard.getMobileInfoByMobile(next3);
                        q qVar3 = new q();
                        qVar3.f200828c = true;
                        if (mobileInfoByMobile != null) {
                            FaceDrawable faceDrawable3 = FaceDrawable.getFaceDrawable(this.app, 11, mobileInfoByMobile.f200891i);
                            this.I0.add(new WeakReference<>(faceDrawable3));
                            imageView3.setBackgroundDrawable(faceDrawable3);
                            qVar3.f200826a = mobileInfoByMobile.f200891i;
                            qVar3.f200827b = mobileInfoByMobile.f200890h;
                        } else {
                            qVar3.f200826a = next3;
                            qVar3.f200827b = next3;
                        }
                        inflate3.setTag(qVar3);
                        textView2.setText(qVar3.f200827b);
                        button2.setTag(qVar3);
                        button2.setOnClickListener(new a());
                        this.f200790k0.addView(inflate3, new LinearLayout.LayoutParams(-1, x.c(this, 70.0f)));
                        i18 = R.id.f164022h9;
                        i3 = R.id.f167078kh4;
                    }
                    Iterator<String> it9 = arrayList4.iterator();
                    while (it9.hasNext()) {
                        P2(this.f200790k0, it9.next(), 0);
                    }
                } else {
                    P2(this.f200790k0, null, 0);
                }
            }
            this.f200791l0.removeAllViews();
            LinearLayout linearLayout = (LinearLayout) this.f200788i0.findViewById(R.id.bgy);
            View findViewById = this.f200788i0.findViewById(R.id.bge);
            if (!businessCard.descs.isEmpty()) {
                linearLayout.setVisibility(0);
                findViewById.setVisibility(0);
                StringBuilder sb5 = new StringBuilder();
                for (String str : businessCard.descs) {
                    if (sb5.length() > 0) {
                        sb5.append("\n");
                    }
                    sb5.append(str);
                }
                if (!TextUtils.isEmpty(sb5.toString())) {
                    P2(this.f200791l0, sb5.toString(), 2);
                    return;
                }
                return;
            }
            linearLayout.setVisibility(8);
            linearLayout.setVisibility(8);
        }
    }

    private void e3(CardOCRInfo cardOCRInfo) {
        int i3;
        int i16;
        if (cardOCRInfo != null) {
            this.f200789j0.removeAllViews();
            ArrayList<String> stringArrayListExtra = this.f200801v0.getStringArrayListExtra("bind_phone_num");
            int i17 = 1;
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    P2(this.f200789j0, it.next(), 1);
                }
            }
            if (!cardOCRInfo.f200895h.isEmpty()) {
                Iterator<String> it5 = cardOCRInfo.f200895h.iterator();
                while (it5.hasNext()) {
                    P2(this.f200789j0, it5.next(), 1);
                }
            }
            if (stringArrayListExtra == null && cardOCRInfo.f200895h.isEmpty()) {
                P2(this.f200789j0, null, 1);
            }
            if (!W2()) {
                this.f200790k0.removeAllViews();
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                if (r3(arrayList, arrayList2, arrayList3, arrayList4)) {
                    Iterator<String> it6 = arrayList.iterator();
                    while (true) {
                        boolean hasNext = it6.hasNext();
                        i3 = R.id.f167078kh4;
                        i16 = R.id.icon;
                        if (!hasNext) {
                            break;
                        }
                        String next = it6.next();
                        View inflate = LayoutInflater.from(this).inflate(R.layout.asd, (ViewGroup) null);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.app, i17, next);
                        this.I0.add(new WeakReference<>(faceDrawable));
                        imageView.setBackgroundDrawable(faceDrawable);
                        ((TextView) inflate.findViewById(R.id.f9d)).setText(ac.H(this.app, next));
                        ((TextView) inflate.findViewById(R.id.f167078kh4)).setText(next);
                        ((ImageView) inflate.findViewById(R.id.f164478z4)).setVisibility(0);
                        q qVar = new q();
                        qVar.f200826a = next;
                        qVar.f200827b = ac.H(this.app, next);
                        qVar.f200828c = false;
                        inflate.setTag(qVar);
                        inflate.setOnClickListener(new m());
                        this.f200790k0.addView(inflate, new LinearLayout.LayoutParams(-1, x.c(this, 70.0f)));
                        i17 = 1;
                    }
                    Iterator<String> it7 = arrayList2.iterator();
                    while (it7.hasNext()) {
                        String next2 = it7.next();
                        View inflate2 = LayoutInflater.from(this).inflate(R.layout.asd, (ViewGroup) null);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(i16);
                        FaceDrawable faceDrawable2 = FaceDrawable.getFaceDrawable(this.app, 1, next2);
                        this.I0.add(new WeakReference<>(faceDrawable2));
                        imageView2.setBackgroundDrawable(faceDrawable2);
                        TextView textView = (TextView) inflate2.findViewById(R.id.f9d);
                        ((TextView) inflate2.findViewById(i3)).setText(next2);
                        Button button = (Button) inflate2.findViewById(R.id.f164022h9);
                        button.setVisibility(0);
                        q qVar2 = new q();
                        qVar2.f200826a = next2;
                        qVar2.f200827b = ac.h(this.app, next2, true);
                        qVar2.f200828c = false;
                        inflate2.setTag(qVar2);
                        textView.setText(qVar2.f200827b);
                        button.setTag(qVar2);
                        button.setOnClickListener(new n());
                        this.f200790k0.addView(inflate2, new LinearLayout.LayoutParams(-1, x.c(this, 70.0f)));
                        i3 = R.id.f167078kh4;
                        i16 = R.id.icon;
                    }
                    Iterator<String> it8 = arrayList4.iterator();
                    while (it8.hasNext()) {
                        P2(this.f200790k0, it8.next(), 0);
                    }
                } else {
                    P2(this.f200790k0, null, 0);
                }
            }
            this.f200791l0.removeAllViews();
            LinearLayout linearLayout = (LinearLayout) this.f200788i0.findViewById(R.id.bgy);
            View findViewById = this.f200788i0.findViewById(R.id.bge);
            linearLayout.setVisibility(8);
            findViewById.setVisibility(8);
        }
    }

    private void g3(BusinessCard businessCard, CardOCRInfo cardOCRInfo) {
        String str;
        int i3;
        int i16 = 0;
        if (businessCard != null) {
            this.f200789j0.removeAllViews();
            if (!businessCard.mobilesNum.isEmpty()) {
                for (int i17 = 0; i17 < businessCard.mobilesNum.size(); i17++) {
                    K2(this.f200789j0, businessCard.mobilesNum.get(i17), 1, 15);
                }
                this.f200798s0 = businessCard.mobilesNum.size();
            }
            if (this.f200801v0.getExtras() != null) {
                str = this.f200801v0.getExtras().getString("add_phone_num", null);
            } else {
                str = null;
            }
            if (str != null && (i3 = this.f200798s0) < 3) {
                this.f200798s0 = i3 + 1;
                L2(this.f200789j0, str, 1, 15, true);
            }
            if (this.f200798s0 >= 3) {
                this.f200792m0.setVisibility(8);
            }
            if (this.f200798s0 == 0) {
                K2(this.f200789j0, null, 1, 15);
                this.f200798s0 = 1;
            }
            this.f200790k0.removeAllViews();
            if (!businessCard.uinInfos.isEmpty()) {
                while (i16 < businessCard.uinInfos.size()) {
                    String str2 = businessCard.uinInfos.get(i16).f200898d;
                    if (!TextUtils.isEmpty(str2)) {
                        M2(str2, i16);
                    }
                    i16++;
                }
                int size = businessCard.uinInfos.size();
                this.f200799t0 = size;
                if (size >= 2) {
                    this.f200793n0.setVisibility(8);
                }
            } else {
                M2(null, 0);
                this.f200799t0 = 1;
            }
            this.f200791l0.removeAllViews();
            if (!businessCard.descs.isEmpty()) {
                StringBuilder sb5 = new StringBuilder();
                for (String str3 : businessCard.descs) {
                    if (sb5.length() > 0) {
                        sb5.append("\n");
                    }
                    sb5.append(str3);
                }
                K2(this.f200791l0, sb5.toString(), 2, 150);
                int size2 = businessCard.descs.size();
                this.f200800u0 = size2;
                if (size2 >= 2) {
                    this.f200794o0.setVisibility(8);
                    return;
                }
                return;
            }
            K2(this.f200791l0, null, 2, 150);
            this.f200800u0 = 1;
            return;
        }
        if (cardOCRInfo != null) {
            this.f200789j0.removeAllViews();
            if (!cardOCRInfo.f200895h.isEmpty()) {
                for (int i18 = 0; i18 < cardOCRInfo.f200895h.size(); i18++) {
                    K2(this.f200789j0, cardOCRInfo.f200895h.get(i18), 1, 15);
                }
                this.f200798s0 = cardOCRInfo.f200895h.size();
            } else {
                K2(this.f200789j0, null, 1, 15);
                this.f200798s0 = 1;
            }
            this.f200790k0.removeAllViews();
            if (!cardOCRInfo.f200894f.isEmpty()) {
                while (i16 < cardOCRInfo.f200894f.size()) {
                    M2(cardOCRInfo.f200894f.get(i16), i16);
                    i16++;
                }
                this.f200799t0 = cardOCRInfo.f200894f.size();
            } else {
                M2(null, 0);
                this.f200799t0 = 1;
            }
            this.f200791l0.removeAllViews();
            K2(this.f200791l0, null, 2, 150);
            this.f200800u0 = 1;
        }
    }

    private void h3(String str) {
        if (str != null && str.length() > 0) {
            this.F0 = str + "/?01";
            this.f200784e0.setVisibility(0);
            this.f200784e0.setOnClickListener(this);
            int i3 = getResources().getDisplayMetrics().widthPixels;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f200784e0.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = (i3 * 600) / 1000;
            this.f200784e0.setLayoutParams(layoutParams);
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = 1000;
                obtain.mRequestHeight = 600;
                obtain.mLoadingDrawable = super.getResources().getDrawable(R.drawable.ab_);
                obtain.mFailedDrawable = super.getResources().getDrawable(R.drawable.ab_);
                this.f200784e0.setImageDrawable(URLDrawable.getDrawable(this.F0, obtain));
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        findViewById(R.id.fs9).setVisibility(8);
        this.f200784e0.setVisibility(8);
    }

    private void i3() {
        if (this.f200803x0) {
            int i3 = this.f200802w0;
            if (i3 == 2) {
                this.f200781b0.setCenterText(HardCodeUtil.qqStr(R.string.f_r));
            } else if (i3 == 3) {
                this.f200781b0.setCenterText(HardCodeUtil.qqStr(R.string.f_v));
            } else {
                this.f200781b0.setCenterText(HardCodeUtil.qqStr(R.string.f_p));
            }
            this.f200781b0.setRightType(1);
            this.f200781b0.setRightText(HardCodeUtil.qqStr(R.string.b9f));
            return;
        }
        if (this.f200802w0 == 3) {
            this.f200781b0.setCenterText(HardCodeUtil.qqStr(R.string.f_v));
        } else {
            this.f200781b0.setCenterText(HardCodeUtil.qqStr(R.string.f_o));
        }
        this.f200781b0.setRightType(1);
        this.f200781b0.setRightText(HardCodeUtil.qqStr(R.string.f170869aw3));
        if (this.H0 == 2) {
            this.f200781b0.setRightType(0);
        }
    }

    private void initData() {
        BusinessCard businessCard;
        Intent intent = super.getIntent();
        this.f200801v0 = intent;
        this.f200802w0 = intent.getIntExtra("mode_type", 0);
        this.f200803x0 = this.f200801v0.getBooleanExtra("is_edit_mode", false);
        this.C0 = this.f200801v0.getStringExtra("cur_card_id");
        this.D0 = (BusinessCard) this.f200801v0.getParcelableExtra("cur_card_body");
        this.E0 = (CardOCRInfo) this.f200801v0.getParcelableExtra("cur_ocr_info");
        this.H0 = this.f200801v0.getIntExtra("source_activity", 0);
        this.f200804y0 = this.f200801v0.getBooleanExtra("finish_immedia", false);
        this.G0 = this.f200801v0.getStringExtra("has_local_remark");
        this.I0 = new ArrayList();
        BusinessCardManager businessCardManager = (BusinessCardManager) this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        this.B0 = businessCardManager;
        String str = this.C0;
        if (str != null) {
            BusinessCard i3 = businessCardManager.i(str);
            this.D0 = i3;
            if (i3 == null) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        BusinessCardEditActivity businessCardEditActivity = BusinessCardEditActivity.this;
                        businessCardEditActivity.D0 = businessCardEditActivity.B0.g(businessCardEditActivity.C0);
                        BusinessCardEditActivity businessCardEditActivity2 = BusinessCardEditActivity.this;
                        if (businessCardEditActivity2.D0 != null) {
                            businessCardEditActivity2.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    BusinessCardEditActivity businessCardEditActivity3 = BusinessCardEditActivity.this;
                                    businessCardEditActivity3.C0 = businessCardEditActivity3.D0.cardId;
                                    businessCardEditActivity3.t3(businessCardEditActivity3.f200803x0, true, true);
                                }
                            });
                        }
                    }
                }, 8, null, true);
            }
            if (this.f200802w0 != 3) {
                com.tencent.mobileqq.businessCard.b.e(this.app, this.C0, false, 3);
            } else {
                com.tencent.mobileqq.businessCard.b.e(this.app, this.C0, true, 3);
            }
        } else {
            BusinessCard businessCard2 = this.D0;
            if (businessCard2 != null) {
                this.C0 = businessCard2.cardId;
            }
        }
        if (this.f200802w0 == 2 && (businessCard = this.D0) != null && !TextUtils.isEmpty(businessCard.picUrl)) {
            this.J0 = 0;
        }
        int i16 = this.f200802w0;
        if (i16 == 2) {
            this.K0 = 1;
        } else if (i16 == 3) {
            this.K0 = 2;
        } else {
            this.K0 = 0;
        }
        this.app.registObserver(this.Q0);
        Y2();
        addObserver(this.P0);
    }

    private void initUI() {
        super.setContentView(R.layout.as6);
        this.f200780a0 = (RelativeLayout) findViewById(R.id.if5);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f200780a0.setFitsSystemWindows(true);
        }
        V2();
        l3();
        this.f200784e0 = (ImageView) findViewById(R.id.f164743ar1);
        ClearEllipsisEditText clearEllipsisEditText = (ClearEllipsisEditText) findViewById(R.id.aqs);
        this.f200785f0 = clearEllipsisEditText;
        clearEllipsisEditText.setOnEditorActionListener(this);
        this.f200785f0.setTag("name");
        this.f200785f0.setMaxLength(120, 1);
        ClearEllipsisEditText clearEllipsisEditText2 = (ClearEllipsisEditText) findViewById(R.id.f164735aq2);
        this.f200786g0 = clearEllipsisEditText2;
        clearEllipsisEditText2.setOnEditorActionListener(this);
        this.f200786g0.setMaxLength(30, 2);
        this.f200787h0 = (RelativeLayout) findViewById(R.id.f165053bt1);
        this.f200788i0 = (RelativeLayout) findViewById(R.id.bmm);
        BusinessCard businessCard = this.D0;
        if (businessCard != null) {
            h3(businessCard.picUrl);
            BusinessCard businessCard2 = this.D0;
            c3(businessCard2.cardName, businessCard2.company, true);
        } else {
            CardOCRInfo cardOCRInfo = this.E0;
            if (cardOCRInfo != null) {
                h3(cardOCRInfo.f200893e);
                c3(this.E0.f200892d, null, true);
            } else {
                h3(null);
                c3(null, null, true);
            }
        }
        f3(true);
    }

    private void j3(String str, boolean z16) {
        String trim = this.f200785f0.m().trim();
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler != null) {
            friendListHandler.setRemarkName(str, trim, z16, null);
        }
    }

    private void l3() {
        List<String> list;
        CardOCRInfo cardOCRInfo;
        i3();
        if (this.f200803x0) {
            this.f200782c0.setVisibility(8);
            return;
        }
        this.f200783d0.setText(R.string.fa6);
        BusinessCard businessCard = this.D0;
        if (businessCard != null && (((cardOCRInfo = businessCard.OCRInfo) != null && !TextUtils.isEmpty(cardOCRInfo.f200893e)) || this.D0.mobilesNum.size() > 0)) {
            if (this.f200802w0 != 3 && !this.D0.mobilesNum.isEmpty() && !TextUtils.isEmpty(this.D0.cardName)) {
                if (this.D0.mobilesNum.size() > 0) {
                    this.f200782c0.setVisibility(0);
                    return;
                }
                return;
            }
            this.f200782c0.setVisibility(8);
            return;
        }
        CardOCRInfo cardOCRInfo2 = this.E0;
        if (cardOCRInfo2 != null && (list = cardOCRInfo2.f200895h) != null && list.size() > 0) {
            if (this.f200802w0 != 3 && !this.E0.f200895h.isEmpty() && !TextUtils.isEmpty(this.E0.f200892d)) {
                if (this.E0.f200895h.size() > 0) {
                    this.f200782c0.setVisibility(0);
                    return;
                }
                return;
            }
            this.f200782c0.setVisibility(8);
            return;
        }
        this.f200782c0.setVisibility(8);
    }

    private void n3(String str) {
        Dialog createContentOnlyDialog = DialogUtil.createContentOnlyDialog(this, str, R.string.bjz, R.string.f171032bu3, new e(), new f());
        this.f200795p0 = createContentOnlyDialog;
        if (createContentOnlyDialog != null && !isFinishing()) {
            this.f200795p0.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRightClick() {
        BusinessCard businessCard;
        if (this.f200803x0) {
            InputMethodUtil.hide(this);
            BusinessCard businessCard2 = new BusinessCard();
            R2(businessCard2, true);
            if (this.f200805z0) {
                Z2(this.E0);
                this.f200805z0 = false;
            }
            int i3 = this.f200802w0;
            if (i3 == 2 && this.G0 != null) {
                ((BusinessCardManager) this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).d(businessCard2.bindUin, businessCard2);
                if (!isFinishing()) {
                    Intent intent = getIntent();
                    String m3 = this.f200785f0.m();
                    this.G0 = m3;
                    intent.putExtra("has_local_remark", m3);
                    setResult(-1, intent);
                    finish();
                }
            } else {
                if (i3 == 2 && (businessCard = this.D0) != null) {
                    j3(businessCard.bindUin, getIntent().getBooleanExtra(ProfileContants.CMD_PARAM_NOTIFY_PLUGIN, false));
                }
                if (S2(businessCard2, this.D0)) {
                    if (!NetworkUtil.isNetSupport(this)) {
                        notifyUser(R.string.cjm, 1);
                        return;
                    }
                    Boolean bool = Boolean.FALSE;
                    if (this.f200802w0 == 3) {
                        bool = Boolean.TRUE;
                    }
                    String str = businessCard2.cardId;
                    if (str != null && str.length() > 0) {
                        com.tencent.mobileqq.businessCard.b.f(this.app, businessCard2, bool.booleanValue());
                        showWaitingDialog(HardCodeUtil.qqStr(R.string.k4z));
                    } else {
                        com.tencent.mobileqq.businessCard.b.a(this.app, businessCard2, bool.booleanValue());
                        showWaitingDialog(HardCodeUtil.qqStr(R.string.k4t));
                    }
                } else if (this.f200803x0 && this.f200804y0 && !isFinishing()) {
                    finish();
                } else {
                    t3(false, false, false);
                }
            }
            int i16 = this.K0;
            if (i16 != 0) {
                ReportController.o(this.app, "CliOper", "", "", "0X8007754", "0X8007754", i16, 0, "", "", "", "");
                return;
            }
            return;
        }
        t3(true, false, true);
        ReportController.o(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
    }

    private boolean r3(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4) {
        BusinessCard businessCard = this.D0;
        if (businessCard == null) {
            return false;
        }
        if (!TextUtils.isEmpty(businessCard.bindUin)) {
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.D0.bindUin), "BusinessCard_EditActivity") || this.D0.cardType == 1) {
                arrayList.add(this.D0.bindUin);
            }
        }
        for (CardUinInfo cardUinInfo : this.D0.uinInfos) {
            if (cardUinInfo.f200899e) {
                arrayList.add(cardUinInfo.f200898d);
            } else if (cardUinInfo.f200900f) {
                arrayList2.add(cardUinInfo.f200898d);
            } else {
                arrayList4.add(cardUinInfo.f200898d);
            }
        }
        for (CardMobileInfo cardMobileInfo : this.D0.mobileInfos) {
            if (cardMobileInfo.f200889f) {
                arrayList.add(cardMobileInfo.f200888e);
            } else {
                arrayList3.add(cardMobileInfo.f200887d);
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty() && arrayList3.isEmpty() && arrayList4.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(boolean z16, boolean z17, boolean z18) {
        this.f200803x0 = z16;
        l3();
        BusinessCard businessCard = this.D0;
        if (businessCard != null) {
            if (z17) {
                h3(businessCard.picUrl);
            }
            BusinessCard businessCard2 = this.D0;
            c3(businessCard2.cardName, businessCard2.company, true);
        }
        f3(z18);
    }

    public void K2(LinearLayout linearLayout, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, linearLayout, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            L2(linearLayout, str, i3, i16, false);
        }
    }

    public void L2(LinearLayout linearLayout, String str, int i3, int i16, boolean z16) {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, linearLayout, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(44.0f, getResources()));
        if (i3 != 2) {
            editText = new ClearableEditText(this).e(super.getResources().getDrawable(R.drawable.qui_close_filled_icon_secondary_01_selector));
            editText.setInputType(2);
            editText.setSingleLine();
            editText.setHint(R.string.f_t);
            editText.setBackgroundDrawable(super.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
            editText.setCompoundDrawablePadding(BaseAIOUtils.f(5.0f, getResources()));
            editText.setPadding(BaseAIOUtils.f(28.0f, getResources()), 0, BaseAIOUtils.f(10.0f, getResources()), 0);
        } else {
            editText = new EditText(this);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            editText.setBackgroundDrawable(super.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
            editText.setMinHeight(x.c(this, 44.0f));
            editText.setOnEditorActionListener(this);
            editText.setPadding(BaseAIOUtils.f(28.0f, getResources()), BaseAIOUtils.f(12.0f, getResources()), BaseAIOUtils.f(50.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
            editText.setHint(R.string.f_m);
        }
        editText.setText(str);
        editText.setTextSize(16.0f);
        editText.setTextColor(super.getResources().getColor(R.color.cdh));
        editText.setHintTextColor(super.getResources().getColor(R.color.qui_common_text_secondary));
        editText.setGravity(16);
        linearLayout.addView(editText, layoutParams);
        editText.addTextChangedListener(new r(i16, editText));
        if (z16) {
            editText.setSelection(editText.getText().toString().length());
            editText.postDelayed(new Runnable(editText) { // from class: com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EditText f200807d;

                {
                    this.f200807d = editText;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this, (Object) editText);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f200807d.requestFocusFromTouch();
                        BaseAIOUtils.o(this.f200807d);
                    }
                }
            }, 100L);
        }
    }

    public void M2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.asc, (ViewGroup) null);
        inflate.setTag(Integer.valueOf(i3));
        EditText editText = (EditText) inflate.findViewById(R.id.gr9);
        editText.addTextChangedListener(new r(15, editText));
        editText.setText(str);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f164034hv);
        imageView.setTag(Integer.valueOf(i3));
        imageView.setOnClickListener(new l());
        this.f200790k0.addView(inflate);
    }

    void N2(String str, String str2, boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = i3;
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this, i16, str, null, 3026, i16, str2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null));
        ReportController.o(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
    }

    public void P2(LinearLayout linearLayout, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, linearLayout, str, Integer.valueOf(i3));
            return;
        }
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setHint(HardCodeUtil.qqStr(R.string.k5i));
        textView.setTextColor(super.getResources().getColor(R.color.skin_black));
        textView.setGravity(16);
        textView.setBackgroundDrawable(super.getResources().getDrawable(R.drawable.skin_setting_strip_top_unpressed));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.c(this, 44.0f));
        textView.setPadding(BaseAIOUtils.f(28.0f, getResources()), 0, BaseAIOUtils.f(50.0f, getResources()), 0);
        if (i3 == 1) {
            textView.setTag(str);
            textView.setOnClickListener(new b());
        } else if (i3 == 2) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            textView.setMinHeight(x.c(this, 44.0f));
            textView.setPadding(BaseAIOUtils.f(28.0f, getResources()), BaseAIOUtils.f(12.0f, getResources()), BaseAIOUtils.f(50.0f, getResources()), BaseAIOUtils.f(10.0f, getResources()));
        }
        linearLayout.addView(textView, layoutParams);
    }

    public void Q2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("param_type", 9999);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 1);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, i3);
    }

    protected void U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.tnh);
        this.f200781b0 = qUISecNavBar;
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new j());
        this.f200781b0.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new k());
    }

    protected void V2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        U2();
        this.f200782c0 = (LinearLayout) findViewById(R.id.abu);
        Button button = (Button) findViewById(R.id.acc);
        this.f200783d0 = button;
        button.setOnClickListener(this);
    }

    public boolean W2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        int i3 = this.f200802w0;
        if (i3 != 3 && i3 != 2 && this.H0 != 2) {
            return false;
        }
        return true;
    }

    @QQPermissionDenied(1)
    public void denied() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            QLog.d("CheckPermission", 1, "CheckPermission user denied = ");
            this.M0 = false;
        }
    }

    void dismissWaittingDialog() {
        QQProgressDialog qQProgressDialog = this.f200796q0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && !isFinishing()) {
            this.f200796q0.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1 && intent != null) {
            if (i3 != 11) {
                if (i3 != 21) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                    if (parcelableArrayListExtra != null && this.f200803x0) {
                        ResultRecord resultRecord = (ResultRecord) parcelableArrayListExtra.get(0);
                        for (int i17 = 0; i17 < this.f200790k0.getChildCount(); i17++) {
                            View childAt = this.f200790k0.getChildAt(i17);
                            if ((childAt instanceof ViewGroup) && (childAt.getTag() instanceof Integer) && i3 == ((Integer) childAt.getTag()).intValue() && (editText = (EditText) childAt.findViewById(R.id.gr9)) != null) {
                                editText.setText(resultRecord.uin);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.hvn));
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                m3.putExtras(new Bundle(intent.getExtras()));
                startActivity(m3);
                return;
            }
            if (this.f200803x0 && intent.getBooleanExtra("delete_pic", false)) {
                this.L0 = true;
                h3(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = !isInMultiWindow();
        super.doOnCreate(bundle);
        initData();
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.P0);
        s3();
        this.app.unRegistObserver(this.Q0);
        Iterator<WeakReference<FaceDrawable>> it = this.I0.iterator();
        while (it.hasNext()) {
            FaceDrawable faceDrawable = it.next().get();
            if (faceDrawable != null) {
                faceDrawable.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.doOnPause();
            this.N0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        int i3 = this.K0;
        if (i3 != 0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8007751", "0X8007751", i3, 0, "", "", "", "");
        }
    }

    public void f3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (this.f200803x0) {
            this.f200788i0.setVisibility(8);
            this.f200787h0.setVisibility(0);
            this.f200789j0 = (LinearLayout) this.f200787h0.findViewById(R.id.eyi);
            this.f200790k0 = (LinearLayout) this.f200787h0.findViewById(R.id.gra);
            this.f200791l0 = (LinearLayout) this.f200787h0.findViewById(R.id.bgl);
            TextView textView = (TextView) this.f200787h0.findViewById(R.id.eyc);
            this.f200792m0 = textView;
            textView.setVisibility(0);
            this.f200792m0.setOnClickListener(this);
            TextView textView2 = (TextView) this.f200787h0.findViewById(R.id.f166611gn0);
            this.f200793n0 = textView2;
            textView2.setVisibility(0);
            this.f200793n0.setOnClickListener(this);
            TextView textView3 = (TextView) this.f200787h0.findViewById(R.id.bgc);
            this.f200794o0 = textView3;
            textView3.setVisibility(8);
            this.f200794o0.setOnClickListener(this);
            if (W2()) {
                this.f200787h0.findViewById(R.id.grb).setVisibility(8);
                this.f200793n0.setVisibility(8);
            }
            if (z16) {
                g3(this.D0, this.E0);
                return;
            }
            return;
        }
        this.f200788i0.setVisibility(0);
        this.f200787h0.setVisibility(8);
        this.f200789j0 = (LinearLayout) this.f200788i0.findViewById(R.id.eyi);
        this.f200790k0 = (LinearLayout) this.f200788i0.findViewById(R.id.gra);
        this.f200791l0 = (LinearLayout) this.f200788i0.findViewById(R.id.bgl);
        if (W2()) {
            this.f200788i0.findViewById(R.id.grb).setVisibility(8);
            if (QLog.isColorLevel()) {
                QLog.w("BusinessCard_EditActivity", 2, "\u540d\u7247\u5907\u6ce8\u4e0d\u5e94\u8be5\u51fa\u73b0\u8be6\u60c5\u6001");
            }
        }
        if (z16) {
            BusinessCard businessCard = this.D0;
            if (businessCard != null) {
                d3(businessCard);
                return;
            }
            CardOCRInfo cardOCRInfo = this.E0;
            if (cardOCRInfo != null) {
                e3(cardOCRInfo);
            }
        }
    }

    @QQPermissionGrant(1)
    public void grant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.M0) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusinessCardEditActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BusinessCardEditActivity businessCardEditActivity = BusinessCardEditActivity.this;
                    BusinessCard businessCard = businessCardEditActivity.D0;
                    if (businessCard != null) {
                        businessCardEditActivity.b3(businessCard.cardName, businessCard.company, businessCard.mobilesNum);
                        return;
                    }
                    CardOCRInfo cardOCRInfo = businessCardEditActivity.E0;
                    if (cardOCRInfo != null) {
                        businessCardEditActivity.b3(cardOCRInfo.f200892d, null, cardOCRInfo.f200895h);
                    }
                }
            }, 8, null, true);
        }
        this.M0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    public void notifyUser(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            new QQToastNotifier(this).notifyUser(i3, getTitleBarHeight(), 0, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        InputMethodUtil.hide(this);
        if (this.f200803x0) {
            BusinessCard businessCard = new BusinessCard();
            R2(businessCard, false);
            if (S2(businessCard, this.D0)) {
                n3(super.getResources().getString(R.string.d1z));
            } else {
                if (this.f200803x0 && this.f200804y0 && !isFinishing()) {
                    finish();
                    return true;
                }
                BusinessCard businessCard2 = this.D0;
                if (businessCard2 != null && !TextUtils.isEmpty(businessCard2.cardId)) {
                    t3(false, false, false);
                } else {
                    super.finish();
                    return true;
                }
            }
        } else {
            super.finish();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                onBackEvent();
            } else if (id5 == R.id.ivTitleBtnRightText) {
                onRightClick();
            } else if (id5 == R.id.acc) {
                if (this.D0 != null || this.E0 != null) {
                    this.M0 = true;
                    QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.BUSINESS_CARD_CONTACTS)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CONTACTS}, 2, new c());
                }
            } else if (id5 == R.id.eyc) {
                K2(this.f200789j0, null, 1, 15);
                int i3 = this.f200798s0 + 1;
                this.f200798s0 = i3;
                if (i3 >= 3) {
                    this.f200792m0.setVisibility(8);
                }
                int i16 = this.K0;
                if (i16 != 0) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8007752", "0X8007752", i16, 0, "", "", "", "");
                }
            } else if (id5 == R.id.f166611gn0) {
                M2(null, this.f200799t0);
                int i17 = this.f200799t0 + 1;
                this.f200799t0 = i17;
                if (i17 >= 2) {
                    this.f200793n0.setVisibility(8);
                }
            } else if (id5 == R.id.bgc) {
                K2(this.f200791l0, null, 2, 150);
                int i18 = this.f200800u0 + 1;
                this.f200800u0 = i18;
                if (i18 >= 2) {
                    this.f200794o0.setVisibility(8);
                }
            } else if (id5 == R.id.f164743ar1) {
                Intent intent = new Intent(this, (Class<?>) CardPicGalleryActivity.class);
                ArrayList<String> arrayList = new ArrayList<>();
                if (!TextUtils.isEmpty(this.F0)) {
                    arrayList.add(this.F0);
                }
                intent.putStringArrayListExtra("business_card_pics", arrayList);
                intent.putExtra("is_edit_mode", this.f200803x0);
                int i19 = this.H0;
                if (i19 == 1 || i19 == 3) {
                    intent.putExtra("is_from_profile", true);
                }
                startActivityForResult(intent, 11);
                overridePendingTransition(R.anim.f155038he, 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            z17 = ((Boolean) iPatchRedirector.redirect((short) 21, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
        } else if (keyEvent != null) {
            if (keyEvent.getKeyCode() != 66) {
                z16 = false;
            }
            z17 = z16;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z17;
    }

    void p3(String str) {
        ActionSheet create = ActionSheet.create(this);
        create.addButton(R.string.f_b);
        create.addButton(R.string.faa);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new d(str, create));
        create.show();
    }

    void s3() {
        if (this.O0 != null) {
            try {
                this.app.getApp().getContentResolver().unregisterContentObserver(this.O0);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_EditActivity", 2, th5.getMessage(), th5);
                }
            }
            this.O0 = null;
        }
    }

    void showWaitingDialog(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.f200796q0 == null) {
            this.f200796q0 = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.f200796q0.setMessage(str);
        this.f200796q0.setCancelable(false);
        if (isFinishing()) {
            return;
        }
        this.f200796q0.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class r implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f200830d;

        /* renamed from: e, reason: collision with root package name */
        int f200831e;

        /* renamed from: f, reason: collision with root package name */
        EditText f200832f;

        /* renamed from: h, reason: collision with root package name */
        boolean f200833h;

        /* renamed from: i, reason: collision with root package name */
        int f200834i;

        /* renamed from: m, reason: collision with root package name */
        String f200835m;

        public r(int i3, EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BusinessCardEditActivity.this, Integer.valueOf(i3), editText);
                return;
            }
            this.f200830d = true;
            this.f200833h = false;
            this.f200835m = "";
            this.f200831e = i3;
            this.f200832f = editText;
            this.f200834i = 0;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) editable);
                return;
            }
            if (this.f200834i == 1 && !this.f200835m.equals(editable.toString())) {
                if (this.f200830d) {
                    z17 = this.f200833h;
                } else {
                    z17 = true;
                }
                this.f200833h = z17;
            }
            this.f200830d = false;
            EditText editText = this.f200832f;
            if (editText instanceof ClearEllipsisEditText) {
                obj = ((ClearEllipsisEditText) editText).m();
            } else {
                obj = editText.getText().toString();
            }
            int length = obj.length();
            if (this.f200832f.getTag() != null && ((String) this.f200832f.getTag()).equals("name")) {
                length = obj.getBytes().length;
                z16 = true;
            } else {
                z16 = false;
            }
            if (length > this.f200831e) {
                while (length > this.f200831e) {
                    obj = obj.substring(0, obj.length() - 1);
                    if (z16) {
                        length = obj.getBytes().length;
                    } else {
                        length = obj.length();
                    }
                }
                this.f200832f.setText(obj);
                this.f200832f.setSelection(obj.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.f200835m = charSequence.toString();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        public r(int i3, EditText editText, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, BusinessCardEditActivity.this, Integer.valueOf(i3), editText, Integer.valueOf(i16));
                return;
            }
            this.f200830d = true;
            this.f200833h = false;
            this.f200835m = "";
            this.f200831e = i3;
            this.f200832f = editText;
            this.f200834i = i16;
        }
    }
}
