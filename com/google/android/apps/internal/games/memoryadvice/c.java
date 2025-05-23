package com.google.android.apps.internal.games.memoryadvice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.util.Log;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f32928e = "c";

    /* renamed from: a, reason: collision with root package name */
    private final b f32929a;

    /* renamed from: b, reason: collision with root package name */
    protected final JSONObject f32930b;

    /* renamed from: c, reason: collision with root package name */
    private final ActivityManager f32931c;

    /* renamed from: d, reason: collision with root package name */
    private int f32932d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, JSONObject jSONObject) {
        this.f32929a = new b(context.getCacheDir());
        this.f32931c = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        try {
            JSONObject a16 = a(jSONObject.getJSONObject("variable"));
            this.f32930b = a16;
            JSONObject optJSONObject = jSONObject.optJSONObject("constant");
            if (optJSONObject != null) {
                a16.put("constant", a(optJSONObject));
            }
        } catch (JSONException e16) {
            throw new IllegalStateException(e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0296 A[Catch: JSONException -> 0x0378, TryCatch #0 {JSONException -> 0x0378, blocks: (B:3:0x0027, B:5:0x002d, B:7:0x003a, B:8:0x0043, B:10:0x0047, B:15:0x0056, B:22:0x007a, B:29:0x0092, B:34:0x00a6, B:36:0x00b3, B:38:0x00b9, B:39:0x00c4, B:41:0x00ca, B:43:0x00d2, B:44:0x00d7, B:46:0x00db, B:51:0x00ea, B:53:0x00f0, B:56:0x0104, B:60:0x0114, B:64:0x0127, B:68:0x0137, B:70:0x0142, B:72:0x0148, B:73:0x013d, B:74:0x012d, B:75:0x011a, B:77:0x011e, B:78:0x010a, B:81:0x014b, B:83:0x0151, B:85:0x015e, B:86:0x0169, B:88:0x016f, B:89:0x017a, B:91:0x0180, B:92:0x0189, B:94:0x0191, B:95:0x019d, B:97:0x01a1, B:98:0x01aa, B:100:0x01b5, B:102:0x01bd, B:103:0x01c2, B:105:0x01c6, B:108:0x01d1, B:111:0x01db, B:113:0x01e8, B:115:0x01ee, B:116:0x01e1, B:119:0x01f1, B:121:0x01f9, B:123:0x0201, B:124:0x0206, B:126:0x020a, B:131:0x0219, B:133:0x021f, B:135:0x0234, B:136:0x0242, B:138:0x0248, B:140:0x0256, B:146:0x0260, B:149:0x027d, B:151:0x0283, B:153:0x0289, B:154:0x028e, B:156:0x0296, B:158:0x029e, B:159:0x02a3, B:161:0x02a7, B:166:0x02b6, B:168:0x02bc, B:169:0x02cd, B:171:0x02d3, B:173:0x02e1, B:176:0x02e7, B:182:0x02ef, B:184:0x02f5, B:187:0x02f8, B:189:0x0300, B:191:0x0308, B:192:0x030d, B:194:0x0311, B:199:0x0320, B:201:0x0326, B:202:0x0337, B:204:0x033d, B:206:0x034b, B:209:0x0351, B:215:0x0359, B:217:0x035f, B:220:0x0362, B:227:0x00ac, B:228:0x0098, B:229:0x0083, B:230:0x0065), top: B:2:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0300 A[Catch: JSONException -> 0x0378, TryCatch #0 {JSONException -> 0x0378, blocks: (B:3:0x0027, B:5:0x002d, B:7:0x003a, B:8:0x0043, B:10:0x0047, B:15:0x0056, B:22:0x007a, B:29:0x0092, B:34:0x00a6, B:36:0x00b3, B:38:0x00b9, B:39:0x00c4, B:41:0x00ca, B:43:0x00d2, B:44:0x00d7, B:46:0x00db, B:51:0x00ea, B:53:0x00f0, B:56:0x0104, B:60:0x0114, B:64:0x0127, B:68:0x0137, B:70:0x0142, B:72:0x0148, B:73:0x013d, B:74:0x012d, B:75:0x011a, B:77:0x011e, B:78:0x010a, B:81:0x014b, B:83:0x0151, B:85:0x015e, B:86:0x0169, B:88:0x016f, B:89:0x017a, B:91:0x0180, B:92:0x0189, B:94:0x0191, B:95:0x019d, B:97:0x01a1, B:98:0x01aa, B:100:0x01b5, B:102:0x01bd, B:103:0x01c2, B:105:0x01c6, B:108:0x01d1, B:111:0x01db, B:113:0x01e8, B:115:0x01ee, B:116:0x01e1, B:119:0x01f1, B:121:0x01f9, B:123:0x0201, B:124:0x0206, B:126:0x020a, B:131:0x0219, B:133:0x021f, B:135:0x0234, B:136:0x0242, B:138:0x0248, B:140:0x0256, B:146:0x0260, B:149:0x027d, B:151:0x0283, B:153:0x0289, B:154:0x028e, B:156:0x0296, B:158:0x029e, B:159:0x02a3, B:161:0x02a7, B:166:0x02b6, B:168:0x02bc, B:169:0x02cd, B:171:0x02d3, B:173:0x02e1, B:176:0x02e7, B:182:0x02ef, B:184:0x02f5, B:187:0x02f8, B:189:0x0300, B:191:0x0308, B:192:0x030d, B:194:0x0311, B:199:0x0320, B:201:0x0326, B:202:0x0337, B:204:0x033d, B:206:0x034b, B:209:0x0351, B:215:0x0359, B:217:0x035f, B:220:0x0362, B:227:0x00ac, B:228:0x0098, B:229:0x0083, B:230:0x0065), top: B:2:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9 A[Catch: JSONException -> 0x0378, TryCatch #0 {JSONException -> 0x0378, blocks: (B:3:0x0027, B:5:0x002d, B:7:0x003a, B:8:0x0043, B:10:0x0047, B:15:0x0056, B:22:0x007a, B:29:0x0092, B:34:0x00a6, B:36:0x00b3, B:38:0x00b9, B:39:0x00c4, B:41:0x00ca, B:43:0x00d2, B:44:0x00d7, B:46:0x00db, B:51:0x00ea, B:53:0x00f0, B:56:0x0104, B:60:0x0114, B:64:0x0127, B:68:0x0137, B:70:0x0142, B:72:0x0148, B:73:0x013d, B:74:0x012d, B:75:0x011a, B:77:0x011e, B:78:0x010a, B:81:0x014b, B:83:0x0151, B:85:0x015e, B:86:0x0169, B:88:0x016f, B:89:0x017a, B:91:0x0180, B:92:0x0189, B:94:0x0191, B:95:0x019d, B:97:0x01a1, B:98:0x01aa, B:100:0x01b5, B:102:0x01bd, B:103:0x01c2, B:105:0x01c6, B:108:0x01d1, B:111:0x01db, B:113:0x01e8, B:115:0x01ee, B:116:0x01e1, B:119:0x01f1, B:121:0x01f9, B:123:0x0201, B:124:0x0206, B:126:0x020a, B:131:0x0219, B:133:0x021f, B:135:0x0234, B:136:0x0242, B:138:0x0248, B:140:0x0256, B:146:0x0260, B:149:0x027d, B:151:0x0283, B:153:0x0289, B:154:0x028e, B:156:0x0296, B:158:0x029e, B:159:0x02a3, B:161:0x02a7, B:166:0x02b6, B:168:0x02bc, B:169:0x02cd, B:171:0x02d3, B:173:0x02e1, B:176:0x02e7, B:182:0x02ef, B:184:0x02f5, B:187:0x02f8, B:189:0x0300, B:191:0x0308, B:192:0x030d, B:194:0x0311, B:199:0x0320, B:201:0x0326, B:202:0x0337, B:204:0x033d, B:206:0x034b, B:209:0x0351, B:215:0x0359, B:217:0x035f, B:220:0x0362, B:227:0x00ac, B:228:0x0098, B:229:0x0083, B:230:0x0065), top: B:2:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        int myPid;
        String str5;
        boolean z16;
        String str6;
        String str7;
        JSONObject jSONObject2;
        boolean z17;
        JSONObject jSONObject3;
        boolean z18;
        JSONObject jSONObject4;
        boolean z19;
        int i3;
        JSONObject jSONObject5;
        boolean z26;
        JSONObject jSONObject6;
        boolean z27;
        JSONObject jSONObject7;
        boolean z28;
        JSONObject jSONObject8 = new JSONObject();
        try {
            if (!jSONObject.has("debug")) {
                str = "status";
                str2 = "summary";
                str3 = "meminfo";
                str4 = "proc";
            } else {
                JSONObject jSONObject9 = new JSONObject();
                Object obj = jSONObject.get("debug");
                if (!(obj instanceof JSONObject)) {
                    str = "status";
                    jSONObject7 = null;
                } else {
                    jSONObject7 = (JSONObject) obj;
                    str = "status";
                }
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (!z28 && (jSONObject7 == null || !jSONObject7.optBoolean("nativeHeapAllocatedSize"))) {
                    str2 = "summary";
                    str3 = "meminfo";
                    if (!z28 && (jSONObject7 == null || !jSONObject7.optBoolean("NativeHeapFreeSize"))) {
                        str4 = "proc";
                        if (!z28 || (jSONObject7 != null && jSONObject7.optBoolean("NativeHeapSize"))) {
                            jSONObject9.put("NativeHeapSize", Debug.getNativeHeapSize());
                        }
                        if (!z28 || (jSONObject7 != null && jSONObject7.optBoolean("Pss"))) {
                            jSONObject9.put("Pss", Debug.getNativeHeapSize());
                        }
                        if (jSONObject9.length() > 0) {
                            jSONObject8.put("debug", jSONObject9);
                        }
                    }
                    str4 = "proc";
                    jSONObject9.put("NativeHeapFreeSize", Debug.getNativeHeapFreeSize());
                    if (!z28) {
                    }
                    jSONObject9.put("NativeHeapSize", Debug.getNativeHeapSize());
                    if (!z28) {
                    }
                    jSONObject9.put("Pss", Debug.getNativeHeapSize());
                    if (jSONObject9.length() > 0) {
                    }
                }
                str2 = "summary";
                str3 = "meminfo";
                jSONObject9.put("NativeHeapAllocatedSize", Debug.getNativeHeapAllocatedSize());
                if (!z28) {
                    str4 = "proc";
                    if (!z28) {
                    }
                    jSONObject9.put("NativeHeapSize", Debug.getNativeHeapSize());
                    if (!z28) {
                    }
                    jSONObject9.put("Pss", Debug.getNativeHeapSize());
                    if (jSONObject9.length() > 0) {
                    }
                }
                str4 = "proc";
                jSONObject9.put("NativeHeapFreeSize", Debug.getNativeHeapFreeSize());
                if (!z28) {
                }
                jSONObject9.put("NativeHeapSize", Debug.getNativeHeapSize());
                if (!z28) {
                }
                jSONObject9.put("Pss", Debug.getNativeHeapSize());
                if (jSONObject9.length() > 0) {
                }
            }
            if (jSONObject.has("MemoryInfo")) {
                Object obj2 = jSONObject.get("MemoryInfo");
                if (obj2 instanceof JSONObject) {
                    jSONObject6 = (JSONObject) obj2;
                } else {
                    jSONObject6 = null;
                }
                if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27 || (jSONObject6 != null && jSONObject6.length() > 0)) {
                    JSONObject jSONObject10 = new JSONObject();
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    this.f32931c.getMemoryInfo(memoryInfo);
                    if (z27 || jSONObject6.has("availMem")) {
                        jSONObject10.put("availMem", memoryInfo.availMem);
                    }
                    if ((z27 || jSONObject6.has(HippyReporter.RemoveEngineReason.LOW_MEMORY)) && memoryInfo.lowMemory) {
                        jSONObject10.put(HippyReporter.RemoveEngineReason.LOW_MEMORY, true);
                    }
                    if (z27 || jSONObject6.has("totalMem")) {
                        jSONObject10.put("totalMem", memoryInfo.totalMem);
                    }
                    if (z27 || jSONObject6.has("threshold")) {
                        jSONObject10.put("threshold", memoryInfo.threshold);
                    }
                    if (jSONObject10.length() > 0) {
                        jSONObject8.put("MemoryInfo", jSONObject10);
                    }
                }
            }
            if (jSONObject.has("ActivityManager")) {
                JSONObject jSONObject11 = jSONObject.getJSONObject("ActivityManager");
                if (jSONObject11.has("MemoryClass")) {
                    jSONObject8.put("MemoryClass", this.f32931c.getMemoryClass() * 1048576);
                }
                if (jSONObject11.has("LargeMemoryClass")) {
                    jSONObject8.put("LargeMemoryClass", this.f32931c.getLargeMemoryClass() * 1048576);
                }
                if (jSONObject11.has("LowRamDevice")) {
                    jSONObject8.put("LowRamDevice", this.f32931c.isLowRamDevice());
                }
            }
            if (this.f32929a.b()) {
                jSONObject8.put("mapTester", true);
                this.f32929a.a();
            }
            int i16 = this.f32932d;
            if (i16 > 0) {
                jSONObject8.put("onTrim", i16);
                this.f32932d = 0;
            }
            myPid = Process.myPid();
            String str8 = str4;
            if (jSONObject.has(str8)) {
                Object obj3 = jSONObject.get(str8);
                if (obj3 instanceof JSONObject) {
                    jSONObject5 = (JSONObject) obj3;
                } else {
                    jSONObject5 = null;
                }
                if ((obj3 instanceof Boolean) && ((Boolean) obj3).booleanValue()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                JSONObject jSONObject12 = new JSONObject();
                if (z26 || jSONObject5.optBoolean("oom_score")) {
                    jSONObject12.put("oom_score", e.b(myPid));
                }
                if (jSONObject12.length() > 0) {
                    jSONObject8.put(str8, jSONObject12);
                }
            }
            str5 = str2;
        } catch (JSONException e16) {
            Log.w(f32928e, "Problem getting memory metrics", e16);
        }
        if (jSONObject.has(str5)) {
            Object obj4 = jSONObject.get(str5);
            if (obj4 instanceof JSONObject) {
                jSONObject4 = (JSONObject) obj4;
            } else {
                jSONObject4 = null;
            }
            if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19 || (jSONObject4 != null && jSONObject4.length() > 0)) {
                z16 = true;
                Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(this.f32931c, new int[]{myPid});
                JSONObject jSONObject13 = new JSONObject();
                int length = processMemoryInfo.length;
                for (int i17 = 0; i17 < length; i17++) {
                    for (Map.Entry<String, String> entry : processMemoryInfo[i17].getMemoryStats().entrySet()) {
                        String key = entry.getKey();
                        if (!z19 && !jSONObject4.has(key)) {
                            i3 = length;
                            length = i3;
                        }
                        i3 = length;
                        jSONObject13.put(key, jSONObject13.optLong(key) + (Long.parseLong(entry.getValue()) * 1024));
                        length = i3;
                    }
                }
                if (jSONObject13.length() > 0) {
                    jSONObject8.put(str5, jSONObject13);
                }
                str6 = str3;
                if (jSONObject.has(str6)) {
                    Object obj5 = jSONObject.get(str6);
                    if (obj5 instanceof JSONObject) {
                        jSONObject3 = (JSONObject) obj5;
                    } else {
                        jSONObject3 = null;
                    }
                    if ((obj5 instanceof Boolean) && ((Boolean) obj5).booleanValue()) {
                        z18 = z16;
                    } else {
                        z18 = false;
                    }
                    if (z18 || (jSONObject3 != null && jSONObject3.length() > 0)) {
                        JSONObject jSONObject14 = new JSONObject();
                        for (Map.Entry<String, Long> entry2 : e.c().entrySet()) {
                            String key2 = entry2.getKey();
                            if (z18 || jSONObject3.optBoolean(key2)) {
                                jSONObject14.put(key2, entry2.getValue());
                            }
                        }
                        if (jSONObject14.length() > 0) {
                            jSONObject8.put(str6, jSONObject14);
                        }
                    }
                }
                str7 = str;
                if (jSONObject.has(str7)) {
                    Object obj6 = jSONObject.get(str7);
                    if (obj6 instanceof JSONObject) {
                        jSONObject2 = (JSONObject) obj6;
                    } else {
                        jSONObject2 = null;
                    }
                    if ((obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue()) {
                        z17 = z16;
                    } else {
                        z17 = false;
                    }
                    if (z17 || (jSONObject2 != null && jSONObject2.length() > 0)) {
                        JSONObject jSONObject15 = new JSONObject();
                        for (Map.Entry<String, Long> entry3 : e.d(myPid).entrySet()) {
                            String key3 = entry3.getKey();
                            if (z17 || jSONObject2.optBoolean(key3)) {
                                jSONObject15.put(key3, entry3.getValue());
                            }
                        }
                        if (jSONObject15.length() > 0) {
                            jSONObject8.put(str7, jSONObject15);
                        }
                    }
                }
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("time", System.currentTimeMillis());
                jSONObject8.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject16);
                return jSONObject8;
            }
        }
        z16 = true;
        str6 = str3;
        if (jSONObject.has(str6)) {
        }
        str7 = str;
        if (jSONObject.has(str7)) {
        }
        JSONObject jSONObject162 = new JSONObject();
        jSONObject162.put("time", System.currentTimeMillis());
        jSONObject8.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject162);
        return jSONObject8;
    }
}
