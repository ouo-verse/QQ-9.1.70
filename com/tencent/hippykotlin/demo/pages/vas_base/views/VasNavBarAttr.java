package com.tencent.hippykotlin.demo.pages.vas_base.views;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasNavBarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(VasNavBarAttr.class, "navTitle", "getNavTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(VasNavBarAttr.class, "bgColor", "getBgColor()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(VasNavBarAttr.class, "textColor", "getTextColor()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(VasNavBarAttr.class, "bgImg", "getBgImg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(VasNavBarAttr.class, "rightText", "getRightText()Ljava/lang/String;", 0)};
    public final ReadWriteProperty bgColor$delegate;
    public final ReadWriteProperty bgImg$delegate;
    public final ReadWriteProperty navTitle$delegate = c.a("");
    public final ReadWriteProperty rightText$delegate;
    public final ReadWriteProperty textColor$delegate;

    public VasNavBarAttr() {
        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
        this.bgColor$delegate = c.a(qUISkinColor.bgNavAIO());
        this.textColor$delegate = c.a(qUISkinColor.textNavSecondary());
        this.bgImg$delegate = c.a("");
        this.rightText$delegate = c.a("");
    }
}
