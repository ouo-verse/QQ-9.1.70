package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends k {

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private a f227420e;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f227421a;

        /* renamed from: b, reason: collision with root package name */
        public String f227422b;

        public a(int i3, String str) {
            this.f227421a = i3;
            this.f227422b = str;
        }

        public boolean equals(Object obj) {
            String str;
            a aVar;
            String str2;
            if (!(obj instanceof a) || (str = this.f227422b) == null || (str2 = (aVar = (a) obj).f227422b) == null || this.f227421a != aVar.f227421a || !str.equals(str2)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "SelItem{selType=" + this.f227421a + ", selKey='" + this.f227422b + "'}";
        }
    }

    public c(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227420e = new a(-1, "");
    }

    public static c k(@NonNull com.tencent.mobileqq.guild.mainframe.i iVar) {
        return (c) iVar.getHelper(GuildMainFrameConstants.f227259c);
    }

    private p l(List<p> list, int i3, String str) {
        if (i3 == -1) {
            return null;
        }
        for (p pVar : list) {
            if (i3 == pVar.f226295d && TextUtils.equals(str, pVar.f226296e)) {
                return pVar;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        if (z16) {
            this.f227420e = new a(-1, "");
            QLog.d("Guild.C2C.GuildInboxSelectHelper", 1, "onAfterAccountChanged account changed");
        }
    }

    public LaunchGuildChatPieParam i(p pVar) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        return new LaunchGuildChatPieParam().l(pVar.f226296e).b(pVar.f226297f).r(true).o(2).g(5).k(bundle).a();
    }

    public a j() {
        return this.f227420e;
    }

    public void m(List<p> list) {
        a aVar = this.f227420e;
        int i3 = aVar.f227421a;
        String str = aVar.f227422b;
        p l3 = l(list, i3, str);
        GuildCenterPanelController Z0 = this.f227466d.Z0();
        if (l3 == null) {
            Z0.r();
            QLog.w("Guild.C2C.GuildInboxSelectHelper", 1, "openCenterPanel failed " + str + " size:" + list.size());
            return;
        }
        n(l3);
    }

    public boolean n(p pVar) {
        GuildCenterPanelController Z0 = this.f227466d.Z0();
        if (pVar.f226295d == 1) {
            if (TextUtils.equals(pVar.f226296e, String.valueOf(6))) {
                Z0.F(4, null);
            } else if (TextUtils.equals(pVar.f226296e, String.valueOf(7))) {
                Z0.F(7, null);
            } else if (TextUtils.equals(pVar.f226296e, String.valueOf(5))) {
                Z0.F(10, null);
            }
            Z0.y(2);
            return true;
        }
        return GuildMainFrameUtils.r(this.f227466d.getActivity(), 6, i(pVar));
    }

    public void o(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.GuildInboxSelectHelper", 1, "setCurSelectInboxItem from " + this.f227420e.toString());
        }
        a aVar = this.f227420e;
        aVar.f227421a = i3;
        aVar.f227422b = str;
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.GuildInboxSelectHelper", 1, "setCurSelectInboxItem to " + this.f227420e.toString());
        }
    }

    public void p(List<p> list, boolean z16, boolean z17) {
        if (!z16) {
            QLog.d("Guild.C2C.GuildInboxSelectHelper", 1, "updateSelectItem inbox is hide");
            return;
        }
        if (list.isEmpty()) {
            o(-1, "");
            this.f227466d.Z0().r();
            QLog.i("Guild.C2C.GuildInboxSelectHelper", 1, "updateSelectItem inbox list is empty");
            return;
        }
        a aVar = this.f227420e;
        int i3 = aVar.f227421a;
        String str = aVar.f227422b;
        if (l(list, i3, str) != null) {
            if (z17) {
                this.f227466d.Z0().r();
                QLog.w("Guild.C2C.GuildInboxSelectHelper", 1, "updateSelectItem close center panel guildId" + str + " curSelGuildId=" + this.f227466d.Z0().u());
            }
            QLog.i("Guild.C2C.GuildInboxSelectHelper", 1, "updateSelectItem find last select item forceJump=" + z17 + " [type=" + i3 + " id=" + str + "]");
            return;
        }
        QLog.w("Guild.C2C.GuildInboxSelectHelper", 1, "updateSelectItem close center panel guildId" + str + " curSelGuildId=" + this.f227466d.Z0().u() + " dataList=" + list.size());
        this.f227466d.Z0().r();
    }
}
