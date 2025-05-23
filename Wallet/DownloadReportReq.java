package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DownloadReportReq extends JceStruct {
    public static final int TYPE_DOWNLOADING = 0;
    public static final int TYPE_DOWNLOAD_FAIL = 2;
    public static final int TYPE_DOWNLOAD_SUCC = 1;
    static ArrayList<ResInfo> cache_vecResInfo = new ArrayList<>();
    public int iActId = 1001;
    public int iType = 0;
    public ArrayList<ResInfo> vecResInfo = null;
    public long iUin = 0;
    public String sSpeed = "";
    public int iPlatForm = 1;
    public int iScene = 0;
    public String sPhoneType = "";
    public String sOsVersion = "";
    public String sQQVersion = "";

    static {
        cache_vecResInfo.add(new ResInfo());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iActId = jceInputStream.read(this.iActId, 0, false);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.vecResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResInfo, 2, false);
        this.iUin = jceInputStream.read(this.iUin, 3, false);
        this.sSpeed = jceInputStream.readString(4, false);
        this.iPlatForm = jceInputStream.read(this.iPlatForm, 5, false);
        this.iScene = jceInputStream.read(this.iScene, 6, false);
        this.sPhoneType = jceInputStream.readString(7, false);
        this.sOsVersion = jceInputStream.readString(8, false);
        this.sQQVersion = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "DownRep{iType=" + this.iType + "iScene =" + this.iScene + "vecResInfo = " + this.vecResInfo + "|" + this.sPhoneType + "|" + this.sOsVersion + "|" + this.sQQVersion + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iActId, 0);
        jceOutputStream.write(this.iType, 1);
        ArrayList<ResInfo> arrayList = this.vecResInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.iUin, 3);
        String str = this.sSpeed;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.iPlatForm, 5);
        jceOutputStream.write(this.iScene, 6);
        String str2 = this.sPhoneType;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        String str3 = this.sOsVersion;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.sQQVersion;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }
}
