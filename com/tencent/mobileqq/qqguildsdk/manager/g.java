package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.GuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.util.h;
import com.tencent.mobileqq.qqguildsdk.util.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFaceAuthInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268464a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<AppRuntime> f268465b;

    /* renamed from: c, reason: collision with root package name */
    private final String f268466c;

    /* renamed from: d, reason: collision with root package name */
    private final GPServiceObserver f268467d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            g.this.w(iGProGuildInfo.getGuildID(), "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            g.this.w(str, "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            g.this.w(str, "");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeRoleMember(String str, List<IGProRoleMemberChange> list) {
            g.this.w(str, "");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(String str, String str2, int i3, List<String> list) {
            g.this.w(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            g.this.w("", str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            g.this.w(str, "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            if (hashSet == null) {
                return;
            }
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                g.this.w(str, it.next());
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onDeleteRole(String str, List<IGProGuildRoleInfo> list) {
            g.this.w(str, "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            g.this.w(str, "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(String str, dx dxVar) {
            g.this.w(str, "");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            g.this.w(str, "");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onSelfBannedSpeakChange(String str, String str2, String str3, int i3) {
            g.this.w(str, str2);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(String str, long j3) {
            g.this.w(str, "");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onSpeakableThresholdUpdate(List<String> list, List<fc> list2) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                g.this.w(it.next(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int i3, String str, String str2, String str3, ev evVar) {
            if (i3 == 0) {
                g.this.w(str2, "");
            }
        }
    }

    public g(AppRuntime appRuntime, GPSManagerEngine gPSManagerEngine) {
        a aVar = new a();
        this.f268467d = aVar;
        this.f268464a = gPSManagerEngine;
        this.f268465b = new WeakReference<>(appRuntime);
        this.f268466c = gPSManagerEngine.Rf();
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).addObserver(aVar);
    }

    private int b(IGProGuildInfo iGProGuildInfo, GProFaceAuthInfo gProFaceAuthInfo) {
        fc speakThreshold = iGProGuildInfo.getSpeakThreshold();
        long d16 = speakThreshold.d();
        long joinTime = iGProGuildInfo.getJoinTime();
        iGProGuildInfo.getGuildID();
        int faceAuthStatus = gProFaceAuthInfo.getFaceAuthStatus();
        if (speakThreshold.e() && !e(faceAuthStatus)) {
            return 2;
        }
        if (speakThreshold.d() != 0 && !d(d16, joinTime)) {
            return 4;
        }
        return 1;
    }

    private boolean c(String str) {
        IGProGuildInfo jl5 = this.f268464a.jl(str);
        if (jl5 == null) {
            return false;
        }
        if (jl5.getUserType() != 2 && jl5.getUserType() != 1) {
            return false;
        }
        return true;
    }

    private boolean d(long j3, long j16) {
        boolean z16 = true;
        if (!s(j3)) {
            h.k("SpeakLimitMgr", 1, "checkJoinTime", "invalid limitTime=" + j3);
            return true;
        }
        long j17 = j16 * 1000;
        long j18 = j3 * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long j19 = serverTimeMillis - j17;
        if (j19 <= j18) {
            z16 = false;
        }
        if (!z16) {
            x("checkJoinTime", "limitTime=" + j18 + ", curTime=" + serverTimeMillis + ", joinTime=" + j17 + ", spanTime=" + j19);
        }
        return z16;
    }

    private boolean e(int i3) {
        if (i3 != 1) {
            return true;
        }
        return false;
    }

    private int h(String str, String str2) {
        return this.f268464a.P3(str, str2);
    }

    private int i(IGProGuildInfo iGProGuildInfo, String str) {
        int i3;
        boolean t16 = t(iGProGuildInfo);
        boolean u16 = u(iGProGuildInfo);
        if (t16) {
            i3 = 1024;
        } else {
            i3 = 0;
        }
        if (u16) {
            i3 |= 2048;
        }
        if (t16 || u16) {
            i3 |= 8;
        }
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        if (!v(str)) {
            i3 |= 16;
        }
        if (p(str)) {
            i3 |= 64;
        }
        if (h(iGProGuildInfo.getGuildID(), str) == 2) {
            return i3 | 32 | 16;
        }
        return i3;
    }

    private int k(IGProGuildInfo iGProGuildInfo, String str) {
        return i(iGProGuildInfo, str) | l(iGProGuildInfo, str);
    }

    private int l(IGProGuildInfo iGProGuildInfo, String str) {
        int i3;
        if (!iGProGuildInfo.isVisibleForVisitor()) {
            i3 = 129;
        } else {
            i3 = 1;
        }
        if (!iGProGuildInfo.isInteractiveForVisitor()) {
            i3 |= 256;
        }
        return 65536 | i3 | 128;
    }

    private int m(IGProGuildInfo iGProGuildInfo, String str) {
        return i(iGProGuildInfo, str) | n(str, iGProGuildInfo);
    }

    private int n(String str, IGProGuildInfo iGProGuildInfo) {
        int i3;
        if (o(iGProGuildInfo, Boolean.FALSE)) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (o(iGProGuildInfo, Boolean.TRUE)) {
            i3 |= 4;
        }
        if (iGProGuildInfo.getUserType() == 2) {
            i3 |= 4096;
        } else if (iGProGuildInfo.getUserType() == 1) {
            i3 |= 8192;
        }
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        if (r(str)) {
            i3 |= 16384;
        }
        if (q(str)) {
            return i3 | 32768;
        }
        return i3;
    }

    private boolean o(IGProGuildInfo iGProGuildInfo, Boolean bool) {
        return false;
    }

    private boolean p(String str) {
        IGProChannelInfo cl5;
        IGProChannelInfo cl6 = this.f268464a.cl(str);
        if (cl6 == null || cl6.getGotoChannelId() == 0 || cl6.getJumpSwitch() != 1 || (cl5 = this.f268464a.cl(String.valueOf(cl6.getGotoChannelId()))) == null || cl5.getVisibleType() != 1) {
            return false;
        }
        return true;
    }

    private boolean q(String str) {
        IGProChannelInfo cl5 = this.f268464a.cl(str);
        if (cl5 != null && cl5.getIsCategoryAdmin() == 1) {
            return true;
        }
        return false;
    }

    private boolean r(String str) {
        IGProChannelInfo cl5 = this.f268464a.cl(str);
        if (cl5 != null && cl5.getIsChannelAdmin() == 1) {
            return true;
        }
        return false;
    }

    private boolean s(long j3) {
        if (j3 % JoinTimeType.THIRTY_MINUTES == 0) {
            return true;
        }
        return false;
    }

    private boolean t(IGProGuildInfo iGProGuildInfo) {
        boolean z16;
        long shutUpExpireTime = iGProGuildInfo.getShutUpExpireTime() * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (shutUpExpireTime > serverTimeMillis) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            x("isMutedAll", "globalMuteTime=" + shutUpExpireTime + ", curTime=" + serverTimeMillis);
        }
        return z16;
    }

    private boolean u(IGProGuildInfo iGProGuildInfo) {
        boolean z16;
        long myShutUpExpireTime = iGProGuildInfo.getMyShutUpExpireTime() * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (myShutUpExpireTime > serverTimeMillis) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            x("isMutedSelf", "myMuteTime=" + myShutUpExpireTime + ", curTime=" + serverTimeMillis);
        }
        return z16;
    }

    private boolean v(String str) {
        IGProChannelInfo cl5 = this.f268464a.cl(str);
        if (cl5 == null) {
            h.j("SpeakLimitMgr", 1, "isSpeakableInChannel channelInfo is null");
            return true;
        }
        if (cl5.getMyTalkPermissionType() == 0) {
            h.g("SpeakLimitMgr", 4, "isSpeakableInChannel getMyTalkPermissionType=0");
            return true;
        }
        if (cl5.getMyTalkPermissionType() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, String str2) {
        this.f268464a.ej(162, "SpeakLimitMgr", str, str2);
    }

    private void x(String str, String str2) {
        QLog.d("[gpro_sdk]SpeakLimitMgr", 4, str + ", " + str2);
    }

    public void f() {
        AppRuntime appRuntime = this.f268465b.get();
        if (appRuntime == null) {
            return;
        }
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.f268467d);
    }

    public IGuildSpeakableThresholdPermission g(String str) {
        GuildSpeakableThresholdPermission.a aVar = new GuildSpeakableThresholdPermission.a();
        if (j.i(str)) {
            h.j("SpeakLimitMgr", 1, "invalid guildId=" + str);
            return aVar.g();
        }
        if (c(str)) {
            aVar.j(1);
            aVar.i(1);
            return aVar.g();
        }
        IGProGuildInfo jl5 = this.f268464a.jl(str);
        if (jl5 == null) {
            return aVar.g();
        }
        GProFaceAuthInfo cf5 = this.f268464a.cf();
        if (cf5 == null) {
            h.k("SpeakLimitMgr", 1, "getGuildSpeakableThresholdPermission", "authInfo is null, tinyId=" + this.f268466c);
            cf5 = new GProFaceAuthInfo(2, "");
        }
        fc speakThreshold = jl5.getSpeakThreshold();
        if (speakThreshold == null) {
            h.k("SpeakLimitMgr", 1, "getGuildSpeakableThresholdPermission", "threshold is null, guildId=" + str);
            return aVar.g();
        }
        aVar.j(1);
        aVar.k(jl5.getJoinTime());
        aVar.l(cf5.getVerifyUrl());
        aVar.h(speakThreshold.d());
        aVar.i(b(jl5, cf5));
        return aVar.g();
    }

    public int j(String str, String str2) {
        IGProGuildInfo jl5 = this.f268464a.jl(str);
        if (jl5 == null) {
            h.k("SpeakLimitMgr", 1, "getSpeakLimit", "guildInfo=null, guildId=" + str);
            return 1;
        }
        if (jl5.isMember()) {
            return m(jl5, str2);
        }
        return k(jl5, str2);
    }
}
