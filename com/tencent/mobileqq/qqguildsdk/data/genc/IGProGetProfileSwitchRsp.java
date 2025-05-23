package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetProfileSwitchRsp extends Serializable {
    ArrayList<Integer> getCloseSwitch();

    ArrayList<Integer> getOpenSwitch();

    String toString();
}
