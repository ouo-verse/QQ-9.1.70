package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UploadBackgroundAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundAttr.class, "itemId", "getItemId()I", 0)};
    public final ReadWriteProperty itemId$delegate = c.a(0);
    public float viewHeight;
    public float viewWidth;

    public final int getItemId() {
        return ((Number) this.itemId$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }
}
