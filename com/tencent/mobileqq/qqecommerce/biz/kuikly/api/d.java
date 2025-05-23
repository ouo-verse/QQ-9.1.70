package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/d;", "", "", "resId", "", "validateResFile", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ c a(d dVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return dVar.a(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }

    @NotNull
    c a(@NotNull String resId, boolean validateResFile);
}
