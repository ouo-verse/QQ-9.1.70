package com.tencent.mobileqq.qqlive.sail.ui.pendant;

import android.content.res.Configuration;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.tophead.e;
import com.tencent.qqlive.common.api.AegisLogger;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/pendant/QQLivePendantPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sa", "ta", "xa", "Landroid/widget/FrameLayout;", "pa", "", MiniChatConstants.MINI_APP_LANDSCAPE, "za", "ra", "onInitView", "", "getInitRelyViewStubId", "U9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "V9", "e", "Z", "isVideoLandscape", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "topPendantView", h.F, "bottomPendantView", "Lcom/tencent/mobileqq/qqlive/room/pendant/a;", "i", "Lcom/tencent/mobileqq/qqlive/room/pendant/a;", "pendantManager", "Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "qa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/e;", "topHeadViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", BdhLogUtil.LogTag.Tag_Conn, "oa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "inputViewModel", "<init>", "()V", "D", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePendantPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoLandscape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup topPendantView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bottomPendantView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.room.pendant.a pendantManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topHeadViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/pendant/QQLivePendantPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePendantPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pendantManager = new com.tencent.mobileqq.qqlive.room.pendant.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$topHeadViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePendantPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (e) QQLivePendantPart.this.getViewModel(e.class) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.topHeadViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.input.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$inputViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePendantPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.input.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.input.a) QQLivePendantPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.input.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.input.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.inputViewModel = lazy2;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.input.a oa() {
        Object value = this.inputViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.input.a) value;
    }

    private final FrameLayout pa() {
        ViewGroup viewGroup = this.bottomPendantView;
        if (viewGroup != null) {
            return (FrameLayout) viewGroup.findViewById(R.id.f235806t);
        }
        return null;
    }

    private final e qa() {
        Object value = this.topHeadViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topHeadViewModel>(...)");
        return (e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        boolean z16;
        boolean c16 = com.tencent.timi.game.liveroom.impl.room.util.a.c(getContext());
        AegisLogger.INSTANCE.i("room_info|QQLivePendantPart", "hideRightBottomPendentIfNeed", "videoLandscape=" + this.isVideoLandscape + ", isFolderScreenOpen=" + c16);
        com.tencent.mobileqq.qqlive.room.pendant.a aVar = this.pendantManager;
        if (this.isVideoLandscape && c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.g(z16);
    }

    private final void sa(View rootView) {
        ViewGroup viewGroup;
        if (rootView instanceof ViewGroup) {
            View inflate = ((ViewStub) ((ViewGroup) rootView).findViewById(R.id.f61202xh)).inflate();
            if (inflate instanceof ViewGroup) {
                viewGroup = (ViewGroup) inflate;
            } else {
                viewGroup = null;
            }
            this.bottomPendantView = viewGroup;
        }
    }

    private final void ta() {
        View view;
        MutableLiveData<Size> d26;
        f F9 = F9();
        if (F9 == null) {
            AegisLogger.INSTANCE.i("room_info|QQLivePendantPart", "init pendant", "room id is 0!");
            com.tencent.mobileqq.qqlive.framework.c.e(new IllegalAccessException("pendant init but room id is 0!"));
            return;
        }
        this.pendantManager.t(F9.getRoomId()).r(C9()).u(F9.b().getRoomType()).s(pa());
        com.tencent.mobileqq.qqlive.room.pendant.a aVar = this.pendantManager;
        ViewGroup viewGroup = this.topPendantView;
        View view2 = null;
        if (viewGroup != null) {
            view = viewGroup.findViewById(R.id.f236106w);
        } else {
            view = null;
        }
        gk4.b E = aVar.E(view);
        ViewGroup viewGroup2 = this.topPendantView;
        if (viewGroup2 != null) {
            view2 = viewGroup2.findViewById(R.id.f236006v);
        }
        E.F(view2).h();
        RoomViewModel roomViewModel = (RoomViewModel) getViewModel(RoomViewModel.class);
        if (roomViewModel != null && (d26 = roomViewModel.d2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Size, Unit> function1 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$initPendant$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePendantPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                    invoke2(size);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Size size) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) size);
                        return;
                    }
                    AegisLogger.INSTANCE.i("room_info|QQLivePendantPart", "initPendant", "video size changed, width=" + size.getWidth() + ", height=" + size.getHeight());
                    QQLivePendantPart.this.isVideoLandscape = size.getWidth() > size.getHeight();
                    QQLivePendantPart.this.ra();
                }
            };
            d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLivePendantPart.ua(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xa() {
        this.pendantManager.w();
    }

    private final void za(boolean isLandscape) {
        this.pendantManager.m(isLandscape);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (F9() != null) {
            startInit();
            ta();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("room_info|QQLivePendantPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f61212xi;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        boolean z16 = false;
        if (configuration != null && configuration.orientation == 2) {
            z16 = true;
        }
        za(z16);
        ra();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f61212xi);
        } else {
            viewGroup = null;
        }
        this.topPendantView = viewGroup;
        sa(rootView);
        LiveData<Boolean> L1 = qa().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePendantPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.qqlive.room.pendant.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                } else {
                    aVar = QQLivePendantPart.this.pendantManager;
                    aVar.q(!bool.booleanValue());
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePendantPart.va(Function1.this, obj);
            }
        });
        LiveData<Boolean> L12 = oa().L1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.QQLivePendantPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePendantPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.qqlive.room.pendant.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                } else {
                    aVar = QQLivePendantPart.this.pendantManager;
                    aVar.q(!bool.booleanValue());
                }
            }
        };
        L12.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.pendant.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePendantPart.wa(Function1.this, obj);
            }
        });
    }
}
