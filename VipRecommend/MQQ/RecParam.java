package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RecParam extends JceStruct {
    static PayParam cache_payParam;
    public String buttonText;
    public int canOpen;
    public int h5Pay;
    public int is_svip;
    public int is_vip;
    public int is_year;
    public int openMode;
    public int openMonth;
    public PayParam payParam;
    public String type;

    public RecParam() {
        this.canOpen = 0;
        this.type = "";
        this.openMode = 0;
        this.openMonth = 0;
        this.buttonText = "";
        this.h5Pay = 0;
        this.payParam = null;
        this.is_vip = 0;
        this.is_svip = 0;
        this.is_year = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.canOpen = jceInputStream.read(this.canOpen, 0, true);
        this.type = jceInputStream.readString(1, true);
        this.openMode = jceInputStream.read(this.openMode, 2, true);
        this.openMonth = jceInputStream.read(this.openMonth, 3, true);
        this.buttonText = jceInputStream.readString(4, true);
        this.h5Pay = jceInputStream.read(this.h5Pay, 5, true);
        if (cache_payParam == null) {
            cache_payParam = new PayParam();
        }
        this.payParam = (PayParam) jceInputStream.read((JceStruct) cache_payParam, 6, true);
        this.is_vip = jceInputStream.read(this.is_vip, 7, true);
        this.is_svip = jceInputStream.read(this.is_svip, 8, true);
        this.is_year = jceInputStream.read(this.is_year, 9, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.canOpen, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.openMode, 2);
        jceOutputStream.write(this.openMonth, 3);
        jceOutputStream.write(this.buttonText, 4);
        jceOutputStream.write(this.h5Pay, 5);
        jceOutputStream.write((JceStruct) this.payParam, 6);
        jceOutputStream.write(this.is_vip, 7);
        jceOutputStream.write(this.is_svip, 8);
        jceOutputStream.write(this.is_year, 9);
    }

    public RecParam(int i3, String str, int i16, int i17, String str2, int i18, PayParam payParam, int i19, int i26, int i27) {
        this.canOpen = i3;
        this.type = str;
        this.openMode = i16;
        this.openMonth = i17;
        this.buttonText = str2;
        this.h5Pay = i18;
        this.payParam = payParam;
        this.is_vip = i19;
        this.is_svip = i26;
        this.is_year = i27;
    }
}
