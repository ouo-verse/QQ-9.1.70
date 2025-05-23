package com.qzone.reborn.albumx.qzone.base.media.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0003hijB\u0011\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\ba\u0010bB\u001b\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\ba\u0010eB#\b\u0016\u0012\u0006\u0010`\u001a\u00020_\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u0012\u0006\u0010f\u001a\u00020\u0004\u00a2\u0006\u0004\ba\u0010gJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010*\u001a\u0004\b6\u0010,\"\u0004\b;\u0010.R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010*\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010I\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\"\u0010K\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bB\u0010A\u001a\u0004\b:\u0010C\"\u0004\bJ\u0010ER\"\u0010P\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010L\u001a\u0004\b*\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010L\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR\"\u0010[\u001a\u00020U8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bR\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010^\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010L\u001a\u0004\b\\\u0010M\"\u0004\b]\u0010O\u00a8\u0006k"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/MotionEvent;", "ev", "", "action", "", "processEvent", "handleUp", "", HippyTKDListViewAdapter.X, "y", "", "handleMove", "handleMoveScrolling", "handleMoveNoScrolling", "handleScroll", "selectPosition", "handleScrollSelectState", "Landroidx/recyclerview/widget/GridLayoutManager;", TtmlNode.TAG_LAYOUT, "setGridLayoutManager", "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;", "l", "setOnIndexChangedListener", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "f", "Landroidx/recyclerview/widget/GridLayoutManager;", UserInfo.SEX_FEMALE, "()Landroidx/recyclerview/widget/GridLayoutManager;", "setMGridLayoutManager", "(Landroidx/recyclerview/widget/GridLayoutManager;)V", "mGridLayoutManager", h.F, "Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;", "L", "()Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;", "setMOnSelectChangedListener", "(Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;)V", "mOnSelectChangedListener", "i", "I", "getMTouchSlop", "()I", "setMTouchSlop", "(I)V", "mTouchSlop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMLastMotionX", "()F", "setMLastMotionX", "(F)V", "mLastMotionX", BdhLogUtil.LogTag.Tag_Conn, "getMLastMotionY", "setMLastMotionY", "mLastMotionY", "D", "setMBeginSelectPosition", "mBeginSelectPosition", "E", "setMEndSelectPosition", "mEndSelectPosition", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setMIsBeingInSelectMode", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mIsBeingInSelectMode", "G", "setMIsBegined", "mIsBegined", "setMEnableSelectMode", "mEnableSelectMode", "Z", "()Z", "setMIsScrolling", "(Z)V", "mIsScrolling", "J", "K", "setMIsScrollingFromTop", "mIsScrollingFromTop", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "M", "()Landroidx/recyclerview/widget/LinearSmoothScroller;", "setMSmoothScroller", "(Landroidx/recyclerview/widget/LinearSmoothScroller;)V", "mSmoothScroller", "getDisallowParentIntercept", "setDisallowParentIntercept", "disallowParentIntercept", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class MediaRecyclerView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    private float mLastMotionY;

    /* renamed from: D, reason: from kotlin metadata */
    private int mBeginSelectPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private int mEndSelectPosition;

    /* renamed from: F, reason: from kotlin metadata */
    public AtomicBoolean mIsBeingInSelectMode;

    /* renamed from: G, reason: from kotlin metadata */
    public AtomicBoolean mIsBegined;

    /* renamed from: H, reason: from kotlin metadata */
    public AtomicBoolean mEnableSelectMode;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsScrolling;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsScrollingFromTop;

    /* renamed from: K, reason: from kotlin metadata */
    public LinearSmoothScroller mSmoothScroller;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean disallowParentIntercept;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GridLayoutManager mGridLayoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d mOnSelectChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mLastMotionX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaRecyclerView f52619c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, MediaRecyclerView mediaRecyclerView) {
            super(context);
            this.f52619c = mediaRecyclerView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 500.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int targetPosition) {
            GridLayoutManager mGridLayoutManager = this.f52619c.getMGridLayoutManager();
            if (mGridLayoutManager == null) {
                return null;
            }
            View childAt = mGridLayoutManager.getChildCount() != 0 ? mGridLayoutManager.getChildAt(0) : null;
            if (childAt != null) {
                return new PointF(0.0f, targetPosition < mGridLayoutManager.getPosition(childAt) ? -1 : 1);
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$c;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "<init>", "(Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            int findFirstCompletelyVisibleItemPosition;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (MediaRecyclerView.this.getMIsScrolling()) {
                GridLayoutManager mGridLayoutManager = MediaRecyclerView.this.getMGridLayoutManager();
                if (mGridLayoutManager != null) {
                    MediaRecyclerView mediaRecyclerView = MediaRecyclerView.this;
                    if (mediaRecyclerView.getMIsScrollingFromTop()) {
                        findFirstCompletelyVisibleItemPosition = mGridLayoutManager.findLastVisibleItemPosition();
                    } else {
                        findFirstCompletelyVisibleItemPosition = mGridLayoutManager.findFirstCompletelyVisibleItemPosition();
                    }
                    mediaRecyclerView.setMEndSelectPosition(findFirstCompletelyVisibleItemPosition);
                }
                d mOnSelectChangedListener = MediaRecyclerView.this.getMOnSelectChangedListener();
                if (mOnSelectChangedListener != null) {
                    MediaRecyclerView mediaRecyclerView2 = MediaRecyclerView.this;
                    mOnSelectChangedListener.onSelectChanged(mediaRecyclerView2.getMBeginSelectPosition(), mediaRecyclerView2.getMEndSelectPosition());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/media/view/MediaRecyclerView$d;", "", "", "beginIndex", "", "onSelectBegin", "selectIndex", "onSelectChanged", "onSelectEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface d {
        void onSelectBegin(int beginIndex);

        void onSelectChanged(int beginIndex, int selectIndex);

        void onSelectEnd();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaRecyclerView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void handleMove(float x16, float y16) {
        if (!H().get()) {
            float abs = Math.abs(x16 - this.mLastMotionX);
            if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                H().set(true);
                this.mLastMotionX = x16;
                this.mLastMotionY = y16;
            }
        }
        if (H().get()) {
            if (this.mIsScrolling) {
                handleMoveScrolling(y16);
            } else {
                handleMoveNoScrolling(y16);
            }
        }
        handleScroll((int) x16, (int) y16);
    }

    private final void handleScroll(int x16, int y16) {
        int i3;
        if (H().get()) {
            if (!G().get() && (i3 = this.mBeginSelectPosition) != -1) {
                d dVar = this.mOnSelectChangedListener;
                if (dVar != null) {
                    dVar.onSelectBegin(i3);
                }
                G().set(true);
            }
            View findChildViewUnder = findChildViewUnder(x16, y16);
            handleScrollSelectState(findChildViewUnder != null ? getChildAdapterPosition(findChildViewUnder) : -1);
        }
    }

    private final boolean handleUp() {
        d dVar;
        if (this.mIsScrolling) {
            stopScroll();
            this.mIsScrolling = false;
        }
        boolean z16 = H().get();
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        H().set(false);
        G().set(false);
        if (z16 && (dVar = this.mOnSelectChangedListener) != null) {
            dVar.onSelectEnd();
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r7 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean processEvent(MotionEvent ev5, int action) {
        float x16 = ev5.getX();
        float y16 = ev5.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    float abs = Math.abs(x16 - this.mLastMotionX);
                    if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                        H().set(true);
                        this.mLastMotionX = x16;
                        this.mLastMotionY = y16;
                    }
                }
            }
            boolean z16 = H().get();
            H().set(false);
            this.mBeginSelectPosition = -1;
            this.mEndSelectPosition = -1;
            AtomicBoolean G = G();
            Intrinsics.checkNotNull(G);
            G.set(false);
            if (z16) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
            View findChildViewUnder = findChildViewUnder((int) x16, (int) y16);
            int childAdapterPosition = findChildViewUnder != null ? getChildAdapterPosition(findChildViewUnder) : -1;
            if (childAdapterPosition != -1) {
                this.mEndSelectPosition = childAdapterPosition;
                this.mBeginSelectPosition = childAdapterPosition;
            }
        }
        return false;
    }

    /* renamed from: C, reason: from getter */
    public final int getMBeginSelectPosition() {
        return this.mBeginSelectPosition;
    }

    public final AtomicBoolean D() {
        AtomicBoolean atomicBoolean = this.mEnableSelectMode;
        if (atomicBoolean != null) {
            return atomicBoolean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEnableSelectMode");
        return null;
    }

    /* renamed from: E, reason: from getter */
    public final int getMEndSelectPosition() {
        return this.mEndSelectPosition;
    }

    /* renamed from: F, reason: from getter */
    public final GridLayoutManager getMGridLayoutManager() {
        return this.mGridLayoutManager;
    }

    public final AtomicBoolean G() {
        AtomicBoolean atomicBoolean = this.mIsBegined;
        if (atomicBoolean != null) {
            return atomicBoolean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIsBegined");
        return null;
    }

    public final AtomicBoolean H() {
        AtomicBoolean atomicBoolean = this.mIsBeingInSelectMode;
        if (atomicBoolean != null) {
            return atomicBoolean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIsBeingInSelectMode");
        return null;
    }

    /* renamed from: I, reason: from getter */
    public final boolean getMIsScrolling() {
        return this.mIsScrolling;
    }

    /* renamed from: K, reason: from getter */
    public final boolean getMIsScrollingFromTop() {
        return this.mIsScrollingFromTop;
    }

    /* renamed from: L, reason: from getter */
    public final d getMOnSelectChangedListener() {
        return this.mOnSelectChangedListener;
    }

    public final LinearSmoothScroller M() {
        LinearSmoothScroller linearSmoothScroller = this.mSmoothScroller;
        if (linearSmoothScroller != null) {
            return linearSmoothScroller;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSmoothScroller");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!D().get()) {
            return super.dispatchTouchEvent(ev5);
        }
        int action = ev5.getAction();
        float x16 = ev5.getX();
        float y16 = ev5.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    handleMove(x16, y16);
                }
            }
            if (handleUp()) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
        }
        return H().get() || super.dispatchTouchEvent(ev5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        ViewParent parent;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.disallowParentIntercept && (ev5.getAction() & 255) == 0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (!D().get()) {
            return super.onInterceptTouchEvent(ev5);
        }
        int action = ev5.getAction();
        return (action == 2 && H().get()) || processEvent(ev5, action) || H().get() || super.onInterceptTouchEvent(ev5);
    }

    public final void setDisallowParentIntercept(boolean z16) {
        this.disallowParentIntercept = z16;
    }

    public final void setGridLayoutManager(GridLayoutManager layout) {
        super.setLayoutManager(layout);
        this.mGridLayoutManager = layout;
        D().set(true);
    }

    public final void setMBeginSelectPosition(int i3) {
        this.mBeginSelectPosition = i3;
    }

    public final void setMEnableSelectMode(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.mEnableSelectMode = atomicBoolean;
    }

    public final void setMEndSelectPosition(int i3) {
        this.mEndSelectPosition = i3;
    }

    public final void setMGridLayoutManager(GridLayoutManager gridLayoutManager) {
        this.mGridLayoutManager = gridLayoutManager;
    }

    public final void setMIsBegined(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.mIsBegined = atomicBoolean;
    }

    public final void setMIsBeingInSelectMode(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.mIsBeingInSelectMode = atomicBoolean;
    }

    public final void setMIsScrolling(boolean z16) {
        this.mIsScrolling = z16;
    }

    public final void setMIsScrollingFromTop(boolean z16) {
        this.mIsScrollingFromTop = z16;
    }

    public final void setMLastMotionX(float f16) {
        this.mLastMotionX = f16;
    }

    public final void setMLastMotionY(float f16) {
        this.mLastMotionY = f16;
    }

    public final void setMOnSelectChangedListener(d dVar) {
        this.mOnSelectChangedListener = dVar;
    }

    public final void setMSmoothScroller(LinearSmoothScroller linearSmoothScroller) {
        Intrinsics.checkNotNullParameter(linearSmoothScroller, "<set-?>");
        this.mSmoothScroller = linearSmoothScroller;
    }

    public final void setMTouchSlop(int i3) {
        this.mTouchSlop = i3;
    }

    public final void setOnIndexChangedListener(d l3) {
        this.mOnSelectChangedListener = l3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        setMIsBeingInSelectMode(new AtomicBoolean(false));
        setMIsBegined(new AtomicBoolean(false));
        setMEnableSelectMode(new AtomicBoolean(false));
        this.mIsScrolling = false;
        this.mIsScrollingFromTop = true;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
        addOnScrollListener(new c());
        setMSmoothScroller(new a(context, this));
    }

    private final void handleScrollSelectState(int selectPosition) {
        d dVar;
        if (selectPosition != -1) {
            if (!G().get()) {
                this.mEndSelectPosition = selectPosition;
                this.mBeginSelectPosition = selectPosition;
                d dVar2 = this.mOnSelectChangedListener;
                if (dVar2 != null) {
                    dVar2.onSelectBegin(selectPosition);
                }
                G().set(true);
                return;
            }
            if (this.mEndSelectPosition != selectPosition) {
                this.mEndSelectPosition = selectPosition;
                if (this.mIsScrolling || (dVar = this.mOnSelectChangedListener) == null) {
                    return;
                }
                dVar.onSelectChanged(this.mBeginSelectPosition, selectPosition);
            }
        }
    }

    private final void handleMoveNoScrolling(float y16) {
        if (y16 < 0.0f || y16 > getHeight()) {
            this.mIsScrolling = true;
            if (y16 < 0.0f) {
                this.mIsScrollingFromTop = false;
            } else if (y16 > getHeight()) {
                RecyclerView.Adapter adapter = getAdapter();
                r2 = adapter != null ? adapter.getItemCount() : 0;
                this.mIsScrollingFromTop = true;
            }
            M().setTargetPosition(r2);
            GridLayoutManager gridLayoutManager = this.mGridLayoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.startSmoothScroll(M());
            }
        }
    }

    private final void handleMoveScrolling(float y16) {
        if (y16 <= 0.0f || y16 >= getHeight()) {
            return;
        }
        stopScroll();
        this.mIsScrolling = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
