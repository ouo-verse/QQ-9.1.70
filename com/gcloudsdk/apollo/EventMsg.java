package com.gcloudsdk.apollo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EventMsg {
    public static final int CMD_BIND = 2;
    public static final int CMD_INIT_CM = 255;
    public static final int CMD_WARM = 1;
    public int arg1;
    public int arg2;
    public int cmd;
    public byte[] data;
    public String strarg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventMsg(int i3, int i16, int i17, String str) {
        this.cmd = i3;
        this.arg1 = i16;
        this.arg2 = i17;
        this.strarg = str;
    }
}
