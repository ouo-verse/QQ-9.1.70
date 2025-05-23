package com.tencent.state.square.guide.step.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.guide.GuideContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 E2\u00020\u0001:\u0001EB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\u0010\u0010,\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0006\u0010-\u001a\u00020(J\u0006\u0010.\u001a\u00020(J\u0010\u0010/\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020 J\u0010\u00100\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0000J\b\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u000203H&J\u000e\u00106\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u0010\u00107\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u00108\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u00109\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010=\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H$J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0002J\"\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020 H$J\u0010\u0010D\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020 R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006F"}, d2 = {"Lcom/tencent/state/square/guide/step/base/BaseStep;", "", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "listener", "Lcom/tencent/state/square/guide/step/base/IStepListener;", "(Lcom/tencent/state/square/guide/GuideContext;Lcom/tencent/state/square/guide/step/base/IStepListener;)V", "flag", "", "getFlag", "()I", "setFlag", "(I)V", "getGuideContext", "()Lcom/tencent/state/square/guide/GuideContext;", "getListener", "()Lcom/tencent/state/square/guide/step/base/IStepListener;", "msgHandler", "Landroid/os/Handler;", "nextStep", "getNextStep", "()Lcom/tencent/state/square/guide/step/base/BaseStep;", "setNextStep", "(Lcom/tencent/state/square/guide/step/base/BaseStep;)V", "addFlag", "", "target", "cancel", "desc", "", "complete", "bundle", "Landroid/os/Bundle;", "end", "result", "Lcom/tencent/state/square/guide/step/base/StepResult;", "error", "errorInfo", "Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "hasCancelFlag", "", "hasCompleteFlag", "hasEndFlag", "hasErrorFlag", "hasFlag", "hasIgnoreFlag", "hasStartFlag", TagValue.IGNORE, "linkNext", "next", "obtainMsg", "Landroid/os/Message;", "onInterceptMsg", "msg", "onNextStep", "onStepCancel", "onStepComplete", "onStepEnd", "onStepError", "onStepIgnore", "onStepStart", "paramsForNextStep", "removeFlag", SmsPlugin.API_SEND_SMS, "type", "delay", "", "shouldInterruptNextStep", "start", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class BaseStep {
    private static final int FLAG_CANCEL = 4;
    private static final int FLAG_COMPLETE = 16;
    private static final int FLAG_END = 32;
    private static final int FLAG_ERROR = 2;
    private static final int FLAG_IGNORE = 8;
    private static final int FLAG_START = 1;
    public static final String KEY_STEP_CANCEL_MSG_STR = "cancel_msg";
    public static final String KEY_STEP_END_RESULT_CODE_SER = "end_result_code";
    public static final String KEY_STEP_ERR_INFO_SER = "error_info";
    public static final int MSG_STEP_CANCEL = 1003;
    public static final int MSG_STEP_COMPLETE = 1005;
    public static final int MSG_STEP_END = 1006;
    public static final int MSG_STEP_ERROR = 1002;
    public static final int MSG_STEP_IGNORE = 1004;
    public static final int MSG_STEP_START = 1001;
    private static final String TAG = "BaseStep";
    private int flag;
    private final GuideContext guideContext;
    private final IStepListener listener;
    private Handler msgHandler;
    private BaseStep nextStep;

    public BaseStep(GuideContext guideContext, IStepListener iStepListener) {
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        this.guideContext = guideContext;
        this.listener = iStepListener;
        final Looper mainLooper = Looper.getMainLooper();
        this.msgHandler = new Handler(mainLooper) { // from class: com.tencent.state.square.guide.step.base.BaseStep$msgHandler$1
            private boolean destroyed;

            private final void destroy() {
                SquareBaseKt.getSquareLog().d("BaseStep", "[NoviceGuide] destroy");
                this.destroyed = true;
                BaseStep.this.msgHandler = null;
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                SquareBaseKt.getSquareLog().d("BaseStep", "[NoviceGuide] handleMessage, " + msg2.what + ", " + this.destroyed);
                if (this.destroyed || BaseStep.this.onInterceptMsg(msg2)) {
                    return;
                }
                switch (msg2.what) {
                    case 1001:
                        BaseStep.this.addFlag(1);
                        IStepListener listener = BaseStep.this.getListener();
                        if (listener != null) {
                            BaseStep baseStep = BaseStep.this;
                            Bundle data = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data, "msg.data");
                            listener.onStepStart(baseStep, data);
                        }
                        BaseStep baseStep2 = BaseStep.this;
                        Bundle data2 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data2, "msg.data");
                        baseStep2.onStepStart(data2);
                        return;
                    case 1002:
                        BaseStep.this.addFlag(2);
                        IStepListener listener2 = BaseStep.this.getListener();
                        if (listener2 != null) {
                            BaseStep baseStep3 = BaseStep.this;
                            Bundle data3 = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data3, "msg.data");
                            listener2.onStepError(baseStep3, data3);
                        }
                        BaseStep baseStep4 = BaseStep.this;
                        Bundle data4 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data4, "msg.data");
                        baseStep4.onStepError(data4);
                        BaseStep baseStep5 = BaseStep.this;
                        StepResult stepResult = StepResult.ERROR;
                        Bundle data5 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data5, "msg.data");
                        baseStep5.end(stepResult, data5);
                        return;
                    case 1003:
                        BaseStep.this.addFlag(4);
                        IStepListener listener3 = BaseStep.this.getListener();
                        if (listener3 != null) {
                            BaseStep baseStep6 = BaseStep.this;
                            Bundle data6 = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data6, "msg.data");
                            listener3.onStepCancel(baseStep6, data6);
                        }
                        BaseStep baseStep7 = BaseStep.this;
                        Bundle data7 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data7, "msg.data");
                        baseStep7.onStepCancel(data7);
                        BaseStep baseStep8 = BaseStep.this;
                        StepResult stepResult2 = StepResult.CANCEL;
                        Bundle data8 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data8, "msg.data");
                        baseStep8.end(stepResult2, data8);
                        return;
                    case 1004:
                        BaseStep.this.addFlag(8);
                        IStepListener listener4 = BaseStep.this.getListener();
                        if (listener4 != null) {
                            BaseStep baseStep9 = BaseStep.this;
                            Bundle data9 = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data9, "msg.data");
                            listener4.onStepIgnore(baseStep9, data9);
                        }
                        BaseStep baseStep10 = BaseStep.this;
                        Bundle data10 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data10, "msg.data");
                        baseStep10.onStepIgnore(data10);
                        BaseStep baseStep11 = BaseStep.this;
                        StepResult stepResult3 = StepResult.IGNORE;
                        Bundle data11 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data11, "msg.data");
                        baseStep11.end(stepResult3, data11);
                        return;
                    case 1005:
                        BaseStep.this.addFlag(16);
                        IStepListener listener5 = BaseStep.this.getListener();
                        if (listener5 != null) {
                            BaseStep baseStep12 = BaseStep.this;
                            Bundle data12 = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data12, "msg.data");
                            listener5.onStepComplete(baseStep12, data12);
                        }
                        BaseStep baseStep13 = BaseStep.this;
                        Bundle data13 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data13, "msg.data");
                        baseStep13.onStepComplete(data13);
                        BaseStep baseStep14 = BaseStep.this;
                        StepResult stepResult4 = StepResult.COMPLETE;
                        Bundle data14 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data14, "msg.data");
                        baseStep14.end(stepResult4, data14);
                        return;
                    case 1006:
                        BaseStep.this.addFlag(32);
                        IStepListener listener6 = BaseStep.this.getListener();
                        if (listener6 != null) {
                            BaseStep baseStep15 = BaseStep.this;
                            Bundle data15 = msg2.getData();
                            Intrinsics.checkNotNullExpressionValue(data15, "msg.data");
                            listener6.onStepEnd(baseStep15, data15);
                        }
                        BaseStep baseStep16 = BaseStep.this;
                        Bundle data16 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data16, "msg.data");
                        baseStep16.onStepEnd(data16);
                        BaseStep baseStep17 = BaseStep.this;
                        Bundle data17 = msg2.getData();
                        Intrinsics.checkNotNullExpressionValue(data17, "msg.data");
                        baseStep17.onNextStep(data17);
                        destroy();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFlag(int target) {
        this.flag = target | this.flag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void end(StepResult result, Bundle bundle) {
        if (hasEndFlag()) {
            return;
        }
        bundle.putSerializable(KEY_STEP_END_RESULT_CODE_SER, result);
        Unit unit = Unit.INSTANCE;
        sendMsg$default(this, 1006, bundle, 0L, 4, null);
    }

    private final boolean hasFlag(int target) {
        return (target & this.flag) != 0;
    }

    private final Message obtainMsg() {
        Message obtain = Message.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Message.obtain()");
        return obtain;
    }

    private final void removeFlag(int target) {
        this.flag = (~target) & this.flag;
    }

    public final void cancel(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (hasEndFlag() || hasCancelFlag()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_STEP_CANCEL_MSG_STR, desc);
        Unit unit = Unit.INSTANCE;
        sendMsg$default(this, 1003, bundle, 0L, 4, null);
    }

    public final void complete(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (hasEndFlag() || hasCompleteFlag()) {
            return;
        }
        sendMsg$default(this, 1005, bundle, 0L, 4, null);
    }

    public final void error(ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        if (hasEndFlag() || hasErrorFlag()) {
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] err, " + errorInfo);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_STEP_ERR_INFO_SER, errorInfo);
        Unit unit = Unit.INSTANCE;
        sendMsg$default(this, 1002, bundle, 0L, 4, null);
    }

    protected final int getFlag() {
        return this.flag;
    }

    public final GuideContext getGuideContext() {
        return this.guideContext;
    }

    public final IStepListener getListener() {
        return this.listener;
    }

    protected final BaseStep getNextStep() {
        return this.nextStep;
    }

    public final void ignore(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (hasEndFlag() || hasIgnoreFlag()) {
            return;
        }
        sendMsg$default(this, 1004, bundle, 0L, 4, null);
    }

    public final BaseStep linkNext(BaseStep next) {
        this.nextStep = next;
        return this;
    }

    public abstract boolean onInterceptMsg(Message msg2);

    public final void onNextStep(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (this.nextStep == null) {
            return;
        }
        if (shouldInterruptNextStep(bundle)) {
            IStepListener iStepListener = this.listener;
            if (iStepListener != null) {
                iStepListener.onInterrupted(this, bundle);
                return;
            }
            return;
        }
        BaseStep baseStep = this.nextStep;
        if (baseStep != null) {
            baseStep.start(paramsForNextStep(bundle));
        }
    }

    public abstract void onStepCancel(Bundle bundle);

    public abstract void onStepComplete(Bundle bundle);

    public abstract void onStepEnd(Bundle bundle);

    public abstract void onStepError(Bundle bundle);

    public abstract void onStepIgnore(Bundle bundle);

    public abstract void onStepStart(Bundle bundle);

    protected abstract Bundle paramsForNextStep(Bundle bundle);

    public final void sendMsg(int type, Bundle bundle, long delay) {
        Handler handler;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (hasEndFlag() || (handler = this.msgHandler) == null) {
            return;
        }
        Message obtainMsg = obtainMsg();
        obtainMsg.what = type;
        obtainMsg.setData(bundle);
        Unit unit = Unit.INSTANCE;
        handler.sendMessageDelayed(obtainMsg, delay);
    }

    protected final void setFlag(int i3) {
        this.flag = i3;
    }

    protected final void setNextStep(BaseStep baseStep) {
        this.nextStep = baseStep;
    }

    protected abstract boolean shouldInterruptNextStep(Bundle bundle);

    public final void start(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (hasEndFlag() || hasStartFlag()) {
            return;
        }
        sendMsg$default(this, 1001, bundle, 0L, 4, null);
    }

    public final boolean hasCancelFlag() {
        return hasFlag(4);
    }

    public final boolean hasErrorFlag() {
        return hasFlag(2);
    }

    public final boolean hasStartFlag() {
        return hasFlag(1);
    }

    public /* synthetic */ BaseStep(GuideContext guideContext, IStepListener iStepListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? null : iStepListener);
    }

    public final boolean hasCompleteFlag() {
        return hasFlag(16);
    }

    public final boolean hasEndFlag() {
        return hasFlag(32);
    }

    public final boolean hasIgnoreFlag() {
        return hasFlag(8);
    }

    public static /* synthetic */ void complete$default(BaseStep baseStep, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                bundle = new Bundle();
            }
            baseStep.complete(bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: complete");
    }

    static /* synthetic */ void end$default(BaseStep baseStep, StepResult stepResult, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bundle = new Bundle();
            }
            baseStep.end(stepResult, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: end");
    }

    public static /* synthetic */ void ignore$default(BaseStep baseStep, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                bundle = new Bundle();
            }
            baseStep.ignore(bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ignore");
    }

    public static /* synthetic */ void sendMsg$default(BaseStep baseStep, int i3, Bundle bundle, long j3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                bundle = new Bundle();
            }
            if ((i16 & 4) != 0) {
                j3 = 0;
            }
            baseStep.sendMsg(i3, bundle, j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMsg");
    }

    public static /* synthetic */ void start$default(BaseStep baseStep, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                bundle = new Bundle();
            }
            baseStep.start(bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }
}
