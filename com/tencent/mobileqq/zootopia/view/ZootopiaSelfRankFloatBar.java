package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\"&\u0018\u0000 62\u00020\u0001:\u000278B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001dR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "Landroid/widget/FrameLayout;", "", tl.h.F, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "i", "g", "Lzb3/k;", "data", "setMapDetailRankData", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "getDefaultAvatarDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultAvatarDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultAvatarDrawable", "Lfi3/i;", "e", "Lfi3/i;", "binding", "", "f", "J", "animationDelay", "Z", "initAnimation", "needEnter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needExit", "com/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$c;", "enterAnimationListener", "com/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$d", "D", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$d;", "exitAnimationListener", "Landroid/view/animation/TranslateAnimation;", "E", "Landroid/view/animation/TranslateAnimation;", "enterAnimation", UserInfo.SEX_FEMALE, "exitAnimation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSelfRankFloatBar extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private c enterAnimationListener;

    /* renamed from: D, reason: from kotlin metadata */
    private d exitAnimationListener;

    /* renamed from: E, reason: from kotlin metadata */
    private TranslateAnimation enterAnimation;

    /* renamed from: F, reason: from kotlin metadata */
    private TranslateAnimation exitAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Drawable defaultAvatarDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final fi3.i binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long animationDelay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean initAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needEnter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean needExit;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$b;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "", "d", "Z", "a", "()Z", "setAnimating", "(Z)V", "isAnimating", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isAnimating;

        /* renamed from: a, reason: from getter */
        public final boolean getIsAnimating() {
            return this.isAnimating;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.isAnimating = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.isAnimating = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$c", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$b;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends b {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (ZootopiaSelfRankFloatBar.this.needExit) {
                ZootopiaSelfRankFloatBar.this.g();
            }
            if (ZootopiaSelfRankFloatBar.this.initAnimation) {
                return;
            }
            ZootopiaSelfRankFloatBar.this.h();
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            super.onAnimationStart(animation);
            ZootopiaSelfRankFloatBar.this.setVisibility(0);
            ZootopiaSelfRankFloatBar.this.needEnter = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$d", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar$b;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends b {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            ZootopiaSelfRankFloatBar.this.setVisibility(8);
            if (ZootopiaSelfRankFloatBar.this.needEnter) {
                ZootopiaSelfRankFloatBar.this.i();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            super.onAnimationStart(animation);
            ZootopiaSelfRankFloatBar.this.needExit = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaSelfRankFloatBar(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        float measuredHeight = (((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r0.bottomMargin : 0) + getMeasuredHeight()) / (getMeasuredHeight() * 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, measuredHeight, 1, 0.0f);
        translateAnimation.setDuration(this.animationDelay);
        translateAnimation.setAnimationListener(this.enterAnimationListener);
        this.enterAnimation = translateAnimation;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, measuredHeight);
        translateAnimation2.setDuration(this.animationDelay);
        translateAnimation2.setAnimationListener(this.exitAnimationListener);
        this.exitAnimation = translateAnimation2;
        this.initAnimation = true;
    }

    public final boolean g() {
        TranslateAnimation translateAnimation;
        if (this.exitAnimationListener.getIsAnimating()) {
            if (this.needEnter) {
                this.needEnter = false;
            }
            return false;
        }
        if (this.enterAnimationListener.getIsAnimating()) {
            this.needExit = true;
        } else if (getVisibility() == 0 && (translateAnimation = this.exitAnimation) != null) {
            startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    public final boolean i() {
        if (this.enterAnimationListener.getIsAnimating()) {
            if (this.needExit) {
                this.needExit = false;
            }
            return false;
        }
        if (this.exitAnimationListener.getIsAnimating()) {
            this.needEnter = true;
        } else if (getVisibility() != 0) {
            setVisibility(0);
            startAnimation(this.enterAnimation);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getMeasuredHeight() == 0 || this.initAnimation) {
            return;
        }
        h();
    }

    public final void setDefaultAvatarDrawable(Drawable drawable) {
        this.defaultAvatarDrawable = drawable;
    }

    public final void setMapDetailRankData(zb3.k data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.sqshow.zootopia.utils.ae.INSTANCE.a(this.binding.f399278b, data.getSelfRankData().f(), this.defaultAvatarDrawable, R.drawable.ibh);
        this.binding.f399280d.setText(data.getSelfRankData().h());
        this.binding.f399281e.setText(String.valueOf(data.getSelfRankData().getRank()));
        this.binding.f399282f.setText(data.getSelfRankData().getScore());
        this.binding.f399283g.setText(data.getRankConfig().getRankTableSortSuffix());
        TextView textView = this.binding.f399281e;
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        textView.setTypeface(mVar.f(assets));
        TextView textView2 = this.binding.f399282f;
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        textView2.setTypeface(mVar.f(assets2));
        if (data.getSelfRankData().getRank() == 0 || data.getSelfRankData().getRank() > data.getRankConfig().getRankDataMax()) {
            this.binding.f399281e.setText("\u672a\u4e0a\u699c");
            this.binding.f399281e.setTypeface(null);
        }
    }

    public /* synthetic */ ZootopiaSelfRankFloatBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSelfRankFloatBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.i f16 = fi3.i.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.animationDelay = 500L;
        this.enterAnimationListener = new c();
        this.exitAnimationListener = new d();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(this.animationDelay);
        translateAnimation.setAnimationListener(this.enterAnimationListener);
        this.enterAnimation = translateAnimation;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.defaultAvatarDrawable = com.tencent.mobileqq.mvvm.f.c(resources, R.drawable.ibh);
    }
}
