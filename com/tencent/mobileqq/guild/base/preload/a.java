package com.tencent.mobileqq.guild.base.preload;

import com.tencent.biz.richframework.layoutinflater.RFWInflateType;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/base/preload/a;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;", "Lcom/tencent/biz/richframework/layoutinflater/RFWInflateType;", "getInflateMode", "", "a", "Ljava/lang/String;", "from", "b", "Lcom/tencent/biz/richframework/layoutinflater/RFWInflateType;", "inflateMode", "<init>", "(Ljava/lang/String;Lcom/tencent/biz/richframework/layoutinflater/RFWInflateType;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements RFWLayoutLoaderStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWInflateType inflateMode;

    public a(@NotNull String from, @NotNull RFWInflateType inflateMode) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(inflateMode, "inflateMode");
        this.from = from;
        this.inflateMode = inflateMode;
    }

    @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy
    @NotNull
    public RFWInflateType getInflateMode() {
        return this.inflateMode;
    }
}
