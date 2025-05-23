package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SkinInfo extends JceStruct {
    static PopDialog cache_pop_dialog = new PopDialog();
    public String blessing;
    public int is_hide_title;
    public PopDialog pop_dialog;
    public int skin_id;
    public String skin_name;
    public long skin_permission_state;

    public SkinInfo() {
        this.skin_id = 0;
        this.skin_permission_state = 0L;
        this.skin_name = "";
        this.pop_dialog = null;
        this.is_hide_title = 0;
        this.blessing = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.skin_id = jceInputStream.read(this.skin_id, 0, true);
        this.skin_permission_state = jceInputStream.read(this.skin_permission_state, 1, true);
        this.skin_name = jceInputStream.readString(2, true);
        this.pop_dialog = (PopDialog) jceInputStream.read((JceStruct) cache_pop_dialog, 3, false);
        this.is_hide_title = jceInputStream.read(this.is_hide_title, 4, false);
        this.blessing = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.skin_id, 0);
        jceOutputStream.write(this.skin_permission_state, 1);
        jceOutputStream.write(this.skin_name, 2);
        PopDialog popDialog = this.pop_dialog;
        if (popDialog != null) {
            jceOutputStream.write((JceStruct) popDialog, 3);
        }
        jceOutputStream.write(this.is_hide_title, 4);
        String str = this.blessing;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public SkinInfo(int i3, long j3, String str, PopDialog popDialog, int i16, String str2) {
        this.skin_id = i3;
        this.skin_permission_state = j3;
        this.skin_name = str;
        this.pop_dialog = popDialog;
        this.is_hide_title = i16;
        this.blessing = str2;
    }
}
