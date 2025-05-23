package com.tencent.mobileqq.guild.main.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import java.io.Serializable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildChannelLive extends e {

    @NonNull
    private a K;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class LiveProgramInfo implements Cloneable, Serializable {
        private String anchorName;
        private String liveTitle;
        private String programId;
        private long tabId;
        private String thirdPartyLogo;

        public static LiveProgramInfo parse(ILiveProgramInfo iLiveProgramInfo) {
            LiveProgramInfo liveProgramInfo = new LiveProgramInfo();
            liveProgramInfo.programId = iLiveProgramInfo.getProgramId();
            liveProgramInfo.liveTitle = iLiveProgramInfo.getLiveTitle();
            liveProgramInfo.anchorName = iLiveProgramInfo.getAnchorName();
            liveProgramInfo.thirdPartyLogo = iLiveProgramInfo.getThirdPartyLogo();
            liveProgramInfo.tabId = iLiveProgramInfo.getTabId();
            return liveProgramInfo;
        }

        public String getAnchorName() {
            return this.anchorName;
        }

        public String getLiveTitle() {
            return this.liveTitle;
        }

        public String getProgramId() {
            return this.programId;
        }

        public long getTabId() {
            return this.tabId;
        }

        public String getThirdPartyLogo() {
            return this.thirdPartyLogo;
        }

        public boolean isValid() {
            String str = this.programId;
            if (str != null && !str.isEmpty() && !"0".equals(this.programId)) {
                return true;
            }
            return false;
        }

        public void setAnchorName(String str) {
            this.anchorName = str;
        }

        public void setLiveTitle(String str) {
            this.liveTitle = str;
        }

        public void setProgramId(String str) {
            this.programId = str;
        }

        public void setTabId(long j3) {
            this.tabId = j3;
        }

        public void setThirdPartyLogo(String str) {
            this.thirdPartyLogo = str;
        }

        @NonNull
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public LiveProgramInfo m188clone() throws CloneNotSupportedException {
            LiveProgramInfo liveProgramInfo = (LiveProgramInfo) super.clone();
            liveProgramInfo.programId = this.programId;
            liveProgramInfo.liveTitle = this.liveTitle;
            liveProgramInfo.anchorName = this.anchorName;
            liveProgramInfo.thirdPartyLogo = this.thirdPartyLogo;
            liveProgramInfo.tabId = this.tabId;
            return liveProgramInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a implements Cloneable {
        private String C;
        private String D;
        private int E;
        private LiveProgramInfo F;
        private int G;
        private String H;
        private String I;
        private String J;

        /* renamed from: d, reason: collision with root package name */
        private String f227140d;

        /* renamed from: e, reason: collision with root package name */
        private String f227141e;

        /* renamed from: f, reason: collision with root package name */
        private String f227142f;

        /* renamed from: h, reason: collision with root package name */
        private String f227143h;

        /* renamed from: i, reason: collision with root package name */
        private long f227144i;

        /* renamed from: m, reason: collision with root package name */
        private String f227145m;

        public a() {
        }

        private void o(ILiveRoomInfo iLiveRoomInfo) {
            this.f227140d = iLiveRoomInfo.getQueryId();
            this.f227141e = iLiveRoomInfo.getRoomId();
            this.f227142f = iLiveRoomInfo.getProgramId();
            this.f227143h = iLiveRoomInfo.getRoomTitle();
            this.f227144i = iLiveRoomInfo.getViewer();
            this.C = iLiveRoomInfo.getLiveStreamUrl();
            this.D = iLiveRoomInfo.getLiveStreamFlvUrl();
            this.E = iLiveRoomInfo.getLiveTypeNum();
            this.G = iLiveRoomInfo.getPlatform();
            if (iLiveRoomInfo.getAnchorInfo() != null) {
                this.f227145m = iLiveRoomInfo.getAnchorInfo().getAnchorName();
                this.I = iLiveRoomInfo.getAnchorInfo().getAnchorTinyId();
                this.J = iLiveRoomInfo.getAnchorInfo().getAnchorAvatarMeta();
            }
            this.F = LiveProgramInfo.parse(iLiveRoomInfo.getProgramInfo());
            this.H = iLiveRoomInfo.getRoomPv();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a clone() throws CloneNotSupportedException {
            LiveProgramInfo m188clone;
            a aVar = (a) super.clone();
            aVar.f227140d = this.f227140d;
            aVar.f227141e = this.f227141e;
            aVar.f227145m = this.f227145m;
            aVar.f227142f = this.f227142f;
            aVar.f227143h = this.f227143h;
            aVar.f227144i = this.f227144i;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            LiveProgramInfo liveProgramInfo = this.F;
            if (liveProgramInfo == null) {
                m188clone = null;
            } else {
                m188clone = liveProgramInfo.m188clone();
            }
            aVar.F = m188clone;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            return aVar;
        }

        public String c() {
            return this.f227145m;
        }

        public LiveProgramInfo d() {
            return this.F;
        }

        public int e() {
            return this.E;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f227144i == aVar.f227144i && Objects.equals(this.f227140d, aVar.f227140d) && Objects.equals(this.f227141e, aVar.f227141e) && Objects.equals(this.f227142f, aVar.f227142f) && Objects.equals(this.f227143h, aVar.f227143h) && Objects.equals(this.f227145m, aVar.f227145m) && Objects.equals(Integer.valueOf(this.E), Integer.valueOf(aVar.E))) {
                return true;
            }
            return false;
        }

        public int f() {
            return this.G;
        }

        public String h() {
            return this.f227142f;
        }

        public int hashCode() {
            return Objects.hash(this.f227140d, this.f227141e, this.f227142f, this.f227143h, Long.valueOf(this.f227144i), this.f227145m, Integer.valueOf(this.E));
        }

        public String i() {
            return this.f227140d;
        }

        public String j() {
            return this.f227141e;
        }

        public String k() {
            return this.f227143h;
        }

        public String l() {
            return this.D;
        }

        public String m() {
            return this.C;
        }

        public long n() {
            return this.f227144i;
        }

        public String toString() {
            return "LiveRoomInfoUIData{mQueryId='" + this.f227140d + "', mRoomId='" + this.f227141e + "', mProgramId='" + this.f227142f + "', mRoomTitle='" + this.f227143h + "', mViewer=" + this.f227144i + ", mAnchorName='" + this.f227145m + "', mStreamUrl='" + this.C + "', mStreamFlvUrl='" + this.D + "', mLiveType='" + this.E + "', mPlatform='" + this.G + "', mRoomPv='" + this.H + "', mAnchorTinyId='" + this.I + "', mAnchorAvatarMeta='" + this.J + "'}";
        }

        public a(ILiveRoomInfo iLiveRoomInfo) {
            if (iLiveRoomInfo != null) {
                o(iLiveRoomInfo);
            }
        }
    }

    public QQGuildChannelLive(@NonNull c cVar) {
        super(cVar, true, false);
        this.K = new a();
        r(((IGPSService) ch.S0(IGPSService.class, "")).getPollingChannelOfLive(i(), o()));
    }

    @Override // com.tencent.mobileqq.guild.main.data.e
    public boolean d(e eVar) {
        if (!(eVar instanceof QQGuildChannelLive)) {
            return false;
        }
        return Objects.equals(this.K, ((QQGuildChannelLive) eVar).K);
    }

    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQGuildChannelLive) || !super.equals(obj)) {
            return false;
        }
        return d((QQGuildChannelLive) obj);
    }

    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.K);
    }

    @Override // com.tencent.mobileqq.guild.main.data.e
    public String i() {
        return this.C.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    @NonNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public QQGuildChannelLive clone() throws CloneNotSupportedException {
        QQGuildChannelLive qQGuildChannelLive = (QQGuildChannelLive) super.clone();
        qQGuildChannelLive.K = this.K.clone();
        return qQGuildChannelLive;
    }

    public String o() {
        return this.C.d();
    }

    public a p() {
        return this.K;
    }

    public Boolean q() {
        boolean z16;
        if (!TextUtils.isEmpty(this.K.f227141e) && !"0".equals(this.K.f227141e)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public void r(ILiveRoomInfo iLiveRoomInfo) {
        if (iLiveRoomInfo == null) {
            this.K = new a();
        } else {
            this.K = new a(iLiveRoomInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.main.data.e
    public String toString() {
        return "QQGuildChannelLive{roomInfo=" + this.K + "} " + super.toString();
    }
}
