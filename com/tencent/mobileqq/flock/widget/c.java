package com.tencent.mobileqq.flock.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/flock/widget/c;", "", "", "j", "i", "", "k", "Landroid/widget/EditText;", "a", "Landroid/widget/EditText;", "input", "b", "I", "maxLength", "", "c", "Z", "enableEmoji", "d", "showLimitedToast", "", "e", "Ljava/lang/String;", "newlineReplacement", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "remainingCountText", "g", "lastText", "<init>", "(Landroid/widget/EditText;IZZLjava/lang/String;Landroid/widget/TextView;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText input;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maxLength;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean enableEmoji;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean showLimitedToast;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String newlineReplacement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView remainingCountText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String lastText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/widget/c$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TextView textView = c.this.remainingCountText;
                if (textView != null) {
                    c cVar = c.this;
                    textView.setText(String.valueOf(cVar.maxLength - cVar.k()));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c.this.lastText = String.valueOf(s16);
            } else {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
        
            if (r13 == true) goto L23;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            String replace$default;
            String obj;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            if (c.this.k() > c.this.maxLength) {
                c.this.input.setText(c.this.lastText);
                c.this.input.setSelection(c.this.input.getText().length());
                if (c.this.showLimitedToast) {
                    QQToast.makeText(c.this.input.getContext(), -1, "\u6700\u591a" + c.this.maxLength + "\u4e2a\u5b57\u54e6", 0).show();
                }
            }
            String str = c.this.newlineReplacement;
            if (str != null) {
                c cVar = c.this;
                if (s16 != null && (obj = s16.toString()) != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) obj, (CharSequence) "\n", false, 2, (Object) null);
                }
                z16 = false;
                if (z16) {
                    EditText editText = cVar.input;
                    replace$default = StringsKt__StringsJVMKt.replace$default(s16.toString(), "\n", str, false, 4, (Object) null);
                    editText.setText(replace$default);
                    cVar.input.setSelection(cVar.input.getText().length());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flock/widget/c$b", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends Editable.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@Nullable CharSequence source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
            }
            if (source instanceof QQTextBuilder) {
                return (Editable) source;
            }
            return new QQTextBuilder(source, 3, 20);
        }
    }

    public c(@NotNull EditText input, int i3, boolean z16, boolean z17, @Nullable String str, @Nullable TextView textView) {
        Intrinsics.checkNotNullParameter(input, "input");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, input, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), str, textView);
            return;
        }
        this.input = input;
        this.maxLength = i3;
        this.enableEmoji = z16;
        this.showLimitedToast = z17;
        this.newlineReplacement = str;
        this.remainingCountText = textView;
        this.lastText = "";
        j();
        i();
    }

    private final void i() {
        this.input.addTextChangedListener(new a());
    }

    private final void j() {
        if (this.enableEmoji) {
            this.input.setEditableFactory(new b());
        }
        TextView textView = this.remainingCountText;
        if (textView != null) {
            textView.setText(String.valueOf(this.maxLength));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k() {
        return TextUtils.getQQTextCharCount(this.input.getText().toString(), 3);
    }

    public /* synthetic */ c(EditText editText, int i3, boolean z16, boolean z17, String str, TextView textView, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(editText, i3, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? null : str, (i16 & 32) != 0 ? null : textView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, editText, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), str, textView, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
