package com.tencent.mobileqq.zplan.utils;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aa\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\b\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", "block", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Object;", "a", "Ljava/lang/Object;", "NULL", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FlowUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f335725a = new Object();

    public static final <T> Object b(Flow<? extends T> flow, Function2<? super T, ? super T, Unit> function2, Continuation<? super Flow<? extends T>> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) f335725a;
        return FlowKt.flow(new FlowUtilKt$onChange2$$inlined$transform$1(flow, null, objectRef, function2));
    }
}
