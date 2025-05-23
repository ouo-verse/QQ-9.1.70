package com.tencent.android.androidbypass.parser.api;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.android.androidbypass.enhance.j;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/android/androidbypass/parser/api/c;", "Lcom/tencent/android/androidbypass/enhance/d;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "b", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "text", "Landroid/widget/TextView;", "tv", "Lcom/tencent/android/androidbypass/enhance/j;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/android/androidbypass/parser/api/b;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mOnUrlClickListeners", "<init>", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c implements com.tencent.android.androidbypass.enhance.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<b> mOnUrlClickListeners;

    public c(@NotNull CopyOnWriteArrayList<b> mOnUrlClickListeners) {
        Intrinsics.checkNotNullParameter(mOnUrlClickListeners, "mOnUrlClickListeners");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mOnUrlClickListeners);
        } else {
            this.mOnUrlClickListeners = mOnUrlClickListeners;
        }
    }

    private final d b(String url) {
        if (url == null) {
            return null;
        }
        return d.INSTANCE.a(url);
    }

    @Override // com.tencent.android.androidbypass.enhance.d
    @Nullable
    public j a(@Nullable String link, @Nullable String text, @Nullable TextView tv5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (j) iPatchRedirector.redirect((short) 1, this, link, text, tv5);
        }
        d b16 = b(link);
        if (b16 != null) {
            if (!TextUtils.isEmpty(b16.c()) && !TextUtils.isEmpty(b16.d())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                b16 = null;
            }
            if (b16 != null) {
                Iterator<b> it = this.mOnUrlClickListeners.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.a(link, b16, text)) {
                        return next;
                    }
                }
            }
        }
        return null;
    }
}
