package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetGuidePageInfoRsp extends Serializable {
    ArrayList<IGProGuidePageInfo> getGuidePage();

    IGProGuidePageInfo getMainGuidePage();

    String toString();
}
