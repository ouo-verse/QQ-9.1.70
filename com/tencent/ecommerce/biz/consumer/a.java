package com.tencent.ecommerce.biz.consumer;

import android.content.Context;
import com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J;\u0010%\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00072!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00040 H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010.\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/a;", "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "receiver", "", "registerGameListener", "unRegisterGameListener", "", "appId", "channelId", "querySubscribeStatus", "listener", "querySubscribeStatusForKTV", "", "dyeOpType", "taskKey", "contentId", "subscribe", "Landroid/content/Context;", "context", PushClientConstants.TAG_PKG_NAME, "", "isAppInstalled", WadlProxyConsts.REMOTE_CMD_QUERY_TASK, "doQuerySingleTask", "appName", "downloadUrl", WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION, WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION, WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION, "noticeContent", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isConfirmed", "callback", "showNoWifiDialog", "isWifiConnected", "startApp", ZPlanPublishSource.FROM_SCHEME, MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "Lcom/tencent/ecommerce/biz/consumer/ECMockXingHuanGameButton;", "a", QCircleDaTongConstant.ElementParamValue.OPERATION, VasWebviewConstants.KEY_ADTAG, "subscribeGame", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECGameProxy {
    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ECMockXingHuanGameButton createXingHuanGameButton(@NotNull Context context) {
        return new ECMockXingHuanGameButton(context);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public boolean isAppInstalled(@NotNull Context context, @NotNull String pkgName) {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public boolean isWifiConnected(@NotNull Context context) {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doQueryAllTask() {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doPauseAction(@NotNull String appId) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doQuerySingleTask(@NotNull String appId) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doResumeAction(@NotNull String appId) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void registerGameListener(@NotNull IECGameEventReceiver receiver) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void unRegisterGameListener(@NotNull IECGameEventReceiver receiver) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void openMiniApp(@NotNull Context context, @NotNull String scheme) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void querySubscribeStatus(@NotNull String appId, @NotNull String channelId) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void startApp(@NotNull Context context, @NotNull String pkgName) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void querySubscribeStatusForKTV(@NotNull String appId, @NotNull String channelId, @NotNull IECGameEventReceiver listener) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void showNoWifiDialog(@NotNull Context context, @NotNull String noticeContent, @NotNull Function1<? super Boolean, Unit> callback) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void subscribeGame(@NotNull String appId, @NotNull String channelId, @NotNull String operation, @NotNull String adTag) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doDownloadAction(@NotNull String appId, @NotNull String pkgName, @NotNull String appName, @NotNull String channelId, @NotNull String downloadUrl) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doInstallAction(@NotNull String appId, @NotNull String pkgName, @NotNull String appName, @NotNull String channelId, @NotNull String downloadUrl) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void subscribe(int dyeOpType, @NotNull String taskKey, @NotNull String channelId, @NotNull String appId, @NotNull String contentId) {
    }
}
