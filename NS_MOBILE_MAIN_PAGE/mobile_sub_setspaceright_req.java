package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setspaceright_req extends JceStruct {
    static byte[] cache_allowGroupsId;
    static s_question cache_questions;
    public byte[] allowGroupsId;
    public long cur_seq;
    public s_question questions;
    public int rightval;
    public long uin;

    public mobile_sub_setspaceright_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.rightval = jceInputStream.read(this.rightval, 1, true);
        if (cache_allowGroupsId == null) {
            cache_allowGroupsId = r0;
            byte[] bArr = {0};
        }
        this.allowGroupsId = jceInputStream.read(cache_allowGroupsId, 2, false);
        this.cur_seq = jceInputStream.read(this.cur_seq, 3, false);
        if (cache_questions == null) {
            cache_questions = new s_question();
        }
        this.questions = (s_question) jceInputStream.read((JceStruct) cache_questions, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.rightval, 1);
        byte[] bArr = this.allowGroupsId;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        jceOutputStream.write(this.cur_seq, 3);
        s_question s_questionVar = this.questions;
        if (s_questionVar != null) {
            jceOutputStream.write((JceStruct) s_questionVar, 4);
        }
    }

    public mobile_sub_setspaceright_req(long j3, int i3, byte[] bArr, long j16, s_question s_questionVar) {
        this.uin = j3;
        this.rightval = i3;
        this.allowGroupsId = bArr;
        this.cur_seq = j16;
        this.questions = s_questionVar;
    }
}
