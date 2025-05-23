package cs1;

import com.tencent.mobileqq.guild.config.r;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends b {
    public IGuildUnreadCntService.b E;
    public String F;
    public r G;
    public boolean H;

    public e(IGProGuildInfo iGProGuildInfo, List<String> list) {
        super(1, iGProGuildInfo.getGuildID());
        p(iGProGuildInfo, list);
    }

    private boolean n(e eVar) {
        IGuildUnreadCntService.b bVar = this.E;
        int i3 = bVar.f230841e;
        IGuildUnreadCntService.b bVar2 = eVar.E;
        if (i3 != bVar2.f230841e) {
            return false;
        }
        if (i3 == 2) {
            long j3 = bVar.f230840d;
            long j16 = bVar2.f230840d;
            if (j3 != j16 && (j3 == 0 || j16 == 0)) {
                return false;
            }
        }
        if (i3 == 1) {
            long j17 = bVar.f230840d;
            long j18 = bVar2.f230840d;
            if (j17 != j18 && (j17 < 100 || j18 < 100)) {
                return false;
            }
        }
        return true;
    }

    private boolean o(e eVar) {
        if (Objects.equals(this.F, eVar.F) && Objects.equals(this.G, eVar.G) && this.H == eVar.H) {
            return true;
        }
        return false;
    }

    @Override // cs1.b
    public List<Integer> e(b bVar) {
        if (!(bVar instanceof e)) {
            return new ArrayList();
        }
        e eVar = (e) bVar;
        if (o(eVar)) {
            List<Integer> e16 = super.e(eVar);
            if (!n(eVar)) {
                e16.add(2);
            }
            return e16;
        }
        return new ArrayList();
    }

    @Override // cs1.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e) || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        if (!n(eVar)) {
            return false;
        }
        return o(eVar);
    }

    @Override // cs1.b
    public int f() {
        if (this.H) {
            return GuildMainFrameConstants.f227272p;
        }
        return GuildMainFrameConstants.f227273q;
    }

    @Override // cs1.b
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.E, this.F, this.G);
    }

    @Override // cs1.b
    public void m() {
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        p(iGPSService.getGuildInfo(this.f391796e), iGPSService.getTopGuildList());
    }

    public void p(IGProGuildInfo iGProGuildInfo, List<String> list) {
        boolean z16;
        int i3 = 2;
        if (iGProGuildInfo != null) {
            this.C = iGProGuildInfo.getAvatarUrl(140);
            this.F = iGProGuildInfo.getGuildName();
            this.f391797f = iGProGuildInfo.getIsBanned();
            if (iGProGuildInfo.getUserType() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f391798h = z16;
            q(list);
            if (this.f391797f) {
                QLog.d("Guild.MF.Lt.GuildListItemBuilder", 1, "isGuildBanned guildId=" + this.f391796e);
            }
        } else {
            QLog.w("Guild.MF.Lt.GuildListItemBuilder", 1, "updateItemData error guildId=" + this.f391796e);
        }
        UnreadInfo.a guildUnreadCount = ((IGuildUnreadService) ch.R0(IGuildUnreadService.class)).getGuildUnreadCount(this.f391796e);
        long count = guildUnreadCount.getCount();
        if (guildUnreadCount.getIsStrongUnread()) {
            i3 = 1;
        }
        this.E = new IGuildUnreadCntService.b(count, i3);
        this.G = ds1.a.e(this.f391796e);
    }

    public void q(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.H = list.contains(this.f391796e);
        } else {
            this.H = false;
        }
    }

    @Override // cs1.b
    public String toString() {
        return "GuildLeftBarNormalUIData{ itemType=" + this.f391795d + ", guildId='" + this.f391796e + "', cntInfo=" + this.E + ", isTopGuild=" + this.H + ", guildStateIconInfo=" + this.G + ", headDrawableId=" + this.f391800m + ", headAvatarUrl='" + this.C + "', extra=" + this.f391799i + '}';
    }
}
