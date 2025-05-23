package com.tencent.mobileqq.guild.media.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.media.GuildMediaChannelFragment;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.GuildMediaRoomMsgGuideController;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.widget.DragLinearLayout;
import com.tencent.mobileqq.guild.media.widget.GuildNestedScrollView;
import com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u001b\u0010;\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020.0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020.0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaLayoutPresenter;", "", "Lcom/tencent/mobileqq/guild/media/widget/GuildSwipeBackLayout;", "swipeBackLayout", "", HippyTKDListViewAdapter.X, "", "y", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "isVisible", "E", "", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelFragment;", "fragment", "u", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView;", "a", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView;", "scrollView", "b", "Lcom/tencent/mobileqq/guild/media/widget/GuildSwipeBackLayout;", "Lcom/tencent/mobileqq/guild/media/widget/DragLinearLayout;", "c", "Lcom/tencent/mobileqq/guild/media/widget/DragLinearLayout;", "mDragLinearLayout", "Landroid/view/View;", "d", "Landroid/view/View;", "thirdAppArea", "Lmqq/util/WeakReference;", "e", "Lmqq/util/WeakReference;", "fragmentRef", "f", "Z", "hasScrollFinishTrigger", "g", "Ljava/lang/Boolean;", "mLastAioVisible", "Le12/e;", "", tl.h.F, "Le12/e;", "mTouchEventLiveData", "i", UserInfo.SEX_FEMALE, "mTouchDownX", "j", "mTouchDownY", "k", "Lkotlin/Lazy;", "t", "()I", "mMoveThreshold", "Le12/a;", "l", "Le12/a;", "mScrollChangeLiveData", "Landroidx/lifecycle/Observer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "mScrollObserver", "<init>", "()V", DomainData.DOMAIN_NAME, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaLayoutPresenter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GuildNestedScrollView scrollView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private GuildSwipeBackLayout swipeBackLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private DragLinearLayout mDragLinearLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View thirdAppArea;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<GuildMediaChannelFragment> fragmentRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasScrollFinishTrigger;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean mLastAioVisible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.e<Integer> mTouchEventLiveData = new e12.e<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mTouchDownX;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mTouchDownY;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMoveThreshold;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.a<Integer> mScrollChangeLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> mScrollObserver;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/GuildMediaLayoutPresenter$b", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView$a;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildNestedScrollView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.widget.GuildNestedScrollView.a
        public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
            if (ev5 == null) {
                return false;
            }
            boolean z16 = true;
            if (GuildMediaLayoutPresenter.this.r(ev5.getX(), ev5.getY()) || ev5.getAction() == 1 || ev5.getAction() == 3) {
                DragLinearLayout dragLinearLayout = GuildMediaLayoutPresenter.this.mDragLinearLayout;
                if (dragLinearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragLinearLayout");
                    dragLinearLayout = null;
                }
                dragLinearLayout.b(ev5);
            }
            int action = ev5.getAction();
            if (action != 0) {
                if (action == 2 && Math.abs(ev5.getX() - GuildMediaLayoutPresenter.this.mTouchDownX) < GuildMediaLayoutPresenter.this.t() && Math.abs(ev5.getY() - GuildMediaLayoutPresenter.this.mTouchDownY) < GuildMediaLayoutPresenter.this.t()) {
                    z16 = false;
                }
            } else {
                GuildMediaLayoutPresenter.this.mTouchDownX = ev5.getX();
                GuildMediaLayoutPresenter.this.mTouchDownY = ev5.getY();
            }
            if (z16) {
                GuildMediaLayoutPresenter.this.mTouchEventLiveData.setValue(Integer.valueOf(ev5.getAction() & 255));
            }
            if (ev5.getAction() == 0) {
                return GuildMediaLayoutPresenter.this.D();
            }
            return false;
        }
    }

    public GuildMediaLayoutPresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter$mMoveThreshold$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                GuildNestedScrollView guildNestedScrollView;
                guildNestedScrollView = GuildMediaLayoutPresenter.this.scrollView;
                if (guildNestedScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                    guildNestedScrollView = null;
                }
                return Integer.valueOf(ViewConfiguration.get(guildNestedScrollView.getContext()).getScaledTouchSlop());
            }
        });
        this.mMoveThreshold = lazy;
        this.mScrollChangeLiveData = new e12.a<>();
        this.mScrollObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.presenter.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaLayoutPresenter.B(GuildMediaLayoutPresenter.this, (Integer) obj);
            }
        };
    }

    private final boolean A() {
        boolean z16;
        com.tencent.mobileqq.guild.media.content.i mContentView;
        GuildNestedScrollView guildNestedScrollView = this.scrollView;
        WeakReference<GuildMediaChannelFragment> weakReference = null;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        if (guildNestedScrollView.getChildCount() <= 0) {
            return false;
        }
        GuildNestedScrollView guildNestedScrollView2 = this.scrollView;
        if (guildNestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView2 = null;
        }
        boolean canScrollVertically = guildNestedScrollView2.canScrollVertically(-1);
        GuildNestedScrollView guildNestedScrollView3 = this.scrollView;
        if (guildNestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView3 = null;
        }
        boolean canScrollVertically2 = guildNestedScrollView3.canScrollVertically(1);
        WeakReference<GuildMediaChannelFragment> weakReference2 = this.fragmentRef;
        if (weakReference2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
        } else {
            weakReference = weakReference2;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment != null && (mContentView = guildMediaChannelFragment.getMContentView()) != null) {
            z16 = mContentView.kd();
        } else {
            z16 = false;
        }
        if (!canScrollVertically && !canScrollVertically2 && !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildMediaLayoutPresenter this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer value = this$0.mTouchEventLiveData.getValue();
        if (value != null && value.intValue() == 0) {
            this$0.mLastAioVisible = Boolean.valueOf(this$0.z());
            return;
        }
        boolean z16 = false;
        if (value != null && value.intValue() == 2) {
            this$0.E(false);
            return;
        }
        if ((value != null && value.intValue() == 1) || (value != null && value.intValue() == 3)) {
            z16 = true;
        }
        if (z16) {
            this$0.E(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        FragmentActivity fragmentActivity;
        GuildMediaAioViewModel guildMediaAioViewModel;
        boolean z16;
        GuildNestedScrollView guildNestedScrollView = this.scrollView;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        Context context = guildNestedScrollView.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            guildMediaAioViewModel = GuildMediaAioViewModel.INSTANCE.a(fragmentActivity);
        } else {
            guildMediaAioViewModel = null;
        }
        if (guildMediaAioViewModel != null && guildMediaAioViewModel.g2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        guildMediaAioViewModel.l2(new b.h(false, 1, null));
        return true;
    }

    private final void E(boolean isVisible) {
        if (Intrinsics.areEqual(this.mLastAioVisible, Boolean.TRUE)) {
            if (QLog.isColorLevel()) {
                QLog.i("QGMC.GuildMediaScrollViewPresenter", 2, "[updateAioVisibility] " + isVisible);
            }
            GuildNestedScrollView guildNestedScrollView = this.scrollView;
            FragmentActivity fragmentActivity = null;
            if (guildNestedScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                guildNestedScrollView = null;
            }
            Context context = guildNestedScrollView.getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            if (fragmentActivity != null) {
                GuildMediaAioViewModel.INSTANCE.a(fragmentActivity).l2(new b.k(isVisible));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(float x16, float y16) {
        boolean z16;
        com.tencent.mobileqq.guild.media.content.i mContentView;
        if (A()) {
            return false;
        }
        WeakReference<GuildMediaChannelFragment> weakReference = this.fragmentRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment != null && (mContentView = guildMediaChannelFragment.getMContentView()) != null) {
            z16 = mContentView.J2();
        } else {
            z16 = false;
        }
        if (z16 || s(x16, y16)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(float x16, float y16) {
        boolean z16;
        boolean z17;
        boolean z18;
        View rootView;
        WeakReference<GuildMediaChannelFragment> weakReference = this.fragmentRef;
        View view = null;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
            weakReference = null;
        }
        if (weakReference.get() == null) {
            Logger.f235387a.d().i("QGMC.GuildMediaScrollViewPresenter", 1, "checkInThirdAppArea: x[" + x16 + "] y[" + y16 + "] fragment is null return");
            return false;
        }
        if (this.thirdAppArea == null) {
            WeakReference<GuildMediaChannelFragment> weakReference2 = this.fragmentRef;
            if (weakReference2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                weakReference2 = null;
            }
            GuildMediaChannelFragment guildMediaChannelFragment = weakReference2.get();
            if (guildMediaChannelFragment != null && (rootView = guildMediaChannelFragment.getRootView()) != null) {
                view = rootView.findViewById(R.id.f96635i8);
            }
            this.thirdAppArea = view;
        }
        View view2 = this.thirdAppArea;
        if (view2 != null && view2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        Rect rect = new Rect();
        View view3 = this.thirdAppArea;
        Intrinsics.checkNotNull(view3);
        view3.getGlobalVisibleRect(rect);
        Logger.f235387a.d().i("QGMC.GuildMediaScrollViewPresenter", 1, "checkInThirdAppArea: x[" + x16 + "] y[" + y16 + "] rect[" + rect + "]");
        if (x16 > rect.left && x16 < rect.right) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (y16 > rect.top && y16 < rect.bottom) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 && z18) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        return ((Number) this.mMoveThreshold.getValue()).intValue();
    }

    private final void v() {
        GuildNestedScrollView guildNestedScrollView = this.scrollView;
        GuildNestedScrollView guildNestedScrollView2 = null;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        guildNestedScrollView.setDispatchTouchListener(new b());
        GuildNestedScrollView guildNestedScrollView3 = this.scrollView;
        if (guildNestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            guildNestedScrollView2 = guildNestedScrollView3;
        }
        guildNestedScrollView2.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.tencent.mobileqq.guild.media.presenter.a
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18) {
                GuildMediaLayoutPresenter.w(GuildMediaLayoutPresenter.this, nestedScrollView, i3, i16, i17, i18);
            }
        });
        this.mTouchEventLiveData.observeForever(this.mScrollObserver);
        this.mScrollChangeLiveData.observeForever(this.mScrollObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GuildMediaLayoutPresenter this$0, NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer value = this$0.mScrollChangeLiveData.getValue();
        if (value == null) {
            value = 0;
        }
        this$0.mScrollChangeLiveData.setValue(Integer.valueOf(value.intValue() + 1));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void x(final GuildSwipeBackLayout swipeBackLayout) {
        swipeBackLayout.setOnStartSwipeEvent(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter$initSwipeBackLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                IGuildMainFrameApi ji5;
                QLog.i("QGMC.GuildMediaScrollViewPresenter", 1, "[initSwipeBackLayout] onStartSwipeEvent.");
                weakReference = GuildMediaLayoutPresenter.this.fragmentRef;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    weakReference = null;
                }
                GuildMediaChannelFragment guildMediaChannelFragment = (GuildMediaChannelFragment) weakReference.get();
                if (guildMediaChannelFragment != null && (ji5 = guildMediaChannelFragment.ji()) != null) {
                    ji5.notifyGuildFrameVisibleChanged("media channel, swipe start.", true);
                }
                swipeBackLayout.setBackground(UIUtil.f112434a.x().getDrawable(R.drawable.guild_media_swipe_border_bg, null));
            }
        });
        swipeBackLayout.setOnSwipeAioAreaFromRightToLeftEvent(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter$initSwipeBackLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                GuildMediaAioViewModel fi5;
                QLog.i("QGMC.GuildMediaScrollViewPresenter", 1, "[initSwipeBackLayout] onSwipeAioAreaFromRightToLeftEvent.");
                weakReference = GuildMediaLayoutPresenter.this.fragmentRef;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    weakReference = null;
                }
                GuildMediaChannelFragment guildMediaChannelFragment = (GuildMediaChannelFragment) weakReference.get();
                if (guildMediaChannelFragment == null || (fi5 = guildMediaChannelFragment.fi()) == null) {
                    return;
                }
                fi5.l2(b.m.f227879a);
            }
        });
        swipeBackLayout.setOnScrollFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter$initSwipeBackLayout$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16) {
                boolean z17;
                WeakReference weakReference;
                WeakReference weakReference2;
                GuildMediaChannelFragment guildMediaChannelFragment;
                boolean y16;
                WeakReference weakReference3;
                IGuildMainFrameApi ji5;
                boolean z18;
                WeakReference weakReference4;
                z17 = GuildMediaLayoutPresenter.this.hasScrollFinishTrigger;
                QLog.i("QGMC.GuildMediaScrollViewPresenter", 1, "[initSwipeBackLayout] onScrollFinish: " + z16 + " " + z17);
                WeakReference weakReference5 = null;
                if (!z16) {
                    z18 = GuildMediaLayoutPresenter.this.hasScrollFinishTrigger;
                    if (!z18) {
                        weakReference4 = GuildMediaLayoutPresenter.this.fragmentRef;
                        if (weakReference4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                            weakReference4 = null;
                        }
                        GuildMediaChannelFragment guildMediaChannelFragment2 = (GuildMediaChannelFragment) weakReference4.get();
                        if (guildMediaChannelFragment2 != null) {
                            guildMediaChannelFragment2.Ji();
                        }
                        GuildMediaLayoutPresenter.this.hasScrollFinishTrigger = true;
                        if (z16) {
                            y16 = GuildMediaLayoutPresenter.this.y();
                            if (!y16) {
                                weakReference3 = GuildMediaLayoutPresenter.this.fragmentRef;
                                if (weakReference3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                                    weakReference3 = null;
                                }
                                GuildMediaChannelFragment guildMediaChannelFragment3 = (GuildMediaChannelFragment) weakReference3.get();
                                if (guildMediaChannelFragment3 != null && (ji5 = guildMediaChannelFragment3.ji()) != null) {
                                    ji5.notifyGuildFrameVisibleChanged("media channel, swipe cancel.", false);
                                }
                            }
                        }
                        weakReference2 = GuildMediaLayoutPresenter.this.fragmentRef;
                        if (weakReference2 != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                        } else {
                            weakReference5 = weakReference2;
                        }
                        guildMediaChannelFragment = (GuildMediaChannelFragment) weakReference5.get();
                        if (guildMediaChannelFragment == null && guildMediaChannelFragment.isAdded()) {
                            return;
                        }
                        swipeBackLayout.setBackgroundColor(UIUtil.f112434a.x().getColor(R.color.bsd));
                        return;
                    }
                }
                weakReference = GuildMediaLayoutPresenter.this.fragmentRef;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    weakReference = null;
                }
                GuildMediaChannelFragment guildMediaChannelFragment4 = (GuildMediaChannelFragment) weakReference.get();
                View rootView = guildMediaChannelFragment4 != null ? guildMediaChannelFragment4.getRootView() : null;
                if (rootView != null) {
                    rootView.setAlpha(1.0f);
                }
                if (z16) {
                }
                weakReference2 = GuildMediaLayoutPresenter.this.fragmentRef;
                if (weakReference2 != null) {
                }
                guildMediaChannelFragment = (GuildMediaChannelFragment) weakReference5.get();
                if (guildMediaChannelFragment == null && guildMediaChannelFragment.isAdded()) {
                }
            }
        });
        swipeBackLayout.setBizInterceptScroll(new Function2<Float, Float, Boolean>() { // from class: com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter$initSwipeBackLayout$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @NotNull
            public final Boolean invoke(float f16, float f17) {
                WeakReference weakReference;
                boolean s16;
                WeakReference weakReference2;
                WeakReference weakReference3;
                com.tencent.mobileqq.guild.media.content.i mContentView;
                GuildMediaRoomMsgGuideController mMsgGuideController;
                GuildMediaAioViewModel fi5;
                weakReference = GuildMediaLayoutPresenter.this.fragmentRef;
                WeakReference weakReference4 = null;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    weakReference = null;
                }
                GuildMediaChannelFragment guildMediaChannelFragment = (GuildMediaChannelFragment) weakReference.get();
                boolean z16 = true;
                if (!((guildMediaChannelFragment == null || (fi5 = guildMediaChannelFragment.fi()) == null || !fi5.h2(f16, f17)) ? false : true)) {
                    s16 = GuildMediaLayoutPresenter.this.s(f16, f17);
                    if (!s16) {
                        weakReference2 = GuildMediaLayoutPresenter.this.fragmentRef;
                        if (weakReference2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                            weakReference2 = null;
                        }
                        GuildMediaChannelFragment guildMediaChannelFragment2 = (GuildMediaChannelFragment) weakReference2.get();
                        if (!((guildMediaChannelFragment2 == null || (mMsgGuideController = guildMediaChannelFragment2.getMMsgGuideController()) == null || !mMsgGuideController.k()) ? false : true)) {
                            weakReference3 = GuildMediaLayoutPresenter.this.fragmentRef;
                            if (weakReference3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                            } else {
                                weakReference4 = weakReference3;
                            }
                            GuildMediaChannelFragment guildMediaChannelFragment3 = (GuildMediaChannelFragment) weakReference4.get();
                            if (!((guildMediaChannelFragment3 == null || (mContentView = guildMediaChannelFragment3.getMContentView()) == null || !mContentView.J2()) ? false : true)) {
                                z16 = false;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y() {
        FragmentActivity fragmentActivity;
        boolean z16;
        boolean z17;
        FragmentActivity activity;
        FragmentActivity activity2;
        WeakReference<GuildMediaChannelFragment> weakReference = this.fragmentRef;
        WeakReference<GuildMediaChannelFragment> weakReference2 = null;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
            weakReference = null;
        }
        if (weakReference.get() != null) {
            WeakReference<GuildMediaChannelFragment> weakReference3 = this.fragmentRef;
            if (weakReference3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                weakReference3 = null;
            }
            GuildMediaChannelFragment guildMediaChannelFragment = weakReference3.get();
            if (guildMediaChannelFragment != null) {
                fragmentActivity = guildMediaChannelFragment.getActivity();
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                WeakReference<GuildMediaChannelFragment> weakReference4 = this.fragmentRef;
                if (weakReference4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    weakReference4 = null;
                }
                GuildMediaChannelFragment guildMediaChannelFragment2 = weakReference4.get();
                if (guildMediaChannelFragment2 != null && (activity2 = guildMediaChannelFragment2.getActivity()) != null && activity2.isDestroyed()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    WeakReference<GuildMediaChannelFragment> weakReference5 = this.fragmentRef;
                    if (weakReference5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fragmentRef");
                    } else {
                        weakReference2 = weakReference5;
                    }
                    GuildMediaChannelFragment guildMediaChannelFragment3 = weakReference2.get();
                    if (guildMediaChannelFragment3 != null && (activity = guildMediaChannelFragment3.getActivity()) != null && activity.isFinishing()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final boolean z() {
        GuildNestedScrollView guildNestedScrollView = this.scrollView;
        FragmentActivity fragmentActivity = null;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        Context context = guildNestedScrollView.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        if (fragmentActivity != null) {
            return GuildMediaAioViewModel.INSTANCE.a(fragmentActivity).L1();
        }
        return true;
    }

    public final void C() {
        this.mTouchEventLiveData.removeObserver(this.mScrollObserver);
        this.mScrollChangeLiveData.removeObserver(this.mScrollObserver);
    }

    public final void u(@NotNull GuildMediaChannelFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentRef = new WeakReference<>(fragment);
        View findViewById = fragment.getRootView().findViewById(R.id.yzs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "fragment.getRootView().f\u2026channel_root_scroll_view)");
        this.scrollView = (GuildNestedScrollView) findViewById;
        View findViewById2 = fragment.getRootView().findViewById(R.id.wpt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "fragment.getRootView().f\u2026d_media_channel_fragment)");
        this.swipeBackLayout = (GuildSwipeBackLayout) findViewById2;
        View findViewById3 = fragment.getRootView().findViewById(R.id.ulf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "fragment.getRootView().f\u2026d(R.id.drag_frame_layout)");
        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById3;
        this.mDragLinearLayout = dragLinearLayout;
        GuildSwipeBackLayout guildSwipeBackLayout = null;
        if (dragLinearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLinearLayout");
            dragLinearLayout = null;
        }
        dragLinearLayout.a();
        v();
        GuildSwipeBackLayout guildSwipeBackLayout2 = this.swipeBackLayout;
        if (guildSwipeBackLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
        } else {
            guildSwipeBackLayout = guildSwipeBackLayout2;
        }
        x(guildSwipeBackLayout);
    }
}
