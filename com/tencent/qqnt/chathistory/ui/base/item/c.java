package com.tencent.qqnt.chathistory.ui.base.item;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chathistory.ui.base.j;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0000*\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0007*\u00020\u0004H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "", "a", "T", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "c", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;)Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "b", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;)Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull a aVar) {
        String format;
        String str;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (j.e(aVar)) {
            format = BaseApplication.getContext().getString(R.string.zjl);
            str = "getContext().getString(R\u2026at_history_current_weeak)";
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseApplication.getContext().getString(R.string.zjk);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026story_current_date_title)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(j.d(aVar)), Integer.valueOf(j.c(aVar))}, 2));
            str = "format(format, *args)";
        }
        Intrinsics.checkNotNullExpressionValue(format, str);
        return format;
    }

    @Nullable
    public static final <T extends b> T b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.b bVar) {
        Object last;
        Object last2;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (bVar.getNUM_BACKGOURND_ICON() != 0) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) bVar.m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (!(bVar2 instanceof b)) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) bVar2.b());
                Intrinsics.checkNotNull(last2, "null cannot be cast to non-null type T of com.tencent.qqnt.chathistory.ui.base.item.BaseHistoryItemModelKt.getLastChildNode");
                return (T) last2;
            }
            return (T) bVar2;
        }
        return null;
    }

    @Nullable
    public static final <T extends a> T c(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.b bVar) {
        Object last;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        if (bVar.getNUM_BACKGOURND_ICON() != 0) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) bVar.m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (bVar2 instanceof a) {
                return (T) bVar2;
            }
            Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.base.item.BaseHistoryItemModel");
            T t16 = (T) ((b) bVar2).d();
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.qqnt.chathistory.ui.base.item.BaseHistoryItemModelKt.getLastParentNode");
            return t16;
        }
        return null;
    }
}
