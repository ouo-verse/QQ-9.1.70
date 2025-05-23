package com.tencent.mobileqq.qqecommerce.base.searchbar;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public /* synthetic */ class ECSearchBar$methodMap$2 extends FunctionReferenceImpl implements Function1<Object, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object m3;
        m3 = ((ECSearchBar) this.receiver).m(obj);
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSearchBar$methodMap$2(Object obj) {
        super(1, obj, ECSearchBar.class, IECSearchBar.METHOD_SET_CALLBACK, "setCallback(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }
}
