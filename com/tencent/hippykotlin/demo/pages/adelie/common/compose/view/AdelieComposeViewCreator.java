package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieComposeViewCreator implements e {
    public static final AdelieComposeViewCreator INSTANCE = new AdelieComposeViewCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        if (Intrinsics.areEqual(str, "AudioRecordFrequency")) {
            return c.b(new AdelieAudioRecordFrequencyView());
        }
        return c.b(new v());
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}
