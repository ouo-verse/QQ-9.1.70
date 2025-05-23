package com.tencent.ecommerce.biz.retain.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J%\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/repo/ECRetainRepository;", "Lcom/tencent/ecommerce/biz/retain/repo/IECRetainRepository;", "", "spuId", "from", "", "b", "retainId", "", "isNeedRetain", "markRetainShowed", "markInvalidRetainID", "Lcom/tencent/ecommerce/biz/retain/repo/b;", "getRetainInfo", "asyncGetRetainInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshRetainInfo", "reportRetainPopup", "markPaySuccess", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRetainRepository implements IECRetainRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final ECRetainRepository f104121b = new ECRetainRepository();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    ECRetainRepository() {
    }

    private final void b(String spuId, String from) {
        if (spuId.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("spu_id", spuId);
        jSONObject.put("from", from);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new ECRetainRepository$reportRetainPopup$1(jSONObject, spuId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object a(String str, String str2, Continuation<? super ECRetainInfoModel> continuation) {
        ECRetainRepository$asyncGetRetainInfo$2 eCRetainRepository$asyncGetRetainInfo$2;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECRetainRepository$asyncGetRetainInfo$2) {
            eCRetainRepository$asyncGetRetainInfo$2 = (ECRetainRepository$asyncGetRetainInfo$2) continuation;
            int i16 = eCRetainRepository$asyncGetRetainInfo$2.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRetainRepository$asyncGetRetainInfo$2.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRetainRepository$asyncGetRetainInfo$2.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRetainRepository$asyncGetRetainInfo$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject = new JSONObject();
                    jSONObject.put("spu_id", str);
                    jSONObject.put("from", str2);
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECRetainRepository$asyncGetRetainInfo$response$1 eCRetainRepository$asyncGetRetainInfo$response$1 = new ECRetainRepository$asyncGetRetainInfo$response$1(str, objectRef, null);
                    eCRetainRepository$asyncGetRetainInfo$2.L$0 = str;
                    eCRetainRepository$asyncGetRetainInfo$2.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCRetainRepository$asyncGetRetainInfo$response$1, eCRetainRepository$asyncGetRetainInfo$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    str = (String) eCRetainRepository$asyncGetRetainInfo$2.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("get retain info, spuId:[");
                    sb5.append(str);
                    sb5.append("] type:[");
                    ECRetainInfoModel eCRetainInfoModel = (ECRetainInfoModel) eCNetworkResponse.b();
                    sb5.append(eCRetainInfoModel != null ? eCRetainInfoModel.type : null);
                    sb5.append(']');
                    cg0.a.b("Retain", sb5.toString());
                    a.f104126d.a((ECRetainInfoModel) eCNetworkResponse.b());
                    return (ECRetainInfoModel) eCNetworkResponse.b();
                }
                cg0.a.a("Retain", "getRetainInfo", "get retain info error, spuId:[" + str + "] code:[" + eCNetworkResponse.getCode() + "] msg:[" + eCNetworkResponse.getMessage() + ']');
                return null;
            }
        }
        eCRetainRepository$asyncGetRetainInfo$2 = new ECRetainRepository$asyncGetRetainInfo$2(this, continuation);
        Object obj2 = eCRetainRepository$asyncGetRetainInfo$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRetainRepository$asyncGetRetainInfo$2.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public Object asyncGetRetainInfo(String str, Continuation<? super ECRetainInfoModel> continuation) {
        return a(str, "500002", continuation);
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public ECRetainInfoModel getRetainInfo() {
        return a.f104126d.b();
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public boolean isNeedRetain(String retainId) {
        return a.f104126d.c(retainId);
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public void markInvalidRetainID(String retainId) {
        a.f104126d.d(retainId);
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public void markPaySuccess() {
        String str;
        ECRetainInfoModel retainInfo = getRetainInfo();
        if (retainInfo == null || (str = retainInfo.spuId) == null) {
            str = "";
        }
        a.f104126d.e();
        b(str, "500002");
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public void markRetainShowed(String retainId) {
        a.f104126d.f(retainId);
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public void refreshRetainInfo(String spuId) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new ECRetainRepository$refreshRetainInfo$1(spuId, null), 3, null);
    }

    @Override // com.tencent.ecommerce.biz.retain.repo.IECRetainRepository
    public void reportRetainPopup(String spuId) {
        b(spuId, "500002");
    }
}
