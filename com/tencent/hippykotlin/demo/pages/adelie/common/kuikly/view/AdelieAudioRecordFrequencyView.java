package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieAudioRecordFrequencyView extends DeclarativeBaseView<AdelieAudioRecordFrequencyViewAttr, AdelieAudioRecordFrequencyViewEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new AdelieAudioRecordFrequencyViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AdelieAudioRecordFrequencyViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "AdelieAudioRecordFrequencyView";
    }
}
