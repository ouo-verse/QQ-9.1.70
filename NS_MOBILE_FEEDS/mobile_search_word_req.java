package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_search_word_req extends JceStruct {
    public String keyword;
    public int type;
    public long uHostUin;

    public mobile_search_word_req() {
        this.uHostUin = 0L;
        this.type = 0;
        this.keyword = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uHostUin = jceInputStream.read(this.uHostUin, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.keyword = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uHostUin, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.keyword;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public mobile_search_word_req(long j3, int i3, String str) {
        this.uHostUin = j3;
        this.type = i3;
        this.keyword = str;
    }
}
