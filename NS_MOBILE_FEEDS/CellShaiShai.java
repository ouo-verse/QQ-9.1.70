package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CellShaiShai extends JceStruct {
    static ArrayList<s_user> cache_user = new ArrayList<>();
    public String mDescription;
    public String mNoteSchemaUrl;
    public ArrayList<s_user> mUsers;

    static {
        cache_user.add(new s_user());
    }

    public CellShaiShai() {
        this.mDescription = "";
        this.mUsers = null;
        this.mNoteSchemaUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mDescription = jceInputStream.readString(0, false);
        this.mUsers = (ArrayList) jceInputStream.read((JceInputStream) cache_user, 1, false);
        this.mNoteSchemaUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.mDescription;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<s_user> arrayList = this.mUsers;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str2 = this.mNoteSchemaUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public CellShaiShai(String str, ArrayList<s_user> arrayList, String str2) {
        this.mDescription = str;
        this.mUsers = arrayList;
        this.mNoteSchemaUrl = str2;
    }
}
