package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AllowDomainInfo extends JceStruct {
    public String allow_domain_regex;
    public int open_type;

    public AllowDomainInfo() {
        this.allow_domain_regex = "";
        this.open_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allow_domain_regex = jceInputStream.readString(0, false);
        this.open_type = jceInputStream.read(this.open_type, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "AllowDomainInfo{allow_domain_regex='" + this.allow_domain_regex + "', open_type=" + this.open_type + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.allow_domain_regex;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.open_type, 1);
    }

    public AllowDomainInfo(String str, int i3) {
        this.allow_domain_regex = str;
        this.open_type = i3;
    }
}
