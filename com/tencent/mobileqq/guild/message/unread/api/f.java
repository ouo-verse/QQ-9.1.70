package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/f;", "", "", "unreadCntUpType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "Lkotlin/collections/ArrayList;", "unreadInfos", "Lcom/tencent/mobileqq/guild/message/unread/api/DataSource;", "dataSource", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface f {
    void a(int unreadCntUpType, @NotNull ArrayList<UnreadInfo> unreadInfos, @NotNull DataSource dataSource);
}
