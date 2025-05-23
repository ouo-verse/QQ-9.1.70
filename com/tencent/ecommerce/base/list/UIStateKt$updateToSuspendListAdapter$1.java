package com.tencent.ecommerce.base.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@"}, d2 = {"BEAN", "EXTRA", "Lcom/tencent/ecommerce/base/list/h;", "Lcom/tencent/ecommerce/base/list/ISuspendStateListAdapter;", "adapter", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "updateToSuspendListAdapter"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.UIStateKt", f = "UIState.kt", i = {}, l = {94}, m = "updateToSuspendListAdapter", n = {}, s = {})
/* loaded from: classes32.dex */
public final class UIStateKt$updateToSuspendListAdapter$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UIStateKt$updateToSuspendListAdapter$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UIStateKt.g(null, null, this);
    }
}
