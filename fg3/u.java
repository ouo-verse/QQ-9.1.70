package fg3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lfg3/u;", "", "Landroid/view/View;", "view", "", "c", "Landroid/content/Context;", "context", "b", "a", "Landroid/view/View;", "inflateView", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnRetry", "()Lkotlin/jvm/functions/Function0;", "e", "(Lkotlin/jvm/functions/Function0;)V", "onRetry", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View inflateView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onRetry;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onRetry;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final View b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = this.inflateView;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dc5, (ViewGroup) null, false);
        this.inflateView = inflate;
        if (inflate != null) {
            c(inflate);
        }
        return this.inflateView;
    }

    public final void e(Function0<Unit> function0) {
        this.onRetry = function0;
    }

    private final void c(View view) {
        View findViewById = view.findViewById(R.id.qhf);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: fg3.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    u.d(u.this, view2);
                }
            });
        }
    }
}
