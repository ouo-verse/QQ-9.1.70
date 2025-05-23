package com.tencent.biz.qui.quitagview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td0.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010 \u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010&\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010(\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010+\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0014\u0010.\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/qui/quitagview/QUITagView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/qui/quitagview/d;", "newConfig", "", "d", "c", "f", "e", "Landroid/graphics/drawable/Drawable;", "originDrawable", "a", "drawable", "b", "setConfig", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "leftIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "contentTextView", "Lcom/tencent/biz/qui/quitagview/d;", "currentConfig", "", h.F, "I", "dp2", "i", "dp3", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dp4", BdhLogUtil.LogTag.Tag_Conn, "dp6", "D", "dp8", "E", "dp10", UserInfo.SEX_FEMALE, "dp12", "G", "dp16", "", "H", "sp10", "sp12", "J", "sp14", "Ltd0/m;", "K", "Ltd0/m;", "urlDrawableDelegate", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUITagView_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes5.dex */
public final class QUITagView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int dp6;

    /* renamed from: D, reason: from kotlin metadata */
    private final int dp8;

    /* renamed from: E, reason: from kotlin metadata */
    private final int dp10;

    /* renamed from: F, reason: from kotlin metadata */
    private final int dp12;

    /* renamed from: G, reason: from kotlin metadata */
    private final int dp16;

    /* renamed from: H, reason: from kotlin metadata */
    private final float sp10;

    /* renamed from: I, reason: from kotlin metadata */
    private final float sp12;

    /* renamed from: J, reason: from kotlin metadata */
    private final float sp14;

    /* renamed from: K, reason: from kotlin metadata */
    private m urlDrawableDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView leftIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView contentTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUITagViewConfig currentConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int dp2;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int dp3;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int dp4;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    static final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View v3, MotionEvent event) {
            if (!QUITagView.this.isClickable()) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(event, "event");
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    Intrinsics.checkNotNullExpressionValue(v3, "v");
                    v3.setAlpha(1.0f);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                v3.setAlpha(0.5f);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUITagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dp2 = e.c(2.0f);
        this.dp3 = e.c(3.0f);
        this.dp4 = e.c(4.0f);
        this.dp6 = e.c(6.0f);
        this.dp8 = e.c(8.0f);
        this.dp10 = e.c(10.0f);
        this.dp12 = e.c(12.0f);
        int c16 = e.c(16.0f);
        this.dp16 = c16;
        this.sp10 = 10.0f;
        this.sp12 = 12.0f;
        this.sp14 = 14.0f;
        this.currentConfig = new QUITagViewConfig(QUITagType.FILL, QUITagSize.BIG, null, "");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(15);
        this.leftIcon = new ImageView(context);
        linearLayout.addView(this.leftIcon, new LinearLayout.LayoutParams(c16, c16));
        this.leftIcon.setVisibility(8);
        TextView textView = new TextView(context);
        this.contentTextView = textView;
        textView.setMaxLines(1);
        this.contentTextView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(this.contentTextView, new ViewGroup.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        f(this.currentConfig);
        e(this.currentConfig);
        setClickable(false);
        setOnTouchListener(new a());
        this.urlDrawableDelegate = (m) ud0.c.a(m.class);
    }

    private final Drawable a(Drawable originDrawable, QUITagViewConfig newConfig) {
        Drawable b16 = b(originDrawable);
        if (b16 != null) {
            QUITagType type = newConfig.getType();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            b16.setColorFilter(new PorterDuffColorFilter(type.getIconColor$QUITagView_debug(context).getDefaultColor(), PorterDuff.Mode.SRC_IN));
            return b16;
        }
        return null;
    }

    private final Drawable b(Drawable drawable) {
        boolean z16;
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                if (children != null) {
                    if (children.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        int length = children.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            children[i3] = b(children[i3]);
                        }
                    }
                }
                return drawable.mutate();
            }
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    private final void c(QUITagViewConfig newConfig) {
        this.contentTextView.setText(newConfig.getContent());
    }

    private final void d(QUITagViewConfig newConfig) {
        boolean z16;
        QUITagIcon icon = newConfig.getIcon();
        Drawable drawable = null;
        if (icon == null) {
            this.leftIcon.setImageDrawable(null);
            this.leftIcon.setVisibility(8);
            return;
        }
        if (icon.getResIs() != 0) {
            Drawable drawable2 = getResources().getDrawable(icon.getResIs());
            if (icon.getNeedTint()) {
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
                drawable2 = a(drawable2, newConfig);
            }
            this.leftIcon.setImageDrawable(drawable2);
        }
        String iconUrl = icon.getIconUrl();
        if (iconUrl != null) {
            if (iconUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ImageView imageView = this.leftIcon;
                m mVar = this.urlDrawableDelegate;
                if (mVar != null) {
                    drawable = mVar.c(icon.getIconUrl());
                }
                imageView.setImageDrawable(drawable);
            }
        }
        this.leftIcon.setVisibility(0);
    }

    private final void e(QUITagViewConfig newConfig) {
        ViewGroup.LayoutParams layoutParams = this.leftIcon.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int i3 = c.f95343a[newConfig.getSize().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        int i16 = this.dp6;
                        int i17 = this.dp3;
                        setPadding(i16, i17, i16, i17);
                        int i18 = this.dp10;
                        layoutParams2.width = i18;
                        layoutParams2.height = i18;
                        layoutParams2.rightMargin = this.dp2;
                        this.contentTextView.setTextSize(this.sp10);
                    }
                } else {
                    int i19 = this.dp8;
                    int i26 = this.dp4;
                    setPadding(i19, i26, i19, i26);
                    int i27 = this.dp12;
                    layoutParams2.width = i27;
                    layoutParams2.height = i27;
                    layoutParams2.rightMargin = this.dp2;
                    this.contentTextView.setTextSize(this.sp12);
                }
            } else {
                int i28 = this.dp16;
                int i29 = this.dp8;
                setPadding(i28, i29, i28, i29);
                int i36 = this.dp16;
                layoutParams2.width = i36;
                layoutParams2.height = i36;
                layoutParams2.rightMargin = this.dp4;
                this.contentTextView.setTextSize(this.sp14);
            }
            layoutParams2.gravity = 16;
            this.leftIcon.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final void f(QUITagViewConfig newConfig) {
        QUITagType type = newConfig.getType();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setBackground(type.getBgDrawable$QUITagView_debug(context, newConfig.getSize().getCornerRadius$QUITagView_debug()));
        TextView textView = this.contentTextView;
        QUITagType type2 = newConfig.getType();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView.setTextColor(type2.getTextColor$QUITagView_debug(context2));
    }

    public final void setConfig(@NotNull QUITagViewConfig newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.currentConfig.getSize() != newConfig.getSize()) {
            e(newConfig);
        }
        if (this.currentConfig.getType() != newConfig.getType()) {
            f(newConfig);
        }
        if (!Intrinsics.areEqual(this.currentConfig.getContent(), newConfig.getContent())) {
            c(newConfig);
        }
        if (!Intrinsics.areEqual(this.currentConfig.getIcon(), newConfig.getIcon())) {
            d(newConfig);
        }
        this.currentConfig = newConfig;
    }

    public /* synthetic */ QUITagView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
