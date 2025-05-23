package com.tencent.qzonehub.api.contentbox;

import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IMQMsg extends Serializable {
    JSONObject convertToJson();

    List getFeeds();

    long getPushTime();

    int isNewStyle();

    boolean isNewStyleCard();

    boolean isRecommGuideCard();
}
