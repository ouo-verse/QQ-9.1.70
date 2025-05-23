package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProCmd0xf55CategoryInfo extends Serializable {
    ArrayList<IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry> getBytesCategoryCommonList();

    String getCategoryAlias();

    long getCategoryId();

    int getCategoryIndex();

    String getCategoryName();

    int getCategoryType();

    IGProChannelCategoryInfo getChannelCategoryInfo();

    int getCloseSwitch();

    String toString();
}
