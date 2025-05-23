package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PicTagInfo extends JceStruct {
    static ArrayList<TagInfo> cache_vecTagInfo = new ArrayList<>();
    public int iCode;
    public String strPicId;
    public String strPicTagId;
    public ArrayList<TagInfo> vecTagInfo;

    static {
        cache_vecTagInfo.add(new TagInfo());
    }

    public PicTagInfo() {
        this.vecTagInfo = null;
        this.strPicId = "";
        this.iCode = 0;
        this.strPicTagId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecTagInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTagInfo, 0, false);
        this.strPicId = jceInputStream.readString(1, false);
        this.iCode = jceInputStream.read(this.iCode, 2, false);
        this.strPicTagId = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<TagInfo> arrayList = this.vecTagInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.strPicId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iCode, 2);
        String str2 = this.strPicTagId;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public PicTagInfo(ArrayList<TagInfo> arrayList, String str, int i3, String str2) {
        this.vecTagInfo = arrayList;
        this.strPicId = str;
        this.iCode = i3;
        this.strPicTagId = str2;
    }
}
