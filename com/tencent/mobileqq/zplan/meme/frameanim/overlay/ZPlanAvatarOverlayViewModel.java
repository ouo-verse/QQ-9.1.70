package com.tencent.mobileqq.zplan.meme.frameanim.overlay;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.meme.frameanim.model.RecordErrorInfo;
import com.tencent.mobileqq.zplan.utils.ZDispatchers;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\u0006\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R%\u0010*\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010 R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)R\"\u00106\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewModel;", "Landroidx/lifecycle/ViewModel;", "", "needTimeout", "", SemanticAttributes.DbSystemValues.H2, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S1", "W1", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/a;", "errorDetail", "U1", "T1", "onCleared", "g2", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "X1", "()J", "preRecordLoadingTimeoutMs", BdhLogUtil.LogTag.Tag_Conn, ICustomDataEditor.STRING_ARRAY_PARAM_2, "recordTimeoutMs", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "isRecordingMut", "E", "isTimeOutMut", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "c2", "()Landroidx/lifecycle/LiveData;", "isShowingLoading", "G", "isShowingErrTipsMut", "H", "b2", "isShowingErrorTips", "", "I", "Z1", "()I", "setRecordErrorCode", "(I)V", "recordErrorCode", "<init>", "()V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZPlanAvatarOverlayViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy recordTimeoutMs;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isRecordingMut;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isTimeOutMut;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> isShowingLoading;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isShowingErrTipsMut;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> isShowingErrorTips;

    /* renamed from: I, reason: from kotlin metadata */
    private int recordErrorCode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy preRecordLoadingTimeoutMs;

    public ZPlanAvatarOverlayViewModel() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel$preRecordLoadingTimeoutMs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanFeatureSwitch.f369852a.I1());
            }
        });
        this.preRecordLoadingTimeoutMs = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel$recordTimeoutMs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanFeatureSwitch.f369852a.L1());
            }
        });
        this.recordTimeoutMs = lazy2;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        this.isRecordingMut = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
        this.isTimeOutMut = mutableLiveData2;
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel$isShowingLoading$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                invoke2(bool2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool2) {
                QLog.i("ZPlanAvatarOverlayViewModel", 1, ZPlanAvatarOverlayViewModel.this + ", isRecordingMut changed with " + bool2);
                MediatorLiveData<Pair<Boolean, Boolean>> mediatorLiveData2 = mediatorLiveData;
                Pair<Boolean, Boolean> value = mediatorLiveData2.getValue();
                mediatorLiveData2.setValue(TuplesKt.to(bool2, value != null ? value.getSecond() : null));
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarOverlayViewModel.d2(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel$isShowingLoading$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                invoke2(bool2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool2) {
                QLog.i("ZPlanAvatarOverlayViewModel", 1, ZPlanAvatarOverlayViewModel.this + ", isTimeOutMut changed with " + bool2);
                MediatorLiveData<Pair<Boolean, Boolean>> mediatorLiveData2 = mediatorLiveData;
                Pair<Boolean, Boolean> value = mediatorLiveData2.getValue();
                mediatorLiveData2.setValue(TuplesKt.to(value != null ? value.getFirst() : null, bool2));
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarOverlayViewModel.e2(Function1.this, obj);
            }
        });
        LiveData<Boolean> map = Transformations.map(mediatorLiveData, new Function() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.c
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean f26;
                f26 = ZPlanAvatarOverlayViewModel.f2((Pair) obj);
                return f26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(MediatorLiveData<Pai\u2026    false\n        }\n    }");
        this.isShowingLoading = map;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
        this.isShowingErrTipsMut = mutableLiveData3;
        this.isShowingErrorTips = mutableLiveData3;
    }

    private final void S1() {
        QLog.i("ZPlanAvatarOverlayViewModel", 1, this + ", cancel loading");
        JobKt__JobKt.cancelChildren$default(this.viewModelScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        MutableLiveData<Boolean> mutableLiveData = this.isRecordingMut;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.postValue(bool);
        this.isTimeOutMut.postValue(bool);
    }

    private final long X1() {
        return ((Number) this.preRecordLoadingTimeoutMs.getValue()).longValue();
    }

    private final long a2() {
        return ((Number) this.recordTimeoutMs.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean f2(Pair pair) {
        Boolean bool = (Boolean) pair.component1();
        Boolean bool2 = (Boolean) pair.component2();
        boolean z16 = false;
        if (bool != null && bool2 != null && bool.booleanValue() && bool2.booleanValue()) {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h2(boolean z16, Continuation<? super Unit> continuation) {
        ZPlanAvatarOverlayViewModel$startCountDown$1 zPlanAvatarOverlayViewModel$startCountDown$1;
        Object coroutine_suspended;
        int i3;
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel;
        if (continuation instanceof ZPlanAvatarOverlayViewModel$startCountDown$1) {
            zPlanAvatarOverlayViewModel$startCountDown$1 = (ZPlanAvatarOverlayViewModel$startCountDown$1) continuation;
            int i16 = zPlanAvatarOverlayViewModel$startCountDown$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarOverlayViewModel$startCountDown$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarOverlayViewModel$startCountDown$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarOverlayViewModel$startCountDown$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long X1 = X1();
                    zPlanAvatarOverlayViewModel$startCountDown$1.L$0 = this;
                    zPlanAvatarOverlayViewModel$startCountDown$1.Z$0 = z16;
                    zPlanAvatarOverlayViewModel$startCountDown$1.label = 1;
                    if (DelayKt.delay(X1, zPlanAvatarOverlayViewModel$startCountDown$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarOverlayViewModel = this;
                } else if (i3 == 1) {
                    z16 = zPlanAvatarOverlayViewModel$startCountDown$1.Z$0;
                    zPlanAvatarOverlayViewModel = (ZPlanAvatarOverlayViewModel) zPlanAvatarOverlayViewModel$startCountDown$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(zPlanAvatarOverlayViewModel$startCountDown$1.get$context());
                if (z16) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new ZPlanAvatarOverlayViewModel$startCountDown$2$1(zPlanAvatarOverlayViewModel, null), 3, null);
                }
                zPlanAvatarOverlayViewModel.isTimeOutMut.postValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
        }
        zPlanAvatarOverlayViewModel$startCountDown$1 = new ZPlanAvatarOverlayViewModel$startCountDown$1(this, continuation);
        Object obj2 = zPlanAvatarOverlayViewModel$startCountDown$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarOverlayViewModel$startCountDown$1.label;
        if (i3 != 0) {
        }
        CoroutineScope CoroutineScope2 = CoroutineScopeKt.CoroutineScope(zPlanAvatarOverlayViewModel$startCountDown$1.get$context());
        if (z16) {
        }
        zPlanAvatarOverlayViewModel.isTimeOutMut.postValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i2(Continuation<? super Unit> continuation) {
        ZPlanAvatarOverlayViewModel$startErrTimeout$1 zPlanAvatarOverlayViewModel$startErrTimeout$1;
        Object coroutine_suspended;
        int i3;
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel;
        if (continuation instanceof ZPlanAvatarOverlayViewModel$startErrTimeout$1) {
            zPlanAvatarOverlayViewModel$startErrTimeout$1 = (ZPlanAvatarOverlayViewModel$startErrTimeout$1) continuation;
            int i16 = zPlanAvatarOverlayViewModel$startErrTimeout$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanAvatarOverlayViewModel$startErrTimeout$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanAvatarOverlayViewModel$startErrTimeout$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanAvatarOverlayViewModel$startErrTimeout$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("ZPlanAvatarOverlayViewModel", 1, this + ", timeout config\uff1a" + a2());
                    long a26 = a2();
                    zPlanAvatarOverlayViewModel$startErrTimeout$1.L$0 = this;
                    zPlanAvatarOverlayViewModel$startErrTimeout$1.label = 1;
                    if (DelayKt.delay(a26, zPlanAvatarOverlayViewModel$startErrTimeout$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanAvatarOverlayViewModel = this;
                } else if (i3 == 1) {
                    zPlanAvatarOverlayViewModel = (ZPlanAvatarOverlayViewModel) zPlanAvatarOverlayViewModel$startErrTimeout$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                QLog.e("ZPlanAvatarOverlayViewModel", 1, zPlanAvatarOverlayViewModel + ", reach record time out, call onLoadingError manually.");
                zPlanAvatarOverlayViewModel.U1(new RecordErrorInfo(0, 0, -5000, 3, null));
                return Unit.INSTANCE;
            }
        }
        zPlanAvatarOverlayViewModel$startErrTimeout$1 = new ZPlanAvatarOverlayViewModel$startErrTimeout$1(this, continuation);
        Object obj2 = zPlanAvatarOverlayViewModel$startErrTimeout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanAvatarOverlayViewModel$startErrTimeout$1.label;
        if (i3 != 0) {
        }
        QLog.e("ZPlanAvatarOverlayViewModel", 1, zPlanAvatarOverlayViewModel + ", reach record time out, call onLoadingError manually.");
        zPlanAvatarOverlayViewModel.U1(new RecordErrorInfo(0, 0, -5000, 3, null));
        return Unit.INSTANCE;
    }

    public final void T1() {
        QLog.i("ZPlanAvatarOverlayViewModel", 1, this + ", onLoadingEnd");
        S1();
    }

    public final void U1(com.tencent.mobileqq.zplan.meme.frameanim.model.a errorDetail) {
        QLog.e("ZPlanAvatarOverlayViewModel", 1, this + ", onLoadingError.");
        S1();
        if (errorDetail instanceof RecordErrorInfo) {
            this.recordErrorCode = ((RecordErrorInfo) errorDetail).getErrorCode();
        }
        this.isShowingErrTipsMut.postValue(Boolean.TRUE);
    }

    public final void W1(boolean needTimeout) {
        QLog.i("ZPlanAvatarOverlayViewModel", 1, this + ", onLoadingStart.");
        S1();
        this.isRecordingMut.postValue(Boolean.TRUE);
        this.isShowingErrTipsMut.postValue(Boolean.FALSE);
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, ZDispatchers.f335734a.b(), null, new ZPlanAvatarOverlayViewModel$doOnLoadingStart$1(this, needTimeout, null), 2, null);
    }

    /* renamed from: Z1, reason: from getter */
    public final int getRecordErrorCode() {
        return this.recordErrorCode;
    }

    public final LiveData<Boolean> b2() {
        return this.isShowingErrorTips;
    }

    public final LiveData<Boolean> c2() {
        return this.isShowingLoading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        QLog.i("ZPlanAvatarOverlayViewModel", 1, this + ", ViewModel onCleared callback invoke.");
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    public final void g2() {
        this.recordErrorCode = 0;
    }
}
