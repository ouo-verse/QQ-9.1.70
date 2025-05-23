package com.tencent.mobileqq.wink.pager;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u001aB\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u001a,\u0010\u000f\u001a\u00020\u000e\"\f\b\u0000\u0010\u0000*\u00020\u000b*\u00020\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\r2\u0006\u0010\u0002\u001a\u00020\u0001\u001a4\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\f\b\u0000\u0010\u0000*\u00020\u000b*\u00020\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u00102\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0012"}, d2 = {"T", "", "pageId", "pageName", "", "isLightTheme", "needBottomPadding", "Lkotlin/Function0;", "initializer", "Lcom/tencent/mobileqq/wink/pager/b;", "b", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "", "", "a", "", "d", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {
    public static final <T extends Fragment & FragmentPager.d> int a(@NotNull List<? extends b<? extends T>> list, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Iterator<? extends b<? extends T>> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(it.next().getPageId(), pageId)) {
                i3++;
            } else {
                return i3;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T> b<T> b(@NotNull String pageId, @NotNull String pageName, boolean z16, boolean z17, @NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new b<>(pageId, pageName, z16, z17, initializer);
    }

    public static /* synthetic */ b c(String str, String str2, boolean z16, boolean z17, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        return b(str, str2, z16, z17, function0);
    }

    @Nullable
    public static final <T extends Fragment & FragmentPager.d> b<T> d(@NotNull List<b<T>> list, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        int a16 = a(list, pageId);
        if (a16 > -1) {
            return list.remove(a16);
        }
        return null;
    }
}
