package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SmartFilterRspItem extends JceStruct {
    static ArrayList<YoutuResultItem> cache_DisplayLabels = new ArrayList<>();
    public ArrayList<YoutuResultItem> DisplayLabels;
    public String PituLabel;

    static {
        cache_DisplayLabels.add(new YoutuResultItem());
    }

    public SmartFilterRspItem() {
        this.PituLabel = "";
        this.DisplayLabels = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.PituLabel = jceInputStream.readString(0, false);
        this.DisplayLabels = (ArrayList) jceInputStream.read((JceInputStream) cache_DisplayLabels, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.PituLabel;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<YoutuResultItem> arrayList = this.DisplayLabels;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public SmartFilterRspItem(String str, ArrayList<YoutuResultItem> arrayList) {
        this.PituLabel = str;
        this.DisplayLabels = arrayList;
    }
}
