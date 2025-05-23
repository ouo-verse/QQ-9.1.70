package com.tencent.robot.widget.list.vb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001#\u0018\u0000 )*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u0001*B\u001b\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListVB;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "Ljava/lang/Class;", "getObserverStates", "state", "d1", "Lcom/tencent/robot/widget/list/vb/c;", "Lcom/tencent/robot/widget/list/vb/f;", "d", "Lcom/tencent/robot/widget/list/vb/c;", "mAdornApi", "e", "Lcom/tencent/robot/widget/list/vb/f;", "mBinding", "com/tencent/robot/widget/list/vb/CommonListVB$b", "f", "Lcom/tencent/robot/widget/list/vb/CommonListVB$b;", "mVBDelegateMediator", "<init>", "(Lcom/tencent/robot/widget/list/vb/c;)V", h.F, "a", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommonListVB<C extends com.tencent.mvi.api.runtime.b> extends BaseVB<a, CommonListUIState, C> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f368697i = ViewCompat.generateViewId();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.robot.widget.list.vb.c<f, C> mAdornApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mVBDelegateMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListVB$a;", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/ViewGroup$LayoutParams;", "layoutParam", "Lcom/tencent/robot/widget/list/vb/f;", "a", "", "RECYCLERVIEW_ID", "I", "c", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.widget.list.vb.CommonListVB$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/widget/list/vb/CommonListVB$a$a", "Lcom/tencent/robot/widget/list/vb/f;", "Landroidx/recyclerview/widget/RecyclerView;", "e", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mRv", "b", HippyTKDListViewAdapter.X, "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.widget.list.vb.CommonListVB$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9783a implements f {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final RecyclerView mRv;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final RecyclerView recyclerView;

            C9783a(com.tencent.mvi.api.help.a aVar, ViewGroup.LayoutParams layoutParams) {
                RecyclerView recyclerView = new RecyclerView(aVar.a());
                recyclerView.setId(CommonListVB.INSTANCE.c());
                recyclerView.setItemAnimator(null);
                recyclerView.setLayoutManager(new LinearLayoutManager(aVar.a(), 1, false));
                recyclerView.setLayoutParams(layoutParams);
                this.mRv = recyclerView;
                this.recyclerView = recyclerView;
            }

            @Override // androidx.viewbinding.ViewBinding
            @NotNull
            /* renamed from: e, reason: from getter and merged with bridge method [inline-methods] */
            public RecyclerView getMContainer() {
                return this.mRv;
            }

            @Override // com.tencent.robot.widget.list.vb.f
            @NotNull
            /* renamed from: x, reason: from getter */
            public RecyclerView getRecyclerView() {
                return this.recyclerView;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ f b(Companion companion, com.tencent.mvi.api.help.a aVar, ViewGroup.LayoutParams layoutParams, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            return companion.a(aVar, layoutParams);
        }

        @NotNull
        public final f a(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull ViewGroup.LayoutParams layoutParam) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
            return new C9783a(createViewParams, layoutParam);
        }

        public final int c() {
            return CommonListVB.f368697i;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\u0001j\u0002`\u0006J<\u0010\u000b\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`\n0\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/widget/list/vb/CommonListVB$b", "Lcom/tencent/input/base/mvicompat/g;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/CommonListVBDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", DomainData.DOMAIN_NAME, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends g<a, CommonListUIState, d, ? super f> {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CommonListVB<C> f368703h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CommonListVB<C> commonListVB, c cVar) {
            super(cVar);
            this.f368703h = commonListVB;
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.c<a, CommonListUIState, d, ? super f>> i(@NotNull d host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return ((CommonListVB) this.f368703h).mAdornApi.b(host);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/robot/widget/list/vb/CommonListVB$c", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/a;", "intent", "", "a", "Lcom/tencent/mvi/runtime/strategy/b;", "D", "()Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonListVB<C> f368704d;

        c(CommonListVB<C> commonListVB) {
            this.f368704d = commonListVB;
        }

        @Override // com.tencent.robot.widget.list.vb.d
        @NotNull
        public com.tencent.mvi.runtime.strategy.b D() {
            return this.f368704d.getMStrategyService();
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull a intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.f368704d.sendIntent(intent);
        }
    }

    public CommonListVB(@NotNull com.tencent.robot.widget.list.vb.c<f, C> mAdornApi) {
        Intrinsics.checkNotNullParameter(mAdornApi, "mAdornApi");
        this.mAdornApi = mAdornApi;
        this.mVBDelegateMediator = new b(this, new c(this));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        this.mVBDelegateMediator.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<a, CommonListUIState, C> createVM() {
        return new com.tencent.robot.widget.list.vb.b(new Function1<e, List<? extends com.tencent.input.base.mvicompat.e<a, CommonListUIState, C, e>>>(this) { // from class: com.tencent.robot.widget.list.vb.CommonListVB$createVM$1
            final /* synthetic */ CommonListVB<C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<com.tencent.input.base.mvicompat.e<a, CommonListUIState, C, e>> invoke(@NotNull e host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return ((CommonListVB) this.this$0).mAdornApi.c(host);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.mVBDelegateMediator.f(state);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return this.mVBDelegateMediator.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends CommonListUIState>> getObserverStates() {
        return this.mVBDelegateMediator.l();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        f a16 = this.mAdornApi.a(createViewParams);
        this.mBinding = a16;
        b bVar = this.mVBDelegateMediator;
        f fVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            a16 = null;
        }
        bVar.c(a16);
        f fVar2 = this.mBinding;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fVar = fVar2;
        }
        View mContainer = fVar.getMContainer();
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
