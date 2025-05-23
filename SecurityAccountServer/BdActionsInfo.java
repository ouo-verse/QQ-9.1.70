package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BdActionsInfo extends JceStruct {
    public int accountAbi;
    public long bindUin;
    public long bindingDate;
    public long isRecommend;
    public String mobileCode;
    public String nationCode;
    public long originBinder;

    public BdActionsInfo() {
        this.bindUin = 0L;
        this.nationCode = "";
        this.mobileCode = "";
        this.bindingDate = 0L;
        this.isRecommend = 0L;
        this.originBinder = 0L;
        this.accountAbi = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bindUin = jceInputStream.read(this.bindUin, 0, true);
        this.nationCode = jceInputStream.readString(1, true);
        this.mobileCode = jceInputStream.readString(2, true);
        this.bindingDate = jceInputStream.read(this.bindingDate, 3, true);
        this.isRecommend = jceInputStream.read(this.isRecommend, 4, false);
        this.originBinder = jceInputStream.read(this.originBinder, 5, false);
        this.accountAbi = jceInputStream.read(this.accountAbi, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bindUin, 0);
        jceOutputStream.write(this.nationCode, 1);
        jceOutputStream.write(this.mobileCode, 2);
        jceOutputStream.write(this.bindingDate, 3);
        jceOutputStream.write(this.isRecommend, 4);
        jceOutputStream.write(this.originBinder, 5);
        jceOutputStream.write(this.accountAbi, 6);
    }

    public BdActionsInfo(long j3, String str, String str2, long j16, long j17, long j18, int i3) {
        this.bindUin = j3;
        this.nationCode = str;
        this.mobileCode = str2;
        this.bindingDate = j16;
        this.isRecommend = j17;
        this.originBinder = j18;
        this.accountAbi = i3;
    }
}
