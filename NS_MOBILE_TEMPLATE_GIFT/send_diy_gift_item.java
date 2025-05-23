package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class send_diy_gift_item extends JceStruct {
    static ArrayList<send_gift_info> cache_info;
    public int arch;
    public String audioUrl;
    public String backId;
    public String content;

    /* renamed from: id, reason: collision with root package name */
    public long f25047id;
    public ArrayList<send_gift_info> info;
    public boolean isBack;
    public boolean isPrivate;
    public String picUrl;
    public int recv_source;

    public send_diy_gift_item() {
        this.isBack = true;
        this.isPrivate = true;
        this.audioUrl = "";
        this.picUrl = "";
        this.content = "";
        this.backId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_info == null) {
            cache_info = new ArrayList<>();
            cache_info.add(new send_gift_info());
        }
        this.info = (ArrayList) jceInputStream.read((JceInputStream) cache_info, 0, true);
        this.f25047id = jceInputStream.read(this.f25047id, 1, true);
        this.isBack = jceInputStream.read(this.isBack, 2, true);
        this.isPrivate = jceInputStream.read(this.isPrivate, 3, true);
        this.audioUrl = jceInputStream.readString(4, true);
        this.picUrl = jceInputStream.readString(5, true);
        this.content = jceInputStream.readString(6, true);
        this.arch = jceInputStream.read(this.arch, 7, false);
        this.backId = jceInputStream.readString(8, false);
        this.recv_source = jceInputStream.read(this.recv_source, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.info, 0);
        jceOutputStream.write(this.f25047id, 1);
        jceOutputStream.write(this.isBack, 2);
        jceOutputStream.write(this.isPrivate, 3);
        jceOutputStream.write(this.audioUrl, 4);
        jceOutputStream.write(this.picUrl, 5);
        jceOutputStream.write(this.content, 6);
        jceOutputStream.write(this.arch, 7);
        String str = this.backId;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        jceOutputStream.write(this.recv_source, 9);
    }

    public send_diy_gift_item(ArrayList<send_gift_info> arrayList, long j3, boolean z16, boolean z17, String str, String str2, String str3, int i3, String str4, int i16) {
        this.info = arrayList;
        this.f25047id = j3;
        this.isBack = z16;
        this.isPrivate = z17;
        this.audioUrl = str;
        this.picUrl = str2;
        this.content = str3;
        this.arch = i3;
        this.backId = str4;
        this.recv_source = i16;
    }
}
