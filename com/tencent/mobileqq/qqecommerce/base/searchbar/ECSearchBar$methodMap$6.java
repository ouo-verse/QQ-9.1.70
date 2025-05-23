package com.tencent.mobileqq.qqecommerce.base.searchbar;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public /* synthetic */ class ECSearchBar$methodMap$6 extends FunctionReferenceImpl implements Function1<Object, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object p16;
        p16 = ((ECSearchBar) this.receiver).p(obj);
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSearchBar$methodMap$6(Object obj) {
        super(1, obj, ECSearchBar.class, "showKeyboard", "showKeyboard(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }
}
