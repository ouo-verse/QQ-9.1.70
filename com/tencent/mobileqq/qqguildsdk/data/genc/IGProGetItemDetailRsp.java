package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetItemDetailRsp extends Serializable {
    byte[] getCookies();

    boolean getIsEnd();

    ArrayList<IGProRecommendItem> getItems();

    String getMsg();

    int getNextTs();

    String getRequestId();

    String toString();
}
