package com.tencent.robot.write.vb;

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
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.write.vb.delegate.WriteListUIState;
import e74.ItemData;
import e74.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\t*\u0001+\u0018\u0000 1*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u00012B\u001b\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u00000 \u00a2\u0006\u0004\b/\u00100J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001a0\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001f\u001a\u00020\u001eR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u00000 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/write/vb/WriteListVB;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/robot/write/vb/delegate/a;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Le74/f;", "data", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "", "Ljava/lang/Class;", "getObserverStates", "state", "d1", "", "c1", "Lcom/tencent/robot/write/vb/a;", "Lcom/tencent/robot/write/vb/d;", "d", "Lcom/tencent/robot/write/vb/a;", "mAdornApi", "e", "Lcom/tencent/robot/write/vb/d;", "mBinding", "f", "I", "mContainerHeight", "com/tencent/robot/write/vb/WriteListVB$b", h.F, "Lcom/tencent/robot/write/vb/WriteListVB$b;", "mVBDelegateMediator", "<init>", "(Lcom/tencent/robot/write/vb/a;)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class WriteListVB<C extends com.tencent.mvi.api.runtime.b> extends BaseVB<com.tencent.robot.write.vb.delegate.a, WriteListUIState, C> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a<d, C> mAdornApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mContainerHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mVBDelegateMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/write/vb/WriteListVB$a;", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "b", "Lcom/tencent/robot/write/vb/d;", "c", "", "CONTAINER_DEFAULT_HEIGHT", "I", "ROW_HEIGHT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.WriteListVB$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/write/vb/WriteListVB$a$a", "Lcom/tencent/robot/write/vb/d;", "Landroid/view/View;", "getRoot", "a", "Landroid/view/View;", "mContainer", "b", "getContainer", "()Landroid/view/View;", ParseCommon.CONTAINER, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.write.vb.WriteListVB$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9787a implements d {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final View mContainer;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final View container;

            C9787a(com.tencent.mvi.api.help.a aVar) {
                View b16 = WriteListVB.INSTANCE.b(aVar);
                this.mContainer = b16;
                this.container = b16;
            }

            @Override // com.tencent.robot.write.vb.d
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
            View container = LayoutInflater.from(createViewParams.a()).inflate(R.layout.hnx, (ViewGroup) null);
            container.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Intrinsics.checkNotNullExpressionValue(container, "container");
            return container;
        }

        @NotNull
        public final d c(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            return new C9787a(createViewParams);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\u0001j\u0002`\u0006J<\u0010\u000b\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00020\u00050\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`\n0\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/write/vb/WriteListVB$b", "Lcom/tencent/input/base/mvicompat/g;", "Lcom/tencent/robot/write/vb/delegate/a;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Lcom/tencent/robot/write/vb/b;", "Lcom/tencent/robot/write/vb/d;", "Lcom/tencent/robot/write/vb/WriteListVBDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/write/vb/IWriteListVBDelegate;", DomainData.DOMAIN_NAME, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends g<com.tencent.robot.write.vb.delegate.a, WriteListUIState, com.tencent.robot.write.vb.b, ? super d> {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WriteListVB<C> f368735h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(WriteListVB<C> writeListVB, c cVar) {
            super(cVar);
            this.f368735h = writeListVB;
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.c<com.tencent.robot.write.vb.delegate.a, WriteListUIState, com.tencent.robot.write.vb.b, ? super d>> i(@NotNull com.tencent.robot.write.vb.b host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return ((WriteListVB) this.f368735h).mAdornApi.b(host);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/write/vb/WriteListVB$c", "Lcom/tencent/robot/write/vb/b;", "Lcom/tencent/robot/write/vb/delegate/a;", "intent", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.robot.write.vb.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WriteListVB<C> f368736d;

        c(WriteListVB<C> writeListVB) {
            this.f368736d = writeListVB;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull com.tencent.robot.write.vb.delegate.a intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.f368736d.sendIntent(intent);
        }
    }

    public WriteListVB(@NotNull a<d, C> mAdornApi) {
        Intrinsics.checkNotNullParameter(mAdornApi, "mAdornApi");
        this.mAdornApi = mAdornApi;
        this.mVBDelegateMediator = new b(this, new c(this));
    }

    private final void e1(f data) {
        int coerceAtMost;
        if (data == null) {
            return;
        }
        List<ItemData> e16 = data.e();
        if (e16 == null) {
            e16 = CollectionsKt__CollectionsKt.emptyList();
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(((e16.size() + 17) - 1) / 17, 3);
        this.mContainerHeight = ViewUtils.f352270a.b((coerceAtMost * 42) + 113);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        this.mVBDelegateMediator.a();
    }

    /* renamed from: c1, reason: from getter */
    public final int getMContainerHeight() {
        return this.mContainerHeight;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<com.tencent.robot.write.vb.delegate.a, WriteListUIState, C> createVM() {
        return new e(new Function1<com.tencent.robot.write.vb.c, List<? extends com.tencent.input.base.mvicompat.e<com.tencent.robot.write.vb.delegate.a, WriteListUIState, C, com.tencent.robot.write.vb.c>>>(this) { // from class: com.tencent.robot.write.vb.WriteListVB$createVM$1
            final /* synthetic */ WriteListVB<C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<com.tencent.input.base.mvicompat.e<com.tencent.robot.write.vb.delegate.a, WriteListUIState, C, c>> invoke(@NotNull c host) {
                Intrinsics.checkNotNullParameter(host, "host");
                return ((WriteListVB) this.this$0).mAdornApi.c(host);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull WriteListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.mVBDelegateMediator.f(state);
        if (state instanceof WriteListUIState.SubmitListUIState) {
            e1(((WriteListUIState.SubmitListUIState) state).getData());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return this.mVBDelegateMediator.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends WriteListUIState>> getObserverStates() {
        return this.mVBDelegateMediator.l();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        d a16 = this.mAdornApi.a(createViewParams);
        this.mBinding = a16;
        b bVar = this.mVBDelegateMediator;
        d dVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            a16 = null;
        }
        bVar.c(a16);
        d dVar2 = this.mBinding;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dVar = dVar2;
        }
        View mContainer = dVar.getMContainer();
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
