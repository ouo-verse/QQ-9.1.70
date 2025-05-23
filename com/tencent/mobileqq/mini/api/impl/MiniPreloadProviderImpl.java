package com.tencent.mobileqq.mini.api.impl;

import android.content.Context;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniPreloadProvider;
import com.tencent.webbundle.sdk.WebBundleConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/MiniPreloadProviderImpl;", "Lcom/tencent/mobileqq/mini/api/IMiniPreloadProvider;", "()V", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW, "", "context", "Landroid/content/Context;", "preLoader", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniPreloadProviderImpl implements IMiniPreloadProvider {
    @Override // com.tencent.mobileqq.mini.api.IMiniPreloadProvider
    public void preloadView(Context context, RFWLayoutPreLoader preLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preLoader, "preLoader");
        preLoader.preloadView(context, R.layout.diy, 1);
        preLoader.preloadView(context, R.layout.f167476dj0, 1);
        preLoader.preloadView(context, R.layout.dir, 1);
        preLoader.preloadView(context, R.layout.f167478dj2, 1);
        preLoader.preloadView(context, R.layout.f167477dj1, 15);
        preLoader.preloadView(context, R.layout.dip, 3);
        preLoader.preloadView(context, R.layout.f167479dj3, 3);
        preLoader.preloadView(context, R.layout.die, 1);
        preLoader.preloadView(context, R.layout.dik, 1);
        preLoader.preloadView(context, R.layout.dib, 1);
        preLoader.preloadView(context, R.layout.fhl, 1);
        preLoader.preloadView(context, R.layout.djn, 1);
        preLoader.preloadView(context, R.layout.dih, 1);
        preLoader.preloadView(context, R.layout.dij, 1);
        preLoader.preloadView(context, R.layout.did, 1);
        preLoader.preloadView(context, R.layout.dii, 12);
        preLoader.preloadView(context, R.layout.dig, 20);
    }
}
