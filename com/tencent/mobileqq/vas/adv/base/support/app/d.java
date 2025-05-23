package com.tencent.mobileqq.vas.adv.base.support.app;

import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface d {
    void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16);

    void b(int returnCode, @NotNull byte[] rspBytes);
}
