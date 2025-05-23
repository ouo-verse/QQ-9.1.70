package com.qzone.publish.ui.activity;

import FileUpload.MarkUinInfoBeforeUpload;
import FileUpload.cnst.kExtKeyMarkUinBeforeUpload;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.st_copy_photo;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.album.business.photogroupgrade.PhotoGroupOptimizeFuncSwitcher;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneQueryAlbumRequest;
import com.qzone.album.qun.ui.ReshipPhotoStateQun;
import com.qzone.album.qun.ui.ReshipPhotoStateQun4PhotoList;
import com.qzone.album.qun.ui.ReshipPhotoStateQunAIO;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneAdvService;
import com.qzone.common.event.EventCenter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.publish.ui.state.UploadPhotoStateNormal;
import com.qzone.publish.ui.state.UploadPhotoStateQun;
import com.qzone.publish.ui.state.UploadPhotoStateQun4PhotoList;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.part.publish.mood.sync.QZonePublishSyncQCirclePart;
import com.qzone.util.ToastUtil;
import com.qzone.util.am;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.qzone.widget.AlbumVipOpenArea;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.ExtendScrollView;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.qzone.widget.util.b;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.qzonehub.api.events.QZoneUploadPhotoPageFinishEvent;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$BuyItemRsp;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.Size;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import e9.a;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QZoneUploadPhotoActivity extends PhotoActivity {

    /* renamed from: b5, reason: collision with root package name */
    private static final int f51686b5 = ViewUtils.dpToPx(8.0f);

    /* renamed from: c5, reason: collision with root package name */
    public static String f51687c5 = "QunReshipPhotoToQzone.key_qun_photo_info";
    private RFWSquareImageView A2;
    private QZonePublishSyncQCirclePart B2;
    private AtomicInteger C2;
    private AsyncImageView C4;
    private TextView E4;
    private String F4;
    private int G4;
    private String H4;
    private boolean J4;
    public BusinessAlbumInfo L2;
    public ai N2;
    private String O2;
    private QzoneVipInfo O4;
    private String P2;
    private String P4;
    protected RelativeLayout R2;
    private RelativeLayout S2;
    private RelativeLayout T2;
    private bm.a T4;
    private int U2;
    private int V2;
    public String W2;
    private mc.a W4;
    private String X2;
    public boolean Z2;

    /* renamed from: a3, reason: collision with root package name */
    private View f51688a3;

    /* renamed from: a5, reason: collision with root package name */
    ActionSheet f51689a5;

    /* renamed from: b3, reason: collision with root package name */
    private AsyncImageView f51690b3;

    /* renamed from: c3, reason: collision with root package name */
    private TextView f51692c3;

    /* renamed from: d3, reason: collision with root package name */
    private RelativeLayout f51693d3;

    /* renamed from: e3, reason: collision with root package name */
    private RelativeLayout f51695e3;

    /* renamed from: f3, reason: collision with root package name */
    private AlbumVipOpenArea f51696f3;

    /* renamed from: g3, reason: collision with root package name */
    protected RelativeLayout f51697g3;

    /* renamed from: h3, reason: collision with root package name */
    protected TextView f51698h3;
    protected Switch i3;
    protected ShuoshuoVideoInfo k3;
    private long l3;
    private long m3;

    /* renamed from: o3, reason: collision with root package name */
    b.c f51699o3;

    /* renamed from: u2, reason: collision with root package name */
    private RelativeLayout f51708u2;

    /* renamed from: v2, reason: collision with root package name */
    private TextView f51709v2;

    /* renamed from: w2, reason: collision with root package name */
    private TextView f51710w2;

    /* renamed from: x2, reason: collision with root package name */
    private ImageView f51711x2;

    /* renamed from: y2, reason: collision with root package name */
    private ImageView f51713y2;

    /* renamed from: z2, reason: collision with root package name */
    private ImageView f51715z2;

    /* renamed from: t2, reason: collision with root package name */
    private long f51706t2 = QzoneConfig.getUploadRawVideoByte();
    private boolean D2 = true;
    private boolean E2 = true;
    private boolean F2 = false;
    private boolean G2 = false;
    private boolean H2 = true;
    private boolean I2 = false;
    private String J2 = "";
    private int K2 = 0;
    public ag M2 = new ag();
    public String Q2 = "";
    public boolean Y2 = true;
    protected boolean j3 = false;
    private boolean n3 = false;

    /* renamed from: p3, reason: collision with root package name */
    private String f51700p3 = null;

    /* renamed from: q3, reason: collision with root package name */
    private String f51702q3 = null;

    /* renamed from: r3, reason: collision with root package name */
    private String f51703r3 = null;

    /* renamed from: s3, reason: collision with root package name */
    private String f51705s3 = null;

    /* renamed from: t3, reason: collision with root package name */
    private String f51707t3 = null;

    /* renamed from: x3, reason: collision with root package name */
    private String f51712x3 = null;

    /* renamed from: y3, reason: collision with root package name */
    private String f51714y3 = null;

    /* renamed from: b4, reason: collision with root package name */
    private String f51691b4 = null;

    /* renamed from: d4, reason: collision with root package name */
    private String f51694d4 = null;

    /* renamed from: p4, reason: collision with root package name */
    private String f51701p4 = null;

    /* renamed from: r4, reason: collision with root package name */
    private String f51704r4 = null;
    private boolean D4 = false;
    private ArrayList<LocalMediaInfo> I4 = new ArrayList<>();
    private String K4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastHaveToChoosePhotoOrVideo", "\u672a\u9009\u62e9\u7167\u7247\u6216\u89c6\u9891");
    private String L4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastHowManyPhotoQuoteFail", "\u5f20\u8f6c\u8f7d\u5931\u8d25");
    private String M4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastQuoteFail", "\u8f6c\u8f7d\u5931\u8d25");
    private String N4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoProcessing", "\u6b63\u5728\u5904\u7406\u89c6\u9891...");
    private boolean Q4 = false;
    private boolean R4 = ar.b("kenaiyu", "2024-11-18", "vas_bug_qzone_upload_opt").isEnable(true);
    private boolean S4 = false;
    private final ym.a U4 = new ym.a();
    private boolean V4 = false;
    private View.OnClickListener X4 = new k();
    private AbsCompatRequest.a Y4 = new s();
    private AbsCompatRequest.a Z4 = new AbsCompatRequest.a() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.31
        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            QZoneUploadPhotoActivity.this.G2 = true;
            QZoneUploadPhotoActivity.this.Y4.a(absCompatRequest, sVar, i3, str);
            QZoneUploadPhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.31.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneUploadPhotoActivity.this.wq();
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class aa implements QZoneFontPanel.f {
        aa() {
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.f
        public void a() {
            ClickReport.c(602, 8, "1", true, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ab implements View.OnClickListener {
        ab() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneUploadPhotoActivity.this.cp();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ac implements View.OnClickListener {
        ac() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadPhotoActivity.this.simpleClassname, view);
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).K1 == 12) {
                LpReportInfo_pf00064.allReport(86, 8, 2);
            }
            QZoneUploadPhotoActivity.this.Wp();
            LpReportInfo_pf00064.allReport(602, 3);
            ClickReport.m("604", "3", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ad implements View.OnClickListener {
        ad() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadPhotoActivity.this.simpleClassname, view);
            QZoneUploadPhotoActivity.this.Zo();
            LpReportInfo_pf00064.allReport(602, 4);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ae implements AdapterView.OnItemClickListener {
        ae() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            RDMEtraMsgCollector.getInstance().addNormalItemClickAction(QZoneUploadPhotoActivity.this.simpleClassname, adapterView, view, i3, j3);
            if (QZoneUploadPhotoActivity.this.T.d0(i3) && QZoneUploadPhotoActivity.this.T.H(view)) {
                QZoneUploadPhotoActivity.this.Gp();
                return;
            }
            LpReportInfo_pf00064.allReport(602, 10);
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 6 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 7 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 8 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 3 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 5 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 4 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 11 && ((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 12) {
                QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                DynamicGridView dynamicGridView = qZoneUploadPhotoActivity.P;
                ArrayList<String> oj5 = qZoneUploadPhotoActivity.oj();
                boolean h16 = QZoneUploadPhotoActivity.this.P.h1();
                qZoneUploadPhotoActivity.Wk(dynamicGridView, i3, oj5, h16 ? 1 : 0, ((PhotoActivity) QZoneUploadPhotoActivity.this).f45144z1);
                return;
            }
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
            qZoneUploadPhotoActivity2.Wk(qZoneUploadPhotoActivity2.P, i3, qZoneUploadPhotoActivity2.Oo(), 1, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class ag {

        /* renamed from: a, reason: collision with root package name */
        private AlbumCacheData f51758a;

        /* renamed from: b, reason: collision with root package name */
        private String f51759b;

        /* renamed from: c, reason: collision with root package name */
        private String f51760c;

        /* renamed from: d, reason: collision with root package name */
        private int f51761d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<Long> f51762e;

        /* renamed from: f, reason: collision with root package name */
        private String f51763f;

        /* renamed from: g, reason: collision with root package name */
        private String f51764g;

        ag() {
        }

        public boolean a(AlbumCacheData albumCacheData) {
            AlbumCacheData albumCacheData2 = this.f51758a;
            if (albumCacheData2 == null || albumCacheData == null || TextUtils.isEmpty(albumCacheData2.albumid) || TextUtils.isEmpty(albumCacheData.albumid)) {
                return false;
            }
            return this.f51758a.albumid.equals(albumCacheData.albumid);
        }

        public void c() {
            ArrayList<Long> arrayList;
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData != null && (arrayList = albumCacheData.album_white_list) != null) {
                arrayList.clear();
            }
            ArrayList<Long> arrayList2 = this.f51762e;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }

        public AlbumCacheData d() {
            return this.f51758a;
        }

        public String e() {
            return this.f51760c;
        }

        public boolean f() {
            AlbumCacheData albumCacheData = this.f51758a;
            return (albumCacheData == null || TextUtils.isEmpty(albumCacheData.albumid)) ? false : true;
        }

        public void h() {
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData == null) {
                return;
            }
            albumCacheData.albumanswer = this.f51764g;
            albumCacheData.albumquestion = this.f51763f;
            albumCacheData.albumrights = this.f51761d;
            albumCacheData.album_white_list = this.f51762e;
        }

        public void j(AlbumCacheData albumCacheData, boolean z16) {
            g(z16);
            this.f51758a = albumCacheData;
        }

        public void k(String str) {
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData == null) {
                return;
            }
            this.f51764g = albumCacheData.albumanswer;
            albumCacheData.albumanswer = str;
        }

        public void l(String str) {
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData == null) {
                return;
            }
            this.f51763f = albumCacheData.albumquestion;
            albumCacheData.albumquestion = str;
        }

        public void m(String str) {
            this.f51760c = str;
        }

        public void n(String str) {
            this.f51759b = str;
        }

        public void o(int i3) {
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData == null) {
                return;
            }
            this.f51761d = albumCacheData.albumrights;
            albumCacheData.albumrights = i3;
        }

        public void p(ArrayList<Long> arrayList) {
            AlbumCacheData albumCacheData = this.f51758a;
            if (albumCacheData == null) {
                return;
            }
            this.f51762e = albumCacheData.album_white_list;
            albumCacheData.album_white_list = arrayList;
        }

        public void b() {
            this.f51764g = null;
            this.f51763f = null;
            this.f51762e = null;
            this.f51761d = -1;
        }

        public void i(AlbumCacheData albumCacheData) {
            j(albumCacheData, true);
        }

        private void g(boolean z16) {
            if (z16) {
                this.f51759b = null;
                this.f51760c = null;
            }
            this.f51758a = null;
            this.f51761d = -1;
            this.f51762e = null;
            this.f51763f = null;
            this.f51764g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class ah implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneUploadPhotoActivity> f51765a;

        /* renamed from: b, reason: collision with root package name */
        private String f51766b;

        public ah(QZoneUploadPhotoActivity qZoneUploadPhotoActivity, String str) {
            this.f51765a = new WeakReference<>(qZoneUploadPhotoActivity);
            this.f51766b = str;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity;
            WeakReference<QZoneUploadPhotoActivity> weakReference = this.f51765a;
            if (weakReference == null || (qZoneUploadPhotoActivity = weakReference.get()) == null) {
                return null;
            }
            String str2 = this.f51766b;
            str2.hashCode();
            if (!str2.equals("yellow_tips")) {
                if (!str2.equals("upload_view")) {
                    return new HashMap();
                }
                return qZoneUploadPhotoActivity.Uo();
            }
            return qZoneUploadPhotoActivity.Yo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class aj implements Function0<Unit> {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QZoneUploadPhotoActivity> f51769d;

        public aj(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
            this.f51769d = new WeakReference<>(qZoneUploadPhotoActivity);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51769d.get();
            if (qZoneUploadPhotoActivity == null) {
                return null;
            }
            qZoneUploadPhotoActivity.gp();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements DynamicGridView.s {
        b() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void a(int i3, int i16) {
            QZoneUploadPhotoActivity.this.Zk(i3, i16);
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void b(int i3, int i16) {
            if (i16 == 0) {
                ClickReport.m("47", "5", "1");
            } else if (i16 == 1) {
                ClickReport.m("47", "5", "3");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadPhotoActivity.this.simpleClassname, view);
            ((LBSModule) QZoneUploadPhotoActivity.this.hj(LBSModule.class)).C();
            ClickReport.m("437", "1", "1");
            LpReportInfo_pf00064.allReport(602, 5);
            ClickReport.m("604", "5", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.putExtra("aid", "jhan_xcsc");
            intent.putExtra("direct_go", true);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(QZoneUploadPhotoActivity.this.getActivity(), intent, -1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneUploadPhotoActivity.this.ap();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        private void a() {
            Intent qZoneVideoDownloadActivityIntent = QZoneHelper.getQZoneVideoDownloadActivityIntent(QZoneUploadPhotoActivity.this.getActivity().getApplicationContext());
            qZoneVideoDownloadActivityIntent.putExtra("video_type", QZoneUploadPhotoActivity.this.k3.mVideoType);
            qZoneVideoDownloadActivityIntent.putExtra("file_send_path", QZoneUploadPhotoActivity.this.k3.mVideoPath);
            qZoneVideoDownloadActivityIntent.putExtra("preview_video", true);
            qZoneVideoDownloadActivityIntent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, QZoneUploadPhotoActivity.this.k3.mExtras);
            qZoneVideoDownloadActivityIntent.putExtra(PeakConstants.VIDEO_REFER, PeakConstants.VIDEO_REFER_FROM_ALBUM);
            QZoneUploadPhotoActivity.this.startActivity(qZoneVideoDownloadActivityIntent);
        }

        private void b() {
            Intent P = ak.P(QZoneUploadPhotoActivity.this.getActivity().getApplicationContext());
            P.putExtra("video_type", QZoneUploadPhotoActivity.this.k3.mVideoType);
            P.putExtra("video_source_path", QZoneUploadPhotoActivity.this.k3.mVideoPath);
            P.putExtra("start_time", QZoneUploadPhotoActivity.this.k3.mStartTime);
            P.putExtra("end_time", QZoneUploadPhotoActivity.this.k3.mEndTime);
            QZoneUploadPhotoActivity.this.startActivity(P);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object obj = "";
            ClickReport.m("604", "6", "");
            ShuoshuoVideoInfo shuoshuoVideoInfo = QZoneUploadPhotoActivity.this.k3;
            if (shuoshuoVideoInfo != null && !FileUtils.fileExists(shuoshuoVideoInfo.mVideoPath)) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFileNotExist", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC), 4);
            } else {
                ShuoshuoVideoInfo shuoshuoVideoInfo2 = QZoneUploadPhotoActivity.this.k3;
                if (shuoshuoVideoInfo2 != null && shuoshuoVideoInfo2.mVideoType == 0) {
                    a();
                } else if (shuoshuoVideoInfo2 != null && 1 == shuoshuoVideoInfo2.mVideoType) {
                    if (!QZoneVideoCommonUtils.getTrimSupport().isAvailable()) {
                        com.qzone.common.business.service.b.f().w(QZoneUploadPhotoActivity.this.getRealActivity(), QZoneUploadPhotoActivity.this.k3);
                    } else {
                        b();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("goto preview, video type error, type=");
                    ShuoshuoVideoInfo shuoshuoVideoInfo3 = QZoneUploadPhotoActivity.this.k3;
                    if (shuoshuoVideoInfo3 != null) {
                        obj = Integer.valueOf(shuoshuoVideoInfo3.mVideoType);
                    }
                    sb5.append(obj);
                    QZLog.w("QZoneUploadPhotoActivity", sb5.toString());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!QZoneUploadPhotoActivity.this.Bo() && z16) {
                QZoneUploadPhotoActivity.this.i3.setChecked(false);
                QZoneUploadPhotoActivity.this.kq();
            } else {
                QZoneUploadPhotoActivity.this.j3 = z16;
                if (z16) {
                    try {
                        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PRESET, "medium");
                        ActivityManager activityManager = (ActivityManager) QZoneUploadPhotoActivity.this.getActivity().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        int g16 = com.qzone.util.ag.g(config, true);
                        if (memoryInfo.availMem < g16) {
                            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastLessMemoryToTrim", "\u5f53\u524d\u53ef\u7528\u5185\u5b58\u8fc7\u5c11\uff0c\u53ef\u80fd\u5f71\u54cd\u88c1\u526a\u64cd\u4f5c"));
                        }
                        if (QZLog.isColorLevel()) {
                            QZLog.d("QZoneUploadPhotoActivity", 2, "availMem=" + memoryInfo.availMem + ", threshold=" + memoryInfo.threshold + ", lowMem=" + memoryInfo.lowMemory + ", minRam=" + g16 + ", preset=" + config);
                        }
                    } catch (Exception e16) {
                        QZLog.w(e16);
                    }
                }
            }
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
            com.qzone.util.ag.C(qZoneUploadPhotoActivity.k3, qZoneUploadPhotoActivity.i3.isChecked());
            if (z16) {
                ClickReport.m("604", "4", "2");
            } else {
                ClickReport.m("604", "4", "1");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes39.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadPhotoActivity.this.simpleClassname, view);
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).K1 == 12) {
                LpReportInfo_pf00064.allReport(86, 8, 4);
            }
            QZoneUploadPhotoActivity.this.ck();
            QZoneUploadPhotoActivity.this.onBack();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            eo.c.f396879a.a();
            int D = QZoneUploadPhotoActivity.this.L2 != null ? QZonePublishQueue.w().D(QZoneUploadPhotoActivity.this.L2.mAlbumId) : 0;
            if (QZoneUploadPhotoActivity.this.rp() && QZoneUploadPhotoActivity.this.f51696f3 != null) {
                AlbumVipOpenArea albumVipOpenArea = QZoneUploadPhotoActivity.this.f51696f3;
                QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                if (!albumVipOpenArea.b(qZoneUploadPhotoActivity.D0, qZoneUploadPhotoActivity.oj().size() + D)) {
                    QZoneUploadPhotoActivity.this.Jp();
                    EventCollector.getInstance().onViewClicked(view);
                }
            }
            QZoneUploadPhotoActivity.this.fm(view);
            QZoneUploadPhotoActivity.this.gm(false);
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(com.qzone.util.ak.b(140, QZoneUploadPhotoActivity.this.Qo(), ""));
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneUploadPhotoActivity.this.simpleClassname, view);
            String To = QZoneUploadPhotoActivity.this.To();
            if (!TextUtils.isEmpty(To)) {
                QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), To);
            }
            if (QZoneUploadPhotoActivity.this.I2) {
                QZoneUploadPhotoActivity.this.vq();
            } else if (QZoneUploadPhotoActivity.this.Ui() > QZoneUploadPhotoActivity.this.ej()) {
                QZoneUploadPhotoActivity.this.toast(R.string.f173054gr0);
                QZoneUploadPhotoActivity.this.gm(true);
            } else {
                QZoneUploadPhotoActivity.this.zo();
            }
            LpReportInfo_pf00064.allReport(602, 1);
            Intent intent = QZoneUploadPhotoActivity.this.getIntent();
            int intExtra = intent.getIntExtra(QZoneHelper.Constants.KEY_STATE_TYPE_SRC, -1);
            boolean booleanExtra = intent.getBooleanExtra(QZoneHelper.IS_FROM_MINI_APP, false);
            if (intExtra == 1 && !booleanExtra) {
                com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
                String m3 = lVar.m(((PhotoActivity) QZoneUploadPhotoActivity.this).Q1, intent);
                String n3 = lVar.n(((PhotoActivity) QZoneUploadPhotoActivity.this).Q1, intent);
                String z16 = lVar.z(((PhotoActivity) QZoneUploadPhotoActivity.this).Q1, intent);
                String y16 = lVar.y(((PhotoActivity) QZoneUploadPhotoActivity.this).Q1, intent);
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = z16;
                userInfo.nickname = y16;
                QZoneHelper.forwardToQunFeed(QZoneUploadPhotoActivity.this.getActivity(), userInfo, m3, n3, true, -1);
            }
            String stringExtra = intent.getStringExtra("QZoneUploadRecommend.CLASSIFY_ID");
            if (!TextUtils.isEmpty(stringExtra)) {
                QZoneUploadRecommendDirector.INSTANCE.a().v(stringExtra);
            }
            if (QZoneUploadPhotoActivity.this.J4) {
                QZoneUploadPhotoActivity.this.startActivityForResult(ak.I(view.getContext(), QZoneUploadPhotoActivity.this.L2, 0), 3);
            }
            QZoneUploadPhotoActivity.this.Fo(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f51781d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f51782e;

        l(ViewGroup viewGroup, FrameLayout frameLayout) {
            this.f51781d = viewGroup;
            this.f51782e = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f51781d.removeView(this.f51782e);
            this.f51782e.destroyDrawingCache();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f51784d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f51785e;

        m(ViewGroup viewGroup, FrameLayout frameLayout) {
            this.f51784d = viewGroup;
            this.f51785e = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneUploadPhotoActivity.this.ap();
            this.f51784d.removeView(this.f51785e);
            this.f51785e.destroyDrawingCache();
            LpReportInfo_dc04586.report(new LpReportInfo_dc04586(LpReportInfo_dc04586.ITEM_ID_BTN_OPEN, 102, QZoneUploadPhotoActivity.this.O4.getVipType()));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f51787d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f51788e;

        n(ViewGroup viewGroup, FrameLayout frameLayout) {
            this.f51787d = viewGroup;
            this.f51788e = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f51787d.removeView(this.f51788e);
            this.f51788e.destroyDrawingCache();
            QZoneUploadPhotoActivity.this.ep();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class o implements View.OnTouchListener {
        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements ChannelCallback {
        p() {
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onError(boolean z16, int i3, String str) {
            QZoneUploadPhotoActivity.this.dp();
        }

        @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
        public void onRecv(byte[] bArr) {
            QZoneVipPayInfo$BuyItemRsp qZoneVipPayInfo$BuyItemRsp = new QZoneVipPayInfo$BuyItemRsp();
            if (bArr == null) {
                QZoneUploadPhotoActivity.this.dp();
                return;
            }
            try {
                qZoneVipPayInfo$BuyItemRsp.mergeFrom(bArr);
                if (qZoneVipPayInfo$BuyItemRsp.code.get() != 0) {
                    QZoneUploadPhotoActivity.this.dp();
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QZoneUploadPhotoActivity.this.dp();
                QZLog.e("QZoneUploadPhotoActivity", 1, " handle sendMsgForGetPayInfo error", e16);
            }
            Bundle bundle = new Bundle();
            bundle.putString("callbackSn", "callbackSn");
            String uinString = LoginData.getInstance().getUinString();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("productId", qZoneVipPayInfo$BuyItemRsp.picInfo.productId.get());
                jSONObject.put(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "skey");
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, "uin");
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, uinString);
                jSONObject.put("aid", qZoneVipPayInfo$BuyItemRsp.picInfo.midasAppid.get());
                jSONObject.put("zoneId", qZoneVipPayInfo$BuyItemRsp.picInfo.zoneId.get());
                jSONObject.put("tokenUrl", qZoneVipPayInfo$BuyItemRsp.picInfo.midasUrlParams.get());
                jSONObject.put("userId", uinString);
                jSONObject.put("offerId", qZoneVipPayInfo$BuyItemRsp.picInfo.midasAppid.get());
                jSONObject.put("numberVisible", false);
            } catch (JSONException e17) {
                QZoneUploadPhotoActivity.this.dp();
                QZLog.e("QZoneUploadPhotoActivity", 1, " handle sendMsgForGetPayInfo error", e17);
            }
            bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, jSONObject.toString());
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 5);
            LpReportInfo_dc04586.report(new LpReportInfo_dc04586(LpReportInfo_dc04586.ITEM_ID_BTN_PAY, 109, QZoneUploadPhotoActivity.this.O4.getVipType(), qZoneVipPayInfo$BuyItemRsp.picInfo.midasAppid.get()));
            ((IPayLogic) QRoute.api(IPayLogic.class)).newPay(BaseApplicationImpl.getApplication().getRuntime(), QZoneUploadPhotoActivity.this.getRealActivity(), new ResultReceiver(QZoneUploadPhotoActivity.this.getHandler()), 7, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements DialogInterface.OnClickListener {
        q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneUploadPhotoActivity.this.Zo();
        }
    }

    /* loaded from: classes39.dex */
    class s implements AbsCompatRequest.a {
        s() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (QZoneUploadPhotoActivity.this.C2 != null) {
                QZLog.i("QZoneUploadPhotoActivity", "QueryAlbumOnResponse -> cnt = " + QZoneUploadPhotoActivity.this.C2.decrementAndGet());
            }
            QZoneUploadPhotoActivity.this.E2 = true;
            QZoneUploadPhotoActivity.this.D2 = true;
            if (sVar.getSucceed()) {
                if (sVar.getData() instanceof QZoneQueryAlbumRequest.a) {
                    QZoneQueryAlbumRequest.a aVar = (QZoneQueryAlbumRequest.a) sVar.getData();
                    if (aVar.f43974c != null) {
                        if (!QZoneUploadPhotoActivity.this.M2.f()) {
                            QZoneUploadPhotoActivity.this.M2.i(aVar.f43974c);
                        } else if (QZoneUploadPhotoActivity.this.M2.a(aVar.f43974c)) {
                            QZoneUploadPhotoActivity.this.M2.j(aVar.f43974c, false);
                        }
                    }
                    BusinessAlbumInfo businessAlbumInfo = aVar.f43973b;
                    if (businessAlbumInfo != null) {
                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                        if (qZoneUploadPhotoActivity.L2 == null) {
                            qZoneUploadPhotoActivity.L2 = businessAlbumInfo;
                        } else {
                            QLog.i("QZoneUploadPhotoActivity", 1, "pre album id is " + QZoneUploadPhotoActivity.this.L2.mAlbumId + ", is from last upload is " + QZoneUploadPhotoActivity.this.L2.isFromLastUpload + ", query album id is " + aVar.f43973b.mAlbumId + ", is mood album " + aVar.f43973b.isMoodAlbum);
                            if (!QZoneUploadPhotoActivity.this.L2.mAlbumId.equals(aVar.f43973b.mAlbumId)) {
                                QLog.i("QZoneUploadPhotoActivity", 1, "album id not equal");
                                return;
                            }
                            BusinessAlbumInfo businessAlbumInfo2 = aVar.f43973b;
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                            BusinessAlbumInfo businessAlbumInfo3 = qZoneUploadPhotoActivity2.L2;
                            businessAlbumInfo2.isFromLastUpload = businessAlbumInfo3.isFromLastUpload;
                            boolean z16 = businessAlbumInfo3.isFromLastUpload;
                            if (!z16 && businessAlbumInfo2.isMoodAlbum) {
                                qZoneUploadPhotoActivity2.Z2 = true;
                            }
                            if (z16 && businessAlbumInfo2.isMoodAlbum) {
                                qZoneUploadPhotoActivity2.L2 = null;
                            } else {
                                qZoneUploadPhotoActivity2.L2 = businessAlbumInfo2;
                            }
                        }
                        QZoneUploadPhotoActivity.this.gq();
                        QZoneUploadPhotoActivity.this.Xp(false);
                        if (QZoneUploadPhotoActivity.this.F2) {
                            QZoneUploadPhotoActivity.this.F2 = false;
                            QZoneUploadPhotoActivity.this.cp();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (sVar.getReturnCode() == -11529) {
                QZoneUploadPhotoActivity.this.M2.i(null);
                QZoneUploadPhotoActivity qZoneUploadPhotoActivity3 = QZoneUploadPhotoActivity.this;
                BusinessAlbumInfo businessAlbumInfo4 = qZoneUploadPhotoActivity3.L2;
                if (businessAlbumInfo4 == null || businessAlbumInfo4.mAlbumType != 1) {
                    qZoneUploadPhotoActivity3.D2 = false;
                    return;
                }
                qZoneUploadPhotoActivity3.L2 = null;
                qZoneUploadPhotoActivity3.gq();
                QZoneUploadPhotoActivity.this.Xp(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class t implements AbsCompatRequest.a {
        t() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            com.qzone.common.activities.titlebuilder.a aVar = QZoneUploadPhotoActivity.this.C;
            if (aVar != null && aVar.isRefreshing()) {
                QZoneUploadPhotoActivity.this.C.y();
            }
            if (sVar == null) {
                QZLog.e("QZoneUploadPhotoActivity", "[changeAlbumPermission] change permision failed -> no wrapper");
                QZoneUploadPhotoActivity.this.hq(4);
                return;
            }
            if (sVar.getSucceed()) {
                QZoneUploadPhotoActivity.this.M2.b();
                return;
            }
            QZoneUploadPhotoActivity.this.M2.h();
            if (QZoneUploadPhotoActivity.this.M2.d() != null) {
                QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                qZoneUploadPhotoActivity.L2.mPrivacy = qZoneUploadPhotoActivity.M2.d().albumrights;
            }
            QZoneUploadPhotoActivity.this.gq();
            QZLog.e("QZoneUploadPhotoActivity", "[changeAlbumPermission] change permision failed -> " + sVar.getMessage());
            if (-11592 != i3 || TextUtils.isEmpty(sVar.getMessage())) {
                QZoneUploadPhotoActivity.this.hq(4);
            } else {
                ToastUtil.s(sVar.getMessage(), 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class v implements View.OnFocusChangeListener {
        v() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (view instanceof ExtendEditText) {
                ExtendEditText extendEditText = (ExtendEditText) view;
                if (!z16) {
                    if (extendEditText.getTag() != null) {
                        extendEditText.setHint(extendEditText.getTag().toString());
                    }
                } else if (extendEditText.getHint() != null) {
                    extendEditText.setTag(extendEditText.getHint().toString());
                    extendEditText.setHint("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class w implements DialogInterface.OnClickListener {
        w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneUploadPhotoActivity.this.Lp("an_yuanshipin");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class x implements ActionSheet.OnButtonClickListener {
        x() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZoneUploadPhotoActivity.this.simpleClassname + "   QQCustomDialog  which:0");
            QZoneUploadPhotoActivity.this.wq();
            QZoneUploadPhotoActivity.this.f51689a5.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class y implements ActionSheet.OnDismissListener {
        y() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity] QZoneUploadPhotoActivity   QQCustomDialog  whichButton:1");
            QZoneUploadPhotoActivity.this.gm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Integer.toHexString(view.getId());
            QZoneUploadPhotoActivity.this.fk(false);
            Intent intent = new Intent();
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).K1 == 0) {
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
            } else {
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, false);
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).K1 != 0 && !TextUtils.isEmpty(QZoneUploadPhotoActivity.this.O2)) {
                intent.putExtra("group_uin", QZoneUploadPhotoActivity.this.O2);
                intent.putExtra("group_name", QZoneUploadPhotoActivity.this.P2);
            }
            Activity realActivity = QZoneUploadPhotoActivity.this.getRealActivity();
            if (realActivity instanceof BasePluginActivity) {
                realActivity = ((BasePluginActivity) realActivity).getOutActivity();
            }
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(realActivity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ap() {
        RelativeLayout relativeLayout = this.T2;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        sq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bo() {
        return LoginData.getInstance().isQzoneVip() || this.Q4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bp(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Pair<Boolean, Boolean> tp5 = tp();
        if (tp5.first.booleanValue() || tp5.second.booleanValue()) {
            if (tp5.first.booleanValue() && tp5.second.booleanValue()) {
                str = "jhan.hz.rk.tq_ytyspsc";
            } else if (tp5.first.booleanValue()) {
                str = "jhan.hz.rk.tq_ytsc";
            } else {
                str = "jhan.hz.rk.tq_yspsc";
            }
            Co("em_qz_notice_strip", view);
            Kp(str);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Co(String str, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", getDaTongPageId());
        fo.c.q(view, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do(final int i3) {
        ClickReport.m("47", "5", "2");
        Yk(i3);
        String str = (oj() == null || i3 >= oj().size()) ? null : oj().get(i3);
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap != null && hashMap.size() > 0) {
                this.Z.remove(str);
            }
            HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                this.U1.remove(str);
            }
            HashMap<String, Boolean> hashMap3 = this.V1;
            if (hashMap3 != null && hashMap3.containsKey(str)) {
                this.V1.remove(str);
            }
            HashMap<String, ArrayList<FaceData>> hashMap4 = this.X1;
            if (hashMap4 != null && hashMap4.containsKey(str)) {
                this.X1.remove(str);
            }
            HashMap<String, Boolean> hashMap5 = this.W1;
            if (hashMap5 != null && hashMap5.containsKey(str)) {
                this.W1.remove(str);
            }
        }
        this.P.n1(i3, new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.19
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneUploadPhotoActivity.this.oj() == null || QZoneUploadPhotoActivity.this.oj().size() == 0) {
                    return;
                }
                QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                ai aiVar = qZoneUploadPhotoActivity.N2;
                if (aiVar instanceof com.qzone.publish.ui.state.h) {
                    ((com.qzone.publish.ui.state.h) aiVar).D(i3);
                    QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                    qZoneUploadPhotoActivity2.ri(qZoneUploadPhotoActivity2.N2.g());
                } else if (!(aiVar instanceof ReshipPhotoStateQun) && !(aiVar instanceof ReshipPhotoStateQun4PhotoList) && !(aiVar instanceof com.qzone.album.qun.ui.a) && !(aiVar instanceof com.qzone.album.qun.ui.b) && !(aiVar instanceof com.qzone.publish.ui.state.j)) {
                    qZoneUploadPhotoActivity.ri(aiVar.g());
                } else {
                    ArrayList<NetImageInfo> arrayList = qZoneUploadPhotoActivity.f45143z0;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        int i16 = i3;
                        if (size > i16) {
                            QZoneUploadPhotoActivity.this.f45143z0.remove(i16);
                        }
                    }
                    QZoneUploadPhotoActivity qZoneUploadPhotoActivity3 = QZoneUploadPhotoActivity.this;
                    qZoneUploadPhotoActivity3.ri(qZoneUploadPhotoActivity3.N2.g());
                }
                QZoneUploadPhotoActivity.this.ui();
                QZoneUploadPhotoActivity.this.sq();
                QZoneUploadPhotoActivity.this.fq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Dp(final Boolean bool) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.publish.ui.activity.p
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadPhotoActivity.this.Cp(bool);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Eo, reason: merged with bridge method [inline-methods] */
    public void Cp(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        this.S4 = booleanValue;
        if (booleanValue) {
            if (!VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).decodeBool("vas_uplod_photo_key", true) && Bo()) {
                this.D0 = v5.a.a().d("photo");
                this.E0 = v5.a.a().d("video");
                if (this.D0 == -2016082619) {
                    this.D0 = 0;
                    u5.b.L0("photo", 0, LoginData.getInstance().getUin());
                }
            } else {
                this.D0 = 2;
            }
            sq();
            this.f51695e3.setVisibility(8);
            this.f51693d3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Ep(e.DialogData dialogData) {
        com.tencent.mobileqq.vas.troop.e.INSTANCE.b(dialogData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo(boolean z16) {
        QLog.d("QZoneUploadPhotoActivity", 1, "[dispatchFinishEvent] come from = " + this.f45136v1);
        if (this.f45136v1 == 1) {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneUploadPhotoPageFinishEvent(z16, this.f45136v1), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fp(boolean z16, int i3, String str) {
        VasLogReporter.getQzoneVip().reportLow("pay end");
        VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_request_real_vip", false);
        if (z16) {
            Vp();
        }
    }

    private void Go() {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        TextView u16 = (aVar == null || aVar.u() == null) ? null : this.C.u();
        if (u16 == null) {
            QZLog.e(getTAG(), 1, "[dtReportRightUploadView] right upload view is null");
            return;
        }
        fo.b h16 = new fo.b().l(new HashMap()).h(new ah(this, "upload_view"));
        fo.c.l(u16, getFragmentContentView());
        fo.c.o(u16, "em_qz_confirm_upload", h16);
    }

    private void Ho() {
        if (this.T2 == null) {
            QZLog.e(getTAG(), 1, "[openYellowTipsContainer] view is null");
            return;
        }
        fo.b h16 = new fo.b().l(new HashMap()).g(ClickPolicy.REPORT_NONE).h(new ah(this, "yellow_tips"));
        fo.c.l(this.T2, getFragmentContentView());
        fo.c.o(this.T2, "em_qz_notice_strip", h16);
    }

    private void Hp() {
        this.N2.p();
    }

    private void Ip() {
        this.N2.q();
    }

    private void Jo(int i3) {
        if (tp().first.booleanValue()) {
            if (i3 == 0) {
                tq(this.f51703r3, this.f51705s3);
                return;
            }
            if (i3 == 2) {
                tq(this.f51702q3, this.f51712x3);
            } else if (i3 != 3) {
                this.C4.setVisibility(8);
            } else {
                tq(this.f51700p3, this.f51707t3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hmh, (ViewGroup) null);
        viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(viewGroup.getWidth(), viewGroup.getHeight()));
        AsyncImageView asyncImageView = (AsyncImageView) frameLayout.findViewById(R.id.f1197677q);
        AsyncImageView asyncImageView2 = (AsyncImageView) frameLayout.findViewById(R.id.f1197777r);
        AsyncImageView asyncImageView3 = (AsyncImageView) frameLayout.findViewById(R.id.f1197577p);
        asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/zftc.png");
        asyncImageView2.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/yellowDiamondButton.png");
        asyncImageView3.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/hz-xctq/cancelButton.png");
        LpReportInfo_dc04586.report(new LpReportInfo_dc04586(LpReportInfo_dc04586.ITEM_ID_BTN_OPEN, 101, this.O4.getVipType()));
        LpReportInfo_dc04586.report(new LpReportInfo_dc04586(LpReportInfo_dc04586.ITEM_ID_BTN_PAY, 101, this.O4.getVipType()));
        asyncImageView3.setOnClickListener(new l(viewGroup, frameLayout));
        asyncImageView2.setOnClickListener(new m(viewGroup, frameLayout));
        asyncImageView.setOnClickListener(new n(viewGroup, frameLayout));
        frameLayout.setOnTouchListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        String f16 = com.qzone.util.ag.f(this.k3.mVideoPath);
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        this.k3.mCoverUrl = f16;
    }

    private void Kp(String str) {
        VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("qzone_request_real_vip", true);
        ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).openPayWithSchema(com.tencent.mobileqq.vas.troop.f.f311020a.a(str), new IVasYellowDiamondPay.a() { // from class: com.qzone.publish.ui.activity.q
            @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
            public final void onResult(boolean z16, int i3, String str2) {
                QZoneUploadPhotoActivity.this.Fp(z16, i3, str2);
            }
        });
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x007a. Please report as an issue. */
    private String Lo() {
        String str;
        String str2;
        Intent intent = getIntent();
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra(QzoneVideoBeaconReport.BEACON_SOURCE);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM, 1);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_ALBUM, 2);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM_PHOTO, 3);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_ALBUM, 4);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM_PHOTO, 5);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_ALBUM, 6);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM_PHOTO, 7);
        if (TextUtils.isEmpty(str) || hashMap.get(str) == null) {
            return "";
        }
        switch (((Integer) hashMap.get(str)).intValue()) {
            case 1:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM_SELECT;
                return str2;
            case 2:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_SELECT;
                return str2;
            case 3:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM_SELECT;
                return str2;
            case 4:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_SELECT;
                return str2;
            case 5:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM_SELECT;
                return str2;
            case 6:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_SELECT;
                return str2;
            case 7:
                str2 = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM_SELECT;
                return str2;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp(String str) {
        ak.Q(getActivity(), ak.r(getActivity(), str, getResources().getString(R.string.gln), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 999);
    }

    private Map<String, String> Np(Intent intent) {
        if (!intent.hasExtra("third_party_extend_map")) {
            return null;
        }
        Serializable serializableExtra = intent.getSerializableExtra("third_party_extend_map");
        if (com.qzone.util.r.a(serializableExtra)) {
            return (Map) serializableExtra;
        }
        return null;
    }

    private void Op(final AbsCompatRequest.a aVar) {
        ai aiVar = this.N2;
        if ((aiVar instanceof UploadPhotoStateNormal) || (aiVar instanceof com.qzone.album.qun.ui.b) || (aiVar instanceof com.qzone.album.qun.ui.a) || (aiVar instanceof com.qzone.publish.ui.state.j)) {
            this.D2 = false;
            this.E2 = false;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.28
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (QZoneUploadPhotoActivity.this.C2 != null) {
                        QZLog.i("QZoneUploadPhotoActivity", "postQueryAlbum -> cnt = " + QZoneUploadPhotoActivity.this.C2.incrementAndGet());
                    }
                    com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
                    BusinessAlbumInfo businessAlbumInfo = QZoneUploadPhotoActivity.this.L2;
                    String id5 = businessAlbumInfo != null ? businessAlbumInfo.getId() : null;
                    QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                    BusinessAlbumInfo businessAlbumInfo2 = qZoneUploadPhotoActivity.L2;
                    if (businessAlbumInfo2 != null) {
                        str = businessAlbumInfo2.getTitle();
                    } else {
                        ai aiVar2 = qZoneUploadPhotoActivity.N2;
                        if (aiVar2 != null) {
                            str = aiVar2.b();
                        } else {
                            str = "";
                        }
                    }
                    W.e1(id5, str, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Qo() {
        if (getIntent() == null || getIntent().getExtras() == null) {
            return null;
        }
        return getIntent().getExtras().getString("adId");
    }

    private ArrayList<String> Ro(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (!this.X.containsKey(arrayList.get(i3))) {
                arrayList2.add(arrayList.get(i3));
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rp() {
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        ClickReport.e(311, lVar.x(this.Q1, getIntent()), 309, 4, 303);
        ClickReport.m("604", "1", "");
        try {
            Intent intent = getIntent();
            if (intent != null) {
                String x16 = lVar.x(this.Q1, intent);
                pq(oj());
                if (x16 != null) {
                    x16.equals("photoBanner");
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void Sp(final String str, final String str2, final String str3, final int i3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.36
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str3;
                if (str4 == null || TextUtils.isEmpty(str4)) {
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(str2, str3);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, i3, 0L, hashMap, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x009d. Please report as an issue. */
    public String To() {
        String str;
        String str2 = this.F4;
        HashMap hashMap = new HashMap();
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM_SELECT, 1);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_SELECT, 2);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM_SELECT, 3);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_GUIDE, 4);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_SELECT, 5);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM_SELECT, 6);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_LIST_GUIDE, 7);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_SELECT, 8);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM_SELECT, 9);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_GUIDE, 10);
        hashMap.put(QzoneVideoBeaconReport.EVENT_ALBUM_GUIDE, 11);
        if (TextUtils.isEmpty(str2) || hashMap.get(str2) == null) {
            return "";
        }
        switch (((Integer) hashMap.get(str2)).intValue()) {
            case 1:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM_UPLOAD;
                return str;
            case 2:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_UPLOAD;
                return str;
            case 3:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ALBUM_UPLOAD;
                return str;
            case 4:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_GUIDE_UPLOAD;
                return str;
            case 5:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_UPLOAD;
                return str;
            case 6:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ALBUM_UPLOAD;
                return str;
            case 7:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_GUIDE_UPLOAD;
                return str;
            case 8:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_UPLOAD;
                return str;
            case 9:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ALBUM_UPLOAD;
                return str;
            case 10:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_GUIDE_UPLOAD;
                return str;
            case 11:
                str = QzoneVideoBeaconReport.EVENT_ALBUM_GUIDE_UPLOAD;
                return str;
            default:
                return "";
        }
    }

    private void Tp() {
        switch (this.G4) {
            case 2017032201:
                StatisticCollector.getInstance(getActivity()).collectPerformance(LoginData.getInstance().getUinString(), "qzonePhotoGroupListClickUpload", true, 0L, 0L, (HashMap<String, String>) null, (String) null, true);
                return;
            case 2017032202:
                StatisticCollector.getInstance(getActivity()).collectPerformance(LoginData.getInstance().getUinString(), "qzonePhotoGroupDetailClickUpload", true, 0L, 0L, (HashMap<String, String>) null, (String) null, true);
                return;
            default:
                return;
        }
    }

    private int Vo() {
        int i3 = this.D0;
        if (i3 != 2) {
            return i3 != 3 ? 3 : 1;
        }
        return 2;
    }

    private void Vp() {
        na.e.f419543a.e(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QZonePublishSyncQCirclePart Wo() {
        if (this.B2 == null) {
            QZonePublishSyncQCirclePart qZonePublishSyncQCirclePart = new QZonePublishSyncQCirclePart();
            this.B2 = qZonePublishSyncQCirclePart;
            qZonePublishSyncQCirclePart.Cb(602, 17);
            Bundle bundle = new Bundle();
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_ALBUM);
            bundle.putBoolean(QQWinkConstants.EDITOR_TEMPLATE_RECOMMEND_MENU, true);
            bundle.putBoolean(QQWinkConstants.EDITOR_RECOMMEND_TEMPLATE_SHOW, true);
            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qzone-syncalbum-0001");
            this.B2.Eb(bundle);
        }
        return this.B2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        Intent intent = getIntent();
        if (intent != null) {
            this.N2.t(com.qzone.reborn.util.l.f59550a.x(this.Q1, intent));
        }
        this.N2.r();
    }

    private void Zp() {
        MoodPicLabel moodPicLabel = this.Q0;
        if (moodPicLabel == null || moodPicLabel.b() == null || this.Q0.a() == null || getContext() == null || getContext().getResources() == null) {
            return;
        }
        this.Q0.b().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
        this.Q0.a().setColorFilter(getContext().getResources().getColor(R.color.qui_common_text_secondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        Intent intent = new Intent();
        intent.putExtra("aid", "yuantubaoyue");
        intent.putExtra("direct_go", true);
        VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(getActivity(), intent, -1);
    }

    private void aq(boolean z16) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.u() == null) {
            return;
        }
        this.C.u().setEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        if (pp()) {
            com.qzone.common.activities.titlebuilder.a aVar = this.C;
            if (aVar != null && aVar.isRefreshing()) {
                this.C.y();
            }
            nq();
            return;
        }
        if (wp()) {
            com.qzone.common.activities.titlebuilder.a aVar2 = this.C;
            if (aVar2 != null && !aVar2.isRefreshing()) {
                this.C.t();
            }
            this.F2 = true;
            return;
        }
        QZLog.e("QZoneUploadPhotoActivity", "[handleAlbumRightSetting] invalid param and status");
        if (this.L2 == null) {
            ToastUtil.s("\u8bf7\u5148\u9009\u62e9\u76f8\u518c", 4);
        } else {
            hq(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp() {
        AlbumVipOpenArea albumVipOpenArea = this.f51696f3;
        if (albumVipOpenArea != null) {
            albumVipOpenArea.c((ViewGroup) getRoot(), null);
        }
        if (rp()) {
            DialogUtil.createCustomDialog(getRealActivity(), 233, "\u63d0\u793a", "\u65e0\u6cd5\u8bc6\u522b\u60a8\u7684\u539f\u56fe\u4e0a\u4f20\u8d44\u683c\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u6216\u8005\u4f7f\u7528\u9ad8\u6e05\u901a\u9053\u4e0a\u4f20\u54e6\uff5e", "\u597d\u7684", "\u5207\u6362\u753b\u8d28", new q(), new r()).show();
        }
    }

    private void dq(ArrayList<String> arrayList, String str) {
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY, this.P4);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_ALBUM_ID, str);
        if (up()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO, this.L2);
            intent.putExtras(bundle);
        }
        getActivity().setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep() {
        LpReportInfo_dc04586.report(new LpReportInfo_dc04586(LpReportInfo_dc04586.ITEM_ID_BTN_PAY, 102, this.O4.getVipType()));
        h.a.a(new p());
    }

    private void eq(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        shuoshuoVideoInfo.mShootTime = MediaWrapper.getVideoShootTime(getActivity(), shuoshuoVideoInfo.mVideoPath);
        shuoshuoVideoInfo.mTakenTime = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format((Date) new java.sql.Date(shuoshuoVideoInfo.mShootTime));
    }

    private void fp(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null) {
            if (unpack.getSucceed()) {
                toast(getString(R.string.f173040gn1), 5);
                finish();
                return;
            }
            ArrayList arrayList = (ArrayList) unpack.getData();
            if (arrayList != null && arrayList.size() > 0) {
                toast(arrayList.size() + this.L4, 4);
                finish();
                return;
            }
            this.Y2 = true;
            if (!TextUtils.isEmpty(unpack.getMessage())) {
                toast(unpack.getMessage(), 4);
                return;
            } else {
                toast(this.M4, 4);
                return;
            }
        }
        this.Y2 = true;
        toast(this.M4, 4);
    }

    private void hp() {
        ImageView imageView = this.f51711x2;
        int i3 = fd.a.f398306e;
        s5.a.a(imageView, i3);
        s5.a.a(this.f51713y2, i3);
        s5.a.a(this.f51715z2, i3);
    }

    private void initData() {
        ExtendEditText extendEditText;
        np();
        this.I = true;
        this.G2 = false;
        this.I2 = getIntent().getBooleanExtra("isCloudPhotoCopy", false);
        this.J2 = getIntent().getStringExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_BEGIN_SEND_SHOW_TOAST);
        if (oj() == null) {
            dm(new ArrayList<>());
        }
        String stringExtra = getIntent().getStringExtra("summary");
        if (!TextUtils.isEmpty(stringExtra) && (extendEditText = this.f45104j0) != null) {
            extendEditText.setText(stringExtra);
        }
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("images");
        if (stringArrayListExtra != null) {
            RFWLog.d("QZoneUploadPhotoActivity", RFWLog.USR, "initData QZONE_SHARE_IMAGES: " + stringArrayListExtra);
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!oj().contains(next)) {
                    fi(next);
                }
            }
        }
        this.f45117n1 = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_HULIAN_APPID);
        Dm();
        Hp();
        gq();
        Xp(true);
        ui();
        vo();
        if (this.H2) {
            this.H2 = false;
            this.C2 = new AtomicInteger(0);
            Op(this.Y4);
            a8.b.O().P(getHandler());
        }
        this.C0.h(oj(), this.D0);
        yo();
        if (this.F0 == 6) {
            qi();
        }
        this.G4 = getIntent().getIntExtra("photoGroupBeaconSource", -1);
        this.H4 = getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
        super.Gk();
        this.W4 = new mc.a("qzone_album_old_upload_album", com.qzone.reborn.util.l.f59550a.u(this.Q1, getIntent()));
    }

    private void ip() {
        int i3 = this.f45111l1;
        if (i3 == 12) {
            jp();
        } else if (i3 == 11) {
            this.L1 = QZoneMediaBusiness.QZONE_PANEL_ALBUM;
        } else if (i3 == 13) {
            this.L1 = QZoneMediaBusiness.QZONE_ALBUM_DETAIL;
        }
    }

    private void iq() {
        ActionSheet actionSheet = this.f45089e0;
        if (actionSheet == null || !actionSheet.isShowing()) {
            if (!Wj()) {
                vi();
                Rp();
                finish();
                Fo(false);
                return;
            }
            ActionSheet create = ActionSheet.create(getActivity());
            create.addButton(R.string.gd6, 3);
            create.addButton(R.string.cancel, 5);
            create.setOnButtonClickListener(new u(create));
            try {
                create.show();
                this.f45089e0 = create;
            } catch (Exception e16) {
                QZLog.e("QZoneUploadPhotoActivity", "showCancelUploadPhotoConfirmDialog  " + e16);
            }
        }
    }

    private void jp() {
        int i3 = this.F0;
        if (i3 == 1) {
            this.L1 = QZoneMediaBusiness.QZONE_ALBUM_LIST;
        } else if (i3 == 10) {
            this.L1 = QZoneMediaBusiness.QZONE_ALBUM_LIST_ONLY_VIDEO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(int i3) {
        String config;
        com.qzone.component.e eVar = new com.qzone.component.e();
        e9.a aVar = this.T;
        if (aVar != null && aVar.h0(i3)) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpVideo", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f");
        } else {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpPhoto", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u5f20\u7167\u7247\u5417\uff1f");
        }
        eVar.g(getActivity(), config, null, new h(i3), new i());
    }

    private void kp() {
        cm(ParcelableWrapper.getArrayListFromIntent(getIntent(), "QZoneUploadPhotoActivity.key_reship_photos"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq() {
        QZoneHelper.showQzoneVipOriginalVideoDialog(getActivity(), new w());
    }

    private void lp() {
        ArrayList<String> C;
        if (getIntent() == null) {
            return;
        }
        if (getIntent().getBooleanExtra("PhotoActivity.is_image_may_too_much", false)) {
            C = PhotoActivity.f45075r2;
        } else {
            C = com.qzone.reborn.util.l.f59550a.C(this.Q1, getIntent());
        }
        if (C != null) {
            this.N0 = C.size();
            dm(C);
            ((LBSModule) hj(LBSModule.class)).J();
            am();
        }
    }

    private void lq(String str) {
        ActionSheet actionSheet = this.f51689a5;
        if (actionSheet == null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogUpload", "\u7acb\u5373\u4e0a\u4f20");
            ActionSheet create = ActionSheet.create(getActivity());
            this.f51689a5 = create;
            create.setMainTitle(str);
            this.f51689a5.addButton(config, 0);
            this.f51689a5.addCancelButton(com.qzone.util.l.a(R.string.j6l));
            this.f51689a5.setOnButtonClickListener(new x());
            this.f51689a5.setOnDismissListener(new y());
            this.f51689a5.show();
            return;
        }
        if (actionSheet.isShowing()) {
            return;
        }
        this.f51689a5.show();
    }

    private void np() {
        na.e eVar = na.e.f419543a;
        eVar.c(LoginData.getInstance().getUin(), new Function1() { // from class: com.qzone.publish.ui.activity.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Dp;
                Dp = QZoneUploadPhotoActivity.this.Dp((Boolean) obj);
                return Dp;
            }
        });
        if (Bo()) {
            eVar.b(4, new Function1() { // from class: com.qzone.publish.ui.activity.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Ep;
                    Ep = QZoneUploadPhotoActivity.Ep((e.DialogData) obj);
                    return Ep;
                }
            });
        }
    }

    private void nq() {
        if (!this.M2.f()) {
            QZLog.e("QZoneUploadPhotoActivity", "[startUGCSettingH5] empty albumcachedata");
            return;
        }
        String j3 = yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}"), "{type}", "editphoto");
        if (this.M2.d().isSharingAlbumOnUI()) {
            j3 = j3 + "&tip=shareAlbum";
        }
        yo.d.k(getActivity(), j3 + "&source=UploadPhoto", 5, AlbumCacheData.createUgcSettingParam(this.M2.d(), this.M2.e()), null, null);
    }

    private void op() {
        this.l3 = Long.valueOf(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP, QzoneConfig.DefaultValue.DEFUALT_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP)).longValue();
        this.m3 = Long.valueOf(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT, String.valueOf(1048576000L))).longValue();
        this.f51688a3 = findViewById(R.id.kt9);
        this.f51692c3 = (TextView) findViewById(R.id.kqr);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.kt_);
        this.f51690b3 = asyncImageView;
        asyncImageView.setOnClickListener(new f());
        this.f51697g3 = (RelativeLayout) findViewById(R.id.ktc);
        this.f51698h3 = (TextView) findViewById(R.id.kte);
        Switch r06 = (Switch) findViewById(R.id.ktd);
        this.i3 = r06;
        r06.setOnCheckedChangeListener(new g());
    }

    private ai oq(int i3) {
        this.K1 = i3;
        switch (i3) {
            case 1:
                return new UploadPhotoStateQun(this);
            case 2:
                return new UploadPhotoStateQun4PhotoList(this);
            case 3:
                return new ReshipPhotoStateQun(this);
            case 4:
                return new ReshipPhotoStateQun4PhotoList(this);
            case 5:
                return new ReshipPhotoStateQunAIO(this);
            case 6:
                return new com.qzone.album.qun.ui.a(this);
            case 7:
            case 8:
                return new com.qzone.album.qun.ui.b(this);
            case 9:
            case 10:
            default:
                this.K1 = 0;
                return new UploadPhotoStateNormal(this);
            case 11:
                if (com.qzone.reborn.configx.g.f53821a.b().t()) {
                    return new com.qzone.publish.ui.state.i(this);
                }
                return new com.qzone.publish.ui.state.h(this);
            case 12:
                return new com.qzone.publish.ui.state.j(this);
        }
    }

    private boolean pp() {
        BusinessAlbumInfo businessAlbumInfo;
        if (this.C2 == null) {
            QZLog.e("QZoneUploadPhotoActivity", "[isAlbumRightSettingAvailable] empty curRunningAlbumQueryCnt!");
            return false;
        }
        if (this.M2.f() && (businessAlbumInfo = this.L2) != null) {
            if (!TextUtils.isEmpty(businessAlbumInfo.mAlbumId) && this.L2.mAlbumId.equals(this.M2.d().albumid)) {
                if (this.D2 && !wp()) {
                    return true;
                }
                QZLog.i("QZoneUploadPhotoActivity", "[isAlbumRightSettingAvailable] query album is not finished");
                return false;
            }
            QZLog.i("QZoneUploadPhotoActivity", "[isAlbumRightSettingAvailable] albumid empty or conflicts");
            return false;
        }
        QZLog.i("QZoneUploadPhotoActivity", "[isAlbumRightSettingAvailable] core param is null");
        return false;
    }

    private ArrayList<ImageInfo> pq(ArrayList<String> arrayList) {
        LocalMediaInfo localMediaInfo;
        Integer num;
        ArrayList<ImageInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ImageInfo imageInfo = new ImageInfo(next);
                imageInfo.mDescription = Vi();
                this.f45121o2 = false;
                ConcurrentHashMap<String, float[]> concurrentHashMap = this.f45140x1;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(next)) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    HashMap<String, String> hashMap2 = imageInfo.mPhotoTagInfo;
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        imageInfo.mPhotoTagInfo.putAll(hashMap);
                    } else {
                        imageInfo.mPhotoTagInfo = hashMap;
                    }
                }
                HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = this.U1;
                if (hashMap3 != null && hashMap3.containsKey(next)) {
                    MarkUinInfoBeforeUpload markUinInfoBeforeUpload = new MarkUinInfoBeforeUpload();
                    markUinInfoBeforeUpload.marks = this.U1.get(next).marks;
                    imageInfo.setExternalData(kExtKeyMarkUinBeforeUpload.value, markUinInfoBeforeUpload.toByteArray());
                } else {
                    imageInfo.setExternalData(kExtKeyMarkUinBeforeUpload.value, new MarkUinInfoBeforeUpload().toByteArray());
                }
                HashMap<String, Integer> hashMap4 = this.f45080b0;
                if (hashMap4 != null && hashMap4.size() > 0 && (num = this.f45080b0.get(next)) != null) {
                    imageInfo.panoramaType = num.intValue();
                }
                HashMap<String, LocalMediaInfo> hashMap5 = this.W;
                if (hashMap5 != null && hashMap5.containsKey(next) && (localMediaInfo = this.W.get(next)) != null && imageInfo.mGpsInfo == null) {
                    imageInfo.mGpsInfo = new GpsInfo4LocalImage(localMediaInfo.latitude, localMediaInfo.longitude);
                }
                arrayList2.add(imageInfo);
            }
        }
        return arrayList2;
    }

    private void qq(String str) {
        if (this.A2 == null) {
            QLog.d("QZoneUploadPhotoActivity", 1, "album cover is null");
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(this.A2).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(this.U2).setRequestHeight(this.V2).setLoadingDrawableColor(getContext().getResources().getColor(R.color.f156918f7)).setFailedDrawableId(R.drawable.fux), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rp() {
        return ((IFeatureRuntimeService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qzone_album_privilege_new", false);
    }

    private boolean sp() {
        return (this.S4 || (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin()) & 8388608) == 0) ? false : true;
    }

    private void tq(String str, String str2) {
        AsyncImageView asyncImageView = this.C4;
        if (asyncImageView != null) {
            asyncImageView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.C4 == null) {
                this.C4 = (AsyncImageView) findViewById(R.id.h1x);
            }
            this.C4.setAsyncImage(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.E4 == null) {
            this.E4 = (TextView) findViewById(R.id.fpv);
        }
        this.E4.setText(str2);
    }

    private void uo() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText == null) {
            return;
        }
        extendEditText.setOnFocusChangeListener(new v());
    }

    private boolean up() {
        int i3 = this.K1;
        return (i3 == 1 || i3 == 6 || i3 == 2 || i3 == 7 || i3 == 8 || i3 == 5 || i3 == 4 || i3 == 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq() {
        DynamicArrayList<String> dynamicArrayList = this.U;
        if (dynamicArrayList == null || this.W == null || dynamicArrayList.size() == 0 || this.W.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.U.iterator();
        while (it.hasNext()) {
            LocalMediaInfo localMediaInfo = this.W.get(it.next());
            st_copy_photo st_copy_photoVar = new st_copy_photo();
            st_copy_photoVar.owneruin = localMediaInfo.mCloudPhotoOwnerUin;
            st_copy_photoVar.albumid = localMediaInfo.mCloudPhotoOwnerAlbumId;
            st_copy_photoVar.photoid = localMediaInfo.mCloudPhotoId;
            arrayList.add(st_copy_photoVar);
        }
        EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, this.U.toArray());
        dq(this.U, this.L2.mAlbumId);
        finish();
    }

    private void wo() {
        MaterialItem materialItem;
        AlbumCacheData d16 = this.M2.d();
        if (d16 == null) {
            QZLog.e("QZoneUploadPhotoActivity", "[changeAlbumPermission] empty album cache data");
            hq(4);
            return;
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null && !aVar.isRefreshing()) {
            this.C.t();
        }
        String str = "";
        if (d16.albumrights == 5) {
            if (TextUtils.isEmpty(d16.albumquestion) || TextUtils.isEmpty(d16.albumanswer)) {
                QZLog.e("QZoneUploadPhotoActivity", "[changeAlbumPermission] set permission to q/a but no content");
                hq(5);
                return;
            }
        } else {
            d16.albumquestion = "";
            d16.albumanswer = "";
        }
        String x16 = getIntent() != null ? com.qzone.reborn.util.l.f59550a.x(this.Q1, getIntent()) : null;
        int i3 = (QZoneAlbumUtil.r(d16.albumtype) != 1 || (materialItem = d16.albumTemplate) == null) ? 0 : materialItem.iItemId;
        Album createAlbumRequestModel = d16.createAlbumRequestModel(1, d16, -1);
        com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
        if (i3 != 0) {
            str = String.valueOf(i3);
        }
        W.F(createAlbumRequestModel, "", x16, str, (byte) 0, new t());
    }

    private boolean wp() {
        AtomicInteger atomicInteger = this.C2;
        if (atomicInteger == null) {
            QZLog.e("QZoneUploadPhotoActivity", "[isQueryAlbumInProgress] empty curRunningAlbumQueryCnt!");
            return false;
        }
        atomicInteger.get();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xp() {
        if (Wo() == null) {
            return false;
        }
        return Wo().Ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yp(long j3) {
        if (com.qzone.util.image.c.M(j3)) {
            lq(com.qzone.util.image.c.H(j3, false));
        } else {
            wq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zp() {
        final long C = com.qzone.util.image.c.C(this.X, oj(), this.D0, this.E0);
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.o
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadPhotoActivity.this.yp(C);
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Cm(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        int i3;
        String stringExtra;
        int i16 = 2;
        if (!this.f45084c1) {
            int i17 = this.K1;
            i16 = ((i17 == 1 || i17 == 2) && !QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_QUN_UPLOAD_VIDEO, true)) ? 6 : 5;
        }
        Bundle bundle = new Bundle();
        if (this.f45087d1) {
            bundle.putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID);
            Intent intent = getIntent();
            if (intent != null && (stringExtra = intent.getStringExtra(QAlbumConstants.ALBUM_NAME)) != null) {
                bundle.putString(QAlbumConstants.ALBUM_NAME, stringExtra);
            }
            i3 = 5;
        } else {
            i3 = i16;
        }
        return bl(getRealActivity(), arrayList, dj(), false, i3, true, concurrentHashMap, bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Di(String str) {
        int i3 = this.K1;
        if (i3 != 3 && i3 != 4 && i3 != 8 && i3 != 7 && i3 != 6 && i3 != 12) {
            return super.Di(str);
        }
        if (!Qp(str)) {
            return false;
        }
        this.T.notifyDataSetChanged();
        this.N.invalidate();
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Dm() {
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.t0(this.U);
            this.T.u0(this.W, this.X, this.f45080b0, this.K1 == 0);
            this.T.notifyDataSetChanged();
            ExtendScrollView extendScrollView = this.M;
            if (extendScrollView != null) {
                extendScrollView.postInvalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Fk(Intent intent) {
        HashMap hashMap;
        super.Fk(intent);
        String Lo = Lo();
        if (!TextUtils.isEmpty(Lo())) {
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), Lo());
            this.F4 = Lo;
        }
        ui();
        yo();
        if (intent != null && this.f45080b0 != null && (hashMap = (HashMap) intent.getSerializableExtra(PeakConstants.PANORAMA_IMAGES)) != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!this.f45080b0.containsKey(entry.getKey())) {
                    this.f45080b0.put((String) entry.getKey(), (Integer) entry.getValue());
                }
            }
        }
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.u0(this.W, this.X, this.f45080b0, this.K1 == 0);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Hm() {
        sq();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Jk() {
        ai aiVar = this.N2;
        if (aiVar == null || !(aiVar instanceof UploadPhotoStateNormal)) {
            return false;
        }
        BusinessAlbumInfo businessAlbumInfo = this.L2;
        return businessAlbumInfo == null || businessAlbumInfo.mAlbumType != 21;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Kj(List<LocalMediaInfo> list, Intent intent) {
        super.Kj(list, intent);
        Map<String, String> Np = Np(intent);
        if (Np != null) {
            QLog.i("QZoneUploadPhotoActivity", 1, "handleMediaParseIntent map: " + Np);
            String a16 = oo.d.f423238a.a(Np);
            for (LocalMediaInfo localMediaInfo : list) {
                if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path) && !TextUtils.isEmpty(a16)) {
                    oo.d.f423238a.b(localMediaInfo.path, a16);
                }
            }
        }
        this.U4.F9(intent);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Kk() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Lk() {
        return false;
    }

    public String Mo() {
        return this.P4;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Nk() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Oj(final String str, final int i3, final int i16, final long j3, final long j16, final long j17, final boolean z16, final Bundle bundle) {
        super.Oj(str, i3, i16, j3, j16, j17, z16, bundle);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.37
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(QZoneUploadPhotoActivity.this.f45096g1)) {
                    ToastUtil.o(R.string.glj, 4);
                } else {
                    if (!new File(QZoneUploadPhotoActivity.this.f45096g1).exists()) {
                        ToastUtil.o(R.string.glj, 4);
                        return;
                    }
                    QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                    qZoneUploadPhotoActivity.k3 = com.qzone.util.ag.q(qZoneUploadPhotoActivity.f45096g1, ((PhotoActivity) qZoneUploadPhotoActivity).f45099h1, QZoneUploadPhotoActivity.this.f45102i1, str, i3, i16, j3, j16, j17, z16, bundle);
                    QZoneUploadPhotoActivity.this.uq();
                }
            }
        });
    }

    protected ArrayList<String> Oo() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<NetImageInfo> arrayList2 = this.f45143z0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<NetImageInfo> it = this.f45143z0.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getBigPath());
            }
        }
        return arrayList;
    }

    protected NetImageInfo Po(String str) {
        ArrayList<NetImageInfo> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = this.f45143z0) == null || arrayList.size() <= 0) {
            return null;
        }
        Iterator<NetImageInfo> it = this.f45143z0.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            if (str.equals(next.getBigPath())) {
                return next;
            }
        }
        return null;
    }

    protected boolean Qp(String str) {
        NetImageInfo Po;
        e9.a aVar;
        if (TextUtils.isEmpty(str) || (Po = Po(str)) == null || !vl(Po.getSmallPath())) {
            return false;
        }
        DynamicArrayList<String> dynamicArrayList = this.U;
        if (dynamicArrayList != null && dynamicArrayList.size() <= 0) {
            int i3 = this.K1;
            if (i3 == 7 || i3 == 6) {
                getActivity().setResult(-1);
                finish();
                return false;
            }
            if (i3 == 8) {
                getActivity().setResult(293);
                finish();
                return false;
            }
        }
        ai aiVar = this.N2;
        if (aiVar != null && (aVar = this.T) != null) {
            aVar.o0(aiVar.g(), false);
        }
        ArrayList<NetImageInfo> arrayList = this.f45143z0;
        if (arrayList != null && arrayList.size() > 0) {
            this.f45143z0.remove(Po);
        }
        sq();
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ri(Intent intent) {
        intent.putExtra(WinkPreviewFragment.ENTRY_FROM, 2);
        if (this.V4) {
            intent.putExtra(PictureConst.KEY_EDIT_BTN_TYPE, 1);
        }
    }

    public String So() {
        HashMap<String, LocalMediaInfo> hashMap = this.W;
        if (hashMap == null) {
            return null;
        }
        ArrayList<String> oj5 = oj();
        for (int i3 = 0; i3 < oj5.size(); i3++) {
            LocalMediaInfo localMediaInfo = hashMap.get(oj5.get(i3));
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_QUALITY_TEXT_DIFF, getString(R.string.f2199567t));
            }
        }
        return null;
    }

    public Map<String, Object> Uo() {
        HashMap hashMap = new HashMap();
        Pair<Integer, Integer> No = No();
        hashMap.put("pic_cnt", No.first);
        hashMap.put("video_number", No.second);
        hashMap.put("is_without_text", Integer.valueOf(Ui() > 0 ? 1 : 0));
        hashMap.put("finnal_pic_quality", Integer.valueOf(Vo()));
        hashMap.put("publisher_gameplay", this.U4.E9());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_GAMEPLAY, this.U4.C9());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SHARE_ORIGINAL_PICTURE, this.U4.D9());
        this.U4.H9(this.U);
        return hashMap;
    }

    public String Xo() {
        return this.O2;
    }

    void Xp(boolean z16) {
        if (this.A2 != null) {
            if (this.U2 == 0) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b1r);
                this.U2 = dimensionPixelSize;
                this.V2 = dimensionPixelSize;
            }
            this.A2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A2.setAdjustViewBounds(false);
            BusinessAlbumInfo businessAlbumInfo = this.L2;
            if (businessAlbumInfo == null) {
                qq(this.W2);
                return;
            }
            if (z16) {
                qq(this.W2);
                return;
            }
            String str = businessAlbumInfo.mCover;
            if (!TextUtils.isEmpty(str)) {
                if (o6.a.e().b(str).equals(o6.a.e().b(this.W2))) {
                    return;
                }
                qq(str);
                this.W2 = str;
                return;
            }
            qq("");
        }
    }

    public Map<String, Object> Yo() {
        int i3;
        HashMap hashMap = new HashMap();
        Pair<Boolean, Boolean> tp5 = tp();
        if (tp5.first.booleanValue() && tp5.second.booleanValue()) {
            i3 = 0;
        } else {
            i3 = tp5.second.booleanValue() ? 2 : 1;
        }
        hashMap.put("strip_type", Integer.valueOf(i3));
        return hashMap;
    }

    protected void Yp() {
        View view = this.f45119o0;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new z());
    }

    protected void Zo() {
        Pair<Boolean, Boolean> tp5 = tp();
        boolean booleanValue = tp5.first.booleanValue();
        boolean booleanValue2 = tp5.second.booleanValue();
        if (!booleanValue && !booleanValue2) {
            toast(this.K4);
            return;
        }
        LpReportInfo_pf00064.allReport(602, 13, 1);
        Intent l3 = ak.l(getActivity(), "com.qzone.publish.ui.activity.QZoneUploadQualityActivity");
        l3.putStringArrayListExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_SELECTED_ARRAY", Ro(oj()));
        if (booleanValue) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", this.D0);
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", -2016082619);
        }
        if (booleanValue2) {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", this.E0);
        } else {
            l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", -2016082619);
        }
        if (!TextUtils.isEmpty(this.f51714y3)) {
            l3.putExtra("out_logo_pic_normal", this.f51714y3);
        }
        if (!TextUtils.isEmpty(this.f51691b4)) {
            l3.putExtra("out_logo_pic", this.f51691b4);
        }
        if (!TextUtils.isEmpty(this.f51694d4)) {
            l3.putExtra("out_logo_pic_hd", this.f51694d4);
        }
        if (!TextUtils.isEmpty(this.f51705s3)) {
            l3.putExtra("text_normal", this.f51705s3);
        }
        if (!TextUtils.isEmpty(this.f51707t3)) {
            l3.putExtra("text", this.f51707t3);
        }
        if (!TextUtils.isEmpty(this.f51712x3)) {
            l3.putExtra("text_hd", this.f51712x3);
        }
        if (!TextUtils.isEmpty(this.f51701p4)) {
            l3.putExtra("trace_info", this.f51701p4);
        }
        if (!TextUtils.isEmpty(this.f51704r4)) {
            l3.putExtra("trace_new_info", this.f51704r4);
        }
        l3.putExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_IS_GRAY_USER", this.S4);
        l3.putExtra("INTENT_QUALITY_DIFF_TEXT", So());
        startActivityForResult(l3, 607);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void al() {
        int i3;
        ai aiVar = this.N2;
        if (aiVar == null || !aiVar.i() || (i3 = this.K0) == 3 || i3 == 1) {
            return;
        }
        ((LBSModule) hj(LBSModule.class)).J();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (QZonePublishSyncQCirclePart.Ka()) {
            arrayList.add(Wo());
        }
        arrayList.add(new am.a(this));
        arrayList.add(this.U4);
        return arrayList;
    }

    public void bq(String str) {
        this.O2 = str;
    }

    public void cq(String str) {
        this.P2 = str;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int dj() {
        int i3 = this.K1;
        if (i3 != 3 && i3 != 4) {
            return com.qzone.util.y.b();
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUOTE_MAX_NUM, 20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void dl(Bundle bundle) {
        super.dl(bundle);
        this.N2 = oq(bundle.getInt("mStateType"));
        this.K2 = bundle.getInt("mQuality");
        this.K = bundle.getBoolean("mActionFromFriendFeeds");
        this.L2 = (BusinessAlbumInfo) bundle.getParcelable("mAlbumInfo");
        this.H2 = bundle.getBoolean("isFirstTime");
        this.D2 = bundle.getBoolean("isAlbumValid");
        this.E2 = bundle.getBoolean("queryAlbumReturned");
        int i3 = bundle.getInt("curRunningAlbumQueryCnt", 0);
        if (!this.H2 && this.C2 == null) {
            this.C2 = new AtomicInteger(i3);
        }
        if (bundle.getBoolean("hasTroopId")) {
            this.O2 = bundle.getString("troopId");
        }
        if (bundle.getBoolean("hasTroopName")) {
            this.P2 = bundle.getString("troopName");
        }
        if (bundle.getBoolean("hasCover")) {
            this.W2 = bundle.getString("cover");
        }
        this.Y2 = bundle.getBoolean("canQuoteToQzone");
        gq();
        Xp(true);
        Dm();
        if (this.L2 != null) {
            Op(this.Y4);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int ej() {
        return QZoneConfigHelper.a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void el(Bundle bundle) {
        super.el(bundle);
        bundle.putInt("mStateType", this.K1);
        bundle.putInt("mQuality", this.K2);
        bundle.putBoolean("mActionFromFriendFeeds", this.K);
        bundle.putParcelable("mAlbumInfo", this.L2);
        bundle.putBoolean("isFirstTime", this.H2);
        bundle.putBoolean("isAlbumValid", this.D2);
        bundle.putBoolean("queryAlbumReturned", this.E2);
        AtomicInteger atomicInteger = this.C2;
        if (atomicInteger != null) {
            bundle.putInt("curRunningAlbumQueryCnt", atomicInteger.get());
        }
        if (!TextUtils.isEmpty(this.O2)) {
            bundle.putBoolean("hasTroopId", true);
            bundle.putString("troopId", this.O2);
        } else {
            bundle.putBoolean("hasTroopId", false);
        }
        if (!TextUtils.isEmpty(this.P2)) {
            bundle.putBoolean("hasTroopName", true);
            bundle.putString("troopName", this.P2);
        } else {
            bundle.putBoolean("hasTroopName", false);
        }
        BusinessAlbumInfo businessAlbumInfo = this.L2;
        if (businessAlbumInfo != null && !TextUtils.isEmpty(businessAlbumInfo.mCover)) {
            bundle.putBoolean("hasCover", true);
            bundle.putString("cover", this.L2.mCover);
        } else {
            bundle.putBoolean("hasCover", false);
        }
        bundle.putBoolean("canQuoteToQzone", this.Y2);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected boolean enableDaTongPageRegister() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        super.finish();
        Jl();
    }

    public void fq() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_PHOTO_PAGE_TIP, 1) == 0 || this.S4) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.46
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                RelativeLayout relativeLayout;
                int[] iArr = new int[2];
                ViewGroup viewGroup = QZoneUploadPhotoActivity.this.N;
                if (viewGroup != null) {
                    viewGroup.getLocationOnScreen(iArr);
                    i3 = QZoneUploadPhotoActivity.this.N.getHeight();
                } else {
                    i3 = 0;
                }
                int i16 = iArr[1];
                int screenHeight = ViewUtils.getScreenHeight();
                if (QZoneUploadPhotoActivity.this.rp()) {
                    relativeLayout = QZoneUploadPhotoActivity.this.f51693d3;
                    QZoneUploadPhotoActivity.this.f51695e3.setVisibility(8);
                } else {
                    relativeLayout = QZoneUploadPhotoActivity.this.f51695e3;
                    QZoneUploadPhotoActivity.this.f51693d3.setVisibility(8);
                }
                int height = ((screenHeight - i16) - (relativeLayout != null ? relativeLayout.getHeight() : 0)) - i3;
                if (relativeLayout != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                    if (height < 0) {
                        height = 0;
                    }
                    layoutParams.topMargin = height;
                    relativeLayout.setLayoutParams(layoutParams);
                    if (!am.h(QZoneUploadPhotoActivity.this.H4)) {
                        relativeLayout.setVisibility(4);
                    } else {
                        relativeLayout.setVisibility(0);
                    }
                }
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public int getAppId() {
        return WiFiPhotoErrorCode.ERR_FILEBRIDGE_FILE_INFO_NOT_FOUND;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("come_from", Integer.valueOf(this.f45136v1));
        hashMap.put("qz_adid", com.qzone.reborn.util.l.f59550a.f(this.Q1, getIntent()));
        hashMap.put("user_identity", Integer.valueOf(Bo() ? 1 : 0));
        hashMap.put("default_pic_quality", Integer.valueOf(Vo()));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.SUB_SOURCE_ID, Integer.valueOf(this.f45138w1));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.bsh;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_album_upload";
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public Activity getRealActivity() {
        return getActivity();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public View getRoot() {
        return this.S2;
    }

    void gq() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (this.L2 == null) {
            QZLog.e("QZoneUploadPhotoActivity", 1, "showAlbumInfo... mAlbumInfo == null");
            TextView textView4 = this.f51709v2;
            if (textView4 != null) {
                textView4.setText(this.N2.b());
            }
            if (!this.N2.m() || (textView3 = this.f51710w2) == null) {
                return;
            }
            textView3.setText(R.string.f173001vq1);
            return;
        }
        Wo().Bb(this.L2.mPrivacy != 1);
        Wo().pb();
        if (!TextUtils.isEmpty(this.L2.getTitle()) && (textView2 = this.f51709v2) != null) {
            textView2.setText(this.L2.getTitle());
        }
        if (this.N2.m() && !TextUtils.isEmpty(this.L2.getPrivacyDescription()) && (textView = this.f51710w2) != null) {
            BusinessAlbumInfo businessAlbumInfo = this.L2;
            if (businessAlbumInfo.isShare == 1) {
                textView.setText(this.L2.getPrivacyDescription() + com.qzone.util.l.a(R.string.s__));
            } else {
                textView.setText(businessAlbumInfo.getPrivacyDescription());
            }
        }
        RFWSquareImageView rFWSquareImageView = this.A2;
        if (rFWSquareImageView != null) {
            rFWSquareImageView.setVisibility(this.N2.l() ? 0 : 8);
        }
        View view = this.f45119o0;
        if (view != null) {
            view.setVisibility(this.N2.h() ? 0 : 8);
        }
        View view2 = this.B0;
        if (view2 != null) {
            view2.setVisibility(xp() ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void hl() {
        bm.a aVar;
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null && (aVar = this.T4) != null) {
            aVar.Q1(extendEditText.getText(), com.qzone.common.activities.base.aj.f(this.f45104j0, this.f45141y0, this.H));
        }
        super.hl();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean mm() {
        BusinessAlbumInfo businessAlbumInfo = this.L2;
        if (businessAlbumInfo != null && (businessAlbumInfo.mAlbumType == 9 || businessAlbumInfo.mAnonymity == 6)) {
            this.P0 = true;
            return true;
        }
        return super.mm();
    }

    protected void mq() {
        LbsDataV2.PoiInfo poiInfo;
        this.f51688a3.setVisibility(0);
        this.P.setVisibility(4);
        this.R2.setVisibility(8);
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.k3;
        if (shuoshuoVideoInfo != null && shuoshuoVideoInfo.mVideoType == 1) {
            this.f51697g3.setVisibility(0);
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.k3;
        if (shuoshuoVideoInfo2 != null && shuoshuoVideoInfo2.mVideoType == 0 && (poiInfo = this.M0) != null) {
            if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                Xl(1, this.M0.poiDefaultName);
            } else {
                ((LBSModule) hj(LBSModule.class)).K();
            }
        }
        View findViewById = findViewById(R.id.bmt);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.kt9);
        layoutParams.setMargins(ViewUtils.dpToPx(15.0f), 0, 0, 0);
        findViewById.setLayoutParams(layoutParams);
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null && aVar.u() != null) {
            this.C.u().setEnabled(oi());
        }
        setTitle(R.string.gcw);
        jm(getText(R.string.glp));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean oi() {
        if (this.f45084c1 && !TextUtils.isEmpty(this.f45096g1)) {
            return super.oi();
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean ok() {
        return !up();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String stringExtra;
        super.onActivityCreated(bundle);
        PerfTracer.traceStart(PerfTracer.UPLOADPHOTO_ONCREATE);
        this.S0 = 2;
        if (bundle != null) {
            dl(bundle);
        } else {
            mp(getIntent());
        }
        PerfTracer.traceStart(PerfTracer.UPLOADPHOTO_STATE_INIT);
        this.N2.k();
        Intent intent = getIntent();
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        this.P4 = lVar.H(this.Q1, intent);
        if (intent != null && intent.getBooleanExtra(QZoneHelper.QZoneAlbumConstants.KEY_ALBUM_UPLOAD_IMMEDIATELY, false)) {
            Mp(intent);
            return;
        }
        if (intent != null) {
            this.V4 = intent.getIntExtra(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, -1) == 4;
        }
        ip();
        switch (this.F0) {
            case 1:
                this.F0 = 0;
                this.K = true;
                Kl();
                break;
            case 2:
                this.F0 = 0;
                this.K = true;
                fl();
                break;
            case 4:
                this.F0 = 0;
                this.K = true;
                wm(false);
                break;
            case 5:
            case 6:
            case 7:
                this.K = true;
                lp();
                this.n3 = true;
                break;
            case 8:
                this.F0 = 0;
                this.K = true;
                lp();
                Kl();
                break;
            case 9:
                kp();
                break;
            case 10:
                this.F0 = 0;
                this.K = true;
                Nl();
                break;
        }
        PerfTracer.trace(PerfTracer.UPLOADPHOTO_STATE_INIT, PerfTracer.UPLOADPHOTO_INITUI);
        getWindow().setSoftInputMode(16);
        this.J4 = getIntent().getBooleanExtra("QZoneUploadPhotoActivity.key_finish_with_goto_album", false);
        String A = lVar.A(this.Q1, getIntent());
        this.X2 = A;
        if (!TextUtils.isEmpty(A) || this.V4) {
            this.n3 = false;
        }
        this.I1.h(getIntent());
        this.S2 = (RelativeLayout) findViewById(R.id.ht6);
        initUI();
        PerfTracer.trace(PerfTracer.UPLOADPHOTO_INITUI, PerfTracer.UPLOADPHOTO_INITDATA);
        initData();
        PerfTracer.traceEnd(PerfTracer.UPLOADPHOTO_INITDATA);
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.T3(R.string.gd5, new j());
        }
        PerfTracer.traceEnd(PerfTracer.UPLOADPHOTO_ONCREATE);
        LpReportInfo_pf00064.allReport(602, 12);
        this.f45130s1 = lVar.I(this.Q1, intent);
        if (intent == null) {
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra(QzoneVideoBeaconReport.BEACON_SOURCE);
        }
        this.F4 = stringExtra;
        this.I4.clear();
        this.I1.i();
        LpReportInfo_pf00064.allReport(326, 2, 50);
        this.T4 = (bm.a) getViewModel(bm.a.class);
        Go();
        Ho();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 7 && 65521 == i16) {
            return;
        }
        if (i16 == 0) {
            Uj(i3);
            return;
        }
        if (i16 == 8215 && i3 == 6000) {
            Uj(i3);
            return;
        }
        if (intent != null) {
            if (i3 == 2) {
                BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
                if (businessAlbumInfo != null) {
                    this.L2 = businessAlbumInfo;
                    AlbumCacheData albumCacheData = new AlbumCacheData();
                    albumCacheData.albumid = this.L2.mAlbumId;
                    this.M2.i(albumCacheData);
                    gq();
                    String b16 = o6.a.e().b(this.W2);
                    String b17 = o6.a.e().b(businessAlbumInfo.mCover);
                    if (TextUtils.isEmpty(b17) || TextUtils.isEmpty(b16) || !b16.equals(b17)) {
                        this.W2 = businessAlbumInfo.mCover;
                        Xp(true);
                    }
                    Ip();
                    Op(this.Y4);
                } else {
                    com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
                    String h16 = lVar.h(this.Q1, intent);
                    String i17 = lVar.i(this.Q1, intent);
                    if (!TextUtils.isEmpty(h16)) {
                        BusinessAlbumInfo create = BusinessAlbumInfo.create(h16);
                        this.L2 = create;
                        create.mTitle = i17;
                        AlbumCacheData albumCacheData2 = new AlbumCacheData();
                        albumCacheData2.albumid = this.L2.mAlbumId;
                        this.M2.i(albumCacheData2);
                        gq();
                        Ip();
                        Op(this.Y4);
                    }
                }
            } else if (i3 == 3) {
                BusinessAlbumInfo businessAlbumInfo2 = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
                if (businessAlbumInfo2 != null) {
                    this.L2 = businessAlbumInfo2;
                    AlbumCacheData albumCacheData3 = new AlbumCacheData();
                    albumCacheData3.albumid = this.L2.mAlbumId;
                    this.M2.i(albumCacheData3);
                    gq();
                    String b18 = o6.a.e().b(this.W2);
                    String b19 = o6.a.e().b(businessAlbumInfo2.mCover);
                    if (TextUtils.isEmpty(b19) || TextUtils.isEmpty(b18) || !b18.equals(b19)) {
                        this.W2 = businessAlbumInfo2.mCover;
                        Xp(true);
                    }
                    Ip();
                    Op(this.Y4);
                }
            } else if (i3 == 5) {
                bp(intent);
            } else if (i3 != 607) {
                if ((i3 == 6000 || i3 == 6003) && this.H2) {
                    this.H2 = false;
                    Op(this.Y4);
                }
            } else {
                sq();
                Jo(this.D0);
            }
        }
        yo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.publish.ui.controller.a
    public void onBack() {
        super.onBack();
        getActivity().setResult(0, null);
        ai aiVar = this.N2;
        if (aiVar != null && aiVar.o()) {
            iq();
            return;
        }
        vi();
        Rp();
        finish();
        Fo(false);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.W4.b();
        VSNetworkHelper.getInstance().cancelRequest(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            QZLog.e("QZoneUploadPhotoActivity", "onHandleMessage result is null");
            return;
        }
        int i3 = message.what;
        if (i3 != 2540 && i3 != 2572) {
            switch (i3) {
                case 1000405:
                    if (unpack.getSucceed()) {
                        AlbumVipOpenArea albumVipOpenArea = this.f51696f3;
                        if (albumVipOpenArea != null) {
                            albumVipOpenArea.c((ViewGroup) getRoot(), (Bundle) unpack.getData());
                            return;
                        }
                        return;
                    }
                    dp();
                    return;
                case 1000406:
                    if (unpack.getSucceed()) {
                        Wo().Db(((Bundle) unpack.getData()).getBoolean(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        Io((Bundle) unpack.getData());
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.qzone.misc.network.report.e.a(0, ro.a.a(getIntent()));
        sq();
        Ti(intent);
        if (intent != null) {
            try {
                this.I4.clear();
                this.I4.addAll((ArrayList) intent.getSerializableExtra(PeakConstants.QZONE_ALBUM_ML_EXPOSED_MEDIA_LST));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        PerfTracer.traceStart(PerfTracer.UPLOADPHOTO_ONRESUME);
        super.onResume();
        PerfTracer.traceEnd(PerfTracer.UPLOADPHOTO_ONRESUME);
        PerfTracer.traceClick2Completed(this);
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (((PhotoActivity) QZoneUploadPhotoActivity.this).B0 != null) {
                    ((PhotoActivity) QZoneUploadPhotoActivity.this).B0.setVisibility(QZoneUploadPhotoActivity.this.xp() ? 8 : 0);
                }
            }
        });
        if (!this.D4 && !TextUtils.isEmpty(this.f51703r3) && !TextUtils.isEmpty(this.f51704r4)) {
            this.D4 = true;
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f51704r4, LoginData.getInstance().getUinString());
            QZLog.i("QZoneUploadPhotoActivity", "photo selectUI report expose");
        }
        fq();
        if (rp()) {
            g45.a.D().E(LoginData.getInstance().getUin(), getHandler());
        }
        if (!Bo()) {
            VasLogReporter.getQzoneVip().reportLow("QZoneUploadPhotoActivity not vip");
            if (!VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).decodeBool("qzone_request_real_vip", false) && !this.R4) {
                VasLogReporter.getQzoneVip().reportLow("not request");
            } else {
                Vp();
            }
            this.R4 = false;
        } else {
            VasLogReporter.getQzoneVip().reportLow("QZoneUploadPhotoActivity is vip");
        }
        this.W4.c();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (this.n3) {
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.L(false);
            }
            this.n3 = false;
        }
        if (ImmersiveUtils.statusHeightCorrect) {
            return;
        }
        ImmersiveUtils.correctStatusBarHeight(getWindow());
    }

    public boolean qp() {
        return FontSettingManager.getFontLevel() > 17.0f;
    }

    public void sq() {
        RelativeLayout relativeLayout;
        if (this.C0 == null || this.f45090e1) {
            return;
        }
        Pair<Boolean, Boolean> tp5 = tp();
        boolean booleanValue = tp5.first.booleanValue();
        boolean booleanValue2 = tp5.second.booleanValue();
        TextView textView = (TextView) this.R2.findViewById(R.id.fpr);
        if (textView != null) {
            if (booleanValue2) {
                if (!Bo() || this.E0 == 3) {
                    textView.setText(R.string.f173047gp1);
                } else if (!booleanValue) {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u753b\u4e0a\u4f20\uff09");
                } else {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u56fe\u4e0a\u4f20\uff09");
                }
            } else if (this.S4) {
                if (Bo() && this.D0 != 3) {
                    textView.setText("\u753b\u8d28\uff08\u53ef\u9009\u539f\u56fe\u4e0a\u4f20\uff09");
                } else {
                    textView.setText(R.string.f173047gp1);
                }
            } else {
                textView.setText(R.string.f173047gp1);
            }
        }
        this.C0.g(this.S4);
        ai aiVar = this.N2;
        boolean z16 = (aiVar == null || aiVar.j()) && TextUtils.isEmpty(this.X2);
        this.C0.f(z16);
        if (this.S4 && (relativeLayout = this.T2) != null) {
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.f116446yr);
            if (booleanValue) {
                textView2.setText(com.tencent.mobileqq.vas.troop.f.f311020a.b());
            } else if (booleanValue2) {
                textView2.setText(com.tencent.mobileqq.vas.troop.f.f311020a.d());
            }
            ArrayList<String> oj5 = oj();
            this.T2.setVisibility((Bo() || !z16 || oj5 == null || oj5.size() <= 0) ? 8 : 0);
        }
        if (!booleanValue && booleanValue2) {
            this.C0.i(oj(), this.E0, 1);
            return;
        }
        if (this.D0 == 3 && sp()) {
            this.D0 = 0;
        }
        this.C0.h(oj(), this.D0);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void ui() {
        DynamicArrayList<String> dynamicArrayList = this.U;
        aq(((dynamicArrayList == null || dynamicArrayList.isEmpty()) && this.k3 == null) ? false : true);
    }

    protected void uq() {
        if (!this.f45084c1 || TextUtils.isEmpty(this.f45096g1) || this.f51688a3 == null || this.f51692c3 == null || this.f51690b3 == null || this.k3 == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.38
            @Override // java.lang.Runnable
            public void run() {
                String str = QZoneUploadPhotoActivity.this.k3.mVideoPath;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!new File(str).exists()) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (TextUtils.isEmpty(QZoneUploadPhotoActivity.this.k3.mCoverUrl)) {
                    QZoneUploadPhotoActivity.this.Ko();
                } else if (!new File(QZoneUploadPhotoActivity.this.k3.mCoverUrl).exists()) {
                    QZoneUploadPhotoActivity.this.Ko();
                }
                QZoneUploadPhotoActivity.this.f51690b3.setAsyncImage(QZoneUploadPhotoActivity.this.k3.mCoverUrl);
                String i3 = com.qzone.util.ag.i(QZoneUploadPhotoActivity.this.k3.mDuration);
                QZoneUploadPhotoActivity.this.f51692c3.setText(" " + i3);
                QZoneUploadPhotoActivity.this.mq();
                if (((PhotoActivity) QZoneUploadPhotoActivity.this).B0 != null) {
                    ((PhotoActivity) QZoneUploadPhotoActivity.this).B0.setVisibility(QZoneUploadPhotoActivity.this.xp() ? 8 : 0);
                }
            }
        });
    }

    public void vo() {
        this.N2.a();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void xm(Message message) {
        String string;
        int i3 = message.what;
        if (i3 != 999908) {
            if (i3 == 1000026) {
                rq(message);
                return;
            } else {
                if (i3 != 1000052) {
                    return;
                }
                fp(message);
                return;
            }
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack.getSucceed()) {
            int intValue = ((Integer) unpack.getData()).intValue();
            if (intValue == 1) {
                string = getResources().getString(R.string.akw);
            } else if (intValue == 2) {
                string = getResources().getString(R.string.f170825al1);
            } else if (intValue != 7) {
                string = null;
            } else if (com.qzone.util.l.a(R.string.s_2).equals(getResources().getString(this.N2.d()))) {
                string = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f");
            } else {
                string = getResources().getString(R.string.f170824al0);
            }
            toast(string, 5);
            getActivity().setResult(-1);
            finish();
            return;
        }
        toast(unpack.getMessage(), 4);
    }

    public int xo() {
        BusinessAlbumInfo businessAlbumInfo = this.L2;
        if (businessAlbumInfo != null && businessAlbumInfo.mAlbumType != 1) {
            int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_ALBUM_MAX_PHOTO_COUNT, 10000);
            int D = QZonePublishQueue.w().D(this.L2.mAlbumId);
            if (this.D2 && config != 0 && oj().size() + D + this.L2.mTotal > config) {
                return 1;
            }
            if (!this.D2 && this.E2) {
                return 2;
            }
        }
        return 0;
    }

    public void xq(ArrayList<String> arrayList, BusinessAlbumInfo businessAlbumInfo, int i3, String str, LbsDataV2.PoiInfo poiInfo, String str2) {
        ai aiVar = this.N2;
        if ((aiVar instanceof UploadPhotoStateQun) || (aiVar instanceof UploadPhotoStateQun4PhotoList)) {
            aiVar.v(pq(arrayList), businessAlbumInfo, i3, poiInfo, null, ((LBSModule) hj(LBSModule.class)).z(), str, str2, this.P4);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void ym() {
        ai aiVar;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_NEED_SHOWLBSLIST, 1) > 0 && (aiVar = this.N2) != null) {
            if (aiVar.i()) {
                int i3 = this.K0;
                if (i3 == 3 || i3 == 1) {
                    return;
                } else {
                    ((LBSModule) hj(LBSModule.class)).J();
                }
            }
            this.N2.f();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void zi() {
        String str;
        Intent intent = getIntent();
        if (intent != null) {
            str = com.qzone.reborn.util.l.f59550a.x(this.Q1, intent);
        } else {
            str = "";
        }
        startActivityForResult(ak.o(getActivity(), str), 3);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean zk() {
        return true;
    }

    protected void zo() {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        if (NetworkState.isWifiConn()) {
            wq();
            return;
        }
        if (this.f45084c1 && (shuoshuoVideoInfo = this.k3) != null) {
            if (com.qzone.util.image.c.M(shuoshuoVideoInfo.mSize)) {
                lq(com.qzone.util.image.c.H(this.k3.mSize, this.f45084c1));
                return;
            } else {
                wq();
                return;
            }
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.publish.ui.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadPhotoActivity.this.zp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements DynamicGridView.t {
        a() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (!z16 || QZoneUploadPhotoActivity.this.T.e0()) {
                return;
            }
            QZoneUploadPhotoActivity.this.T.L(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        this.f45128r1 = -1;
        this.f45121o2 = false;
        if (oj().size() < dj()) {
            int i3 = this.K1;
            if (i3 != 3 && i3 != 4) {
                this.K = false;
                this.L1 = QZoneMediaBusiness.QZONE_ALBUM_UPLOAD_PIC;
                tm();
            } else {
                wm(true);
            }
        }
        LpReportInfo_pf00064.allReport(602, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp() {
        this.Q4 = true;
        if (tp().first.booleanValue()) {
            this.D0 = 3;
            u5.b.L0("photo", 3, LoginData.getInstance().getUin());
            VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("vas_uplod_photo_key", false);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.publish.ui.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadPhotoActivity.this.Ap();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void fl() {
        ClickReport.e(4, "uploadphoto", 309, 4, 306);
        super.fl();
    }

    private void Mp(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        ArrayList<String> q16 = lVar.q(this.Q1, intent);
        if (q16 != null && !q16.isEmpty()) {
            String h16 = lVar.h(this.Q1, intent);
            String i3 = lVar.i(this.Q1, intent);
            BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(TextUtils.isEmpty(h16) ? "" : h16);
            if (TextUtils.isEmpty(h16)) {
                i3 = this.N2.b();
            }
            businessAlbumInfo.mTitle = i3;
            int intExtra = intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, 0);
            String m3 = lVar.m(this.Q1, intent);
            String x16 = lVar.x(this.Q1, intent);
            dq(q16, businessAlbumInfo.getId());
            xq(q16, businessAlbumInfo, intExtra, m3, null, x16);
            finish();
            return;
        }
        finish();
    }

    private void bp(Intent intent) {
        int i3;
        if (intent != null && this.M2.f() && this.L2 != null) {
            Bundle extras = intent.getExtras();
            if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                i3 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                this.M2.o(com.qzone.feed.utils.h.b(i3));
                this.L2.mPrivacy = com.qzone.feed.utils.h.b(i3);
            } else {
                i3 = -1;
            }
            if (extras.containsKey("uin_list")) {
                this.M2.c();
                ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                ArrayList<Long> arrayList = new ArrayList<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(Long.parseLong(it.next())));
                    }
                }
                this.M2.p(arrayList);
            }
            if (extras.containsKey(UgcSettingUtil.KEY_QUESTION) && extras.containsKey(UgcSettingUtil.KEY_ANSWER)) {
                this.M2.l(extras.getString(UgcSettingUtil.KEY_QUESTION));
                this.M2.k(extras.getString(UgcSettingUtil.KEY_ANSWER));
            }
            if (com.qzone.feed.utils.h.h(i3)) {
                this.M2.n(extras.getString(UgcSettingUtil.KEY_TAG_INFO));
            }
            this.M2.m(extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON));
            gq();
            wo();
            return;
        }
        QZLog.e("QZoneUploadPhotoActivity", "[handleAlbumRightSelectionResult] AlbumCacheData or Return Intent is Empty");
    }

    private void mp(Intent intent) {
        if (intent != null) {
            int J = com.qzone.reborn.util.l.f59550a.J(this.Q1, intent);
            int intExtra = intent.getIntExtra(PeakConstants.KEY_STATE_TYPE, -1);
            if (intExtra != -1) {
                J = intExtra;
            }
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals(QZoneHelper.Constants.INTENT_ACTION_RESHIP_FROM_QUN_AIO_TO_QUN)) {
                    J = 5;
                } else if (action.equals(QZoneHelper.Constants.INTENT_ACTION_FORWARD_PHOTO_FROM_AIO_TO_QZONE)) {
                    J = 11;
                }
            }
            if (J != -1) {
                this.N2 = oq(J);
                return;
            }
        }
        this.N2 = oq(0);
    }

    private boolean vp(ImageInfo imageInfo) {
        HashMap<String, LocalMediaInfo> hashMap;
        LocalMediaInfo localMediaInfo;
        String str;
        return (imageInfo == null || TextUtils.isEmpty(imageInfo.mPath) || (hashMap = this.W) == null || hashMap.size() <= 0 || !this.W.containsKey(imageInfo.mPath) || (localMediaInfo = this.W.get(imageInfo.mPath)) == null || (str = localMediaInfo.mMimeType) == null || !str.contains("image")) ? false : true;
    }

    private Map<String, String> yq(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(QZonePublishMoodRequest.KEY_UPLOAD_PHOTO_CLIENT_KEY, this.P4);
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x03b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void wq() {
        String str;
        int i3;
        final String str2;
        int i16;
        Intent intent;
        String str3;
        Iterator<ImageInfo> it;
        HashMap<String, String> hashMap;
        Intent intent2;
        String str4;
        HashMap<String, ShuoshuoVideoInfo> hashMap2;
        int i17;
        int i18;
        Intent intent3;
        if ((oj() != null && oj().size() > 0) || this.k3 != null) {
            ek();
            com.qzone.common.activities.titlebuilder.a aVar = this.C;
            if (aVar != null) {
                aVar.y();
            }
            int xo5 = xo();
            if (xo5 != 0) {
                if (!this.G2) {
                    com.qzone.common.activities.titlebuilder.a aVar2 = this.C;
                    if (aVar2 != null) {
                        aVar2.t();
                    }
                    Op(this.Z4);
                } else {
                    hq(xo5);
                }
                this.G2 = false;
                gm(true);
                return;
            }
            final String Vi = Vi();
            ArrayList<ImageInfo> pq5 = pq(oj());
            if (this.L2 == null) {
                BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo("");
                this.L2 = businessAlbumInfo;
                businessAlbumInfo.mTitle = this.N2.b();
            }
            final int i19 = this.D0;
            if (i19 == 3) {
                u5.b.q0("photo_quality_sp_key_" + LoginData.getInstance().getUin(), 1);
                MobileReportManager.getInstance().reportAction("qzone_pri", "6", "10", 144, 1, System.currentTimeMillis());
            }
            final Map<String, String> Ni = Ni(uj(Zi(null)));
            final QZonePreUploadInfo qZonePreUploadInfo = new QZonePreUploadInfo();
            qZonePreUploadInfo.preUploadedPaths = null;
            qZonePreUploadInfo.preUploadingRequest = null;
            qZonePreUploadInfo.preUploadType = 0;
            dq(oj(), this.L2.getId());
            Intent intent4 = getIntent();
            String x16 = intent4 != null ? com.qzone.reborn.util.l.f59550a.x(this.Q1, intent4) : null;
            QZLog.d("upload2 uploadalbum", 1, "start upload imageQuality = " + this.D0 + ", videoQuality = " + this.E0 + ", list = " + oj());
            if (!TextUtils.isEmpty(this.J2)) {
                toast(this.J2);
            }
            ai aiVar = this.N2;
            if (!(aiVar instanceof UploadPhotoStateNormal)) {
                str = "";
                i3 = 4;
                str2 = x16;
                i16 = 2;
                if (!(aiVar instanceof UploadPhotoStateQun) && !(aiVar instanceof UploadPhotoStateQun4PhotoList)) {
                    if (!(aiVar instanceof ReshipPhotoStateQun) && !(aiVar instanceof ReshipPhotoStateQun4PhotoList)) {
                        if (!(aiVar instanceof com.qzone.album.qun.ui.a) && !(aiVar instanceof com.qzone.album.qun.ui.b)) {
                            if (aiVar instanceof com.qzone.publish.ui.state.f) {
                                aiVar.v(null, this.L2, 0, null, null, null, Vi, str2);
                            } else if (aiVar instanceof com.qzone.publish.ui.state.j) {
                                aiVar.v(null, this.L2, 0, null, null, null, this.f45143z0, Vi, str2);
                            }
                        } else {
                            aiVar.v(null, this.L2, 0, null, null, null, this.f45143z0, Vi);
                        }
                    } else {
                        aiVar.v(null, this.L2, 0, null, null, null, this.f45143z0, this.O2, Vi, str2);
                    }
                    intent = intent4;
                } else {
                    if (this.V0 || this.K0 != 1) {
                    }
                    intent = intent4;
                    str3 = str2;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                            ai aiVar2 = qZoneUploadPhotoActivity.N2;
                            String str5 = Vi;
                            ArrayList Pp = qZoneUploadPhotoActivity.Pp(i19, qZoneUploadPhotoActivity.E0);
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                            BusinessAlbumInfo businessAlbumInfo2 = qZoneUploadPhotoActivity2.L2;
                            LbsDataV2.PoiInfo A = ((LBSModule) qZoneUploadPhotoActivity2.hj(LBSModule.class)).A();
                            QZonePreUploadInfo qZonePreUploadInfo2 = qZonePreUploadInfo;
                            Map<String, String> z16 = ((LBSModule) QZoneUploadPhotoActivity.this.hj(LBSModule.class)).z();
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity3 = QZoneUploadPhotoActivity.this;
                            aiVar2.u(str5, Pp, businessAlbumInfo2, A, qZonePreUploadInfo2, z16, str2, Integer.valueOf(((PhotoActivity) QZoneUploadPhotoActivity.this).N0), qZoneUploadPhotoActivity3.f45117n1, null, Ni, ((PhotoActivity) qZoneUploadPhotoActivity3).f45132t1, QZoneUploadPhotoActivity.this.O2);
                        }
                    });
                    this.f45120o1 = true;
                    o7.c.c(System.currentTimeMillis());
                    if (str3 != null && str3.equals(QzoneConfig.SECONDARY_FEED_GUIDE_UPLOAD_ALBUM_BANNER_ENABLE)) {
                        LpReportInfo_pf00064.allReport(i16, 12, i3);
                    }
                    if (str3 == null && str3.equals("photoBanner") && intent != null) {
                        if (intent.getIntExtra(QZoneHelper.Constants.KEY_PHOTO_EVENT_TYPE, -1) == 0) {
                            PhotoGroupOptimizeFuncSwitcher.b(PhotoGroupOptimizeFuncSwitcher.f42531b);
                        }
                    } else if (pq5 != null && pq5.size() > 0) {
                        it = pq5.iterator();
                        int i26 = 0;
                        int i27 = 0;
                        int i28 = 0;
                        int i29 = 0;
                        while (it.hasNext()) {
                            ImageInfo next = it.next();
                            if (vp(next)) {
                                i26++;
                            }
                            if (next != null && (hashMap = next.mPhotoTagInfo) != null && hashMap.get("youtu_tag_array") != null) {
                                i27++;
                            }
                            if (next != null) {
                                int i36 = next.panoramaType;
                                if (i36 == i16) {
                                    i28++;
                                } else if (i36 == 1) {
                                    i29++;
                                }
                            }
                        }
                        Sp("qzone_tag_classify", "upload_count", "upload_all_count", i26);
                        Sp("qzone_tag_classify", "upload_count", "upload_has_marker_count", i27);
                        ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_all_count", i26 + str, 0);
                        ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_sphere", i28 + str, 0);
                        ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_cylinder", i29 + str, 0);
                    }
                    getActivity().sendBroadcast(new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH));
                    return;
                }
            } else {
                if (!this.V0) {
                    int i37 = this.K0;
                }
                final String str5 = x16;
                ((UploadPhotoStateNormal) aiVar).H(Vi, new ArrayList(this.U), this.W, this.X, this.Z, this.L2);
                final Map<String, String> yq5 = yq(Ni);
                ShuoshuoVideoInfo shuoshuoVideoInfo = this.k3;
                if (shuoshuoVideoInfo == null) {
                    intent2 = intent4;
                    str4 = "";
                    HashMap<String, LocalMediaInfo> hashMap3 = this.W;
                    if (((hashMap3 != null && hashMap3.size() > 0) || ((hashMap2 = this.Z) != null && hashMap2.size() > 0)) && tp().second.booleanValue()) {
                        Pair<Boolean, Boolean> Ao = Ao();
                        boolean booleanValue = Ao.first.booleanValue();
                        boolean booleanValue2 = Ao.second.booleanValue();
                        if (booleanValue) {
                            if (this.f51699o3 == null) {
                                b.c d16 = com.qzone.widget.util.b.d(getActivity());
                                this.f51699o3 = d16;
                                d16.setTitle(this.N4);
                                this.f51699o3.setCancelable(false);
                            }
                            if (booleanValue2) {
                                this.f51699o3.show();
                                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.33
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                                        ai aiVar2 = qZoneUploadPhotoActivity.N2;
                                        String str6 = Vi;
                                        ArrayList Pp = qZoneUploadPhotoActivity.Pp(i19, qZoneUploadPhotoActivity.E0);
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                                        BusinessAlbumInfo businessAlbumInfo2 = qZoneUploadPhotoActivity2.L2;
                                        LbsDataV2.PoiInfo A = ((LBSModule) qZoneUploadPhotoActivity2.hj(LBSModule.class)).A();
                                        QZonePreUploadInfo qZonePreUploadInfo2 = qZonePreUploadInfo;
                                        Map<String, String> z16 = ((LBSModule) QZoneUploadPhotoActivity.this.hj(LBSModule.class)).z();
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity3 = QZoneUploadPhotoActivity.this;
                                        aiVar2.u(str6, Pp, businessAlbumInfo2, A, qZonePreUploadInfo2, z16, str5, Integer.valueOf(((PhotoActivity) QZoneUploadPhotoActivity.this).N0), qZoneUploadPhotoActivity3.f45117n1, null, yq5, ((PhotoActivity) qZoneUploadPhotoActivity3).f45132t1);
                                    }
                                });
                            } else {
                                this.f51699o3.show();
                                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.34
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                                        ai aiVar2 = qZoneUploadPhotoActivity.N2;
                                        String str6 = Vi;
                                        ArrayList Pp = qZoneUploadPhotoActivity.Pp(i19, qZoneUploadPhotoActivity.E0);
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                                        BusinessAlbumInfo businessAlbumInfo2 = qZoneUploadPhotoActivity2.L2;
                                        LbsDataV2.PoiInfo A = ((LBSModule) qZoneUploadPhotoActivity2.hj(LBSModule.class)).A();
                                        QZonePreUploadInfo qZonePreUploadInfo2 = qZonePreUploadInfo;
                                        Map<String, String> z16 = ((LBSModule) QZoneUploadPhotoActivity.this.hj(LBSModule.class)).z();
                                        QZoneUploadPhotoActivity qZoneUploadPhotoActivity3 = QZoneUploadPhotoActivity.this;
                                        aiVar2.u(str6, Pp, businessAlbumInfo2, A, qZonePreUploadInfo2, z16, str5, Integer.valueOf(((PhotoActivity) QZoneUploadPhotoActivity.this).N0), qZoneUploadPhotoActivity3.f45117n1, null, yq5, ((PhotoActivity) qZoneUploadPhotoActivity3).f45132t1);
                                    }
                                });
                            }
                            Tp();
                        }
                    } else {
                        ai aiVar2 = this.N2;
                        BusinessAlbumInfo businessAlbumInfo2 = this.L2;
                        LbsDataV2.PoiInfo A = ((LBSModule) hj(LBSModule.class)).A();
                        Map<String, String> z16 = ((LBSModule) hj(LBSModule.class)).z();
                        str2 = str5;
                        i17 = 2;
                        i18 = 4;
                        Object[] objArr = {str2, Integer.valueOf(this.N0), this.f45117n1, null, yq5, this.f45132t1};
                        str = str4;
                        intent3 = intent2;
                        aiVar2.v(pq5, businessAlbumInfo2, i19, A, qZonePreUploadInfo, z16, objArr);
                        Tp();
                        getPartManager().broadcastMessage("event_on_send_mood", this.P4);
                        intent = intent3;
                        i3 = i18;
                        i16 = i17;
                    }
                } else {
                    eq(shuoshuoVideoInfo);
                    this.k3.mDescription = Vi();
                    this.k3.mIsUploadOrigin = this.j3;
                    final ArrayList arrayList = new ArrayList();
                    Iterator<ImageInfo> it5 = pq5.iterator();
                    while (it5.hasNext()) {
                        MediaWrapper mediaWrapper = new MediaWrapper(it5.next());
                        mediaWrapper.setQuality(i19);
                        arrayList.add(mediaWrapper);
                    }
                    arrayList.add(new MediaWrapper(this.k3));
                    intent2 = intent4;
                    str4 = "";
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
                            ai aiVar3 = qZoneUploadPhotoActivity.N2;
                            String str6 = Vi;
                            List<MediaWrapper> list = arrayList;
                            BusinessAlbumInfo businessAlbumInfo3 = qZoneUploadPhotoActivity.L2;
                            LbsDataV2.PoiInfo A2 = ((LBSModule) qZoneUploadPhotoActivity.hj(LBSModule.class)).A();
                            QZonePreUploadInfo qZonePreUploadInfo2 = qZonePreUploadInfo;
                            Map<String, String> z17 = ((LBSModule) QZoneUploadPhotoActivity.this.hj(LBSModule.class)).z();
                            QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = QZoneUploadPhotoActivity.this;
                            aiVar3.u(str6, list, businessAlbumInfo3, A2, qZonePreUploadInfo2, z17, str5, Integer.valueOf(((PhotoActivity) QZoneUploadPhotoActivity.this).N0), qZoneUploadPhotoActivity2.f45117n1, null, yq5, ((PhotoActivity) qZoneUploadPhotoActivity2).f45132t1);
                        }
                    });
                    Up(this.k3);
                    Tp();
                    ClickReport.m("604", "2", str4);
                }
                str = str4;
                intent3 = intent2;
                str2 = str5;
                i18 = 4;
                i17 = 2;
                getPartManager().broadcastMessage("event_on_send_mood", this.P4);
                intent = intent3;
                i3 = i18;
                i16 = i17;
            }
            str3 = str2;
            this.f45120o1 = true;
            o7.c.c(System.currentTimeMillis());
            if (str3 != null) {
                LpReportInfo_pf00064.allReport(i16, 12, i3);
            }
            if (str3 == null) {
            }
            if (pq5 != null) {
                it = pq5.iterator();
                int i262 = 0;
                int i272 = 0;
                int i282 = 0;
                int i292 = 0;
                while (it.hasNext()) {
                }
                Sp("qzone_tag_classify", "upload_count", "upload_all_count", i262);
                Sp("qzone_tag_classify", "upload_count", "upload_has_marker_count", i272);
                ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_all_count", i262 + str, 0);
                ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_sphere", i282 + str, 0);
                ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_cylinder", i292 + str, 0);
            }
            getActivity().sendBroadcast(new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH));
            return;
        }
        toast(R.string.gpb);
        gm(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class af extends a.i {
        af() {
        }

        @Override // e9.a.i
        public boolean a() {
            return QZoneUploadPhotoActivity.this.T.U() < QZoneUploadPhotoActivity.this.dj();
        }

        @Override // e9.a.i
        public boolean b() {
            QZoneUploadPhotoActivity.this.Gp();
            return true;
        }

        @Override // e9.a.i
        public void d() {
            QZoneUploadPhotoActivity qZoneUploadPhotoActivity = QZoneUploadPhotoActivity.this;
            ExtendScrollView extendScrollView = qZoneUploadPhotoActivity.M;
            if (extendScrollView != null) {
                extendScrollView.e(qZoneUploadPhotoActivity.P.getId());
            }
        }

        @Override // e9.a.i
        public void e() {
            QZoneUploadPhotoActivity.this.ui();
            QZoneUploadPhotoActivity.this.sq();
            QZoneUploadPhotoActivity.this.Wo().pb();
        }

        @Override // e9.a.i
        public boolean f(View view) {
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            LpReportInfo_pf00064.allReport(602, 6, 1);
            if (((PhotoActivity) QZoneUploadPhotoActivity.this).f45139x0) {
                QZoneUploadPhotoActivity.this.jq(i3);
                ((PhotoActivity) QZoneUploadPhotoActivity.this).f45139x0 = false;
            } else {
                QZoneUploadPhotoActivity.this.Do(i3);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f51776d;

        h(int i3) {
            this.f51776d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(602, 6, 4);
            QZoneUploadPhotoActivity.this.Do(this.f51776d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(602, 6, 5);
        }
    }

    private Pair<Integer, Integer> No() {
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < oj().size(); i17++) {
            String str = oj().get(i17);
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap == null || hashMap.size() <= 0 || !this.Z.containsKey(str)) {
                HashMap<String, LocalMediaInfo> hashMap2 = this.W;
                if (hashMap2 != null && hashMap2.containsKey(str)) {
                    int mediaType = QAlbumUtil.getMediaType(this.W.get(str));
                    if (mediaType == 0) {
                        i3++;
                    } else if (mediaType != 1) {
                    }
                }
            }
            i16++;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    private void rq(Message message) {
        QZoneResult unpack;
        List<v4.b> list;
        e9.a aVar;
        if (message == null || (unpack = QZoneResult.unpack(message)) == null || !unpack.getSucceed() || (list = (List) unpack.getData()) == null || list.size() <= 0) {
            return;
        }
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        for (v4.b bVar : list) {
            PictureItem pictureItem = bVar.picItem;
            arrayList.add(new NetImageInfo(pictureItem.currentUrl.url, pictureItem.bigUrl.url, bVar.albumid));
        }
        cm(arrayList);
        ai aiVar = this.N2;
        if (aiVar == null || aiVar.g() || (aVar = this.T) == null) {
            return;
        }
        aVar.o0(false, true);
    }

    private Pair<Boolean, Boolean> tp() {
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 = 0; i3 < oj().size(); i3++) {
            String str = oj().get(i3);
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap == null || hashMap.size() <= 0 || !this.Z.containsKey(str)) {
                HashMap<String, LocalMediaInfo> hashMap2 = this.W;
                if (hashMap2 != null && hashMap2.containsKey(str)) {
                    int mediaType = QAlbumUtil.getMediaType(this.W.get(str));
                    if (mediaType == 0) {
                        z16 = true;
                    } else if (mediaType != 1) {
                    }
                }
            }
            z17 = true;
        }
        if (!z16 && !z17 && oj().size() > 0) {
            z16 = true;
        }
        return new Pair<>(Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    public void Up(final ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.45
            @Override // java.lang.Runnable
            public void run() {
                long uin = LoginData.getInstance().getUin();
                ShuoshuoVideoInfo shuoshuoVideoInfo2 = shuoshuoVideoInfo;
                boolean z16 = shuoshuoVideoInfo2.mNeedProcess;
                long j3 = shuoshuoVideoInfo2.mSize;
                int networkType = NetworkState.getNetworkType();
                HashMap hashMap = new HashMap();
                hashMap.put("extra_network_type", networkType + "");
                hashMap.put("extra_file_size", j3 + "");
                hashMap.put("extra_quality", (z16 ? 1 : 0) + "");
                shuoshuoVideoInfo.perfKey = UUID.randomUUID().toString();
                QzoneVideoPerfReport.a(shuoshuoVideoInfo.perfKey, 0).c(uin, "event_extra", hashMap);
                QzoneVideoUploadActionReport.b().d(shuoshuoVideoInfo.mVideoPath, "start_publish", 0);
            }
        });
    }

    private Pair<Boolean, Boolean> Ao() {
        boolean z16 = false;
        int i3 = 0;
        boolean z17 = false;
        for (int i16 = 0; i16 < oj().size(); i16++) {
            String str = oj().get(i16);
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap == null || !hashMap.containsKey(str)) {
                HashMap<String, LocalMediaInfo> hashMap2 = this.W;
                if (hashMap2 != null && hashMap2.containsKey(str)) {
                    LocalMediaInfo localMediaInfo = this.W.get(str);
                    if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                        i3++;
                        if (this.E0 == 3 && localMediaInfo.fileSize > this.f51706t2 && !z17) {
                            z17 = true;
                        }
                    }
                }
            } else {
                i3++;
            }
        }
        int j3 = com.tencent.mobileqq.utils.e.j();
        if (i3 > j3) {
            QQToast.makeText(getActivity(), com.qzone.util.l.a(R.string.s_b) + j3 + com.qzone.util.l.a(R.string.s_5), 0).show();
        } else {
            z16 = true;
        }
        return new Pair<>(Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    private void Io(Bundle bundle) {
        String string = bundle.getString("trace_info");
        String string2 = bundle.getString("trace_new_info");
        String string3 = bundle.getString("text");
        String string4 = bundle.getString("text_hd");
        String string5 = bundle.getString("logo_pic");
        String string6 = bundle.getString("logo_pic_md5");
        String string7 = bundle.getString("logo_pic_hd");
        String string8 = bundle.getString("logo_pic_hd_md5");
        String string9 = bundle.getString("text_normal");
        String string10 = bundle.getString("logo_pic_normal");
        bundle.getString("logo_pic_normal_md5");
        String string11 = bundle.getString("out_logo_pic_normal");
        String string12 = bundle.getString("out_logo_pic_normal_md5");
        String string13 = bundle.getString("out_logo_pic");
        String string14 = bundle.getString("out_logo_pic_md5");
        String string15 = bundle.getString("out_logo_pic_hd");
        String string16 = bundle.getString("out_logo_pic_hd_md5");
        String string17 = bundle.getString("jump_url");
        if (!TextUtils.isEmpty(string)) {
            this.f51701p4 = string;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.f51704r4 = string2;
        }
        if (!TextUtils.isEmpty(string13)) {
            this.f51700p3 = string13;
        }
        if (!TextUtils.isEmpty(string11)) {
            this.f51703r3 = string11;
        }
        if (!TextUtils.isEmpty(string15)) {
            this.f51702q3 = string15;
        }
        if (!TextUtils.isEmpty(string5)) {
            this.f51691b4 = string5;
        }
        if (!TextUtils.isEmpty(string10)) {
            this.f51714y3 = string10;
        }
        if (!TextUtils.isEmpty(string7)) {
            this.f51694d4 = string7;
        }
        if (!TextUtils.isEmpty(string9)) {
            this.f51705s3 = string9;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.f51707t3 = string3;
        }
        if (!TextUtils.isEmpty(string4)) {
            this.f51712x3 = string4;
        }
        tq(this.f51703r3, null);
        QZLog.i("QZoneUploadPhotoActivity", "onGetPhotoPostSelectAdvFinished success trace_info: " + string + " trace_newinfo: " + string2 + " text:" + string3 + " norText:" + string9 + " hdText:" + string4 + " logo_normal:" + string10 + " logo: " + string5 + " logo_md5: " + string6 + " logoHd:" + string7 + " logoHdMd5:" + string8 + " url: " + string17 + " outLogoPicNor:" + string11 + " outLogoPicNorMd5:" + string12 + " outLogoPic:" + string13 + " outLogoPicMd5:" + string14 + " outLogoPicHd:" + string15 + " outLogoPicHdMd5:" + string16);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Bi(LocalMediaInfo localMediaInfo, Intent intent) {
        if (intent == null || !com.qzone.reborn.part.publish.mood.sync.o.a2(intent)) {
            return false;
        }
        Wo().sa(localMediaInfo, intent);
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void jk() {
        LpReportInfo_pf00064.allReport(602, 9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class u implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f51796d;

        u(ActionSheet actionSheet) {
            this.f51796d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                StringBuilder sb5 = new StringBuilder(64);
                sb5.append("[Actvity]");
                sb5.append(QZoneUploadPhotoActivity.this.simpleClassname);
                if (view != null) {
                    sb5.append("   view id:");
                    sb5.append(Integer.toHexString(view.getId()));
                }
                sb5.append(" which:");
                sb5.append(i3);
                RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
                BusinessAlbumInfo businessAlbumInfo = QZoneUploadPhotoActivity.this.L2;
                if (businessAlbumInfo != null && !TextUtils.isEmpty(businessAlbumInfo.mCover)) {
                    u5.b.x0("key_upload_photo_albun_cover", QZoneUploadPhotoActivity.this.L2.mCover, LoginData.getInstance().getUin());
                } else if (!TextUtils.isEmpty(QZoneUploadPhotoActivity.this.W2)) {
                    u5.b.x0("key_upload_photo_albun_cover", QZoneUploadPhotoActivity.this.W2, LoginData.getInstance().getUin());
                }
                QZoneUploadPhotoActivity.this.vi();
                QZoneUploadPhotoActivity.this.Rp();
                LpReportInfo_pf00064.allReport(602, 2, 1);
                QZoneUploadPhotoActivity.this.finish();
                QZoneUploadPhotoActivity.this.Fo(false);
            } else if (i3 == 1) {
                LpReportInfo_pf00064.allReport(602, 2, 2);
            }
            this.f51796d.superDismiss();
        }
    }

    private void initUI() {
        ai aiVar;
        ExtendScrollView extendScrollView = (ExtendScrollView) findViewById(R.id.fph);
        this.M = extendScrollView;
        extendScrollView.b(R.id.fpe);
        this.M.setOnDownListener(this.f45112l2);
        ai aiVar2 = this.N2;
        if (aiVar2 != null) {
            setTitle(aiVar2.d());
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null && (aiVar = this.N2) != null) {
            aVar.P(aiVar.c(), this.X4, false);
        }
        this.N = (ViewGroup) findViewById(R.id.fpg);
        this.P = (DynamicGridView) findViewById(R.id.fpf);
        this.f45104j0 = (ExtendEditText) findViewById(R.id.fpe);
        uo();
        Yh();
        Sl();
        this.f45119o0 = findViewById(R.id.hrp);
        Yp();
        ai aiVar3 = this.N2;
        if (aiVar3 != null && !aiVar3.h()) {
            this.f45119o0.setVisibility(8);
        }
        if (this.K1 == 0) {
            ai();
            Tl();
        }
        Vl(new aa());
        this.f45110l0 = (ImageView) findViewById(R.id.ius);
        Ul();
        if (this.N2 != null) {
            ((TextView) findViewById(R.id.fpc)).setText(this.N2.e());
        }
        this.f51709v2 = (TextView) findViewById(R.id.fp8);
        this.f51710w2 = (TextView) findViewById(R.id.fp9);
        this.A2 = (RFWSquareImageView) findViewById(R.id.f164257p5);
        this.f51708u2 = (RelativeLayout) findViewById(R.id.fpa);
        this.f51711x2 = (ImageView) findViewById(R.id.f68673go);
        this.f51713y2 = (ImageView) findViewById(R.id.f69923k2);
        this.f51715z2 = (ImageView) findViewById(R.id.f68373fv);
        hp();
        if (qp()) {
            this.f51709v2.setMaxEms(5);
        }
        ai aiVar4 = this.N2;
        if (aiVar4 != null && !aiVar4.m()) {
            this.f51708u2.setVisibility(8);
            this.f51708u2.setClickable(false);
        } else {
            this.f51708u2.setVisibility(0);
            this.f51708u2.setOnClickListener(new ab());
        }
        ai aiVar5 = this.N2;
        if (aiVar5 != null && !aiVar5.l()) {
            this.A2.setVisibility(8);
        }
        findViewById(R.id.fp6).setOnClickListener(new ac());
        ai aiVar6 = this.N2;
        if (aiVar6 != null && !aiVar6.s()) {
            findViewById(R.id.fp6).setClickable(false);
            findViewById(R.id.fp5).setVisibility(4);
        }
        ai aiVar7 = this.N2;
        if (aiVar7 != null && aiVar7.n()) {
            findViewById(R.id.f167046k84).setVisibility(0);
        }
        this.R2 = (RelativeLayout) findViewById(R.id.fpj);
        int intExtra = getIntent().getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -2016082619);
        this.D0 = intExtra;
        if (intExtra == -2016082619) {
            this.D0 = v5.a.a().d("photo");
            this.E0 = v5.a.a().d("video");
            if (this.D0 == -2016082619) {
                this.D0 = 0;
                u5.b.L0("photo", 0, LoginData.getInstance().getUin());
            }
        }
        if (!VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).decodeBool("feature_122208286", false) && com.tencent.mobileqq.vas.troop.f.f311020a.e()) {
            if (this.D0 == 3) {
                QLog.i("QZoneUploadPhotoActivity", 1, "reset ImageUploadQuality to HD");
                this.D0 = 2;
                u5.b.L0("photo", 2, LoginData.getInstance().getUin());
            }
            VipNtMMKV.getCommon(LoginData.getInstance().getUinString()).encodeBool("feature_122208286", true);
        }
        if (!LoginData.getInstance().isQzoneVip() && this.E0 == 3) {
            this.E0 = 0;
            u5.b.L0("video", 0, LoginData.getInstance().getUin());
        }
        View findViewById = findViewById(R.id.f164258p8);
        this.B0 = findViewById;
        this.C0 = new com.qzone.album.ui.widget.g(this.R2, findViewById, this.D0);
        this.R2.setOnClickListener(new ad());
        ai aiVar8 = this.N2;
        if (aiVar8 != null && !aiVar8.j()) {
            this.C0.f(false);
        }
        this.P.setNumColumns(3);
        this.P.setTranscriptMode(1);
        this.P.setOnItemClickListener(new ae());
        this.T = new e9.a(getActivity(), this.P, Integer.MAX_VALUE, -1.0f, 1, false, true);
        if (pk()) {
            this.T.q0(true);
        }
        this.T.y0(new af());
        ai aiVar9 = this.N2;
        if (aiVar9 != null && !aiVar9.g()) {
            this.T.o0(false, false);
        }
        this.P.setAdapter((ListAdapter) this.T);
        this.P.setLetParentInterceptTouchEventAt23(false);
        if (TextUtils.isEmpty(this.X2) && !this.V4) {
            this.P.setEditModeEnabled(true);
        } else {
            this.P.setEditModeEnabled(false);
        }
        this.P.setOnEditModeChangeListener(new a());
        this.P.setOnDragListener(new b());
        this.M.b(this.P.getId());
        this.M.a(this.P.getId());
        ak();
        this.Q0 = (MoodPicLabel) findViewById(R.id.e6c);
        ai aiVar10 = this.N2;
        if (aiVar10 != null && aiVar10.i()) {
            Zp();
            this.Q0.setOnClickListener(new c());
        } else {
            this.Q0.setVisibility(8);
        }
        this.R0 = (FrameLayout) $(R.id.hq8);
        if (rp()) {
            AlbumVipOpenArea albumVipOpenArea = new AlbumVipOpenArea(getActivity());
            this.f51696f3 = albumVipOpenArea;
            albumVipOpenArea.a((ViewGroup) getRoot());
        }
        this.O4 = VipComponentProxy.f50997g.getServiceInterface().getVipInfo(LoginData.getInstance().getUinString());
        if (!Bo()) {
            this.T2 = (RelativeLayout) findViewById(R.id.f116466yt);
            if (QQTheme.isNowThemeIsNight()) {
                RelativeLayout relativeLayout = this.T2;
                relativeLayout.setBackground(relativeLayout.getResources().getDrawable(R.drawable.obs));
            } else {
                RelativeLayout relativeLayout2 = this.T2;
                relativeLayout2.setBackground(relativeLayout2.getResources().getDrawable(R.drawable.obr));
            }
            this.T2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.publish.ui.activity.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneUploadPhotoActivity.this.Bp(view);
                }
            });
        }
        this.f51693d3 = (RelativeLayout) findViewById(R.id.f11986780);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.f11987781);
        this.f51695e3 = relativeLayout3;
        relativeLayout3.setOnClickListener(new d());
        this.f51693d3.setOnClickListener(new e());
        op();
        this.C4 = (AsyncImageView) findViewById(R.id.h1x);
        QZoneAdvService.c().g(getHandler(), 3, 2540);
        QZoneAdvService.c().g(getHandler(), 4, 2572);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ej() {
        LpReportInfo_pf00064.allReport(602, 15, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MediaWrapper> Pp(int i3, int i16) {
        int i17;
        boolean z16;
        Integer num;
        ArrayList<MediaWrapper> arrayList = new ArrayList<>();
        boolean z17 = false;
        int i18 = 0;
        while (i18 < oj().size()) {
            String str = oj().get(i18);
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap != null && hashMap.size() > 0 && this.Z.containsKey(str)) {
                ShuoshuoVideoInfo shuoshuoVideoInfo = this.Z.get(str);
                QZLog.d("QZoneUploadPhotoActivity", 4, "recordedVideoInfoMap-processUploadMediaList add:" + str);
                if (shuoshuoVideoInfo != null) {
                    Up(shuoshuoVideoInfo);
                    eq(shuoshuoVideoInfo);
                    shuoshuoVideoInfo.mDescription = Vi();
                    MediaWrapper mediaWrapper = new MediaWrapper(shuoshuoVideoInfo);
                    if (i16 == 3) {
                        if (shuoshuoVideoInfo.mSize <= QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_BIG_VIDEO_BYTE, 1610612736)) {
                            shuoshuoVideoInfo.mIsUploadOrigin = true;
                        } else {
                            shuoshuoVideoInfo.mIsUploadOrigin = z17;
                        }
                    }
                    arrayList.add(mediaWrapper);
                }
            } else {
                if (this.W.containsKey(str)) {
                    LocalMediaInfo localMediaInfo = this.W.get(str);
                    QZLog.d("QZoneUploadPhotoActivity", 4, "processUploadMediaList add:" + str);
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    if (mediaType == 0) {
                        i17 = i18;
                        z16 = z17;
                        ImageInfo imageInfo = new ImageInfo(str);
                        imageInfo.mDescription = Vi();
                        HashMap<String, Integer> hashMap2 = this.f45080b0;
                        if (hashMap2 != null && hashMap2.size() > 0 && (num = this.f45080b0.get(str)) != null) {
                            imageInfo.panoramaType = num.intValue();
                        }
                        MediaWrapper mediaWrapper2 = new MediaWrapper(imageInfo);
                        mediaWrapper2.setQuality(i3);
                        arrayList.add(mediaWrapper2);
                    } else if (mediaType == 1) {
                        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.X.get(localMediaInfo.path);
                        Size b16 = f6.b.b(localMediaInfo);
                        if (shuoshuoVideoInfo2 == null) {
                            FragmentActivity activity = getActivity();
                            long j3 = localMediaInfo._id;
                            String str2 = localMediaInfo.path;
                            i17 = i18;
                            long j16 = localMediaInfo.fileSize;
                            int i19 = b16.height;
                            int i26 = b16.width;
                            long j17 = localMediaInfo.mDuration;
                            shuoshuoVideoInfo2 = com.qzone.util.ag.p(activity, j3, str2, j16, 1, null, i19, i26, 0L, j17, j17, false, null);
                            if (shuoshuoVideoInfo2 != null) {
                                this.X.put(str, shuoshuoVideoInfo2);
                            }
                        } else {
                            i17 = i18;
                            shuoshuoVideoInfo2.mVideoWidth = b16.width;
                            shuoshuoVideoInfo2.mVideoHeight = b16.height;
                        }
                        if (shuoshuoVideoInfo2 != null) {
                            Up(shuoshuoVideoInfo2);
                            eq(shuoshuoVideoInfo2);
                            shuoshuoVideoInfo2.mDescription = Vi();
                            MediaWrapper mediaWrapper3 = new MediaWrapper(shuoshuoVideoInfo2);
                            if (i16 != 3) {
                                z16 = false;
                                mediaWrapper3.setQuality(i16);
                            } else if (shuoshuoVideoInfo2.mSize <= this.f51706t2) {
                                shuoshuoVideoInfo2.mIsUploadOrigin = true;
                                mediaWrapper3.setQuality(i16);
                                z16 = false;
                            } else {
                                z16 = false;
                                shuoshuoVideoInfo2.mIsUploadOrigin = false;
                                mediaWrapper3.setQuality(0);
                            }
                            arrayList.add(mediaWrapper3);
                        } else {
                            z16 = false;
                        }
                    }
                } else {
                    i17 = i18;
                    z16 = z17;
                    if (!TextUtils.isEmpty(str)) {
                        ImageInfo imageInfo2 = new ImageInfo(str);
                        imageInfo2.mDescription = Vi();
                        MediaWrapper mediaWrapper4 = new MediaWrapper(imageInfo2);
                        mediaWrapper4.setQuality(i3);
                        arrayList.add(mediaWrapper4);
                    }
                }
                boolean z18 = z16;
                i18 = i17 + 1;
                z17 = z18;
            }
            i17 = i18;
            z16 = z17;
            boolean z182 = z16;
            i18 = i17 + 1;
            z17 = z182;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.44
            @Override // java.lang.Runnable
            public void run() {
                b.c cVar = QZoneUploadPhotoActivity.this.f51699o3;
                if (cVar == null || !cVar.isShowing()) {
                    return;
                }
                QZoneUploadPhotoActivity.this.f51699o3.dismiss();
            }
        });
        return arrayList;
    }

    /* loaded from: classes39.dex */
    public static abstract class ai {

        /* renamed from: a, reason: collision with root package name */
        protected QZoneUploadPhotoActivity f51767a;

        /* renamed from: b, reason: collision with root package name */
        protected String f51768b;

        public ai(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
            this.f51767a = qZoneUploadPhotoActivity;
        }

        public abstract String b();

        public int c() {
            return R.string.gpd;
        }

        public int d() {
            return R.string.f173046gp0;
        }

        public int e() {
            return R.string.gp6;
        }

        public boolean g() {
            return true;
        }

        public boolean h() {
            return true;
        }

        public abstract boolean i();

        public boolean j() {
            return true;
        }

        public boolean l() {
            return true;
        }

        public boolean m() {
            return true;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return true;
        }

        public abstract void p();

        public abstract void q();

        public abstract void r();

        public boolean s() {
            return true;
        }

        public void t(String str) {
            this.f51768b = str;
        }

        public abstract void v(List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i3, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Object... objArr);

        public void a() {
        }

        public void f() {
        }

        public void k() {
        }

        public void u(String str, List<MediaWrapper> list, BusinessAlbumInfo businessAlbumInfo, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Object... objArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(int i3) {
        if (i3 == 1) {
            ToastUtil.o(R.string.gcq, 4);
            return;
        }
        if (i3 == 2) {
            ToastUtil.o(R.string.gcr, 4);
            return;
        }
        if (i3 == 3) {
            ToastUtil.o(R.string.gct, 4);
        } else if (i3 == 4) {
            ToastUtil.o(R.string.gcs, 4);
        } else {
            if (i3 != 5) {
                return;
            }
            ToastUtil.o(R.string.ght, 4);
        }
    }

    public void yo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class r implements DialogInterface.OnClickListener {
        r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Bj(Boolean bool, String str, String str2, String str3) {
    }
}
