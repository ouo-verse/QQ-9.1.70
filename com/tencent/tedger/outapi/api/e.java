package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface e extends ue4.a {
    List<EdgePointWiseSample> convertFeedBack(List<EdgePointWiseSample> list, EdgeStatus edgeStatus);

    void init(String str, EdgeStatus edgeStatus);
}
