package com.tencent.biz.qqcircle.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "", "ignoreViews", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class cp {
    @NotNull
    public static final List<View> a(@NotNull View view, @NotNull List<? extends View> ignoreViews, @NotNull View rootView) {
        ViewGroup viewGroup;
        List<View> emptyList;
        List<View> emptyList2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(ignoreViews, "ignoreViews");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ArrayList arrayList = new ArrayList();
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        if (Intrinsics.areEqual(viewGroup, rootView)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = viewGroup.getChildAt(i3);
            if (!Intrinsics.areEqual(child, view) && !ignoreViews.contains(child)) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                arrayList.add(child);
            }
        }
        arrayList.addAll(a(viewGroup, ignoreViews, rootView));
        return arrayList;
    }
}
