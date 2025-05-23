package com.tencent.ecommerce.biz.register.officialAccountFollowedChecker;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import com.tencent.ecommerce.base.network.service.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedRepository;", "", "", "accountType", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "b", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountFollowScene", "a", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAccountFollowedRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final ECAccountFollowedRepository f103993a = new ECAccountFollowedRepository();

    ECAccountFollowedRepository() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(int i3, int i16, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECAccountFollowedRepository$followAccount$1 eCAccountFollowedRepository$followAccount$1;
        Object coroutine_suspended;
        int i17;
        JSONObject jSONObject;
        if (continuation instanceof ECAccountFollowedRepository$followAccount$1) {
            eCAccountFollowedRepository$followAccount$1 = (ECAccountFollowedRepository$followAccount$1) continuation;
            int i18 = eCAccountFollowedRepository$followAccount$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                eCAccountFollowedRepository$followAccount$1.label = i18 - Integer.MIN_VALUE;
                Object obj = eCAccountFollowedRepository$followAccount$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = eCAccountFollowedRepository$followAccount$1.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("official_account", i3);
                    jSONObject2.put("scene", i16);
                    b bVar = b.f100803a;
                    eCAccountFollowedRepository$followAccount$1.L$0 = jSONObject2;
                    eCAccountFollowedRepository$followAccount$1.label = 1;
                    Object e16 = a.e("trpc.ecom.official_account_writer.OfficialAccountWriter", "/trpc.ecom.official_account_writer.OfficialAccountWriter/Follow", bVar, jSONObject2, eCAccountFollowedRepository$followAccount$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i17 == 1) {
                    jSONObject = (JSONObject) eCAccountFollowedRepository$followAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECAccountFollowedRepository", "followAccount service=trpc.ecom.official_account_writer.OfficialAccountWriter, method=/trpc.ecom.official_account_writer.OfficialAccountWriter/Follow, params=" + jSONObject + ", response=" + eCNetworkResponse);
                return eCNetworkResponse;
            }
        }
        eCAccountFollowedRepository$followAccount$1 = new ECAccountFollowedRepository$followAccount$1(this, continuation);
        Object obj2 = eCAccountFollowedRepository$followAccount$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = eCAccountFollowedRepository$followAccount$1.label;
        if (i17 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECAccountFollowedRepository", "followAccount service=trpc.ecom.official_account_writer.OfficialAccountWriter, method=/trpc.ecom.official_account_writer.OfficialAccountWriter/Follow, params=" + jSONObject + ", response=" + eCNetworkResponse2);
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(int i3, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECAccountFollowedRepository$hasUserFollowedAccount$1 eCAccountFollowedRepository$hasUserFollowedAccount$1;
        Object coroutine_suspended;
        int i16;
        JSONObject jSONObject;
        if (continuation instanceof ECAccountFollowedRepository$hasUserFollowedAccount$1) {
            eCAccountFollowedRepository$hasUserFollowedAccount$1 = (ECAccountFollowedRepository$hasUserFollowedAccount$1) continuation;
            int i17 = eCAccountFollowedRepository$hasUserFollowedAccount$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCAccountFollowedRepository$hasUserFollowedAccount$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCAccountFollowedRepository$hasUserFollowedAccount$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCAccountFollowedRepository$hasUserFollowedAccount$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("official_account", i3);
                    b bVar = b.f100803a;
                    eCAccountFollowedRepository$hasUserFollowedAccount$1.L$0 = jSONObject2;
                    eCAccountFollowedRepository$hasUserFollowedAccount$1.label = 1;
                    Object e16 = a.e("trpc.ecom.official_account_reader.OfficialAccountReader", "/trpc.ecom.official_account_reader.OfficialAccountReader/IsUserFollow", bVar, jSONObject2, eCAccountFollowedRepository$hasUserFollowedAccount$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i16 == 1) {
                    jSONObject = (JSONObject) eCAccountFollowedRepository$hasUserFollowedAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECAccountFollowedRepository", "followAccount service=trpc.ecom.official_account_reader.OfficialAccountReader, method=/trpc.ecom.official_account_reader.OfficialAccountReader/IsUserFollow, params=" + jSONObject + ", response=" + eCNetworkResponse);
                return eCNetworkResponse;
            }
        }
        eCAccountFollowedRepository$hasUserFollowedAccount$1 = new ECAccountFollowedRepository$hasUserFollowedAccount$1(this, continuation);
        Object obj2 = eCAccountFollowedRepository$hasUserFollowedAccount$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCAccountFollowedRepository$hasUserFollowedAccount$1.label;
        if (i16 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECAccountFollowedRepository", "followAccount service=trpc.ecom.official_account_reader.OfficialAccountReader, method=/trpc.ecom.official_account_reader.OfficialAccountReader/IsUserFollow, params=" + jSONObject + ", response=" + eCNetworkResponse2);
        return eCNetworkResponse2;
    }
}
