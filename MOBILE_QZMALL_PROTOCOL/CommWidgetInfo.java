package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommWidgetInfo extends JceStruct {
    static int cache_type;
    public boolean bShow;
    public ArrowInfo stArrowInfo;
    public DescInfo stDescInfo;
    public NumberInfo stNumberInfo;
    public WidgetMargin stWidgetMargin;
    public String strDownloadAppPackageName;
    public String strJumpUrl;
    public String strTraceInfo;
    public String strWidgetUrl;
    public int type;
    public long uiFrameIntervalMs;
    public long uiLevel;
    public long uiLoopIntervalMs;
    static ArrowInfo cache_stArrowInfo = new ArrowInfo();
    static WidgetMargin cache_stWidgetMargin = new WidgetMargin();
    static DescInfo cache_stDescInfo = new DescInfo();
    static NumberInfo cache_stNumberInfo = new NumberInfo();

    public CommWidgetInfo() {
        this.bShow = false;
        this.type = 0;
        this.strWidgetUrl = "";
        this.stArrowInfo = null;
        this.strJumpUrl = "";
        this.uiLevel = 0L;
        this.stWidgetMargin = null;
        this.stDescInfo = null;
        this.stNumberInfo = null;
        this.uiFrameIntervalMs = 0L;
        this.uiLoopIntervalMs = 0L;
        this.strTraceInfo = "";
        this.strDownloadAppPackageName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bShow = jceInputStream.read(this.bShow, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.strWidgetUrl = jceInputStream.readString(2, false);
        this.stArrowInfo = (ArrowInfo) jceInputStream.read((JceStruct) cache_stArrowInfo, 3, false);
        this.strJumpUrl = jceInputStream.readString(4, false);
        this.uiLevel = jceInputStream.read(this.uiLevel, 5, false);
        this.stWidgetMargin = (WidgetMargin) jceInputStream.read((JceStruct) cache_stWidgetMargin, 6, false);
        this.stDescInfo = (DescInfo) jceInputStream.read((JceStruct) cache_stDescInfo, 7, false);
        this.stNumberInfo = (NumberInfo) jceInputStream.read((JceStruct) cache_stNumberInfo, 8, false);
        this.uiFrameIntervalMs = jceInputStream.read(this.uiFrameIntervalMs, 9, false);
        this.uiLoopIntervalMs = jceInputStream.read(this.uiLoopIntervalMs, 10, false);
        this.strTraceInfo = jceInputStream.readString(11, false);
        this.strDownloadAppPackageName = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bShow, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.strWidgetUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        ArrowInfo arrowInfo = this.stArrowInfo;
        if (arrowInfo != null) {
            jceOutputStream.write((JceStruct) arrowInfo, 3);
        }
        String str2 = this.strJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.uiLevel, 5);
        WidgetMargin widgetMargin = this.stWidgetMargin;
        if (widgetMargin != null) {
            jceOutputStream.write((JceStruct) widgetMargin, 6);
        }
        DescInfo descInfo = this.stDescInfo;
        if (descInfo != null) {
            jceOutputStream.write((JceStruct) descInfo, 7);
        }
        NumberInfo numberInfo = this.stNumberInfo;
        if (numberInfo != null) {
            jceOutputStream.write((JceStruct) numberInfo, 8);
        }
        jceOutputStream.write(this.uiFrameIntervalMs, 9);
        jceOutputStream.write(this.uiLoopIntervalMs, 10);
        String str3 = this.strTraceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.strDownloadAppPackageName;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
    }

    public CommWidgetInfo(boolean z16, int i3, String str, ArrowInfo arrowInfo, String str2, long j3, WidgetMargin widgetMargin, DescInfo descInfo, NumberInfo numberInfo, long j16, long j17, String str3, String str4) {
        this.bShow = z16;
        this.type = i3;
        this.strWidgetUrl = str;
        this.stArrowInfo = arrowInfo;
        this.strJumpUrl = str2;
        this.uiLevel = j3;
        this.stWidgetMargin = widgetMargin;
        this.stDescInfo = descInfo;
        this.stNumberInfo = numberInfo;
        this.uiFrameIntervalMs = j16;
        this.uiLoopIntervalMs = j17;
        this.strTraceInfo = str3;
        this.strDownloadAppPackageName = str4;
    }
}
