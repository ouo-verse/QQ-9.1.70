package com.tencent.mobileqq.zplan.aio.panel.item.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.sqshow.zootopia.utils.q;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001RB1\b\u0007\u0012\u0006\u0010k\u001a\u00020j\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l\u0012\b\b\u0002\u0010n\u001a\u00020\u0004\u0012\b\b\u0002\u0010o\u001a\u00020\u0004\u00a2\u0006\u0004\bp\u0010qJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0013\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u0017\u0010,R\u0017\u00102\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b \u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001f\u0010<\u001a\n 9*\u0004\u0018\u00010)0)8\u0006\u00a2\u0006\f\n\u0004\b:\u0010+\u001a\u0004\b;\u0010,R\u0017\u0010@\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010>\u001a\u0004\b\u001c\u0010?R\u0017\u0010B\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bA\u00100\u001a\u0004\b\b\u00101R\u0017\u0010E\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u00101R\u0017\u0010J\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010M\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bK\u00100\u001a\u0004\bL\u00101R\u0017\u0010P\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bN\u00100\u001a\u0004\bO\u00101R\u0017\u0010S\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bQ\u00100\u001a\u0004\bR\u00101R(\u0010[\u001a\b\u0012\u0004\u0012\u00020\t0T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR*\u0010c\u001a\u00020\\2\u0006\u0010\u0016\u001a\u00020\\8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010i\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010f\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView;", "Landroid/widget/RelativeLayout;", "", "changed", "", "l", "t", "r", "b", "", "onLayout", "selected", "setSelected", "pressed", "setPressed", "dx", "dy", "i", "", "d", UserInfo.SEX_FEMALE, "sp", "value", "e", "I", "k", "(I)V", "outlineGap", "f", "j", "iconSize", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ThumbnailIcon;", h.F, "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ThumbnailIcon;", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ThumbnailIcon;", "iconView", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/SelectedOutline;", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/SelectedOutline;", "getOutlineView", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/SelectedOutline;", "outlineView", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "()Landroid/view/View;", "identifyingIcon", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "textView", "Landroid/view/LayoutInflater;", "D", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater", "kotlin.jvm.PlatformType", "E", "g", "priceView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "priceArea", "G", "goldTxv", "H", "getOrTxv", "orTxv", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getSilverIcon", "()Landroid/widget/ImageView;", "silverIcon", "J", "getSilverTxv", "silverTxv", "K", "c", "hintTxv", "L", "a", "buyBtn", "Lkotlin/Function0;", "M", "Lkotlin/jvm/functions/Function0;", "getOnExposeListener", "()Lkotlin/jvm/functions/Function0;", "setOnExposeListener", "(Lkotlin/jvm/functions/Function0;)V", "onExposeListener", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "N", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "getTheme", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "setTheme", "(Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;)V", "theme", "Landroid/graphics/Rect;", "P", "Landroid/graphics/Rect;", "screenRect", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, CanvasView.ACTION_RECT, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ItemView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView textView;

    /* renamed from: D, reason: from kotlin metadata */
    private final LayoutInflater layoutInflater;

    /* renamed from: E, reason: from kotlin metadata */
    private final View priceView;

    /* renamed from: F, reason: from kotlin metadata */
    private final LinearLayout priceArea;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView goldTxv;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView orTxv;

    /* renamed from: I, reason: from kotlin metadata */
    private final ImageView silverIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView silverTxv;

    /* renamed from: K, reason: from kotlin metadata */
    private final TextView hintTxv;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView buyBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private Function0<Unit> onExposeListener;

    /* renamed from: N, reason: from kotlin metadata */
    private Theme theme;

    /* renamed from: P, reason: from kotlin metadata */
    private final Rect screenRect;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Rect rect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float sp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int outlineGap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int iconSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ThumbnailIcon iconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final SelectedOutline outlineView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View identifyingIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void j(int i3) {
        this.iconSize = i3;
        ThumbnailIcon thumbnailIcon = this.iconView;
        ViewGroup.LayoutParams layoutParams = thumbnailIcon.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i3;
            layoutParams.height = i3;
            thumbnailIcon.setLayoutParams(layoutParams);
            SelectedOutline selectedOutline = this.outlineView;
            ViewGroup.LayoutParams layoutParams2 = selectedOutline.getLayoutParams();
            if (layoutParams2 != null) {
                int i16 = this.outlineGap;
                layoutParams2.width = (i16 * 2) + i3;
                layoutParams2.height = i3 + (i16 * 2);
                selectedOutline.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void k(int i3) {
        this.outlineGap = i3;
        ViewGroup.LayoutParams layoutParams = this.outlineView.getLayoutParams();
        int i16 = this.iconSize;
        int i17 = i3 * 2;
        layoutParams.width = i16 + i17;
        layoutParams.height = i16 + i17;
    }

    /* renamed from: a, reason: from getter */
    public final TextView getBuyBtn() {
        return this.buyBtn;
    }

    /* renamed from: b, reason: from getter */
    public final TextView getGoldTxv() {
        return this.goldTxv;
    }

    /* renamed from: c, reason: from getter */
    public final TextView getHintTxv() {
        return this.hintTxv;
    }

    /* renamed from: d, reason: from getter */
    public final ThumbnailIcon getIconView() {
        return this.iconView;
    }

    /* renamed from: e, reason: from getter */
    public final View getIdentifyingIcon() {
        return this.identifyingIcon;
    }

    /* renamed from: f, reason: from getter */
    public final LinearLayout getPriceArea() {
        return this.priceArea;
    }

    /* renamed from: g, reason: from getter */
    public final View getPriceView() {
        return this.priceView;
    }

    /* renamed from: h, reason: from getter */
    public final TextView getTextView() {
        return this.textView;
    }

    public final void i(int dx5, int dy5) {
        getGlobalVisibleRect(this.rect);
        if (this.rect.intersect(this.screenRect)) {
            int width = this.rect.width();
            int height = this.rect.height();
            if (getWidth() <= 0 || getHeight() <= 0 || width <= 0 || height <= 0) {
                return;
            }
            Rect rect = this.rect;
            if (rect.left <= 0 || rect.top <= 0 || (width * height) / (getWidth() * getHeight()) <= 0.5f) {
                return;
            }
            this.onExposeListener.invoke();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        int width = (getWidth() - this.iconView.getWidth()) / 2;
        View view = this.identifyingIcon;
        view.setTranslationX(Math.min(view.getTranslationX(), width));
    }

    public final void setOnExposeListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onExposeListener = function0;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        this.outlineView.setVisibility((isSelected() || pressed) ? 0 : 8);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        this.outlineView.setVisibility((selected || isPressed()) ? 0 : 8);
    }

    public final void setTheme(Theme value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.theme = value;
        j(g.c(this, value.getIconSizeDp()));
        k(g.c(this, value.getOutlineGapDp()));
        this.identifyingIcon.setTranslationX(g.c(this, value.getIdentifyingOffsetXDp()));
        this.identifyingIcon.setTranslationY(g.c(this, value.getIdentifyingOffsetYDp()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "iconSizeDp", "b", "f", "outlineGapDp", "d", "identifyingOffsetXDp", "e", "identifyingOffsetYDp", "<init>", "(FFFF)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class Theme {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: f, reason: collision with root package name */
        private static final Theme f331199f = new Theme(52.0f, 3.0f, 7.0f, -6.0f);

        /* renamed from: g, reason: collision with root package name */
        private static final Theme f331200g = new Theme(70.0f, 3.0f, 2.85f, -4.0f);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float iconSizeDp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float outlineGapDp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float identifyingOffsetXDp;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final float identifyingOffsetYDp;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a$a;", "", "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "a", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ItemView$a;", "SPACE", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes35.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Theme a() {
                return Theme.f331199f;
            }

            public final Theme b() {
                return Theme.f331200g;
            }

            Companion() {
            }
        }

        public Theme(float f16, float f17, float f18, float f19) {
            this.iconSizeDp = f16;
            this.outlineGapDp = f17;
            this.identifyingOffsetXDp = f18;
            this.identifyingOffsetYDp = f19;
        }

        /* renamed from: c, reason: from getter */
        public final float getIconSizeDp() {
            return this.iconSizeDp;
        }

        /* renamed from: d, reason: from getter */
        public final float getIdentifyingOffsetXDp() {
            return this.identifyingOffsetXDp;
        }

        /* renamed from: e, reason: from getter */
        public final float getIdentifyingOffsetYDp() {
            return this.identifyingOffsetYDp;
        }

        /* renamed from: f, reason: from getter */
        public final float getOutlineGapDp() {
            return this.outlineGapDp;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.iconSizeDp) * 31) + Float.floatToIntBits(this.outlineGapDp)) * 31) + Float.floatToIntBits(this.identifyingOffsetXDp)) * 31) + Float.floatToIntBits(this.identifyingOffsetYDp);
        }

        public String toString() {
            return "Theme(iconSizeDp=" + this.iconSizeDp + ", outlineGapDp=" + this.outlineGapDp + ", identifyingOffsetXDp=" + this.identifyingOffsetXDp + ", identifyingOffsetYDp=" + this.identifyingOffsetYDp + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Theme)) {
                return false;
            }
            Theme theme = (Theme) other;
            return Float.compare(this.iconSizeDp, theme.iconSizeDp) == 0 && Float.compare(this.outlineGapDp, theme.outlineGapDp) == 0 && Float.compare(this.identifyingOffsetXDp, theme.identifyingOffsetXDp) == 0 && Float.compare(this.identifyingOffsetYDp, theme.identifyingOffsetYDp) == 0;
        }
    }

    public /* synthetic */ ItemView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sp = TypedValue.applyDimension(2, 1.0f, context.getResources().getDisplayMetrics());
        this.outlineGap = g.c(this, 3.0f);
        this.iconSize = g.c(this, 52.0f);
        ThumbnailIcon thumbnailIcon = new ThumbnailIcon(context, attributeSet, i3, i16);
        addView(thumbnailIcon);
        int i17 = this.iconSize;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i17, i17);
        layoutParams.topMargin = g.c(thumbnailIcon, 3.0f) + this.outlineGap;
        layoutParams.addRule(14, -1);
        layoutParams.addRule(10);
        thumbnailIcon.setLayoutParams(layoutParams);
        thumbnailIcon.setId(R.id.r75);
        this.iconView = thumbnailIcon;
        SelectedOutline selectedOutline = new SelectedOutline(context, attributeSet, i3, i16);
        addView(selectedOutline);
        int i18 = this.iconSize;
        int i19 = this.outlineGap;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((i19 * 2) + i18, i18 + (i19 * 2));
        layoutParams2.topMargin = g.c(selectedOutline, 3.0f);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(10);
        selectedOutline.setLayoutParams(layoutParams2);
        this.outlineView = selectedOutline;
        View view = new View(context, attributeSet, i3);
        addView(view);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g.c(view, 25.0f), g.c(view, 13.0f));
        layoutParams3.addRule(6, R.id.r75);
        layoutParams3.addRule(7, R.id.r75);
        view.setLayoutParams(layoutParams3);
        this.identifyingIcon = view;
        TextView textView = new TextView(context, attributeSet, i3, i16);
        addView(textView);
        textView.setText("\u52a0\u8f7d\u4e2d");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = g.c(textView, 4.0f);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(3, R.id.r75);
        textView.setLayoutParams(layoutParams4);
        textView.setTextSize(2, 12.0f);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            textView.setTextColor(q.a(R.color.f8737r));
        } else {
            textView.setTextColor(q.a(R.color.f8717p));
        }
        textView.setId(R.id.r6y);
        this.textView = textView;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.layoutInflater = from;
        View priceView$lambda$12$lambda$11 = from.inflate(R.layout.ddo, (ViewGroup) null);
        addView(priceView$lambda$12$lambda$11);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        Intrinsics.checkNotNullExpressionValue(priceView$lambda$12$lambda$11, "priceView$lambda$12$lambda$11");
        layoutParams5.topMargin = g.c(priceView$lambda$12$lambda$11, 2.0f);
        layoutParams5.addRule(14, -1);
        layoutParams5.addRule(3, R.id.r6y);
        priceView$lambda$12$lambda$11.setLayoutParams(layoutParams5);
        this.priceView = priceView$lambda$12$lambda$11;
        View findViewById = priceView$lambda$12$lambda$11.findViewById(R.id.qdo);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.priceArea = (LinearLayout) findViewById;
        View findViewById2 = priceView$lambda$12$lambda$11.findViewById(R.id.px7);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById2;
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(textView2.getResources().getColor(R.color.qui_common_text_primary));
        this.goldTxv = textView2;
        View findViewById3 = priceView$lambda$12$lambda$11.findViewById(R.id.qam);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById3;
        textView3.setVisibility(8);
        this.orTxv = textView3;
        View findViewById4 = priceView$lambda$12$lambda$11.findViewById(R.id.qls);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        imageView.setVisibility(8);
        this.silverIcon = imageView;
        View findViewById5 = priceView$lambda$12$lambda$11.findViewById(R.id.qlv);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) findViewById5;
        textView4.setVisibility(8);
        this.silverTxv = textView4;
        View findViewById6 = priceView$lambda$12$lambda$11.findViewById(R.id.qmu);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) findViewById6;
        textView5.setText("\u5df2\u62e5\u6709");
        textView5.setVisibility(8);
        textView5.setTextColor(textView5.getResources().getColor(R.color.qui_common_text_tertiary));
        textView5.setTextSize(9.0f);
        this.hintTxv = textView5;
        View findViewById7 = priceView$lambda$12$lambda$11.findViewById(R.id.phn);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView6 = (TextView) findViewById7;
        textView6.setVisibility(8);
        this.buyBtn = textView6;
        this.onExposeListener = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView$onExposeListener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.theme = Theme.INSTANCE.a();
        setSelected(false);
        setTheme(this.theme);
        this.screenRect = new Rect(0, 0, context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
        this.rect = new Rect();
    }
}
