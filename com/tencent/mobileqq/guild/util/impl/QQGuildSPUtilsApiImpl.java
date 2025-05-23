package com.tencent.mobileqq.guild.util.impl;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.main.d;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import java.util.List;
import n02.a;

/* loaded from: classes14.dex */
public class QQGuildSPUtilsApiImpl implements IQQGuildSPUtilsApi {
    private String getAtRoleRecentRecordKey(String str) {
        return ch.g() + "-" + str;
    }

    private String getMMKVKey(String str, boolean z16, boolean z17) {
        if (z16) {
            return bw.a2(str);
        }
        if (z17) {
            return bw.b2(str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void addOneRecentTalkedChannel(boolean z16, String str) {
        a.a(str);
        d.c(z16, str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void addShowTroopJoinGuildTipsTimes() {
        bw.a();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void clearAllMMVK() {
        bw.b();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void clearMMKVBool(String str, boolean z16, boolean z17) {
        bw.L().encodeBool(getMMKVKey(str, z16, z17), false);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void clearMMKVInt(String str, boolean z16, boolean z17) {
        bw.L().encodeInt(getMMKVKey(str, z16, z17), 0);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void clearMMKVLong(String str, boolean z16, boolean z17) {
        bw.L().encodeLong(getMMKVKey(str, z16, z17), 0L);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean containsKey(String str) {
        return bw.L().containsKey(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public int decodeInt(String str, int i3) {
        return bw.L().decodeInt(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public long decodeLong(String str, long j3) {
        return bw.L().decodeLong(str, j3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    @Nullable
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t16) {
        return (T) bw.L().decodeParcelable(str, cls, t16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void encodeInt(String str, int i3) {
        bw.L().encodeInt(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void encodeLong(String str, long j3) {
        bw.L().encodeLong(str, j3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void encodeParcelable(String str, Parcelable parcelable) {
        bw.L().encodeParcelable(str, parcelable);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public List<Integer> getAioBubbleWidth() {
        return bw.d();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean getAioGuildTabDakaPopupShowed() {
        return bw.e();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean getAioGuildTabPopupShowed() {
        return bw.f();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getAtRemainNum(String str) {
        return bw.h(getAtRoleRecentRecordKey(str));
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getAtRobotRecentRecord(String str) {
        return bw.i(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getAtRoleRecentRecord(String str) {
        return bw.j(getAtRoleRecentRecordKey(str));
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public Integer getFeedContentWidth() {
        return Integer.valueOf(bw.t());
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getGuildCoverConfigUrl() {
        return bw.u();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public int getGuildCoverConfigVersion() {
        return bw.v();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getGuildCoverInfoList() {
        return bw.w();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getGuildOnePlayConfigJson() {
        return bw.y();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getGuildOnePlayConfigUrl() {
        return bw.z();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public int getGuildOnePlayConfigVersion() {
        return bw.A();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public long getGuildSpeakManageGuideLastTime(String str) {
        return bw.B(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public Long getGuildUserOnBackgroundTime() {
        return Long.valueOf(bw.C());
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getMiniAppGuildShareInfo(String str) {
        return bw.S(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean getRecentChannelGuildAnimationClosed() {
        return bw.X();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean getRecentChannelGuildAnimationShowed() {
        return bw.Y();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String getRecentTalkedChannelsWithTime() {
        return bx.f();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean getShowTroopJoinGuildTipsHasClose() {
        return bw.e0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public int getShowTroopJoinGuildTipsTimes() {
        return bw.f0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public int getShowTroopJoinGuildTipsVersion() {
        return bw.g0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean guildMsgDebugOpen() {
        return bw.L().decodeBool("key_aio_msgId_enabled", false);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean hasSubscribeChannelSuccessfullyEver() {
        return bw.o0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isAioNewGuideHasShow() {
        return bx.k();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isChannelShowedBlockAdsTip(String str) {
        return bw.q0(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isNewGuideHasShow() {
        return bx.l();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isOpenGProDelayInitMode() {
        return bw.u0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isPlusBtnRobotDotHasShow() {
        QQGuildMCBean.GuildConfigBean guildConfigBean = bs.f235483a.h("100533").getGuildConfigBean();
        if (guildConfigBean != null && guildConfigBean.getEnableRobotRedDotVersion().contains(AppSetting.f99551k)) {
            return bw.v0();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isRobotSlashPanelUsed() {
        return bw.w0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public boolean isRobotSlashRedDotHasShow() {
        QQGuildMCBean.GuildConfigBean guildConfigBean = bs.f235483a.h("100533").getGuildConfigBean();
        if (guildConfigBean != null && guildConfigBean.getEnableRobotRedDotVersion().contains(AppSetting.f99551k)) {
            return bw.x0();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void resetGuideAnimationMMKV() {
        bw.I1(false);
        bw.J1(false);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void resetShowTroopJoinGuildTipsHasClose() {
        bw.A0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void resetShowTroopJoinGuildTipsTimes() {
        bw.B0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void resetUINSubscribeMMKV() {
        bw.T0(ch.g(), 0L);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void saveAtRemainNum(String str, String str2) {
        bw.C0(getAtRoleRecentRecordKey(str), str2);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAioBubbleWidth(List<Integer> list) {
        bw.F0(list);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAioGuildTabDakaPopupShowed() {
        bw.G0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAioGuildTabPopupShowed() {
        bw.H0();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAioNewGuideHasShow() {
        bx.m();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAtRobotRecentRecord(String str, String str2) {
        bw.J0(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setAtRoleRecentRecord(String str, String str2) {
        bw.K0(getAtRoleRecentRecordKey(str), str2);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setChannelShowedBlockAdsTip(String str) {
        bw.O0(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setFeedContentWidth(Integer num) {
        bw.X0(num.intValue());
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildCoverConfigUrl(String str) {
        bw.Y0(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildCoverConfigVersion(int i3) {
        bw.Z0(i3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildCoverInfoList(String str) {
        bw.a1(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildOnePlayConfigJson(String str) {
        bw.c1(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildOnePlayConfigUrl(String str) {
        bw.d1(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildOnePlayConfigVersion(int i3) {
        bw.e1(i3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setGuildSpeakManageGuideLastTime(String str, long j3) {
        bw.f1(str, j3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setNewGuideHasShow() {
        bx.t();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setNewVersionGuideHasShow() {
        bw.F1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setOpenGProDelayInitMode(boolean z16) {
        bw.G1(z16);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setPlusBtnRobotDotHasShow() {
        bw.H1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setRecentChannelGuildAnimationClosed() {
        bw.I1(true);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setRecentChannelGuildAnimationShowed() {
        bw.J1(true);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setRecentTalkedChannelsWithTime(String str) {
        bx.u(str);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setRobotSlashPanelUsed() {
        bw.O1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setRobotSlashRedDotHasShow() {
        bw.P1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setShowTroopJoinGuildTipsHasClose() {
        bw.S1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setShowTroopJoinGuildTipsVersion(int i3) {
        bw.T1(i3);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void setSubscribeChannelSuccessfully() {
        bw.W1();
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public void suppressRecommendedChannelGuide() {
        bw.V1(System.currentTimeMillis() + 2592000000L);
    }

    @Override // com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi
    public String uinKeyOf(String str) {
        return bw.b2(str);
    }
}
