package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_visit_notification extends JceStruct {
    static s_visit_contentkey cache_contentkey;
    static s_user cache_user;
    public s_visit_contentkey contentkey;

    /* renamed from: msg, reason: collision with root package name */
    public String f25008msg;
    public short state;
    public long time;
    public s_user user;
    public short user_type;

    public s_visit_notification() {
        this.f25008msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_user == null) {
            cache_user = new s_user();
        }
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.user_type = jceInputStream.read(this.user_type, 1, false);
        this.state = jceInputStream.read(this.state, 2, false);
        this.f25008msg = jceInputStream.readString(3, false);
        this.time = jceInputStream.read(this.time, 4, false);
        if (cache_contentkey == null) {
            cache_contentkey = new s_visit_contentkey();
        }
        this.contentkey = (s_visit_contentkey) jceInputStream.read((JceStruct) cache_contentkey, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        jceOutputStream.write(this.user_type, 1);
        jceOutputStream.write(this.state, 2);
        String str = this.f25008msg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.time, 4);
        s_visit_contentkey s_visit_contentkeyVar = this.contentkey;
        if (s_visit_contentkeyVar != null) {
            jceOutputStream.write((JceStruct) s_visit_contentkeyVar, 5);
        }
    }

    public s_visit_notification(s_user s_userVar, short s16, short s17, String str, long j3, s_visit_contentkey s_visit_contentkeyVar) {
        this.user = s_userVar;
        this.user_type = s16;
        this.state = s17;
        this.f25008msg = str;
        this.time = j3;
        this.contentkey = s_visit_contentkeyVar;
    }
}
