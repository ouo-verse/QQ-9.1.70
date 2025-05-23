package com.tencent.mobileqq.zplan.utils.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zplan.utils.api.IUESoLoaderHelper;
import com.tencent.mobileqq.zplan.utils.ba;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/UESoLoaderHelperImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IUESoLoaderHelper;", "()V", "loadSo", "", "ctx", "Landroid/content/Context;", "from", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class UESoLoaderHelperImpl implements IUESoLoaderHelper {
    @Override // com.tencent.mobileqq.zplan.utils.api.IUESoLoaderHelper
    public void loadSo(Context ctx, String from) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(from, "from");
        ba.f335809a.a(ctx, from);
    }
}
