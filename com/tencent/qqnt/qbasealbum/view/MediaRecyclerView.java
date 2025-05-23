package com.tencent.qqnt.qbasealbum.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\u00020\u0001:\u0003QRSB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R.\u0010 \u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010,R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010)\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00108R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010=\u001a\u0004\b,\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\b:\u0010>\"\u0004\bC\u0010@R\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006T"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/MotionEvent;", "ev", "", "action", "", "processEvent", "handleUp", "", HippyTKDListViewAdapter.X, "y", "", "handleMove", "handleMoveScrolling", "handleMoveNoScrolling", "handleScroll", "selectPosition", "handleScrollSelectState", "Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;", "l", "setOnIndexChangedListener", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "Landroidx/recyclerview/widget/GridLayoutManager;", "value", "f", "Landroidx/recyclerview/widget/GridLayoutManager;", BdhLogUtil.LogTag.Tag_Conn, "()Landroidx/recyclerview/widget/GridLayoutManager;", "setGridLayoutManager", "(Landroidx/recyclerview/widget/GridLayoutManager;)V", "gridLayoutManager", h.F, "Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;", "H", "()Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;", "setMOnSelectChangedListener", "(Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;)V", "mOnSelectChangedListener", "i", "I", "mTouchSlop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "mLastMotionX", "mLastMotionY", "D", "()I", "setMBeginSelectPosition", "(I)V", "mBeginSelectPosition", "E", "setMEndSelectPosition", "mEndSelectPosition", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsBeingInSelectMode", "G", "mHasBegan", "mEnableSelectMode", "Z", "()Z", "setMIsScrolling", "(Z)V", "mIsScrolling", "J", "setMIsScrollingFromTop", "mIsScrollingFromTop", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "K", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "smoothScroller", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "b", "c", "d", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MediaRecyclerView extends RecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float mLastMotionY;

    /* renamed from: D, reason: from kotlin metadata */
    private int mBeginSelectPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private int mEndSelectPosition;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private AtomicBoolean mIsBeingInSelectMode;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private AtomicBoolean mHasBegan;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AtomicBoolean mEnableSelectMode;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsScrolling;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsScrollingFromTop;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LinearSmoothScroller smoothScroller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GridLayoutManager gridLayoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mOnSelectChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mLastMotionX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/qbasealbum/view/MediaRecyclerView$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends LinearSmoothScroller {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaRecyclerView f361688c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, MediaRecyclerView mediaRecyclerView) {
            super(context);
            this.f361688c = mediaRecyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) mediaRecyclerView);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayMetrics)).floatValue();
            }
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 500.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int targetPosition) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PointF) iPatchRedirector.redirect((short) 3, (Object) this, targetPosition);
            }
            if (this.f361688c.C() != null) {
                GridLayoutManager C = this.f361688c.C();
                Intrinsics.checkNotNull(C);
                if (C.getChildCount() != 0) {
                    GridLayoutManager C2 = this.f361688c.C();
                    Intrinsics.checkNotNull(C2);
                    if (C2.getChildAt(0) != null) {
                        GridLayoutManager C3 = this.f361688c.C();
                        Intrinsics.checkNotNull(C3);
                        View childAt = C3.getChildAt(0);
                        Intrinsics.checkNotNull(childAt);
                        Objects.requireNonNull(childAt);
                        GridLayoutManager C4 = this.f361688c.C();
                        Intrinsics.checkNotNull(C4);
                        if (targetPosition < C4.getPosition(childAt)) {
                            i3 = -1;
                        } else {
                            i3 = 1;
                        }
                        return new PointF(0.0f, i3);
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$b;", "", "", "DEFAULT_SCROLL_SPEED", UserInfo.SEX_FEMALE, "", "DEFAULT_TOUCH_SLOP", "I", "HORIZONTAL_SLIDE_RATIO", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.view.MediaRecyclerView$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$c;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "<init>", "(Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MediaRecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, newState);
            } else {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            int findFirstCompletelyVisibleItemPosition;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (!MediaRecyclerView.this.F()) {
                return;
            }
            MediaRecyclerView mediaRecyclerView = MediaRecyclerView.this;
            if (mediaRecyclerView.G()) {
                GridLayoutManager C = MediaRecyclerView.this.C();
                Intrinsics.checkNotNull(C);
                findFirstCompletelyVisibleItemPosition = C.findLastVisibleItemPosition();
            } else {
                GridLayoutManager C2 = MediaRecyclerView.this.C();
                Intrinsics.checkNotNull(C2);
                findFirstCompletelyVisibleItemPosition = C2.findFirstCompletelyVisibleItemPosition();
            }
            mediaRecyclerView.setMEndSelectPosition(findFirstCompletelyVisibleItemPosition);
            d H = MediaRecyclerView.this.H();
            Intrinsics.checkNotNull(H);
            H.onSelectChanged(MediaRecyclerView.this.D(), MediaRecyclerView.this.E());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/MediaRecyclerView$d;", "", "", "beginIndex", "", "onSelectBegin", "selectIndex", "onSelectChanged", "onSelectEnd", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface d {
        void onSelectBegin(int beginIndex);

        void onSelectChanged(int beginIndex, int selectIndex);

        void onSelectEnd();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45348);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
    }

    private final void handleMove(float x16, float y16) {
        AtomicBoolean atomicBoolean = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean);
        if (!atomicBoolean.get()) {
            float abs = Math.abs(x16 - this.mLastMotionX);
            if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                AtomicBoolean atomicBoolean2 = this.mIsBeingInSelectMode;
                Intrinsics.checkNotNull(atomicBoolean2);
                atomicBoolean2.set(true);
                this.mLastMotionX = x16;
                this.mLastMotionY = y16;
            }
        }
        AtomicBoolean atomicBoolean3 = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean3);
        if (atomicBoolean3.get()) {
            if (this.mIsScrolling) {
                handleMoveScrolling(y16);
            } else {
                handleMoveNoScrolling(y16);
            }
        }
        handleScroll((int) x16, (int) y16);
    }

    private final void handleMoveNoScrolling(float y16) {
        if (y16 >= 0.0f && y16 <= getHeight()) {
            return;
        }
        this.mIsScrolling = true;
        int i3 = 0;
        if (y16 < 0.0f) {
            this.mIsScrollingFromTop = false;
        } else if (y16 > getHeight()) {
            RecyclerView.Adapter adapter = getAdapter();
            Objects.requireNonNull(adapter);
            i3 = adapter.getItemCount();
            this.mIsScrollingFromTop = true;
        }
        LinearSmoothScroller linearSmoothScroller = this.smoothScroller;
        Intrinsics.checkNotNull(linearSmoothScroller);
        linearSmoothScroller.setTargetPosition(i3);
        GridLayoutManager gridLayoutManager = this.gridLayoutManager;
        Intrinsics.checkNotNull(gridLayoutManager);
        gridLayoutManager.startSmoothScroll(this.smoothScroller);
    }

    private final void handleMoveScrolling(float y16) {
        if (y16 > 0.0f && y16 < getHeight()) {
            stopScroll();
            this.mIsScrolling = false;
        }
    }

    private final void handleScroll(int x16, int y16) {
        AtomicBoolean atomicBoolean = this.mIsBeingInSelectMode;
        boolean z16 = false;
        if (atomicBoolean != null && !atomicBoolean.get()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AtomicBoolean atomicBoolean2 = this.mHasBegan;
        Intrinsics.checkNotNull(atomicBoolean2);
        int i3 = -1;
        if (!atomicBoolean2.get() && this.mBeginSelectPosition != -1) {
            d dVar = this.mOnSelectChangedListener;
            if (dVar != null) {
                Intrinsics.checkNotNull(dVar);
                dVar.onSelectBegin(this.mBeginSelectPosition);
            }
            AtomicBoolean atomicBoolean3 = this.mHasBegan;
            Intrinsics.checkNotNull(atomicBoolean3);
            atomicBoolean3.set(true);
        }
        View findChildViewUnder = findChildViewUnder(x16, y16);
        if (findChildViewUnder != null) {
            i3 = getChildAdapterPosition(findChildViewUnder);
        }
        handleScrollSelectState(i3);
    }

    private final void handleScrollSelectState(int selectPosition) {
        d dVar;
        if (selectPosition == -1) {
            return;
        }
        AtomicBoolean atomicBoolean = this.mHasBegan;
        Intrinsics.checkNotNull(atomicBoolean);
        if (!atomicBoolean.get()) {
            this.mEndSelectPosition = selectPosition;
            this.mBeginSelectPosition = selectPosition;
            d dVar2 = this.mOnSelectChangedListener;
            if (dVar2 != null) {
                Intrinsics.checkNotNull(dVar2);
                dVar2.onSelectBegin(this.mBeginSelectPosition);
            }
            AtomicBoolean atomicBoolean2 = this.mHasBegan;
            Intrinsics.checkNotNull(atomicBoolean2);
            atomicBoolean2.set(true);
            return;
        }
        if (this.mEndSelectPosition != selectPosition) {
            this.mEndSelectPosition = selectPosition;
            if (!this.mIsScrolling && (dVar = this.mOnSelectChangedListener) != null) {
                Intrinsics.checkNotNull(dVar);
                dVar.onSelectChanged(this.mBeginSelectPosition, this.mEndSelectPosition);
            }
        }
    }

    private final boolean handleUp() {
        d dVar;
        if (this.mIsScrolling) {
            stopScroll();
            this.mIsScrolling = false;
        }
        AtomicBoolean atomicBoolean = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean);
        boolean z16 = atomicBoolean.get();
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        AtomicBoolean atomicBoolean2 = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean2);
        atomicBoolean2.set(false);
        AtomicBoolean atomicBoolean3 = this.mHasBegan;
        Intrinsics.checkNotNull(atomicBoolean3);
        atomicBoolean3.set(false);
        if (z16 && (dVar = this.mOnSelectChangedListener) != null) {
            Intrinsics.checkNotNull(dVar);
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
        int i3;
        float x16 = ev5.getX();
        float y16 = ev5.getY();
        int i16 = action & 255;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    float abs = Math.abs(x16 - this.mLastMotionX);
                    if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                        AtomicBoolean atomicBoolean = this.mIsBeingInSelectMode;
                        Intrinsics.checkNotNull(atomicBoolean);
                        atomicBoolean.set(true);
                        this.mLastMotionX = x16;
                        this.mLastMotionY = y16;
                    }
                }
            }
            AtomicBoolean atomicBoolean2 = this.mIsBeingInSelectMode;
            Intrinsics.checkNotNull(atomicBoolean2);
            boolean z16 = atomicBoolean2.get();
            AtomicBoolean atomicBoolean3 = this.mIsBeingInSelectMode;
            Intrinsics.checkNotNull(atomicBoolean3);
            atomicBoolean3.set(false);
            this.mBeginSelectPosition = -1;
            this.mEndSelectPosition = -1;
            AtomicBoolean atomicBoolean4 = this.mHasBegan;
            Intrinsics.checkNotNull(atomicBoolean4);
            atomicBoolean4.set(false);
            if (z16) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
            View findChildViewUnder = findChildViewUnder((int) x16, (int) y16);
            if (findChildViewUnder != null) {
                i3 = getChildAdapterPosition(findChildViewUnder);
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                this.mEndSelectPosition = i3;
                this.mBeginSelectPosition = i3;
            }
        }
        return false;
    }

    @Nullable
    public final GridLayoutManager C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GridLayoutManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.gridLayoutManager;
    }

    public final int D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mBeginSelectPosition;
    }

    public final int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mEndSelectPosition;
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mIsScrolling;
    }

    public final boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mIsScrollingFromTop;
    }

    @Nullable
    public final d H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mOnSelectChangedListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        AtomicBoolean atomicBoolean = this.mEnableSelectMode;
        Intrinsics.checkNotNull(atomicBoolean);
        if (!atomicBoolean.get()) {
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
            handleUp();
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
        }
        AtomicBoolean atomicBoolean2 = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean2);
        if (atomicBoolean2.get() || super.dispatchTouchEvent(ev5)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        AtomicBoolean atomicBoolean = this.mEnableSelectMode;
        Intrinsics.checkNotNull(atomicBoolean);
        if (!atomicBoolean.get()) {
            return super.onInterceptTouchEvent(ev5);
        }
        if (ev5.getAction() == 2) {
            AtomicBoolean atomicBoolean2 = this.mIsBeingInSelectMode;
            Intrinsics.checkNotNull(atomicBoolean2);
            if (atomicBoolean2.get()) {
                return true;
            }
        }
        if (processEvent(ev5, ev5.getAction())) {
            return true;
        }
        AtomicBoolean atomicBoolean3 = this.mIsBeingInSelectMode;
        Intrinsics.checkNotNull(atomicBoolean3);
        if (atomicBoolean3.get() || super.onInterceptTouchEvent(ev5)) {
            return true;
        }
        return false;
    }

    public final void setGridLayoutManager(@Nullable GridLayoutManager gridLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gridLayoutManager);
            return;
        }
        super.setLayoutManager(gridLayoutManager);
        this.gridLayoutManager = gridLayoutManager;
        AtomicBoolean atomicBoolean = this.mEnableSelectMode;
        Intrinsics.checkNotNull(atomicBoolean);
        atomicBoolean.set(true);
    }

    public final void setMBeginSelectPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mBeginSelectPosition = i3;
        }
    }

    public final void setMEndSelectPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mEndSelectPosition = i3;
        }
    }

    public final void setMIsScrolling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mIsScrolling = z16;
        }
    }

    public final void setMIsScrollingFromTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mIsScrollingFromTop = z16;
        }
    }

    public final void setMOnSelectChangedListener(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
        } else {
            this.mOnSelectChangedListener = dVar;
        }
    }

    public final void setOnIndexChangedListener(@Nullable d l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) l3);
        } else {
            this.mOnSelectChangedListener = l3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ MediaRecyclerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        this.mIsBeingInSelectMode = new AtomicBoolean(false);
        this.mHasBegan = new AtomicBoolean(false);
        this.mEnableSelectMode = new AtomicBoolean(false);
        this.mIsScrolling = false;
        this.mIsScrollingFromTop = true;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
        addOnScrollListener(new c());
        this.smoothScroller = new a(context, this);
    }
}
