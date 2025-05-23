package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCategoryMaterialReq extends JceStruct {
    static ArrayList<MetaSdkInfo> cache_SdkInfos = new ArrayList<>();
    public String ETag;
    public ArrayList<MetaSdkInfo> SdkInfos;
    public String ServiceId;

    static {
        cache_SdkInfos.add(new MetaSdkInfo());
    }

    public GetCategoryMaterialReq() {
        this.ETag = "";
        this.ServiceId = "";
        this.SdkInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ETag = jceInputStream.readString(0, false);
        this.ServiceId = jceInputStream.readString(1, false);
        this.SdkInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_SdkInfos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ETag;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.ServiceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        ArrayList<MetaSdkInfo> arrayList = this.SdkInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetCategoryMaterialReq(String str, String str2, ArrayList<MetaSdkInfo> arrayList) {
        this.ETag = str;
        this.ServiceId = str2;
        this.SdkInfos = arrayList;
    }
}
