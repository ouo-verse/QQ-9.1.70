package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildChannelInfoApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J:\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007H\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0096\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J;\u0010\"\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\t0\u001f2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\"\u0010#J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0016J\b\u0010&\u001a\u00020\tH\u0016J,\u0010,\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\"\u0010-\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*H\u0016\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMiscApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMiscApi;", "", "", "method", "Leipc/EIPCResultCallback;", "callback", "", "args", "", "asyncCallGetSimpleDataMethod", "(Ljava/lang/String;Leipc/EIPCResultCallback;[Ljava/lang/Object;)V", "ipcContext", "Leipc/EIPCResult;", "dispatchToIpcHandler", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "syncCallGetSimpleDataMethod", "(Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImpeachReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "sendImpeachReq", "guildId", "getCurrentUserType", "bean", "", "isGuildFeedDetailInitBean", "getGuildPostLoadHandler", "webViewProvider", "finishWebViewIfExist", "releaseGuildInfoManager", "Lkotlin/Function1;", "Landroid/os/Bundle;", "arguments", "getEnablePicShareConfig", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;)V", "Ljava/lang/Class;", "getGuildTaskProgressStateClass", "initGuildTaskQueueManager", "Landroid/content/Context;", "context", "channelId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "jumpToMediaChannel", "jumpToLiveChannel", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMiscApiImpl implements IGuildFeedMiscApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    public static final String EXTRA_KEY_ENTRY_CONFIG = "entry_config";

    @Deprecated
    @NotNull
    public static final String TAG = "GuildFeedMiscApiImpl";
    private final /* synthetic */ FeedIPCApiImpl $$delegate_0 = new FeedIPCApiImpl();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMiscApiImpl$a;", "", "", "EXTRA_KEY_ENTRY_CONFIG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGuildTaskQueueManager$lambda$0() {
        GuildTaskQueueManager.m().C();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void asyncCallGetSimpleDataMethod(@NotNull String method, @Nullable EIPCResultCallback callback, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        this.$$delegate_0.g(method, callback, args);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    @Nullable
    public EIPCResult dispatchToIpcHandler(@Nullable Object ipcContext, @NotNull String method, @NotNull Object[] args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        return this.$$delegate_0.j(ipcContext, method, args);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void finishWebViewIfExist(@Nullable Object webViewProvider) {
        if (webViewProvider instanceof lj1.a) {
            lj1.a aVar = (lj1.a) webViewProvider;
            if (aVar.available()) {
                aVar.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    @Nullable
    public String getCurrentUserType(@Nullable String guildId) {
        return com.tencent.mobileqq.guild.feed.report.f.j(guildId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void getEnablePicShareConfig(@NotNull Function1<? super Bundle, Unit> callback, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        callback.invoke(BundleKt.bundleOf(TuplesKt.to(EXTRA_KEY_ENTRY_CONFIG, 1)));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    @NotNull
    public Object getGuildPostLoadHandler() {
        return new dj1.b();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    @NotNull
    public Class<?> getGuildTaskProgressStateClass() {
        return GuildTaskProgressState.class;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void initGuildTaskQueueManager() {
        if (ch.s0()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedMiscApiImpl.initGuildTaskQueueManager$lambda$0();
                }
            }, 16, null, false);
        } else {
            asyncCallGetSimpleDataMethod("guild_task_queue_mgr_init", null, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public boolean isGuildFeedDetailInitBean(@NotNull Object bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        return bean instanceof GuildFeedDetailInitBean;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void jumpToLiveChannel(@NotNull String guildId, @NotNull String channelId, @Nullable final JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ((IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class)).fetchChannelInfoAnyway(guildId, channelId, new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMiscApiImpl$jumpToLiveChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                invoke2(iGProChannelInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProChannelInfo iGProChannelInfo) {
                if (iGProChannelInfo == null) {
                    QLog.e(GuildFeedMiscApiImpl.TAG, 1, "jumpToLiveChannel fail, fetchChannelInfoAnyway is null.");
                    QQToastUtil.showQQToastInUiThread(1, "\u76f4\u64ad\u5df2\u7ed3\u675f");
                } else {
                    GuildFeedRecommendCardUtils.f219300a.f(iGProChannelInfo, JumpGuildParam.JoinInfoParam.this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void jumpToMediaChannel(@Nullable final Context context, @NotNull String guildId, @NotNull String channelId, @Nullable final JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ((IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class)).fetchChannelInfoAnyway(guildId, channelId, new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMiscApiImpl$jumpToMediaChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                invoke2(iGProChannelInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProChannelInfo iGProChannelInfo) {
                if (iGProChannelInfo == null) {
                    QLog.e(GuildFeedMiscApiImpl.TAG, 1, "jumpToMediaChannel fail, fetchChannelInfoAnyway is null.");
                    QQToastUtil.showQQToastInUiThread(1, "\u76f4\u64ad\u5df2\u7ed3\u675f");
                } else {
                    GuildFeedRecommendCardUtils.f219300a.i(context, iGProChannelInfo, joinInfoParam);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void releaseGuildInfoManager() {
        GuildInfoManager.a0();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    public void sendImpeachReq(@NotNull GProImpeachReq req, @Nullable IGProImpeachCallback callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.impeach(req, callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi
    @Nullable
    public EIPCResult syncCallGetSimpleDataMethod(@NotNull String method, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        return this.$$delegate_0.m(method, args);
    }
}
