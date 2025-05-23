package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TagViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TagViewAttr.class, "tag", "getTag()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/data/TagInfo;", 0)};
    public final ReadWriteProperty tag$delegate = c.a(new TagInfo(null, 1, null));

    public final TagInfo getTag() {
        return (TagInfo) this.tag$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTag(TagInfo tagInfo) {
        this.tag$delegate.setValue(this, $$delegatedProperties[0], tagInfo);
    }
}
