package com.tencent.mobileqq.zplan.servlet;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/c;", "", "", "Lhu4/l;", "info", "Lorg/json/JSONArray;", "b", "([Lhu4/l;)Lorg/json/JSONArray;", "", HippyControllerProps.STRING, "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f335402a = new c();

    c() {
    }

    public final List<hu4.l> a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("desc");
                String optString2 = jSONObject.optString(QZoneDTLoginReporter.SCHEMA);
                hu4.l lVar = new hu4.l();
                lVar.f406385a = optString;
                lVar.f406386b = optString2;
                arrayList.add(lVar);
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("JsonObject", 1, "parse JsonArray fail " + string + ", " + e16);
            return arrayList;
        }
    }

    public final JSONArray b(hu4.l[] info) {
        Intrinsics.checkNotNullParameter(info, "info");
        JSONArray jSONArray = new JSONArray();
        for (hu4.l lVar : info) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("desc", lVar.f406385a);
            jSONObject.put(QZoneDTLoginReporter.SCHEMA, lVar.f406386b);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }
}
