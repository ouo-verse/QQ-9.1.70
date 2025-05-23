package com.tencent.biz.entity;

import com.tencent.biz.pb.clientbusilogic$PublicAccountInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "luin")
/* loaded from: classes2.dex */
public class MsgListPluginEntity extends Entity {
    public String name = "";
    public String displayNumber = "";
    public String summary = "";
    public boolean isRecvMsg = false;
    public boolean isRecvPush = false;
    public int certifiedGrade = 0;
    public boolean isSyncLbs = false;
    public int groupId = 0;
    public int showFlag = 0;
    public int accountFlag = 0;

    @unique
    public long luin = 0;
    public long accountFlag2 = 0;
    public int accountType = 0;
    public String accountUid = "";
    public int pluginIndex = -1;
    public boolean isMute = false;
    public boolean isEnable = false;

    public MsgListPluginEntity convertFromPublicAccountInfo(clientbusilogic$PublicAccountInfo clientbusilogic_publicaccountinfo, boolean z16) {
        this.name = clientbusilogic_publicaccountinfo.name.get();
        this.displayNumber = clientbusilogic_publicaccountinfo.display_number.get();
        this.summary = clientbusilogic_publicaccountinfo.summary.get();
        this.isRecvMsg = clientbusilogic_publicaccountinfo.is_recv_msg.get();
        this.isRecvPush = clientbusilogic_publicaccountinfo.is_recv_push.get();
        this.certifiedGrade = clientbusilogic_publicaccountinfo.certified_grade.get();
        this.isSyncLbs = clientbusilogic_publicaccountinfo.is_sync_lbs.get();
        this.groupId = clientbusilogic_publicaccountinfo.group_id.get();
        this.showFlag = clientbusilogic_publicaccountinfo.show_flag.get();
        this.accountFlag = clientbusilogic_publicaccountinfo.account_flag.get();
        this.luin = clientbusilogic_publicaccountinfo.luin.get();
        this.accountFlag2 = clientbusilogic_publicaccountinfo.account_flag2.get();
        this.accountType = clientbusilogic_publicaccountinfo.account_type.get();
        this.accountUid = clientbusilogic_publicaccountinfo.account_uid.get();
        this.isMute = clientbusilogic_publicaccountinfo.is_mute.get();
        this.pluginIndex = clientbusilogic_publicaccountinfo.plugin_index.get();
        this.isEnable = z16;
        return this;
    }
}
