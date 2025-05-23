package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProFeedSummary extends Serializable {
    String getFeedId();

    ArrayList<IGProFeedThumbnail> getFeedThumbnails();

    String getTitle();
}
