package com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.BubblePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/UiUtils;", "", "()V", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class UiUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/UiUtils$Companion;", "", "()V", "createContent", "Landroid/widget/TextView;", "ctx", "Landroid/content/Context;", "showProfileSignGuideAsDropDown", "", "view", "Landroid/view/View;", "xoff", "", "yoff", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final TextView createContent(Context ctx) {
            TextView textView = new TextView(ctx);
            int dpToPx = ViewUtils.dpToPx(5.0f);
            textView.setPadding(dpToPx, 0, dpToPx, 0);
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setText(R.string.per);
            return textView;
        }

        public final void showProfileSignGuideAsDropDown(@NotNull View view, int xoff, int yoff) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(xoff), Integer.valueOf(yoff));
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            bubblePopupWindow.setContentView(createContent(context));
            bubblePopupWindow.setOnDismissListener(null);
            bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            bubblePopupWindow.setOutsideTouchable(true);
            bubblePopupWindow.setFocusable(false);
            bubblePopupWindow.showAsDropDown(view, xoff, yoff);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UiUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
