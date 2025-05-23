package com.tencent.av.business.manager.magicface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FaceItem extends com.tencent.av.business.manager.pendant.c {
    private String attr;
    private String desc;
    private String icon_url;

    /* renamed from: id, reason: collision with root package name */
    private String f73323id;
    private String peerdeconame1;
    private int platform;
    private boolean predownload;
    private String res_md5;
    private String res_url;
    private String selfdeconame1;
    private String text;
    private boolean usable;
    private String version;
    private int vip_level;
    public String[] voice_text;
    private long voiceexpired;
    private String type = "";
    private boolean is_interact = true;
    private boolean isshow = true;
    public int lastPositionIndex = -1;

    public String getAttr() {
        return this.attr;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getDesc() {
        return this.desc;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getIconUrl() {
        return this.icon_url;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getId() {
        return this.f73323id;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getMd5() {
        return this.res_md5;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public int getPlatform() {
        return this.platform;
    }

    public boolean getPredownload() {
        return this.predownload;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getResUrl() {
        return this.res_url;
    }

    public String getText() {
        return this.text;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getVersion() {
        return this.version;
    }

    public int getVipLevel() {
        return this.vip_level;
    }

    public boolean isInteract() {
        return this.is_interact;
    }

    public boolean isSameType(String str) {
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase(this.type);
    }

    public boolean isShow() {
        return this.isshow;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public boolean isUsable() {
        return this.usable;
    }

    public void setAttr(String str) {
        this.attr = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIconUrl(String str) {
        this.icon_url = str;
    }

    public void setId(String str) {
        this.f73323id = str;
    }

    public void setIsInteract(boolean z16) {
        this.is_interact = z16;
    }

    public void setIsshow(boolean z16) {
        this.isshow = z16;
    }

    public void setPeerdeconame1(String str) {
        this.peerdeconame1 = str;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setPredownload(boolean z16) {
        this.predownload = z16;
    }

    public void setResMd5(String str) {
        this.res_md5 = str;
    }

    public void setResUrl(String str) {
        this.res_url = str;
    }

    public void setSelfdeconame1(String str) {
        this.selfdeconame1 = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public void setUsable(boolean z16) {
        this.usable = z16;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVipLevel(int i3) {
        this.vip_level = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.voice_text != null) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.voice_text;
                if (i3 >= strArr.length) {
                    break;
                }
                sb5.append(strArr[i3]);
                sb5.append("|");
                i3++;
            }
        }
        return "FaceItem{id = " + this.f73323id + ", vip_level = " + this.vip_level + ", text = " + this.text + ", predownload = " + this.predownload + ", res_url = " + this.res_url + ", res_md5 = " + this.res_md5 + ", icon_url = " + this.icon_url + ", peerdeconame1 = " + this.peerdeconame1 + ", selfdeconame1 = " + this.selfdeconame1 + ", type = " + this.type + ", attr = " + this.attr + ", is_interact = " + this.is_interact + ", platform = " + this.platform + ", usable = " + this.usable + ", isshow = " + this.isshow + ", voiceexpired = " + this.voiceexpired + ", desc = " + this.desc + ", voice_text = " + ((Object) sb5) + ", isDownloading = " + this.isDownloading + '}';
    }
}
