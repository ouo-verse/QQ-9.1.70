package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b(\u0010)J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/m;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/mobileqq/widget/listitem/e;", "holder", "", "left", "right", "", "a", "themeId", "d", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "e", "Z", "b", "()Z", "c", "(Z)V", "showBottomDivider", "Landroid/graphics/drawable/GradientDrawable;", "f", "Landroid/graphics/drawable/GradientDrawable;", "divider", tl.h.F, "I", "dividerHeight", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "i", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "margins", "<init>", "(Landroid/content/Context;Z)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class m extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean showBottomDivider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GradientDrawable divider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int dividerHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Group.c margins;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f317044a;

        static {
            int[] iArr = new int[Group.PositionType.values().length];
            try {
                iArr[Group.PositionType.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Group.PositionType.Middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Group.PositionType.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Group.PositionType.Only.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Group.PositionType.Other.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f317044a = iArr;
        }
    }

    public m(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.showBottomDivider = z16;
        this.divider = new GradientDrawable();
        this.dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.f159499da3);
        this.margins = new Group.c(0, 0);
        d(1000);
    }

    private final void a(Canvas canvas, e holder, int left, int right) {
        int roundToInt;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int bottom = view.getBottom();
        roundToInt = MathKt__MathJVMKt.roundToInt(view.getTranslationY());
        int i3 = bottom + roundToInt;
        int i16 = i3 - this.dividerHeight;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        this.margins.c(0);
        this.margins.d(0);
        holder.l().c(holder, this.margins);
        this.divider.setBounds(left + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + this.margins.getLeft(), i16, (right - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - this.margins.getRight(), i3);
        this.divider.draw(canvas);
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShowBottomDivider() {
        return this.showBottomDivider;
    }

    public final void c(boolean z16) {
        this.showBottomDivider = z16;
    }

    public final void d(int themeId) {
        this.divider.setColor(ie0.a.f().h(this.context, R.color.qui_common_border_standard, themeId));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int width;
        int i3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getLayoutManager() == null) {
            return;
        }
        canvas.save();
        if (parent.getClipToPadding()) {
            i3 = parent.getPaddingLeft();
            width = parent.getWidth() - parent.getPaddingRight();
            canvas.clipRect(i3, parent.getPaddingTop(), width, parent.getHeight() - parent.getPaddingBottom());
        } else {
            width = parent.getWidth();
            i3 = 0;
        }
        int childCount = parent.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(parent.getChildAt(i16));
            Intrinsics.checkNotNull(childViewHolder, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.ListItemViewHolder");
            e eVar = (e) childViewHolder;
            int i17 = a.f317044a[eVar.l().getPositionInGroup().ordinal()];
            if (i17 != 1 && i17 != 2) {
                if ((i17 == 3 || i17 == 4) && this.showBottomDivider) {
                    a(canvas, eVar, i3, width);
                }
            } else {
                a(canvas, eVar, i3, width);
            }
        }
        canvas.restore();
    }
}
