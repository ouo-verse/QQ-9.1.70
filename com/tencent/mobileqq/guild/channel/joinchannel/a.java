package com.tencent.mobileqq.guild.channel.joinchannel;

import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u0001:\u0001\rB<\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR/\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001e\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/a;", "", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "k", "j", "isSuccess", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "g", "l", "", "a", "Ljava/lang/String;", "guildId", "b", "channelId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "c", "Lkotlin/jvm/functions/Function1;", "block", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isGuildInfoReady", "e", "isChannelInfoReady", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "f", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsServiceObserver", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> block;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isGuildInfoReady;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isChannelInfoReady;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IGPSService gpsService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/a$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "updateGuildId", "", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (Intrinsics.areEqual(a.this.channelId, channelUin) && a.this.isChannelInfoReady.compareAndSet(false, true)) {
                a.i(a.this, false, 1, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String updateGuildId) {
            if (Intrinsics.areEqual(a.this.guildId, updateGuildId) && !a.this.gpsService.isGuest(a.this.guildId) && a.this.isGuildInfoReady.compareAndSet(false, true)) {
                a.i(a.this, false, 1, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/a$c", "Lvh2/n;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements vh2.n {
        c() {
        }

        @Override // vh2.n
        public void a(int result, @Nullable String errMsg, @Nullable IGProChannelInfo channelInfo) {
            if (result == 0 && channelInfo != null) {
                if (a.this.isChannelInfoReady.compareAndSet(false, true)) {
                    a.i(a.this, false, 1, null);
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.join.FetchGuildAndChannelInfoLogic", 2, "fetchChannelInfo success");
                    return;
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            a aVar = a.this;
            Logger.b bVar = new Logger.b();
            String str = aVar.channelId + " fetchGuildInfoWithSource error result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.join.FetchGuildAndChannelInfoLogic", 1, (String) it.next(), null);
            }
            a.this.h(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/a$d", "Lvh2/v;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements vh2.v {
        d() {
        }

        @Override // vh2.v
        public void a(int result, @Nullable String errMsg, @Nullable IGProGuildInfo guildInfo) {
            if (result == 0 && guildInfo != null) {
                if (a.this.isGuildInfoReady.compareAndSet(false, true)) {
                    a.i(a.this, false, 1, null);
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.join.FetchGuildAndChannelInfoLogic", 2, "fetchGuildInfo success");
                    return;
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            a aVar = a.this;
            Logger.b bVar = new Logger.b();
            String str = aVar.guildId + " fetchGuildInfoWithSource error result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.join.FetchGuildAndChannelInfoLogic", 1, (String) it.next(), null);
            }
            a.this.h(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull String guildId, @Nullable String str, @NotNull Function1<? super Boolean, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(block, "block");
        this.guildId = guildId;
        this.channelId = str;
        this.block = block;
        this.isGuildInfoReady = new AtomicBoolean(false);
        this.isChannelInfoReady = new AtomicBoolean(false);
        this.gpsService = (IGPSService) ch.R0(IGPSService.class);
        GPServiceObserver g16 = g();
        this.gpsServiceObserver = g16;
        this.gpsService.addObserver(g16);
    }

    private final GPServiceObserver g() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean isSuccess) {
        if (!isSuccess) {
            this.gpsService.deleteObserver(this.gpsServiceObserver);
            this.block.invoke(Boolean.FALSE);
            Logger.f235387a.d().d("Guild.join.FetchGuildAndChannelInfoLogic", 1, "dispatchResult false");
        } else if (this.isGuildInfoReady.get() && this.isChannelInfoReady.get()) {
            this.gpsService.deleteObserver(this.gpsServiceObserver);
            this.block.invoke(Boolean.TRUE);
            Logger.f235387a.d().d("Guild.join.FetchGuildAndChannelInfoLogic", 1, "dispatchResult true");
        }
    }

    static /* synthetic */ void i(a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        aVar.h(z16);
    }

    private final void j(boolean force) {
        if (GuildMainFrameUtils.q(this.channelId)) {
            if (this.isChannelInfoReady.compareAndSet(false, true)) {
                i(this, false, 1, null);
            }
        } else {
            if (!force && this.gpsService.getChannelInfo(this.channelId) != null) {
                if (this.isChannelInfoReady.compareAndSet(false, true)) {
                    i(this, false, 1, null);
                    return;
                }
                return;
            }
            this.gpsService.fetchChannelInfoWithCategory(this.guildId, this.channelId, 102, new c());
        }
    }

    private final void k(boolean force) {
        if (!force && this.gpsService.getGuildInfo(this.guildId) != null) {
            if (this.isGuildInfoReady.compareAndSet(false, true)) {
                i(this, false, 1, null);
                return;
            }
            return;
        }
        this.gpsService.fetchGuildInfoWithSource(this.guildId, 104, new d());
    }

    public static /* synthetic */ void m(a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        aVar.l(z16);
    }

    public final void l(boolean force) {
        Logger.f235387a.d().d("Guild.join.FetchGuildAndChannelInfoLogic", 1, "fetchInfo guildId:" + this.guildId + " channelId:" + this.channelId);
        k(force);
        j(force);
    }
}
