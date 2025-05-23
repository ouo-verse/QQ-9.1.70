package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends ue4.a {
    List<Integer> dispatchAction(EdgeAction edgeAction, EdgeUser edgeUser, EdgeStatus edgeStatus);

    void init(String str, EdgeStatus edgeStatus);
}
