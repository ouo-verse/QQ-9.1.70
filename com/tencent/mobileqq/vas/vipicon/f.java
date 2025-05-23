package com.tencent.mobileqq.vas.vipicon;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/b;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f extends com.tencent.mobileqq.aio.msglist.holder.component.nick.block.b {
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.b
    @NotNull
    protected List<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> a(@NotNull Context context, @NotNull LinearLayout rootView) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new AIOVipIconProcessor(context, rootView), new AIOVipIconExProcessor(context, rootView), new AIOGameIconProcessor(context, rootView));
        return arrayListOf;
    }
}
