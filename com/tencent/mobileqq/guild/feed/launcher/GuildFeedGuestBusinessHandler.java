package com.tencent.mobileqq.guild.feed.launcher;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShowBusinessDialogEvent;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010H\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGuestBusinessHandler;", "Lcom/tencent/mobileqq/guild/feed/launcher/a;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShowBusinessDialogEvent;", "dialogEvent", "", "e", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "f", "g", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGuestBusinessHandler extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildFeedGuestBusinessHandler> f220052f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGuestBusinessHandler$a;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGuestBusinessHandler;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGuestBusinessHandler;", "sInstance", "", "ATTRS_GUEST_ENABLE_VISITOR_INTERACT_MODE", "Ljava/lang/String;", "ATTRS_GUEST_ENABLE_VISITOR_MODE", "ATTRS_IS_MEMBER", "DIALOG_SHOW_JOIN_GUILD_GUIDE", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.launcher.GuildFeedGuestBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildFeedGuestBusinessHandler b() {
            return (GuildFeedGuestBusinessHandler) GuildFeedGuestBusinessHandler.f220052f.getValue();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedGuestBusinessHandler a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildFeedGuestBusinessHandler> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildFeedGuestBusinessHandler>() { // from class: com.tencent.mobileqq.guild.feed.launcher.GuildFeedGuestBusinessHandler$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedGuestBusinessHandler invoke() {
                return new GuildFeedGuestBusinessHandler(null);
            }
        });
        f220052f = lazy;
    }

    public /* synthetic */ GuildFeedGuestBusinessHandler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedGuestBusinessHandler d() {
        return INSTANCE.a();
    }

    private final void e(GuildFeedShowBusinessDialogEvent dialogEvent) {
        JumpGuildParam jumpGuildParam;
        Logger.f235387a.d().d("GuildFeedBusinessDialogLauncher", 1, "handleShowGuestJoinDialog, type: " + dialogEvent.getType());
        if (Intrinsics.areEqual(dialogEvent.getType(), "joinGuildGuide") && (jumpGuildParam = dialogEvent.getJumpGuildParam()) != null) {
            f(jumpGuildParam);
        }
    }

    private final void f(final JumpGuildParam jumpGuildParam) {
        Logger.f235387a.d().d("GuildFeedBusinessDialogLauncher", 1, "[handleShowJoinGuildGuide] joinParam: " + jumpGuildParam);
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        GuildMainFrameUtils.k(str, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.launcher.GuildFeedGuestBusinessHandler$handleShowJoinGuildGuide$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("[handleShowJoinGuildGuide] fetchGuildInfoAnyway failed");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildFeedBusinessDialogLauncher", 1, (String) it.next(), null);
                    }
                    return;
                }
                Logger.f235387a.d().d("GuildFeedBusinessDialogLauncher", 1, "[handleShowJoinGuildGuide] fetchGuildInfoAnyway and openJoinInvitationDialog!");
                ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(BaseApplication.getContext(), JumpGuildParam.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.launcher.a
    protected void a(@Nullable SimpleBaseEvent event) {
        if (event == null) {
            return;
        }
        Logger.f235387a.d().d("GuildFeedBusinessDialogLauncher", 1, "[handleReceiveEvent], event: " + event);
        if (event instanceof GuildFeedShowBusinessDialogEvent) {
            e((GuildFeedShowBusinessDialogEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.launcher.a
    @NotNull
    protected ArrayList<Class<Object>> b() {
        ArrayList<Class<Object>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedShowBusinessDialogEvent.class);
        return arrayListOf;
    }

    public final void g() {
        if (1 != MobileQQ.sProcessId) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("can't register out of MAIN Process!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedBusinessDialogLauncher", 1, (String) it.next(), null);
            }
            return;
        }
        if (this.isInit.compareAndSet(false, true)) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    GuildFeedGuestBusinessHandler() {
        this.isInit = new AtomicBoolean(false);
    }
}
