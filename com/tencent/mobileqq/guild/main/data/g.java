package com.tencent.mobileqq.guild.main.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.main.view.GuildVoiceAvatarFrameView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends e {
    private int K;
    private int L;
    private List<GuildVoiceAvatarFrameView.a> M;
    private List<GuildVoiceAvatarFrameView.a> N;

    @Override // com.tencent.mobileqq.guild.main.data.e
    public boolean d(e eVar) {
        if (!(eVar instanceof g)) {
            return false;
        }
        g gVar = (g) eVar;
        if (this.L != gVar.L || this.K != gVar.K || !Objects.equals(this.M, gVar.M) || !Objects.equals(this.N, gVar.N)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g) || !super.equals(obj)) {
            return false;
        }
        return d((g) obj);
    }

    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.L), this.M, this.N);
    }

    @Override // com.tencent.mobileqq.guild.main.data.e
    public String i() {
        return this.C.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.main.data.e, com.tencent.mobileqq.guild.main.data.d
    @NonNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g clone() throws CloneNotSupportedException {
        g gVar = (g) super.clone();
        gVar.K = this.K;
        gVar.L = this.L;
        gVar.M = new ArrayList(this.M);
        gVar.N = new ArrayList(this.N);
        return gVar;
    }

    public int o() {
        return this.K;
    }

    @Override // com.tencent.mobileqq.guild.main.data.e
    public String toString() {
        return "QQGuildChannelVoice{channelState=" + this.K + ", memberCount=" + this.L + ", voicingMemberList=" + this.M + ", audienceMemberList=" + this.N + "} " + super.toString();
    }
}
