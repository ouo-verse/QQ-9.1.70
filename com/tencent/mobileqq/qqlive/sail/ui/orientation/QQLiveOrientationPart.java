package com.tencent.mobileqq.qqlive.sail.ui.orientation;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.OrientationViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.a;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.utils.v;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/QQLiveOrientationPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/a$a;", "", "va", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "U9", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "orientation", DomainData.DOMAIN_NAME, "Landroidx/constraintlayout/widget/Group;", "e", "Landroidx/constraintlayout/widget/Group;", "guidelineGroup", "Landroid/util/Size;", "f", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", h.F, "Lkotlin/Lazy;", "oa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", "orientationViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "i", "pa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "pkViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveOrientationPart extends com.tencent.mobileqq.qqlive.sail.base.c implements a.InterfaceC8398a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group guidelineGroup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Size videoSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy orientationViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pkViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/QQLiveOrientationPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveOrientationPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoSize = new Size(0, 0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OrientationViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$orientationViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OrientationViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (OrientationViewModel) QQLiveOrientationPart.this.getViewModel(OrientationViewModel.class) : (OrientationViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.orientationViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$pkViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) QQLiveOrientationPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e.class) : (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.pkViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveOrientationPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy3;
    }

    private final OrientationViewModel oa() {
        Object value = this.orientationViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-orientationViewModel>(...)");
        return (OrientationViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e pa() {
        Object value = this.pkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pkViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) value;
    }

    private final RoomViewModel qa() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(QQLiveOrientationPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(i3);
            return;
        }
        AegisLogger.INSTANCE.w("Audience|QQLiveOrientationPart", "onChangeOrientation", "roomId=" + this$0.H9() + ", activity is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        if (!R9()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "tryStartCheckOrientation", "roomId=" + H9() + ", no enter room");
            return;
        }
        if (this.videoSize.getWidth() <= this.videoSize.getHeight()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "tryStartCheckOrientation", "roomId=" + H9() + ", invalid size,  w=" + this.videoSize.getWidth() + ", h=" + this.videoSize.getHeight());
            a.f272983a.k(H9());
            return;
        }
        com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a value = pa().M1().getValue();
        boolean z16 = false;
        if (value != null && value.b()) {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "tryWatchOrientation", "roomId=" + H9() + ", is linking screen");
            a.f272983a.k(H9());
            return;
        }
        if (a.f272983a.j(H9(), this)) {
            AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "tryWatchOrientation", "roomId=" + H9() + ", watch orientation");
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "tryWatchOrientation", "roomId=" + H9() + ", do not watch orientation");
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.U9();
            va();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.V9();
            a.f272983a.k(H9());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.orientation.a.InterfaceC8398a
    public void n(final int orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, orientation);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "onChangeOrientation", "roomId=" + H9() + ", orientation=" + orientation);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.e
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveOrientationPart.ra(QQLiveOrientationPart.this, orientation);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                v.c(getActivity().getWindow().getDecorView());
                Group group = this.guidelineGroup;
                if (group != null) {
                    group.setVisibility(8);
                    return;
                }
                return;
            }
            v.a(getActivity().getWindow().getDecorView());
            Group group2 = this.guidelineGroup;
            if (group2 != null) {
                group2.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Group group;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            group = (Group) rootView.findViewById(R.id.f61532yd);
        } else {
            group = null;
        }
        this.guidelineGroup = group;
        if (group != null) {
            group.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onPartStart(activity);
        MutableLiveData<Size> d26 = qa().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function1 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$onPartStart$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveOrientationPart qQLiveOrientationPart = QQLiveOrientationPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveOrientationPart.videoSize = it;
                QQLiveOrientationPart.this.va();
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveOrientationPart.sa(Function1.this, obj);
            }
        });
        LiveData<OrientationViewModel.RequestedOrientation> M1 = oa().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<OrientationViewModel.RequestedOrientation, Unit> function12 = new Function1<OrientationViewModel.RequestedOrientation, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$onPartStart$2
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes17.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f272982a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52642);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[OrientationViewModel.RequestedOrientation.values().length];
                    try {
                        iArr[OrientationViewModel.RequestedOrientation.LANDSCAPE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OrientationViewModel.RequestedOrientation.PORTRAIT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[OrientationViewModel.RequestedOrientation.OPPOSITE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f272982a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrientationViewModel.RequestedOrientation requestedOrientation) {
                invoke2(requestedOrientation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OrientationViewModel.RequestedOrientation requestedOrientation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) requestedOrientation);
                    return;
                }
                int i3 = requestedOrientation == null ? -1 : a.f272982a[requestedOrientation.ordinal()];
                if (i3 == 1) {
                    QQLiveOrientationPart.this.n(0);
                    return;
                }
                if (i3 == 2) {
                    QQLiveOrientationPart.this.n(1);
                    return;
                }
                if (i3 != 3) {
                    AegisLogger.INSTANCE.w("Audience|QQLiveOrientationPart", "changeOrientation", "invalid orientation, " + requestedOrientation);
                    return;
                }
                QQLiveOrientationPart.this.n(QQLiveOrientationPart.this.getContext().getResources().getConfiguration().orientation == 2 ? 1 : 0);
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveOrientationPart.ta(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> M12 = pa().M1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit> function13 = new Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.QQLiveOrientationPart$onPartStart$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveOrientationPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveOrientationPart", "showLinkChanged", "roomId=" + QQLiveOrientationPart.this.H9() + ", showLink=" + aVar);
                if (!aVar.b()) {
                    QQLiveOrientationPart.this.va();
                    return;
                }
                a.f272983a.k(QQLiveOrientationPart.this.H9());
                if ((QQLiveOrientationPart.this.getContext().getResources().getConfiguration().orientation == 1) || !QQLiveOrientationPart.this.R9()) {
                    return;
                }
                QQLiveOrientationPart.this.n(1);
            }
        };
        M12.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.orientation.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveOrientationPart.ua(Function1.this, obj);
            }
        });
    }
}
