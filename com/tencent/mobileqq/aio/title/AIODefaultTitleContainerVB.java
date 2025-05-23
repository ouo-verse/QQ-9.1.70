package com.tencent.mobileqq.aio.title;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.title.AIOTitleContainerUIState;
import com.tencent.mobileqq.aio.title.l;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J&\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00150\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017H\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00190\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/l;", "Lcom/tencent/mobileqq/aio/title/AIOTitleContainerUIState;", "", "visibility", "", "isRobotAIO", "", "l1", ViewStickEventHelper.IS_SHOW, "h1", "j1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "e1", "Ljava/lang/Class;", "getObserverStates", "state", "i1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Landroid/view/View;", "mTitleContainer", "Lcom/tencent/mobileqq/aio/title/j;", "e", "Lkotlin/Lazy;", "g1", "()Lcom/tencent/mobileqq/aio/title/j;", "mMsgShotTitle", "Lcom/tencent/mobileqq/aio/title/AIOTitleVB;", "f", "f1", "()Lcom/tencent/mobileqq/aio/title/AIOTitleVB;", "mAIOTitleVB", tl.h.F, "Z", "mIsLongShotMode", "Landroid/view/View$OnLayoutChangeListener;", "i", "Landroid/view/View$OnLayoutChangeListener;", "mLayoutChangeListener", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIODefaultTitleContainerVB extends com.tencent.aio.base.mvvm.a<l, AIOTitleContainerUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTitleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMsgShotTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAIOTitleVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLongShotMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mLayoutChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIODefaultTitleContainerVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIODefaultTitleContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AIODefaultTitleContainerVB$mMsgShotTitle$2.INSTANCE);
            this.mMsgShotTitle = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(AIODefaultTitleContainerVB$mAIOTitleVB$2.INSTANCE);
            this.mAIOTitleVB = lazy2;
            this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.title.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    AIODefaultTitleContainerVB.k1(AIODefaultTitleContainerVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(AIODefaultTitleContainerVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = new int[2];
        View view = this$0.mTitleContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view = null;
        }
        view.getLocationOnScreen(iArr);
        View view3 = this$0.mTitleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view3 = null;
        }
        this$0.sendIntent(new l.a(view3.getHeight(), iArr));
        View view4 = this$0.mTitleContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
        } else {
            view2 = view4;
        }
        QLog.d("AIODefaultTitleContainerVB", 1, "bindViewAndData height=" + view2.getHeight() + " location=[" + iArr[0] + "," + iArr[1] + "]");
    }

    private final AIOTitleVB f1() {
        return (AIOTitleVB) this.mAIOTitleVB.getValue();
    }

    private final j g1() {
        return (j) this.mMsgShotTitle.getValue();
    }

    private final void h1(boolean isShow) {
        View view = null;
        if (isShow) {
            View view2 = this.mTitleContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.mTitleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final boolean j1() {
        l.b bVar = new l.b(false, 1, null);
        sendIntent(bVar);
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(AIODefaultTitleContainerVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i18 - i16;
        if (i29 != i28 - i26) {
            int[] iArr = new int[2];
            View view2 = this$0.mTitleContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
                view2 = null;
            }
            view2.getLocationOnScreen(iArr);
            this$0.sendIntent(new l.a(i29, iArr));
            QLog.d("AIODefaultTitleContainerVB", 1, "onLayoutChange height=" + i29 + " location=[" + iArr[0] + "," + iArr[1] + "]");
        }
    }

    private final void l1(int visibility, boolean isRobotAIO) {
        if (visibility == 0) {
            if (!this.mIsLongShotMode) {
                addChildVB(g1());
            }
            if (isRobotAIO) {
                f1().getHostView().setVisibility(8);
            }
            this.mIsLongShotMode = true;
            return;
        }
        if (this.mIsLongShotMode) {
            removeChildVB(g1());
        }
        if (isRobotAIO) {
            f1().getHostView().setVisibility(0);
        }
        this.mIsLongShotMode = false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        View view = this.mTitleContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view = null;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.b
            @Override // java.lang.Runnable
            public final void run() {
                AIODefaultTitleContainerVB.d1(AIODefaultTitleContainerVB.this);
            }
        });
        l1(8, j1());
        View view3 = this.mTitleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
        } else {
            view2 = view3;
        }
        view2.addOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<l, AIOTitleContainerUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new AIODefaultTitleContainerVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AIOTitleContainerUIState>> getObserverStates() {
        List<Class<? extends AIOTitleContainerUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIOTitleContainerUIState.ShowTitleContainer.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOTitleContainerUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOTitleContainerUIState.ShowTitleContainer) {
            h1(((AIOTitleContainerUIState.ShowTitleContainer) state).a());
            return;
        }
        if (state instanceof AIOTitleContainerUIState.SetMsgShotTitleVisibility) {
            AIOTitleContainerUIState.SetMsgShotTitleVisibility setMsgShotTitleVisibility = (AIOTitleContainerUIState.SetMsgShotTitleVisibility) state;
            l1(setMsgShotTitleVisibility.a(), setMsgShotTitleVisibility.b());
        } else if (state instanceof AIOTitleContainerUIState.GetTitleContainerLocationInWindow) {
            View view = this.mTitleContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
                view = null;
            }
            view.getLocationInWindow(((AIOTitleContainerUIState.GetTitleContainerLocationInWindow) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new com.tencent.mobileqq.aio.reserve1.blur.d(), new com.tencent.mobileqq.aio.reserve1.mask.b(), f1()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 48;
        frameLayout.setLayoutParams(a16);
        this.mTitleContainer = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        View view = this.mTitleContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view = null;
        }
        view.removeOnLayoutChangeListener(this.mLayoutChangeListener);
    }
}
