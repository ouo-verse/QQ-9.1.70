package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TagTabObservable {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TagTabObservable.class, "tagLines", "getTagLines()I", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(TagTabObservable.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TagTabObservable.class, "expanded", "getExpanded()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TagTabObservable.class, "collapsedSpaceEnough", "getCollapsedSpaceEnough()Z", 0)};
    public final ReadWriteProperty collapsedSpaceEnough$delegate;
    public final ReadWriteProperty expanded$delegate;
    public float pageViewWidth;
    public final ReadWriteProperty tagLines$delegate;
    public final ReadWriteProperty tagList$delegate;
    public final int tagType;
    public final String tagTypeIcon;
    public final String tagTypeName;
    public final List<TagInfo> tags;

    public TagTabObservable() {
        this(0, null, null, null, 0.0f, 31, null);
    }

    public final void getCollapsedTags() {
        if (getTagLines() < 3) {
            getTagList().clear();
            getTagList().addAll(this.tags);
            return;
        }
        getTagList().clear();
        float f16 = this.pageViewWidth - 32.0f;
        float f17 = 0.0f;
        int i3 = 1;
        for (TagInfo tagInfo : this.tags) {
            float f18 = tagInfo.viewWith;
            if (f17 + f18 > f16) {
                i3++;
                f17 = f18 + 12.0f;
                if (i3 <= 2) {
                    getTagList().add(tagInfo);
                }
            } else {
                f17 += f18 + 12.0f;
                if (i3 == 1 || (i3 == 2 && ((float) 60) + f17 < f16)) {
                    getTagList().add(tagInfo);
                }
            }
        }
    }

    public final boolean getExpanded() {
        return ((Boolean) this.expanded$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final int getTagLines() {
        return ((Number) this.tagLines$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final c<TagInfo> getTagList() {
        return (c) this.tagList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public TagTabObservable(int i3, String str, List<TagInfo> list, String str2, float f16) {
        this.tagType = i3;
        this.tagTypeName = str;
        this.tags = list;
        this.tagTypeIcon = str2;
        this.pageViewWidth = f16;
        this.tagLines$delegate = c01.c.a(0);
        this.tagList$delegate = c01.c.b();
        Boolean bool = Boolean.FALSE;
        this.expanded$delegate = c01.c.a(bool);
        this.collapsedSpaceEnough$delegate = c01.c.a(bool);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TagTabObservable(int i3, String str, List list, String str2, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", r4, "", 375.0f);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
    }
}
