package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryNewUserRecommendedListNotBind extends JceStruct {
    static ArrayList<RecommendedContactInfo> cache_RecommendedContacts = new ArrayList<>();
    public ArrayList<RecommendedContactInfo> RecommendedContacts;
    public long lastUsedFlag;

    static {
        cache_RecommendedContacts.add(new RecommendedContactInfo());
    }

    public ResponeQueryNewUserRecommendedListNotBind() {
        this.RecommendedContacts = null;
        this.lastUsedFlag = 1L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.RecommendedContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_RecommendedContacts, 1, true);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.RecommendedContacts, 1);
        jceOutputStream.write(this.lastUsedFlag, 2);
    }

    public ResponeQueryNewUserRecommendedListNotBind(ArrayList<RecommendedContactInfo> arrayList, long j3) {
        this.RecommendedContacts = arrayList;
        this.lastUsedFlag = j3;
    }
}
