package com.tencent.mobileqq.matchfriend.reborn.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.matchfriend.aio.utils.c;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerMutualMarkApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import k72.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/impl/QQStrangerMutualMarkApiImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerMutualMarkApi;", "()V", "showMutualDetailDialog", "", "ctx", "Landroid/app/Activity;", "model", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerMutualMarkApiImpl implements IQQStrangerMutualMarkApi {
    @Override // com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerMutualMarkApi
    public void showMutualDetailDialog(Activity ctx, QQStrangerInteractiveMarkModel model) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(model, "model");
        if (ctx.isFinishing() || ctx.isDestroyed()) {
            return;
        }
        c.f243986a.j(model.level, model.subtype);
        new d(ctx, model).show();
    }
}
