package com.tencent.mobileqq.aio.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.notification.list.AIONotificationListVB;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p81.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u001a\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0011H\u0016J$\u0010\u0014\u001a\u00020\u00062\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J,\u0010\u001c\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u001a\u0012\u0006\b\u0001\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0003H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/AIONotificationVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "h1", "", "height", "g1", "", NodeProps.VISIBLE, "i1", "f1", "b1", "c1", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "mUIModel", "afterCreateVM", "bindViewAndData", "Landroid/view/View;", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "state", "e1", "Lp81/f;", "d", "Lp81/f;", "viewBinding", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "notificationContainer", "f", "Z", "Lcom/tencent/mobileqq/aio/notification/AIONotificationVM;", h.F, "Lkotlin/Lazy;", "d1", "()Lcom/tencent/mobileqq/aio/notification/AIONotificationVM;", "viewModel", "<init>", "()V", "i", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationVB extends com.tencent.aio.base.mvvm.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout notificationContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/AIONotificationVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.AIONotificationVB$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52784);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONotificationVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.visible = true;
        lazy = LazyKt__LazyJVMKt.lazy(AIONotificationVB$viewModel$2.INSTANCE);
        this.viewModel = lazy;
    }

    private final void b1() {
        f fVar = this.viewBinding;
        if (fVar != null) {
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            FrameLayout mRv = fVar.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "it.root");
            aIONotificationUIUtils.C(mRv, 500L);
        }
    }

    private final void c1() {
        f fVar = this.viewBinding;
        if (fVar != null) {
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            FrameLayout mRv = fVar.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "it.root");
            aIONotificationUIUtils.V(mRv, 500L);
        }
    }

    private final AIONotificationVM d1() {
        return (AIONotificationVM) this.viewModel.getValue();
    }

    private final void f1() {
        List listOf;
        if (this.viewBinding != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVB", 2, "lazyInitVB: ");
        }
        LayoutInflater from = LayoutInflater.from(getMContext());
        FrameLayout frameLayout = this.notificationContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            frameLayout = null;
        }
        f g16 = f.g(from, frameLayout, true);
        this.viewBinding = g16;
        int i3 = 0;
        if (g16 != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new AIONotificationListVB(g16), new AIONotificationBlurVB(g16)});
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                addChildVB((com.tencent.aio.base.mvvm.a) it.next());
            }
        }
        d1().q();
        f fVar = this.viewBinding;
        if (fVar != null) {
            frameLayout2 = fVar.getMRv();
        }
        if (frameLayout2 != null) {
            if (!this.visible) {
                i3 = 8;
            }
            frameLayout2.setVisibility(i3);
        }
    }

    private final void g1(int height) {
        FrameLayout frameLayout = this.notificationContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            frameLayout = null;
        }
        if (frameLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            FrameLayout frameLayout3 = this.notificationContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
                frameLayout3 = null;
            }
            ViewGroup.LayoutParams layoutParams = frameLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = height;
            FrameLayout frameLayout4 = this.notificationContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            } else {
                frameLayout2 = frameLayout4;
            }
            frameLayout2.setLayoutParams(marginLayoutParams);
        }
    }

    private final void h1(com.tencent.aio.api.runtime.a aioContext) {
        boolean z16;
        boolean z17 = false;
        if (aioContext != null) {
            try {
                z16 = aioContext.g().l().getBoolean("key_is_miniaio", false);
                z17 = aioContext.g().l().getBoolean("key_is_scale_chat", false);
            } catch (Exception e16) {
                QLog.e("AIONotificationVB", 1, "updateTopMargin exception: " + e16.getMessage());
                return;
            }
        } else {
            z16 = false;
        }
        int m3 = AIOUtil.f194084a.m(getMContext(), z17, z16);
        FrameLayout frameLayout = this.notificationContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            frameLayout = null;
        }
        if (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            FrameLayout frameLayout3 = this.notificationContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
                frameLayout3 = null;
            }
            ViewGroup.LayoutParams layoutParams = frameLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = m3;
            FrameLayout frameLayout4 = this.notificationContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            } else {
                frameLayout2 = frameLayout4;
            }
            frameLayout2.setLayoutParams(layoutParams2);
        }
    }

    private final void i1(boolean visible) {
        FrameLayout frameLayout;
        int i3;
        this.visible = visible;
        f fVar = this.viewBinding;
        if (fVar != null) {
            frameLayout = fVar.getMRv();
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (mUIModel != null) {
            aVar = mUIModel.getMContext();
        } else {
            aVar = null;
        }
        h1(aVar);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVB", 2, "bindViewAndData: ");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return d1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIONotificationUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIONotificationUIState.FadeHideNotification) {
            b1();
            return;
        }
        if (state instanceof AIONotificationUIState.FadeShowNotification) {
            c1();
            return;
        }
        if (state instanceof AIONotificationUIState.LazyInitVB) {
            f1();
        } else if (state instanceof AIONotificationUIState.UpdateVisibilityUIState) {
            i1(((AIONotificationUIState.UpdateVisibilityUIState) state).a());
        } else if (state instanceof AIONotificationUIState.UpdateTitleHeight) {
            g1(((AIONotificationUIState.UpdateTitleHeight) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> emptyList;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        if (!a.f192801a.a()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        FrameLayout frameLayout = this.notificationContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationContainer");
            frameLayout = null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.aio.notification.debug.d(frameLayout));
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVB", 2, "onCreateView: ");
        }
        FrameLayout frameLayout = new FrameLayout(createViewParams.b().getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.notificationContainer = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVB", 2, "onDestroy: ");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVB", 2, "onReuseView: ");
        }
    }
}
