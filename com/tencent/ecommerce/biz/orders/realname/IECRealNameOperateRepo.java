package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "", "", "hasRealName", "", "updateReadNameAccountFlag", "Lcom/tencent/ecommerce/biz/orders/realname/a;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo$a;", "createAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "accountId", "deleteAccounts", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHasRealNameAccount", "()Z", "hasRealNameAccount", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECRealNameOperateRepo {
    Object createAccount(RealNameAccount realNameAccount, Continuation<? super ECNetworkResponse<CreateRealNameAccountWrapper>> continuation);

    Object deleteAccounts(String str, Continuation<? super Boolean> continuation);

    boolean getHasRealNameAccount();

    void updateReadNameAccountFlag(boolean hasRealName);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "alertMsg", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "b", "Lcom/tencent/ecommerce/biz/orders/realname/a;", QCircleAlphaUserReporter.KEY_USER, "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/realname/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CreateRealNameAccountWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String alertMsg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final RealNameAccount user;

        public CreateRealNameAccountWrapper(String str, RealNameAccount realNameAccount) {
            this.alertMsg = str;
            this.user = realNameAccount;
        }

        public int hashCode() {
            String str = this.alertMsg;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            RealNameAccount realNameAccount = this.user;
            return hashCode + (realNameAccount != null ? realNameAccount.hashCode() : 0);
        }

        public String toString() {
            return "CreateRealNameAccountWrapper(alertMsg=" + this.alertMsg + ", user=" + this.user + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateRealNameAccountWrapper)) {
                return false;
            }
            CreateRealNameAccountWrapper createRealNameAccountWrapper = (CreateRealNameAccountWrapper) other;
            return Intrinsics.areEqual(this.alertMsg, createRealNameAccountWrapper.alertMsg) && Intrinsics.areEqual(this.user, createRealNameAccountWrapper.user);
        }
    }
}
