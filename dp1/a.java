package dp1;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Ldp1/a;", "", "", "guildId", "", "timestamp", "target", "", "d", "f", "e", "g", "", "", "b", "Ljava/util/Map;", "guildOpenTimes", "c", "guildOnCreatedTimestamp", "guildOnOpenPageTimestamp", "guildOnCreatViewTimestamp", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f394517a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> guildOpenTimes = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Long> guildOnCreatedTimestamp = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Long> guildOnOpenPageTimestamp = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Long> guildOnCreatViewTimestamp = new LinkedHashMap();

    a() {
    }

    public final void d(@NotNull String guildId, long timestamp, @NotNull String target) {
        int i3;
        long j3;
        long j16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(target, "target");
        Integer num = guildOpenTimes.get(guildId);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            Long l3 = (Long) guildOnOpenPageTimestamp.get(guildId);
            long j17 = 0;
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            long j18 = timestamp - j3;
            Long l16 = (Long) guildOnCreatedTimestamp.get(guildId);
            if (l16 != null) {
                j16 = l16.longValue();
            } else {
                j16 = 0;
            }
            long j19 = timestamp - j16;
            Long l17 = (Long) guildOnCreatViewTimestamp.get(guildId);
            if (l17 != null) {
                j17 = l17.longValue();
            }
            d16.d("GuildHomeCostTimeHelper", 1, "\u6253\u5f00(\u7b2c" + i3 + "\u6b21): " + guildId + " \u7ed8\u5236:" + target + " \u8017\u65f6: \topen/OnCreated/OnCreatView \t" + j18 + " \t" + j19 + " \t" + (timestamp - j17) + " \t");
        }
    }

    public final void e(@NotNull String guildId, long timestamp) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        guildOnCreatViewTimestamp.put(guildId, Long.valueOf(timestamp));
    }

    public final void f(@NotNull String guildId, long timestamp) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        guildOnCreatedTimestamp.put(guildId, Long.valueOf(timestamp));
        Map<String, Integer> map = guildOpenTimes;
        Integer num = map.get(guildId);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        map.put(guildId, Integer.valueOf(i3 + 1));
    }

    public final void g(@NotNull String guildId, long timestamp) {
        int i3;
        long j3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Integer num = guildOpenTimes.get(guildId);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            Long l3 = (Long) guildOnCreatedTimestamp.get(guildId);
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            d16.d("GuildHomeCostTimeHelper", 1, "\u6253\u5f00(\u7b2c" + i3 + "\u6b21): " + guildId + " \u8017\u65f6: \t" + (timestamp - j3) + " \tms ");
        }
    }
}
