package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEmptyViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECEmptyViewAttr.class, "emptyText", "getEmptyText()Ljava/lang/String;", 0)};
    public h backgroundColor;
    public Float positionTop;
    public h textColor;
    public final ReadWriteProperty emptyText$delegate = c.a("");
    public String emptyImgToken = "qecommerce_skin_emptystate_img_wuwangluo";

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: backgroundColor */
    public final Attr mo113backgroundColor(h hVar) {
        this.backgroundColor = hVar;
        return this;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: backgroundColor, reason: collision with other method in class */
    public final d mo113backgroundColor(h hVar) {
        this.backgroundColor = hVar;
        return this;
    }
}
