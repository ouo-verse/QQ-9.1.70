package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetRecommendTagListRsp extends Serializable {
    byte[] getCookies();

    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendItem> getRecommendList();

    String toString();
}
