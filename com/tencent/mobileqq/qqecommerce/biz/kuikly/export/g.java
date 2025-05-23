package com.tencent.mobileqq.qqecommerce.biz.kuikly.export;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\f\u001a\u00020\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Li01/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "c", "(Li01/a;)Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "qqRenderView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyFragment;", "a", "(Li01/a;)Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyFragment;", "qqKuiklyFragment", "", "b", "(Li01/a;)Ljava/lang/String;", "qqKuiklyPageName", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {
    public static final QQKuiklyFragment a(i01.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        QQKuiklyRenderView c16 = c(aVar);
        h delegate = c16 != null ? c16.getDelegate() : null;
        if (delegate instanceof QQKuiklyFragment) {
            return (QQKuiklyFragment) delegate;
        }
        return null;
    }

    public static final String b(i01.a aVar) {
        Map<String, Object> O;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        QQKuiklyRenderView c16 = c(aVar);
        Object obj = (c16 == null || (O = c16.O()) == null) ? null : O.get("page_name");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    public static final QQKuiklyRenderView c(i01.a aVar) {
        com.tencent.kuikly.core.render.android.d O0;
        ViewGroup view;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        com.tencent.kuikly.core.render.android.a aVar2 = aVar.get_kuiklyRenderContext();
        ViewParent viewParent = null;
        if (aVar2 != null && (O0 = aVar2.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof QQKuiklyRenderView) {
                    viewParent = parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        return (QQKuiklyRenderView) viewParent;
    }
}
