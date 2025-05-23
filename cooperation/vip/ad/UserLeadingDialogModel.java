package cooperation.vip.ad;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UserLeadingDialogModel implements Serializable {
    public static final String CUSTOM_TYPE = "3";
    public static final String GIF_TYPE = "1";
    public static final String IMAGE_TYPE = "0";
    public static final int PARAMN_COUNT = 11;
    public static final String VIDEO_TYPE = "2";
    private String title = "";
    private String titleColor = "";
    private String content = "";
    private String contentColor = "";
    private String resType = "";
    private String resUrl = "";
    private String resPlaceholder = "";
    private String resCustomUrl = "";
    private String resLink = "";
    private String buttonText = "";
    private String buttonColor = "";
    private String buttonTextColor = "";
    private String resCustomHippyWh = "";
    private String resCustomHippyTraceId = "";

    public String getButtonColor() {
        return this.buttonColor;
    }

    public String getButtonColorDark() {
        if (this.buttonColor.equals("")) {
            return "";
        }
        String[] split = this.buttonColor.split("_");
        if (split.length < 1) {
            return "";
        }
        return split[1];
    }

    public String getButtonColorLight() {
        if (this.buttonColor.equals("")) {
            return "";
        }
        String[] split = this.buttonColor.split("_");
        if (split.length < 0) {
            return "";
        }
        return split[0];
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public String getButtonTextColorDark() {
        if (this.buttonTextColor.equals("")) {
            return "";
        }
        String[] split = this.buttonTextColor.split("_");
        if (split.length < 1) {
            return "";
        }
        return split[1];
    }

    public String getButtonTextColorLight() {
        if (this.buttonTextColor.equals("")) {
            return "";
        }
        String[] split = this.buttonTextColor.split("_");
        if (split.length < 0) {
            return "";
        }
        return split[0];
    }

    public String getContent() {
        return this.content;
    }

    public String getContentColor() {
        return this.contentColor;
    }

    public String getContentColorDark() {
        if (this.contentColor.equals("")) {
            return "";
        }
        String[] split = this.contentColor.split("_");
        if (split.length < 1) {
            return "";
        }
        return split[1];
    }

    public String getContentColorLight() {
        if (this.contentColor.equals("")) {
            return "";
        }
        String[] split = this.contentColor.split("_");
        if (split.length < 0) {
            return "";
        }
        return split[0];
    }

    public String getResCustomHippyTraceId() {
        return this.resCustomHippyTraceId;
    }

    public String getResCustomHippyWh() {
        return this.resCustomHippyWh;
    }

    public String getResCustomUrl() {
        return this.resCustomUrl;
    }

    public String getResLink() {
        return this.resLink;
    }

    public String getResPlaceholder() {
        return this.resPlaceholder;
    }

    public String getResType() {
        return this.resType;
    }

    public String getResUrl() {
        return this.resUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String getTitleColorDark() {
        if (this.titleColor.equals("")) {
            return "";
        }
        String[] split = this.titleColor.split("_");
        if (split.length < 1) {
            return "";
        }
        return split[1];
    }

    public String getTitleColorLight() {
        if (this.titleColor.equals("")) {
            return "";
        }
        String[] split = this.titleColor.split("_");
        if (split.length < 0) {
            return "";
        }
        return split[0];
    }

    public boolean isCustomType() {
        String str = this.resType;
        if (str != "" && str.equals("3")) {
            return true;
        }
        return false;
    }

    public boolean isDynamicImageType() {
        String str = this.resType;
        if (str != "" && str.equals("1")) {
            return true;
        }
        return false;
    }

    public boolean isImageType() {
        String str = this.resType;
        if (str != "" && str.equals("0")) {
            return true;
        }
        return false;
    }

    public boolean isVideoType() {
        String str = this.resType;
        if (str != "" && str.equals("2")) {
            return true;
        }
        return false;
    }

    public void setButtonColor(String str) {
        this.buttonColor = str;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setButtonTextColor(String str) {
        this.buttonTextColor = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentColor(String str) {
        this.contentColor = str;
    }

    public void setResCustomHippyTraceId(String str) {
        this.resCustomHippyTraceId = str;
    }

    public void setResCustomHippyWh(String str) {
        this.resCustomHippyWh = str;
    }

    public void setResCustomUrl(String str) {
        this.resCustomUrl = str;
    }

    public void setResLink(String str) {
        this.resLink = str;
    }

    public void setResPlaceholder(String str) {
        this.resPlaceholder = str;
    }

    public void setResType(String str) {
        this.resType = str;
    }

    public void setResUrl(String str) {
        this.resUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleColor(String str) {
        this.titleColor = str;
    }

    public String toString() {
        return "UserLeadingDialogModel{title='" + this.title + "', titleColor='" + this.titleColor + "', content='" + this.content + "', contentColor='" + this.contentColor + "', resType='" + this.resType + "', resUrl='" + this.resUrl + "', resPlaceholder='" + this.resPlaceholder + "', resCustomUrl='" + this.resCustomUrl + "', resLink='" + this.resLink + "', buttonText='" + this.buttonText + "', buttonColor='" + this.buttonColor + "', buttonTextColor='" + this.buttonTextColor + "', resCustomHippyWh='" + this.resCustomHippyWh + "', resCustomHippyTraceId='" + this.resCustomHippyTraceId + "'}";
    }
}
