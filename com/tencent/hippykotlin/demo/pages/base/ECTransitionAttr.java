package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.m;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECTransitionAttr extends m {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECTransitionAttr.class, "transitionAppear", "getTransitionAppear()Z", 0)};
    public int transitionType = 5;
    public final ReadWriteProperty transitionAppear$delegate = c.a(Boolean.TRUE);

    public final boolean getTransitionAppear() {
        return ((Boolean) this.transitionAppear$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setTransitionAppear(boolean z16) {
        this.transitionAppear$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
