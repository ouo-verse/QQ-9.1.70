package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes10.dex */
public class PubAccountAssistantData extends Entity {
    public int mDistance;
    public long mLastDraftTime;
    public long mLastMsgTime;
    public int mType;

    @unique
    public String mUin;
}
