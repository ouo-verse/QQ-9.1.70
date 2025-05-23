package com.tencent.qqnt.biz.lightbusiness;

import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/b;", "", "", "jsonString", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "getBusinessType", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    @Nullable
    Object a(@NotNull String jsonString);

    @NotNull
    LiteBusinessType getBusinessType();
}
