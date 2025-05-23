package gz;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0007\u001a\u00020\u0006H$J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH$J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001a\u00a8\u0006\""}, d2 = {"Lgz/d;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "f", "e", "", "d", "Landroid/view/Window;", "window", "g", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onBackPressed", "", "tipsText", "i", "Lgz/d$a;", "Lgz/d$a;", "getOnButtonClickListener", "()Lgz/d$a;", h.F, "(Lgz/d$a;)V", "onButtonClickListener", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvTipsText", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class d extends Dialog implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a onButtonClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTipsText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lgz/d$a;", "", "", "a", "onCancel", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void a();

        void onCancel();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        setContentView(d());
        View findViewById = findViewById(R.id.p6x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_auth_friends_text)");
        this.tvTipsText = (TextView) findViewById;
        findViewById(R.id.p6w).setOnClickListener(this);
        findViewById(R.id.p6v).setOnClickListener(this);
    }

    protected abstract int d();

    public final void e() {
        f();
        Window window = getWindow();
        if (window != null) {
            g(window);
        }
        setCanceledOnTouchOutside(false);
    }

    protected abstract void g(Window window);

    public final void h(a aVar) {
        this.onButtonClickListener = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(String tipsText) {
        boolean z16;
        boolean isBlank;
        TextView textView = this.tvTipsText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTipsText");
            textView = null;
        }
        if (tipsText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(tipsText);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    tipsText = null;
                }
                if (tipsText == null) {
                    tipsText = ag.c(R.string.x9v);
                }
                textView.setText(tipsText);
            }
        }
        z16 = true;
        if (z16) {
        }
        if (tipsText == null) {
        }
        textView.setText(tipsText);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        a aVar = this.onButtonClickListener;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.p6v) {
            dismiss();
            a aVar = this.onButtonClickListener;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.p6w) {
            dismiss();
            a aVar2 = this.onButtonClickListener;
            if (aVar2 != null) {
                aVar2.onCancel();
            }
        }
    }
}
