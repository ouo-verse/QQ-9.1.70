package com.tencent.mobileqq.guild.homev2.parts;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/recyclerview/widget/RecyclerView;", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class p {
    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerView b(ViewPager2 viewPager2) {
        for (View view : ViewGroupKt.getChildren(viewPager2)) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
        }
        throw new IllegalStateException("ViewPager2 does not have RecyclerView child");
    }
}
