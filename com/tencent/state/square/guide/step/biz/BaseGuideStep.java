package com.tencent.state.square.guide.step.biz;

import android.os.Bundle;
import android.os.Message;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.guide.step.base.BaseStep;
import com.tencent.state.square.guide.step.base.IStepListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/BaseGuideStep;", "Lcom/tencent/state/square/guide/step/base/BaseStep;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "type", "Lcom/tencent/state/square/guide/step/biz/StepType;", "listener", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "(Lcom/tencent/state/square/guide/GuideContext;Lcom/tencent/state/square/guide/step/biz/StepType;Lcom/tencent/state/square/guide/step/base/IStepListener;)V", "getType", "()Lcom/tencent/state/square/guide/step/biz/StepType;", "onInterceptMsg", "", "msg", "Landroid/os/Message;", "onStepCancel", "", "bundle", "Landroid/os/Bundle;", "onStepComplete", "onStepEnd", "onStepError", "onStepIgnore", "onStepStart", "paramsForNextStep", "shouldInterruptNextStep", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class BaseGuideStep extends BaseStep {
    private final StepType type;

    public /* synthetic */ BaseGuideStep(GuideContext guideContext, StepType stepType, IStepListener iStepListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, stepType, (i3 & 4) != 0 ? null : iStepListener);
    }

    public final StepType getType() {
        return this.type;
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public boolean onInterceptMsg(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return false;
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepCancel(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepComplete(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepEnd(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepError(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepIgnore(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    public void onStepStart(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    protected Bundle paramsForNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return new Bundle();
    }

    @Override // com.tencent.state.square.guide.step.base.BaseStep
    protected boolean shouldInterruptNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGuideStep(GuideContext guideContext, StepType type, IStepListener iStepListener) {
        super(guideContext, iStepListener);
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }
}
