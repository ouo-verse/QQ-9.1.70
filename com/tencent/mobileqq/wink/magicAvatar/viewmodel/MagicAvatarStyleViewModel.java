package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.PageInfoCallbackInfo;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarStyleViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "R1", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", DownloadInfo.spKey_Config, "Q1", "T1", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_banner", "Lkotlinx/coroutines/flow/SharedFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/SharedFlow;", "S1", "()Lkotlinx/coroutines/flow/SharedFlow;", "banner", "", "D", "_path", "E", "W1", "path", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarStyleViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<PageInfoCallbackInfo> banner;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<String> _path;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<String> path;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<PageInfoCallbackInfo> _banner;

    public MagicAvatarStyleViewModel() {
        MutableSharedFlow<PageInfoCallbackInfo> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._banner = MutableSharedFlow$default;
        this.banner = MutableSharedFlow$default;
        MutableSharedFlow<String> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._path = MutableSharedFlow$default2;
        this.path = MutableSharedFlow$default2;
        MagicAvatarDataSource.f323499a.q(new Function1<PageInfoCallbackInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel.1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel$1$1", f = "MagicAvatarStyleViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes21.dex */
            public static final class C90571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PageInfoCallbackInfo $it;
                int label;
                final /* synthetic */ MagicAvatarStyleViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C90571(MagicAvatarStyleViewModel magicAvatarStyleViewModel, PageInfoCallbackInfo pageInfoCallbackInfo, Continuation<? super C90571> continuation) {
                    super(2, continuation);
                    this.this$0 = magicAvatarStyleViewModel;
                    this.$it = pageInfoCallbackInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C90571(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        MutableSharedFlow mutableSharedFlow = this.this$0._banner;
                        PageInfoCallbackInfo pageInfoCallbackInfo = this.$it;
                        this.label = 1;
                        if (mutableSharedFlow.emit(pageInfoCallbackInfo, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C90571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PageInfoCallbackInfo pageInfoCallbackInfo) {
                invoke2(pageInfoCallbackInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PageInfoCallbackInfo pageInfoCallbackInfo) {
                MetaMaterial homePageHeadBgPag;
                BuildersKt__Builders_commonKt.launch$default(MagicAvatarStyleViewModel.this.viewModelScope, null, null, new C90571(MagicAvatarStyleViewModel.this, pageInfoCallbackInfo, null), 3, null);
                if (pageInfoCallbackInfo == null || (homePageHeadBgPag = pageInfoCallbackInfo.getHomePageHeadBgPag()) == null) {
                    return;
                }
                MagicAvatarStyleViewModel.this.R1(homePageHeadBgPag);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(MetaMaterial metaMaterial) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarStyleViewModel$downloadPag$1(metaMaterial, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1() {
        BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkRecommendDataServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler");
        ((WinkRecommendDataServiceHandler) businessHandler).m3("MagicAvatar");
    }

    public final void Q1(@Nullable ModifyAvatarConfig config) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarStyleViewModel$checkDownloadOldFile$1(config, null), 3, null);
    }

    @NotNull
    public final SharedFlow<PageInfoCallbackInfo> S1() {
        return this.banner;
    }

    public final void T1() {
        w53.b.f("MagicAvatarStyleViewModel", "getPageInfo");
        if (!NetworkUtil.isNetworkAvailable()) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarStyleViewModel$getPageInfo$1(this, null), 3, null);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.viewmodel.e
                @Override // java.lang.Runnable
                public final void run() {
                    MagicAvatarStyleViewModel.U1();
                }
            }, 128, null, false);
        }
    }

    @NotNull
    public final SharedFlow<String> W1() {
        return this.path;
    }
}
