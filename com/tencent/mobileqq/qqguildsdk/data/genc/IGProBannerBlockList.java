package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProBannerBlockList extends Serializable {
    String getBlockName();

    ArrayList<IGProBlockBaseInfo> getList();

    String toString();
}
