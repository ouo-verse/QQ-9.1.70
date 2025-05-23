package com.tencent.mobileqq.guild.component.banner.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.viewpager2.widget.ViewPager2;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0005B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nR*\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator;", "Landroid/view/View;", "Log1/b;", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$a;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "selectedWidth", "setSelectedWidth", "selectedHeight", "setSelectedHeight", "value", "d", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$a;", "()Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$a;", "setOptions", "(Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$a;)V", "options", "e", "I", "selectedIndex", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "c", "()Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SimpleBannerIndicator extends View implements og1.b<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a options;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int selectedIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$a;", "Log1/a;", "", "b", "I", "c", "()I", "k", "(I)V", "gap", "Landroid/util/Size;", "Landroid/util/Size;", "j", "()Landroid/util/Size;", DomainData.DOMAIN_NAME, "(Landroid/util/Size;)V", "size", "d", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selectedSize", "e", h.F, "l", "resId", "g", "maxItemWidth", "f", "maxItemHeight", "indicatorWidth", "indicatorHeight", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends og1.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int gap;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Size size = new Size(0, 0);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Size selectedSize = new Size(0, 0);

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @DrawableRes
        private int resId = R.drawable.guild_banner_indicator;

        /* renamed from: c, reason: from getter */
        public final int getGap() {
            return this.gap;
        }

        public final int d() {
            return f();
        }

        public final int e() {
            return (this.gap * (getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_BANNER_COUNT java.lang.String() - 1)) + (g() * getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_BANNER_COUNT java.lang.String());
        }

        public final int f() {
            return Math.max(this.size.getHeight(), this.selectedSize.getHeight());
        }

        public final int g() {
            return Math.max(this.size.getWidth(), this.selectedSize.getWidth());
        }

        /* renamed from: h, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final Size getSelectedSize() {
            return this.selectedSize;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        public final void k(int i3) {
            this.gap = i3;
        }

        public final void l(int i3) {
            this.resId = i3;
        }

        public final void m(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.selectedSize = size;
        }

        public final void n(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.size = size;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            SimpleBannerIndicator.this.selectedIndex = position;
            SimpleBannerIndicator.this.invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SimpleBannerIndicator(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable c() {
        Resources resources = getResources();
        a options = getOptions();
        Intrinsics.checkNotNull(options);
        return resources.getDrawable(options.getResId());
    }

    @Override // og1.b
    @NotNull
    public ViewPager2.OnPageChangeCallback a() {
        return new b();
    }

    @Override // og1.b
    @NotNull
    /* renamed from: d, reason: from getter */
    public a getOptions() {
        return this.options;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        Size size;
        int[] iArr;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        a options = getOptions();
        Drawable c16 = c();
        int i3 = options.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_BANNER_COUNT java.lang.String();
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            if (this.selectedIndex == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                size = options.getSelectedSize();
            } else {
                size = options.getSize();
            }
            int g16 = (options.g() - size.getWidth()) / 2;
            int f16 = (options.f() - size.getHeight()) / 2;
            int i18 = g16 + i16;
            c16.setBounds(i18, f16, size.getWidth() + i18, size.getHeight() + f16);
            i16 += options.g() + options.getGap();
            if (c16.isStateful()) {
                if (z16) {
                    iArr = View.SELECTED_STATE_SET;
                } else {
                    iArr = View.EMPTY_STATE_SET;
                }
                c16.setState(iArr);
            }
            c16.draw(canvas);
        }
    }

    public final void setSelectedHeight(int selectedHeight) {
        getOptions().m(new Size(getOptions().getSelectedSize().getWidth(), selectedHeight));
        requestLayout();
    }

    public final void setSelectedWidth(int selectedWidth) {
        getOptions().m(new Size(selectedWidth, getOptions().getSelectedSize().getHeight()));
        requestLayout();
    }

    public /* synthetic */ SimpleBannerIndicator(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @Override // og1.b
    public void setOptions(@NotNull a value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.options = value;
        if (getOptions().getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_BANNER_COUNT java.lang.String() > 1) {
            setVisibility(0);
            kotlin.h.g(this, getOptions().e(), getOptions().d());
        } else {
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SimpleBannerIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.options = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.f215693k4, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026pleBannerIndicator, 0, 0)");
        getOptions().k(obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215705m4, getResources().getDimensionPixelSize(R.dimen.f159558dc4)));
        getOptions().n(new Size(obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215732q4, getResources().getDimensionPixelSize(R.dimen.dc8)), obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215711n4, getResources().getDimensionPixelSize(R.dimen.dc5))));
        getOptions().m(new Size(obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215725p4, getResources().getDimensionPixelSize(R.dimen.dc7)), obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215718o4, getResources().getDimensionPixelSize(R.dimen.dc6))));
        getOptions().l(obtainStyledAttributes.getResourceId(com.tencent.mobileqq.guild.component.b.f215699l4, R.drawable.lm8));
        setOptions(getOptions());
        obtainStyledAttributes.recycle();
    }
}
