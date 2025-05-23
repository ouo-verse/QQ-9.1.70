package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProNavigationList extends Serializable {
    ArrayList<IGProNavigationData> getDataList();

    String getNavigationVersion();

    String toString();
}
