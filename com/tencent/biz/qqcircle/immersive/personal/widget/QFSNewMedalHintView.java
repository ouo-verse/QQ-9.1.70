package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StExternalMedalWallInfo;
import feedcloud.FeedCloudMeta$StMedalInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0011\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100B\u001b\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b/\u00103B#\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u00104\u001a\u00020\u000e\u00a2\u0006\u0004\b/\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0004R\u0018\u0010$\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010%R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010+\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSNewMedalHintView;", "Landroid/widget/FrameLayout;", "", "i", "", "isNeedAnim", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Ljava/util/ArrayList;", "Lfeedcloud/FeedCloudMeta$StMedalInfo;", "Lkotlin/collections/ArrayList;", "g", "", "medalResUrl", "", "leftMargin", "Landroid/widget/ImageView;", "f", "hint", "medalListWidth", "backgroundColorId", "Landroid/widget/TextView;", "e", "Landroid/view/View;", "needEnlargeView", DomainData.DOMAIN_NAME, "medalCount", "o", "l", "Lfeedcloud/FeedCloudMeta$StExternalMedalWallInfo;", "medalInfo", "setData", "k", tl.h.F, "j", "Lfeedcloud/FeedCloudMeta$StExternalMedalWallInfo;", "medalWallInfo", "Z", "isRunning", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "animRunnable", "hasShowAnim", "Ljava/lang/String;", "hintType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSNewMedalHintView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StExternalMedalWallInfo medalWallInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable animRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String hintType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/widget/QFSNewMedalHintView$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), cx.a(10.0f));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/widget/QFSNewMedalHintView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            QFSNewMedalHintView.this.isRunning = false;
            QLog.d("QFSNewMedalHintView", 1, "onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QFSNewMedalHintView.this.isRunning = false;
            QLog.d("QFSNewMedalHintView", 1, "onAnimationEnd");
            VideoReport.traversePage(QFSNewMedalHintView.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            QLog.d("QFSNewMedalHintView", 1, "onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QLog.d("QFSNewMedalHintView", 1, "onAnimationStart");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSNewMedalHintView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_GET_ICON);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, this.hintType);
        VideoReport.setElementParams(this, params);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    }

    private final TextView e(String hint, int medalListWidth, int backgroundColorId) {
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388629);
        layoutParams.leftMargin = cx.a(8.0f);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(cx.a((medalListWidth - 8) + 4), 0, cx.a(8.0f), 0);
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_primary, null));
        textView.setTextSize(1, 11.0f);
        textView.setBackgroundColor(getResources().getColor(backgroundColorId, null));
        textView.setSingleLine();
        textView.setText(hint);
        return textView;
    }

    private final ImageView f(String medalResUrl, int leftMargin) {
        ImageView imageView = new ImageView(getContext());
        int a16 = cx.a(16.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16, 16);
        if (leftMargin != 0) {
            layoutParams.leftMargin = cx.a(leftMargin);
        }
        imageView.setLayoutParams(layoutParams);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(medalResUrl).setRequestWidth(a16).setRequestHeight(a16).setTargetView(imageView).setLoadingDrawableColor(0).setSupportRecycler(true));
        return imageView;
    }

    private final ArrayList<FeedCloudMeta$StMedalInfo> g() {
        List<FeedCloudMeta$StMedalInfo> list;
        boolean z16;
        PBRepeatMessageField<FeedCloudMeta$StMedalInfo> pBRepeatMessageField;
        PBRepeatMessageField<FeedCloudMeta$StMedalInfo> pBRepeatMessageField2;
        FeedCloudMeta$StExternalMedalWallInfo feedCloudMeta$StExternalMedalWallInfo = this.medalWallInfo;
        if (feedCloudMeta$StExternalMedalWallInfo == null) {
            return new ArrayList<>();
        }
        List<FeedCloudMeta$StMedalInfo> list2 = null;
        if (feedCloudMeta$StExternalMedalWallInfo != null && (pBRepeatMessageField2 = feedCloudMeta$StExternalMedalWallInfo.myNewMedalInfos) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        FeedCloudMeta$StExternalMedalWallInfo feedCloudMeta$StExternalMedalWallInfo2 = this.medalWallInfo;
        if (feedCloudMeta$StExternalMedalWallInfo2 != null && (pBRepeatMessageField = feedCloudMeta$StExternalMedalWallInfo2.officialNewMedalInfos) != null) {
            list2 = pBRepeatMessageField.get();
        }
        ArrayList<FeedCloudMeta$StMedalInfo> arrayList = new ArrayList<>();
        boolean z17 = true;
        if (list != null && (!list.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (list.size() > 2) {
                arrayList.addAll(list.subList(0, 2));
            } else {
                arrayList.addAll(list);
            }
        } else {
            if (list2 == null || !(!list2.isEmpty())) {
                z17 = false;
            }
            if (z17) {
                if (list2.size() > 2) {
                    arrayList.addAll(list2.subList(0, 2));
                } else {
                    arrayList.addAll(list2);
                }
            }
        }
        return arrayList;
    }

    private final void i() {
        setOutlineProvider(new b());
        setClipChildren(true);
        setClipToPadding(true);
        setClipToOutline(true);
    }

    private final void l() {
        if (this.isRunning) {
            QLog.d("QFSNewMedalHintView", 1, "[startAnim] isRunning, return");
            return;
        }
        if (this.animRunnable == null) {
            this.animRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    QFSNewMedalHintView.m(QFSNewMedalHintView.this);
                }
            };
        }
        removeCallbacks(this.animRunnable);
        postDelayed(this.animRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QFSNewMedalHintView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(true);
        QLog.d("QFSNewMedalHintView", 1, "[startAnim] start.");
    }

    private final void n(View needEnlargeView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(needEnlargeView, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(needEnlargeView, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.1f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(needEnlargeView, BasicAnimation.KeyPath.SCALE_X, 1.1f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(needEnlargeView, BasicAnimation.KeyPath.SCALE_Y, 1.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(100L);
        ofFloat2.setDuration(100L);
        ofFloat3.setDuration(300L);
        ofFloat4.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3).before(ofFloat4);
        animatorSet.setStartDelay(10L);
        animatorSet.start();
    }

    private final void o(int medalCount) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, cx.a((((medalCount + 1) * 16) / 2) + 66.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSNewMedalHintView.p(QFSNewMedalHintView.this, valueAnimator);
            }
        });
        ofInt.setDuration(400L);
        ofInt.addListener(new c());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QFSNewMedalHintView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.width = ((Integer) animatedValue).intValue();
        this$0.setLayoutParams(layoutParams);
    }

    private final void q(boolean isNeedAnim) {
        boolean z16;
        TextView textView;
        PBRepeatMessageField<FeedCloudMeta$StMedalInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StMedalInfo> list;
        PBRepeatMessageField<FeedCloudMeta$StMedalInfo> pBRepeatMessageField2;
        List<FeedCloudMeta$StMedalInfo> list2;
        removeAllViews();
        setVisibility(8);
        ArrayList<FeedCloudMeta$StMedalInfo> g16 = g();
        if (g16.isEmpty()) {
            QLog.d("QFSNewMedalHintView", 1, "[updateView] medalInfoList is empty");
            return;
        }
        QLog.d("QFSNewMedalHintView", 1, "[updateView] start update");
        this.isRunning = true;
        boolean z17 = false;
        setVisibility(0);
        Iterator<FeedCloudMeta$StMedalInfo> it = g16.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            String str = it.next().iconUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "medalInfo.iconUrl.get()");
            ImageView f16 = f(str, i3);
            addView(f16);
            i3 += 8;
            i16++;
            if (isNeedAnim) {
                n(f16);
            }
        }
        FeedCloudMeta$StExternalMedalWallInfo feedCloudMeta$StExternalMedalWallInfo = this.medalWallInfo;
        if (feedCloudMeta$StExternalMedalWallInfo != null && (pBRepeatMessageField2 = feedCloudMeta$StExternalMedalWallInfo.myNewMedalInfos) != null && (list2 = pBRepeatMessageField2.get()) != null) {
            z16 = !list2.isEmpty();
        } else {
            z16 = false;
        }
        FeedCloudMeta$StExternalMedalWallInfo feedCloudMeta$StExternalMedalWallInfo2 = this.medalWallInfo;
        if (feedCloudMeta$StExternalMedalWallInfo2 != null && (pBRepeatMessageField = feedCloudMeta$StExternalMedalWallInfo2.officialNewMedalInfos) != null && (list = pBRepeatMessageField.get()) != null) {
            z17 = !list.isEmpty();
        }
        int i17 = (i3 - 8) + 16;
        if (z16) {
            this.hintType = "get_medal";
            String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19077430);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_get_new_medal)");
            textView = e(a16, i17, R.color.f157865ck3);
        } else if (z17) {
            this.hintType = "official_medal";
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1917045i);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_medal_up_to_date)");
            textView = e(a17, i17, R.color.qui_common_fill_standard_primary);
        } else {
            textView = null;
        }
        if (textView != null) {
            addView(textView);
        }
        if (isNeedAnim) {
            o(i16);
            this.hasShowAnim = true;
        }
        d();
    }

    public final void h() {
        removeAllViews();
        setVisibility(8);
        Runnable runnable = this.animRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public final boolean j() {
        List<FeedCloudMeta$StMedalInfo> list;
        PBRepeatMessageField<FeedCloudMeta$StMedalInfo> pBRepeatMessageField;
        FeedCloudMeta$StExternalMedalWallInfo feedCloudMeta$StExternalMedalWallInfo = this.medalWallInfo;
        if (feedCloudMeta$StExternalMedalWallInfo != null && (pBRepeatMessageField = feedCloudMeta$StExternalMedalWallInfo.medalInfos) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list == null || list.size() < 3) {
            return false;
        }
        return true;
    }

    public final void k() {
        if (this.hasShowAnim) {
            q(false);
        } else {
            l();
        }
    }

    public final void setData(@NotNull FeedCloudMeta$StExternalMedalWallInfo medalInfo) {
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        this.medalWallInfo = medalInfo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSNewMedalHintView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSNewMedalHintView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hintType = "";
        i();
    }
}
