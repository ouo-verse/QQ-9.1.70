package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLiveShowSimpleRoomInfoRsp extends JceStruct {
    static RecordPlayInfo cache_recordPlayInfo = new RecordPlayInfo();
    public int happychat;
    public int isRecordVideo;
    public String multiVideoStreamUrl;
    public RecordPlayInfo recordPlayInfo;
    public String roomName;
    public int roomStatus;
    public String roomid;
    public String uid;
    public String videoRtmpUrl;

    public GetLiveShowSimpleRoomInfoRsp() {
        this.roomid = "";
        this.uid = "";
        this.roomName = "";
        this.roomStatus = 0;
        this.multiVideoStreamUrl = "";
        this.videoRtmpUrl = "";
        this.isRecordVideo = 0;
        this.recordPlayInfo = null;
        this.happychat = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.roomid = jceInputStream.readString(0, false);
        this.uid = jceInputStream.readString(1, false);
        this.roomName = jceInputStream.readString(2, false);
        this.roomStatus = jceInputStream.read(this.roomStatus, 3, false);
        this.multiVideoStreamUrl = jceInputStream.readString(4, false);
        this.videoRtmpUrl = jceInputStream.readString(5, false);
        this.isRecordVideo = jceInputStream.read(this.isRecordVideo, 6, false);
        this.recordPlayInfo = (RecordPlayInfo) jceInputStream.read((JceStruct) cache_recordPlayInfo, 7, false);
        this.happychat = jceInputStream.read(this.happychat, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.roomid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.uid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.roomName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.roomStatus, 3);
        String str4 = this.multiVideoStreamUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.videoRtmpUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.isRecordVideo, 6);
        RecordPlayInfo recordPlayInfo = this.recordPlayInfo;
        if (recordPlayInfo != null) {
            jceOutputStream.write((JceStruct) recordPlayInfo, 7);
        }
        jceOutputStream.write(this.happychat, 8);
    }

    public GetLiveShowSimpleRoomInfoRsp(String str, String str2, String str3, int i3, String str4, String str5, int i16, RecordPlayInfo recordPlayInfo, int i17) {
        this.roomid = str;
        this.uid = str2;
        this.roomName = str3;
        this.roomStatus = i3;
        this.multiVideoStreamUrl = str4;
        this.videoRtmpUrl = str5;
        this.isRecordVideo = i16;
        this.recordPlayInfo = recordPlayInfo;
        this.happychat = i17;
    }
}
