package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.Intent;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.k;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends k {

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, k> f227436e;

    public j(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227436e = new ConcurrentHashMap<>();
        j();
    }

    private void j() {
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227258b), new e(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227259c), new c(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227262f), new com.tencent.mobileqq.guild.safety.i(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227263g), new i(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227261e), new pq1.a(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227264h), new b(this.f227466d));
        this.f227436e.put(Integer.valueOf(GuildMainFrameConstants.f227266j), new GuildGuideAnimHelper(this.f227466d));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().b(z16);
        }
    }

    public Object i(int i3) {
        return this.f227436e.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onActivityResult(int i3, int i16, Intent intent) {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onBeforeAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onResume(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStart() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStop() {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onTabChanged(boolean z16) {
        Iterator<k> it = this.f227436e.values().iterator();
        while (it.hasNext()) {
            it.next().onTabChanged(z16);
        }
    }
}
