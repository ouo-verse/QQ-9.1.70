package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/WinkAlbumItemType;", "", "viewType", "", "(Ljava/lang/String;II)V", "getViewType", "()I", "UI_TYPE_MEMORY_ALBUM_PREVIEW_ITEM", "UI_TYPE_NEW_ALBUM_PREVIEW_ITEM", "UI_TYPE_PREVIEW_FOOTER_ITEM", "UI_TYPE_PREVIEW_FOOTER_ITEM_FINISH", "UI_TYPE_TOPIC_EMPTY", "UI_TYPE_MEMORY_ALBUM_TOPIC_SMALL", "UI_TYPE_MEMORY_ALBUM_TOPIC_ONE_BIG", "UI_TYPE_TOPIC_UNAUTHORIZE", "UI_TYPE_TOPIC_LOADING", "UI_TYPE_NEW_ALBUM_TOPIC_SMALL", "UI_TYPE_NEW_ALBUM_TOPIC_ONE_BIG", "DATA_TYPE_MEMORY_ALBUM", "DATA_TYPE_NEW_ALBUM", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum WinkAlbumItemType {
    UI_TYPE_MEMORY_ALBUM_PREVIEW_ITEM(1),
    UI_TYPE_NEW_ALBUM_PREVIEW_ITEM(2),
    UI_TYPE_PREVIEW_FOOTER_ITEM(3),
    UI_TYPE_PREVIEW_FOOTER_ITEM_FINISH(4),
    UI_TYPE_TOPIC_EMPTY(50),
    UI_TYPE_MEMORY_ALBUM_TOPIC_SMALL(51),
    UI_TYPE_MEMORY_ALBUM_TOPIC_ONE_BIG(52),
    UI_TYPE_TOPIC_UNAUTHORIZE(53),
    UI_TYPE_TOPIC_LOADING(54),
    UI_TYPE_NEW_ALBUM_TOPIC_SMALL(55),
    UI_TYPE_NEW_ALBUM_TOPIC_ONE_BIG(56),
    DATA_TYPE_MEMORY_ALBUM(100),
    DATA_TYPE_NEW_ALBUM(101);

    private final int viewType;

    WinkAlbumItemType(int i3) {
        this.viewType = i3;
    }

    public final int getViewType() {
        return this.viewType;
    }
}
