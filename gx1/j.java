package gx1;

import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private long f403696a;

    /* renamed from: b, reason: collision with root package name */
    private String f403697b;

    /* renamed from: c, reason: collision with root package name */
    private String f403698c;

    /* renamed from: d, reason: collision with root package name */
    private int f403699d;

    public String a() {
        return this.f403697b;
    }

    public long b() {
        return this.f403696a;
    }

    public String c() {
        return this.f403698c;
    }

    public int d() {
        return this.f403699d;
    }

    public void e(String str) {
        this.f403697b = str;
    }

    public void f(long j3) {
        this.f403696a = j3;
    }

    public void g(String str) {
        this.f403698c = str;
    }

    public void h(int i3) {
        this.f403699d = i3;
    }

    public GuildChannel i() {
        GuildChannel guildChannel = new GuildChannel();
        guildChannel.e(b());
        return guildChannel;
    }
}
