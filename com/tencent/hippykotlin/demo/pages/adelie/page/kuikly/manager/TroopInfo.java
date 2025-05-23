package com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TroopInfo {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TroopInfo.class, "uin", "getUin()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TroopInfo.class, "name", "getName()Ljava/lang/String;", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty uin$delegate = c.a("");
    public final ReadWriteProperty name$delegate = c.a("");

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public final String getName() {
        return (String) this.name$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final String getUin() {
        return (String) this.uin$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("uin=");
        m3.append(getUin());
        m3.append(", name=");
        m3.append(getName());
        return m3.toString();
    }
}
