package com.tencent.mobileqq.zplan.proxy;

import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/ae;", "Lzx4/f;", "", "qualityJsonStr", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ae implements zx4.f {
    @Override // zx4.f
    public void a(String qualityJsonStr) {
        Intrinsics.checkNotNullParameter(qualityJsonStr, "qualityJsonStr");
        QLog.i("ZPlanGraphics", 1, "handleGraphicsQuality from UE: " + qualityJsonStr);
        if (TextUtils.isEmpty(qualityJsonStr)) {
            return;
        }
        com.tencent.mobileqq.zplan.setting.b.g(BaseApplication.getContext(), qualityJsonStr);
    }
}
