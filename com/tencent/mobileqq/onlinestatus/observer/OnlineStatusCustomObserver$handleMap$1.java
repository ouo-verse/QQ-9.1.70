package com.tencent.mobileqq.onlinestatus.observer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
/* synthetic */ class OnlineStatusCustomObserver$handleMap$1 extends FunctionReferenceImpl implements Function2<Boolean, Object, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OnlineStatusCustomObserver$handleMap$1(Object obj) {
        super(2, obj, OnlineStatusCustomObserver.class, "handleSetShareInfo", "handleSetShareInfo(ZLjava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj) {
        invoke(bool.booleanValue(), obj);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @Nullable Object obj) {
        ((OnlineStatusCustomObserver) this.receiver).c(z16, obj);
    }
}
