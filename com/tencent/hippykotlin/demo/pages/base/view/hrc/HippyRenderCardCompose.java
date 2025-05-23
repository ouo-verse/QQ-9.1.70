package com.tencent.hippykotlin.demo.pages.base.view.hrc;

import com.tencent.hippykotlin.demo.pages.base.view.hrc.HRCComposeAttr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class HippyRenderCardCompose<A extends HRCComposeAttr> extends ComposeView<HRCComposeAttr, l> {
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final boolean isPager() {
        return true;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public l createEvent() {
        return new l();
    }

    public void onReceiveCustomEvent(String str, e eVar) {
    }
}
