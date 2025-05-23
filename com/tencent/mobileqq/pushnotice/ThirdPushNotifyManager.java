package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver;
import com.tencent.mobileqq.notification.modularize.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ThirdPushNotifyManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ThirdPushNotifyManager f261341c;

    /* renamed from: a, reason: collision with root package name */
    private PushNotificationData f261342a;

    /* renamed from: b, reason: collision with root package name */
    private List<b> f261343b;

    ThirdPushNotifyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f261343b = arrayList;
        arrayList.add(new a());
        this.f261343b.add(new f());
    }

    private boolean a() {
        PushNotificationData pushNotificationData = this.f261342a;
        if (pushNotificationData != null && !TextUtils.isEmpty(pushNotificationData.f261348i) && !TextUtils.isEmpty(this.f261342a.f261349m)) {
            return true;
        }
        QLog.e("ThirdPushNotifyManager", 1, "token or uin is empty!");
        return false;
    }

    private static void c(AppRuntime appRuntime, Context context, PushNotificationData pushNotificationData) {
        if (pushNotificationData == null) {
            QLog.w("ThirdPushNotifyManager", 1, "doAction: data is null");
            return;
        }
        if (TextUtils.isEmpty(pushNotificationData.f261346f)) {
            QLog.w("ThirdPushNotifyManager", 1, "doAction: data url is empty, type is " + pushNotificationData.f261345e);
            return;
        }
        String g16 = g(pushNotificationData.f261344d, appRuntime.getCurrentUin());
        if (appRuntime.getCurrentUin().equals(pushNotificationData.f261349m) && pushNotificationData.f261348i.equals(g16)) {
            int i3 = pushNotificationData.f261345e;
            if (i3 != 0) {
                if (i3 == 1) {
                    if (!(appRuntime instanceof BaseQQAppInterface)) {
                        QLog.w("ThirdPushNotifyManager", 1, "doAction: do nothing while current process is not main process");
                        return;
                    }
                    ax c16 = bi.c((BaseQQAppInterface) appRuntime, context, pushNotificationData.f261346f);
                    if (c16 != null) {
                        QLog.i("ThirdPushNotifyManager", 1, "doAction: do action with url " + pushNotificationData.f261346f);
                        c16.b();
                        return;
                    }
                    QLog.w("ThirdPushNotifyManager", 1, "doAction: jump action is null for url " + pushNotificationData.f261346f);
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", pushNotificationData.f261346f);
            QLog.i("ThirdPushNotifyManager", 1, "doAction: start activity with url " + pushNotificationData.f261346f);
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        QLog.w("ThirdPushNotifyManager", 1, "uin or token is not equal!");
    }

    public static ThirdPushNotifyManager d() {
        if (f261341c == null) {
            synchronized (ThirdPushNotifyManager.class) {
                if (f261341c == null) {
                    f261341c = new ThirdPushNotifyManager();
                }
            }
        }
        return f261341c;
    }

    private static MMKVOptionEntity e() {
        return QMMKV.from(BaseApplicationImpl.getApplication(), "common_mmkv_configurations");
    }

    private String f(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ThirdPushNotifyManager", 1, "getPushTokenFromArray: token is empty!");
            return "";
        }
        try {
            return new JSONArray(str).optString(0);
        } catch (JSONException e16) {
            QLog.e("ThirdPushNotifyManager", 1, "getPushTokenFromArray: exception", e16);
            return "";
        }
    }

    public static String g(int i3, String str) {
        return e().decodeString(h(i3, str), "");
    }

    private static String h(int i3, String str) {
        return "key_third_push_token_" + i3 + "_" + str;
    }

    private void j() {
        String str;
        if (TextUtils.isEmpty(this.f261342a.f261347h)) {
            QLog.i("ThirdPushNotifyManager", 1, "report: ignore reporting, report data is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f261342a.f261347h);
            String optString = jSONObject.optString("tianshu_ext");
            String optString2 = jSONObject.optString("trigger_info");
            if (TextUtils.isEmpty(optString2)) {
                str = "";
            } else {
                String str2 = "";
                for (String str3 : new JSONObject(optString2).optString("oac_triggle").split(ContainerUtils.FIELD_DELIMITER)) {
                    if (str3.contains("ad_id=")) {
                        str2 = str3.replace("ad_id=", "");
                    } else if (str3.contains("nid=")) {
                        String replace = str3.replace("nid=", "");
                        OnlineModulePushReceiver.Companion companion = OnlineModulePushReceiver.INSTANCE;
                        companion.o(companion.g(replace));
                    }
                }
                str = str2;
            }
            i.h(1, 1, str, optString2, "3");
            i.f254311a.d(RFWApplication.getAccountId(), 117, str, optString2, "3");
            QLog.i("ThirdPushNotifyManager", 1, "reportThirdPushClick:" + optString + "," + optString2 + ",pushId=" + str);
        } catch (JSONException e16) {
            QLog.e("ThirdPushNotifyManager", 1, "report: exception.", e16);
        }
    }

    public static void k(int i3, String str, String str2) {
        e().encodeString(h(i3, str), str2);
    }

    private boolean l(Context context) {
        if (SplashActivity.sWeakInstance != null && SplashActivity.sWeakInstance.get() != null) {
            return false;
        }
        RouteUtils.startActivity(context, new Intent(), RouterConstants.UI_ROUTER_SPLASH);
        return true;
    }

    public void b(AppRuntime appRuntime, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) context);
        } else {
            c(appRuntime, context, this.f261342a);
            this.f261342a = null;
        }
    }

    public boolean i(Context context, Intent intent, AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, intent, appRuntime)).booleanValue();
        }
        if (!AppSetting.isPublicVersion()) {
            QLog.e("ThirdPushNotifyManager", 1, "handlePushData,intent: " + intent.getExtras());
        }
        try {
            Iterator<b> it = this.f261343b.iterator();
            while (true) {
                if (it.hasNext()) {
                    b next = it.next();
                    if (next.a(intent)) {
                        PushNotificationData b16 = next.b(intent);
                        this.f261342a = b16;
                        b16.f261348i = f(b16.f261348i);
                        QLog.i("ThirdPushNotifyManager", 1, "handlePushData: data=" + this.f261342a);
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                QLog.i("ThirdPushNotifyManager", 1, "handlePushData: not from third push.");
                return false;
            }
            if (!a()) {
                QLog.i("ThirdPushNotifyManager", 1, "handlePushData: push data is not valid");
                this.f261342a = null;
                l(context);
                return true;
            }
            j();
            if (!l(context)) {
                QLog.i("ThirdPushNotifyManager", 2, "[handlePushData] do action now");
                b(appRuntime, context);
            } else {
                QLog.i("ThirdPushNotifyManager", 1, "[handlePushData]: start splash activity if not exists.");
            }
            return true;
        } catch (Exception e16) {
            this.f261342a = null;
            QLog.e("ThirdPushNotifyManager", 1, "handlePushData: exception.", e16);
            return true;
        }
    }

    /* loaded from: classes16.dex */
    public static class PushNotificationData implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<PushNotificationData> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        private int f261344d;

        /* renamed from: e, reason: collision with root package name */
        private int f261345e;

        /* renamed from: f, reason: collision with root package name */
        private String f261346f;

        /* renamed from: h, reason: collision with root package name */
        private String f261347h;

        /* renamed from: i, reason: collision with root package name */
        private String f261348i;

        /* renamed from: m, reason: collision with root package name */
        private String f261349m;

        /* loaded from: classes16.dex */
        class a implements Parcelable.Creator<PushNotificationData> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PushNotificationData createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (PushNotificationData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new PushNotificationData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public PushNotificationData[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (PushNotificationData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new PushNotificationData[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74317);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                CREATOR = new a();
            }
        }

        public PushNotificationData(int i3, int i16, String str, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, str4);
                return;
            }
            this.f261344d = i3;
            this.f261345e = i16;
            this.f261346f = str;
            this.f261347h = str2;
            this.f261348i = str3;
            this.f261349m = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 0;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "PushNotificationData{mThirdId=" + this.f261344d + ", mType=" + this.f261345e + ", mUrl='" + this.f261346f + "', mReportData='" + this.f261347h + "', mToken='" + this.f261348i + "', mToUin='" + this.f261349m + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeInt(this.f261344d);
            parcel.writeInt(this.f261345e);
            parcel.writeString(this.f261346f);
            parcel.writeString(this.f261347h);
            parcel.writeString(this.f261348i);
            parcel.writeString(this.f261349m);
        }

        protected PushNotificationData(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f261344d = parcel.readInt();
            this.f261345e = parcel.readInt();
            this.f261346f = parcel.readString();
            this.f261347h = parcel.readString();
            this.f261348i = parcel.readString();
            this.f261349m = parcel.readString();
        }
    }
}
