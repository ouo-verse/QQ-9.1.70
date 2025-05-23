package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ImageSummaryList extends JceStruct {
    static ArrayList<ImageSummary> cache_vecImageSummary;
    public ArrayList<ImageSummary> vecImageSummary;

    public ImageSummaryList() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecImageSummary == null) {
            cache_vecImageSummary = new ArrayList<>();
            cache_vecImageSummary.add(new ImageSummary());
        }
        this.vecImageSummary = (ArrayList) jceInputStream.read((JceInputStream) cache_vecImageSummary, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<ImageSummary> arrayList = this.vecImageSummary;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public ImageSummaryList(ArrayList<ImageSummary> arrayList) {
        this.vecImageSummary = arrayList;
    }
}
