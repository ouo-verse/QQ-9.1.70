package com.tencent.mobileqq.matchfriend.aio.foreground;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkView;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkAnimatorDialog;", "Landroid/app/Dialog;", "", "e", "", "f", "show", "dismiss", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "d", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "model", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "onDisappearEnd", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkViewAnimator;", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkViewAnimator;", "animator", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;Lkotlin/jvm/functions/Function1;)V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerGainMutualMarkAnimatorDialog extends Dialog {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final StrangerGainMutualMarkView.StrangerGainMutualMarkModel model;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<StrangerGainMutualMarkView.StrangerGainMutualMarkModel, Unit> onDisappearEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final StrangerGainMutualMarkViewAnimator animator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrangerGainMutualMarkAnimatorDialog(Context ctx, StrangerGainMutualMarkView.StrangerGainMutualMarkModel model, Function1<? super StrangerGainMutualMarkView.StrangerGainMutualMarkModel, Unit> function1) {
        super(ctx, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.onDisappearEnd = function1;
        e();
        StrangerGainMutualMarkView strangerGainMutualMarkView = new StrangerGainMutualMarkView(ctx, null, 0, 6, null);
        strangerGainMutualMarkView.setData(model);
        final StrangerGainMutualMarkViewAnimator strangerGainMutualMarkViewAnimator = new StrangerGainMutualMarkViewAnimator(strangerGainMutualMarkView, model);
        strangerGainMutualMarkViewAnimator.C(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkAnimatorDialog$contentView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StrangerGainMutualMarkViewAnimator.this.F();
            }
        });
        strangerGainMutualMarkViewAnimator.D(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkAnimatorDialog$contentView$1$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean f16;
                f16 = StrangerGainMutualMarkAnimatorDialog.this.f();
                if (f16) {
                    return;
                }
                if (StrangerGainMutualMarkAnimatorDialog.this.isShowing()) {
                    StrangerGainMutualMarkAnimatorDialog.this.dismiss();
                }
                Function1<StrangerGainMutualMarkView.StrangerGainMutualMarkModel, Unit> d16 = StrangerGainMutualMarkAnimatorDialog.this.d();
                if (d16 != null) {
                    d16.invoke(strangerGainMutualMarkViewAnimator.getModel());
                }
            }
        });
        this.animator = strangerGainMutualMarkViewAnimator;
        strangerGainMutualMarkView.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.c
            @Override // java.lang.Runnable
            public final void run() {
                StrangerGainMutualMarkAnimatorDialog.g(StrangerGainMutualMarkAnimatorDialog.this);
            }
        });
        strangerGainMutualMarkView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(strangerGainMutualMarkView);
    }

    private final void e() {
        Window window = getWindow();
        if (window == null) {
            QLog.d("StrangerGainMutualMarkAnimatorDialog", 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        window.getAttributes().gravity = 17;
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("StrangerGainMutualMarkAnimatorDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            return activity.isFinishing() || activity.isDestroyed();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(StrangerGainMutualMarkAnimatorDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animator.E();
    }

    public final Function1<StrangerGainMutualMarkView.StrangerGainMutualMarkModel, Unit> d() {
        return this.onDisappearEnd;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }
}
