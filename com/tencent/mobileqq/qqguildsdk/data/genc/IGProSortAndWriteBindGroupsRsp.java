package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProSortAndWriteBindGroupsRsp extends Serializable {
    ArrayList<Long> getGroupCodeList();

    long getGuildId();

    String toString();
}
