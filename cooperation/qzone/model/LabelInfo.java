package cooperation.qzone.model;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LabelInfo implements Serializable, Comparable {

    /* renamed from: id, reason: collision with root package name */
    public String f390867id;
    public String name;
    public String rank;
    public boolean hasSelected = false;
    public int type = 0;
    public String iconUrl = "";

    protected Object clone() throws CloneNotSupportedException {
        LabelInfo labelInfo = new LabelInfo();
        labelInfo.f390867id = this.f390867id;
        labelInfo.name = this.name;
        labelInfo.rank = this.rank;
        labelInfo.hasSelected = this.hasSelected;
        labelInfo.type = this.type;
        return labelInfo;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        boolean z16 = this.hasSelected;
        if (z16 && !((LabelInfo) obj).hasSelected) {
            return -1;
        }
        if (!z16 && ((LabelInfo) obj).hasSelected) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.name.equals(((LabelInfo) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("LabelInfo{\n");
        stringBuffer.append("id='");
        stringBuffer.append(this.f390867id);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", name='");
        stringBuffer.append(this.name);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", rank='");
        stringBuffer.append(this.rank);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", hasSelected=");
        stringBuffer.append(this.hasSelected);
        stringBuffer.append('\n');
        stringBuffer.append(", type=");
        stringBuffer.append(this.type);
        stringBuffer.append('\n');
        stringBuffer.append(", operateIconUrl=");
        stringBuffer.append(this.iconUrl);
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
