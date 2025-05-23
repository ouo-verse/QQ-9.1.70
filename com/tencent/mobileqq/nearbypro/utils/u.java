package com.tencent.mobileqq.nearbypro.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003J.\u0010\r\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/u;", "", "Lcom/tencent/mobileqq/nearbypro/part/a;", "", "inflateId", "Landroid/view/View;", "b", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "tag", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f253961a = new u();

    u() {
    }

    @NotNull
    public final View a(@Nullable com.tencent.mobileqq.nearbypro.part.a aVar, @NotNull Context context, int i3, @NotNull ViewGroup rootView, @NotNull String tag) {
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(tag, "tag");
        boolean z16 = false;
        if (aVar != null) {
            view = b(aVar, i3);
            if (view != null) {
                rootView.addView(view);
                z16 = true;
            } else {
                view = LayoutInflater.from(context).inflate(i3, rootView, false);
                rootView.addView(view);
            }
        } else {
            view = LayoutInflater.from(context).inflate(i3, rootView, false);
            rootView.addView(view);
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.PreloadPart", "getMarkerView tag:" + tag + " getPreload:" + z16);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Nullable
    public final View b(@NotNull com.tencent.mobileqq.nearbypro.part.a aVar, int i3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Object e65 = aVar.e6("msg_get_preload_marker_view", Integer.valueOf(i3));
        if (e65 instanceof View) {
            return (View) e65;
        }
        return null;
    }
}
