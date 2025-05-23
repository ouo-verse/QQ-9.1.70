package com.tencent.mobileqq.troop.troopsetting.modules.nickname;

import android.graphics.Paint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/nickname/a;", "", "Lcom/tencent/mobileqq/text/QQText;", "qt", "Landroid/graphics/Paint;", "paint", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301205a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301205a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a(@NotNull QQText qt5, @NotNull Paint paint) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qt5, "qt");
        Intrinsics.checkNotNullParameter(paint, "paint");
        String purePlainText = qt5.toPurePlainText();
        Intrinsics.checkNotNullExpressionValue(purePlainText, "qt.toPurePlainText()");
        int i3 = 0;
        if (purePlainText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = (int) paint.measureText(qt5.toPurePlainText());
        }
        return i3 + (ViewUtils.dip2px(16.0f) * qt5.mSpanCount);
    }
}
