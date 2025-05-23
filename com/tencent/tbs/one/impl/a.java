package com.tencent.tbs.one.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.tbs.logger.e;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.i;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f374526a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f374527b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f374528c = true;

    public static void a(Context context) {
        synchronized (f374526a) {
            if (!f374527b) {
                e.j(context.getApplicationContext(), "onelog", 604800000L, 3145728L);
                g.a(new g.b() { // from class: com.tencent.tbs.one.impl.a.1
                    @Override // com.tencent.tbs.one.impl.a.g.b
                    public final void a(int i3, String str) {
                        e.l(i3, "TBSOne", str);
                    }
                });
                b.a(context.getApplicationContext());
                h.c(new h.b() { // from class: com.tencent.tbs.one.impl.a.2
                    @Override // com.tencent.tbs.one.impl.common.h.b
                    public final void reportEvent(String str, int i3, Map map) {
                        if (i3 != 201 && i3 != 209 && i3 != 214 && i3 != 506) {
                            a.a(str, i3, map);
                        }
                    }

                    @Override // com.tencent.tbs.one.impl.common.h.b
                    public final void reportLog() {
                        b.a();
                    }
                });
                Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(context.getDir("tbs", 0)));
                f374527b = true;
            }
        }
    }

    public static void a(boolean z16) {
        f374528c = z16;
    }

    public static com.tencent.tbs.one.impl.e.h a(Context context, String str) {
        i iVar = new i(context, str);
        if (a(iVar, context, str)) {
            g.a("[PolicyManager] Debug.conf exists, in debug mode, category: " + str, new Object[0]);
        }
        if ("default".equals(str)) {
            SharedPreferences sharedPreferences = iVar.f375067q;
            if (!sharedPreferences.contains("in_use_component_names")) {
                try {
                    Set<String> keySet = BuildConfig.COMPONENT_SDK_VERSIONS.keySet();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putStringSet("in_use_component_names", keySet);
                    edit.apply();
                } catch (Throwable th5) {
                    g.c("[%s] Failed to preset in-use component names", "default", th5);
                }
            }
        }
        return iVar;
    }

    private static boolean a(i iVar, Context context, String str) {
        File file;
        FileInputStream fileInputStream;
        if (context != null && context.getApplicationContext().checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            g.a("External storage read permission has not bean granted yet, giving up entering debug mode", new Object[0]);
            return false;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (com.tencent.tbs.one.impl.a.a.a(context)) {
            file = new File(externalStorageDirectory, "Android/data/" + context.getPackageName() + "/files/tbs/" + str + "/debug.conf");
        } else {
            file = new File(new File(new File(new File(new File(externalStorageDirectory, "tencent"), "tbs"), context.getPackageName()), str), "debug.conf");
        }
        if (file.exists()) {
            b.a(file.exists());
            g.a("Debug conf exist: " + file.getAbsolutePath(), new Object[0]);
            iVar.a(TBSOneConfigurationKeys.ONLINE_SERVICE_URL, "https://tbsone.sparta.html5.qq.com");
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                for (Map.Entry entry : properties.entrySet()) {
                    String obj = entry.getKey().toString();
                    Object value = entry.getValue();
                    g.a("Debug configuration: " + obj + " = " + value, new Object[0]);
                    iVar.a(obj, value);
                }
                com.tencent.tbs.one.impl.a.d.a(fileInputStream);
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                try {
                    g.c("Exception when read debug.conf", th);
                    return file.exists();
                } finally {
                    com.tencent.tbs.one.impl.a.d.a(fileInputStream2);
                }
            }
        }
        return file.exists();
    }

    public static com.tencent.tbs.one.impl.a.b<com.tencent.tbs.one.impl.e.e<com.tencent.tbs.one.impl.common.d>> a(i iVar, int i3, File file, Bundle bundle) {
        Context context = iVar.f375048a;
        String str = iVar.f375049b;
        String f16 = iVar.f();
        Object g16 = iVar.g(TBSOneConfigurationKeys.SHARABLE_APPLICATION_PACKAGES);
        return new com.tencent.tbs.one.impl.e.a.b(context, str, f16, g16 instanceof String ? ((String) g16).split(File.pathSeparator) : com.tencent.tbs.one.impl.common.b.f374812a, i3, file, bundle);
    }

    static /* synthetic */ void a(String str, int i3, Map map) {
        if (f374528c) {
            b a16 = b.a(str, i3);
            if (map == null) {
                a16.b();
                return;
            }
            if (map.containsKey("DEPS_VERSION_CODE")) {
                a16.f374603d = ((Integer) map.get("DEPS_VERSION_CODE")).intValue();
            }
            if (map.containsKey("DEPS_LOCAL_VERSION_CODE")) {
                a16.f374604e = ((Integer) map.get("DEPS_LOCAL_VERSION_CODE")).intValue();
            }
            if (map.containsKey("KEY_DEPS_COMPONENT_LOCV")) {
                a16.f374605f = (String) map.get("KEY_DEPS_COMPONENT_LOCV");
            }
            String str2 = map.containsKey("COMPONENT_NAME") ? (String) map.get("COMPONENT_NAME") : "";
            int intValue = map.containsKey("COMPONENT_VERSION_CODE") ? ((Integer) map.get("COMPONENT_VERSION_CODE")).intValue() : -1;
            int intValue2 = map.containsKey("COMPONENT_LOCAL_VERSION_CODE") ? ((Integer) map.get("COMPONENT_LOCAL_VERSION_CODE")).intValue() : -1;
            a16.f374600a = str2;
            a16.f374601b = intValue;
            a16.f374602c = intValue2;
            a16.b();
        }
    }
}
