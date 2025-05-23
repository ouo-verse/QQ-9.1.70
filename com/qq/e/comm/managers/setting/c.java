package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f38230a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f38231a;

        /* renamed from: b, reason: collision with root package name */
        private c f38232b;

        public a(String str, c cVar) {
            this.f38231a = str;
            this.f38232b = cVar;
        }

        public final String a() {
            return this.f38231a;
        }

        public final c b() {
            return this.f38232b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f38233a;

        /* renamed from: b, reason: collision with root package name */
        private com.qq.e.comm.managers.setting.b f38234b;

        b(String str, com.qq.e.comm.managers.setting.b bVar) {
            this.f38233a = str;
            this.f38234b = bVar;
        }

        public final String a() {
            return this.f38233a;
        }

        public final com.qq.e.comm.managers.setting.b b() {
            return this.f38234b;
        }

        /* synthetic */ b(String str, com.qq.e.comm.managers.setting.b bVar, byte b16) {
            this(str, bVar);
        }
    }

    public c() {
        this.f38230a = new JSONObject();
    }

    private static Pair<String, String> a(Context context, String str) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName(Constants.SETTING.SETTINGDIR), 0);
        if (dir.exists()) {
            File file = new File(dir, str + ".nsig");
            File file2 = new File(dir, str + ".ncfg");
            if (file.exists() && file2.exists()) {
                try {
                    return new Pair<>(StringUtil.readAll(file), StringUtil.readAll(file2));
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    public static b b(Context context) {
        Pair<String, String> a16 = a(context, Constants.SETTING.SDK_CLOUD_SETTING);
        if (a16 == null) {
            return null;
        }
        try {
            return new b((String) a16.first, new com.qq.e.comm.managers.setting.b(new String(Base64.decode((String) a16.second, 0), "UTF-8")), (byte) 0);
        } catch (Throwable th5) {
            GDTLogger.e("exception while loading local sdk cloud setting", th5);
            return null;
        }
    }

    c(String str) {
        this();
        GDTLogger.d("Initialize GDTAPPSetting,Json=" + str);
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            this.f38230a = new JSONObject(str);
        } catch (JSONException e16) {
            GDTLogger.e("JsonException While build GDTAPPSetting Instance from JSON", e16);
        }
    }

    public static a a(Context context) {
        Pair<String, String> a16 = a(context, Constants.SETTING.DEV_CLOUD_SETTING);
        if (a16 == null) {
            return null;
        }
        try {
            return new a((String) a16.first, new c(new String(Base64.decode((String) a16.second, 0), "UTF-8")));
        } catch (Throwable th5) {
            GDTLogger.e("exception while loading local dev cloud setting", th5);
            return null;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        return a(context, Constants.SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #2 {Exception -> 0x008a, blocks: (B:42:0x0082, B:37:0x0087), top: B:41:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        Throwable th5;
        FileWriter fileWriter2;
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName(Constants.SETTING.SETTINGDIR), 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".ncfg");
        File file2 = new File(dir, str + ".nsig");
        FileWriter fileWriter3 = null;
        try {
            fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str3);
                fileWriter = new FileWriter(file2);
            } catch (Exception unused) {
                fileWriter = null;
            } catch (Throwable th6) {
                fileWriter = null;
                th5 = th6;
            }
            try {
                fileWriter.write(str2);
                try {
                    fileWriter2.close();
                    fileWriter.close();
                    return true;
                } catch (Exception unused2) {
                    return true;
                }
            } catch (Exception unused3) {
                fileWriter3 = fileWriter2;
                try {
                    file.delete();
                    file2.delete();
                    if (fileWriter3 != null) {
                        try {
                            fileWriter3.close();
                        } catch (Exception unused4) {
                            return false;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    return false;
                } catch (Throwable th7) {
                    fileWriter2 = fileWriter3;
                    th5 = th7;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (Exception unused5) {
                            throw th5;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th5;
                }
            } catch (Throwable th8) {
                th5 = th8;
                if (fileWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th5;
            }
        } catch (Exception unused6) {
            fileWriter = null;
        } catch (Throwable th9) {
            fileWriter = null;
            th5 = th9;
            fileWriter2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f38230a.opt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str, String str2) {
        JSONObject optJSONObject = this.f38230a.optJSONObject(Constants.KEYS.PLACEMENTS);
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        try {
            this.f38230a.putOpt(str, obj);
        } catch (JSONException e16) {
            GDTLogger.e("Exception while update setting", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj, String str2) {
        try {
            JSONObject optJSONObject = this.f38230a.optJSONObject(Constants.KEYS.PLACEMENTS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f38230a.putOpt(Constants.KEYS.PLACEMENTS, optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e16) {
            GDTLogger.e("Exception while update setting", e16);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, Constants.SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(str3)) {
            return b(context, str, str2, str3);
        }
        GDTLogger.e(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
        return false;
    }
}
