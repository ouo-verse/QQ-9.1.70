package com.tencent.mobileqq.tvideo.account.tenvideo.cache;

import bu2.TVideoAccountInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/cache/a;", "", "Lbu2/b;", "getAccount", "account", "", "a", "clearAccount", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    void a(@NotNull TVideoAccountInfo account);

    void clearAccount();

    @Nullable
    TVideoAccountInfo getAccount();
}
