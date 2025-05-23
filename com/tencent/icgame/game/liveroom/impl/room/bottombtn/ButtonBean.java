package com.tencent.icgame.game.liveroom.impl.room.bottombtn;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ButtonBean implements Serializable {
    public static final int TYPE_LOCAL = 2;
    public static final int TYPE_OPERATE = 1;
    private ep4.a bottomItem;
    private String name;
    private int resourceId;
    private int type;

    public ButtonBean(int i3, int i16, String str) {
        this.type = i3;
        this.resourceId = i16;
        this.name = str;
    }

    public ep4.a getBottomItem() {
        return this.bottomItem;
    }

    public String getName() {
        return this.name;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public int getType() {
        return this.type;
    }

    public ButtonBean(int i3, ep4.a aVar) {
        this.type = i3;
        this.bottomItem = aVar;
    }
}
