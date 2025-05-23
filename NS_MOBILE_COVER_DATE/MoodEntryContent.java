package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MoodEntryContent extends JceStruct {
    public String content;

    public MoodEntryContent() {
        this.content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public MoodEntryContent(String str) {
        this.content = str;
    }
}
