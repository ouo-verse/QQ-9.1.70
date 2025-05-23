package com.tencent.qqnt.circularprogress.api.impl;

import android.content.Context;
import com.tencent.qqnt.circularprogress.a;
import com.tencent.qqnt.circularprogress.api.ICircularProgressApi;
import com.tencent.qqnt.circularprogress.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/circularprogress/api/impl/CircularProgressApiImpl;", "Lcom/tencent/qqnt/circularprogress/api/ICircularProgressApi;", "Landroid/content/Context;", "context", "", "progressIconSize", "Lcom/tencent/qqnt/circularprogress/b;", "getCircularProgress", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CircularProgressApiImpl implements ICircularProgressApi {
    @Override // com.tencent.qqnt.circularprogress.api.ICircularProgressApi
    public b getCircularProgress(Context context, int progressIconSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(context, progressIconSize);
    }
}
