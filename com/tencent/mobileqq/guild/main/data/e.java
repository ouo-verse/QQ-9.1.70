package com.tencent.mobileqq.guild.main.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class e extends d {
    protected a C;
    public long D = 0;
    public long E = 0;
    public int F = 0;
    public boolean G;
    public GuildSummaryUIData H;
    private final boolean I;
    private final boolean J;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a implements Cloneable {
        private int C;
        private IGProChannelInfo D;
        private int E;
        private int F;
        private String G;
        private long H;
        private int I;

        /* renamed from: d, reason: collision with root package name */
        private String f227159d;

        /* renamed from: e, reason: collision with root package name */
        private String f227160e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f227161f;

        /* renamed from: h, reason: collision with root package name */
        private int f227162h;

        /* renamed from: i, reason: collision with root package name */
        private int f227163i;

        /* renamed from: m, reason: collision with root package name */
        private int f227164m;

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f227159d = this.f227159d;
            aVar.f227160e = this.f227160e;
            aVar.f227161f = this.f227161f;
            aVar.f227164m = this.f227164m;
            aVar.C = this.C;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            return aVar;
        }

        public String d() {
            return this.f227160e;
        }

        public String e() {
            return this.f227159d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f227162h == aVar.f227162h && this.f227163i == aVar.f227163i && this.f227164m == aVar.f227164m && this.C == aVar.C && this.E == aVar.E && this.F == aVar.F && this.H == aVar.H && Objects.equals(this.f227159d, aVar.f227159d) && Objects.equals(this.f227160e, aVar.f227160e) && Objects.equals(this.f227161f, aVar.f227161f) && Objects.equals(this.G, aVar.G) && Objects.equals(Integer.valueOf(this.I), Integer.valueOf(aVar.I))) {
                return true;
            }
            return false;
        }

        public void f(IGProChannelInfo iGProChannelInfo) {
            this.f227162h = iGProChannelInfo.getType();
            this.f227163i = iGProChannelInfo.getOperationType();
            this.f227159d = iGProChannelInfo.getGuildId();
            this.f227160e = iGProChannelInfo.getChannelUin();
            this.f227161f = iGProChannelInfo.getChannelName();
            this.f227164m = iGProChannelInfo.getChannelMemberMax();
            this.C = iGProChannelInfo.getNoMemberMaxLimited();
            this.D = iGProChannelInfo;
            this.E = iGProChannelInfo.getTextChannelSubtypeId();
            this.F = iGProChannelInfo.getAppChannelJumpType();
            this.G = iGProChannelInfo.getAppChannelJumpUrl();
            this.H = iGProChannelInfo.getApplicationId();
            this.I = iGProChannelInfo.getFinalMsgNotify();
        }

        public int hashCode() {
            return Objects.hash(this.f227159d, this.f227160e, this.f227161f, Integer.valueOf(this.f227162h), Integer.valueOf(this.f227163i), Integer.valueOf(this.f227164m), Integer.valueOf(this.C), Integer.valueOf(this.E), Integer.valueOf(this.F), this.G, Long.valueOf(this.H), Integer.valueOf(this.I));
        }

        public String toString() {
            return "ChannelUIData{guildId='" + this.f227159d + "', channelUin='" + this.f227160e + "', channelName='" + this.f227161f + "', type=" + this.f227162h + ", secondType=" + this.f227163i + ", mChannelMaxMember=" + this.f227164m + ", mNoMemberMaxLimited=" + this.C + ", textChannelSubtypeId=" + this.E + ", appChannelJumpType=" + this.F + ", appChannelJumpUrl=" + this.G + ", appId=" + this.H + ", finalMsgNotify=" + this.I + '}';
        }
    }

    public e(@NonNull c cVar, boolean z16, boolean z17) {
        boolean z18 = false;
        c(cVar);
        this.I = z16;
        if (z17 && !cVar.d()) {
            z18 = true;
        }
        this.J = z18;
        a aVar = new a();
        this.C = aVar;
        aVar.f(cVar.c());
        this.f227157i = cVar.e();
        this.G = ((IGPSService) ch.S0(IGPSService.class, "")).isQQMsgListChannel(this.C.e(), this.C.d());
        k(cVar.c());
    }

    private GuildSummaryData j() {
        IGuildSummaryApi iGuildSummaryApi = (IGuildSummaryApi) ch.S0(IGuildSummaryApi.class, "");
        if (ch.j0(this.C.e())) {
            return iGuildSummaryApi.getGuestSummary(this.C.e(), this.C.d());
        }
        return iGuildSummaryApi.getSummary(this.C.e(), this.C.d(), false);
    }

    private void k(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo != null) {
            if (this.I || this.J) {
                m(j());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.main.data.d
    @NonNull
    /* renamed from: a */
    public d clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        GuildSummaryUIData guildSummaryUIData = this.H;
        if (guildSummaryUIData != null) {
            eVar.H = guildSummaryUIData.a();
        }
        eVar.C = h().clone();
        return eVar;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public boolean b() {
        if (this.D > 0) {
            return true;
        }
        long j3 = this.E;
        if (j3 > 0 && this.F == 1) {
            return true;
        }
        if (j3 > 0 && this.F == 2) {
            return true;
        }
        return false;
    }

    public abstract boolean d(e eVar);

    public boolean e(e eVar) {
        if (Objects.equals(this.C, eVar.C) && this.G == eVar.G && d(eVar)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e) || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        if (e(eVar) && f(eVar)) {
            return true;
        }
        return false;
    }

    public boolean f(e eVar) {
        if (this.D == eVar.D && this.E == eVar.E && this.F == eVar.F && Objects.equals(this.H, eVar.H)) {
            return true;
        }
        return false;
    }

    public a h() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.C, Long.valueOf(this.D), Long.valueOf(this.E), Integer.valueOf(this.F), Boolean.valueOf(this.G));
    }

    public String i() {
        return this.C.e();
    }

    public Boolean l(long j3, UnreadInfo unreadInfo) {
        boolean z16;
        if (j3 > 0 && unreadInfo != null && unreadInfo.d().getUnreadType() > 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public void m(GuildSummaryData guildSummaryData) {
        String str;
        boolean z16;
        int j3;
        int i3;
        UnreadInfo unreadInfo = guildSummaryData.getUnreadInfo();
        if (this.J && unreadInfo != null) {
            if (this.C.f227162h == 6 && this.C.H == 1000050) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j3 = unreadInfo.i();
            } else {
                j3 = unreadInfo.j();
            }
            this.E = j3;
            this.D = unreadInfo.getRelatedToMeCnt();
            if (this.E == 0) {
                this.F = 0;
            } else if (z16) {
                if (unreadInfo.k()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                this.F = i3;
            } else {
                this.F = unreadInfo.d().getUnreadType();
            }
        }
        if (this.I) {
            Object obj = "99+";
            if (l(this.E, unreadInfo).booleanValue() && (this.C.f227162h == 1 || this.C.H == 1000137)) {
                String qqStr = HardCodeUtil.qqStr(R.string.f157461mz);
                Object[] objArr = new Object[1];
                long j16 = this.E;
                if (j16 <= 99) {
                    obj = Long.valueOf(j16);
                }
                objArr[0] = obj;
                str = String.format(qqStr, objArr);
            } else if (l(this.E, unreadInfo).booleanValue() && this.C.f227162h == 7) {
                String qqStr2 = HardCodeUtil.qqStr(R.string.f157451my);
                Object[] objArr2 = new Object[1];
                long j17 = this.E;
                if (j17 <= 99) {
                    obj = Long.valueOf(j17);
                }
                objArr2[0] = obj;
                str = String.format(qqStr2, objArr2);
            } else {
                str = "";
            }
            this.H = com.tencent.mobileqq.guild.summary.c.a(guildSummaryData.getLastMessage(), guildSummaryData.getUnreadInfo(), guildSummaryData.getDraftInfo(), str);
        }
    }

    public String toString() {
        return "QQChannelNormalItemData{mChannelUIData=" + this.C + ", mSummaryUIDataNew=" + this.H + ", aboutMeMsgCnt=" + this.D + ", msgCnt=" + this.E + ", msgShowType=" + this.F + ", mIsInMsgTab" + this.G + "} " + super.toString();
    }
}
