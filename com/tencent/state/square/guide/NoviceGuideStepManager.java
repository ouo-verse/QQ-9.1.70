package com.tencent.state.square.guide;

import android.os.Bundle;
import com.tencent.state.square.guide.step.base.BaseStep;
import com.tencent.state.square.guide.step.base.IStepListener;
import com.tencent.state.square.guide.step.biz.CreateRolePageStep;
import com.tencent.state.square.guide.step.biz.PublishStatusStep;
import com.tencent.state.square.guide.step.biz.RoleBornStep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/guide/NoviceGuideStepManager;", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "blockShow", "", "(Lcom/tencent/state/square/guide/GuideContext;Z)V", "curStep", "Lcom/tencent/state/square/guide/step/base/BaseStep;", "getGuideContext", "()Lcom/tencent/state/square/guide/GuideContext;", "steps", "buildSteps", "", "cancel", "desc", "", "onFragmentStopped", "onInterrupted", "step", "bundle", "Landroid/os/Bundle;", "onStepCancel", "onStepComplete", "onStepEnd", "onStepError", "onStepIgnore", "onStepStart", "start", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class NoviceGuideStepManager implements IStepListener {
    private final boolean blockShow;
    private BaseStep curStep;
    private final GuideContext guideContext;
    private BaseStep steps;

    public NoviceGuideStepManager(GuideContext guideContext, boolean z16) {
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        this.guideContext = guideContext;
        this.blockShow = z16;
        buildSteps();
    }

    private final void buildSteps() {
        if (this.blockShow) {
            return;
        }
        BaseStep linkNext = new RoleBornStep(this.guideContext, this).linkNext(new CreateRolePageStep(this.guideContext, this).linkNext(new PublishStatusStep(this.guideContext, this).linkNext(null)));
        this.steps = linkNext;
        this.curStep = linkNext;
    }

    public final void cancel(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        BaseStep baseStep = this.curStep;
        if (baseStep != null) {
            baseStep.cancel(desc);
        }
    }

    public final GuideContext getGuideContext() {
        return this.guideContext;
    }

    public final void onFragmentStopped() {
        BaseStep baseStep = this.curStep;
        if (baseStep == null || (baseStep instanceof CreateRolePageStep)) {
            return;
        }
        baseStep.cancel("onFragmentStopped");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onInterrupted(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepCancel(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepComplete(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepEnd(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics.areEqual(this.curStep, step)) {
            this.curStep = null;
        }
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepError(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepIgnore(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.IStepListener
    public void onStepStart(BaseStep step, Bundle bundle) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.curStep = step;
    }

    public final void start(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        BaseStep baseStep = this.curStep;
        if (baseStep != null) {
            baseStep.start(bundle);
        }
    }

    public /* synthetic */ NoviceGuideStepManager(GuideContext guideContext, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? false : z16);
    }

    public static /* synthetic */ void start$default(NoviceGuideStepManager noviceGuideStepManager, Bundle bundle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bundle = new Bundle();
        }
        noviceGuideStepManager.start(bundle);
    }
}
