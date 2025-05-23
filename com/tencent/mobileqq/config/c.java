package com.tencent.mobileqq.config;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<String> f202855a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<b>> f202856b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f202857a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f202858b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f202859c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f202860d = "";

        /* renamed from: e, reason: collision with root package name */
        public boolean f202861e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f202862f = false;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, a aVar);
    }

    public c() {
        SparseArray<String> sparseArray = new SparseArray<>(10);
        this.f202855a = sparseArray;
        sparseArray.put(275, AppConstants.Preferences.CONFESS_CONFIG);
        sparseArray.put(com.tencent.luggage.wxa.rf.d.CTRL_INDEX, AppConstants.Preferences.CONTACT_TOP_ENTRY_CONFIG);
        sparseArray.put(326, AppConstants.Preferences.SOSOINTERFACE_CONFIG);
        sparseArray.put(369, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG);
        sparseArray.put(379, AppConstants.Preferences.QQSETTINGME_F2F_GUIDE_CONFIG);
        sparseArray.put(401, AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG);
        sparseArray.put(407, AppConstants.Preferences.HIDE_QQ_XMAN);
        sparseArray.put(405, AppConstants.Preferences.ADD_CONTACT_PAGE_PUBLIC_ACCOUNT_TAB_SWITCH);
        sparseArray.put(408, AppConstants.Preferences.SELECT_MEMBER_ENTRY_SWITCH);
        sparseArray.put(355, AppConstants.Preferences.TROOP_MEMBER_LIST_CONFIG);
        this.f202856b = new ConcurrentHashMap<>(10);
        for (int i3 = 0; i3 < this.f202855a.size(); i3++) {
            this.f202856b.put(this.f202855a.valueAt(i3), new CopyOnWriteArraySet<>());
        }
        a(AppConstants.Preferences.QQSETTINGME_F2F_GUIDE_CONFIG, new OnF2FConfigListener());
        a(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG, new ag());
    }

    public static String b(String str, String str2) {
        return ea.D(BaseApplicationImpl.getApplication(), str, str2);
    }

    private CopyOnWriteArraySet<b> c(String str) {
        if (TextUtils.isEmpty(str) || this.f202855a.indexOfValue(str) < 0) {
            return null;
        }
        return this.f202856b.get(str);
    }

    public boolean a(String str, b bVar) {
        CopyOnWriteArraySet<b> c16 = c(str);
        if (c16 != null) {
            return c16.add(bVar);
        }
        return false;
    }

    public void d(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config, int i3) {
        ConfigurationService$Content configurationService$Content;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.f202855a.get(i3);
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("CfgProcess", 2, String.format(" handleConfig tag is null ! config: %s", Integer.valueOf(i3)));
                return;
            }
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        BaseApplication app = qQAppInterface.getApp();
        a aVar = new a();
        aVar.f202858b = configurationService$Config.version.get();
        int F = ea.F(app, currentAccountUin, str);
        aVar.f202857a = F;
        if (aVar.f202858b == F) {
            if (QLog.isColorLevel()) {
                QLog.d("CfgProcess", 2, " handleConfig config version is the same. [tag: %s, version: %s]", str, Integer.valueOf(aVar.f202858b));
                return;
            }
            return;
        }
        aVar.f202859c = 0;
        if (configurationService$Config.msg_content_list.size() > 0) {
            configurationService$Content = configurationService$Config.msg_content_list.get(0);
            if (configurationService$Content == null) {
                i19 = -1;
            } else {
                i19 = configurationService$Content.task_id.get();
            }
            i16 = i19;
            if (QLog.isDebugVersion()) {
                QLog.d("CfgProcess", 2, " config task id " + i16);
            }
            if (configurationService$Content == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("CfgProcess", 2, " handleConfig content is null !");
                }
                aVar.f202859c = 1;
            } else if (configurationService$Content.compress.get() == 1) {
                byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                if (d16 != null) {
                    try {
                        aVar.f202860d = new String(d16, StandardCharsets.UTF_8);
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CfgProcess", 2, " handleConfig Throwable:" + th5.getMessage());
                        }
                        aVar.f202859c = 2;
                    }
                } else {
                    aVar.f202859c = 3;
                    if (QLog.isColorLevel()) {
                        QLog.d("CfgProcess", 2, " handleConfig inflateConfigString error!");
                    }
                }
            } else {
                aVar.f202860d = configurationService$Content.content.get().toStringUtf8();
            }
        } else {
            configurationService$Content = null;
            i16 = 0;
        }
        if (aVar.f202860d == null) {
            aVar.f202860d = "";
        }
        aVar.f202862f = true;
        aVar.f202861e = false;
        if (aVar.f202859c == 0) {
            try {
                com.tencent.mobileqq.utils.y.b(qQAppInterface, str, aVar, i16);
            } catch (Throwable th6) {
                th6.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("CfgProcess", 2, "handleConfig call save individual fail:  " + str);
                }
            }
            if (!aVar.f202861e) {
                ea.L3(app, currentAccountUin, str, aVar.f202860d);
            } else if (QLog.isColorLevel()) {
                QLog.i("CfgProcess", 2, "handleConfig self save config tag: " + str);
            }
            CopyOnWriteArraySet<b> c16 = c(str);
            if (c16 != null && c16.size() > 0) {
                Iterator<b> it = c16.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onGetConfig(qQAppInterface, i3, str, aVar);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.i("CfgProcess", 2, "handleConfig OnGetConfigListener fail:  " + str);
                        }
                    }
                }
            }
        }
        if (aVar.f202862f) {
            i17 = aVar.f202858b;
        } else {
            i17 = 0;
        }
        ea.M3(app, currentAccountUin, str, i17);
        if (QLog.isColorLevel()) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(aVar.f202857a);
            objArr[3] = Integer.valueOf(aVar.f202858b);
            objArr[4] = Integer.valueOf(aVar.f202859c);
            if (configurationService$Content == null) {
                i18 = 0;
            } else {
                i18 = configurationService$Content.task_id.get();
            }
            objArr[5] = Integer.valueOf(i18);
            objArr[6] = aVar.f202860d;
            QLog.i("CfgProcess", 2, String.format(locale, "handleConfigForTag  configId: %s, tag: %s, localVersion: %s, version: %s, result: %s, task_id:%s, strContent: %s", objArr));
        }
    }

    public void e(QQAppInterface qQAppInterface, int i3, boolean z16, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigFail [id: %s, tag: %s, isSuc: %s, result: %s]", Integer.valueOf(i3), this.f202855a.get(i3), Boolean.valueOf(z16), Integer.valueOf(i16)));
        }
    }

    public void f(ConfigurationService$ConfigSeq configurationService$ConfigSeq, QQAppInterface qQAppInterface, int i3) {
        int F;
        String str = this.f202855a.get(i3);
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion tag is null, configId: %s", Integer.valueOf(i3)));
                return;
            }
            return;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        BaseApplication app = qQAppInterface.getApp();
        if (ea.C(app, currentUin, str) != AppSetting.f()) {
            ea.K3(app, currentUin, str, AppSetting.f());
            ea.M3(app, currentUin, str, 0);
            configurationService$ConfigSeq.version.set(0);
            F = 0;
        } else {
            F = ea.F(app, currentUin, str);
            configurationService$ConfigSeq.version.set(F);
        }
        configurationService$ConfigSeq.compress.set(1);
        if (QLog.isColorLevel()) {
            QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion [id: %s, tag: %s, version: %s]", Integer.valueOf(i3), str, Integer.valueOf(F)));
        }
    }

    public void g() {
        this.f202856b.clear();
        this.f202855a.clear();
    }

    public boolean h(b bVar) {
        Iterator<CopyOnWriteArraySet<b>> it = this.f202856b.values().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= it.next().remove(bVar);
        }
        return z16;
    }

    public boolean i(String str, b bVar) {
        CopyOnWriteArraySet<b> c16 = c(str);
        if (c16 != null) {
            return c16.remove(bVar);
        }
        return false;
    }
}
