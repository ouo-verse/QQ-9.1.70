package com.tencent.mobileqq.vas.avatar;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface NtFaceConstant {
    public static final String LARGE = "large";
    public static final String MEDIUM = "medium";
    public static final String SCID_FACE_PREFIX = "face.";
    public static final String SMALL = "small";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HeadShape {
        public static final byte FACE_SHAPE_APOLLO_FIGURE = 8;
        public static final byte FACE_SHAPE_APOLLO_FIGURE_HALF = 7;
        public static final byte FACE_SHAPE_APOLLO_HEAD_CIRCLE = 6;
        public static final byte FACE_SHAPE_CIRCLE = 3;
        public static final byte FACE_SHAPE_DEFAULT = 3;
        public static final byte FACE_SHAPE_DISUSSION = 3;
        public static final byte FACE_SHAPE_FORCE_CIRCLE = 4;
        public static final byte FACE_SHAPE_FORCE_SQUARE = 5;
        public static final byte FACE_SHAPE_MAX_VALUE = 8;
        public static final byte FACE_SHAPE_PUBLIC_ACCOUNT = 4;
        public static final byte FACE_SHAPE_ROUND = 2;
        public static final byte FACE_SHAPE_SQUARE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HeadSize {
        public static final int DEFAULT_AVATAR_SIZE = 140;
        public static final int DEFAULT_HD_AVATAR_SIZE = 1080;
        public static final int DYNAMIC_SIZE_BIG = 640;
        public static final int DYNAMIC_SIZE_MIDDLE = 200;
        public static final int DYNAMIC_SIZE_SMALL = 100;
        public static final int[] SIZE_RANGE = {0, 100, 200, 640, 140, 1080};
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HeadType {
        public static final int FACE_TYPE_MATCH_FRIEND = 202;
        public static final int FACE_TYPE_OHTER_SYSTEM = -55;
        public static final int FACE_TYPE_TROOP_SYSTEM = -56;
        public static final int QQHEAD_TYPE_APOLLO = 116;
        public static final int QQHEAD_TYPE_BLESS = 108;
        public static final int QQHEAD_TYPE_DATALINE = 102;
        public static final int QQHEAD_TYPE_DATALINE_IPAD = 107;
        public static final int QQHEAD_TYPE_DEVICE = 104;
        public static final int QQHEAD_TYPE_DISUSSION = 101;
        public static final int QQHEAD_TYPE_GROUP = 4;
        public static final int QQHEAD_TYPE_GROUP_NEW = 8;
        public static final int QQHEAD_TYPE_GUILD = 117;
        public static final int QQHEAD_TYPE_GUILD_USER_TINYID = 118;
        public static final int QQHEAD_TYPE_IMAX_AD = 114;
        public static final int QQHEAD_TYPE_MERGE_KANDIAN = 111;
        public static final int QQHEAD_TYPE_MOBILE_NUMBER = 11;
        public static final int QQHEAD_TYPE_NEW_TROOP = 113;
        public static final int QQHEAD_TYPE_PSTN_DISCUSSION = 1001;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT = 115;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_ECSHOP = 106;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_SUBSCRIPT = 105;
        public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_XIN_KANDIAN = 110;
        public static final int QQHEAD_TYPE_QCALL = 16;
        public static final int QQHEAD_TYPE_SERVICE_ACCOUNT_FOLDER = 112;
        public static final int QQHEAD_TYPE_STRANGER = 32;
        public static final int QQHEAD_TYPE_SUBACCOUNT = 103;
        public static final int QQHEAD_TYPE_TEMP_GAME_MSG = 119;
        public static final int QQHEAD_TYPE_USER = 1;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ShopSource {
        public static final int SOURCE_DEF = 0;
        public static final int SOURCE_SHOP = 1;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface UinType {
        public static final int ID_OPENID = 204;
        public static final int ID_TINYID = 202;
        public static final int ID_UIN = 200;
        public static final int ID_URL = 205;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface UseSource {
        public static final int AIO_MIN_PROFILE = 8;
        public static final int AIO_MSG = 9;
        public static final int AVATAR_PENDENT = 7;
        public static final int CONTACTS = 1;
        public static final int CONVERSATION = 0;
        public static final int FRIEND_PROFILE = 3;
        public static final int NEARBY_LIST = 2;
        public static final int NEARBY_PEOFILE = 4;
        public static final int QQSETTING = 6;
        public static final int TROOP_PROFILE = 5;
        public static final int UNKNOWN = -1;
    }
}
