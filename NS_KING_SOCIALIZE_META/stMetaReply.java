package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaReply extends JceStruct {
    static stMetaPerson cache_poster = new stMetaPerson();
    static stMetaPerson cache_receiver = new stMetaPerson();
    public String beReplyReplyId;
    public int createtime;

    /* renamed from: id, reason: collision with root package name */
    public String f24938id;
    public int mask;
    public stMetaPerson poster;
    public stMetaPerson receiver;
    public int robotMode;
    public String wording;

    public stMetaReply() {
        this.f24938id = "";
        this.wording = "";
        this.poster = null;
        this.receiver = null;
        this.createtime = 0;
        this.mask = 0;
        this.robotMode = 0;
        this.beReplyReplyId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24938id = jceInputStream.readString(0, false);
        this.wording = jceInputStream.readString(1, false);
        this.poster = (stMetaPerson) jceInputStream.read((JceStruct) cache_poster, 2, false);
        this.receiver = (stMetaPerson) jceInputStream.read((JceStruct) cache_receiver, 3, false);
        this.createtime = jceInputStream.read(this.createtime, 4, false);
        this.mask = jceInputStream.read(this.mask, 5, false);
        this.robotMode = jceInputStream.read(this.robotMode, 6, false);
        this.beReplyReplyId = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f24938id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.wording;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        stMetaPerson stmetaperson = this.poster;
        if (stmetaperson != null) {
            jceOutputStream.write((JceStruct) stmetaperson, 2);
        }
        stMetaPerson stmetaperson2 = this.receiver;
        if (stmetaperson2 != null) {
            jceOutputStream.write((JceStruct) stmetaperson2, 3);
        }
        jceOutputStream.write(this.createtime, 4);
        jceOutputStream.write(this.mask, 5);
        jceOutputStream.write(this.robotMode, 6);
        String str3 = this.beReplyReplyId;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
    }

    public stMetaReply(String str, String str2, stMetaPerson stmetaperson, stMetaPerson stmetaperson2, int i3, int i16, int i17, String str3) {
        this.f24938id = str;
        this.wording = str2;
        this.poster = stmetaperson;
        this.receiver = stmetaperson2;
        this.createtime = i3;
        this.mask = i16;
        this.robotMode = i17;
        this.beReplyReplyId = str3;
    }
}
