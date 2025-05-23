package com.tencent.biz.pubaccount.weishi.combo.home.rightpager;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalVideoRelativeLayout;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/home/rightpager/WSComboVerticalVideoProgressManager;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSPlayerControlBar;", "progressBar", "", "g", "d", "f", "", "e", h.F, "c", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalVideoRelativeLayout;", "a", "Ljava/lang/ref/WeakReference;", "mComboBottomProgressContainerRef", "mProgressBarRef", "Landroid/view/ViewGroup;", "mVideoPageProgressParentViewRef", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSComboVerticalVideoProgressManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<WSComboVerticalVideoProgressManager> f80477e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<WSVerticalVideoRelativeLayout> mComboBottomProgressContainerRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<WSPlayerControlBar> mProgressBarRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<ViewGroup> mVideoPageProgressParentViewRef;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/home/rightpager/WSComboVerticalVideoProgressManager$a;", "", "Lcom/tencent/biz/pubaccount/weishi/combo/home/rightpager/WSComboVerticalVideoProgressManager;", "Instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/biz/pubaccount/weishi/combo/home/rightpager/WSComboVerticalVideoProgressManager;", "Instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WSComboVerticalVideoProgressManager a() {
            return (WSComboVerticalVideoProgressManager) WSComboVerticalVideoProgressManager.f80477e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<WSComboVerticalVideoProgressManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WSComboVerticalVideoProgressManager>() { // from class: com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager$Companion$Instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WSComboVerticalVideoProgressManager invoke() {
                return new WSComboVerticalVideoProgressManager();
            }
        });
        f80477e = lazy;
    }

    private final void d(WSPlayerControlBar progressBar) {
        WSVerticalVideoRelativeLayout wSVerticalVideoRelativeLayout;
        if (progressBar.getParent() != null) {
            return;
        }
        WeakReference<WSPlayerControlBar> weakReference = new WeakReference<>(progressBar);
        this.mProgressBarRef = weakReference;
        x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][replaceCurrProgress] mProgressBar: " + weakReference + ", mParent: " + this.mVideoPageProgressParentViewRef);
        WeakReference<WSVerticalVideoRelativeLayout> weakReference2 = this.mComboBottomProgressContainerRef;
        if (weakReference2 == null || (wSVerticalVideoRelativeLayout = weakReference2.get()) == null) {
            return;
        }
        wSVerticalVideoRelativeLayout.addView(progressBar);
    }

    private final void f() {
        WeakReference<WSPlayerControlBar> weakReference;
        WSPlayerControlBar wSPlayerControlBar;
        WeakReference<WSVerticalVideoRelativeLayout> weakReference2 = this.mComboBottomProgressContainerRef;
        WSVerticalVideoRelativeLayout wSVerticalVideoRelativeLayout = weakReference2 != null ? weakReference2.get() : null;
        int childCount = wSVerticalVideoRelativeLayout != null ? wSVerticalVideoRelativeLayout.getChildCount() : 0;
        x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][recoverLastProgress] mVerticalVideoContentContainer.childCount: " + childCount);
        if (childCount <= 0 || (weakReference = this.mProgressBarRef) == null || (wSPlayerControlBar = weakReference.get()) == null) {
            return;
        }
        if (wSVerticalVideoRelativeLayout != null) {
            wSVerticalVideoRelativeLayout.removeView(wSPlayerControlBar);
        }
        WeakReference<ViewGroup> weakReference3 = this.mVideoPageProgressParentViewRef;
        ViewGroup viewGroup = weakReference3 != null ? weakReference3.get() : null;
        if (viewGroup != null) {
            int childCount2 = viewGroup.getChildCount();
            x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][recoverLastProgress] mParent.childCount: " + childCount2);
            if (childCount2 > 0) {
                return;
            }
            viewGroup.addView(wSPlayerControlBar);
        }
    }

    private final void g(WSPlayerControlBar progressBar) {
        if (progressBar.getParent() instanceof FrameLayout) {
            ViewParent parent = progressBar.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) parent;
            frameLayout.removeView(progressBar);
            this.mVideoPageProgressParentViewRef = new WeakReference<>(frameLayout);
        }
    }

    public final void b() {
        WSPlayerControlBar wSPlayerControlBar;
        x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][replaceProgressBar]");
        WeakReference<WSPlayerControlBar> weakReference = this.mProgressBarRef;
        if (weakReference == null || (wSPlayerControlBar = weakReference.get()) == null) {
            return;
        }
        c(wSPlayerControlBar);
    }

    public final void c(WSPlayerControlBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][replaceProgressBar]");
        g(progressBar);
        d(progressBar);
    }

    public final boolean e() {
        return false;
    }

    public final void h() {
        x.i("WSComboVerticalVideoProgressManager", "[WSComboVerticalVideoProgressManager][removeProgress]");
        f();
    }
}
