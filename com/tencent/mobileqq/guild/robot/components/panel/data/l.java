package com.tencent.mobileqq.guild.robot.components.panel.data;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import uo0.p;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends p {

    /* renamed from: e, reason: collision with root package name */
    protected final LruCache<String, uo0.k> f232208e;

    public l(p.b bVar) {
        super(bVar);
        this.f232208e = new LruCache<>(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v(String str, String str2, String str3, String str4, AppRuntime appRuntime) {
        q(new RobotInlineSearch(appRuntime, str, str2, str3, str4));
        return null;
    }

    @Override // uo0.p
    protected void m(uo0.k kVar) {
        if (!this.f439365c && !kVar.j()) {
            this.f439366d.e(kVar, kVar.h(), kVar.i(), kVar.g());
        }
    }

    public uo0.k t() {
        return this.f439364b;
    }

    public void u(final String str, final String str2, final String str3, final String str4) {
        n("GuildRobotTag:RobotInlineSession.getRobotInline", new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object v3;
                v3 = l.this.v(str, str2, str3, str4, (AppRuntime) obj);
                return v3;
            }
        });
    }
}
