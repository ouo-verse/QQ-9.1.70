package com.tencent.mobileqq.listentogether.player;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    public static String a(int i3) {
        switch (i3) {
            case 0:
                return " IDLE ";
            case 1:
                return " BUFFERING ";
            case 2:
                return " PLAYING ";
            case 3:
                return " PAUSE ";
            case 4:
                return " STOP ";
            case 5:
                return " ERROR_INTERNAL ";
            case 6:
                return " NETWORK_INTERRUPT ";
            case 7:
                return " ERROR_FOCUS ";
            case 8:
                return " COMPLETION ";
            default:
                return " Unknow playState ";
        }
    }
}
