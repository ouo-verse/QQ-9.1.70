package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetPlayShowCatMatTreeRsp extends JceStruct {
    static ArrayList<PSMetaCategory> cache_Categories = new ArrayList<>();
    public ArrayList<PSMetaCategory> Categories;
    public int Code;
    public String ETag;

    static {
        cache_Categories.add(new PSMetaCategory());
    }

    public GetPlayShowCatMatTreeRsp() {
        this.Code = 0;
        this.ETag = "";
        this.Categories = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.ETag = jceInputStream.readString(1, false);
        this.Categories = (ArrayList) jceInputStream.read((JceInputStream) cache_Categories, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.ETag;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<PSMetaCategory> arrayList = this.Categories;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetPlayShowCatMatTreeRsp(int i3, String str, ArrayList<PSMetaCategory> arrayList) {
        this.Code = i3;
        this.ETag = str;
        this.Categories = arrayList;
    }
}
