package camera.SHADOW_BACKEND_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCatMatTreeReq extends JceStruct {
    static ArrayList<MetaSdkInfo> cache_SdkInfos = new ArrayList<>();
    public String ETag;
    public String GroupId;
    public int ReqType;
    public ArrayList<MetaSdkInfo> SdkInfos;
    public String ServiceId;

    static {
        cache_SdkInfos.add(new MetaSdkInfo());
    }

    public GetCatMatTreeReq() {
        this.ETag = "";
        this.GroupId = "";
        this.ServiceId = "";
        this.SdkInfos = null;
        this.ReqType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ETag = jceInputStream.readString(0, false);
        this.GroupId = jceInputStream.readString(1, false);
        this.ServiceId = jceInputStream.readString(2, false);
        this.SdkInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_SdkInfos, 3, false);
        this.ReqType = jceInputStream.read(this.ReqType, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ETag;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.GroupId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.ServiceId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<MetaSdkInfo> arrayList = this.SdkInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.ReqType, 4);
    }

    public GetCatMatTreeReq(String str, String str2, String str3, ArrayList<MetaSdkInfo> arrayList, int i3) {
        this.ETag = str;
        this.GroupId = str2;
        this.ServiceId = str3;
        this.SdkInfos = arrayList;
        this.ReqType = i3;
    }
}
