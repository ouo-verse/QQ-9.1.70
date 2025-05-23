package com.tencent.biz.pubaccount.accountdetail.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.entity.MsgListPluginEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/IMsgListPluginApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "params", "", "startMsgListPluginSettingPage", "", "from", "", "uin", "Lcom/tencent/biz/entity/MsgListPluginEntity;", "getEntityByUin", "data", "updateData", "Lux/a;", "listener", "addPluginListListener", "removePluginListListener", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IMsgListPluginApi extends QRouteApi {
    void addPluginListListener(@NotNull String from, @NotNull a listener);

    @Nullable
    MsgListPluginEntity getEntityByUin(@NotNull String from, long uin);

    void removePluginListListener(@NotNull String from, @NotNull a listener);

    void startMsgListPluginSettingPage(@NotNull Context context, @Nullable Intent params);

    void updateData(@NotNull String from, @Nullable MsgListPluginEntity data);
}
