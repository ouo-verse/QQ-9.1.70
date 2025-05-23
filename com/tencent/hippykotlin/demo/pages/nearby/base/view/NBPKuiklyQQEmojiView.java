package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;

/* loaded from: classes31.dex */
public final class NBPKuiklyQQEmojiView extends ViewContainer<NBPKuiklyQQEmojiViewAttr, NBPKuiklyQQEmojiViewEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPKuiklyQQEmojiViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPKuiklyQQEmojiViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "NBPKuiklyQQEmojiView";
    }
}
