package com.tencent.richframework;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.cache.api.d;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/QQArgusNode;", "", "T", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Lcom/tencent/cache/api/d;", "getPageArgus", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ParseCommon.CONTAINER, "<init>", "(Landroid/view/View;Ljava/lang/Object;)V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class QQArgusNode<T> extends ArgusNode<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQArgusNode(@NotNull View rootView, @NotNull T container) {
        super(rootView, container);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @NotNull
    public abstract d getPageArgus();
}
