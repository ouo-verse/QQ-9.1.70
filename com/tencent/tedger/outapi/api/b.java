package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b extends ue4.a {
    List<EdgeItemInfer> inference(EdgeListWiseSample edgeListWiseSample, EdgeStatus edgeStatus);

    void init(String str, EdgeStatus edgeStatus);

    void reload(EdgeStatus edgeStatus);
}
