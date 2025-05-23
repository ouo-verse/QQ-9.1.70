package com.tencent.mobileqq.qqecommerce.biz.game.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqecommerce.biz.game.api.IECGameButtonApi;
import kf2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/game/api/impl/ECGameButtonApiImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/game/api/IECGameButtonApi;", "()V", "createGameButton", "Landroid/view/View;", "context", "Landroid/content/Context;", "params", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECGameButtonApiImpl implements IECGameButtonApi {
    @Override // com.tencent.mobileqq.qqecommerce.biz.game.api.IECGameButtonApi
    public View createGameButton(Context context, String params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        return new a().createGameButton(context, params);
    }
}
