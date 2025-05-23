package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "", "a", "(F)I", "dp", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {
    public static final int a(float f16) {
        return DisplayUtil.dip2px(QCircleServiceImpl.getAppRunTime().getApplicationContext(), f16);
    }
}
