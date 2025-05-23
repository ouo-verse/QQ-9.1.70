package com.tencent.mobileqq.vas.tofu.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView;
import com.tencent.mobileqq.vas.tofu.IBeancurdFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/tofu/impl/BeancurdFactoryImpl;", "Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory$a;", "getDressShowBeancurdView", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BeancurdFactoryImpl implements IBeancurdFactory {
    @Override // com.tencent.mobileqq.vas.tofu.IBeancurdFactory
    @NotNull
    public IBeancurdFactory.a getDressShowBeancurdView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DressShowBeancurdView(context);
    }
}
