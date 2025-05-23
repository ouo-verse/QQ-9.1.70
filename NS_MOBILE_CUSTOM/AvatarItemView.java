package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AvatarItemView extends JceStruct {
    static CustomFileInfo cache_stFileInfo;
    public int iPlayInterval;
    public CustomFileInfo stFileInfo;
    public String strStaticUrl;

    public AvatarItemView() {
        this.strStaticUrl = "";
        this.iPlayInterval = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stFileInfo == null) {
            cache_stFileInfo = new CustomFileInfo();
        }
        this.stFileInfo = (CustomFileInfo) jceInputStream.read((JceStruct) cache_stFileInfo, 0, false);
        this.strStaticUrl = jceInputStream.readString(1, false);
        this.iPlayInterval = jceInputStream.read(this.iPlayInterval, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CustomFileInfo customFileInfo = this.stFileInfo;
        if (customFileInfo != null) {
            jceOutputStream.write((JceStruct) customFileInfo, 0);
        }
        String str = this.strStaticUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iPlayInterval, 2);
    }

    public AvatarItemView(CustomFileInfo customFileInfo, String str, int i3) {
        this.stFileInfo = customFileInfo;
        this.strStaticUrl = str;
        this.iPlayInterval = i3;
    }
}
