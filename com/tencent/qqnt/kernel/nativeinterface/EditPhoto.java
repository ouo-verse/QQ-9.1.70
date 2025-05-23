package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class EditPhoto {
    public long shootTime;
    public String picId = "";
    public String name = "";
    public String desc = "";
    public ArrayList<Long> opmask = new ArrayList<>();
    public StLBS lbs = new StLBS();

    public String getDesc() {
        return this.desc;
    }

    public StLBS getLbs() {
        return this.lbs;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Long> getOpmask() {
        return this.opmask;
    }

    public String getPicId() {
        return this.picId;
    }

    public long getShootTime() {
        return this.shootTime;
    }
}
