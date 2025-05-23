package com.tencent.mobileqq.bizParts;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bizParts.QQSettingMeCoverPart;
import com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$profileCardObserver$2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.DrawerRandomCoverView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeCoverPart;", "Lcom/tencent/mobileqq/part/a;", "", "disableMove", "", "ea", "", "y", "ca", "", "height", "S9", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "Z9", NodeProps.VISIBLE, "X9", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPostThemeChanged", "onPartDestroy", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "viewStub", "Lcom/tencent/mobileqq/widget/DrawerRandomCoverView;", tl.h.F, "Lcom/tencent/mobileqq/widget/DrawerRandomCoverView;", "randomCoverView", "i", "I", "coverRequestTime", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "startShowMin", "Landroid/animation/ValueAnimator;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/ValueAnimator;", "animator", "D", "Z", "isVisible", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "E", "Lkotlin/Lazy;", "T9", "()Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "profileCardObserver", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQSettingMeCoverPart extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator animator;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isVisible;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy profileCardObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub viewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DrawerRandomCoverView randomCoverView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int coverRequestTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean startShowMin;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeCoverPart$a;", "", "", "COVER_REQUEST_COUNT_LIMITED_NR", "I", "", "TAG", "Ljava/lang/String;", "ZPLAN_BG_DEFAULT", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeCoverPart$b;", "Lcom/tencent/mobileqq/activity/qqsettingme/k;", "", "cover", "", "isNewCoverUrl", "", "onResult", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/bizParts/QQSettingMeCoverPart;", "Ljava/lang/ref/WeakReference;", "partRef", "part", "<init>", "(Lcom/tencent/mobileqq/bizParts/QQSettingMeCoverPart;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.activity.qqsettingme.k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<QQSettingMeCoverPart> partRef;

        public b(@Nullable QQSettingMeCoverPart qQSettingMeCoverPart) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeCoverPart);
            } else {
                this.partRef = new WeakReference<>(qQSettingMeCoverPart);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String str, QQSettingMeCoverPart this_apply, boolean z16) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            if (TextUtils.isEmpty(str) || this_apply.Y9()) {
                this_apply.X9(false);
            } else {
                this_apply.X9(true);
                DrawerRandomCoverView drawerRandomCoverView = this_apply.randomCoverView;
                if (drawerRandomCoverView != null) {
                    if (Intrinsics.areEqual(str, "qzone_zplan_bg")) {
                        drawerRandomCoverView.a().setImageDrawable(ex.c(R.drawable.nzw));
                    } else {
                        drawerRandomCoverView.c(str, z16, drawerRandomCoverView.getWidth(), drawerRandomCoverView.getHeight());
                    }
                }
            }
            ((QQSettingMeViewModel) this_apply.getViewModel(QQSettingMeViewModel.class)).f312699h0.postValue(Boolean.valueOf(this_apply.isVisible));
        }

        @Override // com.tencent.mobileqq.activity.qqsettingme.k
        public void a() {
            QQSettingMeCoverPart qQSettingMeCoverPart;
            QQSettingMeCoverPart qQSettingMeCoverPart2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("QQSettingMeCoverPart", 2, "onRequest");
            WeakReference<QQSettingMeCoverPart> weakReference = this.partRef;
            if (weakReference != null && (qQSettingMeCoverPart = weakReference.get()) != null) {
                int i3 = qQSettingMeCoverPart.coverRequestTime;
                WeakReference<QQSettingMeCoverPart> weakReference2 = this.partRef;
                if (weakReference2 != null) {
                    qQSettingMeCoverPart2 = weakReference2.get();
                } else {
                    qQSettingMeCoverPart2 = null;
                }
                if (qQSettingMeCoverPart2 != null) {
                    Intrinsics.checkNotNullExpressionValue(qQSettingMeCoverPart2, "get()");
                    qQSettingMeCoverPart2.coverRequestTime = i3 - 1;
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.qqsettingme.k
        public void onResult(@Nullable final String cover, final boolean isNewCoverUrl) {
            final QQSettingMeCoverPart qQSettingMeCoverPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cover, Boolean.valueOf(isNewCoverUrl));
                return;
            }
            QLog.i("QQSettingMeCoverPart", 2, "onResult cover:" + cover + " ,isNewCoverUrl:" + isNewCoverUrl);
            WeakReference<QQSettingMeCoverPart> weakReference = this.partRef;
            if (weakReference != null && (qQSettingMeCoverPart = weakReference.get()) != null) {
                qQSettingMeCoverPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.bizParts.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeCoverPart.b.c(cover, qQSettingMeCoverPart, isNewCoverUrl);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/bizParts/QQSettingMeCoverPart$c", "Lji3/m;", "", "a", "", "isSwitchOn", "onChange", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements ji3.m {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeCoverPart.this);
            }
        }

        @Override // ji3.m
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QQSettingMeCoverPart.aa(QQSettingMeCoverPart.this, null, 1, null);
            }
        }

        @Override // ji3.m
        public void onChange(boolean isSwitchOn) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, isSwitchOn);
            } else {
                QQSettingMeCoverPart.aa(QQSettingMeCoverPart.this, null, 1, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeCoverPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.coverRequestTime = 3;
        this.startShowMin = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQSettingMeCoverPart$profileCardObserver$2.a>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$profileCardObserver$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/bizParts/QQSettingMeCoverPart$profileCardObserver$2$a", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "", "isSuccess", "", "data", "", "onGetProfileCard", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a extends ProfileCardObserver {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQSettingMeCoverPart f200393d;

                a(QQSettingMeCoverPart qQSettingMeCoverPart) {
                    this.f200393d = qQSettingMeCoverPart;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeCoverPart);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(QQSettingMeCoverPart this$0, Object obj) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.Z9((Card) obj);
                }

                @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
                protected void onGetProfileCard(boolean isSuccess, @Nullable final Object data) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                        return;
                    }
                    QLog.i("QQSettingMeCoverPart", 2, "onGetProfileCard " + isSuccess + ", data:" + data);
                    if (data == null) {
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (isSuccess && peekAppRuntime != null && (data instanceof Card) && Intrinsics.areEqual(peekAppRuntime.getCurrentAccountUin(), ((Card) data).uin)) {
                        final QQSettingMeCoverPart qQSettingMeCoverPart = this.f200393d;
                        ThreadManagerV2.excute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: INVOKE 
                              (wrap:java.lang.Runnable:0x0063: CONSTRUCTOR 
                              (r6v4 'qQSettingMeCoverPart' com.tencent.mobileqq.bizParts.QQSettingMeCoverPart A[DONT_INLINE])
                              (r7v0 'data' java.lang.Object A[DONT_INLINE])
                             A[MD:(com.tencent.mobileqq.bizParts.QQSettingMeCoverPart, java.lang.Object):void (m), WRAPPED] (LINE:100) call: com.tencent.mobileqq.bizParts.m.<init>(com.tencent.mobileqq.bizParts.QQSettingMeCoverPart, java.lang.Object):void type: CONSTRUCTOR)
                              (16 int)
                              (null com.tencent.mobileqq.app.ThreadExcutor$IThreadListener)
                              true
                             STATIC call: com.tencent.mobileqq.app.ThreadManagerV2.excute(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void A[MD:(java.lang.Runnable, int, com.tencent.mobileqq.app.ThreadExcutor$IThreadListener, boolean):void (m)] (LINE:106) in method: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$profileCardObserver$2.a.onGetProfileCard(boolean, java.lang.Object):void, file: classes11.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.bizParts.m, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 31 more
                            */
                        /*
                            this = this;
                            com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$profileCardObserver$2.a.$redirector_
                            r1 = 1
                            r2 = 2
                            if (r0 == 0) goto L1e
                            boolean r3 = r0.hasPatch(r2)
                            if (r3 == 0) goto L1e
                            r3 = 3
                            java.lang.Object[] r3 = new java.lang.Object[r3]
                            r4 = 0
                            r3[r4] = r5
                            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                            r3[r1] = r6
                            r3[r2] = r7
                            r0.redirect(r2, r3)
                            return
                        L1e:
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            java.lang.String r3 = "onGetProfileCard "
                            r0.append(r3)
                            r0.append(r6)
                            java.lang.String r3 = ", data:"
                            r0.append(r3)
                            r0.append(r7)
                            java.lang.String r0 = r0.toString()
                            java.lang.String r3 = "QQSettingMeCoverPart"
                            com.tencent.qphone.base.util.QLog.i(r3, r2, r0)
                            if (r7 != 0) goto L42
                            return
                        L42:
                            mqq.app.MobileQQ r0 = mqq.app.MobileQQ.sMobileQQ
                            mqq.app.AppRuntime r0 = r0.peekAppRuntime()
                            if (r6 == 0) goto L6c
                            if (r0 == 0) goto L6c
                            boolean r6 = r7 instanceof com.tencent.mobileqq.data.Card
                            if (r6 == 0) goto L6c
                            java.lang.String r6 = r0.getCurrentAccountUin()
                            r0 = r7
                            com.tencent.mobileqq.data.Card r0 = (com.tencent.mobileqq.data.Card) r0
                            java.lang.String r0 = r0.uin
                            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
                            if (r6 == 0) goto L6c
                            com.tencent.mobileqq.bizParts.QQSettingMeCoverPart r6 = r5.f200393d
                            com.tencent.mobileqq.bizParts.m r0 = new com.tencent.mobileqq.bizParts.m
                            r0.<init>(r6, r7)
                            r6 = 16
                            r7 = 0
                            com.tencent.mobileqq.app.ThreadManagerV2.excute(r0, r6, r7, r1)
                        L6c:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$profileCardObserver$2.a.onGetProfileCard(boolean, java.lang.Object):void");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeCoverPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(QQSettingMeCoverPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.profileCardObserver = lazy;
        }

        private final void S9(int height) {
            DrawerRandomCoverView drawerRandomCoverView = this.randomCoverView;
            if (drawerRandomCoverView != null) {
                ViewGroup.LayoutParams layoutParams = drawerRandomCoverView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.width = -1;
                layoutParams2.height = height;
                drawerRandomCoverView.setLayoutParams(layoutParams2);
            }
        }

        private final ProfileCardObserver T9() {
            return (ProfileCardObserver) this.profileCardObserver.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void U9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void V9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void W9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X9(boolean visible) {
            int i3;
            View view;
            this.isVisible = visible;
            if (visible && this.randomCoverView == null) {
                ViewStub viewStub = this.viewStub;
                DrawerRandomCoverView drawerRandomCoverView = null;
                if (viewStub != null) {
                    view = viewStub.inflate();
                } else {
                    view = null;
                }
                if (view instanceof DrawerRandomCoverView) {
                    drawerRandomCoverView = (DrawerRandomCoverView) view;
                }
                this.randomCoverView = drawerRandomCoverView;
            }
            DrawerRandomCoverView drawerRandomCoverView2 = this.randomCoverView;
            if (drawerRandomCoverView2 != null) {
                if (visible) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                drawerRandomCoverView2.setVisibility(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean Y9() {
            return de.f307628a.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Z9(Card card) {
            Object[] objArr;
            Object obj;
            String str;
            if (Y9()) {
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.bizParts.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeCoverPart.ba(QQSettingMeCoverPart.this);
                    }
                });
                return;
            }
            boolean z16 = false;
            Boolean bool = null;
            if (card != null) {
                objArr = card.getCoverData(0);
            } else {
                objArr = null;
            }
            if (objArr != null) {
                obj = objArr[0];
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeCoverPart", 2, "[getCoverData] getCovertUrl from net,url:" + str);
            }
            b bVar = new b(this);
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("card.isNoCover()=");
                    if (card != null) {
                        bool = Boolean.valueOf(card.isNoCover());
                    }
                    sb5.append(bool);
                    QLog.d("QQSettingMeCoverPart", 2, sb5.toString());
                }
                ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getCover(card, bVar);
                return;
            }
            IQQSettingMeApi iQQSettingMeApi = (IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class);
            if (this.coverRequestTime > 0) {
                z16 = true;
            }
            iQQSettingMeApi.getCover(bVar, z16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void aa(QQSettingMeCoverPart qQSettingMeCoverPart, Card card, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                card = null;
            }
            qQSettingMeCoverPart.Z9(card);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void ba(QQSettingMeCoverPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.X9(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void ca(float y16) {
            int coerceAtLeast;
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            int Q1 = qQSettingMeViewModel.Q1();
            if (qQSettingMeViewModel.f312702j0 == 0) {
                if (this.startShowMin.compareAndSet(false, true)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(((int) y16) + ScreenUtil.dip2px(24.0f), Q1);
                    this.animator = ofInt;
                    if (ofInt != null) {
                        ofInt.setDuration(200L);
                    }
                    ValueAnimator valueAnimator = this.animator;
                    if (valueAnimator != null) {
                        valueAnimator.setInterpolator(new DecelerateInterpolator(0.5f));
                    }
                    ValueAnimator valueAnimator2 = this.animator;
                    if (valueAnimator2 != null) {
                        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.bizParts.i
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                                QQSettingMeCoverPart.da(QQSettingMeCoverPart.this, valueAnimator3);
                            }
                        });
                    }
                    ValueAnimator valueAnimator3 = this.animator;
                    if (valueAnimator3 != null) {
                        valueAnimator3.start();
                        return;
                    }
                    return;
                }
                return;
            }
            this.startShowMin.set(false);
            ValueAnimator valueAnimator4 = this.animator;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (y16 + 0.5d), com.tencent.mobileqq.activity.qqsettingme.utils.b.b());
            S9(coerceAtLeast + ex.d(Float.valueOf(24.0f)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void da(QQSettingMeCoverPart this$0, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            this$0.S9(((Integer) animatedValue).intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void ea(boolean disableMove) {
            DrawerRandomCoverView drawerRandomCoverView = this.randomCoverView;
            if (drawerRandomCoverView != null) {
                final QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
                if (disableMove) {
                    drawerRandomCoverView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QQSettingMeCoverPart.ga(QQSettingMeViewModel.this, view);
                        }
                    });
                    drawerRandomCoverView.setContentDescription(getActivity().getString(R.string.ztg));
                } else {
                    drawerRandomCoverView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QQSettingMeCoverPart.ha(QQSettingMeViewModel.this, view);
                        }
                    });
                    DrawerUtils.f306948a.o(drawerRandomCoverView, true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void ga(QQSettingMeViewModel qQSettingMeViewModel, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("QQSettingMeCoverPart")) {
                qQSettingMeViewModel.N1("d_nickname").onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void ha(QQSettingMeViewModel qQSettingMeViewModel, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("QQSettingMeCoverPart")) {
                qQSettingMeViewModel.f312693b0.postValue(3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void onInitView(@Nullable View rootView) {
            ViewStub viewStub;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
                return;
            }
            super.onInitView(rootView);
            if (rootView != null) {
                viewStub = (ViewStub) rootView.findViewById(R.id.f1192276_);
            } else {
                viewStub = null;
            }
            this.viewStub = viewStub;
            aa(this, null, 1, null);
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
                return;
            }
            super.onPartCreate(activity, savedInstanceState);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                appInterface.addObserver(T9());
            }
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.f312697f0;
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$onPartCreate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeCoverPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                        return;
                    }
                    if (num != null && num.intValue() == 0) {
                        QQSettingMeCoverPart.aa(QQSettingMeCoverPart.this, null, 1, null);
                    } else if (num != null && num.intValue() == 1) {
                        QQSettingMeCoverPart.this.X9(false);
                    }
                }
            };
            mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQSettingMeCoverPart.U9(Function1.this, obj);
                }
            });
            MutableLiveData<Float> T1 = qQSettingMeViewModel.T1();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<Float, Unit> function12 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$onPartCreate$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeCoverPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke2(f16);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Float y16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) y16);
                        return;
                    }
                    QQSettingMeCoverPart qQSettingMeCoverPart = QQSettingMeCoverPart.this;
                    Intrinsics.checkNotNullExpressionValue(y16, "y");
                    qQSettingMeCoverPart.ca(y16.floatValue());
                }
            };
            T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQSettingMeCoverPart.V9(Function1.this, obj);
                }
            });
            MutableLiveData<Integer> mutableLiveData2 = qQSettingMeViewModel.f312695d0;
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeCoverPart$onPartCreate$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeCoverPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQSettingMeCoverPart.this.ea(num != null && num.intValue() == 0);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    }
                }
            };
            mutableLiveData2.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.bizParts.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQSettingMeCoverPart.W9(Function1.this, obj);
                }
            });
            QRouteApi api = QRoute.api(IZPlanApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
            ((IZPlanApi) api).setOnZPlanSettingChangeListener(1004L, new c());
        }

        @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
        public void onPartDestroy(@Nullable Activity activity) {
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            super.onPartDestroy(activity);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                appInterface.removeObserver(T9());
            }
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void onPartResume(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                super.onPartResume(activity);
                aa(this, null, 1, null);
            }
        }

        @Override // com.tencent.mobileqq.part.a
        public void onPostThemeChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                super.onPostThemeChanged();
                aa(this, null, 1, null);
            }
        }
    }
