package com.tencent.richframework.text.rich.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes25.dex */
public class RichTextPreloadEvent extends SimpleBaseEvent {
    public static final int EVENT_PRELOAD_AT_CLICK_CALLBACK = 2;
    public static final int EVENT_PRELOAD_CLICKABLE_IMAGE_SPAN_CALLBACK = 5;
    public static final int EVENT_PRELOAD_CLICKABLE_IMAGE_SPAN_CLICK_CALLBACK = 4;
    public static final int EVENT_PRELOAD_EMOJI_CALLBACK = 1;
    public static final int EVENT_PRELOAD_HASH_TAG_CLICK_CALLBACK = 3;
    public static final int EVENT_PRELOAD_NICKNAME_CLICK_CALLBACK = 6;
    public static final int EVENT_PRELOAD_SEARCH_KEYWORD_CLICK_CALLBACK = 7;
    public String busiId;
    public String businessTag;
    public String cacheKey;
    public int eventType;
    public String searchKeyword;
    public String tagName;
    public int type;
    public String uin;

    public RichTextPreloadEvent(int i3, String str, String str2) {
        this.eventType = i3;
        this.businessTag = str;
        this.cacheKey = str2;
    }
}
