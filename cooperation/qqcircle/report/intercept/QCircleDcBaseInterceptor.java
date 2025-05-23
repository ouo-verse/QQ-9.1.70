package cooperation.qqcircle.report.intercept;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class QCircleDcBaseInterceptor {
    protected static final String KEY_APP_VERSION = "app_version";
    protected static final String KEY_CLEAR = "clear";
    protected static final String KEY_CUBAGE = "cubage";
    protected static final String KEY_DEVICE_INFO = "device_info";
    protected static final String KEY_ERRCODE = "errorcode";
    protected static final String KEY_FEEDS_URL = "feeds_url";
    protected static final String KEY_HEIGHT = "height";
    protected static final String KEY_LLOC = "lloc";
    protected static final String KEY_NETWORK_TYPE = "network_type";
    protected static final String KEY_PIC_INFO = "pic_info";
    protected static final String KEY_PLAY_ID = "play_id";
    protected static final String KEY_PLAY_URL = "play_url";
    protected static final String KEY_RULE_ID = "rule_id";
    protected static final String KEY_UNIQUE_REPORT_ID = "unique_report_id";
    protected static final String KEY_URL = "url";
    protected static final String KEY_USER_IP = "user_ip";
    protected static final String KEY_VID = "vid";
    protected static final String KEY_VIDEO_TAG = "video_tag";
    protected static final String KEY_VIDEO_URL = "video_url";
    protected static final String KEY_WIDTH = "width";
    private static final String TAG = "QCircleReporter-Interceptor";

    private String clearDataForKey(List<FeedCloudCommon$Entry> list, String str) {
        Iterator<FeedCloudCommon$Entry> it = list.iterator();
        while (it.hasNext()) {
            FeedCloudCommon$Entry next = it.next();
            if (next != null && TextUtils.equals(next.key.get(), str)) {
                it.remove();
                return next.value.get();
            }
        }
        return "";
    }

    public void filter(QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        if (qQCircleReport$SingleDcData != null && !qQCircleReport$SingleDcData.report_data.isEmpty()) {
            for (String str : getFilterKeyList()) {
                clearDataForKey(qQCircleReport$SingleDcData.report_data.get(), str);
            }
        }
    }

    public abstract int getDcId();

    @NonNull
    public abstract String[] getFilterKeyList();
}
