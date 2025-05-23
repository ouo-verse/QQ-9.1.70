package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ck {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f195450a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f195451b;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f195452c;

    /* renamed from: d, reason: collision with root package name */
    private bh f195453d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ck.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-onReceive:" + hashCode() + ", action=" + action);
            }
            if (action.equals("com.tencent.mobileqq.addLbsObserver")) {
                if (ck.this.f195451b != null) {
                    ck.this.f195451b.addObserver(ck.this.f195453d);
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.removeLbsObserver")) {
                if (ck.this.f195451b != null) {
                    ck.this.f195451b.removeObserver(ck.this.f195453d);
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.getStreetViewUrl")) {
                if (ck.this.f195451b != null) {
                    ((LBSHandler) ck.this.f195451b.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).H2((int) (intent.getDoubleExtra("latitude", 0.0d) * 1000000.0d), (int) (intent.getDoubleExtra("longitude", 0.0d) * 1000000.0d));
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.unregisterReceiver")) {
                try {
                    ck.this.f195450a.unregisterReceiver(ck.this.f195452c);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("QQMapActivityProxy", 2, "mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + e16.toString());
                        return;
                    }
                    return;
                }
            }
            if (action.equals("com.tencent.mobileqq.getLbsShareSearch")) {
                int intExtra = intent.getIntExtra("latitude", 0);
                int intExtra2 = intent.getIntExtra("longitude", 0);
                int intExtra3 = intent.getIntExtra("coordinate", 0);
                String stringExtra = intent.getStringExtra("keyword");
                String stringExtra2 = intent.getStringExtra("category");
                int intExtra4 = intent.getIntExtra("page", 0);
                int intExtra5 = intent.getIntExtra("count", 0);
                int intExtra6 = intent.getIntExtra("requireMyLbs", 0);
                if (ck.this.f195451b != null) {
                    ((LBSHandler) ck.this.f195451b.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).E2(intExtra, intExtra2, intExtra3, stringExtra, stringExtra2, intExtra4, intExtra5, intExtra6);
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.getLbsShareShop")) {
                int intExtra7 = intent.getIntExtra("latitude", 0);
                int intExtra8 = intent.getIntExtra("longitude", 0);
                int intExtra9 = intent.getIntExtra("coordinate", 0);
                int intExtra10 = intent.getIntExtra("begin", 0);
                int intExtra11 = intent.getIntExtra("count", 0);
                if (ck.this.f195451b != null) {
                    ((LBSHandler) ck.this.f195451b.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).F2(intExtra7, intExtra8, intExtra9, intExtra10, intExtra11);
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.getShareShopDetail")) {
                String stringExtra3 = intent.getStringExtra("shop_id");
                if (!TextUtils.isEmpty(stringExtra3) && ck.this.f195451b != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(stringExtra3);
                    ((LBSHandler) ck.this.f195451b.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).G2(arrayList);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends bh {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ck.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bh
        protected void onGetLbsShareSearch(boolean z16, Object[] objArr) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mLbsObserver, onGetLbsShareSearch: isSuccess=");
                sb5.append(z16);
                sb5.append(", isDataNull=");
                if (objArr == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(", hashCode=");
                sb5.append(hashCode());
                QLog.d("QQMapActivityProxy", 2, sb5.toString());
            }
            if (objArr == null) {
                return;
            }
            ToServiceMsg toServiceMsg = (ToServiceMsg) objArr[0];
            byte[] bArr = (byte[]) objArr[1];
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.onGetLbsShareSearch");
            intent.putExtra("data", bArr);
            intent.putExtra("req", toServiceMsg.extraData.getBundle("req"));
            ck.this.f195450a.sendBroadcast(intent);
        }

        @Override // com.tencent.mobileqq.app.bh
        protected void onGetLbsShareShop(boolean z16, Object[] objArr) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mLbsObserver, onGetLbsShareShop: isSuccess=");
                sb5.append(z16);
                sb5.append(", isDataNull=");
                if (objArr == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(", hashCode=");
                sb5.append(hashCode());
                QLog.d("QQMapActivityProxy", 2, sb5.toString());
            }
            if (objArr == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.onGetLbsShareShop");
            intent.putExtra("data", (byte[]) objArr[1]);
            intent.putExtra("req", ((ToServiceMsg) objArr[0]).extraData.getBundle("req"));
            ck.this.f195450a.sendBroadcast(intent);
        }

        @Override // com.tencent.mobileqq.app.bh
        protected void onGetShareShopDetail(boolean z16, Object[] objArr) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mLbsObserver, onGetShareShopDetail: isSuccess=");
                sb5.append(z16);
                sb5.append(", isDataNull=");
                if (objArr == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(", hashCode=");
                sb5.append(hashCode());
                QLog.d("QQMapActivityProxy", 2, sb5.toString());
            }
            if (objArr == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.onGetShareShopDetail");
            intent.putExtra("data", (byte[]) objArr[1]);
            intent.putExtra("req", ((ToServiceMsg) objArr[0]).extraData.getBundle("req"));
            ck.this.f195450a.sendBroadcast(intent);
        }

        @Override // com.tencent.mobileqq.app.bh
        protected void onGetStreetViewUrl(boolean z16, byte[] bArr) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bArr);
                return;
            }
            if (z16 && bArr != null) {
                str = new String(bArr);
                ck.this.f195450a.sendBroadcast(new Intent().setAction("com.tencent.mobileqq.onGetStreetViewUrl").putExtra("streetViewUrl", str));
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQMapActivityProxy", 2, "mLbsObserver, onGetStreetViewUrl: isSuccess=" + z16 + ", hashCode=" + hashCode() + JefsClass.INDEX_URL + str);
            }
        }
    }

    public ck(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f195452c = new a();
        this.f195453d = new b();
        try {
            this.f195450a = BaseApplication.getContext();
            this.f195451b = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(str);
        } catch (AccountNotMatchException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQMapActivityProxy", 2, "AccountNotMatchException " + e16.toString());
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.addLbsObserver");
        intentFilter.addAction("com.tencent.mobileqq.removeLbsObserver");
        intentFilter.addAction("com.tencent.mobileqq.getStreetViewUrl");
        intentFilter.addAction("com.tencent.mobileqq.unregisterReceiver");
        intentFilter.addAction("com.tencent.mobileqq.getLbsShareSearch");
        intentFilter.addAction("com.tencent.mobileqq.getLbsShareShop");
        intentFilter.addAction("com.tencent.mobileqq.getShareShopDetail");
        this.f195450a.registerReceiver(this.f195452c, intentFilter);
        if (QLog.isColorLevel()) {
            QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-create, registerReceiver:" + hashCode() + ", " + this.f195452c.hashCode());
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQMapActivityProxy", 2, "onDestory,  hashCode=" + hashCode());
        }
        QQAppInterface qQAppInterface = this.f195451b;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f195453d);
        }
        try {
            this.f195450a.unregisterReceiver(this.f195452c);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("QQMapActivityProxy", 2, "onDestory, mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + e16.toString());
            }
        }
    }
}
