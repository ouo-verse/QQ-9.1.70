package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProConfirmOption extends Serializable {
    String getConfirmMsg();

    ArrayList<IGProConfirmNode> getConfirmNodes();

    String toString();
}
