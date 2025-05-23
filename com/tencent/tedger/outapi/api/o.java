package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface o extends ue4.a {
    void d(EdgeAction edgeAction, EdgeStatus edgeStatus);

    EdgeUser u(EdgeStatus edgeStatus);

    void updateUserBaseInfo(EdgeUser edgeUser, EdgeStatus edgeStatus);
}
