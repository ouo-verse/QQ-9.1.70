package com.tencent.guild.api.channel.impl;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.n;
import vh2.s;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001b\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/api/channel/impl/GuildChannelApiImpl;", "Lcom/tencent/guild/api/channel/IGuildChannelApi;", "Landroid/widget/ImageView;", "view", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "getChannelAvatar", "", "getChannelName", "", "getChannelNoticeFlag", "onChannelDetailClick", "getCurrentThemeId", "factoryName", "", "isInLiveChannel", "channelId", "guildId", "isSelfGuest", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "isVisibleForGuest", "isInteractiveForGuest", "isNeedRealNameForGuest", "isFaceAuthVerified", "getFaceAuthVerifyUrl", "isMutedForGuest", "channelReadOnly", "updateGuildInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChannelInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChannelApiImpl implements IGuildChannelApi {

    @NotNull
    private static final String TAG = "GuildChannelApiImpl";

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean channelReadOnly(@NotNull String guildId, @NotNull String channelId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        QLog.i(TAG, 1, "channelReadOnly guildId=" + guildId + " channelId=" + channelId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(channelId);
        }
        boolean z16 = false;
        if (iGProChannelInfo != null && iGProChannelInfo.getMyTalkPermissionType() == 2) {
            z16 = true;
        }
        return !z16;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public void getChannelAvatar(@NotNull ImageView view, @NotNull AIOContact contact) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        AppInterface appInterface2;
        IRuntimeService iRuntimeService2;
        IGProGuildInfo guildInfo;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(contact, "contact");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Drawable drawable = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (guildInfo = iGPSService.getGuildInfo(contact.f())) != null) {
            str = guildInfo.getAvatarUrl(140);
        } else {
            str = null;
        }
        if (str != null) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 instanceof AppInterface) {
                appInterface2 = (AppInterface) peekAppRuntime2;
            } else {
                appInterface2 = null;
            }
            if (appInterface2 != null) {
                iRuntimeService2 = appInterface2.getRuntimeService(IQQGuildAvatarApi.class, "");
            } else {
                iRuntimeService2 = null;
            }
            IQQGuildAvatarApi iQQGuildAvatarApi = (IQQGuildAvatarApi) iRuntimeService2;
            if (iQQGuildAvatarApi != null) {
                drawable = iQQGuildAvatarApi.getDefaultFaceDrawable(false);
            }
            e.a().e(new Option().setUrl(str).setTargetView(view).setNeedFilterUrl(false).setLoadingDrawable(drawable));
        }
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    @NotNull
    public String getChannelName(@NotNull AIOContact contact) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        Intrinsics.checkNotNullParameter(contact, "contact");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(contact.j())) != null) {
            str = channelInfo.getChannelName();
        }
        if (str == null) {
            return "\u672a\u77e5\u9891\u9053-" + contact.j();
        }
        return str;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public int getChannelNoticeFlag(@NotNull AIOContact contact) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(contact, "contact");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(contact.j());
        }
        if (iGProChannelInfo != null) {
            return iGProChannelInfo.getFinalMsgNotify();
        }
        return 0;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    @NotNull
    public String getCurrentThemeId() {
        return "1000";
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    @NotNull
    public String getFaceAuthVerifyUrl() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Cdo faceAuthInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (faceAuthInfo = iGPSService.getFaceAuthInfo()) != null) {
            str = faceAuthInfo.getVerifyUrl();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isFaceAuthVerified() {
        return true;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isInLiveChannel(@NotNull String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        if (((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transChannelType(factoryName) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isInteractiveForGuest(@NotNull String channelId, @NotNull String guildId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(channelId)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (iGProGuildInfo == null) {
            return false;
        }
        return iGProGuildInfo.isInteractiveForVisitor();
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isMutedForGuest(@NotNull String guildId) {
        AppInterface appInterface;
        long j3;
        IGProGuildInfo guildInfo;
        IGProGuildInfo guildInfo2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i(TAG, 1, "isMutedForGuest guildId=" + guildId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        long j16 = 0;
        if (iGPSService != null && (guildInfo2 = iGPSService.getGuildInfo(guildId)) != null) {
            j3 = guildInfo2.getShutUpExpireTime();
        } else {
            j3 = 0;
        }
        if (iGPSService != null && (guildInfo = iGPSService.getGuildInfo(guildId)) != null) {
            j16 = guildInfo.getMyShutUpExpireTime();
        }
        if (NetConnInfoCenter.getServerTime() < Math.max(j3, j16)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isNeedRealNameForGuest(@NotNull String channelId, @NotNull String guildId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(channelId)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (iGProGuildInfo == null) {
            return false;
        }
        return iGProGuildInfo.isNeedRealNameForVisitor();
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isSelfGuest(@NotNull String channelId, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(channelId)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            return iGPSService.isGuest(guildId);
        }
        return true;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isVisibleForGuest(@NotNull String channelId, @NotNull String guildId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(channelId)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (iGProGuildInfo == null) {
            return false;
        }
        return iGProGuildInfo.isVisibleForVisitor();
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    @Nullable
    public Object updateChannelInfo(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Integer> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        QLog.i(TAG, 1, "updateChannelInfo guildId=" + str + " channelId=" + str2);
        if (iGPSService != null) {
            iGPSService.fetchChannelInfoWithCategory(str, str2, 102, new n() { // from class: com.tencent.guild.api.channel.impl.GuildChannelApiImpl$updateChannelInfo$2$1
                @Override // vh2.n
                public final void a(int i3, String str3, IGProChannelInfo iGProChannelInfo) {
                    cancellableContinuationImpl.resume(Integer.valueOf(i3), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.channel.impl.GuildChannelApiImpl$updateChannelInfo$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    @Nullable
    public Object updateGuildInfo(@NotNull String str, @NotNull Continuation<? super Integer> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        QLog.i(TAG, 1, "updateGuildInfo guildId=" + str);
        if (iGPSService != null) {
            iGPSService.fetchGuestGuild(str, false, new s() { // from class: com.tencent.guild.api.channel.impl.GuildChannelApiImpl$updateGuildInfo$2$1
                @Override // vh2.s
                public final void a(int i3, String str2, IGProGuildInfo iGProGuildInfo, List<cy> list) {
                    cancellableContinuationImpl.resume(Integer.valueOf(i3), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.channel.impl.GuildChannelApiImpl$updateGuildInfo$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public boolean isSelfGuest(@NotNull a aioContext, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (aioContext.g().l().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            return iGPSService.isGuest(guildId);
        }
        return true;
    }

    @Override // com.tencent.guild.api.channel.IGuildChannelApi
    public void onChannelDetailClick() {
    }
}
