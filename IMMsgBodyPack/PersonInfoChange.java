package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PersonInfoChange extends JceStruct {
    static ArrayList<PersonInfoField> cache_vChgField;
    public byte cType;
    public ArrayList<PersonInfoField> vChgField;

    public PersonInfoChange() {
        this.cType = (byte) 0;
        this.vChgField = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cType = jceInputStream.read(this.cType, 0, false);
        if (cache_vChgField == null) {
            cache_vChgField = new ArrayList<>();
            cache_vChgField.add(new PersonInfoField());
        }
        this.vChgField = (ArrayList) jceInputStream.read((JceInputStream) cache_vChgField, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cType, 0);
        ArrayList<PersonInfoField> arrayList = this.vChgField;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public PersonInfoChange(byte b16, ArrayList<PersonInfoField> arrayList) {
        this.cType = b16;
        this.vChgField = arrayList;
    }
}
