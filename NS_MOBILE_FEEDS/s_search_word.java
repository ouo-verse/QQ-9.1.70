package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_search_word extends JceStruct {
    public String hot_word;
    public String jump_url;

    public s_search_word() {
        this.hot_word = "";
        this.jump_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hot_word = jceInputStream.readString(0, false);
        this.jump_url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.hot_word;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public s_search_word(String str, String str2) {
        this.hot_word = str;
        this.jump_url = str2;
    }
}
