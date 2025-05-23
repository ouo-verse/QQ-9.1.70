package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProMemberGetBoundGroupRsp extends Serializable {
    ArrayList<Long> getAllBindGroupCodeList();

    int getBindingGroupLimit();

    ArrayList<IGProBindingGroup> getBindingGroupList();

    int getBindingGroupSize();

    long getGuildId();

    int getSrcType();

    String toString();
}
