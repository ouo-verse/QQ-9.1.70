package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class UnpackManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final File f114781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpackManager(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
            return;
        }
        File file2 = new File(file, "UnpackedPlugin");
        this.f114781a = file2;
        file2.mkdirs();
    }

    private static boolean d(File file) {
        return new File(file, InstalledPlugin.PLUGIN_LAUNCH_FAILED_TAG).exists();
    }

    private static File e(File file) {
        return new File(file.getParentFile(), "unpacked." + file.getName());
    }

    private static InstalledPlugin f(File file) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file, "config.json"))));
        StringBuilder sb5 = new StringBuilder("");
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
                sb5.append("\n");
            } catch (Throwable th5) {
                bufferedReader.close();
                throw th5;
            }
        }
        bufferedReader.close();
        JSONObject jSONObject = new JSONObject(sb5.toString());
        String string = jSONObject.getString(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_LOADER_VERSION);
        String string2 = jSONObject.getString(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_CONTAINER_VERSION);
        String string3 = jSONObject.getString(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_LOADER_PATH);
        String string4 = jSONObject.getString(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_LOADER_CLASSNAME);
        JSONArray jSONArray = jSONObject.getJSONArray(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES);
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = jSONArray.getString(i3);
        }
        String string5 = jSONObject.getString(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_CONTAINER_PATH);
        String string6 = jSONObject.getString(InstalledPlugin.PLUGIN_PACKAGE_NAME);
        String string7 = jSONObject.getString(InstalledPlugin.PLUGIN_VERSION);
        String string8 = jSONObject.getString(InstalledPlugin.PLUGIN_FILE_PATH);
        return new UseDynamicPluginLoaderInstalledPlugin(string6, string7, new File(file, string8), string, string2, new File(file, string3), new File(file, string5), string4, strArr, file, jSONObject.optInt(UseDynamicPluginLoaderInstalledPlugin.DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InstalledPlugin a() {
        Iterator<File> it = MinFileUtils.b(this.f114781a).iterator();
        while (it.hasNext()) {
            File next = it.next();
            String name = next.getName();
            if (name.startsWith("unpacked.")) {
                File file = new File(this.f114781a, name.substring(9));
                if (e(file).exists() && !d(file)) {
                    try {
                        return f(file);
                    } catch (Exception unused) {
                        next.delete();
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(File file) {
        return d(a(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InstalledPlugin c(File file) throws IOException, JSONException {
        BufferedOutputStream bufferedOutputStream;
        File a16 = a(file);
        a16.mkdirs();
        File e16 = e(a16);
        if (e(a(file)).exists()) {
            try {
                return f(a16);
            } catch (Exception unused) {
                if (!e16.delete()) {
                    throw new IOException("\u89e3\u6790\u7248\u672c\u4fe1\u606f\u5931\u8d25\uff0c\u4e14\u65e0\u6cd5\u5220\u9664\u6807\u8bb0:" + e16.getAbsolutePath());
                }
            }
        }
        MinFileUtils.c(a16);
        QZipInputStream qZipInputStream = new QZipInputStream(new FileInputStream(file));
        while (true) {
            try {
                ZipEntry nextEntry = qZipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (!nextEntry.isDirectory()) {
                        BufferedOutputStream bufferedOutputStream2 = null;
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(a16, nextEntry.getName())));
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(qZipInputStream);
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 8192);
                                if (read < 0) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            qZipInputStream.closeEntry();
                            bufferedOutputStream.close();
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedOutputStream2 = bufferedOutputStream;
                            qZipInputStream.closeEntry();
                            if (bufferedOutputStream2 != null) {
                                bufferedOutputStream2.close();
                            }
                            throw th;
                        }
                    }
                } else {
                    InstalledPlugin f16 = f(a16);
                    e16.createNewFile();
                    return f16;
                }
            } finally {
                qZipInputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File a(File file) {
        return new File(this.f114781a, file.getName());
    }
}
