package fm4;

import com.tencent.timi.game.api.param.ExpandHallLaunchParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f399871a;

    /* renamed from: b, reason: collision with root package name */
    public long f399872b;

    /* renamed from: c, reason: collision with root package name */
    public String f399873c;

    public c() {
        this.f399871a = 0L;
        this.f399872b = 0L;
        this.f399873c = "";
    }

    public static c a(ExpandHallLaunchParam expandHallLaunchParam) {
        c cVar = new c();
        cVar.f399871a = expandHallLaunchParam.f376304h;
        try {
            cVar.f399872b = Long.parseLong(expandHallLaunchParam.C);
        } catch (Exception e16) {
            com.tencent.timi.game.utils.l.l("GuildShequnParams", 1, "parseLong channelId failed", e16);
        }
        cVar.f399873c = expandHallLaunchParam.f376305i;
        return cVar;
    }

    public c(long j3, long j16, String str) {
        this.f399871a = j3;
        this.f399872b = j16;
        this.f399873c = str;
    }
}
