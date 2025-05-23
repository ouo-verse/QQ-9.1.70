package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FilterableInfo extends JceStruct {
    static ArrayList<String> cache_FilterableEnumValue;
    public ArrayList<String> FilterableEnumValue;
    public String FilterableField;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_FilterableEnumValue = arrayList;
        arrayList.add("");
    }

    public FilterableInfo() {
        this.FilterableField = "";
        this.FilterableEnumValue = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.FilterableField = jceInputStream.readString(0, true);
        this.FilterableEnumValue = (ArrayList) jceInputStream.read((JceInputStream) cache_FilterableEnumValue, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.FilterableField, 0);
        ArrayList<String> arrayList = this.FilterableEnumValue;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public FilterableInfo(String str, ArrayList<String> arrayList) {
        this.FilterableField = str;
        this.FilterableEnumValue = arrayList;
    }
}
