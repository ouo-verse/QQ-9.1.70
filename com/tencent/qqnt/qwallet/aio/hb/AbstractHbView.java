package com.tencent.qqnt.qwallet.aio.hb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.AIOContentView;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&R\u001b\u0010\u0019\u001a\u00020\u00148DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u000f8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/AbstractHbView;", "Lcom/tencent/qqnt/qwallet/aio/AIOContentView;", "Landroidx/lifecycle/LifecycleObserver;", "", "initView", "Landroid/view/View;", "E0", "H0", NodeProps.ON_ATTACHED_TO_WINDOW, "onResume", NodeProps.ON_DETACHED_FROM_WINDOW, "D0", "K0", "", "isOpened", "", "stateText", "J0", "L0", "I0", "Lcom/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel;", "e", "Lkotlin/Lazy;", "F0", "()Lcom/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel;", "grabHbViewModel", "f", "Ljava/lang/String;", "getTypeText", "()Ljava/lang/String;", "typeText", "Landroidx/lifecycle/Observer;", tl.h.F, "Landroidx/lifecycle/Observer;", "stateObserver", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isViewInitialized", "Lmqq/util/WeakReference;", "Landroidx/lifecycle/Lifecycle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "lifecycleWeak", "Lcom/tencent/qqnt/qwallet/aio/hb/c;", "G0", "()Lcom/tencent/qqnt/qwallet/aio/hb/c;", "viewModel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AbstractHbView extends AIOContentView implements LifecycleObserver {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy grabHbViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<String> stateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isViewInitialized;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Lifecycle> lifecycleWeak;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractHbView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GrabHbViewModel>() { // from class: com.tencent.qqnt.qwallet.aio.hb.AbstractHbView$grabHbViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GrabHbViewModel invoke() {
                return new GrabHbViewModel();
            }
        });
        this.grabHbViewModel = lazy;
        this.typeText = "QQ\u7ea2\u5305";
        this.stateObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AbstractHbView.M0(AbstractHbView.this, (String) obj);
            }
        };
        this.isViewInitialized = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(AbstractHbView this$0, String stateText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d(this$0.getTAG(), 1, "stateObserver: this " + this$0.hashCode() + ", bliiNo " + this$0.W0().M1().getBillNo() + ", msgType " + this$0.W0().M1().getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() + " stateText [" + stateText + "]");
        Intrinsics.checkNotNullExpressionValue(stateText, "stateText");
        if (stateText.length() <= 0) {
            z16 = false;
        }
        this$0.J0(z16, stateText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D0() {
        W0().R1().observeForever(this.stateObserver);
    }

    @NotNull
    public abstract View E0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GrabHbViewModel F0() {
        return (GrabHbViewModel) this.grabHbViewModel.getValue();
    }

    @NotNull
    /* renamed from: G0 */
    public abstract c W0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        final Dialog showQWalletProgressDialog = ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).showQWalletProgressDialog(activity);
        AIOContextHolder.f361707d.c(new UnclaimedEvent.UpdateHbList(false));
        GrabHbViewModel F0 = F0();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        F0.W1(context2, W0().M1(), new Function1<Integer, Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.AbstractHbView$onCoverClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Dialog dialog = showQWalletProgressDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (i3 != 0) {
                    String string = this.getContext().getResources().getString(R.string.f17938398, Integer.valueOf(i3));
                    Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ay_hb_pregrab_fail, code)");
                    QQToast.makeText(this.getContext(), string, 0).show();
                }
            }
        });
    }

    public abstract void I0(@NotNull String stateText);

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0(boolean isOpened, @NotNull String stateText) {
        Intrinsics.checkNotNullParameter(stateText, "stateText");
        QLog.d(getTAG(), 2, "onHbStateChanged: this " + hashCode() + ", isOpened " + isOpened + ", stateText " + stateText);
        if (isOpened) {
            I0(stateText);
        } else {
            L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K0() {
        W0().R1().removeObserver(this.stateObserver);
    }

    public abstract void L0();

    public abstract void initView();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        super.onAttachedToWindow();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null) {
            lifecycle = lifecycleOwner.getLifecycle();
        } else {
            lifecycle = null;
        }
        if (lifecycle != null) {
            lifecycle.addObserver(this);
            this.lifecycleWeak = new WeakReference<>(lifecycle);
        } else {
            WeakReference<Lifecycle> weakReference = this.lifecycleWeak;
            if (weakReference != null && (lifecycle2 = weakReference.get()) != null) {
                lifecycle2.addObserver(this);
            }
        }
        if (this.isViewInitialized.compareAndSet(false, true)) {
            initView();
            com.tencent.mobileqq.qwallet.k.c(E0(), 500L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.AbstractHbView$onAttachedToWindow$1
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
                    AbstractHbView.this.H0();
                }
            });
        }
        L0();
        D0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        WeakReference<Lifecycle> weakReference = this.lifecycleWeak;
        if (weakReference != null) {
            lifecycle = weakReference.get();
        } else {
            lifecycle = null;
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        } else {
            QLog.e(getTAG(), 1, "onDetachedFromWindow lifecycle is null");
        }
        K0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        QLog.d(getTAG(), 2, "onResume: " + hashCode());
        W0().U1();
    }
}
