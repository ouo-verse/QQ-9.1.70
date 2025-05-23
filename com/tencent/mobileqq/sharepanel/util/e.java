package com.tencent.mobileqq.sharepanel.util;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/util/e;", "Landroid/text/InputFilter$LengthFilter;", "", "b", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "", "d", "Ljava/lang/String;", "tips", "max", "<init>", "(ILjava/lang/String;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends InputFilter.LengthFilter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, @NotNull String tips) {
        super(i3);
        Intrinsics.checkNotNullParameter(tips, "tips");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) tips);
        } else {
            this.tips = tips;
        }
    }

    private final void b() {
        boolean z16;
        if (this.tips.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.util.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(MobileQQ.sMobileQQ, 1, this$0.tips, 0).show();
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    @Nullable
    public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, source, Integer.valueOf(start), Integer.valueOf(end), dest, Integer.valueOf(dstart), Integer.valueOf(dend));
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        CharSequence filter = super.filter(source, start, end, dest, dstart, dend);
        if (filter != null) {
            b();
        }
        return filter;
    }
}
