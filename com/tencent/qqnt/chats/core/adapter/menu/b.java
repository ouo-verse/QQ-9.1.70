package com.tencent.qqnt.chats.core.adapter.menu;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/menu/b;", "", "Landroid/view/ViewGroup;", "viewGroup", "", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "items", "Landroid/view/View;", "a", "view", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Lcom/tencent/qqnt/chats/core/adapter/menu/creator/a;", "Lcom/tencent/qqnt/chats/core/adapter/menu/creator/a;", "menuCreator", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/menu/creator/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.adapter.menu.creator.a menuCreator;

    public b(@NotNull com.tencent.qqnt.chats.core.adapter.menu.creator.a menuCreator) {
        Intrinsics.checkNotNullParameter(menuCreator, "menuCreator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) menuCreator);
        } else {
            this.menuCreator = menuCreator;
        }
    }

    @NotNull
    public final List<View> a(@NotNull ViewGroup viewGroup, @NotNull List<a> items) {
        int count;
        int count2;
        List list;
        List<View> subList;
        List list2;
        int count3;
        int collectionSizeOrDefault;
        List list3;
        Set set;
        List minus;
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, (Object) items);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(items, "items");
        Sequence<View> children = ViewGroupKt.getChildren(viewGroup);
        count = SequencesKt___SequencesKt.count(children);
        if (count == items.size()) {
            subList = SequencesKt___SequencesKt.toList(children);
        } else {
            count2 = SequencesKt___SequencesKt.count(children);
            if (count2 < items.size()) {
                list2 = SequencesKt___SequencesKt.toList(children);
                List list4 = list2;
                count3 = SequencesKt___SequencesKt.count(children);
                List<a> subList2 = items.subList(count3, items.size());
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = subList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.menuCreator.b(viewGroup, (a) it.next()));
                }
                subList = CollectionsKt___CollectionsKt.plus((Collection) list4, (Iterable) arrayList);
            } else {
                list = SequencesKt___SequencesKt.toList(children);
                subList = list.subList(0, items.size());
            }
        }
        list3 = SequencesKt___SequencesKt.toList(children);
        List<View> list5 = subList;
        set = CollectionsKt___CollectionsKt.toSet(list5);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list3, (Iterable) set);
        Iterator it5 = minus.iterator();
        while (it5.hasNext()) {
            ((View) it5.next()).setVisibility(8);
        }
        for (View view : list5) {
            contains = SequencesKt___SequencesKt.contains(children, view);
            if (!contains) {
                viewGroup.addView(view);
            }
            view.setVisibility(0);
        }
        return subList;
    }

    public final void b(@NotNull View view, @NotNull a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        this.menuCreator.a(view, item);
    }
}
