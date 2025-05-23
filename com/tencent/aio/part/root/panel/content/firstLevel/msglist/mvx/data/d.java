package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "", "Lcom/tencent/aio/data/msglist/a;", "b", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;)Ljava/util/List;", "list", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "c", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;)Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "Landroid/os/Bundle;", "a", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;)Landroid/os/Bundle;", "extra", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d {
    @Nullable
    public static final Bundle a(@NotNull c extra) {
        Intrinsics.checkNotNullParameter(extra, "$this$extra");
        return extra.b().a();
    }

    @NotNull
    public static final List<com.tencent.aio.data.msglist.a> b(@NotNull c list) {
        Intrinsics.checkNotNullParameter(list, "$this$list");
        return list.b().c();
    }

    @NotNull
    public static final IMsgListRepository.MsgListRepoOpType c(@NotNull c opType) {
        Intrinsics.checkNotNullParameter(opType, "$this$opType");
        return opType.b().d();
    }
}
