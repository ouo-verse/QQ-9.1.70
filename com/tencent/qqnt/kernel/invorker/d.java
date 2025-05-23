package com.tencent.qqnt.kernel.invorker;

import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/d;", "", "", "listType", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "O0", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface d {
    void O0(int listType, int unreadCnt, @Nullable List<RecentContactInfo> changedList);
}
