package com.tencent.av.business.manager.magicface;

/* loaded from: classes3.dex */
public class MagicfaceDataPendantJason {
    public static final String BELONG_TO_BOTH = "both";
    public static final String BELONG_TO_RECEIVER = "reciever";
    public static final String BELONG_TO_SENDER = "sender";
    public static final String TRIGGER_HIT = "hit";
    public static final String TRIGGER_MISS = "miss";
    public String name = null;
    public String belongto = null;
    public String trigger = null;
    public int startframe = 0;
    public int duration = 3;
    public boolean mirror = false;

    public String toString() {
        return "MagicfaceDataPendantJason{name='" + this.name + "', belongto='" + this.belongto + "', trigger='" + this.trigger + "', startframe=" + this.startframe + ", duration=" + this.duration + ", mirror=" + this.mirror + '}';
    }
}
