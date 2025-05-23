package NS_MOBILE_TAGS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSugTagsReq extends JceStruct {
    public String inputTag;

    public GetSugTagsReq() {
        this.inputTag = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.inputTag = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.inputTag;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public GetSugTagsReq(String str) {
        this.inputTag = str;
    }
}
