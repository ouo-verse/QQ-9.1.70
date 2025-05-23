package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/y;", "", "", com.tencent.luggage.wxa.c8.c.G, "itemCount", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "Lcom/tencent/mobileqq/aio/msglist/payload/a;", "Lkotlin/collections/HashMap;", "payLoad", "", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface y {
    void f(int pos, int itemCount, @Nullable HashMap<AIOMsgItemPayloadType, com.tencent.mobileqq.aio.msglist.payload.a> payLoad);
}
