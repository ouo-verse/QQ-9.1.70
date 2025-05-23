package com.tencent.qqnt.aio.helper;

import com.tencent.qqnt.aio.helper.ZplanEntranceHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
/* synthetic */ class ZplanEntranceHelper$onCreate$4 extends FunctionReferenceImpl implements Function2<Integer, Object, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
        invoke(num.intValue(), obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZplanEntranceHelper$onCreate$4(Object obj) {
        super(2, obj, ZplanEntranceHelper.b.class, "send", "send(ILjava/lang/Object;)V", 0);
    }

    public final void invoke(int i3, Object obj) {
        ((ZplanEntranceHelper.b) this.receiver).a(i3, obj);
    }
}
