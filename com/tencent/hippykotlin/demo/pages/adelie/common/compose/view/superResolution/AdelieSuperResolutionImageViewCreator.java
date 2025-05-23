package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageView;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieSuperResolutionImageViewCreator implements e {
    public static final AdelieSuperResolutionImageViewCreator INSTANCE = new AdelieSuperResolutionImageViewCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        if (Intrinsics.areEqual(str, "SuperResolutionImage")) {
            return c.b(new AdelieSuperResolutionImageView());
        }
        return c.b(new v());
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}
