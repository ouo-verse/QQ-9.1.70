package com.tencent.mobileqq.zplan.lite.impl;

import com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentLoadSoUtil;
import gl0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/impl/ZPlanFilamentLoadSoUtilImpl;", "Lcom/tencent/mobileqq/zplan/lite/IZPlanFilamentLoadSoUtil;", "Lgl0/b;", "listener", "", "downloadAndLoadSo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentLoadSoUtilImpl implements IZPlanFilamentLoadSoUtil {
    private final /* synthetic */ ZPlanFilamentLoadSoUtil $$delegate_0 = ZPlanFilamentLoadSoUtil.INSTANCE;

    @Override // com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil
    public void downloadAndLoadSo(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.downloadAndLoadSo(listener);
    }
}
