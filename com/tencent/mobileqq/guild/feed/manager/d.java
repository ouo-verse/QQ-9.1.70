package com.tencent.mobileqq.guild.feed.manager;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected final LinkedHashMap<String, GuildBaseFeedChildPresenter<ij1.g>> f220171a = new LinkedHashMap<>();

    public void a(com.tencent.mobileqq.guild.feed.event.a aVar) {
        hj1.b.b("Guild_Feed_GuildFeedPresenterManager", "broadcastMessage: hash[" + hashCode() + "] event[" + aVar.f218571a + "]");
        if (this.f220171a.size() == 0) {
            hj1.b.b("Guild_Feed_GuildFeedPresenterManager", "broadcastMessage: hash[" + hashCode() + "] presenter is empty");
        }
        Iterator<String> it = this.f220171a.keySet().iterator();
        while (it.hasNext()) {
            GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter = this.f220171a.get(it.next());
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.g(aVar);
            }
        }
    }

    public boolean b(GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter) {
        return this.f220171a.containsKey(guildBaseFeedChildPresenter.getClass().getName());
    }

    public void c() {
        hj1.b.b("Guild_Feed_GuildFeedPresenterManager", "clear: hash[" + hashCode() + "]");
        this.f220171a.clear();
    }

    public LinkedHashMap<String, GuildBaseFeedChildPresenter<ij1.g>> d() {
        return this.f220171a;
    }

    public void e(GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter) {
        if (guildBaseFeedChildPresenter == null) {
            return;
        }
        if (this.f220171a.get(guildBaseFeedChildPresenter.getClass().getName()) != null && RFWApplication.isDebug()) {
            throw new RuntimeException("you can not register Same Class Presenter");
        }
        this.f220171a.put(guildBaseFeedChildPresenter.getClass().getName(), guildBaseFeedChildPresenter);
    }
}
