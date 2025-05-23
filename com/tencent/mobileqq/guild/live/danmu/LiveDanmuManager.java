package com.tencent.mobileqq.guild.live.danmu;

import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.inject.b;
import com.tencent.common.danmaku.inject.l;
import com.tencent.common.danmaku.inject.m;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.danmu.LiveDanmuManager;
import com.tencent.mobileqq.guild.live.danmu.item.GLiveDanmuPriority;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.profile.me.aa;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import iq1.DanmakuDataBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0013\u001a\u00020\u0003H\u0007J\b\u0010\u0014\u001a\u00020\u0003H\u0007J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/LiveDanmuManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/guild/live/danmu/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "i", "Lcom/tencent/common/danmaku/inject/b;", "k", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "g", "Landroid/view/View;", h.F, "Landroidx/fragment/app/Fragment;", "fragment", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onResume", "", "type", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "c", "d", "Landroid/view/View;", "danmukuView", "Lcom/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender;", "e", "Lcom/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender;", "danmuRender", "Lcom/tencent/mobileqq/guild/live/danmu/b;", "f", "Lcom/tencent/mobileqq/guild/live/danmu/b;", "danmuCreator", "Lcom/tencent/common/danmaku/inject/b;", "danmukuContext", "Lcom/tencent/common/danmaku/core/DanmakuManager;", "danmukuManager", "", "J", "startTime", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasCreate", "<init>", "()V", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveDanmuManager implements LifecycleObserver, a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasCreate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View danmukuView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LiveDanmakuRender danmuRender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.live.danmu.b danmuCreator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.common.danmaku.inject.b danmukuContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private DanmakuManager danmukuManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/LiveDanmuManager$b", "Lcom/tencent/common/danmaku/inject/l$a;", "", "p0", "p1", "", "v", "d", "i", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements l.a {
        b() {
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void d(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            QLog.d(p06, 4, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void e(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            QLog.d(p06, 1, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void i(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            QLog.d(p06, 4, p16);
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void v(@NotNull String p06, @NotNull String p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            QLog.d(p06, 4, p16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveDanmuManager this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.danmukuView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            view = null;
        }
        if (view.getAlpha() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            View view3 = this$0.danmukuView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            } else {
                view2 = view3;
            }
            view2.setAlpha(1.0f);
        }
    }

    private final DanmakuManager g() {
        com.tencent.mobileqq.danmaku.a.a();
        View view = this.danmukuView;
        com.tencent.common.danmaku.inject.b bVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            view = null;
        }
        com.tencent.common.danmaku.inject.b bVar2 = this.danmukuContext;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuContext");
        } else {
            bVar = bVar2;
        }
        return new DanmakuManager(view, bVar);
    }

    private final View h() {
        TextureView textureView = new TextureView(BaseApplication.getContext());
        textureView.setAlpha(0.0f);
        return textureView;
    }

    private final void i(FrameLayout container) {
        container.removeAllViews();
        View view = this.danmukuView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            view = null;
        }
        aa.a(view);
        View view3 = this.danmukuView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            view3 = null;
        }
        view3.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        View view4 = this.danmukuView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
        } else {
            view2 = view4;
        }
        container.addView(view2, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(LiveDanmuManager this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.common.danmaku.inject.b.p().C(x.f(BaseApplication.getContext()).b());
        if (num != null && num.intValue() == 2) {
            com.tencent.common.danmaku.inject.b.p().v(8000);
        } else {
            com.tencent.common.danmaku.inject.b.p().v(5000);
        }
        DanmakuManager danmakuManager = this$0.danmukuManager;
        if (danmakuManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
            danmakuManager = null;
        }
        danmakuManager.k0();
    }

    private final com.tencent.common.danmaku.inject.b k() {
        b.a o16 = com.tencent.common.danmaku.inject.b.s().q(5).o(false);
        com.tencent.mobileqq.guild.live.danmu.b bVar = this.danmuCreator;
        LiveDanmakuRender liveDanmakuRender = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmuCreator");
            bVar = null;
        }
        b.a n3 = o16.n(bVar);
        LiveDanmakuRender liveDanmakuRender2 = this.danmuRender;
        if (liveDanmakuRender2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmuRender");
        } else {
            liveDanmakuRender = liveDanmakuRender2;
        }
        com.tencent.common.danmaku.inject.b m3 = n3.l(liveDanmakuRender).p(true).m();
        Intrinsics.checkNotNullExpressionValue(m3, "newBuilder()\n           \u2026rue)\n            .build()");
        return m3;
    }

    private final void l() {
        com.tencent.common.danmaku.util.e.f(new b());
        m p16 = com.tencent.common.danmaku.inject.b.p();
        p16.B(3);
        p16.D(14.0f);
        p16.v(5000);
        p16.s(0.0f);
        p16.t(0.0f);
        p16.F(10);
        p16.y(2.0f);
        p16.x(7);
        p16.r(true);
        p16.E(true);
        p16.z(0.0f);
        p16.A(0.0f);
    }

    private final void m() {
        this.startTime = System.currentTimeMillis();
        DanmakuManager danmakuManager = this.danmukuManager;
        DanmakuManager danmakuManager2 = null;
        if (danmakuManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
            danmakuManager = null;
        }
        danmakuManager.C0();
        DanmakuManager danmakuManager3 = this.danmukuManager;
        if (danmakuManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
        } else {
            danmakuManager2 = danmakuManager3;
        }
        danmakuManager2.A0(new c());
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.a
    public void a(int type, @NotNull com.tencent.mobileqq.guild.live.danmu.item.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        DanmakuManager danmakuManager = this.danmukuManager;
        View view = null;
        if (danmakuManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
            danmakuManager = null;
        }
        com.tencent.common.danmaku.data.a C = danmakuManager.C(item.b(), new DanmakuDataBean(item, item.i()));
        C.v0(System.currentTimeMillis() - this.startTime);
        boolean z16 = true;
        if (item.getPriority() == GLiveDanmuPriority.HIGH) {
            C.r0(true);
            DanmakuManager danmakuManager2 = this.danmukuManager;
            if (danmakuManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
                danmakuManager2 = null;
            }
            danmakuManager2.v(C);
        } else {
            DanmakuManager danmakuManager3 = this.danmukuManager;
            if (danmakuManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
                danmakuManager3 = null;
            }
            danmakuManager3.w(C);
        }
        View view2 = this.danmukuView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            view2 = null;
        }
        if (view2.getAlpha() != 0.0f) {
            z16 = false;
        }
        if (z16) {
            View view3 = this.danmukuView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
            } else {
                view = view3;
            }
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.danmu.d
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDanmuManager.f(LiveDanmuManager.this);
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.a
    public void b(@NotNull Fragment fragment, @NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.hasCreate) {
            QLog.d("QGL.LiveDanmuManager", 1, "initDanmuManger hasCreate");
            return;
        }
        this.danmukuView = h();
        this.danmuRender = new LiveDanmakuRender();
        this.danmuCreator = new com.tencent.mobileqq.guild.live.danmu.b();
        this.danmukuContext = k();
        this.danmukuManager = g();
        this.startTime = 0L;
        l.c(true);
        l();
        fragment.getLifecycle().addObserver(this);
        m();
        i(container);
        DanmakuManager danmakuManager = this.danmukuManager;
        if (danmakuManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
            danmakuManager = null;
        }
        danmakuManager.u0();
        GLiveChannelCore.f226698a.t().l().observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.live.danmu.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveDanmuManager.j(LiveDanmuManager.this, (Integer) obj);
            }
        });
        this.hasCreate = true;
        QLog.d("QGL.LiveDanmuManager", 1, "initDanmuManger");
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.a
    public void c() {
        ViewGroup viewGroup;
        if (this.hasCreate) {
            QLog.d("QGL.LiveDanmuManager", 1, "destroyDanmu");
            this.hasCreate = false;
            DanmakuManager danmakuManager = this.danmukuManager;
            View view = null;
            if (danmakuManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
                danmakuManager = null;
            }
            danmakuManager.n0();
            DanmakuManager danmakuManager2 = this.danmukuManager;
            if (danmakuManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
                danmakuManager2 = null;
            }
            danmakuManager2.B();
            DanmakuManager danmakuManager3 = this.danmukuManager;
            if (danmakuManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
                danmakuManager3 = null;
            }
            danmakuManager3.G();
            View view2 = this.danmukuView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
                view2 = null;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                View view3 = this.danmukuView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("danmukuView");
                } else {
                    view = view3;
                }
                viewGroup.removeView(view);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        DanmakuManager danmakuManager = this.danmukuManager;
        if (danmakuManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmukuManager");
            danmakuManager = null;
        }
        danmakuManager.u0();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\u001a\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0016J.\u0010\u0010\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/LiveDanmuManager$c", "Lcom/tencent/common/danmaku/core/DanmakuManager$e;", "", "a", "", "Lcom/tencent/common/danmaku/data/a;", "", "Lcom/tencent/common/danmaku/inject/h;", "p0", "b", "", "d", "Lcom/tencent/common/danmaku/tool/h;", "p1", "Lcom/tencent/common/danmaku/tool/b;", "p2", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements DanmakuManager.e {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(com.tencent.common.danmaku.data.a aVar) {
            com.tencent.guild.api.wallet.a createGuildWalletHolder = ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).createGuildWalletHolder(((iq1.d) aVar).l().getContent().g(), null, true);
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            createGuildWalletHolder.c(sTopActivity);
        }

        @Override // com.tencent.common.danmaku.core.DanmakuManager.e
        public void c(@Nullable final com.tencent.common.danmaku.data.a<?, ?> p06, @Nullable com.tencent.common.danmaku.tool.h p16, @Nullable com.tencent.common.danmaku.tool.b p26) {
            if (p06 instanceof iq1.d) {
                QLog.i("QGL.LiveDanmuManager", 1, "onClickEvent HongBaoDanmaku");
                GLiveChannelCore.f226698a.t().T(1);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.danmu.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveDanmuManager.c.f(com.tencent.common.danmaku.data.a.this);
                    }
                }, 500L);
            }
        }

        @Override // com.tencent.common.danmaku.core.DanmakuManager.e
        public void a() {
        }

        @Override // com.tencent.common.danmaku.core.DanmakuManager.e
        public void b(@Nullable List<com.tencent.common.danmaku.data.a<Object, com.tencent.common.danmaku.inject.h>> p06) {
        }

        @Override // com.tencent.common.danmaku.core.DanmakuManager.e
        public void d(boolean p06) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
    }
}
