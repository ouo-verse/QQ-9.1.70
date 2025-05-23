package com.tencent.ecommerce.biz.router;

import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "p2", "", "", "p3", "", "p4", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final /* synthetic */ class ECScheme$pathHandlerMap$1 extends FunctionReferenceImpl implements Function4<Integer, Map<String, ? extends String>, Map<Object, ? extends Object>, IECSchemeCallback, Integer> {
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, Map<String, ? extends String> map, Map<Object, ? extends Object> map2, IECSchemeCallback iECSchemeCallback) {
        return Integer.valueOf(invoke(num.intValue(), (Map<String, String>) map, map2, iECSchemeCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECScheme$pathHandlerMap$1(ECScheme eCScheme) {
        super(4, eCScheme, ECScheme.class, "handleOpenPath", "handleOpenPath(ILjava/util/Map;Ljava/util/Map;Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;)I", 0);
    }

    public final int invoke(int i3, Map<String, String> map, Map<Object, ? extends Object> map2, IECSchemeCallback iECSchemeCallback) {
        int i16;
        i16 = ((ECScheme) this.receiver).i(i3, map, map2, iECSchemeCallback);
        return i16;
    }
}
