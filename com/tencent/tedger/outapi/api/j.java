package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface j extends ue4.a {
    EdgeListWiseSample extractFeatures(EdgeFeatureList edgeFeatureList, List<EdgeFeatureList> list, EdgeStatus edgeStatus);

    void init(String str, EdgeStatus edgeStatus);
}
