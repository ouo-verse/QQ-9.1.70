package com.tencent.tbs.one.impl.common;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tbs.one.TBSOneException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f374832a;

    /* renamed from: b, reason: collision with root package name */
    public String f374833b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f374834c;

    /* renamed from: d, reason: collision with root package name */
    public String f374835d;

    /* renamed from: e, reason: collision with root package name */
    public a[] f374836e;

    /* renamed from: f, reason: collision with root package name */
    public Pair<String, String>[] f374837f;

    /* renamed from: g, reason: collision with root package name */
    public String f374838g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f374839h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f374840i;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f374841a;

        /* renamed from: b, reason: collision with root package name */
        public String f374842b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f374843c;

        /* renamed from: d, reason: collision with root package name */
        public b f374844d;

        /* renamed from: e, reason: collision with root package name */
        public String f374845e;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f374846a;

        /* renamed from: b, reason: collision with root package name */
        public String f374847b;
    }

    e(JSONObject jSONObject) {
        this.f374839h = false;
        this.f374840i = false;
        try {
            this.f374839h = jSONObject.optBoolean("NO_SEALED");
        } catch (Exception unused) {
        }
        try {
            this.f374840i = jSONObject.optBoolean("DEX_SOFT_LINK_DISABLED");
        } catch (Throwable unused2) {
        }
        this.f374832a = jSONObject.optInt("VERSIONCODE");
        this.f374838g = jSONObject.optString("BUILD_TYPE");
        this.f374833b = jSONObject.optString("RESOURCE");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ENTRY2");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("DEX_LIST");
                    com.tencent.tbs.one.impl.a.g.a("ManifestConfig ENTRY2 dexListStr=" + optString, new Object[0]);
                    if (!TextUtils.isEmpty(optString)) {
                        String[] split = optString.split(",");
                        this.f374834c = split;
                        if (split.length > 1) {
                            com.tencent.tbs.one.impl.a.g.a("ManifestConfig mEntryDexPath[0]:%s  mEntryDexPath[1]:%s", split[0], split[1]);
                        }
                    }
                    String optString2 = optJSONObject.optString("ENTRY_CLASS");
                    this.f374835d = optString2;
                    if (!TextUtils.isEmpty(optString2)) {
                        com.tencent.tbs.one.impl.a.g.a("ManifestConfig mEntryClassName:%s", this.f374835d);
                    }
                } else {
                    com.tencent.tbs.one.impl.a.g.a("ManifestConfig ENTRY2 NULL", new Object[0]);
                }
            }
        } catch (Exception e16) {
            com.tencent.tbs.one.impl.a.g.a("ManifestConfig ENTRY2 Exception", new Object[0]);
            e16.printStackTrace();
        }
        String[] strArr = this.f374834c;
        if (strArr == null || TextUtils.isEmpty(strArr[0]) || TextUtils.isEmpty(this.f374835d)) {
            String optString3 = jSONObject.optString("ENTRY");
            if (!TextUtils.isEmpty(optString3)) {
                this.f374834c = new String[1];
                String[] split2 = optString3.split(":");
                if (split2.length == 1) {
                    this.f374834c[0] = split2[0];
                } else if (split2.length >= 2) {
                    this.f374834c[0] = split2[0];
                    this.f374835d = split2[1];
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("FILES");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                a a16 = a(optJSONArray.optJSONObject(i3));
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
            this.f374836e = (a[]) arrayList.toArray(new a[0]);
        }
        a(jSONObject.optJSONArray("RECEIVERS"));
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:21:0x00a3 */
    public static e a(File file) throws TBSOneException {
        JSONException e16;
        IOException e17;
        FileNotFoundException e18;
        Closeable closeable;
        FileInputStream fileInputStream;
        Closeable closeable2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e19) {
                e18 = e19;
            } catch (IOException e26) {
                e17 = e26;
            } catch (JSONException e27) {
                e16 = e27;
            } catch (Throwable th5) {
                th = th5;
                com.tencent.tbs.one.impl.a.d.a(closeable2);
                throw th;
            }
            try {
                e eVar = new e(new JSONObject(com.tencent.tbs.one.impl.a.d.a(fileInputStream, "utf-8")));
                com.tencent.tbs.one.impl.a.d.a(fileInputStream);
                return eVar;
            } catch (FileNotFoundException e28) {
                e18 = e28;
                throw new TBSOneException(401, "Failed to open MANIFEST file " + file.getAbsolutePath() + ", error: " + e18.getMessage(), e18);
            } catch (IOException e29) {
                e17 = e29;
                throw new TBSOneException(402, "Failed to read MANIFEST file " + file.getAbsolutePath() + ", error: " + e17.getMessage(), e17);
            } catch (JSONException e36) {
                e16 = e36;
                throw new TBSOneException(403, "Failed to parse MANIFEST json from file " + file.getAbsolutePath() + ", error: " + e16.getMessage(), e16);
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            com.tencent.tbs.one.impl.a.d.a(closeable2);
            throw th;
        }
    }

    public final a a(String str) {
        for (a aVar : this.f374836e) {
            if (aVar.f374841a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(AEEditorConstants.PATH);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        a aVar = new a();
        aVar.f374841a = optString;
        aVar.f374842b = jSONObject.optString(KeyPropertiesCompact.DIGEST_MD5);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("UNSEALED");
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    strArr[i3] = jSONArray.optString(i3);
                }
                aVar.f374843c = strArr;
            }
        } catch (JSONException e16) {
            e16.getMessage();
        }
        aVar.f374845e = jSONObject.optString(Global.TRACKING_URL);
        String optString2 = jSONObject.optString("PARENT");
        if (!TextUtils.isEmpty(optString2)) {
            b bVar = new b();
            String[] split = optString2.split(":");
            if (split.length == 1) {
                bVar.f374847b = split[0];
            } else {
                bVar.f374846a = split[0];
                bVar.f374847b = split[1];
            }
            aVar.f374844d = bVar;
        }
        return aVar;
    }

    private void a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("CLASS");
            JSONArray optJSONArray = optJSONObject.optJSONArray("EVENTS");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length2 = optJSONArray.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList.add(new Pair(optJSONArray.optString(i16), optString));
                }
            }
        }
        this.f374837f = (Pair[]) arrayList.toArray(new Pair[0]);
    }
}
