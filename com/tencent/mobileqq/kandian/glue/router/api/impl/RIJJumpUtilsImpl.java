package com.tencent.mobileqq.kandian.glue.router.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p62.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J#\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0015J7\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0018J0\u0010\u0019\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u001c\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J#\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/router/api/impl/RIJJumpUtilsImpl;", "Lcom/tencent/mobileqq/kandian/glue/router/api/IRIJJumpUtils;", "()V", "getSourceForDownloadAndJumpOtherApp", "", "channelID", "", "jumpToMiniApp", "", "context", "Landroid/content/Context;", ZPlanPublishSource.FROM_SCHEME, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "miniAppLaunchListener", "Lcom/tencent/mobileqq/mini/api/MiniAppLaunchListener;", "jumpToNativeSearchResultPage", "", "keyword", WadlProxyConsts.KEY_JUMP_URL, "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "wxAppId", "wxAppPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "jumpToViola", "title", "params", "jumpToViolaUrl", "bundle", "Landroid/os/Bundle;", "jumpToWeb", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RIJJumpUtilsImpl implements IRIJJumpUtils {
    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public String getSourceForDownloadAndJumpOtherApp(int channelID) {
        return a.a(channelID);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public boolean jumpToMiniApp(Context context, String scheme, int launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a.c(context, scheme, launchParam, miniAppLaunchListener);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public void jumpToNativeSearchResultPage(Context context, String keyword, String jumpUrl) {
        a.d(context, keyword, jumpUrl);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public Integer jumpToUrl(Context context, String url) {
        return a.e(context, url);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public void jumpToViola(Context context, String title, String url, String params) {
        a.g(context, title, url, params);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public void jumpToViolaUrl(Context context, String url, Bundle bundle) {
        Intrinsics.checkNotNullParameter(url, "url");
        a.b(context, url, bundle);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public Integer jumpToWeb(Context context, String url) {
        return a.h(context, url);
    }

    @Override // com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils
    public Integer jumpToUrl(Context context, String url, String wxAppId, String wxAppPath) {
        return a.f(context, url, wxAppId, wxAppPath);
    }
}
