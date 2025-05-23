package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_arkshare;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class publish_active_album_rsp extends JceStruct {
    static s_arkshare cache_ark_sharedata = new s_arkshare();
    public s_arkshare ark_sharedata;
    public String fake_feeds_client_key;
    public String mgz_id;

    /* renamed from: msg, reason: collision with root package name */
    public String f25043msg;
    public int ret;
    public String share_url;
    public String xcx_name;
    public String xcx_share_path;

    public publish_active_album_rsp() {
        this.ret = 0;
        this.f25043msg = "";
        this.fake_feeds_client_key = "";
        this.share_url = "";
        this.mgz_id = "";
        this.ark_sharedata = null;
        this.xcx_share_path = "";
        this.xcx_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25043msg = jceInputStream.readString(1, true);
        this.fake_feeds_client_key = jceInputStream.readString(2, false);
        this.share_url = jceInputStream.readString(3, false);
        this.mgz_id = jceInputStream.readString(4, false);
        this.ark_sharedata = (s_arkshare) jceInputStream.read((JceStruct) cache_ark_sharedata, 5, false);
        this.xcx_share_path = jceInputStream.readString(6, false);
        this.xcx_name = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.f25043msg, 1);
        String str = this.fake_feeds_client_key;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.share_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.mgz_id;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        s_arkshare s_arkshareVar = this.ark_sharedata;
        if (s_arkshareVar != null) {
            jceOutputStream.write((JceStruct) s_arkshareVar, 5);
        }
        String str4 = this.xcx_share_path;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.xcx_name;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
    }

    public publish_active_album_rsp(int i3, String str, String str2, String str3, String str4, s_arkshare s_arkshareVar, String str5, String str6) {
        this.ret = i3;
        this.f25043msg = str;
        this.fake_feeds_client_key = str2;
        this.share_url = str3;
        this.mgz_id = str4;
        this.ark_sharedata = s_arkshareVar;
        this.xcx_share_path = str5;
        this.xcx_name = str6;
    }
}
