package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.winkpublish.outbox.exceptions.WinkPublishBaseException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a[\u0010\n\u001a\u00020\b2(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00002\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001aa\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f2(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00002\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lkotlin/Function3;", "", "", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "Lkotlin/Function1;", "", "block", "a", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "b", "qq_winkpublish_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class IFeatureKt {
    /* JADX WARN: Can't wrap try/catch for region: R(6:13|14|(2:29|30)|17|18|(1:20)(1:22)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        r6 = r11;
        r11 = r13;
        r13 = r6;
        r10 = r2;
        r2 = r12;
        r12 = r0;
        r0 = r1;
        r1 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b1 -> B:11:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00c2 -> B:14:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        IFeatureKt$retry$1 iFeatureKt$retry$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        Object obj;
        IFeatureKt$retry$1 iFeatureKt$retry$12;
        int i17;
        int i18;
        int i19;
        Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function32;
        Function1<? super Continuation<? super Unit>, ? extends Object> function12;
        boolean z16;
        if (continuation instanceof IFeatureKt$retry$1) {
            iFeatureKt$retry$1 = (IFeatureKt$retry$1) continuation;
            int i26 = iFeatureKt$retry$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                iFeatureKt$retry$1.label = i26 - Integer.MIN_VALUE;
                Object obj2 = iFeatureKt$retry$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = iFeatureKt$retry$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        i19 = iFeatureKt$retry$1.I$1;
                        i18 = iFeatureKt$retry$1.I$0;
                        function12 = (Function1) iFeatureKt$retry$1.L$1;
                        function32 = (Function3) iFeatureKt$retry$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (WinkPublishBaseException e16) {
                            WinkPublishBaseException e17 = e16;
                            QLog.d("WinkPublish-upload2--retry", 1, "attempt=" + i18 + ", ", e17);
                            Integer boxInt = Boxing.boxInt(i18);
                            iFeatureKt$retry$1.L$0 = function32;
                            iFeatureKt$retry$1.L$1 = function12;
                            iFeatureKt$retry$1.I$0 = i18;
                            iFeatureKt$retry$1.I$1 = i19;
                            iFeatureKt$retry$1.label = 2;
                            obj2 = function32.invoke(boxInt, e17, iFeatureKt$retry$1);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj2).booleanValue()) {
                            }
                            i16 = i19;
                            function3 = function32;
                            z16 = false;
                            IFeatureKt$retry$1 iFeatureKt$retry$13 = iFeatureKt$retry$1;
                            i17 = i18;
                            function1 = function12;
                            obj = coroutine_suspended;
                            iFeatureKt$retry$12 = iFeatureKt$retry$13;
                            if (z16) {
                            }
                            return Unit.INSTANCE;
                        }
                        i16 = i19;
                        function3 = function32;
                        z16 = false;
                        IFeatureKt$retry$1 iFeatureKt$retry$132 = iFeatureKt$retry$1;
                        i17 = i18;
                        function1 = function12;
                        obj = coroutine_suspended;
                        iFeatureKt$retry$12 = iFeatureKt$retry$132;
                        if (z16) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (i3 == 2) {
                        i19 = iFeatureKt$retry$1.I$1;
                        i18 = iFeatureKt$retry$1.I$0;
                        function12 = (Function1) iFeatureKt$retry$1.L$1;
                        function32 = (Function3) iFeatureKt$retry$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        if (((Boolean) obj2).booleanValue()) {
                            i18++;
                            i16 = i19;
                            function3 = function32;
                            z16 = true;
                            IFeatureKt$retry$1 iFeatureKt$retry$1322 = iFeatureKt$retry$1;
                            i17 = i18;
                            function1 = function12;
                            obj = coroutine_suspended;
                            iFeatureKt$retry$12 = iFeatureKt$retry$1322;
                            if (z16 || i17 >= i16) {
                                return Unit.INSTANCE;
                            }
                            iFeatureKt$retry$12.L$0 = function3;
                            iFeatureKt$retry$12.L$1 = function1;
                            iFeatureKt$retry$12.I$0 = i17;
                            iFeatureKt$retry$12.I$1 = i16;
                            iFeatureKt$retry$12.label = 1;
                            if (function1.invoke(iFeatureKt$retry$12) != obj) {
                                return obj;
                            }
                            function32 = function3;
                            i19 = i16;
                            Object obj3 = obj;
                            function12 = function1;
                            i18 = i17;
                            iFeatureKt$retry$1 = iFeatureKt$retry$12;
                            coroutine_suspended = obj3;
                        }
                        i16 = i19;
                        function3 = function32;
                        z16 = false;
                        IFeatureKt$retry$1 iFeatureKt$retry$13222 = iFeatureKt$retry$1;
                        i17 = i18;
                        function1 = function12;
                        obj = coroutine_suspended;
                        iFeatureKt$retry$12 = iFeatureKt$retry$13222;
                        if (z16) {
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                i16 = 10;
                obj = coroutine_suspended;
                iFeatureKt$retry$12 = iFeatureKt$retry$1;
                i17 = 0;
                iFeatureKt$retry$12.L$0 = function3;
                iFeatureKt$retry$12.L$1 = function1;
                iFeatureKt$retry$12.I$0 = i17;
                iFeatureKt$retry$12.I$1 = i16;
                iFeatureKt$retry$12.label = 1;
                if (function1.invoke(iFeatureKt$retry$12) != obj) {
                }
            }
        }
        iFeatureKt$retry$1 = new IFeatureKt$retry$1(continuation);
        Object obj22 = iFeatureKt$retry$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = iFeatureKt$retry$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0093 -> B:11:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object b(Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        IFeatureKt$retryWithResult$1 iFeatureKt$retryWithResult$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function32;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Object invoke;
        Object invoke2;
        boolean z16;
        if (continuation instanceof IFeatureKt$retryWithResult$1) {
            iFeatureKt$retryWithResult$1 = (IFeatureKt$retryWithResult$1) continuation;
            int i26 = iFeatureKt$retryWithResult$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                iFeatureKt$retryWithResult$1.label = i26 - Integer.MIN_VALUE;
                Object obj = iFeatureKt$retryWithResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = iFeatureKt$retryWithResult$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i16 = 10;
                    i17 = 0;
                    iFeatureKt$retryWithResult$1.L$0 = function3;
                    iFeatureKt$retryWithResult$1.L$1 = function1;
                    iFeatureKt$retryWithResult$1.L$2 = null;
                    iFeatureKt$retryWithResult$1.I$0 = i17;
                    iFeatureKt$retryWithResult$1.I$1 = i16;
                    iFeatureKt$retryWithResult$1.label = 1;
                    invoke2 = function1.invoke(iFeatureKt$retryWithResult$1);
                    if (invoke2 != coroutine_suspended) {
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            int i27 = iFeatureKt$retryWithResult$1.I$1;
                            i18 = iFeatureKt$retryWithResult$1.I$0;
                            Object obj2 = iFeatureKt$retryWithResult$1.L$2;
                            Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) iFeatureKt$retryWithResult$1.L$1;
                            Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function33 = (Function3) iFeatureKt$retryWithResult$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            IFeatureKt$retryWithResult$1 iFeatureKt$retryWithResult$12 = iFeatureKt$retryWithResult$1;
                            int i28 = i27;
                            function3 = function33;
                            Object obj3 = obj2;
                            function12 = function13;
                            Object obj4 = coroutine_suspended;
                            IFeatureKt$retryWithResult$1 iFeatureKt$retryWithResult$13 = iFeatureKt$retryWithResult$12;
                            if (((Boolean) obj).booleanValue()) {
                                z16 = false;
                            } else {
                                QLog.d("WinkPublish-upload2--retryWithResult", 1, "attempt=" + i18 + ", result=" + obj3);
                                i18++;
                                z16 = true;
                            }
                            if (z16 || i18 >= i28) {
                                return obj3;
                            }
                            i16 = i28;
                            iFeatureKt$retryWithResult$1 = iFeatureKt$retryWithResult$13;
                            coroutine_suspended = obj4;
                            Function1<? super Continuation<? super T>, ? extends Object> function14 = function12;
                            i17 = i18;
                            function1 = function14;
                            iFeatureKt$retryWithResult$1.L$0 = function3;
                            iFeatureKt$retryWithResult$1.L$1 = function1;
                            iFeatureKt$retryWithResult$1.L$2 = null;
                            iFeatureKt$retryWithResult$1.I$0 = i17;
                            iFeatureKt$retryWithResult$1.I$1 = i16;
                            iFeatureKt$retryWithResult$1.label = 1;
                            invoke2 = function1.invoke(iFeatureKt$retryWithResult$1);
                            if (invoke2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function32 = function3;
                            i19 = i16;
                            obj = invoke2;
                            int i29 = i17;
                            function12 = function1;
                            i18 = i29;
                            Integer boxInt = Boxing.boxInt(i18);
                            iFeatureKt$retryWithResult$1.L$0 = function32;
                            iFeatureKt$retryWithResult$1.L$1 = function12;
                            iFeatureKt$retryWithResult$1.L$2 = obj;
                            iFeatureKt$retryWithResult$1.I$0 = i18;
                            iFeatureKt$retryWithResult$1.I$1 = i19;
                            iFeatureKt$retryWithResult$1.label = 2;
                            invoke = function32.invoke(boxInt, obj, iFeatureKt$retryWithResult$1);
                            if (invoke != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            IFeatureKt$retryWithResult$1 iFeatureKt$retryWithResult$14 = iFeatureKt$retryWithResult$1;
                            i28 = i19;
                            function3 = function32;
                            obj4 = coroutine_suspended;
                            iFeatureKt$retryWithResult$13 = iFeatureKt$retryWithResult$14;
                            obj3 = obj;
                            obj = invoke;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            if (z16) {
                            }
                            return obj3;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i19 = iFeatureKt$retryWithResult$1.I$1;
                    i18 = iFeatureKt$retryWithResult$1.I$0;
                    function12 = (Function1) iFeatureKt$retryWithResult$1.L$1;
                    function32 = (Function3) iFeatureKt$retryWithResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Integer boxInt2 = Boxing.boxInt(i18);
                    iFeatureKt$retryWithResult$1.L$0 = function32;
                    iFeatureKt$retryWithResult$1.L$1 = function12;
                    iFeatureKt$retryWithResult$1.L$2 = obj;
                    iFeatureKt$retryWithResult$1.I$0 = i18;
                    iFeatureKt$retryWithResult$1.I$1 = i19;
                    iFeatureKt$retryWithResult$1.label = 2;
                    invoke = function32.invoke(boxInt2, obj, iFeatureKt$retryWithResult$1);
                    if (invoke != coroutine_suspended) {
                    }
                }
            }
        }
        iFeatureKt$retryWithResult$1 = new IFeatureKt$retryWithResult$1(continuation);
        Object obj5 = iFeatureKt$retryWithResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = iFeatureKt$retryWithResult$1.label;
        if (i3 != 0) {
        }
    }
}
