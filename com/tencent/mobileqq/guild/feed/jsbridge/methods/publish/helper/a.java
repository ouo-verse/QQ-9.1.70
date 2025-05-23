package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.guild.event.GuildAtEvent;
import com.tencent.mobileqq.guild.feed.publish.result.InsertAtResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import rk1.n;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements SimpleEventReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f220046f;

    /* renamed from: d, reason: collision with root package name */
    private n f220047d;

    /* renamed from: e, reason: collision with root package name */
    private List<IGProUserInfo> f220048e;

    a() {
    }

    private int a(int i3) {
        if (i3 == 8) {
            return 2;
        }
        if (i3 == 64) {
            return 4;
        }
        return 3;
    }

    public static a b() {
        if (f220046f == null) {
            synchronized (a.class) {
                if (f220046f == null) {
                    f220046f = new a();
                }
            }
        }
        return f220046f;
    }

    private void c(GuildAtEvent guildAtEvent) {
        AtRoleInfo atRoleInfo;
        int i3;
        ArrayList arrayList = new ArrayList();
        this.f220048e = arrayList;
        arrayList.addAll(guildAtEvent.userInfo);
        if (bl.b(this.f220048e)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (IGProUserInfo iGProUserInfo : this.f220048e) {
            String tinyId = iGProUserInfo.getTinyId();
            String name = iGProUserInfo.getName();
            if (iGProUserInfo instanceof AtUserWithRoleInfo) {
                AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
                i3 = a(atUserWithRoleInfo.getAtType());
                atRoleInfo = atUserWithRoleInfo.getAtRole();
            } else {
                atRoleInfo = null;
                i3 = 1;
            }
            arrayList2.add(new InsertAtResult.AtBean(tinyId, name, atRoleInfo, i3));
        }
        this.f220048e.clear();
        this.f220047d.i(new InsertAtResult(arrayList2).c());
    }

    public void d(n nVar) {
        this.f220047d = nVar;
        com.tencent.mobileqq.guild.feed.util.bl.c().d(this);
    }

    public void e() {
        com.tencent.mobileqq.guild.feed.util.bl.c().e(this);
        List<IGProUserInfo> list = this.f220048e;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildAtEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QLog.d("GUP-JS-GuildAtHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "onReceiveEvent-> ", simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildAtEvent) {
            c((GuildAtEvent) simpleBaseEvent);
        }
    }
}
