package com.tencent.mobileqq.springhb.interactive.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0014\u001a\u00020\u0006R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lorg/libpag/PAGView$PAGViewListener;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lorg/libpag/PAGFile;", "pagFile", "Lcom/tencent/mobileqq/springhb/interactive/ui/a;", "listener", "k", "Lorg/libpag/PAGView;", "p0", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "j", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "innerView", "e", "Lcom/tencent/mobileqq/springhb/interactive/ui/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class InteractivePopPagView extends VasPagView implements PAGView.PAGViewListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f289307f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<PAGView> innerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.springhb.interactive.ui.a listener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopPagView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f289307f = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractivePopPagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            api().build();
        }
    }

    public final void j() {
        PAGView pAGView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        WeakReference<PAGView> weakReference = this.innerView;
        if (weakReference != null && (pAGView = weakReference.get()) != null) {
            QLog.d("InteractivePopPagView", 1, "release " + pAGView.isPlaying());
            if (pAGView.isPlaying()) {
                pAGView.stop();
            }
            pAGView.freeCache();
            pAGView.removeListener(this);
        }
        this.innerView = null;
        this.listener = null;
    }

    public final void k(@NotNull final PAGFile pagFile, @NotNull final com.tencent.mobileqq.springhb.interactive.ui.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pagFile, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        Intrinsics.checkNotNullParameter(listener, "listener");
        api().postAction(new Function1<PAGView, Unit>(this, listener) { // from class: com.tencent.mobileqq.springhb.interactive.ui.InteractivePopPagView$show$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a $listener;
            final /* synthetic */ InteractivePopPagView this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PAGFile.this, this, listener);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView pagView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pagView);
                    return;
                }
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                pagView.setComposition(PAGFile.this);
                pagView.setRepeatCount(1);
                pagView.setProgress(0.0d);
                pagView.setScaleMode(2);
                this.this$0.innerView = new WeakReference(pagView);
                this.this$0.listener = this.$listener;
                pagView.addListener(this.this$0);
                pagView.play();
            }
        });
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationCancel(@Nullable PAGView p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
            return;
        }
        com.tencent.mobileqq.springhb.interactive.ui.a aVar = this.listener;
        if (aVar != null) {
            aVar.onAnimationCancel();
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationEnd(@NotNull PAGView p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
            return;
        }
        Intrinsics.checkNotNullParameter(p06, "p0");
        boolean z16 = true;
        QLog.d("InteractivePopPagView", 1, " onAnimationEnd " + p06.getProgress());
        com.tencent.mobileqq.springhb.interactive.ui.a aVar = this.listener;
        if (aVar != null) {
            if (p06.getProgress() != 1.0d) {
                z16 = false;
            }
            aVar.a(z16);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationRepeat(@Nullable PAGView p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) p06);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationStart(@Nullable PAGView p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
            return;
        }
        QLog.d("InteractivePopPagView", 1, " onAnimationStart");
        com.tencent.mobileqq.springhb.interactive.ui.a aVar = this.listener;
        if (aVar != null) {
            aVar.onAnimationStart();
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationUpdate(@Nullable PAGView p06) {
        com.tencent.mobileqq.springhb.interactive.ui.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
        } else if (p06 != null && (aVar = this.listener) != null) {
            aVar.b(p06.getProgress());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (com.tencent.mobileqq.springhb.interactive.a.b(context)) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(size >> 1, 1073741824);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
