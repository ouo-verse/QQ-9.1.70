package com.qzone.reborn.albumx.qzone.local;

import cooperation.qzone.report.QZonePushReporter;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/f;", "", "", "sceneID", "", "a", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f52661a = new f();

    f() {
    }

    public final void a(int sceneID) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_recommend_licensing");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, "clck");
        String i3 = com.tencent.open.adapter.a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneID", sceneID);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject2);
        fo.c.c("ev_qz_recommend_licensing_clck", linkedHashMap);
    }

    public final void b(int sceneID) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_recommend_licensing");
        linkedHashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, "imp");
        String i3 = com.tencent.open.adapter.a.f().i();
        Intrinsics.checkNotNullExpressionValue(i3, "getInstance().getQUA3()");
        linkedHashMap.put("qua", i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneID", sceneID);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventValue.toString()");
        linkedHashMap.put(QZonePushReporter.EVENT_VALUE, jSONObject2);
        fo.c.c("ev_qz_recommend_licensing_imp", linkedHashMap);
    }
}
