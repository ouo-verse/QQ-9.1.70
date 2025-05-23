package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface c extends ue4.a {
    void init(String str, EdgeStatus edgeStatus);

    boolean train(List<EdgeListWiseSample> list, EdgeStatus edgeStatus);
}
