package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_getspaceright_rsp extends JceStruct {
    static Map<Short, GROUP_RIGHT_INFO> cache_allGroups;
    static s_question cache_question;
    static Map<Long, FRIEND_INFO> cache_white_list;
    public Map<Short, GROUP_RIGHT_INFO> allGroups;
    public long cur_seq;
    public s_question question;
    public int rightval;
    public Map<Long, FRIEND_INFO> white_list;

    public mobile_sub_getspaceright_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.rightval = jceInputStream.read(this.rightval, 0, true);
        if (cache_allGroups == null) {
            cache_allGroups = new HashMap();
            cache_allGroups.put((short) 0, new GROUP_RIGHT_INFO());
        }
        this.allGroups = (Map) jceInputStream.read((JceInputStream) cache_allGroups, 1, false);
        this.cur_seq = jceInputStream.read(this.cur_seq, 2, false);
        if (cache_question == null) {
            cache_question = new s_question();
        }
        this.question = (s_question) jceInputStream.read((JceStruct) cache_question, 3, false);
        if (cache_white_list == null) {
            cache_white_list = new HashMap();
            cache_white_list.put(0L, new FRIEND_INFO());
        }
        this.white_list = (Map) jceInputStream.read((JceInputStream) cache_white_list, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.rightval, 0);
        Map<Short, GROUP_RIGHT_INFO> map = this.allGroups;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.cur_seq, 2);
        s_question s_questionVar = this.question;
        if (s_questionVar != null) {
            jceOutputStream.write((JceStruct) s_questionVar, 3);
        }
        Map<Long, FRIEND_INFO> map2 = this.white_list;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
    }

    public mobile_sub_getspaceright_rsp(int i3, Map<Short, GROUP_RIGHT_INFO> map, long j3, s_question s_questionVar, Map<Long, FRIEND_INFO> map2) {
        this.rightval = i3;
        this.allGroups = map;
        this.cur_seq = j3;
        this.question = s_questionVar;
        this.white_list = map2;
    }
}
