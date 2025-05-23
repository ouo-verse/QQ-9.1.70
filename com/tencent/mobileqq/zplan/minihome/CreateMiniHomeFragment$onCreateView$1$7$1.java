package com.tencent.mobileqq.zplan.minihome;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$onCreateView$1$7$1", f = "CreateMiniHomeFragment.kt", i = {0, 1, 1}, l = {509, 363}, m = "invokeSuspend", n = {"choosing", "choosing", "choosingDesc"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes34.dex */
public final class CreateMiniHomeFragment$onCreateView$1$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zplan.minihome.view.h $adapter;
    final /* synthetic */ MutableStateFlow<r55.b[]> $source;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreateMiniHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a implements nk3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f334247a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f334247a = cancellableContinuation;
        }

        @Override // nk3.a
        public final void onResult(boolean z16) {
            this.f334247a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateMiniHomeFragment$onCreateView$1$7$1(com.tencent.mobileqq.zplan.minihome.view.h hVar, MutableStateFlow<r55.b[]> mutableStateFlow, CreateMiniHomeFragment createMiniHomeFragment, Continuation<? super CreateMiniHomeFragment$onCreateView$1$7$1> continuation) {
        super(2, continuation);
        this.$adapter = hVar;
        this.$source = mutableStateFlow;
        this.this$0 = createMiniHomeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateMiniHomeFragment$onCreateView$1$7$1(this.$adapter, this.$source, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        Integer num;
        r55.a aVar;
        CreateMiniHomeSource createMiniHomeSource;
        String Uh;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Integer choosing = this.$adapter.getChoosing();
            if (choosing == null) {
                QQToast.makeText((Context) null, 1, "\u521b\u5efa\u5931\u8d25\uff0c\u672a\u9009\u4e2d\u573a\u666f", 0).show();
                return Unit.INSTANCE;
            }
            this.L$0 = choosing;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).requestSetZPlanMiniHomeSettingSwitch(true, new a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            num = choosing;
            obj = result;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    aVar = (r55.a) this.L$1;
                    num = (Integer) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        QQToast.makeText((Context) null, 1, "\u521b\u5efa\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 0).show();
                        return Unit.INSTANCE;
                    }
                    byte[] bArr = aVar.f430776d;
                    Intrinsics.checkNotNullExpressionValue(bArr, "choosingDesc.roomDescJson");
                    String str = new String(bArr, Charsets.UTF_8);
                    String str2 = aVar.f430773a;
                    Intrinsics.checkNotNullExpressionValue(str2, "choosingDesc.hash");
                    String str3 = aVar.f430774b;
                    Intrinsics.checkNotNullExpressionValue(str3, "choosingDesc.coverUrl");
                    String str4 = aVar.f430775c;
                    Intrinsics.checkNotNullExpressionValue(str4, "choosingDesc.darkCoverUrl");
                    ao aoVar = new ao(str2, str3, str4, str);
                    QLog.i("CreateMiniHomeFragment", 1, "save roomDesc: " + aoVar);
                    ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(String.valueOf(bb.f335811a.e()), aoVar);
                    QQToast.makeText(this.this$0.getActivity(), 2, "\u521b\u5efa\u6210\u529f", 0).show();
                    ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).saveHasCreatedMiniHome(2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("zplan_room_name", this.$source.getValue()[num.intValue()].f430778a);
                    VideoReport.reportEvent("clck", this.this$0.Rh().f398949i, hashMap);
                    createMiniHomeSource = this.this$0.createHomeSource;
                    if (createMiniHomeSource == CreateMiniHomeSource.MINI_CONNECT && ZPlanQQMC.INSTANCE.destroyMiniConnectWhenJumpOut()) {
                        Uh = this.this$0.Uh();
                        if (Uh.length() > 0) {
                            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                            Context requireContext = this.this$0.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                            iZPlanApi.launchScheme(requireContext, Uh);
                        }
                    }
                    this.this$0.requireActivity().setResult(-1);
                    this.this$0.requireActivity().finish();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            num = (Integer) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            QQToast.makeText((Context) null, 1, "\u521b\u5efa\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 0).show();
            return Unit.INSTANCE;
        }
        r55.a aVar2 = this.$source.getValue()[num.intValue()].f430785h;
        String str5 = aVar2.f430773a;
        Intrinsics.checkNotNullExpressionValue(str5, "choosingDesc.hash");
        this.L$0 = num;
        this.L$1 = aVar2;
        this.label = 2;
        Object l3 = MiniHomeNetworkKt.l(str5, this);
        if (l3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        aVar = aVar2;
        obj = l3;
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateMiniHomeFragment$onCreateView$1$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
