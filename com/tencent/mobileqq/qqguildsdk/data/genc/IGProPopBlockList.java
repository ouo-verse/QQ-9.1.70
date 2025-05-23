package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProPopBlockList extends Serializable {
    String getBlockName();

    ArrayList<IGProBlockBaseInfo> getList();

    int getNextTs();

    String toString();
}
