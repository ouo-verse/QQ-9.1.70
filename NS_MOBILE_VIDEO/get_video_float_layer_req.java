package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_video_float_layer_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_extend_info;
    static byte[] cache_layer_user_session_action;
    static QzoneWeisiReqcommendReq cache_qzone_weisi_req;
    static int cache_req_type;
    public int appid;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public Map<String, String> extend_info;
    public int get_type;
    public byte[] layer_user_session_action;
    public QzoneWeisiReqcommendReq qzone_weisi_req;
    public int req_type;
    public String rooftop_id;
    public int scene;
    public String ugckey;
    public long uin;
    public String video_url;

    static {
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_req_type = 0;
        cache_qzone_weisi_req = new QzoneWeisiReqcommendReq();
        cache_layer_user_session_action = r1;
        byte[] bArr = {0};
    }

    public get_video_float_layer_req() {
        this.uin = 0L;
        this.scene = 0;
        this.appid = 0;
        this.ugckey = "";
        this.video_url = "";
        this.busi_param = null;
        this.extend_info = null;
        this.attach_info = "";
        this.get_type = 0;
        this.req_type = 1;
        this.qzone_weisi_req = null;
        this.rooftop_id = "";
        this.layer_user_session_action = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.ugckey = jceInputStream.readString(3, false);
        this.video_url = jceInputStream.readString(4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 6, false);
        this.attach_info = jceInputStream.readString(7, false);
        this.get_type = jceInputStream.read(this.get_type, 8, false);
        this.req_type = jceInputStream.read(this.req_type, 9, false);
        this.qzone_weisi_req = (QzoneWeisiReqcommendReq) jceInputStream.read((JceStruct) cache_qzone_weisi_req, 10, false);
        this.rooftop_id = jceInputStream.readString(11, false);
        this.layer_user_session_action = jceInputStream.read(cache_layer_user_session_action, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.scene, 1);
        jceOutputStream.write(this.appid, 2);
        String str = this.ugckey;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.video_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        Map<String, String> map2 = this.extend_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 6);
        }
        String str3 = this.attach_info;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.get_type, 8);
        jceOutputStream.write(this.req_type, 9);
        QzoneWeisiReqcommendReq qzoneWeisiReqcommendReq = this.qzone_weisi_req;
        if (qzoneWeisiReqcommendReq != null) {
            jceOutputStream.write((JceStruct) qzoneWeisiReqcommendReq, 10);
        }
        String str4 = this.rooftop_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        byte[] bArr = this.layer_user_session_action;
        if (bArr != null) {
            jceOutputStream.write(bArr, 12);
        }
    }

    public get_video_float_layer_req(long j3, int i3, int i16, String str, String str2, Map<Integer, String> map, Map<String, String> map2, String str3, int i17, int i18, QzoneWeisiReqcommendReq qzoneWeisiReqcommendReq, String str4, byte[] bArr) {
        this.uin = j3;
        this.scene = i3;
        this.appid = i16;
        this.ugckey = str;
        this.video_url = str2;
        this.busi_param = map;
        this.extend_info = map2;
        this.attach_info = str3;
        this.get_type = i17;
        this.req_type = i18;
        this.qzone_weisi_req = qzoneWeisiReqcommendReq;
        this.rooftop_id = str4;
        this.layer_user_session_action = bArr;
    }
}
