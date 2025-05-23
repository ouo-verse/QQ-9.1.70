package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgInteractData extends JceStruct {
    static PushInfo cache_pushInfo;
    static ViewInfo cache_viewInfo;
    public CommentInfo commentInfo;
    public LikInfo likInfo;
    public PushInfo pushInfo;
    public ShareInfo shareInfo;
    public int type;
    public ArrayList<ButtonInfo> vecButtonInfo;
    public ViewInfo viewInfo;
    static LikInfo cache_likInfo = new LikInfo();
    static CommentInfo cache_commentInfo = new CommentInfo();
    static ShareInfo cache_shareInfo = new ShareInfo();
    static ArrayList<ButtonInfo> cache_vecButtonInfo = new ArrayList<>();

    static {
        cache_vecButtonInfo.add(new ButtonInfo());
        cache_pushInfo = new PushInfo();
        cache_viewInfo = new ViewInfo();
    }

    public MsgInteractData() {
        this.type = 0;
        this.likInfo = null;
        this.commentInfo = null;
        this.shareInfo = null;
        this.vecButtonInfo = null;
        this.pushInfo = null;
        this.viewInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.likInfo = (LikInfo) jceInputStream.read((JceStruct) cache_likInfo, 1, false);
        this.commentInfo = (CommentInfo) jceInputStream.read((JceStruct) cache_commentInfo, 2, false);
        this.shareInfo = (ShareInfo) jceInputStream.read((JceStruct) cache_shareInfo, 3, false);
        this.vecButtonInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecButtonInfo, 4, false);
        this.pushInfo = (PushInfo) jceInputStream.read((JceStruct) cache_pushInfo, 5, false);
        this.viewInfo = (ViewInfo) jceInputStream.read((JceStruct) cache_viewInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        LikInfo likInfo = this.likInfo;
        if (likInfo != null) {
            jceOutputStream.write((JceStruct) likInfo, 1);
        }
        CommentInfo commentInfo = this.commentInfo;
        if (commentInfo != null) {
            jceOutputStream.write((JceStruct) commentInfo, 2);
        }
        ShareInfo shareInfo = this.shareInfo;
        if (shareInfo != null) {
            jceOutputStream.write((JceStruct) shareInfo, 3);
        }
        ArrayList<ButtonInfo> arrayList = this.vecButtonInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        PushInfo pushInfo = this.pushInfo;
        if (pushInfo != null) {
            jceOutputStream.write((JceStruct) pushInfo, 5);
        }
        ViewInfo viewInfo = this.viewInfo;
        if (viewInfo != null) {
            jceOutputStream.write((JceStruct) viewInfo, 6);
        }
    }

    public MsgInteractData(int i3, LikInfo likInfo, CommentInfo commentInfo, ShareInfo shareInfo, ArrayList<ButtonInfo> arrayList, PushInfo pushInfo, ViewInfo viewInfo) {
        this.type = i3;
        this.likInfo = likInfo;
        this.commentInfo = commentInfo;
        this.shareInfo = shareInfo;
        this.vecButtonInfo = arrayList;
        this.pushInfo = pushInfo;
        this.viewInfo = viewInfo;
    }
}
