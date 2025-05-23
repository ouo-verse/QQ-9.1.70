package com.tencent.now.pkgame.pkgame.scorebar.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oo3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u0001FB\u0013\b\u0016\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u00a2\u0006\u0004\b?\u0010@B\u001d\b\u0016\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\b?\u0010CB%\b\u0016\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010D\u001a\u00020\u000e\u00a2\u0006\u0004\b?\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006G"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/scorebar/view/ScoreBar;", "Landroid/widget/FrameLayout;", "", "o", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "", "leftWidth", "r", "", LocalPhotoFaceInfo.SCORE, DomainData.DOMAIN_NAME, "", "width", "leftScore", "rightScore", "l", "leftValue", "rightValue", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "j", "i", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/now/pkgame/pkgame/scorebar/view/RoundCornerImageView;", "d", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/RoundCornerImageView;", "leftView", "e", "rightView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvLeftScore", h.F, "tvRightScore", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "cursorView", "highLightView", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Loo3/d;", "D", "Loo3/d;", "scoreGrowthAnimation", "E", "J", UserInfo.SEX_FEMALE, "G", "lastUpdateTimeMs", "H", "scoreWidthPerLen", "Loo3/c;", "I", "Loo3/c;", "animCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ScoreBar extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private oo3.d scoreGrowthAnimation;

    /* renamed from: E, reason: from kotlin metadata */
    private long leftScore;

    /* renamed from: F, reason: from kotlin metadata */
    private long rightScore;

    /* renamed from: G, reason: from kotlin metadata */
    private long lastUpdateTimeMs;

    /* renamed from: H, reason: from kotlin metadata */
    private float scoreWidthPerLen;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final oo3.c animCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView leftView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView rightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvLeftScore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvRightScore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView cursorView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView highLightView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/pkgame/pkgame/scorebar/view/ScoreBar$b", "Loo3/c;", "", "updateWidth", "", "a", "", "leftScore", "rightScore", "b", "onAnimationEnd", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements oo3.c {
        b() {
        }

        @Override // oo3.c
        public void a(float updateWidth) {
            ScoreBar.this.mAegisLog.i("ScoreBar", 1, "updateWidth>>>> " + updateWidth);
            ScoreBar.this.r(updateWidth);
        }

        @Override // oo3.c
        public void b(long leftScore, long rightScore) {
            ScoreBar.this.mAegisLog.i("ScoreBar", 1, "onUpdateProgress >>>> " + leftScore + ", " + rightScore);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - ScoreBar.this.lastUpdateTimeMs > 100) {
                ScoreBar.this.lastUpdateTimeMs = elapsedRealtime;
                TextView textView = ScoreBar.this.tvLeftScore;
                TextView textView2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvLeftScore");
                    textView = null;
                }
                textView.setText(String.valueOf(leftScore));
                TextView textView3 = ScoreBar.this.tvRightScore;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvRightScore");
                } else {
                    textView2 = textView3;
                }
                textView2.setText(String.valueOf(rightScore));
            }
        }

        @Override // oo3.c
        public void onAnimationEnd() {
            TextView textView = ScoreBar.this.tvLeftScore;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLeftScore");
                textView = null;
            }
            textView.setText(String.valueOf(ScoreBar.this.leftScore));
            TextView textView3 = ScoreBar.this.tvRightScore;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvRightScore");
            } else {
                textView2 = textView3;
            }
            textView2.setText(String.valueOf(ScoreBar.this.rightScore));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreBar(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.animCallback = new b();
        o();
    }

    private final boolean k() {
        ImageView imageView = this.cursorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cursorView");
            imageView = null;
        }
        if (imageView.getVisibility() != 0) {
            this.mAegisLog.e("ScoreBar", 1, "Cursor invisible, do not update.");
            return false;
        }
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            return true;
        }
        this.mAegisLog.e("ScoreBar", 1, "Invalid w/h, width: " + getMeasuredWidth() + ", height: " + getMeasuredHeight());
        return false;
    }

    private final void l(int width, long leftScore, long rightScore) {
        float n3 = n(leftScore);
        float n16 = n(rightScore);
        e a16 = com.tencent.now.pkgame.pkgame.scorebar.view.b.a(width, leftScore, rightScore, n3, n16);
        this.mAegisLog.i("ScoreBar", 1, "\u66f4\u65b0\u79ef\u5206\u6761\uff1a" + a16 + ", leftReserve: " + n3 + ", rightReserve: " + n16);
        oo3.d dVar = this.scoreGrowthAnimation;
        Intrinsics.checkNotNull(dVar);
        RoundCornerImageView roundCornerImageView = this.leftView;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftView");
            roundCornerImageView = null;
        }
        dVar.b(roundCornerImageView.getWidth(), a16.f423271c);
        oo3.d dVar2 = this.scoreGrowthAnimation;
        Intrinsics.checkNotNull(dVar2);
        dVar2.c(leftScore, rightScore);
        oo3.d dVar3 = this.scoreGrowthAnimation;
        Intrinsics.checkNotNull(dVar3);
        dVar3.d();
    }

    private final URLDrawable.URLDrawableOptions m() {
        Drawable drawable = getResources().getDrawable(R.drawable.trans);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    private final float n(long score) {
        return (this.scoreWidthPerLen * String.valueOf(score).length()) + x.c(getContext(), 34.0f);
    }

    private final void o() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hax, this);
        View findViewById = inflate.findViewById(R.id.f80224aw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.score_bar_left)");
        this.leftView = (RoundCornerImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f80234ax);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.score_bar_right)");
        this.rightView = (RoundCornerImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f80244ay);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.score_bar_sursor)");
        this.cursorView = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f80294b3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.score_value_left)");
        this.tvLeftScore = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f80304b4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.score_value_right)");
        this.tvRightScore = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f80214av);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.score_bar_high_light)");
        this.highLightView = (ImageView) findViewById6;
        this.scoreWidthPerLen = com.tencent.now.pkgame.pkgame.scorebar.view.b.b(getContext(), 13);
        this.scoreGrowthAnimation = new oo3.d(this.animCallback);
        ImageView imageView = this.cursorView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cursorView");
            imageView = null;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/Q3auHgzwzM5522kdqrNehXgZzqR6vgeRpzficZTZlKSsiaylS0QJ7b0g/", m()));
        ImageView imageView2 = this.highLightView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highLightView");
            imageView2 = null;
        }
        imageView2.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKnrmMlxWibhSuZSktKtHcP5iaMYibsb3DabmMVAPVb93Kdw/", m()));
        TextView textView2 = this.tvLeftScore;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLeftScore");
            textView2 = null;
        }
        RFWTypefaceUtil.setNumberTypeface(textView2, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
        TextView textView3 = this.tvRightScore;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightScore");
        } else {
            textView = textView3;
        }
        RFWTypefaceUtil.setNumberTypeface(textView, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(float leftWidth) {
        RoundCornerImageView roundCornerImageView = this.leftView;
        RoundCornerImageView roundCornerImageView2 = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftView");
            roundCornerImageView = null;
        }
        ViewGroup.LayoutParams layoutParams = roundCornerImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) leftWidth;
        RoundCornerImageView roundCornerImageView3 = this.leftView;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftView");
        } else {
            roundCornerImageView2 = roundCornerImageView3;
        }
        roundCornerImageView2.setLayoutParams(layoutParams2);
    }

    public final void i() {
        ImageView imageView = this.cursorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cursorView");
            imageView = null;
        }
        imageView.setVisibility(0);
        q(this.leftScore, this.rightScore);
    }

    public final void j() {
        TextView textView = this.tvLeftScore;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLeftScore");
            textView = null;
        }
        textView.setText("0");
        TextView textView3 = this.tvRightScore;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightScore");
        } else {
            textView2 = textView3;
        }
        textView2.setText("0");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oo3.d dVar = this.scoreGrowthAnimation;
        Intrinsics.checkNotNull(dVar);
        dVar.a();
    }

    public final void p() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        ImageView imageView = this.cursorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cursorView");
            imageView = null;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIm3icKU7vHwYCjV3Dk3jaqH4k6HvKjQgSozG207enmz3g/", obtain));
    }

    public final void q(long leftValue, long rightValue) {
        this.leftScore = leftValue;
        this.rightScore = rightValue;
        if (k()) {
            l(getMeasuredWidth(), leftValue, this.rightScore);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.animCallback = new b();
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.animCallback = new b();
        o();
    }
}
