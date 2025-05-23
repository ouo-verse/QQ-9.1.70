package com.tencent.state.square.guide.step.biz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.ISquareObserveRoleRegistService;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.square.guide.step.base.BaseStep;
import com.tencent.state.square.guide.step.base.ErrorInfo;
import com.tencent.state.square.guide.step.base.IStepListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010!\u001a\u00020\rH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/CreateRolePageStep;", "Lcom/tencent/state/square/guide/step/biz/BaseGuideStep;", "Landroidx/lifecycle/LifecycleEventObserver;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "listener", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "(Lcom/tencent/state/square/guide/GuideContext;Lcom/tencent/state/square/guide/step/base/IStepListener;)V", "createRolePage", "Lcom/tencent/state/square/guide/step/biz/CreateRoleGuidePage;", "observeResultService", "Lcom/tencent/state/square/api/ISquareObserveRoleRegistService;", "checkAndHandleRolePageResult", "", "resumed", "", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/state/square/guide/SquareNoviceGuideRecord;", "initResultObserver", "onHidePage", "onInterceptMsg", "msg", "Landroid/os/Message;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStepEnd", "bundle", "Landroid/os/Bundle;", "onStepStart", "shouldInterruptNextStep", "showPage", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CreateRolePageStep extends BaseGuideStep implements LifecycleEventObserver {
    private static final int HIDE_PAGE = 2;
    private static final int ON_ERROR = 3;
    private static final int SHOW_PAGE = 1;
    private static final String TAG = "CreateRolePageStep";
    private CreateRoleGuidePage createRolePage;
    private ISquareObserveRoleRegistService observeResultService;

    public /* synthetic */ CreateRolePageStep(GuideContext guideContext, IStepListener iStepListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? null : iStepListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndHandleRolePageResult(boolean resumed, SquareNoviceGuideRecord record) {
        CreateRoleGuidePage createRoleGuidePage;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[NoviceGuide] checkAndHandleRolePageResult, ");
        sb5.append(resumed);
        sb5.append(", ");
        sb5.append(record != null ? record.getRolePageResult() : null);
        squareLog.d(TAG, sb5.toString());
        if (record == null || !resumed || !Intrinsics.areEqual(record.getRolePageResult(), Boolean.TRUE) || (createRoleGuidePage = this.createRolePage) == null) {
            return;
        }
        createRoleGuidePage.dismiss();
    }

    private final void initResultObserver() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        ISquareObserveRoleRegistService createObserveRoleRegistService = Square.INSTANCE.getConfig().getServiceProvider().createObserveRoleRegistService();
        this.observeResultService = createObserveRoleRegistService;
        if (createObserveRoleRegistService != null) {
            createObserveRoleRegistService.start();
        }
        getGuideContext().getFragment().getLifecycle().addObserver(this);
        GuideContext guideContext = getGuideContext();
        if (guideContext == null || (squareActivityViewModel = guideContext.getSquareActivityViewModel()) == null || (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) == null) {
            return;
        }
        noviceGuideRecord.observe(getGuideContext().getActivity(), new Observer<SquareNoviceGuideRecord>() { // from class: com.tencent.state.square.guide.step.biz.CreateRolePageStep$initResultObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(SquareNoviceGuideRecord squareNoviceGuideRecord) {
                CreateRolePageStep createRolePageStep = CreateRolePageStep.this;
                Lifecycle lifecycle = createRolePageStep.getGuideContext().getFragment().getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "guideContext.fragment.lifecycle");
                createRolePageStep.checkAndHandleRolePageResult(lifecycle.getCurrentState() == Lifecycle.State.RESUMED, squareNoviceGuideRecord);
            }
        });
    }

    private final void showPage() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareViewModel squareActivityViewModel2;
        GuideContext guideContext = getGuideContext();
        if (guideContext != null && (squareActivityViewModel = guideContext.getSquareActivityViewModel()) != null && (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            value.recordCreateRolePageStart();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        if (!getGuideContext().getActivity().isFinishing() && !getGuideContext().getActivity().isDestroyed()) {
            CreateRoleGuidePage createRoleGuidePage = new CreateRoleGuidePage(getGuideContext(), new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRolePageStep$showPage$2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseStep.sendMsg$default(CreateRolePageStep.this, 2, null, 0L, 6, null);
                }
            });
            createRoleGuidePage.show();
            Unit unit = Unit.INSTANCE;
            this.createRolePage = createRoleGuidePage;
            return;
        }
        BaseStep.sendMsg$default(this, 3, null, 0L, 6, null);
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public boolean onInterceptMsg(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            showPage();
            return true;
        }
        if (i3 == 2) {
            onHidePage();
            return true;
        }
        if (i3 != 3) {
            return super.onInterceptMsg(msg2);
        }
        Object obj = msg2.obj;
        if (!(obj instanceof ErrorInfo)) {
            obj = null;
        }
        ErrorInfo errorInfo = (ErrorInfo) obj;
        if (errorInfo == null) {
            errorInfo = new ErrorInfo(-1, "unknown");
        }
        error(errorInfo);
        return true;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(!Intrinsics.areEqual(source, getGuideContext().getFragment())) && event == Lifecycle.Event.ON_RESUME) {
            SquareViewModel squareActivityViewModel = getGuideContext().getSquareActivityViewModel();
            checkAndHandleRolePageResult(true, (squareActivityViewModel == null || (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) == null) ? null : noviceGuideRecord.getValue());
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
            value.recordCreateRolePageEnd();
            GuideContext guideContext2 = getGuideContext();
            if (guideContext2 != null && (squareActivityViewModel2 = guideContext2.getSquareActivityViewModel()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareActivityViewModel2.updateNoviceGuideRecord(value);
            }
        }
        getGuideContext().getFragment().getLifecycle().removeObserver(this);
        ISquareObserveRoleRegistService iSquareObserveRoleRegistService = this.observeResultService;
        if (iSquareObserveRoleRegistService != null) {
            iSquareObserveRoleRegistService.destroy();
        }
        this.observeResultService = null;
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    public void onStepStart(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        super.onStepStart(bundle);
        if (!getGuideContext().canShowCreateRolePage()) {
            ignore(bundle);
        } else {
            initResultObserver();
            BaseStep.sendMsg$default(this, 1, null, 0L, 6, null);
        }
    }

    @Override // com.tencent.state.square.guide.step.biz.BaseGuideStep, com.tencent.state.square.guide.step.base.BaseStep
    protected boolean shouldInterruptNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return hasCancelFlag();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRolePageStep(GuideContext guideContext, IStepListener iStepListener) {
        super(guideContext, StepType.CREATE_ROLE, iStepListener);
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
    }

    private final void onHidePage() {
        BaseStep.complete$default(this, null, 1, null);
    }
}
