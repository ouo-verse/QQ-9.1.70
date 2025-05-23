package nz3;

import com.qzone.widget.u;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jz3.d;
import jz3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\f\u0010\u0004\u001a\u00020\u0000*\u00020\u0002H\u0000\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u001a\f\u0010\b\u001a\u00020\u0000*\u00020\u0006H\u0000\u001a\u001a\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t\u001a\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000f"}, d2 = {"", "jsonObject", "Lnz3/a;", "d", "c", "obj", "Ljz3/e;", "a", "b", "", "", "map", "f", "str", "e", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {
    @Nullable
    public static final e a(@Nullable Object obj) {
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        try {
            e eVar = new e();
            eVar.f411260a = ((JSONObject) obj).optString("id");
            eVar.f411261b = ((JSONObject) obj).optLong("version");
            eVar.f411262c = ((JSONObject) obj).optLong("res_ver");
            eVar.f411263d = ((JSONObject) obj).optLong("size");
            eVar.D = ((JSONObject) obj).optLong("compressSize");
            eVar.f411264e = ((JSONObject) obj).optString("md5");
            eVar.f411265f = ((JSONObject) obj).optString("crc32", null);
            eVar.f411266g = ((JSONObject) obj).optString("downloadUrl");
            eVar.C = ((JSONObject) obj).optString("compOrigFileDownUrl");
            eVar.f411268i = ((JSONObject) obj).optString("resType");
            eVar.f411267h = ((JSONObject) obj).optString("description");
            eVar.f411272m = ((JSONObject) obj).optString("fileExtra");
            eVar.f411273n = ((JSONObject) obj).optInt("isEncrypted");
            eVar.f411274o = ((JSONObject) obj).optString("secretKey");
            eVar.f411275p = ((JSONObject) obj).optString("secretMd5");
            eVar.f411276q = ((JSONObject) obj).optString("secretCrc32", null);
            eVar.f411277r = ((JSONObject) obj).optString("app_max_ver");
            eVar.f411278s = ((JSONObject) obj).optInt("close");
            eVar.f411279t = ((JSONObject) obj).optString("task_id");
            eVar.f411280u = ((JSONObject) obj).optInt(VirtualAppProxy.KEY_AUTO_DOWNLOAD);
            eVar.f411281v = ((JSONObject) obj).optInt("forbidMobileNetAutoDownload");
            eVar.f411284y = ((JSONObject) obj).optInt("forceUpdate");
            eVar.f411285z = ((JSONObject) obj).optInt("allowAssetDowngrade");
            eVar.A = ((JSONObject) obj).optInt("noNeedUnZip");
            eVar.B = ((JSONObject) obj).optInt("isUnzippedBuiltInSource");
            eVar.E = ((JSONObject) obj).optLong("downloadOrder");
            eVar.F = ((JSONObject) obj).optString("cdnId");
            JSONArray optJSONArray = ((JSONObject) obj).optJSONArray("diffInfoList");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    DiffInfo d16 = d(optJSONArray.get(i3));
                    if (d16 != null) {
                        arrayList.add(d16);
                    }
                }
                eVar.f411269j = arrayList;
            }
            JSONArray optJSONArray2 = ((JSONObject) obj).optJSONArray("bigResDiffInfoList");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    DiffInfo d17 = d(optJSONArray2.get(i16));
                    if (d17 != null) {
                        arrayList2.add(d17);
                    }
                }
                eVar.f411283x = arrayList2;
            }
            JSONArray optJSONArray3 = ((JSONObject) obj).optJSONArray("sub_files");
            if (optJSONArray3 != null) {
                ArrayList arrayList3 = new ArrayList();
                int length3 = optJSONArray3.length();
                for (int i17 = 0; i17 < length3; i17++) {
                    arrayList3.add(optJSONArray3.get(i17).toString());
                }
                eVar.f411282w = arrayList3;
            }
            JSONObject optJSONObject = ((JSONObject) obj).optJSONObject("innerMd5");
            if (optJSONObject != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator keys = optJSONObject.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "fileArray.keys()");
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.get(str).toString());
                }
                eVar.f411270k = hashMap;
            }
            JSONObject optJSONObject2 = ((JSONObject) obj).optJSONObject("innerCrc32");
            if (optJSONObject2 != null) {
                HashMap<String, String> hashMap2 = new HashMap<>();
                Iterator keys2 = optJSONObject2.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys2, "crc32Array.keys()");
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    hashMap2.put(str2, optJSONObject2.get(str2).toString());
                }
                eVar.f411271l = hashMap2;
            }
            eVar.L = ((JSONObject) obj).optBoolean("auto_unzip", true);
            eVar.N = ((JSONObject) obj).optBoolean("isLoadFromPresetAssets", false);
            eVar.G = ((JSONObject) obj).optString("local");
            eVar.H = ((JSONObject) obj).optString("originLocal");
            eVar.I = ((JSONObject) obj).optString("encryptLocal");
            return eVar;
        } catch (JSONException e16) {
            d.d("JsonParse", "Parse ResConfig Exception: " + e16.getMessage(), e16);
            return null;
        }
    }

    @NotNull
    public static final Object b(@NotNull e convertToObj) {
        boolean z16;
        boolean z17;
        Intrinsics.checkParameterIsNotNull(convertToObj, "$this$convertToObj");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", convertToObj.f411260a);
        jSONObject.put("version", convertToObj.f411261b);
        jSONObject.put("res_ver", convertToObj.f411262c);
        jSONObject.put("size", convertToObj.f411263d);
        jSONObject.put("compressSize", convertToObj.D);
        jSONObject.put("md5", convertToObj.f411264e);
        jSONObject.putOpt("crc32", convertToObj.f411265f);
        jSONObject.put("downloadUrl", convertToObj.f411266g);
        jSONObject.put("compOrigFileDownUrl", convertToObj.C);
        jSONObject.put("resType", convertToObj.f411268i);
        jSONObject.put("description", convertToObj.f411267h);
        jSONObject.put("auto_unzip", convertToObj.L);
        jSONObject.put("isLoadFromPresetAssets", convertToObj.N);
        jSONObject.put("fileExtra", convertToObj.f411272m);
        jSONObject.put("isEncrypted", convertToObj.f411273n);
        jSONObject.put("secretKey", convertToObj.f411274o);
        jSONObject.put("secretMd5", convertToObj.f411275p);
        jSONObject.putOpt("secretCrc32", convertToObj.f411276q);
        jSONObject.put("app_max_ver", convertToObj.f411277r);
        jSONObject.put("close", convertToObj.f411278s);
        jSONObject.put("task_id", convertToObj.f411279t);
        jSONObject.put(VirtualAppProxy.KEY_AUTO_DOWNLOAD, convertToObj.f411280u);
        jSONObject.put("forbidMobileNetAutoDownload", convertToObj.f411281v);
        jSONObject.put("forceUpdate", convertToObj.f411284y);
        jSONObject.put("allowAssetDowngrade", convertToObj.f411285z);
        jSONObject.put("noNeedUnZip", convertToObj.A);
        jSONObject.put("isUnzippedBuiltInSource", convertToObj.B);
        jSONObject.put("downloadOrder", convertToObj.E);
        jSONObject.put("cdnId", convertToObj.F);
        if (convertToObj.f411269j != null) {
            JSONArray jSONArray = new JSONArray();
            List<DiffInfo> diffInfoList = convertToObj.f411269j;
            Intrinsics.checkExpressionValueIsNotNull(diffInfoList, "diffInfoList");
            for (DiffInfo info : diffInfoList) {
                Intrinsics.checkExpressionValueIsNotNull(info, "info");
                jSONArray.mo162put(c(info));
            }
            jSONObject.put("diffInfoList", jSONArray);
        }
        if (convertToObj.f411283x != null) {
            JSONArray jSONArray2 = new JSONArray();
            List<DiffInfo> bigResDiffInfoList = convertToObj.f411283x;
            Intrinsics.checkExpressionValueIsNotNull(bigResDiffInfoList, "bigResDiffInfoList");
            for (DiffInfo info2 : bigResDiffInfoList) {
                Intrinsics.checkExpressionValueIsNotNull(info2, "info");
                jSONArray2.mo162put(c(info2));
            }
            jSONObject.put("bigResDiffInfoList", jSONArray2);
        }
        if (convertToObj.f411282w != null) {
            JSONArray jSONArray3 = new JSONArray();
            List<String> sub_files = convertToObj.f411282w;
            Intrinsics.checkExpressionValueIsNotNull(sub_files, "sub_files");
            Iterator<T> it = sub_files.iterator();
            while (it.hasNext()) {
                jSONArray3.mo162put((String) it.next());
            }
            jSONObject.put("sub_files", jSONArray3);
        }
        if (convertToObj.f411270k != null) {
            JSONObject jSONObject2 = new JSONObject();
            HashMap<String, String> hashMap = convertToObj.f411270k;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("innerMd5", jSONObject2);
        }
        if (convertToObj.f411271l != null) {
            JSONObject jSONObject3 = new JSONObject();
            HashMap<String, String> hashMap2 = convertToObj.f411271l;
            if (hashMap2 != null) {
                for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                    jSONObject3.put(entry2.getKey(), entry2.getValue());
                }
            }
            jSONObject.put("innerCrc32", jSONObject3);
        }
        String str = convertToObj.G;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            jSONObject.put("local", convertToObj.G);
        }
        String str2 = convertToObj.H;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            jSONObject.put("originLocal", convertToObj.H);
        }
        String str3 = convertToObj.I;
        if (str3 == null || str3.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            jSONObject.put("encryptLocal", convertToObj.I);
        }
        return jSONObject;
    }

    @NotNull
    public static final Object c(@NotNull DiffInfo convertToObj) {
        Intrinsics.checkParameterIsNotNull(convertToObj, "$this$convertToObj");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", convertToObj.getVersion());
        jSONObject.put("downloadUrl", convertToObj.getDownloadUrl());
        jSONObject.put("md5", convertToObj.getMd5());
        jSONObject.putOpt("crc32", convertToObj.getCrc32());
        jSONObject.put("size", convertToObj.getSize());
        jSONObject.put(u.COLUMN_OLD_MD5, convertToObj.getOld_md5());
        jSONObject.putOpt("old_crc32", convertToObj.getOldCrc32());
        return jSONObject;
    }

    @Nullable
    public static final DiffInfo d(@Nullable Object obj) {
        try {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            long optLong = ((JSONObject) obj).optLong("version");
            String downloadUrl = ((JSONObject) obj).optString("downloadUrl");
            String md5 = ((JSONObject) obj).optString("md5");
            String optString = ((JSONObject) obj).optString("crc32", null);
            long optLong2 = ((JSONObject) obj).optLong("size");
            String oldMd5 = ((JSONObject) obj).optString(u.COLUMN_OLD_MD5);
            String optString2 = ((JSONObject) obj).optString("old_crc32", null);
            Intrinsics.checkExpressionValueIsNotNull(downloadUrl, "downloadUrl");
            Intrinsics.checkExpressionValueIsNotNull(md5, "md5");
            Intrinsics.checkExpressionValueIsNotNull(oldMd5, "oldMd5");
            return new DiffInfo(optLong, downloadUrl, md5, optLong2, oldMd5, optString, optString2);
        } catch (JSONException e16) {
            d.d("JsonParse", "Parse DiffInfo Exception: " + e16.getMessage(), e16);
            return null;
        }
    }

    @Nullable
    public static final Map<String, e> e(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkExpressionValueIsNotNull(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                e a16 = a(jSONObject.get(str2));
                if (a16 != null) {
                    hashMap.put(str2, a16);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            d.d("JsonParse", "Parse ResConfigMap Exception: " + e16.getMessage(), e16);
            return null;
        }
    }

    @NotNull
    public static final String f(@NotNull Map<String, ? extends e> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends e> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), b(entry.getValue()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "result.toString()");
        return jSONObject2;
    }
}
