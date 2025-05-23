package com.tencent.mobileqq.vas.social;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.social.SquareVasPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import com.tencent.state.square.api.ISquarePagFileHandler;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\\]B\u000f\u0012\u0006\u0010X\u001a\u00020W\u00a2\u0006\u0004\bY\u0010ZJ+\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J3\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\tH\u0016J+\u0010\"\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\u001a\u0010&\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J5\u0010*\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u00182\b\u0010(\u001a\u0004\u0018\u00010\u00182\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b*\u0010+J%\u0010/\u001a\u00020\t2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\u0006\u0010.\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b/\u00100J\n\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u000eH\u0016J\b\u00104\u001a\u000201H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\u0012\u00107\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00108\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00109\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010:\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010;\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010@\u001a\n =*\u0004\u0018\u00010<0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR$\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR$\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010S\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/vas/social/SquareVasPagView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/api/ISquarePagView;", "Lorg/libpag/PAGView$PAGViewListener;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "callback", "j", "soLoadResult", "l", "", "repeatCount", "o", "Lorg/libpag/PAGView;", "pagView", DomainData.DOMAIN_NAME, "initView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "id", "setPagFile", "", "filePath", "Lcom/tencent/state/square/api/ISquarePagFileHandler;", "handler", "setPagFileHandler", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "listener", "setPagViewListener", "playPag", "stop", "preparePagRuntime", "layerIndex", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "replaceImageLayer", "text", "textColor", "bold", "replaceTextLayer", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "layers", NodeProps.VISIBLE, "setLayerVisible", "([Ljava/lang/Integer;Z)V", "Landroid/view/View;", "getPagView", "getTextLayer", "getView", "numImages", "p0", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "loader", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "initState", "f", "Lorg/libpag/PAGView;", tl.h.F, "Ljava/lang/Integer;", "pagRawId", "i", "Ljava/lang/String;", "path", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "pagViewListener", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/state/square/api/ISquarePagFileHandler;", "pagFileHandler", "D", "Lkotlin/jvm/functions/Function1;", "prepareLoadCallback", "E", "playInnerCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareVasPagView extends FrameLayout implements ISquarePagView, PAGView.PAGViewListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ISquarePagFileHandler pagFileHandler;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> prepareLoadCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> playInnerCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final PagLoader loader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger initState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PAGView pagView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer pagRawId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String path;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ISquarePagViewListener pagViewListener;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B<\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/social/SquareVasPagView$b;", "Lcom/tencent/sqshow/zootopia/utils/PagLoader$b;", "", "result", "", "onComplete", "d", "Z", "getInitView", "()Z", "initView", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/vas/social/SquareVasPagView;", "e", "Lmqq/util/WeakReference;", "squarePagView", "Lkotlin/Function1;", "f", "bizCallback", "pagView", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lcom/tencent/mobileqq/vas/social/SquareVasPagView;Lkotlin/jvm/functions/Function1;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements PagLoader.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean initView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<SquareVasPagView> squarePagView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Function1<Boolean, Unit>> bizCallback;

        public b(SquareVasPagView squareVasPagView, Function1<? super Boolean, Unit> callback, boolean z16) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.initView = z16;
            this.squarePagView = new WeakReference<>(squareVasPagView);
            this.bizCallback = new WeakReference<>(callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0, SquareVasPagView squareVasPagView, boolean z16, Function1 function1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.initView) {
                squareVasPagView.l(z16, function1);
            } else {
                function1.invoke(Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
        public void onComplete(final boolean result) {
            final Function1<Boolean, Unit> function1 = this.bizCallback.get();
            final SquareVasPagView squareVasPagView = this.squarePagView.get();
            QLog.d("SquareVasPagView", 1, "LoadComplete, " + result + ", " + (function1 != null) + ", " + (squareVasPagView != null));
            if (squareVasPagView == null || function1 == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.k
                @Override // java.lang.Runnable
                public final void run() {
                    SquareVasPagView.b.b(SquareVasPagView.b.this, squareVasPagView, result, function1);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareVasPagView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loader = PagLoader.c();
        this.initState = new AtomicInteger(0);
    }

    private final void j(final Function1<? super Boolean, Unit> callback) {
        if (QLog.isDebugVersion()) {
            QLog.d("SquareVasPagView", 1, "initPag, loader.isLoad:" + this.loader.d());
        }
        if (this.loader.d()) {
            l(true, callback);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.social.h
                @Override // java.lang.Runnable
                public final void run() {
                    SquareVasPagView.k(SquareVasPagView.this, callback);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SquareVasPagView this$0, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.m(true, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(boolean soLoadResult, Function1<? super Boolean, Unit> callback) {
        if (QLog.isDebugVersion()) {
            QLog.d("SquareVasPagView", 1, "initPagView, result:" + soLoadResult + ", state:" + this.initState.get());
        }
        if (!this.initState.compareAndSet(1, soLoadResult ? 2 : 3)) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        if (!soLoadResult) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        boolean z16 = false;
        if (!(activity != null && activity.isFinishing())) {
            Context context2 = getContext();
            Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity2 != null && activity2.isDestroyed()) {
                z16 = true;
            }
            if (!z16) {
                try {
                    PAGView pAGView = new PAGView(getContext());
                    this.pagView = pAGView;
                    pAGView.addListener(this);
                    addView(this.pagView, -1, -1);
                    callback.invoke(Boolean.TRUE);
                    return;
                } catch (Throwable th5) {
                    QLog.e("SquareVasPagView", 1, "initPagView err.", th5);
                    callback.invoke(Boolean.FALSE);
                    return;
                }
            }
        }
        callback.invoke(Boolean.FALSE);
    }

    private final void m(boolean initView, Function1<? super Boolean, Unit> callback) {
        PagLoader loader = this.loader;
        Intrinsics.checkNotNullExpressionValue(loader, "loader");
        synchronized (loader) {
            this.loader.f(getContext(), new b(this, callback, initView));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final int repeatCount) {
        int i3 = this.initState.get();
        if (QLog.isDebugVersion()) {
            QLog.d("SquareVasPagView", 1, "playPagInner, state:" + i3);
        }
        if (i3 == 0 || i3 == 1) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.pagView);
        boolean z16 = false;
        if (QLog.isDebugVersion()) {
            QLog.d("SquareVasPagView", 1, "playPagInner, pagView is null:" + (this.pagView == null));
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null && i3 != 3) {
            if (pAGView != null && pAGView.isPlaying()) {
                z16 = true;
            }
            if (z16) {
                QLog.d("SquareVasPagView", 1, "playPagReal, pagView is playing");
                return;
            }
            Integer num = this.pagRawId;
            if (num != null) {
                if (num != null) {
                    com.tencent.mobileqq.zootopia.utils.c.f329552a.c(num.intValue(), new SquareVasPagView$playPagInner$1$1(weakReference, this, repeatCount));
                    return;
                }
                return;
            } else if (this.path != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.social.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SquareVasPagView.p(SquareVasPagView.this, weakReference, repeatCount);
                    }
                }, 64, null, true);
                return;
            } else {
                n(this.pagView, repeatCount);
                return;
            }
        }
        ISquarePagViewListener iSquarePagViewListener = this.pagViewListener;
        if (iSquarePagViewListener != null) {
            iSquarePagViewListener.onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final SquareVasPagView this$0, final WeakReference weakPagView, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weakPagView, "$weakPagView");
        String str = this$0.path;
        final PAGFile Load = str != null ? PagViewMonitor.Load(str) : null;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.j
            @Override // java.lang.Runnable
            public final void run() {
                SquareVasPagView.q(WeakReference.this, Load, this$0, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(WeakReference weakPagView, PAGFile pAGFile, SquareVasPagView this$0, int i3) {
        Intrinsics.checkNotNullParameter(weakPagView, "$weakPagView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGView pAGView = (PAGView) weakPagView.get();
        if (pAGView != null) {
            pAGView.setComposition(pAGFile);
        }
        this$0.n((PAGView) weakPagView.get(), i3);
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public View getPagView() {
        return this.pagView;
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public String getTextLayer(int layerIndex) {
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
        if (pAGFile == null) {
            return null;
        }
        return com.tencent.sqshow.zootopia.utils.k.f373283a.g(pAGFile, layerIndex);
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public int numImages() {
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
        if (pAGFile == null) {
            return 0;
        }
        return pAGFile.numImages();
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationCancel(PAGView p06) {
        ISquarePagViewListener iSquarePagViewListener = this.pagViewListener;
        if (iSquarePagViewListener != null) {
            iSquarePagViewListener.onAnimationCancel(this);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationEnd(PAGView p06) {
        ISquarePagViewListener iSquarePagViewListener = this.pagViewListener;
        if (iSquarePagViewListener != null) {
            iSquarePagViewListener.onAnimationEnd(this);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationRepeat(PAGView p06) {
        ISquarePagViewListener iSquarePagViewListener = this.pagViewListener;
        if (iSquarePagViewListener != null) {
            iSquarePagViewListener.onAnimationRepeat(this);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationStart(PAGView p06) {
        ISquarePagViewListener iSquarePagViewListener = this.pagViewListener;
        if (iSquarePagViewListener != null) {
            iSquarePagViewListener.onAnimationStart(this);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void playPag(final int repeatCount) {
        if (QLog.isDebugVersion()) {
            QLog.d("SquareVasPagView", 1, "playPag, repeatCount:" + repeatCount);
        }
        if (this.initState.compareAndSet(0, 1)) {
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.social.SquareVasPagView$playPag$innerCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void invoke(boolean z16) {
                    SquareVasPagView.this.o(repeatCount);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
            this.playInnerCallback = function1;
            j(function1);
            return;
        }
        o(repeatCount);
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public synchronized void preparePagRuntime(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.prepareLoadCallback = callback;
        if (this.loader.d()) {
            callback.invoke(Boolean.TRUE);
        } else {
            m(false, callback);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public boolean replaceImageLayer(int layerIndex, Bitmap bitmap) {
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
        if (pAGFile == null) {
            return false;
        }
        return com.tencent.sqshow.zootopia.utils.k.f373283a.d(pAGFile, layerIndex, bitmap);
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void replaceTextLayer(int layerIndex, String text, String textColor, Boolean bold) {
        PAGView pAGView = this.pagView;
        PAGComposition composition = pAGView != null ? pAGView.getComposition() : null;
        PAGFile pAGFile = composition instanceof PAGFile ? (PAGFile) composition : null;
        if (pAGFile == null) {
            return;
        }
        com.tencent.sqshow.zootopia.utils.k.f373283a.e(pAGFile, layerIndex, text, textColor, bold);
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void setLayerVisible(Integer[] layers, boolean visible) {
        Intrinsics.checkNotNullParameter(layers, "layers");
        PAGView pAGView = this.pagView;
        PAGLayer pAGLayer = null;
        PAGLayer composition = pAGView != null ? pAGView.getComposition() : null;
        int length = layers.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                pAGLayer = composition;
                break;
            }
            int intValue = layers[i3].intValue();
            if (!(composition instanceof PAGComposition)) {
                break;
            }
            composition = ((PAGComposition) composition).getLayerAt(intValue);
            i3++;
        }
        if (pAGLayer != null) {
            pAGLayer.setVisible(visible);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void setPagFile(int id5) {
        this.pagRawId = Integer.valueOf(id5);
        this.path = null;
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void setPagFileHandler(ISquarePagFileHandler handler) {
        this.pagFileHandler = handler;
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void setPagViewListener(ISquarePagViewListener listener) {
        this.pagViewListener = listener;
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void stop() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public void setPagFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.path = filePath;
        this.pagRawId = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(PAGView pagView, int repeatCount) {
        if (pagView == null) {
            return;
        }
        ISquarePagFileHandler iSquarePagFileHandler = this.pagFileHandler;
        if (iSquarePagFileHandler != null) {
            iSquarePagFileHandler.onPagFileLoaded(this);
        }
        pagView.setRepeatCount(repeatCount);
        pagView.setVisibility(0);
        if (!pagView.isPlaying()) {
            QLog.d("SquareVasPagView", 1, "playPagReal, doPlay");
            pagView.play();
        } else {
            QLog.d("SquareVasPagView", 1, "playPagReal, unexpected playing");
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagView
    public View getView() {
        return this;
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationUpdate(PAGView p06) {
    }
}
