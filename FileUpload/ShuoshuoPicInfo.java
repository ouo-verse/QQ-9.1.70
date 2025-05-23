package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ShuoshuoPicInfo extends JceStruct {
    static Map<String, String> cache_mapWaterMarkParams;
    public String albumid;
    public int hdheight;
    public String hdid;
    public int hdwidth;
    public String imageId;
    public int is_appext_pic;
    public boolean ishd;
    public Map<String, String> mapWaterMarkParams;
    public String pic_url;
    public int picheight;
    public String pictureid;
    public int pictype;
    public int picwidth;
    public String richval;
    public String sloc;
    public int sourceType;
    public String strWaterMarkID;
    public String strWaterMarkMemo;
    public String video_id;

    static {
        HashMap hashMap = new HashMap();
        cache_mapWaterMarkParams = hashMap;
        hashMap.put("", "");
    }

    public ShuoshuoPicInfo() {
        this.albumid = "";
        this.pictureid = "";
        this.sloc = "";
        this.pictype = 0;
        this.picheight = 0;
        this.picwidth = 0;
        this.ishd = true;
        this.hdid = "";
        this.hdheight = 0;
        this.hdwidth = 0;
        this.strWaterMarkID = "";
        this.strWaterMarkMemo = "";
        this.mapWaterMarkParams = null;
        this.pic_url = "";
        this.is_appext_pic = 0;
        this.richval = "";
        this.sourceType = 0;
        this.imageId = "";
        this.video_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumid = jceInputStream.readString(0, false);
        this.pictureid = jceInputStream.readString(1, false);
        this.sloc = jceInputStream.readString(2, false);
        this.pictype = jceInputStream.read(this.pictype, 3, false);
        this.picheight = jceInputStream.read(this.picheight, 4, false);
        this.picwidth = jceInputStream.read(this.picwidth, 5, false);
        this.ishd = jceInputStream.read(this.ishd, 6, false);
        this.hdid = jceInputStream.readString(7, false);
        this.hdheight = jceInputStream.read(this.hdheight, 8, false);
        this.hdwidth = jceInputStream.read(this.hdwidth, 9, false);
        this.strWaterMarkID = jceInputStream.readString(10, false);
        this.strWaterMarkMemo = jceInputStream.readString(11, false);
        this.mapWaterMarkParams = (Map) jceInputStream.read((JceInputStream) cache_mapWaterMarkParams, 12, false);
        this.pic_url = jceInputStream.readString(13, false);
        this.is_appext_pic = jceInputStream.read(this.is_appext_pic, 14, false);
        this.richval = jceInputStream.readString(15, false);
        this.sourceType = jceInputStream.read(this.sourceType, 16, false);
        this.imageId = jceInputStream.readString(17, false);
        this.video_id = jceInputStream.readString(18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.pictureid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sloc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.pictype, 3);
        jceOutputStream.write(this.picheight, 4);
        jceOutputStream.write(this.picwidth, 5);
        jceOutputStream.write(this.ishd, 6);
        String str4 = this.hdid;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.hdheight, 8);
        jceOutputStream.write(this.hdwidth, 9);
        String str5 = this.strWaterMarkID;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.strWaterMarkMemo;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        Map<String, String> map = this.mapWaterMarkParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        String str7 = this.pic_url;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        jceOutputStream.write(this.is_appext_pic, 14);
        String str8 = this.richval;
        if (str8 != null) {
            jceOutputStream.write(str8, 15);
        }
        jceOutputStream.write(this.sourceType, 16);
        String str9 = this.imageId;
        if (str9 != null) {
            jceOutputStream.write(str9, 17);
        }
        String str10 = this.video_id;
        if (str10 != null) {
            jceOutputStream.write(str10, 18);
        }
    }

    public ShuoshuoPicInfo(String str, String str2, String str3, int i3, int i16, int i17, boolean z16, String str4, int i18, int i19, String str5, String str6, Map<String, String> map, String str7, int i26, String str8, int i27, String str9, String str10) {
        this.albumid = str;
        this.pictureid = str2;
        this.sloc = str3;
        this.pictype = i3;
        this.picheight = i16;
        this.picwidth = i17;
        this.ishd = z16;
        this.hdid = str4;
        this.hdheight = i18;
        this.hdwidth = i19;
        this.strWaterMarkID = str5;
        this.strWaterMarkMemo = str6;
        this.mapWaterMarkParams = map;
        this.pic_url = str7;
        this.is_appext_pic = i26;
        this.richval = str8;
        this.sourceType = i27;
        this.imageId = str9;
        this.video_id = str10;
    }
}
