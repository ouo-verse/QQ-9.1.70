package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.OrientationViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveVideoOverlayPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "", "Ca", "", "sa", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", NodeProps.ON_CLICK, "U9", "V9", "e", "Z", "isUIPortrait", "f", "isVideoLandscape", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", tl.h.F, "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "autoCollapseController", "i", "Landroid/view/View;", "overlayRoot", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fullscreenBtn", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "definitionBtn", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "D", "Lkotlin/Lazy;", "wa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "E", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", UserInfo.SEX_FEMALE, "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", "orientationViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "G", "va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "pkViewModel", "<init>", "()V", "H", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveVideoOverlayPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView definitionBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy orientationViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy pkViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isUIPortrait;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoLandscape;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.room.displayview.horizontal.b autoCollapseController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View overlayRoot;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View fullscreenBtn;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveVideoOverlayPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveVideoOverlayPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isUIPortrait = true;
        this.autoCollapseController = new com.tencent.mobileqq.qqlive.room.displayview.horizontal.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveVideoOverlayPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.definition.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$definitionViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.definition.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.definition.a) QQLiveVideoOverlayPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.definition.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.definitionViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<OrientationViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$orientationViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OrientationViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (OrientationViewModel) QQLiveVideoOverlayPart.this.getViewModel(OrientationViewModel.class) : (OrientationViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.orientationViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$pkViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) QQLiveVideoOverlayPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e.class) : (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.pkViewModel = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca() {
        if (sa()) {
            startInit();
            View view = this.overlayRoot;
            if (view != null) {
                view.setVisibility(0);
            }
            ImageView imageView = this.definitionBtn;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.definitionBtn;
            if (imageView2 != null) {
                imageView2.setImageResource(ta().P1());
            }
            this.autoCollapseController.n(null, this.overlayRoot);
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.q(this.autoCollapseController, 0, 0, 3, null);
            return;
        }
        View view2 = this.overlayRoot;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final boolean sa() {
        if (this.isUIPortrait && this.isVideoLandscape && R9()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.definition.a ta() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.definition.a) value;
    }

    private final OrientationViewModel ua() {
        Object value = this.orientationViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-orientationViewModel>(...)");
        return (OrientationViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e va() {
        Object value = this.pkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pkViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) value;
    }

    private final RoomViewModel wa() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.U9();
            Ca();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.V9();
            this.autoCollapseController.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f61682ys;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.cpt) {
                ua().L1(OrientationViewModel.RequestedOrientation.LANDSCAPE);
            } else if (num != null && num.intValue() == R.id.ufs) {
                ta().X1(true);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
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
            boolean z16 = true;
            if (configuration.orientation != 1) {
                z16 = false;
            }
            this.isUIPortrait = z16;
            Ca();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        ImageView imageView2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.ydh);
        } else {
            view = null;
        }
        this.overlayRoot = view;
        if (rootView != null && (view2 = rootView.findViewById(R.id.cpt)) != null) {
            view2.setOnClickListener(this);
        } else {
            view2 = null;
        }
        this.fullscreenBtn = view2;
        if (rootView != null && (imageView = (ImageView) rootView.findViewById(R.id.ufs)) != null) {
            imageView.setOnClickListener(this);
            imageView2 = imageView;
        }
        this.definitionBtn = imageView2;
        MutableLiveData<Boolean> e26 = wa().e2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                } else {
                    bVar = QQLiveVideoOverlayPart.this.autoCollapseController;
                    bVar.l();
                }
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveVideoOverlayPart.xa(Function1.this, obj);
            }
        });
        LiveData<StreamDefinition> R1 = ta().R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<StreamDefinition, Unit> function12 = new Function1<StreamDefinition, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$onInitView$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StreamDefinition streamDefinition) {
                invoke2(streamDefinition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StreamDefinition streamDefinition) {
                ImageView imageView3;
                com.tencent.mobileqq.qqlive.sail.ui.definition.a ta5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) streamDefinition);
                    return;
                }
                imageView3 = QQLiveVideoOverlayPart.this.definitionBtn;
                if (imageView3 != null) {
                    ta5 = QQLiveVideoOverlayPart.this.ta();
                    imageView3.setImageResource(ta5.P1());
                }
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveVideoOverlayPart.za(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> M1 = va().M1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit> function13 = new Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$onInitView$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                View view3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar.b()) {
                    QQLiveVideoOverlayPart.this.Ca();
                    return;
                }
                view3 = QQLiveVideoOverlayPart.this.overlayRoot;
                if (view3 == null) {
                    return;
                }
                view3.setVisibility(8);
            }
        };
        M1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveVideoOverlayPart.Aa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Size> d26 = wa().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function1 = new Function1<Size, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveVideoOverlayPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveVideoOverlayPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size size) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) size);
                    return;
                }
                QQLiveVideoOverlayPart.this.isVideoLandscape = size.getWidth() > size.getHeight();
                QQLiveVideoOverlayPart.this.Ca();
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveVideoOverlayPart.Ba(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            this.autoCollapseController.m();
        }
    }
}
