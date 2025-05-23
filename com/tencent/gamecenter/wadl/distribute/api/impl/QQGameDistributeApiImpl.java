package com.tencent.gamecenter.wadl.distribute.api.impl;

import android.content.Context;
import com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi;
import com.tencent.gamecenter.wadl.distribute.widget.DistributeButton;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.gamecenter.wadl.distribute.widget.KuiklyDistributeButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/api/impl/QQGameDistributeApiImpl;", "Lcom/tencent/gamecenter/wadl/distribute/api/IQQGameDistributeApi;", "()V", "createButton", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "context", "Landroid/content/Context;", "createKuiklyButton", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class QQGameDistributeApiImpl implements IQQGameDistributeApi {
    @Override // com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi
    @NotNull
    public IDistributeButton createButton(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DistributeButton(context);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi
    @NotNull
    public IDistributeButton createKuiklyButton(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new KuiklyDistributeButton(context);
    }
}
