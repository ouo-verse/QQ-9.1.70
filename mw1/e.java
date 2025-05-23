package mw1;

import android.content.res.ColorStateList;
import android.view.View;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lmw1/e;", "Lmw1/c;", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e implements c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f417710d = new e();

    e() {
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull b helper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof SingleLineTextView)) {
            return;
        }
        SingleLineTextView singleLineTextView = (SingleLineTextView) view;
        ColorStateList textColor = singleLineTextView.getTextColor();
        if (textColor != null) {
            ColorStateList b16 = helper.b(textColor);
            if (!Intrinsics.areEqual(b16, textColor)) {
                singleLineTextView.setTextColor(b16);
            }
        }
        int extendTextCount = singleLineTextView.getExtendTextCount();
        for (int i3 = 0; i3 < extendTextCount; i3++) {
            ColorStateList extendTextColor = singleLineTextView.getExtendTextColor(i3);
            if (extendTextColor != null) {
                ColorStateList b17 = helper.b(extendTextColor);
                if (!Intrinsics.areEqual(b17, extendTextColor)) {
                    singleLineTextView.setExtendTextColor(b17, i3);
                }
            }
        }
    }
}
