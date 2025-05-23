package com.tencent.mobileqq.zplan.proxy;

import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.zplan.common.model.UploadConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011JZ\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000528\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/ac;", "Llx4/g;", "", "localPath", "uuid", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "uploadTarget", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "remoteUrl", "", "callback", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ac implements lx4.g {
    @Override // lx4.g
    public void a(String localPath, String uuid, UploadConfig.UploadTarget uploadTarget, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(uploadTarget, "uploadTarget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.c().k(localPath, uuid, uploadTarget, callback);
    }
}
