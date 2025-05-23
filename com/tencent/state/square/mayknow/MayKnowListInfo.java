package com.tencent.state.square.mayknow;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowListInfo;", "", "cookies", "", "isEnd", "", "list", "", "Lcom/tencent/state/square/mayknow/MayKnowUser;", "([BZLjava/util/List;)V", "getCookies", "()[B", "()Z", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowListInfo {
    private final byte[] cookies;
    private final boolean isEnd;
    private final List<MayKnowUser> list;

    public MayKnowListInfo(byte[] cookies, boolean z16, List<MayKnowUser> list) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(list, "list");
        this.cookies = cookies;
        this.isEnd = z16;
        this.list = list;
    }

    public final byte[] getCookies() {
        return this.cookies;
    }

    public final List<MayKnowUser> getList() {
        return this.list;
    }

    /* renamed from: isEnd, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }
}
