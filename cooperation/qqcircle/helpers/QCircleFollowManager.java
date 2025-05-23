package cooperation.qqcircle.helpers;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleFollowManager {
    public static final String TAG = "QCircleFollowManager";
    private static volatile QCircleFollowManager sInstance;
    private ConcurrentHashMap<String, Integer> mUinFollowMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> mFakeUinFollowMap = new ConcurrentHashMap<>();

    public static QCircleFollowManager getInstance() {
        if (sInstance == null) {
            synchronized (QCircleFollowManager.class) {
                if (sInstance == null) {
                    sInstance = new QCircleFollowManager();
                }
            }
        }
        return sInstance;
    }

    public void clearAll() {
        QLog.i(TAG, 1, "clear all");
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mUinFollowMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = this.mFakeUinFollowMap;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public void clearFakeUinFollowed(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mFakeUinFollowMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
    }

    public Integer getUinFollowed(String str) {
        Integer num = this.mFakeUinFollowMap.get(str);
        if (num == null) {
            return this.mUinFollowMap.get(str);
        }
        return num;
    }

    public boolean hasUin(String str) {
        if (str != null && (this.mFakeUinFollowMap.containsKey(str) || this.mUinFollowMap.containsKey(str))) {
            return true;
        }
        return false;
    }

    public boolean isUinFollowed(String str) {
        if (!hasUin(str)) {
            return false;
        }
        Integer uinFollowed = getUinFollowed(str);
        if (uinFollowed.intValue() != 1 && uinFollowed.intValue() != 3) {
            return false;
        }
        return true;
    }

    public void setFakeUinFollowed(String str, int i3) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mFakeUinFollowMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Integer.valueOf(i3));
        }
    }

    public void setUinFollowed(String str, int i3) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mUinFollowMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Integer.valueOf(i3));
        }
        clearFakeUinFollowed(str);
    }
}
