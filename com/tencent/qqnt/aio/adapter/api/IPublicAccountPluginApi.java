package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IPublicAccountPluginApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "runTimePublicAccountPluginSwitch", "", "content", "Lcom/tencent/qqnt/aio/adapter/api/d;", "parseXMLContent", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "httpMqqJump", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IPublicAccountPluginApi extends QRouteApi {
    void httpMqqJump(@NotNull String jumpUrl, @NotNull BaseQQAppInterface app, @NotNull Context context);

    @Nullable
    d parseXMLContent(@NotNull String content);

    boolean runTimePublicAccountPluginSwitch();
}
