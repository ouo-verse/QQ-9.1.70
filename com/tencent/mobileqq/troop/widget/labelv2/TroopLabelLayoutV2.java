package com.tencent.mobileqq.troop.widget.labelv2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.widget.labelv2.model.b;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001\fB\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0014J\u0014\u0010\u0019\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelLayoutV2;", "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/troop/widget/labelv2/model/b;", "label", "Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelItemLayout;", "itemLayout", "", "c", "Landroid/graphics/drawable/Drawable;", "leftIcon", "b", "Lcom/tencent/mobileqq/troop/widget/labelv2/model/a;", "a", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "l", "t", "r", "onLayout", "", "newLabels", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "labelItems", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLabelLayoutV2 extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> labelItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelLayoutV2$a;", "", "", "DEFAULT_MAX_LINE", "I", "ITEM_MARGIN", "LINE_SPACING", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.widget.labelv2.TroopLabelLayoutV2$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopLabelLayoutV2(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.labelItems = new ArrayList<>();
        }
    }

    private final void a(com.tencent.mobileqq.troop.widget.labelv2.model.a label, TroopLabelItemLayout itemLayout) {
        Set of5;
        Drawable drawable;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{0, 1});
        if (!of5.contains(Integer.valueOf(label.d()))) {
            QLog.e("TroopLabelLayoutV2", 1, "invalid gender: " + label.d());
            return;
        }
        if (label.c() <= 0) {
            QLog.e("TroopLabelLayoutV2", 1, "invalid age: " + label.c());
            return;
        }
        itemLayout.a().setText(label.a());
        itemLayout.setContentDescription(label.a());
        if (label.d() == 0) {
            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ngi, null);
        } else {
            drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ngh, null);
        }
        itemLayout.b().setImageDrawable(drawable);
        addView(itemLayout);
    }

    private final void b(b label, TroopLabelItemLayout itemLayout, Drawable leftIcon) {
        if (leftIcon == null) {
            c(label, itemLayout);
            return;
        }
        itemLayout.a().setText(label.a());
        itemLayout.setContentDescription(label.a());
        DrawableCompat.setTint(leftIcon, getContext().getColor(R.color.qui_common_icon_secondary));
        itemLayout.b().setImageDrawable(leftIcon);
        addView(itemLayout);
    }

    private final void c(b label, TroopLabelItemLayout itemLayout) {
        itemLayout.a().setText(label.a());
        itemLayout.setContentDescription(label.a());
        itemLayout.b().setVisibility(8);
        addView(itemLayout);
    }

    public final boolean d(@NotNull List<? extends b> newLabels) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) newLabels)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        this.labelItems.clear();
        removeAllViews();
        if (newLabels.isEmpty()) {
            return true;
        }
        for (b bVar : newLabels) {
            if (!TextUtils.isEmpty(bVar.a()) && bVar.b() != 2001) {
                this.labelItems.add(bVar);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TroopLabelItemLayout troopLabelItemLayout = new TroopLabelItemLayout(context);
                troopLabelItemLayout.bringToFront();
                if (bVar instanceof com.tencent.mobileqq.troop.widget.labelv2.model.a) {
                    a((com.tencent.mobileqq.troop.widget.labelv2.model.a) bVar, troopLabelItemLayout);
                } else if (bVar.b() == 1) {
                    b(bVar, troopLabelItemLayout, ResourcesCompat.getDrawable(getResources(), R.drawable.qui_user, null));
                } else if (bVar.b() == 9) {
                    b(bVar, troopLabelItemLayout, ResourcesCompat.getDrawable(getResources(), R.drawable.qui_calendar, null));
                } else if (bVar.b() == 10) {
                    b(bVar, troopLabelItemLayout, ResourcesCompat.getDrawable(getResources(), R.drawable.qui_position, null));
                } else {
                    c(bVar, troopLabelItemLayout);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        int paddingLeft = ((r16 - l3) - getPaddingLeft()) - getPaddingRight();
        int a16 = (int) al.a(getContext(), 3.0f);
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        getChildAt(0).getMeasuredHeight();
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (paddingLeft2 + measuredWidth > paddingLeft) {
                    return;
                }
                childAt.layout(paddingLeft2, paddingTop, measuredWidth + paddingLeft2, measuredHeight + paddingTop);
                paddingLeft2 = (a16 * 2) + measuredWidth + paddingLeft2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r4 != 1073741824) goto L27;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            i16 += getChildAt(i17).getMeasuredWidth() + 3;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    size = i16;
                }
            } else {
                size = Math.min(i16, size);
            }
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                if (getChildCount() > 0) {
                    View childAt = getChildAt(0);
                    i3 = 0 + getPaddingBottom() + getPaddingTop();
                    if (childAt != null) {
                        i3 += childAt.getMeasuredHeight();
                    }
                }
            }
            super.setMeasuredDimension(size, i3);
        }
        i3 = size2;
        super.setMeasuredDimension(size, i3);
    }
}
