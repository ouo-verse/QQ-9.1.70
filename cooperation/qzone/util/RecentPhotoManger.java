package cooperation.qzone.util;

import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes28.dex */
public class RecentPhotoManger {
    public static final String KEY_BANNER_RECENT_PHOTO_BLACKLIST = "key_banner_recent_photo_blacklist";
    public static final String KEY_BUBBLE_RECENT_PHOTO_BLACKLIST = "key_bubble_recent_photo_blacklist";
    public static final String KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST = "key_personal_album_recent_photo_blacklist";
    public static final String KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST = "key_shuoshuo_recent_photo_blacklist";
    public static final int MAX_COUNT = 500;
    public static final long OFFSET_TIME = 86400000;
    public static final int RECENT_PHOTO_SOURCE_BUBBLE = 3;
    public static final int RECENT_PHOTO_SOURCE_LOCAL = 0;
    public static final int RECENT_PHOTO_SOURCE_PERSONAL_ALBUM = 1;
    public static final int RECENT_PHOTO_SOURCE_SHUOSHUO = 2;
    public static final int RECENT_PHOTO_SOURCE_SHUOSHUO_EXT = 3;

    public static void addToRecentPhotoBlacklist(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> recentPhotoBlackListPath = getRecentPhotoBlackListPath(str, 500);
        if (recentPhotoBlackListPath.contains(str2)) {
            return;
        }
        recentPhotoBlackListPath.add(0, str2);
        if (recentPhotoBlackListPath.size() > 500) {
            recentPhotoBlackListPath.remove(500);
        }
        LocalMultiProcConfig.putString(str, encodeBlackList(recentPhotoBlackListPath));
    }

    private static String encodeBlackList(List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        return sb5.toString();
    }

    public static List<String> getRecentPhotoBlackListPath(String str, int i3) {
        String[] split = LocalMultiProcConfig.getString(str, "").split(";");
        LinkedList linkedList = new LinkedList();
        if (split.length != 0 && i3 > 0) {
            int i16 = 0;
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    linkedList.add(str2);
                    i16++;
                }
                if (i16 == i3) {
                    break;
                }
            }
        }
        return linkedList;
    }

    public static List<String> getRecentPhotoBlackListPath(String str) {
        return getRecentPhotoBlackListPath(str, 500);
    }

    public static void addToRecentPhotoBlacklist(String str, List<String> list) {
        if (list == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        List<String> recentPhotoBlackListPath = getRecentPhotoBlackListPath(str, 500 - list.size());
        linkedList.addAll(list);
        linkedList.addAll(recentPhotoBlackListPath);
        LocalMultiProcConfig.putString(str, encodeBlackList(linkedList));
    }
}
