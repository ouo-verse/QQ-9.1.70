package com.tencent.gamematrix.gmcg.webrtc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MobileButtonEvent {
    public int buttonType;
    public int msgType;
    public int pId;
    public boolean pLast;
    public short pX;
    public short pY;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ButtonType {
        public static final int BACK = 2;
        public static final int HOME = 0;
        public static final int MENU = 1;
        public static final int VOLUMEDOWN = 3;
        public static final int VOLUMEUP = 4;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface MsgType {
        public static final int BUTTONDOWN = 83;
        public static final int BUTTONUP = 84;
        public static final int TOUCHDOWN = 80;
        public static final int TOUCHMOVE = 82;
        public static final int TOUCHUP = 81;
    }
}
