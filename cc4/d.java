package cc4;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0011B\u001b\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcc4/d;", "Landroid/app/Dialog;", "", "e", "d", "Lcc4/b;", "controller", "f", "dismiss", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcc4/b;", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b controller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
        d();
    }

    private final void e() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("RewardDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b bVar = this.controller;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    public final void f(b controller) {
        this.controller = controller;
        if (controller != null) {
            View view = controller.getView();
            if (view != null) {
                setContentView(view);
            }
            controller.c();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.controller;
        if (bVar != null) {
            bVar.onDetachedFromWindow();
        }
    }

    public /* synthetic */ d(Context context, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? R.style.f2431400 : i3);
    }

    private final void d() {
    }
}
