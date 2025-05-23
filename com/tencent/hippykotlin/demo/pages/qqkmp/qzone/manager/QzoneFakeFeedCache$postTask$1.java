package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public /* synthetic */ class QzoneFakeFeedCache$postTask$1 extends FunctionReferenceImpl implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public QzoneFakeFeedCache$postTask$1(Object obj) {
        super(0, obj, QzoneFakeFeedCache.class, "processNextTask", "processNextTask()V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((QzoneFakeFeedCache) this.receiver).processNextTask();
    }
}
