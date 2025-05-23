package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeEventOp extends JceStruct {
    public int action;
    public TimeEvent events;
    static TimeEvent cache_events = new TimeEvent();
    static int cache_action = 0;

    public TimeEventOp() {
        this.events = null;
        this.action = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.events = (TimeEvent) jceInputStream.read((JceStruct) cache_events, 0, false);
        this.action = jceInputStream.read(this.action, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        TimeEvent timeEvent = this.events;
        if (timeEvent != null) {
            jceOutputStream.write((JceStruct) timeEvent, 0);
        }
        jceOutputStream.write(this.action, 1);
    }

    public TimeEventOp(TimeEvent timeEvent, int i3) {
        this.events = timeEvent;
        this.action = i3;
    }
}
