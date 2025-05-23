package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MarkUinInfoBeforeUpload extends JceStruct {
    static ArrayList<MarkUinInPhoto> cache_marks = new ArrayList<>();
    public ArrayList<MarkUinInPhoto> marks;

    static {
        cache_marks.add(new MarkUinInPhoto());
    }

    public MarkUinInfoBeforeUpload() {
        this.marks = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.marks = (ArrayList) jceInputStream.read((JceInputStream) cache_marks, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MarkUinInPhoto> arrayList = this.marks;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public MarkUinInfoBeforeUpload(ArrayList<MarkUinInPhoto> arrayList) {
        this.marks = arrayList;
    }
}
