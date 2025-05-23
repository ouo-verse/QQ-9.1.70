package com.tencent.mobileqq.aio.input.edit;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u0001:\u0005DEFGHB\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=B\u001b\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b<\u0010@B#\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010A\u001a\u00020\u0002\u00a2\u0006\u0004\b<\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010#\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\b\u0010'\u001a\u00020\u0004H\u0016R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020\n02j\b\u0012\u0004\u0012\u00020\n`38\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "id", "", "onTextContextMenuItem", "Landroid/view/KeyEvent;", "event", "dispatchKeyEventPreIme", "dispatchKeyEvent", "Landroid/view/View$OnKeyListener;", "l", "", "setOnKeyListener", "", "action", "Landroid/os/Bundle;", "data", "onPrivateIMECommand", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$d;", "listener", h.F, "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$c;", "setOnKeyEventPreImeListener", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$e;", "setOnPrivateIMECommandListener", "i", "", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "performLongClick", "", "E", "Ljava/util/List;", "mTextMenuListenerList", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$c;", "mOnKeyEventPreImeListener", "G", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$e;", "mOnPrivateIMECommandListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mKeyListenerList", "I", "Landroid/view/View$OnKeyListener;", "mKeyListenerDelegate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "b", "c", "d", "e", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOEditText extends AppCompatEditText {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int K;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<d> mTextMenuListenerList;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private c mOnKeyEventPreImeListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private e mOnPrivateIMECommandListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<View.OnKeyListener> mKeyListenerList;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View.OnKeyListener mKeyListenerDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$b;", "", "", "MAX_INPUT_LENGTH", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.edit.AIOEditText$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOEditText.K;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$c;", "", "Landroid/view/KeyEvent;", "event", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface c {
        boolean a(@Nullable KeyEvent event);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$d;", "", "", "id", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface d {
        boolean a(int id5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$e;", "", "", "action", "Landroid/os/Bundle;", "data", "", "onPrivateIMECommand", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface e {
        boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/input/edit/AIOEditText$f", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEditText.this);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@NotNull View v3, int keyCode, @NotNull KeyEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(keyCode), event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            while (true) {
                boolean z16 = false;
                for (View.OnKeyListener onKeyListener : AIOEditText.this.mKeyListenerList) {
                    if (z16 || onKeyListener.onKey(v3, keyCode, event)) {
                        z16 = true;
                    }
                }
                return z16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
            K = BaseApplication.getContext().getResources().getInteger(R.integer.f167165o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mTextMenuListenerList = new ArrayList();
            this.mKeyListenerList = new ArrayList<>();
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@Nullable KeyEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) event)).booleanValue();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(@Nullable KeyEvent event) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) event)).booleanValue();
        }
        c cVar = this.mOnKeyEventPreImeListener;
        if (cVar != null && cVar.a(event)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || super.dispatchKeyEventPreIme(event)) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mTextMenuListenerList.add(listener);
        }
    }

    public final boolean i(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, id5)).booleanValue();
        }
        try {
            return super.onTextContextMenuItem(id5);
        } catch (Exception e16) {
            QLog.w("AIOEditText", 1, "[doOnTextContextMenuItem]: ", e16);
            return false;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (InputConnection) iPatchRedirector.redirect((short) 9, (Object) this, (Object) outAttrs);
        }
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        if (getParent() == null) {
            QLog.e("AIOEditText", 1, "createInputConnection to an orphan editText!!");
        }
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        QLog.i("AIOEditText", 1, "[onCreateInputConnection]: connection is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            QLog.i("AIOEditText", 1, "[onCreateInputConnection]: isEnable= " + isEnabled() + ", inputType= " + getInputType() + ", text= " + ((Object) getEditableText()));
            return onCreateInputConnection;
        }
        a aVar = new a(this, onCreateInputConnection, false, 2, null);
        if (getImeOptions() != 0 && (getInputType() & 131072) == 131072) {
            outAttrs.imeOptions &= -1073741825;
            outAttrs.inputType &= -131073;
        }
        return aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        String str;
        Editable editableText;
        IntStream chars;
        int[] array;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (IndexOutOfBoundsException e16) {
            if (Build.VERSION.SDK_INT >= 24 && (editableText = getEditableText()) != null) {
                chars = editableText.chars();
                array = chars.toArray();
                Intrinsics.checkNotNullExpressionValue(array, "it.chars().toArray()");
                str = ArraysKt___ArraysKt.joinToString$default(array, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) AIOEditText$onDraw$1$1.INSTANCE, 30, (Object) null);
            } else {
                str = "";
            }
            QLog.i("AIOEditText", 1, "[onMeasure] " + ((Object) getText()) + " chars: " + ((Object) str) + " exc=" + e16);
            throw new RuntimeException("measure exception: " + ((Object) getText()) + " chars: " + ((Object) str) + " exc=" + e16, e16);
        }
    }

    @Override // android.widget.TextView
    public boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) action, (Object) data)).booleanValue();
        }
        QLog.i("AIOEditText", 1, "onPrivateIMECommand, action: " + action + " data: " + data);
        e eVar = this.mOnPrivateIMECommandListener;
        if (eVar != null) {
            return eVar.onPrivateIMECommand(action, data);
        }
        return super.onPrivateIMECommand(action, data);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, id5)).booleanValue();
        }
        Iterator<d> it = this.mTextMenuListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().a(id5)) {
                return true;
            }
        }
        return i(id5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        try {
            return super.performLongClick();
        } catch (IllegalStateException e16) {
            QLog.d("AIOEditText", 1, "[performLongClick] IllegalStateException", e16);
            return false;
        }
    }

    public final void setOnKeyEventPreImeListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            this.mOnKeyEventPreImeListener = listener;
        }
    }

    @Override // android.view.View
    public void setOnKeyListener(@NotNull View.OnKeyListener l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
            return;
        }
        Intrinsics.checkNotNullParameter(l3, "l");
        if (!this.mKeyListenerList.contains(l3)) {
            this.mKeyListenerList.add(l3);
        }
        if (this.mKeyListenerDelegate == null) {
            f fVar = new f();
            this.mKeyListenerDelegate = fVar;
            super.setOnKeyListener(fVar);
        }
    }

    public final void setOnPrivateIMECommandListener(@NotNull e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mOnPrivateIMECommandListener = listener;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) text, (Object) type);
            return;
        }
        try {
            super.setText(text, type);
        } catch (Exception e16) {
            QLog.i("AIOEditText", 1, "[setText]: " + e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$a;", "Landroid/view/inputmethod/InputConnectionWrapper;", "", "beforeLength", "afterLength", "", "deleteSurroundingText", "Landroid/view/inputmethod/InputConnection;", "target", "mutable", "<init>", "(Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;Landroid/view/inputmethod/InputConnection;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    private final class a extends InputConnectionWrapper {
        static IPatchRedirector $redirector_;

        public a(@Nullable InputConnection inputConnection, boolean z16) {
            super(inputConnection, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, AIOEditText.this, inputConnection, Boolean.valueOf(z16));
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(beforeLength), Integer.valueOf(afterLength))).booleanValue();
            }
            if (beforeLength == 1 && afterLength == 0) {
                return AIOEditText.this.onKeyDown(67, new KeyEvent(0, 67));
            }
            return super.deleteSurroundingText(beforeLength, afterLength);
        }

        public /* synthetic */ a(AIOEditText aIOEditText, InputConnection inputConnection, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(inputConnection, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOEditText, inputConnection, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mTextMenuListenerList = new ArrayList();
            this.mKeyListenerList = new ArrayList<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mTextMenuListenerList = new ArrayList();
            this.mKeyListenerList = new ArrayList<>();
        }
    }
}
