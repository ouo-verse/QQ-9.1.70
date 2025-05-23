package com.tencent.mobileqq.sharepanel.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.multiSelect.dialog.SelectedContactFragment;
import com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart;
import com.tencent.mobileqq.sharepanel.report.SelectedContactReportListener;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u001f*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u001e\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010!\u001a\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/SharePanelAnimationPart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "na", "aa", "ga", "ha", "V9", "", "ma", "Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "dismissType", "onlyAnimate", "Lkotlin/Function0;", "onEnd", "ia", "la", "qa", "", "X9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "G9", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "W9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectVM", "Lcom/tencent/mobileqq/sharepanel/preview/k;", "f", "Z9", "()Lcom/tencent/mobileqq/sharepanel/preview/k;", "singlePreviewVM", tl.h.F, "Landroid/view/View;", "panelContainer", "i", "maskView", "Landroid/view/animation/Animation;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/animation/Animation;", "showAnimation", BdhLogUtil.LogTag.Tag_Conn, "dismissAnimation", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/sharepanel/multiSelect/dialog/SelectedContactFragment;", "D", "Lmqq/util/WeakReference;", "selectedContactFragmentRef", "Lcom/tencent/mobileqq/sharepanel/report/SelectedContactReportListener;", "E", "Y9", "()Lcom/tencent/mobileqq/sharepanel/report/SelectedContactReportListener;", "selectedContactReportListener", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", UserInfo.SEX_FEMALE, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelAnimationPart extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Animation dismissAnimation;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<SelectedContactFragment> selectedContactFragmentRef;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedContactReportListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy multiSelectVM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy singlePreviewVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View panelContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View maskView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation showAnimation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/SharePanelAnimationPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/part/SharePanelAnimationPart$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f287523e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f287524f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ DismissType f287525h;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f287526a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40709);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[DismissType.values().length];
                try {
                    iArr[DismissType.CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DismissType.FORCE_CANCEL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f287526a = iArr;
            }
        }

        b(Function0<Unit> function0, boolean z16, DismissType dismissType) {
            this.f287523e = function0;
            this.f287524f = z16;
            this.f287525h = dismissType;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SharePanelAnimationPart.this, function0, Boolean.valueOf(z16), dismissType);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DismissType dismissType, SharePanelAnimationPart this$0) {
            Intrinsics.checkNotNullParameter(dismissType, "$dismissType");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i3 = a.f287526a[dismissType.ordinal()];
            if (i3 != 1 && i3 != 2) {
                this$0.E9();
            } else {
                this$0.A9();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QLog.d("SharePanelAnimationPart", 1, "onDismissAnimationEnd");
            SharePanelAnimationPart.this.dismissAnimation = null;
            Function0<Unit> function0 = this.f287523e;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.f287524f) {
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final DismissType dismissType = this.f287525h;
            final SharePanelAnimationPart sharePanelAnimationPart = SharePanelAnimationPart.this;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.part.g
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelAnimationPart.b.b(DismissType.this, sharePanelAnimationPart);
                }
            }, 30L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/part/SharePanelAnimationPart$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f287527d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SharePanelAnimationPart f287528e;

        c(View view, SharePanelAnimationPart sharePanelAnimationPart) {
            this.f287527d = view;
            this.f287528e = sharePanelAnimationPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) sharePanelAnimationPart);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QLog.d("SharePanelAnimationPart", 1, "onShowAnimationEnd");
            this.f287528e.showAnimation = null;
            this.f287528e.qa();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.f287527d.setVisibility(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelAnimationPart(@NotNull final SharePanelParam param) {
        super(param);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$multiSelectVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelAnimationPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) SharePanelAnimationPart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectVM = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.preview.k>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$singlePreviewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelAnimationPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.preview.k invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.preview.k) SharePanelAnimationPart.this.getViewModel(com.tencent.mobileqq.sharepanel.preview.k.class) : (com.tencent.mobileqq.sharepanel.preview.k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.singlePreviewVM = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SelectedContactReportListener>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$selectedContactReportListener$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelParam.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SelectedContactReportListener invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new SelectedContactReportListener(SharePanelParam.this) : (SelectedContactReportListener) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.selectedContactReportListener = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final void V9() {
        SelectedContactFragment selectedContactFragment;
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        try {
            WeakReference<SelectedContactFragment> weakReference = this.selectedContactFragmentRef;
            if (weakReference != null && (selectedContactFragment = weakReference.get()) != null) {
                FragmentActivity fragmentActivity = null;
                this.selectedContactFragmentRef = null;
                if (!selectedContactFragment.isAdded()) {
                    return;
                }
                Activity activity = getActivity();
                if (activity instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) activity;
                }
                if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(selectedContactFragment)) != null) {
                    remove.commitAllowingStateLoss();
                }
            }
        } catch (Exception e16) {
            QLog.e("SharePanelAnimationPart", 1, "dismissSelectedContactListDialog error: ", e16);
        }
    }

    private final com.tencent.mobileqq.sharepanel.multiSelect.vm.a W9() {
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) this.multiSelectVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X9() {
        Context context;
        View view = this.panelContainer;
        if (view == null || (context = view.getContext()) == null) {
            context = BaseApplication.context;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectedContactReportListener Y9() {
        return (SelectedContactReportListener) this.selectedContactReportListener.getValue();
    }

    private final com.tencent.mobileqq.sharepanel.preview.k Z9() {
        return (com.tencent.mobileqq.sharepanel.preview.k) this.singlePreviewVM.getValue();
    }

    private final void aa() {
        View view;
        ImageView imageView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SharePanelAnimationPart.ba(SharePanelAnimationPart.this, view2);
                }
            });
        }
        View partRootView2 = getPartRootView();
        View view2 = null;
        if (partRootView2 != null) {
            view = partRootView2.findViewById(R.id.yey);
        } else {
            view = null;
        }
        this.panelContainer = view;
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            view2 = partRootView3.findViewById(R.id.t6c);
        }
        this.maskView = view2;
        View partRootView4 = getPartRootView();
        if (partRootView4 != null && (imageView = (ImageView) partRootView4.findViewById(R.id.dum)) != null) {
            com.tencent.mobileqq.sharepanel.util.c cVar = com.tencent.mobileqq.sharepanel.util.c.f287601a;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            imageView.setImageDrawable(cVar.a(context));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SharePanelAnimationPart.ca(SharePanelAnimationPart.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(SharePanelAnimationPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z9(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(SharePanelAnimationPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z9(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ga() {
        View view = this.panelContainer;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = (int) (X9() * 0.15d);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        final Activity activity;
        final List<SharePanelContactItem> value = W9().M1().getValue();
        if (value != null && (activity = getActivity()) != null) {
            ia(DismissType.DISMISS, true, new Function0<Unit>(activity, this, value) { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$showSelectedContactListDialog$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $it;
                final /* synthetic */ List<SharePanelContactItem> $selectedList;
                final /* synthetic */ SharePanelAnimationPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$it = activity;
                    this.this$0 = this;
                    this.$selectedList = value;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, this, value);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int X9;
                    SelectedContactReportListener Y9;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SelectedContactFragment selectedContactFragment = new SelectedContactFragment();
                    final SharePanelAnimationPart sharePanelAnimationPart = this.this$0;
                    List<SharePanelContactItem> list = this.$selectedList;
                    Bundle bundle = new Bundle();
                    X9 = sharePanelAnimationPart.X9();
                    bundle.putInt("panel_height", X9 / 2);
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    arrayList.addAll(list);
                    bundle.putParcelableArrayList("selected_contact_list", arrayList);
                    bundle.putString("title", "\u5206\u4eab\u81f3");
                    selectedContactFragment.setArguments(bundle);
                    selectedContactFragment.Kh(new Function0<Unit>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$showSelectedContactListDialog$1$1$fragment$1$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelAnimationPart.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                SharePanelAnimationPart.this.ma();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    Y9 = sharePanelAnimationPart.Y9();
                    selectedContactFragment.Lh(Y9);
                    try {
                        Activity activity2 = this.$it;
                        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        ((FragmentActivity) activity2).getSupportFragmentManager().beginTransaction().add(selectedContactFragment, "SharePanelAnimationPart").commitAllowingStateLoss();
                        this.this$0.selectedContactFragmentRef = new WeakReference(selectedContactFragment);
                    } catch (Exception e16) {
                        QLog.e("SharePanelAnimationPart", 1, "showInternal error: ", e16);
                    }
                }
            });
        }
    }

    private final boolean ia(DismissType dismissType, boolean onlyAnimate, Function0<Unit> onEnd) {
        float f16;
        View view = this.panelContainer;
        boolean z16 = false;
        if (view == null || view.getHeight() <= 0) {
            return false;
        }
        Animation animation = this.dismissAnimation;
        if (animation != null && animation.hasStarted()) {
            z16 = true;
        }
        if (z16) {
            Animation animation2 = this.dismissAnimation;
            if (animation2 != null) {
                animation2.cancel();
            }
            f16 = view.getTranslationY();
        } else {
            f16 = 0.0f;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f16, view.getHeight());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        he0.b.l(animationSet, R.anim.f154974uh);
        animationSet.setAnimationListener(new b(onEnd, onlyAnimate, dismissType));
        view.startAnimation(animationSet);
        this.dismissAnimation = animationSet;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean ja(SharePanelAnimationPart sharePanelAnimationPart, DismissType dismissType, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        return sharePanelAnimationPart.ia(dismissType, z16, function0);
    }

    private final void la() {
        View view = this.maskView;
        if (view != null) {
            view.setBackgroundResource(R.drawable.qui_common_overlay_dark_bg);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(100L);
        View view2 = this.maskView;
        if (view2 != null) {
            view2.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ma() {
        boolean z16;
        View view = this.panelContainer;
        if (view == null) {
            return false;
        }
        if (view.getHeight() <= 0) {
            view.setVisibility(0);
            return false;
        }
        Animation animation = this.showAnimation;
        if (animation != null && animation.hasStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            view.setVisibility(0);
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        he0.b.l(animationSet, R.anim.f154977uk);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c(view, this));
        view.startAnimation(animationSet);
        this.showAnimation = animationSet;
        return true;
    }

    private final void na() {
        View view = this.panelContainer;
        if (view != null) {
            view.setVisibility(4);
            view.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelAnimationPart.oa(SharePanelAnimationPart.this);
                }
            });
        }
        if (this.maskView != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelAnimationPart.pa(SharePanelAnimationPart.this);
                }
            }, 30L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(SharePanelAnimationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(SharePanelAnimationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.la();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        DialogFragment dialogFragment;
        Dialog dialog;
        Window window;
        Object partHost = getPartHost();
        if (partHost instanceof DialogFragment) {
            dialogFragment = (DialogFragment) partHost;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
            QUIImmersiveHelper.u(window, true, true);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.part.i
    public boolean G9(@NotNull DismissType dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dismissType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(dismissType, "dismissType");
        return ja(this, dismissType, false, null, 6, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            ga();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        aa();
        na();
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null) {
            MutableLiveData<Boolean> O1 = W9().O1();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$onInitView$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelAnimationPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        SharePanelAnimationPart.this.ha();
                    }
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SharePanelAnimationPart.da(Function1.this, obj);
                }
            });
            MutableLiveData<Unit> L1 = Z9().L1();
            final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart$onInitView$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelAnimationPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SharePanelAnimationPart.ja(SharePanelAnimationPart.this, DismissType.DISMISS, true, null, 4, null);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) unit);
                    }
                }
            };
            L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SharePanelAnimationPart.ea(Function1.this, obj);
                }
            });
        }
        ga();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            V9();
        }
    }
}
