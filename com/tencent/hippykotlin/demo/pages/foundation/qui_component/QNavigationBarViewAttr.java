package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIColor;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QNavigationBarViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "showLeftIcon", "getShowLeftIcon$qecommerce_biz_release()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "bgColor", "getBgColor$qecommerce_biz_release()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "textColor", "getTextColor$qecommerce_biz_release()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "bgImg", "getBgImg$qecommerce_biz_release()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "rightIconList", "getRightIconList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "rightText", "getRightText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "rightClickHandler", "getRightClickHandler()Lkotlin/jvm/functions/Function1;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "leftIcon", "getLeftIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "leftClickHandler", "getLeftClickHandler()Lkotlin/jvm/functions/Function1;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "leftIconAccessibilityText", "getLeftIconAccessibilityText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "leftText", "getLeftText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "slotLeft", "getSlotLeft$qecommerce_biz_release()Lkotlin/jvm/functions/Function1;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "slotTitle", "getSlotTitle$qecommerce_biz_release()Lkotlin/jvm/functions/Function1;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "slotRight", "getSlotRight()Lkotlin/jvm/functions/Function1;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "slotLeftWidth", "getSlotLeftWidth$qecommerce_biz_release()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QNavigationBarViewAttr.class, "autoChangeStatusBarStyle", "getAutoChangeStatusBarStyle()Z", 0)};
    public final ReadWriteProperty autoChangeStatusBarStyle$delegate;
    public final ReadWriteProperty bgColor$delegate;
    public final ReadWriteProperty bgImg$delegate;
    public final ReadWriteProperty leftClickHandler$delegate;
    public final ReadWriteProperty leftIcon$delegate;
    public final ReadWriteProperty leftIconAccessibilityText$delegate;
    public final ReadWriteProperty leftText$delegate;
    public final ReadWriteProperty rightClickHandler$delegate;
    public final ReadWriteProperty rightIconList$delegate;
    public final ReadWriteProperty rightText$delegate;
    public final ReadWriteProperty showLeftIcon$delegate;
    public final ReadWriteProperty slotLeft$delegate;
    public final ReadWriteProperty slotLeftWidth$delegate;
    public final ReadWriteProperty slotRight$delegate;
    public final ReadWriteProperty slotTitle$delegate;
    public final ReadWriteProperty textColor$delegate;
    public final ReadWriteProperty title$delegate;

    public QNavigationBarViewAttr() {
        Boolean bool = Boolean.TRUE;
        this.showLeftIcon$delegate = c.a(bool);
        this.bgColor$delegate = c.a(QUISkinColor.INSTANCE.bgNavAIO());
        this.textColor$delegate = c.a(QUIColor.INSTANCE.getTextPrimary());
        this.bgImg$delegate = c.a("");
        this.title$delegate = c.a("");
        this.rightIconList$delegate = c.b();
        this.rightText$delegate = c.a("");
        this.rightClickHandler$delegate = c.a(null);
        this.leftIcon$delegate = c.a("");
        this.leftClickHandler$delegate = c.a(null);
        this.leftIconAccessibilityText$delegate = c.a("");
        this.leftText$delegate = c.a("");
        this.slotLeft$delegate = c.a(null);
        this.slotTitle$delegate = c.a(null);
        this.slotRight$delegate = c.a(null);
        this.slotLeftWidth$delegate = c.a(Float.valueOf(-1.0f));
        this.autoChangeStatusBarStyle$delegate = c.a(bool);
    }

    public static final Function1 access$getLeftClickHandler(QNavigationBarViewAttr qNavigationBarViewAttr) {
        return (Function1) qNavigationBarViewAttr.leftClickHandler$delegate.getValue(qNavigationBarViewAttr, $$delegatedProperties[9]);
    }

    public final h getTextColor$qecommerce_biz_release() {
        return (h) this.textColor$delegate.getValue(this, $$delegatedProperties[2]);
    }
}
