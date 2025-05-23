package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002)-\u0018\u0000 =2\u00020\u0001:\u0002>?B\u001d\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\"\"\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar;", "Landroid/widget/FrameLayout;", "", "j", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "k", "i", "Lcom/tencent/sqshow/zootopia/data/m;", "data", "setMapDetailData", "g", "", NodeProps.VISIBLE, "setSizeTextVisible", "Lfi3/g;", "d", "Lfi3/g;", "binding", "", "e", "J", "animationDelay", "f", "Z", "initAnimation", tl.h.F, "needEnter", "needExit", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "setBtnDownload", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;)V", "btnDownload", BdhLogUtil.LogTag.Tag_Conn, "I", NodeProps.SHADOW_COLOR, "com/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$c", "D", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$c;", "enterAnimationListener", "com/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$d", "E", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$d;", "exitAnimationListener", "Landroid/view/animation/TranslateAnimation;", UserInfo.SEX_FEMALE, "Landroid/view/animation/TranslateAnimation;", "enterAnimation", "G", "exitAnimation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailFloatBar extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int shadowColor;

    /* renamed from: D, reason: from kotlin metadata */
    private c enterAnimationListener;

    /* renamed from: E, reason: from kotlin metadata */
    private d exitAnimationListener;

    /* renamed from: F, reason: from kotlin metadata */
    private TranslateAnimation enterAnimation;

    /* renamed from: G, reason: from kotlin metadata */
    private TranslateAnimation exitAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final fi3.g binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long animationDelay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean initAnimation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean needEnter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needExit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDownloadButton btnDownload;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$b;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "", "d", "Z", "a", "()Z", "setAnimating", "(Z)V", "isAnimating", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$c", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$b;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends b {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (ZootopiaDetailFloatBar.this.needExit) {
                ZootopiaDetailFloatBar.this.i();
            }
            if (ZootopiaDetailFloatBar.this.initAnimation) {
                return;
            }
            ZootopiaDetailFloatBar.this.j();
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            super.onAnimationStart(animation);
            ZootopiaDetailFloatBar.this.setVisibility(0);
            ZootopiaDetailFloatBar.this.needEnter = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$d", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailFloatBar$b;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends b {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            ZootopiaDetailFloatBar.this.setVisibility(8);
            if (ZootopiaDetailFloatBar.this.needEnter) {
                ZootopiaDetailFloatBar.this.k();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar.b, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            super.onAnimationStart(animation);
            ZootopiaDetailFloatBar.this.needExit = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailFloatBar(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
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
        return this.binding.f399263b.getStatus() == ButtonStatus.INIT;
    }

    /* renamed from: h, reason: from getter */
    public final ZootopiaDownloadButton getBtnDownload() {
        return this.btnDownload;
    }

    public final boolean i() {
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

    public final boolean k() {
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
        j();
    }

    public final void setBtnDownload(ZootopiaDownloadButton zootopiaDownloadButton) {
        Intrinsics.checkNotNullParameter(zootopiaDownloadButton, "<set-?>");
        this.btnDownload = zootopiaDownloadButton;
    }

    public final void setMapDetailData(ZootopiaMapDetail data) {
        Intrinsics.checkNotNullParameter(data, "data");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (TextUtils.isEmpty(data.getIcon())) {
            this.binding.f399267f.setImageResource(R.drawable.ik_);
        } else {
            this.binding.f399267f.setImageDrawable(URLDrawable.getDrawable(data.getIcon(), obtain));
        }
        this.binding.f399266e.setText(data.getTitle());
        this.binding.f399265d.setText(data.getDesc());
        TextView textView = this.binding.f399269h;
        if (data.getModVersionSimpleData().getDataSize() != 0 && g()) {
            textView.setVisibility(0);
            textView.setText(t74.a.a(data.getModVersionSimpleData().getDataSize()));
        } else {
            textView.setVisibility(8);
        }
    }

    public final void setSizeTextVisible(int visible) {
        this.binding.f399269h.setVisibility(visible);
    }

    public /* synthetic */ ZootopiaDetailFloatBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailFloatBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.g f16 = fi3.g.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context),this)");
        this.binding = f16;
        this.animationDelay = 500L;
        ZootopiaDownloadButton zootopiaDownloadButton = f16.f399263b;
        Intrinsics.checkNotNullExpressionValue(zootopiaDownloadButton, "binding.btnDownload");
        this.btnDownload = zootopiaDownloadButton;
        int parseColor = Color.parseColor("#99000000");
        this.shadowColor = parseColor;
        this.enterAnimationListener = new c();
        this.exitAnimationListener = new d();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(this.animationDelay);
        translateAnimation.setAnimationListener(this.enterAnimationListener);
        this.enterAnimation = translateAnimation;
        ZootopiaDownloadButton zootopiaDownloadButton2 = f16.f399263b;
        zootopiaDownloadButton2.setButtonType(ZootopiaDownloadBarType.BOTTOM_DOWNLOAD_BAR);
        zootopiaDownloadButton2.setShowButtonSubText(false);
        setBackgroundResource(R.drawable.gyr);
        int i3 = Build.VERSION.SDK_INT;
        setTranslationZ(com.tencent.sqshow.zootopia.utils.i.a(20.0f));
        setElevation(com.tencent.sqshow.zootopia.utils.i.a(2.0f));
        if (i3 >= 28) {
            setOutlineAmbientShadowColor(parseColor);
            setOutlineSpotShadowColor(parseColor);
        }
    }
}
