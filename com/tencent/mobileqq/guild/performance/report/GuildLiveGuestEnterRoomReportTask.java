package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildLiveGuestEnterRoomReportTask;", "Lcom/tencent/mobileqq/guild/performance/report/a;", "", "b", "d", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveGuestEnterRoomReportTask extends a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildLiveGuestEnterRoomReportTask> f230973m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildLiveGuestEnterRoomReportTask$a;", "", "", "e", "", "costTime", "", "errorCode", "", "errorMsg", "b", "Lcom/tencent/mobileqq/guild/performance/report/z;", "reportTask$delegate", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/guild/performance/report/z;", "reportTask", "PARAMS_PUSH_TYPE", "Ljava/lang/String;", "PARAMS_USER_TYPE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.performance.report.GuildLiveGuestEnterRoomReportTask$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, long j3, int i3, String str, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            if ((i16 & 4) != 0) {
                str = null;
            }
            companion.b(j3, i3, str);
        }

        private final z d() {
            return (z) GuildLiveGuestEnterRoomReportTask.f230973m.getValue();
        }

        @JvmStatic
        @JvmOverloads
        public final void a(long j3) {
            c(this, j3, 0, null, 6, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void b(long costTime, int errorCode, @Nullable String errorMsg) {
            HashMap<String, String> hashMap = new HashMap<>();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            hashMap.put("guild_id", gLiveChannelCore.s().getGuildId());
            hashMap.put("channel_id", gLiveChannelCore.s().getChannelId());
            hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(gLiveChannelCore.s().getRoomId()));
            hashMap.put("ret", String.valueOf(errorCode));
            if (errorMsg == null) {
                errorMsg = "";
            }
            hashMap.put("msg", errorMsg);
            hashMap.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, String.valueOf(gLiveChannelCore.s().getLiveType()));
            hashMap.put("user_type", String.valueOf(gLiveChannelCore.s().getAnchorIsSelf() ? 1 : 0));
            hashMap.put("cost_time", String.valueOf(costTime));
            d().a(hashMap);
            d().endTask();
        }

        public final void e() {
            d().c();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildLiveGuestEnterRoomReportTask> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveGuestEnterRoomReportTask>() { // from class: com.tencent.mobileqq.guild.performance.report.GuildLiveGuestEnterRoomReportTask$Companion$reportTask$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLiveGuestEnterRoomReportTask invoke() {
                return new GuildLiveGuestEnterRoomReportTask();
            }
        });
        f230973m = lazy;
    }

    @JvmStatic
    @JvmOverloads
    public static final void j(long j3) {
        INSTANCE.a(j3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void k(long j3, int i3, @Nullable String str) {
        INSTANCE.b(j3, i3, str);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String b() {
        return "QGL.GuildLiveGuestEnterRoomReportTask";
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String d() {
        return "gpro_quality#error_code#live_guest_enter_room";
    }
}
