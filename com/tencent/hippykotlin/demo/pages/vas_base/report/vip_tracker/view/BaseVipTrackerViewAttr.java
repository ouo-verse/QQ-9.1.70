package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BaseVipTrackerViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BaseVipTrackerViewAttr.class, "exposeActive", "getExposeActive()Z", 0)};
    public BaseVipTrackerView<?, ?> parentVt;
    public final Tracker tracker = new Tracker(null, null, null, null, null, null, false, null, null, null, null, 0, 4095, null);
    public int exposeStrategy = 1;
    public final ReadWriteProperty exposeActive$delegate = c.a(Boolean.TRUE);

    public final boolean getExposeActive() {
        return ((Boolean) this.exposeActive$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }
}
