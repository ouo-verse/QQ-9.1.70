package com.tencent.qqnt.markdown.pic;

import android.graphics.drawable.Drawable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/markdown/pic/a;", "", "Lcom/tencent/android/androidbypass/span/a;", TtmlNode.TAG_SPAN, "", "a", "localPath", "Lcom/tencent/android/androidbypass/enhance/h$b;", "drawable", "", "b", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359431a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359431a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(@Nullable com.tencent.android.androidbypass.span.a span) {
        Drawable drawable;
        h.b bVar;
        Object obj;
        Map<String, Object> d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) span);
        }
        if (span != null) {
            drawable = span.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable instanceof h.b) {
            bVar = (h.b) drawable;
        } else {
            bVar = null;
        }
        if (bVar != null && (d16 = bVar.d()) != null) {
            obj = d16.get("proxy_local_path");
        } else {
            obj = null;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public final void b(@NotNull String localPath, @NotNull h.b drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) localPath, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> d16 = drawable.d();
        Intrinsics.checkNotNullExpressionValue(d16, "drawable.extraData");
        d16.put("proxy_local_path", localPath);
    }
}
