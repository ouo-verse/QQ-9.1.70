package d92;

import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Ld92/b;", "Lcom/tencent/qqmini/sdk/widget/CapsuleButton$CapsuleBtnClickListener;", "", "onCloseClick", "onMoreClick", "Ljava/lang/ref/WeakReference;", "Lmu3/b;", "a", "Ljava/lang/ref/WeakReference;", "runtimeWeakRef", "runtime", "<init>", "(Lmu3/b;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements CapsuleButton.CapsuleBtnClickListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<mu3.b> runtimeWeakRef;

    public b(mu3.b runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtimeWeakRef = new WeakReference<>(runtime);
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onCloseClick() {
        Activity attachActivity;
        mu3.b bVar = this.runtimeWeakRef.get();
        if (bVar == null || (attachActivity = bVar.getAttachActivity()) == null || attachActivity.moveTaskToBack(true)) {
            return;
        }
        attachActivity.finish();
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onMoreClick() {
        mu3.b bVar = this.runtimeWeakRef.get();
        if (bVar == null) {
            return;
        }
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(bVar);
    }
}
