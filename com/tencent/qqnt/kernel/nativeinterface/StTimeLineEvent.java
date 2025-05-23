package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StTimeLineEvent {
    public long beginTime;
    public int bindingType;
    public boolean disable;
    public long endTime;
    public boolean isSpecialDayNode;
    public int itemCount;
    public int type;
    public String title = "";
    public String content = "";
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public int getBindingType() {
        return this.bindingType;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getDisable() {
        return this.disable;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public boolean getIsSpecialDayNode() {
        return this.isSpecialDayNode;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }
}
