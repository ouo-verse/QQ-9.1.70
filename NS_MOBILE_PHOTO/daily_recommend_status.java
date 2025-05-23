package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class daily_recommend_status extends JceStruct {
    static int cache_switchType;
    public boolean recommendPush_on;
    public boolean recommend_on;
    public int switchType;

    public daily_recommend_status() {
        this.recommend_on = true;
        this.recommendPush_on = true;
        this.switchType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.recommend_on = jceInputStream.read(this.recommend_on, 0, false);
        this.recommendPush_on = jceInputStream.read(this.recommendPush_on, 1, false);
        this.switchType = jceInputStream.read(this.switchType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.recommend_on, 0);
        jceOutputStream.write(this.recommendPush_on, 1);
        jceOutputStream.write(this.switchType, 2);
    }

    public daily_recommend_status(boolean z16, boolean z17, int i3) {
        this.recommend_on = z16;
        this.recommendPush_on = z17;
        this.switchType = i3;
    }
}
