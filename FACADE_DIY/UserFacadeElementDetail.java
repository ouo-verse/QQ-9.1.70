package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserFacadeElementDetail extends JceStruct {
    static ElementInfo cache_background = new ElementInfo();
    static ArrayList<ElementInfo> cache_icons = new ArrayList<>();
    static ArrayList<ElementInfo> cache_other;
    public ElementInfo background;
    public ArrayList<ElementInfo> icons;
    public int lottieId;
    public ArrayList<ElementInfo> other;
    public int templateId;
    public int themeId;

    static {
        cache_icons.add(new ElementInfo());
        cache_other = new ArrayList<>();
        cache_other.add(new ElementInfo());
    }

    public UserFacadeElementDetail() {
        this.templateId = 0;
        this.themeId = 0;
        this.lottieId = 0;
        this.background = null;
        this.icons = null;
        this.other = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.templateId = jceInputStream.read(this.templateId, 0, false);
        this.themeId = jceInputStream.read(this.themeId, 1, false);
        this.lottieId = jceInputStream.read(this.lottieId, 2, false);
        this.background = (ElementInfo) jceInputStream.read((JceStruct) cache_background, 3, false);
        this.icons = (ArrayList) jceInputStream.read((JceInputStream) cache_icons, 4, false);
        this.other = (ArrayList) jceInputStream.read((JceInputStream) cache_other, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.templateId, 0);
        jceOutputStream.write(this.themeId, 1);
        jceOutputStream.write(this.lottieId, 2);
        ElementInfo elementInfo = this.background;
        if (elementInfo != null) {
            jceOutputStream.write((JceStruct) elementInfo, 3);
        }
        ArrayList<ElementInfo> arrayList = this.icons;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<ElementInfo> arrayList2 = this.other;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
    }

    public UserFacadeElementDetail(int i3, int i16, int i17, ElementInfo elementInfo, ArrayList<ElementInfo> arrayList, ArrayList<ElementInfo> arrayList2) {
        this.templateId = i3;
        this.themeId = i16;
        this.lottieId = i17;
        this.background = elementInfo;
        this.icons = arrayList;
        this.other = arrayList2;
    }
}
