package com.qzone.preview.service;

import NS_MOBILE_FEEDS.FaceRecommendInfo;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_OPERATION.PhotoInformation;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import NS_MOBILE_PHOTO.cluster_search_result;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneCategoryIdentifyBatchReq;
import com.qzone.album.protocol.QzoneFaceOperationRequest;
import com.qzone.album.protocol.QzoneGetPhotoCommentRequest;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.business.service.QZoneAdvService;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.downloader.i;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.l;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.SimpleFontInfo;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ServiceHandler implements PictureConst {
    private static final String KEY_HANDLER = "handler";
    private static final String KEY_RESPONSE = "response";
    private static final String KEY_TYPE = "type";
    private AbsCompatRequest.a mOnGetPhotoCommentCallback = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZLog.d("goo.GetQzonePhotoComment", 4, "mOnGetPhotoCommentCallback - onResponse");
            QZoneResult qZoneResult = (QZoneResult) sVar.a();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(qZoneResult.getMessage());
            Bundle bundle = qZoneResult.getBundle();
            bundle.putInt("type", ((Integer) absCompatRequest.getParam("type")).intValue());
            Object data = qZoneResult.getData();
            if (data instanceof QzoneGetPhotoCommentRequest.RespBean) {
                bundle.putSerializable("response", ((QzoneGetPhotoCommentRequest.RespBean) data).f43993d);
            }
            qZoneResult.sendToHandler((Handler) absCompatRequest.getParam(ServiceHandler.KEY_HANDLER));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f50027a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f50028b;

        b(String str, Handler handler) {
            this.f50027a = str;
            this.f50028b = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            t5.a.b(this.f50027a);
            sVar.sendToHandler(this.f50028b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f50030a;

        c(Handler handler) {
            this.f50030a = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            sVar.sendToHandler(this.f50030a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f50032a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f50033b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f50034c;

        d(String str, ArrayList arrayList, Handler handler) {
            this.f50032a = str;
            this.f50033b = arrayList;
            this.f50034c = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            ArrayList arrayList;
            if (sVar.getSucceed() && !TextUtils.isEmpty(this.f50032a) && (arrayList = this.f50033b) != null && arrayList.size() > 0) {
                com.qzone.album.base.Service.a.W().O0(15, this.f50033b);
            }
            sVar.sendToHandler(this.f50034c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f50036a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50037b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f50038c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f50039d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f50040e;

        e(long j3, String str, long j16, long j17, Handler handler) {
            this.f50036a = j3;
            this.f50037b = str;
            this.f50038c = j16;
            this.f50039d = j17;
            this.f50040e = handler;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QzoneFavoriteService.M().J(this.f50036a, str, this.f50037b, this.f50038c, this.f50039d, true, this.f50040e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f50044a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MarkFaceItemFeed f50045b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f50046c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f50047d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f50048e;

        g(int i3, MarkFaceItemFeed markFaceItemFeed, long j3, String str, Handler handler) {
            this.f50044a = i3;
            this.f50045b = markFaceItemFeed;
            this.f50046c = j3;
            this.f50047d = str;
            this.f50048e = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            String str2;
            QZoneResult qZoneResult = new QZoneResult(1000192);
            if (sVar != null && sVar.getSucceed() && (sVar.getData() instanceof QzoneFaceOperationRequest.a) && this.f50044a != -1) {
                FaceData stFaceItemToFaceData = FaceData.stFaceItemToFaceData(((QzoneFaceOperationRequest.a) sVar.getData()).f43990c, this.f50045b.albumid, this.f50046c);
                qZoneResult.getBundle().putSerializable(PictureConst.PARAM_FACE_DATA, stFaceItemToFaceData);
                qZoneResult.getBundle().putInt(PictureConst.PARAM_MARKFACE_INDEX, this.f50044a);
                qZoneResult.getBundle().putString(PictureConst.PARAM_MARKFACE_UNIKEY, this.f50047d);
                if (("[Data come back] faceData:" + stFaceItemToFaceData) != null) {
                    str2 = stFaceItemToFaceData.toString();
                } else {
                    str2 = "";
                }
                QZLog.i("[PhotoAlbum]FaceFuntion", str2);
                EventCenter.getInstance().post("QzoneAlbum", 24, this.f50047d, Integer.valueOf(this.f50044a), stFaceItemToFaceData, Integer.valueOf(this.f50045b.f25031op));
            }
            qZoneResult.setSucceed(sVar != null ? sVar.getSucceed() : false);
            qZoneResult.setMessage(str);
            qZoneResult.sendToHandler(this.f50048e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FaceTarget f50050a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f50052c;

        h(FaceTarget faceTarget, String str, Handler handler) {
            this.f50050a = faceTarget;
            this.f50051b = str;
            this.f50052c = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            String message;
            char c16;
            if (sVar != null && sVar.getSucceed() && (sVar.getData() instanceof QZoneCategoryIdentifyBatchReq.a)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[Data come back] onResponse : ");
                sb5.append(sVar.getSucceed());
                sb5.append(" > ");
                sb5.append(sVar.getData() == null);
                QZLog.i("[PhotoAlbum]FaceFuntion", sb5.toString());
                QZoneCategoryIdentifyBatchReq.a aVar = (QZoneCategoryIdentifyBatchReq.a) sVar.getData();
                ArrayList arrayList = new ArrayList();
                if (aVar.f43897a != null) {
                    int i16 = 10;
                    int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_CHECK_FACE_NUM, 10);
                    int i17 = 0;
                    while (i17 < this.f50050a.faces.length && i17 < config) {
                        FaceData faceData = new FaceData();
                        FaceTarget faceTarget = this.f50050a;
                        FaceStatus faceStatus = faceTarget.faces[i17];
                        float f16 = faceStatus.f61315x * 10000.0f;
                        int i18 = faceTarget.width;
                        int i19 = config;
                        faceData.f390865x = f16 / i18;
                        float f17 = faceStatus.f61316y * 10000.0f;
                        int i26 = faceTarget.height;
                        faceData.f390866y = f17 / i26;
                        faceData.f390864w = (faceStatus.width * 10000.0f) / i18;
                        faceData.f390863h = (faceStatus.height * 10000.0f) / i26;
                        faceData.groupid = aVar.f43898b.get(i17 + "");
                        Object[] objArr = new Object[i16];
                        objArr[0] = "[Data come back] x:";
                        objArr[1] = Long.valueOf(faceData.f390865x);
                        objArr[2] = " y:";
                        objArr[3] = Long.valueOf(faceData.f390866y);
                        objArr[4] = " w:";
                        objArr[5] = Long.valueOf(faceData.f390864w);
                        char c17 = 6;
                        objArr[6] = " h:";
                        objArr[7] = Long.valueOf(faceData.f390863h);
                        objArr[8] = " faceData.newgroupid:";
                        objArr[9] = faceData.groupid;
                        QZLog.d("[PhotoAlbum]FaceFuntion", 2, objArr);
                        ArrayList<cluster_search_result> arrayList2 = aVar.f43897a.get("" + i17);
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            ArrayList<FaceRecommendInfo> arrayList3 = new ArrayList<>();
                            int i27 = 0;
                            while (i27 < arrayList2.size()) {
                                if (arrayList2.get(i27).uin == 0 || !arrayList2.get(i27).has_identify) {
                                    c16 = c17;
                                } else {
                                    arrayList3.add(new FaceRecommendInfo(arrayList2.get(i27).uin, arrayList2.get(i27).nickname, arrayList2.get(i27).groupid));
                                    c16 = 6;
                                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[Data come back] nickname:", arrayList2.get(i27).nickname, " uin:", Long.valueOf(arrayList2.get(i27).uin), " groupid:", arrayList2.get(i27).groupid);
                                }
                                i27++;
                                c17 = c16;
                            }
                            faceData.recommend_infos = arrayList3;
                        }
                        arrayList.add(faceData);
                        i17++;
                        config = i19;
                        i16 = 10;
                    }
                    QZoneResult qZoneResult = new QZoneResult(1000191);
                    qZoneResult.setSucceed(true);
                    qZoneResult.getBundle().putSerializable("data", arrayList);
                    qZoneResult.getBundle().putString(PictureConst.PARAM_FACE_PIC_LLOC, this.f50051b);
                    qZoneResult.sendToHandler(this.f50052c);
                    return;
                }
                return;
            }
            if (sVar == null) {
                message = l.a(R.string.tbf);
            } else if (TextUtils.isEmpty(sVar.getMessage())) {
                message = l.a(R.string.tbg) + sVar.getReturnCode();
            } else {
                message = sVar.getMessage();
            }
            QZLog.e("[PhotoAlbum]FaceFuntion", "server error = " + message);
        }
    }

    @ServiceCmd(PictureConst.CMD_GET_QZONE_PHOTOCOMMENTEX)
    public void handleGetQzonePhotoComment(SendMsg sendMsg, Handler handler) {
        QZLog.d("goo.GetQzonePhotoComment", 4, "handleGetQzonePhotoComment start");
        Bundle bundle = sendMsg.extraData;
        long j3 = bundle.getLong("param.uin", 0L);
        String string = bundle.getString(PictureConst.PARAM_CELLID, "");
        AbsCompatRequest v06 = com.qzone.album.base.Service.a.W().v0(j3, bundle.getString(PictureConst.PARAM_ALBUMID, ""), bundle.getString(PictureConst.PARAM_PHOTOID, ""), bundle.getInt(PictureConst.PARAM_REQ_TYPE, 0), string, this.mOnGetPhotoCommentCallback);
        v06.addParam(KEY_HANDLER, handler);
        v06.addParam("type", 6);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f50042a;

        f(Handler handler) {
            this.f50042a = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            sVar.setWhat(1000118);
            sVar.sendToHandler(this.f50042a);
        }
    }

    @ServiceCmd(PictureConst.CMD_CLOUD_BATCH_FACE_RECOGNIZE)
    public void handlerCloudBatchFaceRecognize(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        q4.a.h(LoginData.getInstance().getUin(), (ArrayList) bundle.getSerializable(PictureConst.PARAM_FEATURELIST), new h((FaceTarget) bundle.getSerializable(PictureConst.PARAM_FACETARGET), bundle.getString(PictureConst.PARAM_FACE_PIC_LLOC, ""), handler), true);
    }

    @ServiceCmd(PictureConst.CMD_COMMENT_FEED)
    public void handlerCommentFeed(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45712e = bundle.getInt(PictureConst.PARAM_APPID);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        if (mapParcelable != null) {
            lVar.f45718k = mapParcelable.getSingleMap();
        }
        lVar.f45715h = bundle.getString("param.content");
        lVar.f45716i = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        lVar.f45710c = bundle.getString(PictureConst.PARAM_FAKEUNIKEY);
        lVar.f45709b = bundle.getString(PictureConst.PARAM_FEEDKEY);
        lVar.f45711d = bundle.getString(PictureConst.PARAM_CLIENT_KEY);
        lVar.f45725r = bundle.getBoolean(PictureConst.PARAM_IS_PRIVATE);
        lVar.f45724q = bundle.getBoolean(PictureConst.PARAM_IS_TODAY_IN_HIS_FEED);
        lVar.f45720m = (PictureItem) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_PICTURE_ITEM);
        lVar.f45713f = bundle.getLong("param.uin");
        lVar.f45714g = bundle.getString(PictureConst.PARAM_SRCID);
        lVar.f45708a = bundle.getString(PictureConst.PARAM_UGCKEY);
        lVar.f45722o = bundle.getString(PictureConst.PARAM_RELATIVE_UGC_KEY);
        lVar.f45726s = bundle.getStringArrayList(PictureConst.PARAM_COMMENT_PICS);
        lVar.f45729v = bundle.getString(PictureConst.PARAM_LLOC);
        lVar.f45723p = bundle.getInt(PictureConst.PARAM_POSITION, 0);
        lVar.f45728u = 2;
        lVar.f45728u = bundle.getInt(PictureConst.PARAM_SRC_REFER, 0);
        String string = bundle.getString(PictureConst.PARAM_FONT_INFO);
        if (!TextUtils.isEmpty(string)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(string);
            if (simpleFontInfo.hasFont()) {
                HashMap hashMap = new HashMap();
                lVar.f45730w = hashMap;
                hashMap.put("diy_font_id", simpleFontInfo.fontId + "");
                lVar.f45730w.put("diy_font_type", simpleFontInfo.formatType + "");
                lVar.f45730w.put("diy_font_url", simpleFontInfo.fontUrl);
            }
        }
        String string2 = bundle.getString(PictureConst.PARAM_SUPER_FONT_INFO);
        if (!TextUtils.isEmpty(string2)) {
            QzoneSuperPersonalFontData.SuperFontInfo fromJson = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(string2);
            if (fromJson.f51897id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson.f51897id + "");
                lVar.f45730w.put("sparkle_json", string2);
            }
        }
        String string3 = bundle.getString(PictureConst.PARAM_BARRAGE_EFFECT_INFO);
        if (!TextUtils.isEmpty(string3)) {
            QzoneBarrageEffectData.BarrageEffectInfo fromJson2 = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(string3);
            if (fromJson2.f51896id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(UNIVERSAL_MALL_QUAL.value, fromJson2.f51896id + "");
                lVar.f45730w.put("private_barrage_data", string3);
            }
        }
        RapidCommentExpressionInfo rapidCommentExpressionInfo = (RapidCommentExpressionInfo) bundle.getParcelable(PictureConst.PARAM_RAPID_COMMENT_INFO);
        if (rapidCommentExpressionInfo != null) {
            QZoneWriteOperationService.v0().X1(handler, lVar, rapidCommentExpressionInfo);
        } else {
            QZoneWriteOperationService.v0().Q(handler, lVar);
        }
    }

    @ServiceCmd(PictureConst.CMD_COMMENT_FRIEND_VIDEO)
    public void handlerCommentFriendVideo(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA);
        String string2 = bundle.getString("param.content");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PictureConst.PARAM_COMMENT_PICS);
        boolean z16 = bundle.getBoolean(PictureConst.PARAM_IS_PRIVATE);
        System.out.println("--------------handlerCommentFriendVideo--");
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45712e = businessFeedData.getFeedCommInfo().appid;
        lVar.f45715h = string2;
        lVar.f45726s = stringArrayList;
        lVar.f45710c = UUID.randomUUID().toString();
        lVar.f45725r = z16;
        lVar.f45724q = businessFeedData.getFeedCommInfo().isTodayInHistoryFeed();
        lVar.f45713f = businessFeedData.getUser().uin;
        lVar.f45714g = businessFeedData.getIdInfo().cellId;
        String str = businessFeedData.getFeedCommInfo().ugckey;
        lVar.f45708a = str;
        lVar.f45727t = 0;
        lVar.f45716i = string;
        if (TextUtils.isEmpty(str)) {
            lVar.f45708a = businessFeedData.getUser().uin + "_" + businessFeedData.getFeedCommInfo().appid + "_" + businessFeedData.getIdInfo().cellId + "_";
            System.out.println("--------------handlerCommentFriendVideo--ugckey is null");
        }
        QZoneWriteOperationService.v0().Q(handler, lVar);
    }

    @ServiceCmd(PictureConst.CMD_COMMENT_PHOTO)
    public void handlerCommentPhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        PictureItem pictureItem;
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45708a = bundle.getString(PictureConst.PARAM_UGCKEY);
        lVar.f45709b = bundle.getString(PictureConst.PARAM_FEEDKEY);
        lVar.f45710c = bundle.getString(PictureConst.PARAM_FAKEUNIKEY);
        lVar.f45712e = bundle.getInt(PictureConst.PARAM_APPID, 0);
        lVar.f45713f = bundle.getLong("param.uin", 0L);
        lVar.f45714g = bundle.getString(PictureConst.PARAM_SRCID);
        lVar.f45715h = bundle.getString("param.content");
        lVar.f45717j = bundle.getInt(PictureConst.PARAM_ISVERIFY, 0);
        lVar.f45716i = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        lVar.f45718k = (HashMap) bundle.getSerializable(PictureConst.PARAM_BUSI_PARAM);
        lVar.f45721n = bundle.getInt(PictureConst.PARAM_SYN, 0);
        Pair pair = (Pair) bundle.getSerializable(PictureConst.PARAM_PICTURE_ITEM);
        if (pair != null) {
            pictureItem = new PictureItem();
            PictureViewerFactory.m0(pictureItem, pair);
        } else {
            pictureItem = null;
        }
        lVar.f45720m = pictureItem;
        lVar.f45725r = bundle.getBoolean(PictureConst.PARAM_IS_PRIVATE);
        lVar.f45719l = QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW;
        lVar.f45726s = bundle.getStringArrayList(PictureConst.PARAM_COMMENT_PICS);
        lVar.f45723p = bundle.getInt("param.index", 0);
        lVar.f45728u = 2;
        lVar.f45729v = bundle.getString(PictureConst.PARAM_LLOC);
        String string = bundle.getString(PictureConst.PARAM_FONT_INFO);
        if (!TextUtils.isEmpty(string)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(string);
            if (simpleFontInfo.hasFont()) {
                HashMap hashMap = new HashMap();
                lVar.f45730w = hashMap;
                hashMap.put("diy_font_id", simpleFontInfo.fontId + "");
                lVar.f45730w.put("diy_font_type", simpleFontInfo.formatType + "");
                lVar.f45730w.put("diy_font_url", simpleFontInfo.fontUrl);
            }
        }
        String string2 = bundle.getString(PictureConst.PARAM_SUPER_FONT_INFO);
        if (!TextUtils.isEmpty(string2)) {
            QzoneSuperPersonalFontData.SuperFontInfo fromJson2 = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(string2);
            if (fromJson2.f51897id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson2.f51897id + "");
                lVar.f45730w.put("sparkle_json", string2);
            }
        }
        String string3 = bundle.getString(PictureConst.PARAM_BARRAGE_EFFECT_INFO);
        if (!TextUtils.isEmpty(string3) && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(string3)) != null && fromJson.f51896id > 0) {
            if (lVar.f45730w == null) {
                lVar.f45730w = new HashMap();
            }
            lVar.f45730w.put(UNIVERSAL_MALL_QUAL.value, fromJson.f51896id + "");
            lVar.f45730w.put("private_barrage_data", string3);
        }
        QZoneWriteOperationService.v0().Q(handler, lVar);
    }

    @ServiceCmd(PictureConst.CMD_DEL_FAVOR)
    public void handlerDelFavor(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong(PictureConst.PARAM_FAVOR_OWN_UIN);
        String string = bundle.getString(PictureConst.PARAM_FAVOR_UGCKEY);
        QzoneFavoriteService.M().Q(new e(j3, string, bundle.getLong(PictureConst.PARAM_FAVOR_APPID), bundle.getLong(PictureConst.PARAM_FAVOR_SUBID), handler), string);
    }

    @ServiceCmd(PictureConst.CMD_DEL_LOCAL_PHOTO)
    public void handlerDelLocalPhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_DEL_PHOTO_PATH);
        if (com.qzone.common.business.service.e.D().C(string)) {
            Message obtain = Message.obtain();
            obtain.obj = string;
            handler.sendMessage(obtain);
        }
    }

    @ServiceCmd(PictureConst.CMD_DELETE_COMMENT)
    public void handlerDeleteComment(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.v0().T(handler, (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_FEED_DATA), (Comment) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_COMMENT_ITEM));
    }

    @ServiceCmd(PictureConst.CMD_DELETE_PHOTO)
    public void handlerDeletePhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_ALBUMID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PictureConst.PARAM_PHOTOIDLIST);
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(PictureConst.PARAM_VIDEOIDLIST);
        boolean z16 = bundle.getBoolean(PictureConst.PARAM_FROM_SEARCH_RESULT, false);
        if (i3 == 311) {
            com.qzone.album.base.Service.a.W().E(stringArrayList2, new c(handler));
        } else {
            com.qzone.album.base.Service.a.W().B(string, stringArrayList, stringArrayList2, new d(string, stringArrayList, handler), z16);
        }
    }

    @ServiceCmd(PictureConst.CMD_DELETE_REPLY)
    public void handlerDeleteReply(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.v0().d0(handler, (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_FEED_DATA), (Reply) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_REPLY_ITEM), (Comment) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_COMMENT_ITEM), bundle.getInt(PictureConst.PARAM_POSITION));
    }

    @ServiceCmd(PictureConst.CMD_DOWNLOAD_VIDEO)
    public void handlerDownloadVideo(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        i.u().q(bundle.getString(PictureConst.PARAM_URL));
    }

    @ServiceCmd(PictureConst.CMD_EDIT_PHOTOINFO)
    public void handlerEditPhotoInfo(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_ALBUMID);
        String string2 = bundle.getString(PictureConst.PARAM_PHOTOEDIT_CACHEKEY);
        com.qzone.album.base.Service.a.W().G(string, bundle.getStringArrayList(PictureConst.PARAM_PHOTOEDIT_IDLIST), (EditPhoto) bundle.getSerializable(PictureConst.PARAM_PHOTOEDIT_PHOTOINFO), bundle.getInt(PictureConst.PARAM_PHOTOEDIT_OPERATYPE, 2), null, string2, new f(handler));
    }

    @ServiceCmd(PictureConst.CMD_FORWARD_FRIEND_VIDEO)
    public void handlerForwardFriendVideo(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA);
        String string2 = bundle.getString("param.content");
        int i3 = bundle.getInt(PictureConst.PARAM_ACTION_TYPE);
        System.out.println("--------------handlerCommentFriendVideo--");
        QZoneFeedUtil.s(businessFeedData, string2, i3, null, string, handler, false, 1, false);
    }

    @ServiceCmd(PictureConst.CMD_GET_BIG_PHOTO_AD_LIST)
    public void handlerGetBigPhotoAdList(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneAdvService.c().g(handler, bundle.getInt("local_type"), bundle.getInt("remote_type"));
    }

    @ServiceCmd(PictureConst.CMD_GET_FEED_COMMENT)
    public void handlerGetFeedComment(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin");
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        String string = bundle.getString(PictureConst.PARAM_CELLID);
        String string2 = bundle.getString(PictureConst.PARAM_SUBID);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        new com.qzone.detail.business.service.a().Y(j3, i3, string, string2, mapParcelable != null ? mapParcelable.getSingleMap() : null, handler, false);
    }

    @ServiceCmd(PictureConst.CMD_GET_MORE_PHOTO_DATA_LIST)
    public void handlerGetMorePhotoDataList(SendMsg sendMsg, Handler handler) {
        if (sendMsg != null) {
            com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 30, Integer.valueOf(sendMsg.getExtraData().getInt("scroll_orientation")));
        }
    }

    @ServiceCmd(PictureConst.CMD_GET_VIDEO_ID)
    public void handlerGetVideoId(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        ShareUtils.i(handler, bundle.getString(PictureConst.PARAM_URL));
    }

    @ServiceCmd(PictureConst.CMD_LIKE_COMMENT)
    public void handlerLikeComment(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = bundle.getInt(PictureConst.PARAM_APPID);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        if (mapParcelable != null) {
            kVar.f45702i = mapParcelable.getSingleMap();
        }
        kVar.f45697d = bundle.getString(PictureConst.PARAM_FEEDKEY);
        kVar.f45696c = bundle.getString(PictureConst.PARAM_UGCKEY);
        kVar.f45698e = bundle.getString(PictureConst.PARAM_UNIKEY);
        kVar.f45694a = bundle.getLong("param.uin");
        kVar.f45699f = bundle.getString(PictureConst.PARAM_COMM_KEY);
        kVar.f45703j = bundle.getString(PictureConst.PARAM_COMMENT_ID);
        kVar.f45700g = bundle.getBoolean(PictureConst.PARAM_ISLIKE);
        kVar.f45695b = (User) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_TARGET_USER);
        kVar.f45706m = (CustomPraiseData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_CUSTOM_PRAISE_DATA);
        kVar.f45707n = bundle.getInt(PictureConst.PARAM_COMBO_COUNT);
        QZoneWriteOperationService.v0().t1(handler, kVar);
    }

    @ServiceCmd(PictureConst.CMD_PRAISE_FRIEND_VIDEO)
    public void handlerPraiseFriendVideo(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA);
        System.out.println("--------------handlerPraiseFriendVideo--");
        String str = businessFeedData.getFeedCommInfo().ugckey;
        String string = bundle.getString(PictureConst.PARAM_FRIEND_VIDEO_UNIKEY);
        if (TextUtils.isEmpty(str)) {
            str = businessFeedData.getUser().uin + "_" + businessFeedData.getFeedCommInfo().appid + "_" + businessFeedData.getIdInfo().cellId + "_";
            System.out.println("--------------handlerPraiseFriendVideo--ugckey is null");
        }
        if (TextUtils.isEmpty(string)) {
            string = "http://user.qzone.qq.com/" + businessFeedData.getUser().uin + "/mood/" + businessFeedData.getIdInfo().cellId;
            System.out.println("--------------handlerPraiseFriendVideo--unikey is null");
        }
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = str;
        mVar.f45735b = string;
        mVar.f45736c = businessFeedData.getCellUserInfo().uniKey;
        mVar.f45738e = businessFeedData.getLikeInfo().isLiked;
        mVar.f45739f = businessFeedData.getFeedCommInfo().appid;
        mVar.f45742i = 0;
        mVar.f45744k = false;
        mVar.f45746m = 1;
        QZoneWriteOperationService.v0().u1(handler, mVar);
    }

    @ServiceCmd(PictureConst.CMD_PRAISE_PHOTO)
    public void handlerPraisePhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = bundle.getString(PictureConst.PARAM_UGCKEY);
        mVar.f45735b = bundle.getString(PictureConst.PARAM_CURKEY);
        mVar.f45736c = bundle.getString(PictureConst.PARAM_UNIKEY);
        mVar.f45738e = bundle.getBoolean(PictureConst.PARAM_ISLIKE);
        mVar.f45739f = bundle.getInt(PictureConst.PARAM_APPID, 0);
        HashMap hashMap = (HashMap) bundle.getSerializable(PictureConst.PARAM_BUSI_PARAM);
        mVar.f45740g = hashMap;
        if (hashMap != null) {
            hashMap.put(142, "8");
        }
        mVar.f45741h = bundle.getInt(PictureConst.PARAM_SYN, 0);
        mVar.f45742i = bundle.getInt("param.index", 0);
        mVar.f45748o = QzoneCustomPraiseService.i().g();
        mVar.f45749p = 1;
        QZoneWriteOperationService.v0().u1(handler, mVar);
    }

    @ServiceCmd(PictureConst.CMD_QUN_COMMENT_PHOTO)
    public void handlerQunCommentPhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        PictureItem pictureItem;
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45708a = bundle.getString(PictureConst.PARAM_UGCKEY);
        lVar.f45709b = bundle.getString(PictureConst.PARAM_FEEDKEY);
        lVar.f45710c = bundle.getString(PictureConst.PARAM_FAKEUNIKEY);
        lVar.f45712e = bundle.getInt(PictureConst.PARAM_APPID, 0);
        lVar.f45713f = bundle.getLong("param.uin", 0L);
        lVar.f45714g = bundle.getString(PictureConst.PARAM_SRCID);
        lVar.f45715h = bundle.getString("param.content");
        lVar.f45717j = bundle.getInt(PictureConst.PARAM_ISVERIFY, 0);
        lVar.f45716i = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        lVar.f45718k = (HashMap) bundle.getSerializable(PictureConst.PARAM_BUSI_PARAM);
        lVar.f45721n = bundle.getInt(PictureConst.PARAM_SYN, 0);
        Pair pair = (Pair) bundle.getSerializable(PictureConst.PARAM_PICTURE_ITEM);
        if (pair != null) {
            pictureItem = new PictureItem();
            PictureViewerFactory.m0(pictureItem, pair);
        } else {
            pictureItem = null;
        }
        lVar.f45720m = pictureItem;
        lVar.f45725r = bundle.getBoolean(PictureConst.PARAM_IS_PRIVATE);
        lVar.f45719l = QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW;
        lVar.f45726s = bundle.getStringArrayList(PictureConst.PARAM_COMMENT_PICS);
        lVar.f45723p = bundle.getInt("param.index", 0);
        lVar.f45728u = 2;
        lVar.f45729v = bundle.getString(PictureConst.PARAM_LLOC);
        lVar.A = true;
        String string = bundle.getString(PictureConst.PARAM_FONT_INFO);
        if (!TextUtils.isEmpty(string)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(string);
            if (simpleFontInfo.hasFont()) {
                HashMap hashMap = new HashMap();
                lVar.f45730w = hashMap;
                hashMap.put("diy_font_id", simpleFontInfo.fontId + "");
                lVar.f45730w.put("diy_font_type", simpleFontInfo.formatType + "");
                lVar.f45730w.put("diy_font_url", simpleFontInfo.fontUrl);
            }
        }
        String string2 = bundle.getString(PictureConst.PARAM_SUPER_FONT_INFO);
        if (!TextUtils.isEmpty(string2)) {
            QzoneSuperPersonalFontData.SuperFontInfo fromJson2 = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(string2);
            if (fromJson2.f51897id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson2.f51897id + "");
                lVar.f45730w.put("sparkle_json", string2);
            }
        }
        String string3 = bundle.getString(PictureConst.PARAM_BARRAGE_EFFECT_INFO);
        if (!TextUtils.isEmpty(string3) && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(string3)) != null && fromJson.f51896id > 0) {
            if (lVar.f45730w == null) {
                lVar.f45730w = new HashMap();
            }
            lVar.f45730w.put(UNIVERSAL_MALL_QUAL.value, fromJson.f51896id + "");
            lVar.f45730w.put("private_barrage_data", string3);
        }
        QZoneWriteOperationService.v0().Q(handler, lVar);
    }

    @ServiceCmd(PictureConst.CMD_SEND_REPORT_EXPOSE_OR_CLICK)
    public void handlerSendReportExposeOrClick(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString("account_type");
        String string2 = bundle.getString("trace_info");
        if (bundle.getBoolean(TVKDataBinder.KEY_REPORT_TYPE)) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(string2, string);
        } else {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(string2, string);
        }
    }

    @ServiceCmd(PictureConst.CMD_QUERY_ALBUM)
    public void queryAlbum(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        QZoneWriteOperationService.v0().T1(bundle.getString(PictureConst.PARAM_ALBUMID), handler);
    }

    @ServiceCmd(PictureConst.CMD_START_DOWNLOAD_VIDEO)
    public void startDownloadVideo(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || sendMsg.extraData == null) {
            return;
        }
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "serviceHandler startDownloadVideo");
        com.qzone.adapter.feedcomponent.i.H().F2();
    }

    @ServiceCmd(PictureConst.CMD_STOP_DOWNLOAD_VIDEO)
    public void stopDownloadVideo(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || sendMsg.extraData == null) {
            return;
        }
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "serviceHandler stopDownloadVideo");
        com.qzone.adapter.feedcomponent.i.H().G2();
    }

    @ServiceCmd(PictureConst.CMD_ADD_FAVOR)
    public void handlerAddFavor(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong(PictureConst.PARAM_FAVOR_OWN_UIN);
        long j16 = bundle.getLong(PictureConst.PARAM_FAVOR_APPID);
        long j17 = bundle.getLong(PictureConst.PARAM_FAVOR_SUBID);
        String string = bundle.getString(PictureConst.PARAM_FAVOR_CELLID);
        String string2 = bundle.getString(PictureConst.PARAM_FAVOR_SID);
        String string3 = bundle.getString(PictureConst.PARAM_FAVOR_UGCKEY);
        HashMap<String, String> hashMap = (HashMap) bundle.getSerializable(PictureConst.PARAM_FAVOR_BUSIPARAM);
        ArrayList arrayList = (ArrayList) bundle.getSerializable(PictureConst.PARAM_FAVOR_PHOTOS);
        ArrayList<PhotoInformation> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    PhotoInformation photoInformation = new PhotoInformation();
                    photoInformation.sUrl = str;
                    arrayList2.add(photoInformation);
                }
            }
        }
        QzoneFavoriteService.M().F(j3, j16, j17, string, string2, string3, hashMap, arrayList2, true, handler);
    }

    @ServiceCmd(PictureConst.CMD_FORWARD_PHOTO)
    public void handlerForwardPhoto(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        com.qzone.album.base.Service.a.W().J(bundle.getInt(PictureConst.PARAM_APPID, 0), bundle.getInt(PictureConst.PARAM_SUBID, 0), bundle.getLong("param.uin", 0L), bundle.getString(PictureConst.PARAM_SRCID), bundle.getStringArrayList(PictureConst.PARAM_SRCSUBID), bundle.getString("param.content"), 4, "", 0, null, string, new b(string, handler));
    }

    @ServiceCmd(PictureConst.CMD_GET_MORE_COMMENT)
    public void handlerGetMoreComment(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin");
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        String string = bundle.getString(PictureConst.PARAM_CELLID);
        String string2 = bundle.getString(PictureConst.PARAM_SUBID);
        String string3 = bundle.getString(PictureConst.PARAM_ATTACHINFO);
        int i16 = bundle.getInt(PictureConst.PARAM_COUNT);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        new com.qzone.detail.business.service.a().a0(j3, i3, string, string2, string3, i16, mapParcelable != null ? mapParcelable.getSingleMap() : null, bundle.getInt(PictureConst.PARAM_REFRESHTYPE), bundle.getBoolean(PictureConst.PARAM_REQUEST_LIKE_INFO), bundle.getBoolean(PictureConst.PARAM_SAVE_DB), handler);
    }

    @ServiceCmd(PictureConst.CMD_GET_MORE_COMMENT_ESSENCE)
    public void handlerGetMoreCommentEssence(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin");
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        String string = bundle.getString(PictureConst.PARAM_CELLID);
        String string2 = bundle.getString(PictureConst.PARAM_SUBID);
        String string3 = bundle.getString(PictureConst.PARAM_ATTACHINFO);
        int i16 = bundle.getInt(PictureConst.PARAM_COUNT);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        new com.qzone.detail.business.service.a().b0(j3, i3, string, string2, string3, i16, mapParcelable != null ? mapParcelable.getSingleMap() : null, bundle.getInt(PictureConst.PARAM_REFRESHTYPE), bundle.getBoolean(PictureConst.PARAM_REQUEST_LIKE_INFO), bundle.getBoolean(PictureConst.PARAM_SAVE_DB), handler);
    }

    @ServiceCmd(PictureConst.CMD_GET_OUT_SHARE_URL)
    public void handlerGetOutShareUrl(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        OutSiteShareService.a().d(handler, bundle.getInt(PictureConst.PARAM_APPID, 0), bundle.getInt(PictureConst.PARAM_TYPE, 0), bundle.getString(PictureConst.PARAM_SRCID), bundle.getString(PictureConst.PARAM_ALBUMID), bundle.getString(PictureConst.PARAM_LLOC), bundle.getString(PictureConst.PARAM_BATCHID), bundle.getInt(PictureConst.PARAM_IISSHARETO, 0), bundle.getLong(PictureConst.PARAM_HOSTUIN), bundle.getInt(PictureConst.PARAM_SHARESCENE, 2), (Map) bundle.getSerializable(PictureConst.PARAM_BUSI_PARAM));
    }

    @ServiceCmd(PictureConst.CMD_FACE_OPERATION)
    public void handlerOperateFace(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        MarkFaceItemMood markFaceItemMood = (MarkFaceItemMood) bundle.getSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMMOOD);
        MarkFaceItemFeed markFaceItemFeed = (MarkFaceItemFeed) bundle.getSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMFEED);
        long j3 = bundle.getLong(PictureConst.PARAM_MARKFACE_OWNERUIN, 0L);
        com.qzone.album.base.Service.a.W().Z0(j3, bundle.getInt(PictureConst.PARAM_MARKFACE_SCENE, 0), markFaceItemFeed, markFaceItemMood, new g(bundle.getInt(PictureConst.PARAM_MARKFACE_INDEX, -1), markFaceItemFeed, j3, bundle.getString(PictureConst.PARAM_MARKFACE_UNIKEY, ""), handler));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x010d  */
    @ServiceCmd(PictureConst.CMD_REPLY_FEED)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlerReplyFeed(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        Map<Integer, String> hashMap;
        String str;
        String string;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string2 = bundle.getString(PictureConst.PARAM_UGCKEY);
        String string3 = bundle.getString(PictureConst.PARAM_FEEDKEY);
        String string4 = bundle.getString(PictureConst.PARAM_FAKEUNIKEY);
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        long j3 = bundle.getLong("param.uin");
        long j16 = bundle.getLong(PictureConst.PARAM_COMMENT_UIN);
        User user = (User) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.PARAM_TARGET_USER);
        String string5 = bundle.getString(PictureConst.PARAM_SRCID);
        String string6 = bundle.getString(PictureConst.PARAM_LLOC);
        String string7 = bundle.getString(PictureConst.PARAM_COMMENT_ID);
        String string8 = bundle.getString("param.content");
        String string9 = bundle.getString(PictureConst.PARAM_ORI_CONTENT);
        String string10 = bundle.getString(PictureConst.PARAM_CACHE_UNIKEY);
        int i16 = bundle.getInt(PictureConst.PARAM_ISVERIFY);
        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable(PictureConst.PARAM_BUSI_PARAM);
        if (mapParcelable != null) {
            hashMap = mapParcelable.getSingleMap();
        } else {
            hashMap = new HashMap<>();
        }
        Map<Integer, String> map = hashMap;
        String string11 = bundle.getString(PictureConst.PARAM_REFER);
        boolean z16 = bundle.getBoolean(PictureConst.PARAM_IS_TODAY_IN_HIS_FEED);
        int i17 = bundle.getInt(PictureConst.PARAM_POSITION);
        int i18 = bundle.getInt(PictureConst.PARAM_CLICK_SCENE);
        String string12 = bundle.getString(PictureConst.PARAM_FONT_INFO);
        HashMap hashMap2 = new HashMap();
        if (!TextUtils.isEmpty(string12)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(string12);
            if (simpleFontInfo.hasFont()) {
                StringBuilder sb5 = new StringBuilder();
                str = string6;
                sb5.append(simpleFontInfo.fontId);
                sb5.append("");
                hashMap2.put("diy_font_id", sb5.toString());
                hashMap2.put("diy_font_type", simpleFontInfo.formatType + "");
                hashMap2.put("diy_font_url", simpleFontInfo.fontUrl);
                string = bundle.getString(PictureConst.PARAM_SUPER_FONT_INFO);
                if (!TextUtils.isEmpty(string)) {
                    QzoneSuperPersonalFontData.SuperFontInfo fromJson = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(string);
                    if (fromJson.f51897id > 0) {
                        hashMap2.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson.f51897id + "");
                        hashMap2.put("sparkle_json", string);
                    }
                }
                QZoneWriteOperationService.v0().c2(handler, string2, string3, string4, i3, j3, j16, user, string5, str, string7, string8, string9, string10, i16, map, string11, z16, i17, i18, hashMap2);
            }
        }
        str = string6;
        string = bundle.getString(PictureConst.PARAM_SUPER_FONT_INFO);
        if (!TextUtils.isEmpty(string)) {
        }
        QZoneWriteOperationService.v0().c2(handler, string2, string3, string4, i3, j3, j16, user, string5, str, string7, string8, string9, string10, i16, map, string11, z16, i17, i18, hashMap2);
    }

    @ServiceCmd(PictureConst.CMD_RESHIP)
    public void handlerReship(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        int i3 = bundle.getInt(PictureConst.PARAM_APPID);
        long j3 = bundle.getLong("param.uin");
        String string = bundle.getString(PictureConst.PARAM_SRCID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PictureConst.PARAM_SRCSUBID);
        HashMap hashMap = (HashMap) bundle.getSerializable(PictureConst.PARAM_PHOTOIDLIST);
        String string2 = bundle.getString(PictureConst.PARAM_ALBUMID);
        QZoneWriteOperationService.v0().s0(null, null, i3, 0, j3, string, stringArrayList, "", null, null, null, 0, 0, 0, null, 7, string2, !TextUtils.isEmpty(string2) ? -1 : 1, null, handler, null, false, false, hashMap, null);
    }
}
