package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TrafficResultInfo extends JceStruct {
    public int bUpdate;
    public int iDrawerEnable;
    public int iDrawerTextId;
    public int iGuideEnable;
    public int iImsiInterval;
    public int iReportInterval;
    public int iWkOrderState1;
    public int iWkOrderState2;
    public PopupImgInfo popInfo;
    public String sDrawerText;
    public String sDrawerTextRuleID;
    public String sDrawerUrl;
    public String sGuideUrl;
    public ToastImgInfo toasInfo;
    static ToastImgInfo cache_toasInfo = new ToastImgInfo();
    static PopupImgInfo cache_popInfo = new PopupImgInfo();

    public TrafficResultInfo() {
        this.iWkOrderState1 = 0;
        this.iWkOrderState2 = 0;
        this.iDrawerEnable = 0;
        this.iGuideEnable = 0;
        this.sDrawerText = "";
        this.sDrawerUrl = "";
        this.sGuideUrl = "";
        this.iImsiInterval = 0;
        this.toasInfo = null;
        this.popInfo = null;
        this.iReportInterval = 0;
        this.bUpdate = 0;
        this.iDrawerTextId = 0;
        this.sDrawerTextRuleID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iWkOrderState1 = jceInputStream.read(this.iWkOrderState1, 0, false);
        this.iWkOrderState2 = jceInputStream.read(this.iWkOrderState2, 1, false);
        this.iDrawerEnable = jceInputStream.read(this.iDrawerEnable, 2, false);
        this.iGuideEnable = jceInputStream.read(this.iGuideEnable, 3, false);
        this.sDrawerText = jceInputStream.readString(4, false);
        this.sDrawerUrl = jceInputStream.readString(5, false);
        this.sGuideUrl = jceInputStream.readString(6, false);
        this.iImsiInterval = jceInputStream.read(this.iImsiInterval, 7, false);
        this.toasInfo = (ToastImgInfo) jceInputStream.read((JceStruct) cache_toasInfo, 8, false);
        this.popInfo = (PopupImgInfo) jceInputStream.read((JceStruct) cache_popInfo, 9, false);
        this.iReportInterval = jceInputStream.read(this.iReportInterval, 10, false);
        this.bUpdate = jceInputStream.read(this.bUpdate, 11, false);
        this.iDrawerTextId = jceInputStream.read(this.iDrawerTextId, 12, false);
        this.sDrawerTextRuleID = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iWkOrderState1, 0);
        jceOutputStream.write(this.iWkOrderState2, 1);
        jceOutputStream.write(this.iDrawerEnable, 2);
        jceOutputStream.write(this.iGuideEnable, 3);
        String str = this.sDrawerText;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.sDrawerUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.sGuideUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.iImsiInterval, 7);
        ToastImgInfo toastImgInfo = this.toasInfo;
        if (toastImgInfo != null) {
            jceOutputStream.write((JceStruct) toastImgInfo, 8);
        }
        PopupImgInfo popupImgInfo = this.popInfo;
        if (popupImgInfo != null) {
            jceOutputStream.write((JceStruct) popupImgInfo, 9);
        }
        jceOutputStream.write(this.iReportInterval, 10);
        jceOutputStream.write(this.bUpdate, 11);
        jceOutputStream.write(this.iDrawerTextId, 12);
        String str4 = this.sDrawerTextRuleID;
        if (str4 != null) {
            jceOutputStream.write(str4, 13);
        }
    }

    public TrafficResultInfo(int i3, int i16, int i17, int i18, String str, String str2, String str3, int i19, ToastImgInfo toastImgInfo, PopupImgInfo popupImgInfo, int i26, int i27, int i28, String str4) {
        this.iWkOrderState1 = i3;
        this.iWkOrderState2 = i16;
        this.iDrawerEnable = i17;
        this.iGuideEnable = i18;
        this.sDrawerText = str;
        this.sDrawerUrl = str2;
        this.sGuideUrl = str3;
        this.iImsiInterval = i19;
        this.toasInfo = toastImgInfo;
        this.popInfo = popupImgInfo;
        this.iReportInterval = i26;
        this.bUpdate = i27;
        this.iDrawerTextId = i28;
        this.sDrawerTextRuleID = str4;
    }
}
