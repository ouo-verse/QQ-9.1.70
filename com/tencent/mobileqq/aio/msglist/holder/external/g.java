package com.tencent.mobileqq.aio.msglist.holder.external;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/external/g;", "", "", "type", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        @Nullable
        public static c a(@NotNull g gVar, @NotNull String type, @NotNull e helper) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(helper, "helper");
            return null;
        }

        @Nullable
        public static d b(@NotNull g gVar, @NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return null;
        }
    }

    @Nullable
    c a(@NotNull String type, @NotNull e helper);

    @Nullable
    d b(@NotNull String type);
}
