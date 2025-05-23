package com.tencent.qqnt.utils;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/utils/a;", "", "Landroid/widget/ImageView;", "imageView", "", "itemBgColor", "", "b", "Landroid/view/View;", "view", "", HippyTKDListViewAdapter.X, "y", "", "a", "<init>", "()V", "text_preview_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f363000a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f363000a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull View view, int x16, int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(x16), Integer.valueOf(y16))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        rect.left = i3;
        int i16 = iArr[1];
        rect.top = i16;
        rect.right += i3;
        rect.bottom += i16;
        return rect.contains(x16, y16);
    }

    public final void b(@NotNull ImageView imageView, @NotNull String itemBgColor) {
        boolean startsWith$default;
        String replace$default;
        String replace$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView, (Object) itemBgColor);
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(itemBgColor, "itemBgColor");
        if (!TextUtils.isEmpty(itemBgColor)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(itemBgColor, "#", false, 2, null);
            if (!startsWith$default) {
                itemBgColor = '#' + itemBgColor;
            }
            String str = itemBgColor;
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "#", "#7F", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(str, "#", "#4C", false, 4, (Object) null);
            imageView.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(replace$default), Color.parseColor(replace$default2)}));
        }
    }
}
