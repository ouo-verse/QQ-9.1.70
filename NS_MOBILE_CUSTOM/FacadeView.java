package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FacadeView extends JceStruct {
    static CustomFileInfo cache_stFileInfo;
    static ProfileRect cache_stProfileRect;
    static ArrayList<ConfigRect> cache_vecConfRect;
    public int iNeedProfileAdjust;
    public CustomFileInfo stFileInfo;
    public ProfileRect stProfileRect;
    public ArrayList<ConfigRect> vecConfRect;

    public FacadeView() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stFileInfo == null) {
            cache_stFileInfo = new CustomFileInfo();
        }
        this.stFileInfo = (CustomFileInfo) jceInputStream.read((JceStruct) cache_stFileInfo, 0, false);
        if (cache_vecConfRect == null) {
            cache_vecConfRect = new ArrayList<>();
            cache_vecConfRect.add(new ConfigRect());
        }
        this.vecConfRect = (ArrayList) jceInputStream.read((JceInputStream) cache_vecConfRect, 1, false);
        if (cache_stProfileRect == null) {
            cache_stProfileRect = new ProfileRect();
        }
        this.stProfileRect = (ProfileRect) jceInputStream.read((JceStruct) cache_stProfileRect, 2, false);
        this.iNeedProfileAdjust = jceInputStream.read(this.iNeedProfileAdjust, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CustomFileInfo customFileInfo = this.stFileInfo;
        if (customFileInfo != null) {
            jceOutputStream.write((JceStruct) customFileInfo, 0);
        }
        ArrayList<ConfigRect> arrayList = this.vecConfRect;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ProfileRect profileRect = this.stProfileRect;
        if (profileRect != null) {
            jceOutputStream.write((JceStruct) profileRect, 2);
        }
        jceOutputStream.write(this.iNeedProfileAdjust, 3);
    }

    public FacadeView(CustomFileInfo customFileInfo, ArrayList<ConfigRect> arrayList, ProfileRect profileRect, int i3) {
        this.stFileInfo = customFileInfo;
        this.vecConfRect = arrayList;
        this.stProfileRect = profileRect;
        this.iNeedProfileAdjust = i3;
    }
}
