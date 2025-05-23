package com.tencent.mobileqq.qqlive.sail.ui.tophead;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.room.displayview.horizontal.b;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.ui.orientation.OrientationViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.head.AnchorTopHeadView;
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
import tl.h;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010#R\u0018\u00108\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010+R\u0018\u0010:\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010#R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010K\u001a\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/QQLiveTopHeadPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "", "Fa", "wa", "Da", "Ea", "za", "Aa", "sa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "X9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onPartResume", "V9", "", "args", "W9", "U9", "e", "Landroid/view/View;", "statusBar", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivBack", "Landroid/view/ViewStub;", h.F, "Landroid/view/ViewStub;", "fansQQGroupViewStub", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "i", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "topHeadView", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/liveroom/impl/room/toparea/b;", "topViewModel", BdhLogUtil.LogTag.Tag_Conn, "fansQQGroupButton", "D", "topHeadLandscapeBgViewStub", "E", "topHeadLandscapeBg", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "topHeadContainer", "", "G", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "H", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "autoCollapseTopHead", "I", "autoCollapseTopHeadBg", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "J", "Lkotlin/Lazy;", "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", "K", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/OrientationViewModel;", "orientationViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/e;", "L", "va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/e;", "topHeadViewModel", "<init>", "()V", "M", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveTopHeadPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View fansQQGroupButton;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewStub topHeadLandscapeBgViewStub;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View topHeadLandscapeBg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ViewGroup topHeadContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.displayview.horizontal.b autoCollapseTopHead;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.displayview.horizontal.b autoCollapseTopHeadBg;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy orientationViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy topHeadViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View statusBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub fansQQGroupViewStub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorTopHeadView topHeadView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.toparea.b topViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/tophead/QQLiveTopHeadPart$a;", "", "", "KEY_IS_CLICK_ANCHOR_INFO_CARD_AVATAR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/tophead/QQLiveTopHeadPart$b", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$b;", "", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements b.InterfaceC8369b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTopHeadPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.InterfaceC8369b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QQLiveTopHeadPart.this.va().M1(true);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.InterfaceC8369b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QQLiveTopHeadPart.this.va().M1(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveTopHeadPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.topViewModel = new com.tencent.timi.game.liveroom.impl.room.toparea.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTopHeadPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveTopHeadPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<OrientationViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart$orientationViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTopHeadPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OrientationViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (OrientationViewModel) QQLiveTopHeadPart.this.getViewModel(OrientationViewModel.class) : (OrientationViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.orientationViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart$topHeadViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTopHeadPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (e) QQLiveTopHeadPart.this.getViewModel(e.class) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.topHeadViewModel = lazy3;
    }

    private final void Aa() {
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar = this.autoCollapseTopHead;
        if (bVar != null) {
            bVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(QQLiveTopHeadPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ta().L1(OrientationViewModel.RequestedOrientation.PORTRAIT);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Da() {
        View view;
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.topHeadLandscapeBg == null) {
            ViewStub viewStub = this.topHeadLandscapeBgViewStub;
            if (viewStub != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            this.topHeadLandscapeBg = view;
        }
        ViewStub viewStub2 = this.topHeadLandscapeBgViewStub;
        if (viewStub2 != null) {
            viewStub2.setVisibility(0);
        }
        View view2 = this.fansQQGroupButton;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.statusBar;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    private final void Ea() {
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ViewStub viewStub = this.topHeadLandscapeBgViewStub;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        View view = this.fansQQGroupButton;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.statusBar;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private final void Fa() {
        AnchorTopHeadView anchorTopHeadView = this.topHeadView;
        if (anchorTopHeadView != null) {
            anchorTopHeadView.Q(B9(), A9());
            anchorTopHeadView.onPreload(H9(), false, null);
        }
    }

    private final void sa() {
        AnchorTopHeadView anchorTopHeadView = this.topHeadView;
        if (anchorTopHeadView != null) {
            anchorTopHeadView.onExitRoom(H9());
            anchorTopHeadView.onPageOut(H9());
            anchorTopHeadView.X();
        }
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar = this.autoCollapseTopHead;
        if (bVar != null) {
            bVar.m();
        }
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar2 = this.autoCollapseTopHeadBg;
        if (bVar2 != null) {
            bVar2.m();
        }
        this.autoCollapseTopHead = null;
        this.autoCollapseTopHeadBg = null;
    }

    private final OrientationViewModel ta() {
        Object value = this.orientationViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-orientationViewModel>(...)");
        return (OrientationViewModel) value;
    }

    private final RoomViewModel ua() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e va() {
        Object value = this.topHeadViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topHeadViewModel>(...)");
        return (e) value;
    }

    private final void wa() {
        LiveData<rr4.e> w3 = this.topViewModel.w();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQLiveTopHeadPart$observeFansQQGroup$1 qQLiveTopHeadPart$observeFansQQGroup$1 = new QQLiveTopHeadPart$observeFansQQGroup$1(this);
        w3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTopHeadPart.xa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void za() {
        if (this.autoCollapseTopHead == null) {
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar = new com.tencent.mobileqq.qqlive.room.displayview.horizontal.b();
            bVar.n(this.topHeadContainer, null);
            bVar.o(new b());
            this.autoCollapseTopHead = bVar;
        }
        if (this.autoCollapseTopHeadBg == null) {
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar2 = new com.tencent.mobileqq.qqlive.room.displayview.horizontal.b();
            this.autoCollapseTopHeadBg = bVar2;
            bVar2.n(this.topHeadLandscapeBg, null);
        }
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar3 = this.autoCollapseTopHead;
        if (bVar3 != null) {
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.q(bVar3, wi2.c.b(12), 0, 2, null);
        }
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar4 = this.autoCollapseTopHeadBg;
        if (bVar4 != null) {
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.q(bVar4, 0, 0, 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        uq4.d dVar;
        AnchorTopHeadView anchorTopHeadView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        uq4.c a16 = updater.a();
        if (a16 != null && (dVar = a16.f439827b) != null) {
            boolean z16 = dVar.f439831a;
            if (updater.b() == H9() && (anchorTopHeadView = this.topHeadView) != null) {
                anchorTopHeadView.Y(z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("room_info|QQLiveTopHeadPart", "onPartCreate", "roomId=" + H9());
        f F9 = F9();
        if (F9 != null) {
            startInit();
            long roomId = F9.getRoomId();
            AnchorTopHeadView anchorTopHeadView = this.topHeadView;
            String str = null;
            if (anchorTopHeadView != null) {
                anchorTopHeadView.onPageIn(roomId);
                com.tencent.timi.game.liveroom.impl.room.toparea.b bVar = this.topViewModel;
                f F92 = F9();
                if (F92 != null && (b16 = F92.b()) != null) {
                    str = b16.f();
                }
                bVar.r0(str);
                anchorTopHeadView.onEnterRoom(roomId, Q9());
                BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
                if (busConfigHelper.j().get(Long.valueOf(roomId)) != null) {
                    anchorTopHeadView.Y(busConfigHelper.d(roomId));
                }
            } else {
                anchorTopHeadView = null;
            }
            if (anchorTopHeadView != null) {
                return;
            }
        }
        companion.e("room_info|QQLiveTopHeadPart", "onPartCreate", "no room");
        Unit unit = Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            sa();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void W9(@Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, args);
        } else {
            if ((args instanceof Long) && !Intrinsics.areEqual(args, (Object) 0L) && !Intrinsics.areEqual(args, Long.valueOf(H9()))) {
                return;
            }
            super.W9(args);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void X9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (H9() > 0) {
            startInit();
            Fa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.f61632yn;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
            return;
        }
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLandscape = z16;
        AnchorTopHeadView anchorTopHeadView = this.topHeadView;
        if (anchorTopHeadView != null) {
            anchorTopHeadView.P(z16);
        }
        if (this.isLandscape) {
            Da();
            za();
        } else {
            Ea();
            Aa();
        }
        kk4.a.INSTANCE.a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        ImageView imageView;
        AnchorTopHeadView anchorTopHeadView;
        ViewStub viewStub;
        ViewStub viewStub2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        ViewGroup viewGroup = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f88244wj);
        } else {
            view = null;
        }
        this.statusBar = view;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f61592yj);
        } else {
            imageView = null;
        }
        this.ivBack = imageView;
        if (rootView != null) {
            anchorTopHeadView = (AnchorTopHeadView) rootView.findViewById(R.id.f61622ym);
        } else {
            anchorTopHeadView = null;
        }
        this.topHeadView = anchorTopHeadView;
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f60642vz);
        } else {
            viewStub = null;
        }
        this.fansQQGroupViewStub = viewStub;
        if (rootView != null) {
            viewStub2 = (ViewStub) rootView.findViewById(R.id.f61612yl);
        } else {
            viewStub2 = null;
        }
        this.topHeadLandscapeBgViewStub = viewStub2;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f61632yn);
        }
        this.topHeadContainer = viewGroup;
        ImageView imageView2 = this.ivBack;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLiveTopHeadPart.Ba(QQLiveTopHeadPart.this, view2);
                }
            });
        }
        MutableLiveData<Boolean> e26 = ua().e2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.QQLiveTopHeadPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTopHeadPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                boolean z16;
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar;
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                z16 = QQLiveTopHeadPart.this.isLandscape;
                if (z16) {
                    bVar = QQLiveTopHeadPart.this.autoCollapseTopHead;
                    if (bVar != null) {
                        bVar.l();
                    }
                    bVar2 = QQLiveTopHeadPart.this.autoCollapseTopHeadBg;
                    if (bVar2 != null) {
                        bVar2.l();
                    }
                }
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.tophead.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTopHeadPart.Ca(Function1.this, obj);
            }
        });
        AnchorTopHeadView anchorTopHeadView2 = this.topHeadView;
        if (anchorTopHeadView2 != null) {
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "this@QQLiveTopHeadPart.partHost.hostLifecycleOwner");
            anchorTopHeadView2.setLifecycle(lifecycleOwner2);
            anchorTopHeadView2.setViewModel(this.topViewModel);
            anchorTopHeadView2.setQQLive();
            anchorTopHeadView2.setRoomType(0);
        }
        wa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            sa();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        AnchorTopHeadView anchorTopHeadView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else if (rm4.a.b("is_click_anchor_info_card_avatar", false) && (anchorTopHeadView = this.topHeadView) != null) {
            anchorTopHeadView.Z();
        }
    }
}
