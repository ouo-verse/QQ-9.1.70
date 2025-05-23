package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_parenting_photo_list_req extends JceStruct {
    static BannerAttachInfo cache_banner_attach_info;
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumid;
    public String attach_info;
    public BannerAttachInfo banner_attach_info;
    public Map<Integer, String> busi_param;
    public String ciphertext;
    public String password;
    public int share_flag;
    public int type;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        cache_banner_attach_info = new BannerAttachInfo();
    }

    public get_parenting_photo_list_req() {
        this.uin = 0L;
        this.albumid = "";
        this.attach_info = "";
        this.password = "";
        this.busi_param = null;
        this.share_flag = 0;
        this.ciphertext = "";
        this.type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.attach_info = jceInputStream.readString(2, false);
        this.password = jceInputStream.readString(3, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 4, false);
        this.share_flag = jceInputStream.read(this.share_flag, 5, false);
        this.ciphertext = jceInputStream.readString(6, false);
        this.type = jceInputStream.read(this.type, 7, false);
        this.banner_attach_info = (BannerAttachInfo) jceInputStream.read((JceStruct) cache_banner_attach_info, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.albumid, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.password;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.share_flag, 5);
        String str3 = this.ciphertext;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.type, 7);
        BannerAttachInfo bannerAttachInfo = this.banner_attach_info;
        if (bannerAttachInfo != null) {
            jceOutputStream.write((JceStruct) bannerAttachInfo, 8);
        }
    }

    public get_parenting_photo_list_req(long j3, String str, String str2, String str3, Map<Integer, String> map, int i3, String str4, int i16) {
        this.uin = j3;
        this.albumid = str;
        this.attach_info = str2;
        this.password = str3;
        this.busi_param = map;
        this.share_flag = i3;
        this.ciphertext = str4;
        this.type = i16;
    }

    public get_parenting_photo_list_req(long j3, String str, String str2, String str3, Map<Integer, String> map, int i3, String str4, int i16, BannerAttachInfo bannerAttachInfo) {
        this.uin = j3;
        this.albumid = str;
        this.attach_info = str2;
        this.password = str3;
        this.busi_param = map;
        this.share_flag = i3;
        this.ciphertext = str4;
        this.type = i16;
        this.banner_attach_info = bannerAttachInfo;
    }
}
