package com.tencent.state.common.tag;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/common/tag/TagCategoryInfo;", "", "category", "", "categoryName", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Ljava/util/ArrayList;", "Lcom/tencent/state/common/tag/CommonTagInfo;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCategory", "()Ljava/lang/String;", "getCategoryName", "getTags", "()Ljava/util/ArrayList;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class TagCategoryInfo {
    private final String category;
    private final String categoryName;
    private final ArrayList<CommonTagInfo> tags;

    public TagCategoryInfo(String category, String categoryName, ArrayList<CommonTagInfo> tags) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.category = category;
        this.categoryName = categoryName;
        this.tags = tags;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final ArrayList<CommonTagInfo> getTags() {
        return this.tags;
    }
}
