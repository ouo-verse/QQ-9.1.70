package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EventItem extends JceStruct {
    static byte[] cache_eventData;
    public byte[] eventData;
    public int eventType;

    public EventItem() {
        this.eventType = 0;
        this.eventData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eventType = jceInputStream.read(this.eventType, 0, true);
        if (cache_eventData == null) {
            cache_eventData = r0;
            byte[] bArr = {0};
        }
        this.eventData = jceInputStream.read(cache_eventData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eventType, 0);
        byte[] bArr = this.eventData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public EventItem(int i3, byte[] bArr) {
        this.eventType = i3;
        this.eventData = bArr;
    }
}
