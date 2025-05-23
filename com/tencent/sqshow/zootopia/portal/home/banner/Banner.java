package com.tencent.sqshow.zootopia.portal.home.banner;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import cooperation.qzone.QZoneTopGestureLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u008c\u0001*\u0004\b\u0000\u0010\u0001*\u0016\b\u0001\u0010\u0004*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u00020\u00052\u00020\u0006:\b\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001B\u0013\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001B\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0089\u0001B(\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u0012\u0007\u0010\u008a\u0001\u001a\u00020\u0010\u00a2\u0006\u0006\b\u0085\u0001\u0010\u008b\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0010J\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00028\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 J\u0010\u0010$\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010#J\u000e\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0012J\u0016\u0010+\u001a\u00020\t2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)J\u0018\u0010,\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0010\u0010/\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-J\u0010\u00100\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-J\u000e\u00103\u001a\u00020\t2\u0006\u00102\u001a\u000201J\u000e\u00106\u001a\u00020\t2\u0006\u00105\u001a\u000204J\u000e\u00109\u001a\u00020\t2\u0006\u00108\u001a\u000207J\u0010\u0010;\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\rH\u0016J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010>\u001a\u00020\tH\u0014J\b\u0010?\u001a\u00020\tH\u0014J\u0006\u0010@\u001a\u00020\tJ\u0006\u0010A\u001a\u00020\tJ\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020\u0010J\u0010\u0010F\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DJ\u0012\u0010G\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010H\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010I\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016R\u0016\u0010K\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010MR&\u0010Q\u001a\u00120OR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010PR&\u0010T\u001a\u00120RR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010SR\u0014\u0010V\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010YR\u0018\u0010]\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010^R\u0016\u0010a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010UR\u0016\u0010c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\"\u0010j\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010b\u001a\u0004\b[\u0010g\"\u0004\bh\u0010iR\"\u0010l\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010b\u001a\u0004\bU\u0010g\"\u0004\bk\u0010iR\"\u0010r\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010U\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010UR\"\u0010w\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0001\u0010U\u001a\u0004\bu\u0010o\"\u0004\bv\u0010qR\u0016\u0010y\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010UR\u0016\u0010|\u001a\u00020z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010\u000fR\u0016\u0010~\u001a\u00020z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010\u000fR\u0017\u0010\u0080\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010bR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "T", "Lqa4/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "BA", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/b;", "Landroid/content/Context;", "context", "", "G", "H", "O", "Landroid/view/MotionEvent;", "event", UserInfo.SEX_FEMALE, "", "position", "", "smoothScroll", "M", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isIntercept", "y", "Landroidx/viewpager2/widget/ViewPager2;", "E", "D", "adapter", "setAdapter", "(Lqa4/b;)V", "Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "pageListener", "v", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$a;", "u", "radius", "setBackgroundRadius", "loop", "setInfiniteLoop", "Lqa4/d;", "listener", "setOnBannerListener", "setCurrentItemOutSide", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "transformer", "w", "K", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "indicator", "setIndicator", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;", "margin", "setIndicatorMargin", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/Direction;", "direction", "setIndicatorGravity", "ev", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "owner", "t", DKHippyEvent.EVENT_STOP, "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "Landroidx/viewpager2/widget/CompositePageTransformer;", "Landroidx/viewpager2/widget/CompositePageTransformer;", "mCompositePageTransformer", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$b;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$b;", "mPageChangeCallback", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$AutoLoopTask;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$AutoLoopTask;", "mLoopTask", "I", "invalidValue", "Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "mOnPageChangeListener", "Lqa4/b;", "mAdapter", "J", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "mIndicator", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "L", "mDirection", "Z", "mIsSelectItem", "N", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$a;", "mLoopListener", "()Z", "setInfiniteLooper", "(Z)V", "isInfiniteLooper", "setAutoLoop", "isAutoLoop", BdhLogUtil.LogTag.Tag_Req, "B", "()I", "setMLoopTime", "(I)V", "mLoopTime", ExifInterface.LATITUDE_SOUTH, "mScrollTime", "getMStartPosition", "setMStartPosition", "mStartPosition", "U", "mTouchSlop", "", "V", "mStartX", "W", "mStartY", "a0", "mIsViewPager2Drag", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "b0", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mAdapterDataObserver", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "AutoLoopTask", "a", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Banner<T, BA extends qa4.b<T, ? extends RecyclerView.ViewHolder>> extends RoundRelativeLayout implements com.tencent.sqshow.zootopia.portal.home.banner.b {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewPager2 mViewPager2;

    /* renamed from: D, reason: from kotlin metadata */
    private CompositePageTransformer mCompositePageTransformer;

    /* renamed from: E, reason: from kotlin metadata */
    private Banner<T, BA>.b mPageChangeCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private Banner<T, BA>.AutoLoopTask mLoopTask;

    /* renamed from: G, reason: from kotlin metadata */
    private final int invalidValue;

    /* renamed from: H, reason: from kotlin metadata */
    private c mOnPageChangeListener;

    /* renamed from: I, reason: from kotlin metadata */
    private BA mAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.portal.home.banner.indicator.a mIndicator;

    /* renamed from: K, reason: from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private int mDirection;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsSelectItem;

    /* renamed from: N, reason: from kotlin metadata */
    private a mLoopListener;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isInfiniteLooper;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isAutoLoop;

    /* renamed from: R, reason: from kotlin metadata */
    private int mLoopTime;

    /* renamed from: S, reason: from kotlin metadata */
    private int mScrollTime;

    /* renamed from: T, reason: from kotlin metadata */
    private int mStartPosition;

    /* renamed from: U, reason: from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: V, reason: from kotlin metadata */
    private float mStartX;

    /* renamed from: W, reason: from kotlin metadata */
    private float mStartY;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsViewPager2Drag;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$AutoLoopTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "d", "Ljava/lang/ref/WeakReference;", "reference", "banner", "<init>", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class AutoLoopTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private WeakReference<Banner<T, BA>> reference;
        final /* synthetic */ Banner<T, BA> this$0;

        public AutoLoopTask(Banner banner, Banner<T, BA> banner2) {
            Intrinsics.checkNotNullParameter(banner2, "banner");
            this.this$0 = banner;
            this.reference = new WeakReference<>(banner2);
        }

        @Override // java.lang.Runnable
        public void run() {
            int A;
            int i3;
            int i16;
            Banner<T, BA> banner = this.reference.get();
            Log.d("ZootopiaBanner", "run: banner is null " + (banner == null));
            if (banner == null || !banner.getIsAutoLoop() || (A = banner.A()) == 0) {
                return;
            }
            AutoLoopTask autoLoopTask = null;
            if (((Banner) banner).mIsSelectItem) {
                ((Banner) banner).mIsSelectItem = false;
                AutoLoopTask autoLoopTask2 = ((Banner) banner).mLoopTask;
                if (autoLoopTask2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoopTask");
                } else {
                    autoLoopTask = autoLoopTask2;
                }
                banner.postDelayed(autoLoopTask, banner.getMLoopTime());
                return;
            }
            ViewPager2 viewPager2 = ((Banner) banner).mViewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager2 = null;
            }
            int currentItem = viewPager2.getCurrentItem();
            if (banner.getIsInfiniteLooper()) {
                i16 = (currentItem + 1) % A;
            } else {
                if (currentItem + 1 == banner.C()) {
                    ((Banner) banner).mDirection = -1;
                    i3 = 0;
                } else {
                    ((Banner) banner).mDirection = 1;
                    i3 = currentItem;
                }
                i16 = i3 + ((Banner) banner).mDirection;
            }
            Log.d("ZootopiaBanner", "run: next " + i16 + " cur " + currentItem);
            Banner.N(banner, i16, false, 2, null);
            AutoLoopTask autoLoopTask3 = ((Banner) banner).mLoopTask;
            if (autoLoopTask3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoopTask");
            } else {
                autoLoopTask = autoLoopTask3;
            }
            banner.postDelayed(autoLoopTask, banner.getMLoopTime());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$a;", "", "", "dstPosition", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(int dstPosition);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner$b;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "o0", "b", "I", "mTempPosition", "", "c", "Z", "isScrolled", "d", "isFirstSelected", "<init>", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int mTempPosition;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isScrolled;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstSelected = true;

        public b() {
            this.mTempPosition = Banner.this.invalidValue;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            sa4.a aVar;
            Integer a16;
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                if (this.mTempPosition != ((Banner) Banner.this).invalidValue && Banner.this.getIsInfiniteLooper() && (a16 = (aVar = sa4.a.f433598a).a(this.mTempPosition, Banner.this.C(), Banner.this.A())) != null) {
                    Banner<T, BA> banner = Banner.this;
                    int intValue = a16.intValue();
                    a aVar2 = ((Banner) banner).mLoopListener;
                    if (aVar2 != null) {
                        aVar2.a(aVar.b(banner.getIsInfiniteLooper(), intValue, banner.C()));
                    }
                    banner.M(intValue, false);
                }
                this.isScrolled = false;
            } else if (state == 1 || state == 2) {
                this.isScrolled = true;
            }
            c cVar = ((Banner) Banner.this).mOnPageChangeListener;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(state);
            }
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar3 = ((Banner) Banner.this).mIndicator;
            if (aVar3 != null) {
                aVar3.onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            c cVar;
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            int b16 = sa4.a.f433598a.b(Banner.this.getIsInfiniteLooper(), position, Banner.this.C());
            ViewPager2 viewPager2 = ((Banner) Banner.this).mViewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager2 = null;
            }
            if (b16 == viewPager2.getCurrentItem() - 1 && (cVar = ((Banner) Banner.this).mOnPageChangeListener) != null) {
                cVar.onPageScrolled(b16, positionOffset, positionOffsetPixels);
            }
            com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = ((Banner) Banner.this).mIndicator;
            if (aVar != null) {
                aVar.onPageScrolled(b16, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (this.isFirstSelected || this.isScrolled) {
                this.mTempPosition = position;
                boolean z16 = Banner.this.getIsInfiniteLooper() && sa4.a.f433598a.d(position, Banner.this.A());
                int b16 = sa4.a.f433598a.b(Banner.this.getIsInfiniteLooper(), position, Banner.this.C());
                Log.d("ZootopiaBanner", "onPageSelected: " + position + "  real " + b16);
                c cVar = ((Banner) Banner.this).mOnPageChangeListener;
                if (cVar != null) {
                    cVar.c(b16, z16);
                }
                com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = ((Banner) Banner.this).mIndicator;
                if (aVar != null) {
                    aVar.c(b16, z16);
                }
                this.isFirstSelected = false;
            }
        }

        public final void o0() {
            this.isFirstSelected = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/portal/home/banner/Banner$d", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends RecyclerView.AdapterDataObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Banner<T, BA> f372359d;

        d(Banner<T, BA> banner) {
            this.f372359d = banner;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (this.f372359d.A() <= 1) {
                this.f372359d.Q();
            } else {
                this.f372359d.P();
            }
            this.f372359d.O();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Banner(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int A() {
        BA ba5 = this.mAdapter;
        if (ba5 != null) {
            return ba5.getNUM_BACKGOURND_ICON();
        }
        return 0;
    }

    private final void F(MotionEvent event) {
        int action = event.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = event.getX();
                    float y16 = event.getY();
                    float abs = Math.abs(x16 - this.mStartX);
                    float abs2 = Math.abs(y16 - this.mStartY);
                    ViewPager2 viewPager2 = this.mViewPager2;
                    if (viewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                        viewPager2 = null;
                    }
                    if (viewPager2.getOrientation() != 0 ? !(abs2 <= this.mTouchSlop || abs2 <= abs) : !(abs <= this.mTouchSlop || abs <= abs2)) {
                        z16 = true;
                    }
                    this.mIsViewPager2Drag = z16;
                    y(true);
                    getParent().requestDisallowInterceptTouchEvent(this.mIsViewPager2Drag);
                    return;
                }
                if (action != 3) {
                    return;
                }
            }
            y(false);
            getParent().requestDisallowInterceptTouchEvent(false);
            TopGestureLayout z17 = z();
            if (z17 != null) {
                z17.setIsInterceptChildEventWhenScroll(true);
            }
            QZoneTopGestureLayout.shouldInterceptEvent(true);
            return;
        }
        this.mStartX = event.getX();
        this.mStartY = event.getY();
        TopGestureLayout z18 = z();
        if (z18 != null) {
            z18.setIsInterceptChildEventWhenScroll(false);
        }
        QZoneTopGestureLayout.shouldInterceptEvent(false);
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    private final void G(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mCompositePageTransformer = new CompositePageTransformer();
        this.mPageChangeCallback = new b();
        this.mLoopTask = new AutoLoopTask(this, this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mViewPager2 = viewPager2;
        viewPager2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ViewPager2 viewPager22 = this.mViewPager2;
        ViewPager2 viewPager23 = null;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager22 = null;
        }
        viewPager22.setOffscreenPageLimit(2);
        ViewPager2 viewPager24 = this.mViewPager2;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager24 = null;
        }
        Banner<T, BA>.b bVar = this.mPageChangeCallback;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageChangeCallback");
            bVar = null;
        }
        viewPager24.registerOnPageChangeCallback(bVar);
        ViewPager2 viewPager25 = this.mViewPager2;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager25 = null;
        }
        CompositePageTransformer compositePageTransformer = this.mCompositePageTransformer;
        if (compositePageTransformer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCompositePageTransformer");
            compositePageTransformer = null;
        }
        viewPager25.setPageTransformer(compositePageTransformer);
        sa4.b.r(this);
        ViewPager2 viewPager26 = this.mViewPager2;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        } else {
            viewPager23 = viewPager26;
        }
        addView(viewPager23);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if ((r1 != null ? r1.l0() : 0) > 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H() {
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.mIndicator;
        if (aVar != null) {
            if (aVar.getHelper().getAttachToBanner()) {
                if (aVar.getHelper().getAutoHideWhenSingle()) {
                    BA ba5 = this.mAdapter;
                }
                View b16 = aVar.b();
                b16.setId(R.id.r5t);
                removeView(b16);
                addView(b16);
                if (aVar.getHelper().getCom.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String() == Direction.BELOW_BANNER) {
                    ViewPager2 viewPager2 = this.mViewPager2;
                    ViewPager2 viewPager22 = null;
                    if (viewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                        viewPager2 = null;
                    }
                    ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    }
                    layoutParams2.addRule(2, b16.getId());
                    ViewPager2 viewPager23 = this.mViewPager2;
                    if (viewPager23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                    } else {
                        viewPager22 = viewPager23;
                    }
                    viewPager22.setLayoutParams(layoutParams2);
                }
            }
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Banner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Banner<T, BA>.b bVar = this$0.mPageChangeCallback;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageChangeCallback");
            bVar = null;
        }
        bVar.onPageSelected(this$0.mStartPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int position, boolean smoothScroll) {
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(position, smoothScroll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        sa4.a aVar = sa4.a.f433598a;
        boolean z16 = this.isInfiniteLooper;
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        int b16 = aVar.b(z16, viewPager2.getCurrentItem(), C());
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar2 = this.mIndicator;
        if (aVar2 != null) {
            aVar2.a(C(), b16);
        }
    }

    private final void y(boolean isIntercept) {
        TopGestureLayout z16 = z();
        if (z16 != null) {
            z16.requestDisallowInterceptTouchEvent(isIntercept);
        }
    }

    private final TopGestureLayout z() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    /* renamed from: B, reason: from getter */
    public final int getMLoopTime() {
        return this.mLoopTime;
    }

    public final int C() {
        BA ba5 = this.mAdapter;
        if (ba5 != null) {
            return ba5.l0();
        }
        return 0;
    }

    /* renamed from: D, reason: from getter */
    public final int getMScrollTime() {
        return this.mScrollTime;
    }

    public final ViewPager2 E() {
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
        return null;
    }

    /* renamed from: I, reason: from getter */
    public final boolean getIsAutoLoop() {
        return this.isAutoLoop;
    }

    /* renamed from: J, reason: from getter */
    public final boolean getIsInfiniteLooper() {
        return this.isInfiniteLooper;
    }

    public final void P() {
        if (this.isAutoLoop) {
            Q();
            Banner<T, BA>.AutoLoopTask autoLoopTask = this.mLoopTask;
            if (autoLoopTask == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoopTask");
                autoLoopTask = null;
            }
            postDelayed(autoLoopTask, this.mLoopTime);
        }
    }

    public final void Q() {
        if (this.isAutoLoop) {
            Banner<T, BA>.AutoLoopTask autoLoopTask = this.mLoopTask;
            if (autoLoopTask == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoopTask");
                autoLoopTask = null;
            }
            removeCallbacks(autoLoopTask);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int actionMasked = ev5.getActionMasked();
        if (actionMasked == 0) {
            Q();
        } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            P();
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        P();
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.b
    public void onDestroy(LifecycleOwner owner) {
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        F(event);
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.b
    public void onStart(LifecycleOwner owner) {
        P();
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.b
    public void onStop(LifecycleOwner owner) {
        Q();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        F(event);
        return super.onTouchEvent(event);
    }

    public final void setAdapter(BA adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mAdapter = adapter;
        if (adapter != null) {
            if (!this.isInfiniteLooper) {
                adapter.n0(0);
            }
            adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            ViewPager2 viewPager2 = this.mViewPager2;
            Banner<T, BA>.b bVar = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager2 = null;
            }
            viewPager2.setAdapter(adapter);
            ViewPager2 viewPager22 = this.mViewPager2;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager22 = null;
            }
            viewPager22.setCurrentItem(this.mStartPosition, false);
            Banner<T, BA>.b bVar2 = this.mPageChangeCallback;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageChangeCallback");
            } else {
                bVar = bVar2;
            }
            bVar.o0();
            post(new Runnable() { // from class: com.tencent.sqshow.zootopia.portal.home.banner.a
                @Override // java.lang.Runnable
                public final void run() {
                    Banner.L(Banner.this);
                }
            });
            H();
        }
    }

    public final void setAutoLoop(boolean z16) {
        this.isAutoLoop = z16;
    }

    public final void setCurrentItemOutSide(int position, boolean smoothScroll) {
        BA ba5 = this.mAdapter;
        if (ba5 != null && position >= 0) {
            Intrinsics.checkNotNull(ba5);
            if (position > ba5.getNUM_BACKGOURND_ICON()) {
                return;
            }
            Log.d("ZootopiaBanner", "setCurrentItem: " + position);
            this.mIsSelectItem = true;
            M(position, smoothScroll);
        }
    }

    public final void setIndicator(com.tencent.sqshow.zootopia.portal.home.banner.indicator.a indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.mIndicator;
        if (aVar != null) {
            removeView(aVar.b());
        }
        this.mIndicator = indicator;
        H();
    }

    public final void setIndicatorGravity(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.mIndicator;
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.b helper = aVar != null ? aVar.getHelper() : null;
        if (helper == null) {
            return;
        }
        helper.r(direction);
    }

    public final void setIndicatorMargin(com.tencent.sqshow.zootopia.portal.home.banner.indicator.c margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.a aVar = this.mIndicator;
        com.tencent.sqshow.zootopia.portal.home.banner.indicator.b helper = aVar != null ? aVar.getHelper() : null;
        if (helper == null) {
            return;
        }
        helper.v(margin);
    }

    public final void setInfiniteLoop(boolean loop) {
        this.isInfiniteLooper = loop;
    }

    public final void setInfiniteLooper(boolean z16) {
        this.isInfiniteLooper = z16;
    }

    public final void setMLoopTime(int i3) {
        this.mLoopTime = i3;
    }

    public final void setMStartPosition(int i3) {
        this.mStartPosition = i3;
    }

    public final void setOnBannerListener(qa4.d<T> listener) {
        BA ba5 = this.mAdapter;
        if (ba5 != null) {
            ba5.o0(listener);
        }
    }

    public final void u(a pageListener) {
        this.mLoopListener = pageListener;
    }

    public final void v(c pageListener) {
        this.mOnPageChangeListener = pageListener;
    }

    public final void x() {
        ViewPager2 viewPager2 = this.mViewPager2;
        Banner<T, BA>.b bVar = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        }
        Banner<T, BA>.b bVar2 = this.mPageChangeCallback;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageChangeCallback");
        } else {
            bVar = bVar2;
        }
        viewPager2.unregisterOnPageChangeCallback(bVar);
        Q();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.invalidValue = -1;
        this.mDirection = 1;
        this.isInfiniteLooper = true;
        this.isAutoLoop = true;
        this.mLoopTime = 5000;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.mAdapterDataObserver = new d(this);
        G(context);
    }

    public final void K(ViewPager2.PageTransformer transformer) {
        if (transformer != null) {
            CompositePageTransformer compositePageTransformer = this.mCompositePageTransformer;
            if (compositePageTransformer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompositePageTransformer");
                compositePageTransformer = null;
            }
            compositePageTransformer.removeTransformer(transformer);
        }
    }

    public final void setBackgroundRadius(int radius) {
        this.f316197h = 15;
        this.f316195e = radius;
    }

    public final void t(LifecycleOwner owner) {
        Lifecycle lifecycle;
        if (owner == null || (lifecycle = owner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(new BannerLifecycleObserverAdapter(this, owner));
    }

    public final void w(ViewPager2.PageTransformer transformer) {
        if (transformer != null) {
            CompositePageTransformer compositePageTransformer = this.mCompositePageTransformer;
            if (compositePageTransformer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCompositePageTransformer");
                compositePageTransformer = null;
            }
            compositePageTransformer.addTransformer(transformer);
        }
    }

    static /* synthetic */ void N(Banner banner, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        banner.M(i3, z16);
    }

    public static /* synthetic */ void setCurrentItemOutSide$default(Banner banner, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        banner.setCurrentItemOutSide(i3, z16);
    }
}
