package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class IntimateSpaceComposeViewCreator implements e {
    public static final IntimateSpaceComposeViewCreator INSTANCE = new IntimateSpaceComposeViewCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        if (Intrinsics.areEqual(str, "FilamentView")) {
            return c.b(new IntimateSpaceFilamentView());
        }
        return c.b(new v());
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}
