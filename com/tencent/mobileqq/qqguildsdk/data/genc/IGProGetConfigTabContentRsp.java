package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetConfigTabContentRsp extends Serializable {
    ArrayList<IGProRecommendContentItem> getBannerConfigList();

    IGProTabContentCommonRsp getCommonRsp();

    ArrayList<IGProRecommendContentItem> getH5kuiklyConfigList();

    String toString();
}
