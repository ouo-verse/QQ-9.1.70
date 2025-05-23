package com.tencent.qui.quilistitem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qui.quilistitem.Group;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010'\u001a\u00020 \u00a2\u0006\u0004\b(\u0010)J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/qui/quilistitem/n;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/qui/quilistitem/h;", "holder", "", "left", "right", "", "a", "themeId", "d", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "divider", "e", "I", "dividerHeight", "Lcom/tencent/qui/quilistitem/Group$b;", "f", "Lcom/tencent/qui/quilistitem/Group$b;", "margins", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "context", "", "i", "Z", "b", "()Z", "c", "(Z)V", "showBottomDivider", "<init>", "(Landroid/content/Context;Z)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class n extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GradientDrawable divider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int dividerHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Group.b margins;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean showBottomDivider;

    public n(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.showBottomDivider = z16;
        this.divider = new GradientDrawable();
        this.dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.f159499da3);
        this.margins = new Group.b(0, 0);
        d(1000);
    }

    private final void a(Canvas canvas, h holder, int left, int right) {
        int roundToInt;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int bottom = view.getBottom();
        roundToInt = MathKt__MathJVMKt.roundToInt(view.getTranslationY());
        int i3 = bottom + roundToInt;
        int i16 = i3 - this.dividerHeight;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            this.margins.c(0);
            this.margins.d(0);
            holder.l().b(holder, this.margins);
            this.divider.setBounds(left + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + this.margins.a(), i16, (right - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - this.margins.b(), i3);
            this.divider.draw(canvas);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.showBottomDivider;
    }

    public final void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.showBottomDivider = z16;
        }
    }

    public final void d(int themeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, themeId);
        } else {
            this.divider.setColor(ie0.a.f().h(this.context, R.color.qui_common_border_standard, themeId));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int width;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, parent, state);
            return;
        }
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
            if (childViewHolder != null) {
                h hVar = (h) childViewHolder;
                int i17 = m.f363806a[hVar.l().e().ordinal()];
                if (i17 != 1 && i17 != 2) {
                    if ((i17 == 3 || i17 == 4) && this.showBottomDivider) {
                        a(canvas, hVar, i3, width);
                    }
                } else {
                    a(canvas, hVar, i3, width);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.qui.quilistitem.ListItemViewHolder");
            }
        }
        canvas.restore();
    }
}
