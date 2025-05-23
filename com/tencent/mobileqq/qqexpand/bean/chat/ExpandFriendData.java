package com.tencent.mobileqq.qqexpand.bean.chat;

import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandFriendData extends Entity {
    public static final int ATTRIBUTE_ID_ADVERTISE_DATE = 3;
    public static final int ATTRIBUTE_ID_HAS_ENTER_AIO = 1;
    public static final int ATTRIBUTE_ID_HAS_SHOW_ICEBREAKER_TOPIC = 2;
    public static final int ATTRIBUTE_ID_MATCH_SRC = 0;
    public static final int ATTRIBUTE_ID_MATCH_SRC_DESCRIPTION = -1;
    private static final String MATCH_SRC_APPLETS_DESCRIPTION = "\u5c0f\u7a0b\u5e8f";
    public static final int MATCH_SRC_APPLETS_ID = 9;
    private static final String MATCH_SRC_BOTH_LIKE_DESCRIPTION = "\u627e\u540c\u597d";
    public static final int MATCH_SRC_BOTH_LIKE_ID = 3;
    private static final String MATCH_SRC_DEFAULT_DESCRIPTION = "\u6269\u5217\u5339\u914d";
    public static final int MATCH_SRC_DEFAULT_ID = 0;
    private static final String MATCH_SRC_EXPAND_SQUARE_DESCRIPTION = "\u6696\u8bf4\u8bf4";
    public static final int MATCH_SRC_EXPAND_SQUARE_ID = 6;
    private static final String MATCH_SRC_FIND_TEAMMATES_DESCRIPTION = "\u627e\u961f\u53cb";
    public static final int MATCH_SRC_FIND_TEAMMATES_ID = 1;
    private static final String MATCH_SRC_MAKE_FRIEND_DESCRIPTION = "\u5904q\u53cb";
    public static final int MATCH_SRC_MAKE_FRIEND_ID = 4;
    private static final String MATCH_SRC_TREE_HOLE_DESCRIPTION = "\u627e\u6811\u6d1e";
    public static final int MATCH_SRC_TREE_HOLE_ID = 2;
    private static final String MATCH_SRC_VOICE_LINK_DESCRIPTION = "\u8bed\u97f3\u8fde\u9ea6";
    public static final int MATCH_SRC_VOICE_LINK_ID = 5;
    private static final String TAG = "ExpandFriendData";
    public static final int THEME_BLIND_BOX_END = 200;
    public static final int THEME_BLIND_BOX_START = 100;
    private static final HashMap<Integer, String> sMatchSrcMap = new HashMap<Integer, String>() { // from class: com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData.1
        {
            put(0, ExpandFriendData.MATCH_SRC_DEFAULT_DESCRIPTION);
            put(1, ExpandFriendData.MATCH_SRC_FIND_TEAMMATES_DESCRIPTION);
            put(2, ExpandFriendData.MATCH_SRC_TREE_HOLE_DESCRIPTION);
            put(3, ExpandFriendData.MATCH_SRC_BOTH_LIKE_DESCRIPTION);
            put(4, ExpandFriendData.MATCH_SRC_MAKE_FRIEND_DESCRIPTION);
            put(5, "\u8bed\u97f3\u8fde\u9ea6");
            put(6, ExpandFriendData.MATCH_SRC_EXPAND_SQUARE_DESCRIPTION);
            put(9, "\u5c0f\u7a0b\u5e8f");
        }
    };
    public long advertiseDate;
    public boolean hasEnterAIO;
    public boolean hasShowIcebreakerTopic;
    public int matchSrc;

    @unique
    public String matchUin;
    public String nickName;

    public ExpandFriendData() {
    }

    public static long getAdvertiseDate(BaseQQAppInterface baseQQAppInterface, String str) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            return expandFriendData.advertiseDate;
        }
        return 0L;
    }

    public static boolean getHasEnterAIO(BaseQQAppInterface baseQQAppInterface, String str) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            return expandFriendData.hasEnterAIO;
        }
        return false;
    }

    public static boolean getHasShowIcebreakerTopic(BaseQQAppInterface baseQQAppInterface, String str) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            return expandFriendData.hasShowIcebreakerTopic;
        }
        return false;
    }

    public static ExpandFriendData getInstance(BaseQQAppInterface baseQQAppInterface, String str) {
        return ((IExpandChatUtils) QRoute.api(IExpandChatUtils.class)).getInstance(baseQQAppInterface, str);
    }

    public static int getMatchSrc(BaseQQAppInterface baseQQAppInterface, String str) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            return expandFriendData.matchSrc;
        }
        return 0;
    }

    public static String getMatchSrcDes(BaseQQAppInterface baseQQAppInterface, String str) {
        return sMatchSrcMap.get(Integer.valueOf(getMatchSrc(baseQQAppInterface, str)));
    }

    public static String getNickName(BaseQQAppInterface baseQQAppInterface, String str) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            return expandFriendData.nickName;
        }
        return "";
    }

    public static void setAdvertiseDate(BaseQQAppInterface baseQQAppInterface, String str, long j3) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            expandFriendData.advertiseDate = j3;
            updateInstance(baseQQAppInterface, expandFriendData);
        }
    }

    public static void setHasEnterAIO(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            expandFriendData.hasEnterAIO = z16;
            updateInstance(baseQQAppInterface, expandFriendData);
        }
    }

    public static void setHasShowIcebreakerTopic(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            expandFriendData.hasShowIcebreakerTopic = z16;
            updateInstance(baseQQAppInterface, expandFriendData);
        }
    }

    public static void setMatchSrc(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            expandFriendData.matchSrc = i3;
            updateInstance(baseQQAppInterface, expandFriendData);
        }
    }

    public static void setNickName(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        ExpandFriendData expandFriendData = getInstance(baseQQAppInterface, str);
        if (expandFriendData != null) {
            expandFriendData.nickName = str2;
            updateInstance(baseQQAppInterface, expandFriendData);
        }
    }

    public static void updateInstance(BaseQQAppInterface baseQQAppInterface, ExpandFriendData expandFriendData) {
        ((IExpandChatUtils) QRoute.api(IExpandChatUtils.class)).updateInstance(baseQQAppInterface, expandFriendData);
    }

    public Object getAttribute(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return Long.valueOf(this.advertiseDate);
                    }
                    return Boolean.valueOf(this.hasShowIcebreakerTopic);
                }
                return Boolean.valueOf(this.hasEnterAIO);
            }
            return Integer.valueOf(this.matchSrc);
        }
        return sMatchSrcMap.get(Integer.valueOf(this.matchSrc));
    }

    public void setAttribute(int i3, Object obj) throws Exception {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.advertiseDate = ((Long) obj).longValue();
                        return;
                    }
                    return;
                }
                this.hasShowIcebreakerTopic = ((Boolean) obj).booleanValue();
                return;
            }
            this.hasEnterAIO = ((Boolean) obj).booleanValue();
            return;
        }
        this.matchSrc = ((Integer) obj).intValue();
    }

    @NonNull
    public String toString() {
        return "matchUin:" + this.matchUin + ",matchSrc:" + this.matchSrc + ",hasEnterAIO:" + this.hasEnterAIO + ",hasShowIcebreakerTopic:" + this.hasShowIcebreakerTopic + ",advertiseData:" + this.advertiseDate + ",nickName:" + this.nickName + ",";
    }

    public ExpandFriendData(String str) {
        this.matchUin = str;
    }
}
