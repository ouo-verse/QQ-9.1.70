package com.tencent.mobileqq.wink.publish.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/f;", "", "Landroid/content/Context;", "context", "", "text", "", "a", "Landroid/widget/Toast;", "b", "Landroid/widget/Toast;", "showingToast", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f325978a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Toast showingToast;

    f() {
    }

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull String text) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        isBlank = StringsKt__StringsJVMKt.isBlank(text);
        if (isBlank) {
            return;
        }
        Toast toast = showingToast;
        if (toast != null) {
            toast.cancel();
        }
        TextView textView = new TextView(context.getApplicationContext());
        textView.setBackgroundResource(R.drawable.ko6);
        textView.setTextColor(-1);
        textView.setText(text);
        QFixToast qFixToast = new QFixToast(context.getApplicationContext());
        qFixToast.setView(textView);
        qFixToast.setGravity(17, 0, ImmersiveUtils.dpToPx(-60.0f));
        showingToast = qFixToast;
        qFixToast.show();
    }
}
