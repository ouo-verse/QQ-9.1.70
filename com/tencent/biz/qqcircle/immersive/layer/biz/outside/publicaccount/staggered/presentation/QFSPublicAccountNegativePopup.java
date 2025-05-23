package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.base.QFSPublicAccountBaseDialogFragment;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u0013\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016Jk\u0010\"\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u00182\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032+\u0010!\u001a'\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0002` R\u0019\u0010(\u001a\u0004\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010$R\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010$R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010$R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010$\u00a8\u0006R"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountNegativePopup;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/base/QFSPublicAccountBaseDialogFragment;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/NegativeItem;", "", "yh", "", "initData", "Landroid/view/View;", "view", "initView", OcrConfig.CHINESE, "Landroid/content/Context;", "context", "Dh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "feedId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "negativeItems", HippyTKDListViewAdapter.X, "y", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/base/OnResult;", "onResult", "Ch", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "I", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "J", "Landroid/view/View;", "bgLayout", "K", "anchorView", "L", "anchorArrow", "M", "anchorOuterCircle", "N", "anchorInnerCircle", "Landroidx/cardview/widget/CardView;", "P", "Landroidx/cardview/widget/CardView;", "popupContent", "Landroidx/constraintlayout/helper/widget/Flow;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/constraintlayout/helper/widget/Flow;", "flow", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/constraintlayout/widget/ConstraintLayout;", "popupContentConstraintLayout", ExifInterface.LATITUDE_SOUTH, "anchorX", "T", "anchorY", "U", "Ljava/lang/String;", "", "V", "Ljava/util/List;", "negativeItemList", "W", "popupContentHeight", "X", "popupContentWidth", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "Y", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountNegativePopup extends QFSPublicAccountBaseDialogFragment<NegativeItem> {
    private static final int Z = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(16.0f);

    /* renamed from: a0, reason: collision with root package name */
    private static final int f86880a0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(36.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f86881b0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(33.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final int f86882c0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(-5.0f);

    /* renamed from: d0, reason: collision with root package name */
    private static final int f86883d0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(28.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f86884e0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(138.0f);

    /* renamed from: f0, reason: collision with root package name */
    private static final int f86885f0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(92.0f);

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final QCircleInitBean initBean;

    /* renamed from: J, reason: from kotlin metadata */
    private View bgLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private View anchorView;

    /* renamed from: L, reason: from kotlin metadata */
    private View anchorArrow;

    /* renamed from: M, reason: from kotlin metadata */
    private View anchorOuterCircle;

    /* renamed from: N, reason: from kotlin metadata */
    private View anchorInnerCircle;

    /* renamed from: P, reason: from kotlin metadata */
    private CardView popupContent;

    /* renamed from: Q, reason: from kotlin metadata */
    private Flow flow;

    /* renamed from: R, reason: from kotlin metadata */
    private ConstraintLayout popupContentConstraintLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private int anchorX;

    /* renamed from: T, reason: from kotlin metadata */
    private int anchorY;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String feedId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final List<NegativeItem> negativeItemList;

    /* renamed from: W, reason: from kotlin metadata */
    private int popupContentHeight;

    /* renamed from: X, reason: from kotlin metadata */
    private int popupContentWidth;

    public QFSPublicAccountNegativePopup() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(QFSPublicAccountNegativePopup this$0, NegativeItem negativeItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(negativeItem, "$negativeItem");
        QFSPublicAccountBaseDialogFragment.rh(this$0, negativeItem, 0, 2, null);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a.q(this$0.feedId, negativeItem, this$0.initBean);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(QFSPublicAccountNegativePopup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Dh(Context context) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSPublicAccountNegativePopup.Eh(QFSPublicAccountNegativePopup.this, valueAnimator);
            }
        });
        ofFloat.setDuration(280L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSPublicAccountNegativePopup.Fh(QFSPublicAccountNegativePopup.this, valueAnimator);
            }
        });
        ofFloat2.setDuration(200L);
        ofFloat2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(QFSPublicAccountNegativePopup this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.anchorOuterCircle;
        CardView cardView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorOuterCircle");
            view = null;
        }
        view.setScaleX(floatValue);
        View view2 = this$0.anchorOuterCircle;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorOuterCircle");
            view2 = null;
        }
        view2.setScaleY(floatValue);
        View view3 = this$0.anchorInnerCircle;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorInnerCircle");
            view3 = null;
        }
        view3.setScaleX(floatValue);
        View view4 = this$0.anchorInnerCircle;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorInnerCircle");
            view4 = null;
        }
        view4.setScaleY(floatValue);
        CardView cardView2 = this$0.popupContent;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView2 = null;
        }
        cardView2.setScaleX(floatValue);
        CardView cardView3 = this$0.popupContent;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
        } else {
            cardView = cardView3;
        }
        cardView.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(QFSPublicAccountNegativePopup this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.anchorOuterCircle;
        CardView cardView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorOuterCircle");
            view = null;
        }
        view.setAlpha(floatValue);
        View view2 = this$0.anchorOuterCircle;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorOuterCircle");
            view2 = null;
        }
        view2.setAlpha(floatValue);
        View view3 = this$0.anchorInnerCircle;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorInnerCircle");
            view3 = null;
        }
        view3.setAlpha(floatValue);
        View view4 = this$0.anchorInnerCircle;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorInnerCircle");
            view4 = null;
        }
        view4.setAlpha(floatValue);
        CardView cardView2 = this$0.popupContent;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView2 = null;
        }
        cardView2.setAlpha(floatValue);
        CardView cardView3 = this$0.popupContent;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
        } else {
            cardView = cardView3;
        }
        cardView.setAlpha(floatValue);
    }

    private final void initData() {
        int i3;
        String str;
        Bundle arguments = getArguments();
        int i16 = 0;
        if (arguments != null) {
            i3 = arguments.getInt("anchor_x");
        } else {
            i3 = 0;
        }
        this.anchorX = i3;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i16 = arguments2.getInt("anchor_y");
        }
        this.anchorY = i16;
        Bundle arguments3 = getArguments();
        ArrayList arrayList = null;
        if (arguments3 != null) {
            str = arguments3.getString("feed_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.feedId = str;
        this.negativeItemList.clear();
        List<NegativeItem> list = this.negativeItemList;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            arrayList = arguments4.getParcelableArrayList("negative_list");
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        list.addAll(arrayList);
        int size = this.negativeItemList.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    this.popupContentHeight = f86884e0;
                    this.popupContentWidth = yh();
                    return;
                } else {
                    this.popupContentHeight = f86884e0;
                    this.popupContentWidth = yh();
                    this.negativeItemList.add(h.a());
                    return;
                }
            }
            this.popupContentHeight = f86885f0;
            this.popupContentWidth = yh();
            return;
        }
        this.popupContentHeight = f86885f0;
        this.popupContentWidth = yh() / 2;
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f164600a83);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bg_layout)");
        this.bgLayout = findViewById;
        View findViewById2 = view.findViewById(R.id.spf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.anchor_view)");
        this.anchorView = findViewById2;
        View findViewById3 = view.findViewById(R.id.sno);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.anchor_arrow)");
        this.anchorArrow = findViewById3;
        View findViewById4 = view.findViewById(R.id.sov);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.anchor_outer_circle)");
        this.anchorOuterCircle = findViewById4;
        View findViewById5 = view.findViewById(R.id.so_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.anchor_inner_circle)");
        this.anchorInnerCircle = findViewById5;
        View findViewById6 = view.findViewById(R.id.xu6);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.item_flow)");
        this.flow = (Flow) findViewById6;
        View findViewById7 = view.findViewById(R.id.f26450dk);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.p\u2026ontent_constraint_layout)");
        this.popupContentConstraintLayout = (ConstraintLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.f26440dj);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.popup_content)");
        CardView cardView = (CardView) findViewById8;
        this.popupContent = cardView;
        CardView cardView2 = null;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView = null;
        }
        cardView.setCardBackgroundColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
        CardView cardView3 = this.popupContent;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView3 = null;
        }
        CardView cardView4 = this.popupContent;
        if (cardView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView4 = null;
        }
        ViewGroup.LayoutParams layoutParams = cardView4.getLayoutParams();
        layoutParams.height = this.popupContentHeight;
        layoutParams.width = this.popupContentWidth;
        cardView3.setLayoutParams(layoutParams);
        View view2 = this.bgLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgLayout");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSPublicAccountNegativePopup.Bh(QFSPublicAccountNegativePopup.this, view3);
            }
        });
        zh();
        View view3 = this.anchorView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
            view3 = null;
        }
        view3.setTranslationX(this.anchorX - (Z / 2.0f));
        View view4 = this.anchorView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
            view4 = null;
        }
        float f16 = this.anchorY;
        int i3 = f86880a0;
        view4.setTranslationY(f16 - (i3 / 2.0f));
        if (this.anchorY < DisplayUtil.getScreenHeight() / 2) {
            View view5 = this.anchorArrow;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anchorArrow");
                view5 = null;
            }
            view5.setTranslationY(f86881b0);
            CardView cardView5 = this.popupContent;
            if (cardView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                cardView5 = null;
            }
            cardView5.setTranslationY((this.anchorY - (i3 / 2.0f)) + i3);
            CardView cardView6 = this.popupContent;
            if (cardView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                cardView6 = null;
            }
            cardView6.setPivotY(0.0f);
        } else {
            View view6 = this.anchorArrow;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("anchorArrow");
                view6 = null;
            }
            view6.setTranslationY(f86882c0);
            CardView cardView7 = this.popupContent;
            if (cardView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                cardView7 = null;
            }
            cardView7.setTranslationY((this.anchorY - (i3 / 2.0f)) - this.popupContentHeight);
            CardView cardView8 = this.popupContent;
            if (cardView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                cardView8 = null;
            }
            cardView8.setPivotY(this.popupContentHeight);
        }
        if (this.negativeItemList.size() == 1 && this.popupContentWidth < yh()) {
            if (this.anchorX < DisplayUtil.getScreenWidth() / 2) {
                CardView cardView9 = this.popupContent;
                if (cardView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                    cardView9 = null;
                }
                cardView9.setTranslationX(f86883d0);
            } else {
                CardView cardView10 = this.popupContent;
                if (cardView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                    cardView10 = null;
                }
                cardView10.setTranslationX((DisplayUtil.getScreenWidth() - f86883d0) - this.popupContentWidth);
            }
        } else {
            CardView cardView11 = this.popupContent;
            if (cardView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContent");
                cardView11 = null;
            }
            cardView11.setTranslationX(f86883d0);
        }
        CardView cardView12 = this.popupContent;
        if (cardView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
            cardView12 = null;
        }
        float f17 = this.anchorX;
        CardView cardView13 = this.popupContent;
        if (cardView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupContent");
        } else {
            cardView2 = cardView13;
        }
        cardView12.setPivotX(f17 - cardView2.getTranslationX());
    }

    private final int yh() {
        return DisplayUtil.getScreenWidth() - (f86883d0 * 2);
    }

    private final void zh() {
        for (final NegativeItem negativeItem : this.negativeItemList) {
            ConstraintLayout constraintLayout = this.popupContentConstraintLayout;
            Flow flow = null;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContentConstraintLayout");
                constraintLayout = null;
            }
            TextView textView = new TextView(constraintLayout.getContext());
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(0, com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(32.0f)));
            textView.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_divider_r4_bg));
            textView.setGravity(17);
            textView.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_text_primary));
            textView.setTextSize(13.0f);
            textView.setText(negativeItem.getTitle());
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPublicAccountNegativePopup.Ah(QFSPublicAccountNegativePopup.this, negativeItem, view);
                }
            });
            if (Intrinsics.areEqual(negativeItem, h.a())) {
                textView.setVisibility(4);
            }
            ConstraintLayout constraintLayout2 = this.popupContentConstraintLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupContentConstraintLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.addView(textView);
            Flow flow2 = this.flow;
            if (flow2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flow");
            } else {
                flow = flow2;
            }
            flow.addView(textView);
        }
    }

    public final void Ch(@NotNull FragmentManager fragmentManager, @NotNull String feedId, @NotNull ArrayList<NegativeItem> negativeItems, int x16, int y16, @NotNull Function1<? super NegativeItem, Unit> onResult) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(negativeItems, "negativeItems");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Bundle bundle = new Bundle();
        bundle.putInt("anchor_x", x16);
        bundle.putInt("anchor_y", y16);
        bundle.putString("feed_id", feedId);
        bundle.putParcelableArrayList("negative_list", negativeItems);
        setArguments(bundle);
        sh(fragmentManager, onResult);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.base.QFSPublicAccountBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.gog;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.base.QFSPublicAccountBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dh(context);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a.o(this.feedId, this.initBean);
    }

    public /* synthetic */ QFSPublicAccountNegativePopup(QCircleInitBean qCircleInitBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : qCircleInitBean);
    }

    public QFSPublicAccountNegativePopup(@Nullable QCircleInitBean qCircleInitBean) {
        this.initBean = qCircleInitBean;
        this.feedId = "";
        this.negativeItemList = new ArrayList();
        this.popupContentHeight = f86884e0;
        this.popupContentWidth = yh();
    }
}
