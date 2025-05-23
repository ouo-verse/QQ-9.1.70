package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1", f = "MiniHomeConnectSelfFocusComponent.kt", i = {}, l = {447}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $it;
    int label;
    final /* synthetic */ MiniHomeConnectSelfFocusComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1(long j3, MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent, Continuation<? super MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1> continuation) {
        super(2, continuation);
        this.$it = j3;
        this.this$0 = miniHomeConnectSelfFocusComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("MiniHomeConnectSelfFocusComponent", 1, "requestMiniHomeConnectArkInfo");
            long j3 = this.$it;
            this.label = 1;
            obj = MiniHomeNetworkKt.j(j3, 3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        s55.b bVar = (s55.b) obj;
        if (bVar != null) {
            byte[] bArr = bVar.f433366a;
            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.signedArk");
            if (!(bArr.length == 0)) {
                QLog.i("MiniHomeConnectSelfFocusComponent", 1, "requestMiniHomeConnectArkInfo rsp");
                com.tencent.mobileqq.zplan.utils.b bVar2 = com.tencent.mobileqq.zplan.utils.b.f335808a;
                Context context = this.this$0.getContext();
                byte[] bArr2 = bVar.f433366a;
                Intrinsics.checkNotNullExpressionValue(bArr2, "rsp.signedArk");
                bVar2.b(context, new String(bArr2, Charsets.UTF_8), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "sendArkToFriendByNative " + z16);
                        if (z16) {
                            return;
                        }
                        QQToastUtil.showQQToastInUiThread(1, "\u6c42\u52a9\u529b\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    }
                });
                return Unit.INSTANCE;
            }
        }
        QLog.e("MiniHomeConnectSelfFocusComponent", 1, "requestMiniHomeConnectArkInfo rsp error.");
        QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
