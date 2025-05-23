package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryNewUserRecommendedList extends JceStruct {
    static ArrayList<RecommendedContactInfo> cache_RecommendedContacts = new ArrayList<>();
    public ArrayList<RecommendedContactInfo> RecommendedContacts;
    public long lastUsedFlag;
    public String mobileNo;
    public String nationCode;

    static {
        cache_RecommendedContacts.add(new RecommendedContactInfo());
    }

    public ResponeQueryNewUserRecommendedList() {
        this.RecommendedContacts = null;
        this.nationCode = "";
        this.mobileNo = "";
        this.lastUsedFlag = 1L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.RecommendedContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_RecommendedContacts, 1, true);
        this.nationCode = jceInputStream.readString(2, true);
        this.mobileNo = jceInputStream.readString(3, true);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.RecommendedContacts, 1);
        jceOutputStream.write(this.nationCode, 2);
        jceOutputStream.write(this.mobileNo, 3);
        jceOutputStream.write(this.lastUsedFlag, 4);
    }

    public ResponeQueryNewUserRecommendedList(ArrayList<RecommendedContactInfo> arrayList, String str, String str2, long j3) {
        this.RecommendedContacts = arrayList;
        this.nationCode = str;
        this.mobileNo = str2;
        this.lastUsedFlag = j3;
    }
}
