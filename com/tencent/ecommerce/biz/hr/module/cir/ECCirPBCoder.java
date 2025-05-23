package com.tencent.ecommerce.biz.hr.module.cir;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedDetailReq;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedListReq;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedListRsp;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFollowListReq;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFollowListRsp;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetMainPageCommDataRsp;
import com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetMainPageReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000b\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\tj\u0002`\n0\b0\bH\u0002J\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/cir/ECCirPBCoder;", "", "", "cmd", "Lcom/tencent/ecommerce/biz/hr/module/cir/ECCirPBCoder$ECCirPBCoderType;", "type", "Lcom/tencent/mobileqq/pb/MessageMicro;", "b", "", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/biz/hr/module/cir/CoderCreateFun;", "a", "d", "c", "<init>", "()V", "ECCirPBCoderType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class ECCirPBCoder {

    /* renamed from: a, reason: collision with root package name */
    public static final ECCirPBCoder f102609a = new ECCirPBCoder();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/cir/ECCirPBCoder$ECCirPBCoderType;", "", "(Ljava/lang/String;I)V", "REQ", "RSP", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum ECCirPBCoderType {
        REQ,
        RSP
    }

    ECCirPBCoder() {
    }

    private final Map<String, Map<ECCirPBCoderType, Function0<MessageMicro<?>>>> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ECCirPBCoderType eCCirPBCoderType = ECCirPBCoderType.REQ;
        linkedHashMap2.put(eCCirPBCoderType, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetMainPageReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetMainPageReq
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34}, new String[]{"userId", "from", "feedAttchInfo"}, new Object[]{"", 0, ""}, ECQCirMainPageSvr$CirStGetMainPageReq.class);
                    public final PBStringField userId = PBField.initString("");
                    public final PBInt32Field from = PBField.initInt32(0);
                    public final PBStringField feedAttchInfo = PBField.initString("");
                };
            }
        });
        ECCirPBCoderType eCCirPBCoderType2 = ECCirPBCoderType.RSP;
        linkedHashMap2.put(eCCirPBCoderType2, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetMainPageCommDataRsp>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetMainPageCommDataRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26, 32, 42}, new String[]{QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "vecFeed", "isFinish", "feedAttchInfo"}, new Object[]{0, null, 0, ""}, ECQCirMainPageSvr$CirStGetMainPageCommDataRsp.class);
                    public final PBUInt32Field feedCount = PBField.initUInt32(0);
                    public final PBRepeatMessageField<ECQCirMainPageSvr$CirStFeed> vecFeed = PBField.initRepeatMessage(ECQCirMainPageSvr$CirStFeed.class);
                    public final PBUInt32Field isFinish = PBField.initUInt32(0);
                    public final PBStringField feedAttchInfo = PBField.initString("");
                };
            }
        });
        Unit unit = Unit.INSTANCE;
        linkedHashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData", linkedHashMap2);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(eCCirPBCoderType, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$2$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFeedDetailReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedDetailReq
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26, 34, 40}, new String[]{"from", "userId", "feedId", WadlProxyConsts.CREATE_TIME}, new Object[]{0, "", "", 0L}, ECQCirMainPageSvr$CirStGetFeedDetailReq.class);
                    public final PBInt32Field from = PBField.initInt32(0);
                    public final PBStringField userId = PBField.initString("");
                    public final PBStringField feedId = PBField.initString("");
                    public final PBUInt64Field createTime = PBField.initUInt64(0);
                };
            }
        });
        linkedHashMap3.put(eCCirPBCoderType2, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$2$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFeedDetailRsp>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedDetailRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26}, new String[]{"feed"}, new Object[]{null}, ECQCirMainPageSvr$CirStGetFeedDetailRsp.class);
                    public ECQCirMainPageSvr$CirStFeed feed = new MessageMicro<ECQCirMainPageSvr$CirStFeed>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStFeed
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 72, 114, 610}, new String[]{"feedId", "title", "subtitle", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "content", WadlProxyConsts.CREATE_TIME, "visitorInfo", "recommend_info"}, new Object[]{"", "", "", null, null, null, "", 0L, null, null}, ECQCirMainPageSvr$CirStFeed.class);
                        public final PBStringField feedId = PBField.initString("");
                        public final PBStringField title = PBField.initString("");
                        public final PBStringField subtitle = PBField.initString("");
                        public ECQCirMainPageSvr$CirStUser poster = new MessageMicro<ECQCirMainPageSvr$CirStUser>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStUser
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uin", "nick", "icon"}, new Object[]{"", "", null}, ECQCirMainPageSvr$CirStUser.class);
                            public final PBStringField uin = PBField.initString("");
                            public final PBStringField nick = PBField.initString("");
                            public ECQCirMainPageSvr$CirStIconInfo icon = new MessageMicro<ECQCirMainPageSvr$CirStIconInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStIconInfo
                                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{42}, new String[]{"iconUrl"}, new Object[]{""}, ECQCirMainPageSvr$CirStIconInfo.class);
                                public final PBStringField iconUrl = PBField.initString("");
                            };
                        };
                        public ECQCirMainPageSvr$CirStImage cover = new MessageMicro<ECQCirMainPageSvr$CirStImage>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStImage
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"width", "height", "picUrl"}, new Object[]{0, 0, ""}, ECQCirMainPageSvr$CirStImage.class);
                            public final PBUInt32Field width = PBField.initUInt32(0);
                            public final PBUInt32Field height = PBField.initUInt32(0);
                            public final PBStringField picUrl = PBField.initString("");
                        };
                        public ECQCirMainPageSvr$CirStVideo video = new MessageMicro<ECQCirMainPageSvr$CirStVideo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStVideo
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{"fileId", "fileSize", "duration", "width", "height", "playUrl"}, new Object[]{"", 0, 0, 0, 0, ""}, ECQCirMainPageSvr$CirStVideo.class);
                            public final PBStringField fileId = PBField.initString("");
                            public final PBUInt32Field fileSize = PBField.initUInt32(0);
                            public final PBUInt32Field duration = PBField.initUInt32(0);
                            public final PBUInt32Field width = PBField.initUInt32(0);
                            public final PBUInt32Field height = PBField.initUInt32(0);
                            public final PBStringField playUrl = PBField.initString("");
                        };
                        public final PBStringField content = PBField.initString("");
                        public final PBUInt64Field createTime = PBField.initUInt64(0);
                        public ECQCirMainPageSvr$CirStVisitor visitorInfo = new MessageMicro<ECQCirMainPageSvr$CirStVisitor>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStVisitor
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"viewCount"}, new Object[]{0}, ECQCirMainPageSvr$CirStVisitor.class);
                            public final PBUInt32Field viewCount = PBField.initUInt32(0);
                        };
                        public ECQCirMainPageSvr$CirStRecommendInfo recommend_info = new MessageMicro<ECQCirMainPageSvr$CirStRecommendInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStRecommendInfo
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88}, new String[]{"recommend_status"}, new Object[]{0}, ECQCirMainPageSvr$CirStRecommendInfo.class);
                            public final PBInt32Field recommend_status = PBField.initInt32(0);
                        };
                    };
                };
            }
        });
        linkedHashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail", linkedHashMap3);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put(eCCirPBCoderType, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$3$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFeedListReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedListReq
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 58, 80, 98}, new String[]{"listNum", "from", "feedAttchInfo", "source", "dstUserId"}, new Object[]{0, 0, "", 0, ""}, ECQCirMainPageSvr$CirStGetFeedListReq.class);
                    public final PBUInt32Field listNum = PBField.initUInt32(0);
                    public final PBInt32Field from = PBField.initInt32(0);
                    public final PBStringField feedAttchInfo = PBField.initString("");
                    public final PBInt32Field source = PBField.initInt32(0);
                    public final PBStringField dstUserId = PBField.initString("");
                };
            }
        });
        linkedHashMap4.put(eCCirPBCoderType2, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$3$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFeedListRsp>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFeedListRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 50}, new String[]{"vecFeed", "isFinish", "feedAttchInfo"}, new Object[]{null, 0, ""}, ECQCirMainPageSvr$CirStGetFeedListRsp.class);
                    public final PBRepeatMessageField<ECQCirMainPageSvr$CirStFeed> vecFeed = PBField.initRepeatMessage(ECQCirMainPageSvr$CirStFeed.class);
                    public final PBUInt32Field isFinish = PBField.initUInt32(0);
                    public final PBStringField feedAttchInfo = PBField.initString("");
                };
            }
        });
        linkedHashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListLike", linkedHashMap4);
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        linkedHashMap5.put(eCCirPBCoderType, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$4$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFollowListReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFollowListReq
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 32, 48, 56, 64}, new String[]{"userId", "attachInfo", "count", "filterRelation", "sortType", "followMethod"}, new Object[]{"", "", 0, 0, 0, 0}, ECQCirMainPageSvr$CirStGetFollowListReq.class);
                    public final PBStringField userId = PBField.initString("");
                    public final PBStringField attachInfo = PBField.initString("");
                    public final PBUInt32Field count = PBField.initUInt32(0);
                    public final PBInt32Field filterRelation = PBField.initInt32(0);
                    public final PBUInt32Field sortType = PBField.initUInt32(0);
                    public final PBUInt32Field followMethod = PBField.initUInt32(0);
                };
            }
        });
        linkedHashMap5.put(eCCirPBCoderType2, new Function0<MessageMicro<?>>() { // from class: com.tencent.ecommerce.biz.hr.module.cir.ECCirPBCoder$allCoderClass$4$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessageMicro<?> invoke() {
                return new MessageMicro<ECQCirMainPageSvr$CirStGetFollowListRsp>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir_main_svr.ECQCirMainPageSvr$CirStGetFollowListRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34}, new String[]{"attachInfo", "hasNext", "relationInfo"}, new Object[]{"", 0, null}, ECQCirMainPageSvr$CirStGetFollowListRsp.class);
                    public final PBStringField attachInfo = PBField.initString("");
                    public final PBUInt32Field hasNext = PBField.initUInt32(0);
                    public final PBRepeatMessageField<ECQCirMainPageSvr$CirStRelationInfo> relationInfo = PBField.initRepeatMessage(ECQCirMainPageSvr$CirStRelationInfo.class);
                };
            }
        });
        linkedHashMap.put("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowList", linkedHashMap5);
        return linkedHashMap;
    }

    private final MessageMicro<?> b(String cmd, ECCirPBCoderType type) {
        Map<String, Map<ECCirPBCoderType, Function0<MessageMicro<?>>>> a16 = a();
        a16.get(cmd);
        Map<ECCirPBCoderType, Function0<MessageMicro<?>>> map = a16.get(cmd);
        if (map == null) {
            return null;
        }
        Function0<MessageMicro<?>> function0 = map.get(type);
        if (!TypeIntrinsics.isFunctionOfArity(function0, 0)) {
            function0 = null;
        }
        Function0<MessageMicro<?>> function02 = function0;
        if (function02 != null) {
            return function02.invoke();
        }
        return null;
    }

    public final MessageMicro<?> c(String cmd) {
        return b(cmd, ECCirPBCoderType.RSP);
    }

    public final MessageMicro<?> d(String cmd) {
        return b(cmd, ECCirPBCoderType.REQ);
    }
}
