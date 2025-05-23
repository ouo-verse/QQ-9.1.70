package l10;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Ll10/b;", "Ll10/a;", "Landroid/view/View$OnClickListener;", "", "e", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Ll10/c;", "d", "Ll10/c;", "getOnConfirmDialogClickListener", "()Ll10/c;", "f", "(Ll10/c;)V", "onConfirmDialogClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends a implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c onConfirmDialogClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }

    public final void f(c cVar) {
        this.onConfirmDialogClickListener = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        c cVar;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f163270p73) {
            c cVar2 = this.onConfirmDialogClickListener;
            if (cVar2 != null) {
                cVar2.onConfirm();
                return;
            }
            return;
        }
        if (valueOf == null || valueOf.intValue() != R.id.f163269p72 || (cVar = this.onConfirmDialogClickListener) == null) {
            return;
        }
        cVar.onCancel();
    }

    private final void e() {
        setContentView(R.layout.d0g);
        findViewById(R.id.f163270p73).setOnClickListener(this);
        findViewById(R.id.f163269p72).setOnClickListener(this);
    }
}
