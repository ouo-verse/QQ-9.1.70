package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProExtra extends Serializable {
    ArrayList<IGProEntry> getBizDataList();

    IGProMVPItemCbData getCallback();

    boolean getIsRead();

    ArrayList<IGProEntry> getReports();

    String getSessionId();

    ArrayList<IGProTag> getTags();

    String toString();
}
