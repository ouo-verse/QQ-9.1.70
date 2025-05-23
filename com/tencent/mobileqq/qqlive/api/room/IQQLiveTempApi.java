package com.tencent.mobileqq.qqlive.api.room;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JB\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0005H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/IQQLiveTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isAudioChating", "", "launchAppWithTokens", "", "app", "Lcom/tencent/common/app/AppInterface;", "context", "Landroid/content/Context;", "appid", "", "params", "packageName", WadlProxyConsts.FLAGS, "", "registerQQLiveChatObserver", "removeQQLiveChatObserver", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IQQLiveTempApi extends QRouteApi {
    boolean isAudioChating();

    void launchAppWithTokens(@Nullable AppInterface app, @Nullable Context context, @Nullable String appid, @Nullable String params, @Nullable String packageName, int flags);

    void registerQQLiveChatObserver();

    void removeQQLiveChatObserver();
}
