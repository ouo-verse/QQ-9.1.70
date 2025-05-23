package com.tencent.qqnt.aio.adapter.api;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOArkApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "app", "view", "", "canReplyByFreesia", "Lcom/tencent/qqnt/aio/adapter/api/a;", "getArkPlatformConfig", "url", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/adapter/api/b;", WadlProxyConsts.EXTRA_DATA, WadlProxyConsts.KEY_JUMP_URL, "", "jumpToPreViewImage", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOArkApi extends QRouteApi {
    boolean canReplyByFreesia(@Nullable String app, @Nullable String view);

    @Nullable
    a getArkPlatformConfig();

    void jumpToPreViewImage(@NotNull Activity activity, @NotNull String url);

    boolean jumpUrl(@NotNull String url, @Nullable MsgRecord msgRecord, @Nullable Activity activity, @NotNull b extraData);
}
