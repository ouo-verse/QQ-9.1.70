package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProItemHeadInfo extends Serializable {
    String getOnlineNums();

    ArrayList<IGProConditionalTag> getTags();

    String toString();
}
