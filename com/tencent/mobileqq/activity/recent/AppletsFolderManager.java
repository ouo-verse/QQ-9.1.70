package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.data.AppletInfo;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppletsFolderManager implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static int H;
    private DBDelayManager C;
    private volatile boolean D;
    private long E;
    private com.tencent.mobileqq.applets.a F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private ad f185099d;

    /* renamed from: e, reason: collision with root package name */
    private String f185100e;

    /* renamed from: f, reason: collision with root package name */
    private int f185101f;

    /* renamed from: h, reason: collision with root package name */
    private AppletsHandler f185102h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f185103i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.app.asyncdb.cache.a f185104m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.applets.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppletsFolderManager.this);
            }
        }

        @Override // com.tencent.mobileqq.applets.a
        protected void onGetAppletsDetail(boolean z16, List<AppletsAccountInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            if (z16 && list != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(com.tencent.mobileqq.applets.a.TAG, 2, "onGetAppletsDetail:  isSuccess: " + z16 + ", data.size = " + list.size());
                }
                AppletsFolderManager.this.f185099d.obtainMessage(2, 0, 0, list).sendToTarget();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            H = -1;
        }
    }

    @Deprecated
    public AppletsFolderManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = false;
        this.F = new a();
        this.G = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public static AppletInfo h(byte[] bArr) {
        ObjectInputStream objectInputStream;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                } catch (IOException e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (ClassNotFoundException e17) {
                    e = e17;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bArr = 0;
                    if (bArr != 0) {
                        try {
                            bArr.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof AppletInfo) {
                        AppletInfo appletInfo = (AppletInfo) readObject;
                        try {
                            objectInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                        return appletInfo;
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    return null;
                } catch (IOException e27) {
                    e = e27;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                } catch (ClassNotFoundException e28) {
                    e = e28;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                }
            } catch (IOException e29) {
                e29.printStackTrace();
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private QQAppInterface p() {
        QQAppInterface qQAppInterface = this.f185103i;
        if (qQAppInterface == null) {
            try {
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                if (application != null) {
                    AppRuntime runtime = application.getRuntime();
                    if (runtime instanceof QQAppInterface) {
                        qQAppInterface = (QQAppInterface) runtime;
                    }
                }
            } catch (Throwable th5) {
                QLog.e("AppletsFolderManager", 2, "getQQAppInterface error!: ", th5);
            }
        }
        if (qQAppInterface == null) {
            QLog.e("AppletsFolderManager", 2, "getQQAppInterface error: return null!");
        }
        return qQAppInterface;
    }

    private SharedPreferences q() {
        try {
            QQAppInterface p16 = p();
            if (p16 == null) {
                return null;
            }
            return QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(p16.getApp(), "AppletsFolderManager" + p16.getCurrentAccountUin(), 0);
        } catch (Throwable th5) {
            QLog.e("AppletsFolderManager", 2, "getSharedPreferences error!: ", th5);
            return null;
        }
    }

    public static boolean r(String str) {
        if (TextUtils.equals(str, QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_APPLETS_UIN, QzoneConfig.DEFAULT_APPLETS_UIN))) {
            return s(false);
        }
        return true;
    }

    public static boolean s(boolean z16) {
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:52), block:B:38:0x0033 */
    public static byte[] u(AppletInfo appletInfo) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream3 = null;
        try {
            if (appletInfo == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e16) {
                e = e16;
                objectOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                if (objectOutputStream3 != null) {
                    try {
                        objectOutputStream3.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                objectOutputStream2.writeObject(appletInfo);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return byteArray;
            } catch (IOException e19) {
                e = e19;
                e.printStackTrace();
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            objectOutputStream3 = objectOutputStream;
        }
    }

    public void A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        q16.edit().putString("applets_app_list_des", str).apply();
    }

    public void B(Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) set);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        if (set != null && set.size() >= 1) {
            q16.edit().putStringSet("applets_app_list_unreceive_msg_appids", set).apply();
        } else {
            q16.edit().remove("applets_app_list_unreceive_msg_appids").apply();
        }
        if (QLog.isColorLevel()) {
            QLog.i("AppletsFolderManager", 2, "updateAppletsSettingUnReceiveMsgAppids: " + set);
        }
    }

    public void e(AppletsAccountInfo appletsAccountInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appletsAccountInfo);
            return;
        }
        if (appletsAccountInfo != null) {
            appletsAccountInfo.appInfoDetail = u(appletsAccountInfo.appInfo);
            this.f185104m.d(appletsAccountInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletsFolderManager", 2, "putAppletAccountInfo: " + appletsAccountInfo);
        }
    }

    public void f(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recentUser);
        } else if (recentUser != null) {
            this.f185099d.obtainMessage(3, 0, 0, recentUser.uin).sendToTarget();
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Set<String> o16 = o();
        if (o16 == null) {
            o16 = new HashSet<>();
        }
        if (QLog.isColorLevel()) {
            QLog.i("AppletsFolderManager", 2, "addAppletsSettingUnReceiveMsgAppid: " + str);
        }
        o16.add(str);
        B(o16);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    String str = (String) message.obj;
                    if (!this.D) {
                        this.f185104m.b();
                        this.D = true;
                    }
                    if (j(str) == null || this.E + this.f185101f <= NetConnInfoCenter.getServerTime()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(str));
                        this.f185102h.G2(arrayList);
                        w(NetConnInfoCenter.getServerTime());
                    }
                }
            } else {
                Iterator it = ((List) message.obj).iterator();
                while (it.hasNext()) {
                    e((AppletsAccountInfo) it.next());
                }
            }
        } else {
            i();
        }
        return true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (!this.D) {
            this.f185104m.b();
            this.D = true;
        }
    }

    public AppletsAccountInfo j(String str) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AppletsAccountInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        AppletsAccountInfo c16 = this.f185104m.c(str);
        if (c16 != null && (bArr = c16.appInfoDetail) != null) {
            c16.appInfo = h(bArr);
        }
        return c16;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        this.f185100e = q16.getString("applets_detail_request_answer", "");
        this.f185101f = q16.getInt("applets_detail_request_duration", 0);
        this.E = q16.getLong("applets_detail_last_request_time", 0L);
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return "";
        }
        return q16.getString("applets_main_des", "");
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return "";
        }
        return q16.getString("applets_main_title", "");
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return "";
        }
        return q16.getString("applets_app_list_des", "");
    }

    public Set<String> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Set) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return null;
        }
        Set<String> stringSet = q16.getStringSet("applets_app_list_unreceive_msg_appids", null);
        if (QLog.isColorLevel()) {
            QLog.i("AppletsFolderManager", 2, "getAppletsSettingUnReceiveMsgAppids: " + stringSet);
        }
        return stringSet;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletsFolderManager", 2, "onDestroy.");
        }
        H = -1;
        this.f185099d.removeCallbacksAndMessages(null);
        DBDelayManager dBDelayManager = this.C;
        if (dBDelayManager != null) {
            dBDelayManager.onDestroy();
        }
        QQAppInterface qQAppInterface = this.f185103i;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.F);
        }
        com.tencent.mobileqq.app.asyncdb.cache.a aVar = this.f185104m;
        if (aVar != null) {
            aVar.a();
        }
        this.f185103i = null;
    }

    public void t(String str) {
        Set<String> o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && (o16 = o()) != null && o16.size() >= 1) {
            if (QLog.isColorLevel()) {
                QLog.i("AppletsFolderManager", 2, "removeAppletsSettingUnReceiveMsgAppid: " + str);
            }
            if (o16.remove(str)) {
                B(o16);
            }
        }
    }

    public void v(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, context, str, str2);
            return;
        }
        QQAppInterface p16 = p();
        if (p16 == null) {
            return;
        }
        p16.runOnUiThread(new Runnable(context, str, str2) { // from class: com.tencent.mobileqq.activity.recent.AppletsFolderManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f185105d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f185106e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f185107f;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.recent.AppletsFolderManager$2$a */
            /* loaded from: classes10.dex */
            class a implements ActionSheet.OnDismissListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // com.tencent.widget.ActionSheet.OnDismissListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AppletsFolderManager.this.G = false;
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.recent.AppletsFolderManager$2$b */
            /* loaded from: classes10.dex */
            class b implements ActionSheet.OnButtonClickListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ActionSheet f185109d;

                b(ActionSheet actionSheet) {
                    this.f185109d = actionSheet;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) actionSheet);
                    }
                }

                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                        return;
                    }
                    if (!AppletsFolderManager.this.G) {
                        AppletsFolderManager.this.G = true;
                        if (i3 == 0) {
                            ArrayList<AppletItem> arrayList = new ArrayList<>();
                            AppletItem.b bVar = new AppletItem.b();
                            bVar.c(Integer.valueOf(AnonymousClass2.this.f185106e).intValue());
                            bVar.e(Integer.valueOf(AnonymousClass2.this.f185107f).intValue());
                            bVar.f(0);
                            arrayList.add(bVar.a());
                            AppletsFolderManager.this.f185102h.U2(arrayList);
                            QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.jnu), 0).show();
                        }
                        this.f185109d.dismiss();
                    }
                }
            }

            {
                this.f185105d = context;
                this.f185106e = str;
                this.f185107f = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AppletsFolderManager.this, context, str, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ActionSheet create = ActionSheet.create(this.f185105d);
                create.setMainTitle(this.f185105d.getString(R.string.f170406pg));
                create.addButton(R.string.f170407ph, 3);
                create.addCancelButton(R.string.cancel);
                create.setOnDismissListener(new a());
                create.setOnButtonClickListener(new b(create));
                if (!create.isShowing()) {
                    AppletsFolderManager.this.G = false;
                    create.show();
                }
            }
        });
    }

    public void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        this.E = j3;
        q16.edit().putLong("applets_detail_last_request_time", j3).apply();
    }

    public void x(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        this.f185101f = i3;
        this.f185100e = str;
        q16.edit().putString("applets_detail_request_answer", str).putInt("applets_detail_request_duration", this.f185101f).apply();
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        q16.edit().putString("applets_main_des", str).apply();
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        SharedPreferences q16 = q();
        if (q16 == null) {
            return;
        }
        q16.edit().putString("applets_main_title", str).apply();
    }

    public AppletsFolderManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.D = false;
        this.F = new a();
        this.G = false;
        this.f185103i = qQAppInterface;
        DBDelayManager dBDelayManager = new DBDelayManager(qQAppInterface);
        this.C = dBDelayManager;
        dBDelayManager.start();
        this.f185102h = (AppletsHandler) this.f185103i.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        this.f185104m = new com.tencent.mobileqq.app.asyncdb.cache.a(this.f185103i, this.C);
        ad adVar = new ad(ThreadManagerV2.getSubThreadLooper(), this);
        this.f185099d = adVar;
        adVar.sendEmptyMessage(1);
        this.f185103i.addObserver(this.F);
        k();
        s(true);
    }
}
