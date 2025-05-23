package com.tencent.mobileqq.multishare.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\bB\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020\u0005\u00a2\u0006\u0004\b&\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0001H\u0003J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0014\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J0\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0014R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001ej\b\u0012\u0004\u0012\u00020\f`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/MultiShareIconListView;", "Landroid/widget/FrameLayout;", "", "f", "e", "", "starIndex", "endIndex", "a", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "c", "d", "Lcom/tencent/mobileqq/multishare/bean/a;", QCircleAlphaUserReporter.KEY_USER, "Landroid/widget/ImageView;", "iconView", "b", "g", "", "list", "setIconData", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "l", "t", "r", "onLayout", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "usersList", "I", "overSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiShareIconListView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.multishare.bean.a> usersList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int overSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/MultiShareIconListView$a;", "", "", "GAP_SPACE", UserInfo.SEX_FEMALE, "ICON_BORDER_WIDTH", "ICON_CORNER_RADIUS", "ICON_SIZE", "", "MAX_SIZE", "I", "OVERLOAD_ICON_SIZE", "", "TAG", "Ljava/lang/String;", "TEXT_SIZE", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.widget.MultiShareIconListView$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiShareIconListView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        ArrayList<com.tencent.mobileqq.multishare.bean.a> arrayList = new ArrayList<>();
        this.usersList = arrayList;
        setVisibility(8);
        arrayList.clear();
    }

    private final void a(int starIndex, int endIndex) {
        Object orNull;
        while (starIndex < endIndex) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.usersList, starIndex);
            com.tencent.mobileqq.multishare.bean.a aVar = (com.tencent.mobileqq.multishare.bean.a) orNull;
            if (aVar != null) {
                RFWRoundImageView c16 = c();
                b(aVar, c16);
                addView(c16);
            }
            starIndex++;
        }
        if (this.overSize > 0) {
            addView(d());
        }
    }

    private final void b(com.tencent.mobileqq.multishare.bean.a user, ImageView iconView) {
        com.tencent.mobileqq.multishare.util.d dVar = com.tencent.mobileqq.multishare.util.d.f251801a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.c(context, user.d(), user.e(), user.b(), iconView, user.a());
    }

    private final RFWRoundImageView c() {
        RFWRoundImageView rFWRoundImageView = new RFWRoundImageView(getContext());
        rFWRoundImageView.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 17));
        rFWRoundImageView.setBorderWidth(ViewUtils.dip2px(1.0f));
        rFWRoundImageView.setBorderColor(getResources().getColor(R.color.qui_common_bg_middle_light, null));
        rFWRoundImageView.setTopLeftRadius(ViewUtils.dip2px(2.0f));
        rFWRoundImageView.setTopRightRadius(ViewUtils.dip2px(2.0f));
        rFWRoundImageView.setBottomLeftRadius(ViewUtils.dip2px(2.0f));
        rFWRoundImageView.setBottomRightRadius(ViewUtils.dip2px(2.0f));
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cVar.i(context, rFWRoundImageView);
        return rFWRoundImageView;
    }

    @SuppressLint({"SetTextI18n"})
    private final FrameLayout d() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 17);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dip2px(18.0f), ViewUtils.dip2px(18.0f), 17);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 17);
        frameLayout.setLayoutParams(layoutParams);
        imageView.setLayoutParams(layoutParams2);
        textView.setLayoutParams(layoutParams3);
        textView.setText(Marker.ANY_NON_NULL_MARKER + this.overSize);
        textView.setTextSize(1, 10.0f);
        textView.setTextColor(getResources().getColor(R.color.f157375c74, null));
        imageView.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.k1j, null));
        frameLayout.addView(imageView);
        frameLayout.addView(textView);
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cVar.i(context, frameLayout);
        return frameLayout;
    }

    private final void e() {
        Object orNull;
        RFWRoundImageView rFWRoundImageView;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.usersList, i3);
            com.tencent.mobileqq.multishare.bean.a aVar = (com.tencent.mobileqq.multishare.bean.a) orNull;
            if (aVar != null) {
                View childAt = getChildAt(i3);
                if (childAt instanceof RFWRoundImageView) {
                    rFWRoundImageView = (RFWRoundImageView) childAt;
                } else {
                    rFWRoundImageView = null;
                }
                if (rFWRoundImageView != null) {
                    b(aVar, rFWRoundImageView);
                }
            }
        }
    }

    private final void f() {
        setVisibility(0);
        if (getChildCount() == 0) {
            a(0, this.usersList.size());
            return;
        }
        if (getChildCount() <= this.usersList.size()) {
            e();
            a(getChildCount(), this.usersList.size());
        } else {
            if (this.overSize > 0) {
                e();
                g();
                return;
            }
            int childCount = getChildCount();
            for (int size = this.usersList.size(); size < childCount; size++) {
                removeViewAt(size);
            }
            e();
        }
    }

    private final void g() {
        FrameLayout frameLayout;
        TextView textView;
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt instanceof FrameLayout) {
            frameLayout = (FrameLayout) childAt;
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            int childCount = frameLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = frameLayout.getChildAt(i3);
                if (childAt2 instanceof TextView) {
                    textView = (TextView) childAt2;
                } else {
                    textView = null;
                }
                if (textView != null) {
                    textView.setText(Marker.ANY_NON_NULL_MARKER + this.overSize);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i17 == 0) {
                    i3 += measuredWidth;
                } else {
                    i3 = (int) (i3 + (measuredWidth * 0.8f));
                }
                childAt.layout(i16, 0, i3, measuredHeight);
                i16 = (int) (i16 + (measuredWidth * 0.8f));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i17 == 0) {
                    i3 += measuredWidth;
                } else {
                    i3 = (int) (i3 + (measuredWidth * 0.8f));
                }
                i16 = RangesKt___RangesKt.coerceAtLeast(i16, measuredHeight);
            }
        }
        if (mode2 != 1073741824) {
            size2 = i3;
        }
        if (mode != 1073741824) {
            size = i16;
        }
        setMeasuredDimension(size2, size);
    }

    public final void setIconData(@NotNull List<com.tencent.mobileqq.multishare.bean.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            setVisibility(8);
            this.usersList.clear();
            return;
        }
        this.usersList.clear();
        if (list.size() > 4) {
            this.usersList.addAll(list.subList(0, 4));
            this.overSize = list.size() - 4;
        } else {
            this.overSize = 0;
            this.usersList.addAll(list);
        }
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiShareIconListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        ArrayList<com.tencent.mobileqq.multishare.bean.a> arrayList = new ArrayList<>();
        this.usersList = arrayList;
        setVisibility(8);
        arrayList.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiShareIconListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ArrayList<com.tencent.mobileqq.multishare.bean.a> arrayList = new ArrayList<>();
        this.usersList = arrayList;
        setVisibility(8);
        arrayList.clear();
    }
}
