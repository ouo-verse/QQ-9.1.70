package com.tencent.state.library.tag;

import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.common.tag.DialogTagSetInfo;
import com.tencent.state.common.tag.TagCategoryInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"defaultDialogTagSetInfo", "Lcom/tencent/state/common/tag/DialogTagSetInfo;", "getDefaultDialogTagSetInfo", "()Lcom/tencent/state/common/tag/DialogTagSetInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryTagInfoKt {
    private static final DialogTagSetInfo defaultDialogTagSetInfo;

    static {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new CommonTagInfo("1", "\u9759\u4e0b\u5fc3\u4e13\u6ce8\uff0c\u597d\u597d\u5b66\u4e60"));
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new CommonTagInfo("101", "\u4e00\u5206\u8015\u8018\uff0c\u4e00\u4efd\u6536\u83b7"));
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new TagCategoryInfo("xuexi", "\u5b66\u4e60", arrayListOf), new TagCategoryInfo("xiezuoye", "\u5199\u4f5c\u4e1a", arrayListOf2));
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(new CommonTagInfo("1", "\u968f\u7f18\u5c31\u597d"));
        defaultDialogTagSetInfo = new DialogTagSetInfo(arrayListOf3, arrayListOf4, null, null, 12, null);
    }

    public static final DialogTagSetInfo getDefaultDialogTagSetInfo() {
        return defaultDialogTagSetInfo;
    }
}
