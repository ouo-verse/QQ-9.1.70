package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaPerson;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSimpleComment extends JceStruct {
    public long dingNum;
    public stSchema dingSchema;
    public String feedId;

    /* renamed from: id, reason: collision with root package name */
    public String f25127id;
    public int isDing;
    public stMetaPerson poster;
    public String posterId;
    public String wording;
    static stMetaPerson cache_poster = new stMetaPerson();
    static stSchema cache_dingSchema = new stSchema();

    public stSimpleComment() {
        this.f25127id = "";
        this.wording = "";
        this.posterId = "";
        this.poster = null;
        this.dingNum = 0L;
        this.isDing = 0;
        this.feedId = "";
        this.dingSchema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25127id = jceInputStream.readString(0, false);
        this.wording = jceInputStream.readString(1, false);
        this.posterId = jceInputStream.readString(2, false);
        this.poster = (stMetaPerson) jceInputStream.read((JceStruct) cache_poster, 3, false);
        this.dingNum = jceInputStream.read(this.dingNum, 4, false);
        this.isDing = jceInputStream.read(this.isDing, 5, false);
        this.feedId = jceInputStream.readString(6, false);
        this.dingSchema = (stSchema) jceInputStream.read((JceStruct) cache_dingSchema, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25127id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.wording;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.posterId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        stMetaPerson stmetaperson = this.poster;
        if (stmetaperson != null) {
            jceOutputStream.write((JceStruct) stmetaperson, 3);
        }
        jceOutputStream.write(this.dingNum, 4);
        jceOutputStream.write(this.isDing, 5);
        String str4 = this.feedId;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        stSchema stschema = this.dingSchema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 7);
        }
    }

    public stSimpleComment(String str, String str2, String str3, stMetaPerson stmetaperson, long j3, int i3, String str4, stSchema stschema) {
        this.f25127id = str;
        this.wording = str2;
        this.posterId = str3;
        this.poster = stmetaperson;
        this.dingNum = j3;
        this.isDing = i3;
        this.feedId = str4;
        this.dingSchema = stschema;
    }
}
