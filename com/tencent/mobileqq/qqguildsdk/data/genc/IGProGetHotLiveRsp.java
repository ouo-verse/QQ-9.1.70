package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetHotLiveRsp extends Serializable {
    byte[] getCookie();

    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendItem> getRecommendList();

    String getSessionId();

    String toString();
}
