package cooperation.qwallet.plugin.ipc;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletRedTouchInfo implements Serializable {
    public static final int SITE_FOR_H5 = 3;
    public static final int SITE_FOR_NORMAL_APPS = 2;
    public static final int SITE_FOR_OPERATION_APPS = 4;
    public static final int SITE_FOR_TOP_APPS = 1;
    private static final long serialVersionUID = 1;
    public int adId;
    public int appId;
    public String buffer;
    public String fullBuffer;
    public String imageRedContent;
    public String imageRedDesc;
    public String path;
    public String redDotContent;
    public String redDotIconUrl;
    public int redDotType;
    public int site;
    public int type;

    public QWalletRedTouchInfo(String str, int i3, String str2, String str3, String str4) {
        this(str, i3, 0, str2, str3, str4, 0, 0, 0, null, null, null);
    }

    public boolean isForH5() {
        if (this.site == 3 && this.appId != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "QWalletRedTouchInfo{path='" + this.path + "', type=" + this.type + ", site=" + this.site + ", appId=" + this.appId + '}';
    }

    public QWalletRedTouchInfo(String str, int i3, int i16, String str2, String str3, String str4, int i17, int i18, int i19, String str5, String str6, String str7) {
        this.path = str;
        this.type = i3;
        this.adId = i16;
        this.buffer = str2;
        this.imageRedDesc = str3;
        this.imageRedContent = str4;
        this.site = i17;
        this.appId = i18;
        this.redDotType = i19;
        this.redDotContent = str5;
        this.redDotIconUrl = str6;
        this.fullBuffer = str7;
    }
}
