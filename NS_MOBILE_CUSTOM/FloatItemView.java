package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FloatItemView extends JceStruct {
    static CustomFileInfo cache_stFileInfo = new CustomFileInfo();
    public CustomFileInfo stFileInfo;

    public FloatItemView() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFileInfo = (CustomFileInfo) jceInputStream.read((JceStruct) cache_stFileInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CustomFileInfo customFileInfo = this.stFileInfo;
        if (customFileInfo != null) {
            jceOutputStream.write((JceStruct) customFileInfo, 0);
        }
    }

    public FloatItemView(CustomFileInfo customFileInfo) {
        this.stFileInfo = customFileInfo;
    }
}
