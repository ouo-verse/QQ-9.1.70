package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoInfo extends JceStruct {
    public VideoSpec stVideoSpec;
    public VideoUrl stVideoUrl;
    static VideoUrl cache_stVideoUrl = new VideoUrl();
    static VideoSpec cache_stVideoSpec = new VideoSpec();

    public VideoInfo() {
        this.stVideoUrl = null;
        this.stVideoSpec = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stVideoUrl = (VideoUrl) jceInputStream.read((JceStruct) cache_stVideoUrl, 0, false);
        this.stVideoSpec = (VideoSpec) jceInputStream.read((JceStruct) cache_stVideoSpec, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        VideoUrl videoUrl = this.stVideoUrl;
        if (videoUrl != null) {
            jceOutputStream.write((JceStruct) videoUrl, 0);
        }
        VideoSpec videoSpec = this.stVideoSpec;
        if (videoSpec != null) {
            jceOutputStream.write((JceStruct) videoSpec, 1);
        }
    }

    public VideoInfo(VideoUrl videoUrl, VideoSpec videoSpec) {
        this.stVideoUrl = videoUrl;
        this.stVideoSpec = videoSpec;
    }
}
