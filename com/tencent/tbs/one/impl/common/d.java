package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tbs.one.TBSOneException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f374823a;

    /* renamed from: b, reason: collision with root package name */
    public int f374824b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, a> f374825c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f374826a;

        /* renamed from: b, reason: collision with root package name */
        public String f374827b;

        /* renamed from: c, reason: collision with root package name */
        public int f374828c;

        /* renamed from: d, reason: collision with root package name */
        public String f374829d;

        /* renamed from: e, reason: collision with root package name */
        public String f374830e;

        /* renamed from: f, reason: collision with root package name */
        public String[] f374831f;
    }

    d(JSONObject jSONObject) {
        this.f374823a = jSONObject.optString("VERSIONNAME");
        this.f374824b = jSONObject.optInt("VERSIONCODE");
        JSONArray optJSONArray = jSONObject.optJSONArray("COMPONENTS");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.f374825c = new HashMap(length);
            for (int i3 = 0; i3 < length; i3++) {
                a a16 = a(optJSONArray.optJSONObject(i3));
                if (a16 != null) {
                    this.f374825c.put(a16.f374826a, a16);
                }
            }
        }
    }

    public static d a(File file) throws TBSOneException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    d a16 = a(fileInputStream2);
                    com.tencent.tbs.one.impl.a.d.a(fileInputStream2);
                    return a16;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    com.tencent.tbs.one.impl.a.g.c("[DEPSConfig].parse(file) Failed to open DEPS file, error: " + e.getMessage(), new Object[0]);
                    throw new TBSOneException(306, "Failed to open DEPS file, error: " + e.getMessage(), e);
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    com.tencent.tbs.one.impl.a.d.a(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final a b(String str) {
        Map<String, a> map = this.f374825c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static d a(InputStream inputStream) throws TBSOneException {
        try {
            return a(com.tencent.tbs.one.impl.a.d.a(inputStream, "utf-8"));
        } catch (IOException e16) {
            com.tencent.tbs.one.impl.a.g.c("[DEPSConfig].parse(inputStream) Failed to read DEPS contents, error: " + e16.getMessage(), new Object[0]);
            throw new TBSOneException(307, "Failed to read DEPS contents, error: " + e16.getMessage(), e16);
        }
    }

    public static d a(String str) throws TBSOneException {
        try {
            return new d(new JSONObject(str));
        } catch (JSONException e16) {
            com.tencent.tbs.one.impl.a.g.c("[DEPSConfig].parse(json) Failed to parse DEPS Json: " + str + ", error: " + e16.getMessage(), new Object[0]);
            throw new TBSOneException(308, "Failed to parse DEPS " + str + ", error: " + e16.getMessage(), e16);
        }
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("NAME");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        a aVar = new a();
        aVar.f374826a = optString;
        aVar.f374827b = jSONObject.optString("VERSIONNAME");
        aVar.f374828c = jSONObject.optInt("VERSIONCODE");
        aVar.f374829d = jSONObject.optString(Global.TRACKING_URL);
        aVar.f374830e = jSONObject.optString(KeyPropertiesCompact.DIGEST_MD5);
        JSONArray optJSONArray = jSONObject.optJSONArray("DEPENDENCIES");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            aVar.f374831f = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                aVar.f374831f[i3] = optJSONArray.optString(i3);
            }
        }
        return aVar;
    }
}
