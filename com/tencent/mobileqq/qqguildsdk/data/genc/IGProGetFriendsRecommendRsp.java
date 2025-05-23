package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetFriendsRecommendRsp extends Serializable {
    IGProMVPExtInfo getExtInfo();

    int getFriendType();

    boolean getIsEnd();

    ArrayList<IGProRecommendContentItem> getRecommendList();

    String toString();
}
