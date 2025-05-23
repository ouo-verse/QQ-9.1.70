package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b1\u00102B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b1\u00105B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00106\u001a\u00020\u0013\u00a2\u0006\u0004\b1\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J\u0014\u0010\u0017\u001a\u00020\u00052\n\u0010\u0016\u001a\u00020\u0015\"\u00020\u0013H\u0017J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J0\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0017J\b\u0010(\u001a\u00020\u0011H\u0016J \u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0016R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "Landroid/content/Context;", "context", "", "a", "Landroid/view/View;", "getView", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getSpinnerStyle", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "", "success", "", "onFinish", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/a;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/a;", "loadingViewWrapper", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes13.dex */
public final class DiscoveryV2RefreshHeader extends FrameLayout implements IRefreshHeader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a loadingViewWrapper;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f217361a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.RefreshReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.None.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f217361a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u0000\f\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshHeader$c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/a;", "", "a", "b", "", "progress", "c", "", "Z", "rotating", "stopping", "com/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshHeader$c$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshHeader$c$a;", "handler", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.discoveryv2.content.refresh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean rotating;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean stopping;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a handler;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RefreshLoadingView f217365d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/refresh/DiscoveryV2RefreshHeader$c$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends Handler {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RefreshLoadingView f217367b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RefreshLoadingView refreshLoadingView, Looper looper) {
                super(looper);
                this.f217367b = refreshLoadingView;
            }

            @Override // android.os.Handler
            public void handleMessage(@NotNull Message msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (c.this.stopping) {
                    Logger logger = Logger.f235387a;
                    c cVar = c.this;
                    logger.d().i("DiscoveryV2RefreshHeader", 1, "stopRotate success rotating:" + cVar.rotating + " stopping:" + cVar.stopping);
                    this.f217367b.d();
                    c.this.stopping = false;
                    c.this.rotating = false;
                }
            }
        }

        c(RefreshLoadingView refreshLoadingView) {
            this.f217365d = refreshLoadingView;
            this.handler = new a(refreshLoadingView, Looper.getMainLooper());
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.a
        public void a() {
            Logger logger = Logger.f235387a;
            logger.d().i("DiscoveryV2RefreshHeader", 1, "startRotate rotating:" + this.rotating + " stopping:" + this.stopping);
            this.stopping = false;
            this.handler.removeCallbacksAndMessages(null);
            if (this.rotating) {
                return;
            }
            this.rotating = true;
            logger.d().i("DiscoveryV2RefreshHeader", 1, "startRotate success rotating:" + this.rotating + " stopping:" + this.stopping);
            this.f217365d.a();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.a
        public void b() {
            Logger.f235387a.d().i("DiscoveryV2RefreshHeader", 1, "stopRotate rotating:" + this.rotating + " stopping:" + this.stopping);
            if (!this.stopping && this.rotating) {
                this.stopping = true;
                this.handler.sendMessage(Message.obtain());
            }
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.a
        public void c(float progress) {
            if (this.rotating) {
                return;
            }
            this.f217365d.setRotation(progress * 360.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshHeader(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context) {
        RefreshLoadingView refreshLoadingView = new RefreshLoadingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bi.b(24), bi.b(24));
        layoutParams.gravity = 17;
        refreshLoadingView.setLayoutParams(layoutParams);
        addView(refreshLoadingView);
        this.loadingViewWrapper = new c(refreshLoadingView);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "autoOpen " + duration + ", " + dragRate + " " + animationOnly);
        }
        a aVar = this.loadingViewWrapper;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
            aVar = null;
        }
        aVar.a();
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: getSpinnerStyle */
    public SpinnerStyle getFooterSpinnerStyle() {
        SpinnerStyle Translate = SpinnerStyle.Translate;
        Intrinsics.checkNotNullExpressionValue(Translate, "Translate");
        return Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "onFinish " + success);
            return 400;
        }
        return 400;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "onInitialized " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        float coerceAtMost;
        if (isDragging) {
            a aVar = this.loadingViewWrapper;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
                aVar = null;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(percent, 1.0f);
            aVar.c(coerceAtMost);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "onReleased " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "onStartAnimator " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger.f235387a.d().i("DiscoveryV2RefreshHeader", 1, "onStateChanged " + oldState + ", " + newState);
        int i3 = b.f217361a[newState.ordinal()];
        a aVar = null;
        if (i3 != 1) {
            if (i3 == 2) {
                a aVar2 = this.loadingViewWrapper;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
                } else {
                    aVar = aVar2;
                }
                aVar.b();
                return;
            }
            return;
        }
        a aVar3 = this.loadingViewWrapper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
        } else {
            aVar = aVar3;
        }
        aVar.a();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryV2RefreshHeader", "setPrimaryColors " + colors);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoveryV2RefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public View getView() {
        return this;
    }
}
