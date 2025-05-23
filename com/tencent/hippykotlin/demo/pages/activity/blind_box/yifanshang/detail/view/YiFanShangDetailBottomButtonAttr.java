package com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view;

import c01.c;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class YiFanShangDetailBottomButtonAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "bottomButtonMode", "getBottomButtonMode()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonMode;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "firstButton", "getFirstButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "secondButton", "getSecondButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "thirdButton", "getThirdButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "showLastShangTag", "getShowLastShangTag()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "cover", "getCover()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "firstJumpUrl", "getFirstJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "secondJumpUrl", "getSecondJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(YiFanShangDetailBottomButtonAttr.class, "thirdJumpUrl", "getThirdJumpUrl()Ljava/lang/String;", 0)};
    public final ReadWriteProperty bottomButtonMode$delegate = c.a(ButtonMode.NONE);
    public final ReadWriteProperty firstButton$delegate = c.a(new ButtonInfo(true, "\u62bd\u4e00\u5f20", "", false));
    public final ReadWriteProperty secondButton$delegate = c.a(new ButtonInfo(true, "\u62bd\u4e09\u5f20", "", false));
    public final ReadWriteProperty thirdButton$delegate = c.a(new ButtonInfo(true, "\u5168\u6536", "", false));
    public final ReadWriteProperty showLastShangTag$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty cover$delegate = c.a("");
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty firstJumpUrl$delegate = c.a("");
    public final ReadWriteProperty secondJumpUrl$delegate = c.a("");
    public final ReadWriteProperty thirdJumpUrl$delegate = c.a("");

    public final ButtonMode getBottomButtonMode() {
        return (ButtonMode) this.bottomButtonMode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final ButtonInfo getFirstButton() {
        return (ButtonInfo) this.firstButton$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final ButtonInfo getSecondButton() {
        return (ButtonInfo) this.secondButton$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final ButtonInfo getThirdButton() {
        return (ButtonInfo) this.thirdButton$delegate.getValue(this, $$delegatedProperties[3]);
    }
}
