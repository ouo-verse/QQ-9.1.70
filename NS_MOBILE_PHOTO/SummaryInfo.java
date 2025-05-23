package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_lbs;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SummaryInfo extends JceStruct {
    static int cache_type;
    public String categoryid;
    public face_show_info face_show;
    public label_show_info label_show;
    public long photo_num;
    public cell_lbs poi_info;
    public CategoryPhoto preview_elements;
    public int type;
    public String url;
    static CategoryPhoto cache_preview_elements = new CategoryPhoto();
    static face_show_info cache_face_show = new face_show_info();
    static cell_lbs cache_poi_info = new cell_lbs();
    static label_show_info cache_label_show = new label_show_info();

    public SummaryInfo() {
        this.type = 0;
        this.photo_num = 0L;
        this.categoryid = "";
        this.url = "";
        this.preview_elements = null;
        this.face_show = null;
        this.poi_info = null;
        this.label_show = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.photo_num = jceInputStream.read(this.photo_num, 1, false);
        this.categoryid = jceInputStream.readString(2, false);
        this.url = jceInputStream.readString(3, false);
        this.preview_elements = (CategoryPhoto) jceInputStream.read((JceStruct) cache_preview_elements, 4, false);
        this.face_show = (face_show_info) jceInputStream.read((JceStruct) cache_face_show, 5, false);
        this.poi_info = (cell_lbs) jceInputStream.read((JceStruct) cache_poi_info, 6, false);
        this.label_show = (label_show_info) jceInputStream.read((JceStruct) cache_label_show, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.photo_num, 1);
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        CategoryPhoto categoryPhoto = this.preview_elements;
        if (categoryPhoto != null) {
            jceOutputStream.write((JceStruct) categoryPhoto, 4);
        }
        face_show_info face_show_infoVar = this.face_show;
        if (face_show_infoVar != null) {
            jceOutputStream.write((JceStruct) face_show_infoVar, 5);
        }
        cell_lbs cell_lbsVar = this.poi_info;
        if (cell_lbsVar != null) {
            jceOutputStream.write((JceStruct) cell_lbsVar, 6);
        }
        label_show_info label_show_infoVar = this.label_show;
        if (label_show_infoVar != null) {
            jceOutputStream.write((JceStruct) label_show_infoVar, 7);
        }
    }

    public SummaryInfo(int i3, long j3, String str, String str2, CategoryPhoto categoryPhoto, face_show_info face_show_infoVar, cell_lbs cell_lbsVar, label_show_info label_show_infoVar) {
        this.type = i3;
        this.photo_num = j3;
        this.categoryid = str;
        this.url = str2;
        this.preview_elements = categoryPhoto;
        this.face_show = face_show_infoVar;
        this.poi_info = cell_lbsVar;
        this.label_show = label_show_infoVar;
    }
}
