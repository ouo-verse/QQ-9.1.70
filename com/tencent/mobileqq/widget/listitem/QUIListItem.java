package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.quibadge.QUIRichBadge;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 b*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0006\u0016c\u0018\u0017deB\u001d\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J)\u0010\u0014\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0004J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u001c\u001a\u00020\u000b*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0010H\u0004J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0004J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0016J\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020)H\u0016J\u001a\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010'\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0010H\u0014R\u0016\u00102\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00101R\u001a\u00106\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105R\u001a\u00108\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\b7\u00105R\u001a\u0010:\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b9\u00103\u001a\u0004\b9\u00105R\u001a\u0010<\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b7\u00103\u001a\u0004\b;\u00105R\u001a\u0010>\u001a\u00020\u00108\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b0\u00103\u001a\u0004\b=\u00105R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010H\u001a\u00020C8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR0\u0010.\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u00108\u0016@VX\u0096\u000e\u00a2\u0006\u0018\n\u0004\bJ\u00103\u0012\u0004\bN\u0010O\u001a\u0004\bK\u00105\"\u0004\bL\u0010MR$\u0010U\u001a\f0PR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR$\u0010[\u001a\f0VR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "", "Config", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/widget/listitem/q;", "Lcom/tencent/mobileqq/widget/listitem/l;", "Lcom/tencent/mobileqq/widget/listitem/n;", "Landroid/view/View;", "view", "Lcom/google/android/flexbox/FlexboxLayout$LayoutParams;", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "Landroid/widget/TextView;", "textView", "", "colorResId", "setTextColor$qqui_kit_release", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;Landroid/widget/TextView;I)V", "setTextColor", "index", "a", "d", "c", "f", "e", NodeProps.MIN_WIDTH, "p", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", "style", "setStyle", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "type", "setBackgroundType", "", "isGrayed", "setGrayState", "isEnabled", "setEnableState", "themeId", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "backgroundType", "I", "getDp4", "()I", "dp4", "i", "dp8", tl.h.F, "dp12", "getDp16", "dp16", "k", "itemHeight", "Landroid/widget/Space;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Space;", "space", "Lcom/google/android/flexbox/FlexboxLayout;", "D", "Lcom/google/android/flexbox/FlexboxLayout;", "j", "()Lcom/google/android/flexbox/FlexboxLayout;", "flexboxLayout", "value", "E", "o", "setThemeId", "(I)V", "getThemeId$annotations", "()V", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$LeftBinding;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$LeftBinding;", "l", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItem$LeftBinding;", "leftBinding", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$RightBinding;", "G", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$RightBinding;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/widget/listitem/QUIListItem$RightBinding;", "rightBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "b", "LeftBinding", "RightBinding", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class QUIListItem<Config> extends FrameLayout implements q, l, n {

    /* renamed from: C */
    @NotNull
    private final Space space;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final FlexboxLayout flexboxLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: F */
    @NotNull
    private final QUIListItem<Config>.LeftBinding leftBinding;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final QUIListItem<Config>.RightBinding rightBinding;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private QUIListItemBackgroundType backgroundType;

    /* renamed from: e, reason: from kotlin metadata */
    private final int dp4;

    /* renamed from: f, reason: from kotlin metadata */
    private final int dp8;

    /* renamed from: h */
    private final int dp12;

    /* renamed from: i, reason: from kotlin metadata */
    private final int dp16;

    /* renamed from: m */
    private final int itemHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0080\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0015\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0018\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem$LeftBinding;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$a;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Landroid/widget/TextView;", "c", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "text", "Landroid/widget/ImageView;", "d", "g", "()Landroid/widget/ImageView;", "avatar", "e", "j", "image", "f", "i", "icon", tl.h.F, "descriptionText", "l", "multiLineText", "k", "largeAvatar", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItem;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class LeftBinding extends QUIListItem<Config>.a {

        /* renamed from: c, reason: from kotlin metadata */
        @NotNull
        private final d text;

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final d avatar;

        /* renamed from: e, reason: from kotlin metadata */
        @NotNull
        private final d image;

        /* renamed from: f, reason: from kotlin metadata */
        @NotNull
        private final d icon;

        /* renamed from: g, reason: from kotlin metadata */
        @NotNull
        private final d descriptionText;

        /* renamed from: h */
        @NotNull
        private final d multiLineText;

        /* renamed from: i, reason: from kotlin metadata */
        @NotNull
        private final d largeAvatar;

        public LeftBinding() {
            super();
            final QUIListItem qUIListItem = QUIListItem.this;
            d dVar = new d(new Function1<d<TextView>, TextView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    TextView textView = new TextView(r2.getContext());
                    textView.setId(R.id.f66203a0);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.1f);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dag));
                    r2.setTextColor$qqui_kit_release($receiver, textView, R.color.qui_common_text_primary);
                    QUIListItem qUIListItem2 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams3);
                    $receiver.e(textView, qUIListItem2.getThemeId());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar);
            this.text = dVar;
            final QUIListItem qUIListItem2 = QUIListItem.this;
            d dVar2 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66153_v);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.da9);
                    ab.d(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    QUIListItem qUIListItem3 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem3.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar2);
            this.avatar = dVar2;
            final QUIListItem qUIListItem3 = QUIListItem.this;
            d dVar3 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66183_y);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dad);
                    ab.d(imageView, imageView.getResources().getDimension(R.dimen.dae));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    QUIListItem qUIListItem4 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem4.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar3);
            this.image = dVar3;
            final QUIListItem qUIListItem4 = QUIListItem.this;
            d dVar4 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66173_x);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dac);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    QUIListItem qUIListItem5 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem5.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar4);
            this.icon = dVar4;
            final QUIListItem qUIListItem5 = QUIListItem.this;
            d dVar5 = new d(new Function1<d<TextView>, TextView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    TextView textView = new TextView(r2.getContext());
                    textView.setId(R.id.f66163_w);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    r2.setTextColor$qqui_kit_release($receiver, textView, R.color.qui_common_text_secondary);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.da_));
                    QUIListItem qUIListItem6 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams2 = layoutParams instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams2).width, 0);
                    layoutParams2.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams2);
                    $receiver.e(textView, qUIListItem6.getThemeId());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar5);
            this.descriptionText = dVar5;
            final QUIListItem qUIListItem6 = QUIListItem.this;
            d dVar6 = new d(new Function1<d<TextView>, TextView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    TextView textView = new TextView(r2.getContext());
                    textView.setId(R.id.f66163_w);
                    r2.setTextColor$qqui_kit_release($receiver, textView, R.color.qui_common_text_secondary);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.da_));
                    QUIListItem qUIListItem7 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams2 = layoutParams instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams2).width, 0);
                    layoutParams2.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams2);
                    $receiver.e(textView, qUIListItem7.getThemeId());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar6);
            this.multiLineText = dVar6;
            final QUIListItem qUIListItem7 = QUIListItem.this;
            d dVar7 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$LeftBinding$special$$inlined$lazyView$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66193_z);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daf);
                    ab.d(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    QUIListItem qUIListItem8 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem8.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar7);
            this.largeAvatar = dVar7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView g() {
            return (ImageView) this.avatar.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final TextView h() {
            return (TextView) this.descriptionText.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView i() {
            return (ImageView) this.icon.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView j() {
            return (ImageView) this.image.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView k() {
            return (ImageView) this.largeAvatar.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final TextView l() {
            return (TextView) this.multiLineText.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final TextView m() {
            return (TextView) this.text.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0080\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b3\u00104R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001c\u0010\u0011R\u001b\u0010\u001f\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u001e\u0010\u0011R\u001b\u0010 \u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0019\u0010\u0011R\u001b\u0010$\u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b&\u0010'R\u001b\u0010*\u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b)\u0010#R\u001b\u0010/\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b+\u0010,*\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b0\u0010\u0011*\u0004\b1\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem$RightBinding;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$a;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Landroid/widget/TextView;", "c", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "text", "Landroid/widget/Button;", "d", "i", "()Landroid/widget/Button;", "button", "Landroid/widget/ImageView;", "e", "j", "()Landroid/widget/ImageView;", "close", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "Landroid/widget/CompoundButton;", "f", "l", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "lazySwitchButton", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lazyTick", tl.h.F, "avatar", "k", "image", "arrow", "Landroid/view/View;", DomainData.DOMAIN_NAME, "()Landroid/view/View;", "redPoint", "Lcom/tencent/mobileqq/quibadge/QUIRichBadge;", "o", "()Lcom/tencent/mobileqq/quibadge/QUIRichBadge;", "richRedPoint", "r", "tianshuRedPoint", "p", "()Landroid/widget/CompoundButton;", "getSwitchButton$delegate", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItem$RightBinding;)Ljava/lang/Object;", "switchButton", ReportConstant.COSTREPORT_PREFIX, "getTick$delegate", "tick", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItem;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class RightBinding extends QUIListItem<Config>.a {

        /* renamed from: c, reason: from kotlin metadata */
        @NotNull
        private final d text;

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final d button;

        /* renamed from: e, reason: from kotlin metadata */
        @NotNull
        private final d close;

        /* renamed from: f, reason: from kotlin metadata */
        @NotNull
        private final d<CompoundButton> lazySwitchButton;

        /* renamed from: g, reason: from kotlin metadata */
        @NotNull
        private final d<ImageView> lazyTick;

        /* renamed from: h */
        @NotNull
        private final d avatar;

        /* renamed from: i, reason: from kotlin metadata */
        @NotNull
        private final d image;

        /* renamed from: j, reason: from kotlin metadata */
        @NotNull
        private final d arrow;

        /* renamed from: k, reason: from kotlin metadata */
        @NotNull
        private final d redPoint;

        /* renamed from: l, reason: from kotlin metadata */
        @NotNull
        private final d richRedPoint;

        /* renamed from: m */
        @NotNull
        private final d tianshuRedPoint;

        public RightBinding() {
            super();
            final QUIListItem qUIListItem = QUIListItem.this;
            d dVar = new d(new Function1<d<TextView>, TextView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    TextView textView = new TextView(r2.getContext());
                    textView.setId(R.id.f66293a9);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(100.0f);
                    textView.setLayoutParams(layoutParams);
                    r2.setTextColor$qqui_kit_release($receiver, textView, R.color.qui_common_text_secondary);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dap));
                    QUIListItem qUIListItem2 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams3);
                    $receiver.e(textView, qUIListItem2.getThemeId());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar);
            this.text = dVar;
            final QUIListItem qUIListItem2 = QUIListItem.this;
            d dVar2 = new d(new Function1<d<Button>, Button>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Button invoke(@NotNull QUIListItem.d<Button> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Function1<Context, Button> a16 = CapabilityInjector.f316927a.a();
                    Context context = r2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    final Button invoke = a16.invoke(context);
                    invoke.setId(R.id.f66233a3);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    invoke.setLayoutParams(layoutParams);
                    if (invoke instanceof QUIButton) {
                        final Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = 1000;
                        $receiver.g(invoke, new Function2<Button, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$button$2$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Button button, Integer num) {
                                invoke(button, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull Button theme, int i3) {
                                Intrinsics.checkNotNullParameter(theme, "$this$theme");
                                Ref.IntRef intRef2 = Ref.IntRef.this;
                                if (intRef2.element != i3) {
                                    intRef2.element = i3;
                                    ((QUIButton) invoke).setThemeId(i3);
                                }
                            }
                        });
                    }
                    QUIListItem qUIListItem3 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = invoke.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    invoke.setLayoutParams(layoutParams3);
                    $receiver.e(invoke, qUIListItem3.getThemeId());
                    return invoke;
                }
            });
            ((a) this).lazyViewList.add(dVar2);
            this.button = dVar2;
            final QUIListItem qUIListItem3 = QUIListItem.this;
            d dVar3 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66243a4);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dak);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    Unit unit = Unit.INSTANCE;
                    ImageView h16 = $receiver.h($receiver.i(imageView, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$close$2$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2) {
                            invoke2(imageView2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ImageView themeSkin) {
                            Intrinsics.checkNotNullParameter(themeSkin, "$this$themeSkin");
                            themeSkin.setImageResource(R.drawable.qui_close_icon_secondary_01_selector);
                        }
                    }), new Function2<ImageView, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$close$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2, Integer num) {
                            invoke(imageView2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ImageView themeDefaultOrNight, int i3) {
                            Intrinsics.checkNotNullParameter(themeDefaultOrNight, "$this$themeDefaultOrNight");
                            themeDefaultOrNight.setImageDrawable(ie0.a.f().p(themeDefaultOrNight.getContext(), R.drawable.qui_close, R.color.qui_common_icon_secondary, i3));
                        }
                    });
                    QUIListItem qUIListItem4 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    $receiver.e(h16, qUIListItem4.getThemeId());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar3);
            this.close = dVar3;
            final QUIListItem qUIListItem4 = QUIListItem.this;
            d<CompoundButton> dVar4 = new d<>(new Function1<d<CompoundButton>, CompoundButton>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CompoundButton invoke(@NotNull QUIListItem.d<CompoundButton> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Function1<Context, CompoundButton> b16 = CapabilityInjector.f316927a.b();
                    Context context = r2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    final CompoundButton invoke = b16.invoke(context);
                    invoke.setId(R.id.f66283a8);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    invoke.setLayoutParams(layoutParams);
                    ViewCompat.setImportantForAccessibility(invoke, 2);
                    if (invoke instanceof Switch) {
                        final Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = 1000;
                        $receiver.g(invoke, new Function2<CompoundButton, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$lazySwitchButton$1$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(CompoundButton compoundButton, Integer num) {
                                invoke(compoundButton, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull CompoundButton theme, int i3) {
                                Intrinsics.checkNotNullParameter(theme, "$this$theme");
                                Ref.IntRef intRef2 = Ref.IntRef.this;
                                if (intRef2.element != i3) {
                                    intRef2.element = i3;
                                    ((Switch) invoke).setThemeId(i3);
                                }
                            }
                        });
                    }
                    QUIListItem qUIListItem5 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = invoke.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    invoke.setLayoutParams(layoutParams3);
                    $receiver.e(invoke, qUIListItem5.getThemeId());
                    return invoke;
                }
            });
            ((a) this).lazyViewList.add(dVar4);
            this.lazySwitchButton = dVar4;
            final QUIListItem qUIListItem5 = QUIListItem.this;
            d<ImageView> dVar5 = new d<>(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66313aa);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daq);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    Unit unit = Unit.INSTANCE;
                    ImageView h16 = $receiver.h($receiver.i(imageView, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$lazyTick$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2) {
                            invoke2(imageView2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ImageView themeSkin) {
                            Intrinsics.checkNotNullParameter(themeSkin, "$this$themeSkin");
                            themeSkin.setImageResource(R.drawable.qui_tick_brand_standard);
                        }
                    }), new Function2<ImageView, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$lazyTick$1$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2, Integer num) {
                            invoke(imageView2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ImageView themeDefaultOrNight, int i3) {
                            Intrinsics.checkNotNullParameter(themeDefaultOrNight, "$this$themeDefaultOrNight");
                            themeDefaultOrNight.setImageDrawable(ie0.a.f().o(themeDefaultOrNight.getContext(), R.drawable.qui_tick, R.color.qui_common_brand_standard, i3));
                        }
                    });
                    QUIListItem qUIListItem6 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    $receiver.e(h16, qUIListItem6.getThemeId());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar5);
            this.lazyTick = dVar5;
            final QUIListItem qUIListItem6 = QUIListItem.this;
            d dVar6 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66223a2);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daj);
                    ab.d(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    QUIListItem qUIListItem7 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem7.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar6);
            this.avatar = dVar6;
            final QUIListItem qUIListItem7 = QUIListItem.this;
            d dVar7 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66253a5);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dal);
                    ab.d(imageView, imageView.getResources().getDimension(R.dimen.dam));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    QUIListItem qUIListItem8 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    $receiver.e(imageView, qUIListItem8.getThemeId());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar7);
            this.image = dVar7;
            final QUIListItem qUIListItem8 = QUIListItem.this;
            d dVar8 = new d(new Function1<d<ImageView>, ImageView>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    ImageView imageView = new ImageView(r2.getContext());
                    imageView.setId(R.id.f66213a1);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(imageView.getResources().getDimensionPixelSize(R.dimen.dai), imageView.getResources().getDimensionPixelSize(R.dimen.dah));
                    layoutParams.b(0.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Unit unit = Unit.INSTANCE;
                    ImageView h16 = $receiver.h($receiver.i(imageView, new Function1<ImageView, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$arrow$2$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2) {
                            invoke2(imageView2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ImageView themeSkin) {
                            Intrinsics.checkNotNullParameter(themeSkin, "$this$themeSkin");
                            themeSkin.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
                        }
                    }), new Function2<ImageView, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$arrow$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView2, Integer num) {
                            invoke(imageView2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull ImageView themeDefaultOrNight, int i3) {
                            Intrinsics.checkNotNullParameter(themeDefaultOrNight, "$this$themeDefaultOrNight");
                            themeDefaultOrNight.setImageDrawable(ie0.a.f().o(themeDefaultOrNight.getContext(), R.drawable.qui_chevron_right, R.color.qui_common_icon_secondary, i3));
                        }
                    });
                    QUIListItem qUIListItem9 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    $receiver.e(h16, qUIListItem9.getThemeId());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar8);
            this.arrow = dVar8;
            final QUIListItem qUIListItem9 = QUIListItem.this;
            d dVar9 = new d(new Function1<d<View>, View>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final View invoke(@NotNull QUIListItem.d<View> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    View qUIBadge = new QUIBadge(r2.getContext());
                    qUIBadge.setId(R.id.f66263a6);
                    qUIBadge.setContentDescription(qUIBadge.getResources().getString(R.string.f2172160e));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    qUIBadge.setLayoutParams(layoutParams);
                    QUIListItem qUIListItem10 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = qUIBadge.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    qUIBadge.setLayoutParams(layoutParams3);
                    $receiver.e(qUIBadge, qUIListItem10.getThemeId());
                    return qUIBadge;
                }
            });
            ((a) this).lazyViewList.add(dVar9);
            this.redPoint = dVar9;
            final QUIListItem qUIListItem10 = QUIListItem.this;
            d dVar10 = new d(new Function1<d<QUIRichBadge>, QUIRichBadge>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final QUIRichBadge invoke(@NotNull QUIListItem.d<QUIRichBadge> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Context context = r2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    QUIRichBadge qUIRichBadge = new QUIRichBadge(context);
                    qUIRichBadge.setId(R.id.f66273a7);
                    qUIRichBadge.setContentDescription(qUIRichBadge.getResources().getString(R.string.f2172160e));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    qUIRichBadge.setLayoutParams(layoutParams);
                    QUIListItem qUIListItem11 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = qUIRichBadge.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    qUIRichBadge.setLayoutParams(layoutParams3);
                    $receiver.e(qUIRichBadge, qUIListItem11.getThemeId());
                    return qUIRichBadge;
                }
            });
            ((a) this).lazyViewList.add(dVar10);
            this.richRedPoint = dVar10;
            final QUIListItem qUIListItem11 = QUIListItem.this;
            d dVar11 = new d(new Function1<d<View>, View>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$RightBinding$special$$inlined$lazyView$11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final View invoke(@NotNull QUIListItem.d<View> $receiver) {
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Function1<Context, View> c16 = CapabilityInjector.f316927a.c();
                    Context context = r2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    View invoke = c16.invoke(context);
                    invoke.setId(R.id.f66303a_);
                    invoke.setContentDescription(invoke.getResources().getString(R.string.f2172160e));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -1);
                    layoutParams.b(0.0f);
                    invoke.setLayoutParams(layoutParams);
                    QUIListItem qUIListItem12 = QUIListItem.this;
                    ViewGroup.LayoutParams layoutParams2 = invoke.getLayoutParams();
                    FlexboxLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FlexboxLayout.LayoutParams ? (FlexboxLayout.LayoutParams) layoutParams2 : null;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    invoke.setLayoutParams(layoutParams3);
                    $receiver.e(invoke, qUIListItem12.getThemeId());
                    return invoke;
                }
            });
            ((a) this).lazyViewList.add(dVar11);
            this.tianshuRedPoint = dVar11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView g() {
            return (ImageView) this.arrow.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView h() {
            return (ImageView) this.avatar.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final Button i() {
            return (Button) this.button.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView j() {
            return (ImageView) this.close.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView k() {
            return (ImageView) this.image.getValue();
        }

        @NotNull
        public final d<CompoundButton> l() {
            return this.lazySwitchButton;
        }

        @NotNull
        public final d<ImageView> m() {
            return this.lazyTick;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final View n() {
            return (View) this.redPoint.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final QUIRichBadge o() {
            return (QUIRichBadge) this.richRedPoint.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final CompoundButton p() {
            return (CompoundButton) this.lazySwitchButton.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final TextView q() {
            return (TextView) this.text.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final View r() {
            return (View) this.tianshuRedPoint.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ImageView s() {
            return (ImageView) this.lazyTick.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0090\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J'\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\"\b\b\u0001\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001\u00a2\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem$a;", "", "", "f", "c", "e", "Landroid/view/View;", "T", "view", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "d", "(Landroid/view/View;)Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "", "a", "Ljava/util/List;", "lazyViewList", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItem;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: from kotlin metadata */
        @NotNull
        private final List<d<?>> lazyViewList = new ArrayList();

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c() {
            Iterator<T> it = this.lazyViewList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.isInitialized() && ((View) dVar.getValue()).getParent() == null) {
                    dVar.c();
                }
            }
        }

        @Nullable
        public final <T extends View> d<T> d(@NotNull T view) {
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(view, "view");
            Iterator<T> it = this.lazyViewList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    d dVar = (d) obj;
                    if (dVar.isInitialized() && dVar.getValue() == view) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (!(obj instanceof d)) {
                return null;
            }
            return (d) obj;
        }

        public final void e() {
            List<d<?>> list = this.lazyViewList;
            QUIListItem<Config> qUIListItem = QUIListItem.this;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d(qUIListItem.getThemeId());
            }
        }

        public final void f() {
            Iterator<T> it = this.lazyViewList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0010\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B&\u0012\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016R+\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\b\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00018\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem$c;", "T", "Lkotlin/Lazy;", "", "isInitialized", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "d", "Lkotlin/jvm/functions/Function1;", "initializer", "e", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "_value", HippyTextInputController.COMMAND_getValue, "value", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static class c<T> implements Lazy<T> {

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private final Function1<c<T>, T> initializer;

        /* renamed from: e, reason: from kotlin metadata */
        @Nullable
        private T _value;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function1<? super c<T>, ? extends T> initializer) {
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            this.initializer = initializer;
        }

        @Nullable
        protected final T a() {
            return this._value;
        }

        protected final void b(@Nullable T t16) {
            this._value = t16;
        }

        @Override // kotlin.Lazy
        public T getValue() {
            T t16 = this._value;
            if (t16 == null) {
                T invoke = this.initializer.invoke(this);
                this._value = invoke;
                return invoke;
            }
            return t16;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            if (this._value != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B&\u0012\u001d\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\u0013\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0019\u0010\n\u001a\u00020\u0004*\u00028\u00012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0011\u001a\u00028\u0001*\u00028\u00012,\u0010\u0010\u001a(\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0014\u001a\u00028\u0001*\u00028\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0016\u001a\u00028\u0001*\u00028\u00012,\u0010\u0010\u001a(\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0012R>\u0010\u0018\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R)\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R)\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R)\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R>\u0010\u001f\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIListItem$d;", "Landroid/view/View;", "T", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem$c;", "", "f", "c", "", "themeId", "d", "e", "(Landroid/view/View;I)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)Landroid/view/View;", "Lkotlin/Function1;", "i", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", tl.h.F, "Lkotlin/jvm/functions/Function2;", "themeChangedListener", "Lkotlin/jvm/functions/Function1;", "themeSkinChangedListener", "themeDefaultChangedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "themeNightChangedListener", BdhLogUtil.LogTag.Tag_Conn, "themeDefaultOrNightChangedListener", "initializer", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d<T extends View> extends c<T> {

        /* renamed from: C */
        @Nullable
        private Function2<? super T, ? super Integer, Unit> themeDefaultOrNightChangedListener;

        /* renamed from: f, reason: from kotlin metadata */
        @Nullable
        private Function2<? super T, ? super Integer, Unit> themeChangedListener;

        /* renamed from: h */
        @Nullable
        private Function1<? super T, Unit> themeSkinChangedListener;

        /* renamed from: i, reason: from kotlin metadata */
        @Nullable
        private Function1<? super T, Unit> themeDefaultChangedListener;

        /* renamed from: m */
        @Nullable
        private Function1<? super T, Unit> themeNightChangedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Function1<? super d<T>, ? extends T> initializer) {
            super((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(initializer, 1));
            Intrinsics.checkNotNullParameter(initializer, "initializer");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c() {
            View view = (View) a();
            if (view != null) {
                ab.c(view);
            }
            b(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d(int themeId) {
            View view = (View) a();
            if (view == null) {
                return;
            }
            e(view, themeId);
        }

        public final void e(@NotNull T t16, int i3) {
            Intrinsics.checkNotNullParameter(t16, "<this>");
            switch (i3) {
                case 1000:
                    Function1<? super T, Unit> function1 = this.themeSkinChangedListener;
                    if (function1 != null) {
                        function1.invoke(t16);
                        break;
                    }
                    break;
                case 1001:
                    Function1<? super T, Unit> function12 = this.themeDefaultChangedListener;
                    if (function12 != null) {
                        function12.invoke(t16);
                    }
                    Function2<? super T, ? super Integer, Unit> function2 = this.themeDefaultOrNightChangedListener;
                    if (function2 != null) {
                        function2.invoke(t16, Integer.valueOf(i3));
                        break;
                    }
                    break;
                case 1002:
                    Function1<? super T, Unit> function13 = this.themeNightChangedListener;
                    if (function13 != null) {
                        function13.invoke(t16);
                    }
                    Function2<? super T, ? super Integer, Unit> function22 = this.themeDefaultOrNightChangedListener;
                    if (function22 != null) {
                        function22.invoke(t16, Integer.valueOf(i3));
                        break;
                    }
                    break;
            }
            Function2<? super T, ? super Integer, Unit> function23 = this.themeChangedListener;
            if (function23 != null) {
                function23.invoke(t16, Integer.valueOf(i3));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void f() {
            View view = (View) a();
            if (view != null) {
                ab.c(view);
            }
        }

        @NotNull
        public final T g(@NotNull T t16, @NotNull Function2<? super T, ? super Integer, Unit> block) {
            Intrinsics.checkNotNullParameter(t16, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeChangedListener = block;
            return t16;
        }

        @NotNull
        public final T h(@NotNull T t16, @NotNull Function2<? super T, ? super Integer, Unit> block) {
            Intrinsics.checkNotNullParameter(t16, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeDefaultOrNightChangedListener = block;
            return t16;
        }

        @NotNull
        public final T i(@NotNull T t16, @NotNull Function1<? super T, Unit> block) {
            Intrinsics.checkNotNullParameter(t16, "<this>");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeSkinChangedListener = block;
            return t16;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class e {

        /* renamed from: a */
        public static final /* synthetic */ int[] f316981a;

        static {
            int[] iArr = new int[QUIListItemStyle.values().length];
            try {
                iArr[QUIListItemStyle.Card.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QUIListItemStyle.FullWidth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f316981a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIListItem(@NotNull Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void b(QUIListItem qUIListItem, View view, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = -1;
            }
            qUIListItem.a(view, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addContentView");
    }

    private final FlexboxLayout.LayoutParams g(View view) {
        FlexboxLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            FlexboxLayout.LayoutParams layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
            layoutParams3.b(0.0f);
            return layoutParams3;
        }
        if (layoutParams2 instanceof FlexboxLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
            return (FlexboxLayout.LayoutParams) layoutParams4;
        }
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            layoutParams = new FlexboxLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams5);
            layoutParams.b(0.0f);
        } else {
            layoutParams = new FlexboxLayout.LayoutParams(view.getLayoutParams());
            layoutParams.b(0.0f);
        }
        return layoutParams;
    }

    private final void q() {
        setBackground(m(this.backgroundType, getThemeId()));
    }

    public final void a(@NotNull View view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.flexboxLayout.addView(view, index);
    }

    public final void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        FlexboxLayout flexboxLayout = this.flexboxLayout;
        flexboxLayout.addView(view, flexboxLayout.indexOfChild(this.space), g(view));
    }

    public final void d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.flexboxLayout.addView(view, 0, g(view));
    }

    public final void e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.flexboxLayout.addView(view, -1, g(view));
    }

    public final void f(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        FlexboxLayout flexboxLayout = this.flexboxLayout;
        flexboxLayout.addView(view, flexboxLayout.indexOfChild(this.space) + 1, g(view));
    }

    /* renamed from: h, reason: from getter */
    public final int getDp12() {
        return this.dp12;
    }

    /* renamed from: i, reason: from getter */
    public final int getDp8() {
        return this.dp8;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final FlexboxLayout getFlexboxLayout() {
        return this.flexboxLayout;
    }

    /* renamed from: k, reason: from getter */
    protected int getItemHeight() {
        return this.itemHeight;
    }

    @NotNull
    public final QUIListItem<Config>.LeftBinding l() {
        return this.leftBinding;
    }

    @Nullable
    protected Drawable m(@NotNull QUIListItemBackgroundType type, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return type.getBackground(context, i3);
    }

    @NotNull
    public final QUIListItem<Config>.RightBinding n() {
        return this.rightBinding;
    }

    /* renamed from: o, reason: from getter */
    public int getThemeId() {
        return this.themeId;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
        boolean z16;
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        boolean z17 = false;
        if (this.rightBinding.m().isInitialized()) {
            info.setCheckable(true);
            if (this.rightBinding.s().getVisibility() == 0) {
                z17 = true;
            }
            info.setChecked(z17);
            return;
        }
        if (this.rightBinding.l().isInitialized()) {
            if (this.rightBinding.p().getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                info.setCheckable(true);
                info.setChecked(this.rightBinding.p().isChecked());
                info.setClassName(Switch.class.getName());
                return;
            }
        }
        info.setCheckable(false);
        info.setChecked(false);
        info.setClassName(getClass().getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getItemHeight() > 0) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(getItemHeight(), 1073741824));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void p(@NotNull TextView textView, int i3) {
        FlexboxLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        if (layoutParams2 instanceof FlexboxLayout.LayoutParams) {
            layoutParams = (FlexboxLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        }
        layoutParams.W(Math.min(textView.getMeasuredWidth(), i3));
        if (textView.getMeasuredWidth() < i3) {
            layoutParams.b(0.0f);
        } else {
            layoutParams.b(100.0f);
        }
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.listitem.l
    public final void setBackgroundType(@NotNull QUIListItemBackgroundType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.backgroundType = type;
        q();
    }

    @Override // com.tencent.mobileqq.widget.listitem.n
    public void setEnableState(boolean isEnabled) {
        this.flexboxLayout.setEnabled(isEnabled);
    }

    @Override // com.tencent.mobileqq.widget.listitem.n
    public final void setGrayState(boolean isGrayed) {
        float f16;
        FlexboxLayout flexboxLayout = this.flexboxLayout;
        if (isGrayed) {
            f16 = 0.5f;
        } else {
            f16 = 1.0f;
        }
        flexboxLayout.setAlpha(f16);
    }

    @Override // com.tencent.mobileqq.widget.listitem.q
    public final void setStyle(@NotNull QUIListItemStyle style) {
        int dimensionPixelSize;
        Intrinsics.checkNotNullParameter(style, "style");
        int i3 = e.f316981a[style.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                dimensionPixelSize = 0;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.d_z);
        }
        ab.e(this, dimensionPixelSize);
    }

    public final void setTextColor$qqui_kit_release(@NotNull d<TextView> dVar, @NotNull TextView textView, final int i3) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        dVar.g(textView, new Function2<TextView, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.QUIListItem$setTextColor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TextView textView2, Integer num) {
                invoke(textView2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TextView theme, int i16) {
                Intrinsics.checkNotNullParameter(theme, "$this$theme");
                theme.setTextColor(ie0.a.f().h(theme.getContext(), i3, i16));
            }
        });
    }

    public void setThemeId(int i3) {
        if (this.themeId != i3) {
            this.themeId = i3;
            this.leftBinding.e();
            this.rightBinding.e();
            q();
        }
    }

    public /* synthetic */ QUIListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.backgroundType = QUIListItemBackgroundType.NoneRound;
        int n3 = Utils.n(4.0f, getResources());
        this.dp4 = n3;
        int n16 = Utils.n(8.0f, getResources());
        this.dp8 = n16;
        int n17 = Utils.n(12.0f, getResources());
        this.dp12 = n17;
        this.dp16 = Utils.n(16.0f, getResources());
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.dar);
        Space space = new Space(context);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.a(1.0f);
        layoutParams.b(0.0f);
        layoutParams.W(n17);
        space.setLayoutParams(layoutParams);
        this.space = space;
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.addView(space);
        flexboxLayout.setAlignItems(2);
        ViewCompat.setImportantForAccessibility(flexboxLayout, 2);
        addView(flexboxLayout, -1, -1);
        this.flexboxLayout = flexboxLayout;
        this.themeId = 1000;
        this.leftBinding = new LeftBinding();
        this.rightBinding = new RightBinding();
        flexboxLayout.setPadding(n3, flexboxLayout.getPaddingTop(), n16, flexboxLayout.getPaddingBottom());
        q();
    }
}
