package com.tencent.mobileqq.springhb.interactive.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.widget.WidgetsKt;
import com.tencent.guild.aio.util.ae;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAioEggApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000eJ\u001e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J.\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bJ\u0016\u0010 \u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0012R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u001b\u0010<\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "g", "", "chatType", h.F, "scene", "Lcom/tencent/mobileqq/springhb/interactive/config/b;", DownloadInfo.spKey_Config, "", ReportConstant.COSTREPORT_PREFIX, "", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "operId", "ext3", "r", "Landroidx/fragment/app/Fragment;", "fragment", "interactiveConfig", "Lcom/tencent/mobileqq/springhb/interactive/ui/e;", "provider", "Lkotlin/Function0;", "listener", "t", "", "length", "l", "j", "reason", "o", "Lcom/tencent/mobileqq/springhb/interactive/overtimecontrol/a;", "a", "Lcom/tencent/mobileqq/springhb/interactive/overtimecontrol/a;", "overTimeController", "Landroid/view/View;", "b", "Landroid/view/View;", "playViewContainer", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopPagView;", "c", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopPagView;", "playPopView", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "chatPieContainer", "e", "Z", "isSetClickListener", "f", "hasVibrate", "Lkotlin/Lazy;", "i", "()I", "statusBarHeight", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"InternalInsetResource"})
/* loaded from: classes18.dex */
public final class InteractivePopManager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.interactive.overtimecontrol.a overTimeController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View playViewContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InteractivePopPagView playPopView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup chatPieContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSetClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasVibrate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusBarHeight;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager$a;", "", "", "SCENE_CLICK", "I", "SCENE_CLIENT_TO_CHANNEL", "SCENE_CLIENT_TO_CLIENT", "SCENE_CLIENT_TO_GROUP", "SCENE_ENTRY_ACTIVITY", "SCENE_PLAY", "SCENE_UNSET", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.interactive.ui.InteractivePopManager$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager$b", "Lcom/tencent/aio/base/tool/c;", "Landroid/view/View;", "v", "", "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends com.tencent.aio.base.tool.c {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.interactive.config.b f289293h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f289294i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.tencent.mobileqq.springhb.interactive.config.b bVar, Context context) {
            super(0L, 1, null);
            this.f289293h = bVar;
            this.f289294i = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, InteractivePopManager.this, bVar, context);
            }
        }

        @Override // com.tencent.aio.base.tool.c
        public void a(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                InteractivePopManager.this.s(6, this.f289293h);
                String f16 = this.f289293h.f();
                if (!this.f289293h.b()) {
                    f16 = this.f289293h.c();
                }
                String str = f16;
                Bundle bundle = new Bundle(2);
                bundle.putInt("spring_scene", 1);
                Integer valueOf = Integer.valueOf(this.f289293h.getId());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(interactiveConfig.getId())");
                bundle.putInt("spring_backend_scene_id", valueOf.intValue());
                ((IGameCenterAioEggApi) QRoute.api(IGameCenterAioEggApi.class)).jumpWeb(this.f289294i, str, 1, this.f289293h.e(), bundle);
                InteractivePopManager.this.o("UserClickAnim");
                InteractivePopManager.this.r(this.f289293h, "915874", "0");
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager$c", "Lcom/tencent/mobileqq/springhb/interactive/ui/a;", "", "onAnimationStart", "", "complete", "a", "onAnimationCancel", "", "progress", "b", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<View> f289295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InteractivePopManager f289296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.interactive.config.b f289297c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f289298d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f289299e;

        c(Ref.ObjectRef<View> objectRef, InteractivePopManager interactivePopManager, com.tencent.mobileqq.springhb.interactive.config.b bVar, Ref.ObjectRef<Function0<Unit>> objectRef2, Context context) {
            this.f289295a = objectRef;
            this.f289296b = interactivePopManager;
            this.f289297c = bVar;
            this.f289298d = objectRef2;
            this.f289299e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, objectRef, interactivePopManager, bVar, objectRef2, context);
            }
        }

        @Override // com.tencent.mobileqq.springhb.interactive.ui.a
        public void a(boolean complete) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, complete);
                return;
            }
            this.f289296b.o("animationEnd complete " + complete + " ");
            if (complete) {
                Function0<Unit> function0 = this.f289298d.element;
                if (function0 != null) {
                    function0.invoke();
                }
                this.f289298d.element = null;
                return;
            }
            InteractiveAnimationHelper.INSTANCE.a(this.f289297c, "2");
        }

        @Override // com.tencent.mobileqq.springhb.interactive.ui.a
        public void b(double progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Double.valueOf(progress));
                return;
            }
            if (this.f289297c.getType() != 1) {
                return;
            }
            double g16 = this.f289297c.g();
            if (!this.f289296b.hasVibrate && g16 >= 0.0d && progress >= g16) {
                long j3 = this.f289297c.j();
                InteractivePopManager interactivePopManager = this.f289296b;
                Context context = this.f289299e;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                interactivePopManager.l(context, j3);
            }
            if (progress >= this.f289297c.h()) {
                InteractivePopManager interactivePopManager2 = this.f289296b;
                com.tencent.mobileqq.springhb.interactive.config.b bVar = this.f289297c;
                Context context2 = this.f289299e;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                interactivePopManager2.j(bVar, context2);
            }
        }

        @Override // com.tencent.mobileqq.springhb.interactive.ui.a
        public void onAnimationCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.springhb.interactive.ui.a
        public void onAnimationStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            View view = this.f289295a.element;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f289296b.overTimeController.d(this.f289297c.i());
            this.f289296b.s(5, this.f289297c);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager$d", "Lcom/tencent/aio/base/tool/c;", "Landroid/view/View;", "v", "", "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends com.tencent.aio.base.tool.c {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.interactive.config.b f289301h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f289302i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.tencent.mobileqq.springhb.interactive.config.b bVar, Ref.ObjectRef<Function0<Unit>> objectRef) {
            super(0L, 1, null);
            this.f289301h = bVar;
            this.f289302i = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, InteractivePopManager.this, bVar, objectRef);
            }
        }

        @Override // com.tencent.aio.base.tool.c
        public void a(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                return;
            }
            QLog.d("InteractivePopManager", 1, "click jump!!");
            InteractivePopManager.this.o("clickJump");
            fr2.a.d(this.f289301h.getId(), InteractiveRecord.INSTANCE.a(this.f289301h.getChatType()));
            Function0<Unit> function0 = this.f289302i.element;
            if (function0 != null) {
                function0.invoke();
            }
            this.f289302i.element = null;
            InteractivePopManager.this.r(this.f289301h, "915873", "0");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InteractivePopManager() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.overTimeController = new com.tencent.mobileqq.springhb.interactive.overtimecontrol.a(this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) InteractivePopManager$statusBarHeight$2.INSTANCE);
        this.statusBarHeight = lazy;
    }

    private final Drawable g(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(context.getColorStateList(R.color.qui_common_fill_allblack_weak));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(40.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(context.getColorStateList(R.color.qui_common_fill_allblack_medium));
        gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(40.0f));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private final int h(int chatType) {
        int i3 = 1;
        if (chatType != 1) {
            i3 = 2;
            if (chatType != 2 && chatType != 3) {
                if (chatType == 4) {
                    return 3;
                }
                return 0;
            }
        }
        return i3;
    }

    private final int i() {
        return ((Number) this.statusBarHeight.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(InteractivePopManager this$0, com.tencent.mobileqq.springhb.interactive.config.b interactiveConfig, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interactiveConfig, "$interactiveConfig");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (this$0.isSetClickListener) {
            return;
        }
        View view = this$0.playViewContainer;
        if (view != null) {
            view.setOnClickListener(new b(interactiveConfig, context));
        }
        this$0.isSetClickListener = true;
    }

    private final boolean n(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) systemService).getRingerMode() != 0) {
            return false;
        }
        return true;
    }

    private final void p() {
        final View view = this.playViewContainer;
        ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.springhb.interactive.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                InteractivePopManager.q(view);
            }
        });
        this.playViewContainer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View view) {
        ViewGroup viewGroup;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(int scene, com.tencent.mobileqq.springhb.interactive.config.b config) {
        int h16;
        if (config.getSource() != 1) {
            return;
        }
        if (scene != 5) {
            if (scene != 6) {
                h16 = 0;
            } else {
                h16 = 4;
            }
        } else {
            h16 = h(config.getChatType());
        }
        ((IGameCenterAioEggApi) QRoute.api(IGameCenterAioEggApi.class)).triggerEggReq(config.b(), h16, config.getChatType(), config.getSessionId(), config.getId(), config.e(), config.k());
        if (scene == 5) {
            InteractiveAnimationHelper.INSTANCE.a(config, "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(e provider, InteractivePopManager this$0, com.tencent.mobileqq.springhb.interactive.config.b interactiveConfig, InteractivePopPagView it, PAGFile pAGFile, Ref.ObjectRef closeView, Ref.ObjectRef dismisslistener, Context context) {
        Intrinsics.checkNotNullParameter(provider, "$provider");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interactiveConfig, "$interactiveConfig");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(closeView, "$closeView");
        Intrinsics.checkNotNullParameter(dismisslistener, "$dismisslistener");
        if (!provider.a()) {
            QLog.d("InteractivePopManager", 1, "realShow notActive!");
            this$0.o("host not Active!!");
        } else {
            QLog.d("InteractivePopManager", 1, "playViewShow!");
            fr2.a.c(interactiveConfig.getId(), InteractiveRecord.INSTANCE.a(interactiveConfig.getChatType()));
            it.k(pAGFile, new c(closeView, this$0, interactiveConfig, dismisslistener, context));
        }
    }

    public final void j(@NotNull final com.tencent.mobileqq.springhb.interactive.config.b interactiveConfig, @NotNull final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) interactiveConfig, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(interactiveConfig, "interactiveConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.springhb.interactive.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                InteractivePopManager.k(InteractivePopManager.this, interactiveConfig, context);
            }
        });
    }

    public final void l(@NotNull Context context, long length) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Long.valueOf(length));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (length <= 0) {
            return;
        }
        try {
            if (n(context)) {
                QLog.i("InteractivePopManager", 1, "[handleVibrateEvent], ringer silent.");
            } else {
                ae.f112367a.b(context, length);
                this.hasVibrate = true;
            }
        } catch (Throwable th5) {
            QLog.e("InteractivePopManager", 1, "[handleVibrateEvent], th:", th5);
        }
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.playViewContainer != null) {
            return true;
        }
        return false;
    }

    public final void o(@NotNull String reason) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reason);
            return;
        }
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.playViewContainer != null) {
            QLog.d("InteractivePopManager", 1, "onDestroy " + reason + "  " + this.playPopView + " ");
            if (this.hasVibrate) {
                ae aeVar = ae.f112367a;
                InteractivePopPagView interactivePopPagView = this.playPopView;
                if (interactivePopPagView != null) {
                    context = interactivePopPagView.getContext();
                } else {
                    context = null;
                }
                aeVar.a(context);
            }
            p();
            this.overTimeController.c(reason);
            InteractivePopPagView interactivePopPagView2 = this.playPopView;
            if (interactivePopPagView2 != null) {
                interactivePopPagView2.j();
            }
            this.playPopView = null;
            this.isSetClickListener = false;
            this.hasVibrate = false;
        }
    }

    public final void r(@NotNull com.tencent.mobileqq.springhb.interactive.config.b config, @NotNull String operId, @NotNull String ext3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, config, operId, ext3);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(operId, "operId");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        if (config.getSource() != 1) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext3", ext3);
        hashMap.put("ext4", "20");
        hashMap.put("ext2", config.e());
        hashMap.put("ext6", config.getSessionId());
        hashMap.put("ext49", InteractiveRecord.INSTANCE.a(config.getChatType()));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(config.d(), "8", "1069", "9514", "951401", operId, "", hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.widget.TextView, T, android.view.View] */
    public final void t(@NotNull Fragment fragment, @NotNull final com.tencent.mobileqq.springhb.interactive.config.b interactiveConfig, @NotNull final e provider, @Nullable Function0<Unit> listener) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fragment, interactiveConfig, provider, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(interactiveConfig, "interactiveConfig");
        Intrinsics.checkNotNullParameter(provider, "provider");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = listener;
        final PAGFile a16 = interactiveConfig.a();
        if (a16 == null) {
            QLog.e("InteractivePopManager", 1, "showInteractivePop playFile isNull!!");
            return;
        }
        this.isSetClickListener = false;
        this.hasVibrate = false;
        final View view = fragment.getView();
        if (view != null) {
            final Context context = view.getContext();
            p();
            this.chatPieContainer = (ViewGroup) view.findViewById(WidgetsKt.a());
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout frameLayout2 = new FrameLayout(context, view, this, interactiveConfig) { // from class: com.tencent.mobileqq.springhb.interactive.ui.InteractivePopManager$showInteractivePop$1$1$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f289303d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f289304e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ InteractivePopManager f289305f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.springhb.interactive.config.b f289306h;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context);
                    this.f289303d = context;
                    this.f289304e = view;
                    this.f289305f = this;
                    this.f289306h = interactiveConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, context, view, this, interactiveConfig);
                    }
                }

                @Override // android.view.View
                public boolean onTouchEvent(@Nullable MotionEvent event) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
                    }
                    Context context2 = this.f289303d;
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    if (com.tencent.mobileqq.springhb.interactive.a.a(context2)) {
                        QLog.d("InteractivePopManager", 2, "isSplitRight " + this.f289304e.getWidth() + " height " + this.f289304e.getHeight());
                        this.f289305f.r(this.f289306h, "915874", "1");
                        return true;
                    }
                    return super.onTouchEvent(event);
                }
            };
            frameLayout2.setPadding(0, ViewUtils.dpToPx(44.0f) + i(), 0, 0);
            FrameLayout frameLayout3 = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout3.setLayoutParams(layoutParams);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            final InteractivePopPagView interactivePopPagView = new InteractivePopPagView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            interactivePopPagView.setLayoutParams(layoutParams2);
            this.playPopView = interactivePopPagView;
            interactivePopPagView.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.interactive.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    InteractivePopManager.u(e.this, this, interactiveConfig, interactivePopPagView, a16, objectRef, objectRef2, context);
                }
            });
            frameLayout3.addView(interactivePopPagView);
            ?? textView = new TextView(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = ViewUtils.dpToPx(24.0f);
            layoutParams3.rightMargin = ViewUtils.dpToPx(24.0f);
            layoutParams3.gravity = 5;
            textView.setLayoutParams(layoutParams3);
            int dpToPx = ViewUtils.dpToPx(20.0f);
            int dpToPx2 = ViewUtils.dpToPx(4.5f);
            textView.setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
            if (interactiveConfig.b()) {
                str = "\u8df3\u8fc7";
            } else {
                str = "\u5173\u95ed";
            }
            textView.setText(str);
            textView.setTextColor(-1);
            textView.setTextSize(15.0f);
            textView.setBackground(g(context));
            objectRef.element = textView;
            textView.setVisibility(8);
            textView.setOnClickListener(new d(interactiveConfig, objectRef2));
            frameLayout3.addView(textView);
            frameLayout2.addView(frameLayout3);
            frameLayout.addView(frameLayout2);
            this.playViewContainer = frameLayout;
            ViewGroup viewGroup = this.chatPieContainer;
            if (viewGroup != null) {
                viewGroup.addView(frameLayout);
            }
            QLog.d("InteractivePopManager", 1, "popActionShow");
        }
    }
}
