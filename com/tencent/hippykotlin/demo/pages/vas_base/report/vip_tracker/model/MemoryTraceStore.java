package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MemoryTraceStore {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MemoryTraceStore.class, "localStorageTrace", "getLocalStorageTrace()Lcom/tencent/hippykotlin/demo/pages/vas_base/report/vip_tracker/model/TraceInfo;", 0)};
    public static final MemoryTraceStore INSTANCE = new MemoryTraceStore();
    public static final ReadWriteProperty localStorageTrace$delegate = c.a(new TraceInfo(null, null, null, 0, 15, null));

    public final TraceInfo getLocalStorageTrace() {
        return (TraceInfo) localStorageTrace$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
