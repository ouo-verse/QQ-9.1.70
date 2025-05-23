package com.tencent.mobileqq.proavatar.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/a;", "", "Landroid/view/View;", "view", "", "c", "", "msg", "a", "Landroid/graphics/drawable/Drawable;", "drawable", "", "scalePercent", "b", "d", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f259716a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33903);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f259716a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void c(@Nullable View view) {
        f259716a.d(view, 0.15f);
    }

    public static /* synthetic */ void e(a aVar, Drawable drawable, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.15f;
        }
        aVar.b(drawable, f16);
    }

    public final void b(@NotNull Drawable drawable, float scalePercent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, drawable, Float.valueOf(scalePercent));
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable.Callback callback = drawable.getCallback();
        if (callback instanceof View) {
            d((View) callback, scalePercent);
        }
    }

    public final void d(@Nullable View view, float scalePercent) {
        float coerceAtMost;
        int coerceAtLeast;
        int coerceAtLeast2;
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view2, Float.valueOf(scalePercent));
            return;
        }
        if (view2 != null && scalePercent > 0.0f) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(scalePercent, 1.0f);
            a("disableClipOnParents view: " + view2);
            int width = (int) (((float) view.getWidth()) * coerceAtMost);
            int height = (int) (((float) view.getHeight()) * coerceAtMost);
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                i16 += i3;
                Object parent = view2.getParent();
                if (parent instanceof ViewGroup) {
                    arrayList.add(parent);
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int left = viewGroup.getLeft();
                    int right = viewGroup.getRight();
                    int top = viewGroup.getTop();
                    int bottom = viewGroup.getBottom();
                    StringBuilder sb5 = new StringBuilder();
                    ArrayList<ViewGroup> arrayList2 = arrayList;
                    sb5.append("disableClipOnParents level_");
                    sb5.append(i16);
                    sb5.append(" [");
                    sb5.append(left);
                    sb5.append(", ");
                    sb5.append(right);
                    sb5.append(", ");
                    sb5.append(top);
                    sb5.append(", ");
                    sb5.append(bottom);
                    sb5.append("]");
                    a(sb5.toString());
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(view2.getLeft(), 0);
                    i17 += coerceAtLeast;
                    i18 += viewGroup.getWidth() - view2.getRight();
                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(view2.getTop(), 0);
                    i19 += coerceAtLeast2;
                    a("disableClipOnParents add parent: " + parent);
                    if (i17 >= width && i18 >= width && i19 >= height) {
                        a("disableClipOnParents clip level: " + i16);
                        for (ViewGroup viewGroup2 : arrayList2) {
                            a("disableClipOnParents " + viewGroup2);
                            viewGroup2.setTag(R.id.f27770h5, Boolean.valueOf(viewGroup2.getClipChildren()));
                            viewGroup2.setTag(R.id.f27780h6, Boolean.valueOf(viewGroup2.getClipToPadding()));
                            viewGroup2.setClipChildren(false);
                            viewGroup2.setClipToPadding(false);
                        }
                        return;
                    }
                    view2 = (View) parent;
                    arrayList = arrayList2;
                    i3 = 1;
                } else {
                    a("disableClipOnParents parent not viewGroup. parent: " + parent);
                    return;
                }
            }
        }
    }

    private final void a(String msg2) {
    }
}
