package com.tencent.aelight.camera.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowForOnlineStatusLoadingView;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/api/impl/WinkZShowViewForOnlineStatusProviderImpl;", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider;", "Landroid/content/Context;", "context", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$b;", DownloadInfo.spKey_Config, "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "getLoadingView", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WinkZShowViewForOnlineStatusProviderImpl implements IWinkZShowViewForOnlineStatusProvider {
    @Override // com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider
    public IWinkZShowViewForOnlineStatusProvider.a getLoadingView(Context context, IWinkZShowViewForOnlineStatusProvider.LoadViewConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        WinkZShowForOnlineStatusLoadingView winkZShowForOnlineStatusLoadingView = new WinkZShowForOnlineStatusLoadingView(context);
        winkZShowForOnlineStatusLoadingView.G0(config);
        return winkZShowForOnlineStatusLoadingView;
    }
}
