package camera.SHADOW_BACKEND_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.FilterableInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCatMatTreeRsp extends JceStruct {
    static ArrayList<MetaCategory> cache_Categories = new ArrayList<>();
    static ArrayList<FilterableInfo> cache_FilterableInfos;
    public ArrayList<MetaCategory> Categories;
    public int Code;
    public String ETag;
    public ArrayList<FilterableInfo> FilterableInfos;

    static {
        cache_Categories.add(new MetaCategory());
        cache_FilterableInfos = new ArrayList<>();
        cache_FilterableInfos.add(new FilterableInfo());
    }

    public GetCatMatTreeRsp() {
        this.Code = 0;
        this.ETag = "";
        this.Categories = null;
        this.FilterableInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.ETag = jceInputStream.readString(1, false);
        this.Categories = (ArrayList) jceInputStream.read((JceInputStream) cache_Categories, 2, false);
        this.FilterableInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_FilterableInfos, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.ETag;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<MetaCategory> arrayList = this.Categories;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<FilterableInfo> arrayList2 = this.FilterableInfos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public GetCatMatTreeRsp(int i3, String str, ArrayList<MetaCategory> arrayList, ArrayList<FilterableInfo> arrayList2) {
        this.Code = i3;
        this.ETag = str;
        this.Categories = arrayList;
        this.FilterableInfos = arrayList2;
    }
}
