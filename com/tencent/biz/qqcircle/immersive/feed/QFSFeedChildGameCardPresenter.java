package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedButton;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tencent.im.qqgame.QQGameGcSpkTaskDye;
import tencent.im.qqgame.QQGameQfsSubscribe;

/* loaded from: classes4.dex */
public class QFSFeedChildGameCardPresenter extends QFSFeedChildBaseCardPresenter implements WadlTrpcListener, WadlProxyServiceCallBackInterface, QFSFeedCardAnimWrap.j {

    /* renamed from: n0, reason: collision with root package name */
    private static String f85089n0 = "/base/activity/GameCenterActivity";

    /* renamed from: o0, reason: collision with root package name */
    private static HashSet<String> f85090o0;
    FeedCloudMeta$StLiteBanner X;
    FeedCloudMeta$StFeedButton Y;
    ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    View f85091a0;

    /* renamed from: b0, reason: collision with root package name */
    TextView f85092b0;

    /* renamed from: c0, reason: collision with root package name */
    TextView f85093c0;

    /* renamed from: d0, reason: collision with root package name */
    TextView f85094d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f85095e0;

    /* renamed from: f0, reason: collision with root package name */
    TextView f85096f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f85097g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f85098h0;

    /* renamed from: m0, reason: collision with root package name */
    private ApkInfo f85103m0;
    private int W = 1;

    /* renamed from: i0, reason: collision with root package name */
    private String f85099i0 = "";

    /* renamed from: j0, reason: collision with root package name */
    private String f85100j0 = "";

    /* renamed from: k0, reason: collision with root package name */
    private String f85101k0 = "";

    /* renamed from: l0, reason: collision with root package name */
    private int f85102l0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WadlParams f85110d;

