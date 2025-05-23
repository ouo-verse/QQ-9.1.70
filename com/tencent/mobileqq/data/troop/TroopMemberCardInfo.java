package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "troopuin,memberuin")
/* loaded from: classes10.dex */
public class TroopMemberCardInfo extends Entity {
    public String colorNick;
    public int colorNickId;
    public String memberuin;
    public String name;
    public String nick;
    public String troopuin;
}
