package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class GetProcessMediaReq extends JceStruct {
    static ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> cache_media_infos = new ArrayList<>();
    public String BusiID;
    public String Extra;
    public ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> MediaInfos;

    static {
        cache_media_infos.add(new camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo());
    }

    public GetProcessMediaReq() {
        this.BusiID = "";
        this.MediaInfos = null;
        this.Extra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.BusiID = jceInputStream.readString(0, false);
        this.MediaInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_media_infos, 1, false);
        this.Extra = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.BusiID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> arrayList = this.MediaInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str2 = this.Extra;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public GetProcessMediaReq(String str, ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> arrayList, String str2) {
        this.BusiID = str;
        this.MediaInfos = arrayList;
        this.Extra = str2;
    }
}
