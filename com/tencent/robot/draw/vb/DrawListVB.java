package com.tencent.robot.draw.vb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.input.base.mvicompat.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.robot.draw.vb.delegate.DrawListUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001#\u0018\u0000 )*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u0001*B\u001b\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/draw/vb/DrawListVB;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Le44/a;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "Ljava/lang/Class;", "getObserverStates", "state", "c1", "Lcom/tencent/robot/draw/vb/b;", "Lcom/tencent/robot/draw/vb/e;", "d", "Lcom/tencent/robot/draw/vb/b;", "mAdornApi", "e", "Lcom/tencent/robot/draw/vb/e;", "mBinding", "com/tencent/robot/draw/vb/DrawListVB$b", "f", "Lcom/tencent/robot/draw/vb/DrawListVB$b;", "mVBDelegateMediator", "<init>", "(Lcom/tencent/robot/draw/vb/b;)V", h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DrawListVB<C extends com.tencent.mvi.api.runtime.b> extends BaseVB<e44.a, DrawListUIState, C> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.draw.vb.b<e, C> mAdornApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mVBDelegateMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/draw/vb/DrawListVB$a;", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "b", "Lcom/tencent/robot/draw/vb/e;", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.draw.vb.DrawListVB$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/draw/vb/DrawListVB$a$a", "Lcom/tencent/robot/draw/vb/e;", "Landroid/view/View;", "getRoot", "a", "Landroid/view/View;", "mContainer", "b", "getContainer", "()Landroid/view/View;", ParseCommon.CONTAINER, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.draw.vb.DrawListVB$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9774a implements e {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final View mContainer;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final View container;

            C9774a(com.tencent.mvi.api.help.a aVar) {
                View b16 = DrawListVB.INSTANCE.b(aVar);
                this.mContainer = b16;
                this.container = b16;
            }

            @Override // com.tencent.robot.draw.vb.e
            @NotNull
            public View getContainer() {
                return this.container;
            }

            @Override // androidx.viewbinding.ViewBinding
            @NotNull
            /* renamed from: getRoot, reason: from getter */
            public View getMContainer() {
                return this.mContainer;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(com.tencent.mvi.api.help.a createViewParams) {
            View container = LayoutInflater.from(createViewParams.a()).inflate(R.layout.hnu, (ViewGroup) null);
            container.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Intrinsics.checkNotNullExpressionValue(container, "container");
            return container;
        }

        @NotNull
        public final e c(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            return new C9774a(createViewParams);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\u0001j\u0002`\u0006J<\u0010\u000b\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`\n0\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/draw/vb/DrawListVB$b", "Lcom/tencent/input/base/mvicompat/g;", "Le44/a;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/robot/draw/vb/c;", "Lcom/tencent/robot/draw/vb/e;", "Lcom/tencent/robot/draw/vb/DrawListVBDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/draw/vb/IDrawListVBDelegate;", DomainData.DOMAIN_NAME, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends g<e44.a, DrawListUIState, com.tencent.robot.draw.vb.c, ? super e> {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ DrawListVB<C> f367783h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(DrawListVB<C> drawListVB, c cVar) {
            super(cVar);
            this.f367783h = drawListVB;
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.c<e44.a, DrawListUIState, com.tencent.robot.draw.vb.c, ? super e>> i(@NotNull com.tencent.robot.draw.vb.c host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return ((DrawListVB) this.f367783h).mAdornApi.b(host);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/draw/vb/DrawListVB$c", "Lcom/tencent/robot/draw/vb/c;", "Le44/a;", "intent", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.robot.draw.vb.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DrawListVB<C> f367784d;

        c(DrawListVB<C> drawListVB) {
            this.f367784d = drawListVB;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull e44.a intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.f367784d.sendIntent(intent);
        }
    }

    public DrawListVB(@NotNull com.tencent.robot.draw.vb.b<e, C> mAdornApi) {
        Intrinsics.checkNotNullParameter(mAdornApi, "mAdornApi");
        this.mAdornApi = mAdornApi;
        this.mVBDelegateMediator = new b(this, new c(this));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        this.mVBDelegateMediator.a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull DrawListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.mVBDelegateMediator.f(state);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<e44.a, DrawListUIState, C> createVM() {
        return new a(new Function1<d, List<? extends com.tencent.input.base.mvicompat.e<e44.a, DrawListUIState, C, d>>>(this) { // from class: com.tencent.robot.draw.vb.DrawListVB$createVM$1
            final /* synthetic */ DrawListVB<C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<com.tencent.input.base.mvicompat.e<e44.a, DrawListUIState, C, d>> invoke(@NotNull d host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return ((DrawListVB) this.this$0).mAdornApi.c(host);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return this.mVBDelegateMediator.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends DrawListUIState>> getObserverStates() {
        return this.mVBDelegateMediator.l();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        e a16 = this.mAdornApi.a(createViewParams);
        this.mBinding = a16;
        b bVar = this.mVBDelegateMediator;
        e eVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            a16 = null;
        }
        bVar.c(a16);
        e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar2;
        }
        View mContainer = eVar.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "mBinding.root");
        return mContainer;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        this.mVBDelegateMediator.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        this.mVBDelegateMediator.d(reuseParam);
    }
}
