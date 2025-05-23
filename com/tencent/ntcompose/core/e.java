package com.tencent.ntcompose.core;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.pager.Pager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/core/e;", "", "", "viewType", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "createComposeView", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static ComposeRenderView a(e eVar, String viewClassName) {
            DeclarativeBaseView<?, ?> createViewFromRegister;
            Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
            com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
            Pager pager = g16 instanceof Pager ? (Pager) g16 : null;
            if (pager == null || (createViewFromRegister = pager.createViewFromRegister(viewClassName)) == null) {
                return null;
            }
            return c.b(createViewFromRegister);
        }
    }

    ComposeRenderView createComposeView(String viewType);
}
