package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u00063B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b,\u00100B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u00102J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016RA\u0010!\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "sel", "spanStart", "spanEnd", "a", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyPreIme", "id", "onTextContextMenuItem", "eventStart", "eventEnd", "", "onSelectionChanged", "performLongClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ev", "E", "Lkotlin/jvm/functions/Function1;", "getOnKeyEventPreImeListener", "()Lkotlin/jvm/functions/Function1;", "setOnKeyEventPreImeListener", "(Lkotlin/jvm/functions/Function1;)V", "onKeyEventPreImeListener", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;", "getCustomClipboardCopyListener", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;", "setCustomClipboardCopyListener", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;)V", "customClipboardCopyListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedEditText extends AppCompatEditText {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super KeyEvent, Boolean> onKeyEventPreImeListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a customClipboardCopyListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;", "", "", "a", "b", "onCopy", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        boolean a();

        boolean b();

        boolean onCopy();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$b;", "Landroid/view/inputmethod/InputConnectionWrapper;", "", "beforeLength", "afterLength", "", "deleteSurroundingText", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "a", "Lmqq/util/WeakReference;", "editText", "Landroid/view/inputmethod/InputConnection;", "target", "mutable", "<init>", "(Lmqq/util/WeakReference;Landroid/view/inputmethod/InputConnection;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildFeedEditText> editText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull WeakReference<GuildFeedEditText> editText, @Nullable InputConnection inputConnection, boolean z16) {
            super(inputConnection, z16);
            Intrinsics.checkNotNullParameter(editText, "editText");
            this.editText = editText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            GuildFeedEditText guildFeedEditText;
            if (beforeLength == 1 && afterLength == 0 && (guildFeedEditText = this.editText.get()) != null) {
                return guildFeedEditText.onKeyDown(67, new KeyEvent(0, 67));
            }
            return super.deleteSurroundingText(beforeLength, afterLength);
        }

        public /* synthetic */ b(WeakReference weakReference, InputConnection inputConnection, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(weakReference, inputConnection, (i3 & 4) != 0 ? false : z16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int a(int sel, int spanStart, int spanEnd) {
        int i3 = (spanStart + spanEnd) / 2;
        boolean z16 = false;
        if (spanStart + 1 <= sel && sel < spanEnd) {
            z16 = true;
        }
        if (z16) {
            if (sel < i3) {
                return spanStart;
            }
            return spanEnd;
        }
        return sel;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @NotNull
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        return new b(new WeakReference(this), super.onCreateInputConnection(outAttrs), false, 4, null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, @Nullable KeyEvent event) {
        Function1<? super KeyEvent, Boolean> function1 = this.onKeyEventPreImeListener;
        if (function1 != null) {
            return function1.invoke(event).booleanValue();
        }
        return super.onKeyPreIme(keyCode, event);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    @Override // android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onSelectionChanged(int eventStart, int eventEnd) {
        boolean z16;
        boolean z17;
        setHapticFeedbackEnabled(true);
        Editable text = getText();
        if (!(text instanceof Spanned)) {
            super.onSelectionChanged(eventStart, eventEnd);
            return;
        }
        sk1.b[] bVarArr = (sk1.b[]) text.getSpans(eventStart, eventEnd, sk1.b.class);
        if (bVarArr != null) {
            if (bVarArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    super.onSelectionChanged(eventStart, eventEnd);
                    return;
                }
                sk1.b bVar = bVarArr[0];
                sk1.b bVar2 = bVarArr[bVarArr.length - 1];
                int spanStart = text.getSpanStart(bVar);
                int spanEnd = text.getSpanEnd(bVar2);
                setHapticFeedbackEnabled(false);
                if (eventStart == eventEnd && (spanStart == eventStart || spanEnd == eventEnd)) {
                    return;
                }
                int a16 = a(eventStart, spanStart, spanEnd);
                int a17 = a(eventEnd, spanStart, spanEnd);
                setSelection(a16, a17);
                super.onSelectionChanged(a16, a17);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int id5) {
        boolean z16 = false;
        switch (id5) {
            case 16908320:
                a aVar = this.customClipboardCopyListener;
                if (aVar != null && aVar.b()) {
                    z16 = true;
                }
                if (z16) {
                    return true;
                }
                return super.onTextContextMenuItem(id5);
            case 16908321:
                a aVar2 = this.customClipboardCopyListener;
                if (aVar2 != null && aVar2.onCopy()) {
                    z16 = true;
                }
                if (z16) {
                    return true;
                }
                return super.onTextContextMenuItem(id5);
            case 16908322:
                a aVar3 = this.customClipboardCopyListener;
                if (aVar3 != null && aVar3.a()) {
                    z16 = true;
                }
                if (z16) {
                    return true;
                }
                return super.onTextContextMenuItem(id5);
            default:
                return super.onTextContextMenuItem(id5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        setHapticFeedbackEnabled(true);
        return super.performLongClick();
    }

    public final void setCustomClipboardCopyListener(@Nullable a aVar) {
        this.customClipboardCopyListener = aVar;
    }

    public final void setOnKeyEventPreImeListener(@Nullable Function1<? super KeyEvent, Boolean> function1) {
        this.onKeyEventPreImeListener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
