package com.tencent.mobileqq.zplan.utils.api.impl;

import com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import vk3.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/ZPlanPAGLoaderHelperImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanPAGLoaderHelper;", "Lvk3/a;", "listener", "", "addDownloadListener", "removeDownloadListener", "", "pagUrl", "Lorg/libpag/PAGFile;", "getPAGFileByUrl", "pagFile", "", "dp", "setPAGParam", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPAGLoaderHelperImpl implements IZPlanPAGLoaderHelper {
    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper
    public void addDownloadListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanPAGLoader.f369875a.c(listener);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper
    public PAGFile getPAGFileByUrl(String pagUrl) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        return ZPlanPAGLoader.f369875a.f(pagUrl);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper
    public void removeDownloadListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanPAGLoader.f369875a.k(listener);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanPAGLoaderHelper
    public void setPAGParam(PAGFile pagFile, int dp5) {
        ZPlanPAGLoader.f369875a.m(pagFile, dp5);
    }
}
