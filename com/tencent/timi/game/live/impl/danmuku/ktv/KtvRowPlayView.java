package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import fh4.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import li4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvRowPlayView;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "d", "Ljava/util/List;", "ktvPlayViewList", "Lli4/a;", "e", "Lli4/a;", "ktvPlayController", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class KtvRowPlayView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<KtvPlayView> ktvPlayViewList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a ktvPlayController;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvRowPlayView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvRowPlayView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ KtvRowPlayView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public KtvRowPlayView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        List<KtvPlayView> listOf;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new KtvPlayView[]{new KtvPlayView(context, null, 0, 6, null), new KtvPlayView(context2, null, 0, 6, null), new KtvPlayView(context3, null, 0, 6, null)});
        this.ktvPlayViewList = listOf;
        a aVar = new a();
        this.ktvPlayController = aVar;
        setOrientation(1);
        addView(listOf.get(0), new LinearLayout.LayoutParams(-1, b.b(16)));
        View view = listOf.get(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.b(16));
        layoutParams.topMargin = b.b(2);
        Unit unit = Unit.INSTANCE;
        addView(view, layoutParams);
        View view2 = listOf.get(2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, b.b(16));
        layoutParams2.topMargin = b.b(2);
        addView(view2, layoutParams2);
        aVar.b(listOf);
    }
}
