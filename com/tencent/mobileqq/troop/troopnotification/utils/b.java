package com.tencent.mobileqq.troop.troopnotification.utils;

import android.text.format.Time;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTemplateItem;
import com.tencent.qqnt.report.n;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J:\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0001H\u0002J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0018*\u00020\u0015H\u0002J@\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\t\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/utils/b;", "", "", "category", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "notifies", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyTemplateItem;", DKConfiguration.Directory.TEMPLATES, "", "curReadSeq", "", "Lcom/tencent/qqnt/notification/f;", "i", "", "seq", "modelId", "a", "jsonStr", "Lorg/json/JSONArray;", "d", "Lorg/json/JSONObject;", "f", "b", "", "c", "from", tl.h.F, "data", "e", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "g", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f300925a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f300925a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(String seq, int modelId) {
        return seq + "-" + modelId;
    }

    private final List<Object> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object value = jSONArray.get(i3);
            if (value instanceof JSONArray) {
                value = b((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = c((JSONObject) value);
            }
            Intrinsics.checkNotNullExpressionValue(value, "value");
            arrayList.add(value);
        }
        return arrayList;
    }

    private final Map<String, Object> c(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = jSONObject.get(key);
            if (value instanceof JSONArray) {
                value = b((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = c((JSONObject) value);
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            hashMap.put(key, value);
        }
        return hashMap;
    }

    private final JSONArray d(String jsonStr) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        if (jsonStr != null && jsonStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jsonStr, "{", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jsonStr, "[", false, 2, null);
                if (startsWith$default2) {
                    return new JSONArray(jsonStr);
                }
                QLog.e("TroopNotificationJsonUtils", 1, "parseAnyToArray: jsonStr=" + jsonStr);
                return new JSONArray();
            }
            JSONArray mo162put = new JSONArray().mo162put(new JSONObject(jsonStr));
            Intrinsics.checkNotNullExpressionValue(mo162put, "{\n            JSONArray(\u2026bject(jsonStr))\n        }");
            return mo162put;
        }
        return new JSONArray();
    }

    private final JSONObject f(Object jsonStr) {
        if (jsonStr instanceof String) {
            return new JSONObject((String) jsonStr);
        }
        if (jsonStr instanceof JSONObject) {
            return (JSONObject) jsonStr;
        }
        QLog.e("TroopNotificationJsonUtils", 1, "parseJsonObjCompat: jsonStr=" + jsonStr);
        return new JSONObject();
    }

    private final List<com.tencent.qqnt.notification.f> i(int category, List<GroupNotifyMsg> notifies, List<GroupNotifyTemplateItem> templates, long curReadSeq) {
        String str;
        String str2;
        boolean z16;
        String str3;
        JSONObject jSONObject;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList;
        LinkedHashMap linkedHashMap2;
        boolean z17;
        boolean z18;
        b bVar = this;
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        Iterator it = templates.iterator();
        while (true) {
            str = "detailModelId";
            str2 = "listModelId";
            if (!it.hasNext()) {
                break;
            }
            GroupNotifyTemplateItem groupNotifyTemplateItem = (GroupNotifyTemplateItem) it.next();
            String seq = groupNotifyTemplateItem.seq;
            b bVar2 = f300925a;
            JSONArray d16 = bVar2.d(groupNotifyTemplateItem.listTemplate);
            JSONArray d17 = bVar2.d(groupNotifyTemplateItem.detailTemplate);
            int length = d16.length();
            int i3 = 0;
            while (i3 < length) {
                b bVar3 = f300925a;
                Object obj = d16.get(i3);
                Iterator it5 = it;
                Intrinsics.checkNotNullExpressionValue(obj, "listModelArray.get(i)");
                JSONObject f16 = bVar3.f(obj);
                int optInt = f16.optInt("listModelId");
                Intrinsics.checkNotNullExpressionValue(seq, "seq");
                linkedHashMap3.put(bVar3.a(seq, optInt), f16);
                i3++;
                it = it5;
            }
            Iterator it6 = it;
            int length2 = d17.length();
            for (int i16 = 0; i16 < length2; i16++) {
                b bVar4 = f300925a;
                Object obj2 = d17.get(i16);
                Intrinsics.checkNotNullExpressionValue(obj2, "detailModelArray.get(i)");
                JSONObject f17 = bVar4.f(obj2);
                int optInt2 = f17.optInt("detailModelId");
                Intrinsics.checkNotNullExpressionValue(seq, "seq");
                linkedHashMap4.put(bVar4.a(seq, optInt2), f17);
            }
            it = it6;
        }
        for (GroupNotifyMsg groupNotifyMsg : notifies) {
            String str4 = groupNotifyMsg.showModuleMsg;
            if (str4 != null && str4.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e("TroopNotificationJsonUtils", 1, "preprocessDataInner: showModuleMsg is null, category=" + category + ", seq=" + groupNotifyMsg.seq + ", templateSeq=" + groupNotifyMsg.templateSeq);
            } else {
                JSONObject jSONObject2 = new JSONObject(groupNotifyMsg.showModuleMsg);
                int optInt3 = jSONObject2.optInt(str2);
                int optInt4 = jSONObject2.optInt(str);
                String str5 = str2;
                if (QLog.isColorLevel()) {
                    long j3 = groupNotifyMsg.seq;
                    StringBuilder sb5 = new StringBuilder();
                    str3 = str;
                    sb5.append("preprocessDataInner: parse json, category=");
                    sb5.append(category);
                    sb5.append(", seq=");
                    sb5.append(j3);
                    sb5.append(", showModuleMsg=");
                    sb5.append(jSONObject2);
                    QLog.d("TroopNotificationJsonUtils", 2, sb5.toString());
                } else {
                    str3 = str;
                }
                String str6 = groupNotifyMsg.templateSeq;
                Intrinsics.checkNotNullExpressionValue(str6, "msg.templateSeq");
                JSONObject jSONObject3 = (JSONObject) linkedHashMap3.get(bVar.a(str6, optInt3));
                String str7 = groupNotifyMsg.templateSeq;
                Intrinsics.checkNotNullExpressionValue(str7, "msg.templateSeq");
                JSONObject jSONObject4 = (JSONObject) linkedHashMap4.get(bVar.a(str7, optInt4));
                if (jSONObject3 == null) {
                    arrayList = arrayList2;
                    linkedHashMap2 = linkedHashMap3;
                    long j16 = groupNotifyMsg.seq;
                    linkedHashMap = linkedHashMap4;
                    String str8 = groupNotifyMsg.templateSeq;
                    StringBuilder sb6 = new StringBuilder();
                    jSONObject = jSONObject3;
                    sb6.append("preprocessDataInner: not find listTemplate, category=");
                    sb6.append(category);
                    sb6.append(", seq=");
                    sb6.append(j16);
                    sb6.append(", templateSeq=");
                    sb6.append(str8);
                    sb6.append(", listModelId=");
                    sb6.append(optInt3);
                    sb6.append(", dataJson=");
                    sb6.append(jSONObject2);
                    QLog.e("TroopNotificationJsonUtils", 1, sb6.toString());
                } else {
                    jSONObject = jSONObject3;
                    linkedHashMap = linkedHashMap4;
                    arrayList = arrayList2;
                    linkedHashMap2 = linkedHashMap3;
                }
                if (jSONObject4 == null) {
                    z17 = true;
                    QLog.e("TroopNotificationJsonUtils", 1, "preprocessDataInner: not find detailTemplate, category=" + category + ", seq=" + groupNotifyMsg.seq + ", templateSeq=" + groupNotifyMsg.templateSeq + ", listModelId=" + optInt4 + ", dataJson=" + jSONObject2);
                } else {
                    z17 = true;
                }
                if (jSONObject != null && jSONObject4 != null) {
                    JSONObject jSONObject5 = jSONObject;
                    int optInt5 = jSONObject5.optInt("styleId");
                    int optInt6 = jSONObject4.optInt("styleId");
                    Map<String, Object> c16 = c(jSONObject5);
                    Map<String, Object> c17 = c(jSONObject4);
                    Map<String, Object> c18 = c(jSONObject2);
                    com.tencent.qqnt.notification.e eVar = new com.tencent.qqnt.notification.e(optInt5, optInt3, c16, c18);
                    com.tencent.qqnt.notification.e eVar2 = new com.tencent.qqnt.notification.e(optInt6, optInt4, c17, c18);
                    if (groupNotifyMsg.seq <= curReadSeq) {
                        z18 = z17;
                    } else {
                        z18 = false;
                    }
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(new com.tencent.qqnt.notification.f(category, groupNotifyMsg, eVar, eVar2, z18, null, false, false, null, 480, null));
                    bVar = this;
                    str = str3;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                    str2 = str5;
                    arrayList2 = arrayList3;
                } else {
                    bVar = this;
                    str2 = str5;
                    str = str3;
                    arrayList2 = arrayList;
                    linkedHashMap3 = linkedHashMap2;
                    linkedHashMap4 = linkedHashMap;
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.json.JSONArray] */
    @NotNull
    public final Object e(@NotNull Object data) {
        Object jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof List) {
            jSONObject = new JSONArray();
            for (Object obj : (Iterable) data) {
                if (obj != null) {
                    jSONObject.mo162put(f300925a.e(obj));
                }
            }
        } else if (data instanceof Map) {
            jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) data).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if ((key instanceof String) && value != null) {
                    jSONObject.putOpt((String) key, f300925a.e(value));
                }
            }
        } else {
            return data;
        }
        return jSONObject;
    }

    @NotNull
    public final String g(long timeStamp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, timeStamp);
        }
        Time time = new Time();
        time.set(timeStamp);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        if (time.year == time2.year) {
            String p16 = en.p(timeStamp, true, "MM-dd");
            Intrinsics.checkNotNullExpressionValue(p16, "{\n            TimeFormat\u2026 true, \"MM-dd\")\n        }");
            return p16;
        }
        String p17 = en.p(timeStamp, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Intrinsics.checkNotNullExpressionValue(p17, "{\n            TimeFormat\u2026, \"yyyy-MM-dd\")\n        }");
        return p17;
    }

    @NotNull
    public final List<com.tencent.qqnt.notification.f> h(int category, @NotNull List<GroupNotifyMsg> notifies, @NotNull List<GroupNotifyTemplateItem> templates, long curReadSeq, @NotNull String from) {
        List<com.tencent.qqnt.notification.f> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(category), notifies, templates, Long.valueOf(curReadSeq), from);
        }
        Intrinsics.checkNotNullParameter(notifies, "notifies");
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(from, "from");
        n nVar = new n(from, category, notifies.size(), templates.size());
        try {
            arrayList = i(category, notifies, templates, curReadSeq);
        } catch (Exception e16) {
            QLog.e("TroopNotificationJsonUtils", 1, "[preprocessData]: ", e16);
            nVar.e(e16);
            arrayList = new ArrayList<>();
        }
        if (!notifies.isEmpty()) {
            nVar.b();
        }
        return arrayList;
    }
}
