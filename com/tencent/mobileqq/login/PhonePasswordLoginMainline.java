package com.tencent.mobileqq.login;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.PhonePasswordLoginMainline;
import com.tencent.mobileqq.login.bn;
import com.tencent.mobileqq.login.bp;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import com.tencent.util.URLUtil;
import cooperation.qzone.util.WnsError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.slf4j.Marker;
import tencent.im.login.GatewayVerify$ReqBody;
import tencent.im.login.GatewayVerify$ReqCmd24;
import tencent.im.login.GatewayVerify$ReqCmd4;
import tencent.im.login.GatewayVerify$ReqCommonInfo;
import tencent.im.login.GatewayVerify$WaterprofWallInfo;

/* loaded from: classes15.dex */
public class PhonePasswordLoginMainline extends k<ay> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LoginMainline_PhonePassword";
    private AccountInfo mAccountInfo;
    private int mAccountInfoListSize;
    private boolean mHasDevLockVerify;
    private boolean mHasMultiAccountShown;
    private boolean mHasPuzzleVerify;
    private boolean mIsLoginByUinTokenNow;
    private final com.tencent.mobileqq.loginregister.servlet.h mLoginObserver;
    private WeakReference<com.tencent.mobileqq.widget.bm> mMultiAccountDialogRef;
    private final f mSelectAccountListener;

    /* loaded from: classes15.dex */
    public class a implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ String f241797a;

        a(String str) {
            this.f241797a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhonePasswordLoginMainline.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(PhonePasswordLoginMainline.TAG, 1, "PuzzleVerify cancel");
            PhonePasswordLoginMainline.this.reportEvent("0X800C4B1", 2, "", "", "", "");
            PhonePasswordLoginMainline.this.onLoginCancel();
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean z16, String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3);
                return;
            }
            QLog.i(PhonePasswordLoginMainline.TAG, 1, "PuzzleVerify result=" + z16);
            PhonePasswordLoginMainline.this.reportEvent("0X800C4B1", 0, "", "", "", "");
            PhonePasswordLoginMainline phonePasswordLoginMainline = PhonePasswordLoginMainline.this;
            T t16 = phonePasswordLoginMainline.mLoginParams;
            phonePasswordLoginMainline.getSaltUinList(((ay) t16).f241929f, ((ay) t16).f241930g, ((ay) t16).f241932i, str, str2, this.f241797a, phonePasswordLoginMainline.mLoginObserver);
        }
    }

    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhonePasswordLoginMainline.this);
            }
        }

        public /* synthetic */ void H(List list, WUserSigInfo wUserSigInfo) {
            PhonePasswordLoginMainline phonePasswordLoginMainline = PhonePasswordLoginMainline.this;
            phonePasswordLoginMainline.showMultiAccountDialog(list, wUserSigInfo, phonePasswordLoginMainline.mSelectAccountListener);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void m(int i3, ErrMsg errMsg, final WUserSigInfo wUserSigInfo, boolean z16, Parcelable parcelable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, wUserSigInfo, Boolean.valueOf(z16), parcelable);
                return;
            }
            String message = errMsg != null ? errMsg.getMessage() : "";
            QLog.i(PhonePasswordLoginMainline.TAG, 1, "onGetSaltUinList ret=" + i3 + " msg=" + message + " needPuzzleVerify=" + z16);
            if (z16) {
                PhonePasswordLoginMainline.this.startPuzzleVerify((PuzzleVerifyInfo) parcelable);
                return;
            }
            String str = PhonePasswordLoginMainline.this.mHasPuzzleVerify ? "1" : "2";
            final ArrayList arrayList = new ArrayList();
            try {
                List<AccountInfo> c16 = com.tencent.mobileqq.util.bk.c(wUserSigInfo, 7);
                if (c16 != null) {
                    arrayList.addAll(c16);
                }
                if (i3 == 0 && !arrayList.isEmpty()) {
                    int size = arrayList.size();
                    QLog.i(PhonePasswordLoginMainline.TAG, 1, "onGetSaltUinList accountInfoListSize=" + size);
                    PhonePasswordLoginMainline.this.reportEvent("0X800C384", 0, "", str, "0", "");
                    if (size == 1) {
                        PhonePasswordLoginMainline.this.mSelectAccountListener.a((AccountInfo) arrayList.get(0), size, true);
                        return;
                    }
                    AccountInfo d16 = com.tencent.mobileqq.loginregister.z.d(arrayList, Marker.ANY_NON_NULL_MARKER + ((ay) PhonePasswordLoginMainline.this.mLoginParams).f241930g + " " + ((ay) PhonePasswordLoginMainline.this.mLoginParams).f241929f, ((ay) PhonePasswordLoginMainline.this.mLoginParams).f241931h);
                    if (d16 != null) {
                        QLog.i(PhonePasswordLoginMainline.TAG, 1, "startMultiAccountLogin auto select selectedAccountInfo uin " + StringUtil.getSimpleUinForPrint(((ay) PhonePasswordLoginMainline.this.mLoginParams).f241931h));
                        PhonePasswordLoginMainline.this.mSelectAccountListener.a(d16, size, true);
                        return;
                    }
                    PhonePasswordLoginMainline.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.aw
                        @Override // java.lang.Runnable
                        public final void run() {
                            PhonePasswordLoginMainline.b.this.H(arrayList, wUserSigInfo);
                        }
                    }, PhonePasswordLoginMainline.this.isLoginActivityInvalid() ? 1000L : 0L);
                    return;
                }
                PhonePasswordLoginMainline.this.onLoginFailed(new aj(i3, i3, message, errMsg, null, PhonePasswordLoginMainline.this.getTlv543Data(wUserSigInfo), null));
                PhonePasswordLoginMainline.this.reportEvent("0X800C384", 1, "", str, String.valueOf(i3), "");
                QLog.e(PhonePasswordLoginMainline.TAG, 1, "onGetSaltUinList failed ret=" + i3 + " accountInfoList isEmpty");
            } catch (Exception e16) {
                PhonePasswordLoginMainline.this.onLoginFailed(new aj(i3, i3, message, errMsg, null, null, null));
                PhonePasswordLoginMainline.this.reportEvent("0X800C384", 1, "", str, String.valueOf(i3), "");
                QLog.e(PhonePasswordLoginMainline.TAG, 1, "onGetSaltUinList failed" + e16);
            }
        }
    }

    /* loaded from: classes15.dex */
    class c implements f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhonePasswordLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.PhonePasswordLoginMainline.f
        public void a(AccountInfo accountInfo, int i3, boolean z16) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, accountInfo, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            QLog.d(PhonePasswordLoginMainline.TAG, 1, "selectAccountFromList onSelectAccount uin=" + accountInfo.getMaskUin());
            PhonePasswordLoginMainline phonePasswordLoginMainline = PhonePasswordLoginMainline.this;
            String valueOf = String.valueOf(i3);
            if (z16) {
                str = "2";
            } else {
                str = "1";
            }
            if (!PhonePasswordLoginMainline.this.mHasPuzzleVerify) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            phonePasswordLoginMainline.reportEvent("0X800C385", 0, valueOf, str, str2, "");
            PhonePasswordLoginMainline.this.mAccountInfo = accountInfo;
            PhonePasswordLoginMainline.this.mAccountInfoListSize = i3;
            PhonePasswordLoginMainline.this.loginByToken();
        }

        @Override // com.tencent.mobileqq.login.PhonePasswordLoginMainline.f
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d(PhonePasswordLoginMainline.TAG, 1, "selectAccountFromList onCancel");
                PhonePasswordLoginMainline.this.onLoginCancel();
            }
        }
    }

    /* loaded from: classes15.dex */
    public class d implements bn.e {
        static IPatchRedirector $redirector_;

        /* loaded from: classes15.dex */
        class a implements h.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PhonePasswordLoginMainline.this.onLoginCancel();
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    PhonePasswordLoginMainline.this.onReLogin();
                }
            }

            @Override // com.tencent.mobileqq.login.remind.h.b
            public void c(@NonNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhonePasswordLoginMainline.this);
            }
        }

        public /* synthetic */ void f(String str, Bundle bundle) {
            PhonePasswordLoginMainline.this.hideLoading(true);
            PhonePasswordLoginMainline.this.dismissMultiAccountDialog();
            PhonePasswordLoginMainline.this.onLoginSuccess(str, bundle);
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void a(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) ajVar);
            } else if (ajVar != null && !new com.tencent.mobileqq.login.remind.m().h(PhonePasswordLoginMainline.this.getActivity(), ajVar.f241869f, PhonePasswordLoginMainline.this.mAccountInfo.getMaskUin(), new a())) {
                PhonePasswordLoginMainline.this.onReLogin();
            }
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                PhonePasswordLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhonePasswordLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhonePasswordLoginMainline.this.hideLoading(false);
                    return;
                } else {
                    PhonePasswordLoginMainline.this.onLoginCancel();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void c(final String str, final Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
                return;
            }
            QLog.i(PhonePasswordLoginMainline.TAG, 1, "loginByUinToken success");
            PhonePasswordLoginMainline.this.mIsLoginByUinTokenNow = false;
            PhonePasswordLoginMainline.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ax
                @Override // java.lang.Runnable
                public final void run() {
                    PhonePasswordLoginMainline.d.this.f(str, bundle);
                }
            });
        }

        @Override // com.tencent.mobileqq.login.bn.e
        public void d(aj ajVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhonePasswordLoginMainline.this.mIsLoginByUinTokenNow = false;
                if (PhonePasswordLoginMainline.this.isMultiAccountDialogShowing()) {
                    PhonePasswordLoginMainline.this.hideLoading(false);
                    if (!ai.m(PhonePasswordLoginMainline.this.getActivity(), (ay) PhonePasswordLoginMainline.this.mLoginParams, ajVar)) {
                        PhonePasswordLoginMainline.this.onLoginFailed(ajVar);
                        return;
                    }
                    return;
                }
                PhonePasswordLoginMainline.this.onLoginFailed(ajVar);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
        }
    }

    /* loaded from: classes15.dex */
    public class e implements bn.f {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhonePasswordLoginMainline.this);
            }
        }

        private String e() {
            if (PhonePasswordLoginMainline.this.mHasPuzzleVerify && PhonePasswordLoginMainline.this.mHasMultiAccountShown) {
                return "1";
            }
            if (PhonePasswordLoginMainline.this.mHasPuzzleVerify) {
                return "2";
            }
            if (PhonePasswordLoginMainline.this.mHasMultiAccountShown) {
                return "3";
            }
            return "4";
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                PhonePasswordLoginMainline.this.mHasDevLockVerify = true;
                QuestionnaireForLoginManager.g("new_device");
                PhonePasswordLoginMainline.this.reportEvent("0X800C389", 0, "", e(), "", "");
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void b(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhonePasswordLoginMainline.this.reportEvent("0X800C387", i3, String.valueOf(j3), "", PhonePasswordLoginMainline.this.mAccountInfo.getMaskUin(), "");
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                PhonePasswordLoginMainline phonePasswordLoginMainline = PhonePasswordLoginMainline.this;
                phonePasswordLoginMainline.reportEvent("0X800C386", 0, String.valueOf(phonePasswordLoginMainline.mAccountInfoListSize), "", PhonePasswordLoginMainline.this.mAccountInfo.getMaskUin(), "");
            }
        }

        @Override // com.tencent.mobileqq.login.bn.f
        public void d(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                PhonePasswordLoginMainline.this.reportEvent("0X800C38A", i3, String.valueOf(j3), e(), "", "");
            } else {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }
    }

    /* loaded from: classes15.dex */
    public interface f {
        void a(AccountInfo accountInfo, int i3, boolean z16);

        void onCancel();
    }

    public PhonePasswordLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasPuzzleVerify = false;
        this.mHasDevLockVerify = false;
        this.mHasMultiAccountShown = false;
        this.mIsLoginByUinTokenNow = false;
        this.mLoginObserver = new b();
        this.mSelectAccountListener = new c();
    }

    public void dismissMultiAccountDialog() {
        com.tencent.mobileqq.widget.bm bmVar;
        WeakReference<com.tencent.mobileqq.widget.bm> weakReference = this.mMultiAccountDialogRef;
        if (weakReference != null) {
            bmVar = weakReference.get();
        } else {
            bmVar = null;
        }
        if (bmVar != null) {
            try {
                if (bmVar.isShowing()) {
                    bmVar.setOnDismissListener(null);
                    bmVar.dismiss();
                }
            } catch (Exception e16) {
                QLog.w(TAG, 1, "dismissMultiAccountDialog", e16);
            }
        }
        this.mMultiAccountDialogRef = null;
    }

    private static Context getContext() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private String getLoginEndReportInfo() {
        if (this.mHasPuzzleVerify) {
            if (this.mHasMultiAccountShown) {
                if (this.mHasDevLockVerify) {
                    return "1";
                }
                return "2";
            }
            if (this.mHasDevLockVerify) {
                return "3";
            }
            return "4";
        }
        if (this.mHasMultiAccountShown) {
            if (this.mHasDevLockVerify) {
                return "5";
            }
            return "6";
        }
        if (this.mHasDevLockVerify) {
            return "7";
        }
        return "8";
    }

    public byte[] getTlv543Data(WUserSigInfo wUserSigInfo) {
        HashMap<Integer, tlv_t> hashMap;
        tlv_t tlv_tVar;
        if (wUserSigInfo == null || (hashMap = wUserSigInfo.loginResultTLVMap) == null || (tlv_tVar = hashMap.get(1347)) == null) {
            return null;
        }
        return tlv_tVar.get_data();
    }

    public boolean isMultiAccountDialogShowing() {
        com.tencent.mobileqq.widget.bm bmVar;
        WeakReference<com.tencent.mobileqq.widget.bm> weakReference = this.mMultiAccountDialogRef;
        if (weakReference != null) {
            bmVar = weakReference.get();
        } else {
            bmVar = null;
        }
        if (bmVar != null && bmVar.isShowing()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void lambda$onLoginFailed$2(aj ajVar) {
        dismissMultiAccountDialog();
        ai.m(getActivity(), (ay) this.mLoginParams, ajVar);
    }

    public /* synthetic */ void lambda$showMultiAccountDialog$0(f fVar, List list, Object obj) {
        if (obj instanceof AccountInfo) {
            showLoading();
            fVar.a((AccountInfo) obj, list.size(), false);
        }
    }

    public static /* synthetic */ void lambda$showToast$3(String str) {
        QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
    }

    public void loginByToken() {
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo == null) {
            return;
        }
        new bn(new bp.a(7, ((ay) this.mLoginParams).f242201b, accountInfo).d(((ay) this.mLoginParams).f242202c).c(((ay) this.mLoginParams).f242203d).f(((ay) this.mLoginParams).f241934k).e(((ay) this.mLoginParams).f242204e).a(), new d(), new e()).i();
        this.mIsLoginByUinTokenNow = true;
    }

    public void reportEvent(String str, int i3, String str2, String str3, String str4, String str5) {
        T t16 = this.mLoginParams;
        com.tencent.mobileqq.util.as.b("phone_pwd_login_mainline", str, ((ay) t16).f241929f, ((ay) t16).f242201b, i3, false, str2, str3, str4, str5);
    }

    public void showMultiAccountDialog(@NonNull final List<AccountInfo> list, WUserSigInfo wUserSigInfo, @NonNull final f fVar) {
        String str;
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            com.tencent.mobileqq.widget.bm a16 = com.tencent.mobileqq.util.bk.a(activity, wUserSigInfo, 7, new bm.c() { // from class: com.tencent.mobileqq.login.au
                @Override // com.tencent.mobileqq.widget.bm.c
                public final void a(Object obj) {
                    PhonePasswordLoginMainline.this.lambda$showMultiAccountDialog$0(fVar, list, obj);
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.av
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PhonePasswordLoginMainline.f.this.onCancel();
                }
            });
            this.mMultiAccountDialogRef = new WeakReference<>(a16);
            if (a16 == null) {
                showToast(BaseApplication.getContext().getString(R.string.c68));
                fVar.onCancel();
                return;
            }
            hideLoading(false);
            a16.show();
            this.mHasMultiAccountShown = true;
            String valueOf = String.valueOf(list.size());
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            reportEvent("0X800C4B2", 0, valueOf, str, "", "");
            return;
        }
        QLog.e(TAG, 1, "activity == null || activity.isFinishing()");
        fVar.onCancel();
    }

    private void showToast(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.as
            @Override // java.lang.Runnable
            public final void run() {
                PhonePasswordLoginMainline.lambda$showToast$3(str);
            }
        });
    }

    public void startPuzzleVerify(PuzzleVerifyInfo puzzleVerifyInfo) {
        if (puzzleVerifyInfo == null) {
            QLog.e(TAG, 1, "puzzleVerifyInfo is null");
            onLoginFailed(new aj(-1, "puzzleVerifyInfo is null"));
            return;
        }
        reportEvent("0X800C383", 0, "", "", "", "");
        this.mHasPuzzleVerify = true;
        PuzzleVerifyComponent puzzleVerifyComponent = new PuzzleVerifyComponent();
        String str = puzzleVerifyInfo.D;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "PuzzleVerify verifyUrl=" + str);
        }
        puzzleVerifyComponent.d(5, str, new a(parseSidFromPuzzleVerifyUrl(str)));
    }

    @Override // com.tencent.mobileqq.login.k
    protected String getReportUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return ((ay) this.mLoginParams).f241929f;
    }

    public void getSaltUinList(String str, String str2, byte[] bArr, String str3, String str4, String str5, com.tencent.mobileqq.loginregister.servlet.h hVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, bArr, str3, str4, str5, hVar);
            return;
        }
        NewIntent newIntent = new NewIntent(getContext(), com.tencent.mobileqq.loginregister.servlet.i.class);
        newIntent.putExtra("action", WnsError.WNS_CODE_DIS_STAT_BEGIN);
        if (((ay) this.mLoginParams).f242203d) {
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            j3 = 16;
        }
        newIntent.putExtra("appid", j3);
        newIntent.putExtra("subappid", AppSetting.f());
        newIntent.putExtra(NotificationActivity.PASSWORD, bArr);
        int stringToInt = NumberUtil.stringToInt(str2, 86);
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        GatewayVerify$ReqCommonInfo gatewayVerify$ReqCommonInfo = new GatewayVerify$ReqCommonInfo();
        gatewayVerify$ReqCommonInfo.bool_req_support_diff_passwd_can_verify.set(true);
        gatewayVerify$ReqCommonInfo.bool_req_passwd_err_support_identity_verify.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.set(gatewayVerify$ReqCommonInfo);
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(false);
        GatewayVerify$ReqCmd4 gatewayVerify$ReqCmd4 = new GatewayVerify$ReqCmd4();
        gatewayVerify$ReqCmd4.uint32_country_code.set(stringToInt);
        gatewayVerify$ReqBody.msg_req_cmd_4.set(gatewayVerify$ReqCmd4);
        GatewayVerify$ReqCmd24 gatewayVerify$ReqCmd24 = new GatewayVerify$ReqCmd24();
        gatewayVerify$ReqCmd24.str_mobile_phone.set(str);
        gatewayVerify$ReqCmd24.uint32_country_code.set(stringToInt);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            GatewayVerify$WaterprofWallInfo gatewayVerify$WaterprofWallInfo = new GatewayVerify$WaterprofWallInfo();
            gatewayVerify$WaterprofWallInfo.str_waterprof_wall_sig.set(str3);
            gatewayVerify$WaterprofWallInfo.iframe_randstr.set(str4);
            gatewayVerify$WaterprofWallInfo.iframe_sid.set(str5);
            gatewayVerify$ReqCmd24.waterprof_wall_info.set(gatewayVerify$WaterprofWallInfo);
            newIntent.putExtra("needPuzzleVerify", false);
        } else {
            newIntent.putExtra("needPuzzleVerify", true);
        }
        gatewayVerify$ReqBody.msg_req_cmd_24.set(gatewayVerify$ReqCmd24);
        gatewayVerify$ReqBody.setHasFlag(true);
        newIntent.putExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542, gatewayVerify$ReqBody.toByteArray());
        newIntent.setObserver(hVar);
        newIntent.withouLogin = true;
        getAppRuntime().startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onActivityDestroy();
        if (isMultiAccountDialogShowing() && !this.mIsLoginByUinTokenNow) {
            onLoginCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        reportEvent("0X800C388", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginCancel");
        runOnUiThread(new ar(this));
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginFailed(@NonNull final aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ajVar);
            return;
        }
        int i3 = ajVar.f241864a;
        reportEvent("0X800C388", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(i3), getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginFailed ret=" + i3 + " msg=" + ajVar.f241866c);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.at
            @Override // java.lang.Runnable
            public final void run() {
                PhonePasswordLoginMainline.this.lambda$onLoginFailed$2(ajVar);
            }
        });
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
        super.onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginSuccess(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (!checkBeforeLoginSuccess(str, bundle)) {
            return;
        }
        reportEvent("0X800C388", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(str));
        com.tencent.mobileqq.login.account.d.f241848a.b(str, Marker.ANY_NON_NULL_MARKER + ((ay) this.mLoginParams).f241930g + " " + ((ay) this.mLoginParams).f241929f, 7);
        if (!TextUtils.isEmpty(str)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + str, ((ay) this.mLoginParams).f241929f);
        }
        ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportLoginSuccess(getAppRuntime(), Integer.valueOf(((ay) this.mLoginParams).f242201b), ((ay) this.mLoginParams).f241929f);
        runOnUiThread(new ar(this));
        bundle.putString("last_account", str);
        bundle.putBoolean("fromLoginPhoneNum", true);
        super.onLoginSuccess(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onReLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onReLogin();
            loginByToken();
        }
    }

    String parseSidFromPuzzleVerifyUrl(String str) {
        return URLUtil.getString(URLUtil.getArgumentsFromURL(str), "sid");
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start phone password login loginScene=" + ((ay) this.mLoginParams).f242201b + " phoneNum=" + ((ay) this.mLoginParams).f241929f);
        QuestionnaireForLoginManager.i("phone_num_pwd_login");
        QuestionnaireForLoginManager.h(8);
        this.mHasPuzzleVerify = false;
        this.mHasDevLockVerify = false;
        this.mHasMultiAccountShown = false;
        this.mIsLoginByUinTokenNow = false;
        T t16 = this.mLoginParams;
        getSaltUinList(((ay) t16).f241929f, ((ay) t16).f241930g, ((ay) t16).f241932i, null, null, null, this.mLoginObserver);
        reportEvent("0X800C382", 0, "", "", "", "");
    }
}
