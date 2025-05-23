package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f390308d = {"qlink_plugin.apk"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f390309e = {PluginProxyActivity.READER_ID, IQQComicPluginUtil.COMIC_PLUGIN_ID, "Photoplus.apk"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f390310f = {"qqhotspot_plugin.apk"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f390311g = new String[0];

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f390312h = {PluginProxyActivity.READER_ID, IQQComicPluginUtil.COMIC_PLUGIN_ID};

    /* renamed from: i, reason: collision with root package name */
    private static final SimpleDateFormat f390313i = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);

    /* renamed from: a, reason: collision with root package name */
    private Context f390314a;

    /* renamed from: b, reason: collision with root package name */
    private IPluginManager f390315b;

    /* renamed from: c, reason: collision with root package name */
    private OnPluginInstallListener f390316c = new a();

    public h(Context context, IPluginManager iPluginManager, QQAppInterface qQAppInterface) {
        this.f390314a = context;
        this.f390315b = iPluginManager;
        f();
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        for (String str : f390308d) {
            arrayList.add(str);
        }
        if (NetworkUtil.isWifiEnabled(this.f390314a)) {
            for (String str2 : f390309e) {
                if (!str2.equals("Photoplus.apk") || !VersionUtils.isIceScreamSandwich()) {
                    arrayList.add(str2);
                }
            }
        }
        if (ah.k0() || FileUtils.getAvailableInnernalMemorySize() <= 1.048576E8f) {
            if (QLog.isColorLevel()) {
                QLog.d("PluginPreInstaller", 2, "plugins " + Arrays.toString(f390312h) + "filtered in low end phone");
            }
            for (String str3 : f390312h) {
                arrayList.remove(str3);
            }
        }
        return arrayList;
    }

    private int c(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f390314a);
        if (!f390313i.format(new Date()).equals(defaultSharedPreferences.getString("last_retry_day_" + str, ""))) {
            return 0;
        }
        return defaultSharedPreferences.getInt("today_retried_times_" + str, 0);
    }

    private int d(String str) {
        return PreferenceManager.getDefaultSharedPreferences(this.f390314a).getInt("total_retried_times_" + str, 0);
    }

    private void e(String str, int i3, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PluginPreInstaller", 4, "installPlugin plugin = " + str + ", totalTimes = " + i3 + ", todayTimes = " + i16);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f390314a).edit();
        String format = f390313i.format(new Date());
        edit.putInt("total_retried_times_" + str, i3 + 1);
        edit.putInt("today_retried_times_" + str, i16 + 1);
        edit.putString("last_retry_day_" + str, format);
        edit.commit();
        this.f390315b.y5(str, this.f390316c, true);
        if (IQQComicPluginUtil.COMIC_PLUGIN_ID.equals(str)) {
            ((IQQComicWebViewApi) QRoute.api(IQQComicWebViewApi.class)).updateOfflinePkgAsync(1, MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    private void f() {
        if (!PreferenceManager.getDefaultSharedPreferences(this.f390314a).getString("plugin_pre_install_qq_version", "").equals(ah.P())) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f390314a).edit();
            Iterator<String> it = b().iterator();
            while (it.hasNext()) {
                edit.remove("total_retried_times_" + it.next());
            }
            edit.commit();
        }
    }

    public synchronized void g() {
        int d16;
        int c16;
        for (String str : b()) {
            try {
                if (!this.f390315b.isPlugininstalled(str) && (d16 = d(str)) < 10 && (c16 = c(str)) < 2) {
                    e(str, d16, c16);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", e16);
                }
            }
        }
    }

    public synchronized void h() {
        if (AppNetConnInfo.isWifiConn()) {
            if (QLog.isColorLevel()) {
                QLog.e("PluginPreInstaller", 2, "preinstall start,wifi_reinstall_only.");
            }
            for (String str : f390311g) {
                try {
                    if (!this.f390315b.isPlugininstalled(str)) {
                        e(str, d(str), c(str));
                    } else if ("QQWifiPlugin.apk".equals(str)) {
                        Intent intent = new Intent("com.tencent.mobileqq.cooperation.plugin." + str);
                        intent.putExtra("plugin", str);
                        this.f390314a.sendBroadcast(intent);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", e16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements OnPluginInstallListener {
        a() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            if (PluginProxyActivity.READER_ID.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallError, pluginId = " + str + ", errorCode = " + i3);
                }
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, i3, "", "", "", "");
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + str);
            }
            if (IQQComicPluginUtil.COMIC_PLUGIN_ID.equals(str)) {
                ((IQQComicPluginUtil) QRoute.api(IQQComicPluginUtil.class)).loadComicModule(h.this.f390314a);
            }
            Intent intent = new Intent("com.tencent.mobileqq.cooperation.plugin." + str);
            intent.putExtra("plugin", str);
            h.this.f390314a.sendBroadcast(intent);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }
}
