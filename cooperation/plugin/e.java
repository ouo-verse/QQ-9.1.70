package cooperation.plugin;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(PluginUtils.CONFIG_FILE_EXTEND_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PluginInfo a(File file) {
        return (PluginInfo) PluginBaseInfoHelper.createFromFile(file, PluginInfo.class);
    }

    public static void b(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File pluginCfgFile = PluginUtils.getPluginCfgFile(file, str);
        if (pluginCfgFile.isFile() && pluginCfgFile.exists()) {
            pluginCfgFile.delete();
        }
    }

    public static File[] c(File file) {
        return file.listFiles(new a());
    }

    public static boolean d(File file) {
        return !IOUtil.contentEquals(new File(file, "PluginVersion.ini"), AppSetting.l());
    }

    public static boolean e(PluginInfo pluginInfo, Context context) {
        boolean z16;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (pluginInfo == null) {
            return false;
        }
        String[] strArr = pluginInfo.mProcesses;
        String str = "";
        if (strArr != null && strArr.length != 0 && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) != null) {
            z16 = false;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                int length = pluginInfo.mProcesses.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (TextUtils.equals(pluginInfo.mProcesses[i3], runningAppProcessInfo.processName)) {
                        str = pluginInfo.mProcesses[i3];
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            }
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str) && BaseApplicationImpl.useQIPCStart(str)) {
            z16 = QIPCServerHelper.getInstance().isModuleRunning(pluginInfo.mID);
        }
        int i16 = pluginInfo.mSubType;
        if (i16 == 1) {
            if (!z16 || !QShadow.getInstance().isPluginRunning(PluginIdUtil.convertQPluginId2QShadowId(pluginInfo.mID))) {
                return false;
            }
            return true;
        }
        if (i16 == 2) {
            if (!z16 || !com.tencent.mobileqq.app.compact.a.k().m(pluginInfo.mID)) {
                return false;
            }
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(PluginBaseInfo pluginBaseInfo, File file) {
        if (file.exists() && file.isFile()) {
            if (pluginBaseInfo.mLength > 0 && file.length() == pluginBaseInfo.mLength) {
                String encodeFile = PluginStatic.encodeFile(file.getPath());
                String str = pluginBaseInfo.mMD5;
                if (str != null && str.equals(encodeFile)) {
                    QLog.e("plugin_tag", 1, "isValidPluginFile md5 invalid:" + pluginBaseInfo.mMD5 + ", " + encodeFile);
                    return true;
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + pluginBaseInfo.mLength + ", " + file.length());
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("plugin_tag", 2, "isValidPluginFile file not exist");
        }
        return false;
    }

    public static void g(PluginInfo pluginInfo, File file) {
        try {
            File pluginCfgFile = PluginUtils.getPluginCfgFile(file, pluginInfo.mID);
            if (pluginCfgFile.isFile() && pluginCfgFile.exists()) {
                pluginCfgFile.delete();
                pluginCfgFile.createNewFile();
            }
            i(pluginCfgFile, pluginInfo);
        } catch (Exception unused) {
        }
    }

    public static void h(File file) {
        FileOutputStream fileOutputStream;
        Throwable th5;
        File file2 = new File(file, "PluginVersion.ini");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception unused) {
        } catch (Throwable th6) {
            fileOutputStream = null;
            th5 = th6;
        }
        try {
            fileOutputStream.write(AppSetting.l().getBytes());
            IOUtil.closeStream(fileOutputStream);
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            IOUtil.closeStream(fileOutputStream2);
        } catch (Throwable th7) {
            th5 = th7;
            IOUtil.closeStream(fileOutputStream);
            throw th5;
        }
    }

    private static boolean i(File file, PluginInfo pluginInfo) {
        FileOutputStream fileOutputStream = null;
        try {
            byte[] encode = PluginBaseInfoHelper.Base64Helper.encode(PluginBaseInfoHelper.PluginInfoParser.pluginToXML(pluginInfo).getBytes(), 0);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(encode);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException unused3) {
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
