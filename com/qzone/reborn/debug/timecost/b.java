package com.qzone.reborn.debug.timecost;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R:\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/debug/timecost/b;", "", "", "groupName", "itemName", "", QCircleWeakNetReporter.KEY_COST, "", "c", "", "Lcom/qzone/reborn/debug/timecost/c;", "a", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "setMTimeCostMap", "(Ljava/util/Map;)V", "mTimeCostMap", "mGroupNameMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f53835a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Map<String, c>> mTimeCostMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> mGroupNameMap;

    static {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("section_lifecycle", "Section\u751f\u547d\u5468\u671f"), TuplesKt.to("part_lifecycle", "Part\u751f\u547d\u5468\u671f"), TuplesKt.to("item_view_measure", "Feed Item\u6d4b\u91cf"), TuplesKt.to("item_view_stub_inflate", "ViewStub Inflate"), TuplesKt.to("hook_binder_transact", "Binder\u901a\u4fe1"), TuplesKt.to("hook_view_measure", "Hook View onMeasure"), TuplesKt.to("hook_view_constructor", "View\u5b9e\u4f8b\u5316"));
        mGroupNameMap = mutableMapOf;
    }

    b() {
    }

    public final Map<String, Map<String, c>> b() {
        return mTimeCostMap;
    }

    public final void c(String groupName, String itemName, long cost) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(itemName, "itemName");
    }

    public final Map<String, c> a(String groupName) {
        if (groupName == null) {
            return null;
        }
        return mTimeCostMap.get(groupName);
    }
}
