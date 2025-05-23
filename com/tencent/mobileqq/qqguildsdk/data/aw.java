package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.state.ChannelStateUtil;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserChannelState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class aw implements dt {

    /* renamed from: a, reason: collision with root package name */
    public GProGuildState f265699a;

    /* renamed from: b, reason: collision with root package name */
    public long f265700b;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.tencent.mobileqq.qqguildsdk.state.a> f265701c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private GProUserChannelStateInfo f265702d;

    /* renamed from: e, reason: collision with root package name */
    public long f265703e;

    public aw(String str, GProGuildState gProGuildState) {
        this.f265699a = gProGuildState;
        if (gProGuildState == null) {
            this.f265699a = new GProGuildState(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new ArrayList(), 0L, new GProUserChannelState(0L, 0L, 0L, 0L, 2, 1));
        }
        this.f265700b = this.f265699a.getGuildId();
        this.f265703e = this.f265699a.getStateSeq();
        this.f265702d = new GProUserChannelStateInfo(this.f265699a.getUserChannelState());
        Iterator<GProChannelState> it = this.f265699a.getChannelStateList().iterator();
        while (it.hasNext()) {
            GProChannelState next = it.next();
            if (next != null) {
                this.f265701c.add(ChannelStateUtil.a(next));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dt
    public IGProUserChannelStateInfo b() {
        return this.f265702d;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dt
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.qqguildsdk.state.a a(String str) {
        for (com.tencent.mobileqq.qqguildsdk.state.a aVar : this.f265701c) {
            if (aVar.getChannelId().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public long d() {
        return this.f265703e;
    }

    public void e(String str) {
        com.tencent.mobileqq.qqguildsdk.state.a aVar;
        Iterator<com.tencent.mobileqq.qqguildsdk.state.a> it = this.f265701c.iterator();
        while (true) {
            if (it.hasNext()) {
                aVar = it.next();
                if (aVar.getChannelId().equals(str)) {
                    break;
                }
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar != null) {
            this.f265701c.remove(aVar);
        }
    }

    public void f() {
        this.f265701c.clear();
    }

    public void g(GProUserChannelStateInfo gProUserChannelStateInfo) {
        this.f265702d = gProUserChannelStateInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dt
    @NonNull
    public List<cz> getChannelStateList() {
        return new ArrayList(this.f265701c);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dt
    public String getGuildId() {
        return String.valueOf(this.f265700b);
    }

    public void h(long j3) {
        this.f265703e = j3;
    }

    public void i(com.tencent.mobileqq.qqguildsdk.state.a aVar) {
        if (this.f265699a.getGuildId() == 0) {
            this.f265700b = com.tencent.mobileqq.qqguildsdk.util.g.O0(aVar.getGuildId());
        }
        com.tencent.mobileqq.qqguildsdk.state.a a16 = a(aVar.getChannelId());
        if (a16 == null) {
            this.f265701c.add(aVar);
        } else if (ChannelStateUtil.e(aVar.getGuildId()) || a16.a() < aVar.a()) {
            this.f265701c.remove(a16);
            this.f265701c.add(aVar);
        }
    }

    @NonNull
    public String toString() {
        return "GProGuildStateInfo: guild=" + this.f265700b + " channelSize=" + this.f265701c.size() + " channels=" + this.f265701c + " stateSeq=" + this.f265703e;
    }
}
