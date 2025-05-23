package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeatherInfoWithCellidReq extends JceStruct {
    static GSMCell cache_cell;
    static ClientInfo cache_clientInfo;
    static GPSPoint cache_coords;
    static int cache_type;
    static ArrayList<Long> cache_vMacs;
    public GSMCell cell;
    public ClientInfo clientInfo;
    public GPSPoint coords;
    public int type;
    public ArrayList<Long> vMacs;

    public WeatherInfoWithCellidReq() {
        this.cell = null;
        this.coords = null;
        this.type = QUERYTYPE.GPS_CELL_V1.value();
        this.clientInfo = null;
        this.vMacs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_cell == null) {
            cache_cell = new GSMCell();
        }
        this.cell = (GSMCell) jceInputStream.read((JceStruct) cache_cell, 1, true);
        if (cache_coords == null) {
            cache_coords = new GPSPoint();
        }
        this.coords = (GPSPoint) jceInputStream.read((JceStruct) cache_coords, 2, true);
        this.type = jceInputStream.read(this.type, 3, false);
        if (cache_clientInfo == null) {
            cache_clientInfo = new ClientInfo();
        }
        this.clientInfo = (ClientInfo) jceInputStream.read((JceStruct) cache_clientInfo, 4, false);
        if (cache_vMacs == null) {
            cache_vMacs = new ArrayList<>();
            cache_vMacs.add(0L);
        }
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.cell, 1);
        jceOutputStream.write((JceStruct) this.coords, 2);
        jceOutputStream.write(this.type, 3);
        ClientInfo clientInfo = this.clientInfo;
        if (clientInfo != null) {
            jceOutputStream.write((JceStruct) clientInfo, 4);
        }
        ArrayList<Long> arrayList = this.vMacs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
    }

    public WeatherInfoWithCellidReq(GSMCell gSMCell, GPSPoint gPSPoint, int i3, ClientInfo clientInfo, ArrayList<Long> arrayList) {
        this.cell = null;
        this.coords = null;
        QUERYTYPE.GPS_CELL_V1.value();
        this.cell = gSMCell;
        this.coords = gPSPoint;
        this.type = i3;
        this.clientInfo = clientInfo;
        this.vMacs = arrayList;
    }
}
