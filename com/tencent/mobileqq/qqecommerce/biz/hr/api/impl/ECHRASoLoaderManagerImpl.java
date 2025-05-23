package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRASoLoaderManager;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.h;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.ECHRASoLoaderManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/ECHRASoLoaderManagerImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/IECHRASoLoaderManager;", "", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "", "loadLibrary", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECHRASoLoaderManagerImpl implements IECHRASoLoaderManager {
    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRASoLoaderManager
    public void loadLibrary(String from, h callback) {
        ECHRASoLoaderManager.INSTANCE.a().loadLibrary(from, callback);
    }
}
