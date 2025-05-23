package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildLiveStartReportTask;", "Lcom/tencent/mobileqq/guild/performance/report/a;", "", "b", "d", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveStartReportTask extends a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildLiveStartReportTask> f230975m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/GuildLiveStartReportTask$a;", "", "", "c", "", "pushType", "errorCode", "", "errorMsg", "a", "Lcom/tencent/mobileqq/guild/performance/report/z;", "reportTask$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/performance/report/z;", "reportTask", "PARAMS_PUSH_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.performance.report.GuildLiveStartReportTask$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final z b() {
            return (z) GuildLiveStartReportTask.f230975m.getValue();
        }

        @JvmStatic
        public final void a(int pushType, int errorCode, @Nullable String errorMsg) {
            HashMap<String, String> hashMap = new HashMap<>();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            hashMap.put("guild_id", gLiveChannelCore.s().getGuildId());
            hashMap.put("channel_id", gLiveChannelCore.s().getChannelId());
            hashMap.put("ret", String.valueOf(errorCode));
            if (errorMsg == null) {
                errorMsg = "";
            }
            hashMap.put("msg", errorMsg);
            hashMap.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, String.valueOf(pushType));
            b().a(hashMap);
            b().endTask();
        }

        public final void c() {
            b().c();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildLiveStartReportTask> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveStartReportTask>() { // from class: com.tencent.mobileqq.guild.performance.report.GuildLiveStartReportTask$Companion$reportTask$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLiveStartReportTask invoke() {
                return new GuildLiveStartReportTask();
            }
        });
        f230975m = lazy;
    }

    @JvmStatic
    public static final void j(int i3, int i16, @Nullable String str) {
        INSTANCE.a(i3, i16, str);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String b() {
        return "QGL.GuildLiveStartReportTask";
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String d() {
        return "gpro_quality#error_code#anchor_start_live";
    }
}
