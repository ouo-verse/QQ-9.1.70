package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqCreateDiscuss extends JceStruct {
    static int cache_DiscussType;
    static ArrayList<AddDiscussMemberInfo> cache_Members;
    public int DiscussType;
    public ArrayList<AddDiscussMemberInfo> Members;
    public String Name;
    public String Nick;
    public int Refer;

    public ReqCreateDiscuss() {
        this.Name = "";
        this.Members = null;
        this.DiscussType = 0;
        this.Nick = "";
        this.Refer = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Name = jceInputStream.readString(0, true);
        if (cache_Members == null) {
            cache_Members = new ArrayList<>();
            cache_Members.add(new AddDiscussMemberInfo());
        }
        this.Members = (ArrayList) jceInputStream.read((JceInputStream) cache_Members, 1, true);
        this.DiscussType = jceInputStream.read(this.DiscussType, 2, false);
        this.Nick = jceInputStream.readString(3, false);
        this.Refer = jceInputStream.read(this.Refer, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Name, 0);
        jceOutputStream.write((Collection) this.Members, 1);
        jceOutputStream.write(this.DiscussType, 2);
        String str = this.Nick;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.Refer, 4);
    }

    public ReqCreateDiscuss(String str, ArrayList<AddDiscussMemberInfo> arrayList, int i3, String str2, int i16) {
        this.Name = str;
        this.Members = arrayList;
        this.DiscussType = i3;
        this.Nick = str2;
        this.Refer = i16;
    }
}
