package com.tencent.mobileqq.wink.magicstudio;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J/\u0010\u0011\u001a\u00020\t2'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\u000fJ\b\u0010\u0012\u001a\u00020\tH\u0014J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R;\u0010\u001c\u001a)\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\u000f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020!0%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001f\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/wink/magicstudio/ab;", "U1", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "Z1", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "Lcom/tencent/mobileqq/wink/magicstudio/PageInfoCallback;", "callback", ICustomDataEditor.STRING_ARRAY_PARAM_2, "onCleared", "action", "T1", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Set;", "pageInfoCallbackCaches", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/magicstudio/ab;", "cachePageInfoCallbackInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/magicstudio/e;", "D", "Landroidx/lifecycle/MutableLiveData;", "_onActivityResult", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "onActivityResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel$a$a;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_doAction", "Lkotlinx/coroutines/flow/StateFlow;", "G", "Lkotlinx/coroutines/flow/StateFlow;", "W1", "()Lkotlinx/coroutines/flow/StateFlow;", "doAction", "", "H", "Z", "skipFirstMaterialData", "<init>", "()V", "I", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PageInfoCallbackInfo cachePageInfoCallbackInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MagicStudioActivityResult> _onActivityResult;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MagicStudioActivityResult> onActivityResult;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Companion.C9063a> _doAction;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<Companion.C9063a> doAction;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean skipFirstMaterialData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Function1<PageInfoCallbackInfo, Unit>> pageInfoCallbackCaches = new LinkedHashSet();

    public MagicStudioViewModel() {
        MutableLiveData<MagicStudioActivityResult> mutableLiveData = new MutableLiveData<>();
        this._onActivityResult = mutableLiveData;
        this.onActivityResult = mutableLiveData;
        MutableStateFlow<Companion.C9063a> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._doAction = MutableStateFlow;
        this.doAction = MutableStateFlow;
        MagicStudioDataSource.f323652a.f0(new Function1<PageInfoCallbackInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel.1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel$1$1", f = "MagicStudioViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes21.dex */
            public static final class C90621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PageInfoCallbackInfo $it;
                int label;
                final /* synthetic */ MagicStudioViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C90621(MagicStudioViewModel magicStudioViewModel, PageInfoCallbackInfo pageInfoCallbackInfo, Continuation<? super C90621> continuation) {
                    super(2, continuation);
                    this.this$0 = magicStudioViewModel;
                    this.$it = pageInfoCallbackInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C90621(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.cachePageInfoCallbackInfo = this.$it;
                        Set set = this.this$0.pageInfoCallbackCaches;
                        MagicStudioViewModel magicStudioViewModel = this.this$0;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((Function1) it.next()).invoke(magicStudioViewModel.U1());
                        }
                        this.this$0.pageInfoCallbackCaches.clear();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C90621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (MagicStudioViewModel.this.skipFirstMaterialData) {
                    MagicStudioViewModel.this.skipFirstMaterialData = false;
                } else {
                    if (MagicStudioViewModel.this.cachePageInfoCallbackInfo != null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(MagicStudioViewModel.this.viewModelScope, null, null, new C90621(MagicStudioViewModel.this, pageInfoCallbackInfo, null), 3, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PageInfoCallbackInfo U1() {
        PageInfoCallbackInfo pageInfoCallbackInfo = this.cachePageInfoCallbackInfo;
        if (pageInfoCallbackInfo == null) {
            return null;
        }
        Intrinsics.checkNotNull(pageInfoCallbackInfo);
        ArrayList<MagicStudioTip> g16 = pageInfoCallbackInfo.g();
        ArrayList arrayList = new ArrayList();
        PageInfoCallbackInfo pageInfoCallbackInfo2 = this.cachePageInfoCallbackInfo;
        Intrinsics.checkNotNull(pageInfoCallbackInfo2);
        Iterator<T> it = pageInfoCallbackInfo2.f().iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mobileqq.wink.magicstudio.model.f) it.next()).a());
        }
        ArrayList arrayList2 = new ArrayList();
        PageInfoCallbackInfo pageInfoCallbackInfo3 = this.cachePageInfoCallbackInfo;
        Intrinsics.checkNotNull(pageInfoCallbackInfo3);
        Iterator<T> it5 = pageInfoCallbackInfo3.e().iterator();
        while (it5.hasNext()) {
            arrayList2.add(MagicStudioPrompt.copy$default((MagicStudioPrompt) it5.next(), null, null, null, null, 15, null));
        }
        Unit unit = Unit.INSTANCE;
        PageInfoCallbackInfo pageInfoCallbackInfo4 = this.cachePageInfoCallbackInfo;
        Intrinsics.checkNotNull(pageInfoCallbackInfo4);
        return new PageInfoCallbackInfo(g16, arrayList, arrayList2, pageInfoCallbackInfo4.d());
    }

    public final void T1(int action) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioViewModel$doAction$1(action, this, null), 3, null);
    }

    @NotNull
    public final StateFlow<Companion.C9063a> W1() {
        return this.doAction;
    }

    @NotNull
    public final LiveData<MagicStudioActivityResult> X1() {
        return this.onActivityResult;
    }

    public final void Z1(int requestCode, int resultCode, @Nullable Intent data) {
        this._onActivityResult.postValue(new MagicStudioActivityResult(requestCode, resultCode, data));
    }

    public final void a2(@NotNull Function1<? super PageInfoCallbackInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.cachePageInfoCallbackInfo != null) {
            callback.invoke(U1());
        } else {
            this.pageInfoCallbackCaches.add(callback);
            MagicStudioDataSource.f323652a.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        MagicStudioDataSource.f323652a.t();
        super.onCleared();
    }
}
