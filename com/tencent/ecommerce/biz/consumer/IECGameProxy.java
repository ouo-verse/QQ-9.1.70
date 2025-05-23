package com.tencent.ecommerce.biz.consumer;

import android.content.Context;
import com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH&J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001bH&J;\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\t2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070!H&J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&J0\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH&J(\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH&J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001bH&\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "", "createXingHuanGameButton", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "context", "Landroid/content/Context;", WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, "", "appId", "", PushClientConstants.TAG_PKG_NAME, "appName", "channelId", "downloadUrl", WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION, WadlProxyConsts.REMOTE_CMD_QUERY_TASK, "doQuerySingleTask", WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION, "isAppInstalled", "", "isWifiConnected", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, ZPlanPublishSource.FROM_SCHEME, "querySubscribeStatus", "querySubscribeStatusForKTV", "listener", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "registerGameListener", "receiver", "showNoWifiDialog", "noticeContent", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isConfirmed", "startApp", "subscribe", "dyeOpType", "", "taskKey", "contentId", "subscribeGame", QCircleDaTongConstant.ElementParamValue.OPERATION, VasWebviewConstants.KEY_ADTAG, "unRegisterGameListener", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECGameProxy {
    @NotNull
    IECXingHuanGameButton createXingHuanGameButton(@NotNull Context context);

    void doDownloadAction(@NotNull String appId, @NotNull String pkgName, @NotNull String appName, @NotNull String channelId, @NotNull String downloadUrl);

    void doInstallAction(@NotNull String appId, @NotNull String pkgName, @NotNull String appName, @NotNull String channelId, @NotNull String downloadUrl);

    void doPauseAction(@NotNull String appId);

    void doQueryAllTask();

    void doQuerySingleTask(@NotNull String appId);

    void doResumeAction(@NotNull String appId);

    boolean isAppInstalled(@NotNull Context context, @NotNull String pkgName);

    boolean isWifiConnected(@NotNull Context context);

    void openMiniApp(@NotNull Context context, @NotNull String scheme);

    void querySubscribeStatus(@NotNull String appId, @NotNull String channelId);

    void querySubscribeStatusForKTV(@NotNull String appId, @NotNull String channelId, @NotNull IECGameEventReceiver listener);

    void registerGameListener(@NotNull IECGameEventReceiver receiver);

    void showNoWifiDialog(@NotNull Context context, @NotNull String noticeContent, @NotNull Function1<? super Boolean, Unit> callback);

    void startApp(@NotNull Context context, @NotNull String pkgName);

    void subscribe(int dyeOpType, @NotNull String taskKey, @NotNull String channelId, @NotNull String appId, @NotNull String contentId);

    void subscribeGame(@NotNull String appId, @NotNull String channelId, @NotNull String operation, @NotNull String adTag);

    void unRegisterGameListener(@NotNull IECGameEventReceiver receiver);
}
