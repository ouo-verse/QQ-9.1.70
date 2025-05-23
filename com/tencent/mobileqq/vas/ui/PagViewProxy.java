package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGImageView;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 '*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002'(B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020\u000eH\u0004J\r\u0010!\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010$\u001a\u00020\u000e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0005J\b\u0010&\u001a\u00020\u000eH\u0004R6\u0010\u000b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\r`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "T", "Landroid/view/View;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionRecord", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "", "Lkotlin/collections/ArrayList;", "currentView", "getCurrentView", "()Landroid/view/View;", "setCurrentView", "(Landroid/view/View;)V", "<set-?>", "", "isBuild", "()Z", "stateChangeListener", "getStateChangeListener", "()Lkotlin/jvm/functions/Function1;", "setStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "viewProxy", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy$MyViewProxy;", "build", "buildView", "doActionAfterStateChange", "pagView", "postAction", "block", "refresh", "Companion", "MyViewProxy", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class PagViewProxy<T extends View> extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "VasPagView";

    @NotNull
    private static final AbsAsyncLoadProxy.Loader sLoader = new PagLoaderImpl();

    @NotNull
    private final ArrayList<Function1<T, Unit>> actionRecord;

    @Nullable
    private View currentView;
    private boolean isBuild;

    @NotNull
    private Function1<? super View, Unit> stateChangeListener;

    @NotNull
    private final MyViewProxy<T> viewProxy;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/PagViewProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sLoader", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "getSLoader", "()Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AbsAsyncLoadProxy.Loader getSLoader() {
            return PagViewProxy.sLoader;
        }

        @NotNull
        public final String getTAG() {
            return PagViewProxy.TAG;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0014J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/PagViewProxy$MyViewProxy;", "T", "Landroid/view/View;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "(Lcom/tencent/mobileqq/vas/ui/PagViewProxy;)V", "getContainer", "()Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "failedBuilder", "Lkotlin/Function0;", "Landroid/widget/FrameLayout;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "sucessedBuilder", "getSucessedBuilder", "onCurrentObjectChanged", "", "onPostLoaderTask", "block", "update", "view", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class MyViewProxy<T extends View> extends AbsAsyncLoadProxy<View> {

        @NotNull
        private final PagViewProxy<T> container;

        @NotNull
        private final Function0<FrameLayout> failedBuilder;

        @NotNull
        private final Function0<T> sucessedBuilder;

        public MyViewProxy(@NotNull PagViewProxy<T> container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.container = container;
            this.failedBuilder = new Function0<FrameLayout>(this) { // from class: com.tencent.mobileqq.vas.ui.PagViewProxy$MyViewProxy$failedBuilder$1
                final /* synthetic */ PagViewProxy.MyViewProxy<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    return new FrameLayout(this.this$0.getContainer().getContext());
                }
            };
            this.sucessedBuilder = (Function0<T>) new Function0<T>(this) { // from class: com.tencent.mobileqq.vas.ui.PagViewProxy$MyViewProxy$sucessedBuilder$1
                final /* synthetic */ PagViewProxy.MyViewProxy<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Incorrect return type in method signature: ()TT; */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    return this.this$0.getContainer().buildView();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCurrentObjectChanged$lambda$0(MyViewProxy this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.update(this$0.getCurrentObject());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPostLoaderTask$lambda$1(Function0 block) {
            Intrinsics.checkNotNullParameter(block, "$block");
            block.invoke();
        }

        private final void update(View view) {
            if (view == null) {
                this.container.removeAllViews();
                return;
            }
            this.container.removeAllViews();
            this.container.addView(view);
            this.container.getStateChangeListener().invoke(view);
            this.container.doActionAfterStateChange(view);
        }

        @NotNull
        public final PagViewProxy<T> getContainer() {
            return this.container;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy
        @NotNull
        public Function0<View> getFailedBuilder() {
            return this.failedBuilder;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy
        @NotNull
        public Function0<View> getSucessedBuilder() {
            return this.sucessedBuilder;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy
        protected void onCurrentObjectChanged() {
            this.container.setCurrentView(getCurrentObject());
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                update(getCurrentObject());
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.ui.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        PagViewProxy.MyViewProxy.onCurrentObjectChanged$lambda$0(PagViewProxy.MyViewProxy.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy
        protected void onPostLoaderTask(@NotNull final Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vas.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    PagViewProxy.MyViewProxy.onPostLoaderTask$lambda$1(Function0.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagViewProxy(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stateChangeListener = new Function1<View, Unit>() { // from class: com.tencent.mobileqq.vas.ui.PagViewProxy$stateChangeListener$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                ViewGroup.LayoutParams layoutParams;
                Intrinsics.checkNotNullParameter(it, "it");
                if (((it instanceof PAGView) || (it instanceof PAGImageView)) && (layoutParams = it.getLayoutParams()) != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
            }
        };
        this.viewProxy = new MyViewProxy<>(this);
        this.actionRecord = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doActionAfterStateChange(View pagView) {
        if (!(pagView instanceof PAGView) && !(pagView instanceof PAGImageView)) {
            return;
        }
        synchronized (this.actionRecord) {
            Iterator<Function1<T, Unit>> it = this.actionRecord.iterator();
            while (it.hasNext()) {
                it.next().invoke(pagView);
            }
            this.actionRecord.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$2$lambda$1(PagViewProxy this$0, View this_run) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this$0.stateChangeListener.invoke(this_run);
        this$0.doActionAfterStateChange(this_run);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void build() {
        this.isBuild = true;
        this.viewProxy.build(sLoader);
    }

    @NotNull
    public abstract T buildView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View getCurrentView() {
        return this.currentView;
    }

    @NotNull
    protected final Function1<View, Unit> getStateChangeListener() {
        return this.stateChangeListener;
    }

    /* renamed from: isBuild, reason: from getter */
    public final boolean getIsBuild() {
        return this.isBuild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @UiThread
    public final void postAction(@NotNull Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.actionRecord) {
            this.actionRecord.add(block);
        }
        doActionAfterStateChange(this.currentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void refresh() {
        final View view = this.currentView;
        if (view != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                this.stateChangeListener.invoke(view);
                doActionAfterStateChange(view);
            } else {
                view.post(new Runnable() { // from class: com.tencent.mobileqq.vas.ui.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        PagViewProxy.refresh$lambda$2$lambda$1(PagViewProxy.this, view);
                    }
                });
            }
        }
    }

    protected final void setCurrentView(@Nullable View view) {
        this.currentView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setStateChangeListener(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.stateChangeListener = function1;
    }
}
