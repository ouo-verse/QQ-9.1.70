package com.tencent.state.common.tag;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BM\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\nR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/common/tag/DialogTagSetInfo;", "", "ownerTags", "Ljava/util/ArrayList;", "Lcom/tencent/state/common/tag/TagCategoryInfo;", "Lkotlin/collections/ArrayList;", "deskMateTags", "Lcom/tencent/state/common/tag/CommonTagInfo;", "ownerSelectTag", "deskMateSelectTag", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/state/common/tag/TagCategoryInfo;Lcom/tencent/state/common/tag/CommonTagInfo;)V", "getDeskMateSelectTag", "()Lcom/tencent/state/common/tag/CommonTagInfo;", "getDeskMateTags", "()Ljava/util/ArrayList;", "getOwnerSelectTag", "()Lcom/tencent/state/common/tag/TagCategoryInfo;", "getOwnerTags", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class DialogTagSetInfo {
    private final CommonTagInfo deskMateSelectTag;
    private final ArrayList<CommonTagInfo> deskMateTags;
    private final TagCategoryInfo ownerSelectTag;
    private final ArrayList<TagCategoryInfo> ownerTags;

    public DialogTagSetInfo(ArrayList<TagCategoryInfo> ownerTags, ArrayList<CommonTagInfo> deskMateTags, TagCategoryInfo tagCategoryInfo, CommonTagInfo commonTagInfo) {
        Intrinsics.checkNotNullParameter(ownerTags, "ownerTags");
        Intrinsics.checkNotNullParameter(deskMateTags, "deskMateTags");
        this.ownerTags = ownerTags;
        this.deskMateTags = deskMateTags;
        this.ownerSelectTag = tagCategoryInfo;
        this.deskMateSelectTag = commonTagInfo;
    }

    public final CommonTagInfo getDeskMateSelectTag() {
        return this.deskMateSelectTag;
    }

    public final ArrayList<CommonTagInfo> getDeskMateTags() {
        return this.deskMateTags;
    }

    public final TagCategoryInfo getOwnerSelectTag() {
        return this.ownerSelectTag;
    }

    public final ArrayList<TagCategoryInfo> getOwnerTags() {
        return this.ownerTags;
    }

    public /* synthetic */ DialogTagSetInfo(ArrayList arrayList, ArrayList arrayList2, TagCategoryInfo tagCategoryInfo, CommonTagInfo commonTagInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, arrayList2, (i3 & 4) != 0 ? null : tagCategoryInfo, (i3 & 8) != 0 ? null : commonTagInfo);
    }
}
