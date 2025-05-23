package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAVMemberGroupListRsp extends Serializable {
    IGProChannelUserNum getChannelUserNum();

    IGProGroupTypeList getGroupTypeList();

    long getNextReadInterval();

    String toString();
}
