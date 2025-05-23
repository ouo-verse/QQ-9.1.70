package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaLoudNorm extends JceStruct {
    public String input_i;
    public String input_lra;
    public String input_thresh;
    public String input_tp;
    public String normalization_type;
    public String output_i;
    public String output_lra;
    public String output_thresh;
    public String output_tp;
    public String target_offset;
    public String weishi_i;
    public String weishi_lra;
    public String weishi_tp;

    public stMetaLoudNorm() {
        this.input_i = "";
        this.input_tp = "";
        this.input_lra = "";
        this.input_thresh = "";
        this.output_i = "";
        this.output_tp = "";
        this.output_lra = "";
        this.output_thresh = "";
        this.normalization_type = "";
        this.target_offset = "";
        this.weishi_i = "";
        this.weishi_tp = "";
        this.weishi_lra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.input_i = jceInputStream.readString(0, false);
        this.input_tp = jceInputStream.readString(1, false);
        this.input_lra = jceInputStream.readString(2, false);
        this.input_thresh = jceInputStream.readString(3, false);
        this.output_i = jceInputStream.readString(4, false);
        this.output_tp = jceInputStream.readString(5, false);
        this.output_lra = jceInputStream.readString(6, false);
        this.output_thresh = jceInputStream.readString(7, false);
        this.normalization_type = jceInputStream.readString(8, false);
        this.target_offset = jceInputStream.readString(9, false);
        this.weishi_i = jceInputStream.readString(10, false);
        this.weishi_tp = jceInputStream.readString(11, false);
        this.weishi_lra = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.input_i;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.input_tp;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.input_lra;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.input_thresh;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.output_i;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.output_tp;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.output_lra;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.output_thresh;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
        String str9 = this.normalization_type;
        if (str9 != null) {
            jceOutputStream.write(str9, 8);
        }
        String str10 = this.target_offset;
        if (str10 != null) {
            jceOutputStream.write(str10, 9);
        }
        String str11 = this.weishi_i;
        if (str11 != null) {
            jceOutputStream.write(str11, 10);
        }
        String str12 = this.weishi_tp;
        if (str12 != null) {
            jceOutputStream.write(str12, 11);
        }
        String str13 = this.weishi_lra;
        if (str13 != null) {
            jceOutputStream.write(str13, 12);
        }
    }

    public stMetaLoudNorm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.input_i = str;
        this.input_tp = str2;
        this.input_lra = str3;
        this.input_thresh = str4;
        this.output_i = str5;
        this.output_tp = str6;
        this.output_lra = str7;
        this.output_thresh = str8;
        this.normalization_type = str9;
        this.target_offset = str10;
        this.weishi_i = str11;
        this.weishi_tp = str12;
        this.weishi_lra = str13;
    }
}
