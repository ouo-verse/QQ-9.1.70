package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_rc_tab_list extends JceStruct {
    static ArrayList<s_rc_tab_info> cache_rc_tab_list = new ArrayList<>();
    public String rapid_comment_url;
    public long rc_commit_pic_size;
    public ArrayList<s_rc_tab_info> rc_tab_list;
    public String rc_zip_name;
    public long start_id;

    static {
        cache_rc_tab_list.add(new s_rc_tab_info());
    }

    public s_rc_tab_list() {
        this.rapid_comment_url = "";
        this.rc_zip_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rapid_comment_url = jceInputStream.readString(0, false);
        this.rc_commit_pic_size = jceInputStream.read(this.rc_commit_pic_size, 1, false);
        this.rc_tab_list = (ArrayList) jceInputStream.read((JceInputStream) cache_rc_tab_list, 2, false);
        this.rc_zip_name = jceInputStream.readString(3, false);
        this.start_id = jceInputStream.read(this.start_id, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.rapid_comment_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.rc_commit_pic_size, 1);
        ArrayList<s_rc_tab_info> arrayList = this.rc_tab_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.rc_zip_name;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.start_id, 4);
    }

    public s_rc_tab_list(String str, long j3, ArrayList<s_rc_tab_info> arrayList, String str2, long j16) {
        this.rapid_comment_url = str;
        this.rc_commit_pic_size = j3;
        this.rc_tab_list = arrayList;
        this.rc_zip_name = str2;
        this.start_id = j16;
    }
}
