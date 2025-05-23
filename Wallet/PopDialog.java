package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PopDialog extends JceStruct {
    public String dialog_tips;
    public String dialog_title;
    public String left_tips;
    public String left_url;
    public String right_tips;
    public String right_url;

    public PopDialog() {
        this.dialog_tips = "";
        this.left_tips = "";
        this.left_url = "";
        this.right_tips = "";
        this.right_url = "";
        this.dialog_title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dialog_tips = jceInputStream.readString(0, false);
        this.left_tips = jceInputStream.readString(1, false);
        this.left_url = jceInputStream.readString(2, false);
        this.right_tips = jceInputStream.readString(3, false);
        this.right_url = jceInputStream.readString(4, false);
        this.dialog_title = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dialog_tips;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.left_tips;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.left_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.right_tips;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.right_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.dialog_title;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }

    public PopDialog(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dialog_tips = str;
        this.left_tips = str2;
        this.left_url = str3;
        this.right_tips = str4;
        this.right_url = str5;
        this.dialog_title = str6;
    }
}
