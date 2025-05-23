package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes22.dex */
public class UuidPlayIdMap {
    private static final String LOG_TAG = "UuidPlayIdMap";
    private static Map<String, HashSet<String>> uuidTCIdMap = new HashMap(10, 0.75f);
    private static Map<String, String> playidUuidMap = new HashMap(10, 0.75f);
    private static HashSet<String> deletedUuid = new HashSet<>(10, 0.75f);

    public static synchronized void addPlayId(String str, String str2) {
        synchronized (UuidPlayIdMap.class) {
            HashSet<String> tcDataId = getTcDataId(str);
            if (tcDataId == null) {
                tcDataId = new HashSet<>(10, 0.75f);
            }
            tcDataId.add(str2);
            uuidTCIdMap.put(str, tcDataId);
            playidUuidMap.put(str2, str);
            PlayerUtils.log(4, LOG_TAG, "addPlayId uuid=" + str + ", playId=" + str2);
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, LOG_TAG, "playIdListForUuid " + str + " -> " + getPlayIdListByUuid(str));
            }
        }
    }

    public static synchronized void deleteItem(String str) {
        synchronized (UuidPlayIdMap.class) {
            deleteItem(str, false);
        }
    }

    public static String getPlayIdListByUuid(String str) {
        HashSet<String> tcDataId = getTcDataId(str);
        String str2 = "";
        if (tcDataId != null) {
            Iterator<String> it = tcDataId.iterator();
            while (it.hasNext()) {
                str2 = (str2 + it.next()) + ",";
            }
        }
        return str2;
    }

    public static synchronized HashSet<String> getTcDataId(String str) {
        HashSet<String> hashSet;
        synchronized (UuidPlayIdMap.class) {
            hashSet = uuidTCIdMap.get(str);
        }
        return hashSet;
    }

    public static synchronized String getUuid(String str) {
        String str2;
        synchronized (UuidPlayIdMap.class) {
            str2 = playidUuidMap.get(str);
        }
        return str2;
    }

    public static synchronized boolean isTcPlayIdShouldStopped(int i3) {
        boolean contains;
        synchronized (UuidPlayIdMap.class) {
            contains = deletedUuid.contains(getUuid(i3 + ""));
        }
        return contains;
    }

    public static synchronized boolean isUuidDeleted(String str) {
        synchronized (UuidPlayIdMap.class) {
            if (!TextUtils.isEmpty(str)) {
                return deletedUuid.contains(str);
            }
            PlayerUtils.log(6, LOG_TAG, "isUuidDeleted uuid is null");
            return true;
        }
    }

    public static synchronized void deleteItem(String str, boolean z16) {
        synchronized (UuidPlayIdMap.class) {
            HashSet<String> tcDataId = getTcDataId(str);
            if (tcDataId != null && z16) {
                Iterator<String> it = tcDataId.iterator();
                while (it.hasNext()) {
                    playidUuidMap.remove(it.next());
                }
                uuidTCIdMap.remove(str);
            } else if (tcDataId == null) {
                PlayerUtils.log(4, LOG_TAG, "associate playid not exists, data cached? uuid=" + str);
            }
            PlayerUtils.log(4, LOG_TAG, "deleteItem uuid=" + str + "," + z16);
            deletedUuid.add(str);
        }
    }
}
