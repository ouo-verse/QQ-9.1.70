package com.tencent.robot.share;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "arkInfoStr", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotShareActionExecutor$checkShareSign$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ RobotShareActionExecutor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RobotShareActionExecutor$checkShareSign$1(Function1<? super String, Unit> function1, RobotShareActionExecutor robotShareActionExecutor) {
        super(1);
        this.$callback = function1;
        this.this$0 = robotShareActionExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotShareActionExecutor this$0) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        activity = this$0.mActivity;
        QQToast.makeText(activity, 0, R.string.f223416g6, 0).show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String arkInfoStr) {
        Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
        if (arkInfoStr.length() == 0) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final RobotShareActionExecutor robotShareActionExecutor = this.this$0;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.robot.share.i
                @Override // java.lang.Runnable
                public final void run() {
                    RobotShareActionExecutor$checkShareSign$1.b(RobotShareActionExecutor.this);
                }
            });
            return;
        }
        this.$callback.invoke(arkInfoStr);
    }
}
