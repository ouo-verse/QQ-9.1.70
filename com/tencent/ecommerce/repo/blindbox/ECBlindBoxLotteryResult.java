package com.tencent.ecommerce.repo.blindbox;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/repo/blindbox/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "hasResult", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "resultData", "c", "()Z", "shouldRefund", "<init>", "(ZLorg/json/JSONObject;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.blindbox.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECBlindBoxLotteryResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean hasResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject resultData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean shouldRefund;

    public ECBlindBoxLotteryResult(boolean z16, JSONObject jSONObject, boolean z17) {
        this.hasResult = z16;
        this.resultData = jSONObject;
        this.shouldRefund = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getShouldRefund() {
        return this.shouldRefund;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.hasResult;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        JSONObject jSONObject = this.resultData;
        int hashCode = (i3 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        boolean z17 = this.shouldRefund;
        return hashCode + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ECBlindBoxLotteryResult(hasResult=" + this.hasResult + ", resultData=" + this.resultData + ", shouldRefund=" + this.shouldRefund + ")";
    }

    public /* synthetic */ ECBlindBoxLotteryResult(boolean z16, JSONObject jSONObject, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, jSONObject, (i3 & 4) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECBlindBoxLotteryResult)) {
            return false;
        }
        ECBlindBoxLotteryResult eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) other;
        return this.hasResult == eCBlindBoxLotteryResult.hasResult && Intrinsics.areEqual(this.resultData, eCBlindBoxLotteryResult.resultData) && this.shouldRefund == eCBlindBoxLotteryResult.shouldRefund;
    }
}
