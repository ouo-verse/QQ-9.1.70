package com.tencent.robot.adelie.kuikly.view.record;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import x14.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J]\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/record/AdelieUploadFile;", "", "Lx14/c$b;", "param", "Lcom/tencent/robot/adelie/homepage/AdelieUtils$a;", "e", "(Lx14/c$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "errMsg", "url", "", "cb", "c", "Lkotlin/Function1;", "callback", "d", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieUploadFile {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/kuikly/view/record/AdelieUploadFile$b", "Lx14/a;", "", "data", "", "a", "", "errCode", "errMsg", "onFail", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements x14.a<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, String, Unit> f366788a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Integer, ? super String, ? super String, Unit> function3) {
            this.f366788a = function3;
        }

        @Override // x14.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f366788a.invoke(0, "", data);
        }

        @Override // x14.a
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f366788a.invoke(Integer.valueOf(errCode), errMsg, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(c.TaskParam param, Function3<? super Integer, ? super String, ? super String, Unit> cb5) {
        new x14.c(param, new b(cb5)).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(c.TaskParam taskParam, Continuation<? super AdelieUtils.UploadResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        c(taskParam, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.robot.adelie.kuikly.view.record.AdelieUploadFile$uploadAndGetUrl$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull String url) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(url, "url");
                cancellableContinuationImpl.resume(new AdelieUtils.UploadResult(url, i3, errMsg), null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void d(@NotNull c.TaskParam param, @NotNull Function1<? super String, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (param.getFilePath().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            callback.invoke("");
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieUploadFileupload", null, null, null, new AdelieUploadFile$upload$1(this, param, callback, null), 14, null);
        }
    }
}
