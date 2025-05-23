package com.tencent.mobileqq.guild.media.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.media.widget.GuildMediaChannelRippleView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002DEB\u001d\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010 \u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00100R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00102R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R$\u00109\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u0010$R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\"R\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\"\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;", "Landroid/view/View;", "Landroid/content/res/TypedArray;", "typedArray", "", "i", DomainData.DOMAIN_NAME, "o", "p", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "changedView", "", "visibility", "onVisibilityChanged", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setVolume", "", "enable", "setEnableRadiusRatio", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "d", "Landroid/animation/ValueAnimator;", "mSpawnAnimator", "", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView$a;", "e", "Ljava/util/List;", "mRippleAnimators", "f", "Z", "isMale", "()Z", "setMale", "(Z)V", "", tl.h.F, UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()F", "setIgnoreArealRadius", "(F)V", "ignoreArealRadius", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "centerInvalidPaint", "I", "mVolume", BdhLogUtil.LogTag.Tag_Conn, "mRefRadius", "<set-?>", "D", "getMStarted", "mStarted", "E", "mEnableRadiusRatio", "mEnableLowVolumeAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChannelRippleView extends View {

    @NotNull
    private static final Paint H;

    @NotNull
    private static final Paint I;

    /* renamed from: C, reason: from kotlin metadata */
    private int mRefRadius;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mStarted;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mEnableRadiusRatio;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mEnableLowVolumeAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator mSpawnAnimator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> mRippleAnimators;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isMale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float ignoreArealRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path centerInvalidPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mVolume;

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#00B3FF"));
        paint.setStrokeWidth(2.0f);
        H = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.parseColor("#FF4FA7"));
        paint2.setStrokeWidth(2.0f);
        I = paint2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelRippleView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void i(TypedArray typedArray) {
        boolean z16 = false;
        Integer valueOf = Integer.valueOf(typedArray.getResourceId(up1.a.f439618p4, 0));
        if (valueOf.intValue() != 0) {
            z16 = true;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            final int intValue = valueOf.intValue();
            getRootView().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaChannelRippleView.j(GuildMediaChannelRippleView.this, intValue);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final GuildMediaChannelRippleView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final View findViewById = this$0.getRootView().findViewById(i3);
        findViewById.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaChannelRippleView.k(GuildMediaChannelRippleView.this, findViewById);
            }
        });
        findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.media.widget.l
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
                GuildMediaChannelRippleView.l(GuildMediaChannelRippleView.this, findViewById, view, i16, i17, i18, i19, i26, i27, i28, i29);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildMediaChannelRippleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mRefRadius = view.getWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildMediaChannelRippleView this$0, View view, View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mRefRadius = view.getWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        for (a aVar : this.mRippleAnimators) {
            if (aVar.getMIdle()) {
                aVar.i();
                return;
            }
        }
    }

    private final void o() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildMediaChannelRippleView", 2, "start");
        }
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mSpawnAnimator.start();
    }

    private final void p() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildMediaChannelRippleView", 2, "outer stop");
        }
        if (!this.mStarted) {
            return;
        }
        this.mStarted = false;
        this.mSpawnAnimator.cancel();
        Iterator<T> it = this.mRippleAnimators.iterator();
        while (it.hasNext()) {
            ((a) it.next()).j();
        }
    }

    /* renamed from: m, reason: from getter */
    public final float getIgnoreArealRadius() {
        return this.ignoreArealRadius;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        if (getVisibility() == 0) {
            o();
        } else {
            p();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.mStarted) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            return;
        }
        if (this.isMale) {
            paint = H;
        } else {
            paint = I;
        }
        for (a aVar : this.mRippleAnimators) {
            if (!aVar.getMIdle()) {
                float mFraction = aVar.getMFraction();
                float f16 = 1 - mFraction;
                paint.setStrokeWidth(aVar.getMCurMaxStrokeWidth() * f16);
                paint.setAlpha((int) (f16 * 255));
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, aVar.getMCurInitRadius() + ((aVar.getMCurMaxRadius() - aVar.getMCurInitRadius()) * mFraction), paint);
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (visibility == 0) {
            o();
        } else {
            p();
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setEnableRadiusRatio(boolean enable) {
        this.mEnableRadiusRatio = enable;
    }

    public final void setIgnoreArealRadius(float f16) {
        this.ignoreArealRadius = f16;
    }

    public final void setMale(boolean z16) {
        this.isMale = z16;
    }

    public final void setVolume(int volume) {
        this.mVolume = volume;
    }

    public /* synthetic */ GuildMediaChannelRippleView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelRippleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ValueAnimator mSpawnAnimator$lambda$1 = ValueAnimator.ofFloat(0.0f, 1.0f);
        mSpawnAnimator$lambda$1.setInterpolator(new LinearInterpolator());
        mSpawnAnimator$lambda$1.setDuration(670L);
        Intrinsics.checkNotNullExpressionValue(mSpawnAnimator$lambda$1, "mSpawnAnimator$lambda$1");
        mSpawnAnimator$lambda$1.setRepeatCount(-1);
        mSpawnAnimator$lambda$1.addListener(new c());
        this.mSpawnAnimator = mSpawnAnimator$lambda$1;
        int ceil = (int) Math.ceil(1.492537313432836d);
        ArrayList arrayList = new ArrayList(ceil);
        for (int i3 = 0; i3 < ceil; i3++) {
            arrayList.add(new a(this, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelRippleView$mRippleAnimators$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildMediaChannelRippleView.this.invalidate();
                }
            }));
        }
        this.mRippleAnimators = arrayList;
        this.isMale = true;
        this.centerInvalidPaint = new Path();
        this.mEnableRadiusRatio = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439580m4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "this");
        i(obtainStyledAttributes);
        this.mEnableRadiusRatio = obtainStyledAttributes.getBoolean(up1.a.f439605o4, true);
        this.mEnableLowVolumeAnim = obtainStyledAttributes.getBoolean(up1.a.f439592n4, false);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001c\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView$a;", "", "", "i", "j", "", "c", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "a", "Landroid/animation/ValueAnimator;", "mAnimator", "", "<set-?>", "b", "Z", "g", "()Z", "mIdle", "", "I", "d", "()I", "mCurInitRadius", "e", "mCurMaxRadius", "f", "mCurMaxStrokeWidth", UserInfo.SEX_FEMALE, "getMFraction", "()F", "mFraction", "Lkotlin/Function0;", "onUpdate", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ValueAnimator mAnimator;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean mIdle;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mCurInitRadius;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mCurMaxRadius;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mCurMaxStrokeWidth;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float mFraction;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ GuildMediaChannelRippleView f229671g;

        public a(@NotNull GuildMediaChannelRippleView guildMediaChannelRippleView, final Function0<Unit> onUpdate) {
            Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
            this.f229671g = guildMediaChannelRippleView;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildMediaChannelRippleView.a.h(GuildMediaChannelRippleView.a.this, onUpdate, valueAnimator);
                }
            });
            ofFloat.addListener(new C7843a());
            this.mAnimator = ofFloat;
            this.mIdle = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(a this$0, Function0 onUpdate, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(onUpdate, "$onUpdate");
            this$0.mFraction = valueAnimator.getAnimatedFraction();
            onUpdate.invoke();
        }

        /* renamed from: c, reason: from getter */
        public final float getMFraction() {
            return this.mFraction;
        }

        /* renamed from: d, reason: from getter */
        public final int getMCurInitRadius() {
            return this.mCurInitRadius;
        }

        /* renamed from: e, reason: from getter */
        public final int getMCurMaxRadius() {
            return this.mCurMaxRadius;
        }

        /* renamed from: f, reason: from getter */
        public final int getMCurMaxStrokeWidth() {
            return this.mCurMaxStrokeWidth;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getMIdle() {
            return this.mIdle;
        }

        public final void i() {
            double coerceIn;
            double coerceIn2;
            this.mIdle = false;
            double d16 = 1.0d;
            coerceIn = RangesKt___RangesKt.coerceIn((this.f229671g.mVolume * 1.0d) / 65, 0.8d, 1.2d);
            if (this.f229671g.mEnableRadiusRatio) {
                d16 = coerceIn;
            }
            coerceIn2 = RangesKt___RangesKt.coerceIn(d16, 0.8d, 1.0d);
            this.mCurInitRadius = (int) (this.f229671g.mRefRadius * 0.85d * coerceIn2);
            this.mCurMaxRadius = (int) (this.f229671g.mRefRadius * 1.62d * d16);
            this.mCurMaxStrokeWidth = (int) (this.f229671g.mRefRadius * 0.3d * coerceIn);
            if (this.f229671g.mVolume < 10 && this.f229671g.mEnableLowVolumeAnim) {
                this.mCurInitRadius = (int) (this.f229671g.mRefRadius * 0.85d);
                this.mCurMaxRadius = (int) (this.f229671g.mRefRadius * 1.2d);
                this.mCurMaxStrokeWidth = (int) (this.f229671g.mRefRadius * 0.3d * 0.9d);
            }
            this.mAnimator.start();
        }

        public final void j() {
            this.mIdle = true;
            this.mAnimator.cancel();
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView$a$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelRippleView$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7843a implements Animator.AnimatorListener {
            C7843a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator p06) {
                a.this.mIdle = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator p06) {
                a.this.mIdle = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator p06) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator p06) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaChannelRippleView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
            GuildMediaChannelRippleView.this.n();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator p06) {
        }
    }
}