        a(WadlParams wadlParams) {
            this.f85110d = wadlParams;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QFSFeedChildGameCardPresenter.this.G1(this.f85110d);
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f85090o0 = hashSet;
        hashSet.add(WadlProxyConsts.CMD_GAME_DYE_USER);
        f85090o0.add(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A1(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("QFSFeedChildGameCardPresenter", 2, "onSubscribeStatus subscribeStatus=" + i3 + ",startAnim=" + z16);
        }
        if (i3 == 1) {
            if (z16) {
                super.l1((FeedCloudMeta$StFeed) this.f85017h);
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildGameCardPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildGameCardPresenter.this.N.setText(QCircleApplication.APP.getResources().getString(R.string.f229656x1));
                    QFSFeedChildGameCardPresenter.this.P.setText(QCircleApplication.APP.getResources().getString(R.string.f229656x1));
                }
            });
            return;
        }
        if (i3 != 2 && i3 != 1995001) {
            if (i3 == 3) {
                if (z16) {
                    super.l1((FeedCloudMeta$StFeed) this.f85017h);
                }
                if (this.f85103m0 != null) {
                    if (PackageUtil.isAppInstalled(m0(), this.f85103m0.pkgName)) {
                        WadlResult wadlResult = new WadlResult(q1(this.f85103m0));
                        wadlResult.taskStatus = 9;
                        onWadlTaskStatusChanged(wadlResult);
                        return;
                    }
                    WadlProxyServiceUtil.getProxyService().doQueryAllTask();
                    return;
                }
                return;
            }
            return;
        }
        if (z16) {
            super.l1((FeedCloudMeta$StFeed) this.f85017h);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildGameCardPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildGameCardPresenter.this.N.setText(QCircleApplication.APP.getResources().getString(R.string.f229776xc));
                QFSFeedChildGameCardPresenter.this.P.setText(QCircleApplication.APP.getResources().getString(R.string.f229776xc));
            }
        });
    }

    private void B1() {
        if (!TextUtils.isEmpty(this.f85098h0)) {
            try {
                for (String str : this.f85098h0.substring(this.f85098h0.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split != null && split.length == 2) {
                        if ("appid".equalsIgnoreCase(split[0])) {
                            this.f85099i0 = URLDecoder.decode(split[1], "UTF-8");
                        } else if ("taskKey".equalsIgnoreCase(split[0])) {
                            this.f85100j0 = URLDecoder.decode(split[1], "UTF-8");
                        } else if ("channel_id".equalsIgnoreCase(split[0])) {
                            this.f85101k0 = URLDecoder.decode(split[1], "UTF-8");
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.d("QFSFeedChildGameCardPresenter", 1, "parseUrl failed", e16);
            }
        }
        QLog.d("QFSFeedChildGameCardPresenter", 1, "parseUrl currAppid=" + this.f85099i0 + ",taskKey=" + this.f85100j0 + ",channelId=" + this.f85101k0 + ",jumpUrl=" + this.f85098h0);
    }

    private void C1(String str, String str2, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putBoolean("animFlag", z16);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).querySubscribeStatus(str, str2, bundle);
    }

    private void D1(String str, String str2) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("991").setOperModule("9098").setModuleType("909801").setGameCenterSrc("spark_xiaoshijie").setOperId(str).setOperType(str2).setGameAppId(this.f85099i0).setExt(2, String.valueOf(this.W)).setExt(25, this.f85100j0).setExt(42, this.f85101k0).report();
    }

    private void E1(String str, View view, String str2) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "reportDT eventId =" + str + ",eid=" + str2 + ",jumpUrl=" + this.f85098h0);
        if (!TextUtils.isEmpty(str) && view != null && !TextUtils.isEmpty(str2) && this.X != null) {
            VideoReport.setElementId(view, str2);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_custom_pgid", r0());
            buildElementParams.put("xsj_eid", str2);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("dt_pgstp", Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("dt_ref_pgid", Integer.valueOf(y0()));
            buildElementParams.put("xsj_customized_id", this.X.activityID.get());
            buildElementParams.put("xsj_customized_title", s1(this.X.title.get()));
            buildElementParams.put("xsj_customized_words", s1(this.X.summary.get()));
            buildElementParams.put("xsj_customized_link", s1(this.f85098h0));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUSTOMIZED_BUSINESS_TYPE, Integer.valueOf(this.X.business_type.get()));
            VideoReport.reportEvent(str, view, buildElementParams);
        }
    }

    private void F1(WadlParams wadlParams, String str) {
        QCircleCustomDialog.P(m0(), QCircleApplication.APP.getResources().getString(R.string.f1373206j), str, R.string.f1373006h, R.string.f1373106i, new a(wadlParams), new b()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(WadlParams wadlParams) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "startDownload wadlParams =" + wadlParams);
        QQToast.makeText(RFWApplication.getApplication(), 2, R.string.f2322073x, 1).show();
        wadlParams.speedBuffer = 2048;
        WadlProxyServiceUtil.getProxyService().doDownloadAction(wadlParams);
        H1(2);
    }

    private void H1(int i3) {
        QQGameGcSpkTaskDye.SubscribeReq subscribeReq;
        if (i3 == 1) {
            subscribeReq = new QQGameGcSpkTaskDye.SubscribeReq();
            subscribeReq.subscribeType.set(1);
        } else {
            subscribeReq = null;
        }
        QQGameGcSpkTaskDye.SubscribeReq subscribeReq2 = subscribeReq;
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedChildGameCardPresenter", 2, "subscribe taskKey=" + this.f85100j0 + ",channelId=" + this.f85101k0 + ",currAppid=" + this.f85099i0 + ",dyeOpType=" + i3);
        }
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).dyeUser(this.f85100j0, this.f85101k0, this.f85099i0, 2, i3, subscribeReq2, "3", "");
    }

    private void I1(int i3) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = this.X;
        if (feedCloudMeta$StLiteBanner != null && feedCloudMeta$StLiteBanner.tianshuEntry.has()) {
            com.tencent.biz.qqcircle.immersive.utils.az.a(this.X.tianshuEntry.value.lst.get(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(String str, String str2, WadlResult wadlResult) {
        this.N.setText(str);
        this.P.setText(str2);
        this.N.setTag(wadlResult);
        this.P.setTag(wadlResult);
        ImageView imageView = this.Z;
        if (imageView != null) {
            int i3 = wadlResult.taskStatus;
            if (i3 != 2 && i3 != 4) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
    }

    private boolean p1(String... strArr) {
        if (strArr == null || strArr.length < 1) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    private WadlParams q1(ApkInfo apkInfo) {
        WadlParams wadlParams = new WadlParams(apkInfo.appId, apkInfo.pkgName);
        wadlParams.apkUrl = apkInfo.defUrl;
        wadlParams.appName = apkInfo.appName;
        wadlParams.versionCode = apkInfo.versionCode;
        wadlParams.iconUrl = apkInfo.iconUrl;
        wadlParams.apkChannel = apkInfo.channel;
        return wadlParams;
    }

    private void r1(Context context, String str) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "[doJumpUrl] jumpUrl =" + str);
        if (!TextUtils.isEmpty(str) && str.startsWith("mqqapi://miniapp/open?")) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).gotoSchemaUri(context, str);
        } else {
            QRoute.createNavigator(context, f85089n0).withString("url", str).withFlags(268435456).request();
        }
    }

    private String s1(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() > 20) {
            return str.substring(0, 20);
        }
        return str;
    }

    private String t1(long j3) {
        long j16 = j3 / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j16 > 1024) {
            float f16 = ((float) j16) / 1024.0f;
            if (f16 > 1024.0f) {
                return decimalFormat.format(f16 / 1024.0f) + "GB";
            }
            return decimalFormat.format(f16) + "M";
        }
        return j16 + "KB";
    }

    private boolean u1() {
        if (this.W == 2) {
            return true;
        }
        return false;
    }

    private void w1(WadlResult wadlResult) {
        String string;
        QLog.d("QFSFeedChildGameCardPresenter", 1, "onClickByResult wadlResult =" + wadlResult);
        int i3 = wadlResult.taskStatus;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 9) {
                    if (i3 != 12) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    if (i3 != 7) {
                                        return;
                                    }
                                } else {
                                    WadlProxyServiceUtil.getProxyService().doInstallAction(wadlResult.wadlParams);
                                    return;
                                }
                            } else {
                                D1("205991", "20");
                                if (NetworkUtil.isWifiConnected(m0())) {
                                    WadlProxyServiceUtil.getProxyService().doResumeAction(0, wadlResult.wadlParams.appId);
                                    return;
                                } else {
                                    F1(wadlResult.wadlParams, QCircleApplication.APP.getResources().getString(R.string.f1372806f));
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    D1("205992", "20");
                    PackageUtil.startAppWithPkgName(m0(), wadlResult.wadlParams.packageName, null);
                    return;
                }
            }
            WadlProxyServiceUtil.getProxyService().doPauseAction(0, wadlResult.wadlParams.appId);
            return;
        }
        D1("205991", "20");
        if (NetworkUtil.isWifiConnected(m0())) {
            G1(wadlResult.wadlParams);
            return;
        }
        if (this.f85103m0.pkgSize > 0) {
            string = String.format(QCircleApplication.APP.getResources().getString(R.string.f1372906g), t1(this.f85103m0.pkgSize));
        } else {
            string = QCircleApplication.APP.getResources().getString(R.string.f1372806f);
        }
        F1(wadlResult.wadlParams, string);
    }

    private void x1(final String str, final String str2, final String str3, final String str4, final String str5) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "onGetGameInfo gameAuthor=" + str + ",versionName =" + str2 + ",appName =" + str3 + ",permissionsUrl =" + str4 + ",privacyGuideUrl =" + str5);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildGameCardPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildGameCardPresenter.this.f85091a0.setVisibility(0);
                QFSFeedChildGameCardPresenter.this.f85092b0.setText("\u5f00\u53d1\u8005:" + str);
                QFSFeedChildGameCardPresenter.this.f85093c0.setText("\u7248\u672c:" + str2);
                QFSFeedChildGameCardPresenter.this.f85094d0.setText("\u5e94\u7528\u540d\u79f0:" + str3);
                QFSFeedChildGameCardPresenter.this.f85095e0.setTag(str5);
                QFSFeedChildGameCardPresenter.this.f85096f0.setTag(str4);
            }
        });
    }

    private void y1(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        int parseInt;
        String stringExtra = intent.getStringExtra("appid");
        boolean booleanExtra = intent.getBooleanExtra("animFlag", false);
        if (QLog.isColorLevel()) {
            QLog.i("QFSFeedChildGameCardPresenter", 2, "onQuerySubscribe appId=" + this.f85099i0 + ",ret=" + j3);
        }
        if (!TextUtils.isEmpty(stringExtra) && j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null && stringExtra.equals(this.f85099i0)) {
            try {
                QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                getUserGameStatusRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                this.f85102l0 = getUserGameStatusRsp.result.get();
                QQGameQfsSubscribe.GameInfo gameInfo = getUserGameStatusRsp.gameInfo.get();
                QQGameQfsSubscribe.DownloadInfo downloadInfo = getUserGameStatusRsp.downloadInfo.get();
                if (QLog.isColorLevel()) {
                    QLog.i("QFSFeedChildGameCardPresenter", 2, "onQuerySubscribe subscribeStatus=" + this.f85102l0 + ",gameInfo=" + gameInfo + ",downloadInfo=" + downloadInfo);
                }
                if (gameInfo != null && downloadInfo != null) {
                    ApkInfo apkInfo = new ApkInfo(this.f85099i0, gameInfo.appName.get(), this.f85101k0, downloadInfo.pkgName.get(), downloadInfo.androidDownloadUrl.get());
                    this.f85103m0 = apkInfo;
                    apkInfo.pkgSize = downloadInfo.pkgSize.get();
                    String str = downloadInfo.versionCode.get();
                    ApkInfo apkInfo2 = this.f85103m0;
                    if (TextUtils.isEmpty(str)) {
                        parseInt = 0;
                    } else {
                        parseInt = Integer.parseInt(downloadInfo.versionCode.get());
                    }
                    apkInfo2.versionCode = parseInt;
                    this.f85103m0.iconUrl = gameInfo.gameIcon.get();
                    if (this.f85102l0 == 3) {
                        x1(gameInfo.gameAuthor.get(), gameInfo.versionName.get(), gameInfo.appName.get(), gameInfo.permissions.get(), gameInfo.privacyGuidePic.get());
                    }
                }
            } catch (Exception e16) {
                QLog.e("QFSFeedChildGameCardPresenter", 1, e16, new Object[0]);
            }
            A1(this.f85102l0, booleanExtra);
        }
    }

    private void z1(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        String stringExtra = intent.getStringExtra("appid");
        int intExtra = intent.getIntExtra("type", -1);
        if (stringExtra != null && j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null && stringExtra.equals(this.f85099i0)) {
            try {
                QQGameGcSpkTaskDye.GetDyedRsp getDyedRsp = new QQGameGcSpkTaskDye.GetDyedRsp();
                getDyedRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                if (intExtra == 1) {
                    int i3 = getDyedRsp.subscribe_rsp.get().result.get();
                    this.f85102l0 = i3;
                    A1(i3, false);
                    if (QLog.isColorLevel()) {
                        QLog.i("QFSFeedChildGameCardPresenter", 2, "onSubscribe result=" + i3 + ",subscribeStatus=" + this.f85102l0);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QFSFeedChildGameCardPresenter", 1, e16, new Object[0]);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFSFeedChildGameCardPresenter", 2, "onSubscribe ret=" + j3 + ",type=" + intExtra + ",appId=" + stringExtra + ",currAppid=" + this.f85099i0 + ",subscribeStatus=" + this.f85102l0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        this.Q.add(Integer.valueOf(R.id.v_a));
        QLog.d("QFSFeedChildGameCardPresenter", 1, "[onAttachedToWindow] isShowCard=" + this.f85097g0 + ",pos=" + (this.f85018i + 1));
        if (this.f85097g0) {
            WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        }
        if (k1()) {
            ua0.e.b((FeedCloudMeta$StFeed) this.f85017h, r0());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("QFSFeedChildGameCardPresenter", 1, "[onDetachedFromWindow] isShowCard=" + this.f85097g0 + ",pos=" + (this.f85018i + 1));
        if (this.f85097g0) {
            WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
        }
        View view = this.f85091a0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap.j
    public void P(int i3) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "onCardEvent event =" + i3);
        if (i3 == 1) {
            this.W = 1;
            D1("907428", "8");
            E1("dt_imp", this.N, "em_xsj_customized_popularize_banner");
        } else if (i3 == 2) {
            this.W = 2;
            D1("907428", "8");
            E1("dt_imp", this.P, "em_xsj_customized_popularize_card");
        } else if (i3 == 3) {
            this.W = 3;
            D1("907430", "20");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected boolean g1() {
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return f85090o0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected void j1(View view) {
        super.j1(view);
        if (view != null && this.f85091a0 == null) {
            this.I.setVisibility(8);
            this.Z = (ImageView) view.findViewById(R.id.f39341be);
            View inflate = ((ViewStub) view.findViewById(R.id.f41461h5)).inflate();
            this.f85091a0 = inflate;
            inflate.setVisibility(8);
            this.f85092b0 = (TextView) this.f85091a0.findViewById(R.id.u2m);
            this.f85093c0 = (TextView) this.f85091a0.findViewById(R.id.f116616z8);
            this.f85094d0 = (TextView) this.f85091a0.findViewById(R.id.sqf);
            this.f85095e0 = (TextView) this.f85091a0.findViewById(R.id.f88134w9);
            this.f85096f0 = (TextView) this.f85091a0.findViewById(R.id.f2373078);
            this.f85095e0.setOnClickListener(this);
            this.f85096f0.setOnClickListener(this);
            return;
        }
        QLog.w("QFSFeedChildGameCardPresenter", 1, "[initPupWindow] cancel, rootView=" + view + ",mBusinessTopView=" + this.f85091a0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected boolean k1() {
        FeedCloudMeta$StFeedButton feedCloudMeta$StFeedButton;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = this.X;
        if (feedCloudMeta$StLiteBanner != null && feedCloudMeta$StLiteBanner.style_type.get() == 1 && (feedCloudMeta$StFeedButton = this.Y) != null) {
            this.f85097g0 = true;
            this.f85098h0 = feedCloudMeta$StFeedButton.jump_url.get();
            return true;
        }
        this.f85097g0 = false;
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected void l1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QFSFeedChildGameCardPresenter", 1, "[playPupWindowAnimation]");
        B1();
        if (!p1(this.f85099i0, this.f85100j0, this.f85101k0)) {
            super.l1(feedCloudMeta$StFeed);
        } else {
            C1(this.f85099i0, this.f85101k0, true);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.N != null && this.X != null) {
            QLog.d("QFSFeedChildGameCardPresenter", 1, "[updateCardUIData] data =" + feedCloudMeta$StFeed);
            this.L.setText(this.X.title.get());
            this.M.setText(this.X.summary.get());
            FeedCloudMeta$StFeedButton feedCloudMeta$StFeedButton = this.Y;
            if (feedCloudMeta$StFeedButton != null) {
                this.N.setText(feedCloudMeta$StFeedButton.text.get());
                this.P.setText(this.Y.text.get());
            }
            String str = this.X.icon.picUrl.get();
            if (!TextUtils.isEmpty(str)) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.K).setUrl(str));
            }
            this.K.setmRadius(com.tencent.biz.qqcircle.utils.cx.a(2.0f), false);
            I1(101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f88134w9 && id5 != R.id.f2373078) {
            if (this.Q.contains(Integer.valueOf(id5)) && !TextUtils.isEmpty(this.f85098h0)) {
                QLog.d("QFSFeedChildGameCardPresenter", 1, "[onClick] jumpUrl =" + this.f85098h0);
                I1(102);
                if (id5 == R.id.f38571_b) {
                    QLog.d("QFSFeedChildGameCardPresenter", 1, "[onClick] click the btn...subscribeStatus=" + this.f85102l0);
                    int i3 = this.f85102l0;
                    if (i3 != 2 && i3 != 1995001) {
                        D1("907429", "20");
                        int i16 = this.f85102l0;
                        if (i16 == 1) {
                            H1(1);
                            D1("205993", "20");
                        } else if (i16 == 3 && (this.N.getTag() instanceof WadlResult)) {
                            w1((WadlResult) this.N.getTag());
                        } else {
                            r1(m0(), this.f85098h0);
                        }
                    }
                } else {
                    r1(m0(), this.f85098h0);
                }
                if (u1()) {
                    E1("dt_clck", this.P, "em_xsj_customized_popularize_card");
                } else {
                    E1("dt_clck", this.N, "em_xsj_customized_popularize_banner");
                }
                ua0.e.a((FeedCloudMeta$StFeed) this.f85017h, r0());
            } else {
                QLog.w("QFSFeedChildGameCardPresenter", 1, "[onClick] fail, id =" + id5 + ",jumpUrl =" + this.f85098h0);
            }
        } else {
            Object tag = view.getTag();
            if (tag instanceof String) {
                r1(m0(), (String) tag);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        WadlResult wadlResult;
        QLog.d("QFSFeedChildGameCardPresenter", 1, "onQueryCallback wadlResults =" + arrayList.size() + ",subscribeStatus=" + this.f85102l0);
        ApkInfo apkInfo = this.f85103m0;
        if (apkInfo != null && !TextUtils.isEmpty(apkInfo.appId) && this.f85102l0 == 3) {
            Iterator<WadlResult> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    wadlResult = it.next();
                    if (this.f85103m0.appId.equals(wadlResult.wadlParams.appId)) {
                        break;
                    }
                } else {
                    wadlResult = null;
                    break;
                }
            }
            if (wadlResult == null) {
                wadlResult = new WadlResult(q1(this.f85103m0));
                wadlResult.taskStatus = 0;
            }
            onWadlTaskStatusChanged(wadlResult);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedChildGameCardPresenter", 4, "[onResumed] isShowCard=" + this.f85097g0 + ",currAppid=" + this.f85099i0 + ",taskKey=" + this.f85100j0 + ",channelId=" + this.f85101k0);
        }
        if (this.f85097g0 && p1(this.f85099i0, this.f85100j0, this.f85101k0)) {
            C1(this.f85099i0, this.f85101k0, false);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS.equals(str)) {
            y1(intent, j3, trpcInovkeRsp);
        } else if (WadlProxyConsts.CMD_GAME_DYE_USER.equals(str)) {
            z1(intent, j3, trpcInovkeRsp);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(final WadlResult wadlResult) {
        WadlParams wadlParams;
        QLog.d("QFSFeedChildGameCardPresenter", 1, "onWadlTaskStatusChanged currAppid=" + this.f85099i0 + ",wadlResult =" + wadlResult);
        if (this.S && wadlResult != null && (wadlParams = wadlResult.wadlParams) != null && wadlParams.appId.equals(this.f85099i0)) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildGameCardPresenter.6
                @Override // java.lang.Runnable
                public void run() {
                    int i3 = wadlResult.taskStatus;
                    if (i3 != 0) {
                        if (i3 != 2) {
                            if (i3 != 9) {
                                if (i3 != 12) {
                                    if (i3 != 4) {
                                        if (i3 != 5) {
                                            if (i3 != 6) {
                                                if (i3 == 7) {
                                                    String string = QCircleApplication.APP.getResources().getString(R.string.f221246aa);
                                                    QFSFeedChildGameCardPresenter.this.J1(string, string, wadlResult);
                                                    QQToast.makeText(RFWApplication.getApplication(), 1, R.string.f2322173y, 1).show();
                                                    return;
                                                }
                                                return;
                                            }
                                            String string2 = QCircleApplication.APP.getResources().getString(R.string.f160851w5);
                                            QFSFeedChildGameCardPresenter.this.J1(string2, string2, wadlResult);
                                            return;
                                        }
                                        QFSFeedChildGameCardPresenter.this.J1(QCircleApplication.APP.getResources().getString(R.string.f228346th), String.format(QCircleApplication.APP.getResources().getString(R.string.f228356ti), Integer.valueOf(wadlResult.progress)), wadlResult);
                                        return;
                                    }
                                }
                            } else {
                                String string3 = QCircleApplication.APP.getResources().getString(R.string.f228216t5);
                                QFSFeedChildGameCardPresenter.this.J1(string3, string3, wadlResult);
                                return;
                            }
                        }
                        QFSFeedChildGameCardPresenter.this.J1(QCircleApplication.APP.getResources().getString(R.string.f228256t9), String.format(QCircleApplication.APP.getResources().getString(R.string.f228266t_), Integer.valueOf(wadlResult.progress)), wadlResult);
                        return;
                    }
                    String string4 = QCircleApplication.APP.getResources().getString(R.string.zta);
                    QFSFeedChildGameCardPresenter.this.J1(string4, string4, wadlResult);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        try {
            if (feedCloudMeta$StFeed == null) {
                QLog.d("QFSFeedChildGameCardPresenter", 1, "[onBindData] data should not be null.");
                return;
            }
            FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner;
            this.X = feedCloudMeta$StLiteBanner;
            List<FeedCloudMeta$StFeedButton> list = feedCloudMeta$StLiteBanner.button.get();
            if (list.size() > 0) {
                this.Y = list.get(0);
            }
        } catch (Throwable th5) {
            QLog.d("QFSFeedChildGameCardPresenter", 1, "[onBindData] failed", th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildGameCardPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected QFSFeedCardAnimWrap.j i1() {
        return this;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
