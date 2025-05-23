package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_nag_feedback_req extends JceStruct {
    static ArrayList<nagative_fb_info> cache_vecNagFbInfo = new ArrayList<>();
    public long feedsUin;
    public long loginUin;
    public ArrayList<nagative_fb_info> vecNagFbInfo;

    static {
        cache_vecNagFbInfo.add(new nagative_fb_info());
    }

    public mobile_video_nag_feedback_req() {
        this.loginUin = 0L;
        this.feedsUin = 0L;
        this.vecNagFbInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.loginUin = jceInputStream.read(this.loginUin, 0, false);
        this.feedsUin = jceInputStream.read(this.feedsUin, 1, false);
        this.vecNagFbInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecNagFbInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.loginUin, 0);
        jceOutputStream.write(this.feedsUin, 1);
        ArrayList<nagative_fb_info> arrayList = this.vecNagFbInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public mobile_video_nag_feedback_req(long j3, long j16, ArrayList<nagative_fb_info> arrayList) {
        this.loginUin = j3;
        this.feedsUin = j16;
        this.vecNagFbInfo = arrayList;
    }
}
