package com.tencent.mobileqq.wink.api;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkVideoCommentCompleteEvent extends SimpleBaseEvent {
    public HashMap<String, String> params;

    public WinkVideoCommentCompleteEvent() {
    }

    public WinkVideoCommentCompleteEvent(HashMap<String, String> hashMap) {
        this.params = hashMap;
    }
}
