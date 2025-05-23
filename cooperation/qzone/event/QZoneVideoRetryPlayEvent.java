package cooperation.qzone.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes28.dex */
public class QZoneVideoRetryPlayEvent extends SimpleBaseEvent {
    public static final String CLICK_VIEW_HASH_CODE = "CLICK_VIEW_HASH_CODE";
    private final String mClickViewHashCode;
    private final String mQQVideoBusinessFeedID;

    public QZoneVideoRetryPlayEvent(String str, String str2) {
        this.mQQVideoBusinessFeedID = str;
        this.mClickViewHashCode = str2;
    }

    public String getClickViewHashCode() {
        return this.mClickViewHashCode;
    }

    public String getQQVideoBusinessFeedID() {
        return this.mQQVideoBusinessFeedID;
    }
}
