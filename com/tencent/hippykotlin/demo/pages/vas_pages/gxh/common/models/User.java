package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models;

import b01.a;
import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class User implements a {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "isVip", "isVip()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "isSvip", "isSvip()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "name", "getName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "svipSavedMoney", "getSvipSavedMoney()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "freeSetItemNum", "getFreeSetItemNum()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "discountPayItemNum", "getDiscountPayItemNum()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(User.class, "monthLuckybagNum", "getMonthLuckybagNum()I", 0)};
    public final ReadWriteProperty discountPayItemNum$delegate;
    public final ReadWriteProperty freeSetItemNum$delegate;
    public final ReadWriteProperty isSvip$delegate;
    public final ReadWriteProperty isVip$delegate;
    public final ReadWriteProperty monthLuckybagNum$delegate;
    public final ReadWriteProperty name$delegate;
    public final ReadWriteProperty svipSavedMoney$delegate;

    public User() {
        Boolean bool = Boolean.FALSE;
        this.isVip$delegate = c.a(bool);
        this.isSvip$delegate = c.a(bool);
        this.name$delegate = c.a("");
        this.svipSavedMoney$delegate = c.a(0);
        this.freeSetItemNum$delegate = c.a(0);
        this.discountPayItemNum$delegate = c.a(0);
        this.monthLuckybagNum$delegate = c.a(0);
    }

    @Override // b01.a
    public final void deserialization(e eVar) {
        boolean z16 = eVar.j("isClub") == 1;
        ReadWriteProperty readWriteProperty = this.isVip$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], Boolean.valueOf(z16));
        this.isSvip$delegate.setValue(this, kPropertyArr[1], Boolean.valueOf(eVar.j("isSuperclub") == 1));
        String p16 = eVar.p("name");
        if (p16 != null) {
            this.name$delegate.setValue(this, kPropertyArr[2], p16);
        }
        this.svipSavedMoney$delegate.setValue(this, kPropertyArr[3], Integer.valueOf(eVar.j("sum") / 100));
        this.freeSetItemNum$delegate.setValue(this, kPropertyArr[4], Integer.valueOf(eVar.j("freeSetItemNum")));
        this.discountPayItemNum$delegate.setValue(this, kPropertyArr[5], Integer.valueOf(eVar.j("discountPayItemNum")));
        this.monthLuckybagNum$delegate.setValue(this, kPropertyArr[6], Integer.valueOf(eVar.j("monthLuckybagNum")));
    }
}
