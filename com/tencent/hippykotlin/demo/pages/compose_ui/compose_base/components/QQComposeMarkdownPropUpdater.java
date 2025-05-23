package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.hippykotlin.demo.pages.base.view.QQComposeMarkdownView;
import com.tencent.hippykotlin.demo.pages.base.view.QQComposeMarkdownViewAttr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import com.tencent.ntcompose.material.base.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QQComposeMarkdownPropUpdater implements f {
    public static final QQComposeMarkdownPropUpdater INSTANCE = new QQComposeMarkdownPropUpdater();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public final void setPropToView(ComposeRenderView composeRenderView, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        DeclarativeBaseView<?, ?> b16 = composeRenderView.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.view.QQComposeMarkdownView");
        QQComposeMarkdownViewAttr qQComposeMarkdownViewAttr = (QQComposeMarkdownViewAttr) ((QQComposeMarkdownView) b16).getViewAttr();
        int hashCode = str.hashCode();
        if (hashCode != -1556686091) {
            if (hashCode != 246938863) {
                if (hashCode == 390232059 && str.equals("maxLines")) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    qQComposeMarkdownViewAttr.with("maxLines", Integer.valueOf(((Integer) obj).intValue()));
                    return;
                }
            } else if (str.equals("markdown")) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                qQComposeMarkdownViewAttr.with("markdown", (String) obj);
                return;
            }
        } else if (str.equals("paragraphSpacing")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            qQComposeMarkdownViewAttr.with("paragraphSpacing", Float.valueOf(((Float) obj).floatValue()));
            return;
        }
        e.f339411a.setPropToView(composeRenderView, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.tencent.ntcompose.core.f
    public final void resetPropToView(ComposeRenderView composeRenderView, String str) {
    }
}
