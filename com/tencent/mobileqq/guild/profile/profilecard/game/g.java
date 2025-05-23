package com.tencent.mobileqq.guild.profile.profilecard.game;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.de;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory E = new a();
    private MutableLiveData<h> C;
    private MutableLiveData<com.tencent.mobileqq.guild.profile.profilecard.game.a> D;

    /* renamed from: i, reason: collision with root package name */
    private GuildBaseProfileData f231429i;

    /* renamed from: m, reason: collision with root package name */
    private ev f231430m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new g(new wy1.a());
        }
    }

    public g(wy1.a aVar) {
        super(aVar);
        this.f231429i = new GuildBaseProfileData();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
    }

    private void L1(IGProClientPresenceInfo iGProClientPresenceInfo, StringBuilder sb5) {
        String details = iGProClientPresenceInfo.getDetails();
        if (!TextUtils.isEmpty(details)) {
            if (sb5.length() > 0) {
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
            }
            sb5.append(details);
        }
        long partySize = iGProClientPresenceInfo.getPartySize();
        long partyMax = iGProClientPresenceInfo.getPartyMax();
        if (partySize > 0 && partyMax > 0 && partySize <= partyMax) {
            sb5.append("(");
            sb5.append(partySize);
            sb5.append("/");
            sb5.append(partyMax);
            sb5.append(")");
        }
    }

    private void M1(IGProClientPresenceInfo iGProClientPresenceInfo, StringBuilder sb5) {
        String role = iGProClientPresenceInfo.getRole();
        if (TextUtils.isEmpty(role)) {
            return;
        }
        if (sb5.length() > 0) {
            sb5.append(APLogFileUtil.SEPARATOR_LOG);
        }
        sb5.append(role);
    }

    private void N1(IGProClientPresenceInfo iGProClientPresenceInfo, StringBuilder sb5) {
        String state = iGProClientPresenceInfo.getState();
        if (TextUtils.isEmpty(state)) {
            return;
        }
        sb5.append(state);
        long startTimeStamp = iGProClientPresenceInfo.getStartTimeStamp() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (startTimeStamp > 0 && currentTimeMillis >= startTimeStamp) {
            long j3 = ((currentTimeMillis - startTimeStamp) / 1000) / 60;
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildProfileGameViewModel", 1, String.format("minutes is : %s, startTime: %s, curTime: %s", Long.valueOf(j3), en.i(startTimeStamp), en.i(currentTimeMillis)));
            }
            if (j3 >= 0) {
                sb5.append(j3);
                sb5.append("\u5206\u949f");
            }
        }
    }

    private void O1() {
        xh2.c j3 = this.f231430m.j();
        boolean l3 = this.f231430m.l();
        if (j3 != null && j3.getClientId() > 0) {
            if (j3.a() == null) {
                QLog.w("Guild.profile.GuildProfileGameViewModel", 1, "archiveArkData.getArkArgs is null");
                return;
            }
            de a16 = j3.a();
            if (!TextUtils.isEmpty(a16.getApp()) && !TextUtils.isEmpty(a16.getView()) && !TextUtils.isEmpty(a16.a()) && !TextUtils.isEmpty(a16.getConfig())) {
                com.tencent.mobileqq.guild.profile.profilecard.game.a value = this.D.getValue();
                if (value != null && value.a().getClientId() == j3.getClientId()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Guild.profile.GuildProfileGameViewModel", 2, String.format("same archiveArk clientId(%s) don't update!", Integer.valueOf(j3.getClientId())));
                        return;
                    }
                    return;
                }
                this.D.setValue(new com.tencent.mobileqq.guild.profile.profilecard.game.a(j3, l3));
                return;
            }
            QLog.w("Guild.profile.GuildProfileGameViewModel", 1, String.format("archiveArkData arkArgs invalid %s, %s, %s, %s: ", a16.getApp(), a16.getView(), a16.a(), a16.getConfig()));
            return;
        }
        QLog.e("Guild.profile.GuildProfileGameViewModel", 1, "archiveArkData is invalid");
        this.D.setValue(null);
    }

    private void P1() {
        boolean z16;
        IGProClientPresenceInfo clientPresence = this.f231430m.getClientPresence();
        boolean z17 = true;
        if (clientPresence == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.profile.GuildProfileGameViewModel", 1, "IGProClientPresenceInfo is null");
            }
            this.C.setValue(null);
            return;
        }
        int clientId = clientPresence.getClientId();
        if (clientId <= 0) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.profile.GuildProfileGameViewModel", 1, "clientId invalid : " + clientId);
            }
            this.C.setValue(null);
            return;
        }
        h hVar = new h();
        String bigIcon = clientPresence.getBigIcon();
        if (!TextUtils.isEmpty(bigIcon)) {
            hVar.d(bigIcon);
            z16 = true;
        } else {
            z16 = false;
        }
        String clientName = clientPresence.getClientName();
        if (!TextUtils.isEmpty(clientName)) {
            hVar.e(clientName);
            z16 = true;
        }
        StringBuilder sb5 = new StringBuilder();
        N1(clientPresence, sb5);
        L1(clientPresence, sb5);
        M1(clientPresence, sb5);
        if (sb5.length() > 0) {
            hVar.f(sb5.toString());
        } else {
            z17 = z16;
        }
        if (z17) {
            this.C.setValue(hVar);
        }
    }

    public void Q1(GuildProfileData guildProfileData) {
        String str;
        this.f231430m = guildProfileData.getUserProfileInfo();
        this.f231429i = guildProfileData.getGuildBaseProfileData();
        P1();
        O1();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("init profileData, guildId ");
            GuildBaseProfileData guildBaseProfileData = this.f231429i;
            if (guildBaseProfileData != null) {
                str = guildBaseProfileData.e();
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.d("Guild.profile.GuildProfileGameViewModel", 1, sb5.toString());
        }
    }

    public MutableLiveData<com.tencent.mobileqq.guild.profile.profilecard.game.a> R1() {
        return this.D;
    }

    public MutableLiveData<h> S1() {
        return this.C;
    }

    public GuildBaseProfileData getGuildBaseProfileData() {
        return this.f231429i;
    }
}
