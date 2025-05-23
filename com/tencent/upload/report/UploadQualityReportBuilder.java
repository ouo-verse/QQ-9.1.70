package com.tencent.upload.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadQualityReportBuilder implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String CONTROL_PKG_DECODE_ERROR = "control_pkg_decode_error";
    public static final Parcelable.Creator<UploadQualityReportBuilder> CREATOR;
    public static final int RESULT_OK = 0;
    public static final String STATE_CONNECT = "connect";
    public static final String STATE_DISCONNECT = "disconnect";
    public static final String STATE_ERROR = "error";
    public static final String STATE_RESPONSE_COMMIT_FILE_PKG = "response_commit_file_pkg";
    public static final String STATE_RESPONSE_CONTROL_PKG = "response_control_pkg";
    public static final String STATE_RESPONSE_TIMEOUT = "response_Timeout";
    public static final String STATE_SEND_BATCH_CONTROL_PKG = "send_batch_control_pkg";
    public static final String STATE_SEND_COMMIT_FILE_PKG = "send_commit_file_pkg";
    public static final String STATE_SEND_COMMIT_UPLOAD_PKG = "send_commit_upload_pkg";
    public static final String STATE_SEND_CONTROL_PKG = "send_control_pkg";
    public static final String STATE_SEND_FILE_PKG = "send_file_pkg";
    public static final String STATE_SEND_FILE_RANGE_PKG = "send_file_range_pkg";
    public static final String STATE_SEND_MOOD_UPLOAD_PKG = "send_mood_upload_pkg";
    public static final String STATE_SEND_TIMEOUT = "send_timeout";
    public static final String STATE_UPLOAD_FAIL = "upload_fail";
    public static final String STATE_UPLOAD_SUCCESS = "upload_success";
    public static final String STATE_WAIT_TIMEOUT = "wait_timeout";
    public static String T_UPLOAD_SESSION_REPORT;
    private String attachInfo;
    private String cost;
    private String desc;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private String ext6;
    private String index;
    private String key;
    private String keyEventId;
    private String keyRetCode;
    private String traceId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            T_UPLOAD_SESSION_REPORT = "T_UPLOAD_SESSION_REPORT";
            CREATOR = new Parcelable.Creator<UploadQualityReportBuilder>() { // from class: com.tencent.upload.report.UploadQualityReportBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public UploadQualityReportBuilder createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new UploadQualityReportBuilder(parcel) : (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public UploadQualityReportBuilder[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new UploadQualityReportBuilder[i3] : (UploadQualityReportBuilder[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public UploadQualityReportBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
        this.ext5 = "";
        this.ext6 = "";
        this.traceId = "";
        this.keyEventId = "";
        this.keyRetCode = "";
        this.desc = "";
        this.attachInfo = "";
        this.index = "";
        this.key = "";
        this.cost = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return 0;
    }

    public String getAttachInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.attachInfo;
    }

    public String getCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.cost;
    }

    public String getDesc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.desc;
    }

    public String getExt1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.ext1;
    }

    public String getExt2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.ext2;
    }

    public String getExt3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.ext3;
    }

    public String getExt4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.ext4;
    }

    public String getExt5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.ext5;
    }

    public String getExt6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.ext6;
    }

    public String getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.index;
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.key;
    }

    public String getKeyEventId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.keyEventId;
    }

    public String getKeyRetCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.keyRetCode;
    }

    public String getTraceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.traceId;
    }

    public void readFromParcel(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) parcel);
            return;
        }
        this.ext1 = parcel.readString();
        this.ext2 = parcel.readString();
        this.ext3 = parcel.readString();
        this.ext4 = parcel.readString();
        this.ext5 = parcel.readString();
        this.ext6 = parcel.readString();
        this.traceId = parcel.readString();
        this.keyEventId = parcel.readString();
        this.keyRetCode = parcel.readString();
        this.desc = parcel.readString();
        this.attachInfo = parcel.readString();
        this.index = parcel.readString();
        this.key = parcel.readString();
        this.cost = parcel.readString();
    }

    public UploadQualityReportBuilder setAttachInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
        this.attachInfo = str;
        return this;
    }

    public UploadQualityReportBuilder setCost(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        this.cost = str;
        return this;
    }

    public UploadQualityReportBuilder setDesc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        this.desc = str;
        return this;
    }

    public UploadQualityReportBuilder setExt1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.ext1 = str;
        return this;
    }

    public UploadQualityReportBuilder setExt2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.ext2 = str;
        return this;
    }

    public UploadQualityReportBuilder setExt3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.ext3 = str;
        return this;
    }

    public UploadQualityReportBuilder setExt4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        this.ext4 = str;
        return this;
    }

    public UploadQualityReportBuilder setExt5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        this.ext5 = str;
        return this;
    }

    public UploadQualityReportBuilder setExt6(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        this.ext6 = str;
        return this;
    }

    public UploadQualityReportBuilder setIndex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        }
        this.index = str;
        return this;
    }

    public UploadQualityReportBuilder setKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        this.key = str;
        return this;
    }

    public UploadQualityReportBuilder setKeyEventId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        this.keyEventId = str;
        return this;
    }

    public UploadQualityReportBuilder setKeyRetCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        this.keyRetCode = str;
        return this;
    }

    public UploadQualityReportBuilder setTraceId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        if (str != null) {
            this.traceId = str;
        }
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("UploadQualityReportBuilder{\n");
        if (!TextUtils.isEmpty(this.keyEventId) && !this.keyEventId.contains(T_UPLOAD_SESSION_REPORT)) {
            stringBuffer.append("ext1='");
            stringBuffer.append(this.ext1);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
        }
        stringBuffer.append(", ext2='");
        stringBuffer.append(this.ext2);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", ext3='");
        stringBuffer.append(this.ext3);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", ext4='");
        stringBuffer.append(this.ext4);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", ext5='");
        stringBuffer.append(this.ext5);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", ext6='");
        stringBuffer.append(this.ext6);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", traceId='");
        stringBuffer.append(this.traceId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", keyEventId='");
        stringBuffer.append(this.keyEventId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", keyRetCode='");
        stringBuffer.append(this.keyRetCode);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", desc='");
        stringBuffer.append(this.desc);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", attachInfo='");
        stringBuffer.append(this.attachInfo);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", index='");
        stringBuffer.append(this.index);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", key='");
        stringBuffer.append(this.key);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", cost='");
        stringBuffer.append(this.cost);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
        parcel.writeString(this.ext4);
        parcel.writeString(this.ext5);
        parcel.writeString(this.ext6);
        parcel.writeString(this.traceId);
        parcel.writeString(this.keyEventId);
        parcel.writeString(this.keyRetCode);
        parcel.writeString(this.desc);
        parcel.writeString(this.attachInfo);
        parcel.writeString(this.index);
        parcel.writeString(this.key);
        parcel.writeString(this.cost);
    }

    public UploadQualityReportBuilder setKeyRetCode(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (UploadQualityReportBuilder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) l3);
        }
        this.keyRetCode = String.valueOf(l3);
        return this;
    }

    protected UploadQualityReportBuilder(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) parcel);
            return;
        }
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
        this.ext5 = "";
        this.ext6 = "";
        this.traceId = "";
        this.keyEventId = "";
        this.keyRetCode = "";
        this.desc = "";
        this.attachInfo = "";
        this.index = "";
        this.key = "";
        this.cost = "";
        this.ext1 = parcel.readString();
        this.ext2 = parcel.readString();
        this.ext3 = parcel.readString();
        this.ext4 = parcel.readString();
        this.ext5 = parcel.readString();
        this.ext6 = parcel.readString();
        this.traceId = parcel.readString();
        this.keyEventId = parcel.readString();
        this.keyRetCode = parcel.readString();
        this.desc = parcel.readString();
        this.attachInfo = parcel.readString();
        this.index = parcel.readString();
        this.key = parcel.readString();
        this.cost = parcel.readString();
    }
}
