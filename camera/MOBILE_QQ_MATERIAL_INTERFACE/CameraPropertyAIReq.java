package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class CameraPropertyAIReq extends JceStruct {
    static ArrayList<MediaInfo> cache_MediaInfos = new ArrayList<>();
    public String BusiID;
    public String Extra;
    public ArrayList<MediaInfo> MediaInfos;

    static {
        cache_MediaInfos.add(new MediaInfo());
    }

    public CameraPropertyAIReq() {
        this.BusiID = "";
        this.MediaInfos = null;
        this.Extra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.BusiID = jceInputStream.readString(0, false);
        this.MediaInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_MediaInfos, 1, false);
        this.Extra = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.BusiID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<MediaInfo> arrayList = this.MediaInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str2 = this.Extra;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public CameraPropertyAIReq(String str, ArrayList<MediaInfo> arrayList, String str2) {
        this.BusiID = str;
        this.MediaInfos = arrayList;
        this.Extra = str2;
    }
}
