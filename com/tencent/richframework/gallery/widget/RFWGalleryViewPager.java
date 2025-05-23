package com.tencent.richframework.gallery.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.gallery.adapter.RFWBaseLayerAdapter;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\f\u008d\u0001\u008c\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B,\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u0012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\t\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0017J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J$\u0010.\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010-\u001a\u00020\u0017H\u0002J\u0018\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0002J\u001c\u00105\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u00172\b\u00104\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u00106\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020\u0005H\u0002R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010QR\u0014\u0010S\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0014\u0010T\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bT\u0010QR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010OR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010YR\u0016\u0010e\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010YR\u0016\u0010f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010QR\u0018\u0010g\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010hR\u0016\u0010l\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010OR\u0016\u0010m\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010OR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010OR\u0016\u0010o\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010OR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001f0p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0011\u0010u\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\bs\u0010tR0\u0010v\u001a\b\u0012\u0002\b\u0003\u0018\u00010A2\f\u0010v\u001a\b\u0012\u0002\b\u0003\u0018\u00010A8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010}\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b{\u0010t\"\u0004\b\f\u0010|R\u0014\u0010~\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0082\u0001\u001a\u00020/8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0084\u0001\u001a\u00020/8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0016\u0010\u0086\u0001\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010t\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "Landroid/widget/FrameLayout;", "", "", "enableOperate", "", "setEnableOperate", "stopBanner", "setStopBanner", "", c.G, "smoothScroll", "setCurrentItem", "stop", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemClickListener;", "onItemClickListener", "setOnItemClickListener", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemDoubleClickListener;", "onItemDoubleClickListener", "setOnItemDoubleClickListener", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "onItemLongClickListener", "setOnItemLongClickListener", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "Landroid/content/Context;", "context", "init", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "createBaseOnPageChangeCallback", "setCurrentItemWithAnimation", "position", "getRealPosition", "callOnLongClick", "handleDispatchDownEvent", "initDampParams", "handleDispatchMoveEvent", "handleDispatchCancelEvent", "handleDispatchUpEvent", "initDownEventParams", "firstDown", "firstUp", "secondDown", "isConsideredDoubleTap", "", "firstDownTime", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "isConsideredLongClick", "lastEvent", "currentEvent", "isConsideredScroll", "handleInterceptActionMove", "e", "onActionMove", "resetPrinceViewH", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager2", "(Landroidx/viewpager2/widget/ViewPager2;)V", "Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;", "mAdapter", "Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$AutoSwitchTask;", "autoSwitchTask", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$AutoSwitchTask;", "Landroid/animation/ValueAnimator;", "mAnimator", "Landroid/animation/ValueAnimator;", "getMAnimator", "()Landroid/animation/ValueAnimator;", "setMAnimator", "(Landroid/animation/ValueAnimator;)V", "mCurrentPos", "I", "mEnableOperate", "Z", "mStopBanner", "mOpenLeftDamp", "mOpenRightDamp", "mInitLeft", "mInitRight", "", "mVariableX", UserInfo.SEX_FEMALE, "itemLongClickLister", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Ljava/lang/Runnable;", "mClickTask", "Ljava/lang/Runnable;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$LongClickTask;", "mLongClickTask", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$LongClickTask;", "mDownTime", "J", "mDownX", "mDownY", "mHadMove", "mFirstDownEvent", "Landroid/view/MotionEvent;", "mFirstUpEvent", "mPreviousDownEvent", "mPreviousUpEvent", "mClickCount", "doubleTapSlop", "mDoubleTapSlopSquare", "mTouchSlop", "", "mExternalPageChangeCallbacks", "Ljava/util/List;", "getDataSize", "()I", "dataSize", "adapter", "getAdapter", "()Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;", "setAdapter", "(Lcom/tencent/richframework/gallery/adapter/RFWBaseLayerAdapter;)V", "getCurrentItem", "(I)V", "currentItem", "isCanLoop", "()Z", "getAnimationTime", "()J", "animationTime", "getSwitchDurationTime", "switchDurationTime", "getTotalSize", "totalSize", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "AutoSwitchTask", "LongClickTask", "OnItemClickListener", "OnItemDoubleClickListener", "OnItemLongClickListener", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWGalleryViewPager extends FrameLayout {
    private AutoSwitchTask autoSwitchTask;
    private int doubleTapSlop;
    private OnItemLongClickListener itemLongClickLister;
    private RFWBaseLayerAdapter<?> mAdapter;
    public ValueAnimator mAnimator;
    private int mClickCount;
    private Runnable mClickTask;
    private volatile int mCurrentPos;
    private int mDoubleTapSlopSquare;
    private long mDownTime;
    private float mDownX;
    private float mDownY;
    private boolean mEnableOperate;
    private final List<ViewPager2.OnPageChangeCallback> mExternalPageChangeCallbacks;
    private MotionEvent mFirstDownEvent;
    private MotionEvent mFirstUpEvent;
    private boolean mHadMove;
    private int mInitLeft;
    private int mInitRight;
    private LongClickTask mLongClickTask;
    private final boolean mOpenLeftDamp;
    private final boolean mOpenRightDamp;
    private MotionEvent mPreviousDownEvent;
    private MotionEvent mPreviousUpEvent;
    private boolean mStopBanner;
    private int mTouchSlop;
    private float mVariableX;
    public ViewPager2 viewPager2;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$AutoSwitchTask;", "Ljava/lang/Runnable;", "banner", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "(Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;)V", "weakReference", "Ljava/lang/ref/WeakReference;", TencentLocation.RUN_MODE, "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class AutoSwitchTask implements Runnable {
        private final WeakReference<RFWGalleryViewPager> weakReference;

        public AutoSwitchTask(@NotNull RFWGalleryViewPager banner) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            this.weakReference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager2 viewPager2;
            RFWGalleryViewPager rFWGalleryViewPager = this.weakReference.get();
            if (rFWGalleryViewPager != null) {
                viewPager2 = rFWGalleryViewPager.getViewPager2();
            } else {
                viewPager2 = null;
            }
            if (viewPager2 == null) {
                return;
            }
            int mCurrentPos = rFWGalleryViewPager.getMCurrentPos() + 1;
            if (rFWGalleryViewPager.isCanLoop()) {
                mCurrentPos %= rFWGalleryViewPager.getDataSize();
            }
            rFWGalleryViewPager.setCurrentItemWithAnimation(mCurrentPos);
            rFWGalleryViewPager.postDelayed(rFWGalleryViewPager.autoSwitchTask, rFWGalleryViewPager.getAnimationTime() + rFWGalleryViewPager.getSwitchDurationTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$LongClickTask;", "Ljava/lang/Runnable;", "banner", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "(Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;)V", "weakReference", "Ljava/lang/ref/WeakReference;", TencentLocation.RUN_MODE, "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class LongClickTask implements Runnable {
        private final WeakReference<RFWGalleryViewPager> weakReference;

        public LongClickTask(@NotNull RFWGalleryViewPager banner) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            this.weakReference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            RFWGalleryViewPager rFWGalleryViewPager = this.weakReference.get();
            if (rFWGalleryViewPager != null) {
                rFWGalleryViewPager.callOnLongClick();
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemClickListener;", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface OnItemClickListener {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemDoubleClickListener;", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface OnItemDoubleClickListener {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "onItemLongClick", "", "position", "", "onItemLongClickCancel", "onItemLongClickUp", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface OnItemLongClickListener {
        void onItemLongClick(int position);

        void onItemLongClickCancel(int position);

        void onItemLongClickUp(int position);
    }

    @JvmOverloads
    public RFWGalleryViewPager(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    public static final /* synthetic */ OnItemClickListener access$getItemClickListener$p(RFWGalleryViewPager rFWGalleryViewPager) {
        rFWGalleryViewPager.getClass();
        return null;
    }

    public static final /* synthetic */ OnItemDoubleClickListener access$getItemDoubleClickListener$p(RFWGalleryViewPager rFWGalleryViewPager) {
        rFWGalleryViewPager.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callOnLongClick() {
        OnItemLongClickListener onItemLongClickListener;
        if (this.itemLongClickLister != null && !this.mHadMove && isConsideredLongClick(this.mDownTime, System.currentTimeMillis()) && (onItemLongClickListener = this.itemLongClickLister) != null) {
            onItemLongClickListener.onItemLongClick(this.mCurrentPos);
        }
    }

    private final ViewPager2.OnPageChangeCallback createBaseOnPageChangeCallback() {
        return new RFWGalleryViewPager$createBaseOnPageChangeCallback$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getAnimationTime() {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter != null) {
            return rFWBaseLayerAdapter.getAnimationTime();
        }
        return 1000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRealPosition(int position) {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter != null) {
            return rFWBaseLayerAdapter.getRealPosition(position);
        }
        return position;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getSwitchDurationTime() {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter != null) {
            return rFWBaseLayerAdapter.getSwitchDurationTime();
        }
        return 2000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter == null) {
            RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[getTotalSize] -> mAdapter == null ");
            return 0;
        }
        Intrinsics.checkNotNull(rFWBaseLayerAdapter);
        return rFWBaseLayerAdapter.getItemCount();
    }

    private final void handleDispatchCancelEvent(MotionEvent ev5) {
        OnItemLongClickListener onItemLongClickListener;
        removeCallbacks(this.mLongClickTask);
        if (isConsideredLongClick(this.mDownTime, System.currentTimeMillis()) && (onItemLongClickListener = this.itemLongClickLister) != null) {
            onItemLongClickListener.onItemLongClickCancel(this.mCurrentPos);
        }
    }

    private final void handleDispatchDownEvent(MotionEvent ev5) {
        initDownEventParams(ev5);
        initDampParams(ev5);
    }

    private final void handleDispatchMoveEvent(MotionEvent ev5) {
        boolean z16;
        if (Math.sqrt(Math.pow(Math.abs(ev5.getX() - this.mDownX), 2.0d) + Math.pow(Math.abs(ev5.getY() - this.mDownY), 2.0d)) > 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mHadMove = z16;
    }

    private final boolean handleDispatchUpEvent(final MotionEvent ev5) {
        removeCallbacks(this.mLongClickTask);
        Runnable runnable = new Runnable() { // from class: com.tencent.richframework.gallery.widget.RFWGalleryViewPager$handleDispatchUpEvent$1
            @Override // java.lang.Runnable
            public final void run() {
                long j3;
                boolean isConsideredLongClick;
                boolean z16;
                int i3;
                int i16;
                RFWGalleryViewPager.OnItemLongClickListener onItemLongClickListener;
                int i17;
                RFWGalleryViewPager rFWGalleryViewPager = RFWGalleryViewPager.this;
                j3 = rFWGalleryViewPager.mDownTime;
                isConsideredLongClick = rFWGalleryViewPager.isConsideredLongClick(j3, System.currentTimeMillis());
                if (isConsideredLongClick) {
                    onItemLongClickListener = RFWGalleryViewPager.this.itemLongClickLister;
                    if (onItemLongClickListener != null) {
                        i17 = RFWGalleryViewPager.this.mCurrentPos;
                        onItemLongClickListener.onItemLongClickUp(i17);
                        return;
                    }
                    return;
                }
                z16 = RFWGalleryViewPager.this.mHadMove;
                if (!z16) {
                    i3 = RFWGalleryViewPager.this.mClickCount;
                    if (i3 >= 2) {
                        RFWGalleryViewPager.access$getItemDoubleClickListener$p(RFWGalleryViewPager.this);
                    }
                    i16 = RFWGalleryViewPager.this.mClickCount;
                    if (i16 == 1) {
                        RFWGalleryViewPager.access$getItemClickListener$p(RFWGalleryViewPager.this);
                    }
                    RFWGalleryViewPager.this.mClickCount = 0;
                    RFWGalleryViewPager.this.mFirstDownEvent = null;
                    RFWGalleryViewPager.this.mFirstUpEvent = null;
                    RFWGalleryViewPager.this.mPreviousDownEvent = null;
                    RFWGalleryViewPager.this.mPreviousUpEvent = null;
                }
            }
        };
        this.mClickTask = runnable;
        postDelayed(runnable, 300);
        if (this.mFirstUpEvent == null) {
            this.mFirstUpEvent = MotionEvent.obtain(ev5);
        }
        MotionEvent motionEvent = this.mPreviousUpEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.mPreviousUpEvent = MotionEvent.obtain(ev5);
        return super.dispatchTouchEvent(ev5);
    }

    private final boolean handleInterceptActionMove(MotionEvent ev5) {
        float x16 = ev5.getX() - this.mVariableX;
        if (this.mEnableOperate && ((this.mOpenLeftDamp && x16 > 0) || (this.mOpenRightDamp && x16 < 0))) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    private final void init(Context context) {
        this.autoSwitchTask = new AutoSwitchTask(this);
        this.mLongClickTask = new LongClickTask(this);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
        int scaledDoubleTapSlop = configuration.getScaledDoubleTapSlop();
        this.doubleTapSlop = scaledDoubleTapSlop;
        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.mTouchSlop = configuration.getScaledTouchSlop() * configuration.getScaledTouchSlop();
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.viewPager2 = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager22.registerOnPageChangeCallback(createBaseOnPageChangeCallback());
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        addView(viewPager23);
    }

    private final void initDampParams(MotionEvent ev5) {
        this.mVariableX = ev5.getX();
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        this.mInitLeft = viewPager2.getLeft();
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        this.mInitRight = viewPager22.getRight();
    }

    private final void initDownEventParams(MotionEvent ev5) {
        this.mDownTime = System.currentTimeMillis();
        this.mDownX = ev5.getX();
        this.mDownY = ev5.getY();
        this.mHadMove = false;
        if (this.mFirstDownEvent == null) {
            this.mFirstDownEvent = MotionEvent.obtain(ev5);
            this.mClickCount = 1;
        }
        if (this.mClickCount >= 1 && isConsideredDoubleTap(this.mPreviousDownEvent, this.mPreviousUpEvent, ev5)) {
            this.mClickCount++;
        }
        if (this.mClickCount == 1) {
            postDelayed(this.mLongClickTask, 500L);
        }
        MotionEvent motionEvent = this.mPreviousDownEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.mPreviousDownEvent = MotionEvent.obtain(ev5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCanLoop() {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter != null && rFWBaseLayerAdapter.isCanLoop()) {
            return true;
        }
        return false;
    }

    private final boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        if (firstDown == null || firstUp == null || secondDown.getEventTime() - firstUp.getEventTime() > 300 || isConsideredScroll(firstDown, firstUp)) {
            return false;
        }
        int x16 = ((int) firstDown.getX()) - ((int) secondDown.getX());
        int y16 = ((int) firstDown.getY()) - ((int) secondDown.getY());
        if ((x16 * x16) + (y16 * y16) >= this.mDoubleTapSlopSquare) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isConsideredLongClick(long firstDownTime, long currentTime) {
        if (currentTime - firstDownTime >= 500) {
            return true;
        }
        return false;
    }

    private final boolean isConsideredScroll(MotionEvent lastEvent, MotionEvent currentEvent) {
        if (lastEvent == null || currentEvent == null) {
            return false;
        }
        int x16 = ((int) currentEvent.getX()) - ((int) lastEvent.getX());
        int y16 = ((int) currentEvent.getY()) - ((int) lastEvent.getY());
        if ((x16 * x16) + (y16 * y16) <= this.mTouchSlop) {
            return false;
        }
        return true;
    }

    private final boolean onActionMove(MotionEvent e16) {
        float x16 = e16.getX();
        float f16 = x16 - this.mVariableX;
        float f17 = 2;
        if (this.viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int abs = (int) (f16 / (f17 + (Math.abs(r3.getLeft()) / 100.0f)));
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int left = viewPager2.getLeft() + abs;
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int right = abs + viewPager22.getRight();
        RFWLog.d("RFWGalleryViewPager", RFWLog.USR, "[onActionMove] -> left = " + left + " , right = " + right);
        if ((this.mOpenLeftDamp && left > 0) || (this.mOpenRightDamp && left < 0)) {
            ViewPager2 viewPager23 = this.viewPager2;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            }
            ViewPager2 viewPager24 = this.viewPager2;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            }
            int top = viewPager24.getTop();
            ViewPager2 viewPager25 = this.viewPager2;
            if (viewPager25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            }
            viewPager23.layout(left, top, right, viewPager25.getBottom());
            this.mVariableX = x16;
            return true;
        }
        return super.onTouchEvent(e16);
    }

    private final void resetPrinceViewH() {
        if (this.viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(r1.getLeft() - this.mInitLeft, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager2.startAnimation(translateAnimation);
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int i3 = this.mInitLeft;
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int top = viewPager23.getTop();
        int i16 = this.mInitRight;
        ViewPager2 viewPager24 = this.viewPager2;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager22.layout(i3, top, i16, viewPager24.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentItemWithAnimation(int pos) {
        if (this.mCurrentPos == pos) {
            RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[setCurrentItemWithAnimation] -> mCurrentPos == mCurrentPos ");
            return;
        }
        if (getDataSize() <= pos) {
            RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[setCurrentItemWithAnimation] -> getDataSize()() <= pos , getDataSize()() == " + getDataSize() + " , pos == " + pos);
            return;
        }
        if (isCanLoop()) {
            if (this.mCurrentPos == getDataSize() - 1 && pos == 0) {
                pos = getTotalSize() - 1;
            } else {
                pos++;
            }
        }
        if (isCanLoop()) {
            ViewPager2 viewPager2 = this.viewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            }
            int currentItem = viewPager2.getCurrentItem();
            RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
            Intrinsics.checkNotNull(rFWBaseLayerAdapter);
            if (currentItem == rFWBaseLayerAdapter.getItemCount() - 1) {
                ViewPager2 viewPager22 = this.viewPager2;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
                }
                if (viewPager22.isFakeDragging()) {
                    ViewPager2 viewPager23 = this.viewPager2;
                    if (viewPager23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
                    }
                    viewPager23.endFakeDrag();
                }
                ViewPager2 viewPager24 = this.viewPager2;
                if (viewPager24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
                }
                viewPager24.setCurrentItem(1, false);
            }
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        ViewPager2 viewPager25 = this.viewPager2;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        int currentItem2 = viewPager25.getCurrentItem();
        ViewPager2 viewPager26 = this.viewPager2;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, viewPager26.getWidth() * (pos - currentItem2));
        Intrinsics.checkNotNullExpressionValue(ofInt, "ValueAnimator.ofInt(0, pxToDrag)");
        this.mAnimator = ofInt;
        if (ofInt == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.gallery.widget.RFWGalleryViewPager$setCurrentItemWithAnimation$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(@NotNull ValueAnimator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                Object animatedValue = animator.getAnimatedValue();
                if (animatedValue != null) {
                    int intValue = ((Integer) animatedValue).intValue();
                    RFWGalleryViewPager.this.getViewPager2().fakeDragBy(-(intValue - atomicInteger.get()));
                    atomicInteger.set(intValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        });
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.tencent.richframework.gallery.widget.RFWGalleryViewPager$setCurrentItemWithAnimation$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                RFWGalleryViewPager.this.getViewPager2().endFakeDrag();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                RFWGalleryViewPager.this.getViewPager2().beginFakeDrag();
            }
        });
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        valueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        valueAnimator3.setDuration(getAnimationTime());
        ValueAnimator valueAnimator4 = this.mAnimator;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        valueAnimator4.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.mEnableOperate) {
            int action = ev5.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            removeCallbacks(this.mLongClickTask);
                        } else {
                            handleDispatchCancelEvent(ev5);
                        }
                    } else {
                        handleDispatchMoveEvent(ev5);
                    }
                } else {
                    return handleDispatchUpEvent(ev5);
                }
            } else {
                if (this.mStopBanner) {
                    stop();
                }
                handleDispatchDownEvent(ev5);
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
        if (ev5.getAction() == 0 && !dispatchTouchEvent) {
            return true;
        }
        return dispatchTouchEvent;
    }

    @Nullable
    public final RFWBaseLayerAdapter<?> getAdapter() {
        return this.mAdapter;
    }

    /* renamed from: getCurrentItem, reason: from getter */
    public final int getMCurrentPos() {
        return this.mCurrentPos;
    }

    public final int getDataSize() {
        RFWBaseLayerAdapter<?> rFWBaseLayerAdapter = this.mAdapter;
        if (rFWBaseLayerAdapter == null) {
            RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[getDataSize] -> mAdapter == null ");
            return 0;
        }
        Intrinsics.checkNotNull(rFWBaseLayerAdapter);
        return rFWBaseLayerAdapter.getItemCount();
    }

    @NotNull
    public final ViewPager2 getViewPager2() {
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        return viewPager2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        RFWLog.d("RFWGalleryViewPager", RFWLog.DEV, "[onInterceptTouchEvent] -> MotionEvent = " + ev5.getAction());
        if (this.mEnableOperate && ev5.getAction() == 2) {
            return handleInterceptActionMove(ev5);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        RFWLog.d("RFWGalleryViewPager", RFWLog.DEV, "[onTouchEvent] -> MotionEvent = " + ev5.getAction());
        if (this.mEnableOperate && (this.mOpenLeftDamp || this.mOpenRightDamp)) {
            int action = ev5.getAction();
            if (action != 1) {
                if (action == 2) {
                    return onActionMove(ev5);
                }
            }
            resetPrinceViewH();
        }
        return super.onTouchEvent(ev5);
    }

    public final void setAdapter(@Nullable RFWBaseLayerAdapter<?> rFWBaseLayerAdapter) {
        this.mAdapter = rFWBaseLayerAdapter;
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager2.setAdapter(this.mAdapter);
    }

    public final void setCurrentItem(int pos, boolean smoothScroll) {
        if (this.mCurrentPos == pos) {
            return;
        }
        if (getDataSize() <= pos) {
            RFWLog.e("RFWGalleryViewPager", RFWLog.USR, "[setCurrentItem] -> getDataSize()() <= pos , getDataSize()() == " + getDataSize() + " , pos == " + pos);
            return;
        }
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        if (viewPager2.isFakeDragging()) {
            ViewPager2 viewPager22 = this.viewPager2;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            }
            viewPager22.endFakeDrag();
        }
        if (smoothScroll) {
            setCurrentItemWithAnimation(pos);
            return;
        }
        if (isCanLoop()) {
            pos = (this.mCurrentPos == getDataSize() - 1 && pos == 0) ? getTotalSize() - 1 : pos + 1;
        }
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager23.setCurrentItem(pos, smoothScroll);
    }

    public final void setEnableOperate(boolean enableOperate) {
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager2.setUserInputEnabled(enableOperate);
        this.mEnableOperate = enableOperate;
    }

    public final void setMAnimator(@NotNull ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "<set-?>");
        this.mAnimator = valueAnimator;
    }

    public final void setOnItemLongClickListener(@Nullable OnItemLongClickListener onItemLongClickListener) {
        this.itemLongClickLister = onItemLongClickListener;
    }

    public final void setStopBanner(boolean stopBanner) {
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
        }
        viewPager2.setUserInputEnabled(stopBanner);
        this.mStopBanner = stopBanner;
    }

    public final void setViewPager2(@NotNull ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "<set-?>");
        this.viewPager2 = viewPager2;
    }

    public final void stop() {
        removeCallbacks(this.autoSwitchTask);
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimator");
        }
        valueAnimator.cancel();
    }

    @JvmOverloads
    public RFWGalleryViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RFWGalleryViewPager(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RFWGalleryViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentPos = -1;
        this.mEnableOperate = true;
        this.mExternalPageChangeCallbacks = new ArrayList();
        init(context);
    }

    public final void setCurrentItem(int i3) {
        setCurrentItem(i3, true);
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
    }

    public final void setOnItemDoubleClickListener(@Nullable OnItemDoubleClickListener onItemDoubleClickListener) {
    }
}
