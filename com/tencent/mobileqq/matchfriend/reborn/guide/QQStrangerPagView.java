package com.tencent.mobileqq.matchfriend.reborn.guide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0005H\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lorg/libpag/PAGView;", "", "pagPath", "", "p", "", "dp", DomainData.DOMAIN_NAME, "pagUrl", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "played", "e", "assetLoaded", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "hideRunnable", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerPagView extends VasPagView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean played;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean assetLoaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable hideRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerPagView(Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final float n(float dp5) {
        return TypedValue.applyDimension(1, dp5, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QQStrangerPagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.played.set(false);
        this$0.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerPagView$hideRunnable$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.stop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(PAGView pAGView, String str) {
        if (this.assetLoaded.get()) {
            return;
        }
        PAGComposition Make = PAGComposition.Make(pAGView.getWidth(), pAGView.getHeight());
        PAGFile Load = PagViewMonitor.Load(str);
        Matrix totalMatrix = Load != null ? Load.getTotalMatrix() : null;
        float n3 = n(pAGView.getMeasuredWidth()) / Load.width();
        if (totalMatrix != null) {
            totalMatrix.setScale(n3, n3);
        }
        Load.setMatrix(totalMatrix);
        if (Make != null) {
            Make.addLayer(Load);
        }
        pAGView.setComposition(Load);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final QQStrangerPagView this$0, final a aVar, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QQStrangerGuideDialog", 1, "download " + loadState + ", option: " + option);
        if (loadState == LoadState.STATE_DOWNLOAD_SUCCESS) {
            final String picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(option);
            this$0.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerPagView$startPlay$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PAGView it) {
                    Runnable runnable;
                    AtomicBoolean atomicBoolean;
                    Intrinsics.checkNotNullParameter(it, "it");
                    QLog.d("QQStrangerGuideDialog", 1, "localPath: " + picLocalPath + " isPlaying: " + it.isPlaying());
                    QQStrangerPagView qQStrangerPagView = this$0;
                    runnable = qQStrangerPagView.hideRunnable;
                    qQStrangerPagView.removeCallbacks(runnable);
                    QQStrangerPagView qQStrangerPagView2 = this$0;
                    String localStr = picLocalPath;
                    Intrinsics.checkNotNullExpressionValue(localStr, "localStr");
                    qQStrangerPagView2.p(it, localStr);
                    if (!it.isPlaying()) {
                        this$0.setVisibility(0);
                        atomicBoolean = this$0.played;
                        atomicBoolean.set(true);
                        it.play();
                        it.addListener(new a(aVar, this$0));
                    }
                    it.setRepeatCount(500);
                }

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerPagView$startPlay$1$1$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes33.dex */
                public static final class a implements PAGView.PAGViewListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.matchfriend.reborn.guide.a f245099d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QQStrangerPagView f245100e;

                    a(com.tencent.mobileqq.matchfriend.reborn.guide.a aVar, QQStrangerPagView qQStrangerPagView) {
                        this.f245099d = aVar;
                        this.f245100e = qQStrangerPagView;
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationCancel(PAGView p06) {
                        Runnable runnable;
                        QQStrangerPagView qQStrangerPagView = this.f245100e;
                        runnable = qQStrangerPagView.hideRunnable;
                        qQStrangerPagView.post(runnable);
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationEnd(PAGView p06) {
                        Runnable runnable;
                        QQStrangerPagView qQStrangerPagView = this.f245100e;
                        runnable = qQStrangerPagView.hideRunnable;
                        qQStrangerPagView.post(runnable);
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationStart(PAGView p06) {
                        com.tencent.mobileqq.matchfriend.reborn.guide.a aVar = this.f245099d;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationRepeat(PAGView p06) {
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationUpdate(PAGView p06) {
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.hideRunnable);
    }

    public final void q(String pagUrl, final a callback) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        Option url = Option.obtainDownloadOption().setUrl(pagUrl);
        QLog.d("QQStrangerGuideDialog", 2, "getPicLocalPath local path ");
        QQPicLoader.f201806a.d().download(url, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QQStrangerPagView.r(QQStrangerPagView.this, callback, loadState, option);
            }
        });
    }

    public final void s() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerPagView$stopPlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGView it) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                Runnable runnable;
                Intrinsics.checkNotNullParameter(it, "it");
                atomicBoolean = QQStrangerPagView.this.played;
                if (atomicBoolean.get()) {
                    it.stop();
                }
                atomicBoolean2 = QQStrangerPagView.this.assetLoaded;
                atomicBoolean2.set(false);
                QQStrangerPagView qQStrangerPagView = QQStrangerPagView.this;
                runnable = qQStrangerPagView.hideRunnable;
                qQStrangerPagView.removeCallbacks(runnable);
                PAGComposition composition = it.getComposition();
                if (composition != null) {
                    composition.removeAllLayers();
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerPagView(Context ctx, AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ QQStrangerPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerPagView(Context ctx, AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.played = new AtomicBoolean(false);
        this.assetLoaded = new AtomicBoolean(false);
        api().build();
        this.hideRunnable = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.d
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerPagView.o(QQStrangerPagView.this);
            }
        };
    }
}
