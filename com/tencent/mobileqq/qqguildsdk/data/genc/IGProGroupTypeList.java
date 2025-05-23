package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGroupTypeList extends Serializable {
    long getChannelId();

    ArrayList<IGProGroupTypeMember> getGroupTypeMembers();

    String toString();
}
