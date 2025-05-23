package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_daily_config_req extends JceStruct {
    static int cache_confid;
    static daily_recommend_status cache_recommend_status = new daily_recommend_status();
    public int confid;
    public daily_recommend_status recommend_status;
    public boolean remind_upload_on;
    public long uin;

    public get_daily_config_req() {
        this.uin = 0L;
        this.confid = 0;
        this.recommend_status = null;
        this.remind_upload_on = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.confid = jceInputStream.read(this.confid, 1, true);
        this.recommend_status = (daily_recommend_status) jceInputStream.read((JceStruct) cache_recommend_status, 2, false);
        this.remind_upload_on = jceInputStream.read(this.remind_upload_on, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.confid, 1);
        daily_recommend_status daily_recommend_statusVar = this.recommend_status;
        if (daily_recommend_statusVar != null) {
            jceOutputStream.write((JceStruct) daily_recommend_statusVar, 2);
        }
        jceOutputStream.write(this.remind_upload_on, 3);
    }

    public get_daily_config_req(long j3, int i3) {
        this.recommend_status = null;
        this.remind_upload_on = false;
        this.uin = j3;
        this.confid = i3;
    }

    public get_daily_config_req(long j3, int i3, daily_recommend_status daily_recommend_statusVar, boolean z16) {
        this.uin = j3;
        this.confid = i3;
        this.recommend_status = daily_recommend_statusVar;
        this.remind_upload_on = z16;
    }
}
