package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0002H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0012\u001a\u00020\u0007H&J;\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00132\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0015\"\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0007H&J\f\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH&J,\u0010!\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH&J\"\u0010\"\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMiscApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImpeachReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "callback", "", "sendImpeachReq", "", "guildId", "getCurrentUserType", "bean", "", "isGuildFeedDetailInitBean", "getGuildPostLoadHandler", "webViewProvider", "finishWebViewIfExist", "releaseGuildInfoManager", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "arguments", "getEnablePicShareConfig", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;)V", "initGuildTaskQueueManager", "Ljava/lang/Class;", "getGuildTaskProgressStateClass", "Landroid/content/Context;", "context", "channelId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "jumpToMediaChannel", "jumpToLiveChannel", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedMiscApi extends QRouteApi {
    /* synthetic */ void asyncCallGetSimpleDataMethod(@NotNull String str, @Nullable EIPCResultCallback eIPCResultCallback, @NotNull Object... objArr);

    @Nullable
    /* synthetic */ EIPCResult dispatchToIpcHandler(@Nullable Object obj, @NotNull String str, @NotNull Object[] objArr);

    void finishWebViewIfExist(@Nullable Object webViewProvider);

    @Nullable
    String getCurrentUserType(@Nullable String guildId);

    void getEnablePicShareConfig(@NotNull Function1<? super Bundle, Unit> callback, @NotNull Object... arguments);

    @NotNull
    Object getGuildPostLoadHandler();

    @NotNull
    Class<?> getGuildTaskProgressStateClass();

    void initGuildTaskQueueManager();

    boolean isGuildFeedDetailInitBean(@NotNull Object bean);

    void jumpToLiveChannel(@NotNull String guildId, @NotNull String channelId, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam);

    void jumpToMediaChannel(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam);

    void releaseGuildInfoManager();

    void sendImpeachReq(@NotNull GProImpeachReq req, @Nullable IGProImpeachCallback callback);

    @Nullable
    /* synthetic */ EIPCResult syncCallGetSimpleDataMethod(@NotNull String str, @NotNull Object... objArr);
}
