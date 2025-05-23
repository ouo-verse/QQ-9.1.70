package com.tencent.mm.sdk.storage.mvvm;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.luggage.wxa.xn.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0005*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\nB\u0011\b\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mm/sdk/storage/mvvm/MvvmStorage;", "Lcom/tencent/luggage/wxa/xn/a;", "T", "Lcom/tencent/luggage/wxa/xn/g;", "", "e", "Lcom/tencent/luggage/wxa/yn/a;", "dbProvider", "<init>", "(Lcom/tencent/luggage/wxa/yn/a;)V", "a", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public abstract class MvvmStorage<T extends a> extends g {
    @Keep
    public MvvmStorage(@NotNull com.tencent.luggage.wxa.yn.a dbProvider) {
        Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
    }

    @Override // com.tencent.luggage.wxa.xn.g
    public String e() {
        return "MicroMsg.Mvvm.MMLiveStorage";
    }
}
