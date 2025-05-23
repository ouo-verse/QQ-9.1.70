package ClientRecordUpload;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientRecordUploadReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_extendinfo;
    public long duration;
    public Map<String, String> extendinfo;
    public String m3u8_name;
    public long room_id;
    public long version;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public ClientRecordUploadReq() {
        this.version = 1L;
        this.room_id = 0L;
        this.extendinfo = null;
        this.m3u8_name = "";
        this.duration = 0L;
    }

    public String className() {
        return "ClientRecordUpload.ClientRecordUploadReq";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.version, "version");
        jceDisplayer.display(this.room_id, AudienceReportConst.ROOM_ID);
        jceDisplayer.display((Map) this.extendinfo, "extendinfo");
        jceDisplayer.display(this.m3u8_name, "m3u8_name");
        jceDisplayer.display(this.duration, "duration");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.version, true);
        jceDisplayer.displaySimple(this.room_id, true);
        jceDisplayer.displaySimple((Map) this.extendinfo, true);
        jceDisplayer.displaySimple(this.m3u8_name, true);
        jceDisplayer.displaySimple(this.duration, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ClientRecordUploadReq clientRecordUploadReq = (ClientRecordUploadReq) obj;
        if (!JceUtil.equals(this.version, clientRecordUploadReq.version) || !JceUtil.equals(this.room_id, clientRecordUploadReq.room_id) || !JceUtil.equals(this.extendinfo, clientRecordUploadReq.extendinfo) || !JceUtil.equals(this.m3u8_name, clientRecordUploadReq.m3u8_name) || !JceUtil.equals(this.duration, clientRecordUploadReq.duration)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ClientRecordUpload.ClientRecordUploadReq";
    }

    public long getDuration() {
        return this.duration;
    }

    public Map<String, String> getExtendinfo() {
        return this.extendinfo;
    }

    public String getM3u8_name() {
        return this.m3u8_name;
    }

    public long getRoom_id() {
        return this.room_id;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.read(this.version, 0, true);
        this.room_id = jceInputStream.read(this.room_id, 1, true);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
        this.m3u8_name = jceInputStream.readString(3, false);
        this.duration = jceInputStream.read(this.duration, 4, false);
    }

    public void setDuration(long j3) {
        this.duration = j3;
    }

    public void setExtendinfo(Map<String, String> map) {
        this.extendinfo = map;
    }

    public void setM3u8_name(String str) {
        this.m3u8_name = str;
    }

    public void setRoom_id(long j3) {
        this.room_id = j3;
    }

    public void setVersion(long j3) {
        this.version = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.version, 0);
        jceOutputStream.write(this.room_id, 1);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        String str = this.m3u8_name;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.duration, 4);
    }

    public ClientRecordUploadReq(long j3, long j16, Map<String, String> map, String str, long j17) {
        this.version = j3;
        this.room_id = j16;
        this.extendinfo = map;
        this.m3u8_name = str;
        this.duration = j17;
    }
}
