package com.tencent.gdtad.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gdtad/util/h;", "", "Landroid/view/View;", "view", "", "isClickable", "", "f", "d", "b", "", tl.h.F, "e", "c", "a", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f109554a = new h();

    h() {
    }

    private final int b(View view) {
        if (view == null) {
            return 0;
        }
        int alpha = (int) (view.getAlpha() * 100);
        QLog.d("GdtAreaAntiSpamReportUtils", 1, "getViewAlphaPercent:", Integer.valueOf(alpha));
        return alpha;
    }

    private final int d(View view) {
        return f(view, true);
    }

    private final int f(View view, boolean isClickable) {
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ViewParent parent = view.getParent();
        if (parent == null) {
            parent = (ViewGroup) view;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int width = rect.width() * rect.height();
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = viewGroup.getChildAt(i16);
            if (childAt != view && childAt.getVisibility() == 0 && (!isClickable || (isClickable && view.isClickable()))) {
                Rect rect2 = new Rect();
                childAt.getGlobalVisibleRect(rect2);
                if (Rect.intersects(rect, rect2)) {
                    i3 += ((int) (Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left))) * ((int) (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top)));
                }
            }
        }
        int i17 = 100 - ((int) (((i3 * 1.0f) / width) * 100));
        QLog.d("GdtAreaAntiSpamReportUtils", 1, "getViewVisibleAreaPercent isClickable:", Boolean.valueOf(isClickable), ",result:", Integer.valueOf(i17));
        return i17;
    }

    static /* synthetic */ int g(h hVar, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return hVar.f(view, z16);
    }

    public final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102833", false);
    }

    @NotNull
    public final String c(@Nullable View view) {
        return String.valueOf(b(view));
    }

    @NotNull
    public final String e(@Nullable View view) {
        return String.valueOf(d(view));
    }

    @NotNull
    public final String h(@Nullable View view) {
        return String.valueOf(g(this, view, false, 2, null));
    }
}
