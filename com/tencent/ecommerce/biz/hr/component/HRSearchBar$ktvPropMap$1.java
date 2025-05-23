package com.tencent.ecommerce.biz.hr.component;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class HRSearchBar$ktvPropMap$1 extends FunctionReferenceImpl implements Function1<Object, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object N;
        N = ((HRSearchBar) this.receiver).N(obj);
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HRSearchBar$ktvPropMap$1(HRSearchBar hRSearchBar) {
        super(1, hRSearchBar, HRSearchBar.class, IECSearchBar.METHOD_SET_CALLBACK, "setCallback(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }
}
