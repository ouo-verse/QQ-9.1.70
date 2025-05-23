package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TroopBarData extends Entity {
    public boolean mIsSticky = false;
    public long mLastDraftTime;
    public long mLastMsgTime;
    public long mLastStickyTime;

    @notColumn
    public MessageRecord mLatestMessage;

    @unique
    public String mUin;

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return super.getTableName();
    }
}
