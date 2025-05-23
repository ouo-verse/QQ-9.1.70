package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCategoryMaterialRsp extends JceStruct {
    static BubbleData cache_BubbleData;
    static ArrayList<MetaCategory> cache_Categories = new ArrayList<>();
    public BubbleData BubbleData;
    public ArrayList<MetaCategory> Categories;
    public int Code;
    public String ETag;

    static {
        cache_Categories.add(new MetaCategory());
        cache_BubbleData = new BubbleData();
    }

    public GetCategoryMaterialRsp() {
        this.Code = 0;
        this.ETag = "";
        this.Categories = null;
        this.BubbleData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.ETag = jceInputStream.readString(1, false);
        this.Categories = (ArrayList) jceInputStream.read((JceInputStream) cache_Categories, 2, false);
        this.BubbleData = (BubbleData) jceInputStream.read((JceStruct) cache_BubbleData, 3, false);
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
        BubbleData bubbleData = this.BubbleData;
        if (bubbleData != null) {
            jceOutputStream.write((JceStruct) bubbleData, 3);
        }
    }

    public GetCategoryMaterialRsp(int i3, String str, ArrayList<MetaCategory> arrayList, BubbleData bubbleData) {
        this.Code = i3;
        this.ETag = str;
        this.Categories = arrayList;
        this.BubbleData = bubbleData;
    }
}
