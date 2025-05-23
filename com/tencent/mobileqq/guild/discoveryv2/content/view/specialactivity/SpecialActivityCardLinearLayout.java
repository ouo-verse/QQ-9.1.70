package com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpecialActivityListData;
import com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity.SpecialActivityCardView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import ei1.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0002,\nB\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\n\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J*\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardLinearLayout;", "Landroid/widget/LinearLayout;", "", "e", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/t;", "cardInfos", "Lkotlin/Triple;", "", "cardSize", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardView;", "cardView", "data", "c", "cardNum", "layoutWidth", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "setData", "Lei1/a;", "control", "setControl", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "Ljava/util/List;", "cardLayouts", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "originActivityData", "f", "I", "lastWidth", h.F, "Lei1/a;", "specialActivityControl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpecialActivityCardLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SpecialActivityCardView> cardLayouts;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SpecialActivityListData originActivityData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a specialActivityControl;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final CardScale f217402m = new CardScale(4, 87, 87, 16);

    @NotNull
    private static final CardScale C = new CardScale(2, 87, 190, 16);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/specialactivity/SpecialActivityCardLinearLayout$a;", "", "", "layoutWidth", "Lkotlin/Triple;", "a", "", "toString", "hashCode", "other", "", "equals", "I", "getCardNum", "()I", "cardNum", "b", "getCardHeightScale", "cardHeightScale", "c", "getCardWidthScale", "cardWidthScale", "d", "getCardSpaceScale", "cardSpaceScale", "<init>", "(IIII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.view.specialactivity.SpecialActivityCardLinearLayout$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CardScale {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int cardNum;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int cardHeightScale;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int cardWidthScale;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int cardSpaceScale;

        public CardScale(int i3, int i16, int i17, int i18) {
            this.cardNum = i3;
            this.cardHeightScale = i16;
            this.cardWidthScale = i17;
            this.cardSpaceScale = i18;
        }

        @NotNull
        public final Triple<Integer, Integer, Integer> a(int layoutWidth) {
            int i3 = this.cardNum;
            float f16 = layoutWidth / ((i3 * r1) + ((i3 - 1) * r3));
            return new Triple<>(Integer.valueOf((int) (this.cardWidthScale * f16)), Integer.valueOf((int) (this.cardHeightScale * f16)), Integer.valueOf((int) (f16 * this.cardSpaceScale)));
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardScale)) {
                return false;
            }
            CardScale cardScale = (CardScale) other;
            if (this.cardNum == cardScale.cardNum && this.cardHeightScale == cardScale.cardHeightScale && this.cardWidthScale == cardScale.cardWidthScale && this.cardSpaceScale == cardScale.cardSpaceScale) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.cardNum * 31) + this.cardHeightScale) * 31) + this.cardWidthScale) * 31) + this.cardSpaceScale;
        }

        @NotNull
        public String toString() {
            return "CardScale(cardNum=" + this.cardNum + ", cardHeightScale=" + this.cardHeightScale + ", cardWidthScale=" + this.cardWidthScale + ", cardSpaceScale=" + this.cardSpaceScale + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpecialActivityCardLinearLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(List<SpecialActivityData> cardInfos, Triple<Integer, Integer, Integer> cardSize) {
        int coerceAtMost;
        int intValue;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int intValue2;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(cardInfos.size(), this.cardLayouts.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            SpecialActivityCardView specialActivityCardView = this.cardLayouts.get(i3);
            ViewGroup.LayoutParams layoutParams = specialActivityCardView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                specialActivityCardView.setLayoutParams(new LinearLayout.LayoutParams(cardSize.getFirst().intValue(), cardSize.getSecond().intValue()));
            } else if (marginLayoutParams.width != cardSize.getFirst().intValue() || marginLayoutParams.height != cardSize.getSecond().intValue()) {
                marginLayoutParams.width = cardSize.getFirst().intValue();
                marginLayoutParams.height = cardSize.getSecond().intValue();
                if (i3 == 0) {
                    intValue2 = 0;
                } else {
                    intValue2 = cardSize.getThird().intValue();
                }
                marginLayoutParams.leftMargin = intValue2;
                specialActivityCardView.setLayoutParams(marginLayoutParams);
            }
            c(specialActivityCardView, cardInfos.get(i3));
            specialActivityCardView.setVisibility(0);
        }
        if (this.cardLayouts.size() < cardInfos.size()) {
            int size = cardInfos.size();
            for (int size2 = this.cardLayouts.size(); size2 < size; size2++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SpecialActivityCardView specialActivityCardView2 = new SpecialActivityCardView(context, null, 0, 6, null);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cardSize.getFirst().intValue(), cardSize.getSecond().intValue());
                if (size2 == 0) {
                    intValue = 0;
                } else {
                    intValue = cardSize.getThird().intValue();
                }
                layoutParams2.leftMargin = intValue;
                addView(specialActivityCardView2, layoutParams2);
                c(specialActivityCardView2, cardInfos.get(size2));
                this.cardLayouts.add(specialActivityCardView2);
            }
            return;
        }
        if (this.cardLayouts.size() > cardInfos.size()) {
            int size3 = this.cardLayouts.size();
            for (int size4 = cardInfos.size(); size4 < size3; size4++) {
                this.cardLayouts.get(size4).setVisibility(8);
            }
        }
    }

    private final void c(SpecialActivityCardView cardView, SpecialActivityData data) {
        cardView.setData(new SpecialActivityCardView.CardData(data.getCoverUrl(), data.getName(), data.getJumpUrl()));
        a aVar = this.specialActivityControl;
        if (aVar != null) {
            aVar.a(cardView, data);
        }
    }

    private final Triple<Integer, Integer, Integer> d(int cardNum, int layoutWidth) {
        if (cardNum == 0) {
            return new Triple<>(0, 0, 0);
        }
        if (cardNum <= 2) {
            return C.a(layoutWidth);
        }
        return f217402m.a(layoutWidth);
    }

    private final void e() {
        List<SpecialActivityData> list;
        boolean z16;
        Logger logger = Logger.f235387a;
        logger.d().i("SpecialActivityCardLinearLayout", 1, "updateView width: " + this.lastWidth);
        if (this.lastWidth <= 0) {
            return;
        }
        SpecialActivityListData specialActivityListData = this.originActivityData;
        if (specialActivityListData != null) {
            list = specialActivityListData.b();
        } else {
            list = null;
        }
        List<SpecialActivityData> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            logger.d().i("SpecialActivityCardLinearLayout", 1, "originActivityList is empty");
            setVisibility(8);
        } else {
            setVisibility(0);
            b(list, d(list.size(), this.lastWidth));
            VideoReport.traversePage(this);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (this.lastWidth != size) {
            this.lastWidth = size;
            e();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setControl(@NotNull a control) {
        Intrinsics.checkNotNullParameter(control, "control");
        this.specialActivityControl = control;
    }

    public final void setData(@NotNull SpecialActivityListData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.originActivityData = data;
        e();
        requestLayout();
    }

    public /* synthetic */ SpecialActivityCardLinearLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpecialActivityCardLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardLayouts = new ArrayList();
        setGravity(16);
        setOrientation(0);
    }
}
