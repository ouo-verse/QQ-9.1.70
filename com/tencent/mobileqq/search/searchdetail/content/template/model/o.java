package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchNineBoxContent;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGuildJump;", "", "b", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class o {
    public static final float a(@NotNull SearchNineBoxContent searchNineBoxContent) {
        int i3;
        Intrinsics.checkNotNullParameter(searchNineBoxContent, "<this>");
        SearchPicture searchPicture = searchNineBoxContent.picture.small;
        if (searchPicture != null && (i3 = searchPicture.height) != 0) {
            return searchPicture.width / i3;
        }
        return 1.7777778f;
    }

    public static final boolean b(@Nullable SearchGuildJump searchGuildJump) {
        if (searchGuildJump != null && searchGuildJump.guildId > 0) {
            return false;
        }
        return true;
    }
}
