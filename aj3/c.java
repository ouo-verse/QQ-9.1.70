package aj3;

import android.content.Context;
import android.util.AttributeSet;
import b94.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreControllerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Laj3/c;", "Lzi3/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", "onlyBrandMallMode", "Lb94/e;", "Z", "", "doWhenQQLogout", "j0", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c implements zi3.a {
    public c() {
        z94.c.f452180e.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0() {
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0() {
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.F();
    }

    @Override // zi3.a
    public e Z(Context context, AttributeSet attrs, int defStyleAttr, boolean onlyBrandMallMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PortalStoreControllerView(context, attrs, defStyleAttr);
    }

    @Override // zi3.a
    public void doWhenQQLogout() {
        QLog.i("NativeUIImpl", 1, "doWhenQQLogout");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: aj3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.X0();
            }
        });
    }

    @Override // zi3.a
    public void j0() {
        QLog.i("NativeUIImpl", 1, "doWhenQQAccountChange");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: aj3.a
            @Override // java.lang.Runnable
            public final void run() {
                c.W0();
            }
        });
    }
}
