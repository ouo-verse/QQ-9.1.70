package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcShopData extends Entity {
    public static final String TABLE_NAME = "EcShopData";
    public long bindUin;
    public int mDistance;
    public String mImgInfo = "";
    public long mLastDraftTime;
    public long mLastMsgTime;

    @unique
    public String mUin;
    public String msgId;
}
