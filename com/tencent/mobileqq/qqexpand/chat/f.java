package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import expand.common.MatchedInfo;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f {
    public static int a(MatchedInfo matchedInfo) {
        if (matchedInfo == null || matchedInfo.get() == null || !matchedInfo.get().MatchSrcId.has()) {
            return 11;
        }
        int i3 = matchedInfo.get().MatchSrcId.get();
        if (i3 == 1) {
            return 7;
        }
        if (i3 == 2) {
            return 8;
        }
        if (i3 == 3) {
            return 9;
        }
        if (i3 == 4) {
            return 10;
        }
        if (i3 != 12) {
            return i3 != 15 ? 11 : 9;
        }
        return 7;
    }

    public static void b(BaseQQAppInterface baseQQAppInterface, String str, com.tencent.mobileqq.qqexpand.network.d dVar) {
    }
}
