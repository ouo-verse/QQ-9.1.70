package com.tencent.mobileqq.guild.message.directmessage.model.repositories;

import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b@\u0010AR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u001a\u0010\u0013R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0013R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u000f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\u0013R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u000f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\u0013R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u000f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0013R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u000f8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\u0013R\u001b\u00103\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\n\u00100*\u0004\b1\u00102R\u001b\u00106\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u001d\u00104*\u0004\b5\u00102R\u001b\u00109\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0003\u00107*\u0004\b8\u00102R\u001b\u0010<\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0016\u0010:*\u0004\b;\u00102R\u001b\u0010?\u001a\u00020,8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u0011\u0010=*\u0004\b>\u00102\u00a8\u0006B"}, d2 = {"com/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tag", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "c", "getLazyGroService", "()Lkotlin/Lazy;", "lazyGroService", "Lcom/tencent/mobileqq/guild/message/api/IGuildMsgSeqTimeService;", "d", "getLazySequenceService", "lazySequenceService", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadService;", "getLazyUnreadService", "lazyUnreadService", "Lcom/tencent/mobileqq/guild/message/lastmsg/api/IGuildLastMsgService;", "f", "getLazyLastMessageService", "lazyLastMessageService", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "g", "getLazyGuildSummaryApi", "lazyGuildSummaryApi", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", tl.h.F, "getLazyGproGlobalService", "lazyGproGlobalService", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "i", "getLazyGuildInboxRedService", "lazyGuildInboxRedService", "Lcom/tencent/mobileqq/guild/api/IGuildAdapterService;", "j", "getLazyGuildAdapterService", "lazyGuildAdapterService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getGproService$delegate", "(Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;)Ljava/lang/Object;", "gproService", "()Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadService;", "getUnreadService$delegate", "unreadService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "getGproGlobalService$delegate", "gproGlobalService", "()Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "getGuildInboxRedService$delegate", "guildInboxRedService", "()Lcom/tencent/mobileqq/guild/api/IGuildAdapterService;", "getGuildAdapterService$delegate", "guildAdapterService", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ServiceCache$LazyHolder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGPSService> lazyGroService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildMsgSeqTimeService> lazySequenceService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildUnreadService> lazyUnreadService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildLastMsgService> lazyLastMessageService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildSummaryApi> lazyGuildSummaryApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGProGlobalService> lazyGproGlobalService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildInboxRedService> lazyGuildInboxRedService;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<IGuildAdapterService> lazyGuildAdapterService;

    public ServiceCache$LazyHolder(@NotNull String tag) {
        Lazy lazy;
        Lazy<IGPSService> lazy2;
        Lazy<IGuildMsgSeqTimeService> lazy3;
        Lazy<IGuildUnreadService> lazy4;
        Lazy<IGuildLastMsgService> lazy5;
        Lazy<IGuildSummaryApi> lazy6;
        Lazy<IGProGlobalService> lazy7;
        Lazy<IGuildInboxRedService> lazy8;
        Lazy<IGuildAdapterService> lazy9;
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$app$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return ch.Q0();
            }
        });
        this.app = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyGroService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGPSService invoke() {
                r rVar = r.f214743a;
                return (IGPSService) MiscKt.c(IGPSService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyGroService = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildMsgSeqTimeService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazySequenceService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildMsgSeqTimeService invoke() {
                r rVar = r.f214743a;
                return (IGuildMsgSeqTimeService) MiscKt.c(IGuildMsgSeqTimeService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazySequenceService = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildUnreadService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyUnreadService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildUnreadService invoke() {
                r rVar = r.f214743a;
                return (IGuildUnreadService) MiscKt.c(IGuildUnreadService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyUnreadService = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildLastMsgService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyLastMessageService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildLastMsgService invoke() {
                r rVar = r.f214743a;
                return (IGuildLastMsgService) MiscKt.c(IGuildLastMsgService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyLastMessageService = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildSummaryApi>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyGuildSummaryApi$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildSummaryApi invoke() {
                r rVar = r.f214743a;
                return (IGuildSummaryApi) MiscKt.c(IGuildSummaryApi.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyGuildSummaryApi = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<IGProGlobalService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyGproGlobalService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGProGlobalService invoke() {
                r rVar = r.f214743a;
                return (IGProGlobalService) MiscKt.c(IGProGlobalService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyGproGlobalService = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildInboxRedService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyGuildInboxRedService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildInboxRedService invoke() {
                r rVar = r.f214743a;
                return (IGuildInboxRedService) MiscKt.c(IGuildInboxRedService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyGuildInboxRedService = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<IGuildAdapterService>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder$lazyGuildAdapterService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildAdapterService invoke() {
                r rVar = r.f214743a;
                return (IGuildAdapterService) MiscKt.c(IGuildAdapterService.class, ServiceCache$LazyHolder.this.getTag(), "");
            }
        });
        this.lazyGuildAdapterService = lazy9;
    }

    @NotNull
    public final IGProGlobalService a() {
        return this.lazyGproGlobalService.getValue();
    }

    @NotNull
    public final IGPSService b() {
        return this.lazyGroService.getValue();
    }

    @NotNull
    public final IGuildAdapterService c() {
        return this.lazyGuildAdapterService.getValue();
    }

    @NotNull
    public final IGuildInboxRedService d() {
        return this.lazyGuildInboxRedService.getValue();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final IGuildUnreadService f() {
        return this.lazyUnreadService.getValue();
    }
}
