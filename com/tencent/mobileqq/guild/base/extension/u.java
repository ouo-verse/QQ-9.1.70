package com.tencent.mobileqq.guild.base.extension;

import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildViewPagerContainer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroidx/viewpager2/widget/ViewPager2;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class u {
    public static final void a(@NotNull ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "<this>");
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            declaredField2.setAccessible(true);
            Intrinsics.checkNotNull(declaredField2.get(recyclerView), "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf((int) (((Integer) r1).intValue() * 3.5d)));
            ViewParent parent = viewPager2.getParent();
            while (true) {
                if (parent != null) {
                    if (parent instanceof GuildViewPagerContainer) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                } else {
                    parent = null;
                    break;
                }
            }
            GuildViewPagerContainer guildViewPagerContainer = (GuildViewPagerContainer) parent;
            if (guildViewPagerContainer != null) {
                guildViewPagerContainer.b(viewPager2, recyclerView);
            }
        } catch (RuntimeException e16) {
            com.tencent.mobileqq.guild.util.s.e("ViewPager2Ex", "reduceDragSlop", e16);
        }
    }
}
