package com.tencent.state.square.guide.step.biz;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.square.guide.step.base.BaseStep;
import com.tencent.state.square.guide.step.base.ErrorInfo;
import com.tencent.state.square.guide.step.base.IStepListener;
import com.tencent.state.square.guide.step.biz.PublishStatusStep;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.utils.SimplePagDownloadListener;
import com.tencent.state.utils.SquarePagFileUtils;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002)*B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/PublishStatusStep;", "Lcom/tencent/state/square/guide/step/biz/BaseGuideStep;", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "listener", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "(Lcom/tencent/state/square/guide/GuideContext;Lcom/tencent/state/square/guide/step/base/IStepListener;)V", "guideInfo", "Lcom/tencent/state/square/guide/step/biz/PublishStatusStep$PublishStatusGuideInfo;", "reporter", "Lcom/tencent/state/square/IReporter;", "downloadPagFile", "", "getMeHolder", "getReportParams", "", "", "", "needScaleMap", "", "onAnimEnd", "bundle", "Landroid/os/Bundle;", "onAnimationCancel", "squarePagView", "Lcom/tencent/state/square/api/ISquarePagView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onInterceptMsg", "msg", "Landroid/os/Message;", "onStepEnd", "onStepStart", "playAnim", "withMapScale", "playMapScaleAnim", "playPag", "preparePagView", "shouldInterruptNextStep", "Companion", "PublishStatusGuideInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublishStatusStep extends BaseGuideStep implements ISquarePagViewListener {
    private static final int ANIM_END = 6;
    private static final int DOWNLOAD_PAG_FILE = 2;
    private static final int GET_ME_HOLDER = 3;
    private static final int ON_ERROR = 1;
    private static final int PLAY_ANIM = 5;
    private static final int PREPARE_PAG_VIEW = 4;
    private static final String TAG = "PublishStatusStep";
    private PublishStatusGuideInfo guideInfo;
    private final IReporter reporter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00063"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/PublishStatusStep$PublishStatusGuideInfo;", "", "(Lcom/tencent/state/square/guide/step/biz/PublishStatusStep;)V", "bubbleContainer", "Landroid/widget/FrameLayout;", "getBubbleContainer", "()Landroid/widget/FrameLayout;", "setBubbleContainer", "(Landroid/widget/FrameLayout;)V", "errorInfo", "Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "getErrorInfo", "()Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "setErrorInfo", "(Lcom/tencent/state/square/guide/step/base/ErrorInfo;)V", "meIndex", "", "getMeIndex", "()I", "setMeIndex", "(I)V", "meViewHolder", "Lcom/tencent/state/square/holder/AvatarViewHolder;", "getMeViewHolder", "()Lcom/tencent/state/square/holder/AvatarViewHolder;", "setMeViewHolder", "(Lcom/tencent/state/square/holder/AvatarViewHolder;)V", "pagContainer", "getPagContainer", "setPagContainer", Constants.PAG_FILE_PATH, "", "getPagFilePath", "()Ljava/lang/String;", "setPagFilePath", "(Ljava/lang/String;)V", "pagUrl", "getPagUrl", "setPagUrl", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "getPagView", "()Lcom/tencent/state/square/api/ISquarePagView;", "setPagView", "(Lcom/tencent/state/square/api/ISquarePagView;)V", "squareView", "Lcom/tencent/state/square/SquareView;", "getSquareView", "()Lcom/tencent/state/square/SquareView;", "setSquareView", "(Lcom/tencent/state/square/SquareView;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class PublishStatusGuideInfo {
        private FrameLayout bubbleContainer;
        private ErrorInfo errorInfo;
        private AvatarViewHolder meViewHolder;
        private FrameLayout pagContainer;
        private ISquarePagView pagView;
        private SquareView squareView;
        private String pagUrl = "";
        private String pagFilePath = "";
        private int meIndex = -1;

        public PublishStatusGuideInfo() {
        }

        public final FrameLayout getBubbleContainer() {
            return this.bubbleContainer;
        }

        public final ErrorInfo getErrorInfo() {
            return this.errorInfo;
        }

        public final int getMeIndex() {
            return this.meIndex;
        }

        public final AvatarViewHolder getMeViewHolder() {
            return this.meViewHolder;
        }

        public final FrameLayout getPagContainer() {
            return this.pagContainer;
        }

        public final String getPagFilePath() {
            return this.pagFilePath;
        }

        public final String getPagUrl() {
            return this.pagUrl;
        }

        public final ISquarePagView getPagView() {
            return this.pagView;
        }

        public final SquareView getSquareView() {
            return this.squareView;
        }

        public final void setBubbleContainer(FrameLayout frameLayout) {
            this.bubbleContainer = frameLayout;
        }

        public final void setErrorInfo(ErrorInfo errorInfo) {
            this.errorInfo = errorInfo;
        }

        public final void setMeIndex(int i3) {
            this.meIndex = i3;
        }

        public final void setMeViewHolder(AvatarViewHolder avatarViewHolder) {
            this.meViewHolder = avatarViewHolder;
        }

        public final void setPagContainer(FrameLayout frameLayout) {
            this.pagContainer = frameLayout;
        }

        public final void setPagFilePath(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pagFilePath = str;
        }

        public final void setPagUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pagUrl = str;
        }

        public final void setPagView(ISquarePagView iSquarePagView) {
            this.pagView = iSquarePagView;
        }

        public final void setSquareView(SquareView squareView) {
            this.squareView = squareView;
        }
    }

    public /* synthetic */ PublishStatusStep(GuideContext guideContext, IStepListener iStepListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? null : iStepListener);
    }

    private final void downloadPagFile() {
        SquarePagFileUtils.INSTANCE.downloadPagFile(this.guideInfo.getPagUrl(), new SimplePagDownloadListener() { // from class: com.tencent.state.square.guide.step.biz.PublishStatusStep$downloadPagFile$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo;
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                publishStatusGuideInfo = PublishStatusStep.this.guideInfo;
                publishStatusGuideInfo.setErrorInfo(new ErrorInfo(errorCode, errorMessage));
                BaseStep.sendMsg$default(PublishStatusStep.this, 1, null, 0L, 6, null);
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo;
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                publishStatusGuideInfo = PublishStatusStep.this.guideInfo;
                String absolutePath = resultFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                publishStatusGuideInfo.setPagFilePath(absolutePath);
                BaseStep.sendMsg$default(PublishStatusStep.this, 3, null, 0L, 6, null);
            }
        });
    }

    private final void getMeHolder() {
        Integer meIndex;
        SquareView squareMapView = getGuideContext().getSquareMapView();
        int intValue = (squareMapView == null || (meIndex = squareMapView.getMeIndex()) == null) ? -1 : meIndex.intValue();
        SquareView squareMapView2 = getGuideContext().getSquareMapView();
        MapViewHolder<?> viewHolder = squareMapView2 != null ? squareMapView2.getViewHolder(intValue) : null;
        AvatarViewHolder avatarViewHolder = (AvatarViewHolder) (viewHolder instanceof AvatarViewHolder ? viewHolder : null);
        if (avatarViewHolder == null) {
            this.guideInfo.setErrorInfo(new ErrorInfo(-1, "getMeHolder failed. " + intValue));
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
            return;
        }
        this.guideInfo.setMeIndex(intValue);
        this.guideInfo.setMeViewHolder(avatarViewHolder);
        this.guideInfo.setBubbleContainer(avatarViewHolder.getBinding().avatarTopContentContainer);
        this.guideInfo.setPagContainer(avatarViewHolder.getBinding().masterNoviceGuideAnim);
        this.guideInfo.setSquareView(getGuideContext().getSquareMapView());
        BaseStep.sendMsg$default(this, 4, null, 0L, 6, null);
    }

    private final boolean needScaleMap() {
        return getGuideContext().getConfig().getPublishStatusGuideConfig().getNeedEnlargeMap() && getGuideContext().isFirstShowPublishStatusGuide();
    }

    private final void onAnimEnd(Bundle bundle) {
        FrameLayout pagContainer;
        IReporter iReporter;
        PublishStatusGuideInfo publishStatusGuideInfo = this.guideInfo;
        if (publishStatusGuideInfo != null && (pagContainer = publishStatusGuideInfo.getPagContainer()) != null && (iReporter = this.reporter) != null) {
            iReporter.reportEvent("imp_end", pagContainer, getReportParams());
        }
        complete(bundle);
    }

    private final void playAnim(boolean withMapScale) {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareViewModel squareActivityViewModel2;
        GuideContext guideContext = getGuideContext();
        if (guideContext != null && (squareActivityViewModel = guideContext.getSquareActivityViewModel()) != null && (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            value.recordPublishStatusAnimStart();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        if (withMapScale) {
            playMapScaleAnim();
        }
        playPag(withMapScale);
    }

    private final void playMapScaleAnim() {
        SquareView squareView = this.guideInfo.getSquareView();
        if (squareView != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(squareView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.6f).setDuration(800L);
            Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(s\u2026, 1.6f).setDuration(800L)");
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(squareView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.6f).setDuration(800L);
            Intrinsics.checkNotNullExpressionValue(duration2, "ObjectAnimator.ofFloat(s\u2026, 1.6f).setDuration(800L)");
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(squareView, BasicAnimation.KeyPath.SCALE_X, 1.6f, 1.0f).setDuration(600L);
            duration3.setStartDelay(1900L);
            Intrinsics.checkNotNullExpressionValue(duration3, "ObjectAnimator.ofFloat(s\u2026= 1900L\n                }");
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(squareView, BasicAnimation.KeyPath.SCALE_Y, 1.6f, 1.0f).setDuration(600L);
            duration4.setStartDelay(1900L);
            Intrinsics.checkNotNullExpressionValue(duration4, "ObjectAnimator.ofFloat(s\u2026= 1900L\n                }");
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(duration).with(duration2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(duration3).with(duration4);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playSequentially(animatorSet, animatorSet2);
            animatorSet3.start();
        }
    }

    private final void playPag(boolean withMapScale) {
        SquareBaseKt.getSquareThread().postOnUiDelayed(withMapScale ? 700L : 0L, new Function0<Unit>() { // from class: com.tencent.state.square.guide.step.biz.PublishStatusStep$playPag$1
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
                PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo;
                PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo2;
                PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo3;
                FrameLayout pagContainer;
                IReporter iReporter;
                Map<String, Object> reportParams;
                FrameLayout bubbleContainer;
                ViewPropertyAnimator animate;
                ViewPropertyAnimator alpha;
                ViewPropertyAnimator duration;
                publishStatusGuideInfo = PublishStatusStep.this.guideInfo;
                if (publishStatusGuideInfo != null && (bubbleContainer = publishStatusGuideInfo.getBubbleContainer()) != null && (animate = bubbleContainer.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(300L)) != null) {
                    duration.setStartDelay(300L);
                }
                publishStatusGuideInfo2 = PublishStatusStep.this.guideInfo;
                if (publishStatusGuideInfo2 != null && (pagContainer = publishStatusGuideInfo2.getPagContainer()) != null) {
                    pagContainer.setVisibility(0);
                    iReporter = PublishStatusStep.this.reporter;
                    if (iReporter != null) {
                        reportParams = PublishStatusStep.this.getReportParams();
                        iReporter.reportEvent("imp", pagContainer, reportParams);
                    }
                }
                publishStatusGuideInfo3 = PublishStatusStep.this.guideInfo;
                ISquarePagView pagView = publishStatusGuideInfo3.getPagView();
                if (pagView != null) {
                    pagView.playPag(1);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.state.square.api.ISquarePagView, T] */
    private final void preparePagView() {
        FrameLayout pagContainer = this.guideInfo.getPagContainer();
        if (pagContainer != null) {
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                iReporter.setElementInfo(pagContainer, SquareReportConst.ElementId.ELEMENT_ID_ZPLAN_SQUARE_DYNAMIC, new LinkedHashMap(), false, false);
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? pagView = Square.INSTANCE.getConfig().getCommonUtils().getPagView(getGuideContext().getActivity());
            objectRef.element = pagView;
            ISquarePagView iSquarePagView = (ISquarePagView) pagView;
            View view = iSquarePagView != null ? iSquarePagView.getView() : null;
            T t16 = objectRef.element;
            if (((ISquarePagView) t16) != null && view != null) {
                ((ISquarePagView) t16).setPagFile(this.guideInfo.getPagFilePath());
                pagContainer.removeAllViews();
                pagContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
                FrameLayout bubbleContainer = this.guideInfo.getBubbleContainer();
                ViewGroup.LayoutParams layoutParams = bubbleContainer != null ? bubbleContainer.getLayoutParams() : null;
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (layoutParams instanceof ViewGroup.MarginLayoutParams ? layoutParams : null);
                if (marginLayoutParams != null) {
                    ViewExtensionsKt.updateLayoutParams(pagContainer, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.state.square.guide.step.biz.PublishStatusStep$preparePagView$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams2) {
                            invoke2(marginLayoutParams2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ViewGroup.MarginLayoutParams receiver) {
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            receiver.bottomMargin = marginLayoutParams.bottomMargin;
                        }
                    });
                }
                ((ISquarePagView) objectRef.element).setPagViewListener(this);
                ((ISquarePagView) objectRef.element).preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.guide.step.biz.PublishStatusStep$preparePagView$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo;
                        PublishStatusStep.PublishStatusGuideInfo publishStatusGuideInfo2;
                        if (!z16) {
                            publishStatusGuideInfo2 = PublishStatusStep.this.guideInfo;
                            publishStatusGuideInfo2.setErrorInfo(new ErrorInfo(-1, "pagView prepareRuntime failed"));
                            BaseStep.sendMsg$default(PublishStatusStep.this, 1, null, 0L, 6, null);
                        } else {
                            publishStatusGuideInfo = PublishStatusStep.this.guideInfo;
                            publishStatusGuideInfo.setPagView((ISquarePagView) objectRef.element);
                            BaseStep.sendMsg$default(PublishStatusStep.this, 5, null, 0L, 6, null);
                        }
                    }
                });
                return;
            }
            this.guideInfo.setErrorInfo(new ErrorInfo(-1, "create pagView failed"));
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationUpdate(ISquarePagView iSquarePagView) {
        ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public boolean onInterceptMsg(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 1:
                ErrorInfo errorInfo = this.guideInfo.getErrorInfo();
                if (errorInfo == null) {
                    errorInfo = new ErrorInfo(-1, "unknown");
                }
                error(errorInfo);
                return true;
            case 2:
                downloadPagFile();
                return true;
            case 3:
                getMeHolder();
                return true;
            case 4:
                preparePagView();
                return true;
            case 5:
                playAnim(needScaleMap());
                return true;
            case 6:
                Bundle data = msg2.getData();
                Intrinsics.checkNotNullExpressionValue(data, "msg.data");
                onAnimEnd(data);
                return true;
            default:
                return super.onInterceptMsg(msg2);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public void onStepEnd(Bundle bundle) {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareViewModel squareActivityViewModel2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        GuideContext guideContext = getGuideContext();
        if (guideContext != null && (squareActivityViewModel = guideContext.getSquareActivityViewModel()) != null && (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            value.recordPublishStatusAnimEnd();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        FrameLayout bubbleContainer = this.guideInfo.getBubbleContainer();
        if (bubbleContainer != null) {
            bubbleContainer.setAlpha(1.0f);
        }
        FrameLayout pagContainer = this.guideInfo.getPagContainer();
        if (pagContainer != null) {
            pagContainer.removeAllViews();
            pagContainer.setVisibility(8);
        }
        SquareView squareView = this.guideInfo.getSquareView();
        if (squareView != null) {
            squareView.setScaleX(1.0f);
            squareView.setScaleY(1.0f);
        }
        this.guideInfo = new PublishStatusGuideInfo();
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public void onStepStart(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!getGuideContext().canShowPublishGuide()) {
            ignore(bundle);
        } else {
            this.guideInfo.setPagUrl(getGuideContext().getConfig().getPublishStatusGuideConfig().getStatusPagUrl());
            BaseStep.sendMsg$default(this, 2, null, 0L, 6, null);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    protected boolean shouldInterruptNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return hasCancelFlag();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStatusStep(GuideContext guideContext, IStepListener iStepListener) {
        super(guideContext, StepType.PUBLISH_STATUS, iStepListener);
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        this.guideInfo = new PublishStatusGuideInfo();
        this.reporter = Square.INSTANCE.getConfig().getReporter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_DYNAMIC_TYPE, 2));
        return mutableMapOf;
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationEnd(ISquarePagView squarePagView) {
        BaseStep.sendMsg$default(this, 6, null, 200L, 2, null);
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationCancel(ISquarePagView squarePagView) {
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationRepeat(ISquarePagView squarePagView) {
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationStart(ISquarePagView squarePagView) {
    }
}
