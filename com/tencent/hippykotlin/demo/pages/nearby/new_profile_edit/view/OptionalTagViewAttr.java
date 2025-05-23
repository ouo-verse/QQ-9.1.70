package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OptionalTagViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(OptionalTagViewAttr.class, "tag", "getTag()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/data/TagInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(OptionalTagViewAttr.class, "selected", "getSelected()Z", 0)};
    public NBPTagsEditViewModel viewModel;
    public final ReadWriteProperty tag$delegate = c.a(new TagInfo(null, 1, null));
    public final ReadWriteProperty selected$delegate = c.a(Boolean.FALSE);

    public final boolean getSelected() {
        return ((Boolean) this.selected$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final TagInfo getTag() {
        return (TagInfo) this.tag$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setSelected(boolean z16) {
        this.selected$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
