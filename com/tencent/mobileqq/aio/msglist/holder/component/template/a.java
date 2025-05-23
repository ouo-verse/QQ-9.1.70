package com.tencent.mobileqq.aio.msglist.holder.component.template;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.util.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/a;", "", "", "e", "Landroid/content/Context;", "context", "", "msg", "Landroid/view/View;", "d", "tag", "Ljava/lang/Exception;", "exception", "", "a", "b", "Z", "c", "()Z", "f", "(Z)V", "debug", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f191886a;

    /* renamed from: b, reason: from kotlin metadata */
    private static boolean debug;

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        a aVar = new a();
        f191886a = aVar;
        if (!b.f362976b.isPublicVersion() && aVar.e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        debug = z16;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void b(a aVar, String str, String str2, Exception exc, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            exc = null;
        }
        aVar.a(str, str2, exc);
    }

    private final boolean e() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getBoolean("TemplateMsgDebug", false);
    }

    public final void a(@NotNull String tag, @NotNull String msg2, @Nullable Exception exception) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tag, msg2, exception);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!debug) {
            return;
        }
        QLog.d(tag, 1, msg2, exception);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return debug;
    }

    @NotNull
    public final View d(@NotNull Context context, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = new TextView(context);
        if (msg2 == null) {
            msg2 = "\u6a21\u677f\u6d88\u606f\uff0c\u4f46\u662f\u6ca1\u52a0\u8f7d\u51fa\u6765";
        }
        textView.setText(msg2);
        textView.setTextSize(10.0f);
        textView.setTextColor(Color.parseColor("#77FF0000"));
        int dpToPx = ViewUtils.dpToPx(1.0f);
        textView.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        textView.setMaxWidth(ViewUtils.dpToPx(200.0f));
        return textView;
    }

    public final void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            debug = z16;
        }
    }
}
