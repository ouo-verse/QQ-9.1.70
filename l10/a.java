package l10;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Ll10/a;", "Landroid/app/Dialog;", "", "d", "Landroid/view/View;", "view", "setContentView", "", "layoutResID", "Landroid/view/ViewGroup$LayoutParams;", "params", "Landroid/content/Context;", "context", "style", "<init>", "(Landroid/content/Context;I)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class a extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(view);
        d();
    }

    public /* synthetic */ a(Context context, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? R.style.f173280zp : i3);
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        d();
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(view, params);
        d();
    }
}
