package cooperation.vip.ad;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VideoMessage extends SimpleBaseEvent {
    public String message;
    public int messageCode;

    public VideoMessage(int i3, String str) {
        this.messageCode = i3;
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public int getMessageCode() {
        return this.messageCode;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageCode(int i3) {
        this.messageCode = i3;
    }
}
