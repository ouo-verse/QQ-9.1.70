package com.tencent.kuikly.core.views.compose;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004*l\u0010\r\u001a\u0004\b\u0000\u0010\u0007\"0\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\b\u000420\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/compose/SliderPageView;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "T", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/PageListView;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "SliderItemCreator", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {
    public static final void a(ViewContainer<?, ?> viewContainer, Function1<? super SliderPageView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        viewContainer.addChild(new SliderPageView(), init);
    }
}
