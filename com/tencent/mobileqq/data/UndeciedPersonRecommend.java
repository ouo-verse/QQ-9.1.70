package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes10.dex */
public class UndeciedPersonRecommend extends Entity implements Serializable {
    public static final int INVALID_ADDFRIEND_SOURCE = -1;
    public static final int TAB_ID_FOR_MAY_KNOW_RECOMMEND = 23;
    private static final String TAG = "UndeciedPersonRecommend";
    private static final long serialVersionUID = 1;
    public short age;

    @notColumn
    public boolean bHighLight;
    public int friendStatus;

    @notColumn
    public List<MayKnowRecommend.MayKnowRecommendLabel> msgLabel;
    public byte[] msgLabelByte;
    public String nick;
    public String recommendReason;
    public String remark;
    public int timestamp;
    public String uin;
    public short gender = 255;
    public int addFriendsource = -1;
    public int addFriendSubSource = -1;
    public long cardDisplayTimestamp = 0;
    public int tabID = 23;
    public int sourceId = 0;
    public int isVerify = 0;
    public int verifyFriendSource = -1;
    public int verifyType = -1;
    public int verifyTimeStamps = 0;
}
