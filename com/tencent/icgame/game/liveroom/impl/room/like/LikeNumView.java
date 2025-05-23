package com.tencent.icgame.game.liveroom.impl.room.like;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.like.LikeNumView;
import com.tencent.icgame.game.liveroom.impl.room.like.c;
import com.tencent.icgame.game.ui.pag.TimiGamePAGView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import ew0.LikeVibrateBean;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002CDB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0012R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010,R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b\u0017\u0010:\u00a8\u0006E"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView;", "Landroid/widget/FrameLayout;", "", "level", "", "g", "Lorg/libpag/PAGFile;", "d", "c", "likeNum", "k", "l", "pagFile", "width", "i", "j", "setLikeNum", "f", "I", "getEXPLORE_PAG_SIZE", "()I", "EXPLORE_PAG_SIZE", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "numContainer", "Lcom/tencent/icgame/game/ui/pag/TimiGamePAGView;", "Lcom/tencent/icgame/game/ui/pag/TimiGamePAGView;", "upgradePag", "", "Landroid/widget/ImageView;", h.F, "Ljava/util/List;", "numViewList", "Landroid/widget/ImageView;", "xNumView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curLikeNum", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "pagInited", "", "D", UserInfo.SEX_FEMALE, "defaultScale", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView$b;", "E", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView$b;", "scaleAnimate", "currentScale", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "G", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lew0/c;", "H", "Lkotlin/Lazy;", "()Lew0/c;", "vibrateBean", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LikeNumView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean pagInited;

    /* renamed from: D, reason: from kotlin metadata */
    private float defaultScale;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private b scaleAnimate;

    /* renamed from: F, reason: from kotlin metadata */
    private float currentScale;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy vibrateBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int EXPLORE_PAG_SIZE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup numContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimiGamePAGView upgradePag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ImageView> numViewList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView xNumView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curLikeNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView$b;", "", "", "f", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "e", "(Landroid/view/View;)V", "view", "", "b", UserInfo.SEX_FEMALE, "getFrom", "()F", "c", "(F)V", "from", "getTo", "d", "to", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "scaleAnim", "<init>", "(Landroid/view/View;FF)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private View view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float from;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float to;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ValueAnimator scaleAnim;

        public b(@NotNull View view, float f16, float f17) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.from = f16;
            this.to = f17;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(from, to)");
            this.scaleAnim = ofFloat;
            ofFloat.setDuration(150L);
            this.scaleAnim.setInterpolator(new DecelerateInterpolator());
            this.scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LikeNumView.b.b(LikeNumView.b.this, valueAnimator);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            this$0.view.setScaleX(floatValue);
            this$0.view.setScaleY(floatValue);
        }

        public final void c(float f16) {
            this.from = f16;
        }

        public final void d(float f16) {
            this.to = f16;
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.view = view;
        }

        public final void f() {
            this.scaleAnim.cancel();
            this.scaleAnim.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LikeNumView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        boolean z16;
        ImageView imageView;
        boolean z17;
        List<ImageView> list = this.numViewList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            List<ImageView> list2 = this.numViewList;
            ListIterator<ImageView> listIterator = list2.listIterator(list2.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    imageView = listIterator.previous();
                    if (imageView.getVisibility() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    imageView = null;
                    break;
                }
            }
            if (imageView != null) {
                this.upgradePag.setTranslationX((r3.getLeft() + this.numContainer.getLeft()) - uu0.a.b(8));
                this.upgradePag.setTranslationY((this.numContainer.getBottom() - uu0.a.b(5)) - this.upgradePag.getHeight());
            }
        }
    }

    private final PAGFile d(int level) {
        c.Companion companion = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE;
        if (!TextUtils.isEmpty(companion.a().x(level))) {
            return i(PagViewMonitor.Load(companion.a().x(level)), this.EXPLORE_PAG_SIZE);
        }
        return i(PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), companion.a().v()), this.EXPLORE_PAG_SIZE);
    }

    private final LikeVibrateBean e() {
        return (LikeVibrateBean) this.vibrateBean.getValue();
    }

    private final void g(int level) {
        if (!this.pagInited) {
            f();
        }
        if (!this.pagInited) {
            return;
        }
        c();
        PAGFile d16 = d(level);
        if (d16 == null) {
            return;
        }
        PAGComposition d17 = this.upgradePag.d();
        if (d17 != null) {
            d17.removeAllLayers();
            d17.addLayer(d16);
        }
        this.upgradePag.setProgress(0.0d);
        this.upgradePag.setVisibility(0);
        this.upgradePag.setRepeatCount(1);
        this.upgradePag.post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.d
            @Override // java.lang.Runnable
            public final void run() {
                LikeNumView.h(LikeNumView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LikeNumView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.upgradePag.e();
    }

    private final PAGFile i(PAGFile pagFile, int width) {
        if (pagFile == null) {
            return null;
        }
        Matrix totalMatrix = pagFile.getTotalMatrix();
        float width2 = width / pagFile.width();
        totalMatrix.setScale(width2, width2);
        pagFile.setMatrix(totalMatrix);
        return pagFile;
    }

    private final void j() {
        VibrationEffect createOneShot;
        if (!ew0.d.INSTANCE.a()) {
            return;
        }
        try {
            Object systemService = getContext().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(e().getDuration(), e().getAmplitude());
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(e().getDuration());
            }
        } catch (Throwable th5) {
            this.log.a("LikeNumView", "try vibrate failed " + th5);
        }
    }

    private final void k(int likeNum, int level) {
        ImageView imageView;
        boolean z16;
        String valueOf = String.valueOf(likeNum);
        if (valueOf.length() > this.numViewList.size()) {
            int i3 = 0;
            int i16 = 0;
            while (i3 < valueOf.length()) {
                valueOf.charAt(i3);
                int i17 = i16 + 1;
                if (i16 >= this.numViewList.size()) {
                    ImageView imageView2 = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(uu0.a.b(44), uu0.a.b(60));
                    layoutParams.topMargin = uu0.a.b(3);
                    if (i16 != 0) {
                        layoutParams.leftMargin = -uu0.a.b(6);
                    }
                    imageView2.setLayoutParams(layoutParams);
                    this.numContainer.addView(imageView2);
                    this.numViewList.add(imageView2);
                }
                i3++;
                i16 = i17;
            }
        }
        int i18 = 0;
        for (Object obj : this.numViewList) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ImageView imageView3 = (ImageView) obj;
            if (i18 < valueOf.length()) {
                imageView3.setVisibility(0);
                imageView3.setScaleX(1.0f);
                imageView3.setScaleY(1.0f);
                com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().E(imageView3, Integer.parseInt(String.valueOf(String.valueOf(likeNum).charAt(i18))), level);
            } else {
                imageView3.setVisibility(8);
            }
            i18 = i19;
        }
        com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().E(this.xNumView, -1, level);
        List<ImageView> list = this.numViewList;
        ListIterator<ImageView> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                imageView = listIterator.previous();
                if (imageView.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                imageView = null;
                break;
            }
        }
        ImageView imageView4 = imageView;
        if (imageView4 != null) {
            this.scaleAnimate.e(imageView4);
            this.scaleAnimate.f();
        }
    }

    private final void l(int level) {
        float n3 = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().n(level) * this.defaultScale;
        this.currentScale = n3;
        this.numContainer.setScaleX(n3);
        this.numContainer.setScaleY(this.currentScale);
        this.scaleAnimate.c(this.currentScale);
        this.scaleAnimate.d(this.currentScale * 1.25f);
    }

    public final void f() {
        if (!((ev0.b) qx0.a.b(ev0.b.class)).t()) {
            return;
        }
        int i3 = this.EXPLORE_PAG_SIZE;
        this.upgradePag.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        addView(this.upgradePag);
        PAGComposition Make = PAGComposition.Make(i3, i3);
        if (Make == null) {
            return;
        }
        PAGFile d16 = d(0);
        if (d16 != null) {
            Make.addLayer(d16);
        }
        this.upgradePag.setComposition(Make);
        this.upgradePag.setProgress(0.0d);
        this.upgradePag.setVisibility(0);
        this.upgradePag.b(new c());
        this.pagInited = true;
    }

    public final void setLikeNum(int likeNum) {
        if (this.curLikeNum != likeNum) {
            c.Companion companion = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE;
            int l3 = companion.a().l(this.curLikeNum);
            int l16 = companion.a().l(likeNum);
            if (l16 != l3 || this.curLikeNum == -1 || String.valueOf(likeNum).length() != String.valueOf(this.curLikeNum).length()) {
                g(l16);
                l(l16);
            }
            k(likeNum, l16);
            j();
            this.curLikeNum = likeNum;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LikeNumView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LikeNumView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LikeNumView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.EXPLORE_PAG_SIZE = uu0.a.b(70);
        this.numViewList = new ArrayList();
        this.curLikeNum = -1;
        this.defaultScale = 0.5f;
        this.currentScale = 0.5f;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LikeVibrateBean>() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.LikeNumView$vibrateBean$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LikeVibrateBean invoke() {
                IAegisLogApi iAegisLogApi;
                Object configBean = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIKE_VIBRATE_CONFIG, LikeVibrateBean.class, new LikeVibrateBean(0L, 0, 3, null));
                Intrinsics.checkNotNullExpressionValue(configBean, "api(IICGameConfigApi::cl\u2026.java, LikeVibrateBean())");
                LikeVibrateBean likeVibrateBean = (LikeVibrateBean) configBean;
                iAegisLogApi = LikeNumView.this.log;
                iAegisLogApi.i("LikeNumView", "vibrateConfig " + likeVibrateBean);
                return likeVibrateBean;
            }
        });
        this.vibrateBean = lazy;
        LayoutInflater.from(getContext()).inflate(R.layout.fbm, this);
        View findViewById = findViewById(R.id.zvn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.numContainer)");
        this.numContainer = (ViewGroup) findViewById;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        this.upgradePag = new TimiGamePAGView(context2, null, 0, 6, null);
        this.scaleAnimate = new b(this.numContainer, 0.75f, 1.0f);
        ImageView imageView = new ImageView(getContext());
        this.xNumView = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(uu0.a.b(34), uu0.a.b(34));
        layoutParams.gravity = 80;
        imageView.setLayoutParams(layoutParams);
        this.numContainer.addView(this.xNumView);
        f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/LikeNumView$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
