package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaAddr;
import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stSimpleMetaPerson extends JceStruct {
    public String avatar;
    public stSchema avatarSchema;
    public String background;
    public int createtime;
    public stPersonExt extInfo;
    public int followStatus;
    public stMetaAddr formatAddr;

    /* renamed from: id, reason: collision with root package name */
    public String f25130id;
    public stLive live;
    public int medal;
    public String nick;
    public stMetaNumericSys nueric;
    public String recommendReason;
    public int relation_type;
    public String schema_url;
    public int sex;
    public String status;
    public int type;
    public String uid;
    static stMetaNumericSys cache_nueric = new stMetaNumericSys();
    static stSchema cache_avatarSchema = new stSchema();
    static stLive cache_live = new stLive();
    static stPersonExt cache_extInfo = new stPersonExt();
    static stMetaAddr cache_formatAddr = new stMetaAddr();

    public stSimpleMetaPerson() {
        this.f25130id = "";
        this.type = 0;
        this.uid = "";
        this.createtime = 0;
        this.nick = "";
        this.avatar = "";
        this.schema_url = "";
        this.relation_type = 0;
        this.followStatus = 0;
        this.medal = 0;
        this.nueric = null;
        this.recommendReason = "";
        this.sex = 0;
        this.avatarSchema = null;
        this.live = null;
        this.extInfo = null;
        this.status = "";
        this.formatAddr = null;
        this.background = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25130id = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.uid = jceInputStream.readString(2, false);
        this.createtime = jceInputStream.read(this.createtime, 3, false);
        this.nick = jceInputStream.readString(4, false);
        this.avatar = jceInputStream.readString(5, false);
        this.schema_url = jceInputStream.readString(6, false);
        this.relation_type = jceInputStream.read(this.relation_type, 7, false);
        this.followStatus = jceInputStream.read(this.followStatus, 8, false);
        this.medal = jceInputStream.read(this.medal, 9, false);
        this.nueric = (stMetaNumericSys) jceInputStream.read((JceStruct) cache_nueric, 10, false);
        this.recommendReason = jceInputStream.readString(11, false);
        this.sex = jceInputStream.read(this.sex, 12, false);
        this.avatarSchema = (stSchema) jceInputStream.read((JceStruct) cache_avatarSchema, 13, false);
        this.live = (stLive) jceInputStream.read((JceStruct) cache_live, 14, false);
        this.extInfo = (stPersonExt) jceInputStream.read((JceStruct) cache_extInfo, 15, false);
        this.status = jceInputStream.readString(16, false);
        this.formatAddr = (stMetaAddr) jceInputStream.read((JceStruct) cache_formatAddr, 17, false);
        this.background = jceInputStream.readString(18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25130id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.type, 1);
        String str2 = this.uid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.createtime, 3);
        String str3 = this.nick;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.avatar;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.schema_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.relation_type, 7);
        jceOutputStream.write(this.followStatus, 8);
        jceOutputStream.write(this.medal, 9);
        stMetaNumericSys stmetanumericsys = this.nueric;
        if (stmetanumericsys != null) {
            jceOutputStream.write((JceStruct) stmetanumericsys, 10);
        }
        String str6 = this.recommendReason;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        jceOutputStream.write(this.sex, 12);
        stSchema stschema = this.avatarSchema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 13);
        }
        stLive stlive = this.live;
        if (stlive != null) {
            jceOutputStream.write((JceStruct) stlive, 14);
        }
        stPersonExt stpersonext = this.extInfo;
        if (stpersonext != null) {
            jceOutputStream.write((JceStruct) stpersonext, 15);
        }
        String str7 = this.status;
        if (str7 != null) {
            jceOutputStream.write(str7, 16);
        }
        stMetaAddr stmetaaddr = this.formatAddr;
        if (stmetaaddr != null) {
            jceOutputStream.write((JceStruct) stmetaaddr, 17);
        }
        String str8 = this.background;
        if (str8 != null) {
            jceOutputStream.write(str8, 18);
        }
    }

    public stSimpleMetaPerson(String str, int i3, String str2, int i16, String str3, String str4, String str5, int i17, int i18, int i19, stMetaNumericSys stmetanumericsys, String str6, int i26, stSchema stschema, stLive stlive, stPersonExt stpersonext, String str7, stMetaAddr stmetaaddr, String str8) {
        this.f25130id = str;
        this.type = i3;
        this.uid = str2;
        this.createtime = i16;
        this.nick = str3;
        this.avatar = str4;
        this.schema_url = str5;
        this.relation_type = i17;
        this.followStatus = i18;
        this.medal = i19;
        this.nueric = stmetanumericsys;
        this.recommendReason = str6;
        this.sex = i26;
        this.avatarSchema = stschema;
        this.live = stlive;
        this.extInfo = stpersonext;
        this.status = str7;
        this.formatAddr = stmetaaddr;
        this.background = str8;
    }
}
