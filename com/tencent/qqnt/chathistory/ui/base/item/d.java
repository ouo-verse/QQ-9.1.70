package com.tencent.qqnt.chathistory.ui.base.item;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "T", "", "", "getRequestCount", "()I", "requestCount", "", "getData", "()Ljava/util/List;", "data", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface d<T> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static <T> boolean a(@NotNull d<T> dVar) {
            if (dVar.getData().size() < dVar.getRequestCount()) {
                return false;
            }
            return true;
        }
    }

    @NotNull
    List<T> getData();

    int getRequestCount();
}
