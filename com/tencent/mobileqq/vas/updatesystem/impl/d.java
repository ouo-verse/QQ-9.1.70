package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.vas.VipNtMMKV;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/impl/d;", "Lsw4/e;", "", "key", "value", "", "encodeString", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d implements sw4.e {
    @Override // sw4.e
    @Nullable
    public String a(@Nullable String key) {
        return VipNtMMKV.Companion.getCommon$default(VipNtMMKV.INSTANCE, null, 1, null).decodeString(key, "");
    }

    @Override // sw4.e
    public void encodeString(@Nullable String key, @Nullable String value) {
        VipNtMMKV.Companion.getCommon$default(VipNtMMKV.INSTANCE, null, 1, null).encodeString(key, value);
    }
}
