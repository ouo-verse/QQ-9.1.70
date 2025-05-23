package com.tencent.mobileqq.guild.message;

import com.tencent.imcore.message.aj;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
class GuildMessageManager$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ aj f230094d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f230095e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f230096f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f230097h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f230098i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ boolean f230099m;
    final /* synthetic */ m this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        int i3;
        this.this$0.U(this.f230094d);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshUnreadMessage() begin");
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            z16 = true;
            i16++;
            List<ChatMessage> r16 = this.this$0.r(this.f230095e, this.f230096f);
            if (r16 != null) {
                for (ChatMessage chatMessage : r16) {
                    if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(chatMessage)) {
                        i3 = (int) chatMessage.shmsgseq;
                        break;
                    }
                }
            }
            i3 = 0;
            long j3 = i3;
            long j16 = this.f230097h;
            if (j3 > 1 + j16) {
                z16 = false;
            }
            if (i17 == i3 || j3 <= j16) {
                break;
            }
            if (i16 % 500 == 0 && QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshUnreadMessage() dead loop warning, firstSeq: " + this.f230098i + " seq: " + i3 + ", unread: " + this.f230097h);
            }
            int i18 = (int) (j3 - this.f230097h);
            if (this.this$0.L0(this.f230095e, this.f230096f, i18).size() != i18 && i18 > 30) {
                i18 = 30;
            }
            aj ajVar = this.f230094d;
            ajVar.f116543u = i18;
            ajVar.f116535m = 0;
            this.this$0.n(this.f230095e, this.f230096f, i18, ajVar);
            i17 = i3;
        }
        if (z16 && this.f230099m) {
            List<ChatMessage> r17 = this.this$0.r(this.f230095e, this.f230096f);
            this.this$0.d1(r17);
            this.this$0.Q0(this.f230096f, null, this.f230095e, this.f230097h, r17);
        }
        aj ajVar2 = this.f230094d;
        ajVar2.f116532j = z16;
        this.this$0.f116282e.setChangeAndNotify(ajVar2);
        this.this$0.f116282e.getFacadeHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.GuildMessageManager$1.1
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Boolean> refreshActionMap = GuildMessageManager$1.this.this$0.f116282e.getRefreshActionMap();
                GuildMessageManager$1 guildMessageManager$1 = GuildMessageManager$1.this;
                if (refreshActionMap.containsKey(ao.f(guildMessageManager$1.f230095e, guildMessageManager$1.f230096f))) {
                    QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 1, "refreshUnreadMessage getRefreshActionMap remove uin: ", LogUtil.wrapLogUin(GuildMessageManager$1.this.f230095e), ", type:", Integer.valueOf(GuildMessageManager$1.this.f230096f));
                    Map<String, Boolean> refreshActionMap2 = GuildMessageManager$1.this.this$0.f116282e.getRefreshActionMap();
                    GuildMessageManager$1 guildMessageManager$12 = GuildMessageManager$1.this;
                    refreshActionMap2.remove(ao.f(guildMessageManager$12.f230095e, guildMessageManager$12.f230096f));
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshUnreadMessage() end");
        }
    }
}
