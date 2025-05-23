package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class rtmp_report_timed_info extends JceStruct {
    static int cache_play_status;
    public long anchor_svr_delay;
    public double app_memory_usage;
    public long audience_svr_delay;
    public String audio_play_err_code;
    public double cpu_usage;
    public double downstream_audio_bitrate;
    public double downstream_total_bitrate;
    public double downstream_video_bitrate;
    public long lTime;
    public String play_err_code;
    public int play_status;
    public String video_play_err_code;

    public rtmp_report_timed_info() {
        this.anchor_svr_delay = 0L;
        this.audience_svr_delay = 0L;
        this.downstream_total_bitrate = 0.0d;
        this.downstream_video_bitrate = 0.0d;
        this.downstream_audio_bitrate = 0.0d;
        this.play_status = 0;
        this.app_memory_usage = 0.0d;
        this.cpu_usage = 0.0d;
        this.audio_play_err_code = "";
        this.video_play_err_code = "";
        this.play_err_code = "";
        this.lTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.anchor_svr_delay = jceInputStream.read(this.anchor_svr_delay, 0, false);
        this.audience_svr_delay = jceInputStream.read(this.audience_svr_delay, 1, false);
        this.downstream_total_bitrate = jceInputStream.read(this.downstream_total_bitrate, 2, false);
        this.downstream_video_bitrate = jceInputStream.read(this.downstream_video_bitrate, 3, false);
        this.downstream_audio_bitrate = jceInputStream.read(this.downstream_audio_bitrate, 4, false);
        this.play_status = jceInputStream.read(this.play_status, 5, false);
        this.app_memory_usage = jceInputStream.read(this.app_memory_usage, 6, false);
        this.cpu_usage = jceInputStream.read(this.cpu_usage, 7, false);
        this.audio_play_err_code = jceInputStream.readString(8, false);
        this.video_play_err_code = jceInputStream.readString(9, false);
        this.play_err_code = jceInputStream.readString(10, false);
        this.lTime = jceInputStream.read(this.lTime, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.anchor_svr_delay, 0);
        jceOutputStream.write(this.audience_svr_delay, 1);
        jceOutputStream.write(this.downstream_total_bitrate, 2);
        jceOutputStream.write(this.downstream_video_bitrate, 3);
        jceOutputStream.write(this.downstream_audio_bitrate, 4);
        jceOutputStream.write(this.play_status, 5);
        jceOutputStream.write(this.app_memory_usage, 6);
        jceOutputStream.write(this.cpu_usage, 7);
        String str = this.audio_play_err_code;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.video_play_err_code;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        String str3 = this.play_err_code;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        jceOutputStream.write(this.lTime, 11);
    }

    public rtmp_report_timed_info(long j3, long j16, double d16, double d17, double d18, int i3, double d19, double d26, String str, String str2, String str3, long j17) {
        this.anchor_svr_delay = j3;
        this.audience_svr_delay = j16;
        this.downstream_total_bitrate = d16;
        this.downstream_video_bitrate = d17;
        this.downstream_audio_bitrate = d18;
        this.play_status = i3;
        this.app_memory_usage = d19;
        this.cpu_usage = d26;
        this.audio_play_err_code = str;
        this.video_play_err_code = str2;
        this.play_err_code = str3;
        this.lTime = j17;
    }
}
