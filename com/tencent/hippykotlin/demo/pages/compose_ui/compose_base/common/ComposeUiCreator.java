package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.common;

import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdeliePolarLightView;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposeUiCreator implements e {
    public static final ComposeUiCreator INSTANCE = new ComposeUiCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        if (Intrinsics.areEqual(str, "AdeliePolarLightView")) {
            return c.b(new AdeliePolarLightView());
        }
        return c.b(new v());
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}
