package ox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f424401a;

    /* renamed from: b, reason: collision with root package name */
    public String f424402b;

    /* renamed from: c, reason: collision with root package name */
    public int f424403c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ox.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C10965a extends f {
        C10965a() {
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            if (gVar.f313006d == 0) {
                String string = gVar.h().getString("file_path");
                try {
                    File file = new File(string);
                    String readFileToString = FileUtils.readFileToString(file);
                    if (QLog.isColorLevel()) {
                        QLog.d("CommonConfigBase", 2, "onDone() content =  " + readFileToString + ", filePath = " + string);
                    }
                    file.delete();
                    a.this.m(readFileToString);
                    a.this.j(readFileToString);
                    return;
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(e16));
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + gVar.f313006d);
            }
        }
    }

    public a(Context context, String str) {
        this.f424401a = context;
        this.f424402b = str;
        this.f424403c = d(context, str);
        j(k());
    }

    public void a(Context context, String str) {
        g(context).edit().remove(str + "_" + e()).commit();
    }

    protected String b(ConfigurationService$Config configurationService$Config) {
        ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
        if (configurationService$Content.compress.get() == 1) {
            byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
            if (d16 != null) {
                try {
                    return new String(d16, "UTF-8");
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(e16));
                    }
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(e17));
                    }
                    System.gc();
                    try {
                        return new String(d16, "UTF-8");
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(th5));
                        }
                    }
                }
            }
            return null;
        }
        return configurationService$Content.content.get().toStringUtf8();
    }

    public abstract String c();

    public int d(Context context, String str) {
        return g(context).getInt(str + "_" + e(), 0);
    }

    public abstract String e();

    public String f() {
        return "more_config_url";
    }

    protected SharedPreferences g(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void h(AppInterface appInterface, ConfigurationService$Config configurationService$Config) {
        if (QLog.isColorLevel()) {
            QLog.d("CommonConfigBase", 2, "handleConfig type = " + configurationService$Config.type.get());
        }
        this.f424403c = d(this.f424401a, appInterface.getCurrentAccountUin());
        int i3 = configurationService$Config.version.get();
        if (this.f424403c == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("CommonConfigBase", 2, "handleConfig version code not changed .");
                return;
            }
            return;
        }
        n(this.f424401a, appInterface.getCurrentAccountUin(), i3);
        this.f424403c = i3;
        String l3 = l(appInterface, configurationService$Config);
        if (!TextUtils.isEmpty(l3)) {
            if (!i(appInterface, l3)) {
                m(l3);
                j(l3);
                return;
            }
            return;
        }
        m(l3);
        j(l3);
    }

    public boolean i(AppInterface appInterface, String str) {
        try {
            String optString = new JSONObject(str).optString(f(), "");
            if (TextUtils.isEmpty(optString) || !(appInterface instanceof QQAppInterface)) {
                return false;
            }
            h u16 = ((DownloaderFactory) ((QQAppInterface) appInterface).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
            String str2 = AppConstants.SDCARD_PATH + c() + ".tmp";
            g gVar = new g(optString, new File(str2));
            gVar.f313008f = 3;
            Bundle bundle = new Bundle();
            bundle.putString("file_path", str2);
            u16.startDownload(gVar, new C10965a(), bundle);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public abstract void j(String str);

    public String k() {
        return g(this.f424401a).getString(this.f424402b + "_" + c(), null);
    }

    public String l(AppInterface appInterface, ConfigurationService$Config configurationService$Config) {
        if (QLog.isColorLevel()) {
            QLog.d("CommonConfigBase", 2, "handleConfig type = " + configurationService$Config.type.get());
        }
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() >= 1 && configurationService$Config.msg_content_list.get(0) != null) {
            return b(configurationService$Config);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CommonConfigBase", 2, "handleQuickShotShareToStoryConfig data is null!!!");
        }
        a(this.f424401a, appInterface.getCurrentAccountUin());
        return null;
    }

    public void m(String str) {
        SharedPreferences g16 = g(this.f424401a);
        if (TextUtils.isEmpty(str)) {
            g16.edit().remove(this.f424402b + "_" + c());
            return;
        }
        g16.edit().putString(this.f424402b + "_" + c(), str).commit();
    }

    public void n(Context context, String str, int i3) {
        g(context).edit().putInt(str + "_" + e(), i3).commit();
    }
}
