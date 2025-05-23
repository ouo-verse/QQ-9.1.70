package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uin")
/* loaded from: classes10.dex */
public class ShieldListInfo extends Entity {
    public static final int SHIELD_LIST_DEFAULT_SRC_SUB_ID = 0;
    public static final int SHIELD_LIST_INFO_FLAG_IS_SHIELD = 1;
    public static final int SHIELD_LIST_INFO_FLAG_NOT_SHIELD = 0;
    public static final int SHIELD_LIST_SOURCE_AUDIO_ROOM = 167;
    public static final int SHIELD_LIST_SOURCE_CONFESS = 156;
    public static final int SHIELD_LIST_SOURCE_GAME_BUDDY = 168;
    public static final int SHIELD_LIST_SOURCE_GAME_MSG = 164;
    public static final int SHIELD_LIST_SOURCE_ID_CIRCLE_GROUP = 23;
    public static final int SHIELD_LIST_SOURCE_ID_CM_GAME_TEMP = 2164;
    public static final int SHIELD_LIST_SOURCE_ID_CONTECT = 8;
    public static final int SHIELD_LIST_SOURCE_ID_CRM_EXT = 25;
    public static final int SHIELD_LIST_SOURCE_ID_CRM_TMP = 26;
    public static final int SHIELD_LIST_SOURCE_ID_DATE = 11;
    public static final int SHIELD_LIST_SOURCE_ID_DIS_TEMP = 7;
    public static final int SHIELD_LIST_SOURCE_ID_GRP_TEMP = 6;
    public static final int SHIELD_LIST_SOURCE_ID_INVALID = -1;
    public static final int SHIELD_LIST_SOURCE_ID_LBSFRIEND = 9;
    public static final int SHIELD_LIST_SOURCE_ID_OPEN_TROOP_TEMP = 132;
    public static final int SHIELD_LIST_SOURCE_ID_PC_QQ_SEARCH = 24;
    public static final int SHIELD_LIST_SOURCE_ID_RICH_STATE = 18;
    public static final int SHIELD_LIST_SOURCE_ID_STRANGER_FRIEND = 50003;
    public static final int SHIELD_LIST_SOURCE_ID_VALIDATION = 21;
    public static final int SHIELD_LIST_SOURCE_ID_WPA = 10;
    public static final int SHIELD_LIST_SOURCE_LIGHTALK = 27;
    public static final int SHIELD_LIST_SOURCE_MATCH_CAMPUS_CHAT = 166;
    public static final int SHIELD_LIST_SOURCE_MATCH_CHAT = 163;
    public static final int SHIELD_LIST_SOURCE_MOVIE_TICKET = 153;
    public static final int SHIELD_LIST_SOURCE_NATCH_FRIEND_CHAT = 172;
    public static final int SHIELD_LIST_SOURCE_QQ_CIRCLE = 165;
    public static final int SHIELD_LIST_SOURCE_SQUARE_CHAT = 173;
    public int flags;
    public int source_id;
    public int source_sub_id;

    @unique
    public String uin;

    public static int AIO_TYPE_2_SOURCE_ID(int i3) {
        if (i3 != 22) {
            if (i3 != 1036) {
                if (i3 != 10002) {
                    if (i3 != 10004) {
                        if (i3 != 10010) {
                            if (i3 != 10019) {
                                if (i3 != 24 && i3 != 25) {
                                    if (i3 != 1000) {
                                        if (i3 != 1001) {
                                            if (i3 != 1009) {
                                                if (i3 != 1010) {
                                                    if (i3 != 10007) {
                                                        if (i3 != 10008) {
                                                            switch (i3) {
                                                                case 1003:
                                                                    return 50003;
                                                                case 1004:
                                                                    return 7;
                                                                case 1005:
                                                                    return 10;
                                                                case 1006:
                                                                    return 8;
                                                                default:
                                                                    switch (i3) {
                                                                        case 1020:
                                                                            return 132;
                                                                        case 1021:
                                                                            return 23;
                                                                        case 1022:
                                                                            return 21;
                                                                        case 1023:
                                                                            return 24;
                                                                        case 1024:
                                                                            return 26;
                                                                        case 1025:
                                                                            return 25;
                                                                        default:
                                                                            switch (i3) {
                                                                                case 1044:
                                                                                    return 163;
                                                                                case 1045:
                                                                                    return 166;
                                                                                case 1046:
                                                                                    return 172;
                                                                                default:
                                                                                    return -1;
                                                                            }
                                                                    }
                                                            }
                                                        }
                                                        return 165;
                                                    }
                                                    return 164;
                                                }
                                                return 11;
                                            }
                                            return 18;
                                        }
                                    } else {
                                        return 6;
                                    }
                                }
                            } else {
                                return 173;
                            }
                        } else {
                            return 167;
                        }
                    } else {
                        return 153;
                    }
                }
                return 9;
            }
            return SHIELD_LIST_SOURCE_ID_CM_GAME_TEMP;
        }
        return 27;
    }

    public static int SOURCE_ID_2_AIO_TYPE(int i3) {
        if (i3 != 18) {
            if (i3 != 21) {
                if (i3 != 132) {
                    if (i3 != 153) {
                        if (i3 != 2164) {
                            if (i3 != 50003) {
                                if (i3 != 172) {
                                    if (i3 != 173) {
                                        switch (i3) {
                                            case 6:
                                                return 1000;
                                            case 7:
                                                return 1004;
                                            case 8:
                                                return 1006;
                                            case 9:
                                                return 1001;
                                            case 10:
                                                return 1005;
                                            case 11:
                                                return 1010;
                                            default:
                                                switch (i3) {
                                                    case 23:
                                                        return 1021;
                                                    case 24:
                                                        return 1023;
                                                    case 25:
                                                        return 1025;
                                                    case 26:
                                                        return 1024;
                                                    case 27:
                                                        return 22;
                                                    default:
                                                        switch (i3) {
                                                            case 163:
                                                                return 1044;
                                                            case 164:
                                                                return 10007;
                                                            case 165:
                                                                return 10008;
                                                            case 166:
                                                                return 1045;
                                                            case 167:
                                                                return 10010;
                                                            default:
                                                                return -1;
                                                        }
                                                }
                                        }
                                    }
                                    return 10019;
                                }
                                return 1046;
                            }
                            return 1003;
                        }
                        return 1036;
                    }
                    return 10004;
                }
                return 1020;
            }
            return 1022;
        }
        return 1009;
    }

    private void shieldMsg(boolean z16) {
        this.flags = z16 ? 1 : 0;
    }

    public boolean isShieldMsg() {
        if (this.flags == 1) {
            return true;
        }
        return false;
    }
}
