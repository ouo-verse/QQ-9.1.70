package com.tencent.mobileqq.matchfriend.aio.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.matchfriend.aio.api.IStrangerAIOBackgroundApi;
import com.tencent.mobileqq.vas.nt.AIOBackgroundContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/api/impl/StrangerAIOBackgroundApiImpl;", "Lcom/tencent/mobileqq/matchfriend/aio/api/IStrangerAIOBackgroundApi;", "()V", "getDefaultAIOBackground", "Landroid/view/View;", "context", "Landroid/content/Context;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class StrangerAIOBackgroundApiImpl implements IStrangerAIOBackgroundApi {
    @Override // com.tencent.mobileqq.matchfriend.aio.api.IStrangerAIOBackgroundApi
    public View getDefaultAIOBackground(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AIOBackgroundContainer(context);
    }
}
