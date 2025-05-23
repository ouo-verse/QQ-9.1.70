package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class HotChatItemData extends Entity {
    public String mADsContent;
    public long mDraftSec;
    public int mGameId;
    public String mHotChatCode;
    public boolean mIsMakeTop;
    public boolean mIsRead4Folder = true;
    public boolean mIsRead4List = true;
    public long mLatestMsgSec;
    public long mMakeTopTime;
    public int mState;

    @unique
    public String mTroopUin;
}
