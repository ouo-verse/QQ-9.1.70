package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProPreventAddictionCheckRsp extends Serializable {
    String getContext();

    String getInstrTraceId();

    ArrayList<IGProPAInstructionInfo> getInstructions();

    String getMsg();

    int getRet();

    String toString();
}
