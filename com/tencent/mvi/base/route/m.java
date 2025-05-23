package com.tencent.mvi.base.route;

import com.tencent.mvi.runtime.lifeobserver.LifeCycleWrapperObserver;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u001a\u0019\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"T", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "mvi_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class m {
    public static final <T> T a(T t16) {
        Object obj;
        if (!(t16 instanceof LifeCycleWrapperObserver)) {
            obj = null;
        } else {
            obj = t16;
        }
        LifeCycleWrapperObserver lifeCycleWrapperObserver = (LifeCycleWrapperObserver) obj;
        if (lifeCycleWrapperObserver != null) {
            lifeCycleWrapperObserver.c();
        }
        return t16;
    }
}
