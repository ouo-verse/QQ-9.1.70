package com.tencent.mobileqq.guild.base.extension;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a3\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u00a8\u0006\r"}, d2 = {"Landroid/widget/TextView;", "", "resId", "", "", "args", "", "c", "(Landroid/widget/TextView;I[Ljava/lang/Object;)V", "b", "weight", "style", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class s {
    public static final void a(@NotNull TextView textView, int i3, int i16) {
        Object m476constructorimpl;
        Typeface create;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Result.Companion companion = Result.INSTANCE;
                create = Typeface.create(null, i3, false);
                textView.setTypeface(create);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("set fontWeight fail..");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("TextViewEx", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
                return;
            }
            return;
        }
        textView.setTypeface(null, i16);
    }

    public static final void b(@NotNull TextView textView, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(ResourcesCompat.getColor(textView.getContext().getResources(), i3, textView.getContext().getTheme()));
    }

    public static final void c(@NotNull TextView textView, @StringRes int i3, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        textView.setText(textView.getResources().getString(i3, Arrays.copyOf(args, args.length)));
    }
}
