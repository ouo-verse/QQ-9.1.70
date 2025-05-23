package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetBlockRecGuildsRsp extends Serializable {
    IGProGetRecommendV2Rsp getBanner();

    byte[] getCookies();

    boolean getIsEnd();

    String getMsg();

    ArrayList<IGProBlockInfo> getRecBlockInfo();

    String getTraceId();

    String toString();
}
