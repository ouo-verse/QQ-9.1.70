package hz;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lhz/c;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "e", "d", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onBackPressed", "Lhz/c$b;", "Lhz/c$b;", "getOnButtonClickListener", "()Lhz/c$b;", "f", "(Lhz/c$b;)V", "onButtonClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends Dialog implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b onButtonClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lhz/c$b;", "", "", "b", "onConfirm", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void b();

        void onConfirm();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, R.style.f173280zp);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void d() {
        WindowManager.LayoutParams attributes;
        e();
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = ah.b(270.0f);
            attributes.height = -2;
            attributes.gravity = 17;
        }
        setCanceledOnTouchOutside(false);
    }

    public final void f(b bVar) {
        this.onButtonClickListener = bVar;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        b bVar = this.onButtonClickListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.p7g) {
            dismiss();
            b bVar = this.onButtonClickListener;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.p7e) {
            dismiss();
            b bVar2 = this.onButtonClickListener;
            if (bVar2 != null) {
                bVar2.onConfirm();
            }
        }
    }

    private final void e() {
        setContentView(R.layout.d0h);
        findViewById(R.id.p7g).setOnClickListener(this);
        findViewById(R.id.p7e).setOnClickListener(this);
    }
}
