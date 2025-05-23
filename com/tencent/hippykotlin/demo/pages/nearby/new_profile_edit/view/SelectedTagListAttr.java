package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import c01.c;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SelectedTagListAttr extends k {
    public NBPTagsEditViewModel viewModel;

    static {
        Reflection.mutableProperty1(new MutablePropertyReference1Impl(SelectedTagListAttr.class, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "getTags()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0));
    }

    public SelectedTagListAttr() {
        c.b();
    }
}
