package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetCommentReplyListRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<stMetaReply> cache_reply_list = new ArrayList<>();
    public String attach_info;
    public boolean isFinished;
    public boolean isRFinished;
    public ArrayList<stMetaReply> reply_list;
    public int total_reply_num;

    static {
        cache_reply_list.add(new stMetaReply());
    }

    public stGetCommentReplyListRsp() {
        this.attach_info = "";
        this.reply_list = null;
        this.isFinished = true;
        this.total_reply_num = 0;
        this.isRFinished = true;
    }

    public String className() {
        return "NS_KING_INTERFACE.stGetCommentReplyListRsp";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.attach_info, "attach_info");
        jceDisplayer.display((Collection) this.reply_list, "reply_list");
        jceDisplayer.display(this.isFinished, "isFinished");
        jceDisplayer.display(this.total_reply_num, "total_reply_num");
        jceDisplayer.display(this.isRFinished, "isRFinished");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.attach_info, true);
        jceDisplayer.displaySimple((Collection) this.reply_list, true);
        jceDisplayer.displaySimple(this.isFinished, true);
        jceDisplayer.displaySimple(this.total_reply_num, true);
        jceDisplayer.displaySimple(this.isRFinished, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stGetCommentReplyListRsp stgetcommentreplylistrsp = (stGetCommentReplyListRsp) obj;
        if (!JceUtil.equals(this.attach_info, stgetcommentreplylistrsp.attach_info) || !JceUtil.equals(this.reply_list, stgetcommentreplylistrsp.reply_list) || !JceUtil.equals(this.isFinished, stgetcommentreplylistrsp.isFinished) || !JceUtil.equals(this.total_reply_num, stgetcommentreplylistrsp.total_reply_num) || !JceUtil.equals(this.isRFinished, stgetcommentreplylistrsp.isRFinished)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stGetCommentReplyListRsp";
    }

    public String getAttach_info() {
        return this.attach_info;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public boolean getIsRFinished() {
        return this.isRFinished;
    }

    public ArrayList<stMetaReply> getReply_list() {
        return this.reply_list;
    }

    public int getTotal_reply_num() {
        return this.total_reply_num;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attach_info = jceInputStream.readString(0, true);
        this.reply_list = (ArrayList) jceInputStream.read((JceInputStream) cache_reply_list, 1, true);
        this.isFinished = jceInputStream.read(this.isFinished, 2, true);
        this.total_reply_num = jceInputStream.read(this.total_reply_num, 3, false);
        this.isRFinished = jceInputStream.read(this.isRFinished, 4, false);
    }

    public void setAttach_info(String str) {
        this.attach_info = str;
    }

    public void setIsFinished(boolean z16) {
        this.isFinished = z16;
    }

    public void setIsRFinished(boolean z16) {
        this.isRFinished = z16;
    }

    public void setReply_list(ArrayList<stMetaReply> arrayList) {
        this.reply_list = arrayList;
    }

    public void setTotal_reply_num(int i3) {
        this.total_reply_num = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.attach_info, 0);
        jceOutputStream.write((Collection) this.reply_list, 1);
        jceOutputStream.write(this.isFinished, 2);
        jceOutputStream.write(this.total_reply_num, 3);
        jceOutputStream.write(this.isRFinished, 4);
    }

    public stGetCommentReplyListRsp(String str, ArrayList<stMetaReply> arrayList, boolean z16, int i3, boolean z17) {
        this.attach_info = str;
        this.reply_list = arrayList;
        this.isFinished = z16;
        this.total_reply_num = i3;
        this.isRFinished = z17;
    }
}
