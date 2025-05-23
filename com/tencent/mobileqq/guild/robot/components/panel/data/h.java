package com.tencent.mobileqq.guild.robot.components.panel.data;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import uo0.p;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends p {

    /* renamed from: e, reason: collision with root package name */
    private final p.b f232195e;

    /* renamed from: f, reason: collision with root package name */
    MultiRobotsSearch f232196f;

    /* renamed from: g, reason: collision with root package name */
    protected final LruCache<String, uo0.k> f232197g;

    public h(@NonNull p.b bVar) {
        super(bVar);
        this.f232197g = new LruCache<>(20);
        this.f232195e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object w(List list, String str, String str2, String str3, String str4, int i3, boolean z16, AppRuntime appRuntime) {
        MultiRobotsSearch multiRobotsSearch = new MultiRobotsSearch(appRuntime, list, str, str2, str3, str4, i3, z16);
        this.f232196f = multiRobotsSearch;
        q(multiRobotsSearch);
        return null;
    }

    @Override // uo0.p
    protected void m(uo0.k kVar) {
        if (!this.f439365c && !kVar.j()) {
            if (kVar != this.f439364b) {
                QLog.i("GuildRobotTag:MultiRobotsSession", 1, "[onSearchResult]: receive expired search callback!");
            } else {
                this.f232195e.e(kVar, this.f232196f.h(), kVar.i(), kVar.g());
            }
        }
    }

    public uo0.k t() {
        return this.f439364b;
    }

    public p.b u() {
        return this.f232195e;
    }

    public void v(final List<String> list, final String str, final String str2, final String str3, final String str4, final int i3, final boolean z16) {
        n("GuildRobotTag:MultiRobotsSession.getRobotFunctions", new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object w3;
                w3 = h.this.w(list, str, str2, str3, str4, i3, z16, (AppRuntime) obj);
                return w3;
            }
        });
    }
}
