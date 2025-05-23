package com.tencent.mobileqq.vas.kuikly;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.vas.kuikly.VasNativePagView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNativePagView$ECPagSoLoader$loadPagSoAsync$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ WeakReference<Function1<Boolean, Unit>> $resultBlock;
    final /* synthetic */ VasNativePagView.ECPagSoLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasNativePagView$ECPagSoLoader$loadPagSoAsync$1(WeakReference<Function1<Boolean, Unit>> weakReference, VasNativePagView.ECPagSoLoader eCPagSoLoader) {
        super(1);
        this.$resultBlock = weakReference;
        this.this$0 = eCPagSoLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, WeakReference resultBlock) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        VasNativePagView.ECPagSoLoader.f309704d = z16;
        Function1 function1 = (Function1) resultBlock.get();
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16) {
        Handler handler;
        QLog.i("HRPAGView", 1, "load pag async result: " + z16);
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            VasNativePagView.ECPagSoLoader.f309704d = z16;
            Function1<Boolean, Unit> function1 = this.$resultBlock.get();
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z16));
                return;
            }
            return;
        }
        handler = this.this$0.uiHandler;
        final WeakReference<Function1<Boolean, Unit>> weakReference = this.$resultBlock;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.x
            @Override // java.lang.Runnable
            public final void run() {
                VasNativePagView$ECPagSoLoader$loadPagSoAsync$1.b(z16, weakReference);
            }
        });
    }
}
