package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "", "a", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j {
    public static final float a(@NotNull SearchIcon searchIcon) {
        int i3;
        Intrinsics.checkNotNullParameter(searchIcon, "<this>");
        int i16 = searchIcon.width;
        if (i16 != 0 && (i3 = searchIcon.height) != 0) {
            return i16 / i3;
        }
        return 2.5f;
    }
}
