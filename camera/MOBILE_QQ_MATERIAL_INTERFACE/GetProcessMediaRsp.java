package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class GetProcessMediaRsp extends JceStruct {
    static ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> cache_media_infos = new ArrayList<>();
    public int Code;
    public String Extra;
    public ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> MediaInfos;
    public String Msg;

    static {
        cache_media_infos.add(new camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo());
    }

    public GetProcessMediaRsp() {
        this.MediaInfos = null;
        this.Extra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.MediaInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_media_infos, 2, false);
        this.Extra = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> arrayList = this.MediaInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.Extra;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public GetProcessMediaRsp(int i3, String str, ArrayList<camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MediaInfo> arrayList, String str2) {
        this.Code = i3;
        this.Msg = str;
        this.MediaInfos = arrayList;
        this.Extra = str2;
    }
}
