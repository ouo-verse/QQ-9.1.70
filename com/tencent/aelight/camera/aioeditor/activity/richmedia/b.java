package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f66416e;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f66417a;

    /* renamed from: b, reason: collision with root package name */
    private d f66418b;

    /* renamed from: c, reason: collision with root package name */
    private C0576b f66419c = new C0576b();

    /* renamed from: d, reason: collision with root package name */
    private Handler f66420d = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (QLog.isColorLevel()) {
                QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + message.what);
            }
            b.this.d(false, null, message.what);
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.activity.richmedia.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    private class C0576b extends jr.a {
        C0576b() {
        }

        @Override // jr.a
        public void c(int i3, boolean z16, ArrayList<String> arrayList) {
            if (QLog.isColorLevel()) {
                QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + z16 + " req:" + i3);
            }
            if (b.this.f66420d == null || !b.this.f66420d.hasMessages(i3)) {
                return;
            }
            b.this.d(z16, arrayList, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class c extends SosoInterfaceOnLocationListener {

        /* renamed from: a, reason: collision with root package name */
        private int f66423a;

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                double d16 = sosoLocation.mLat02;
                double d17 = sosoLocation.mLon02;
                if (QLog.isColorLevel()) {
                    QLog.d("LBSDetetor", 2, "onLocationUpdate() latitude=" + d16 + " longitude=" + d17);
                }
                b.this.f(d16, d17, this.f66423a);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
            }
            if (b.this.f66420d == null || !b.this.f66420d.hasMessages(this.f66423a)) {
                return;
            }
            b.this.d(false, null, this.f66423a);
        }

        public c(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str, int i16) {
            super(i3, z16, z17, j3, z18, z19, str);
            this.f66423a = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a(int i3, boolean z16, ArrayList<String> arrayList);

        void b(int i3, boolean z16);
    }

    b(AppInterface appInterface) {
        this.f66417a = appInterface;
        if (appInterface != null) {
            appInterface.registObserver(this.f66419c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z16, ArrayList<String> arrayList, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("LBSDetetor", 2, "callback. isSuccess: " + z16 + " cookie: " + i3);
        }
        this.f66420d.removeMessages(i3);
        if (this.f66418b != null) {
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
            }
            this.f66418b.a(i3, z16, arrayList);
        }
    }

    public static b e(AppInterface appInterface) {
        if (f66416e == null) {
            f66416e = new b(appInterface);
        }
        return f66416e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(double d16, double d17, int i3) {
        if (this.f66417a == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.f66417a.getApp(), jr.b.class);
        newIntent.putExtra(AECameraConstants.KEY_LATITUDE, d16);
        newIntent.putExtra("key_longitude", d17);
        int i16 = 4;
        newIntent.putExtra("k_cmd", 4);
        newIntent.putExtra("key_lbs_template_cookie", i3);
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getBaseContext());
        int i17 = 1;
        if (systemNetwork != 0) {
            if (systemNetwork == 1) {
                i16 = 2;
            } else if (systemNetwork != 2) {
                i17 = 3;
                if (systemNetwork != 3) {
                    if (systemNetwork != 4) {
                        i16 = 0;
                    }
                }
            } else {
                i16 = 5;
            }
            newIntent.putExtra("key_lbs_template_network_type", i16);
            this.f66417a.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                return;
            }
            QLog.d("LBSDetetor", 2, "getLBSTemplateIds. req:" + i3 + " netType:" + i16 + " latitude:" + d16 + " longitude:" + d17);
            return;
        }
        i16 = i17;
        newIntent.putExtra("key_lbs_template_network_type", i16);
        this.f66417a.startServlet(newIntent);
        if (QLog.isColorLevel()) {
        }
    }

    public void g(d dVar) {
        this.f66418b = dVar;
    }

    public void h(int i3) {
        boolean z16 = true;
        try {
            Context baseContext = BaseApplicationImpl.getApplication().getBaseContext();
            AppOpsManager appOpsManager = (AppOpsManager) baseContext.getSystemService("appops");
            ApplicationInfo applicationInfo = baseContext.getApplicationInfo();
            int checkOpNoThrow = appOpsManager.checkOpNoThrow("android:fine_location", applicationInfo.uid, applicationInfo.packageName);
            int checkOpNoThrow2 = appOpsManager.checkOpNoThrow("android:coarse_location", applicationInfo.uid, applicationInfo.packageName);
            if (checkOpNoThrow != 0 || checkOpNoThrow2 != 0) {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LBSDetetor", 2, "check permission by AppOpsManager:" + z16);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("LBSDetetor", 2, "something wrong:" + e16.toString());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LBSDetetor", 2, "startCheckPermissionAndDetetLocation. hasPermission:" + z16);
        }
        this.f66420d.removeMessages(i3);
        if (z16) {
            this.f66420d.sendEmptyMessageDelayed(i3, 30000L);
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new c(0, true, true, 30000L, false, false, "NewFlowCameraActivity", i3));
        }
        d dVar = this.f66418b;
        if (dVar != null) {
            dVar.b(i3, z16);
        }
    }
}
