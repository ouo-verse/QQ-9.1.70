package com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "otherBindData", "", "a", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    public static final boolean a(@Nullable c cVar, @Nullable c cVar2) {
        if (cVar == null) {
            if (cVar2 == null) {
                return true;
            }
            return false;
        }
        if (cVar2 == null) {
            return false;
        }
        if (cVar2.b() == cVar.b() && cVar2.d() == cVar.d() && cVar2.c() == cVar.c() && cVar2.a() == cVar.a()) {
            return true;
        }
        return false;
    }
}
