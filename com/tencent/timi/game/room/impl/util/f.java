package com.tencent.timi.game.room.impl.util;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    public static String a(int i3) {
        if (i3 != 1) {
            switch (i3) {
                case 5:
                    return "ROOM_TYPE_COMMUNITY";
                case 6:
                    return "ROOM_TYPE_PUBG";
                case 7:
                    return "ROOM_TYPE_CODM";
                case 8:
                    return "ROOM_TYPE_SPEEDM";
                case 9:
                    return "ROOM_TYPE_CFM";
                default:
                    return "ROOM_TYPE_" + i3;
            }
        }
        return "ROOM_TYPE_SMOBA";
    }
}
