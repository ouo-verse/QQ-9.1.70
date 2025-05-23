package com.tencent.mobileqq.qqlive.sail.ui.danmu;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.l;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import wn4.a;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/l;", "", "Lorg/libpag/PAGFile;", "pagFile", "", "f", tl.h.F, "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "pagView", "d", "i", "g", "a", "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "guidePagView", "Lhi4/b;", "kotlin.jvm.PlatformType", "b", "Lhi4/b;", "service", "Lhi4/c;", "c", "Lhi4/c;", "soLoadListener", "Lwn4/a$a;", "Lwn4/a$a;", "pagResLoadListener", "<init>", "()V", "e", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimiGamePAGView guidePagView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final hi4.b service;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hi4.c soLoadListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a.InterfaceC11498a pagResLoadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/l$a;", "", "", "GUIDE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.danmu.l$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/l$b", "Lwn4/a$a;", "", "url", "Lorg/libpag/PAGFile;", "pagFile", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a.InterfaceC11498a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(l this$0, PAGFile pagFile) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pagFile, "$pagFile");
            this$0.f(pagFile);
        }

        @Override // wn4.a.InterfaceC11498a
        public void a(@NotNull String url, @NotNull final PAGFile pagFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) pagFile);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(pagFile, "pagFile");
            AegisLogger.INSTANCE.i("Chat_Message|QQLiveChatMsgGuideLogic", "onPAGResourceLoad url:" + url);
            if (Intrinsics.areEqual("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8980/live/qvideo_feeds_qqlive_danmu_lead.pag", url)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final l lVar = l.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.b.c(l.this, pagFile);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/l$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements PAGView.PAGViewListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TimiGamePAGView f272587d;

        c(TimiGamePAGView timiGamePAGView) {
            this.f272587d = timiGamePAGView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) timiGamePAGView);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
            } else {
                this.f272587d.setVisibility(8);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
            } else {
                this.f272587d.setVisibility(8);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
            } else {
                this.f272587d.setVisibility(0);
                ct3.a.o("qqlive_key_has_show_chat_msg_guide_animation", true);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/l$d", "Lhi4/c;", "", "onLoaded", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements hi4.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(l this$0, PAGFile pAGFile) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f(pAGFile);
        }

        @Override // hi4.c
        public void onLoaded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Chat_Message|QQLiveChatMsgGuideLogic", "PAG library onLoaded.");
            final PAGFile e16 = wn4.a.f445988a.e("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8980/live/qvideo_feeds_qqlive_danmu_lead.pag", null);
            if (e16 != null) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final l lVar = l.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.d.b(l.this, e16);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51718);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.service = (hi4.b) mm4.b.b(hi4.b.class);
        this.soLoadListener = new d();
        this.pagResLoadListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(PAGFile pagFile) {
        int coerceAtMost;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Chat_Message|QQLiveChatMsgGuideLogic", QZoneJsConstants.METHOD_PLAY, "pagFile is ready.");
        TimiGamePAGView timiGamePAGView = this.guidePagView;
        boolean z16 = false;
        if (timiGamePAGView != null && timiGamePAGView.f()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        companion.i("Chat_Message|QQLiveChatMsgGuideLogic", QZoneJsConstants.METHOD_PLAY, "start play.");
        int screenWidth = ViewUtils.getScreenWidth();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((pagFile.height() * screenWidth) / pagFile.width(), ViewUtils.getScreenHeight());
        TimiGamePAGView timiGamePAGView2 = this.guidePagView;
        if (timiGamePAGView2 != null) {
            ViewGroup.LayoutParams layoutParams = timiGamePAGView2.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = coerceAtMost;
            timiGamePAGView2.setLayoutParams(layoutParams);
            timiGamePAGView2.setScaleMode(3);
            timiGamePAGView2.setComposition(pagFile);
            timiGamePAGView2.setProgress(0.0d);
            timiGamePAGView2.setRepeatCount(1);
            timiGamePAGView2.b(new c(timiGamePAGView2));
            timiGamePAGView2.g();
        }
    }

    private final void h() {
        TimiGamePAGView timiGamePAGView = this.guidePagView;
        if (timiGamePAGView != null) {
            timiGamePAGView.h();
        }
        TimiGamePAGView timiGamePAGView2 = this.guidePagView;
        if (timiGamePAGView2 != null) {
            timiGamePAGView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(l this$0, PAGFile pAGFile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(pAGFile);
    }

    public final void d(@NotNull TimiGamePAGView pagView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pagView);
            return;
        }
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        this.guidePagView = pagView;
        if (pagView != null) {
            pagView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.e(l.this, view);
                }
            });
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        h();
        this.service.Q1(this.soLoadListener);
        wn4.a.f445988a.k(this.pagResLoadListener);
    }

    public final void i() {
        final PAGFile e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (ct3.a.e("qqlive_key_has_show_chat_msg_guide_animation", false)) {
            return;
        }
        this.service.P0(this.soLoadListener);
        wn4.a aVar = wn4.a.f445988a;
        aVar.b(this.pagResLoadListener);
        if (this.service.t() && (e16 = aVar.e("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8980/live/qvideo_feeds_qqlive_danmu_lead.pag", null)) != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.j(l.this, e16);
                }
            });
        }
    }
}
