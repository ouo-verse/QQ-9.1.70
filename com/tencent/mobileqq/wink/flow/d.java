package com.tencent.mobileqq.wink.flow;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/flow/d;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "p3", "", "d0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Y", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "F1", "g", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d implements ApplyMaterialTask {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f322860d = new d();

    d() {
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void F1(@Nullable ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Q(int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void Y(int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean d0(int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return false;
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void g(int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public void p3(int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
    public boolean z(int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return false;
    }
}
