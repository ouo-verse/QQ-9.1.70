package com.tencent.qqnt.structmsg.element;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0004J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\b\u0010\u000f\u001a\u00020\tH\u0004R\u001a\u0010\u0014\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/structmsg/element/a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "convertView", "Landroid/os/Bundle;", "args", "a", "", "d", "Ljava/lang/Class;", "Landroid/widget/TextView;", "f", "e", "b", "Lcom/tencent/qqnt/structmsg/element/b;", "Lcom/tencent/qqnt/structmsg/element/b;", "c", "()Lcom/tencent/qqnt/structmsg/element/b;", "richText", "<init>", "(Lcom/tencent/qqnt/structmsg/element/b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b richText;

    public a(@NotNull b richText) {
        Intrinsics.checkNotNullParameter(richText, "richText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) richText);
        } else {
            this.richText = richText;
        }
    }

    @NotNull
    public final View a(@NotNull Context context, @Nullable View convertView, @Nullable Bundle args) {
        TextView e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, convertView, args);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (convertView != null && f().isInstance(convertView)) {
            e16 = (TextView) convertView;
        } else {
            e16 = e(context);
            e16.setId(d());
        }
        e16.setTag(this);
        e16.setText(c().c());
        e16.setMaxLines(b());
        e16.setEllipsize(TextUtils.TruncateAt.END);
        e16.setTextSize(2, c().e());
        e16.setTextColor(c().d());
        return e16;
    }

    protected final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 2;
    }

    @NotNull
    public b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.richText;
    }

    public abstract int d();

    @NotNull
    protected final TextView e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TextView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (StructMsgTextView.class.isAssignableFrom(f())) {
            return new StructMsgTextView(context);
        }
        return new TextView(context);
    }

    @NotNull
    protected final Class<? extends TextView> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TextView.class;
    }
}
