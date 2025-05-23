package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLoadingAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECLoadingAttr.class, "loadingText", "getLoadingText()Ljava/lang/String;", 0)};
    public boolean delayShow;
    public final ReadWriteProperty loadingText$delegate = c.a("");
    public int delayTime = 850;

    public final void setLoadingText(String str) {
        this.loadingText$delegate.setValue(this, $$delegatedProperties[0], str);
    }
}
