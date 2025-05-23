package j50;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.engineer.test.api.RFWExecutorFactory;
import com.tencent.richframework.engineer.test.api.RFWRuleExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lj50/b;", "", "", "f", "Landroid/widget/ImageView;", "switchView", "b", "e", "d", "a", "Landroid/widget/ImageView;", "selfCheckIcon", "Lcom/tencent/richframework/engineer/test/api/RFWRuleExecutor;", "kotlin.jvm.PlatformType", "Lcom/tencent/richframework/engineer/test/api/RFWRuleExecutor;", "selfCheckExecutor", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ImageView selfCheckIcon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RFWRuleExecutor selfCheckExecutor = RFWExecutorFactory.createRuleExecutor("com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.reportcheck.impl.QFSPublicAccountReportCheckRuleExecutor");

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f() {
        if (!this.selfCheckExecutor.isOpen()) {
            e();
        } else {
            d();
        }
    }

    public final void b(@NotNull ImageView switchView) {
        Intrinsics.checkNotNullParameter(switchView, "switchView");
        this.selfCheckIcon = switchView;
        ImageView imageView = null;
        if (switchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfCheckIcon");
            switchView = null;
        }
        switchView.setVisibility(0);
        ImageView imageView2 = this.selfCheckIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfCheckIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: j50.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.c(b.this, view);
            }
        });
    }

    public final void d() {
        if (!this.selfCheckExecutor.isOpen()) {
            return;
        }
        this.selfCheckExecutor.endExecutor();
        ImageView imageView = this.selfCheckIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfCheckIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.nkp);
    }

    public final void e() {
        if (this.selfCheckExecutor.isOpen()) {
            return;
        }
        this.selfCheckExecutor.beginExecutor();
        ImageView imageView = this.selfCheckIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfCheckIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.nkr);
    }
}
