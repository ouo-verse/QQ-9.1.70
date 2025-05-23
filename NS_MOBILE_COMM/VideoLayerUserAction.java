package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoLayerUserAction extends JceStruct implements Comparable<VideoLayerUserAction> {
    public int appid;
    public boolean has_comment;
    public boolean has_follow;
    public boolean has_forward;
    public boolean has_like;
    public int index;
    public String mkey;
    public long video_duration;
    public int video_integrity;

    public VideoLayerUserAction() {
        this.index = 0;
        this.appid = 0;
        this.video_integrity = 0;
        this.video_duration = 0L;
        this.has_like = false;
        this.has_comment = false;
        this.has_forward = false;
        this.has_follow = false;
        this.mkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.index = jceInputStream.read(this.index, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.video_integrity = jceInputStream.read(this.video_integrity, 2, false);
        this.video_duration = jceInputStream.read(this.video_duration, 3, false);
        this.has_like = jceInputStream.read(this.has_like, 4, false);
        this.has_comment = jceInputStream.read(this.has_comment, 5, false);
        this.has_forward = jceInputStream.read(this.has_forward, 6, false);
        this.has_follow = jceInputStream.read(this.has_follow, 7, false);
        this.mkey = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.index, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.video_integrity, 2);
        jceOutputStream.write(this.video_duration, 3);
        jceOutputStream.write(this.has_like, 4);
        jceOutputStream.write(this.has_comment, 5);
        jceOutputStream.write(this.has_forward, 6);
        jceOutputStream.write(this.has_follow, 7);
        String str = this.mkey;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(VideoLayerUserAction videoLayerUserAction) {
        int[] iArr = {JceUtil.compareTo(this.index, videoLayerUserAction.index)};
        for (int i3 = 0; i3 < 1; i3++) {
            int i16 = iArr[i3];
            if (i16 != 0) {
                return i16;
            }
        }
        return 0;
    }

    public VideoLayerUserAction(int i3, int i16, int i17, long j3, boolean z16, boolean z17, boolean z18, boolean z19, String str) {
        this.index = i3;
        this.appid = i16;
        this.video_integrity = i17;
        this.video_duration = j3;
        this.has_like = z16;
        this.has_comment = z17;
        this.has_forward = z18;
        this.has_follow = z19;
        this.mkey = str;
    }
}
