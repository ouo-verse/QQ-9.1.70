package com.tencent.xweb.xwalk.plugin;

import android.content.Context;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.lq.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class XWalkPluginManager {
    public static final String XFILE_TEMP_FILE_PREFIX = "xfiletemp_";
    public static final String XWALK_PLUGIN_NAME_EXCEL = "XFilesExcelReader";
    public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
    public static final String XWALK_PLUGIN_NAME_OFFICE = "XFilesOfficeReader";
    public static final String XWALK_PLUGIN_NAME_PDF = "XFilesPDFReader";
    public static final String XWALK_PLUGIN_NAME_PPT = "XFilesPPTReader";
    public static final String XWALK_PLUGIN_NAME_TXT = "XFilesTXTReader";
    public static final String XWALK_PLUGIN_NAME_WORD = "XFilesWordReader";

    /* renamed from: a, reason: collision with root package name */
    public static Map f385153a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f385154b = false;

    /* loaded from: classes27.dex */
    public static class PluginInfo {
        public String pluginName;
        public int pluginVersion;

        public PluginInfo(String str, int i3) {
            this.pluginName = str;
            this.pluginVersion = i3;
        }
    }

    public static void a() {
        try {
            x0.d("XWalkPluginManager", "initEmbedPluginInfo, no embed or embed failed, return");
        } catch (Throwable th5) {
            x0.a("XWalkPluginManager", "initEmbedPluginInfo error", th5);
        }
    }

    public static void checkFiles() {
        if (!f385154b) {
            x0.c("XWalkPluginManager", "checkFiles error, not init");
        } else {
            if (f385153a.size() == 0) {
                x0.c("XWalkPluginManager", "checkFiles error, sPluginMap size is 0");
                return;
            }
            Iterator it = f385153a.entrySet().iterator();
            while (it.hasNext()) {
                ((XWalkPlugin) ((Map.Entry) it.next()).getValue()).checkFiles();
            }
        }
    }

    public static void checkKeyFiles(int i3) {
        if (!f385154b) {
            x0.c("XWalkPluginManager", "checkKeyFiles error, not init");
        } else {
            if (f385153a.size() == 0) {
                x0.c("XWalkPluginManager", "checkFilesSimple error, sPluginMap size is 0");
                return;
            }
            Iterator it = f385153a.entrySet().iterator();
            while (it.hasNext()) {
                ((XWalkPlugin) ((Map.Entry) it.next()).getValue()).checkKeyFiles(i3);
            }
        }
    }

    public static void clearOldVersions() {
        if (!f385154b) {
            x0.c("XWalkPluginManager", "clearOldVersions error, not init");
            return;
        }
        if (f385153a.size() == 0) {
            x0.c("XWalkPluginManager", "clearOldVersions error, sPluginMap size is 0");
            return;
        }
        String b16 = u0.b();
        if (b16 != null && !b16.isEmpty()) {
            File[] listFiles = new File(b16).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file != null && !file.getName().equals("plugintemp")) {
                        PluginInfo pluginInfoFromDir = getPluginInfoFromDir(file);
                        if (pluginInfoFromDir == null) {
                            x0.c("XWalkPluginManager", "clearOldVersions can not get plugin info, delete " + file.getAbsolutePath());
                            w.a(file.getAbsolutePath());
                        } else {
                            XWalkPlugin xWalkPlugin = (XWalkPlugin) f385153a.get(pluginInfoFromDir.pluginName);
                            if (xWalkPlugin == null) {
                                x0.c("XWalkPluginManager", "clearOldVersions invalid plugin info, delete " + file.getAbsolutePath());
                                w.a(file.getAbsolutePath());
                            } else {
                                int availableVersion = xWalkPlugin.getAvailableVersion();
                                if (availableVersion < 0) {
                                    availableVersion = xWalkPlugin.getAvailableVersion(true);
                                }
                                if (availableVersion < 0) {
                                    x0.c("XWalkPluginManager", "clearOldVersions can not get availableVersion, skip " + file.getAbsolutePath());
                                } else if (pluginInfoFromDir.pluginVersion < availableVersion) {
                                    x0.d("XWalkPluginManager", "clearOldVersions is old version, delete " + file.getAbsolutePath());
                                    w.a(file.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
                return;
            }
            x0.d("XWalkPluginManager", "clearOldVersions, dir is empty, return");
            return;
        }
        x0.c("XWalkPluginManager", "clearOldVersions clear other, pluginBaseDir is null, return");
    }

    public static void clearTempDir() {
        String c16 = u0.c();
        if (c16.isEmpty()) {
            x0.c("XWalkPluginManager", "clearTempDir, pluginTempDir is null, return");
            return;
        }
        File[] listFiles = new File(c16).listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file != null) {
                    long tempFileTime = getTempFileTime(file);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (tempFileTime < 0 || tempFileTime > currentTimeMillis || currentTimeMillis - tempFileTime > 86400000) {
                        x0.d("XWalkPluginManager", "clearTempDir, delete " + file.getAbsolutePath());
                        w.b(file.getAbsolutePath());
                    }
                }
            }
            return;
        }
        x0.d("XWalkPluginManager", "clearTempDir, dir is empty, return");
    }

    public static String getAllPluginVersionInfo() {
        if (!f385154b) {
            x0.c("XWalkPluginManager", "getAllPluginVersionInfo error, not init");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = f385153a.entrySet().iterator();
        while (it.hasNext()) {
            XWalkPlugin xWalkPlugin = (XWalkPlugin) ((Map.Entry) it.next()).getValue();
            if (xWalkPlugin != null) {
                sb5.append(xWalkPlugin.getPluginName());
                sb5.append(" = ");
                sb5.append(xWalkPlugin.getAvailableVersion());
                sb5.append(", ");
            }
        }
        return sb5.toString();
    }

    public static List<XWalkPlugin> getAllPlugins() {
        ArrayList arrayList = new ArrayList();
        if (!f385154b) {
            x0.c("XWalkPluginManager", "getAllPlugins error, not init");
            return arrayList;
        }
        Iterator it = f385153a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((XWalkPlugin) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    public static Map<String, Integer> getInstalledPluginVersions(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)));
        hashMap.put(XWALK_PLUGIN_NAME_PDF, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_PDF)));
        hashMap.put(XWALK_PLUGIN_NAME_PPT, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_PPT)));
        hashMap.put(XWALK_PLUGIN_NAME_WORD, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_WORD)));
        hashMap.put(XWALK_PLUGIN_NAME_EXCEL, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_EXCEL)));
        hashMap.put(XWALK_PLUGIN_NAME_OFFICE, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_OFFICE)));
        hashMap.put(XWALK_PLUGIN_NAME_TXT, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWALK_PLUGIN_NAME_TXT)));
        return hashMap;
    }

    public static XWalkPlugin getPlugin(String str) {
        if (!f385154b) {
            x0.c("XWalkPluginManager", "getPlugin error, not init");
            return null;
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (XWalkPlugin) f385153a.get(str);
    }

    public static PluginInfo getPluginInfoFromDir(File file) {
        if (file == null) {
            x0.c("XWalkPluginManager", "getPluginInfoFromDir, dirFile is null");
            return null;
        }
        if (file.exists() && file.isDirectory()) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(95);
            if (lastIndexOf >= 0 && lastIndexOf < name.length() - 1) {
                try {
                    return new PluginInfo(name.substring(0, lastIndexOf), Integer.parseInt(name.substring(lastIndexOf + 1)));
                } catch (Throwable th5) {
                    x0.c("XWalkPluginManager", "getPluginInfoFromDir, error: " + th5);
                    return null;
                }
            }
            x0.c("XWalkPluginManager", "getPluginInfoFromDir, can not find _");
            return null;
        }
        x0.c("XWalkPluginManager", "getPluginInfoFromDir, dirFile is invalid");
        return null;
    }

    public static long getTempFileTime(File file) {
        if (file != null && file.isFile()) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(95);
            if (lastIndexOf >= 0 && lastIndexOf < name.length() - 1) {
                try {
                    return Long.parseLong(name.substring(lastIndexOf + 1));
                } catch (Throwable th5) {
                    x0.c("XWalkPluginManager", "getTempFileTime error: " + th5);
                    return -1L;
                }
            }
            x0.c("XWalkPluginManager", "getTempFileTime error, can not find _");
            return -1L;
        }
        x0.c("XWalkPluginManager", "getTempFileTime error, not file");
        return -1L;
    }

    public static synchronized boolean initPlugins() {
        synchronized (XWalkPluginManager.class) {
            if (!f385154b) {
                x0.d("XWalkPluginManager", "initPlugins");
                XWalkFullScreenVideoPlugin xWalkFullScreenVideoPlugin = new XWalkFullScreenVideoPlugin();
                f385153a.put(xWalkFullScreenVideoPlugin.getPluginName(), xWalkFullScreenVideoPlugin);
                XWalkPDFReaderPlugin xWalkPDFReaderPlugin = new XWalkPDFReaderPlugin();
                f385153a.put(xWalkPDFReaderPlugin.getPluginName(), xWalkPDFReaderPlugin);
                XWalkPPTReaderPlugin xWalkPPTReaderPlugin = new XWalkPPTReaderPlugin();
                f385153a.put(xWalkPPTReaderPlugin.getPluginName(), xWalkPPTReaderPlugin);
                XWalkWordReaderPlugin xWalkWordReaderPlugin = new XWalkWordReaderPlugin();
                f385153a.put(xWalkWordReaderPlugin.getPluginName(), xWalkWordReaderPlugin);
                XWalkExcelReaderPlugin xWalkExcelReaderPlugin = new XWalkExcelReaderPlugin();
                f385153a.put(xWalkExcelReaderPlugin.getPluginName(), xWalkExcelReaderPlugin);
                XWalkOfficeReaderPlugin xWalkOfficeReaderPlugin = new XWalkOfficeReaderPlugin();
                f385153a.put(xWalkOfficeReaderPlugin.getPluginName(), xWalkOfficeReaderPlugin);
                XWalkTXTReaderPlugin xWalkTXTReaderPlugin = new XWalkTXTReaderPlugin();
                f385153a.put(xWalkTXTReaderPlugin.getPluginName(), xWalkTXTReaderPlugin);
                f385154b = true;
                a();
            }
            d.a(new Runnable() { // from class: com.tencent.xweb.xwalk.plugin.XWalkPluginManager.1
                @Override // java.lang.Runnable
                public void run() {
                    x0.d("XWalkPluginManager", "check key files in plugins");
                    XWalkPluginManager.checkKeyFiles(1);
                }
            });
        }
        return true;
    }
}
