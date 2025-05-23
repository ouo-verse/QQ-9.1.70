package com.tencent.mobileqq.aio.reserve1.toptip;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import at.e;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.TipsBar;
import com.tencent.qqnt.aio.utils.TipsBarAnimatorUtilsKt;
import com.tencent.qqnt.aio.utils.ag;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\n,-./012345B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001b\u0010\"\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001b\u0010%\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "", "l1", "Landroid/view/View;", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "state", "k1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "d1", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "topContainer", "Landroid/view/ViewGroup;", "e", "Lkotlin/Lazy;", "f1", "()Landroid/view/ViewGroup;", "customBarContainer", "f", "h1", "topTipsContainer", h.F, "j1", "troopToDOContainer", "i", "i1", "totalContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g1", "msgBoxContainer", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isViewAdded", "<init>", "()V", "HideMsgBoxState", "HideTopTipState", "RemoveCustomBarState", "RemoveTroopTODOBarState", "ReplaceTopTipState", "SetTopPadding", "ShowCustomBarState", "ShowMsgBoxState", "ShowTopTipState", "ShowTroopTODOBarState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTopTipContainerVB extends com.tencent.aio.base.mvvm.a<e, TopTipViewState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isViewAdded;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout topContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy customBarContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topTipsContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopToDOContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy totalContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgBoxContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$HideMsgBoxState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class HideMsgBoxState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        public HideMsgBoxState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$HideTopTipState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "", "d", "Z", "a", "()Z", "needAnim", "<init>", "(Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class HideTopTipState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean needAnim;

        public HideTopTipState(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.needAnim = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.needAnim;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$RemoveCustomBarState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class RemoveCustomBarState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RemoveCustomBarState f193389d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64772);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f193389d = new RemoveCustomBarState();
            }
        }

        RemoveCustomBarState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$RemoveTroopTODOBarState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class RemoveTroopTODOBarState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public RemoveTroopTODOBarState(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.view;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$ReplaceTopTipState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Lcom/tencent/qqnt/aio/toptips/b;", "d", "Lcom/tencent/qqnt/aio/toptips/b;", "getCurrentTipsBar", "()Lcom/tencent/qqnt/aio/toptips/b;", "currentTipsBar", "e", "a", "replaceTipsBar", "<init>", "(Lcom/tencent/qqnt/aio/toptips/b;Lcom/tencent/qqnt/aio/toptips/b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ReplaceTopTipState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.toptips.b currentTipsBar;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.toptips.b replaceTipsBar;

        public ReplaceTopTipState(@NotNull com.tencent.qqnt.aio.toptips.b currentTipsBar, @NotNull com.tencent.qqnt.aio.toptips.b replaceTipsBar) {
            Intrinsics.checkNotNullParameter(currentTipsBar, "currentTipsBar");
            Intrinsics.checkNotNullParameter(replaceTipsBar, "replaceTipsBar");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) currentTipsBar, (Object) replaceTipsBar);
            } else {
                this.currentTipsBar = currentTipsBar;
                this.replaceTipsBar = replaceTipsBar;
            }
        }

        @NotNull
        public final com.tencent.qqnt.aio.toptips.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.aio.toptips.b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.replaceTipsBar;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$SetTopPadding;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "", "d", "I", "a", "()I", "padding", "<init>", "(I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class SetTopPadding implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int padding;

        public SetTopPadding(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.padding = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.padding;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$ShowCustomBarState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ShowCustomBarState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public ShowCustomBarState(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.view;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$ShowMsgBoxState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ShowMsgBoxState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public ShowMsgBoxState(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.view;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$ShowTopTipState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Lcom/tencent/qqnt/aio/toptips/b;", "d", "Lcom/tencent/qqnt/aio/toptips/b;", "a", "()Lcom/tencent/qqnt/aio/toptips/b;", "tipsBarTask", "<init>", "(Lcom/tencent/qqnt/aio/toptips/b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ShowTopTipState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.toptips.b tipsBarTask;

        public ShowTopTipState(@NotNull com.tencent.qqnt.aio.toptips.b tipsBarTask) {
            Intrinsics.checkNotNullParameter(tipsBarTask, "tipsBarTask");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tipsBarTask);
            } else {
                this.tipsBarTask = tipsBarTask;
            }
        }

        @NotNull
        public final com.tencent.qqnt.aio.toptips.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.aio.toptips.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.tipsBarTask;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/AIOTopTipContainerVB$ShowTroopTODOBarState;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ShowTroopTODOBarState implements TopTipViewState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public ShowTroopTODOBarState(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.view;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    public AIOTopTipContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$customBarContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    FrameLayout frameLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    frameLayout = AIOTopTipContainerVB.this.topContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        frameLayout = null;
                    }
                    FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                    frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    frameLayout2.setVisibility(8);
                    return frameLayout2;
                }
            });
            this.customBarContainer = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$topTipsContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    FrameLayout frameLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    frameLayout = AIOTopTipContainerVB.this.topContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        frameLayout = null;
                    }
                    FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                    frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    frameLayout2.setVisibility(8);
                    return frameLayout2;
                }
            });
            this.topTipsContainer = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$troopToDOContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    FrameLayout frameLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    frameLayout = AIOTopTipContainerVB.this.topContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        frameLayout = null;
                    }
                    FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                    frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    frameLayout2.setVisibility(8);
                    return frameLayout2;
                }
            });
            this.troopToDOContainer = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$totalContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    FrameLayout frameLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    frameLayout = AIOTopTipContainerVB.this.topContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        frameLayout = null;
                    }
                    LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
                    linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    linearLayout.setOrientation(1);
                    return linearLayout;
                }
            });
            this.totalContainer = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$msgBoxContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    FrameLayout frameLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    frameLayout = AIOTopTipContainerVB.this.topContainer;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        frameLayout = null;
                    }
                    FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
                    frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    frameLayout2.setVisibility(8);
                    return frameLayout2;
                }
            });
            this.msgBoxContainer = lazy5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final View e1() {
        if (h1().getChildCount() <= 0) {
            return null;
        }
        return h1().getChildAt(0);
    }

    private final ViewGroup f1() {
        return (ViewGroup) this.customBarContainer.getValue();
    }

    private final ViewGroup g1() {
        return (ViewGroup) this.msgBoxContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup h1() {
        return (ViewGroup) this.topTipsContainer.getValue();
    }

    private final ViewGroup i1() {
        return (ViewGroup) this.totalContainer.getValue();
    }

    private final ViewGroup j1() {
        return (ViewGroup) this.troopToDOContainer.getValue();
    }

    private final void l1() {
        if (!this.isViewAdded) {
            this.isViewAdded = true;
            FrameLayout frameLayout = this.topContainer;
            FrameLayout frameLayout2 = null;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                frameLayout = null;
            }
            frameLayout.addView(g1());
            i1().addView(h1());
            i1().addView(j1());
            FrameLayout frameLayout3 = this.topContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                frameLayout3 = null;
            }
            frameLayout3.addView(i1());
            FrameLayout frameLayout4 = this.topContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            } else {
                frameLayout2 = frameLayout4;
            }
            frameLayout2.addView(f1());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, TopTipViewState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TopTipViewState state) {
        final View e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        ViewGroup viewGroup = null;
        if (state instanceof ShowTopTipState) {
            l1();
            ShowTopTipState showTopTipState = (ShowTopTipState) state;
            final View a16 = showTopTipState.a().a(new Object[0]);
            h1().setVisibility(0);
            h1().removeAllViews();
            HashMap hashMap = new HashMap();
            hashMap.put("horizontal_service_id", Integer.valueOf(showTopTipState.a().getType()));
            hashMap.putAll(showTopTipState.a().d());
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_small_horizontal", hashMap);
            if (a16 instanceof TipsBar) {
                TipsBar tipsBar = (TipsBar) a16;
                tipsBar.setBusinessType(showTopTipState.a().getType());
                tipsBar.setReportParam(showTopTipState.a().d());
            }
            if (a16 != null) {
                if (a16 instanceof TipsBar) {
                    ((TipsBar) a16).setID(showTopTipState.a().getType());
                }
                ViewParent parent = a16.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(a16);
                }
                h1().addView(a16);
                TipsBarAnimatorUtilsKt.c(a16, new Function1<ag, Unit>(a16) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$1$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $this_apply;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$this_apply = a16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ag agVar) {
                        invoke2(agVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ag showTipsBarAnimator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) showTipsBarAnimator);
                        } else {
                            Intrinsics.checkNotNullParameter(showTipsBarAnimator, "$this$showTipsBarAnimator");
                            showTipsBarAnimator.e(new Function0<Unit>(this.$this_apply) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$1$2.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ View $this_apply;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$this_apply = r4;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) r4);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        this.$this_apply.setAlpha(0.0f);
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            return;
        }
        if (state instanceof HideTopTipState) {
            if (!this.isViewAdded) {
                return;
            }
            if (((HideTopTipState) state).a()) {
                View e17 = e1();
                if (e17 != null) {
                    TipsBarAnimatorUtilsKt.a(e17, new Function1<ag, Unit>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$2$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ag agVar) {
                            invoke2(agVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ag hideTipsBarAnimator) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hideTipsBarAnimator);
                            } else {
                                Intrinsics.checkNotNullParameter(hideTipsBarAnimator, "$this$hideTipsBarAnimator");
                                hideTipsBarAnimator.d(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$2$1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        super(0);
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ViewGroup h16;
                                        ViewGroup h17;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        h16 = AIOTopTipContainerVB.this.h1();
                                        h16.setVisibility(8);
                                        h17 = AIOTopTipContainerVB.this.h1();
                                        h17.removeAllViews();
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                return;
            }
            h1().setVisibility(8);
            h1().removeAllViews();
            return;
        }
        if (state instanceof ReplaceTopTipState) {
            if (this.isViewAdded && (e16 = e1()) != null) {
                final View a17 = ((ReplaceTopTipState) state).a().a(new Object[0]);
                TipsBarAnimatorUtilsKt.b(e16, a17, new Function1<ag, Unit>(e16) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$3$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $this_run;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$this_run = e16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this, (Object) e16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ag agVar) {
                        invoke2(agVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ag replaceTipsBarAnimator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) replaceTipsBarAnimator);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(replaceTipsBarAnimator, "$this$replaceTipsBarAnimator");
                        replaceTipsBarAnimator.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$3$1.1
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ViewGroup h16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    h16 = AIOTopTipContainerVB.this.h1();
                                    h16.setVisibility(0);
                                }
                            }
                        });
                        replaceTipsBarAnimator.d(new Function0<Unit>(this.$this_run) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$3$1.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ View $this_run;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$this_run = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOTopTipContainerVB.this, (Object) r5);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ViewGroup h16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    h16 = AIOTopTipContainerVB.this.h1();
                                    h16.removeView(this.$this_run);
                                }
                            }
                        });
                    }
                }, new Function1<ag, Unit>(a17, this) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$3$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $replaceView;
                    final /* synthetic */ AIOTopTipContainerVB this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$replaceView = a17;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a17, (Object) this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ag agVar) {
                        invoke2(agVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ag replaceTipsBarAnimator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) replaceTipsBarAnimator);
                        } else {
                            Intrinsics.checkNotNullParameter(replaceTipsBarAnimator, "$this$replaceTipsBarAnimator");
                            replaceTipsBarAnimator.e(new Function0<Unit>(this.$replaceView, this.this$0) { // from class: com.tencent.mobileqq.aio.reserve1.toptip.AIOTopTipContainerVB$handleUIState$3$2.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ View $replaceView;
                                final /* synthetic */ AIOTopTipContainerVB this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$replaceView = r4;
                                    this.this$0 = r5;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    ViewGroup h16;
                                    ViewParent parent2;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    View view = this.$replaceView;
                                    if (view != null) {
                                        view.setAlpha(0.0f);
                                    }
                                    View view2 = this.$replaceView;
                                    if (view2 != null && (parent2 = view2.getParent()) != null) {
                                        View view3 = this.$replaceView;
                                        ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                                        if (viewGroup2 != null) {
                                            viewGroup2.removeView(view3);
                                        }
                                    }
                                    h16 = this.this$0.h1();
                                    h16.addView(this.$replaceView);
                                }
                            });
                        }
                    }
                });
                return;
            }
            return;
        }
        if (state instanceof ShowMsgBoxState) {
            l1();
            g1().setVisibility(0);
            ShowMsgBoxState showMsgBoxState = (ShowMsgBoxState) state;
            if (g1().indexOfChild(showMsgBoxState.a()) == -1) {
                g1().addView(showMsgBoxState.a());
                return;
            }
            return;
        }
        if (state instanceof HideMsgBoxState) {
            if (!this.isViewAdded) {
                return;
            }
            g1().setVisibility(8);
            g1().removeAllViews();
            return;
        }
        if (state instanceof ShowCustomBarState) {
            l1();
            f1().setVisibility(0);
            if (f1().getChildCount() == 0) {
                f1().addView(((ShowCustomBarState) state).a());
                return;
            }
            return;
        }
        if (state instanceof RemoveCustomBarState) {
            if (!this.isViewAdded) {
                return;
            }
            f1().setVisibility(8);
            f1().removeAllViews();
            return;
        }
        if (state instanceof SetTopPadding) {
            FrameLayout frameLayout = this.topContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            } else {
                viewGroup = frameLayout;
            }
            viewGroup.setPadding(viewGroup.getPaddingLeft(), ((SetTopPadding) state).a(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            return;
        }
        if (state instanceof ShowTroopTODOBarState) {
            l1();
            ShowTroopTODOBarState showTroopTODOBarState = (ShowTroopTODOBarState) state;
            ViewParent parent2 = showTroopTODOBarState.a().getParent();
            if (parent2 instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent2;
            }
            if (viewGroup != null) {
                viewGroup.removeView(showTroopTODOBarState.a());
            }
            j1().setVisibility(0);
            j1().addView(showTroopTODOBarState.a());
            return;
        }
        if (!(state instanceof RemoveTroopTODOBarState) || !this.isViewAdded) {
            return;
        }
        j1().removeView(((RemoveTroopTODOBarState) state).a());
        if (j1().getChildCount() == 0) {
            j1().setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.f100035re);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026d(R.id.top_tip_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.topContainer = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            return null;
        }
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.isViewAdded) {
            this.isViewAdded = false;
            i1().removeAllViews();
            j1().removeAllViews();
            FrameLayout frameLayout = this.topContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
            h1().removeAllViews();
            g1().removeAllViews();
            f1().removeAllViews();
        }
    }
}
