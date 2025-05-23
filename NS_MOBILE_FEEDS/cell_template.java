package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_template extends JceStruct {
    static int cache_type;
    public int feeds_action_type;
    public String feeds_jmp_url;

    /* renamed from: id, reason: collision with root package name */
    public String f24986id;
    public int type;

    public cell_template() {
        this.f24986id = "";
        this.feeds_action_type = 0;
        this.feeds_jmp_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24986id = jceInputStream.readString(0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.feeds_action_type = jceInputStream.read(this.feeds_action_type, 2, false);
        this.feeds_jmp_url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24986id, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.feeds_action_type, 2);
        String str = this.feeds_jmp_url;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public cell_template(String str, int i3, int i16, String str2) {
        this.f24986id = str;
        this.type = i3;
        this.feeds_action_type = i16;
        this.feeds_jmp_url = str2;
    }
}
