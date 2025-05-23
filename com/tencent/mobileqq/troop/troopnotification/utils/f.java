package com.tencent.mobileqq.troop.troopnotification.utils;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.widget.swipe.CommonSwipeMenuLayout;
import com.tencent.widget.SimpleTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/utils/f;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "leftView", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f300930a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f300930a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View a(Context context) {
        int i3;
        SimpleTextView simpleTextView = new SimpleTextView(context);
        simpleTextView.setGravity(17);
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1 || !SimpleUIUtil.isNowElderMode()) {
            z16 = false;
        }
        if (z16) {
            i3 = 18;
        } else {
            i3 = 16;
        }
        simpleTextView.setTextSize(i3);
        simpleTextView.setId(R.id.f10321600);
        simpleTextView.setText(HardCodeUtil.qqStr(R.string.f170822ak3));
        simpleTextView.setTextColor(-1);
        simpleTextView.setBackgroundResource(R.drawable.cja);
        return simpleTextView;
    }

    @NotNull
    public final View b(@NotNull Context context, @NotNull View leftView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) leftView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(leftView, "leftView");
        CommonSwipeMenuLayout commonSwipeMenuLayout = new CommonSwipeMenuLayout(context);
        commonSwipeMenuLayout.addView(leftView, new LinearLayout.LayoutParams(-1, -2));
        commonSwipeMenuLayout.addView(a(context), new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.atw), -1));
        return commonSwipeMenuLayout;
    }
}
