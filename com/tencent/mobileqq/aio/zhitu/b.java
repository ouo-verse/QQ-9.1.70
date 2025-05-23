package com.tencent.mobileqq.aio.zhitu;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.aio.input.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/zhitu/b;", "", "", "msg", "", "a", "", "b", "Landroid/content/Context;", "context", "text", "Lcom/tencent/mobileqq/aio/input/g;", "input", "c", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f194275a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65353);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f194275a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@NotNull String msg2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).intValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (TextUtils.isEmpty(msg2)) {
            return -1;
        }
        int length = msg2.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = msg2.charAt(i3);
            boolean z27 = true;
            if ('\u2100' <= charAt && charAt < '\u2800') {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return i3;
            }
            if ('\u2934' <= charAt && charAt < '\u2936') {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return i3;
            }
            if ('\u2b05' <= charAt && charAt < '\u2b08') {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                return i3;
            }
            if ('\u2b1b' <= charAt && charAt < '\u2b1d') {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                return i3;
            }
            if (charAt != '\u00a9' && charAt != '\u00ae' && charAt != '\u203c' && charAt != '\u2049' && charAt != '\u2b50' && charAt != '\u2b55' && charAt != '\u3030' && charAt != '\u303d' && charAt != '\u3297' && charAt != '\u3299') {
                if ('\ud800' <= charAt && charAt < '\udc00') {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26 && i3 < msg2.length() - 1) {
                    char charAt2 = msg2.charAt(i3 + 1);
                    if ('\udc00' > charAt2 || charAt2 >= '\ue000') {
                        z27 = false;
                    }
                    if (z27) {
                        return i3;
                    }
                } else if (charAt == '\u20e3') {
                    return i3;
                }
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final boolean b(@NotNull String msg2) {
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!TextUtils.isEmpty(msg2)) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) msg2, (char) 20, 0, false, 6, (Object) null);
            if (-1 == indexOf$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean c(@Nullable Context context, @NotNull String text, @NotNull g input) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, context, text, input)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(input, "input");
        Float c16 = input.c();
        Integer b16 = input.b();
        Integer a16 = input.a();
        if (context != null && c16 != null && b16 != null && a16 != null) {
            Paint paint = new Paint();
            Typeface d16 = input.d();
            if (d16 != null) {
                paint.setTypeface(d16);
            }
            paint.setTextSize(c16.floatValue());
            if (text.length() < 20) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) "\n", false, 2, (Object) null);
                if (contains$default || ((int) paint.measureText(text)) + BaseAIOUtils.f(45.0f, context.getResources()) + b16.intValue() >= a16.intValue()) {
                    return false;
                }
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputRightIconVM", 2, "isInputTextFitInOneLine: false context is null");
        }
        return false;
    }
}
