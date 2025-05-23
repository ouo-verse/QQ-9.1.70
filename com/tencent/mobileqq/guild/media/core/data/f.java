package com.tencent.mobileqq.guild.media.core.data;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends p {
    public String P = "";
    public String Q = "";
    public volatile boolean R = false;
    public int S = -1;
    public int T = 0;

    @Deprecated
    public int U = 2;

    @Override // com.tencent.mobileqq.guild.media.core.data.p
    public void b() {
        super.b();
        this.P = "";
        this.Q = "";
        this.R = false;
        this.S = -1;
        this.T = 0;
        this.U = 2;
    }

    @Override // com.tencent.mobileqq.guild.media.core.data.p
    public void e(p pVar) {
        super.e(pVar);
        if (pVar instanceof f) {
            f fVar = (f) pVar;
            this.P = fVar.P;
            this.Q = fVar.Q;
            this.R = fVar.R;
            this.S = fVar.S;
            this.T = fVar.T;
            this.U = fVar.U;
            this.D = fVar.D;
        }
    }

    public void p() {
        super.b();
        this.R = false;
        this.S = -1;
        this.T = 0;
        this.U = 2;
    }

    @Override // com.tencent.mobileqq.guild.media.core.data.p
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public f c() {
        f fVar = new f();
        fVar.e(this);
        return fVar;
    }

    @Override // com.tencent.mobileqq.guild.media.core.data.p
    public String toString() {
        return "LocalUserInfo{id='" + this.f228093a + "', userType=" + this.f228097e + "\uff0cgroupType=" + this.f228099g + ", isMicOn=" + this.f228101i + ", volume=" + this.f228109q + ", muteToMe=" + this.f228112t + ", globalMute=" + this.f228113u + ", guildId=" + this.P + ", channelId=" + this.Q + ", isInRoom=" + this.R + ", audioRoute=" + this.S + ", memberNumMax=" + this.T + ", screenShareBtnStatus=" + this.U + ", phoneBusy=" + this.B + ", videoOn=" + this.f228103k + '}';
    }
}
