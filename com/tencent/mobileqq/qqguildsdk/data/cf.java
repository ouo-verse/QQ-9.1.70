package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProUserJoinedGuildSummary;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserJoinedGuildSummary;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildUserProfile;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cf implements ev {

    /* renamed from: a, reason: collision with root package name */
    private final GProGuildUserProfile f265813a;

    public cf(GProGuildUserProfile gProGuildUserProfile) {
        this.f265813a = gProGuildUserProfile;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int a() {
        return this.f265813a.getFaceAuthStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public short b() {
        return this.f265813a.getBirthMonth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int c() {
        return this.f265813a.getProvinceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public er d() {
        return com.tencent.mobileqq.qqguildsdk.util.g.J0(this.f265813a.getAllGiftInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public short e() {
        return this.f265813a.getBirthDay();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    @Nullable
    public String f() {
        return this.f265813a.getPersonalSignature();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int g() {
        return this.f265813a.getCityId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public byte getAge() {
        return this.f265813a.getAge();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getAvatarMeta() {
        return this.f265813a.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getCity() {
        return this.f265813a.getCity();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public IGProClientIdentityInfo getClientIdentity() {
        return new GProClientIdentityInfo(this.f265813a.getClientIdentity());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public IGProClientPresenceInfo getClientPresence() {
        return new GProClientPresenceInfo(this.f265813a.getClientPresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getDisplayName() {
        if (!TextUtils.isEmpty(getMemberName())) {
            return getMemberName();
        }
        return getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int getGender() {
        return this.f265813a.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int getIsMember() {
        return this.f265813a.getIsMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public long getJoinTime() {
        return this.f265813a.getJoinTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public IGProUserJoinedGuildSummary getJoinedGuildSummary() {
        return new GGProUserJoinedGuildSummary(this.f265813a.getJoinedGuildSummary());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public ArrayList<eu> getMedals() {
        return com.tencent.mobileqq.qqguildsdk.util.g.x(this.f265813a.getMedals());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getMemberName() {
        return this.f265813a.getMemberName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getNickName() {
        return this.f265813a.getNick();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getOpenId() {
        return this.f265813a.getOpenId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getProvince() {
        return this.f265813a.getProvince();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int getPublishedFeedShowSwitch() {
        return this.f265813a.getPublishedFeedShowSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    @Nullable
    public ea getRoomState() {
        if (this.f265813a.getRoomState() == null) {
            return null;
        }
        return new bk(this.f265813a.getRoomState());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public long getShutUpExpireTime() {
        return this.f265813a.getShutUpExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getTinyId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265813a.getTinyId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getUin() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265813a.getUin());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int getUserType() {
        return this.f265813a.getUserType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String getVerifyUrl() {
        return this.f265813a.getVerifyUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String h() {
        return this.f265813a.getSkinPicUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public String i() {
        return this.f265813a.getCountry();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public boolean isValid() {
        if (this.f265813a.getTinyId() >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public xh2.c j() {
        return new aj(this.f265813a.getFirstArchiveArkData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public boolean k() {
        return this.f265813a.getIsQQFriend();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public boolean l() {
        return this.f265813a.getHasMoreArchive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public ArrayList<dj> m() {
        return com.tencent.mobileqq.qqguildsdk.util.g.z0(this.f265813a.getClientArchives());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public boolean n() {
        if (this.f265813a.getDirectMsgBlackFlag() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public short o() {
        return this.f265813a.getBirthYear();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public int p() {
        return this.f265813a.getCountryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public long q() {
        return this.f265813a.getJoinGroupProTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public IGProUserPublishedFeedSummary r() {
        return new GProUserPublishedFeedSummaryInfo(this.f265813a.getPublishedFeedSummary());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    public em s() {
        return com.tencent.mobileqq.qqguildsdk.util.g.I0(this.f265813a.getSignGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ev
    @Nullable
    public String t() {
        return this.f265813a.getConstellation();
    }

    public String toString() {
        return "GProUserProfileInfo{info=" + this.f265813a + '}';
    }
}
