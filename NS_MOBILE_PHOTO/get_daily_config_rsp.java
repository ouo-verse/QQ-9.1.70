package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_daily_config_rsp extends JceStruct {
    static daily_config_eventcard cache_eventCard_conf = new daily_config_eventcard();
    static daily_recommend_status cache_recommend_status = new daily_recommend_status();
    public daily_config_eventcard eventCard_conf;
    public daily_recommend_status recommend_status;
    public boolean remind_upload_on;
    public long uin;

    public get_daily_config_rsp() {
        this.uin = 0L;
        this.eventCard_conf = null;
        this.recommend_status = null;
        this.remind_upload_on = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.eventCard_conf = (daily_config_eventcard) jceInputStream.read((JceStruct) cache_eventCard_conf, 1, false);
        this.recommend_status = (daily_recommend_status) jceInputStream.read((JceStruct) cache_recommend_status, 2, false);
        this.remind_upload_on = jceInputStream.read(this.remind_upload_on, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        daily_config_eventcard daily_config_eventcardVar = this.eventCard_conf;
        if (daily_config_eventcardVar != null) {
            jceOutputStream.write((JceStruct) daily_config_eventcardVar, 1);
        }
        daily_recommend_status daily_recommend_statusVar = this.recommend_status;
        if (daily_recommend_statusVar != null) {
            jceOutputStream.write((JceStruct) daily_recommend_statusVar, 2);
        }
        jceOutputStream.write(this.remind_upload_on, 3);
    }

    public get_daily_config_rsp(long j3, daily_config_eventcard daily_config_eventcardVar, daily_recommend_status daily_recommend_statusVar, boolean z16) {
        this.uin = j3;
        this.eventCard_conf = daily_config_eventcardVar;
        this.recommend_status = daily_recommend_statusVar;
        this.remind_upload_on = z16;
    }
}
