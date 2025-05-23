package PUSH_UPDATE_FEEDS;

import NS_MOBILE_FEEDS.SimpleComment;
import NS_MOBILE_FEEDS.s_commment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommentReplyInfo extends JceStruct {
    static ArrayList<SimpleComment> cache_all_commont_list = new ArrayList<>();
    static s_commment cache_cur_comment_reply;
    public ArrayList<SimpleComment> all_commont_list;
    public s_commment cur_comment_reply;
    public int real_num;
    public int total_num;

    static {
        cache_all_commont_list.add(new SimpleComment());
        cache_cur_comment_reply = new s_commment();
    }

    public CommentReplyInfo() {
        this.all_commont_list = null;
        this.cur_comment_reply = null;
        this.total_num = 0;
        this.real_num = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_commont_list = (ArrayList) jceInputStream.read((JceInputStream) cache_all_commont_list, 0, false);
        this.cur_comment_reply = (s_commment) jceInputStream.read((JceStruct) cache_cur_comment_reply, 1, false);
        this.total_num = jceInputStream.read(this.total_num, 2, false);
        this.real_num = jceInputStream.read(this.real_num, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SimpleComment> arrayList = this.all_commont_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        s_commment s_commmentVar = this.cur_comment_reply;
        if (s_commmentVar != null) {
            jceOutputStream.write((JceStruct) s_commmentVar, 1);
        }
        jceOutputStream.write(this.total_num, 2);
        jceOutputStream.write(this.real_num, 3);
    }

    public CommentReplyInfo(ArrayList<SimpleComment> arrayList, s_commment s_commmentVar, int i3, int i16) {
        this.all_commont_list = arrayList;
        this.cur_comment_reply = s_commmentVar;
        this.total_num = i3;
        this.real_num = i16;
    }
}
