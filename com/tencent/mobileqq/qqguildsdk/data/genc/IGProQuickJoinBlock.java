package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProQuickJoinBlock extends Serializable {
    ArrayList<String> getMembersAvatar();

    ArrayList<IGProQuickJoinItem> getQuickJoinItems();

    ArrayList<IGProQuickJoinCycleStatusTag> getStatusTag();

    String toString();
}
