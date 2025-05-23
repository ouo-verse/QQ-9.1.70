package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a3\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u00f8\u0001\u0000\u001aH\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u00f8\u0001\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001c"}, d2 = {Node.CHILDREN_ATTR, "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(@NotNull Menu contains, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(item, "item");
        int size = contains.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(contains.getItem(i3), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu forEach, @NotNull Function1<? super MenuItem, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = forEach.getItem(i3);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu forEachIndexed, @NotNull Function2<? super Integer, ? super MenuItem, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEachIndexed.size();
        for (int i3 = 0; i3 < size; i3++) {
            Integer valueOf = Integer.valueOf(i3);
            MenuItem item = forEachIndexed.getItem(i3);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
            action.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu get, int i3) {
        Intrinsics.checkNotNullParameter(get, "$this$get");
        MenuItem item = get.getItem(i3);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull final Menu children) {
        Intrinsics.checkNotNullParameter(children, "$this$children");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(children);
            }
        };
    }

    public static final int getSize(@NotNull Menu size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull Menu isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull Menu isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.size() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new MenuKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull Menu minusAssign, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        Intrinsics.checkNotNullParameter(item, "item");
        minusAssign.removeItem(item.getItemId());
    }
}
