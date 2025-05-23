package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView;
import com.tencent.biz.qqcircle.utils.cv;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdFullView;", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView;", "", "d1", "c1", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setSnapshot", "", "position", "duration", "K0", NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "L0", "", "F0", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "snapshotImg", "Landroid/view/View;", "H", "Landroid/view/View;", "snapshotMask", "I", "replayLayout", "J", "snapshotLayout", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "progressText", "L", "animatorTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPauseAdFullView extends QFSPauseAdBaseView {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView snapshotImg;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View snapshotMask;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View replayLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View snapshotLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView progressText;

    /* renamed from: L, reason: from kotlin metadata */
    private long animatorTime;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdFullView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(QFSPauseAdFullView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(final QFSPauseAdFullView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c1();
        this$0.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.r
            @Override // java.lang.Runnable
            public final void run() {
                QFSPauseAdFullView.Z0(QFSPauseAdFullView.this);
            }
        }, this$0.animatorTime);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(QFSPauseAdFullView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSPauseAdBaseView.a dismissCallback = this$0.getDismissCallback();
        if (dismissCallback != null) {
            dismissCallback.onDismiss(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(final QFSPauseAdFullView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c1();
        this$0.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.q
            @Override // java.lang.Runnable
            public final void run() {
                QFSPauseAdFullView.b1(QFSPauseAdFullView.this);
            }
        }, this$0.animatorTime);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(QFSPauseAdFullView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSPauseAdBaseView.a dismissCallback = this$0.getDismissCallback();
        if (dismissCallback != null) {
            dismissCallback.onDismiss(true);
        }
    }

    private final void c1() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.snapshotLayout;
        float[] fArr = {view.getScaleX(), 1.0f};
        View view2 = this.snapshotLayout;
        float[] fArr2 = {view2.getScaleY(), 1.0f};
        View view3 = this.snapshotLayout;
        float[] fArr3 = {view3.getTranslationX(), 0.0f};
        View view4 = this.snapshotLayout;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, fArr), ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.SCALE_Y, fArr2), ObjectAnimator.ofFloat(view3, "translationX", fArr3), ObjectAnimator.ofFloat(view4, "translationY", view4.getTranslationY(), 0.0f));
        animatorSet.setDuration(this.animatorTime);
        animatorSet.start();
        this.snapshotMask.setVisibility(8);
        this.replayLayout.setVisibility(8);
    }

    private final void d1() {
        int width = this.snapshotLayout.getWidth();
        int height = this.snapshotLayout.getHeight();
        float a16 = cx.a(190.0f);
        float a17 = cx.a(109.0f);
        float f16 = width;
        float f17 = 2;
        float a18 = ((f16 - a16) / f17) - cx.a(2.0f);
        float f18 = height;
        float a19 = ((f18 - a17) / f17) - cx.a(18.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.snapshotLayout, BasicAnimation.KeyPath.SCALE_X, 1.0f, a16 / f16), ObjectAnimator.ofFloat(this.snapshotLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, a17 / f18), ObjectAnimator.ofFloat(this.snapshotLayout, "translationX", 0.0f, a18), ObjectAnimator.ofFloat(this.snapshotLayout, "translationY", 0.0f, a19));
        animatorSet.setDuration(this.animatorTime);
        animatorSet.start();
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSPauseAdFullView.e1(QFSPauseAdFullView.this);
            }
        }, this.animatorTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(QFSPauseAdFullView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.snapshotMask.setVisibility(0);
        this$0.replayLayout.setVisibility(0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    protected int F0() {
        return R.layout.gcj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    public void K0(long position, long duration) {
        super.K0(position, duration);
        if (duration == 0) {
            return;
        }
        this.progressText.setText(cv.c((int) position) + " / " + cv.c((int) duration));
    }

    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    public boolean L0(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        boolean L0 = super.L0(gdtAd);
        getNegativeFeedback().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPauseAdFullView.Y0(QFSPauseAdFullView.this, view);
            }
        });
        this.snapshotLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPauseAdFullView.a1(QFSPauseAdFullView.this, view);
            }
        });
        View findViewById = findViewById(R.id.sb6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_card_ad_source_btn)");
        Q0(findViewById, 4.0f);
        Q0(this.snapshotLayout, 20.0f);
        Q0(this.snapshotImg, 12.0f);
        Q0(this.snapshotMask, 12.0f);
        return L0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.m
            @Override // java.lang.Runnable
            public final void run() {
                QFSPauseAdFullView.X0(QFSPauseAdFullView.this);
            }
        });
    }

    public final void setSnapshot(@Nullable Bitmap bitmap) {
        this.snapshotImg.setImageBitmap(bitmap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdFullView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdFullView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QFSPauseAdFullView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdFullView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.f42561k4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_fu\u2026en_pause_ad_snapshot_img)");
        this.snapshotImg = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f42581k6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_fu\u2026n_pause_ad_snapshot_mask)");
        this.snapshotMask = findViewById2;
        View findViewById3 = findViewById(R.id.f42541k2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_fu\u2026n_pause_ad_replay_layout)");
        this.replayLayout = findViewById3;
        View findViewById4 = findViewById(R.id.f42571k5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_fu\u2026pause_ad_snapshot_layout)");
        this.snapshotLayout = findViewById4;
        View findViewById5 = findViewById(R.id.f42591k7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_fu\u2026ause_video_progress_text)");
        this.progressText = (TextView) findViewById5;
        this.animatorTime = 500L;
    }
}
