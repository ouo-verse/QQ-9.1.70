package com.tencent.mobileqq.qqecommerce.base.searchbar;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public /* synthetic */ class ECSearchBar$methodMap$4 extends FunctionReferenceImpl implements Function1<Object, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object o16;
        o16 = ((ECSearchBar) this.receiver).o(obj);
        return o16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSearchBar$methodMap$4(Object obj) {
        super(1, obj, ECSearchBar.class, IECSearchBar.METHOD_SET_TEXT, "setText(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }
}
