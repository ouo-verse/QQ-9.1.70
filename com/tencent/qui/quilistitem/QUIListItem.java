package com.tencent.qui.quilistitem;

import android.content.Context;
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
import com.google.android.flexbox.FlexboxLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.quibadge.QUIRichBadge;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qui.quilistitem.QUIListItem;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 T*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0006\u0014U\u0015\tVWB\u001d\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J)\u0010\u0012\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0004J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\rH\u0004J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0004J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u001a\u0010*\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b+\u0010)R\u001a\u0010.\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b&\u0010)R\u001a\u00100\u001a\u00020\r8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b-\u0010)R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u0010:\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R0\u0010B\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r8\u0016@VX\u0096\u000e\u00a2\u0006\u0018\n\u0004\b<\u0010'\u0012\u0004\b@\u0010A\u001a\u0004\b=\u0010)\"\u0004\b>\u0010?R$\u0010G\u001a\f0CR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\b/\u0010FR$\u0010M\u001a\f0HR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\u00a8\u0006X"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem;", "", "Config", "Landroid/widget/FrameLayout;", "Lcom/tencent/qui/quilistitem/q;", "Lcom/tencent/qui/quilistitem/l;", "Landroid/view/View;", "view", "Lcom/google/android/flexbox/FlexboxLayout$LayoutParams;", "d", "Lcom/tencent/qui/quilistitem/QUIListItem$d;", "Landroid/widget/TextView;", "textView", "", "colorResId", "", "setTextColor$QUIListItem_debug", "(Lcom/tencent/qui/quilistitem/QUIListItem$d;Landroid/widget/TextView;I)V", "setTextColor", "index", "a", "c", NodeProps.MIN_WIDTH, "l", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "Lcom/tencent/qui/quilistitem/QUIListItemStyle;", "style", "setStyle", "Lcom/tencent/qui/quilistitem/QUIListItemBackgroundType;", "type", "setBackgroundType", "Lcom/tencent/qui/quilistitem/QUIListItemBackgroundType;", "backgroundType", "e", "I", "getDp4", "()I", "dp4", "f", "dp8", tl.h.F, "dp12", "i", "itemHeight", "Landroid/widget/Space;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/Space;", "space", "Lcom/google/android/flexbox/FlexboxLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/android/flexbox/FlexboxLayout;", "g", "()Lcom/google/android/flexbox/FlexboxLayout;", "flexboxLayout", "value", "D", "k", "setThemeId", "(I)V", "getThemeId$annotations", "()V", "themeId", "Lcom/tencent/qui/quilistitem/QUIListItem$LeftBinding;", "E", "Lcom/tencent/qui/quilistitem/QUIListItem$LeftBinding;", "()Lcom/tencent/qui/quilistitem/QUIListItem$LeftBinding;", "leftBinding", "Lcom/tencent/qui/quilistitem/QUIListItem$RightBinding;", UserInfo.SEX_FEMALE, "Lcom/tencent/qui/quilistitem/QUIListItem$RightBinding;", "j", "()Lcom/tencent/qui/quilistitem/QUIListItem$RightBinding;", "rightBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "b", "LeftBinding", "RightBinding", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public abstract class QUIListItem<Config> extends FrameLayout implements q, l {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FlexboxLayout flexboxLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private int themeId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QUIListItem<Config>.LeftBinding leftBinding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QUIListItem<Config>.RightBinding rightBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIListItemBackgroundType backgroundType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int dp4;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int dp8;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int dp12;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Space space;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0080\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0012\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u0011\u0010\fR\u001b\u0010\u0014\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$LeftBinding;", "Lcom/tencent/qui/quilistitem/QUIListItem$a;", "Lcom/tencent/qui/quilistitem/QUIListItem;", "Landroid/widget/TextView;", "c", "Lcom/tencent/qui/quilistitem/QUIListItem$d;", "k", "()Landroid/widget/TextView;", "text", "Landroid/widget/ImageView;", "d", "f", "()Landroid/widget/ImageView;", "avatar", "e", "i", "image", tl.h.F, "icon", "g", "descriptionText", "j", "largeAvatar", "<init>", "(Lcom/tencent/qui/quilistitem/QUIListItem;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public final class LeftBinding extends QUIListItem<Config>.a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d avatar;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d image;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d icon;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d descriptionText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d largeAvatar;

        public LeftBinding() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) QUIListItem.this);
                return;
            }
            d dVar = new d(new Function1<d<TextView>, TextView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.TextView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    TextView textView = new TextView(QUIListItem.this.getContext());
                    textView.setId(R.id.f66203a0);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(1.0E-5f);
                    Unit unit = Unit.INSTANCE;
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dag));
                    QUIListItem.this.setTextColor$QUIListItem_debug(receiver, textView, R.color.qui_common_text_primary);
                    ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams3);
                    receiver.e(textView, QUIListItem.this.k());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar);
            this.text = dVar;
            d dVar2 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66153_v);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.da9);
                    v.e(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar2);
            this.avatar = dVar2;
            d dVar3 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66183_y);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dad);
                    v.e(imageView, imageView.getResources().getDimension(R.dimen.dae));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar3);
            this.image = dVar3;
            d dVar4 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66173_x);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dac);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar4);
            this.icon = dVar4;
            d dVar5 = new d(new Function1<d<TextView>, TextView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.TextView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    TextView textView = new TextView(QUIListItem.this.getContext());
                    textView.setId(R.id.f66163_w);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    QUIListItem.this.setTextColor$QUIListItem_debug(receiver, textView, R.color.qui_common_text_secondary);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.da_));
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    if (!(layoutParams instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams2 = (FlexboxLayout.LayoutParams) layoutParams;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams2).width, 0);
                    layoutParams2.W(coerceAtLeast);
                    Unit unit = Unit.INSTANCE;
                    textView.setLayoutParams(layoutParams2);
                    receiver.e(textView, QUIListItem.this.k());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar5);
            this.descriptionText = dVar5;
            d dVar6 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$LeftBinding$$special$$inlined$lazyView$6
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.LeftBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66193_z);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daf);
                    v.e(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar6);
            this.largeAvatar = dVar6;
        }

        @NotNull
        public final ImageView f() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                value = iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                value = this.avatar.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final TextView g() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                value = iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                value = this.descriptionText.getValue();
            }
            return (TextView) value;
        }

        @NotNull
        public final ImageView h() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                value = iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                value = this.icon.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final ImageView i() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                value = iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                value = this.image.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final ImageView j() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                value = iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                value = this.largeAvatar.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final TextView k() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                value = iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                value = this.text.getValue();
            }
            return (TextView) value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b-\u0010.R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u001d\u0010\u0017R\u001b\u0010 \u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u001f\u0010\u0011R\u001b\u0010\"\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\u0019\u0010\u0011R\u001b\u0010#\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b!\u0010\u0011R\u001b\u0010$\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010(\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020)8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$RightBinding;", "Lcom/tencent/qui/quilistitem/QUIListItem$a;", "Lcom/tencent/qui/quilistitem/QUIListItem;", "Landroid/widget/TextView;", "c", "Lcom/tencent/qui/quilistitem/QUIListItem$d;", "p", "()Landroid/widget/TextView;", "text", "Landroid/widget/Button;", "d", tl.h.F, "()Landroid/widget/Button;", "button", "Landroid/widget/ImageView;", "e", "i", "()Landroid/widget/ImageView;", "close", "Lcom/tencent/qui/quilistitem/QUIListItem$d;", "Landroid/widget/CompoundButton;", "f", "k", "()Lcom/tencent/qui/quilistitem/QUIListItem$d;", "lazySwitchButton", "g", "o", "()Landroid/widget/CompoundButton;", "switchButton", "l", "lazyTick", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "tick", "j", "avatar", "image", "arrow", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "redPoint", "Lcom/tencent/mobileqq/quibadge/QUIRichBadge;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/quibadge/QUIRichBadge;", "richRedPoint", "<init>", "(Lcom/tencent/qui/quilistitem/QUIListItem;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public final class RightBinding extends QUIListItem<Config>.a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d button;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d close;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d<CompoundButton> lazySwitchButton;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d switchButton;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d<ImageView> lazyTick;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d tick;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d avatar;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d image;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d arrow;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d redPoint;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d richRedPoint;

        public RightBinding() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) QUIListItem.this);
                return;
            }
            d dVar = new d(new Function1<d<TextView>, TextView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.TextView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final TextView invoke(@NotNull QUIListItem.d<TextView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    TextView textView = new TextView(QUIListItem.this.getContext());
                    textView.setId(R.id.f66293a9);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(100.0f);
                    Unit unit = Unit.INSTANCE;
                    textView.setLayoutParams(layoutParams);
                    QUIListItem.this.setTextColor$QUIListItem_debug(receiver, textView, R.color.qui_common_text_secondary);
                    textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dap));
                    ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    textView.setLayoutParams(layoutParams3);
                    receiver.e(textView, QUIListItem.this.k());
                    return textView;
                }
            });
            ((a) this).lazyViewList.add(dVar);
            this.text = dVar;
            d dVar2 = new d(new Function1<d<Button>, Button>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, android.widget.Button] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Button invoke(@NotNull final QUIListItem.d<Button> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    final d<Button> a16 = Delegates.f363724d.a();
                    Context context = QUIListItem.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Button button = (Button) a16.createView(context);
                    button.setId(R.id.f66233a3);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    button.setLayoutParams(layoutParams);
                    final Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = 1000;
                    receiver.g(button, new Function2<Button, Integer, Unit>(receiver, a16) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$2$lambda$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ d $delegate$inlined;
                        final /* synthetic */ QUIListItem.d $this_lazyView$inlined;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$this_lazyView$inlined = receiver;
                            this.$delegate$inlined = a16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, Ref.IntRef.this, receiver, a16);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Button button2, Integer num) {
                            invoke(button2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Button receiver2, int i3) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) receiver2, i3);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(receiver2, "$receiver");
                            Ref.IntRef intRef2 = Ref.IntRef.this;
                            if (intRef2.element != i3) {
                                intRef2.element = i3;
                                this.$delegate$inlined.a(receiver2, i3);
                            }
                        }
                    });
                    ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    button.setLayoutParams(layoutParams3);
                    receiver.e(button, QUIListItem.this.k());
                    return button;
                }
            });
            ((a) this).lazyViewList.add(dVar2);
            this.button = dVar2;
            d dVar3 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66243a4);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dak);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    ImageView h16 = receiver.h(receiver.i(imageView, QUIListItem$RightBinding$close$2$2.INSTANCE), QUIListItem$RightBinding$close$2$3.INSTANCE);
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    receiver.e(h16, QUIListItem.this.k());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar3);
            this.close = dVar3;
            d<CompoundButton> dVar4 = new d<>(new Function1<d<CompoundButton>, CompoundButton>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.CompoundButton, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CompoundButton invoke(@NotNull final QUIListItem.d<CompoundButton> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    final e<CompoundButton> b16 = Delegates.f363724d.b();
                    Context context = QUIListItem.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    CompoundButton compoundButton = (CompoundButton) b16.createView(context);
                    compoundButton.setId(R.id.f66283a8);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    compoundButton.setLayoutParams(layoutParams);
                    final Ref.IntRef intRef = new Ref.IntRef();
                    intRef.element = 1000;
                    receiver.g(compoundButton, new Function2<CompoundButton, Integer, Unit>(receiver, b16) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$4$lambda$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ e $delegate$inlined;
                        final /* synthetic */ QUIListItem.d $this_lazyView$inlined;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$this_lazyView$inlined = receiver;
                            this.$delegate$inlined = b16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, Ref.IntRef.this, receiver, b16);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(CompoundButton compoundButton2, Integer num) {
                            invoke(compoundButton2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull CompoundButton receiver2, int i3) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) receiver2, i3);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(receiver2, "$receiver");
                            Ref.IntRef intRef2 = Ref.IntRef.this;
                            if (intRef2.element != i3) {
                                intRef2.element = i3;
                                this.$delegate$inlined.a(receiver2, i3);
                            }
                        }
                    });
                    ViewGroup.LayoutParams layoutParams2 = compoundButton.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    compoundButton.setLayoutParams(layoutParams3);
                    receiver.e(compoundButton, QUIListItem.this.k());
                    return compoundButton;
                }
            });
            ((a) this).lazyViewList.add(dVar4);
            this.lazySwitchButton = dVar4;
            this.switchButton = dVar4;
            d<ImageView> dVar5 = new d<>(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66313aa);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daq);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    ImageView h16 = receiver.h(receiver.i(imageView, QUIListItem$RightBinding$lazyTick$1$2.INSTANCE), QUIListItem$RightBinding$lazyTick$1$3.INSTANCE);
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    receiver.e(h16, QUIListItem.this.k());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar5);
            this.lazyTick = dVar5;
            this.tick = dVar5;
            d dVar6 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$6
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66223a2);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.daj);
                    v.e(imageView, dimensionPixelSize / 2.0f);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar6);
            this.avatar = dVar6;
            d dVar7 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$7
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66253a5);
                    int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dal);
                    v.e(imageView, imageView.getResources().getDimension(R.dimen.dam));
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    imageView.setLayoutParams(layoutParams3);
                    receiver.e(imageView, QUIListItem.this.k());
                    return imageView;
                }
            });
            ((a) this).lazyViewList.add(dVar7);
            this.image = dVar7;
            d dVar8 = new d(new Function1<d<ImageView>, ImageView>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$8
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.ImageView, android.view.View] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull QUIListItem.d<ImageView> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ImageView imageView = new ImageView(QUIListItem.this.getContext());
                    imageView.setId(R.id.f66213a1);
                    FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(imageView.getResources().getDimensionPixelSize(R.dimen.dai), imageView.getResources().getDimensionPixelSize(R.dimen.dah));
                    layoutParams.b(0.0f);
                    Unit unit = Unit.INSTANCE;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageView h16 = receiver.h(receiver.i(imageView, QUIListItem$RightBinding$arrow$2$2.INSTANCE), QUIListItem$RightBinding$arrow$2$3.INSTANCE);
                    ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                    if (!(layoutParams2 instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams2 = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams3 = (FlexboxLayout.LayoutParams) layoutParams2;
                    if (layoutParams3 == null) {
                        layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams3).width, 0);
                    layoutParams3.W(coerceAtLeast);
                    h16.setLayoutParams(layoutParams3);
                    receiver.e(h16, QUIListItem.this.k());
                    return h16;
                }
            });
            ((a) this).lazyViewList.add(dVar8);
            this.arrow = dVar8;
            d dVar9 = new d(new Function1<d<View>, View>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$9
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final View invoke(@NotNull QUIListItem.d<View> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    View qUIBadge = new QUIBadge(QUIListItem.this.getContext());
                    qUIBadge.setId(R.id.f66263a6);
                    ViewGroup.LayoutParams layoutParams = qUIBadge.getLayoutParams();
                    if (!(layoutParams instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams2 = (FlexboxLayout.LayoutParams) layoutParams;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams2).width, 0);
                    layoutParams2.W(coerceAtLeast);
                    Unit unit = Unit.INSTANCE;
                    qUIBadge.setLayoutParams(layoutParams2);
                    receiver.e(qUIBadge, QUIListItem.this.k());
                    return qUIBadge;
                }
            });
            ((a) this).lazyViewList.add(dVar9);
            this.redPoint = dVar9;
            d dVar10 = new d(new Function1<d<QUIRichBadge>, QUIRichBadge>(this) { // from class: com.tencent.qui.quilistitem.QUIListItem$RightBinding$$special$$inlined$lazyView$10
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUIListItem.RightBinding this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIListItem.a.this, (Object) this);
                    }
                }

                /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.tencent.mobileqq.quibadge.QUIRichBadge] */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final QUIRichBadge invoke(@NotNull QUIListItem.d<QUIRichBadge> receiver) {
                    int coerceAtLeast;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) receiver);
                    }
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    Context context = QUIListItem.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    QUIRichBadge qUIRichBadge = new QUIRichBadge(context);
                    qUIRichBadge.setId(R.id.f66273a7);
                    ViewGroup.LayoutParams layoutParams = qUIRichBadge.getLayoutParams();
                    if (!(layoutParams instanceof FlexboxLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    FlexboxLayout.LayoutParams layoutParams2 = (FlexboxLayout.LayoutParams) layoutParams;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams2).width, 0);
                    layoutParams2.W(coerceAtLeast);
                    Unit unit = Unit.INSTANCE;
                    qUIRichBadge.setLayoutParams(layoutParams2);
                    receiver.e(qUIRichBadge, QUIListItem.this.k());
                    return qUIRichBadge;
                }
            });
            ((a) this).lazyViewList.add(dVar10);
            this.richRedPoint = dVar10;
        }

        @NotNull
        public final ImageView f() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                value = iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                value = this.arrow.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final ImageView g() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                value = iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                value = this.avatar.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final Button h() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                value = iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                value = this.button.getValue();
            }
            return (Button) value;
        }

        @NotNull
        public final ImageView i() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                value = iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                value = this.close.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final ImageView j() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                value = iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                value = this.image.getValue();
            }
            return (ImageView) value;
        }

        @NotNull
        public final d<CompoundButton> k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (d) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.lazySwitchButton;
        }

        @NotNull
        public final d<ImageView> l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (d) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.lazyTick;
        }

        @NotNull
        public final View m() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                value = iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                value = this.redPoint.getValue();
            }
            return (View) value;
        }

        @NotNull
        public final QUIRichBadge n() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                value = iPatchRedirector.redirect((short) 12, (Object) this);
            } else {
                value = this.richRedPoint.getValue();
            }
            return (QUIRichBadge) value;
        }

        @NotNull
        public final CompoundButton o() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                value = iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                value = this.switchButton.getValue();
            }
            return (CompoundButton) value;
        }

        @NotNull
        public final TextView p() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                value = iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                value = this.text.getValue();
            }
            return (TextView) value;
        }

        @NotNull
        public final ImageView q() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                value = iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                value = this.tick.getValue();
            }
            return (ImageView) value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0090\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J'\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\"\b\b\u0001\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001\u00a2\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$a;", "", "", "e", "b", "d", "Landroid/view/View;", "T", "view", "Lcom/tencent/qui/quilistitem/QUIListItem$d;", "c", "(Landroid/view/View;)Lcom/tencent/qui/quilistitem/QUIListItem$d;", "", "a", "Ljava/util/List;", "lazyViewList", "<init>", "(Lcom/tencent/qui/quilistitem/QUIListItem;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<d<?>> lazyViewList;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) QUIListItem.this);
            } else {
                this.lazyViewList = new ArrayList();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Iterator<T> it = this.lazyViewList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.isInitialized() && ((View) dVar.getValue()).getParent() == null) {
                    dVar.c();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final <T extends View> d<T> c(@NotNull T view) {
            Object obj;
            Object obj2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Iterator<T> it = this.lazyViewList.iterator();
            while (true) {
                obj = null;
                if (it.hasNext()) {
                    obj2 = it.next();
                    d dVar = (d) obj2;
                    if (dVar.isInitialized() && ((View) dVar.getValue()) == view) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            if (obj2 instanceof d) {
                obj = obj2;
            }
            return (d) obj;
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            Iterator<T> it = this.lazyViewList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d(QUIListItem.this.k());
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator<T> it = this.lazyViewList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quilistitem.QUIListItem$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B&\u0012\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\f\u00a2\u0006\u0002\b\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00018\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\f\u00a2\u0006\u0002\b\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$c;", "T", "Lkotlin/Lazy;", "", "isInitialized", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "_value", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "e", "Lkotlin/jvm/functions/Function1;", "initializer", HippyTextInputController.COMMAND_getValue, "value", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static class c<T> implements Lazy<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private T _value;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Function1<c<T>, T> initializer;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function1<? super c<T>, ? extends T> initializer) {
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) initializer);
            } else {
                this.initializer = initializer;
            }
        }

        @Nullable
        protected final T a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (T) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this._value;
        }

        protected final void b(@Nullable T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            } else {
                this._value = t16;
            }
        }

        @Override // kotlin.Lazy
        public T getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this);
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this._value != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B&\u0012\u001d\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u00010\u0013\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0019\u0010\n\u001a\u00020\u0004*\u00028\u00012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0011\u001a\u00028\u0001*\u00028\u00012,\u0010\u0010\u001a(\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0014\u001a\u00028\u0001*\u00028\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0016\u001a\u00028\u0001*\u00028\u00012,\u0010\u0010\u001a(\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0012R>\u0010\u0018\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R)\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0019R)\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R)\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R>\u0010\u001f\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u00a2\u0006\u0002\b\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItem$d;", "Landroid/view/View;", "T", "Lcom/tencent/qui/quilistitem/QUIListItem$c;", "", "f", "c", "", "themeId", "d", "e", "(Landroid/view/View;I)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)Landroid/view/View;", "Lkotlin/Function1;", "i", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", tl.h.F, "Lkotlin/jvm/functions/Function2;", "themeChangedListener", "Lkotlin/jvm/functions/Function1;", "themeSkinChangedListener", "themeDefaultChangedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "themeNightChangedListener", BdhLogUtil.LogTag.Tag_Conn, "themeDefaultOrNightChangedListener", "initializer", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class d<T extends View> extends c<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private Function2<? super T, ? super Integer, Unit> themeDefaultOrNightChangedListener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private Function2<? super T, ? super Integer, Unit> themeChangedListener;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Function1<? super T, Unit> themeSkinChangedListener;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private Function1<? super T, Unit> themeDefaultChangedListener;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private Function1<? super T, Unit> themeNightChangedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Function1<? super d<T>, ? extends T> initializer) {
            super((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(initializer, 1));
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) initializer);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            View view = (View) a();
            if (view != null) {
                v.d(view);
            }
            b(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d(int themeId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, themeId);
                return;
            }
            View view = (View) a();
            if (view != null) {
                e(view, themeId);
            }
        }

        public final void e(@NotNull T dispatchOnThemeChanged, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) dispatchOnThemeChanged, i3);
                return;
            }
            Intrinsics.checkNotNullParameter(dispatchOnThemeChanged, "$this$dispatchOnThemeChanged");
            switch (i3) {
                case 1000:
                    Function1<? super T, Unit> function1 = this.themeSkinChangedListener;
                    if (function1 != null) {
                        function1.invoke(dispatchOnThemeChanged);
                        break;
                    }
                    break;
                case 1001:
                    Function1<? super T, Unit> function12 = this.themeDefaultChangedListener;
                    if (function12 != null) {
                        function12.invoke(dispatchOnThemeChanged);
                    }
                    Function2<? super T, ? super Integer, Unit> function2 = this.themeDefaultOrNightChangedListener;
                    if (function2 != null) {
                        function2.invoke(dispatchOnThemeChanged, Integer.valueOf(i3));
                        break;
                    }
                    break;
                case 1002:
                    Function1<? super T, Unit> function13 = this.themeNightChangedListener;
                    if (function13 != null) {
                        function13.invoke(dispatchOnThemeChanged);
                    }
                    Function2<? super T, ? super Integer, Unit> function22 = this.themeDefaultOrNightChangedListener;
                    if (function22 != null) {
                        function22.invoke(dispatchOnThemeChanged, Integer.valueOf(i3));
                        break;
                    }
                    break;
            }
            Function2<? super T, ? super Integer, Unit> function23 = this.themeChangedListener;
            if (function23 != null) {
                function23.invoke(dispatchOnThemeChanged, Integer.valueOf(i3));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void f() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            int i16 = ud0.d.f438811e;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("detach from parent: ");
            T a16 = a();
            if (a16 != 0) {
                i3 = a16.hashCode();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            objArr[0] = sb5.toString();
            ud0.d.a("QUIListItem", i16, objArr);
            View view = (View) a();
            if (view != null) {
                v.d(view);
            }
        }

        @NotNull
        public final T g(@NotNull T theme, @NotNull Function2<? super T, ? super Integer, Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) theme, (Object) block);
            }
            Intrinsics.checkNotNullParameter(theme, "$this$theme");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeChangedListener = block;
            return theme;
        }

        @NotNull
        public final T h(@NotNull T themeDefaultOrNight, @NotNull Function2<? super T, ? super Integer, Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) themeDefaultOrNight, (Object) block);
            }
            Intrinsics.checkNotNullParameter(themeDefaultOrNight, "$this$themeDefaultOrNight");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeDefaultOrNightChangedListener = block;
            return themeDefaultOrNight;
        }

        @NotNull
        public final T i(@NotNull T themeSkin, @NotNull Function1<? super T, Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) themeSkin, (Object) block);
            }
            Intrinsics.checkNotNullParameter(themeSkin, "$this$themeSkin");
            Intrinsics.checkNotNullParameter(block, "block");
            this.themeSkinChangedListener = block;
            return themeSkin;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public QUIListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
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

    private final FlexboxLayout.LayoutParams d(View view) {
        FlexboxLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            FlexboxLayout.LayoutParams layoutParams3 = new FlexboxLayout.LayoutParams(-2, -2);
            layoutParams3.b(0.0f);
            return layoutParams3;
        }
        if (layoutParams2 instanceof FlexboxLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
            if (layoutParams4 != null) {
                return (FlexboxLayout.LayoutParams) layoutParams4;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
        }
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            if (layoutParams5 != null) {
                layoutParams = new FlexboxLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams5);
                layoutParams.b(0.0f);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            layoutParams = new FlexboxLayout.LayoutParams(view.getLayoutParams());
            layoutParams.b(0.0f);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NotNull View view, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, index);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.flexboxLayout.addView(view, index);
        }
    }

    public final void c(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.flexboxLayout.addView(view, 0, d(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.dp12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.dp8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FlexboxLayout g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FlexboxLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.flexboxLayout;
    }

    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.itemHeight;
    }

    @NotNull
    public final QUIListItem<Config>.LeftBinding i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LeftBinding) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.leftBinding;
    }

    @NotNull
    public final QUIListItem<Config>.RightBinding j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RightBinding) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.rightBinding;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.themeId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(@NotNull TextView setMinContentWidth, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) setMinContentWidth, i3);
            return;
        }
        Intrinsics.checkNotNullParameter(setMinContentWidth, "$this$setMinContentWidth");
        setMinContentWidth.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams layoutParams = setMinContentWidth.getLayoutParams();
        if (!(layoutParams instanceof FlexboxLayout.LayoutParams)) {
            layoutParams = null;
        }
        FlexboxLayout.LayoutParams layoutParams2 = (FlexboxLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new FlexboxLayout.LayoutParams(-2, -2);
        }
        layoutParams2.W(Math.min(setMinContentWidth.getMeasuredWidth(), i3));
        Unit unit = Unit.INSTANCE;
        setMinContentWidth.setLayoutParams(layoutParams2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        boolean z17 = false;
        if (this.rightBinding.l().isInitialized()) {
            info.setCheckable(true);
            if (this.rightBinding.q().getVisibility() == 0) {
                z17 = true;
            }
            info.setChecked(z17);
            return;
        }
        if (this.rightBinding.k().isInitialized()) {
            if (this.rightBinding.o().getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                info.setCheckable(true);
                info.setChecked(this.rightBinding.o().isChecked());
                return;
            }
        }
        info.setCheckable(false);
        info.setChecked(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else if (h() > 0) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(h(), 1073741824));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.tencent.qui.quilistitem.l
    public final void setBackgroundType(@NotNull QUIListItemBackgroundType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        this.backgroundType = type;
        FlexboxLayout flexboxLayout = this.flexboxLayout;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        flexboxLayout.setBackground(type.getBackground(context, k()));
    }

    @Override // com.tencent.qui.quilistitem.q
    public final void setStyle(@NotNull QUIListItemStyle style) {
        int dimensionPixelSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) style);
            return;
        }
        Intrinsics.checkNotNullParameter(style, "style");
        int i3 = j.f363804a[style.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                dimensionPixelSize = 0;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.d_z);
        }
        v.f(this, dimensionPixelSize);
    }

    public final void setTextColor$QUIListItem_debug(@NotNull d<TextView> setTextColor, @NotNull TextView textView, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, setTextColor, textView, Integer.valueOf(i3));
            return;
        }
        Intrinsics.checkNotNullParameter(setTextColor, "$this$setTextColor");
        Intrinsics.checkNotNullParameter(textView, "textView");
        setTextColor.g(textView, new Function2<TextView, Integer, Unit>(i3) { // from class: com.tencent.qui.quilistitem.QUIListItem$setTextColor$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $colorResId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$colorResId = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TextView textView2, Integer num) {
                invoke(textView2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TextView receiver, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) receiver, i16);
                } else {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.setTextColor(ie0.a.f().h(receiver.getContext(), this.$colorResId, i16));
                }
            }
        });
    }

    public void setThemeId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (this.themeId != i3) {
            this.themeId = i3;
            this.leftBinding.d();
            this.rightBinding.d();
            setBackgroundType(this.backgroundType);
        }
    }

    public /* synthetic */ QUIListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.backgroundType = QUIListItemBackgroundType.NoneRound;
        int b16 = com.tencent.biz.qui.quicommon.e.b(context, 4.0f);
        this.dp4 = b16;
        int b17 = com.tencent.biz.qui.quicommon.e.b(context, 8.0f);
        this.dp8 = b17;
        int b18 = com.tencent.biz.qui.quicommon.e.b(context, 12.0f);
        this.dp12 = b18;
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.dar);
        Space space = new Space(context);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.a(1.0f);
        layoutParams.b(0.0f);
        layoutParams.W(b18);
        Unit unit = Unit.INSTANCE;
        space.setLayoutParams(layoutParams);
        this.space = space;
        FlexboxLayout flexboxLayout = new FlexboxLayout(context);
        flexboxLayout.addView(space);
        flexboxLayout.setAlignItems(2);
        addView(flexboxLayout, -1, -1);
        this.flexboxLayout = flexboxLayout;
        this.themeId = 1000;
        this.leftBinding = new LeftBinding();
        this.rightBinding = new RightBinding();
        flexboxLayout.setPadding(b16, flexboxLayout.getPaddingTop(), b17, flexboxLayout.getPaddingBottom());
        setBackgroundType(this.backgroundType);
    }
}
