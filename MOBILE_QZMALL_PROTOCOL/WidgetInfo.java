package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WidgetInfo extends JceStruct {
    static int cache_category;
    static int cache_src;
    static CommWidgetInfo cache_stCommWidgetInfo = new CommWidgetInfo();
    static EventWidgetInfo cache_stEventWidgetInfo = new EventWidgetInfo();
    public int category;
    public int src;
    public CommWidgetInfo stCommWidgetInfo;
    public EventWidgetInfo stEventWidgetInfo;

    public WidgetInfo() {
        this.category = 0;
        this.src = 0;
        this.stCommWidgetInfo = null;
        this.stEventWidgetInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.category = jceInputStream.read(this.category, 0, false);
        this.src = jceInputStream.read(this.src, 1, false);
        this.stCommWidgetInfo = (CommWidgetInfo) jceInputStream.read((JceStruct) cache_stCommWidgetInfo, 2, false);
        this.stEventWidgetInfo = (EventWidgetInfo) jceInputStream.read((JceStruct) cache_stEventWidgetInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.category, 0);
        jceOutputStream.write(this.src, 1);
        CommWidgetInfo commWidgetInfo = this.stCommWidgetInfo;
        if (commWidgetInfo != null) {
            jceOutputStream.write((JceStruct) commWidgetInfo, 2);
        }
        EventWidgetInfo eventWidgetInfo = this.stEventWidgetInfo;
        if (eventWidgetInfo != null) {
            jceOutputStream.write((JceStruct) eventWidgetInfo, 3);
        }
    }

    public WidgetInfo(int i3, int i16, CommWidgetInfo commWidgetInfo, EventWidgetInfo eventWidgetInfo) {
        this.category = i3;
        this.src = i16;
        this.stCommWidgetInfo = commWidgetInfo;
        this.stEventWidgetInfo = eventWidgetInfo;
    }
}
