package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileCommConf extends JceStruct {
    static NewMobileGlobalConf cache_new_mobile_global_conf = new NewMobileGlobalConf();
    static NewMobileUserConf cache_new_mobile_user_conf = new NewMobileUserConf();
    static ArrayList<String> cache_vecAppList;
    public int maxScanNum;
    public NewMobileGlobalConf new_mobile_global_conf;
    public NewMobileUserConf new_mobile_user_conf;
    public ArrayList<String> vecAppList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecAppList = arrayList;
        arrayList.add("");
    }

    public MobileCommConf() {
        this.new_mobile_global_conf = null;
        this.new_mobile_user_conf = null;
        this.vecAppList = null;
        this.maxScanNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.new_mobile_global_conf = (NewMobileGlobalConf) jceInputStream.read((JceStruct) cache_new_mobile_global_conf, 0, false);
        this.new_mobile_user_conf = (NewMobileUserConf) jceInputStream.read((JceStruct) cache_new_mobile_user_conf, 1, false);
        this.vecAppList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAppList, 2, false);
        this.maxScanNum = jceInputStream.read(this.maxScanNum, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        NewMobileGlobalConf newMobileGlobalConf = this.new_mobile_global_conf;
        if (newMobileGlobalConf != null) {
            jceOutputStream.write((JceStruct) newMobileGlobalConf, 0);
        }
        NewMobileUserConf newMobileUserConf = this.new_mobile_user_conf;
        if (newMobileUserConf != null) {
            jceOutputStream.write((JceStruct) newMobileUserConf, 1);
        }
        ArrayList<String> arrayList = this.vecAppList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.maxScanNum, 3);
    }

    public MobileCommConf(NewMobileGlobalConf newMobileGlobalConf, NewMobileUserConf newMobileUserConf, ArrayList<String> arrayList, int i3) {
        this.new_mobile_global_conf = newMobileGlobalConf;
        this.new_mobile_user_conf = newMobileUserConf;
        this.vecAppList = arrayList;
        this.maxScanNum = i3;
    }
}
