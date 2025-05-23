package com.tencent.mobileqq.qqlivehall.iv;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qcircle.api.global.QFSTeenModeConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.api.auth.AuthState;
import com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0002\r\u000eB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/i;", "Lcom/tencent/biz/richframework/part/Part;", "", "init", "F9", "Landroid/view/View;", "view", "dismiss", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "d", "a", "b", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/i$a;", "", "", "ADULT_AGE", "I", "", "MQQ_STUDY_MODE", "Ljava/lang/String;", "", "SHOW_WINDOW_DELAY", "J", "TAG", "<init>", "()V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlivehall.iv.i$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/i$b;", "Lcom/tencent/timi/game/api/auth/a;", "Lcom/tencent/timi/game/api/auth/AuthState;", "state", "", "message", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlivehall/iv/i;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "partRef", "part", "<init>", "(Lcom/tencent/mobileqq/qqlivehall/iv/i;)V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.timi.game.api.auth.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<i> partRef;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes17.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f274125a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20909);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[AuthState.values().length];
                try {
                    iArr[AuthState.NOT_AUTHED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AuthState.AUTHED_TEEN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f274125a = iArr;
            }
        }

        public b(@NotNull i part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.partRef = new WeakReference<>(part);
            }
        }

        @Override // com.tencent.timi.game.api.auth.a
        public void a(@Nullable AuthState state, @Nullable String message) {
            int i3;
            Bundle arguments;
            Bundle bundle;
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) message);
                return;
            }
            i iVar = this.partRef.get();
            if (iVar == null) {
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Audience|QQLiveTeenModePopWindowPart", "checkAuth state:" + state + ", message:" + message);
            int i16 = -1;
            if (state == null) {
                i3 = -1;
            } else {
                i3 = a.f274125a[state.ordinal()];
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    iVar.F9();
                    QFSTeenModeConfig.saveTeenModeWindowLastShowTime();
                    return;
                }
                return;
            }
            Fragment hostFragment = iVar.getHostFragment();
            if (hostFragment != null && (arguments = hostFragment.getArguments()) != null && (bundle = arguments.getBundle("params")) != null && (bundle2 = bundle.getBundle(OpenHippyInfo.EXTRA_KEY_BUSINESS_BUNDLE)) != null) {
                i16 = bundle2.getInt("userAge", -1);
            }
            companion.i("Audience|QQLiveTeenModePopWindowPart", "userAge:" + i16);
            if (i16 < 18) {
                iVar.F9();
                QFSTeenModeConfig.saveTeenModeWindowLastShowTime();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlivehall/iv/i$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f274126d;

        c(View view) {
            this.f274126d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
            } else {
                this.f274126d.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlivehall.iv.d
            @Override // java.lang.Runnable
            public final void run() {
                i.G9(i.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(final i this$0) {
        ViewStub viewStub;
        final View inflate;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View partRootView = this$0.getPartRootView();
        if (partRootView != null && (viewStub = (ViewStub) partRootView.findViewById(R.id.f6404356)) != null && (inflate = viewStub.inflate()) != null) {
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlivehall.iv.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.H9(i.this, inflate, view);
                }
            });
            inflate.findViewById(R.id.f639534x).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlivehall.iv.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.I9(i.this, inflate, view);
                }
            });
            inflate.findViewById(R.id.f639634y).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlivehall.iv.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.J9(i.this, inflate, view);
                }
            });
            inflate.findViewById(R.id.f6399351).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlivehall.iv.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.K9(i.this, inflate, view);
                }
            });
            View findViewById = inflate.findViewById(R.id.f6398350);
            findViewById.startAnimation(AnimationUtils.loadAnimation(findViewById.getContext(), R.anim.f155067i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(i this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.dismiss(this_apply);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(i this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.dismiss(this_apply);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(i this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.dismiss(this_apply);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(i this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) JumpActivity.class).setData(Uri.parse("mqqapi://vaslive/study_mode")));
        }
        this$0.dismiss(this_apply);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.init();
    }

    private final void dismiss(View view) {
        View findViewById = view.findViewById(R.id.f6398350);
        findViewById.setAnimation(AnimationUtils.loadAnimation(findViewById.getContext(), R.anim.f155066i1));
        findViewById.getAnimation().setAnimationListener(new c(view));
        findViewById.startAnimation(findViewById.getAnimation());
    }

    private final void init() {
        if (ht3.a.b("qqlive_enable_new_minor_strategy", 1) != 1) {
            AegisLogger.INSTANCE.i("Audience|QQLiveTeenModePopWindowPart", "disable teen-mode new strategy");
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveTeenModePopWindowPart", "study mode");
        } else if (!QFSTeenModeConfig.isTeenModeWindowShownMoreThanOneDay()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveTeenModePopWindowPart", "latest show less than one day");
        } else {
            ((IQQLiveAuthCheckApi) QRoute.api(IQQLiveAuthCheckApi.class)).checkAuth(new b(this));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqlivehall.iv.c
                @Override // java.lang.Runnable
                public final void run() {
                    i.L9(i.this);
                }
            });
        }
    }
}
