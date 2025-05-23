package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class PluginCrashReceiver extends BroadcastReceiver {

    /* loaded from: classes28.dex */
    static class a extends AsyncTask<String, String, String> {

        /* renamed from: b, reason: collision with root package name */
        private static boolean f390225b = false;

        /* renamed from: a, reason: collision with root package name */
        private Context f390226a;

        public a(Context context) {
            this.f390226a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        
            if (r4 == null) goto L19;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(String... strArr) {
            BufferedReader bufferedReader;
            if (f390225b) {
                return "";
            }
            f390225b = true;
            try {
                StringBuilder sb5 = new StringBuilder();
                ProcessBuilder processBuilder = new ProcessBuilder("ls", "-l", this.f390226a.getDir("plugins", 0).getPath());
                processBuilder.redirectErrorStream(true);
                bufferedReader = new BufferedReader(new InputStreamReader(processBuilder.start().getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains("plugins")) {
                            sb5.append(readLine);
                            sb5.append("\n");
                        }
                    } catch (Throwable unused) {
                    }
                }
                QLog.d("plugin_tag", 1, "PluginDir: " + sb5.toString());
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
                return null;
            }
        }
    }

    /* loaded from: classes28.dex */
    static class b extends AsyncTask<String, String, String> {

        /* renamed from: a, reason: collision with root package name */
        private String f390227a;

        /* renamed from: b, reason: collision with root package name */
        private String f390228b;

        /* renamed from: c, reason: collision with root package name */
        private String f390229c;

        /* renamed from: d, reason: collision with root package name */
        private String f390230d;

        /* renamed from: e, reason: collision with root package name */
        private String f390231e;

        /* renamed from: f, reason: collision with root package name */
        private String f390232f;

        /* renamed from: g, reason: collision with root package name */
        private IStatisticsUploader f390233g;

        public b(Intent intent) {
            this.f390227a = intent.getStringExtra(PluginStatic.PARAM_UIN);
            this.f390228b = intent.getStringExtra("pluginsdk_pluginName");
            this.f390229c = intent.getStringExtra("pluginsdk_pluginLocation");
            this.f390230d = intent.getStringExtra("pluginsdk_pluginpath");
            this.f390231e = intent.getStringExtra("pluginsdk_launchActivity");
            this.f390232f = intent.getStringExtra(PluginStatic.PARAM_EXTRA_INFO);
            String stringExtra = intent.getStringExtra("clsUploader");
            if (stringExtra != null) {
                try {
                    this.f390233g = (IStatisticsUploader) Class.forName(stringExtra).newInstance();
                } catch (Exception unused) {
                    this.f390233g = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            String str;
            long j3;
            if (this.f390233g != null && (str = this.f390232f) != null) {
                try {
                    if (str.contains("Resources$NotFoundException") || this.f390232f.contains("ResourcesNotFoundException") || this.f390232f.contains("ClassNotFoundException") || this.f390232f.contains("GetPackageInfoFailException")) {
                        String encodeFile = PluginStatic.encodeFile(this.f390230d);
                        if (this.f390230d != null) {
                            j3 = new File(this.f390230d).length();
                        } else {
                            j3 = 0;
                        }
                        this.f390232f = "ApkMd5:" + encodeFile + "__FileSize:" + j3 + "__" + this.f390232f;
                    }
                    this.f390233g.uploadStartupFailure(BaseApplication.getContext(), this.f390227a, this.f390228b, this.f390229c, this.f390231e, this.f390232f);
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return "";
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        "com.tencent.mobileqq.ACTION_PLUGIN_CRASH".equals(action);
        try {
            if ("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED".equals(action)) {
                new b(intent).execute("");
            } else if (PluginProxyActivity.ACTION_PLUGIN_DIR_INFO_LOG.equals(action)) {
                new a(context).execute("");
            } else {
                if ("com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED".equals(action)) {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime instanceof QQAppInterface) {
                        String stringExtra = intent.getStringExtra("plugin");
                        String stringExtra2 = intent.getStringExtra("process");
                        QLog.d("plugin_tag", 1, "receive installFailed " + stringExtra + ", " + stringExtra2);
                        if (!MobileQQ.PACKAGE_NAME.equals(stringExtra2)) {
                            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                            int i3 = QQManagerFactory.MGR_PLUGIN;
                            if (qQAppInterface.isCreateManager(i3)) {
                                ((IPluginManager) qQAppInterface.getManager(i3)).cancelInstall(stringExtra);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                PluginProxyActivity.ACTION_PLUGIN_STARTUP_SPEED_INFO.equals(action);
            }
        } catch (Throwable unused) {
        }
    }
}
