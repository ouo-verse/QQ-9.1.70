package com.tencent.mobileqq.qqecommerce.biz.qq;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00128\u0010\u001e\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\fRI\u0010\u001e\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u000e\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qq/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "troopUin", "b", "d", "troopName", "c", "I", "()I", "sourceId", "authSign", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.qq.f, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class JoinTroopData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String troopName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sourceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String authSign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function2<Integer, String, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public JoinTroopData(String troopUin, String troopName, int i3, String authSign, Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(authSign, "authSign");
        this.troopUin = troopUin;
        this.troopName = troopName;
        this.sourceId = i3;
        this.authSign = authSign;
        this.callback = function2;
    }

    /* renamed from: a, reason: from getter */
    public final String getAuthSign() {
        return this.authSign;
    }

    public final Function2<Integer, String, Unit> b() {
        return this.callback;
    }

    /* renamed from: c, reason: from getter */
    public final int getSourceId() {
        return this.sourceId;
    }

    /* renamed from: d, reason: from getter */
    public final String getTroopName() {
        return this.troopName;
    }

    /* renamed from: e, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public int hashCode() {
        int hashCode = ((((((this.troopUin.hashCode() * 31) + this.troopName.hashCode()) * 31) + this.sourceId) * 31) + this.authSign.hashCode()) * 31;
        Function2<Integer, String, Unit> function2 = this.callback;
        return hashCode + (function2 == null ? 0 : function2.hashCode());
    }

    public String toString() {
        return "JoinTroopData(troopUin=" + this.troopUin + ", troopName=" + this.troopName + ", sourceId=" + this.sourceId + ", authSign=" + this.authSign + ", callback=" + this.callback + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinTroopData)) {
            return false;
        }
        JoinTroopData joinTroopData = (JoinTroopData) other;
        return Intrinsics.areEqual(this.troopUin, joinTroopData.troopUin) && Intrinsics.areEqual(this.troopName, joinTroopData.troopName) && this.sourceId == joinTroopData.sourceId && Intrinsics.areEqual(this.authSign, joinTroopData.authSign) && Intrinsics.areEqual(this.callback, joinTroopData.callback);
    }
}
