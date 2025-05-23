package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.config.TroopJoinGuildBean;
import com.tencent.mobileqq.guild.config.subconfig.parser.GuildTabNameConfigParser;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildConfigApiImpl implements IGuildConfigApi {
    private static final String TAG = "GuildConfigApiImpl";

    private TroopJoinGuildBean getTroopJoinGuildBean() {
        return bs.f235483a.h("100549").getTroopJumpGuildBean();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public String getGuildTabName() {
        return GuildTabNameConfigParser.d();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public double getInputRobotHintProbability() {
        QQGuildMCBean.GuildConfigBean guildConfigBean = bs.f235483a.h("100533").getGuildConfigBean();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " robotHintProbability: " + guildConfigBean.getRobotHintProbability());
        }
        return guildConfigBean.getRobotHintProbability();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public boolean getShowRobotButtonInAddPanel() {
        QQGuildMCBean.GuildConfigBean guildConfigBean = bs.f235483a.h("100533").getGuildConfigBean();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " mShowRobotButtonInAddPanel: " + guildConfigBean.getShowRobotButtonInAddPanel());
        }
        return guildConfigBean.getShowRobotButtonInAddPanel();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public Set<String> getShowRobotCommandGuildList() {
        QQGuildMCBean.GuildConfigBean guildConfigBean = bs.f235483a.h("100534").getGuildConfigBean();
        if (QLog.isColorLevel()) {
            Iterator<String> it = guildConfigBean.getShowRobotCommandGuildList().iterator();
            while (it.hasNext()) {
                QLog.d(TAG, 2, " getShowRobotCommandGuild: " + it.next());
            }
        }
        return guildConfigBean.getShowRobotCommandGuildList();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public Set<Long> getTroopJoinGuildBean_AllowShowClassSet() {
        return getTroopJoinGuildBean().f();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public String getTroopJoinGuildBean_JumpUrl() {
        return getTroopJoinGuildBean().getJumpURL();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public int getTroopJoinGuildBean_ShowMaxTimes() {
        return getTroopJoinGuildBean().getShowMaxTimes();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public boolean getTroopJoinGuildBean_Switch() {
        return getTroopJoinGuildBean().getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public String getTroopJoinGuildBean_TipStr() {
        return getTroopJoinGuildBean().getTipStr();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildConfigApi
    public void registerGuildTabNameUpdate(IGuildConfigApi.a aVar) {
        GuildTabNameConfigParser.c(aVar);
    }
}
