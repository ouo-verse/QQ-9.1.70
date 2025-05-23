package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a3\u0010\u000f\u001a\u00020\u0010*\u00020\u00032!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u00f8\u0001\u0000\u001aH\u0010\u0015\u001a\u00020\u0010*\u00020\u000326\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00100\u0016H\u0086\b\u00f8\u0001\u0000\u001a\u0015\u0010\u0018\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0086\u0002\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0086\b\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001f\u001a\u00020\u0010*\u00020 2\b\b\u0001\u0010\b\u001a\u00020\tH\u0086\b\u001a5\u0010!\u001a\u00020\u0010*\u00020 2\b\b\u0003\u0010\"\u001a\u00020\t2\b\b\u0003\u0010#\u001a\u00020\t2\b\b\u0003\u0010$\u001a\u00020\t2\b\b\u0003\u0010%\u001a\u00020\tH\u0086\b\u001a5\u0010&\u001a\u00020\u0010*\u00020 2\b\b\u0003\u0010'\u001a\u00020\t2\b\b\u0003\u0010#\u001a\u00020\t2\b\b\u0003\u0010(\u001a\u00020\t2\b\b\u0003\u0010%\u001a\u00020\tH\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006)"}, d2 = {Node.CHILDREN_ATTR, "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@NotNull ViewGroup contains, @NotNull View view) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(view, "view");
        if (contains.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull ViewGroup forEach, @NotNull Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = forEach.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = forEach.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup forEachIndexed, @NotNull Function2<? super Integer, ? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Integer valueOf = Integer.valueOf(i3);
            View childAt = forEachIndexed.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup get, int i3) {
        Intrinsics.checkNotNullParameter(get, "$this$get");
        View childAt = get.getChildAt(i3);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + get.getChildCount());
    }

    @NotNull
    public static final Sequence<View> getChildren(@NotNull final ViewGroup children) {
        Intrinsics.checkNotNullParameter(children, "$this$children");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(children);
            }
        };
    }

    @NotNull
    public static final Sequence<View> getDescendants(@NotNull ViewGroup descendants) {
        Intrinsics.checkNotNullParameter(descendants, "$this$descendants");
        return SequencesKt.sequence(new ViewGroupKt$descendants$1(descendants, null));
    }

    public static final int getSize(@NotNull ViewGroup size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new ViewGroupKt$iterator$1(iterator);
    }

    public static final void minusAssign(@NotNull ViewGroup minusAssign, @NotNull View view) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        Intrinsics.checkNotNullParameter(view, "view");
        minusAssign.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup plusAssign, @NotNull View view) {
        Intrinsics.checkNotNullParameter(plusAssign, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(view, "view");
        plusAssign.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams setMargins, @Px int i3) {
        Intrinsics.checkNotNullParameter(setMargins, "$this$setMargins");
        setMargins.setMargins(i3, i3, i3, i3);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams updateMargins, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        Intrinsics.checkNotNullParameter(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i3, i16, i17, i18);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams updateMargins, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = updateMargins.leftMargin;
        }
        if ((i19 & 2) != 0) {
            i16 = updateMargins.topMargin;
        }
        if ((i19 & 4) != 0) {
            i17 = updateMargins.rightMargin;
        }
        if ((i19 & 8) != 0) {
            i18 = updateMargins.bottomMargin;
        }
        Intrinsics.checkNotNullParameter(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i3, i16, i17, i18);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams updateMarginsRelative, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        Intrinsics.checkNotNullParameter(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i3);
        updateMarginsRelative.topMargin = i16;
        updateMarginsRelative.setMarginEnd(i17);
        updateMarginsRelative.bottomMargin = i18;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams updateMarginsRelative, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = updateMarginsRelative.getMarginStart();
        }
        if ((i19 & 2) != 0) {
            i16 = updateMarginsRelative.topMargin;
        }
        if ((i19 & 4) != 0) {
            i17 = updateMarginsRelative.getMarginEnd();
        }
        if ((i19 & 8) != 0) {
            i18 = updateMarginsRelative.bottomMargin;
        }
        Intrinsics.checkNotNullParameter(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i3);
        updateMarginsRelative.topMargin = i16;
        updateMarginsRelative.setMarginEnd(i17);
        updateMarginsRelative.bottomMargin = i18;
    }
}
