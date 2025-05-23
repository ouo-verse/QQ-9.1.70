package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 U2\u00020\u0001:\u0001VB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bP\u0010QB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bP\u0010RB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010S\u001a\u00020(\u00a2\u0006\u0004\bP\u0010TJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R*\u0010$\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R*\u0010.\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020(8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00102\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R(\u00109\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R(\u0010<\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R(\u0010>\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b=\u00106\u001a\u0004\b\u001e\u00108R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\b\u0013\u0010JR\u001b\u0010O\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010I\u001a\u0004\b\u001a\u0010N\u00a8\u0006W"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "g", tl.h.F, "", "show", "j", "visibility", "i", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "value", "d", "Ljava/lang/String;", "getLeftMainText", "()Ljava/lang/String;", "setLeftMainText", "(Ljava/lang/String;)V", "leftMainText", "e", "getLeftSubText", "setLeftSubText", "leftSubText", "f", "Z", "getShowArrow", "()Z", "setShowArrow", "(Z)V", "showArrow", "getRightText", "setRightText", "rightText", "", "I", "getDividerType", "()I", "setDividerType", "(I)V", "dividerType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getShowLeftIcon", "setShowLeftIcon", "showLeftIcon", "Landroid/widget/TextView;", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "getLeftMainTextView", "()Landroid/widget/TextView;", "leftMainTextView", "D", "getLeftSubTextView", "leftSubTextView", "E", "rightTextView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getLeftIconImageView", "()Landroid/widget/ImageView;", "setLeftIconImageView", "(Landroid/widget/ImageView;)V", "leftIconImageView", "Landroid/graphics/Paint;", "G", "Lkotlin/Lazy;", "()Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "H", "()Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECFormRowItem extends LinearLayout {
    private static final Lazy I;
    private static final Lazy J;
    private static final Lazy K;

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView leftMainTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView leftSubTextView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView rightTextView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView leftIconImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy paint;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy rect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String leftMainText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String leftSubText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showArrow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String rightText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int dividerType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showLeftIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFormRowItem$a;", "", "", "ARROW_ICON_SIZE$delegate", "Lkotlin/Lazy;", "a", "()I", "ARROW_ICON_SIZE", "LEFT_ICON_SIZE$delegate", "c", "LEFT_ICON_SIZE", "ARROW_MARGIN$delegate", "b", "ARROW_MARGIN", "DIVIDER_TYPE_FULL", "I", "DIVIDER_TYPE_NONE", "DIVIDER_TYPE_NOT_FULL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.ECFormRowItem$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ((Number) ECFormRowItem.I.getValue()).intValue();
        }

        public final int b() {
            return ((Number) ECFormRowItem.K.getValue()).intValue();
        }

        public final int c() {
            return ((Number) ECFormRowItem.J.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.base.ui.ECFormRowItem$Companion$ARROW_ICON_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(16.0f);
            }
        });
        I = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.base.ui.ECFormRowItem$Companion$LEFT_ICON_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(24.0f);
            }
        });
        J = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.base.ui.ECFormRowItem$Companion$ARROW_MARGIN$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(8.0f);
            }
        });
        K = lazy3;
    }

    public ECFormRowItem(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        this.leftMainText = "";
        lazy = LazyKt__LazyJVMKt.lazy(ECFormRowItem$paint$2.INSTANCE);
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ECFormRowItem$rect$2.INSTANCE);
        this.rect = lazy2;
    }

    private final Paint d() {
        return (Paint) this.paint.getValue();
    }

    private final Rect e() {
        return (Rect) this.rect.getValue();
    }

    /* renamed from: f, reason: from getter */
    public final TextView getRightTextView() {
        return this.rightTextView;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dividerType != 0) {
            d().setColor(ECSkin.INSTANCE.getColor(R.color.f6742d));
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f9840g);
            int dimensionPixelSize2 = this.dividerType == 2 ? getContext().getResources().getDimensionPixelSize(R.dimen.f9850h) : 0;
            e().set(dimensionPixelSize2, getMeasuredHeight() - dimensionPixelSize, getMeasuredWidth() - dimensionPixelSize2, getMeasuredHeight());
            if (canvas != null) {
                canvas.drawRect(e(), d());
            }
        }
    }

    public final void setDividerType(int i3) {
        this.dividerType = i3;
        if (i3 == 0) {
            invalidate();
        } else if (i3 == 1) {
            invalidate();
        } else {
            if (i3 != 2) {
                return;
            }
            invalidate();
        }
    }

    public final void setLeftIconImageView(ImageView imageView) {
        this.leftIconImageView = imageView;
    }

    public final void setLeftMainText(String str) {
        boolean isBlank;
        this.leftMainText = str;
        TextView textView = this.leftMainTextView;
        if (textView != null) {
            textView.setText(str);
            isBlank = StringsKt__StringsJVMKt.isBlank(textView.getText());
            textView.setVisibility(isBlank ^ true ? 0 : 8);
        }
    }

    public final void setLeftSubText(String str) {
        boolean isBlank;
        this.leftSubText = str;
        TextView textView = this.leftSubTextView;
        if (textView != null) {
            textView.setText(str);
            isBlank = StringsKt__StringsJVMKt.isBlank(textView.getText());
            textView.setVisibility(isBlank ^ true ? 0 : 8);
        }
    }

    public final void setRightText(String str) {
        boolean isBlank;
        this.rightText = str;
        TextView textView = this.rightTextView;
        if (textView != null) {
            textView.setText(str);
            isBlank = StringsKt__StringsJVMKt.isBlank(textView.getText());
            textView.setVisibility(((isBlank ^ true) || this.showArrow) ? 0 : 8);
        }
    }

    public final void setShowArrow(boolean z16) {
        if (this.showArrow != z16) {
            this.showArrow = z16;
            j(z16);
        }
    }

    public final void setShowLeftIcon(boolean z16) {
        if (this.showLeftIcon != z16) {
            this.showLeftIcon = z16;
            i(z16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x016a, code lost:
    
        if ((!r2) == true) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h() {
        boolean isBlank;
        int i3;
        boolean isBlank2;
        boolean isBlank3;
        setOrientation(0);
        setGravity(16);
        ImageView imageView = new ImageView(getContext());
        Companion companion = INSTANCE;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(companion.c(), companion.c());
        layoutParams.rightMargin = imageView.getContext().getResources().getDimensionPixelSize(R.dimen.f9860i);
        imageView.setLayoutParams(layoutParams);
        Unit unit = Unit.INSTANCE;
        this.leftIconImageView = imageView;
        i(this.showLeftIcon);
        addView(this.leftIconImageView);
        TextView textView = new TextView(getContext());
        textView.setText(this.leftMainText);
        textView.setContentDescription(this.leftMainText);
        textView.setId(R.id.f163020nw0);
        ECSkin eCSkin = ECSkin.INSTANCE;
        textView.setTextColor(eCSkin.getColor(R.color.f6942x));
        textView.setTextSize(0, textView.getContext().getResources().getDimensionPixelSize(R.dimen.f9870j));
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        isBlank = StringsKt__StringsJVMKt.isBlank(this.leftMainText);
        int i16 = 8;
        textView.setVisibility(isBlank ^ true ? 0 : 8);
        this.leftMainTextView = textView;
        TextView textView2 = new TextView(getContext());
        textView2.setText(this.leftSubText);
        textView2.setContentDescription(this.leftSubText);
        textView2.setId(R.id.f163021nw1);
        textView2.setTextColor(eCSkin.getColor(R.color.f6962z));
        textView2.setTextSize(0, textView2.getContext().getResources().getDimensionPixelSize(R.dimen.f9900m));
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        String str = this.leftSubText;
        if (str != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank3) {
                i3 = 0;
                textView2.setVisibility(i3);
                this.leftSubTextView = textView2;
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setId(R.id.f163022nw2);
                linearLayout.setOrientation(1);
                linearLayout.addView(this.leftMainTextView);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.f9910n);
                linearLayout.addView(this.leftSubTextView, layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 19;
                layoutParams3.weight = 1.0f;
                addView(linearLayout, layoutParams3);
                TextView textView3 = new TextView(getContext());
                textView3.setText(this.rightText);
                textView3.setContentDescription(this.rightText);
                textView3.setTextColor(eCSkin.getColor(R.color.f6962z));
                textView3.setTextSize(0, textView3.getContext().getResources().getDimensionPixelSize(R.dimen.f9900m));
                textView3.setSingleLine();
                textView3.setEllipsize(TextUtils.TruncateAt.END);
                if (!this.showArrow) {
                    String str2 = this.rightText;
                    if (str2 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    }
                    textView3.setVisibility(i16);
                    this.rightTextView = textView3;
                    j(this.showArrow);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.gravity = 21;
                    layoutParams4.weight = 0.0f;
                    addView(this.rightTextView, layoutParams4);
                    int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f9880k);
                    setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    setBackground(new ColorDrawable(0));
                }
                i16 = 0;
                textView3.setVisibility(i16);
                this.rightTextView = textView3;
                j(this.showArrow);
                LinearLayout.LayoutParams layoutParams42 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams42.gravity = 21;
                layoutParams42.weight = 0.0f;
                addView(this.rightTextView, layoutParams42);
                int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.f9880k);
                setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                setBackground(new ColorDrawable(0));
            }
        }
        i3 = 8;
        textView2.setVisibility(i3);
        this.leftSubTextView = textView2;
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setId(R.id.f163022nw2);
        linearLayout2.setOrientation(1);
        linearLayout2.addView(this.leftMainTextView);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams22.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.f9910n);
        linearLayout2.addView(this.leftSubTextView, layoutParams22);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams32.gravity = 19;
        layoutParams32.weight = 1.0f;
        addView(linearLayout2, layoutParams32);
        TextView textView32 = new TextView(getContext());
        textView32.setText(this.rightText);
        textView32.setContentDescription(this.rightText);
        textView32.setTextColor(eCSkin.getColor(R.color.f6962z));
        textView32.setTextSize(0, textView32.getContext().getResources().getDimensionPixelSize(R.dimen.f9900m));
        textView32.setSingleLine();
        textView32.setEllipsize(TextUtils.TruncateAt.END);
        if (!this.showArrow) {
        }
        i16 = 0;
        textView32.setVisibility(i16);
        this.rightTextView = textView32;
        j(this.showArrow);
        LinearLayout.LayoutParams layoutParams422 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams422.gravity = 21;
        layoutParams422.weight = 0.0f;
        addView(this.rightTextView, layoutParams422);
        int dimensionPixelSize22 = getContext().getResources().getDimensionPixelSize(R.dimen.f9880k);
        setPadding(dimensionPixelSize22, 0, dimensionPixelSize22, 0);
        setBackground(new ColorDrawable(0));
    }

    private final void g(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, ok0.b.f423049m);
            String string = obtainStyledAttributes.getString(ok0.b.f423051o);
            if (string == null) {
                string = "";
            }
            setLeftMainText(string);
            setLeftSubText(obtainStyledAttributes.getString(ok0.b.f423055s));
            setRightText(obtainStyledAttributes.getString(ok0.b.f423052p));
            setShowArrow(obtainStyledAttributes.getBoolean(ok0.b.f423053q, false));
            setShowLeftIcon(obtainStyledAttributes.getBoolean(ok0.b.f423054r, false));
            setDividerType(obtainStyledAttributes.getInt(ok0.b.f423050n, 0));
            obtainStyledAttributes.recycle();
            cg0.a.b("ECFormRowItem", "leftMainText:" + this.leftMainText + ", leftSubText:" + this.leftSubText + ", rightText:" + this.rightText + ", showArrow:" + this.showArrow + ", dividerType:" + this.dividerType);
        }
        h();
    }

    private final void i(boolean visibility) {
        if (visibility) {
            ImageView imageView = this.leftIconImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView2 = this.leftIconImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private final void j(boolean show) {
        Drawable drawable;
        if (show) {
            TextView textView = this.rightTextView;
            if (textView == null || (drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e8_)) == null) {
                return;
            }
            Companion companion = INSTANCE;
            drawable.setBounds(new Rect(0, 0, companion.a(), companion.a()));
            textView.setCompoundDrawablePadding(companion.b());
            textView.setCompoundDrawables(null, null, drawable, null);
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.rightTextView;
        if (textView2 != null) {
            textView2.setCompoundDrawables(null, null, null, null);
        }
    }

    public ECFormRowItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        this.leftMainText = "";
        lazy = LazyKt__LazyJVMKt.lazy(ECFormRowItem$paint$2.INSTANCE);
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ECFormRowItem$rect$2.INSTANCE);
        this.rect = lazy2;
        g(context, attributeSet);
    }

    public ECFormRowItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        this.leftMainText = "";
        lazy = LazyKt__LazyJVMKt.lazy(ECFormRowItem$paint$2.INSTANCE);
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ECFormRowItem$rect$2.INSTANCE);
        this.rect = lazy2;
        g(context, attributeSet);
    }
}
