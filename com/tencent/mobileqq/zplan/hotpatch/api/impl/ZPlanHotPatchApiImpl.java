package com.tencent.mobileqq.zplan.hotpatch.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi;
import ji3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yh3.c;
import zh3.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/hotpatch/api/impl/ZPlanHotPatchApiImpl;", "Lcom/tencent/mobileqq/zplan/hotpatch/api/IZPlanHotPatchApi;", "Lji3/d;", "listener", "", "registerHotPatchStatusListener", "unregisterHotPatchStatusListener", "Lji3/c;", "registerHotPatchProgressListener", "unregisterHotPatchProgressListener", "Landroid/content/Context;", "context", "Lzh3/a;", "createHotPatchProgressView", "interruptHotPatching", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanHotPatchApiImpl implements IZPlanHotPatchApi {
    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public a createHotPatchProgressView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new bi3.a(context);
    }

    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public void interruptHotPatching() {
        c.f450357a.f();
    }

    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public void registerHotPatchProgressListener(ji3.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c.f450357a.g(listener);
    }

    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public void registerHotPatchStatusListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c.f450357a.h(listener);
    }

    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public void unregisterHotPatchProgressListener(ji3.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c.f450357a.k(listener);
    }

    @Override // com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi
    public void unregisterHotPatchStatusListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c.f450357a.l(listener);
    }
}
