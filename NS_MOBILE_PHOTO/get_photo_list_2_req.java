package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_list_2_req extends JceStruct {
    static BannerAttachInfo cache_banner_attach_info;
    static Map<Integer, String> cache_busi_param = new HashMap();
    static int cache_req_from;
    static int cache_sort_type;
    static int cache_type;
    public String albumid;
    public String attach_info;
    public BannerAttachInfo banner_attach_info;
    public Map<Integer, String> busi_param;
    public String ciphertext;
    public String curlloc;
    public long face_uin;
    public boolean need_pos;
    public String password;
    public long password_cleartext;

    /* renamed from: pn, reason: collision with root package name */
    public int f25040pn;

    /* renamed from: ps, reason: collision with root package name */
    public int f25041ps;
    public int req_from;
    public String req_url;
    public long sharer;
    public int sheight;
    public int sort_type;
    public int swidth;
    public int type;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        cache_banner_attach_info = new BannerAttachInfo();
        cache_req_from = 0;
        cache_type = 0;
        cache_sort_type = 0;
    }

    public get_photo_list_2_req() {
        this.uin = 0L;
        this.albumid = "";
        this.f25041ps = 0;
        this.f25040pn = 0;
        this.password = "";
        this.curlloc = "";
        this.swidth = 0;
        this.sheight = 0;
        this.busi_param = null;
        this.req_url = "";
        this.face_uin = 0L;
        this.ciphertext = "";
        this.password_cleartext = 1L;
        this.type = 0;
        this.sharer = 0L;
        this.need_pos = false;
        this.sort_type = 0;
        this.attach_info = "";
        this.req_from = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.albumid = jceInputStream.readString(2, true);
        this.f25041ps = jceInputStream.read(this.f25041ps, 3, true);
        this.f25040pn = jceInputStream.read(this.f25040pn, 4, true);
        this.password = jceInputStream.readString(5, false);
        this.curlloc = jceInputStream.readString(6, false);
        this.swidth = jceInputStream.read(this.swidth, 7, false);
        this.sheight = jceInputStream.read(this.sheight, 8, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 9, false);
        this.req_url = jceInputStream.readString(10, false);
        this.face_uin = jceInputStream.read(this.face_uin, 11, false);
        this.ciphertext = jceInputStream.readString(12, false);
        this.password_cleartext = jceInputStream.read(this.password_cleartext, 13, false);
        this.type = jceInputStream.read(this.type, 14, false);
        this.sharer = jceInputStream.read(this.sharer, 15, false);
        this.need_pos = jceInputStream.read(this.need_pos, 16, false);
        this.sort_type = jceInputStream.read(this.sort_type, 17, false);
        this.attach_info = jceInputStream.readString(18, false);
        this.banner_attach_info = (BannerAttachInfo) jceInputStream.read((JceStruct) cache_banner_attach_info, 19, false);
        this.req_from = jceInputStream.read(this.req_from, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.albumid, 2);
        jceOutputStream.write(this.f25041ps, 3);
        jceOutputStream.write(this.f25040pn, 4);
        String str = this.password;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.curlloc;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.swidth, 7);
        jceOutputStream.write(this.sheight, 8);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
        String str3 = this.req_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        jceOutputStream.write(this.face_uin, 11);
        String str4 = this.ciphertext;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        jceOutputStream.write(this.password_cleartext, 13);
        jceOutputStream.write(this.type, 14);
        jceOutputStream.write(this.sharer, 15);
        jceOutputStream.write(this.need_pos, 16);
        jceOutputStream.write(this.sort_type, 17);
        String str5 = this.attach_info;
        if (str5 != null) {
            jceOutputStream.write(str5, 18);
        }
        BannerAttachInfo bannerAttachInfo = this.banner_attach_info;
        if (bannerAttachInfo != null) {
            jceOutputStream.write((JceStruct) bannerAttachInfo, 19);
        }
        jceOutputStream.write(this.req_from, 20);
    }

    public get_photo_list_2_req(long j3, String str, int i3, int i16, String str2, String str3, int i17, int i18, Map<Integer, String> map, String str4, long j16, String str5, long j17, int i19, long j18, boolean z16, int i26, String str6, int i27) {
        this.uin = j3;
        this.albumid = str;
        this.f25041ps = i3;
        this.f25040pn = i16;
        this.password = str2;
        this.curlloc = str3;
        this.swidth = i17;
        this.sheight = i18;
        this.busi_param = map;
        this.req_url = str4;
        this.face_uin = j16;
        this.ciphertext = str5;
        this.password_cleartext = j17;
        this.type = i19;
        this.sharer = j18;
        this.need_pos = z16;
        this.sort_type = i26;
        this.req_from = i27;
        this.attach_info = str6;
    }

    public get_photo_list_2_req(long j3, String str, int i3, int i16, String str2, String str3, int i17, int i18, Map<Integer, String> map, String str4, long j16, String str5, long j17, int i19, long j18, boolean z16, int i26, String str6, BannerAttachInfo bannerAttachInfo, int i27) {
        this.req_from = 0;
        this.uin = j3;
        this.albumid = str;
        this.f25041ps = i3;
        this.f25040pn = i16;
        this.password = str2;
        this.curlloc = str3;
        this.swidth = i17;
        this.sheight = i18;
        this.busi_param = map;
        this.req_url = str4;
        this.face_uin = j16;
        this.ciphertext = str5;
        this.password_cleartext = j17;
        this.type = i19;
        this.sharer = j18;
        this.need_pos = z16;
        this.sort_type = i26;
        this.attach_info = str6;
        this.banner_attach_info = bannerAttachInfo;
    }
}
