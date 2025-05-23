package gz;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"Lgz/a;", "Lgz/d;", "", "d", "Landroid/view/Window;", "window", "", "g", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.f173281zq);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // gz.d
    protected int d() {
        return R.layout.d0d;
    }

    @Override // gz.d
    protected void g(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
    }
}
