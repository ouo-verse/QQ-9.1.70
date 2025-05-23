package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EventWidgetInfo extends JceStruct {
    static DescInfo cache_stDescInfo = new DescInfo();
    static VideoInfo cache_stVideoInfo = new VideoInfo();
    static int cache_type;
    public boolean bIsPreload;
    public boolean bShow;
    public DescInfo stDescInfo;
    public VideoInfo stVideoInfo;
    public String strBubbleDesc;
    public String strDownloadAppPackageName;
    public String strJumpUrl;
    public String strMaterialUrl;
    public String strTraceInfo;
    public int type;

    public EventWidgetInfo() {
        this.bShow = false;
        this.type = 0;
        this.strMaterialUrl = "";
        this.stDescInfo = null;
        this.stVideoInfo = null;
        this.strJumpUrl = "";
        this.bIsPreload = true;
        this.strBubbleDesc = "";
        this.strTraceInfo = "";
        this.strDownloadAppPackageName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bShow = jceInputStream.read(this.bShow, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.strMaterialUrl = jceInputStream.readString(2, false);
        this.stDescInfo = (DescInfo) jceInputStream.read((JceStruct) cache_stDescInfo, 3, false);
        this.stVideoInfo = (VideoInfo) jceInputStream.read((JceStruct) cache_stVideoInfo, 4, false);
        this.strJumpUrl = jceInputStream.readString(5, false);
        this.bIsPreload = jceInputStream.read(this.bIsPreload, 6, false);
        this.strBubbleDesc = jceInputStream.readString(7, false);
        this.strTraceInfo = jceInputStream.readString(8, false);
        this.strDownloadAppPackageName = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bShow, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.strMaterialUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        DescInfo descInfo = this.stDescInfo;
        if (descInfo != null) {
            jceOutputStream.write((JceStruct) descInfo, 3);
        }
        VideoInfo videoInfo = this.stVideoInfo;
        if (videoInfo != null) {
            jceOutputStream.write((JceStruct) videoInfo, 4);
        }
        String str2 = this.strJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.bIsPreload, 6);
        String str3 = this.strBubbleDesc;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.strTraceInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.strDownloadAppPackageName;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
    }

    public EventWidgetInfo(boolean z16, int i3, String str, DescInfo descInfo, VideoInfo videoInfo, String str2, boolean z17, String str3, String str4, String str5) {
        this.bShow = z16;
        this.type = i3;
        this.strMaterialUrl = str;
        this.stDescInfo = descInfo;
        this.stVideoInfo = videoInfo;
        this.strJumpUrl = str2;
        this.bIsPreload = z17;
        this.strBubbleDesc = str3;
        this.strTraceInfo = str4;
        this.strDownloadAppPackageName = str5;
    }
}
