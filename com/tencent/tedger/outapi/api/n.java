package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface n extends ue4.a {
    void G(List<EdgePointWiseSample> list);

    void d(EdgeAction edgeAction, EdgeStatus edgeStatus);

    void onDestroy();

    void p(EdgeStatus edgeStatus);
}
