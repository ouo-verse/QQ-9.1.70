package dn2;

import android.text.TextUtils;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Ldn2/d;", "", "", "text", "Landroid/widget/TextView;", "textView", "", "a", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f394315a = new d();

    d() {
    }

    public final void a(@Nullable String text, @Nullable TextView textView) {
        if (TextUtils.isEmpty(text)) {
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setText(text);
        }
        if (textView != null) {
            textView.setContentDescription(text);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
