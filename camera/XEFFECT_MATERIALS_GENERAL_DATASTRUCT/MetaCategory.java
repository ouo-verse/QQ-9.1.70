package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MetaCategory extends JceStruct {
    static Map<String, String> cache_dynamicFields;
    static ArrayList<MetaMaterial> cache_materials;
    static ArrayList<MetaCategory> cache_subCategories = new ArrayList<>();
    public Map<String, String> dynamicFields;
    public boolean hasRedDot;

    /* renamed from: id, reason: collision with root package name */
    public String f30532id;
    public ArrayList<MetaMaterial> materials;
    public String name;
    public ArrayList<MetaCategory> subCategories;
    public String thumbUrl;

    static {
        cache_subCategories.add(new MetaCategory());
        cache_materials = new ArrayList<>();
        cache_materials.add(new MetaMaterial());
        HashMap hashMap = new HashMap();
        cache_dynamicFields = hashMap;
        hashMap.put("", "");
    }

    public MetaCategory() {
        this.f30532id = "";
        this.name = "";
        this.thumbUrl = "";
        this.subCategories = null;
        this.materials = null;
        this.dynamicFields = null;
        this.hasRedDot = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f30532id = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.thumbUrl = jceInputStream.readString(2, false);
        this.subCategories = (ArrayList) jceInputStream.read((JceInputStream) cache_subCategories, 3, false);
        this.materials = (ArrayList) jceInputStream.read((JceInputStream) cache_materials, 4, false);
        this.dynamicFields = (Map) jceInputStream.read((JceInputStream) cache_dynamicFields, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f30532id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.thumbUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<MetaCategory> arrayList = this.subCategories;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<MetaMaterial> arrayList2 = this.materials;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        Map<String, String> map = this.dynamicFields;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public MetaCategory(String str, String str2, String str3, ArrayList<MetaCategory> arrayList, ArrayList<MetaMaterial> arrayList2, Map<String, String> map) {
        this.hasRedDot = false;
        this.f30532id = str;
        this.name = str2;
        this.thumbUrl = str3;
        this.subCategories = arrayList;
        this.materials = arrayList2;
        this.dynamicFields = map;
    }
}
