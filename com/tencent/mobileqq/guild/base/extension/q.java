package com.tencent.mobileqq.guild.base.extension;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0002\u00a8\u0006\r"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", NodeProps.MARGIN_LEFT, NodeProps.MARGIN_RIGHT, "", "a", "position", "offset", "d", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class q {
    public static final void a(@NotNull RecyclerView recyclerView, int i3, int i16) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new e(c(context, i3, i16)));
    }

    public static /* synthetic */ void b(RecyclerView recyclerView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        a(recyclerView, i3, i16);
    }

    private static final Drawable c(Context context, int i3, int i16) {
        return new LayerDrawable(new Drawable[]{context.getDrawable(R.drawable.guild_divider_list_white_color), new InsetDrawable(context.getDrawable(R.drawable.guild_divider_list), i3, 0, i16, 0)});
    }

    public static final void d(@NotNull RecyclerView recyclerView, int i3, int i16) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        j jVar = new j(context, i16);
        jVar.setTargetPosition(i3);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(jVar);
        }
    }

    public static /* synthetic */ void e(RecyclerView recyclerView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        d(recyclerView, i3, i16);
    }
}
