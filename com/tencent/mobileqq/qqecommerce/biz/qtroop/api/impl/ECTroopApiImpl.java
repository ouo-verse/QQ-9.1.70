package com.tencent.mobileqq.qqecommerce.biz.qtroop.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi;
import com.tencent.mobileqq.qqecommerce.biz.qtroop.api.IECTroopApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f28\u0010\r\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qtroop/api/impl/ECTroopApiImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/qtroop/api/IECTroopApi;", "()V", "joinTroop", "", "context", "Landroid/content/Context;", "troopUin", "", "troopName", "authSign", "sourceId", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECTroopApiImpl implements IECTroopApi {
    @Override // com.tencent.mobileqq.qqecommerce.biz.qtroop.api.IECTroopApi
    public void joinTroop(Context context, String troopUin, String troopName, String authSign, int sourceId, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(authSign, "authSign");
        new ECQQApi().o(context, troopUin, troopName, authSign, sourceId, callback);
    }
}
