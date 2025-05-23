package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class daily_config_eventcard extends JceStruct {
    static feeds_video_actalbum_config cache_vid_alb_config = new feeds_video_actalbum_config();
    static int cache_yy_type;
    public long end_time;
    public long start_time;
    public long trigger_end_time;
    public long trigger_start_time;
    public feeds_video_actalbum_config vid_alb_config;
    public int yy_type;

    public daily_config_eventcard() {
        this.start_time = 0L;
        this.end_time = 0L;
        this.trigger_start_time = 0L;
        this.trigger_end_time = 0L;
        this.yy_type = 0;
        this.vid_alb_config = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.start_time = jceInputStream.read(this.start_time, 0, true);
        this.end_time = jceInputStream.read(this.end_time, 1, true);
        this.trigger_start_time = jceInputStream.read(this.trigger_start_time, 2, true);
        this.trigger_end_time = jceInputStream.read(this.trigger_end_time, 3, true);
        this.yy_type = jceInputStream.read(this.yy_type, 4, false);
        this.vid_alb_config = (feeds_video_actalbum_config) jceInputStream.read((JceStruct) cache_vid_alb_config, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.start_time, 0);
        jceOutputStream.write(this.end_time, 1);
        jceOutputStream.write(this.trigger_start_time, 2);
        jceOutputStream.write(this.trigger_end_time, 3);
        jceOutputStream.write(this.yy_type, 4);
        feeds_video_actalbum_config feeds_video_actalbum_configVar = this.vid_alb_config;
        if (feeds_video_actalbum_configVar != null) {
            jceOutputStream.write((JceStruct) feeds_video_actalbum_configVar, 5);
        }
    }

    public daily_config_eventcard(long j3, long j16, long j17, long j18, int i3, feeds_video_actalbum_config feeds_video_actalbum_configVar) {
        this.start_time = j3;
        this.end_time = j16;
        this.trigger_start_time = j17;
        this.trigger_end_time = j18;
        this.yy_type = i3;
        this.vid_alb_config = feeds_video_actalbum_configVar;
    }
}
