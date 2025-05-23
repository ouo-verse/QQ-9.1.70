package com.tencent.android.androidbypass.enhance.method;

import android.text.Spannable;
import android.text.Spanned;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/method/a;", "", "", "Lcom/tencent/android/androidbypass/codeblock/span/CodeBlockSpan;", "codeBlockSpanList", "", HippyTKDListViewAdapter.X, "y", "", "a", "Landroid/widget/TextView;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "b", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private final boolean a(List<CodeBlockSpan> codeBlockSpanList, float x16, float y16) {
        if (codeBlockSpanList != null) {
            Iterator<T> it = codeBlockSpanList.iterator();
            while (it.hasNext()) {
                if (((CodeBlockSpan) it.next()).p(x16, y16)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean b(@NotNull TextView widget, @Nullable Spannable buffer, @NotNull MotionEvent event) {
        List<CodeBlockSpan> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, widget, buffer, event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1 || !(widget.getText() instanceof Spanned)) {
            return false;
        }
        CharSequence text = widget.getText();
        if (text != null) {
            CodeBlockSpan[] codeBlockSpanArr = (CodeBlockSpan[]) ((Spanned) text).getSpans(0, ((Spanned) widget.getText()).length(), CodeBlockSpan.class);
            if (codeBlockSpanArr != null) {
                list = ArraysKt___ArraysJvmKt.asList(codeBlockSpanArr);
            } else {
                list = null;
            }
            return a(list, event.getX(), event.getY());
        }
        throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
    }
}
