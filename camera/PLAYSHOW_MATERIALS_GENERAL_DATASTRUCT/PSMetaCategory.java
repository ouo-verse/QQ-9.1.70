package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PSMetaCategory extends JceStruct {
    static Map<String, String> cache_additionalFields;
    static ArrayList<PSMetaMaterial> cache_materials;
    static ArrayList<PSMetaCategory> cache_subCategories = new ArrayList<>();
    public Map<String, String> additionalFields;
    public boolean defaultFlag;

    /* renamed from: id, reason: collision with root package name */
    public String f30530id;
    public ArrayList<PSMetaMaterial> materials;
    public String name;
    public boolean onlyFlag;
    public ArrayList<PSMetaCategory> subCategories;

    static {
        cache_subCategories.add(new PSMetaCategory());
        cache_materials = new ArrayList<>();
        cache_materials.add(new PSMetaMaterial());
        HashMap hashMap = new HashMap();
        cache_additionalFields = hashMap;
        hashMap.put("", "");
    }

    public PSMetaCategory() {
        this.f30530id = "";
        this.name = "";
        this.subCategories = null;
        this.materials = null;
        this.defaultFlag = true;
        this.onlyFlag = true;
        this.additionalFields = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f30530id = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.subCategories = (ArrayList) jceInputStream.read((JceInputStream) cache_subCategories, 2, false);
        this.materials = (ArrayList) jceInputStream.read((JceInputStream) cache_materials, 3, false);
        this.defaultFlag = jceInputStream.read(this.defaultFlag, 4, false);
        this.onlyFlag = jceInputStream.read(this.onlyFlag, 5, false);
        this.additionalFields = (Map) jceInputStream.read((JceInputStream) cache_additionalFields, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f30530id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        ArrayList<PSMetaCategory> arrayList = this.subCategories;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<PSMetaMaterial> arrayList2 = this.materials;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        jceOutputStream.write(this.defaultFlag, 4);
        jceOutputStream.write(this.onlyFlag, 5);
        Map<String, String> map = this.additionalFields;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public PSMetaCategory(String str, String str2, ArrayList<PSMetaCategory> arrayList, ArrayList<PSMetaMaterial> arrayList2, boolean z16, boolean z17, Map<String, String> map) {
        this.f30530id = str;
        this.name = str2;
        this.subCategories = arrayList;
        this.materials = arrayList2;
        this.defaultFlag = z16;
        this.onlyFlag = z17;
        this.additionalFields = map;
    }
}
