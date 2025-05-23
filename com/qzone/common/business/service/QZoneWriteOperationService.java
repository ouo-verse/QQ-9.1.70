package com.qzone.common.business.service;

import ADV_REPORT.mobile_adv_report_rsp;
import BOSSStrategyCenter.tAdvDesc;
import FEEDS_RECOM_REPORT.mobile_recom_report_rsp;
import FileUpload.cnst.kExtKeyMarkUinBeforeUpload;
import NS_MOBILE_BITMAP_4TH.bmp4_set_rsp;
import NS_MOBILE_DROPLIST.mobile_video_nag_feedback_rsp;
import NS_MOBILE_DROPLIST.nagative_fb_info;
import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import NS_MOBILE_EXTRA.mobile_get_urlinfo_rsp;
import NS_MOBILE_FEEDS.cnst.PROTO_EXT_TO_UGCSVR_FOR_FONT;
import NS_MOBILE_FEEDS.mobile_detail_actshuoshuo_rsp;
import NS_MOBILE_FEEDS.mobile_detail_rsp;
import NS_MOBILE_FEEDS.operation_click_button_rsp;
import NS_MOBILE_FEEDS.operation_del_icfeed_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_visit_hb_callback_rsp;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.operation_addcomment_rsp;
import NS_MOBILE_OPERATION.operation_addreply_rsp;
import NS_MOBILE_OPERATION.operation_delcomment_rsp;
import NS_MOBILE_OPERATION.operation_delreply_rsp;
import NS_MOBILE_OPERATION.operation_delugc_req;
import NS_MOBILE_OPERATION.operation_delugc_rsp;
import NS_MOBILE_OPERATION.operation_forward_rsp;
import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_MOBILE_OPERATION.operation_publishmessage_rsp;
import NS_MOBILE_OPERATION.operation_publishmood_rsp;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import NS_MOBILE_QUN.qun_add_comment_rsp;
import NS_MOBILE_QUN.quote_photo_universal_rsp;
import NS_MOBILE_QUN.qzone_quote_photo_from_qun_rsp;
import NS_UNDEAL_COUNT.clear_count_req;
import NS_UNDEAL_COUNT.clear_count_rsp;
import PROTO_EXT_TO_UGCSVR.Font;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.model.GifInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneQueryAlbumRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.Observable;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.common.protocol.request.QZoneAddCommentRequest;
import com.qzone.common.protocol.request.QZoneAddReplyRequest;
import com.qzone.common.protocol.request.QZoneAdvReportRequest;
import com.qzone.common.protocol.request.QZoneAutherRequest;
import com.qzone.common.protocol.request.QZoneDeleteMyFeedRequest;
import com.qzone.common.protocol.request.QZoneDropMenuRequest;
import com.qzone.common.protocol.request.QZoneForwardRequest;
import com.qzone.common.protocol.request.QZoneHighFivePassiveNotificationRequest;
import com.qzone.common.protocol.request.QZoneLikeRequest;
import com.qzone.common.protocol.request.QZoneNegativeFeedBackRequest;
import com.qzone.common.protocol.request.QZoneQunAddCommentRequest;
import com.qzone.common.protocol.request.QZoneRecomRecportRequest;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.protocol.request.QzoneClickBookButtonRequest;
import com.qzone.common.protocol.request.QzoneDeleteCommentRequest;
import com.qzone.common.protocol.request.QzoneDeleteDetailRequest;
import com.qzone.common.protocol.request.QzoneDeleteReplyRequest;
import com.qzone.common.protocol.request.QzoneDeleteSecretFeedRequest;
import com.qzone.common.protocol.request.QzoneDissRequest;
import com.qzone.common.protocol.request.QzoneMobileClientActionReportRequest;
import com.qzone.common.protocol.request.QzoneReportSecretFeedRequest;
import com.qzone.common.protocol.request.QzoneShieldSecretFeedRequest;
import com.qzone.common.protocol.request.QzoneUniversalRequest;
import com.qzone.common.protocol.request.QzoneclearFeedCountRequest;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.detail.business.protocol.QzoneGetFeedDetailRequest;
import com.qzone.feed.business.model.FeedHolidayCommentEvent;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.ICoverComponentService;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.protocol.QZoneGetUrlInfoRequest;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.QZonePicCommentTask;
import com.qzone.publish.business.task.QZoneQunUploadPicTask;
import com.qzone.publish.business.task.QZoneQunUploadVideoTask;
import com.qzone.publish.business.task.QZoneUploadAlbumVideoTask;
import com.qzone.publish.business.task.QZoneUploadPicTask;
import com.qzone.publish.business.task.QZoneUploadShuoShuoTask;
import com.qzone.publish.business.task.QZoneUploadVideoCoverTask;
import com.qzone.publish.business.task.QzoneQuotePicFromAIOToQZoneTask;
import com.qzone.publish.business.task.QzoneQuotePicFromQunTask;
import com.qzone.publish.business.task.QzoneQuoteQunPicTask;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.qzone.publish.service.RemoteVideoServiceHandler;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.feedx.util.aa;
import com.qzone.reborn.repair.utils.QZonePhotoRepairUploadManger;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.al;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.qzone.widget.x;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.ditto.area.DittoHost;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.pubaccount.publish.PubAccountTaskQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.model.Size;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWriteOperationService extends Observable implements IQZoneServiceListener {
    private static final al<QZoneWriteOperationService, Void> D = new d();
    private List<n> C;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f45604d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, Long> f45605e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, Long> f45606f;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f45607h;

    /* renamed from: i, reason: collision with root package name */
    private HashSet<String> f45608i;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, String> f45609m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements DialogInterface.OnClickListener {
        final /* synthetic */ Map C;
        final /* synthetic */ boolean D;
        final /* synthetic */ BusinessFeedData E;
        final /* synthetic */ boolean F;
        final /* synthetic */ int G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f45627d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f45628e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Handler f45629f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45630h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f45631i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f45632m;

        b(long j3, int i3, Handler handler, String str, int i16, boolean z16, Map map, boolean z17, BusinessFeedData businessFeedData, boolean z18, int i17) {
            this.f45627d = j3;
            this.f45628e = i3;
            this.f45629f = handler;
            this.f45630h = str;
            this.f45631i = i16;
            this.f45632m = z16;
            this.C = map;
            this.D = z17;
            this.E = businessFeedData;
            this.F = z18;
            this.G = i17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneWriteOperationService.this.o2(this.f45627d, this.f45628e, this.f45629f, this.f45630h, this.f45631i, this.f45632m, this.C, this.D, this.E, this.F, this.G);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d extends al<QZoneWriteOperationService, Void> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneWriteOperationService a(Void r16) {
            return new QZoneWriteOperationService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f45688a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Looper looper, q qVar) {
            super(looper);
            this.f45688a = qVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j3;
            QZoneResult unpack;
            if (message.what != 1000027) {
                return;
            }
            Object obj = message.obj;
            if (obj != null && (obj instanceof QZoneTask)) {
                ((QZoneTask) obj).extraData.put("RequestValidBit", Boolean.FALSE);
            }
            removeMessages(1000027);
            Object obj2 = message.obj;
            if (obj2 == null || !(obj2 instanceof QZoneResult) || (unpack = QZoneResult.unpack(message)) == null || !unpack.getSucceed()) {
                j3 = 0;
            } else {
                Object data = unpack.getData();
                j3 = data != null ? ((Long) data).longValue() : 0L;
                if (QZLog.isColorLevel()) {
                    QZLog.i("upload2_QZoneWriteOperationService", 2, "server time=" + j3);
                }
            }
            if (j3 == 0) {
                QZLog.w("upload2_QZoneWriteOperationService", "server time return error");
                j3 = System.currentTimeMillis() / 1000;
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("upload2_QZoneWriteOperationService", 2, "uploadPic.svrtime--" + j3 + ",time=" + (System.currentTimeMillis() / 1000));
            }
            this.f45688a.a(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f45690a;

        i(q qVar) {
            this.f45690a = qVar;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            BusinessAlbumInfo businessAlbumInfo;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (sVar.getData() instanceof QZoneQueryAlbumRequest.a) {
                QZoneQueryAlbumRequest.a aVar = (QZoneQueryAlbumRequest.a) sVar.getData();
                if (sVar.getSucceed() && (businessAlbumInfo = aVar.f43973b) != null) {
                    currentTimeMillis = businessAlbumInfo.mSvrTime;
                    if (QZLog.isColorLevel()) {
                        QZLog.i("upload2_QZoneWriteOperationService", 2, "server time=" + currentTimeMillis);
                    }
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("upload2_QZoneWriteOperationService", 2, "uploadPic.svrtime--" + currentTimeMillis + ",time=" + (System.currentTimeMillis() / 1000));
            }
            this.f45690a.a(currentTimeMillis);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class j implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45692a;

        j(long j3) {
            this.f45692a = j3;
        }

        @Override // com.qzone.common.business.service.QZoneWriteOperationService.q
        public void a(long j3) {
            com.qzone.publish.business.publishqueue.h.c(this.f45692a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public long f45694a;

        /* renamed from: b, reason: collision with root package name */
        public User f45695b;

        /* renamed from: c, reason: collision with root package name */
        public String f45696c;

        /* renamed from: d, reason: collision with root package name */
        public String f45697d;

        /* renamed from: e, reason: collision with root package name */
        public String f45698e;

        /* renamed from: f, reason: collision with root package name */
        public String f45699f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f45700g;

        /* renamed from: h, reason: collision with root package name */
        public int f45701h;

        /* renamed from: i, reason: collision with root package name */
        public Map<Integer, String> f45702i;

        /* renamed from: j, reason: collision with root package name */
        public String f45703j;

        /* renamed from: k, reason: collision with root package name */
        public String f45704k;

        /* renamed from: l, reason: collision with root package name */
        public int f45705l;

        /* renamed from: m, reason: collision with root package name */
        public CustomPraiseData f45706m = null;

        /* renamed from: n, reason: collision with root package name */
        public int f45707n = 1;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public String f45708a;

        /* renamed from: b, reason: collision with root package name */
        public String f45709b;

        /* renamed from: c, reason: collision with root package name */
        public String f45710c;

        /* renamed from: d, reason: collision with root package name */
        public String f45711d;

        /* renamed from: e, reason: collision with root package name */
        public int f45712e;

        /* renamed from: f, reason: collision with root package name */
        public long f45713f;

        /* renamed from: g, reason: collision with root package name */
        public String f45714g;

        /* renamed from: h, reason: collision with root package name */
        public String f45715h;

        /* renamed from: i, reason: collision with root package name */
        public String f45716i;

        /* renamed from: j, reason: collision with root package name */
        public int f45717j;

        /* renamed from: k, reason: collision with root package name */
        public Map<Integer, String> f45718k;

        /* renamed from: m, reason: collision with root package name */
        public PictureItem f45720m;

        /* renamed from: o, reason: collision with root package name */
        public String f45722o;

        /* renamed from: p, reason: collision with root package name */
        public int f45723p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f45724q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f45725r;

        /* renamed from: s, reason: collision with root package name */
        public ArrayList<String> f45726s;

        /* renamed from: t, reason: collision with root package name */
        public int f45727t;

        /* renamed from: u, reason: collision with root package name */
        public int f45728u;

        /* renamed from: v, reason: collision with root package name */
        public String f45729v;

        /* renamed from: w, reason: collision with root package name */
        public Map<String, String> f45730w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f45731x;

        /* renamed from: y, reason: collision with root package name */
        public BusinessFeedData f45732y;

        /* renamed from: z, reason: collision with root package name */
        public int f45733z;

        /* renamed from: l, reason: collision with root package name */
        public String f45719l = "";

        /* renamed from: n, reason: collision with root package name */
        public int f45721n = 1;
        public boolean A = false;
        public String B = "";

        public static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Matcher matcher = x.f61175e.matcher(str);
                String str2 = str;
                while (matcher.find()) {
                    str2 = str2.replace(matcher.group(), URLDecoder.decode(str.substring(str.indexOf(",text:", matcher.start()) + 6, matcher.end() - 1), "UTF-8"));
                }
                return str2;
            } catch (Exception e16) {
                QZLog.e("Comment", "parse CopyableText error! comment:" + str, e16);
                return str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public String f45734a;

        /* renamed from: b, reason: collision with root package name */
        public String f45735b;

        /* renamed from: c, reason: collision with root package name */
        public String f45736c;

        /* renamed from: d, reason: collision with root package name */
        public String f45737d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f45738e;

        /* renamed from: f, reason: collision with root package name */
        public int f45739f;

        /* renamed from: g, reason: collision with root package name */
        public Map<Integer, String> f45740g;

        /* renamed from: i, reason: collision with root package name */
        public int f45742i;

        /* renamed from: j, reason: collision with root package name */
        public String f45743j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f45744k;

        /* renamed from: m, reason: collision with root package name */
        public int f45746m;

        /* renamed from: q, reason: collision with root package name */
        public boolean f45750q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f45751r;

        /* renamed from: t, reason: collision with root package name */
        public Map<String, String> f45753t;

        /* renamed from: u, reason: collision with root package name */
        public BusinessFeedData f45754u;

        /* renamed from: v, reason: collision with root package name */
        public int f45755v;

        /* renamed from: x, reason: collision with root package name */
        public boolean f45757x;

        /* renamed from: y, reason: collision with root package name */
        public PolymorphicPraiseEmotionData f45758y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f45759z;

        /* renamed from: h, reason: collision with root package name */
        public int f45741h = 1;

        /* renamed from: l, reason: collision with root package name */
        public int f45745l = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f45747n = 0;

        /* renamed from: o, reason: collision with root package name */
        public CustomPraiseData f45748o = null;

        /* renamed from: p, reason: collision with root package name */
        public int f45749p = 1;

        /* renamed from: s, reason: collision with root package name */
        public long f45752s = 0;

        /* renamed from: w, reason: collision with root package name */
        public int f45756w = -1;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface n {
        void i3(String str, String str2, boolean z16, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public String f45760a;

        /* renamed from: b, reason: collision with root package name */
        public String f45761b;

        /* renamed from: c, reason: collision with root package name */
        public String f45762c;

        /* renamed from: d, reason: collision with root package name */
        public String f45763d;

        /* renamed from: e, reason: collision with root package name */
        public String f45764e;

        /* renamed from: f, reason: collision with root package name */
        public long f45765f;

        /* renamed from: g, reason: collision with root package name */
        public User f45766g;

        /* renamed from: h, reason: collision with root package name */
        public String f45767h;

        /* renamed from: i, reason: collision with root package name */
        public Map<String, String> f45768i;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class p {

        /* renamed from: c, reason: collision with root package name */
        public int f45771c;

        /* renamed from: e, reason: collision with root package name */
        public long f45773e;

        /* renamed from: f, reason: collision with root package name */
        public String f45774f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<String> f45775g;

        /* renamed from: v, reason: collision with root package name */
        public Map<String, ArrayList<String>> f45790v;

        /* renamed from: a, reason: collision with root package name */
        public String f45769a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f45770b = null;

        /* renamed from: d, reason: collision with root package name */
        public int f45772d = 0;

        /* renamed from: h, reason: collision with root package name */
        public String f45776h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f45777i = null;

        /* renamed from: j, reason: collision with root package name */
        public String f45778j = null;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<String> f45779k = null;

        /* renamed from: l, reason: collision with root package name */
        public int f45780l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f45781m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f45782n = 0;

        /* renamed from: o, reason: collision with root package name */
        public String f45783o = null;

        /* renamed from: p, reason: collision with root package name */
        public int f45784p = 7;

        /* renamed from: q, reason: collision with root package name */
        public int f45785q = -1;

        /* renamed from: r, reason: collision with root package name */
        public Map<Integer, String> f45786r = null;

        /* renamed from: s, reason: collision with root package name */
        public String f45787s = null;

        /* renamed from: t, reason: collision with root package name */
        public boolean f45788t = false;

        /* renamed from: u, reason: collision with root package name */
        public boolean f45789u = false;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface q {
        void a(long j3);
    }

    QZoneWriteOperationService() {
        super("WriteOperation");
        this.f45604d = new HashMap<>();
        this.f45605e = new HashMap<>();
        this.f45606f = new HashMap<>();
        this.f45607h = new HashMap<>();
        this.f45608i = new HashSet<>();
        this.f45609m = new HashMap<>();
        this.C = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(QZoneTask qZoneTask) {
        HashMap hashMap;
        String str = qZoneTask.clientKey;
        if (TextUtils.isEmpty(str)) {
            QZLog.w("upload2_QZoneWriteOperationService", "onMulitPicShuoShuo ,localkey is empty!");
            return;
        }
        QZLog.i("upload2_QZoneWriteOperationService", "start get fake feed, fakeKey:" + qZoneTask.clientKey);
        boolean z16 = qZoneTask instanceof QZoneUploadShuoShuoTask;
        if (z16) {
            hashMap = (HashMap) ((QZoneUploadShuoShuoTask) qZoneTask).getLocalUrlMap();
        } else {
            hashMap = (HashMap) qZoneTask.getParameter("loacal_url_map");
        }
        HashMap hashMap2 = hashMap;
        QZoneTask qZoneTask2 = new QZoneTask(new QzoneGetFeedDetailRequest(LoginData.getInstance().getUin(), 311, str, qZoneTask.taskRetryCount), null, this, 39);
        qZoneTask2.clientKey = str;
        qZoneTask2.taskRetryCount = qZoneTask.taskRetryCount + 1;
        if (z16) {
            qZoneTask2.addParameter("shuoshuo_video_info", ((QZoneUploadShuoShuoTask) qZoneTask).getVideoInfo());
        } else if (qZoneTask.getParameter("shuoshuo_video_info") != null) {
            qZoneTask2.addParameter("shuoshuo_video_info", qZoneTask.getParameter("shuoshuo_video_info"));
        }
        if (hashMap2 != null) {
            qZoneTask2.addParameter("loacal_url_map", hashMap2);
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask2);
    }

    private void A1(final QZoneTask qZoneTask) {
        int i3;
        if (QZLog.isColorLevel()) {
            QZLog.i("upload2_QZoneWriteOperationService", 2, "Dynamic[publish2]QZoneWriteOperationService true feed done");
        }
        if (qZoneTask == null) {
            return;
        }
        if (qZoneTask.succeeded()) {
            String str = qZoneTask.clientKey;
            mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) qZoneTask.mRequest.rsp;
            if (mobile_detail_rspVar != null && mobile_detail_rspVar.detail_data != null) {
                QZLog.i("upload2_QZoneWriteOperationService", "get fake feed succeed, fakeKey:" + qZoneTask.clientKey);
                BusinessFeedData createFrom = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
                createFrom.getLocalInfo().setHalfReal();
                createFrom.feedType = 4097;
                createFrom.getFeedCommInfo().clientkey = qZoneTask.clientKey;
                a2((HashMap) qZoneTask.getParameter("loacal_url_map"), createFrom);
                ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) qZoneTask.getParameter("shuoshuo_video_info");
                if (shuoshuoVideoInfo != null && createFrom.getVideoInfo() != null && !TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
                    createFrom.getVideoInfo().videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
                }
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().preCalculateData(createFrom, true);
                notify(2, str, createFrom);
                ((IWinkAPI) QRoute.api(IWinkAPI.class)).notifyZoneWriteOperation(2);
                return;
            }
        }
        UniAttribute uniAttribute = qZoneTask.mUniAttr;
        if (uniAttribute != null && uniAttribute.containsKey("retry_time_interval") && qZoneTask.mUniAttr.get("retry_time_interval") != null) {
            int parseInt = Integer.parseInt(qZoneTask.mUniAttr.get("retry_time_interval").toString());
            QZLog.e("upload2_QZoneWriteOperationService", 1, "get fake feed fail, errorCode:" + qZoneTask.mResultCode + ", errormsg:" + qZoneTask.f45835msg + ", retryCount:" + qZoneTask.taskRetryCount + ", next retry time:" + parseInt + ", fakeKey:" + qZoneTask.clientKey);
            if (parseInt > 0) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.13
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneWriteOperationService.this.A0(qZoneTask);
                    }
                }, parseInt * 1000);
                return;
            }
        }
        String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT).split("/");
        if (split == null || (i3 = qZoneTask.taskRetryCount) > split.length) {
            return;
        }
        int parseInt2 = Integer.parseInt(split[i3 - 1]);
        QZLog.i("upload2_QZoneWriteOperationService", 1, "get fake feed fail(timeout), next retry time:" + parseInt2 + ", fakeKey:" + qZoneTask.clientKey);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.14
            @Override // java.lang.Runnable
            public void run() {
                QZoneWriteOperationService.this.A0(qZoneTask);
            }
        }, (long) (parseInt2 * 1000));
    }

    private void C1(QZoneTask qZoneTask) {
        ArrayList<String> arrayList;
        if (qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000052);
        quote_photo_universal_rsp quote_photo_universal_rspVar = (quote_photo_universal_rsp) qZoneTask.mRequest.rsp;
        if (quote_photo_universal_rspVar != null && (arrayList = quote_photo_universal_rspVar.url) != null && arrayList.size() > 0) {
            result.setData(arrayList);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void E0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        mobile_recom_report_rsp mobile_recom_report_rspVar = (mobile_recom_report_rsp) qZoneTask.mRequest.rsp;
        if (mobile_recom_report_rspVar == null || mobile_recom_report_rspVar.ret_code != 0) {
            QZLog.e("[publish2]QZoneWriteOperationService", "onTaskResponse TASK_TYPE_ADV_FEEDBACK wrong");
        }
    }

    private void E1(QZoneTask qZoneTask) {
        if (qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000130);
        mobile_sub_concern_rsp mobile_sub_concern_rspVar = (mobile_sub_concern_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_concern_rspVar == null || mobile_sub_concern_rspVar.ret != 0) {
            result.setSucceed(false);
            if (mobile_sub_concern_rspVar != null) {
                qZoneTask.mResultCode = mobile_sub_concern_rspVar.ret;
            }
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isSpecialFollow")).booleanValue();
        ((Long) qZoneTask.getParameter("uin")).longValue();
        int intValue = ((Integer) qZoneTask.getParameter("position")).intValue();
        BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feedData");
        if (result.getSucceed()) {
            ToastUtil.k(true, booleanValue);
            if (businessFeedData.getFeedCommInfo() != null) {
                businessFeedData.getFeedCommInfo().isSpecialFollowed = booleanValue;
            }
        }
        result.getBundle().putBoolean("iSpecialFollow", booleanValue);
        result.getBundle().putLong("uin", ((Long) qZoneTask.getParameter("uin")).longValue());
        result.getBundle().putInt("position", intValue);
        qZoneTask.sendResultMsg(result);
        if (result.getSucceed()) {
            Object[] objArr = new Object[4];
            objArr[0] = businessFeedData != null ? businessFeedData.getFeedCommInfo().ugckey : null;
            objArr[1] = Boolean.valueOf(booleanValue);
            objArr[2] = (Long) qZoneTask.getParameter("uin");
            objArr[3] = (Boolean) qZoneTask.getParameter("isForward");
            notify(67, objArr);
        }
    }

    private void F0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            mobile_adv_report_rsp mobile_adv_report_rspVar = (mobile_adv_report_rsp) jceStruct;
            if (mobile_adv_report_rspVar.ret_code != 0) {
                QZLog.w("adv_report", "report failed: code = " + mobile_adv_report_rspVar.ret_code + ", msg = " + mobile_adv_report_rspVar.error_msg);
                return;
            }
            return;
        }
        QZLog.w("adv_report", "report failed: rsp is NULL!");
    }

    private QZoneResult G0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            operation_click_button_rsp operation_click_button_rspVar = (operation_click_button_rsp) jceStruct;
            qZoneTask.mResultCode = operation_click_button_rspVar.iRet;
            String str = (String) qZoneTask.getParameter(s4.c.UGCKEY);
            boolean z16 = operation_click_button_rspVar.iRet == 0;
            notify(74, Boolean.valueOf(z16), str, operation_click_button_rspVar.strButtonText);
            if (z16) {
                ToastUtil.s(operation_click_button_rspVar.strToastText, 5);
            } else {
                ToastUtil.s(operation_click_button_rspVar.strToastText, 4);
            }
            if (!TextUtils.isEmpty(operation_click_button_rspVar.strJumpUrl)) {
                yo.d.d(operation_click_button_rspVar.strJumpUrl, FeedGlobalEnv.getContext(), "");
            }
        }
        return qZoneTask.getResult(1000401);
    }

    private void H0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        clear_count_rsp clear_count_rspVar = (clear_count_rsp) qZoneRequest.rsp;
        if (clear_count_rspVar != null) {
            if (clear_count_rspVar.ret != 0) {
                QZLog.e("[publish2]QZoneWriteOperationService", "onTaskResponse TASK_TYPE_CLEAR_FEED_COUNT wrong" + clear_count_rspVar.f25069msg);
                str = ((clear_count_req) qZoneTask.mRequest.req).LastUndealCountTime;
            } else {
                str = "";
            }
        } else {
            str = ((clear_count_req) qZoneRequest.req).LastUndealCountTime;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LocalMultiProcConfig.putString4Uin("qzone_passive_undeal_readtime", str, LoginData.getInstance().getUin());
    }

    private QZoneResult K0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            qZoneTask.mResultCode = ((operation_delcomment_rsp) jceStruct).iRet;
            qZoneTask.f45835msg = ((operation_delcomment_rsp) jceStruct).strErrMsg;
        }
        if (qZoneTask.getParameter(s4.c.UGCKEY) != null) {
            str = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        } else {
            str = "";
        }
        int intValue = qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0;
        QZoneResult result = qZoneTask.getResult(999978);
        result.getBundle().putBoolean(QZoneResult.KEY_IS_DEL_COMMENT, true);
        notify(40, str, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode));
        return result;
    }

    private QZoneResult L0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            qZoneTask.mResultCode = ((operation_delugc_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_delugc_rsp) jceStruct).f25014msg;
        }
        if (qZoneTask.mResultCode == 0) {
            if (qZoneTask.extraData.get("deleteType").equals("delete_photo")) {
                notify(18, (String) qZoneTask.getParameter("albumid"), (String) qZoneTask.getParameter("lloc"));
            } else if (qZoneTask.extraData.get("deleteType").equals("delete_photo_video")) {
                notify(47, (String) qZoneTask.getParameter("albumid"), (String) qZoneTask.getParameter("lloc"));
            } else if (qZoneTask.extraData.get("deleteType").equals("delete_album")) {
                notify(34, (String) qZoneTask.getParameter("albumid"));
            }
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if (qZoneRequest != null) {
                JceStruct jceStruct2 = qZoneRequest.req;
                if (jceStruct2 instanceof operation_delugc_req) {
                    String str = ((operation_delugc_req) jceStruct2).clientKey;
                    QLog.i("[publish2]QZoneWriteOperationService", 1, "[handleDeleteFeedTaskResponse] clientKey = " + str);
                    FeedManager.addDeletedFakeFeedClientKey(str);
                }
            }
        }
        qZoneTask.ugcKey = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        return qZoneTask.getResult(999909);
    }

    private QZoneResult M0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            operation_delugc_rsp operation_delugc_rspVar = (operation_delugc_rsp) jceStruct;
            int i3 = operation_delugc_rspVar.ret;
            qZoneTask.mResultCode = i3;
            qZoneTask.f45835msg = operation_delugc_rspVar.f25014msg;
            if (i3 == 0) {
                notify(23, new Object[0]);
            }
        }
        return qZoneTask.getResult(1000087);
    }

    private QZoneResult N0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            qZoneTask.mResultCode = ((operation_del_icfeed_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_del_icfeed_rsp) jceStruct).f24990msg;
        }
        return qZoneTask.getResult(999909);
    }

    private void O0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
        }
        QZoneResult result = qZoneTask.getResult(999909);
        Object parameter = qZoneTask.getParameter(s4.c.UGCKEY);
        if ((parameter instanceof String) && result.getSucceed()) {
            notify(8, parameter, "");
        }
    }

    private QZoneResult P0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            qZoneTask.mResultCode = ((operation_delreply_rsp) jceStruct).iRet;
            qZoneTask.f45835msg = ((operation_delreply_rsp) jceStruct).strErrMsg;
        }
        if (qZoneTask.getParameter(s4.c.UGCKEY) != null) {
            str = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        } else {
            str = "";
        }
        int intValue = qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0;
        QZoneResult result = qZoneTask.getResult(999978);
        result.getBundle().putBoolean(QZoneResult.KEY_IS_DEL_COMMENT, false);
        notify(41, str, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode));
        return result;
    }

    private QZoneResult Q0(QZoneTask qZoneTask) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            operation_delugc_rsp operation_delugc_rspVar = (operation_delugc_rsp) jceStruct;
            int i3 = operation_delugc_rspVar.ret;
            qZoneTask.mResultCode = i3;
            qZoneTask.f45835msg = operation_delugc_rspVar.f25014msg;
            if (i3 == 0) {
                String str = (String) qZoneTask.getParameter("story_feed_id");
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent();
                    intent.setAction("intent_filter_delete_feed_action");
                    intent.putExtra("key_story_feed_id", str);
                    BaseApplication.getContext().sendBroadcast(intent);
                }
            }
        }
        return qZoneTask.getResult(999909);
    }

    private QZoneResult R0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (((QzoneDissRequest) qZoneRequest).rsp != null) {
            JceStruct jceStruct = qZoneRequest.rsp;
            qZoneTask.mResultCode = ((operation_like_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_like_rsp) jceStruct).f25017msg;
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isLike")).booleanValue();
        notify(71, (String) qZoneTask.getParameter(s4.c.UGCKEY), Boolean.valueOf(booleanValue), (String) qZoneTask.getParameter("uniKey"), Integer.valueOf(qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(qZoneTask.getParameter("clickScene") != null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1));
        QZoneResult result = qZoneTask.getResult(999906);
        JceStruct jceStruct2 = qZoneTask.mRequest.rsp;
        if (jceStruct2 != null && ((operation_like_rsp) jceStruct2).ret == 0 && qZoneTask.getParameter("feeddata") != null && qZoneTask.getParameter("feedtype") != null) {
            BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feeddata");
            if (((Integer) qZoneTask.getParameter("feedtype")).intValue() == 4097 && booleanValue) {
                ToastUtil.f(businessFeedData);
            }
        }
        return result;
    }

    private void T0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        String str2;
        boolean z16;
        JceStruct jceStruct;
        String str3;
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        JceStruct jceStruct2 = qZoneRequest.req;
        String str4 = "";
        if (jceStruct2 == null || (jceStruct = qZoneRequest.rsp) == null) {
            str = "";
            str2 = str;
        } else {
            mobile_get_urlinfo_req mobile_get_urlinfo_reqVar = (mobile_get_urlinfo_req) jceStruct2;
            mobile_get_urlinfo_rsp mobile_get_urlinfo_rspVar = (mobile_get_urlinfo_rsp) jceStruct;
            if (TextUtils.isEmpty(mobile_get_urlinfo_reqVar.url)) {
                str3 = "";
            } else {
                str3 = mobile_get_urlinfo_reqVar.url;
            }
            if (TextUtils.isEmpty(mobile_get_urlinfo_rspVar.title)) {
                str2 = "";
            } else {
                str2 = mobile_get_urlinfo_rspVar.title;
            }
            ArrayList<String> arrayList = mobile_get_urlinfo_rspVar.images;
            if (arrayList != null && arrayList.size() > 0) {
                str4 = mobile_get_urlinfo_rspVar.images.get(0);
            }
            if (!str3.equals(str2.trim())) {
                str = str4;
                str4 = str3;
                z16 = true;
                notify(35, Boolean.valueOf(z16), str4, str2, str);
            }
            str = str4;
            str4 = str3;
        }
        z16 = false;
        notify(35, Boolean.valueOf(z16), str4, str2, str);
    }

    private QZoneResult V0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (((QZoneLikeRequest) qZoneRequest).rsp != null) {
            JceStruct jceStruct = qZoneRequest.rsp;
            qZoneTask.mResultCode = ((operation_like_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_like_rsp) jceStruct).f25017msg;
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isLike")).booleanValue();
        notify(59, (String) qZoneTask.getParameter(s4.c.UGCKEY), (String) qZoneTask.getParameter("feedkey"), (String) qZoneTask.getParameter("uniKey"), Boolean.valueOf(qZoneTask.succeeded()), Integer.valueOf(qZoneTask.mResultCode), (String) qZoneTask.getParameter("comment_id"), Boolean.valueOf(booleanValue), Integer.valueOf(((Integer) qZoneTask.getParameter("clickScene")).intValue()));
        return qZoneTask.getResult(1000185);
    }

    private QZoneResult W0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (((QZoneLikeRequest) qZoneRequest).rsp != null) {
            JceStruct jceStruct = qZoneRequest.rsp;
            qZoneTask.mResultCode = ((operation_like_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_like_rsp) jceStruct).f25017msg;
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isLike")).booleanValue();
        notify(7, (String) qZoneTask.getParameter(s4.c.UGCKEY), Boolean.valueOf(booleanValue), (String) qZoneTask.getParameter("uniKey"), Integer.valueOf(qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(qZoneTask.getParameter("clickScene") != null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1));
        QZoneResult result = qZoneTask.getResult(999906);
        JceStruct jceStruct2 = qZoneTask.mRequest.rsp;
        if (jceStruct2 != null && ((operation_like_rsp) jceStruct2).ret == 0 && qZoneTask.getParameter("feeddata") != null && qZoneTask.getParameter("feedtype") != null) {
            BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feeddata");
            if (((Integer) qZoneTask.getParameter("feedtype")).intValue() == 4097 && booleanValue) {
                ToastUtil.f(businessFeedData);
            }
        }
        return result;
    }

    private QZoneResult X0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (((QZoneLikeRequest) qZoneRequest).rsp != null) {
            JceStruct jceStruct = qZoneRequest.rsp;
            qZoneTask.mResultCode = ((operation_like_rsp) jceStruct).ret;
            qZoneTask.f45835msg = ((operation_like_rsp) jceStruct).f25017msg;
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isLike")).booleanValue();
        notify(69, (String) qZoneTask.getParameter(s4.c.UGCKEY), (String) qZoneTask.getParameter("feedkey"), (String) qZoneTask.getParameter("uniKey"), Boolean.valueOf(qZoneTask.succeeded()), Integer.valueOf(qZoneTask.mResultCode), (String) qZoneTask.getParameter("comment_id"), (String) qZoneTask.getParameter("reply_id"), Boolean.valueOf(booleanValue), Integer.valueOf(((Integer) qZoneTask.getParameter("clickScene")).intValue()));
        return qZoneTask.getResult(1000185);
    }

    public static String Y1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("sid=");
        int length = str.length();
        if (indexOf < 0) {
            return str;
        }
        int i3 = indexOf - 1;
        if (i3 > 0) {
            String str2 = str.charAt(i3) + "";
            if (!str2.equals("#") && !str2.equals(ContainerUtils.FIELD_DELIMITER) && !str2.equals("/") && !str2.equals(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str;
            }
        }
        int indexOf2 = str.indexOf("#", indexOf);
        if (indexOf2 != -1 && indexOf2 < length) {
            length = indexOf2 + 1;
        }
        int indexOf3 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
        if (indexOf3 != -1 && indexOf3 < length) {
            length = indexOf3 + 1;
        }
        int indexOf4 = str.indexOf("/", indexOf);
        if (indexOf4 != -1 && indexOf4 < length) {
            length = indexOf4 + 1;
        }
        int indexOf5 = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, indexOf);
        if (indexOf5 != -1 && indexOf5 < length) {
            length = indexOf5 + 1;
        }
        return str.replace(str.substring(indexOf, length), "");
    }

    private void Z0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        String str2 = qZoneTask.clientKey;
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null && (jceStruct instanceof operation_publishmessage_rsp)) {
            operation_publishmessage_rsp operation_publishmessage_rspVar = (operation_publishmessage_rsp) jceStruct;
            qZoneTask.mResultCode = operation_publishmessage_rspVar.ret;
            qZoneTask.f45835msg = operation_publishmessage_rspVar.f25019msg;
            str = operation_publishmessage_rspVar.tid;
        } else {
            str = "";
        }
        notify(22, str2, str, qZoneTask.getResult(999904));
    }

    private void c1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        if (qZoneTask.succeeded()) {
            QZoneQunUploadPicTask qZoneQunUploadPicTask = (QZoneQunUploadPicTask) qZoneTask;
            notify(25, qZoneQunUploadPicTask.getQunCode(), qZoneQunUploadPicTask.getAlbumId(), qZoneTask.clientKey, y0(qZoneTask, (HashMap) qZoneQunUploadPicTask.getLocalUrlMap(), 4097));
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastUploadSuccess", "\u4e0a\u4f20\u6210\u529f"), 5);
            return;
        }
        ToastUtil.s(qZoneTask.f45835msg, 4);
    }

    private void d1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            qzone_quote_photo_from_qun_rsp qzone_quote_photo_from_qun_rspVar = (qzone_quote_photo_from_qun_rsp) jceStruct;
            qZoneTask.mResultCode = qzone_quote_photo_from_qun_rspVar.ret;
            qZoneTask.f45835msg = qzone_quote_photo_from_qun_rspVar.f25046msg;
        }
    }

    private void e1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str = (String) qZoneTask.getParameter(v4.a.QUNID);
        String str2 = (String) qZoneTask.getParameter("albumid");
        BusinessFeedData y06 = y0(qZoneTask, (HashMap) ((QzoneQuoteQunPicTask) qZoneTask).getLocalUrlMap(), 4097);
        String str3 = qZoneTask.clientKey;
        if (qZoneTask.succeeded()) {
            notify(28, str, str2, str3, y06);
        }
    }

    private QZoneResult f1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        String str2;
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            operation_addreply_rsp operation_addreply_rspVar = (operation_addreply_rsp) jceStruct;
            qZoneTask.mResultCode = operation_addreply_rspVar.ret;
            qZoneTask.f45835msg = operation_addreply_rspVar.f25011msg;
            str = operation_addreply_rspVar.replyid;
            str2 = operation_addreply_rspVar.replyLikeKey;
        } else {
            str = null;
            str2 = "";
        }
        String str3 = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        notify(20, str3, (String) qZoneTask.getParameter("uniKey"), Boolean.valueOf(qZoneTask.succeeded()), (String) qZoneTask.getParameter("comment_id"), (String) qZoneTask.getParameter("feedkey"), str, Integer.valueOf(qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(qZoneTask.getParameter("clickScene") != null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1), str2);
        if (qZoneTask.mResultCode != 0) {
            QZLog.e("[publish2]QZoneWriteOperationService", "handleReplayFeedTaskResponse resultCode: " + qZoneTask.mResultCode + " msg:" + qZoneTask.f45835msg);
        }
        Integer num = (Integer) qZoneTask.getParameter("src_refer");
        if (num != null && num.intValue() == 2) {
            notify(48, Boolean.valueOf(qZoneTask.succeeded()), Integer.valueOf(qZoneTask.mResultCode), (String) qZoneTask.getParameter("albumid"), (String) qZoneTask.getParameter("lloc"), str3);
        }
        return qZoneTask.getResult(999907);
    }

    private QZoneResult h1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        if (jceStruct != null) {
            operation_publishmood_rsp operation_publishmood_rspVar = (operation_publishmood_rsp) jceStruct;
            int i3 = operation_publishmood_rspVar.ret;
            qZoneTask.mResultCode = i3;
            qZoneTask.f45835msg = operation_publishmood_rspVar.f25020msg;
            if (i3 == 0) {
                String str2 = (String) qZoneTask.getParameter(s4.c.UGCKEY);
                Integer num = (Integer) qZoneTask.getParameter("privType");
                byte a16 = com.qzone.proxy.feedcomponent.util.m.a(num.intValue());
                if (num.intValue() != 1) {
                    str = com.qzone.feed.utils.h.f(num.intValue());
                } else {
                    str = "";
                }
                N1(str2, str, a16);
            }
        }
        return qZoneTask.getResult(1000400);
    }

    private void i1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        mobile_recom_report_rsp mobile_recom_report_rspVar = (mobile_recom_report_rsp) qZoneTask.mRequest.rsp;
        if (mobile_recom_report_rspVar == null || mobile_recom_report_rspVar.ret_code != 0) {
            QZLog.e("[publish2]QZoneWriteOperationService", "onTaskResponse TASK_TYPE_SPECIAL_CARE_IN_CONTAINER_EXPOSURE wrong");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str, int i3, List<MediaWrapper> list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, long j3, long j16, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i16, int i17, String str3, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList, String str4) {
        Map<String, byte[]> map4;
        Map<String, String> map5;
        com.qzone.publish.business.task.b bVar;
        String str5;
        long j17;
        Map<String, byte[]> map6;
        com.qzone.publish.business.task.b bVar2;
        String str6;
        List<MediaWrapper> list2 = list;
        long j18 = j3;
        Map<String, String> map7 = map3;
        if (list2 == null || list.size() <= 0) {
            return;
        }
        com.qzone.publish.business.publishqueue.h.a(j18, list.size());
        String w06 = w0(poiInfo);
        com.qzone.publish.business.task.b bVar3 = new com.qzone.publish.business.task.b(list, w06, j16, businessAlbumInfo, map2);
        long j19 = j16;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < list.size(); i26++) {
            if (j19 != 0) {
                j19--;
            }
            MediaWrapper mediaWrapper = list2.get(i26);
            if (mediaWrapper.isImage()) {
                i18++;
            } else if (mediaWrapper.isVideo()) {
                i19++;
            }
        }
        long j26 = j19;
        int i27 = 0;
        Map<String, byte[]> map8 = map2;
        while (i27 < list.size()) {
            if (j26 != 0) {
                j26--;
            }
            MediaWrapper mediaWrapper2 = list2.get(i27);
            if (mediaWrapper2 != null) {
                if (mediaWrapper2.isImage()) {
                    ImageInfo imageInfo = mediaWrapper2.getImageInfo();
                    map4 = map8;
                    bVar2 = bVar3;
                    str6 = w06;
                    map5 = map7;
                    QZoneQunUploadPicTask qZoneQunUploadPicTask = new QZoneQunUploadPicTask(i3, imageInfo.panoramaType, imageInfo.mName, imageInfo.mPath, imageInfo.mModifiedDate, businessAlbumInfo.getId(), businessAlbumInfo.getTitle(), imageInfo.mDescription, mediaWrapper2.getQuality(), poiInfo, list.size(), i27, j3, 7, j26, "", str2, qZonePreUploadInfo, map, i16, i17, str3, null, map3, false, arrayList, imageInfo.mExternalData, str4, i18, i19);
                    qZoneQunUploadPicTask.setMixUploadTaskInfo(bVar2);
                    qZoneQunUploadPicTask.setPhotoTagExtendInfo(imageInfo.mPhotoTagInfo);
                    QZonePublishQueue.w().b(qZoneQunUploadPicTask);
                } else {
                    map4 = map8;
                    map5 = map7;
                    bVar2 = bVar3;
                    str6 = w06;
                    if (mediaWrapper2.isVideo()) {
                        ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) com.qzone.publish.utils.d.a(mediaWrapper2.getVideoInfo());
                        if (shuoshuoVideoInfo == null) {
                            QZLog.w("upload2_QZoneWriteOperationService", "doUploadVideoPic, shuoshuoVideoInfo null, index:" + i27);
                        } else {
                            QZoneQunUploadVideoTask qZoneQunUploadVideoTask = new QZoneQunUploadVideoTask(28, shuoshuoVideoInfo, str2, j26, "", poiInfo, 1, i27, map, str4, i18, i19);
                            qZoneQunUploadVideoTask.setMixUploadTaskInfo(bVar2);
                            qZoneQunUploadVideoTask.uploadEntrance = i17;
                            qZoneQunUploadVideoTask.mContent = str;
                            bVar = bVar2;
                            qZoneQunUploadVideoTask.sAlbumName = businessAlbumInfo.mTitle;
                            qZoneQunUploadVideoTask.sAlbumID = businessAlbumInfo.mAlbumId;
                            qZoneQunUploadVideoTask.iAlbumTypeID = businessAlbumInfo.mAlbumType;
                            j17 = j3;
                            qZoneQunUploadVideoTask.batchId = j17;
                            qZoneQunUploadVideoTask.exifTime = shuoshuoVideoInfo.mTakenTime;
                            if (map5 != null) {
                                if (qZoneQunUploadVideoTask.stExternalMapExt == null) {
                                    qZoneQunUploadVideoTask.stExternalMapExt = new HashMap<>();
                                }
                                qZoneQunUploadVideoTask.stExternalMapExt.putAll(map5);
                            }
                            QZonePublishQueue.w().b(qZoneQunUploadVideoTask);
                            QzoneVideoPerfReport.a(shuoshuoVideoInfo.perfKey, 1);
                            VideoInfo n26 = n2(shuoshuoVideoInfo);
                            n26.isFakeFeed = true;
                            n26.isUploading = true;
                            qZoneQunUploadVideoTask.videoInfo = n26;
                            str5 = str6;
                            qZoneQunUploadVideoTask.lbsAddress = str5;
                            qZoneQunUploadVideoTask.svrTime = j26;
                            qZoneQunUploadVideoTask.albumInfo = businessAlbumInfo;
                            qZoneQunUploadVideoTask.imageInfos = null;
                            map6 = map4 == null ? new HashMap<>() : map4;
                            qZoneQunUploadVideoTask.extras = map6;
                            i27++;
                            map7 = map5;
                            list2 = list;
                            long j27 = j17;
                            w06 = str5;
                            bVar3 = bVar;
                            map8 = map6;
                            j18 = j27;
                        }
                    }
                }
                j17 = j3;
                bVar = bVar2;
                str5 = str6;
            } else {
                map4 = map8;
                map5 = map7;
                bVar = bVar3;
                str5 = w06;
                j17 = j18;
            }
            map6 = map4;
            i27++;
            map7 = map5;
            list2 = list;
            long j272 = j17;
            w06 = str5;
            bVar3 = bVar;
            map8 = map6;
            j18 = j272;
        }
    }

    private void j1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest;
        JceStruct jceStruct;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && (jceStruct = qZoneRequest.rsp) != null) {
            mobile_video_nag_feedback_rsp mobile_video_nag_feedback_rspVar = (mobile_video_nag_feedback_rsp) jceStruct;
            if (mobile_video_nag_feedback_rspVar != null) {
                int i3 = mobile_video_nag_feedback_rspVar.retCode;
                if (i3 == 0) {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommitSuccess", "\u63d0\u4ea4\u6210\u529f"), 5);
                    return;
                }
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommitFail", "\u63d0\u4ea4\u5931\u8d25"), 4);
                QZLog.w("adv_report", "TASK_TYPE_SUBMIT_NEGATIVE_FEEDBACK ret : " + i3);
                return;
            }
            return;
        }
        QZLog.w("adv_report", "TASK_TYPE_SUBMIT_NEGATIVE_FEEDBACK failed");
    }

    private QZoneResult k1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QzoneUniversalRequest qzoneUniversalRequest = (QzoneUniversalRequest) qZoneTask.mRequest;
        if (qzoneUniversalRequest.getCallback() != null && qzoneUniversalRequest.universalRsp != null) {
            qzoneUniversalRequest.getCallback().onResponse(qzoneUniversalRequest.universalRsp);
        }
        return qZoneResult;
    }

    private void l0(String str, int i3, ShuoshuoVideoInfo shuoshuoVideoInfo, List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i16, LbsDataV2.PoiInfo poiInfo, long j3, long j16, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i17, int i18, String str3, Map<String, byte[]> map2, Map<String, String> map3, String str4) {
        com.qzone.publish.business.publishqueue.h.a(j3, 1);
        String uuid = UUID.randomUUID().toString();
        QZoneUploadAlbumVideoTask qZoneUploadAlbumVideoTask = new QZoneUploadAlbumVideoTask(28, shuoshuoVideoInfo, str2, j16, uuid, poiInfo, 1, 0, map);
        qZoneUploadAlbumVideoTask.mContent = str;
        qZoneUploadAlbumVideoTask.uploadEntrance = i18;
        qZoneUploadAlbumVideoTask.sAlbumName = businessAlbumInfo.mTitle;
        qZoneUploadAlbumVideoTask.sAlbumID = businessAlbumInfo.mAlbumId;
        qZoneUploadAlbumVideoTask.iAlbumTypeID = businessAlbumInfo.mAlbumType;
        qZoneUploadAlbumVideoTask.batchId = j3;
        qZoneUploadAlbumVideoTask.exifTime = shuoshuoVideoInfo.mTakenTime;
        if (map3 != null) {
            if (qZoneUploadAlbumVideoTask.stExternalMapExt == null) {
                qZoneUploadAlbumVideoTask.stExternalMapExt = new HashMap<>();
            }
            qZoneUploadAlbumVideoTask.stExternalMapExt.putAll(map3);
        }
        QZonePublishQueue.w().b(qZoneUploadAlbumVideoTask);
        QzoneVideoPerfReport.a(shuoshuoVideoInfo.perfKey, 1);
        QzoneVideoUploadActionReport.b().d(shuoshuoVideoInfo.mVideoPath, "in_publish_queue", 0);
        String w06 = w0(poiInfo);
        VideoInfo n26 = n2(shuoshuoVideoInfo);
        n26.isFakeFeed = true;
        n26.isUploading = true;
        qZoneUploadAlbumVideoTask.clientKey = uuid;
        qZoneUploadAlbumVideoTask.videoInfo = n26;
        qZoneUploadAlbumVideoTask.lbsAddress = w06;
        qZoneUploadAlbumVideoTask.svrTime = j16;
        qZoneUploadAlbumVideoTask.albumInfo = businessAlbumInfo;
        qZoneUploadAlbumVideoTask.imageInfos = list;
        Map<String, byte[]> hashMap = map2 == null ? new HashMap<>() : map2;
        qZoneUploadAlbumVideoTask.extras = hashMap;
        if (!com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            notify(44, uuid, list, n26, w06, Long.valueOf(j16), businessAlbumInfo, hashMap, map3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaWrapper(shuoshuoVideoInfo));
        le.b.f414397d.a(poiInfo, arrayList, uuid, map, le.a.f414396a.f(businessAlbumInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str, int i3, List<MediaWrapper> list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, long j3, long j16, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i16, int i17, String str3, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList) {
        Map<String, byte[]> map4;
        Map<String, String> map5;
        com.qzone.publish.business.task.b bVar;
        String str4;
        String str5;
        long j17;
        int i18;
        Map<String, byte[]> map6;
        List<MediaWrapper> list2 = list;
        long j18 = j3;
        Map<String, String> map7 = map3;
        if (list2 == null || list.size() <= 0) {
            return;
        }
        String uuid = UUID.randomUUID().toString();
        if (map7 != null && map7.containsKey(QZonePublishMoodRequest.KEY_UPLOAD_PHOTO_CLIENT_KEY)) {
            String str6 = map7.get(QZonePublishMoodRequest.KEY_UPLOAD_PHOTO_CLIENT_KEY);
            if (!TextUtils.isEmpty(str6)) {
                uuid = str6;
            }
        }
        String str7 = uuid;
        com.qzone.publish.business.publishqueue.h.a(j18, list.size());
        String w06 = w0(poiInfo);
        com.qzone.publish.business.task.b bVar2 = new com.qzone.publish.business.task.b(list, w06, j16, businessAlbumInfo, map2);
        long j19 = j16;
        Map<String, byte[]> map8 = map2;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i19 < list.size()) {
            if (j19 != 0) {
                j19--;
            }
            MediaWrapper mediaWrapper = list2.get(i19);
            if (mediaWrapper != null) {
                if (mediaWrapper.isImage()) {
                    ImageInfo imageInfo = mediaWrapper.getImageInfo();
                    com.qzone.publish.business.task.b bVar3 = bVar2;
                    Map<String, byte[]> map9 = map8;
                    String str8 = str7;
                    map5 = map3;
                    QZoneUploadPicTask qZoneUploadPicTask = new QZoneUploadPicTask(i3, imageInfo.panoramaType, imageInfo.mName, imageInfo.mPath, imageInfo.mModifiedDate, businessAlbumInfo.getId(), businessAlbumInfo.getTitle(), imageInfo.mDescription, mediaWrapper.getQuality(), poiInfo, list.size(), i19, j3, 7, j19, str8, str2, qZonePreUploadInfo, map, i16, i17, str3, null, map3, true, arrayList, imageInfo.mExternalData);
                    qZoneUploadPicTask.setMixUploadTaskInfo(bVar3);
                    qZoneUploadPicTask.setPhotoTagExtendInfo(imageInfo.mPhotoTagInfo);
                    QZonePublishQueue.w().b(qZoneUploadPicTask);
                    i27++;
                    j17 = j3;
                    i18 = i26;
                    bVar = bVar3;
                    str5 = w06;
                    map6 = map9;
                    str4 = str8;
                } else {
                    map4 = map8;
                    map5 = map7;
                    com.qzone.publish.business.task.b bVar4 = bVar2;
                    String str9 = w06;
                    String str10 = str7;
                    if (mediaWrapper.isVideo()) {
                        ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) com.qzone.publish.utils.d.a(mediaWrapper.getVideoInfo());
                        if (shuoshuoVideoInfo == null) {
                            QZLog.w("upload2_QZoneWriteOperationService", "doUploadVideoPic, shuoshuoVideoInfo null, index:" + i19);
                        } else {
                            QZoneUploadAlbumVideoTask qZoneUploadAlbumVideoTask = new QZoneUploadAlbumVideoTask(28, shuoshuoVideoInfo, str2, j19, str10, poiInfo, list.size(), i19, map);
                            qZoneUploadAlbumVideoTask.setMixUploadTaskInfo(bVar4);
                            qZoneUploadAlbumVideoTask.uploadEntrance = i17;
                            qZoneUploadAlbumVideoTask.mContent = str;
                            qZoneUploadAlbumVideoTask.sAlbumName = businessAlbumInfo.mTitle;
                            qZoneUploadAlbumVideoTask.sAlbumID = businessAlbumInfo.mAlbumId;
                            qZoneUploadAlbumVideoTask.iAlbumTypeID = businessAlbumInfo.mAlbumType;
                            j17 = j3;
                            qZoneUploadAlbumVideoTask.batchId = j17;
                            qZoneUploadAlbumVideoTask.exifTime = shuoshuoVideoInfo.mTakenTime;
                            if (map5 != null) {
                                if (qZoneUploadAlbumVideoTask.stExternalMapExt == null) {
                                    qZoneUploadAlbumVideoTask.stExternalMapExt = new HashMap<>();
                                }
                                qZoneUploadAlbumVideoTask.stExternalMapExt.putAll(map5);
                            }
                            QZonePublishQueue.w().b(qZoneUploadAlbumVideoTask);
                            QzoneVideoPerfReport.a(shuoshuoVideoInfo.perfKey, 1);
                            i18 = i26 + 1;
                            bVar = bVar4;
                            QzoneVideoUploadActionReport.b().d(shuoshuoVideoInfo.mVideoPath, "in_publish_queue", 0);
                            VideoInfo n26 = n2(shuoshuoVideoInfo);
                            n26.isFakeFeed = true;
                            n26.isUploading = true;
                            str4 = str10;
                            qZoneUploadAlbumVideoTask.clientKey = str4;
                            qZoneUploadAlbumVideoTask.videoInfo = n26;
                            str5 = str9;
                            qZoneUploadAlbumVideoTask.lbsAddress = str5;
                            qZoneUploadAlbumVideoTask.svrTime = j19;
                            qZoneUploadAlbumVideoTask.albumInfo = businessAlbumInfo;
                            qZoneUploadAlbumVideoTask.imageInfos = null;
                            map6 = map4 == null ? new HashMap<>() : map4;
                            qZoneUploadAlbumVideoTask.extras = map6;
                        }
                    }
                    j17 = j3;
                    bVar = bVar4;
                    str5 = str9;
                    str4 = str10;
                }
                i19++;
                map7 = map5;
                map8 = map6;
                j18 = j17;
                w06 = str5;
                i26 = i18;
                bVar2 = bVar;
                str7 = str4;
                list2 = list;
            } else {
                map4 = map8;
                map5 = map7;
                bVar = bVar2;
                str4 = str7;
                str5 = w06;
                j17 = j18;
            }
            i18 = i26;
            map6 = map4;
            i19++;
            map7 = map5;
            map8 = map6;
            j18 = j17;
            w06 = str5;
            i26 = i18;
            bVar2 = bVar;
            str7 = str4;
            list2 = list;
        }
        Object obj = map8;
        Object obj2 = map7;
        String str11 = str7;
        Object obj3 = w06;
        QzoneVideoUploadActionReport.b().h(i26 + i27, i26, i27, "task_type_album_video");
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.a(poiInfo, list, str11, map, le.a.f414396a.f(businessAlbumInfo));
        } else {
            notify(49, str11, list, obj3, Long.valueOf(j19), businessAlbumInfo, obj, 1, obj2);
        }
    }

    private void o0(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && value.contains(".mp4")) {
                this.f45607h.put(key, value);
            }
        }
    }

    private void o1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        HashMap<String, String> hashMap;
        if (qZoneTask instanceof QZoneUploadAlbumVideoTask) {
            hashMap = (HashMap) ((QZoneUploadAlbumVideoTask) qZoneTask).getLocalUrlMap();
        } else {
            hashMap = qZoneTask instanceof QZoneUploadPicTask ? (HashMap) ((QZoneUploadPicTask) qZoneTask).getLocalUrlMap() : null;
        }
        BusinessFeedData y06 = y0(qZoneTask, hashMap, 4097);
        String str = qZoneTask.clientKey;
        y06.setMixFake(0);
        notify(50, str, y06);
    }

    private boolean q1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString("pp");
            if (optString != null) {
                return optString.equals("6");
            }
            return false;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean s1(int i3) {
        if ((i3 >= 5 && i3 <= 7) || ((i3 >= 24 && i3 <= 26) || ((i3 >= 30 && i3 <= 35) || (i3 >= 37 && i3 <= 39)))) {
            return true;
        }
        return false;
    }

    public static QZoneWriteOperationService v0() {
        return D.get(null);
    }

    private void x1(String str, String str2, boolean z16, Intent intent) {
        for (n nVar : this.C) {
            if (nVar != null) {
                nVar.i3(str, str2, z16, intent);
            }
        }
    }

    private BusinessFeedData y0(QZoneTask qZoneTask, HashMap<String, String> hashMap, int i3) {
        UniAttribute uniAttribute;
        if (qZoneTask != null && (uniAttribute = qZoneTask.mUniAttr) != null && uniAttribute.containsKey("fakeSingleFeed")) {
            single_feed single_feedVar = (single_feed) qZoneTask.mUniAttr.get("fakeSingleFeed");
            if (single_feedVar == null) {
                QZLog.e("upload2_QZoneWriteOperationService", "QzoneWriteOperation.getServerFakeFeedFail.singleFeed null");
                return null;
            }
            BusinessFeedData createFrom = BusinessFeedData.createFrom(single_feedVar, i3);
            if (createFrom.getUser().uin != LoginData.getInstance().getUin()) {
                return null;
            }
            createFrom.getFeedCommInfo().clientkey = qZoneTask.clientKey;
            createFrom.getLocalInfo().setHalfReal();
            createFrom.getUser().nickName = LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.shh));
            a2(hashMap, createFrom);
            return createFrom;
        }
        QZLog.e("upload2_QZoneWriteOperationService", "getServerFakeFeed Fail");
        return null;
    }

    private void z1(QZoneTask qZoneTask) {
        if (qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(IChannelType.APP_SUB_CHANNEL_TYPE_KARAOKE);
        mobile_detail_actshuoshuo_rsp mobile_detail_actshuoshuo_rspVar = (mobile_detail_actshuoshuo_rsp) qZoneTask.mRequest.rsp;
        if (mobile_detail_actshuoshuo_rspVar == null || !result.getSucceed()) {
            result.setSucceed(false);
            QZLog.w("[publish2]QZoneWriteOperationService", "getOperateMoodContent faild! ret(" + result.getReturnCode() + ")");
        }
        result.setData(mobile_detail_actshuoshuo_rspVar);
        qZoneTask.sendResultMsg(result);
    }

    public void B0(Handler handler, String str) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetUrlInfoRequest(str), handler, this, 35));
    }

    public String C0(String str) {
        HashMap<String, String> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.f45604d) == null || this.f45607h == null) {
            return null;
        }
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f45607h.get(str);
        }
        if (TextUtils.isEmpty(str2) || new File(str2).exists()) {
            return str2;
        }
        return null;
    }

    public HashMap<String, Long> D0(String str) {
        HashMap<String, Long> hashMap;
        HashMap<String, Long> hashMap2 = new HashMap<>();
        if (!TextUtils.isEmpty(str) && (hashMap = this.f45605e) != null && this.f45606f != null) {
            Long l3 = hashMap.get(str);
            Long l16 = this.f45606f.get(str);
            if (l3 != null && l3.longValue() >= 0 && l16 != null && l16.longValue() >= 0 && l16.longValue() > l3.longValue()) {
                hashMap2.put("videoPlayStartTime", l3);
                hashMap2.put("videoPlayEndTime", l16);
            }
        }
        return hashMap2;
    }

    public void F1(l lVar) {
        Map<Integer, String> map = lVar.f45718k;
        String str = map != null ? map.get(2) : null;
        if (lVar.f45721n != 0) {
            if (lVar.f45725r) {
                lVar.f45715h += "[em]e10011[/em]";
            }
            if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
                notify(3, lVar.f45722o, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
            }
            notify(3, lVar.f45708a, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
        }
    }

    public void H(int i3, int i16, String str, String str2, long j3, String str3, String str4, String str5, int i17, LbsDataV2.PoiInfo poiInfo, int i18, int i19, long j16, String str6, long j17, String str7, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i26, int i27, String str8, Map<String, byte[]> map2, Map<String, String> map3, Map<String, String> map4, boolean z16, ArrayList<GifInfo> arrayList, HashMap<String, byte[]> hashMap) {
        QZoneUploadPicTask qZoneUploadPicTask = new QZoneUploadPicTask(i3, i16, str, str2, j3, str3, str4, str5, i17, poiInfo, i18, i19, j16, 7, j17, str6, str7, qZonePreUploadInfo, map, i26, i27, str8, map2, map3, z16, arrayList, hashMap);
        qZoneUploadPicTask.setPhotoTagExtendInfo(map4);
        QZonePublishQueue.w().b(qZoneUploadPicTask);
    }

    public void I(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getUser() != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().busiParam != null && businessFeedData.getOperationInfoV2().busiParam.containsKey(92)) {
            QZLog.i("[publish2]QZoneWriteOperationService", 1, "advFeedBack");
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneRecomRecportRequest(LoginData.getInstance().getUin(), 1, (short) businessFeedData.getFeedCommInfo().recomtype, i3, 2, businessFeedData.getOperationInfoV2().busiParam.get(92), null), null, this, 41));
            return;
        }
        QZLog.e("[publish2]QZoneWriteOperationService", "advFeedBack data null");
    }

    public void K(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, long j16, BusinessFeedData businessFeedData, long j17) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("adv_report", 4, "reportPos = " + i3 + ", writeReturnCode = " + i16 + ", index = " + i17 + ", actionType = " + i18 + ", actionExpectation =" + i19 + " , feedsClickAttachInfo =" + str3);
        }
        if (r1(businessFeedData, i3, str3, z16, z26) || q1(str2)) {
            return;
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneAdvReportRequest(map, i3, i16, i17, i18, i19, z16, z17, str, str2, j3, z18, z19, str3, z26, j16, j17), null, this, 30));
    }

    public void M(String str) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneclearFeedCountRequest(str), null, this, 42));
    }

    public void N(Handler handler, String str, Map<String, String> map) {
        QZoneTask qZoneTask = new QZoneTask(new QzoneClickBookButtonRequest(map), handler, this, 63);
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        notify(73, str);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void O(Handler handler, long j3, int i3, Map<Integer, String> map, fp.a aVar) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneDropMenuRequest(j3, i3, map), handler, aVar, 48);
        notify(57, new Object[0]);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void O1(com.qzone.publish.ui.model.c cVar) {
        Object obj;
        if (!cVar.X) {
            UploadVideoObject.setVideoType(cVar.f51946h, true);
            QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = new QZoneUploadShuoShuoTask(6, 0, cVar);
            qZoneUploadShuoShuoTask.syncToFriendInfo = cVar.R;
            qZoneUploadShuoShuoTask.isVideoToGif = cVar.A;
            qZoneUploadShuoShuoTask.syncToKuolie = cVar.S;
            qZoneUploadShuoShuoTask.kuolie_campus = cVar.T;
            qZoneUploadShuoShuoTask.fromKuolie = cVar.U;
            String h06 = u5.b.h0("key_dynamic_client_ket", "null");
            if (!TextUtils.isEmpty(cVar.f51945g0)) {
                h06 = cVar.f51945g0;
            } else if (!qZoneUploadShuoShuoTask.isDynamicTask() || h06.equals("null")) {
                h06 = UUID.randomUUID().toString();
            }
            qZoneUploadShuoShuoTask.clientKey = h06;
            qZoneUploadShuoShuoTask.uploadEntrance = cVar.f51964z;
            qZoneUploadShuoShuoTask.isMakeVideo = cVar.Q;
            qZoneUploadShuoShuoTask.refer = cVar.I;
            if (cVar.f51946h != null) {
                LoginData.getInstance().getUin();
                QzoneVideoPerfReport.a(cVar.f51946h.perfKey, 1);
                QzoneVideoUploadActionReport.b().d(cVar.f51946h.mVideoPath, "in_publish_queue", 0);
            }
            QZonePublishQueue.w().b(qZoneUploadShuoShuoTask);
            if (cVar.W && com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                le.b.f414397d.c(cVar, h06);
                return;
            }
            ShuoshuoVideoInfo shuoshuoVideoInfo = cVar.f51946h;
            if (shuoshuoVideoInfo != null && !TextUtils.isEmpty(shuoshuoVideoInfo.topicId)) {
                Intent intent = new Intent(PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED);
                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY, h06);
                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_PATH, cVar.f51946h.mCoverUrl);
                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_WIDTH, cVar.f51946h.mVideoWidth);
                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_HEIGHT, cVar.f51946h.mVideoHeight);
                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_SHUOSHUO_CONTENT, cVar.f51934b);
                BaseApplication.getContext().sendBroadcast(intent);
                return;
            }
            if (cVar.f51957s > 0) {
                return;
            }
            Object w06 = w0(cVar.f51948j);
            if (cVar.f51950l && !TextUtils.isEmpty(cVar.f51934b) && cVar.f51934b.startsWith("qm")) {
                obj = cVar.f51934b.substring(2);
            } else {
                obj = cVar.f51934b;
            }
            ShuoshuoVideoInfo shuoshuoVideoInfo2 = cVar.f51946h;
            if (shuoshuoVideoInfo2 != null) {
                shuoshuoVideoInfo2.mIsFakeFeed = true;
            }
            List<String> list = cVar.f51936c;
            if (list != null && list.size() > 0) {
                EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, cVar.f51936c.toArray());
            }
            if (cVar.A) {
                if (cVar.f51936c == null) {
                    cVar.f51936c = new ArrayList();
                }
                ShuoshuoVideoInfo shuoshuoVideoInfo3 = cVar.f51946h;
                if (shuoshuoVideoInfo3 != null) {
                    cVar.f51936c.add(shuoshuoVideoInfo3.mCoverUrl);
                    cVar.f51946h = null;
                }
            }
            Map<String, String> map = cVar.f51935b0;
            Object obj2 = map != null ? (String) map.get("comm_recom_bottom") : null;
            if (cVar.W) {
                notify(1, h06, obj, cVar.f51936c, n2(cVar.f51946h), w06, Integer.valueOf(cVar.f51959u), cVar.f51954p, cVar.f51938d, cVar.C, cVar.b(), cVar.L, cVar.G, cVar.S, cVar.E, obj2, cVar.f51935b0);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Can NOT be used to public account, please use publishMoodForPubAccount");
    }

    public void P(Handler handler, long j3) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneHighFivePassiveNotificationRequest(LoginData.getInstance().getUin(), j3), handler, this, 58));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    public void P1(String str, List<String> list, ArrayList<DynamicPhotoData> arrayList, HashMap<String, String> hashMap, shuoshuo_privacy shuoshuo_privacyVar, ShuoshuoVideoInfo shuoshuoVideoInfo, HashMap<String, PicInfo> hashMap2, LbsDataV2.PoiInfo poiInfo, boolean z16, boolean z17, int i3, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Font font, int i16, long j3, long j16, int i17, ArrayList<String> arrayList2, String str2, LbsDataV2.PoiInfo poiInfo2, String str3, int i18, boolean z18, ArrayList<GifInfo> arrayList3, PublishEventTag publishEventTag, Map<String, byte[]> map2, HashMap<String, String> hashMap3, Map<String, byte[]> map3, HashMap<String, String> hashMap4, Map<String, String> map4, int i19, Map<String, String> map5, String... strArr) {
        ?? r65;
        List<String> list2;
        byte[] byteArray;
        HashMap hashMap5 = new HashMap();
        if (font != null && (byteArray = font.toByteArray()) != null) {
            hashMap5.put(PROTO_EXT_TO_UGCSVR_FOR_FONT.value, byteArray);
        }
        UploadVideoObject.setVideoType(shuoshuoVideoInfo, true);
        QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = new QZoneUploadShuoShuoTask(str, list, arrayList, hashMap, shuoshuo_privacyVar, shuoshuoVideoInfo, hashMap2, poiInfo, z16, z17, r7.a.a(), 6, i3, qZonePreUploadInfo, map, hashMap5, i16, j3, j16, i17, arrayList2, str2, str3, poiInfo2, map2, arrayList3, publishEventTag, hashMap3, map3, hashMap4, map4, i19, map5);
        qZoneUploadShuoShuoTask.isVideoToGif = z18;
        String h06 = u5.b.h0("key_dynamic_client_ket", "null");
        if (!qZoneUploadShuoShuoTask.isDynamicTask() || h06.equals("null")) {
            h06 = UUID.randomUUID().toString();
        }
        qZoneUploadShuoShuoTask.clientKey = h06;
        qZoneUploadShuoShuoTask.uploadEntrance = i18;
        if (strArr != null && strArr.length > 0) {
            qZoneUploadShuoShuoTask.refer = strArr[0];
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = shuoshuoVideoInfo;
        if (shuoshuoVideoInfo2 != null) {
            LoginData.getInstance().getUin();
            r65 = 1;
            QzoneVideoPerfReport.a(shuoshuoVideoInfo2.perfKey, 1);
            QzoneVideoUploadActionReport.b().d(shuoshuoVideoInfo2.mVideoPath, "in_publish_queue", 0);
        } else {
            r65 = 1;
        }
        QZonePublishQueue.w().b(qZoneUploadShuoShuoTask);
        if (shuoshuoVideoInfo2 != null && !TextUtils.isEmpty(shuoshuoVideoInfo2.topicId)) {
            Intent intent = new Intent(PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED);
            intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY, h06);
            intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_PATH, shuoshuoVideoInfo2.mCoverUrl);
            intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_WIDTH, shuoshuoVideoInfo2.mVideoWidth);
            intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_HEIGHT, shuoshuoVideoInfo2.mVideoHeight);
            intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_SHUOSHUO_CONTENT, str);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        String str4 = str;
        if (j3 > 0) {
            return;
        }
        String w06 = w0(poiInfo);
        if (z17 && !TextUtils.isEmpty(str) && str4.startsWith("qm")) {
            str4 = str4.substring(2);
        }
        if (shuoshuoVideoInfo2 != null) {
            shuoshuoVideoInfo2.mIsFakeFeed = r65;
        }
        if (list != null && list.size() > 0) {
            EventCenter.getInstance().post("PHOTOUPLOADACTION", (int) r65, list.toArray());
        }
        if (z18) {
            list2 = list == null ? new ArrayList<>() : list;
            if (shuoshuoVideoInfo2 != null) {
                list2.add(shuoshuoVideoInfo2.mCoverUrl);
                shuoshuoVideoInfo2 = null;
            }
        } else {
            list2 = list;
        }
        Object[] objArr = new Object[16];
        objArr[0] = h06;
        objArr[r65] = str4;
        objArr[2] = list2;
        objArr[3] = n2(shuoshuoVideoInfo2);
        objArr[4] = w06;
        objArr[5] = Integer.valueOf(i17);
        objArr[6] = map;
        objArr[7] = arrayList;
        objArr[8] = publishEventTag;
        objArr[9] = hashMap5;
        objArr[10] = hashMap4;
        objArr[11] = map4;
        objArr[12] = null;
        objArr[13] = null;
        objArr[14] = null;
        objArr[15] = map5;
        notify(r65, objArr);
    }

    public void Q1(com.qzone.publish.ui.model.c cVar) {
        if (cVar.X) {
            UploadVideoObject.setVideoType(cVar.f51946h, true);
            QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = new QZoneUploadShuoShuoTask(67, 0, cVar);
            String h06 = u5.b.h0("key_dynamic_client_ket", "null");
            if (!qZoneUploadShuoShuoTask.isDynamicTask() || h06.equals("null")) {
                h06 = UUID.randomUUID().toString();
            }
            qZoneUploadShuoShuoTask.clientKey = h06;
            qZoneUploadShuoShuoTask.uploadEntrance = cVar.f51964z;
            qZoneUploadShuoShuoTask.isMakeVideo = cVar.Q;
            qZoneUploadShuoShuoTask.refer = cVar.I;
            PubAccountTaskQueue.t().b(qZoneUploadShuoShuoTask);
            List<String> list = cVar.f51936c;
            if (list != null && list.size() > 0) {
                EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, cVar.f51936c.toArray());
            }
            if (cVar.A) {
                if (cVar.f51936c == null) {
                    cVar.f51936c = new ArrayList();
                }
                ShuoshuoVideoInfo shuoshuoVideoInfo = cVar.f51946h;
                if (shuoshuoVideoInfo != null) {
                    cVar.f51936c.add(shuoshuoVideoInfo.mCoverUrl);
                    cVar.f51946h = null;
                }
            }
            w1(qZoneUploadShuoShuoTask);
        }
    }

    public void R1(final Context context, final com.qzone.publish.ui.model.c cVar) {
        String str;
        if (!cVar.X) {
            List<LocalMediaInfo> list = cVar.f51940e;
            if (list == null || list.size() == 0) {
                return;
            }
            Map<String, String> map = cVar.f51954p;
            if (map != null) {
                str = map.get("geo_idname");
            } else {
                cVar.f51954p = new HashMap();
                str = null;
            }
            final String str2 = str;
            final Map<String, String> map2 = cVar.f51954p;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().post(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.2
                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    String str4;
                    Iterator<LocalMediaInfo> it;
                    int i3;
                    ImageInfo imageInfo;
                    ArrayList<MediaWrapper> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    Iterator<LocalMediaInfo> it5 = cVar.f51940e.iterator();
                    int i16 = 0;
                    int i17 = 0;
                    while (it5.hasNext()) {
                        LocalMediaInfo next = it5.next();
                        Size b16 = f6.b.b(next);
                        int i18 = b16.width;
                        int i19 = b16.height;
                        if (next.isRecord) {
                            i3 = i16;
                            it = it5;
                            ShuoshuoVideoInfo p16 = ag.p(context, next._id, next.path, next.fileSize, next.mVideoType, next.thumbnailPath, i19, i18, next.mStartTime, next.mDuration, next.mTotalDuration, next.needProcess, next.bundle);
                            if (p16 == null) {
                                p16 = ag.z(context, next._id, next.path, next.fileSize, next.mVideoType, next.thumbnailPath, i19, i18, next.mStartTime, next.mDuration, next.mTotalDuration, next.needProcess, next.bundle, false);
                            }
                            p16.fakeVid = next.fakeVid;
                            p16.mDescription = cVar.f51934b;
                            p16.mIsUploadOrigin = next.mIsUploadOrigin;
                            if (next.isSyncToWeishi) {
                                ag.w(p16, ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, true);
                            }
                            UploadVideoObject.setVideoType(cVar.f51946h, true);
                            zm.e.f452772a.b(next, p16);
                            arrayList.add(new MediaWrapper(p16, p16.mNeedProcess));
                        } else {
                            it = it5;
                            i3 = i16;
                            if (QAlbumUtil.getMediaType(next) == 0) {
                                if (URLUtil.isNetworkUrl(next.path)) {
                                    imageInfo = new ImageInfo();
                                    imageInfo.mPath = next.path;
                                } else {
                                    imageInfo = new ImageInfo(next.path);
                                    imageInfo.panoramaType = next.panoramaPhotoType;
                                }
                                Map<String, byte[]> map3 = cVar.F;
                                if (map3 != null && map3.containsKey(next.path)) {
                                    imageInfo.mExternalData.put(kExtKeyMarkUinBeforeUpload.value, cVar.F.get(next.path));
                                }
                                com.qzone.publish.ui.model.c cVar2 = cVar;
                                imageInfo.mDescription = cVar2.f51934b;
                                Map<String, String> map4 = cVar2.G;
                                if (map4 != null && map4.containsKey(next.path)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("youtu_tag_array", cVar.G.get(next.path));
                                    HashMap<String, String> hashMap2 = imageInfo.mPhotoTagInfo;
                                    if (hashMap2 != null && hashMap2.size() > 0) {
                                        imageInfo.mPhotoTagInfo.putAll(hashMap);
                                    } else {
                                        imageInfo.mPhotoTagInfo = hashMap;
                                    }
                                }
                                arrayList.add(new MediaWrapper(imageInfo));
                                arrayList2.add(next.path);
                                i17++;
                            } else if (QAlbumUtil.getMediaType(next) == 1) {
                                Context context2 = context;
                                long j3 = next._id;
                                String str5 = next.path;
                                long j16 = next.fileSize;
                                String str6 = next.thumbnailPath;
                                long j17 = next.mDuration;
                                ShuoshuoVideoInfo p17 = ag.p(context2, j3, str5, j16, 1, str6, i19, i18, 0L, j17, j17, next.needProcess, null);
                                if (p17 == null) {
                                    Context context3 = context;
                                    long j18 = next._id;
                                    String str7 = next.path;
                                    long j19 = next.fileSize;
                                    String str8 = next.thumbnailPath;
                                    long j26 = next.mDuration;
                                    p17 = ag.z(context3, j18, str7, j19, 1, str8, i19, i18, 0L, j26, j26, next.needProcess, null, false);
                                }
                                p17.mProcessMissionID = next.missionID;
                                p17.mDescription = cVar.f51934b;
                                if (next.isSyncToWeishi) {
                                    ag.w(p17, ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, true);
                                }
                                if (cVar.f51951m) {
                                    ag.w(p17, ShortVideoConstants.VIDEO_IS_USE_QCIRCLE_RATE, true);
                                }
                                zm.e.f452772a.b(next, p17);
                                MediaWrapper mediaWrapper = new MediaWrapper(p17);
                                if (mediaWrapper.getVideoInfo().mNeedProcess) {
                                    mediaWrapper.getVideoInfo().mNeedProcess = next.needProcess;
                                    mediaWrapper.getVideoInfo().mIsOriginalVideo = next.needProcess ? 0 : 1;
                                    mediaWrapper.getVideoInfo().mIsUploadOrigin = !next.needProcess;
                                } else if (!next.needProcess) {
                                    mediaWrapper.getVideoInfo().mNeedProcess = false;
                                    mediaWrapper.getVideoInfo().mIsOriginalVideo = 1;
                                    mediaWrapper.getVideoInfo().mIsUploadOrigin = true;
                                }
                                arrayList.add(mediaWrapper);
                            }
                            i16 = i3;
                            it5 = it;
                        }
                        i16 = i3 + 1;
                        it5 = it;
                    }
                    int i26 = i16;
                    com.qzone.publish.ui.model.c cVar3 = cVar;
                    cVar3.M = arrayList;
                    cVar3.P = arrayList2;
                    QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = new QZoneUploadShuoShuoTask(6, 1, cVar);
                    if (TextUtils.isEmpty(cVar.f51945g0)) {
                        str3 = UUID.randomUUID().toString();
                    } else {
                        str3 = cVar.f51945g0;
                    }
                    qZoneUploadShuoShuoTask.clientKey = str3;
                    com.qzone.publish.ui.model.c cVar4 = cVar;
                    qZoneUploadShuoShuoTask.uploadEntrance = cVar4.f51964z;
                    qZoneUploadShuoShuoTask.refer = cVar4.I;
                    if (cVar4.f51946h != null) {
                        LoginData.getInstance().getUin();
                        QzoneVideoPerfReport.a(cVar.f51946h.perfKey, 1);
                        QzoneVideoUploadActionReport.b().d(cVar.f51946h.mVideoPath, "in_publish_queue", 0);
                    }
                    QZonePublishQueue.w().b(qZoneUploadShuoShuoTask);
                    if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                        le.b.f414397d.c(cVar, str3);
                        return;
                    }
                    ShuoshuoVideoInfo shuoshuoVideoInfo = cVar.f51946h;
                    if (shuoshuoVideoInfo != null && !TextUtils.isEmpty(shuoshuoVideoInfo.topicId)) {
                        Intent intent = new Intent(PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED);
                        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY, str3);
                        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_PATH, cVar.f51946h.mCoverUrl);
                        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_WIDTH, cVar.f51946h.mVideoWidth);
                        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_HEIGHT, cVar.f51946h.mVideoHeight);
                        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_SHUOSHUO_CONTENT, cVar.f51934b);
                        BaseApplication.getContext().sendBroadcast(intent);
                        return;
                    }
                    if (cVar.f51957s > 0) {
                        return;
                    }
                    map2.put("shuoshuo_priv", cVar.f51959u + "");
                    com.qzone.publish.ui.model.c cVar5 = cVar;
                    if (cVar5.f51950l && !TextUtils.isEmpty(cVar5.f51934b) && cVar.f51934b.startsWith("qm")) {
                        str4 = cVar.f51934b.substring(2);
                    } else {
                        str4 = cVar.f51934b;
                    }
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = cVar.f51946h;
                    if (shuoshuoVideoInfo2 != null) {
                        shuoshuoVideoInfo2.mIsFakeFeed = true;
                    }
                    if (arrayList2.size() > 0) {
                        EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList2.toArray());
                    }
                    if (i26 == 1 && i17 == 0) {
                        ArrayList arrayList3 = new ArrayList();
                        ShuoshuoVideoInfo videoInfo = arrayList.get(0).getVideoInfo();
                        if (videoInfo != null) {
                            videoInfo.mIsFakeFeed = true;
                        }
                        QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                        com.qzone.publish.ui.model.c cVar6 = cVar;
                        com.qzone.publish.ui.model.c cVar7 = cVar;
                        v06.notify(1, str3, str4, arrayList3, QZoneWriteOperationService.n2(videoInfo), str2, Integer.valueOf(cVar.f51959u), map2, cVar6.f51938d, cVar6.C, cVar6.b(), cVar7.L, cVar7.G, cVar7.S, null, null, cVar7.f51935b0);
                        return;
                    }
                    QZoneWriteOperationService v07 = QZoneWriteOperationService.v0();
                    com.qzone.publish.ui.model.c cVar8 = cVar;
                    com.qzone.publish.ui.model.c cVar9 = cVar;
                    v07.notify(60, str3, arrayList, str2, Long.valueOf(cVar.f51957s), null, map2, 1, cVar8.f51935b0, cVar8.b(), cVar9.C, cVar9.L, cVar9.S);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Can NOT be used to publish account, please use publishVideoPicMoodForPublishAccount");
    }

    public void S1(final Context context, final com.qzone.publish.ui.model.c cVar) {
        List<LocalMediaInfo> list = cVar.f51940e;
        if (list == null || list.size() == 0) {
            return;
        }
        Map<String, String> map = cVar.f51954p;
        if (map != null) {
            map.get("geo_idname");
        } else {
            cVar.f51954p = new HashMap();
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().post(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v10, types: [int, boolean] */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v9 */
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<MediaWrapper> arrayList;
                Iterator<LocalMediaInfo> it;
                ?? r16;
                ImageInfo imageInfo;
                String str;
                boolean z16;
                ArrayList<MediaWrapper> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                Iterator<LocalMediaInfo> it5 = cVar.f51940e.iterator();
                while (it5.hasNext()) {
                    LocalMediaInfo next = it5.next();
                    Size b16 = f6.b.b(next);
                    int i3 = b16.width;
                    int i16 = b16.height;
                    if (next.isRecord) {
                        it = it5;
                        arrayList = arrayList2;
                        ArrayList<String> arrayList4 = arrayList3;
                        ShuoshuoVideoInfo p16 = ag.p(context, next._id, next.path, next.fileSize, next.mVideoType, next.thumbnailPath, i16, i3, next.mStartTime, next.mDuration, next.mTotalDuration, next.needProcess, next.bundle);
                        if (p16 != null) {
                            str = ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI;
                        } else {
                            Context context2 = context;
                            long j3 = next._id;
                            String str2 = next.path;
                            long j16 = next.fileSize;
                            int i17 = next.mVideoType;
                            String str3 = next.thumbnailPath;
                            str = ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI;
                            p16 = ag.z(context2, j3, str2, j16, i17, str3, i16, i3, next.mStartTime, next.mDuration, next.mTotalDuration, next.needProcess, next.bundle, false);
                        }
                        p16.fakeVid = next.fakeVid;
                        p16.mDescription = cVar.f51934b;
                        p16.mIsUploadOrigin = next.mIsUploadOrigin;
                        if (next.isSyncToWeishi) {
                            z16 = true;
                            ag.w(p16, str, true);
                        } else {
                            z16 = true;
                        }
                        UploadVideoObject.setVideoType(cVar.f51946h, z16);
                        arrayList.add(new MediaWrapper(p16, p16.mNeedProcess));
                        arrayList3 = arrayList4;
                    } else {
                        arrayList = arrayList2;
                        ArrayList<String> arrayList5 = arrayList3;
                        it = it5;
                        if (QAlbumUtil.getMediaType(next) == 0) {
                            if (URLUtil.isNetworkUrl(next.path)) {
                                imageInfo = new ImageInfo();
                                imageInfo.mPath = next.path;
                            } else {
                                imageInfo = new ImageInfo(next.path);
                                imageInfo.panoramaType = next.panoramaPhotoType;
                            }
                            Map<String, byte[]> map2 = cVar.F;
                            if (map2 != null && map2.containsKey(next.path)) {
                                imageInfo.mExternalData.put(kExtKeyMarkUinBeforeUpload.value, cVar.F.get(next.path));
                            }
                            com.qzone.publish.ui.model.c cVar2 = cVar;
                            imageInfo.mDescription = cVar2.f51934b;
                            Map<String, String> map3 = cVar2.G;
                            if (map3 != null && map3.containsKey(next.path)) {
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("youtu_tag_array", cVar.G.get(next.path));
                                HashMap<String, String> hashMap2 = imageInfo.mPhotoTagInfo;
                                if (hashMap2 != null && hashMap2.size() > 0) {
                                    imageInfo.mPhotoTagInfo.putAll(hashMap);
                                } else {
                                    imageInfo.mPhotoTagInfo = hashMap;
                                }
                            }
                            imageInfo.photoWidth = i3;
                            imageInfo.photoHeight = i16;
                            arrayList.add(new MediaWrapper(imageInfo));
                            arrayList3 = arrayList5;
                            arrayList3.add(next.path);
                        } else {
                            arrayList3 = arrayList5;
                            if (QAlbumUtil.getMediaType(next) == 1) {
                                Context context3 = context;
                                long j17 = next._id;
                                String str4 = next.path;
                                long j18 = next.fileSize;
                                String str5 = next.thumbnailPath;
                                long j19 = next.mDuration;
                                ShuoshuoVideoInfo p17 = ag.p(context3, j17, str4, j18, 1, str5, i16, i3, 0L, j19, j19, next.needProcess, null);
                                if (p17 == null) {
                                    Context context4 = context;
                                    long j26 = next._id;
                                    String str6 = next.path;
                                    long j27 = next.fileSize;
                                    String str7 = next.thumbnailPath;
                                    long j28 = next.mDuration;
                                    p17 = ag.z(context4, j26, str6, j27, 1, str7, i16, i3, 0L, j28, j28, next.needProcess, null, false);
                                }
                                p17.mProcessMissionID = next.missionID;
                                p17.mDescription = cVar.f51934b;
                                if (next.isSyncToWeishi) {
                                    r16 = 1;
                                    ag.w(p17, ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, true);
                                } else {
                                    r16 = 1;
                                }
                                MediaWrapper mediaWrapper = new MediaWrapper(p17);
                                if (mediaWrapper.getVideoInfo().mNeedProcess == r16) {
                                    mediaWrapper.getVideoInfo().mNeedProcess = next.needProcess;
                                    mediaWrapper.getVideoInfo().mIsOriginalVideo = next.needProcess != r16 ? r16 : 0;
                                    mediaWrapper.getVideoInfo().mIsUploadOrigin = r16 ^ (next.needProcess ? 1 : 0);
                                } else if (!next.needProcess) {
                                    mediaWrapper.getVideoInfo().mNeedProcess = false;
                                    mediaWrapper.getVideoInfo().mIsOriginalVideo = r16;
                                    mediaWrapper.getVideoInfo().mIsUploadOrigin = r16;
                                }
                                arrayList.add(mediaWrapper);
                            }
                        }
                    }
                    arrayList2 = arrayList;
                    it5 = it;
                }
                ArrayList<MediaWrapper> arrayList6 = arrayList2;
                com.qzone.publish.ui.model.c cVar3 = cVar;
                cVar3.M = arrayList6;
                cVar3.P = arrayList3;
                QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = new QZoneUploadShuoShuoTask(67, 1, cVar);
                qZoneUploadShuoShuoTask.clientKey = UUID.randomUUID().toString();
                com.qzone.publish.ui.model.c cVar4 = cVar;
                qZoneUploadShuoShuoTask.uploadEntrance = cVar4.f51964z;
                qZoneUploadShuoShuoTask.refer = cVar4.I;
                PubAccountTaskQueue.t().b(qZoneUploadShuoShuoTask);
                ShuoshuoVideoInfo shuoshuoVideoInfo = cVar.f51946h;
                if (shuoshuoVideoInfo != null) {
                    shuoshuoVideoInfo.mIsFakeFeed = true;
                }
                if (arrayList3.size() > 0) {
                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList3.toArray());
                }
                QZoneWriteOperationService.w1(qZoneUploadShuoShuoTask);
            }
        });
    }

    public void W(Handler handler, String str, String str2, String str3, int i3, long j3, String str4, String str5, int i16, Map<Integer, String> map, int i17) {
        X(handler, str, str2, str3, i3, j3, str4, str5, i16, map, i17, "");
    }

    public void Z1(n nVar) {
        this.C.add(nVar);
    }

    public void b2(int i3, Handler handler, String str, String str2, String str3, int i16, long j3, long j16, User user, String str4, String str5, String str6, String str7, String str8, String str9, int i17, Map<Integer, String> map, String str10, boolean z16, int i18, int i19, Map<String, String> map2) {
        if (com.qzone.util.o.b(handler)) {
            return;
        }
        t5.a.b(str9);
        if (z16) {
            map.put(54, "tih");
        }
        QZoneTask qZoneTask = new QZoneTask(new QZoneAddReplyRequest(i3, i16, j3, j16, str4, str6, l.a(str7), str9, i17, map, str10, map2), handler, this, 3);
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        qZoneTask.addParameter("feedkey", str2);
        qZoneTask.addParameter("uniKey", str3);
        qZoneTask.addParameter("comment_id", str6);
        qZoneTask.addParameter("position", Integer.valueOf(i18));
        qZoneTask.addParameter("clickScene", Integer.valueOf(i19));
        if ("picture_viewer".equals(str10)) {
            qZoneTask.addParameter("src_refer", 2);
            qZoneTask.addParameter("albumid", str4);
            qZoneTask.addParameter("lloc", str5);
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        notify(5, str, str3, str6, str8, Long.valueOf(j3), user, str2, map2);
    }

    public void e0(Handler handler, String str, String str2) {
        QzoneDeleteSecretFeedRequest qzoneDeleteSecretFeedRequest = new QzoneDeleteSecretFeedRequest(str);
        QZoneTask qZoneTask = new QZoneTask(qzoneDeleteSecretFeedRequest, handler, this, 4);
        qzoneDeleteSecretFeedRequest.setCommandPrefix("Secret.");
        notify(8, str, str2);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        LpReportInfo_pf00064.allReport(302, 78);
    }

    public void e2(int i3, BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        ArrayList arrayList;
        if (businessFeedData != null && businessFeedData.getUser() != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().busiParam != null && businessFeedData.getOperationInfoV2().busiParam.containsKey(92)) {
            QZLog.i("[publish2]QZoneWriteOperationService", 1, "reportCardExposureSpecialCareInContainer");
            if (businessFeedData2 == null || businessFeedData2.getFeedCommInfoV2() == null || businessFeedData2.getOperationInfoV2().busiParam == null || !businessFeedData2.getOperationInfoV2().busiParam.containsKey(52)) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(businessFeedData2.getOperationInfoV2().busiParam.get(52));
                arrayList = arrayList2;
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneRecomRecportRequest(LoginData.getInstance().getUin(), 1, (short) businessFeedData.getFeedCommInfo().recomtype, i3, 3, businessFeedData.getOperationInfoV2().busiParam.get(92), arrayList), null, this, 40));
            return;
        }
        QZLog.e("[publish2]QZoneWriteOperationService", "reportCardExposureSpecialCareInContainer data null");
    }

    public void f2(int i3, long j3, int i16, Map<String, String> map) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneMobileClientActionReportRequest(i3, j3, i16, map), null, this, 43));
    }

    public void g2(Handler handler, String str, String str2) {
        QzoneReportSecretFeedRequest qzoneReportSecretFeedRequest = new QzoneReportSecretFeedRequest(str, str2);
        QZoneTask qZoneTask = new QZoneTask(qzoneReportSecretFeedRequest, handler, this, 46);
        qzoneReportSecretFeedRequest.setCommandPrefix("Secret.");
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        LpReportInfo_pf00064.allReport(302, 77);
    }

    public void h0(String str, String str2, int i3, long j3, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, long j16, String str7, int i16, Handler handler) {
        if (QZLog.isColorLevel()) {
            QZLog.d("share", 2, "iUrlInfoFrm:" + i16);
        }
        QZoneForwardRequest qZoneForwardRequest = new QZoneForwardRequest(str, Y1(str2), i3, j3, str3, str4, str5, arrayList, j16, str7, i16);
        if (!TextUtils.isEmpty(str6)) {
            qZoneForwardRequest.contentCacheUnikey = str6;
        }
        QZoneTask qZoneTask = new QZoneTask(qZoneForwardRequest, handler, this, 2);
        qZoneTask.addParameter("forwardType", 2);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void j2(Handler handler, String str, String str2, int i3, ArrayList<String> arrayList) {
        QZoneTask qZoneTask = new QZoneTask(new QZonePublishMoodRequest(str, 2, i3, arrayList), handler, this, 60);
        qZoneTask.addParameter(s4.c.UGCKEY, str2);
        qZoneTask.addParameter("privType", Integer.valueOf(i3));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        LpReportInfo_pf00064.allReport(121, 1);
    }

    public void m2(long j3, ArrayList<nagative_fb_info> arrayList) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneNegativeFeedBackRequest(j3, arrayList), null, this, 52));
    }

    public void p1(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(VideoCompressTask.KEY_HANDLE_RESULT, false);
        String stringExtra = intent.getStringExtra("client_key");
        String stringExtra2 = intent.getStringExtra(VideoCompressTask.KEY_DEST_PATH);
        String str = this.f45609m.get(stringExtra);
        if (!TextUtils.isEmpty(str)) {
            x1(str, stringExtra2, booleanExtra, intent);
        }
        this.f45608i.remove(stringExtra);
        this.f45609m.remove(stringExtra);
    }

    public void p2(n nVar) {
        this.C.remove(nVar);
    }

    public void q0(String str, String str2, int i3, int i16, long j3, String str3, ArrayList<String> arrayList, String str4, String str5, String str6, ArrayList<String> arrayList2, int i17, int i18, int i19, String str7, int i26, String str8, int i27, Map<Integer, String> map, Handler handler, String str9, boolean z16, boolean z17, Map<String, ArrayList<String>> map2, int i28, boolean z18, BusinessFeedData businessFeedData) {
        r0(str, str2, i3, i16, j3, str3, arrayList, str4, str5, str6, arrayList2, i17, i18, i19, str7, i26, str8, i27, map, handler, str9, z16, z17, map2, i28, z18, false, businessFeedData);
    }

    public void q2(Handler handler, String str, String str2, byte[] bArr, DittoHost.SilentRequestCallback silentRequestCallback) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneUniversalRequest(str, str2, bArr, silentRequestCallback), handler, this, 65));
    }

    public void r0(String str, String str2, int i3, int i16, long j3, String str3, ArrayList<String> arrayList, String str4, String str5, String str6, ArrayList<String> arrayList2, int i17, int i18, int i19, String str7, int i26, String str8, int i27, Map<Integer, String> map, Handler handler, String str9, boolean z16, boolean z17, Map<String, ArrayList<String>> map2, int i28, boolean z18, boolean z19, BusinessFeedData businessFeedData) {
        char c16;
        boolean z26;
        if (z16) {
            map.put(54, "tih");
        }
        int i29 = i27 <= 0 ? 0 : i27;
        int i36 = (1 << i26) | 0;
        boolean z27 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(aa.g(businessFeedData))) ? false : true;
        String uuid = UUID.randomUUID().toString();
        if (z17 && !z27) {
            i36 |= 8388608;
            notify(3, str, uuid, str4, Long.valueOf(j3), "", null, "");
        }
        QZoneTask qZoneTask = new QZoneTask(new QZoneForwardRequest(i3, i16, j3, str3, arrayList, str4, str5, str6, arrayList2, i17, i18, i19, str7, i36, str8, i29, map, str9, map2), handler, this, 2);
        qZoneTask.addParameter("forwardType", Integer.valueOf(i26));
        qZoneTask.addParameter("clickScene", Integer.valueOf(i28));
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        qZoneTask.addParameter("relative_ugckey", str2);
        qZoneTask.addParameter("isRapid", Boolean.valueOf(z18));
        qZoneTask.addParameter("feeddata", businessFeedData);
        qZoneTask.addParameter("isLongClick", Boolean.valueOf(z19));
        qZoneTask.addParameter("uniKey", uuid);
        if (businessFeedData != null) {
            qZoneTask.addParameter("feedtype", Integer.valueOf(businessFeedData.feedType));
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        if (businessFeedData != null) {
            c16 = 1;
            if (businessFeedData.getUser().isSafeModeUser != 1) {
                z26 = true;
                char c17 = (com.qzone.reborn.feedx.itemview.d.d(businessFeedData) || !z17 || TextUtils.isEmpty(str4)) ? (char) 0 : c16;
                if (z26 && c17 == 0) {
                    Object[] objArr = new Object[2];
                    objArr[0] = str;
                    objArr[c16] = str2;
                    notify(9, objArr);
                }
                VasLogReporter.getQzoneFeedsCard().report("send forwardFeed with comment:" + str4);
            }
        } else {
            c16 = 1;
        }
        z26 = false;
        if (com.qzone.reborn.feedx.itemview.d.d(businessFeedData)) {
        }
        if (z26) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = str;
            objArr2[c16] = str2;
            notify(9, objArr2);
        }
        VasLogReporter.getQzoneFeedsCard().report("send forwardFeed with comment:" + str4);
    }

    public void s0(String str, String str2, int i3, int i16, long j3, String str3, ArrayList<String> arrayList, String str4, String str5, String str6, ArrayList<String> arrayList2, int i17, int i18, int i19, String str7, int i26, String str8, int i27, Map<Integer, String> map, Handler handler, String str9, boolean z16, boolean z17, Map<String, ArrayList<String>> map2, BusinessFeedData businessFeedData) {
        q0(str, str2, i3, i16, j3, str3, arrayList, str4, str5, str6, arrayList2, i17, i18, i19, str7, i26, str8, i27, map, handler, str9, z16, z17, map2, -1, false, businessFeedData);
    }

    public void t0(String str, String str2, String str3, int i3, long j3, String str4, String str5, String str6, ArrayList<String> arrayList, Handler handler, String str7, int i16, boolean z16) {
        QZoneForwardRequest qZoneForwardRequest = new QZoneForwardRequest(str2, str3, i3, j3, str4, str5, str6, arrayList, 0L, null, -1);
        qZoneForwardRequest.contentCacheUnikey = str7;
        QZoneTask qZoneTask = new QZoneTask(qZoneForwardRequest, handler, this, 2);
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        qZoneTask.addParameter("clickScene", Integer.valueOf(i16));
        qZoneTask.addParameter("isRapid", Boolean.valueOf(z16));
        qZoneTask.addParameter("forwardType", 1);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void t2(ShuoshuoVideoInfo shuoshuoVideoInfo, int i3, boolean z16, Map<String, String> map, LbsDataV2.PoiInfo poiInfo, LbsDataV2.GpsInfo gpsInfo, String str, String str2) {
        String str3;
        String str4;
        QZoneUploadVideoCoverTask qZoneUploadVideoCoverTask = new QZoneUploadVideoCoverTask(shuoshuoVideoInfo, r7.a.a(), 26, z16, map, poiInfo, gpsInfo, str);
        qZoneUploadVideoCoverTask.uploadEntrance = i3;
        String uuid = UUID.randomUUID().toString();
        qZoneUploadVideoCoverTask.clientKey = uuid;
        QZonePublishQueue.w().b(qZoneUploadVideoCoverTask);
        CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
        CoverCacheData coverFromCache = coverComponentProxy.getServiceInterface().getCoverFromCache(LoginData.getInstance().getUin());
        if (coverFromCache != null) {
            shuoshuoVideoInfo.mIsFakeFeed = true;
            VideoInfo n26 = n2(shuoshuoVideoInfo);
            if (n26 != null) {
                PictureUrl pictureUrl = n26.coverUrl;
                if (pictureUrl == null) {
                    str3 = "";
                } else {
                    str3 = pictureUrl.url;
                }
                VideoUrl videoUrl = n26.videoUrl;
                if (videoUrl == null) {
                    str4 = "";
                } else {
                    str4 = videoUrl.url;
                }
                CoverCacheData fillVideoCoverDataWithLocalData = coverComponentProxy.getServiceInterface().fillVideoCoverDataWithLocalData(coverFromCache, n26.videoId, str3, str4, n26.width, n26.height, n26.videoTime, uuid, str2);
                coverComponentProxy.getServiceInterface().saveCoverIntoCache(fillVideoCoverDataWithLocalData);
                EventCenter.getInstance().post("Personalize", 8, fillVideoCoverDataWithLocalData);
                com.qzone.adapter.feedcomponent.i.H().O1(qZoneUploadVideoCoverTask.getCommentUniKey(), n26);
            }
        }
    }

    public int u0() {
        return QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_CIRCLE_PLAY_SECOND_FAKEFEED_VALIDTIME, 4499);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean C;
        final /* synthetic */ int D;
        final /* synthetic */ boolean E;
        final /* synthetic */ int F;
        final /* synthetic */ Map G;
        final /* synthetic */ BusinessFeedData H;
        final /* synthetic */ boolean I;
        final /* synthetic */ boolean J;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f45633d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f45634e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f45635f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f45636h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Handler f45637i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f45638m;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(this.f45633d, this.f45634e, this.f45635f, this.f45636h), this.f45637i, QZoneWriteOperationService.this, 56);
            qZoneTask.addParameter("feedkey", this.f45638m);
            qZoneTask.addParameter("isSpecialFollow", Boolean.valueOf(this.C));
            qZoneTask.addParameter("position", Integer.valueOf(this.D));
            qZoneTask.addParameter("need_adv_report", Boolean.valueOf(this.E));
            qZoneTask.addParameter("clickScene", Integer.valueOf(this.F));
            qZoneTask.addParameter("cookie", this.G);
            qZoneTask.addParameter("feedData", this.H);
            qZoneTask.addParameter("isinstalled", Boolean.valueOf(this.I));
            qZoneTask.addParameter("uin", Long.valueOf(this.f45633d));
            qZoneTask.addParameter("isForward", Boolean.valueOf(this.J));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }

        c(long j3, int i3, int i16, Map map, Handler handler, String str, boolean z16, int i17, boolean z17, int i18, Map map2, BusinessFeedData businessFeedData, boolean z18, boolean z19) {
            this.f45633d = j3;
            this.f45634e = i3;
            this.f45635f = i16;
            this.f45636h = map;
            this.f45637i = handler;
            this.f45638m = str;
            this.C = z16;
            this.D = i17;
            this.E = z17;
            this.F = i18;
            this.G = map2;
            this.H = businessFeedData;
            this.I = z18;
            this.J = z19;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45639a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f45640b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f45641c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f45642d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f45643e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LbsDataV2.PoiInfo f45644f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f45645g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QZonePreUploadInfo f45646h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f45647i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f45648j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f45649k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f45650l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Map f45651m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ Map f45652n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ ArrayList f45653o;

        e(long j3, int i3, List list, BusinessAlbumInfo businessAlbumInfo, int i16, LbsDataV2.PoiInfo poiInfo, String str, QZonePreUploadInfo qZonePreUploadInfo, Map map, int i17, int i18, String str2, Map map2, Map map3, ArrayList arrayList) {
            this.f45639a = j3;
            this.f45640b = i3;
            this.f45641c = list;
            this.f45642d = businessAlbumInfo;
            this.f45643e = i16;
            this.f45644f = poiInfo;
            this.f45645g = str;
            this.f45646h = qZonePreUploadInfo;
            this.f45647i = map;
            this.f45648j = i17;
            this.f45649k = i18;
            this.f45650l = str2;
            this.f45651m = map2;
            this.f45652n = map3;
            this.f45653o = arrayList;
        }

        @Override // com.qzone.common.business.service.QZoneWriteOperationService.q
        public void a(long j3) {
            if (com.qzone.publish.business.publishqueue.h.c(this.f45639a)) {
                return;
            }
            QZoneWriteOperationService.this.g0(this.f45640b, this.f45641c, this.f45642d, this.f45643e, this.f45644f, this.f45639a, j3, this.f45645g, this.f45646h, this.f45647i, this.f45648j, this.f45649k, this.f45650l, this.f45651m, this.f45652n, this.f45653o);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f45656b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f45657c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f45658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f45659e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LbsDataV2.PoiInfo f45660f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f45661g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QZonePreUploadInfo f45662h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f45663i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f45664j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f45665k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f45666l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Map f45667m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ Map f45668n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ ArrayList f45669o;

        f(long j3, String str, int i3, List list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map map, int i16, int i17, String str3, Map map2, Map map3, ArrayList arrayList) {
            this.f45655a = j3;
            this.f45656b = str;
            this.f45657c = i3;
            this.f45658d = list;
            this.f45659e = businessAlbumInfo;
            this.f45660f = poiInfo;
            this.f45661g = str2;
            this.f45662h = qZonePreUploadInfo;
            this.f45663i = map;
            this.f45664j = i16;
            this.f45665k = i17;
            this.f45666l = str3;
            this.f45667m = map2;
            this.f45668n = map3;
            this.f45669o = arrayList;
        }

        @Override // com.qzone.common.business.service.QZoneWriteOperationService.q
        public void a(long j3) {
            if (com.qzone.publish.business.publishqueue.h.c(this.f45655a)) {
                return;
            }
            QZoneWriteOperationService.this.m0(this.f45656b, this.f45657c, this.f45658d, this.f45659e, this.f45660f, this.f45655a, j3, this.f45661g, this.f45662h, this.f45663i, this.f45664j, this.f45665k, this.f45666l, this.f45667m, this.f45668n, this.f45669o);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45671a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f45672b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f45673c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f45674d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f45675e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LbsDataV2.PoiInfo f45676f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f45677g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QZonePreUploadInfo f45678h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f45679i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f45680j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f45681k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f45682l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Map f45683m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ Map f45684n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ ArrayList f45685o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ String f45686p;

        g(long j3, String str, int i3, List list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map map, int i16, int i17, String str3, Map map2, Map map3, ArrayList arrayList, String str4) {
            this.f45671a = j3;
            this.f45672b = str;
            this.f45673c = i3;
            this.f45674d = list;
            this.f45675e = businessAlbumInfo;
            this.f45676f = poiInfo;
            this.f45677g = str2;
            this.f45678h = qZonePreUploadInfo;
            this.f45679i = map;
            this.f45680j = i16;
            this.f45681k = i17;
            this.f45682l = str3;
            this.f45683m = map2;
            this.f45684n = map3;
            this.f45685o = arrayList;
            this.f45686p = str4;
        }

        @Override // com.qzone.common.business.service.QZoneWriteOperationService.q
        public void a(long j3) {
            if (com.qzone.publish.business.publishqueue.h.c(this.f45671a)) {
                return;
            }
            QZoneWriteOperationService.this.j0(this.f45672b, this.f45673c, this.f45674d, this.f45675e, this.f45676f, this.f45671a, j3, this.f45677g, this.f45678h, this.f45679i, this.f45680j, this.f45681k, this.f45682l, this.f45683m, this.f45684n, this.f45685o, this.f45686p);
        }
    }

    private void a1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        final QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask = (QZoneUploadShuoShuoTask) qZoneTask;
        if (qZoneUploadShuoShuoTask.mResultCode == -11258) {
            notify(42, qZoneTask);
            return;
        }
        if ((qZoneUploadShuoShuoTask.getTotalImgCount() > 0 && qZoneUploadShuoShuoTask.isUploadMoodStep()) || qZoneUploadShuoShuoTask.isDynamicTask()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.15
                @Override // java.lang.Runnable
                public void run() {
                    QZoneWriteOperationService.this.A0(qZoneUploadShuoShuoTask);
                }
            }, 1000L);
            return;
        }
        BusinessFeedData y06 = y0(qZoneTask, (HashMap) qZoneUploadShuoShuoTask.getLocalUrlMap(), 4097);
        if (y06 == null) {
            return;
        }
        String str = qZoneTask.clientKey;
        QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask2 = (QZoneUploadShuoShuoTask) qZoneTask;
        ShuoshuoVideoInfo videoInfo = qZoneUploadShuoShuoTask2.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.mIsFakeFeed = false;
            VideoInfo n26 = n2(videoInfo);
            if (n26.videoTime <= u0()) {
                n26.validVideoTime = u0();
                if (n26.playType == 1) {
                    n26.playType = (byte) 3;
                }
            }
            y06.setVideoInfo(n26);
            y06.getLocalInfo().setHalfReal();
            com.qzone.adapter.feedcomponent.i.H().O1(qZoneUploadShuoShuoTask.getCommentUniKey(), n26);
        }
        if (qZoneUploadShuoShuoTask2.isTemplateShuoshuo()) {
            if (y06.getPictureInfo() != null && y06.getPictureInfo().pics != null && y06.getPictureInfo().pics.size() > 0) {
                y06.getPictureInfo().pics.get(0).audio_summary = qZoneUploadShuoShuoTask2.getAudioSummary();
            }
            if (y06.getCellSummaryV2() != null && !TextUtils.isEmpty(y06.getCellSummaryV2().summary)) {
                y06.getCellSummaryV2().summary = "";
            }
        }
        y06.getPermissionInfo().permission_mask |= 1;
        LbsDataV2.PoiInfo poiInfo = qZoneUploadShuoShuoTask2.getPoiInfo();
        if (poiInfo != null) {
            if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                y06.getLbsInfo().location = poiInfo.poiDefaultName;
            } else {
                y06.getLbsInfo().location = poiInfo.address;
            }
        }
        y06.preCalculate();
        notify(2, str, y06);
        String contentCacheUnikey = qZoneTask.mRequest.getContentCacheUnikey();
        if (TextUtils.isEmpty(contentCacheUnikey)) {
            return;
        }
        if (!contentCacheUnikey.equals("content_cache_key_default_value")) {
            t5.a.b(qZoneTask.mRequest.getContentCacheUnikey());
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AniversayFeedShareToQzoneSuccess", "\u5206\u4eab\u6210\u529f");
        if (qZoneTask.succeeded()) {
            ToastUtil.s(config, 5);
        }
    }

    private void l1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        notify(11, qZoneTask.clientKey, y0(qZoneTask, (HashMap) ((QZoneUploadPicTask) qZoneTask).getLocalUrlMap(), 4097));
        ((IWinkAPI) QRoute.api(IWinkAPI.class)).notifyZoneWriteOperation(11);
        if ((qZoneTask instanceof QZoneUploadPicTask) && ((QZoneUploadPicTask) qZoneTask).getUploadEntrance() == 11) {
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM_UPLOAD_SUCCESS);
        }
    }

    private void m1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        BusinessFeedData y06 = y0(qZoneTask, (HashMap) ((QZoneUploadAlbumVideoTask) qZoneTask).getLocalUrlMap(), 4097);
        if (y06.cellLocalInfo != null) {
            VideoInfo videoInfo = y06.getVideoInfo();
            if (videoInfo == null && y06.getOriginalInfo() != null) {
                videoInfo = y06.getOriginalInfo().getVideoInfo();
            }
            if (videoInfo != null) {
                y06.cellLocalInfo.videoLocalUrl = C0(videoInfo.videoId);
                RFWLog.d("[publish2]QZoneWriteOperationService", RFWLog.USR, "handleUploadSingalVideoTaskResponse: " + y06.cellLocalInfo.videoLocalUrl + ", task.clientKey: " + qZoneTask.clientKey + ", videoId: " + videoInfo.videoId);
            }
        }
        notify(45, qZoneTask.clientKey, y06);
    }

    public void G1(String str, String str2, int i3) {
        notify(15, str, str2, Integer.valueOf(i3));
    }

    public void H1(String str, String str2) {
        notify(8, str, str2);
    }

    public void I1(o oVar) {
        notify(16, oVar.f45760a, oVar.f45763d, oVar.f45764e);
    }

    public void N1(String str, String str2, int i3) {
        notify(72, str, str2, Integer.valueOf(i3));
    }

    public void Y(Handler handler, String str, String str2, String str3, int i3, long j3, int i16, long j16, Map<Integer, String> map) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneDeleteMyFeedRequest(i3, j3, i16, str2, j16, map, str3), handler, this, 25);
        notify(36, str, str3);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void k2(Handler handler, String str, String str2) {
        notify(8, str, str2);
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneShieldSecretFeedRequest(LoginData.getInstance().getUin()), handler, this, 47));
    }

    private void U0(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        JceStruct jceStruct;
        if (qZoneTask == null || (qZoneRequest = qZoneTask.mRequest) == null || (jceStruct = qZoneRequest.rsp) == null) {
            return;
        }
        bmp4_set_rsp bmp4_set_rspVar = (bmp4_set_rsp) jceStruct;
        if (bmp4_set_rspVar == null) {
            w5.b.a("[publish2]QZoneWriteOperationService", 1, "handleHighFiveNotifyResponse, High Five, rsp is null!");
            return;
        }
        if (bmp4_set_rspVar.retCode == 0) {
            int G = u5.b.G("highFiveNotifyStatus", -1);
            w5.b.a("[publish2]QZoneWriteOperationService", 1, "handleHighFiveNotifyResponse, High Five, currentStatus = " + G);
            if (G == 0) {
                u5.b.q0("highFiveNotifyStatus", 1);
                LpReportInfo_pf00064.allReport(112, 2);
                return;
            } else {
                if (G == 1) {
                    u5.b.q0("highFiveNotifyStatus", 0);
                    LpReportInfo_pf00064.allReport(112, 1);
                    return;
                }
                return;
            }
        }
        w5.b.a("[publish2]QZoneWriteOperationService", 1, "handleHighFiveNotifyResponse, Hihg Five, retCode = " + bmp4_set_rspVar.retCode + ", msg = " + bmp4_set_rspVar.errmsg);
    }

    private QZoneResult b1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QZoneRequest qZoneRequest;
        BusinessAlbumInfo businessAlbumInfo;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && qZoneRequest.rsp != null) {
            qZoneResult = qZoneTask.getResult(999969);
            QZoneRequest qZoneRequest2 = qZoneTask.mRequest;
            try {
                QZoneQueryAlbumRequest.a onJceRespParse = ((QZoneQueryAlbumRequest) qZoneRequest2).onJceRespParse(qZoneRequest2.rsp);
                if (onJceRespParse != null && (businessAlbumInfo = onJceRespParse.f43973b) != null) {
                    qZoneResult.setData(businessAlbumInfo);
                }
            } catch (Exception e16) {
                QZLog.e("[publish2]QZoneWriteOperationService", 2, "TASK_TYPE_QUERY_ALBUM parse failed!! ", e16);
            }
        }
        return qZoneResult;
    }

    private boolean r1(BusinessFeedData businessFeedData, int i3, String str, boolean z16, boolean z17) {
        if (businessFeedData == null || !businessFeedData.isGDTAdvFeed()) {
            return false;
        }
        return i3 == 5001 || i3 == 5000 || !TextUtils.isEmpty(str) || !(z17 || s1(i3));
    }

    private static String w0(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
            return poiInfo.poiDefaultName;
        }
        if (!TextUtils.isEmpty(poiInfo.poiName)) {
            return poiInfo.poiName;
        }
        return poiInfo.address;
    }

    private void y1(QZoneTask qZoneTask) {
        String str;
        if (qZoneTask.mRequest == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000112);
        try {
            JceStruct jceStruct = qZoneTask.mRequest.req;
            if (((mobile_sub_concern_req) jceStruct).isconcern != 3) {
                int i3 = ((mobile_sub_concern_req) jceStruct).isconcern;
            }
        } catch (Exception e16) {
            QZLog.e("[publish2]QZoneWriteOperationService", e16.toString());
        }
        mobile_sub_concern_rsp mobile_sub_concern_rspVar = (mobile_sub_concern_rsp) qZoneTask.mRequest.rsp;
        if (mobile_sub_concern_rspVar == null || mobile_sub_concern_rspVar.ret != 0) {
            result.setSucceed(false);
            if (mobile_sub_concern_rspVar != null) {
                qZoneTask.mResultCode = mobile_sub_concern_rspVar.ret;
            }
        }
        boolean booleanValue = ((Boolean) qZoneTask.getParameter("isFollow")).booleanValue();
        long longValue = ((Long) qZoneTask.getParameter("uin")).longValue();
        int intValue = ((Integer) qZoneTask.getParameter("position")).intValue();
        boolean booleanValue2 = ((Boolean) qZoneTask.getParameter("need_adv_report")).booleanValue();
        int intValue2 = ((Integer) qZoneTask.getParameter("follow_source")).intValue();
        Map map = (Map) qZoneTask.getParameter("cookie");
        BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feedData");
        int intValue3 = ((Integer) qZoneTask.getParameter("clickScene")).intValue();
        boolean booleanValue3 = ((Boolean) qZoneTask.getParameter("isinstalled")).booleanValue();
        if (businessFeedData != null && booleanValue2 && booleanValue) {
            if (businessFeedData.isGDTAdvFeed()) {
                str = null;
                AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "QZoneWriteOperationService::onFollowFamous", "");
                GdtFeedUtilForQZone.A(new AdClickData.Builder().setFeedData(businessFeedData).setFeedIndex(intValue).setAreaId(8).setSceneId(intValue3).create());
                com.qzone.misc.network.report.f.g(businessFeedData);
            } else {
                str = null;
                if (businessFeedData.isAdFeeds() && businessFeedData.getLocalInfo() != null && businessFeedData.getLocalInfo().canLike && businessFeedData.getLocalInfo().canComment) {
                    if (businessFeedData.feedType != 4097 && (!businessFeedData.isSubFeed || businessFeedData.parentFeedData.feedType != 4097)) {
                        r6.a.y(businessFeedData, 5001, 0, 0, com.qzone.misc.network.report.f.i(2, 8));
                    } else if (BaseFeedPresenter.J(businessFeedData, 5) == -1) {
                        r6.a.w(businessFeedData, 13, 0, 0);
                    } else {
                        r6.a.x(businessFeedData, BaseFeedPresenter.M(businessFeedData, 0, 5), 0, 0, 0, com.qzone.misc.network.report.f.j(2, 8, 0));
                    }
                } else {
                    BaseFeedPresenter.q0(map, 13, qZoneTask.mResultCode, intValue + 1, 21, 0, false, booleanValue3, null, null, 0L, false, false, null, false, businessFeedData, 4, intValue3, 8, -1, false);
                }
            }
        } else {
            str = null;
            if (businessFeedData != null && !booleanValue && businessFeedData.isGDTAdvFeed()) {
                com.qzone.misc.network.report.f.f(businessFeedData);
            }
        }
        if (result.getSucceed()) {
            if (intValue2 == 5) {
                ToastUtil.s(com.qzone.util.l.a(booleanValue ? R.string.shi : R.string.shj), 5);
            } else {
                ToastUtil.h(booleanValue, longValue);
            }
        }
        result.getBundle().putBoolean("isFollow", booleanValue);
        result.getBundle().putLong("uin", ((Long) qZoneTask.getParameter("uin")).longValue());
        result.getBundle().putInt("position", intValue);
        qZoneTask.sendResultMsg(result);
        if (result.getSucceed()) {
            Object[] objArr = new Object[4];
            if (businessFeedData != null) {
                str = businessFeedData.getFeedCommInfo().ugckey;
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(booleanValue);
            objArr[2] = (Long) qZoneTask.getParameter("uin");
            objArr[3] = (Boolean) qZoneTask.getParameter("isForward");
            notify(37, objArr);
        }
    }

    public void J(int i3, BusinessFeedData businessFeedData, int i16) {
        if (businessFeedData != null) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneRecomRecportRequest(LoginData.getInstance().getUin(), 1, (short) businessFeedData.getFeedCommInfo().recomtype, i3, i16, businessFeedData.getOperationInfoV2().busiParam.get(92), null), null, this, 41));
        } else {
            QZLog.e("[publish2]QZoneWriteOperationService", "advFeedBack data null");
        }
    }

    public void T(Handler handler, BusinessFeedData businessFeedData, Comment comment) {
        String str;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        long j3 = businessFeedData.getUser().uin;
        if (businessFeedData.getFeedCommInfo().appid == 334 && businessFeedData.getOperationInfo().busiParam != null) {
            try {
                j3 = Long.valueOf(businessFeedData.getOperationInfo().busiParam.get(14)).longValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        long j16 = j3;
        String str2 = businessFeedData.getFeedCommInfo().ugckey;
        long j17 = businessFeedData.getFeedCommInfo().appid;
        String str3 = businessFeedData.getIdInfo().cellId;
        long j18 = comment.user.uin;
        boolean z16 = comment.isFake;
        if (z16) {
            str = comment.fakeUniKey;
        } else {
            str = comment.commentid;
        }
        S(0, handler, str2, j17, j16, str3, j18, str, 0, map, z16, comment.time, 0);
    }

    public void T1(String str, Handler handler) {
        if (str == null) {
            str = "";
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneQueryAlbumRequest(str, TextUtils.isEmpty(str) ? 1 : 0), handler, this, 55));
    }

    public void U1(String str, String str2, ArrayList<NetImageInfo> arrayList, String str3, long j3, long j16, Handler handler) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        QzoneQuotePicFromAIOToQZoneTask qzoneQuotePicFromAIOToQZoneTask = new QzoneQuotePicFromAIOToQZoneTask(24, str, str2, r7.a.a() / 1000, UUID.randomUUID().toString(), str3, j3, j16, arrayList);
        qzoneQuotePicFromAIOToQZoneTask.addParameter("albumid", str);
        qzoneQuotePicFromAIOToQZoneTask.setHandler(handler);
        QZonePublishQueue.w().b(qzoneQuotePicFromAIOToQZoneTask);
    }

    public void V1(String str, String str2, String str3, ArrayList<NetImageInfo> arrayList, String str4) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        QzoneQuotePicFromQunTask qzoneQuotePicFromQunTask = new QzoneQuotePicFromQunTask(22, str, str2, str3, r7.a.a() / 1000, UUID.randomUUID().toString(), arrayList, str4);
        qzoneQuotePicFromQunTask.addParameter(v4.a.QUNID, str);
        qzoneQuotePicFromQunTask.addParameter("albumid", str2);
        QZonePublishQueue.w().b(qzoneQuotePicFromQunTask);
    }

    public void W1(String str, BusinessAlbumInfo businessAlbumInfo, long j3, List<NetImageInfo> list, String str2, String str3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0(str, new a(list, str, businessAlbumInfo, j3, str2, str3));
    }

    public void a2(HashMap<String, String> hashMap, BusinessFeedData businessFeedData) {
        VideoInfo videoInfo;
        if (hashMap != null) {
            o0(hashMap);
        }
        if (hashMap != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null) {
            for (int i3 = 0; i3 < businessFeedData.getPictureInfo().pics.size(); i3++) {
                PictureItem pictureItem = businessFeedData.getPictureInfo().pics.get(i3);
                if (pictureItem.videoflag == 1 && (videoInfo = pictureItem.videodata) != null) {
                    String str = hashMap.get(videoInfo.videoId);
                    if (!TextUtils.isEmpty(str)) {
                        PictureUrl pictureUrl = pictureItem.currentUrl;
                        if (pictureUrl != null) {
                            pictureUrl.url = str;
                        }
                        pictureItem.localFileUrl = str;
                        VideoInfo videoInfo2 = pictureItem.videodata;
                        PictureUrl pictureUrl2 = videoInfo2.currentUrl;
                        if (pictureUrl2 != null) {
                            pictureUrl2.url = str;
                        }
                        VideoUrl videoUrl = videoInfo2.videoUrl;
                        if (videoUrl != null) {
                            videoUrl.url = str;
                        }
                        videoInfo2.playType = (byte) 0;
                        videoInfo2.videoShowType = 0;
                    }
                }
                if (TextUtils.isEmpty(pictureItem.clientFakeKey)) {
                    pictureItem.clientFakeKey = pictureItem.lloc;
                }
                if (hashMap.containsKey(pictureItem.clientFakeKey)) {
                    String str2 = hashMap.get(pictureItem.clientFakeKey);
                    if (!TextUtils.isEmpty(str2)) {
                        BitmapFactory.Options G = !URLUtil.isNetworkUrl(str2) ? com.qzone.util.image.c.G(str2) : null;
                        pictureItem.localFileUrl = str2;
                        if (G != null) {
                            if ("image/gif".equalsIgnoreCase(G.outMimeType)) {
                                pictureItem.currentUrl.pictureType = 2;
                                pictureItem.type = 2;
                            }
                            if (G.outWidth * 5 <= G.outHeight) {
                                pictureItem.setChangtuFlag(true);
                            }
                        }
                    }
                }
            }
            return;
        }
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        this.f45604d.putAll(hashMap);
    }

    public void n0(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QZoneWriteOperationService encodeRecordVideo start");
        String uuid = UUID.randomUUID().toString();
        this.f45609m.put(uuid, shuoshuoVideoInfo.mVideoPath);
        this.f45608i.add(uuid);
        Message obtain = Message.obtain();
        obtain.what = 1001;
        Intent intent = new Intent();
        intent.putExtra("client_key", uuid);
        intent.putExtra("video_source_path", shuoshuoVideoInfo.mVideoPath);
        intent.putExtra("video_type", shuoshuoVideoInfo.mVideoType);
        intent.putExtra("start_time", shuoshuoVideoInfo.mStartTime);
        intent.putExtra("end_time", shuoshuoVideoInfo.mEndTime);
        intent.putExtra(VideoCompressTask.KEY_NEED_ORIGIN, shuoshuoVideoInfo.mIsUploadOrigin);
        intent.putExtra(VideoCompressTask.KEY_TOTAL_DURATION, shuoshuoVideoInfo.mTotalDuration);
        intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, shuoshuoVideoInfo.mExtras);
        intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, shuoshuoVideoInfo.fakeVid);
        intent.putExtra(VideoCompressTask.KEY_NO_DELETE_FILE, true);
        obtain.obj = intent;
        RemoteVideoServiceHandler.j().n(obtain);
        RemoteVideoServiceHandler.j().g(uuid);
    }

    public void r2(int i3, List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i16, LbsDataV2.PoiInfo poiInfo, long j3, String str, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i17, int i18, String str2, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList) {
        if (businessAlbumInfo == null) {
            QZLog.w("upload2_QZoneWriteOperationService", "uploadPic albumInfo null");
            return;
        }
        long a16 = r7.a.a();
        if (j3 == 0) {
            z0(businessAlbumInfo.getId(), new e(a16, i3, list, businessAlbumInfo, i16, poiInfo, str, qZonePreUploadInfo, map, i17, i18, str2, map2, map3, arrayList));
            return;
        }
        QZLog.i("upload2_QZoneWriteOperationService", 1, "success uploadPic.svrtime--" + j3 + ",time=" + (System.currentTimeMillis() / 1000));
        g0(i3, list, businessAlbumInfo, i16, poiInfo, a16, j3, str, qZonePreUploadInfo, map, i17, i18, str2, map2, map3, arrayList);
    }

    public void s2(int i3, List<ImageInfo> list, String str, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, int i16, QZonePreUploadInfo qZonePreUploadInfo, String str2, String str3, int i17) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        if (businessAlbumInfo == null) {
            QZLog.w("upload2_QZoneWriteOperationService", "uploadQunPic albumInfo null");
            return;
        }
        long a16 = r7.a.a() / 1000;
        long j3 = businessAlbumInfo.mSvrTime;
        if (j3 == 0) {
            x0(str, new j(a16));
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("upload2_QZoneWriteOperationService", 2, "succe uploadPic.svrtime--" + j3 + ",time=" + (System.currentTimeMillis() / 1000));
        }
    }

    public void u2(String str, int i3, List<MediaWrapper> list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, long j3, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i16, int i17, String str3, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList) {
        if (businessAlbumInfo != null && list != null) {
            int i18 = 0;
            MediaWrapper mediaWrapper = null;
            boolean z16 = true;
            for (MediaWrapper mediaWrapper2 : list) {
                if (mediaWrapper2.isVideo()) {
                    i18++;
                    mediaWrapper = mediaWrapper2;
                } else {
                    z16 = false;
                }
            }
            boolean z17 = (!z16 || i18 <= 1) ? z16 : false;
            long a16 = r7.a.a();
            if (z17 && mediaWrapper != null) {
                ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) com.qzone.publish.utils.d.a(mediaWrapper.getVideoInfo());
                if (shuoshuoVideoInfo != null) {
                    k0(str, i3, shuoshuoVideoInfo, null, businessAlbumInfo, mediaWrapper.getQuality(), poiInfo, a16, j3, str2, qZonePreUploadInfo, map, i16, i17, str3, map2, map3);
                    return;
                } else {
                    QZLog.w("upload2_QZoneWriteOperationService", "uploadVideoPic2Album singleVideo, videoInfo null");
                    return;
                }
            }
            if (j3 == 0) {
                z0(businessAlbumInfo.getId(), new f(a16, str, i3, list, businessAlbumInfo, poiInfo, str2, qZonePreUploadInfo, map, i16, i17, str3, map2, map3, arrayList));
                return;
            }
            QZLog.i("upload2_QZoneWriteOperationService", 1, "success ServerTime -- " + j3 + ", time=" + (System.currentTimeMillis() / 1000));
            m0(str, i3, list, businessAlbumInfo, poiInfo, a16, j3, str2, qZonePreUploadInfo, map, i16, i17, str3, map2, map3, arrayList);
            return;
        }
        QZLog.w("upload2_QZoneWriteOperationService", "uploadVideoPic2Album invalid params !");
    }

    public void v2(String str, int i3, List<MediaWrapper> list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, long j3, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i16, int i17, String str3, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList, String str4) {
        if (businessAlbumInfo != null && list != null) {
            Iterator<MediaWrapper> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().isVideo()) {
                }
            }
            long a16 = (r7.a.a() / 1000) % 10000000;
            QZLog.w("upload2_QZoneWriteOperationService", "batchId" + a16);
            if (j3 == 0) {
                z0(businessAlbumInfo.getId(), new g(a16, str, i3, list, businessAlbumInfo, poiInfo, str2, qZonePreUploadInfo, map, i16, i17, str3, map2, map3, arrayList, str4));
                return;
            }
            QZLog.i("upload2_QZoneWriteOperationService", 1, "success ServerTime -- " + j3 + ", time=" + (System.currentTimeMillis() / 1000));
            j0(str, i3, list, businessAlbumInfo, poiInfo, a16, j3, str2, qZonePreUploadInfo, map, i16, i17, str3, map2, map3, arrayList, str4);
            return;
        }
        QZLog.w("upload2_QZoneWriteOperationService", "uploadVideoPic2Album invalid params !");
    }

    public void x0(String str, q qVar) {
        if (str == null) {
            QZLog.w("upload2_QZoneWriteOperationService", "getQunServerTime albumID null");
        } else {
            w4.a.L().S(str, new h(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), qVar));
        }
    }

    public void z0(String str, q qVar) {
        if (str == null) {
            QZLog.w("upload2_QZoneWriteOperationService", "getServerTime albumID null");
        } else {
            com.qzone.album.base.Service.a.W().h1(str, new i(qVar));
        }
    }

    private void B1(QZoneTask qZoneTask) {
        Map<Integer, ArrayList<tAdvDesc>> map;
        QZoneResult result = qZoneTask.getResult(1000210);
        MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) qZoneTask.mRequest.rsp;
        if (mobileQbossAdvRsp != null && mobileQbossAdvRsp.iRet == 0 && (map = mobileQbossAdvRsp.mapAdv) != null) {
            HashMap hashMap = (HashMap) map;
            if (hashMap == null || hashMap.get(2577) == null) {
                return;
            }
            tAdvDesc tadvdesc = (tAdvDesc) ((ArrayList) hashMap.get(2577)).get(0);
            if (tadvdesc != null) {
                result.setSucceed(true);
                result.setData(null);
                try {
                    JSONObject jSONObject = new JSONObject(tadvdesc.res_data);
                    String optString = jSONObject.optString(WadlProxyConsts.RES_URL, "");
                    int optInt = jSONObject.optInt("appearCount", 1);
                    u5.b.v0(LoginData.getInstance().getUin() + "key_show_slide_out_camera_anim_url", optString);
                    com.qzone.feed.utils.g.a(LoginData.getInstance().getUin() + "friend_feed_slide_out_camera_anim", optInt);
                    QZLog.i("[publish2]QZoneWriteOperationService", "luo-log request Qboss succeed " + optString + " count=" + optInt);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    private void D1(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000031);
        if (qZoneTask.succeeded()) {
            result.setSucceed(true);
        } else {
            QZLog.e(QZLog.TO_DEVICE_TAG, "onSetWidgetID failed: " + qZoneTask.mResultCode);
            result.setSucceed(false);
            result.setMessage(qZoneTask.f45835msg);
        }
        qZoneTask.sendResultMsg(result);
    }

    private QZoneResult g1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        JceStruct jceStruct;
        Map<String, String> map;
        QZoneResult result = qZoneTask.getResult(1000011);
        result.setSucceed(qZoneTask.succeeded());
        result.setMessage(qZoneTask.f45835msg);
        if (qZoneTask.succeeded() && (jceStruct = qZoneTask.mRequest.rsp) != null && (jceStruct instanceof mobile_sub_set_cover_rsp) && (map = ((mobile_sub_set_cover_rsp) jceStruct).MulRelsotionUrl) != null && (!TextUtils.isEmpty(map.get("HigeResolutionCover")) || !TextUtils.isEmpty(map.get("LowResolutionCover")))) {
            result.setData(map);
        }
        return result;
    }

    private void n1(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        ShuoshuoVideoInfo videoInfo = ((QZoneUploadVideoCoverTask) qZoneTask).getVideoInfo();
        CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
        CoverCacheData coverFromCache = coverComponentProxy.getServiceInterface().getCoverFromCache(LoginData.getInstance().getUin());
        if (coverFromCache != null) {
            QZLog.i("[publish2]QZoneWriteOperationService", 1, "start upload video cover ,set half fake cover.");
            videoInfo.mIsFakeFeed = false;
            VideoInfo n26 = n2(videoInfo);
            if (n26 != null) {
                ICoverComponentService serviceInterface = coverComponentProxy.getServiceInterface();
                String str = n26.videoId;
                if (str == null) {
                    str = "";
                }
                CoverCacheData fillVideoCoverDataWithLocalData = serviceInterface.fillVideoCoverDataWithLocalData(coverFromCache, str, videoInfo.mCoverUrl, videoInfo.mVideoPath, videoInfo.mVideoWidth, videoInfo.mVideoHeight, videoInfo.mDuration, qZoneTask.clientKey, "1001");
                coverComponentProxy.getServiceInterface().saveCoverIntoCache(fillVideoCoverDataWithLocalData);
                EventCenter.getInstance().post("Personalize", 8, fillVideoCoverDataWithLocalData);
                CoverEnv.notifyCanPlayVideo();
                QZoneUploadVideoCoverTask qZoneUploadVideoCoverTask = (QZoneUploadVideoCoverTask) qZoneTask;
                com.qzone.adapter.feedcomponent.i.H().Q1(qZoneUploadVideoCoverTask.getCommentUniKey());
                com.qzone.adapter.feedcomponent.i.H().O1(qZoneUploadVideoCoverTask.getCommentUniKey(), n26);
                return;
            }
            QZLog.w("[publish2]QZoneWriteOperationService", "start upload video cover ,videoInfo is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w1(QZoneUploadShuoShuoTask qZoneUploadShuoShuoTask) {
        CertifiedFakeFeed createCertifiedFakeFeed;
        if (qZoneUploadShuoShuoTask == null || (createCertifiedFakeFeed = qZoneUploadShuoShuoTask.createCertifiedFakeFeed()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(CertifiedFakeFeed.BUNDLE_KEY, createCertifiedFakeFeed);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE, bundle);
    }

    public void f0(Handler handler, m mVar) {
        if (mVar == null) {
            return;
        }
        if (mVar.f45744k) {
            if (mVar.f45740g == null) {
                mVar.f45740g = new HashMap();
            }
            mVar.f45740g.put(54, "tih");
        }
        int i3 = !mVar.f45738e ? 1 : 0;
        QZLog.d("[publish2]QZoneWriteOperationService", 2, "dissFeed: action = " + i3);
        CustomPraiseData customPraiseData = mVar.f45748o;
        QZoneTask qZoneTask = new QZoneTask(new QzoneDissRequest(mVar.f45735b, mVar.f45736c, i3, mVar.f45739f, mVar.f45752s, mVar.f45740g, customPraiseData != null ? customPraiseData.toExternParam(null, mVar.f45749p) : null, mVar.f45753t), handler, this, 59);
        qZoneTask.addParameter("isLike", Boolean.valueOf(mVar.f45738e));
        qZoneTask.addParameter(s4.c.UGCKEY, mVar.f45734a);
        qZoneTask.addParameter("uniKey", mVar.f45736c);
        qZoneTask.addParameter("position", Integer.valueOf(mVar.f45742i));
        qZoneTask.addParameter("clickScene", Integer.valueOf(mVar.f45746m));
        qZoneTask.addParameter("feeddata", mVar.f45754u);
        qZoneTask.addParameter("feedtype", Integer.valueOf(mVar.f45755v));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        if (mVar.f45741h != 0) {
            notify(70, mVar.f45734a, Boolean.valueOf(mVar.f45738e), mVar.f45736c, Integer.valueOf(mVar.f45745l), Integer.valueOf(mVar.f45747n), mVar.f45748o, Integer.valueOf(mVar.f45756w), mVar.f45758y);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            return;
        }
        QZoneResult qZoneResult = null;
        switch (qZoneTask.mType) {
            case 0:
                qZoneResult = J0(qZoneTask, null);
                break;
            case 1:
                qZoneResult = W0(qZoneTask, null);
                com.qzone.common.business.service.d.e().i(qZoneTask, "like");
                break;
            case 2:
                qZoneResult = S0(qZoneTask, null);
                com.qzone.common.business.service.d.e().i(qZoneTask, LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO);
                break;
            case 3:
                qZoneResult = f1(qZoneTask, null);
                com.qzone.common.business.service.d.e().i(qZoneTask, "comment");
                break;
            case 4:
                qZoneResult = L0(qZoneTask, null);
                break;
            case 5:
                Z0(qZoneTask, null);
                break;
            case 6:
                a1(qZoneTask, null);
                break;
            case 7:
                l1(qZoneTask, null);
                break;
            case 10:
                qZoneResult = K0(qZoneTask, null);
                break;
            case 11:
                qZoneResult = P0(qZoneTask, null);
                break;
            case 13:
                c1(qZoneTask, null);
                break;
            case 15:
                e1(qZoneTask, null);
                break;
            case 17:
                qZoneResult = g1(qZoneTask, null);
                break;
            case 19:
                O0(qZoneTask, null);
                break;
            case 22:
                d1(qZoneTask, null);
                break;
            case 24:
                C1(qZoneTask);
                break;
            case 25:
                qZoneResult = N0(qZoneTask, null);
                break;
            case 26:
                n1(qZoneTask, null);
                break;
            case 27:
                m1(qZoneTask, null);
                break;
            case 28:
                o1(qZoneTask, null);
                break;
            case 30:
                F0(qZoneTask, null);
                break;
            case 31:
                y1(qZoneTask);
                break;
            case 32:
                D1(qZoneTask);
                break;
            case 35:
                T0(qZoneTask, null);
                break;
            case 37:
                z1(qZoneTask);
                break;
            case 38:
                qZoneResult = M0(qZoneTask, null);
                break;
            case 39:
                A1(qZoneTask);
                break;
            case 40:
                i1(qZoneTask, null);
                break;
            case 41:
                E0(qZoneTask, null);
                break;
            case 42:
                H0(qZoneTask, null);
                break;
            case 46:
                qZoneResult = qZoneTask.getResult(1000176);
                break;
            case 47:
                qZoneResult = qZoneTask.getResult(1000178);
                break;
            case 50:
                B1(qZoneTask);
                break;
            case 51:
                qZoneResult = V0(qZoneTask, null);
                break;
            case 52:
                j1(qZoneTask, null);
                break;
            case 55:
                qZoneResult = b1(qZoneTask, null);
                break;
            case 56:
                E1(qZoneTask);
                break;
            case 57:
                qZoneResult = X0(qZoneTask, null);
                break;
            case 58:
                U0(qZoneTask);
                w5.b.a("[publish2]QZoneWriteOperationService", 1, "set high five passive message completed!");
                break;
            case 59:
                qZoneResult = R0(qZoneTask, null);
                break;
            case 60:
                h1(qZoneTask, null);
                break;
            case 62:
                qZoneResult = Q0(qZoneTask);
                break;
            case 63:
                G0(qZoneTask, null);
                break;
            case 65:
                k1(qZoneTask, null);
                break;
            case 67:
                Y0(qZoneTask, null);
                break;
        }
        if (qZoneResult != null) {
            qZoneTask.sendResultMsg(qZoneResult);
        }
        QLog.d("[publish2]QZoneWriteOperationService", 1, "task id:", Integer.valueOf(qZoneTask.mType));
    }

    public void t1(Handler handler, k kVar) {
        if (kVar == null) {
            return;
        }
        CustomPraiseData customPraiseData = kVar.f45706m;
        HashMap<Integer, String> externParam = customPraiseData != null ? customPraiseData.toExternParam(null, kVar.f45707n) : null;
        String str = kVar.f45699f;
        QZoneTask qZoneTask = new QZoneTask(new QZoneLikeRequest(0, str, str, !kVar.f45700g ? 1 : 0, kVar.f45701h, kVar.f45702i, externParam), handler, this, 51);
        qZoneTask.addParameter("isLike", Boolean.valueOf(kVar.f45700g));
        qZoneTask.addParameter(s4.c.UGCKEY, kVar.f45696c);
        qZoneTask.addParameter("feedkey", kVar.f45697d);
        qZoneTask.addParameter("uniKey", kVar.f45698e);
        qZoneTask.addParameter("clickScene", Integer.valueOf(kVar.f45705l));
        qZoneTask.addParameter("comment_id", kVar.f45703j);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        notify(58, kVar.f45696c, kVar.f45703j, Boolean.valueOf(kVar.f45700g), Integer.valueOf(kVar.f45705l));
    }

    public void v1(Handler handler, k kVar) {
        if (kVar == null) {
            return;
        }
        CustomPraiseData customPraiseData = kVar.f45706m;
        HashMap<Integer, String> externParam = customPraiseData != null ? customPraiseData.toExternParam(null, kVar.f45707n) : null;
        String str = kVar.f45699f;
        QZoneTask qZoneTask = new QZoneTask(new QZoneLikeRequest(0, str, str, !kVar.f45700g ? 1 : 0, kVar.f45701h, kVar.f45702i, externParam), handler, this, 57);
        qZoneTask.addParameter("isLike", Boolean.valueOf(kVar.f45700g));
        qZoneTask.addParameter(s4.c.UGCKEY, kVar.f45696c);
        qZoneTask.addParameter("feedkey", kVar.f45697d);
        qZoneTask.addParameter("uniKey", kVar.f45698e);
        qZoneTask.addParameter("clickScene", Integer.valueOf(kVar.f45705l));
        qZoneTask.addParameter("comment_id", kVar.f45703j);
        qZoneTask.addParameter("reply_id", kVar.f45704k);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        notify(68, kVar.f45696c, kVar.f45703j, kVar.f45704k, Boolean.valueOf(kVar.f45700g), Integer.valueOf(kVar.f45705l));
        if (kVar.f45700g) {
            LpReportInfo_dc00518.report(44, com.tencent.luggage.wxa.uf.c.CTRL_INDEX, 6);
        } else {
            LpReportInfo_dc00518.report(44, com.tencent.luggage.wxa.uf.i.CTRL_INDEX, 6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private QZoneResult J0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        Object obj;
        String str;
        String str2;
        Object obj2;
        boolean z16;
        Object obj3;
        Map<String, String> map;
        Map<String, String> map2;
        String str3;
        String str4;
        Integer num;
        FeedHolidayCommentEvent parseMapData;
        String str5;
        String str6;
        Object obj4;
        Object obj5;
        Object obj6;
        String str7;
        boolean booleanValue = qZoneTask.getParameter("is_from_hb") != null ? ((Boolean) qZoneTask.getParameter("is_from_hb")).booleanValue() : false;
        Bundle bundle = new Bundle();
        if (!booleanValue) {
            obj = "";
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if (qZoneRequest instanceof QZoneAddCommentRequest) {
                operation_addcomment_rsp operation_addcomment_rspVar = (operation_addcomment_rsp) ((QZoneAddCommentRequest) qZoneRequest).rsp;
                if (operation_addcomment_rspVar != null) {
                    qZoneTask.mResultCode = operation_addcomment_rspVar.ret;
                    qZoneTask.f45835msg = operation_addcomment_rspVar.f25009msg;
                    obj2 = operation_addcomment_rspVar.commentid;
                    obj3 = operation_addcomment_rspVar.commentLikekey;
                    map = operation_addcomment_rspVar.extend_info;
                } else {
                    obj3 = obj;
                    obj2 = obj3;
                    map = null;
                }
                obj = obj3;
                str = "\u8bc4\u8bba\u6210\u529f";
                str2 = "ToastCommentSuccess";
                map2 = map;
                z16 = qZoneTask.succeeded();
                if (qZoneTask.getParameter("is_container_feed") != null && ((Boolean) qZoneTask.getParameter("is_container_feed")).booleanValue()) {
                    String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, str2, str);
                    String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentFail", "\u8bc4\u8bba\u5931\u8d25");
                    if (!z16) {
                        config = config2 + qZoneTask.f45835msg;
                    }
                    ToastUtil.r(config);
                }
                str3 = (String) qZoneTask.getParameter(s4.c.UGCKEY);
                Object obj7 = (String) qZoneTask.getParameter("feedkey");
                String str8 = (String) qZoneTask.getParameter("uniKey");
                str4 = (String) qZoneTask.getParameter("relative_ugckey");
                int intValue = qZoneTask.getParameter("position") == null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0;
                notify(4, str3, str8, Boolean.valueOf(z16), obj2, obj7, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(qZoneTask.getParameter("clickScene") == null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1), obj, (Integer) qZoneTask.getParameter("feedtype"), map2);
                if (!TextUtils.isEmpty(str4)) {
                    notify(4, str4, str8, Boolean.valueOf(qZoneTask.succeeded()), obj2, null, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode));
                }
                num = (Integer) qZoneTask.getParameter("src_refer");
                if (num != null && num.intValue() == 2) {
                    notify(48, Boolean.valueOf(qZoneTask.succeeded()), Integer.valueOf(qZoneTask.mResultCode), (String) qZoneTask.getParameter("albumid"), (String) qZoneTask.getParameter("lloc"), str3);
                }
                parseMapData = FeedHolidayCommentEvent.parseMapData(map2);
                QZoneResult result = qZoneTask.getResult(999905);
                bundle.putString("uinKey", str8);
                bundle.putString(s4.c.UGCKEY, str3);
                bundle.putSerializable("extendInfo", parseMapData);
                result.setData(bundle);
                if (TextUtils.isEmpty(parseMapData.getPlayRid())) {
                    com.qzone.common.business.service.d.e().i(qZoneTask, "comment");
                }
                if (z16) {
                    if (qZoneTask.getParameter("feeddata") != null && qZoneTask.getParameter("feedtype") != null) {
                        BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feeddata");
                        if (((Integer) qZoneTask.getParameter("feedtype")).intValue() == 4097) {
                            ToastUtil.f(businessFeedData);
                        }
                    }
                    String e16 = aa.e(parseMapData);
                    if (!TextUtils.isEmpty(e16)) {
                        if (qZoneTask.getParameter("feeddata") != null && (qZoneTask.getParameter("feeddata") instanceof BusinessFeedData)) {
                            aa.j((BusinessFeedData) qZoneTask.getParameter("feeddata"));
                        }
                        ToastUtil.r(e16);
                    }
                }
                return result;
            }
            if (!(qZoneRequest instanceof QZoneQunAddCommentRequest)) {
                str = "\u8bc4\u8bba\u6210\u529f";
                str2 = "ToastCommentSuccess";
                obj2 = obj;
                z16 = false;
            } else {
                qun_add_comment_rsp qun_add_comment_rspVar = (qun_add_comment_rsp) ((QZoneQunAddCommentRequest) qZoneRequest).rsp;
                Object obj8 = qun_add_comment_rspVar != null ? qun_add_comment_rspVar.commentid : obj;
                boolean succeeded = qZoneTask.succeeded();
                if (succeeded) {
                    str = "\u8bc4\u8bba\u6210\u529f";
                    str2 = "ToastCommentSuccess";
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, str2, str), 5);
                } else {
                    str = "\u8bc4\u8bba\u6210\u529f";
                    str2 = "ToastCommentSuccess";
                }
                obj2 = obj8;
                z16 = succeeded;
            }
        } else {
            bundle.putBoolean("is_from_hb", booleanValue);
            short shortValue = qZoneTask.getParameter("hb_type") != null ? ((Short) qZoneTask.getParameter("hb_type")).shortValue() : (short) 0;
            mobile_visit_hb_callback_rsp mobile_visit_hb_callback_rspVar = (mobile_visit_hb_callback_rsp) qZoneTask.mRequest.rsp;
            if (mobile_visit_hb_callback_rspVar == null || mobile_visit_hb_callback_rspVar.ret != 0) {
                obj = "";
                if (mobile_visit_hb_callback_rspVar == null || shortValue != 3) {
                    str5 = "\u8bc4\u8bba\u6210\u529f";
                    str6 = "ToastCommentSuccess";
                    ToastUtil.r("failed: " + qZoneTask.f45835msg);
                    obj4 = obj;
                    z16 = false;
                    obj2 = obj4;
                    str = str5;
                    str2 = str6;
                } else {
                    Map<String, String> map3 = mobile_visit_hb_callback_rspVar.ext_info;
                    if (map3 != null) {
                        Object obj9 = (String) map3.get("tid");
                        mobile_visit_hb_callback_rspVar.ext_info.get("timestamp");
                        obj4 = obj9;
                    } else {
                        obj4 = obj;
                    }
                    long longValue = ((Long) qZoneTask.getParameter("hbHostUin")).longValue();
                    str5 = "\u8bc4\u8bba\u6210\u529f";
                    str6 = "ToastCommentSuccess";
                    long longValue2 = ((Long) qZoneTask.getParameter("hbOwnerUin")).longValue();
                    bundle.putShort("hb_type", shortValue);
                    bundle.putString("hbErrMsg", mobile_visit_hb_callback_rspVar.err_msg);
                    bundle.putLong("hbHostUin", longValue);
                    bundle.putLong("hbOwnerUin", longValue2);
                    QZLog.e("[publish2]QZoneWriteOperationService", "TASK_TYPE_COMMENT_FEED failed: " + qZoneTask.f45835msg);
                }
            } else {
                Map<String, String> map4 = mobile_visit_hb_callback_rspVar.ext_info;
                if (map4 == null) {
                    obj5 = "";
                } else {
                    obj5 = (String) map4.get("tid");
                    mobile_visit_hb_callback_rspVar.ext_info.get("timestamp");
                }
                if (shortValue != 3) {
                    obj6 = obj5;
                    obj = "";
                } else {
                    bundle.putShort("hb_type", shortValue);
                    Map<String, String> map5 = mobile_visit_hb_callback_rspVar.ext_info;
                    if (map5 != null && map5.containsKey("strEncrypedKey")) {
                        str7 = mobile_visit_hb_callback_rspVar.ext_info.get("strEncrypedKey");
                    } else {
                        QZLog.e("[publish2]QZoneWriteOperationService", "return  rsp.ext_info[strEncrypedKey] is null");
                        str7 = "";
                    }
                    long longValue3 = ((Long) qZoneTask.getParameter("hbHostUin")).longValue();
                    long longValue4 = ((Long) qZoneTask.getParameter("hbOwnerUin")).longValue();
                    String str9 = (String) qZoneTask.getParameter("hb_id");
                    String str10 = (String) qZoneTask.getParameter("feeds_id");
                    obj = "";
                    long longValue5 = ((Long) qZoneTask.getParameter("hb_channel")).longValue();
                    obj6 = obj5;
                    int intValue2 = ((Integer) qZoneTask.getParameter("requestCode")).intValue();
                    bundle.putString("hb_id", str9);
                    bundle.putString("encryp_key", str7);
                    bundle.putString("feeds_id", str10);
                    bundle.putLong("hb_channel", longValue5);
                    bundle.putInt("requestCode", intValue2);
                    bundle.putLong("hbHostUin", longValue3);
                    bundle.putLong("hbOwnerUin", longValue4);
                }
                str5 = "\u8bc4\u8bba\u6210\u529f";
                str6 = "ToastCommentSuccess";
                obj4 = obj6;
            }
            z16 = true;
            obj2 = obj4;
            str = str5;
            str2 = str6;
        }
        map2 = null;
        if (qZoneTask.getParameter("is_container_feed") != null) {
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, str2, str);
            String config22 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentFail", "\u8bc4\u8bba\u5931\u8d25");
            if (!z16) {
            }
            ToastUtil.r(config3);
        }
        str3 = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        Object obj72 = (String) qZoneTask.getParameter("feedkey");
        String str82 = (String) qZoneTask.getParameter("uniKey");
        str4 = (String) qZoneTask.getParameter("relative_ugckey");
        if (qZoneTask.getParameter("position") == null) {
        }
        if (qZoneTask.getParameter("clickScene") == null) {
        }
        notify(4, str3, str82, Boolean.valueOf(z16), obj2, obj72, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(qZoneTask.getParameter("clickScene") == null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1), obj, (Integer) qZoneTask.getParameter("feedtype"), map2);
        if (!TextUtils.isEmpty(str4)) {
        }
        num = (Integer) qZoneTask.getParameter("src_refer");
        if (num != null) {
            notify(48, Boolean.valueOf(qZoneTask.succeeded()), Integer.valueOf(qZoneTask.mResultCode), (String) qZoneTask.getParameter("albumid"), (String) qZoneTask.getParameter("lloc"), str3);
        }
        parseMapData = FeedHolidayCommentEvent.parseMapData(map2);
        QZoneResult result2 = qZoneTask.getResult(999905);
        bundle.putString("uinKey", str82);
        bundle.putString(s4.c.UGCKEY, str3);
        bundle.putSerializable("extendInfo", parseMapData);
        result2.setData(bundle);
        if (TextUtils.isEmpty(parseMapData.getPlayRid())) {
        }
        if (z16) {
        }
        return result2;
    }

    private QZoneResult S0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        boolean z16;
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (((QZoneForwardRequest) qZoneRequest).rsp == null) {
            str = "";
            z16 = false;
        } else {
            JceStruct jceStruct = qZoneRequest.rsp;
            int i3 = ((operation_forward_rsp) jceStruct).ret;
            qZoneTask.mResultCode = i3;
            z16 = i3 == 0;
            qZoneTask.f45835msg = ((operation_forward_rsp) jceStruct).f25015msg;
            str = ((operation_forward_rsp) jceStruct).newid;
        }
        QZoneResult result = qZoneTask.getResult(999908);
        result.setData((Integer) qZoneTask.getParameter("forwardType"));
        Boolean bool = (Boolean) qZoneTask.getParameter("isLongClick");
        if (bool != null) {
            result.getBundle().putBoolean("isLongClick", bool.booleanValue());
        }
        if (z16) {
            Handler handler = new Handler(Looper.getMainLooper());
            if (qZoneTask.getParameter("feeddata") != null && qZoneTask.getParameter("feedtype") != null) {
                final BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("feeddata");
                if (((Integer) qZoneTask.getParameter("feedtype")).intValue() == 4097) {
                    handler.postDelayed(new Runnable() { // from class: com.qzone.common.business.service.QZoneWriteOperationService.16
                        @Override // java.lang.Runnable
                        public void run() {
                            ToastUtil.f(businessFeedData);
                        }
                    }, 1500L);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            t5.a.b(qZoneTask.mRequest.getContentCacheUnikey());
        }
        String str2 = (String) qZoneTask.getParameter(s4.c.UGCKEY);
        int intValue = qZoneTask.getParameter("position") != null ? ((Integer) qZoneTask.getParameter("position")).intValue() : 0;
        int intValue2 = qZoneTask.getParameter("clickScene") != null ? ((Integer) qZoneTask.getParameter("clickScene")).intValue() : -1;
        boolean booleanValue = qZoneTask.getParameter("isRapid") != null ? ((Boolean) qZoneTask.getParameter("isRapid")).booleanValue() : false;
        if (qZoneTask.getParameter("relative_ugckey") != null) {
        }
        Integer num = (Integer) qZoneTask.getParameter("feedtype");
        if (!z16 && num != null) {
            notify(4, str2, (String) qZoneTask.getParameter("uniKey"), Boolean.FALSE, "", "", Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(intValue2), "", num);
        }
        notify(39, str2, Integer.valueOf(intValue), Integer.valueOf(qZoneTask.mResultCode), Integer.valueOf(intValue2), Boolean.valueOf(booleanValue), qZoneTask.f45835msg);
        AccManager.reportForward(qZoneTask.mResultCode);
        return result;
    }

    public static VideoInfo n2(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        if (!RFWFileUtils.fileExists(shuoshuoVideoInfo.mVideoPath)) {
            String c16 = FakeShuoShuoDataCacheHelper.c(shuoshuoVideoInfo.mVideoPath);
            if (!RFWFileUtils.fileExists(c16)) {
                c16 = shuoshuoVideoInfo.mVideoPath;
            }
            shuoshuoVideoInfo.mVideoPath = c16;
        }
        videoInfo.videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = shuoshuoVideoInfo.mVideoPath;
        pictureUrl.width = shuoshuoVideoInfo.mVideoWidth;
        pictureUrl.height = shuoshuoVideoInfo.mVideoHeight;
        String str = shuoshuoVideoInfo.mCoverUrl;
        if (str != null) {
            pictureUrl.url = str;
        }
        videoInfo.bigUrl = pictureUrl;
        videoInfo.originUrl = pictureUrl;
        videoInfo.currentUrl = pictureUrl;
        videoInfo.coverUrl = pictureUrl;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        videoInfo.videoType = 2;
        videoInfo.actionType = 3;
        videoInfo.playType = (byte) 1;
        videoInfo.isFakeFeed = shuoshuoVideoInfo.mIsFakeFeed;
        videoInfo.desc = shuoshuoVideoInfo.mDescription;
        videoInfo.shootTime = shuoshuoVideoInfo.mShootTime;
        videoInfo.needDeleteLocal = shuoshuoVideoInfo.needDeleteLocal;
        videoInfo.width = shuoshuoVideoInfo.mVideoWidth;
        videoInfo.height = shuoshuoVideoInfo.mVideoHeight;
        return videoInfo;
    }

    public void I0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        notify(85, businessFeedData);
    }

    public void J1(k kVar) {
        if (kVar == null) {
            QZLog.e("[publish2]QZoneWriteOperationService", 1, "onlyNotifyLikeComment: params is null");
        } else {
            notify(58, kVar.f45696c, kVar.f45703j, Boolean.valueOf(kVar.f45700g), Integer.valueOf(kVar.f45705l));
        }
    }

    public void K1(int i3, m mVar) {
        if (mVar == null) {
            QZLog.e("[publish2]QZoneWriteOperationService", 1, "onlyNotifyLikeFeed: params is null, action=" + i3);
            return;
        }
        if (mVar.f45741h != 0) {
            int i16 = mVar.f45739f;
            if ((i16 == 4 || i16 == 422) && !TextUtils.isEmpty(mVar.f45743j)) {
                notify(6, mVar.f45743j, Boolean.valueOf(mVar.f45738e), mVar.f45736c, Integer.valueOf(mVar.f45745l), Integer.valueOf(mVar.f45747n), mVar.f45748o, Integer.valueOf(mVar.f45756w), mVar.f45758y);
            }
            if (i3 != 2 && i3 != 4) {
                if (mVar.f45759z) {
                    notify(77, mVar.f45734a, Boolean.valueOf(mVar.f45738e), mVar.f45736c, Integer.valueOf(mVar.f45745l));
                } else {
                    notify(6, mVar.f45734a, Boolean.valueOf(mVar.f45738e), mVar.f45736c, Integer.valueOf(mVar.f45745l), Integer.valueOf(mVar.f45747n), mVar.f45748o, Integer.valueOf(mVar.f45756w), mVar.f45758y);
                }
            } else {
                notify(65, mVar.f45734a, mVar.f45737d, Boolean.TRUE);
            }
        }
        if (mVar.f45742i >= 0) {
            notify(14, mVar.f45734a, Boolean.valueOf(mVar.f45738e), Integer.valueOf(mVar.f45742i), mVar.f45735b, mVar.f45736c, Integer.valueOf(mVar.f45747n), mVar.f45748o);
        }
        if (com.tencent.mobileqq.service.qzone.a.f286399a.b() != null) {
            ug.b.f438918a.a(mVar.f45734a);
        }
    }

    public void L1(k kVar) {
        if (kVar == null) {
            QZLog.e("[publish2]QZoneWriteOperationService", 1, "onlyNotifyLikeReply: params is null");
        } else {
            notify(68, kVar.f45696c, kVar.f45703j, kVar.f45704k, Boolean.valueOf(kVar.f45700g), Integer.valueOf(kVar.f45705l));
        }
    }

    public void M1(o oVar) {
        if (oVar == null) {
            QZLog.e("[publish2]QZoneWriteOperationService", 1, "onlyNotifyReplyFeed: params is null");
        } else {
            notify(5, oVar.f45760a, oVar.f45762c, oVar.f45763d, oVar.f45767h, Long.valueOf(oVar.f45765f), oVar.f45766g, oVar.f45761b, oVar.f45768i);
        }
    }

    public void d0(Handler handler, BusinessFeedData businessFeedData, Reply reply, Comment comment, int i3) {
        String str;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        String str2 = businessFeedData.getFeedCommInfo().ugckey;
        long j3 = businessFeedData.getFeedCommInfo().appid;
        long j16 = businessFeedData.getUser().uin;
        String str3 = businessFeedData.getIdInfo().cellId;
        long j17 = comment.user.uin;
        String str4 = comment.commentid;
        long j18 = reply.user.uin;
        boolean z16 = reply.isFake;
        if (z16) {
            str = reply.fakeUinKey;
        } else {
            str = reply.replyId;
        }
        c0(0, handler, str2, j3, j16, str3, j17, str4, 0, j18, str, map, z16, i3);
    }

    public void l2(long j3, boolean z16, int i3, Handler handler, String str, int i16, boolean z17, Map<Integer, String> map, boolean z18, BusinessFeedData businessFeedData, boolean z19, int i17) {
        CellOperationInfo cellOperationInfo;
        Map<Integer, String> map2 = (businessFeedData == null || (cellOperationInfo = businessFeedData.cellOperationInfo) == null) ? null : cellOperationInfo.busiParam;
        int i18 = z16 ? 3 : 2;
        if (z16) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(j3, i18, i3, map2), handler, this, 56);
            qZoneTask.addParameter("feedkey", str);
            qZoneTask.addParameter("isSpecialFollow", Boolean.valueOf(z16));
            qZoneTask.addParameter("position", Integer.valueOf(i16));
            qZoneTask.addParameter("need_adv_report", Boolean.valueOf(z17));
            qZoneTask.addParameter("clickScene", Integer.valueOf(i17));
            qZoneTask.addParameter("cookie", map);
            qZoneTask.addParameter("feedData", businessFeedData);
            qZoneTask.addParameter("isinstalled", Boolean.valueOf(z18));
            qZoneTask.addParameter("uin", Long.valueOf(j3));
            qZoneTask.addParameter("isForward", Boolean.valueOf(z19));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
            return;
        }
        new com.qzone.component.e().k(BaseActivity.getTopActivity(), new c(j3, i18, i3, map2, handler, str, z16, i16, z17, i17, map, businessFeedData, z18, z19));
    }

    public void o2(long j3, int i3, Handler handler, String str, int i16, boolean z16, Map<Integer, String> map, boolean z17, BusinessFeedData businessFeedData, boolean z18, int i17) {
        CellOperationInfo cellOperationInfo;
        QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(j3, 0, i3, (businessFeedData == null || (cellOperationInfo = businessFeedData.cellOperationInfo) == null) ? null : cellOperationInfo.busiParam), handler, this, 31);
        qZoneTask.addParameter("feedkey", str);
        qZoneTask.addParameter("isFollow", Boolean.FALSE);
        qZoneTask.addParameter("position", Integer.valueOf(i16));
        qZoneTask.addParameter("need_adv_report", Boolean.valueOf(z16));
        qZoneTask.addParameter("clickScene", Integer.valueOf(i17));
        qZoneTask.addParameter("follow_source", Integer.valueOf(i3));
        qZoneTask.addParameter("cookie", map);
        qZoneTask.addParameter("feedData", businessFeedData);
        qZoneTask.addParameter("isinstalled", Boolean.valueOf(z17));
        qZoneTask.addParameter("uin", Long.valueOf(j3));
        qZoneTask.addParameter("isForward", Boolean.valueOf(z18));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void p0(long j3, boolean z16, int i3, Handler handler, String str, int i16, boolean z17, Map<Integer, String> map, boolean z18, BusinessFeedData businessFeedData, boolean z19, int i17) {
        CellOperationInfo cellOperationInfo;
        Map<Integer, String> map2 = (businessFeedData == null || (cellOperationInfo = businessFeedData.cellOperationInfo) == null) ? null : cellOperationInfo.busiParam;
        if (z16) {
            QZoneTask qZoneTask = new QZoneTask(new QZoneAutherRequest(j3, z16 ? 1 : 0, i3, map2), handler, this, 31);
            qZoneTask.addParameter("feedkey", str);
            qZoneTask.addParameter("isFollow", Boolean.valueOf(z16));
            qZoneTask.addParameter("position", Integer.valueOf(i16));
            qZoneTask.addParameter("need_adv_report", Boolean.valueOf(z17));
            qZoneTask.addParameter("clickScene", Integer.valueOf(i17));
            qZoneTask.addParameter("follow_source", Integer.valueOf(i3));
            qZoneTask.addParameter("cookie", map);
            qZoneTask.addParameter("feedData", businessFeedData);
            qZoneTask.addParameter("isinstalled", Boolean.valueOf(z18));
            qZoneTask.addParameter("uin", Long.valueOf(j3));
            qZoneTask.addParameter("isForward", Boolean.valueOf(z19));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
            return;
        }
        com.qzone.component.e eVar = new com.qzone.component.e();
        Context topActivity = BaseActivity.getTopActivity();
        if (topActivity == null) {
            topActivity = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        }
        Context context = topActivity;
        if (context == null) {
            return;
        }
        eVar.j(context, new b(j3, i3, handler, str, i16, z17, map, z18, businessFeedData, z19, i17));
    }

    public void S(int i3, Handler handler, String str, long j3, long j16, String str2, long j17, String str3, int i16, Map<Integer, String> map, boolean z16, int i17, int i18) {
        if (!z16) {
            QZoneTask qZoneTask = new QZoneTask(new QzoneDeleteCommentRequest(i3, j3, j16, str2, j17, str3, i16, map), handler, this, 10);
            qZoneTask.addParameter(s4.c.UGCKEY, str);
            qZoneTask.addParameter("position", Integer.valueOf(i18));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }
        notify(15, str, str3, Integer.valueOf(i17));
    }

    public void Q(Handler handler, l lVar) {
        QZoneWriteOperationService qZoneWriteOperationService;
        Map<Integer, String> map;
        if (com.qzone.util.o.b(handler) || lVar == null) {
            return;
        }
        t5.a.b(lVar.f45716i);
        if (lVar.f45724q && (map = lVar.f45718k) != null) {
            map.put(54, "tih");
        }
        ArrayList<String> arrayList = lVar.f45726s;
        if (arrayList != null && !arrayList.isEmpty()) {
            if ((gd.a.f401926a.c("KEY_ENABLE_USE_NEW_NT_UPLOAD_PIC_COMMENT", false) || com.qzone.reborn.configx.g.f53821a.b().l0()) && Objects.equals(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
                QLog.d("QZPicCommentNTPublishHelper", 1, "send pic comment by nt upload channel");
                x7.b.j().p(lVar);
            } else {
                QLog.d("QZPicCommentNTPublishHelper", 1, "send pic comment use old channel");
                QZonePicCommentTask qZonePicCommentTask = new QZonePicCommentTask(0, lVar.f45712e, lVar.f45713f, lVar.f45714g, lVar.f45715h, lVar.f45716i, lVar.f45711d, lVar.f45717j, lVar.f45718k, "pic_comment", lVar.f45725r, lVar.f45726s, lVar.f45730w);
                qZonePicCommentTask.addParameter(s4.c.UGCKEY, lVar.f45708a);
                qZonePicCommentTask.addParameter("feedkey", lVar.f45709b);
                qZonePicCommentTask.addParameter("uniKey", lVar.f45710c);
                qZonePicCommentTask.addParameter("position", 0);
                qZonePicCommentTask.setCommentUniKey(lVar.f45710c);
                qZonePicCommentTask.addParameter("src_refer", Integer.valueOf(lVar.f45728u));
                qZonePicCommentTask.addParameter("albumid", lVar.f45714g);
                qZonePicCommentTask.addParameter("lloc", lVar.f45729v);
                qZonePicCommentTask.addParameter("is_from_hb", Boolean.FALSE);
                qZonePicCommentTask.setHandler(handler);
                QZonePublishQueue.w().b(qZonePicCommentTask);
            }
            qZoneWriteOperationService = this;
        } else if (lVar.A) {
            qZoneWriteOperationService = this;
            QZoneTask qZoneTask = new QZoneTask(new QZoneQunAddCommentRequest(lVar.B, lVar.f45713f, lVar.f45714g, l.a(lVar.f45715h), lVar.f45718k, lVar.f45719l), handler, qZoneWriteOperationService, 0);
            qZoneTask.addParameter(s4.c.UGCKEY, lVar.f45708a);
            qZoneTask.addParameter("feedkey", lVar.f45709b);
            qZoneTask.addParameter("uniKey", lVar.f45710c);
            qZoneTask.addParameter("position", Integer.valueOf(lVar.f45723p));
            qZoneTask.addParameter("clickScene", Integer.valueOf(lVar.f45727t));
            qZoneTask.addParameter("src_refer", Integer.valueOf(lVar.f45728u));
            qZoneTask.addParameter("albumid", lVar.f45714g);
            qZoneTask.addParameter("lloc", lVar.f45729v);
            qZoneTask.addParameter("is_from_hb", Boolean.FALSE);
            qZoneTask.addParameter("feeddata", lVar.f45732y);
            qZoneTask.addParameter("feedtype", Integer.valueOf(lVar.f45733z));
            if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
                qZoneTask.addParameter("relative_ugckey", lVar.f45722o);
            }
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        } else {
            qZoneWriteOperationService = this;
            QZoneTask qZoneTask2 = new QZoneTask(new QZoneAddCommentRequest(0, lVar.f45712e, lVar.f45713f, lVar.f45714g, l.a(lVar.f45715h), lVar.f45716i, lVar.f45717j, lVar.f45718k, lVar.f45719l, lVar.f45725r, lVar.f45730w), handler, qZoneWriteOperationService, 0);
            qZoneTask2.addParameter(s4.c.UGCKEY, lVar.f45708a);
            qZoneTask2.addParameter("feedkey", lVar.f45709b);
            qZoneTask2.addParameter("uniKey", lVar.f45710c);
            qZoneTask2.addParameter("position", Integer.valueOf(lVar.f45723p));
            qZoneTask2.addParameter("clickScene", Integer.valueOf(lVar.f45727t));
            qZoneTask2.addParameter("src_refer", Integer.valueOf(lVar.f45728u));
            qZoneTask2.addParameter("albumid", lVar.f45714g);
            qZoneTask2.addParameter("lloc", lVar.f45729v);
            qZoneTask2.addParameter("is_from_hb", Boolean.FALSE);
            qZoneTask2.addParameter("feeddata", lVar.f45732y);
            qZoneTask2.addParameter("feedtype", Integer.valueOf(lVar.f45733z));
            if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
                qZoneTask2.addParameter("relative_ugckey", lVar.f45722o);
            }
            QZoneBusinessLooper.getInstance().runTask(qZoneTask2);
        }
        Map<Integer, String> map2 = lVar.f45718k;
        String str = map2 != null ? map2.get(2) : null;
        if (lVar.f45721n != 0) {
            if (lVar.f45725r) {
                lVar.f45715h += "[em]e10011[/em]";
            }
            if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
                qZoneWriteOperationService.notify(3, lVar.f45722o, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
            }
            qZoneWriteOperationService.notify(3, lVar.f45708a, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
        }
    }

    public void X1(Handler handler, l lVar, RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        Map<Integer, String> map;
        if (lVar.f45726s == null) {
            lVar.f45726s = new ArrayList<>();
        }
        PicInfo picInfo = new PicInfo();
        picInfo.pic_url = rapidCommentExpressionInfo.f60642h;
        long j3 = rapidCommentExpressionInfo.C;
        picInfo.picwidth = (int) j3;
        picInfo.picheight = (int) j3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(picInfo);
        MediaInfo mediaInfo = new MediaInfo(arrayList, null, null);
        String str = rapidCommentExpressionInfo.f60644m;
        File file = new File(str);
        PictureItem pictureItem = lVar.f45720m;
        if (pictureItem == null) {
            pictureItem = new PictureItem();
        }
        PictureUrl pictureUrl = new PictureUrl();
        pictureItem.currentUrl = pictureUrl;
        long j16 = rapidCommentExpressionInfo.C;
        pictureUrl.width = (int) j16;
        pictureUrl.height = (int) j16;
        if (file.exists()) {
            pictureItem.localFileUrl = str;
            pictureItem.currentUrl.url = str;
            lVar.f45726s.add(str);
        } else {
            String str2 = rapidCommentExpressionInfo.f60642h;
            pictureItem.localFileUrl = str2;
            pictureItem.currentUrl.url = str2;
            lVar.f45726s.add(str2);
        }
        lVar.f45720m = pictureItem;
        if (lVar.f45724q && (map = lVar.f45718k) != null) {
            map.put(54, "tih");
        }
        QZoneTask qZoneTask = new QZoneTask(new QZoneAddCommentRequest(0, lVar.f45712e, lVar.f45713f, lVar.f45714g, lVar.f45715h, lVar.f45716i, lVar.f45717j, lVar.f45718k, lVar.f45719l, lVar.f45725r, mediaInfo, null), handler, this, 0);
        qZoneTask.addParameter(s4.c.UGCKEY, lVar.f45708a);
        qZoneTask.addParameter("feedkey", lVar.f45709b);
        qZoneTask.addParameter("uniKey", lVar.f45710c);
        qZoneTask.addParameter("position", Integer.valueOf(lVar.f45723p));
        qZoneTask.addParameter("src_refer", Integer.valueOf(lVar.f45728u));
        qZoneTask.addParameter("albumid", lVar.f45714g);
        qZoneTask.addParameter("lloc", lVar.f45729v);
        if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
            qZoneTask.addParameter("relative_ugckey", lVar.f45722o);
        }
        Map<Integer, String> map2 = lVar.f45718k;
        String str3 = map2 != null ? map2.get(2) : null;
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        if (lVar.f45721n != 0) {
            if (lVar.f45725r) {
                lVar.f45715h += "[em]e10011[/em]";
            }
            if (lVar.f45712e == 4 && !TextUtils.isEmpty(lVar.f45722o)) {
                notify(3, lVar.f45722o, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str3, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
            }
            notify(3, lVar.f45708a, lVar.f45710c, lVar.f45715h, Long.valueOf(lVar.f45713f), str3, lVar.f45720m, lVar.f45709b, lVar.f45726s, lVar.f45730w);
        }
    }

    public void c0(int i3, Handler handler, String str, long j3, long j16, String str2, long j17, String str3, int i16, long j18, String str4, Map<Integer, String> map, boolean z16, int i17) {
        String str5;
        if (z16) {
            str5 = str;
        } else {
            QZoneTask qZoneTask = new QZoneTask(new QzoneDeleteReplyRequest(i3, j3, j16, str2, j17, str3, j18, str4, i16, map), handler, this, 11);
            str5 = str;
            qZoneTask.addParameter(s4.c.UGCKEY, str5);
            qZoneTask.addParameter("position", Integer.valueOf(i17));
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }
        notify(16, str5, str3, str4);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f45620a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f45621b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f45622c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f45623d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45624e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45625f;

        a(List list, String str, BusinessAlbumInfo businessAlbumInfo, long j3, String str2, String str3) {
            this.f45620a = list;
            this.f45621b = str;
            this.f45622c = businessAlbumInfo;
            this.f45623d = j3;
            this.f45624e = str2;
            this.f45625f = str3;
        }

        @Override // com.qzone.common.business.service.QZoneWriteOperationService.q
        public void a(long j3) {
            long size = j3 != 0 ? (j3 - this.f45620a.size()) - 1 : j3;
            long a16 = r7.a.a() / 1000;
            String uuid = UUID.randomUUID().toString();
            QzoneQuoteQunPicTask qzoneQuoteQunPicTask = new QzoneQuoteQunPicTask(this.f45621b, this.f45622c.getId(), this.f45622c.getTitle(), this.f45623d, this.f45620a, this.f45624e, 15, a16, uuid, size, this.f45625f);
            qzoneQuoteQunPicTask.addParameter(v4.a.QUNID, this.f45621b);
            qzoneQuoteQunPicTask.addParameter("albumid", this.f45622c.getId());
            QZoneWriteOperationService.this.notify(30, this.f45620a, this.f45621b, this.f45622c, uuid, this.f45624e, Long.valueOf(size));
            QZonePublishQueue.w().b(qzoneQuoteQunPicTask);
        }
    }

    public void i2(Handler handler, String str, String str2) {
        j2(handler, str, str2, 64, null);
    }

    public void u1(Handler handler, m mVar) {
        int i3;
        if (mVar == null) {
            return;
        }
        if (mVar.f45744k) {
            if (mVar.f45740g == null) {
                mVar.f45740g = new HashMap();
            }
            mVar.f45740g.put(54, "tih");
        }
        if (mVar.f45759z) {
            if (mVar.f45740g == null) {
                mVar.f45740g = new HashMap();
            }
            mVar.f45740g.put(180, "fri_recom");
        }
        if (mVar.f45750q) {
            i3 = 2;
        } else {
            i3 = mVar.f45751r ? 4 : !mVar.f45738e ? 1 : 0;
        }
        QZLog.d("[publish2]QZoneWriteOperationService", 2, "likeFeed: action = " + i3);
        CustomPraiseData customPraiseData = mVar.f45748o;
        HashMap<Integer, String> externParam = customPraiseData != null ? customPraiseData.toExternParam(null, mVar.f45749p) : null;
        String str = mVar.f45735b;
        String str2 = mVar.f45736c;
        int i16 = mVar.f45739f;
        long j3 = mVar.f45752s;
        QZoneTask qZoneTask = new QZoneTask(new QZoneLikeRequest(0, str, str2, i3, i16, j3, mVar.f45740g, externParam, mVar.f45753t, j3), handler, this, 1);
        qZoneTask.addParameter("isLike", Boolean.valueOf(mVar.f45738e));
        qZoneTask.addParameter(s4.c.UGCKEY, mVar.f45734a);
        qZoneTask.addParameter("uniKey", mVar.f45736c);
        qZoneTask.addParameter("position", Integer.valueOf(mVar.f45742i));
        qZoneTask.addParameter("clickScene", Integer.valueOf(mVar.f45746m));
        qZoneTask.addParameter("feeddata", mVar.f45754u);
        qZoneTask.addParameter("feedtype", Integer.valueOf(mVar.f45755v));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        K1(i3, mVar);
        CustomPraiseData customPraiseData2 = mVar.f45748o;
        if (customPraiseData2 == null || customPraiseData2.itemId == -1) {
            return;
        }
        MobileReportManager.getInstance().reportAction("qzone_pri", "4", "12", 144, 1, System.currentTimeMillis());
    }

    public void R(Handler handler, String str, String str2, String str3, int i3, long j3, String str4, String str5, String str6, int i16, Map<Integer, String> map, boolean z16, String str7, User user, boolean z17, boolean z18, Map<String, String> map2) {
        String str8;
        if (com.qzone.util.o.b(handler)) {
            return;
        }
        t5.a.b(str6);
        if (z17) {
            map.put(54, "tih");
        }
        QZoneTask qZoneTask = new QZoneTask(new QZoneAddCommentRequest(0, i3, j3, str4, str5, str6, i16, map, str7, z18, map2), handler, this, 0);
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        qZoneTask.addParameter("feedkey", str2);
        qZoneTask.addParameter("uniKey", str3);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        if (z18) {
            str8 = str5 + "[em]e10011[/em]";
        } else {
            str8 = str5;
        }
        if (!z16 && i3 != 334) {
            notify(5, str, str3, "", str8, Long.valueOf(j3), user, str2);
        } else {
            notify(12, str, str3, str8, Boolean.valueOf(z16), str2, map2);
        }
    }

    public void Z(Handler handler, String str, String str2, String str3, int i3, long j3, int i16, long j16, Map<Integer, String> map, int i17, String str4, String str5) {
        String str6;
        QZoneTask qZoneTask = new QZoneTask(new QZoneDeleteMyFeedRequest(i3, j3, i16, str2, j16, map, str3), handler, this, 25);
        if (i17 == 27) {
            qZoneTask.addParameter("albumid", str4);
            qZoneTask.addParameter("lloc", str5);
            if (map != null && map.containsKey(2)) {
                notify(17, str, map.get(2), str2, map.get(12));
            }
            str6 = "delete_photo";
        } else if (i17 != 30) {
            notify(8, str, str3);
            str6 = "";
        } else {
            qZoneTask.addParameter("albumid", str4);
            qZoneTask.addParameter("lloc", str5);
            if (map != null && map.containsKey(2)) {
                notify(46, str, map.get(2), str2, map.get(12));
            }
            str6 = "delete_photo_video";
        }
        HashMap<Object, Object> hashMap = qZoneTask.extraData;
        if (hashMap != null) {
            hashMap.put("deleteType", str6);
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void V(int i3, Handler handler, String str, String str2, String str3, int i16, long j3, String str4, String str5, int i17, Map<Integer, String> map, int i18, String str6, Map<String, String> map2) {
        String str7;
        QZoneTask qZoneTask = new QZoneTask(new QzoneDeleteDetailRequest(i3, i16, j3, str4, str5, i17, map, str3, map2), handler, this, 4);
        qZoneTask.addParameter(s4.c.UGCKEY, str);
        if (i18 == 26) {
            qZoneTask.addParameter("albumid", str4);
            str7 = "delete_album";
        } else if (i18 == 27) {
            qZoneTask.addParameter("albumid", str4);
            qZoneTask.addParameter("lloc", str6);
            if (map != null && map.containsKey(2)) {
                notify(17, str, map.get(2), str2, map.get(12));
            }
            str7 = "delete_photo";
        } else if (i18 != 30) {
            notify(8, str, str3);
            str7 = "";
        } else {
            qZoneTask.addParameter("albumid", str4);
            qZoneTask.addParameter("lloc", str6);
            if (map != null && map.containsKey(2)) {
                notify(46, str, map.get(2), str2, map.get(12));
            }
            str7 = "delete_photo_video";
        }
        HashMap<Object, Object> hashMap = qZoneTask.extraData;
        if (hashMap != null) {
            hashMap.put("deleteType", str7);
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g0(int i3, List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i16, LbsDataV2.PoiInfo poiInfo, long j3, long j16, String str, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i17, int i18, String str2, Map<String, byte[]> map2, Map<String, String> map3, ArrayList<GifInfo> arrayList) {
        int i19;
        Object obj;
        String str3;
        List<ImageInfo> list2 = list;
        if (map3 != null && map3.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_TASK_ID) && map3.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_URL) && !map3.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR)) {
            String str4 = map3.get(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_TASK_ID);
            String str5 = map3.get(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_URL);
            if (!bl.b(list)) {
                str3 = list2.get(0).mDescription;
            } else {
                str3 = "";
            }
            QZonePhotoRepairUploadManger.e().f(str4, businessAlbumInfo.mAlbumId, Long.valueOf(j3), str3, str5);
            return;
        }
        int size = list.size();
        com.qzone.publish.business.publishqueue.h.a(j3, size);
        String uuid = UUID.randomUUID().toString();
        if (map3 != null && map3.containsKey(QZonePublishMoodRequest.KEY_UPLOAD_PHOTO_CLIENT_KEY)) {
            String str6 = map3.get(QZonePublishMoodRequest.KEY_UPLOAD_PHOTO_CLIENT_KEY);
            if (!TextUtils.isEmpty(str6)) {
                uuid = str6;
            }
        }
        String str7 = uuid;
        if (i3 == 0) {
            if (poiInfo == null || !(map == null || map.get("geo_idname") == null)) {
                obj = null;
            } else if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                obj = poiInfo.poiDefaultName;
            } else if (!TextUtils.isEmpty(poiInfo.poiName)) {
                obj = poiInfo.poiName;
            } else {
                obj = poiInfo.address;
            }
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<ImageInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new MediaWrapper(it.next()));
                }
                le.b.f414397d.a(poiInfo, arrayList2, str7, map, le.a.f414396a.f(businessAlbumInfo));
            } else {
                notify(10, str7, list2, obj, Long.valueOf(j16), businessAlbumInfo, map, map3, Long.valueOf(j3));
                long j17 = j16;
                i19 = 0;
                while (i19 < size) {
                    if (j17 != 0) {
                        j17--;
                    }
                    long j18 = j17;
                    ImageInfo imageInfo = list2.get(i19);
                    int i26 = i19;
                    int i27 = size;
                    H(i3, imageInfo.panoramaType, imageInfo.mName, imageInfo.mPath, imageInfo.mModifiedDate, businessAlbumInfo.getId(), businessAlbumInfo.getTitle(), imageInfo.mDescription, i16, poiInfo, i27, i26, j3, str7, j18, str, qZonePreUploadInfo, map, i17, i18, str2, map2, map3, imageInfo.mPhotoTagInfo, false, arrayList, imageInfo.mExternalData);
                    i19 = i26 + 1;
                    size = i27;
                    j17 = j18;
                    list2 = list;
                }
            }
        }
        long j172 = j16;
        i19 = 0;
        while (i19 < size) {
        }
    }

    public void h2(String str, long j3, long j16) {
        if (j3 >= 0 && j16 >= 0 && j16 > j3 && !TextUtils.isEmpty(str)) {
            if (this.f45605e == null) {
                this.f45605e = new HashMap<>();
            }
            this.f45605e.put(str, Long.valueOf(j3));
            if (this.f45606f == null) {
                this.f45606f = new HashMap<>();
            }
            this.f45606f.put(str, Long.valueOf(j16));
            return;
        }
        QZLog.e("[publish2]QZoneWriteOperationService", "saveLocalVideoPlayTime error, [vid:" + str + ", startTime:" + j3 + ", endTime:" + j16 + "]");
    }

    public void d2(Map<Integer, String> map, boolean z16, BusinessFeedData businessFeedData) {
        L(map, 31, 0, 0, 0, 0, true, false, "", "", 0L, false, z16, "", false, businessFeedData);
    }

    public void X(Handler handler, String str, String str2, String str3, int i3, long j3, String str4, String str5, int i16, Map<Integer, String> map, int i17, String str6) {
        U(0, handler, str, str2, str3, i3, j3, str4, str5, i16, map, i17, str6);
    }

    public void i0(String str, String str2, int i3, long j3, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, Handler handler) {
        h0(str, str2, i3, j3, str3, str4, str5, arrayList, str6, 0L, null, -1, handler);
    }

    public void U(int i3, Handler handler, String str, String str2, String str3, int i16, long j3, String str4, String str5, int i17, Map<Integer, String> map, int i18, String str6) {
        V(i3, handler, str, str2, str3, i16, j3, str4, str5, i17, map, i18, str6, null);
    }

    private void k0(String str, int i3, ShuoshuoVideoInfo shuoshuoVideoInfo, List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i16, LbsDataV2.PoiInfo poiInfo, long j3, long j16, String str2, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i17, int i18, String str3, Map<String, byte[]> map2, Map<String, String> map3) {
        l0(str, i3, shuoshuoVideoInfo, list, businessAlbumInfo, i16, poiInfo, j3, j16, str2, qZonePreUploadInfo, map, i17, i18, str3, map2, map3, null);
    }

    public void L(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, BusinessFeedData businessFeedData) {
        K(map, i3, i16, i17, i18, i19, z16, z17, str, str2, j3, z18, z19, str3, z26, 0L, businessFeedData, 0L);
    }

    private void Y0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
    }

    public void c2(Handler handler, String str, String str2, String str3, int i3, long j3, long j16, User user, String str4, String str5, String str6, String str7, String str8, String str9, int i16, Map<Integer, String> map, String str10, boolean z16, int i17, int i18, Map<String, String> map2) {
        b2(0, handler, str, str2, str3, i3, j3, j16, user, str4, str5, str6, str7, str8, str9, i16, map, str10, z16, i17, i18, map2);
    }

    public void a0(Handler handler, long j3, String str, String str2, String str3, Map<Integer, String> map, String str4, boolean z16, int i3) {
    }

    public void b0(Handler handler, long j3, String str, String str2, String str3, Map<Integer, String> map, String str4, String str5, boolean z16) {
    }
}
