package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OptionalTagAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(OptionalTagAttr.class, "tagTabObservable", "getTagTabObservable()Lcom/tencent/hippykotlin/demo/pages/nearby/new_profile_edit/view_model/TagTabObservable;", 0)};
    public final ReadWriteProperty tagTabObservable$delegate = c.a(new TagTabObservable(0, null, null, null, 0.0f, 31, null));
    public NBPTagsEditViewModel viewModel;

    public final TagTabObservable getTagTabObservable() {
        return (TagTabObservable) this.tagTabObservable$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
