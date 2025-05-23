package com.tencent.mobileqq.kandian.biz.framework.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J#\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAccount", "", "getAppRuntime", "Lmqq/app/AppRuntime;", "getEncryptUin", "getLongAccountUin", "", "handConversationToHide", "", "handConversationToShow", "isWeiShiAccount", "", "uin", "jumpTo", "", "context", "Landroid/content/Context;", ZPlanPublishSource.FROM_SCHEME, WadlProxyConsts.EXTRA_DATA, "Landroid/os/Bundle;", "jumpToUrl", "url", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyUtils extends QRouteApi {
    @NotNull
    String getAccount();

    @NotNull
    AppRuntime getAppRuntime();

    @Nullable
    String getEncryptUin();

    long getLongAccountUin();

    void handConversationToHide();

    void handConversationToShow();

    boolean isWeiShiAccount(@NotNull String uin);

    int jumpTo(@NotNull Context context, @NotNull String scheme);

    int jumpTo(@NotNull Context context, @NotNull String scheme, @Nullable Bundle extraData);

    @Nullable
    Integer jumpToUrl(@Nullable Context context, @Nullable String url);
}
