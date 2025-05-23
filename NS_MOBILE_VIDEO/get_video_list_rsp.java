package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_video_list_rsp extends JceStruct {
    static ArrayList<Video> cache_video_list;
    public String attach_info_new;
    public String attach_info_old;
    public boolean has_more;

    /* renamed from: msg, reason: collision with root package name */
    public String f25058msg;
    public boolean old_video_hint_flag;
    public int ret;
    public ArrayList<Video> video_list;

    public get_video_list_rsp() {
        this.f25058msg = "";
        this.has_more = true;
        this.attach_info_new = "";
        this.attach_info_old = "";
        this.old_video_hint_flag = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25058msg = jceInputStream.readString(1, false);
        if (cache_video_list == null) {
            cache_video_list = new ArrayList<>();
            cache_video_list.add(new Video());
        }
        this.video_list = (ArrayList) jceInputStream.read((JceInputStream) cache_video_list, 2, false);
        this.has_more = jceInputStream.read(this.has_more, 3, false);
        this.attach_info_new = jceInputStream.readString(4, false);
        this.attach_info_old = jceInputStream.readString(5, false);
        this.old_video_hint_flag = jceInputStream.read(this.old_video_hint_flag, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25058msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<Video> arrayList = this.video_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.has_more, 3);
        String str2 = this.attach_info_new;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.attach_info_old;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.old_video_hint_flag, 6);
    }

    public get_video_list_rsp(int i3, String str, ArrayList<Video> arrayList, boolean z16, String str2, String str3, boolean z17) {
        this.ret = i3;
        this.f25058msg = str;
        this.video_list = arrayList;
        this.has_more = z16;
        this.attach_info_new = str2;
        this.attach_info_old = str3;
        this.old_video_hint_flag = z17;
    }
}
