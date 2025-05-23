package NS_MOBILE_WIDGET;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VisitorWidgetInfo extends JceStruct {
    static ArrayList<Visitor> cache_delta_visitor;
    static yellow_info cache_yellow_flag;
    public int blocked_visitor_count;
    public ArrayList<Visitor> delta_visitor;
    public int today_delta;
    public int today_visitor;
    public int total_visitor;
    public yellow_info yellow_flag;

    public VisitorWidgetInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.today_delta = jceInputStream.read(this.today_delta, 0, false);
        this.today_visitor = jceInputStream.read(this.today_visitor, 1, false);
        this.total_visitor = jceInputStream.read(this.total_visitor, 2, false);
        if (cache_yellow_flag == null) {
            cache_yellow_flag = new yellow_info();
        }
        this.yellow_flag = (yellow_info) jceInputStream.read((JceStruct) cache_yellow_flag, 4, false);
        this.blocked_visitor_count = jceInputStream.read(this.blocked_visitor_count, 5, false);
        if (cache_delta_visitor == null) {
            cache_delta_visitor = new ArrayList<>();
            cache_delta_visitor.add(new Visitor());
        }
        this.delta_visitor = (ArrayList) jceInputStream.read((JceInputStream) cache_delta_visitor, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.today_delta, 0);
        jceOutputStream.write(this.today_visitor, 1);
        jceOutputStream.write(this.total_visitor, 2);
        yellow_info yellow_infoVar = this.yellow_flag;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 4);
        }
        jceOutputStream.write(this.blocked_visitor_count, 5);
        ArrayList<Visitor> arrayList = this.delta_visitor;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
    }

    public VisitorWidgetInfo(int i3, int i16, int i17, yellow_info yellow_infoVar, int i18, ArrayList<Visitor> arrayList) {
        this.today_delta = i3;
        this.today_visitor = i16;
        this.total_visitor = i17;
        this.yellow_flag = yellow_infoVar;
        this.blocked_visitor_count = i18;
        this.delta_visitor = arrayList;
    }
}
