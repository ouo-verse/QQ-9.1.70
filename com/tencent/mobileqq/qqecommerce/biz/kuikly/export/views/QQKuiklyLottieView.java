package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rlottie.AXrLottieDrawable;
import d01.q;
import d01.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u001f\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyLottieView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Ld01/q;", "Lkotlin/Function0;", "", "task", "y", "", "w", "t", HippyTKDListViewAdapter.X, "destroy", "loop", "i", "pause", "play", "Ld01/r;", "listener", "setLottieViewListener", "stop", NodeProps.ON_DETACHED_FROM_WINDOW, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "type", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "filePath", "", "D", "Ljava/util/List;", "lottieViewLazyTask", "E", "Z", "isInit", UserInfo.SEX_FEMALE, "isInitResource", "Lcom/tencent/rlottie/AXrLottieDrawable;", "G", "Lcom/tencent/rlottie/AXrLottieDrawable;", "axrDrawable", "H", "currentState", "Ld01/r;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "J", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyLottieView extends AppCompatImageView implements q {
    private static volatile boolean K;

    /* renamed from: C, reason: from kotlin metadata */
    private final String filePath;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<Function0<Unit>> lottieViewLazyTask;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isInit;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isInitResource;

    /* renamed from: G, reason: from kotlin metadata */
    private AXrLottieDrawable axrDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: I, reason: from kotlin metadata */
    private r listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyLottieView(Context context, int i3, String filePath) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.type = i3;
        this.filePath = filePath;
        this.lottieViewLazyTask = new ArrayList();
    }

    private final void t() {
        if (this.isInitResource) {
            return;
        }
        this.isInitResource = true;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.e
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyLottieView.u(QQKuiklyLottieView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final QQKuiklyLottieView this$0) {
        final AXrLottieDrawable b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!K) {
            com.tencent.rlottie.a.d(BaseApplication.getContext());
        }
        if (this$0.type == 2) {
            b16 = AXrLottieDrawable.V(this$0.getContext(), this$0.filePath, "").f(false).b();
        } else {
            b16 = AXrLottieDrawable.U(this$0.getContext(), new File(this$0.filePath)).b();
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.f
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyLottieView.v(QQKuiklyLottieView.this, b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QQKuiklyLottieView this$0, AXrLottieDrawable aXrLottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        K = true;
        this$0.isInitResource = false;
        this$0.isInit = true;
        this$0.axrDrawable = aXrLottieDrawable;
        aXrLottieDrawable.y0(new b());
        this$0.x();
    }

    private final boolean w() {
        return K && this.isInit;
    }

    private final void x() {
        Iterator<T> it = this.lottieViewLazyTask.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        this.lottieViewLazyTask.clear();
    }

    private final void y(Function0<Unit> task) {
        if (w()) {
            task.invoke();
        } else {
            this.lottieViewLazyTask.add(task);
            t();
        }
    }

    @Override // d01.q
    public void destroy() {
        y(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView$destroy$1
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
                AXrLottieDrawable aXrLottieDrawable;
                aXrLottieDrawable = QQKuiklyLottieView.this.axrDrawable;
                if (aXrLottieDrawable != null) {
                    aXrLottieDrawable.recycle();
                }
            }
        });
    }

    @Override // d01.q
    public void i(final boolean loop) {
        y(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView$loopAnimation$1
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
                AXrLottieDrawable aXrLottieDrawable;
                aXrLottieDrawable = QQKuiklyLottieView.this.axrDrawable;
                if (aXrLottieDrawable != null) {
                    aXrLottieDrawable.p0(loop ? -1 : 1);
                }
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // d01.q
    public void pause() {
        y(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView$pause$1
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
                AXrLottieDrawable aXrLottieDrawable;
                aXrLottieDrawable = QQKuiklyLottieView.this.axrDrawable;
                if (aXrLottieDrawable != null) {
                    aXrLottieDrawable.stop();
                }
                QQKuiklyLottieView.this.currentState = 2;
            }
        });
    }

    @Override // d01.q
    public void play() {
        y(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView$play$1
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
                AXrLottieDrawable aXrLottieDrawable;
                int i3;
                AXrLottieDrawable aXrLottieDrawable2;
                int i16;
                AXrLottieDrawable aXrLottieDrawable3;
                QQKuiklyLottieView qQKuiklyLottieView = QQKuiklyLottieView.this;
                aXrLottieDrawable = qQKuiklyLottieView.axrDrawable;
                qQKuiklyLottieView.setImageDrawable(aXrLottieDrawable);
                i3 = QQKuiklyLottieView.this.currentState;
                if (i3 != 2) {
                    i16 = QQKuiklyLottieView.this.currentState;
                    if (i16 != 3) {
                        aXrLottieDrawable3 = QQKuiklyLottieView.this.axrDrawable;
                        if (aXrLottieDrawable3 != null) {
                            aXrLottieDrawable3.start();
                        }
                        QQKuiklyLottieView.this.currentState = 1;
                    }
                }
                aXrLottieDrawable2 = QQKuiklyLottieView.this.axrDrawable;
                if (aXrLottieDrawable2 != null) {
                    aXrLottieDrawable2.n0();
                }
                QQKuiklyLottieView.this.currentState = 1;
            }
        });
    }

    @Override // d01.q
    public void setLottieViewListener(r listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // d01.q
    public void stop() {
        y(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView$stop$1
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
                AXrLottieDrawable aXrLottieDrawable;
                aXrLottieDrawable = QQKuiklyLottieView.this.axrDrawable;
                if (aXrLottieDrawable != null) {
                    aXrLottieDrawable.stop();
                }
                QQKuiklyLottieView.this.currentState = 3;
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyLottieView$b", "Lcom/tencent/rlottie/AXrLottieDrawable$c;", "Lcom/tencent/rlottie/AXrLottieDrawable;", "p0", "", "p1", "", "onFrameChanged", "", "onRepeat", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "onRecycle", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements AXrLottieDrawable.c {
        b() {
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onStop(boolean endAnimation) {
            r rVar;
            if (!endAnimation || (rVar = QQKuiklyLottieView.this.listener) == null) {
                return;
            }
            rVar.a(true);
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onRecycle() {
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onStart() {
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onFrameChanged(AXrLottieDrawable p06, int p16) {
        }

        @Override // com.tencent.rlottie.AXrLottieDrawable.c
        public void onRepeat(int p06, boolean p16) {
        }
    }
}
