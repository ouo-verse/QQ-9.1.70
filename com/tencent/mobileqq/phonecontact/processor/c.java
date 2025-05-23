package com.tencent.mobileqq.phonecontact.processor;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f258496a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void a(List<PhoneContact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "updateAddContactList");
        }
        MqqHandler handler = this.f258496a.getHandler(ContactListView.class);
        if (handler != null) {
            handler.removeMessages(4);
            Message obtainMessage = handler.obtainMessage(4);
            obtainMessage.obj = list;
            handler.sendMessageDelayed(obtainMessage, 100L);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "updateContactList");
        }
        MqqHandler handler = this.f258496a.getHandler(ContactListView.class);
        if (handler != null) {
            handler.removeMessages(1);
            handler.sendEmptyMessageDelayed(1, 100L);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f258496a.getPreferences().edit().putInt("system_msg_list_showcount", 0).putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void d(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else {
            this.f258496a = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "reloadContactList");
        }
        MqqHandler mqqHandler = (MqqHandler) ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getContactsInnerFrameHandler(this.f258496a);
        if (mqqHandler != null) {
            int contactsInnerFrame_RELOAD_CONTACTS_Value = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getContactsInnerFrame_RELOAD_CONTACTS_Value();
            mqqHandler.removeMessages(contactsInnerFrame_RELOAD_CONTACTS_Value);
            mqqHandler.sendEmptyMessageDelayed(contactsInnerFrame_RELOAD_CONTACTS_Value, 100L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021b  */
    @Override // com.tencent.mobileqq.phonecontact.processor.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(boolean z16, boolean z17, boolean z18, int i3, RespondQueryQQBindingStat respondQueryQQBindingStat, boolean z19, long j3) {
        boolean z26;
        Intent intent;
        String str;
        String str2;
        BaseActivity baseActivity;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), respondQueryQQBindingStat, Boolean.valueOf(z19), Long.valueOf(j3))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            if (respondQueryQQBindingStat != null) {
                j16 = respondQueryQQBindingStat.lastUsedFlag;
            } else {
                j16 = 0;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showBindPhonePage| fromNotBind: ");
            sb5.append(z16);
            sb5.append(", isFirstRun: ");
            sb5.append(z17);
            sb5.append(", needToJumpBind: ");
            z26 = z18;
            sb5.append(z26);
            sb5.append(", isAutoUpload: ");
            sb5.append(z19);
            sb5.append(", unbindGap: ");
            sb5.append(j3);
            sb5.append(", lastUsedFlag: ");
            sb5.append(j16);
            QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, sb5.toString());
        } else {
            z26 = z18;
        }
        BaseActivity baseActivity2 = BaseActivity.sTopActivity;
        if (!(baseActivity2 instanceof BindNumberActivity) && !(baseActivity2 instanceof BindVerifyActivity)) {
            if (z16) {
                if (i3 == 3 && respondQueryQQBindingStat != null && respondQueryQQBindingStat.lastUsedFlag == 3) {
                    intent = new Intent(this.f258496a.getApplicationContext(), (Class<?>) PhoneMatchActivity.class);
                    intent.putExtra("kSrouce", 16);
                    z26 = false;
                }
                intent = null;
            } else if (i3 != 6) {
                if (i3 == 7 && !z19 && respondQueryQQBindingStat != null && !respondQueryQQBindingStat.isStopFindMatch) {
                    intent = new Intent(this.f258496a.getApplicationContext(), (Class<?>) PhoneMatchActivity.class);
                    if (z17) {
                        intent.putExtra("key_from_contact_first", true);
                    }
                }
                intent = null;
            } else {
                if (respondQueryQQBindingStat != null && respondQueryQQBindingStat.lastUsedFlag == 3) {
                    intent = new Intent(this.f258496a.getApplicationContext(), (Class<?>) PhoneMatchActivity.class);
                }
                intent = null;
            }
            if (intent != null) {
                if (j3 < 3600000) {
                    QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "showBindPhonePage| < minGap, unbindGap: " + j3);
                    return false;
                }
                String className = intent.getComponent().getClassName();
                if (!TextUtils.isEmpty(className)) {
                    if (className.equals(BindNumberActivity.class.getName())) {
                        str = "0X80095EB";
                    } else if (className.equals(PhoneMatchActivity.class.getName())) {
                        str = "0X80095EA";
                    }
                    str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        ReportController.o(this.f258496a, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                    baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity == null && !baseActivity.isFinishing() && baseActivity.getAppRuntime() == this.f258496a) {
                        baseActivity.startActivity(intent);
                        baseActivity.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
                        SharedPreferences sharedPreferences = this.f258496a.getApp().getSharedPreferences(AppConstants.Preferences.CONTACT_BIND_INFO + this.f258496a.getAccount(), 0);
                        if (z16 && z26) {
                            sharedPreferences.edit().putString(AppConstants.Preferences.PHONE_VERSION_RUN_POPPED_NOTBIND, AppSetting.f99551k).apply();
                        } else if (!z16 && z17) {
                            sharedPreferences.edit().putString(AppConstants.Preferences.PHONE_VERSION_RUN_POPPED, AppSetting.f99551k).apply();
                        } else {
                            sharedPreferences.edit().putLong(AppConstants.Preferences.LAST_POPUP_MATCH_TIME_FOR_SWITCHPHONE, System.currentTimeMillis()).apply();
                        }
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "showBindPhonePage topActivity invalid");
                    }
                }
                str = "";
                str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                }
                baseActivity = BaseActivity.sTopActivity;
                if (baseActivity == null) {
                }
                if (QLog.isColorLevel()) {
                }
            }
            return false;
        }
        QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "showBindPhonePage " + BaseActivity.sTopActivity);
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public boolean g(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        if (z16) {
            if (UserguideActivity.G2(this.f258496a.getApp(), this.f258496a.getCurrentAccountUin())) {
                QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| showUserGuideThisTime");
                return false;
            }
            if (com.tencent.mobileqq.phonelogin.a.a().c()) {
                QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| isPhoneNumLogin");
                return false;
            }
            if (PortalManager.z()) {
                QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 1, "needShowBindPhonePage| forbid alert");
                return false;
            }
        }
        boolean z18 = ((LoginWelcomeManager) this.f258496a.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).f243075e;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && baseActivity.isFinishing()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.PhoneContactProcessor", 2, "needShowBindPhonePage| isBound: " + z16 + ", showNewUserGuide: " + z18 + ", sIsUserGuiderShowed: " + UserguideActivity.f177484d0 + ", topActivity: " + baseActivity + ", isFinishing: " + z17);
        }
        if (baseActivity == null || z17 || baseActivity.getAppRuntime() != this.f258496a) {
            return false;
        }
        if (!(baseActivity instanceof UserguideActivity) && !z18 && !UserguideActivity.f177484d0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().O(MobileUnityBannerProcessor.f185231d, 0, null);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            ((PhoneUnityManager) this.f258496a.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).f181279d = true;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void j(String str, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) jSONObject);
        } else {
            LoginUserGuideHelper.e(str, jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f258496a = null;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.processor.a
    public void refreshAppBadge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AppInterface appInterface = this.f258496a;
        if ((appInterface instanceof QQAppInterface) && appInterface.isLogin()) {
            AppInterface appInterface2 = this.f258496a;
            ((IAppBadgeService) appInterface2.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }
}
