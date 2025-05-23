package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MBTITagAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MBTITagAttr.class, "selectTag", "getSelectTag()I", 0)};
    public int index;
    public String leftMeaning;
    public String leftTag;
    public String rightMeaning;
    public String rightTag;
    public final ReadWriteProperty selectTag$delegate;
    public NBPTagsEditViewModel viewModel;

    public MBTITagAttr() {
        this(null, null, null, null, 0, 31, null);
    }

    public final int getSelectTag() {
        return ((Number) this.selectTag$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final int hashCode() {
        return (this.leftTag + this.rightTag).hashCode();
    }

    public final void setSelectTag(int i3) {
        this.selectTag$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public /* synthetic */ MBTITagAttr(String str, String str2, String str3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", -1);
    }

    public MBTITagAttr(String str, String str2, String str3, String str4, int i3) {
        this.leftTag = str;
        this.leftMeaning = str2;
        this.rightTag = str3;
        this.rightMeaning = str4;
        this.index = i3;
        this.selectTag$delegate = c.a(-1);
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof MBTITagAttr) && ((MBTITagAttr) obj).index == this.index;
    }
}
