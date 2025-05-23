package com.tencent.mobileqq.widget.listitem;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public /* synthetic */ class DataObserver$visible$2 extends FunctionReferenceImpl implements Function1<Boolean, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataObserver$visible$2(Object obj) {
        super(1, obj, DataObserver.class, "defaultTransformer", "defaultTransformer(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @NotNull
    public final Boolean invoke(boolean z16) {
        Object c16;
        c16 = ((DataObserver) this.receiver).c(Boolean.valueOf(z16));
        return (Boolean) c16;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
