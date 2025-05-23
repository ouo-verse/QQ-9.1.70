package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.oidb.oidb_0x5e1$RspBody;

/* compiled from: P */
@RoutePage(desc = "\u8bbe\u5907\u7ba1\u7406\u9875\u9762", path = RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY)
/* loaded from: classes9.dex */
public class AuthDevActivity extends QIphoneTitleBarActivity implements com.tencent.mobileqq.app.identity.d {
    static IPatchRedirector $redirector_ = null;
    private static final String FROM_QQ_SAFE_MINIAPP = "app_qq_safe_center";
    private static final String QUESTION_FOR_DEVICE_URL = "https://kf.qq.com/touch/product/qq_aqbh_qqmp.html#showmenu=1007691";
    private static final String TAG = "Q.devlock.AuthDevActivity";
    private static final String T_DEV_MANAGE_PAGE_SHOW = "0X800AC52";
    private static final String T_RECENT_DEV_CLICK = "0X800AC55";
    private static final String T_RECENT_DEV_DELETE = "0X800AC56";
    private boolean isDelMode;
    private boolean isH5_logic;
    private boolean mAllowSet;
    private String mAppId;
    private TextView mAuthListDesc;
    private boolean mCanOpenOrClose;
    private Dialog mConfirmDialog;
    private ActionSheet mDelDevSheet;
    private AtomicBoolean mDelSuccessToastIsShowing;
    private final Set<m> mDeletingDeviceInfoSet;
    private com.tencent.mobileqq.friend.observer.b mDevListObserver;
    private DevlockInfo mDevLockInfo;
    private BusinessObserver mDevLockObserver;
    private boolean mEnableOpenAllowsetDev;
    private oidb_0x5e1$RspBody mFaceStateRsp;
    private String mFrom;
    private Handler mHandler;
    private boolean mIsAllowSet;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private final List<SvcDevLoginInfo> mOnlineDevList;
    private String mPageName;
    private String mPhoneNum;
    private QQProgressDialog mProDialog;
    private ActionSheet mRenameDevSheet;
    private Dialog mRiskDialog;
    private ISafeApi mSafeApi;
    private FaceSecureCheck$SecureCheckResponse mSecureRsp;
    private String mSecureState;
    private int mSeq;
    private final List<SvcDevLoginInfo> mShowedDevList;
    private LinearLayout mShowedDevListLayout;
    private String mTmpKey;
    private TextView mWXSyncQQMsgDesc;
    private FormSwitchItem mWXSyncQQMsgLayout;
    private com.tencent.mobileqq.loginregister.servlet.h mWtLoginObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Comparator<SvcDevLoginInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SvcDevLoginInfo svcDevLoginInfo, SvcDevLoginInfo svcDevLoginInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) svcDevLoginInfo, (Object) svcDevLoginInfo2)).intValue();
            }
            return -Long.compare(svcDevLoginInfo.iLoginTime, svcDevLoginInfo2.iLoginTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Comparator<SvcDevLoginInfo> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SvcDevLoginInfo svcDevLoginInfo, SvcDevLoginInfo svcDevLoginInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) svcDevLoginInfo, (Object) svcDevLoginInfo2)).intValue();
            }
            return -Long.compare(svcDevLoginInfo.iLoginTime, svcDevLoginInfo2.iLoginTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f174943a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18736);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f174943a = iArr;
            try {
                iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f174943a[BaseAction.ACTION_LEFT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f174943a[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (compoundButton == AuthDevActivity.this.mWXSyncQQMsgLayout.getSwitch()) {
                AuthDevActivity.this.onWxMsgStatusChanged();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            int i3 = c.f174943a[baseAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    if (AuthDevActivity.this.isDelMode) {
                        AuthDevActivity.this.toNormalStatus();
                        return null;
                    }
                    AuthDevActivity.this.onBackEvent();
                    return null;
                }
                return null;
            }
            if (!AuthDevActivity.this.isDelMode) {
                QLog.d(AuthDevActivity.TAG, 1, "onClick manage");
                AuthDevActivity.this.toDeletingStatus();
                l.c(AuthDevActivity.this.mShowedDevList.size());
                return null;
            }
            QLog.d(AuthDevActivity.TAG, 1, "onClick delete");
            HashSet hashSet = new HashSet(AuthDevActivity.this.mDeletingDeviceInfoSet);
            AuthDevActivity authDevActivity = AuthDevActivity.this;
            authDevActivity.deleteDevices(authDevActivity.mDeletingDeviceInfoSet);
            l.b(hashSet);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CheckBox f174946d;

        f(CheckBox checkBox) {
            this.f174946d = checkBox;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this, (Object) checkBox);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f174946d.performClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m f174948d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174949e;

        g(m mVar, int i3) {
            this.f174948d = mVar;
            this.f174949e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthDevActivity.this, mVar, Integer.valueOf(i3));
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (z16) {
                AuthDevActivity.this.mDeletingDeviceInfoSet.add(this.f174948d);
                QLog.d(AuthDevActivity.TAG, 2, "deletingStatus selected index=" + this.f174949e + " selectedSize=" + AuthDevActivity.this.mDeletingDeviceInfoSet.size());
            } else {
                AuthDevActivity.this.mDeletingDeviceInfoSet.remove(this.f174948d);
                QLog.d(AuthDevActivity.TAG, 2, "deletingStatus unselected index=" + this.f174949e + " selectedSize=" + AuthDevActivity.this.mDeletingDeviceInfoSet.size());
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f174951d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174952e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SvcDevLoginInfo f174953f;

        h(RelativeLayout relativeLayout, int i3, SvcDevLoginInfo svcDevLoginInfo) {
            this.f174951d = relativeLayout;
            this.f174952e = i3;
            this.f174953f = svcDevLoginInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthDevActivity.this, relativeLayout, Integer.valueOf(i3), svcDevLoginInfo);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", AuthDevActivity.T_RECENT_DEV_CLICK, AuthDevActivity.T_RECENT_DEV_CLICK, 0, 0, "", "", "", "");
                SvcDevLoginInfo svcDevLoginInfo = (SvcDevLoginInfo) this.f174951d.getTag();
                AuthDevActivity.this.showRenameDevActionSheet(svcDevLoginInfo.strDeviceName, svcDevLoginInfo.stDeviceItemDes, this.f174952e, svcDevLoginInfo.iAppId, this.f174953f.vecGuid, svcDevLoginInfo);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f174955d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f174956e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f174957f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ DeviceItemDes f174958h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ byte[] f174959i;

        i(long j3, String str, int i3, DeviceItemDes deviceItemDes, byte[] bArr) {
            this.f174955d = j3;
            this.f174956e = str;
            this.f174957f = i3;
            this.f174958h = deviceItemDes;
            this.f174959i = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthDevActivity.this, Long.valueOf(j3), str, Integer.valueOf(i3), deviceItemDes, bArr);
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
                    ReportController.o(null, "dc00898", "", "", AuthDevActivity.T_RECENT_DEV_DELETE, AuthDevActivity.T_RECENT_DEV_DELETE, 0, 0, "", "", "", "");
                    try {
                        m mVar = new m();
                        mVar.f174964a = this.f174958h;
                        mVar.f174965b = this.f174957f;
                        mVar.f174966c = this.f174955d;
                        mVar.f174967d = this.f174959i;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(mVar);
                        AuthDevActivity.this.showDelDevActionSheet(arrayList);
                    } catch (Throwable th5) {
                        QLog.e(AuthDevActivity.TAG, 1, "showDelDevActionSheet error : ", th5.getMessage());
                    }
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("appname", AuthDevActivity.this.mPageName);
                intent.putExtra("appid", this.f174955d);
                intent.putExtra("sub_appid", AppSetting.f());
                intent.putExtra("device_guid", com.tencent.mobileqq.guid.c.f213821a.c());
                intent.putExtra("target_name", this.f174956e);
                intent.putExtra("target_type_info", ((SvcDevLoginInfo) AuthDevActivity.this.mShowedDevList.get(this.f174957f)).strDeviceTypeInfo);
                intent.putExtra("target_desc", ((SvcDevLoginInfo) AuthDevActivity.this.mShowedDevList.get(this.f174957f)).stDeviceItemDes.vecItemDes);
                intent.putExtra("index", this.f174957f);
                RouteUtils.startActivity(AuthDevActivity.this, intent, RouterConstants.UI_ROUTE_DEV_RENAME_ACTIVITY);
            }
            if (AuthDevActivity.this.mRenameDevSheet != null && AuthDevActivity.this.mRenameDevSheet.isShowing() && !AuthDevActivity.this.isFinishing()) {
                AuthDevActivity.this.mRenameDevSheet.dismiss();
                AuthDevActivity.this.mRenameDevSheet.cancel();
                AuthDevActivity.this.mRenameDevSheet = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f174961d;

        j(ArrayList arrayList) {
            this.f174961d = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this, (Object) arrayList);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                boolean z16 = false;
                if (!NetworkUtil.isNetSupport(AuthDevActivity.this)) {
                    AuthDevActivity authDevActivity = AuthDevActivity.this;
                    QQToast.makeText(authDevActivity, authDevActivity.getString(R.string.b3j), 0).show(AuthDevActivity.this.getTitleBarHeight());
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(AuthDevActivity.TAG, 2, "OnClick.begin to delDev ");
                    }
                    ReportController.o(((AppActivity) AuthDevActivity.this).mRuntime, "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
                    Iterator it = this.f174961d.iterator();
                    boolean z17 = true;
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        boolean equals = Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), mVar.f174967d);
                        if (equals) {
                            z16 = true;
                        }
                        z17 &= AuthDevActivity.this.sendDelDevCmd(mVar, equals);
                        QLog.d(AuthDevActivity.TAG, 2, "delDevice indexInShowedList=" + mVar.f174965b);
                    }
                    if (z17) {
                        AuthDevActivity.this.showProgressDialog();
                    } else if (QLog.isColorLevel()) {
                        QLog.d(AuthDevActivity.TAG, 2, "OnClick.delDev fail");
                    }
                    AuthDevActivity.this.toNormalStatus();
                    l.a(this.f174961d.size(), z16);
                }
            }
            if (AuthDevActivity.this.mDelDevSheet != null && AuthDevActivity.this.mDelDevSheet.isShowing() && !AuthDevActivity.this.isFinishing()) {
                AuthDevActivity.this.mDelDevSheet.dismiss();
                AuthDevActivity.this.mDelDevSheet.cancel();
                AuthDevActivity.this.mDelDevSheet = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void c(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
                return;
            }
            if (AuthDevActivity.this.isFinishing()) {
                QLog.d(AuthDevActivity.TAG, 1, "OnCheckDevLockStatus activity is finished");
                return;
            }
            if (i3 == 0 && devlockInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(AuthDevActivity.TAG, 2, "OnCheckDevLockStatus ret = " + i3);
                    QLog.d(AuthDevActivity.TAG, 2, "DevlockInfo devSetup:" + devlockInfo.DevSetup + " countryCode:" + devlockInfo.CountryCode + " mobile:" + devlockInfo.Mobile + " MbItemSmsCodeStatus:" + devlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + devlockInfo.TimeLimit + " AvailableMsgCount:" + devlockInfo.AvailableMsgCount + " AllowSet:" + devlockInfo.AllowSet);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("DevlockInfo.ProtectIntro:");
                    sb5.append(devlockInfo.ProtectIntro);
                    sb5.append("  info.MbGuideType:");
                    sb5.append(devlockInfo.MbGuideType);
                    QLog.d(AuthDevActivity.TAG, 2, sb5.toString());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("DevlockInfo.MbGuideMsg:");
                    sb6.append(devlockInfo.MbGuideMsg);
                    QLog.d(AuthDevActivity.TAG, 2, sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("DevlockInfo.MbGuideInfoType:");
                    sb7.append(devlockInfo.MbGuideInfoType);
                    QLog.d(AuthDevActivity.TAG, 2, sb7.toString());
                    QLog.d(AuthDevActivity.TAG, 2, "DevlockInfo.MbGuideInfo:" + devlockInfo.MbGuideInfo);
                }
                com.tencent.mobileqq.equipmentlock.a.b().f(devlockInfo.TransferInfo);
                AuthDevActivity.this.mDevLockInfo = devlockInfo;
                AuthDevActivity authDevActivity = AuthDevActivity.this;
                if (authDevActivity.mDevLockInfo.AllowSet == 1) {
                    z16 = true;
                }
                authDevActivity.mIsAllowSet = z16;
                AuthDevActivity.this.initPageUI();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AuthDevActivity.TAG, 2, "OnCheckDevLockStatus ret = " + i3);
                if (errMsg != null) {
                    QLog.d(AuthDevActivity.TAG, 2, "OnCheckDevLockStatus errMsg:" + errMsg.getMessage());
                }
                if (devlockInfo == null) {
                    QLog.d(AuthDevActivity.TAG, 2, "OnCheckDevLockStatus DevlockInfo is null");
                }
            }
            String string = AuthDevActivity.this.getString(R.string.aza);
            if (errMsg != null && !TextUtils.isEmpty(errMsg.getMessage())) {
                string = errMsg.getMessage();
            }
            QQToast.makeText(AuthDevActivity.this.getApplicationContext(), string, 0).show(AuthDevActivity.this.getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class l {
        static IPatchRedirector $redirector_;

        static void a(int i3, boolean z16) {
            String str;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String valueOf = String.valueOf(i3);
            if (z16) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C631", "0X800C631", 0, 0, valueOf, str, "", "");
        }

        static void b(Set<m> set) {
            boolean z16;
            String str;
            if (set == null) {
                return;
            }
            String valueOf = String.valueOf(set.size());
            Iterator<m> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), it.next().f174967d)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C62F", "0X800C62F", 0, 0, valueOf, str, "", "");
        }

        static void c(int i3) {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C3DB", "0X800C3DB", 0, 0, String.valueOf(i3), "", "", "");
        }

        static void d(int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800C632", "0X800C632", 0, 0, String.valueOf(i3), "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        DeviceItemDes f174964a;

        /* renamed from: b, reason: collision with root package name */
        int f174965b;

        /* renamed from: c, reason: collision with root package name */
        long f174966c;

        /* renamed from: d, reason: collision with root package name */
        byte[] f174967d;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public AuthDevActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mPageName = "";
        this.mShowedDevList = new ArrayList();
        this.mOnlineDevList = new ArrayList();
        this.mHandler = new Handler();
        this.mShowedDevListLayout = null;
        this.mDelDevSheet = null;
        this.mRenameDevSheet = null;
        this.mAuthListDesc = null;
        this.mPhoneNum = null;
        this.mAllowSet = true;
        this.mCanOpenOrClose = true;
        this.mIsAllowSet = false;
        this.mEnableOpenAllowsetDev = false;
        this.mWXSyncQQMsgLayout = null;
        this.mWXSyncQQMsgDesc = null;
        this.isH5_logic = false;
        this.mOnCheckedChangeListener = new d();
        this.isDelMode = false;
        this.mDeletingDeviceInfoSet = new HashSet();
        this.mDelSuccessToastIsShowing = new AtomicBoolean(false);
        this.mWtLoginObserver = new k();
    }

    private boolean delItemAndKickOut(byte[] bArr) {
        SvcDevLoginInfo svcDevLoginInfo;
        boolean z16 = false;
        if (bArr != null) {
            Iterator<SvcDevLoginInfo> it = this.mShowedDevList.iterator();
            while (true) {
                if (it.hasNext()) {
                    svcDevLoginInfo = it.next();
                    if (Arrays.equals(bArr, svcDevLoginInfo.vecGuid)) {
                        break;
                    }
                } else {
                    svcDevLoginInfo = null;
                    break;
                }
            }
            if (svcDevLoginInfo == null) {
                return false;
            }
            if (Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), bArr)) {
                AppRuntime appRuntime = this.mRuntime;
                appRuntime.updateSubAccountLogin(appRuntime.getCurrentAccountUin(), false);
                this.mRuntime.getApplication().refreAccountList();
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(this, false);
                Manager manager = this.mRuntime.getManager(1);
                Object[] objArr = new Object[3];
                objArr[0] = "clear login sig, manage is null : [";
                if (manager == null) {
                    z16 = true;
                }
                objArr[1] = Boolean.valueOf(z16);
                objArr[2] = "]";
                QLog.d(TAG, 1, objArr);
                if (manager != null) {
                    WtloginManager wtloginManager = (WtloginManager) manager;
                    String account = this.mRuntime.getAccount();
                    wtloginManager.clearUserFastLoginData(account, 16L);
                    wtloginManager.clearUserFastLoginData(account, BaseConstants.OPEN_SDK_BUFLAG_B1);
                    wtloginManager.refreshMemorySig();
                    ((ILoginServletService) this.mRuntime.getRuntimeService(ILoginServletService.class, "all")).refreshMemorySigInMsf();
                }
                return true;
            }
            this.mShowedDevList.remove(svcDevLoginInfo);
            updateDevListUI();
        } else {
            QLog.e(TAG, 1, "delItemAndKickOut no such Item");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDevices(Set<m> set) {
        if (!set.isEmpty()) {
            showDelDevActionSheet(new ArrayList<>(set));
        } else {
            toNormalStatus();
        }
    }

    private void dismissSafetyRiskDialog() {
        Dialog dialog = this.mRiskDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mRiskDialog.dismiss();
        }
    }

    public static List<RichTextHelper.RichTextData> getDefaultProtocolRichTextData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(HardCodeUtil.qqStr(R.string.zvm), QUESTION_FOR_DEVICE_URL));
        return arrayList;
    }

    public static String getDefaultShowString() {
        return HardCodeUtil.qqStr(R.string.zvl) + HardCodeUtil.qqStr(R.string.zvm);
    }

    private MqqHandler getHandler(Class<?> cls) {
        AppRuntime appRuntime = this.mRuntime;
        if (!(appRuntime instanceof AppInterface)) {
            return null;
        }
        return ((AppInterface) appRuntime).getHandler(cls);
    }

    private void hideProgerssDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
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
                    if (AuthDevActivity.this.mProDialog != null && AuthDevActivity.this.mProDialog.isShowing()) {
                        AuthDevActivity.this.mProDialog.dismiss();
                        AuthDevActivity.this.mProDialog.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                AuthDevActivity.this.mProDialog = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPageUI() {
        this.mSafeApi.getWxMsgOptions(this.mRuntime);
        startGetRecentAndOnlineDevList();
    }

    private boolean isOnlineDevice(SvcDevLoginInfo svcDevLoginInfo) {
        if (svcDevLoginInfo == null) {
            return false;
        }
        Iterator<SvcDevLoginInfo> it = this.mOnlineDevList.iterator();
        while (it.hasNext()) {
            if (isSameDevice(it.next(), svcDevLoginInfo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameDevice(SvcDevLoginInfo svcDevLoginInfo, SvcDevLoginInfo svcDevLoginInfo2) {
        return Arrays.equals(svcDevLoginInfo.vecGuid, svcDevLoginInfo2.vecGuid);
    }

    private List<SvcDevLoginInfo> mergeTwoListAndUnique(List<SvcDevLoginInfo> list, List<SvcDevLoginInfo> list2) {
        boolean z16;
        ArrayList arrayList = new ArrayList(list);
        ArrayList<SvcDevLoginInfo> arrayList2 = new ArrayList(list2);
        Collections.sort(arrayList, new a());
        Collections.sort(arrayList2, new b());
        for (SvcDevLoginInfo svcDevLoginInfo : arrayList2) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (isSameDevice((SvcDevLoginInfo) it.next(), svcDevLoginInfo)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList.add(svcDevLoginInfo);
            }
        }
        return arrayList;
    }

    private void moveCurrentDevToShowedListHead() {
        ArrayList arrayList = new ArrayList();
        int size = this.mShowedDevList.size();
        for (int i3 = 0; i3 < size; i3++) {
            SvcDevLoginInfo svcDevLoginInfo = this.mShowedDevList.get(i3);
            if (svcDevLoginInfo != null) {
                if (Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), svcDevLoginInfo.vecGuid)) {
                    arrayList.add(0, svcDevLoginInfo);
                } else {
                    arrayList.add(svcDevLoginInfo);
                }
            }
        }
        this.mShowedDevList.clear();
        this.mShowedDevList.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWxMsgStatusChanged() {
        this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
        this.mWXSyncQQMsgLayout.setChecked(!r0.isChecked());
        this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
        } else {
            this.mSafeApi.setWXSyncQQMsgOption(this.mRuntime, !this.mWXSyncQQMsgLayout.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendDelDevCmd(m mVar, boolean z16) {
        if (this.mSafeApi.delHistoryDev(this.mRuntime, this.mPageName, mVar.f174964a, mVar.f174966c, mVar.f174967d) && this.mSafeApi.delAuthDev(this.mRuntime, this.mPageName, mVar.f174964a, z16, mVar.f174966c, mVar.f174967d)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelDevActionSheet(ArrayList<m> arrayList) {
        this.mDelDevSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        this.mDelDevSheet.setMainTitle(getString(R.string.f170893az0));
        this.mDelDevSheet.addButton(getResources().getString(R.string.ayz), 3);
        this.mDelDevSheet.addCancelButton(R.string.cancel);
        this.mDelDevSheet.setOnButtonClickListener(new j(arrayList));
        this.mDelDevSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevActivity.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
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
                    if (AuthDevActivity.this.mProDialog == null && !AuthDevActivity.this.isFinishing()) {
                        AuthDevActivity authDevActivity = AuthDevActivity.this;
                        AuthDevActivity authDevActivity2 = AuthDevActivity.this;
                        authDevActivity.mProDialog = new QQProgressDialog(authDevActivity2, authDevActivity2.getTitleBarHeight());
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (AuthDevActivity.this.mProDialog != null && !AuthDevActivity.this.mProDialog.isShowing()) {
                    AuthDevActivity.this.mProDialog.show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRenameDevActionSheet(String str, DeviceItemDes deviceItemDes, int i3, long j3, byte[] bArr, SvcDevLoginInfo svcDevLoginInfo) {
        int i16;
        this.mRenameDevSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        boolean equals = Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), bArr);
        boolean isOnlineDevice = isOnlineDevice(svcDevLoginInfo);
        ActionSheet actionSheet = this.mRenameDevSheet;
        if (!equals && !isOnlineDevice) {
            i16 = R.string.f170893az0;
        } else {
            i16 = R.string.zvi;
        }
        actionSheet.setMainTitle(getString(i16));
        this.mRenameDevSheet.addButton(getResources().getString(R.string.zvk), 5, 0);
        this.mRenameDevSheet.addButton(getResources().getString(R.string.zqr), 3, 1);
        this.mRenameDevSheet.addCancelButton(R.string.cancel);
        this.mRenameDevSheet.setOnButtonClickListener(new i(j3, str, i3, deviceItemDes, bArr));
        this.mRenameDevSheet.show();
    }

    private void startGetRecentAndOnlineDevList() {
        QLog.d(TAG, 1, "startGetRecentAndOnlineDevList");
        boolean recentLoginAndOnlineDevList = this.mSafeApi.getRecentLoginAndOnlineDevList(this.mRuntime, this.mPageName, 0L);
        if (recentLoginAndOnlineDevList) {
            this.mShowedDevList.clear();
            this.mOnlineDevList.clear();
            this.mAuthListDesc.setVisibility(0);
            this.mAuthListDesc.setText(getString(R.string.zvl));
            PrivacyPolicyHelper.initPrivacyPolicyTextView(this.mAuthListDesc, getDefaultShowString(), getDefaultProtocolRichTextData());
            updateDevListUI();
            return;
        }
        QLog.d(TAG, 1, "onCreate getRecentLoginAndOnlineDevList failed ret=", Boolean.valueOf(recentLoginAndOnlineDevList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toDeletingStatus() {
        this.isDelMode = true;
        this.quiSecNavBar.setRightText(getResources().getString(R.string.ajx));
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setLeftText(getResources().getString(R.string.cancel));
        this.mDeletingDeviceInfoSet.clear();
        try {
            int childCount = this.mShowedDevListLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mShowedDevListLayout.getChildAt(i3);
                CheckBox checkBox = (CheckBox) childAt.findViewById(R.id.ugy);
                childAt.setOnClickListener(new f(checkBox));
                checkBox.setVisibility(0);
                checkBox.setOnCheckedChangeListener(null);
                checkBox.setChecked(false);
                SvcDevLoginInfo svcDevLoginInfo = (SvcDevLoginInfo) childAt.getTag();
                m mVar = new m();
                mVar.f174964a = svcDevLoginInfo.stDeviceItemDes;
                mVar.f174965b = i3;
                mVar.f174966c = svcDevLoginInfo.iAppId;
                mVar.f174967d = svcDevLoginInfo.vecGuid;
                checkBox.setOnCheckedChangeListener(new g(mVar, i3));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "toDeletingStatus" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toNormalStatus() {
        this.isDelMode = false;
        this.quiSecNavBar.setLeftType(2);
        this.quiSecNavBar.setRightText(getResources().getString(R.string.f1642725d));
        updateDevListUI();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v12 */
    private void updateDevListUI() {
        int i3;
        String str;
        String str2;
        String str3;
        char c16;
        boolean z16;
        char c17 = '\b';
        if (this.mShowedDevList.isEmpty()) {
            this.mAuthListDesc.setVisibility(4);
            this.mShowedDevListLayout.setVisibility(8);
            return;
        }
        ?? r56 = 1;
        if (this.isDelMode) {
            QLog.d(TAG, 1, "updateDevListUI stop, isDelMode");
            return;
        }
        this.mShowedDevListLayout.removeAllViews();
        ?? r65 = 0;
        this.mShowedDevListLayout.setVisibility(0);
        moveCurrentDevToShowedListHead();
        int size = this.mShowedDevList.size();
        int i16 = 0;
        while (i16 < size) {
            SvcDevLoginInfo svcDevLoginInfo = this.mShowedDevList.get(i16);
            if (svcDevLoginInfo == null) {
                c16 = c17;
                z16 = r56;
            } else {
                View inflate = getLayoutInflater().inflate(R.layout.atu, this.mShowedDevListLayout, (boolean) r65);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.dq8);
                if (size == r56) {
                    com.tencent.mobileqq.widget.o.m(relativeLayout, r65, r56);
                } else if (i16 == 0) {
                    com.tencent.mobileqq.widget.o.m(relativeLayout, r56, r56);
                } else if (i16 == size - 1) {
                    com.tencent.mobileqq.widget.o.m(relativeLayout, 3, r56);
                } else {
                    com.tencent.mobileqq.widget.o.m(relativeLayout, 2, r56);
                }
                ImageView imageView = (ImageView) inflate.findViewById(R.id.f164977uh3);
                TextView textView = (TextView) inflate.findViewById(R.id.f164974uh0);
                TextView textView2 = (TextView) inflate.findViewById(R.id.f164976uh2);
                TextView textView3 = (TextView) inflate.findViewById(R.id.ycy);
                TextView textView4 = (TextView) inflate.findViewById(R.id.ycx);
                TextView textView5 = (TextView) inflate.findViewById(R.id.f164975uh1);
                long j3 = svcDevLoginInfo.iLoginPlatform;
                if (j3 == 3) {
                    imageView.setImageResource(R.drawable.qui_computer);
                } else if (j3 != 2 && j3 != 1) {
                    if (j3 == 8) {
                        imageView.setImageResource(R.drawable.qui_watch);
                    } else {
                        imageView.setImageResource(R.drawable.qui_question_mark_circle);
                    }
                } else {
                    imageView.setImageResource(R.drawable.qui_phone);
                }
                if (TextUtils.isEmpty(svcDevLoginInfo.strDeviceName)) {
                    str = getResources().getString(R.string.f171135cf3);
                } else {
                    str = svcDevLoginInfo.strDeviceName;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "strDeviceName=" + str, " info.strDeviceName=" + svcDevLoginInfo.strDeviceName);
                }
                textView.setText(str);
                boolean equals = Arrays.equals(com.tencent.mobileqq.guid.c.f213821a.c(), svcDevLoginInfo.vecGuid);
                boolean isOnlineDevice = isOnlineDevice(svcDevLoginInfo);
                if (equals) {
                    str2 = getResources().getString(R.string.f171133cf0);
                } else if (isOnlineDevice) {
                    str2 = getResources().getString(R.string.zvh);
                } else {
                    str2 = "";
                }
                textView5.setText(str2);
                if (TextUtils.isEmpty(svcDevLoginInfo.strDeviceTypeInfo)) {
                    str3 = getResources().getString(R.string.f171135cf3);
                } else {
                    str3 = svcDevLoginInfo.strDeviceTypeInfo;
                }
                textView2.setText(str3);
                long j16 = svcDevLoginInfo.iLoginTime;
                if (j16 > 0) {
                    textView3.setText(com.tencent.mobileqq.utils.en.o(j16 * 1000, "MM-dd HH:mm"));
                }
                if (!TextUtils.isEmpty(svcDevLoginInfo.strLoginLocation)) {
                    textView4.setText(APLogFileUtil.SEPARATOR_LOG + svcDevLoginInfo.strLoginLocation);
                }
                CheckBox checkBox = (CheckBox) relativeLayout.findViewById(R.id.ugy);
                checkBox.setOnCheckedChangeListener(null);
                c16 = '\b';
                checkBox.setVisibility(8);
                z16 = true;
                relativeLayout.setClickable(true);
                relativeLayout.setTag(svcDevLoginInfo);
                relativeLayout.setOnClickListener(new h(relativeLayout, i16, svcDevLoginInfo));
                this.mShowedDevListLayout.addView(inflate);
            }
            i16++;
            r56 = z16;
            c17 = c16;
            r65 = 0;
        }
        TextView textView6 = this.mAuthListDesc;
        if (this.mShowedDevListLayout.getChildCount() == 0) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        textView6.setVisibility(i3);
    }

    void dismissConfirmCloseDialog() {
        Dialog dialog = this.mConfirmDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                try {
                    this.mConfirmDialog.dismiss();
                } catch (Exception unused) {
                }
            }
            this.mConfirmDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.att);
        this.mSafeApi = (ISafeApi) QRoute.api(ISafeApi.class);
        this.mShowedDevListLayout = (LinearLayout) super.findViewById(R.id.f164514a11);
        TextView textView = (TextView) super.findViewById(R.id.f164516a13);
        this.mAuthListDesc = textView;
        textView.setVisibility(4);
        FormSwitchItem formSwitchItem = (FormSwitchItem) super.findViewById(R.id.l5g);
        this.mWXSyncQQMsgLayout = formSwitchItem;
        formSwitchItem.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mWXSyncQQMsgLayout.setVisibility(8);
        TextView textView2 = (TextView) super.findViewById(R.id.l5f);
        this.mWXSyncQQMsgDesc = textView2;
        textView2.setVisibility(8);
        Intent intent = super.getIntent();
        if (TextUtils.equals(intent.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
            this.leftView.setText(R.string.fsn);
        }
        if (this.mRuntime == null) {
            finish();
            QLog.e(TAG, 1, "error : app is null");
            return false;
        }
        try {
            this.mPageName = InstalledAppListMonitor.getPackageInfo(getPackageManager(), getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "packName = " + this.mPageName);
        }
        this.mDevLockObserver = this.mSafeApi.getDevLockObserver(this);
        this.mDevListObserver = this.mSafeApi.getDevListObserver(this);
        addObserver(this.mDevLockObserver);
        addObserver(this.mDevListObserver);
        String stringExtra = intent.getStringExtra("from");
        this.mFrom = stringExtra;
        if (FROM_QQ_SAFE_MINIAPP.equals(stringExtra)) {
            if (!((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
                startGetDevLockStatus();
            }
        } else {
            this.mPhoneNum = intent.getExtras().getString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
            this.mIsAllowSet = intent.getExtras().getBoolean(AuthDevOpenUgActivity.KEY_ALLOW_SET);
            this.mEnableOpenAllowsetDev = intent.getExtras().getBoolean("enable_open_allowset_dev");
            this.isH5_logic = intent.getExtras().getBoolean("h5_flag");
            this.mSecureState = intent.getExtras().getString("secureState", "secureStateUNKNOWN");
            this.mDevLockInfo = (DevlockInfo) intent.getParcelableExtra(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO);
            if ("secureStateOk".equals(this.mSecureState)) {
                this.mAppId = intent.getStringExtra("faceAppId");
                this.mTmpKey = intent.getStringExtra("faceTmpKey");
                FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse = new FaceSecureCheck$SecureCheckResponse();
                this.mSecureRsp = faceSecureCheck$SecureCheckResponse;
                faceSecureCheck$SecureCheckResponse.bool_sec_pass.set(true);
                this.mSecureRsp.str_tmpkey.set(this.mTmpKey);
                this.mSecureRsp.str_openid.set(this.mAppId);
            }
            initPageUI();
        }
        super.setTitle(R.string.zvg);
        this.quiSecNavBar.setRightText(getResources().getString(R.string.f1642725d));
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setLeftType(2);
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new e());
        ReportController.o(null, "dc00898", "", "", T_DEV_MANAGE_PAGE_SHOW, T_DEV_MANAGE_PAGE_SHOW, 0, 0, "", "", "", "");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.finish();
        if (getIntent().getBooleanExtra("from_risk_hint", false)) {
            getIntent().removeExtra("from_risk_hint");
            Intent intent = new Intent();
            intent.putExtra("from_risk_hint", true);
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, intent, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 0) {
            QLog.d(TAG, 1, "onActivityResult requestCode is 0, resultCode is : ", Integer.valueOf(i16));
            if ((i16 == 0 || i16 == -1) && intent != null && intent.getExtras() != null && this.mDevLockInfo != null) {
                Bundle extras = intent.getExtras();
                if (this.mDevLockInfo.DevSetup == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z18 = extras.getBoolean(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, z16);
                String string = extras.getString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
                if (this.mDevLockInfo.AllowSet == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                boolean z19 = extras.getBoolean(AuthDevOpenUgActivity.KEY_ALLOW_SET);
                QLog.d(TAG, 1, "status is ", Boolean.valueOf(z17), "open is ", Boolean.valueOf(z18), " status is ", Boolean.valueOf(z17), " allowSet is ", Boolean.valueOf(z19));
                if (z18) {
                    this.mDevLockInfo.DevSetup = 1;
                } else {
                    this.mDevLockInfo.DevSetup = 0;
                }
                if (!TextUtils.isEmpty(string)) {
                    this.mDevLockInfo.Mobile = string;
                    this.mPhoneNum = string;
                }
                this.mAllowSet = z19;
                if (z19) {
                    this.mDevLockInfo.AllowSet = 1;
                } else {
                    this.mDevLockInfo.AllowSet = 0;
                }
                startGetRecentAndOnlineDevList();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        boolean z16;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("devlock_need_broadcast")) {
            z16 = extras.getBoolean("devlock_need_broadcast");
        } else {
            z16 = false;
        }
        if (z16) {
            Intent intent2 = new Intent();
            intent2.setAction(NewIntent.ACTION_DEVLOCK_ROAM);
            sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
        }
        Intent intent3 = new Intent();
        intent3.putExtra(AuthDevOpenUgActivity.KEY_ALLOW_SET, this.mAllowSet);
        intent3.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, this.mPhoneNum);
        oidb_0x5e1$RspBody oidb_0x5e1_rspbody = this.mFaceStateRsp;
        if (oidb_0x5e1_rspbody != null && !oidb_0x5e1_rspbody.rpt_msg_uin_data.isEmpty()) {
            intent3.putExtra("faceStateKey", String.valueOf(this.mFaceStateRsp.rpt_msg_uin_data.get(0).user_login_guard_face.get()));
        }
        setResult(0, intent3);
        if (((ISafeApi) QRoute.api(ISafeApi.class)).isH5Jump() && this.isH5_logic) {
            finish();
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, new Intent(), -1);
            return false;
        }
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.identity.d
    public void onDelDevResult(boolean z16, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, bArr);
            return;
        }
        QLog.d(TAG, 1, "onDelDevResult isSuccess=" + z16 + " errorMsg=" + str + " guid=" + bArr);
        hideProgerssDialog();
        if (z16) {
            if (delItemAndKickOut(bArr)) {
                return;
            }
            if (this.mDelSuccessToastIsShowing.compareAndSet(false, true)) {
                QQToast.makeText(getApplicationContext(), 2, getString(R.string.f170894az3), 0).show();
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevActivity.13
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthDevActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AuthDevActivity.this.mDelSuccessToastIsShowing.set(false);
                        }
                    }
                }, 16, null, true, 1000L);
            }
            ReportController.o(this.mRuntime, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(getApplicationContext(), 1, getString(R.string.cew), 0).show(getTitleBarHeight());
        } else {
            QQToast.makeText(getApplicationContext(), 1, str, 0).show(getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        hideProgerssDialog();
        dismissSafetyRiskDialog();
        removeObserver(this.mDevListObserver);
        removeObserver(this.mDevLockObserver);
    }

    @Override // com.tencent.mobileqq.app.identity.d
    public void onGetRecentLoginAndLoginDevResult(boolean z16, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
        String valueOf;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), svcRspGetDevLoginInfo);
            return;
        }
        if (z16 && svcRspGetDevLoginInfo != null && svcRspGetDevLoginInfo.iResult == 0) {
            QLog.d(TAG, 1, "onGetRecentLoginAndLoginDevResult success");
            this.mOnlineDevList.clear();
            this.mOnlineDevList.addAll(svcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
            this.mShowedDevList.clear();
            this.mShowedDevList.addAll(mergeTwoListAndUnique(svcRspGetDevLoginInfo.vecCurrentLoginDevInfo, svcRspGetDevLoginInfo.vecHistoryLoginDevInfo));
            l.d(this.mShowedDevList.size());
            updateDevListUI();
            return;
        }
        if (svcRspGetDevLoginInfo == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(svcRspGetDevLoginInfo.iResult);
        }
        Object[] objArr = new Object[6];
        objArr[0] = "onGetRecentLoginAndLoginDevResult fail isSuccess=";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = " data==null ? ";
        if (svcRspGetDevLoginInfo == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        objArr[3] = Boolean.valueOf(z17);
        objArr[4] = "errorResult : ";
        objArr[5] = valueOf;
        QLog.d(TAG, 1, objArr);
        QQToast.makeText(getActivity(), 1, getString(R.string.azh), 0).show(getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.app.identity.d
    public void onRenameAuthDev(boolean z16, int i3, byte[] bArr, String str) {
        List<SvcDevLoginInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, str);
            return;
        }
        if (z16 && (list = this.mShowedDevList) != null && i3 >= 0 && i3 < list.size()) {
            SvcDevLoginInfo svcDevLoginInfo = this.mShowedDevList.get(i3);
            if (Arrays.equals(svcDevLoginInfo.stDeviceItemDes.vecItemDes, bArr)) {
                svcDevLoginInfo.strDeviceName = str;
                updateDevListUI();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.identity.d
    public void onWXSyncQQMsgOption(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            return;
        }
        boolean z16 = true;
        int i16 = bundle.getInt("cmd", 1);
        int i17 = bundle.getInt("opt", 2);
        int i18 = bundle.getInt("ret", -1);
        String str = (String) bundle.get("wording");
        if (i16 != 1) {
            if (i16 == 2) {
                if (i18 == 0) {
                    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
                    FormSwitchItem formSwitchItem = this.mWXSyncQQMsgLayout;
                    if (i17 != 1) {
                        z16 = false;
                    }
                    formSwitchItem.setChecked(z16);
                    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
                    this.mWXSyncQQMsgDesc.setText(str);
                    return;
                }
                this.mWXSyncQQMsgLayout.setVisibility(8);
                this.mWXSyncQQMsgDesc.setVisibility(8);
                QQToast.makeText(this, str, 0).show(getTitleBarHeight());
                return;
            }
            return;
        }
        if (i18 == 0) {
            this.mWXSyncQQMsgLayout.setVisibility(0);
            this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
            FormSwitchItem formSwitchItem2 = this.mWXSyncQQMsgLayout;
            if (i17 != 1) {
                z16 = false;
            }
            formSwitchItem2.setChecked(z16);
            this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
            this.mWXSyncQQMsgDesc.setVisibility(0);
            this.mWXSyncQQMsgDesc.setText(str);
            return;
        }
        this.mWXSyncQQMsgLayout.setVisibility(8);
        this.mWXSyncQQMsgDesc.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public void startGetDevLockStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startGetDevLockStatus begin to CheckDevLockStatus");
        }
        int checkDevLockStatus = this.mSafeApi.checkDevLockStatus(this.mRuntime, this.mRuntime.getCurrentAccountUin(), this.mWtLoginObserver);
        if (checkDevLockStatus != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + checkDevLockStatus);
            }
            QQToast.makeText(this, getString(R.string.ci7), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
