package com.tencent.mobileqq.guild.chatpie;

import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.i;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/chatpie/GuildFeedImageProviderService;", "Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;", "", "id", "", "subId", "type", "", "localPath", "", "Z5", "y", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "Y", "Lkotlin/Lazy;", "Y5", "()Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "feedUtilsApi", "<init>", "()V", "Z", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedImageProviderService extends AIOImageProviderService {

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy feedUtilsApi;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/chatpie/GuildFeedImageProviderService$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f215354f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f215355h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f215356i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, int i3, int i16) {
            super(true);
            this.f215354f = j3;
            this.f215355h = i3;
            this.f215356i = i16;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState state, Option option) {
            if (state == LoadState.STATE_SUCCESS) {
                GuildFeedImageProviderService guildFeedImageProviderService = GuildFeedImageProviderService.this;
                long j3 = this.f215354f;
                int i3 = this.f215355h;
                int i16 = this.f215356i;
                String localPath = option != null ? option.getLocalPath() : null;
                if (localPath == null) {
                    localPath = "";
                }
                guildFeedImageProviderService.Z5(j3, i3, i16, localPath);
            }
        }
    }

    public GuildFeedImageProviderService() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildFeedUtilsApi>() { // from class: com.tencent.mobileqq.guild.chatpie.GuildFeedImageProviderService$feedUtilsApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGuildFeedUtilsApi invoke() {
                return (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
            }
        });
        this.feedUtilsApi = lazy;
    }

    private final IGuildFeedUtilsApi Y5() {
        return (IGuildFeedUtilsApi) this.feedUtilsApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z5(long id5, int subId, int type, String localPath) {
        QLog.d("GFeedImageProviderService", 1, "[notifySuccess] id:" + id5);
        i iVar = this.f179747d;
        if (iVar != null) {
            iVar.notifyImageResult(id5, subId, type, 1, localPath, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void y(long id5, int subId, int type) {
        String feedImageServerPath = Y5().getFeedImageServerPath(id5);
        QLog.i("GFeedImageProviderService", 1, "[downloadMedia] id:" + id5 + ", subId:" + subId + ",type:" + type + ",path:" + (feedImageServerPath != null ? Integer.valueOf(feedImageServerPath.hashCode()) : null));
        if (feedImageServerPath != null) {
            e.a().f(Option.obtain().setUrl(feedImageServerPath), new b(id5, subId, type));
        }
    }
}
