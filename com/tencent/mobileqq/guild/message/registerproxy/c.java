package com.tencent.mobileqq.guild.message.registerproxy;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c implements h, f {

    /* renamed from: a, reason: collision with root package name */
    GuildRegisterProxyMsgHandler f230773a;

    /* renamed from: b, reason: collision with root package name */
    private final AppInterface f230774b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<synclogic$GuildNode> f230775c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final Set<Long> f230776d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private boolean f230777e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f230778f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected int f230779g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f230780h = "";

    public c(AppInterface appInterface, GuildRegisterProxyMsgHandler guildRegisterProxyMsgHandler) {
        this.f230773a = guildRegisterProxyMsgHandler;
        this.f230774b = appInterface;
        guildRegisterProxyMsgHandler.H2().a(this);
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public synchronized int a() {
        return this.f230779g;
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public synchronized boolean b(Object obj) {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public void onDestory() {
        if (this.f230773a.H2() != null) {
            this.f230773a.H2().b(this);
        }
    }
}
