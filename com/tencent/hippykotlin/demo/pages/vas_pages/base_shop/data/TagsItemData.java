package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.vm.VasVMData;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.reactive.collection.c;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TagsItemData extends ItemData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(TagsItemData.class, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "getTags()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty tags$delegate = ReactiveObserver.INSTANCE.d();
    public String jumpAllUrl = "";

    public final c<TagInfo> getTags() {
        return (c) this.tags$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class TagInfo extends VasVMData {
        public String iconUrl;
        public String jumpUrl;
        public String name;

        public TagInfo() {
            this.name = "";
            this.iconUrl = "";
            this.jumpUrl = "";
        }

        public TagInfo(String str, String str2, String str3) {
            this.name = str;
            this.iconUrl = str2;
            this.jumpUrl = str3;
        }
    }
}
