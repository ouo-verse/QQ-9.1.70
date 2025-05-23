package com.qwallet.localphone;

import com.qwallet.localphone.QWalletLocalPhoneModule;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetMobileGWPhoneRsp;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qwallet.localphone.QWalletLocalPhoneModule$startGetPhone$1", f = "QWalletLocalPhoneModule.kt", i = {1}, l = {44, 57, 77}, m = "invokeSuspend", n = {"sessionId"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class QWalletLocalPhoneModule$startGetPhone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $appId;
    final /* synthetic */ Function3<Integer, QWalletLocalPhone$GetMobileGWPhoneRsp, String, Unit> $callback;
    final /* synthetic */ String $sessionIdFromOut;
    final /* synthetic */ String $sign;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QWalletLocalPhoneModule$startGetPhone$1(String str, Function3<? super Integer, ? super QWalletLocalPhone$GetMobileGWPhoneRsp, ? super String, Unit> function3, long j3, String str2, Continuation<? super QWalletLocalPhoneModule$startGetPhone$1> continuation) {
        super(2, continuation);
        this.$sessionIdFromOut = str;
        this.$callback = function3;
        this.$appId = j3;
        this.$sign = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletLocalPhoneModule$startGetPhone$1(this.$sessionIdFromOut, this.$callback, this.$appId, this.$sign, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String str;
        Function3<Integer, QWalletLocalPhone$GetMobileGWPhoneRsp, String, Unit> function3;
        boolean z17;
        Object g16;
        Object withTimeoutOrNull;
        boolean z18;
        QWalletLocalPhoneModule.a aVar;
        boolean z19;
        Object e16;
        QWalletLocalPhoneModule.a aVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        e16 = obj;
                        aVar2 = (QWalletLocalPhoneModule.a) e16;
                        QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp = (QWalletLocalPhone$GetMobileGWPhoneRsp) aVar2.a();
                        if (aVar2.getRet() != 0 && qWalletLocalPhone$GetMobileGWPhoneRsp != null) {
                            QLog.d("QWalletLocalPhoneModule", 2, "get local phone end");
                            this.$callback.invoke(Boxing.boxInt(0), qWalletLocalPhone$GetMobileGWPhoneRsp, null);
                            return Unit.INSTANCE;
                        }
                        QLog.e("QWalletLocalPhoneModule", 1, "get local phone error " + aVar2.getErrorMsg());
                        this.$callback.invoke(Boxing.boxInt(aVar2.getRet()), null, aVar2.getErrorMsg());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                withTimeoutOrNull = obj;
                String str2 = str;
                aVar = (QWalletLocalPhoneModule.a) withTimeoutOrNull;
                if (aVar == null) {
                    QLog.e("QWalletLocalPhoneModule", 1, "get phone token timeout");
                    this.$callback.invoke(Boxing.boxInt(-1), null, "get token timeout");
                    return Unit.INSTANCE;
                }
                String str3 = (String) aVar.a();
                if (aVar.getRet() == 0) {
                    if (str3 != null && str3.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        QLog.d("QWalletLocalPhoneModule", 2, "get local phone start");
                        QWalletLocalPhoneModule qWalletLocalPhoneModule = QWalletLocalPhoneModule.f41592a;
                        long j3 = this.$appId;
                        String str4 = this.$sign;
                        this.L$0 = null;
                        this.label = 3;
                        e16 = qWalletLocalPhoneModule.e(j3, str2, str3, str4, this);
                        if (e16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar2 = (QWalletLocalPhoneModule.a) e16;
                        QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp2 = (QWalletLocalPhone$GetMobileGWPhoneRsp) aVar2.a();
                        if (aVar2.getRet() != 0) {
                        }
                        QLog.e("QWalletLocalPhoneModule", 1, "get local phone error " + aVar2.getErrorMsg());
                        this.$callback.invoke(Boxing.boxInt(aVar2.getRet()), null, aVar2.getErrorMsg());
                        return Unit.INSTANCE;
                    }
                }
                QLog.e("QWalletLocalPhoneModule", 1, "get phone token error " + aVar.getErrorMsg());
                this.$callback.invoke(Boxing.boxInt(aVar.getRet()), null, aVar.getErrorMsg());
                return Unit.INSTANCE;
            }
            Function3<Integer, QWalletLocalPhone$GetMobileGWPhoneRsp, String, Unit> function32 = (Function3) this.L$0;
            ResultKt.throwOnFailure(obj);
            function3 = function32;
            g16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$sessionIdFromOut.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("QWalletLocalPhoneModule", 2, "get sessionId start fromOut = " + z16);
            str = this.$sessionIdFromOut;
            long j16 = this.$appId;
            function3 = this.$callback;
            if (str.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                QWalletLocalPhoneModule qWalletLocalPhoneModule2 = QWalletLocalPhoneModule.f41592a;
                this.L$0 = function3;
                this.label = 1;
                g16 = qWalletLocalPhoneModule2.g(j16, this);
                if (g16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            QLog.d("QWalletLocalPhoneModule", 2, "get phone token start");
            QWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1 qWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1 = new QWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1(str, null);
            this.L$0 = str;
            this.label = 2;
            withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(5000L, qWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            String str22 = str;
            aVar = (QWalletLocalPhoneModule.a) withTimeoutOrNull;
            if (aVar == null) {
            }
        }
        QWalletLocalPhoneModule.a aVar3 = (QWalletLocalPhoneModule.a) g16;
        String str5 = (String) aVar3.a();
        if (aVar3.getRet() == 0) {
            if (str5 != null && str5.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                str = str5;
                QLog.d("QWalletLocalPhoneModule", 2, "get phone token start");
                QWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1 qWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$12 = new QWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$1(str, null);
                this.L$0 = str;
                this.label = 2;
                withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(5000L, qWalletLocalPhoneModule$startGetPhone$1$phoneTokenInfo$12, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                }
                String str222 = str;
                aVar = (QWalletLocalPhoneModule.a) withTimeoutOrNull;
                if (aVar == null) {
                }
            }
        }
        QLog.e("QWalletLocalPhoneModule", 1, "get sessionId error " + aVar3.getErrorMsg());
        function3.invoke(Boxing.boxInt(aVar3.getRet()), null, aVar3.getErrorMsg());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletLocalPhoneModule$startGetPhone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
