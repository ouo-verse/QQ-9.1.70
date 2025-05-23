package com.tencent.qidian.api.impl;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianManagerApiImpl implements IQidianManagerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QidianManagerApiImpl";
    private QQAppInterface app;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IQidianManagerApi.a f342804f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AppInterface f342805h;

        a(IQidianManagerApi.a aVar, AppInterface appInterface) {
            this.f342804f = aVar;
            this.f342805h = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianManagerApiImpl.this, aVar, appInterface);
            }
        }

        @Override // com.tencent.qidian.controller.a
        protected void l(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
            } else {
                this.f342804f.a(z16, hashMap);
                this.f342805h.removeObserver(this);
            }
        }
    }

    public QidianManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void addQidianShareAction(Context context, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) arrayList);
        } else {
            QidianManager.g(context, arrayList);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void addShowUin(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
        } else {
            QidianManager.h(this.app, str, str2);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void clearQidianCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qidian.api.impl.QidianManagerApiImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianManagerApiImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit().remove("sp_c2b_tip_uins_shown").commit();
                        PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().remove("eqq-config-data").commit();
                        SharedPreferencesProxyManager.getInstance().getProxy(QidianManagerApiImpl.this.app.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit().clear().commit();
                    } catch (Exception e16) {
                        QLog.e(QidianManagerApiImpl.TAG, 1, "clear qidian cache error", e16.getMessage());
                        e16.printStackTrace();
                    }
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean filterQidianMasterSearch(Friends friends, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) friends, i3)).booleanValue();
        }
        return QidianManager.l(this.app, friends, i3);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public String getShowUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return QidianManager.w(this.app, str);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isCrmMaster(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        return QidianManager.E(i3);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isCrmMasterUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && str != null) {
            return QidianManager.F(qQAppInterface, str);
        }
        return false;
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isEmanMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return QidianManager.H(this.app, messageRecord);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isNeedClickReply(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, str2, str3)).booleanValue();
        }
        return QidianManager.I(str, str2, str3);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isQidianAio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return QidianManager.J(this.app, str);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isQidianExt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        return QidianManager.K(i3);
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isQidianMaster(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? QidianManager.P(this.app, str) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appRuntime);
        } else {
            this.app = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void requestQidianTroopShareInfo(AppInterface appInterface, String str, String str2, IQidianManagerApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appInterface, str, str2, aVar);
        } else {
            appInterface.addObserver(new a(aVar, appInterface));
            ((QidianHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).M2(str, str2);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void shareToQidianOrQiye(Activity activity, int i3, String str, String str2, String str3, String str4, String str5, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, activity, Integer.valueOf(i3), str, str2, str3, str4, str5, Integer.valueOf(i16), Boolean.valueOf(z16));
        } else {
            QidianManager.i0(activity, i3, str, str2, str3, str4, str5, i16, z16);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void updateQidianAccountType(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            QidianManager.n0(this.app, friends);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) friends);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public boolean isQidianMaster(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? QidianManager.O(i3) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void updateQidianAccountType(Friends[] friendsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            QidianManager.p0(this.app, friendsArr);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) friendsArr);
        }
    }

    @Override // com.tencent.qidian.api.IQidianManagerApi
    public void updateQidianAccountType(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            QidianManager.m0(this.app, i3, str);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) str);
        }
    }
}
