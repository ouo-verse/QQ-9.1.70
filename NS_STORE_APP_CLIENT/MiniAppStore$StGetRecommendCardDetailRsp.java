package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppStore$StGetRecommendCardDetailRsp extends MessageMicro<MiniAppStore$StGetRecommendCardDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "stAppRecommendCard"}, new Object[]{null, null}, MiniAppStore$StGetRecommendCardDetailRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public MiniAppStore$StAppRecommendCard stAppRecommendCard = new MessageMicro<MiniAppStore$StAppRecommendCard>() { // from class: NS_STORE_APP_CLIENT.MiniAppStore$StAppRecommendCard
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56}, new String[]{"strCardId", "strCardTitle", "strCardSubTitle", "uiCardType", "vecAppInfo", "stSpecialAppInfo", "uiCardStatus"}, new Object[]{"", "", "", 0, null, null, 0}, MiniAppStore$StAppRecommendCard.class);
        public final PBStringField strCardId = PBField.initString("");
        public final PBStringField strCardTitle = PBField.initString("");
        public final PBStringField strCardSubTitle = PBField.initString("");
        public final PBUInt32Field uiCardType = PBField.initUInt32(0);
        public final PBRepeatMessageField<INTERFACE$StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
        public MiniAppStore$StSpecialAppInfo stSpecialAppInfo = new MessageMicro<MiniAppStore$StSpecialAppInfo>() { // from class: NS_STORE_APP_CLIENT.MiniAppStore$StSpecialAppInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"stAppInfo", "stFirstPicInfo", "vecPicInfo", "stVideoInfo", "strText"}, new Object[]{null, null, null, null, ""}, MiniAppStore$StSpecialAppInfo.class);
            public INTERFACE$StUserAppInfo stAppInfo = new INTERFACE$StUserAppInfo();
            public MiniAppStore$StPicInfo stFirstPicInfo = new MessageMicro<MiniAppStore$StPicInfo>() { // from class: NS_STORE_APP_CLIENT.MiniAppStore$StPicInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"strUrl", "uiWidth", "uiHeight"}, new Object[]{"", 0, 0}, MiniAppStore$StPicInfo.class);
                public final PBStringField strUrl = PBField.initString("");
                public final PBUInt32Field uiWidth = PBField.initUInt32(0);
                public final PBUInt32Field uiHeight = PBField.initUInt32(0);
            };
            public final PBRepeatMessageField<MiniAppStore$StPicInfo> vecPicInfo = PBField.initRepeatMessage(MiniAppStore$StPicInfo.class);
            public MiniAppStore$StVideoInfo stVideoInfo = new MessageMicro<MiniAppStore$StVideoInfo>() { // from class: NS_STORE_APP_CLIENT.MiniAppStore$StVideoInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48}, new String[]{"strVideoUrl", "strCoverUrl", "uiDuration", "uiWidth", "uiHeight", "uiSize"}, new Object[]{"", "", 0, 0, 0, 0}, MiniAppStore$StVideoInfo.class);
                public final PBStringField strVideoUrl = PBField.initString("");
                public final PBStringField strCoverUrl = PBField.initString("");
                public final PBUInt32Field uiDuration = PBField.initUInt32(0);
                public final PBUInt32Field uiWidth = PBField.initUInt32(0);
                public final PBUInt32Field uiHeight = PBField.initUInt32(0);
                public final PBUInt32Field uiSize = PBField.initUInt32(0);
            };
            public final PBStringField strText = PBField.initString("");
        };
        public final PBUInt32Field uiCardStatus = PBField.initUInt32(0);
    };
}
