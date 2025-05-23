package com.tencent.qqnt.chats.main.vm.datasource.preprocess;

import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contactList", "", "isGuildUpdate", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface d {
    @NotNull
    List<Long> a(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> contactList, boolean isGuildUpdate);
}
