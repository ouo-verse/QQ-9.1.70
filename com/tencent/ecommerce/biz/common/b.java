package com.tencent.ecommerce.biz.common;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.ecommerce.biz.router.ECScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ2\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/common/b;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/CustomMethodsRegister$CustomMethodInterface;", "", "cmd", "", "", "data", "invoke", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements CustomMethodsRegister.CustomMethodInterface {
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface
    public Object invoke(String cmd, Object... data) {
        if (cmd != null && cmd.hashCode() == 1007237314 && cmd.equals(CustomMethodsRegister.CMD_HYPER_LINK_CLICK)) {
            if ((!(data.length == 0)) && Intrinsics.areEqual(data[0], "https://docs.qq.com/doc/p/0c3ff492a9c5e12022e7bc05bc1f6bba12f57b1e?dver=3.0.0")) {
                Object obj = data[0];
                if (obj != null) {
                    ECScheme.g((String) obj, null, 2, null);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        return Boolean.TRUE;
    }
}
