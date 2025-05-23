package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base;

import com.tencent.hippykotlin.demo.pages.base.view.QQComposeMarkdownView;
import com.tencent.hippykotlin.demo.pages.base.view.QQKuiklyPageView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQComposeViewExtCreator implements e {
    public static final QQComposeViewExtCreator INSTANCE = new QQComposeViewExtCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        if (Intrinsics.areEqual(str, "NTComposePage")) {
            return c.b(new QQKuiklyPageView());
        }
        if (Intrinsics.areEqual(str, "QQComposeMarkdownView")) {
            return c.b(new QQComposeMarkdownView());
        }
        throw new RuntimeException(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("QQComposeViewExtCreator->viewType:", str, " not found when createComposeView"));
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}
