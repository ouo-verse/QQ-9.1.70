package com.tencent.mobileqq.kandian.glue.router.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J#\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0014J7\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H&J$\u0010\u001b\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J#\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/router/api/IRIJJumpUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSourceForDownloadAndJumpOtherApp", "", "channelID", "", "jumpToMiniApp", "", "context", "Landroid/content/Context;", ZPlanPublishSource.FROM_SCHEME, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "miniAppLaunchListener", "Lcom/tencent/mobileqq/mini/api/MiniAppLaunchListener;", "jumpToNativeSearchResultPage", "", "keyword", WadlProxyConsts.KEY_JUMP_URL, "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "wxAppId", "wxAppPath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "jumpToViola", "title", "params", "jumpToViolaUrl", "bundle", "Landroid/os/Bundle;", "jumpToWeb", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IRIJJumpUtils extends QRouteApi {
    @Nullable
    String getSourceForDownloadAndJumpOtherApp(int channelID);

    boolean jumpToMiniApp(@NotNull Context context, @Nullable String scheme, int launchParam, @Nullable MiniAppLaunchListener miniAppLaunchListener);

    void jumpToNativeSearchResultPage(@Nullable Context context, @Nullable String keyword, @Nullable String jumpUrl);

    @Nullable
    Integer jumpToUrl(@Nullable Context context, @Nullable String url);

    @Nullable
    Integer jumpToUrl(@Nullable Context context, @Nullable String url, @Nullable String wxAppId, @Nullable String wxAppPath);

    void jumpToViola(@Nullable Context context, @Nullable String title, @Nullable String url, @Nullable String params);

    void jumpToViolaUrl(@Nullable Context context, @NotNull String url, @Nullable Bundle bundle);

    @Nullable
    Integer jumpToWeb(@Nullable Context context, @Nullable String url);
}
