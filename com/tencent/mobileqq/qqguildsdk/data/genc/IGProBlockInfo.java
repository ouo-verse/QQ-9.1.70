package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProBlockInfo extends Serializable {
    String getBlockId();

    int getBlockIndex();

    String getBlockName();

    int getBlockType();

    ArrayList<IGProRecommendCategory> getCategories();

    boolean getHasMore();

    int getIsWhole();

    ArrayList<IGProRecommendItem> getItems();

    String toString();
}
