package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SearchInfo extends JceStruct {
    static int cache_eSource;
    public byte bInContact;
    public byte bIsEnterpriseQQ;
    public byte bIsFriend;
    public int eSource;
    public long lUIN;
    public String strMobile;
    public String strNick;

    public SearchInfo() {
        this.lUIN = 0L;
        this.eSource = 0;
        this.strNick = "";
        this.strMobile = "";
        this.bIsFriend = (byte) 0;
        this.bInContact = (byte) 0;
        this.bIsEnterpriseQQ = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.eSource = jceInputStream.read(this.eSource, 1, true);
        this.strNick = jceInputStream.readString(2, false);
        this.strMobile = jceInputStream.readString(3, false);
        this.bIsFriend = jceInputStream.read(this.bIsFriend, 4, false);
        this.bInContact = jceInputStream.read(this.bInContact, 5, false);
        this.bIsEnterpriseQQ = jceInputStream.read(this.bIsEnterpriseQQ, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.eSource, 1);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strMobile;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.bIsFriend, 4);
        jceOutputStream.write(this.bInContact, 5);
        jceOutputStream.write(this.bIsEnterpriseQQ, 6);
    }

    public SearchInfo(long j3, int i3, String str, String str2, byte b16, byte b17, byte b18) {
        this.lUIN = j3;
        this.eSource = i3;
        this.strNick = str;
        this.strMobile = str2;
        this.bIsFriend = b16;
        this.bInContact = b17;
        this.bIsEnterpriseQQ = b18;
    }
}
