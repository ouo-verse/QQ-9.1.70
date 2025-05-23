package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQFaceImageView extends DeclarativeBaseView<QQFaceImageAttr, QQFaceImageEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QQFaceImageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQFaceImageEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "HRQQFaceImageView";
    }
}
