package com.tencent.qqnt.structmsg.element;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/structmsg/element/b;", "", "", "a", "", "b", "", "c", "d", "e", "Lcom/tencent/qqnt/structmsg/c;", "Lcom/tencent/qqnt/structmsg/c;", "getNode", "()Lcom/tencent/qqnt/structmsg/c;", "node", "<init>", "(Lcom/tencent/qqnt/structmsg/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.structmsg.c node;

    public b(@NotNull com.tencent.qqnt.structmsg.c node) {
        Intrinsics.checkNotNullParameter(node, "node");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) node);
        } else {
            this.node = node;
        }
    }

    private final int a() {
        return -16777216;
    }

    private final float b() {
        return 26.0f;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.node.f362294a;
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            String b16 = this.node.b("color");
            if (TextUtils.isEmpty(b16)) {
                return a();
            }
            return Color.parseColor(b16);
        } catch (Exception unused) {
            return a();
        }
    }

    public final float e() {
        float parseFloat;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        try {
            String sizeStr = this.node.b("size");
            if (TextUtils.isEmpty(sizeStr)) {
                parseFloat = b();
            } else {
                Intrinsics.checkNotNullExpressionValue(sizeStr, "sizeStr");
                parseFloat = Float.parseFloat(sizeStr);
            }
            return parseFloat / 2;
        } catch (Exception unused) {
            return b();
        }
    }
}
