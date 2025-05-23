package cooperation.qzone.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzNotificationStruct {
    public String actionUrl;
    public String notifyText;
    public int pushType;
    public String pushstatkey;
    public String roomId;
    public boolean showMsgContent;

    public QzNotificationStruct(String str, String str2, boolean z16, int i3, String str3, String str4) {
        this.roomId = str;
        this.notifyText = str2;
        this.showMsgContent = z16;
        this.pushType = i3;
        this.actionUrl = str3;
        this.pushstatkey = str4;
    }
}
