package com.tencent.timi.game.liveroom.impl.room.like;

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
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.timi.game.initer.impl.LibraryInitManager;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.liveroom.impl.room.like.LikeNumView;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0002+,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u001dJ\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0007H\u0002R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeNumView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "EXPLORE_PAG_SIZE", "getEXPLORE_PAG_SIZE", "()I", "curLikeNum", "currentScale", "", "defaultScale", "numContainer", "Landroid/view/ViewGroup;", "numViewList", "", "Landroid/widget/ImageView;", "pagInited", "", "scaleAnimate", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikeNumView$CustomScaleAnim;", "upgradePag", "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "xNumView", "fixPagPos", "", "getPAGFile", "Lorg/libpag/PAGFile;", "level", "initPagView", "injectPagAndPlay", "loadPag", "pagFile", "width", "setLikeNum", "likeNum", "tryVibrate", "updateNumImage", "updateScale", "Companion", "CustomScaleAnim", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LikeNumView extends FrameLayout {

    @NotNull
    private static final String TAG = "Like_Biz|LikeNumView";
    private final int EXPLORE_PAG_SIZE;
    private int curLikeNum;
    private float currentScale;
    private float defaultScale;

    @NotNull
    private ViewGroup numContainer;

    @NotNull
    private List<ImageView> numViewList;
    private boolean pagInited;

    @NotNull
    private CustomScaleAnim scaleAnimate;

    @NotNull
    private TimiGamePAGView upgradePag;

    @NotNull
    private ImageView xNumView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeNumView$CustomScaleAnim;", "", "view", "Landroid/view/View;", "from", "", "to", "(Landroid/view/View;FF)V", "getFrom", "()F", "setFrom", "(F)V", "scaleAnim", "Landroid/animation/ValueAnimator;", "getTo", "setTo", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", CanvasView.ACTION_RESTORE, "", "startScale", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class CustomScaleAnim {
        private float from;

        @NotNull
        private ValueAnimator scaleAnim;
        private float to;

        @NotNull
        private View view;

        public CustomScaleAnim(@NotNull View view, float f16, float f17) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.from = f16;
            this.to = f17;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(from, to)");
            this.scaleAnim = ofFloat;
            ofFloat.setDuration(150L);
            this.scaleAnim.setInterpolator(new DecelerateInterpolator());
            this.scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LikeNumView.CustomScaleAnim._init_$lambda$0(LikeNumView.CustomScaleAnim.this, valueAnimator);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(CustomScaleAnim this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            this$0.view.setScaleX(floatValue);
            this$0.view.setScaleY(floatValue);
        }

        public final float getFrom() {
            return this.from;
        }

        public final float getTo() {
            return this.to;
        }

        @NotNull
        public final View getView() {
            return this.view;
        }

        public final void restore() {
            this.scaleAnim.cancel();
            this.scaleAnim.reverse();
        }

        public final void setFrom(float f16) {
            this.from = f16;
        }

        public final void setTo(float f16) {
            this.to = f16;
        }

        public final void setView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.view = view;
        }

        public final void startScale() {
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

    private final void fixPagPos() {
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
                this.upgradePag.setTranslationX((r3.getLeft() + this.numContainer.getLeft()) - fh4.b.b(8));
                this.upgradePag.setTranslationY((this.numContainer.getBottom() - fh4.b.b(5)) - this.upgradePag.getHeight());
            }
        }
    }

    private final PAGFile getPAGFile(int level) {
        LikeConfig.Companion companion = LikeConfig.INSTANCE;
        if (!TextUtils.isEmpty(companion.getConfig().getUpgradePagPath(level))) {
            return loadPag(PagViewMonitor.Load(companion.getConfig().getUpgradePagPath(level)), this.EXPLORE_PAG_SIZE);
        }
        return loadPag(PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), companion.getConfig().getUpgradePagAssert()), this.EXPLORE_PAG_SIZE);
    }

    private final void initPagView() {
        if (!LibraryInitManager.f377186a.c()) {
            return;
        }
        int i3 = this.EXPLORE_PAG_SIZE;
        this.upgradePag.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        addView(this.upgradePag);
        PAGComposition Make = PAGComposition.Make(i3, i3);
        if (Make == null) {
            return;
        }
        PAGFile pAGFile = getPAGFile(0);
        if (pAGFile != null) {
            Make.addLayer(pAGFile);
        }
        this.upgradePag.setComposition(Make);
        this.upgradePag.setProgress(0.0d);
        this.upgradePag.setVisibility(0);
        this.upgradePag.b(new PAGView.PAGViewListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LikeNumView$initPagView$2
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
        });
        this.pagInited = true;
    }

    private final void injectPagAndPlay(int level) {
        if (!this.pagInited) {
            initPagView();
        }
        if (!this.pagInited) {
            return;
        }
        fixPagPos();
        PAGFile pAGFile = getPAGFile(level);
        if (pAGFile == null) {
            return;
        }
        PAGComposition d16 = this.upgradePag.d();
        if (d16 != null) {
            d16.removeAllLayers();
            d16.addLayer(pAGFile);
        }
        this.upgradePag.setProgress(0.0d);
        this.upgradePag.setVisibility(0);
        this.upgradePag.setRepeatCount(1);
        this.upgradePag.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.b
            @Override // java.lang.Runnable
            public final void run() {
                LikeNumView.injectPagAndPlay$lambda$2(LikeNumView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void injectPagAndPlay$lambda$2(LikeNumView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.upgradePag.g();
    }

    private final PAGFile loadPag(PAGFile pagFile, int width) {
        if (pagFile == null) {
            return null;
        }
        Matrix totalMatrix = pagFile.getTotalMatrix();
        float width2 = width / pagFile.width();
        totalMatrix.setScale(width2, width2);
        pagFile.setMatrix(totalMatrix);
        return pagFile;
    }

    private final void updateNumImage(int likeNum, int level) {
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
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fh4.b.b(44), fh4.b.b(60));
                    layoutParams.topMargin = fh4.b.b(3);
                    if (i16 != 0) {
                        layoutParams.leftMargin = -fh4.b.b(6);
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
                LikeConfig.INSTANCE.getConfig().setNumImageRes(imageView3, Integer.parseInt(String.valueOf(String.valueOf(likeNum).charAt(i18))), level);
            } else {
                imageView3.setVisibility(8);
            }
            i18 = i19;
        }
        LikeConfig.INSTANCE.getConfig().setNumImageRes(this.xNumView, -1, level);
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
            this.scaleAnimate.setView(imageView4);
            this.scaleAnimate.startScale();
        }
    }

    private final void updateScale(int level) {
        float likeNumScale = LikeConfig.INSTANCE.getConfig().getLikeNumScale(level) * this.defaultScale;
        this.currentScale = likeNumScale;
        this.numContainer.setScaleX(likeNumScale);
        this.numContainer.setScaleY(this.currentScale);
        this.scaleAnimate.setFrom(this.currentScale);
        this.scaleAnimate.setTo(this.currentScale * 1.25f);
    }

    public final int getEXPLORE_PAG_SIZE() {
        return this.EXPLORE_PAG_SIZE;
    }

    public final void setLikeNum(int likeNum) {
        if (this.curLikeNum != likeNum) {
            LikeConfig.Companion companion = LikeConfig.INSTANCE;
            int levelByNum = companion.getConfig().getLevelByNum(this.curLikeNum);
            int levelByNum2 = companion.getConfig().getLevelByNum(likeNum);
            if (levelByNum2 != levelByNum || this.curLikeNum == -1 || String.valueOf(likeNum).length() != String.valueOf(this.curLikeNum).length()) {
                injectPagAndPlay(levelByNum2);
                updateScale(levelByNum2);
            }
            updateNumImage(likeNum, levelByNum2);
            tryVibrate();
            this.curLikeNum = likeNum;
            AegisLogger.INSTANCE.i(TAG, "setLikeNum:" + likeNum);
        }
    }

    public final void tryVibrate() {
        VibrationEffect createOneShot;
        try {
            Object systemService = getContext().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                createOneShot = VibrationEffect.createOneShot(20L, -1);
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(20L);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.EXPLORE_PAG_SIZE = fh4.b.b(70);
        this.numViewList = new ArrayList();
        this.curLikeNum = -1;
        this.defaultScale = 0.5f;
        this.currentScale = 0.5f;
        LayoutInflater.from(getContext()).inflate(R.layout.huc, this);
        View findViewById = findViewById(R.id.zvn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.numContainer)");
        this.numContainer = (ViewGroup) findViewById;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        this.upgradePag = new TimiGamePAGView(context2, null, 0, 6, null);
        this.scaleAnimate = new CustomScaleAnim(this.numContainer, 0.75f, 1.0f);
        ImageView imageView = new ImageView(getContext());
        this.xNumView = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fh4.b.b(34), fh4.b.b(34));
        layoutParams.gravity = 80;
        imageView.setLayoutParams(layoutParams);
        this.numContainer.addView(this.xNumView);
        initPagView();
    }
}
