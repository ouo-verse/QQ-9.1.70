package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSkinListRsp extends JceStruct {
    static ArrayList<SkinInfo> cache_skin_list = new ArrayList<>();
    public boolean is_hide_list;
    public String more_skin_url;
    public String operate_desc;
    public String operate_url;
    public int selected_id;
    public ArrayList<SkinInfo> skin_list;

    static {
        cache_skin_list.add(new SkinInfo());
    }

    public GetSkinListRsp() {
        this.skin_list = null;
        this.selected_id = 0;
        this.more_skin_url = "";
        this.operate_url = "";
        this.operate_desc = "";
        this.is_hide_list = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.skin_list = (ArrayList) jceInputStream.read((JceInputStream) cache_skin_list, 0, true);
        this.selected_id = jceInputStream.read(this.selected_id, 1, true);
        this.more_skin_url = jceInputStream.readString(2, false);
        this.operate_url = jceInputStream.readString(3, false);
        this.operate_desc = jceInputStream.readString(4, false);
        this.is_hide_list = jceInputStream.read(this.is_hide_list, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.skin_list, 0);
        jceOutputStream.write(this.selected_id, 1);
        String str = this.more_skin_url;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.operate_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.operate_desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.is_hide_list, 5);
    }

    public GetSkinListRsp(ArrayList<SkinInfo> arrayList, int i3, String str, String str2, String str3, boolean z16) {
        this.skin_list = arrayList;
        this.selected_id = i3;
        this.more_skin_url = str;
        this.operate_url = str2;
        this.operate_desc = str3;
        this.is_hide_list = z16;
    }
}
