package com.tencent.state.utils;

import com.tencent.state.service.VasStatusSquareService;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/utils/CachePath;", "", "url", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "IndexUserList", "ChatLandEnterRoom1", "ChatLandEnterRoom2", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum CachePath {
    IndexUserList(VasStatusSquareService.METHOD_GET_USER_LIST),
    ChatLandEnterRoom1("ChatLandEnterRoom_1004"),
    ChatLandEnterRoom2("ChatLandEnterRoom_1005");

    private final String url;

    CachePath(String str) {
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
