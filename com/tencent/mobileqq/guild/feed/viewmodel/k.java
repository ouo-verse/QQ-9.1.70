package com.tencent.mobileqq.guild.feed.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.manager.info.GuildInfoField;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class k extends BaseViewModel {
    private MutableLiveData<String> C;
    private MutableLiveData<Long> D;
    private MutableLiveData<Long> E;
    private MutableLiveData<Boolean> F;
    private MutableLiveData<Boolean> G;
    private MutableLiveData<Boolean> H;
    private MutableLiveData<Boolean> I;
    private MutableLiveData<IGProGuildInfo> J = new MutableLiveData<>();
    private String K;
    private String L;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<Boolean> f224055i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Boolean> f224056m;

    private long S1() {
        long longValue;
        long j3 = 0;
        if (this.D.getValue() == null) {
            longValue = 0;
        } else {
            longValue = this.D.getValue().longValue();
        }
        if (this.E.getValue() != null) {
            j3 = this.E.getValue().longValue();
        }
        return Math.max(longValue, j3);
    }

    private boolean a2() {
        if (this.K != null && GuildInfoManager.q().P(this.K) && N1()) {
            return true;
        }
        return false;
    }

    public MutableLiveData<Long> L1() {
        return this.E;
    }

    public MutableLiveData<String> M1() {
        return this.C;
    }

    public boolean N1() {
        if (this.G.getValue() != null && this.G.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public MutableLiveData<Boolean> O1() {
        return this.G;
    }

    public boolean P1() {
        if (this.H.getValue() != null && this.H.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public MutableLiveData<Boolean> Q1() {
        return this.H;
    }

    public MutableLiveData<Boolean> R1() {
        return this.I;
    }

    public MutableLiveData<Long> T1() {
        return this.D;
    }

    public MutableLiveData<Boolean> U1() {
        return this.F;
    }

    public void W1(String str, String str2) {
        if (!TextUtils.isEmpty(this.K) && this.K.equals(str2)) {
            return;
        }
        this.K = str2;
        this.L = str;
        this.f224055i = jj1.b.c().b(GuildInfoField.IS_DISTURB, Boolean.class, this.K);
        this.f224056m = jj1.b.c().b(GuildInfoField.IS_PRIVATE_CHANNEL, Boolean.class, this.K);
        this.C = jj1.b.c().b(GuildInfoField.CHANNEL_NAME, String.class, this.K);
        this.D = jj1.b.c().b(GuildInfoField.USER_MUTE_TIME, Long.class, this.L);
        this.E = jj1.b.c().b(GuildInfoField.ALL_MUTE_TIME, Long.class, this.L);
        this.F = jj1.b.c().b(GuildInfoField.IS_RESTRICT_POST, Boolean.class, this.K);
        this.G = jj1.b.c().b(GuildInfoField.IS_MANAGER, Boolean.class, this.K);
        this.I = jj1.b.c().b(GuildInfoField.SPEAK_THRESHOLD_LIMITING, Boolean.class, this.K);
        this.H = jj1.b.c().b(GuildInfoField.IS_MEMBER, Boolean.class, this.L);
        this.J.setValue(ch.L(this.L));
    }

    public void X1(String str) {
        QLog.e("GuildAuthorityInfoViewModel", 1, "initViewModel guildId=" + str);
        this.L = str;
        this.K = "";
        this.D = jj1.b.c().b(GuildInfoField.USER_MUTE_TIME, Long.class, this.L);
        this.E = jj1.b.c().b(GuildInfoField.ALL_MUTE_TIME, Long.class, this.L);
        this.G = jj1.b.c().b(GuildInfoField.IS_MANAGER, Boolean.class, this.L);
        this.I = jj1.b.c().b(GuildInfoField.SPEAK_THRESHOLD_LIMITING, Boolean.class, this.L);
        this.H = jj1.b.c().b(GuildInfoField.IS_MEMBER, Boolean.class, this.L);
        this.F = jj1.b.c().b(GuildInfoField.IS_RESTRICT_POST, Boolean.class, this.L);
        GuildInfoManager.q().j0(this.L);
        GuildInfoManager.q().T(this.L);
        GuildInfoManager.q().Z(str, "");
        this.J.setValue(ch.L(this.L));
    }

    public void Z1(String str, String str2) {
        QLog.e("GuildAuthorityInfoViewModel", 1, "initViewModel guildId=" + str, ",channelId=" + str2);
        if (TextUtils.isEmpty(str2)) {
            QLog.e("GuildAuthorityInfoViewModel", 1, "channelId should not empty.");
            return;
        }
        W1(str, str2);
        GuildInfoManager.q().m(this.K);
        GuildInfoManager.q().T(this.L);
        GuildInfoManager.q().Z(str, str2);
    }

    public boolean b2() {
        boolean z16;
        boolean z17;
        if (a2()) {
            return false;
        }
        if (com.tencent.mobileqq.guild.setting.mute.c.O(Long.valueOf(S1())) && !com.tencent.mobileqq.guild.setting.mute.c.M(this.L)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.F.getValue() != null && this.F.getValue().booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GuildAuthorityInfoViewModel";
    }

    public void onDestroy() {
        GuildInfoManager.q().h0();
    }
}
