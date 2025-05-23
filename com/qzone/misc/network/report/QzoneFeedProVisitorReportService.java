package com.qzone.misc.network.report;

import NS_MOBILE_EXTRA.s_visit_record;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellOrigin;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionExtID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000267B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\t2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010!R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d0&j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R8\u00102\u001a&\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u000600R\u00020\u00000&j\u0012\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u000600R\u00020\u0000`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010(\u00a8\u00068"}, d2 = {"Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService;", "Lcom/qzone/common/business/IQZoneServiceListener;", "LNS_MOBILE_EXTRA/s_visit_record;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "i", "j", "", "visitType", "", "f", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "g", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "layerLaunchBean", "d", "", "items", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/common/business/task/QZoneTask;", "task", "onTaskResponse", "k", "", "feedUniKey", "l", "", "J", "mLastReportTime", "", "Ljava/util/List;", "mReportItems", "mBackupItems", h.F, "mKeys", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mHBKeysTime", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", BdhLogUtil.LogTag.Tag_Conn, "I", "reportSettingDelay", "Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService$FeedVistorReportRunnable;", "D", "mReportRunnableMap", "<init>", "()V", "E", "a", "FeedVistorReportRunnable", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QzoneFeedProVisitorReportService implements IQZoneServiceListener {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static QzoneFeedProVisitorReportService F;

    /* renamed from: C, reason: from kotlin metadata */
    private int reportSettingDelay;

    /* renamed from: D, reason: from kotlin metadata */
    private final HashMap<String, FeedVistorReportRunnable> mReportRunnableMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mLastReportTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<s_visit_record> mReportItems;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<s_visit_record> mBackupItems;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<String> mKeys;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Long> mHBKeysTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService$FeedVistorReportRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "<init>", "(Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public final class FeedVistorReportRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final CommonFeed feedData;
        final /* synthetic */ QzoneFeedProVisitorReportService this$0;

        public FeedVistorReportRunnable(QzoneFeedProVisitorReportService qzoneFeedProVisitorReportService, CommonFeed feedData) {
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            this.this$0 = qzoneFeedProVisitorReportService;
            this.feedData = feedData;
        }

        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("QzoneFeedProVisitorReportService", "FeedVistorReportRunnable addRecord: " + CommonFeedExtKt.getFeedUniqueKey(this.feedData));
            this.this$0.g(this.feedData, 0);
            this.this$0.mReportRunnableMap.remove(CommonFeedExtKt.getFeedUniqueKey(this.feedData));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService$a;", "", "Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService;", "a", "", "DEFAULT_DELAY_TIME", "I", "DEFAULT_HBCLICK_INTERVAL_TIME", "DEFAULT_INTERVAL_TIME", "DEFAULT_MAX_NUM", "FROM_DETAIL", "FROM_LAYER", "FROM_PLAY", "FROM_RED_READ", "FROM_RED_WRITE", "FROM_SLAY", "FROM_VIDEO_PLAY", "FROM_VOICE_PLAY", "", "TAG", "Ljava/lang/String;", "mInstance", "Lcom/qzone/misc/network/report/QzoneFeedProVisitorReportService;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.misc.network.report.QzoneFeedProVisitorReportService$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final QzoneFeedProVisitorReportService a() {
            QzoneFeedProVisitorReportService qzoneFeedProVisitorReportService = QzoneFeedProVisitorReportService.F;
            if (qzoneFeedProVisitorReportService == null) {
                synchronized (this) {
                    qzoneFeedProVisitorReportService = QzoneFeedProVisitorReportService.F;
                    if (qzoneFeedProVisitorReportService == null) {
                        qzoneFeedProVisitorReportService = new QzoneFeedProVisitorReportService(null);
                        QzoneFeedProVisitorReportService.F = qzoneFeedProVisitorReportService;
                    }
                }
            }
            return qzoneFeedProVisitorReportService;
        }

        Companion() {
        }
    }

    public /* synthetic */ QzoneFeedProVisitorReportService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final QzoneFeedProVisitorReportService h() {
        return INSTANCE.a();
    }

    private final synchronized boolean i(s_visit_record record) {
        boolean z16 = false;
        if (record.fuin == LoginData.getInstance().getUin()) {
            return false;
        }
        String str = record.appid + record.fuin + record.srcId + record.gameId + record.subid + record.visit_type;
        if (!this.mKeys.contains(str)) {
            this.mKeys.add(str);
            z16 = true;
        }
        return z16;
    }

    private final boolean j() {
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        return System.currentTimeMillis() - this.mLastReportTime > ((long) qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_INTEVAL, 600)) * 1000 && this.mReportItems.size() >= qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_COUNT, 50);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        if (r10 != null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(QzoneFeedProLayerRouteBean layerLaunchBean, CommonFeed feedData) {
        String str;
        CommonCellCommon cellCommon;
        String cellId;
        CommonUser user;
        Intrinsics.checkNotNullParameter(layerLaunchBean, "layerLaunchBean");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        ArrayList<QzoneFeedProLayerExtraInfoBean> q16 = layerLaunchBean.q();
        if (q16 == null || layerLaunchBean.getCurPos() >= q16.size()) {
            return;
        }
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = q16.get(layerLaunchBean.getCurPos());
        Intrinsics.checkNotNullExpressionValue(qzoneFeedProLayerExtraInfoBean, "extraInfoBeanList[layerLaunchBean.curPos]");
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean2 = qzoneFeedProLayerExtraInfoBean;
        s_visit_record s_visit_recordVar = new s_visit_record();
        CommonCellUserInfo cellUserInfo = feedData.getCellUserInfo();
        s_visit_recordVar.fuin = ef.d.l((cellUserInfo == null || (user = cellUserInfo.getUser()) == null) ? null : user.getUin(), 0L);
        CommonCellCommon cellCommon2 = feedData.getCellCommon();
        s_visit_recordVar.subid = cellCommon2 != null ? cellCommon2.getSubId() : 0;
        CommonCellCommon cellCommon3 = feedData.getCellCommon();
        int appId = cellCommon3 != null ? cellCommon3.getAppId() : 0;
        s_visit_recordVar.appid = appId;
        if (appId == 4) {
            CommonCellMedia cellMedia = feedData.getCellMedia();
            if (cellMedia != null) {
                str = cellMedia.getAlbumId();
            }
            str = "";
        } else {
            CommonCellOrigin cellOrigin = feedData.getCellOrigin();
            if (cellOrigin == null || (cellCommon = cellOrigin.getCellCommon()) == null || (cellId = cellCommon.getCellId()) == null) {
                CommonCellCommon cellCommon4 = feedData.getCellCommon();
                String cellId2 = cellCommon4 != null ? cellCommon4.getCellId() : null;
                if (cellId2 != null) {
                    str = cellId2;
                }
                str = "";
            } else {
                str = cellId;
            }
        }
        s_visit_recordVar.srcId = str;
        HashMap busi_param = new HashMap();
        s_visit_recordVar.busi_param = busi_param;
        Intrinsics.checkNotNullExpressionValue(busi_param, "busi_param");
        String lLoc = qzoneFeedProLayerExtraInfoBean2.getLLoc();
        if (lLoc == null) {
            lLoc = "";
        }
        busi_param.put(2, lLoc);
        Map<Integer, String> busi_param2 = s_visit_recordVar.busi_param;
        Intrinsics.checkNotNullExpressionValue(busi_param2, "busi_param");
        String sLoc = qzoneFeedProLayerExtraInfoBean2.getSLoc();
        if (sLoc == null) {
            sLoc = "";
        }
        busi_param2.put(1, sLoc);
        long batchId = qzoneFeedProLayerExtraInfoBean2.getBatchId();
        if (batchId != 0) {
            Map<Integer, String> busi_param3 = s_visit_recordVar.busi_param;
            Intrinsics.checkNotNullExpressionValue(busi_param3, "busi_param");
            busi_param3.put(21, String.valueOf(batchId));
        } else {
            Map<Integer, String> busi_param4 = s_visit_recordVar.busi_param;
            Intrinsics.checkNotNullExpressionValue(busi_param4, "busi_param");
            busi_param4.put(21, "");
        }
        f(s_visit_recordVar, 1);
    }

    public final synchronized void e(s_visit_record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        RFWLog.d("QzoneFeedProVisitorReportService", RFWLog.DEV, "add record,record : " + record);
        if (i(record)) {
            record.vtime = System.currentTimeMillis() / 1000;
            this.mReportItems.add(record);
            RFWLog.i("QzoneFeedProVisitorReportService", RFWLog.USR, "add record,record size : " + this.mReportItems.size());
        } else {
            RFWLog.i("QzoneFeedProVisitorReportService", RFWLog.USR, "duplicate record, do not record");
        }
        if (j()) {
            m();
        }
    }

    public final synchronized void f(s_visit_record record, int visitType) {
        Intrinsics.checkNotNullParameter(record, "record");
        record.visit_type = visitType;
        e(record);
    }

    public final void k(CommonFeed feedData) {
        if (!g.f53821a.b().F() || feedData == null) {
            return;
        }
        FeedVistorReportRunnable feedVistorReportRunnable = new FeedVistorReportRunnable(this, feedData);
        if (this.reportSettingDelay < 0) {
            this.reportSettingDelay = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_STOPTIME, 2000);
        }
        this.mHandler.postDelayed(feedVistorReportRunnable, this.reportSettingDelay);
        this.mReportRunnableMap.put(CommonFeedExtKt.getFeedUniqueKey(feedData), feedVistorReportRunnable);
    }

    public final synchronized void m() {
        if (g.f53821a.b().F()) {
            if (LoginData.getInstance().getUin() != 0) {
                n(this.mReportItems);
                if (!this.mBackupItems.isEmpty()) {
                    this.mBackupItems.clear();
                }
                this.mBackupItems.addAll(this.mReportItems);
                this.mReportItems.clear();
                this.mKeys.clear();
            }
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this) {
            if (!task.succeeded() && (!this.mBackupItems.isEmpty())) {
                n(this.mBackupItems);
            }
            this.mBackupItems.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    QzoneFeedProVisitorReportService() {
        this.mReportItems = new ArrayList();
        this.mBackupItems = new ArrayList();
        this.mKeys = new ArrayList();
        this.mHBKeysTime = new HashMap<>();
        this.mHandler = new Handler();
        this.reportSettingDelay = -1;
        this.mReportRunnableMap = new HashMap<>();
    }

    public final void n(List<s_visit_record> items) {
        List<s_visit_record> list = items;
        if (!(list == null || list.isEmpty())) {
            RFWLog.i("QzoneFeedProVisitorReportService", RFWLog.USR, "do report: " + items.size());
            this.mLastReportTime = System.currentTimeMillis();
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneFeedVisitorRptRequest(new ArrayList(items)), null, this, 0));
            return;
        }
        RFWLog.i("QzoneFeedProVisitorReportService", RFWLog.USR, "There is no record to report!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00c1, code lost:
    
        if (r1 == null) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(CommonFeed feedData, int visitType) {
        long j3;
        String cellId;
        CommonCellCommon cellCommon;
        CommonCellMedia cellMedia;
        CommonImage cover;
        CommonImage cover2;
        CommonCellCommon cellCommon2;
        CommonUnionID unionId;
        List<CommonUnionExtID> extIds;
        Object obj;
        CommonUser user;
        if (feedData == null) {
            return;
        }
        s_visit_record s_visit_recordVar = new s_visit_record();
        CommonCellCommon cellCommon3 = feedData.getCellCommon();
        s_visit_recordVar.appid = cellCommon3 != null ? cellCommon3.getAppId() : 0;
        CommonCellCommon cellCommon4 = feedData.getCellCommon();
        s_visit_recordVar.subid = cellCommon4 != null ? cellCommon4.getSubId() : 0;
        CommonCellUserInfo cellUserInfo = feedData.getCellUserInfo();
        s_visit_recordVar.fuin = ef.d.l((cellUserInfo == null || (user = cellUserInfo.getUser()) == null) ? null : user.getUin(), 0L);
        s_visit_recordVar.visit_type = visitType;
        if (s_visit_recordVar.appid == 4 && (cellCommon2 = feedData.getCellCommon()) != null && (unionId = cellCommon2.getUnionId()) != null && (extIds = unionId.getExtIds()) != null) {
            Iterator<T> it = extIds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer extIdType = ((CommonUnionExtID) obj).getExtIdType();
                if (extIdType != null && extIdType.intValue() == 2) {
                    break;
                }
            }
            CommonUnionExtID commonUnionExtID = (CommonUnionExtID) obj;
            if (commonUnionExtID != null) {
                j3 = commonUnionExtID.getNumeric();
                s_visit_recordVar.gameId = j3;
                if (s_visit_recordVar.appid != 4) {
                    CommonCellMedia cellMedia2 = feedData.getCellMedia();
                    if (cellMedia2 != null) {
                        cellId = cellMedia2.getAlbumId();
                    }
                    cellId = "";
                } else {
                    CommonCellOrigin cellOrigin = feedData.getCellOrigin();
                    if (cellOrigin == null || (cellCommon = cellOrigin.getCellCommon()) == null || (cellId = cellCommon.getCellId()) == null) {
                        CommonCellCommon cellCommon5 = feedData.getCellCommon();
                        cellId = cellCommon5 != null ? cellCommon5.getCellId() : null;
                    }
                }
                s_visit_recordVar.srcId = cellId;
                s_visit_recordVar.busi_param = new HashMap();
                if (s_visit_recordVar.appid == 4 && (cellMedia = feedData.getCellMedia()) != null) {
                    if (cellMedia.getBatchId() == 0) {
                        Map<Integer, String> busi_param = s_visit_recordVar.busi_param;
                        Intrinsics.checkNotNullExpressionValue(busi_param, "busi_param");
                        busi_param.put(21, String.valueOf(cellMedia.getBatchId()));
                    } else {
                        Map<Integer, String> busi_param2 = s_visit_recordVar.busi_param;
                        Intrinsics.checkNotNullExpressionValue(busi_param2, "busi_param");
                        busi_param2.put(21, "");
                    }
                    if (!cellMedia.getMediaItems().isEmpty()) {
                        CommonMedia commonMedia = cellMedia.getMediaItems().get(0);
                        if (xd.c.s(commonMedia)) {
                            Map<Integer, String> busi_param3 = s_visit_recordVar.busi_param;
                            Intrinsics.checkNotNullExpressionValue(busi_param3, "busi_param");
                            CommonImage image = commonMedia.getImage();
                            busi_param3.put(2, image != null ? image.getLloc() : null);
                            Map<Integer, String> busi_param4 = s_visit_recordVar.busi_param;
                            Intrinsics.checkNotNullExpressionValue(busi_param4, "busi_param");
                            CommonImage image2 = commonMedia.getImage();
                            busi_param4.put(1, image2 != null ? image2.getSloc() : null);
                        } else {
                            Map<Integer, String> busi_param5 = s_visit_recordVar.busi_param;
                            Intrinsics.checkNotNullExpressionValue(busi_param5, "busi_param");
                            CommonVideo video = commonMedia.getVideo();
                            busi_param5.put(2, (video == null || (cover2 = video.getCover()) == null) ? null : cover2.getLloc());
                            Map<Integer, String> busi_param6 = s_visit_recordVar.busi_param;
                            Intrinsics.checkNotNullExpressionValue(busi_param6, "busi_param");
                            CommonVideo video2 = commonMedia.getVideo();
                            if (video2 != null && (cover = video2.getCover()) != null) {
                                r3 = cover.getSloc();
                            }
                            busi_param6.put(1, r3);
                        }
                    }
                }
                if (visitType != 6 || visitType == 7) {
                }
                e(s_visit_recordVar);
                return;
            }
        }
        j3 = 0;
        s_visit_recordVar.gameId = j3;
        if (s_visit_recordVar.appid != 4) {
        }
        s_visit_recordVar.srcId = cellId;
        s_visit_recordVar.busi_param = new HashMap();
        if (s_visit_recordVar.appid == 4) {
            if (cellMedia.getBatchId() == 0) {
            }
            if (!cellMedia.getMediaItems().isEmpty()) {
            }
        }
        if (visitType != 6) {
        }
    }

    public final void l(String feedUniKey) {
        FeedVistorReportRunnable feedVistorReportRunnable;
        if (feedUniKey == null || (feedVistorReportRunnable = this.mReportRunnableMap.get(feedUniKey)) == null) {
            return;
        }
        this.mHandler.removeCallbacks(feedVistorReportRunnable);
        this.mReportRunnableMap.remove(feedUniKey);
    }
}
