package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideTagPickerAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickerAttr.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickerAttr.class, "selectedTagList", "getSelectedTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty tagList$delegate = c.b();
    public final ReadWriteProperty selectedTagList$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<a> getSelectedTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedTagList$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
