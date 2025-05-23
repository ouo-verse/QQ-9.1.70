package com.tencent.mobileqq.guild.navigatebar;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMessageNavigateInfo extends BaseMessageNavigateInfo {
    public String channelId;

    public boolean equals(Object obj) {
        GuildMessageNavigateInfo guildMessageNavigateInfo = (GuildMessageNavigateInfo) obj;
        String str = this.channelId;
        return str != null && str.equals(guildMessageNavigateInfo.channelId) && this.type == guildMessageNavigateInfo.type && this.shmsgseq == guildMessageNavigateInfo.shmsgseq && this.msgseq == guildMessageNavigateInfo.msgseq;
    }

    public String toString() {
        return "GuildMessageNavigateInfo{troopCode='" + this.channelId + ", type=" + this.type + ", shmsgseq=" + this.shmsgseq + ", msgseq=" + this.msgseq + ", status=" + this.status + '}';
    }

    public synchronized void updateDB(final EntityManager entityManager) {
        if (entityManager == null) {
            return;
        }
        final GuildMessageNavigateInfo guildMessageNavigateInfo = (GuildMessageNavigateInfo) deepCopyByReflect();
        this.status = BaseMessageNavigateInfo.STATUS_NORMAL;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.navigatebar.GuildMessageNavigateInfo.1
            @Override // java.lang.Runnable
            public void run() {
                GuildMessageNavigateInfo.updateDB(entityManager, guildMessageNavigateInfo);
            }
        }, 32, null, false);
    }

    static void updateDB(EntityManager entityManager, GuildMessageNavigateInfo guildMessageNavigateInfo) {
        int i3 = guildMessageNavigateInfo.status;
        if (i3 == BaseMessageNavigateInfo.STATUS_ADD) {
            entityManager.persistOrReplace(guildMessageNavigateInfo);
        } else if (i3 == BaseMessageNavigateInfo.STATUS_MODIFY) {
            entityManager.update(guildMessageNavigateInfo);
        } else if (i3 == BaseMessageNavigateInfo.STATUS_DELETE) {
            entityManager.remove(guildMessageNavigateInfo);
        }
    }
}
