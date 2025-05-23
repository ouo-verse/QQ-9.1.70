package com.tencent.qqnt.msg.unread;

import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/msg/unread/a;", "", "", "unreadCount", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadInfo", "", "a", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {
    void a(int unreadCount, @NotNull HashMap<String, UnreadCntInfo> unreadInfo);
}
