package le;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.proxy.feedcomponent.util.m;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.event.QzoneScrollToTopEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProOldAddFakeFeedEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProOldDeleteFakeFeedEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProOldFetchRealFeedEvent;
import com.qzone.reborn.feedpro.utils.ah;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.bean.QzoneCommonFakeFeedBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellBigTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLocalInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellRemark;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lc.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\u0005JD\u0010\u0015\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 H\u0016J\u0010\u0010#\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$\u00a8\u0006)"}, d2 = {"Lle/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/bean/QzoneCommonFakeFeedBean;", "fakeFeedBean", "", "b", "", "clientKey", h.F, "g", "i", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaList", "", "shootParams", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "a", "Lcom/qzone/publish/ui/model/c;", "params", "c", "", "isSuccess", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedLogicManager$OnFetchFeedCompleteCallback;", "callBack", "f", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final b f414397d = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"le/b$a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache$OnOperateResultCallback;", "", "isSuccess", "", "resultData", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements QzoneFakeFeedCache.OnOperateResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneCommonFakeFeedBean f414398a;

        a(QzoneCommonFakeFeedBean qzoneCommonFakeFeedBean) {
            this.f414398a = qzoneCommonFakeFeedBean;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache.OnOperateResultCallback
        public void onResult(boolean isSuccess, Object resultData) {
            CommonCellCommon cellCommon = this.f414398a.getCellCommon();
            QLog.d("QzoneFeedProFakeFeedManager", 1, "addFakeFeed, saveDbSingleFakeFeed, onResult | isSuccess=" + isSuccess + " | clientKey=" + (cellCommon != null ? cellCommon.getClientKey() : null));
            if (isSuccess) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                CommonCellCommon cellCommon2 = this.f414398a.getCellCommon();
                simpleEventBus.dispatchEvent(new QzoneFeedProOldAddFakeFeedEvent(cellCommon2 != null ? cellCommon2.getClientKey() : null), true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"le/b$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache$OnOperateResultCallback;", "", "isSuccess", "", "resultData", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: le.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10718b implements QzoneFakeFeedCache.OnOperateResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f414399a;

        C10718b(String str) {
            this.f414399a = str;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache.OnOperateResultCallback
        public void onResult(boolean isSuccess, Object resultData) {
            QLog.d("QzoneFeedProFakeFeedManager", 1, "handleOldAddFakeFeed, restoreDbSingleFakeFeed, onResult | isSuccess=" + isSuccess + " | resultData=" + resultData + " | clientKey=" + this.f414399a);
            if (isSuccess && (resultData instanceof CommonFeed)) {
                CommonFeed commonFeed = (CommonFeed) resultData;
                CommonCellCommon cellCommon = commonFeed.getCellCommon();
                if (Intrinsics.areEqual(cellCommon != null ? cellCommon.getClientKey() : null, this.f414399a)) {
                    QzoneFakeFeedLogicManager.INSTANCE.insertFakeFeed(commonFeed);
                    SimpleEventBus.getInstance().dispatchEvent(new QzoneScrollToTopEvent(true, false, 2, null));
                }
            }
        }
    }

    b() {
    }

    private final void b(QzoneCommonFakeFeedBean fakeFeedBean) {
        boolean a16 = km.a.f412646a.a();
        CommonCellCommon cellCommon = fakeFeedBean.getCellCommon();
        QLog.d("QzoneFeedProFakeFeedManager", 1, "addFakeFeed | clientKey=" + (cellCommon != null ? cellCommon.getClientKey() : null) + " | isMainProcess=" + a16);
        if (a16) {
            QzoneFakeFeedLogicManager.INSTANCE.insertFakeFeed(fakeFeedBean);
            SimpleEventBus.getInstance().dispatchEvent(new QzoneScrollToTopEvent(true, false, 2, null));
        } else {
            QzoneFakeFeedLogicManager.INSTANCE.saveDbSingleFakeFeed(fakeFeedBean, new a(fakeFeedBean));
        }
    }

    private final void g(String clientKey) {
        QLog.d("QzoneFeedProFakeFeedManager", 1, "handleOldAddFakeFeedEvent | clientKey=" + clientKey);
        QzoneFakeFeedLogicManager.INSTANCE.restoreDbSingleFakeFeed(clientKey, new C10718b(clientKey));
    }

    private final void h(String clientKey) {
        QLog.d("QzoneFeedProFakeFeedManager", 1, "handleOldFetchRealFeedEvent | clientKey=" + clientKey);
        if (clientKey == null) {
            return;
        }
        QzoneFakeFeedLogicManager.fetchRealFeed$default(QzoneFakeFeedLogicManager.INSTANCE, clientKey, null, 2, null);
    }

    public final void a(LbsDataV2.PoiInfo poiInfo, List<? extends MediaWrapper> mediaList, String clientKey, Map<String, String> shootParams, CommonAlbumInfo albumInfo) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        QLog.i("QzoneFeedProFakeFeedManager", 1, "addAlbumPicFakeFeed clientKey=" + clientKey + " | albumId=" + albumInfo.getAlbumId() + " | mediaSize=" + mediaList.size());
        le.a aVar = le.a.f414396a;
        aVar.c(mediaList);
        CommonCellCommon commonCellCommon = new CommonCellCommon();
        commonCellCommon.setFeedType(1);
        commonCellCommon.setFeedSubType(2);
        commonCellCommon.setFeedBizType(0);
        commonCellCommon.setClientKey(clientKey);
        CommonUnionID commonUnionID = new CommonUnionID();
        commonUnionID.setFeedId(clientKey);
        commonUnionID.setUfKey(clientKey);
        commonUnionID.setUgcId(clientKey);
        commonCellCommon.setUnionId(commonUnionID);
        commonCellCommon.setTime(System.currentTimeMillis() / 1000);
        CommonCellUserInfo commonCellUserInfo = new CommonCellUserInfo();
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(LoginData.getInstance().getUinString());
        commonUser.setNick(i.H().k0());
        commonCellUserInfo.setUser(commonUser);
        CommonCellLBS commonCellLBS = new CommonCellLBS();
        commonCellLBS.setLbs(new CommonLBS());
        String e16 = c.f414336a.e(poiInfo);
        if (e16 != null) {
            CommonLBS lbs = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs);
            lbs.setLocation(e16);
            CommonLBS lbs2 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs2);
            lbs2.setAddress(e16);
        }
        CommonLBS lbs3 = commonCellLBS.getLbs();
        Intrinsics.checkNotNull(lbs3);
        if (TextUtils.isEmpty(lbs3.getLocation()) && shootParams != null && (str2 = shootParams.get("geo_idname")) != null) {
            CommonLBS lbs4 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs4);
            lbs4.setLocation(str2);
            CommonLBS lbs5 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs5);
            lbs5.setAddress(str2);
        }
        CommonCellSummary commonCellSummary = new CommonCellSummary();
        if (!(!mediaList.isEmpty())) {
            str = null;
        } else if (mediaList.get(0).isImage()) {
            str = mediaList.get(0).getImageInfo().mDescription;
        } else {
            str = mediaList.get(0).getVideoInfo().mDescription;
        }
        commonCellSummary.setSummary(ah.f54303a.a(str));
        CommonCellRemark commonCellRemark = new CommonCellRemark();
        if (!TextUtils.isEmpty(albumInfo.getName())) {
            commonCellRemark.setTitle(albumInfo.getName());
        }
        CommonCellPermission commonCellPermission = new CommonCellPermission();
        if (albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType() != 1) {
            com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
            commonCellPermission.setDesc(cVar.d(albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()));
            commonCellPermission.setIcon(cVar.i(albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()));
        }
        CommonCellMedia d16 = aVar.d(mediaList, albumInfo);
        CommonCellBigTail commonCellBigTail = new CommonCellBigTail();
        if (!TextUtils.isEmpty(albumInfo.getName())) {
            commonCellBigTail.setDesc("\u6b63\u5728\u4e0a\u4f20\u5230" + com.qzone.reborn.albumx.qzonex.utils.c.f53402a.b(albumInfo.getQzAlbumType()) + "\u00b7" + albumInfo.getName());
            commonCellBigTail.setBrightIcon("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qzone/icon/qecommerce_qzone_icon_photo.png");
            commonCellBigTail.setDarkIcon("https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/qzone/icon/qecommerce_qzone_icon_photo.png");
            commonCellBigTail.setType(1);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(commonCellBigTail);
        CommonCellLocalInfo commonCellLocalInfo = new CommonCellLocalInfo();
        commonCellLocalInfo.setFake();
        QzoneCommonFakeFeedBean qzoneCommonFakeFeedBean = new QzoneCommonFakeFeedBean();
        qzoneCommonFakeFeedBean.setCellCommon(commonCellCommon);
        qzoneCommonFakeFeedBean.setCellUserInfo(commonCellUserInfo);
        qzoneCommonFakeFeedBean.setCellLbs(commonCellLBS);
        qzoneCommonFakeFeedBean.setCellSummary(commonCellSummary);
        qzoneCommonFakeFeedBean.setCellRemark(commonCellRemark);
        qzoneCommonFakeFeedBean.setCellPermission(commonCellPermission);
        qzoneCommonFakeFeedBean.setCellMedia(d16);
        qzoneCommonFakeFeedBean.setRptCellBigTail(arrayList);
        qzoneCommonFakeFeedBean.setCellLocalInfo(commonCellLocalInfo);
        b(qzoneCommonFakeFeedBean);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(com.qzone.publish.ui.model.c params, String clientKey) {
        String str;
        String N0;
        PublishEventTag publishEventTag;
        int i3;
        ArrayList arrayList;
        PublishEventTag publishEventTag2;
        String str2;
        boolean startsWith$default;
        Map<String, String> map;
        String str3;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QzoneFeedProFakeFeedManager", 1, "addShuoShuoPicFakeFeed clientKey=" + clientKey + " | params=" + params);
        if (lc.i.f414345a.u(params, clientKey)) {
            return;
        }
        CommonCellCommon commonCellCommon = new CommonCellCommon();
        commonCellCommon.setFeedType(1);
        commonCellCommon.setFeedSubType(1);
        commonCellCommon.setFeedBizType(0);
        commonCellCommon.setClientKey(clientKey);
        CommonUnionID commonUnionID = new CommonUnionID();
        commonUnionID.setFeedId(clientKey);
        commonUnionID.setUfKey(clientKey);
        commonUnionID.setUgcId(clientKey);
        commonCellCommon.setUnionId(commonUnionID);
        commonCellCommon.setTime(System.currentTimeMillis() / 1000);
        CommonCellUserInfo commonCellUserInfo = new CommonCellUserInfo();
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(LoginData.getInstance().getUinString());
        commonUser.setNick(i.H().k0());
        commonCellUserInfo.setUser(commonUser);
        CommonCellLBS commonCellLBS = new CommonCellLBS();
        commonCellLBS.setLbs(new CommonLBS());
        String e16 = c.f414336a.e(params.f51948j);
        if (e16 != null) {
            CommonLBS lbs = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs);
            lbs.setLocation(e16);
            CommonLBS lbs2 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs2);
            lbs2.setAddress(e16);
        }
        CommonLBS lbs3 = commonCellLBS.getLbs();
        Intrinsics.checkNotNull(lbs3);
        if (TextUtils.isEmpty(lbs3.getLocation()) && (map = params.f51954p) != null && (str3 = map.get("geo_idname")) != null) {
            CommonLBS lbs4 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs4);
            lbs4.setLocation(str3);
            CommonLBS lbs5 = commonCellLBS.getLbs();
            Intrinsics.checkNotNull(lbs5);
            lbs5.setAddress(str3);
        }
        CommonCellSummary commonCellSummary = new CommonCellSummary();
        if (params.f51950l && !TextUtils.isEmpty(params.f51934b)) {
            String str4 = params.f51934b;
            Intrinsics.checkNotNullExpressionValue(str4, "params.content");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str4, "qm", false, 2, null);
            if (startsWith$default) {
                String str5 = params.f51934b;
                Intrinsics.checkNotNullExpressionValue(str5, "params.content");
                str = str5.substring(2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                N0 = f.N0(str);
                if (TextUtils.isEmpty(N0)) {
                    ArrayList<MediaWrapper> arrayList2 = params.M;
                    if (!(arrayList2 == null || arrayList2.isEmpty())) {
                        if (params.M.get(0).isImage()) {
                            str2 = params.M.get(0).getImageInfo().mDescription;
                        } else {
                            str2 = params.M.get(0).getVideoInfo().mDescription;
                        }
                        N0 = str2;
                    }
                }
                commonCellSummary.setSummary(ah.f54303a.a(N0));
                publishEventTag = params.C;
                if (publishEventTag != null) {
                    TextUtils.isEmpty(publishEventTag.title);
                }
                CommonCellPermission commonCellPermission = new CommonCellPermission();
                i3 = params.f51959u;
                if (i3 != 1) {
                    commonCellPermission.setDesc(m.b(i3));
                    com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
                    commonCellPermission.setIcon(cVar.i(cVar.k(Integer.valueOf(params.f51959u))));
                }
                if (bl.b(params.M) && bl.c(params.f51936c)) {
                    List<String> list = params.f51936c;
                    Intrinsics.checkNotNullExpressionValue(list, "params.imageFiles");
                    for (String str6 : list) {
                        ImageInfo imageInfo = new ImageInfo();
                        imageInfo.mPath = str6;
                        MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
                        if (params.M == null) {
                            params.M = new ArrayList<>();
                        }
                        params.M.add(mediaWrapper);
                    }
                }
                CommonCellMedia d16 = le.a.f414396a.d(params.M, null);
                HashMap<String, String> hashMap = params.E;
                d16.setLongPicsBrowsingMode(TextUtils.equals(hashMap != null ? hashMap.get("is_feeds_long_pics_browsing_mode") : null, "1"));
                arrayList = new ArrayList();
                publishEventTag2 = params.C;
                if (publishEventTag2 != null && !TextUtils.isEmpty(publishEventTag2.title)) {
                    CommonCellBigTail commonCellBigTail = new CommonCellBigTail();
                    commonCellBigTail.setDesc("#" + params.C.title);
                    commonCellBigTail.setType(3);
                    arrayList.add(commonCellBigTail);
                }
                CommonCellLocalInfo commonCellLocalInfo = new CommonCellLocalInfo();
                commonCellLocalInfo.setFake();
                QzoneCommonFakeFeedBean qzoneCommonFakeFeedBean = new QzoneCommonFakeFeedBean();
                qzoneCommonFakeFeedBean.setCellCommon(commonCellCommon);
                qzoneCommonFakeFeedBean.setCellUserInfo(commonCellUserInfo);
                qzoneCommonFakeFeedBean.setCellLbs(commonCellLBS);
                qzoneCommonFakeFeedBean.setCellSummary(commonCellSummary);
                qzoneCommonFakeFeedBean.setCellPermission(commonCellPermission);
                qzoneCommonFakeFeedBean.setCellMedia(d16);
                qzoneCommonFakeFeedBean.setRptCellBigTail(arrayList);
                qzoneCommonFakeFeedBean.setCellLocalInfo(commonCellLocalInfo);
                b(qzoneCommonFakeFeedBean);
            }
        }
        str = params.f51934b;
        N0 = f.N0(str);
        if (TextUtils.isEmpty(N0)) {
        }
        commonCellSummary.setSummary(ah.f54303a.a(N0));
        publishEventTag = params.C;
        if (publishEventTag != null) {
        }
        CommonCellPermission commonCellPermission2 = new CommonCellPermission();
        i3 = params.f51959u;
        if (i3 != 1) {
        }
        if (bl.b(params.M)) {
            List<String> list2 = params.f51936c;
            Intrinsics.checkNotNullExpressionValue(list2, "params.imageFiles");
            while (r2.hasNext()) {
            }
        }
        CommonCellMedia d162 = le.a.f414396a.d(params.M, null);
        HashMap<String, String> hashMap2 = params.E;
        d162.setLongPicsBrowsingMode(TextUtils.equals(hashMap2 != null ? hashMap2.get("is_feeds_long_pics_browsing_mode") : null, "1"));
        arrayList = new ArrayList();
        publishEventTag2 = params.C;
        if (publishEventTag2 != null) {
            CommonCellBigTail commonCellBigTail2 = new CommonCellBigTail();
            commonCellBigTail2.setDesc("#" + params.C.title);
            commonCellBigTail2.setType(3);
            arrayList.add(commonCellBigTail2);
        }
        CommonCellLocalInfo commonCellLocalInfo2 = new CommonCellLocalInfo();
        commonCellLocalInfo2.setFake();
        QzoneCommonFakeFeedBean qzoneCommonFakeFeedBean2 = new QzoneCommonFakeFeedBean();
        qzoneCommonFakeFeedBean2.setCellCommon(commonCellCommon);
        qzoneCommonFakeFeedBean2.setCellUserInfo(commonCellUserInfo);
        qzoneCommonFakeFeedBean2.setCellLbs(commonCellLBS);
        qzoneCommonFakeFeedBean2.setCellSummary(commonCellSummary);
        qzoneCommonFakeFeedBean2.setCellPermission(commonCellPermission2);
        qzoneCommonFakeFeedBean2.setCellMedia(d162);
        qzoneCommonFakeFeedBean2.setRptCellBigTail(arrayList);
        qzoneCommonFakeFeedBean2.setCellLocalInfo(commonCellLocalInfo2);
        b(qzoneCommonFakeFeedBean2);
    }

    public final void e(String clientKey) {
        boolean a16 = km.a.f412646a.a();
        QLog.i("QzoneFeedProFakeFeedManager", 1, "deleteFakeFeed clientKey: " + clientKey + ", isMainProcess=" + a16);
        if (!a16) {
            SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProOldDeleteFakeFeedEvent(clientKey), true);
            return;
        }
        if (TextUtils.isEmpty(clientKey)) {
            return;
        }
        CommonFeed commonFeed = new CommonFeed();
        CommonCellCommon commonCellCommon = new CommonCellCommon();
        commonCellCommon.setFeedType(1);
        commonCellCommon.setClientKey(clientKey);
        CommonUnionID commonUnionID = new CommonUnionID();
        commonUnionID.setFeedId(clientKey);
        commonUnionID.setUfKey(clientKey);
        commonUnionID.setUgcId(clientKey);
        commonCellCommon.setUnionId(commonUnionID);
        commonFeed.setCellCommon(commonCellCommon);
        d(commonFeed);
    }

    public final void f(boolean isSuccess, String clientKey, QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback callBack) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        boolean a16 = km.a.f412646a.a();
        QLog.i("QzoneFeedProFakeFeedManager", 1, "fetchRealFeed  | isSuccess=" + isSuccess + " | clientKey=" + clientKey + " | isMainProcess=" + a16);
        if (isSuccess) {
            if (a16) {
                QzoneFakeFeedLogicManager.INSTANCE.fetchRealFeed(clientKey, callBack);
            } else {
                SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProOldFetchRealFeedEvent(clientKey), true);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QzoneFeedProOldAddFakeFeedEvent.class);
        arrayList.add(QzoneFeedProOldFetchRealFeedEvent.class);
        arrayList.add(QzoneFeedProOldDeleteFakeFeedEvent.class);
        return arrayList;
    }

    public final void i() {
        km.a aVar = km.a.f412646a;
        QLog.d("QzoneFeedProFakeFeedManager", 1, "init isMainProcess=" + aVar.a());
        if (aVar.a()) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QzoneFeedProOldAddFakeFeedEvent) {
            g(((QzoneFeedProOldAddFakeFeedEvent) event).getClientKey());
        } else if (event instanceof QzoneFeedProOldFetchRealFeedEvent) {
            h(((QzoneFeedProOldFetchRealFeedEvent) event).getClientKey());
        } else if (event instanceof QzoneFeedProOldDeleteFakeFeedEvent) {
            e(((QzoneFeedProOldDeleteFakeFeedEvent) event).getClientKey());
        }
    }

    public final void d(CommonFeed commonFeed) {
        QLog.i("QzoneFeedProFakeFeedManager", 1, "deleteFakeFeed clientKey: " + (commonFeed != null ? CommonFeedExtKt.getFeedUniqueKey(commonFeed) : null));
        QzoneFakeFeedLogicManager.INSTANCE.deleteFakeFeed(commonFeed);
    }
}
