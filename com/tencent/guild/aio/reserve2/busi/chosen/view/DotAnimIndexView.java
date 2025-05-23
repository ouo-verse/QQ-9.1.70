package com.tencent.guild.aio.reserve2.busi.chosen.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002%&B\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!B\u001d\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b \u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012\u00a2\u0006\u0002\b\u0014J\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView;", "Landroid/widget/RelativeLayout;", "", "d", com.tencent.luggage.wxa.c8.c.G, "", "k", "i", "Landroid/view/View;", h.F, "startValue", "endValue", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "onFinishInflate", "Lkotlin/Function1;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView$Config;", "Lkotlin/ExtensionFunctionType;", "block", "g", "l", "j", "Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView$Config;", DownloadInfo.spKey_Config, "Lvn0/b;", "Lvn0/b;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "Config", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class DotAnimIndexView extends RelativeLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int f112218h = com.tencent.guild.aio.util.c.b(3);

    /* renamed from: i, reason: collision with root package name */
    private static final int f112219i = com.tencent.guild.aio.util.c.b(3);

    /* renamed from: m, reason: collision with root package name */
    private static final int f112220m = com.tencent.guild.aio.util.c.b(5);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Config config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vn0.b binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u0000 \u00032\u00020\u0001:\u0002\u0005%B\u0007\u00a2\u0006\u0004\b$\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016R(\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0005\u0010\n\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b \u0010\u000eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\"\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView$Config;", "", "", h.F, "", "a", "", "k", "", "toString", "I", "getOrientationMode", "()I", "setOrientationMode", "(I)V", "getOrientationMode$annotations", "()V", "orientationMode", "b", "d", "setNormalDrawableRes", "normalDrawableRes", "c", "e", "setSelectedDrawableRes", "selectedDrawableRes", "g", "j", "totalNum", "f", "i", "selectedPos", "setMaxDotNum", "maxDotNum", "setDotPadding", "dotPadding", "<init>", "OrientationMode", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class Config {

        /* renamed from: i, reason: collision with root package name */
        private static final int f112224i = com.tencent.guild.aio.util.c.b(2);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int totalNum;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int selectedPos;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int orientationMode = 1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int normalDrawableRes = R.drawable.guild_topping_msg_gray_point;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int selectedDrawableRes = R.drawable.guild_topping_msg_blue_point;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int maxDotNum = 5;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int dotPadding = f112224i;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/view/DotAnimIndexView$Config$OrientationMode;", "", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public @interface OrientationMode {
        }

        public final void a() {
            int i3 = this.selectedPos - 1;
            this.selectedPos = i3;
            if (i3 < 0) {
                this.selectedPos = this.totalNum - 1;
            }
        }

        /* renamed from: b, reason: from getter */
        public final int getDotPadding() {
            return this.dotPadding;
        }

        /* renamed from: c, reason: from getter */
        public final int getMaxDotNum() {
            return this.maxDotNum;
        }

        /* renamed from: d, reason: from getter */
        public final int getNormalDrawableRes() {
            return this.normalDrawableRes;
        }

        /* renamed from: e, reason: from getter */
        public final int getSelectedDrawableRes() {
            return this.selectedDrawableRes;
        }

        /* renamed from: f, reason: from getter */
        public final int getSelectedPos() {
            return this.selectedPos;
        }

        /* renamed from: g, reason: from getter */
        public final int getTotalNum() {
            return this.totalNum;
        }

        public final boolean h() {
            if (this.orientationMode == 0) {
                return true;
            }
            return false;
        }

        public final void i(int i3) {
            this.selectedPos = i3;
        }

        public final void j(int i3) {
            this.totalNum = i3;
        }

        public final int k() {
            return !h() ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "totalNum=" + this.totalNum + ", selectedPos=" + this.selectedPos + " dotPadding=" + this.dotPadding + " maxDotNum=" + this.maxDotNum;
        }
    }

    public DotAnimIndexView(@Nullable Context context) {
        super(context);
        this.config = new Config();
    }

    private final int d() {
        if (this.config.getTotalNum() == 0) {
            return -1;
        }
        if (this.config.getTotalNum() <= 5) {
            return this.config.getSelectedPos();
        }
        int totalNum = 5 - (this.config.getTotalNum() - this.config.getSelectedPos());
        if (totalNum >= 0) {
            if (totalNum == 0 && this.config.getTotalNum() > 5) {
                return 1;
            }
            return totalNum;
        }
        if (this.config.getSelectedPos() > 0) {
            return 1;
        }
        return 0;
    }

    private final int e(int pos) {
        int dotPadding = (this.config.getDotPadding() * 2) + f112218h;
        return (pos * dotPadding) + ((dotPadding - f112219i) / 2);
    }

    private final int f(int pos) {
        int dotPadding = (this.config.getDotPadding() * 2) + f112218h;
        return (pos * dotPadding) + ((dotPadding - f112220m) / 2);
    }

    private final View h() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(this.config.getNormalDrawableRes());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.config.h()) {
            layoutParams.leftMargin = this.config.getDotPadding();
            layoutParams.rightMargin = this.config.getDotPadding();
        } else {
            layoutParams.topMargin = this.config.getDotPadding();
            layoutParams.bottomMargin = this.config.getDotPadding();
        }
        imageView.setLayoutParams(layoutParams);
        imageView.measure(0, 0);
        return imageView;
    }

    private final void i() {
        View root;
        ImageView imageView;
        LinearLayout linearLayout;
        QLog.i("DotAnimIndexView", 4, "init " + this.config);
        vn0.b bVar = this.binding;
        if (bVar != null && (linearLayout = bVar.f441917b) != null) {
            linearLayout.removeAllViews();
            linearLayout.setOrientation(this.config.k());
            int min = Math.min(this.config.getTotalNum(), this.config.getMaxDotNum());
            for (int i3 = 0; i3 < min; i3++) {
                linearLayout.addView(h());
            }
        }
        vn0.b bVar2 = this.binding;
        if (bVar2 != null && (imageView = bVar2.f441918c) != null) {
            imageView.setImageResource(this.config.getSelectedDrawableRes());
        }
        j(d());
        vn0.b bVar3 = this.binding;
        if (bVar3 != null && (root = bVar3.getRoot()) != null) {
            boolean z16 = true;
            if (this.config.getTotalNum() > 1) {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            root.setVisibility(4);
            if (((View) g.a(valueOf, root)) == null) {
                root.setVisibility(0);
            }
        }
    }

    private final void k(int pos) {
        boolean z16;
        int f16;
        int i3;
        Object obj;
        boolean z17;
        Pair pair;
        int i16;
        ImageView imageView;
        boolean z18 = true;
        if (pos >= this.config.getMaxDotNum()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = (Integer) g.a(Boolean.valueOf(z16), Integer.valueOf(this.config.getMaxDotNum() - 1));
        if (num != null) {
            pos = num.intValue();
        }
        if (this.config.h()) {
            f16 = 0;
        } else {
            f16 = f(pos);
        }
        if (this.config.h()) {
            i3 = e(pos);
        } else {
            i3 = 0;
        }
        vn0.b bVar = this.binding;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (bVar != null && (imageView = bVar.f441918c) != null) {
            obj = imageView.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
        }
        if (marginLayoutParams != null && marginLayoutParams.topMargin == f16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (marginLayoutParams != null) {
                i16 = marginLayoutParams.topMargin;
            } else {
                i16 = 0;
            }
            pair = new Pair(Integer.valueOf(i16), Integer.valueOf(f16));
        } else {
            int i17 = marginLayoutParams.leftMargin;
            if (i17 != i3) {
                pair = new Pair(Integer.valueOf(i17), Integer.valueOf(i3));
            } else {
                pair = new Pair(0, 0);
            }
        }
        if (((Number) pair.getFirst()).intValue() == ((Number) pair.getSecond()).intValue()) {
            z18 = false;
        }
        g.b(Boolean.valueOf(z18), new DotAnimIndexView$selectPosSmooth$1(this, pair, marginLayoutParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int startValue, int endValue, ValueAnimator.AnimatorUpdateListener listener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(startValue, endValue);
        ofInt.setDuration(150L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(listener);
        ofInt.start();
    }

    public final void g(@NotNull Function1<? super Config, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(this.config);
        i();
    }

    public final void j(int pos) {
        int f16;
        ImageView imageView;
        QLog.i("DotAnimIndexView", 4, "selectPos=" + pos);
        int i3 = 0;
        int max = Math.max(Math.min(pos, this.config.getMaxDotNum() + (-1)), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.config.h()) {
            f16 = 0;
        } else {
            f16 = f(max);
        }
        layoutParams.topMargin = f16;
        if (this.config.h()) {
            i3 = e(max);
        }
        layoutParams.leftMargin = i3;
        vn0.b bVar = this.binding;
        if (bVar != null) {
            imageView = bVar.f441918c;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
    }

    public final void l() {
        this.config.a();
        k(d());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.binding = vn0.b.f(c.a(this), this);
    }

    public DotAnimIndexView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.config = new Config();
    }
}
