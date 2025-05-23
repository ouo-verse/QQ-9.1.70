package com.tencent.mobileqq.guild.robot.components.join;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback;
import gx1.j;
import java.util.ArrayList;
import java.util.List;
import sx1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends sx1.b {

    /* renamed from: a, reason: collision with root package name */
    private int f232158a;

    /* renamed from: b, reason: collision with root package name */
    private final RobotJoinGuildFragment f232159b;

    /* renamed from: c, reason: collision with root package name */
    private final RobotInfo f232160c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(RobotJoinGuildFragment robotJoinGuildFragment, AppInterface appInterface, RobotInfo robotInfo) {
        this.f232159b = robotJoinGuildFragment;
        this.f232160c = robotInfo;
    }

    private List<j> d(GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        ArrayList arrayList = new ArrayList();
        for (GProRobotCommonGuildInfo gProRobotCommonGuildInfo : gProRobotCommonGuildRsp.getGuilds()) {
            j jVar = new j();
            jVar.f(gProRobotCommonGuildInfo.getGuildId());
            jVar.e(gProRobotCommonGuildInfo.getGuildFace());
            jVar.g(gProRobotCommonGuildInfo.getGuildName());
            jVar.h(gProRobotCommonGuildInfo.getStatus());
            arrayList.add(jVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i3, String str) {
        this.f232159b.Vh(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(List list) {
        this.f232159b.Ih(list, this.f232158a);
        this.f232159b.Wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(final int i3, final String str, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        if (i3 == 0 && gProRobotCommonGuildRsp != null) {
            if (this.f232158a <= 0) {
                this.f232158a = gProRobotCommonGuildRsp.getTotal();
                final List<j> d16 = d(gProRobotCommonGuildRsp);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: gx1.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.mobileqq.guild.robot.components.join.b.this.g(d16);
                    }
                });
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: gx1.c
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.guild.robot.components.join.b.this.f(i3, str);
            }
        });
    }

    public RobotInfo e() {
        return this.f232160c;
    }

    public void i(int i3) {
        ac g16 = f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchRobotCommonGuild(new GProRobotCommonGuildReq(this.f232160c.l(), i3, 50, 0L, 0, 0L, new ArrayList(), new ArrayList()), new IGProFetchRobotCommonGuildCallback() { // from class: gx1.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback
            public final void onFetchRobotCommonGuild(int i16, String str, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
                com.tencent.mobileqq.guild.robot.components.join.b.this.h(i16, str, gProRobotCommonGuildRsp);
            }
        });
    }
}
