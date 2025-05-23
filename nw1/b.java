package nw1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnw1/b;", "Lmw1/c;", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements mw1.c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f421452d = new b();

    b() {
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull mw1.b helper) {
        ColorStateList b16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof ImageView)) {
            return;
        }
        ImageView imageView = (ImageView) view;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.getContext()");
            Drawable a16 = helper.a(context, drawable);
            if (a16 != drawable) {
                ((ImageView) view).setImageDrawable(a16);
            }
        }
        ColorStateList imageTintList = imageView.getImageTintList();
        if (imageTintList != null && (b16 = helper.b(imageTintList)) != imageTintList) {
            imageView.setImageTintList(b16);
        }
    }
}
