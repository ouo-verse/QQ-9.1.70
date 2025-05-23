package com.tencent.state.square.guide.step.biz;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.square.guide.step.base.BaseStep;
import com.tencent.state.square.guide.step.base.ErrorInfo;
import com.tencent.state.square.guide.step.base.IStepListener;
import com.tencent.state.square.guide.step.biz.RoleBornStep;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/RoleBornStep;", "Lcom/tencent/state/square/guide/step/biz/BaseGuideStep;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "listener", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "(Lcom/tencent/state/square/guide/GuideContext;Lcom/tencent/state/square/guide/step/base/IStepListener;)V", "reporter", "Lcom/tencent/state/square/IReporter;", "roleBornAnimInfo", "Lcom/tencent/state/square/guide/step/biz/RoleBornStep$RoleBornAnimInfo;", "downloadPagFile", "", "getMeHolder", "getReportParams", "", "", "", "locateToMe", "onAnimEnd", "bundle", "Landroid/os/Bundle;", "onInterceptMsg", "", "msg", "Landroid/os/Message;", "onStepEnd", "onStepStart", "playAnim", "playAvatarAnim", "playPagAnim", "preparePagView", "refreshOtherViews", "shouldInterruptNextStep", "Companion", "RoleBornAnimInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RoleBornStep extends BaseGuideStep {
    private static final int ANIM_END = 6;
    private static final int DOWNLOAD_PAG_FILE = 2;
    private static final int GET_ME_HOLDER = 3;
    private static final int LOCATE_TO_ME = 7;
    private static final int ON_ERROR = 1;
    private static final int PLAY_ANIM = 5;
    private static final int PREPARE_PAG_VIEW = 4;
    private static final String TAG = "RoleBornStep";
    private final IReporter reporter;
    private RoleBornAnimInfo roleBornAnimInfo;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00066"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/RoleBornStep$RoleBornAnimInfo;", "", "(Lcom/tencent/state/square/guide/step/biz/RoleBornStep;)V", "avatarView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "getAvatarView", "()Lcom/tencent/state/square/avatar/SquareAvatarView;", "setAvatarView", "(Lcom/tencent/state/square/avatar/SquareAvatarView;)V", "errorInfo", "Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "getErrorInfo", "()Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "setErrorInfo", "(Lcom/tencent/state/square/guide/step/base/ErrorInfo;)V", "meIndex", "", "getMeIndex", "()I", "setMeIndex", "(I)V", "meViewHolder", "Lcom/tencent/state/square/holder/AvatarViewHolder;", "getMeViewHolder", "()Lcom/tencent/state/square/holder/AvatarViewHolder;", "setMeViewHolder", "(Lcom/tencent/state/square/holder/AvatarViewHolder;)V", "pagContainer", "Landroid/widget/FrameLayout;", "getPagContainer", "()Landroid/widget/FrameLayout;", "setPagContainer", "(Landroid/widget/FrameLayout;)V", Constants.PAG_FILE_PATH, "", "getPagFilePath", "()Ljava/lang/String;", "setPagFilePath", "(Ljava/lang/String;)V", "pagUrl", "getPagUrl", "setPagUrl", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "getPagView", "()Lcom/tencent/state/square/api/ISquarePagView;", "setPagView", "(Lcom/tencent/state/square/api/ISquarePagView;)V", "squareView", "Lcom/tencent/state/square/SquareView;", "getSquareView", "()Lcom/tencent/state/square/SquareView;", "setSquareView", "(Lcom/tencent/state/square/SquareView;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class RoleBornAnimInfo {
        private SquareAvatarView avatarView;
        private ErrorInfo errorInfo;
        private AvatarViewHolder meViewHolder;
        private FrameLayout pagContainer;
        private ISquarePagView pagView;
        private SquareView squareView;
        private String pagUrl = "";
        private String pagFilePath = "";
        private int meIndex = -1;

        public RoleBornAnimInfo() {
        }

        public final SquareAvatarView getAvatarView() {
            return this.avatarView;
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

        public final void setAvatarView(SquareAvatarView squareAvatarView) {
            this.avatarView = squareAvatarView;
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

    public /* synthetic */ RoleBornStep(GuideContext guideContext, IStepListener iStepListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? null : iStepListener);
    }

    private final void downloadPagFile() {
        SquarePagFileUtils.INSTANCE.downloadPagFile(this.roleBornAnimInfo.getPagUrl(), new SimplePagDownloadListener() { // from class: com.tencent.state.square.guide.step.biz.RoleBornStep$downloadPagFile$1
            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                RoleBornStep.RoleBornAnimInfo roleBornAnimInfo;
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                roleBornAnimInfo = RoleBornStep.this.roleBornAnimInfo;
                roleBornAnimInfo.setErrorInfo(new ErrorInfo(errorCode, errorMessage));
                BaseStep.sendMsg$default(RoleBornStep.this, 1, null, 0L, 6, null);
            }

            @Override // com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                RoleBornStep.RoleBornAnimInfo roleBornAnimInfo;
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                roleBornAnimInfo = RoleBornStep.this.roleBornAnimInfo;
                String absolutePath = resultFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                roleBornAnimInfo.setPagFilePath(absolutePath);
                BaseStep.sendMsg$default(RoleBornStep.this, 7, null, 0L, 6, null);
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
            this.roleBornAnimInfo.setErrorInfo(new ErrorInfo(-1, "getMeHolder failed. " + intValue));
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
            return;
        }
        this.roleBornAnimInfo.setMeIndex(intValue);
        this.roleBornAnimInfo.setMeViewHolder(avatarViewHolder);
        this.roleBornAnimInfo.setAvatarView(avatarViewHolder.getAvatar());
        this.roleBornAnimInfo.setPagContainer(avatarViewHolder.getBinding().bornPag);
        this.roleBornAnimInfo.setSquareView(getGuideContext().getSquareMapView());
        BaseStep.sendMsg$default(this, 4, null, 0L, 6, null);
    }

    private final void locateToMe() {
        SquareView squareMapView = getGuideContext().getSquareMapView();
        IMapViewManipulator manipulator = squareMapView != null ? squareMapView.getManipulator() : null;
        if (manipulator == null) {
            this.roleBornAnimInfo.setErrorInfo(new ErrorInfo(-1, "manipulator is null"));
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
        } else {
            IMapViewManipulator.DefaultImpls.locateToMe$default(manipulator, 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.guide.step.biz.RoleBornStep$locateToMe$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    RoleBornStep.RoleBornAnimInfo roleBornAnimInfo;
                    SquareBaseKt.getSquareLog().d("RoleBornStep", "[NoviceGuide] locateToMe, " + z16);
                    if (!z16) {
                        roleBornAnimInfo = RoleBornStep.this.roleBornAnimInfo;
                        roleBornAnimInfo.setErrorInfo(new ErrorInfo(-1, "locate to me failed"));
                        BaseStep.sendMsg$default(RoleBornStep.this, 1, null, 0L, 6, null);
                        return;
                    }
                    BaseStep.sendMsg$default(RoleBornStep.this, 3, null, 0L, 6, null);
                }
            }, 1, null);
        }
    }

    private final void onAnimEnd(Bundle bundle) {
        IReporter iReporter;
        FrameLayout pagContainer = this.roleBornAnimInfo.getPagContainer();
        if (pagContainer != null && (iReporter = this.reporter) != null) {
            iReporter.reportEvent("imp_end", pagContainer, getReportParams());
        }
        complete(bundle);
    }

    private final void playAnim() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareViewModel squareActivityViewModel2;
        GuideContext guideContext = getGuideContext();
        if (guideContext != null && (squareActivityViewModel = guideContext.getSquareActivityViewModel()) != null && (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] notify playingRoleBornAnim");
            value.recordRoleBornAnimStart();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        playPagAnim();
        playAvatarAnim();
        BaseStep.sendMsg$default(this, 6, null, 3000L, 2, null);
    }

    private final void playAvatarAnim() {
        SquareAvatarView avatarView = this.roleBornAnimInfo.getAvatarView();
        if (avatarView != null) {
            avatarView.setAlpha(0.0f);
            avatarView.setPivotX(avatarView.getWidth() / 2);
            avatarView.setPivotY(avatarView.getHeight());
            avatarView.setScaleX(0.0f);
            avatarView.setScaleY(0.0f);
            avatarView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(1000L);
        }
    }

    private final void playPagAnim() {
        FrameLayout pagContainer = this.roleBornAnimInfo.getPagContainer();
        if (pagContainer != null) {
            pagContainer.setVisibility(0);
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                iReporter.reportEvent("imp", pagContainer, getReportParams());
            }
        }
        ISquarePagView pagView = this.roleBornAnimInfo.getPagView();
        if (pagView != null) {
            pagView.playPag(1);
        }
        refreshOtherViews();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.state.square.api.ISquarePagView, T] */
    private final void preparePagView() {
        FrameLayout pagContainer = this.roleBornAnimInfo.getPagContainer();
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
                ((ISquarePagView) t16).setPagFile(this.roleBornAnimInfo.getPagFilePath());
                pagContainer.removeAllViews();
                pagContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
                ((ISquarePagView) objectRef.element).preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.guide.step.biz.RoleBornStep$preparePagView$1
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
                        RoleBornStep.RoleBornAnimInfo roleBornAnimInfo;
                        RoleBornStep.RoleBornAnimInfo roleBornAnimInfo2;
                        if (!z16) {
                            roleBornAnimInfo2 = RoleBornStep.this.roleBornAnimInfo;
                            roleBornAnimInfo2.setErrorInfo(new ErrorInfo(-1, "pagView prepareRuntime failed"));
                            BaseStep.sendMsg$default(RoleBornStep.this, 1, null, 0L, 6, null);
                        } else {
                            roleBornAnimInfo = RoleBornStep.this.roleBornAnimInfo;
                            roleBornAnimInfo.setPagView((ISquarePagView) objectRef.element);
                            BaseStep.sendMsg$default(RoleBornStep.this, 5, null, 0L, 6, null);
                        }
                    }
                });
                return;
            }
            this.roleBornAnimInfo.setErrorInfo(new ErrorInfo(-1, "create pagView failed"));
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
        }
    }

    private final void refreshOtherViews() {
        MapAdapter adapter;
        SquareView squareMapView = getGuideContext().getSquareMapView();
        if (squareMapView == null || (adapter = squareMapView.getAdapter()) == null) {
            return;
        }
        int meIndex = adapter.getMeIndex();
        if (adapter.getMeIndex() >= 0) {
            adapter.notifyItemChanged(meIndex, 24);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public boolean onInterceptMsg(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 1:
                ErrorInfo errorInfo = this.roleBornAnimInfo.getErrorInfo();
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
                playAnim();
                return true;
            case 6:
                Bundle data = msg2.getData();
                Intrinsics.checkNotNullExpressionValue(data, "msg.data");
                onAnimEnd(data);
                return true;
            case 7:
                locateToMe();
                return true;
            default:
                return super.onInterceptMsg(msg2);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public void onStepEnd(Bundle bundle) {
        MapAdapter adapter;
        MapItemController controller;
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareViewModel squareActivityViewModel2;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        GuideContext guideContext = getGuideContext();
        if (guideContext != null && (squareActivityViewModel = guideContext.getSquareActivityViewModel()) != null && (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            value.recordRoleBornAnimEnd();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        RoleBornAnimInfo roleBornAnimInfo = this.roleBornAnimInfo;
        FrameLayout pagContainer = roleBornAnimInfo.getPagContainer();
        if (pagContainer != null) {
            pagContainer.setVisibility(8);
            pagContainer.removeAllViews();
        }
        SquareAvatarView avatarView = roleBornAnimInfo.getAvatarView();
        if (avatarView != null) {
            ViewPropertyAnimator animate = avatarView.animate();
            if (animate != null) {
                animate.cancel();
            }
            avatarView.setScaleX(1.0f);
            avatarView.setScaleY(1.0f);
            avatarView.setAlpha(1.0f);
            avatarView.setVisibility(0);
        }
        SquareView squareMapView = getGuideContext().getSquareMapView();
        if (squareMapView != null && (adapter = squareMapView.getAdapter()) != null && (controller = adapter.getController()) != null) {
            controller.setHasCheckRoleBornAnim(true);
        }
        refreshOtherViews();
        this.roleBornAnimInfo = new RoleBornAnimInfo();
        getGuideContext().recordHasCheckedCreateRoleGuide();
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public void onStepStart(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!getGuideContext().canShowRoleBornAnim()) {
            ignore(bundle);
        } else {
            this.roleBornAnimInfo.setPagUrl(getGuideContext().getConfig().getCreateRoleGuideConfig().getBornPagUrl());
            BaseStep.sendMsg$default(this, 2, null, 0L, 6, null);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    protected boolean shouldInterruptNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return hasCancelFlag();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleBornStep(GuideContext guideContext, IStepListener iStepListener) {
        super(guideContext, StepType.ROLE_BORN, iStepListener);
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        this.roleBornAnimInfo = new RoleBornAnimInfo();
        this.reporter = Square.INSTANCE.getConfig().getReporter();
    }

    private final Map<String, Object> getReportParams() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_DYNAMIC_TYPE, 1));
        return mutableMapOf;
    }
}
