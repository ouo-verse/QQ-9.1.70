package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoSubmitLoadingAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoSubmitLoadingAttr.class, "text", "getText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoSubmitLoadingAttr.class, "icon", "getIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoSubmitLoadingAttr.class, "showAnimation", "getShowAnimation()Z", 0)};
    public final ReadWriteProperty text$delegate = c.a("");
    public final ReadWriteProperty icon$delegate = c.a("");
    public final ReadWriteProperty showAnimation$delegate = c.a(Boolean.FALSE);

    public final void setIcon(String str) {
        this.icon$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setShowAnimation(boolean z16) {
        this.showAnimation$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final void setText(String str) {
        this.text$delegate.setValue(this, $$delegatedProperties[0], str);
    }
}
