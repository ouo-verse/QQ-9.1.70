package com.tencent.sqshow.zootopia.recommend.characterV2.controller;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.smallhome.ZPlanSmallHomeBubbleView;
import com.tencent.sqshow.zootopia.utils.ui.ZPlanViewState;
import com.tencent.sqshow.zootopia.utils.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import zu4.k;
import zu4.l;
import zu4.t;
import zu4.u;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000278B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0003J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rR\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/l;", "", tl.h.F, "Lzu4/t;", "data", "c", "d", "e", "b", "result", "g", "", "error", "", "message", "onResultFailure", "f", "Landroid/graphics/Rect;", "viewPos", "bubbleIndex", "i", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "mBubbleOwner", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView;", "mBubbleView", "Landroid/graphics/Rect;", "mTargetViewRect", "", "Z", "mDestroyed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mBubbleIndex", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController$AutoRefreshTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController$AutoRefreshTask;", "mAutoRefreshTask", "", "D", "J", "mAutoRefreshInterval", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequestLock", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;)V", UserInfo.SEX_FEMALE, "AutoRefreshTask", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeBubbleController implements com.tencent.mobileqq.zootopia.api.e<l> {

    /* renamed from: C, reason: from kotlin metadata */
    private final AutoRefreshTask mAutoRefreshTask;

    /* renamed from: D, reason: from kotlin metadata */
    private long mAutoRefreshInterval;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicBoolean mRequestLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a mBubbleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZPlanSmallHomeBubbleView mBubbleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Rect mTargetViewRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mBubbleIndex;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController$AutoRefreshTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanSmallHomeBubbleController;", "d", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "<init>", "(Ljava/lang/ref/WeakReference;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class AutoRefreshTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanSmallHomeBubbleController> ref;

        public AutoRefreshTask(WeakReference<ZPlanSmallHomeBubbleController> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZPlanSmallHomeBubbleController zPlanSmallHomeBubbleController = this.ref.get();
            if (zPlanSmallHomeBubbleController != null) {
                zPlanSmallHomeBubbleController.e();
            }
        }
    }

    public ZPlanSmallHomeBubbleController(Context mContext, a mBubbleOwner) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mBubbleOwner, "mBubbleOwner");
        this.mContext = mContext;
        this.mBubbleOwner = mBubbleOwner;
        this.mBubbleView = new ZPlanSmallHomeBubbleView(mContext, null, 0, 6, null);
        this.mTargetViewRect = new Rect();
        this.mAutoRefreshTask = new AutoRefreshTask(new WeakReference(this));
        this.mAutoRefreshInterval = 3000L;
        this.mRequestLock = new AtomicBoolean(false);
    }

    private final void b(t data) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAutoRefreshTask);
        long j3 = data.f453483d * 1000;
        this.mAutoRefreshInterval = j3;
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "adjustInterval refreshInterval=" + j3 + ", mDestroyed:" + this.mDestroyed);
        if (this.mAutoRefreshInterval <= 0 || this.mDestroyed) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mAutoRefreshTask, this.mAutoRefreshInterval);
    }

    private final void c(t data) {
        d();
        if (this.mBubbleView.e() == ZPlanViewState.SHOW) {
            this.mBubbleView.i();
        }
        this.mBubbleView.j(data, this.mBubbleIndex);
        this.mBubbleView.n();
    }

    private final void d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) this.mContext.getResources().getDimension(R.dimen.f12537q));
        int width = e84.a.f395879a.d().width();
        layoutParams.gravity = 5;
        Rect rect = this.mTargetViewRect;
        int i3 = width - rect.left;
        layoutParams.rightMargin = i3;
        int i16 = rect.top;
        layoutParams.topMargin = i16;
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "moveBubbleViewToContainer rightMargin:" + i3 + ", topMargin:" + i16);
        ViewParent parent = this.mBubbleView.getParent();
        ViewGroup midContainer = this.mBubbleOwner.getMidContainer();
        if (midContainer != null && Intrinsics.areEqual(parent, midContainer)) {
            this.mBubbleView.setLayoutParams(layoutParams);
            return;
        }
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.mBubbleView);
        }
        if (midContainer != null) {
            midContainer.addView(this.mBubbleView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        boolean a16 = this.mBubbleOwner.a();
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "onAutoRefreshTick mAutoRefreshInterval=" + this.mAutoRefreshInterval + ", canShowBubble:" + a16 + ", mDestroyed:" + this.mDestroyed);
        if (a16) {
            h();
        }
        if (this.mAutoRefreshInterval <= 0 || this.mDestroyed) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mAutoRefreshTask, this.mAutoRefreshInterval);
    }

    private final void h() {
        Long longOrNull;
        int[] intArray;
        if (this.mRequestLock.get()) {
            QLog.w("ZPlanSmallHomeBubbleController_", 1, "requestBubbleData intercepted by RequestLock");
            return;
        }
        this.mRequestLock.set(true);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(w.f373306a.b());
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        k kVar = new k();
        kVar.f453445a = longValue;
        kVar.f453446b = this.mBubbleIndex;
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.mBubbleOwner.c());
        kVar.f453447c = intArray;
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "requestBubbleData uin: req = " + kVar);
        va4.d.b(va4.d.f441287a, kVar, this, 0, 4, null);
    }

    public final void f() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAutoRefreshTask);
        this.mBubbleView.c();
        this.mDestroyed = true;
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onResultSuccess(l result) {
        Intrinsics.checkNotNullParameter(result, "result");
        t bubbleData = result.f453448a;
        u uVar = bubbleData.f453482c;
        String str = uVar != null ? uVar.f453486b : null;
        if (str == null) {
            str = "";
        }
        boolean a16 = this.mBubbleOwner.a();
        Intrinsics.checkNotNullExpressionValue(bubbleData, "bubbleData");
        b(bubbleData);
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "onResultSuccess canShowBubble:" + a16 + ", content:" + str + ", index: " + this.mBubbleIndex);
        if (!(str.length() == 0) && a16) {
            QLog.i("ZPlanSmallHomeBubbleController_", 1, "onResultSuccess show bubble");
            c(bubbleData);
        } else {
            QLog.e("ZPlanSmallHomeBubbleController_", 1, "onResultSuccess do nothing");
        }
        this.mRequestLock.set(false);
    }

    public final void i(Rect viewPos, int bubbleIndex) {
        Intrinsics.checkNotNullParameter(viewPos, "viewPos");
        QLog.i("ZPlanSmallHomeBubbleController_", 1, "onReceiveEvent GetSmallHomeBubbleEvent " + bubbleIndex);
        this.mTargetViewRect = viewPos;
        this.mBubbleIndex = bubbleIndex;
        e();
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        QLog.e("ZPlanSmallHomeBubbleController_", 1, "onResultFailure error:" + error + ", message:" + message + " , " + this.mBubbleIndex);
        this.mRequestLock.set(false);
    }
}
