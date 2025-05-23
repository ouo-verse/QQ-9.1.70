package com.tencent.mobileqq.guild.media.presenter;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.GuildMediaChannelFragment;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaLandVideoView;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.immersive.GuildMediaImmersiveEvent;
import com.tencent.mobileqq.guild.media.presenter.ImmersivePresenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u00010\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0016\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/ImmersivePresenter;", "Let1/d;", "", "v", "k", "t", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "", "toEnterImmersiveState", tl.h.F, "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelFragment;", "fragment", "p", "a", "b", "underNeedImmersiveState", ReportConstant.COSTREPORT_PREFIX, "u", "w", "j", "Landroid/view/View;", "view1", "view2", DomainData.DOMAIN_NAME, "o", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ldt1/d;", "Ldt1/d;", "mImmersiveTouchHandler", "Ldt1/a;", "c", "Ldt1/a;", "mImmersiveAnimHandler", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "mediaChannelFragmentRef", "Ljava/util/Timer;", "e", "Ljava/util/Timer;", "mMarkGestureTimer", "f", "Z", "mIsUnderImmersive", "com/tencent/mobileqq/guild/media/presenter/ImmersivePresenter$b", "g", "Lcom/tencent/mobileqq/guild/media/presenter/ImmersivePresenter$b;", "mImmersiveStateTimer", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ImmersivePresenter implements et1.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private dt1.d mImmersiveTouchHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private dt1.a mImmersiveAnimHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<GuildMediaChannelFragment> mediaChannelFragmentRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Timer mMarkGestureTimer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsUnderImmersive;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mImmersiveStateTimer;

    public ImmersivePresenter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mImmersiveStateTimer = new b();
    }

    private final void h(boolean toEnterImmersiveState) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildMediaImmersiveEvent(toEnterImmersiveState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        WeakReference<GuildMediaChannelFragment> weakReference = this.mediaChannelFragmentRef;
        dt1.a aVar = null;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment == null) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[doEnterImmersiveView] ref is null return");
            return;
        }
        if (guildMediaChannelFragment.hi().getNoNeedDetectionImmersive()) {
            return;
        }
        QLog.i("QGMC.ImmersivePresenter", 1, "[doEnterImmersiveView]");
        h(true);
        if (this.mIsUnderImmersive) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[doEnterImmersiveView] is under immersive currently, ignore");
            return;
        }
        this.mIsUnderImmersive = true;
        if (guildMediaChannelFragment.getMContentView() instanceof GuildMediaLandVideoView) {
            dt1.a aVar2 = this.mImmersiveAnimHandler;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
            } else {
                aVar = aVar2;
            }
            aVar.d(guildMediaChannelFragment.mi(), guildMediaChannelFragment.gi());
            return;
        }
        dt1.a aVar3 = this.mImmersiveAnimHandler;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
        } else {
            aVar = aVar3;
        }
        aVar.c(guildMediaChannelFragment.mi(), guildMediaChannelFragment.gi(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        WeakReference<GuildMediaChannelFragment> weakReference = this.mediaChannelFragmentRef;
        dt1.d dVar = null;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment != null && !guildMediaChannelFragment.hi().getNoNeedDetectionImmersive()) {
            dt1.d dVar2 = this.mImmersiveTouchHandler;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImmersiveTouchHandler");
            } else {
                dVar = dVar2;
            }
            View rootView = guildMediaChannelFragment.getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            dVar.k((ViewGroup) rootView, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmersivePresenter.l(ImmersivePresenter.this, view);
                }
            }, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.presenter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmersivePresenter.m(ImmersivePresenter.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ImmersivePresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ImmersivePresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        QLog.i("QGMC.ImmersivePresenter", 1, "[onChildViewButtonClicked] ");
        t();
    }

    private final void r() {
        QLog.i("QGMC.ImmersivePresenter", 1, "[onChildViewEmptyClicked] ");
        WeakReference<GuildMediaChannelFragment> weakReference = this.mediaChannelFragmentRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment == null) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[onChildViewEmptyClicked] ref is null return ");
            return;
        }
        if (!Intrinsics.areEqual(guildMediaChannelFragment.hi().c2().getValue(), Boolean.TRUE)) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[onChildViewEmptyClicked] ignored");
        } else if (this.mIsUnderImmersive) {
            t();
            j();
        } else {
            v();
            i();
        }
    }

    private final void t() {
        boolean z16;
        WeakReference<GuildMediaChannelFragment> weakReference = this.mediaChannelFragmentRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment == null) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[startImmersiveCountDown] ref is null return");
            return;
        }
        v();
        com.tencent.mobileqq.guild.media.content.i mContentView = guildMediaChannelFragment.getMContentView();
        if (mContentView != null) {
            z16 = mContentView.C0();
        } else {
            z16 = false;
        }
        if (z16) {
            this.mImmersiveStateTimer.start();
        }
        QLog.i("QGMC.ImmersivePresenter", 1, "[startImmersiveCountDown] needImmersive: " + z16);
    }

    private final void v() {
        this.mImmersiveStateTimer.cancel();
        QLog.i("QGMC.ImmersivePresenter", 1, "[stopImmersiveCountDown] ");
    }

    @Override // et1.d
    public void a() {
        dt1.d dVar = this.mImmersiveTouchHandler;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImmersiveTouchHandler");
            dVar = null;
        }
        dVar.a();
    }

    @Override // et1.d
    public void b() {
        dt1.d dVar = this.mImmersiveTouchHandler;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImmersiveTouchHandler");
            dVar = null;
        }
        dVar.b();
    }

    public final void j() {
        QLog.i("QGMC.ImmersivePresenter", 1, "[doExitImmersiveView] ");
        if (!this.mIsUnderImmersive) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[doExitImmersiveView] is not under immersive currently, ignore");
            return;
        }
        this.mIsUnderImmersive = false;
        WeakReference<GuildMediaChannelFragment> weakReference = this.mediaChannelFragmentRef;
        dt1.a aVar = null;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
            weakReference = null;
        }
        GuildMediaChannelFragment guildMediaChannelFragment = weakReference.get();
        if (guildMediaChannelFragment == null) {
            QLog.i("QGMC.ImmersivePresenter", 1, "[doExitImmersiveView] ref is null return");
            return;
        }
        if (guildMediaChannelFragment.getMContentView() instanceof GuildMediaLandVideoView) {
            dt1.a aVar2 = this.mImmersiveAnimHandler;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
            } else {
                aVar = aVar2;
            }
            aVar.f(guildMediaChannelFragment.mi(), guildMediaChannelFragment.gi());
        } else {
            dt1.a aVar3 = this.mImmersiveAnimHandler;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
            } else {
                aVar = aVar3;
            }
            aVar.e(guildMediaChannelFragment.mi(), guildMediaChannelFragment.gi(), this);
        }
        h(false);
    }

    public final void n(@NotNull View view1, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view1, "view1");
        Intrinsics.checkNotNullParameter(view2, "view2");
        dt1.a aVar = this.mImmersiveAnimHandler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
            aVar = null;
        }
        aVar.d(view1, view2);
    }

    public final void o(@NotNull View view1, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view1, "view1");
        Intrinsics.checkNotNullParameter(view2, "view2");
        dt1.a aVar = this.mImmersiveAnimHandler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImmersiveAnimHandler");
            aVar = null;
        }
        aVar.f(view1, view2);
    }

    public final void p(@NotNull GuildMediaChannelFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mImmersiveTouchHandler = new dt1.d(this.context);
        this.mImmersiveAnimHandler = new dt1.a(this.context);
        this.mediaChannelFragmentRef = new WeakReference<>(fragment);
    }

    public final void s(boolean underNeedImmersiveState) {
        if (underNeedImmersiveState) {
            u();
        } else {
            w();
            j();
        }
    }

    public final void u() {
        QLog.i("QGMC.ImmersivePresenter", 1, "[startMarkImmersiveGesture] ");
        w();
        BaseTimer baseTimer = new BaseTimer();
        this.mMarkGestureTimer = baseTimer;
        baseTimer.schedule(new ImmersivePresenter$startMarkImmersiveGesture$1(this), 0L, 200L);
        t();
    }

    public final void w() {
        QLog.i("QGMC.ImmersivePresenter", 1, "[stopMarkImmersiveGesture] ");
        v();
        Timer timer = this.mMarkGestureTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mMarkGestureTimer = null;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/ImmersivePresenter$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends CountDownTimer {
        b() {
            super(3000L, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(ImmersivePresenter this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("QGMC.ImmersivePresenter", 1, "[onFinish] immersive state timer");
            WeakReference weakReference = this$0.mediaChannelFragmentRef;
            WeakReference weakReference2 = null;
            if (weakReference == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
                weakReference = null;
            }
            if (weakReference.get() != 0) {
                MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
                WeakReference weakReference3 = this$0.mediaChannelFragmentRef;
                if (weakReference3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaChannelFragmentRef");
                } else {
                    weakReference2 = weakReference3;
                }
                T t16 = weakReference2.get();
                Intrinsics.checkNotNull(t16);
                if (!mediaChannelUtils.s(((GuildMediaChannelFragment) t16).getActivity())) {
                    this$0.i();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ImmersivePresenter immersivePresenter = ImmersivePresenter.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.j
                @Override // java.lang.Runnable
                public final void run() {
                    ImmersivePresenter.b.b(ImmersivePresenter.this);
                }
            });
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
        }
    }
}
