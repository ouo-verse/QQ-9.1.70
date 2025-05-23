package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {
    public static int a(RecentMatchChatListItem recentMatchChatListItem) {
        int i3 = recentMatchChatListItem.b().nState;
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 1) {
            return 2;
        }
        switch (recentMatchChatListItem.mStatus) {
            case 1:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 1;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 12;
            case 11:
                return 13;
            default:
                return 0;
        }
    }
}
