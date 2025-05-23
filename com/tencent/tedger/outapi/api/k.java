package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface k extends ue4.a {
    List<EdgePointWiseSample> dump(String str, String str2, List<String> list, EdgeStatus edgeStatus);

    void init(String str, EdgeStatus edgeStatus);

    List<EdgeFeatureList> parseItemFeatures(String str, List<EdgeItem> list, EdgeStatus edgeStatus);

    EdgeFeatureList parseUserFeatures(String str, EdgeUser edgeUser, EdgeStatus edgeStatus);
}
