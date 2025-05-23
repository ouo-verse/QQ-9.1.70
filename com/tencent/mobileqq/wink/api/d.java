package com.tencent.mobileqq.wink.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/d;", "", "", "getShareType", "", "getShareUrl", "Lkotlin/Function2;", "", "", "a", "Lkotlin/Function0;", "b", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface d {
    @Nullable
    Function2<String, Boolean, Unit> a();

    @Nullable
    Function0<Unit> b();

    int getShareType();

    @NotNull
    String getShareUrl();
}
