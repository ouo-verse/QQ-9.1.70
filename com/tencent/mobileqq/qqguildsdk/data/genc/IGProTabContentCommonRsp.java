package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProTabContentCommonRsp extends Serializable {
    byte[] getBackendCookies();

    byte[] getCookies();

    IGProMVPExtInfo getExtInfo();

    ArrayList<IGProRecommendContentItem> getRecommendList();

    String getSessionId();

    ArrayList<IGProNavigationTab> getTabList();

    String toString();
}
