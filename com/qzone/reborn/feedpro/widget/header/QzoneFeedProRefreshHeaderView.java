package com.qzone.reborn.feedpro.widget.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0002abB'\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020\u001b\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0015J\b\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0012\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001bH\u0016J\u0006\u0010,\u001a\u00020\u0003J\u001a\u0010/\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u0015H\u0004R\u0017\u00103\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u00102R\u001a\u00108\u001a\u00020\u00178\u0006X\u0086D\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00100R\u0016\u0010;\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010:R\u0016\u0010<\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00105R\u0016\u0010=\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00105R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010:R\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b4\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010X\u00a8\u0006c"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/richframework/part/IRefreshViewProvider;", "", "i", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "getRefreshView", "Lcom/tencent/biz/richframework/part/IRefreshViewProvider$OnRefreshListener;", "listener", "setOnRefreshListener", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "onRefreshListener", "c", "p", DomainData.DOMAIN_NAME, "Landroid/view/MotionEvent;", "event", "handleRefreshGesture", "g", "", "j", "", "offset", "sumOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "height", "setVisibleHeight", ReportConstant.COSTREPORT_PREFIX, tl.h.F, "l", "o", "isRefresh", "isRefreshing", "setRefreshing", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "callRefresh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "setState", "v", "destHeight", "needReset", "t", "I", "getRefreshDisThreshold", "()I", "refreshDisThreshold", "e", UserInfo.SEX_FEMALE, "getMoveDisDecayRatio", "()F", "moveDisDecayRatio", "refreshState", "Z", "isManualRefreshing", "touchEventLastY", "slideOffset", "", BdhLogUtil.LogTag.Tag_Conn, "J", "startLoadingTimeStamp", "D", "isSlideUp", "Landroid/os/Handler;", "E", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "mainHandler", "Lcom/tencent/biz/richframework/part/IRefreshViewProvider$OnRefreshListener;", "compactRefreshListener", "", "G", "Ljava/util/List;", "onRefreshListeners", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "H", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "getRefreshProgressProvider", "()Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "setRefreshProgressProvider", "(Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;)V", "refreshProgressProvider", "k", "()Z", "isOnTop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProRefreshHeaderView extends LinearLayout implements IRefreshViewProvider {

    /* renamed from: C, reason: from kotlin metadata */
    private long startLoadingTimeStamp;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isSlideUp;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private IRefreshViewProvider.OnRefreshListener compactRefreshListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final List<QZoneFeedxRefreshView.b> onRefreshListeners;

    /* renamed from: H, reason: from kotlin metadata */
    private b refreshProgressProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int refreshDisThreshold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float moveDisDecayRatio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int refreshState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isManualRefreshing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float touchEventLastY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float slideOffset;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "", "", "d", "offsetY", "", "e", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a();

        int d();

        void e(int offsetY);

        void f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProRefreshHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        if (this.refreshState <= 1) {
            if (l()) {
                n();
            } else {
                p();
            }
        }
    }

    private final Handler e() {
        return (Handler) this.mainHandler.getValue();
    }

    private final void i() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        setOrientation(1);
        setGravity(17);
        setClipChildren(false);
        setClipToPadding(false);
    }

    private final boolean k() {
        return getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QzoneFeedProRefreshHeaderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setState(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QzoneFeedProRefreshHeaderView this$0, boolean z16, int i3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.setVisibleHeight(intValue);
        if (z16 && i3 == 0 && intValue == 0) {
            this$0.p();
        }
    }

    public final void c(QZoneFeedxRefreshView.b onRefreshListener) {
        Intrinsics.checkNotNullParameter(onRefreshListener, "onRefreshListener");
        this.onRefreshListeners.add(onRefreshListener);
    }

    public final int f() {
        b bVar = this.refreshProgressProvider;
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    public final void g() {
        if (!this.isManualRefreshing) {
            o();
        }
        this.touchEventLastY = -1.0f;
        this.slideOffset = 0.0f;
    }

    public final void h() {
        b bVar = this.refreshProgressProvider;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.touchEventLastY == -1.0f) {
            this.touchEventLastY = event.getRawY();
        }
        int action = event.getAction();
        if (action == 0) {
            this.touchEventLastY = event.getRawY();
            this.slideOffset = 0.0f;
            return;
        }
        if (action != 2) {
            Iterator<QZoneFeedxRefreshView.b> it = this.onRefreshListeners.iterator();
            while (it.hasNext()) {
                it.next().onRelease();
            }
            g();
            return;
        }
        float rawY = event.getRawY();
        float f16 = this.touchEventLastY;
        float f17 = (rawY - f16) / 2;
        boolean z16 = f16 == 0.0f;
        this.touchEventLastY = event.getRawY();
        this.slideOffset += f17;
        this.isSlideUp = f17 > 0.0f && !z16;
        if (j()) {
            m(f17, this.slideOffset);
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh, reason: from getter */
    public boolean getIsManualRefreshing() {
        return this.isManualRefreshing;
    }

    public final boolean j() {
        return k() && this.isSlideUp && !this.isManualRefreshing;
    }

    public final boolean l() {
        return this.slideOffset > ((float) this.refreshDisThreshold);
    }

    public final void m(float offset, float sumOffset) {
        Iterator<QZoneFeedxRefreshView.b> it = this.onRefreshListeners.iterator();
        while (it.hasNext()) {
            if (it.next().a(offset, sumOffset)) {
                return;
            }
        }
        if (f() > 0 || offset > 0.0f) {
            setVisibleHeight(((int) (offset * this.moveDisDecayRatio)) + f());
            d();
        }
    }

    public final boolean o() {
        if (k() && l() && this.refreshState < 2) {
            setState(2);
            return true;
        }
        v();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        e().removeCallbacksAndMessages(null);
    }

    public final void s() {
        b bVar = this.refreshProgressProvider;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.compactRefreshListener = listener;
    }

    public final void setRefreshProgressProvider(b bVar) {
        this.refreshProgressProvider = bVar;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean isRefreshing) {
        QLog.i("QZoneConciseZPlan QzoneFeedProRefreshHeaderView", 1, "[setRefreshing] refreshing = " + isRefreshing);
        this.isManualRefreshing = isRefreshing;
        if (isRefreshing) {
            return;
        }
        q();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int state) {
        if (state == this.refreshState) {
            return;
        }
        if (state == 0) {
            h();
        } else if (state == 1) {
            s();
        } else if (state == 2) {
            this.startLoadingTimeStamp = System.currentTimeMillis();
            IRefreshViewProvider.OnRefreshListener onRefreshListener = this.compactRefreshListener;
            if (onRefreshListener != null) {
                onRefreshListener.onRefresh();
            }
            t(0, false);
        } else if (state != 3) {
            QLog.d("QzoneFeedProRefreshHeaderView", 1, "[setState] wrong refresh state: " + state);
        } else {
            v();
        }
        QLog.d("QzoneFeedProRefreshHeaderView", 1, "[setState] refresh state from " + this.refreshState + " to " + state);
        this.refreshState = state;
    }

    public final void setVisibleHeight(int height) {
        b bVar = this.refreshProgressProvider;
        if (bVar != null) {
            bVar.e(height);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProRefreshHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void q() {
        QLog.d("QzoneFeedProRefreshHeaderView", 1, "[refreshComplete]");
        long j3 = 1000 - this.startLoadingTimeStamp;
        if (j3 > 0) {
            e().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.header.n
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProRefreshHeaderView.r(QzoneFeedProRefreshHeaderView.this);
                }
            }, j3);
        } else {
            setState(3);
        }
    }

    public final void n() {
        setState(1);
    }

    public final void p() {
        setState(0);
    }

    protected final void t(final int destHeight, final boolean needReset) {
        ValueAnimator ofInt = ValueAnimator.ofInt(f(), destHeight);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.feedpro.widget.header.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QzoneFeedProRefreshHeaderView.u(QzoneFeedProRefreshHeaderView.this, needReset, destHeight, valueAnimator);
            }
        });
        ofInt.start();
    }

    public /* synthetic */ QzoneFeedProRefreshHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void v() {
        t(0, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProRefreshHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.refreshDisThreshold = ef.d.b(40);
        this.moveDisDecayRatio = 0.25f;
        this.touchEventLastY = -1.0f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mainHandler = lazy;
        this.onRefreshListeners = new ArrayList();
        i();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(RecyclerView recyclerView) {
    }
}
