package com.tencent.map.sdk.comps.offlinemap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OfflineItem {
    private String name;
    private int percentage;
    private String pinyin;
    private long size;
    private boolean upgrade = true;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineItem)) {
            return false;
        }
        OfflineItem offlineItem = (OfflineItem) obj;
        String str = this.name;
        if (str == null ? offlineItem.name != null : !str.equals(offlineItem.name)) {
            return false;
        }
        String str2 = this.pinyin;
        String str3 = offlineItem.pinyin;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        int i3;
        String str = this.name;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.pinyin;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public boolean isUpgrade() {
        return this.upgrade;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPercentage(int i3) {
        this.percentage = i3;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public void setSize(long j3) {
        this.size = j3;
    }

    public void setUpgrade(boolean z16) {
        this.upgrade = z16;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("OfflineItem{");
        stringBuffer.append("name='");
        stringBuffer.append(this.name);
        stringBuffer.append('\'');
        stringBuffer.append(", pinyin='");
        stringBuffer.append(this.pinyin);
        stringBuffer.append('\'');
        stringBuffer.append(", size=");
        stringBuffer.append(this.size);
        stringBuffer.append(", upgrade=");
        stringBuffer.append(this.upgrade);
        stringBuffer.append(", percentage=");
        stringBuffer.append(this.percentage);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
