package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetContentRecommendRsp extends Serializable {
    byte[] getCookies();

    IGProMVPExtInfo getExtInfo();

    IGProNavigationList getNavigation();

    ArrayList<IGProRecommendContentItem> getRecommendList();

    String getSessionId();

    String toString();
}
