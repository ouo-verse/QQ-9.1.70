package com.tencent.mobileqq.reminder.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "originView", "", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f281112a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f281112a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context, @Nullable View originView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) originView);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (originView == null || (originView instanceof TextView) || FontSettingManager.isFontSizeNormal()) {
            return;
        }
        if (originView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) originView;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                a(context, viewGroup.getChildAt(i3));
            }
        }
        originView.setPadding((int) FontSettingManager.revertSize2Normal(context, originView.getPaddingLeft()), (int) FontSettingManager.revertSize2Normal(context, originView.getPaddingTop()), (int) FontSettingManager.revertSize2Normal(context, originView.getPaddingRight()), (int) FontSettingManager.revertSize2Normal(context, originView.getPaddingBottom()));
        ViewGroup.LayoutParams layoutParams = originView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = (int) FontSettingManager.revertSize2Normal(context, marginLayoutParams.bottomMargin);
            marginLayoutParams.topMargin = (int) FontSettingManager.revertSize2Normal(context, marginLayoutParams.topMargin);
            marginLayoutParams.leftMargin = (int) FontSettingManager.revertSize2Normal(context, marginLayoutParams.leftMargin);
            marginLayoutParams.rightMargin = (int) FontSettingManager.revertSize2Normal(context, marginLayoutParams.rightMargin);
        }
        int i16 = layoutParams.width;
        if (i16 != -1 && i16 != -2) {
            layoutParams.width = (int) FontSettingManager.revertSize2Normal(context, i16);
        }
        int i17 = layoutParams.height;
        if (i17 != -1 && i17 != -2) {
            layoutParams.height = (int) FontSettingManager.revertSize2Normal(context, i17);
        }
        originView.setLayoutParams(layoutParams);
    }
}
