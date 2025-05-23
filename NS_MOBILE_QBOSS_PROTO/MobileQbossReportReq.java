package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileQbossReportReq extends JceStruct {
    static ArrayList<tMobileQbossFeedBackInfo> cache_vecMobileQbossFeedBackInfo;
    public ArrayList<tMobileQbossFeedBackInfo> vecMobileQbossFeedBackInfo;

    public MobileQbossReportReq() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecMobileQbossFeedBackInfo == null) {
            cache_vecMobileQbossFeedBackInfo = new ArrayList<>();
            cache_vecMobileQbossFeedBackInfo.add(new tMobileQbossFeedBackInfo());
        }
        this.vecMobileQbossFeedBackInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecMobileQbossFeedBackInfo, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecMobileQbossFeedBackInfo, 0);
    }

    public MobileQbossReportReq(ArrayList<tMobileQbossFeedBackInfo> arrayList) {
        this.vecMobileQbossFeedBackInfo = arrayList;
    }
}
