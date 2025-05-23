package com.qzone.common.activities.base;

import NS_MOBILE_OPERATION.operation_hide_feeds_rsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.detail.business.protocol.QZonehideSingleFeedRequest;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ToastUtil;
import com.qzone.widget.f;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lg.k;
import lg.q;
import n5.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedOperateLogic implements IQZoneServiceListener, IQZoneFeedOperateLogicInterface {
    private static final int ACTION_HIDE_SINGLE_FEED = 1;
    public static final String FORBID_FROWARD_CLICK = "1";
    public static final String FROM_DETAIL = "detail";
    public static final String FROM_FEED = "feed";
    public static final String FROM_GONGZHONGHAO = "gongzhonghao";
    public static final int HIDE_VIDEO_FEED_POSITION = -1;
    public static final int SHARETOQQ = 1;
    public static final int SHARETOWEIXIN = 0;
    public static final int SHARETOWEIXINMINI = 3;
    public static final int SHARETOXHS = 4;
    private static final String TAG = "QZoneFeedOperateLogic";
    public static int mPos = -1;
    Dialog hideFeedDialog;
    protected BusinessFeedData mFeedData;
    Handler mHandler;
    protected Activity owner;
    private String refer;
    protected int itemTag = 0;
    public View mClickView = null;
    private Dialog viewWattingDialog = null;
    private TextView viewWattingDialogMsg = null;
    private ai mResHelper = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f45295d;

        a(Dialog dialog) {
            this.f45295d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f45295d.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f45297d;

        b(int i3) {
            this.f45297d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BusinessFeedData businessFeedData = QZoneFeedOperateLogic.this.mFeedData;
            TTTReportManager.s().o(12, 204, 1, System.currentTimeMillis(), null, QZoneFeedOperateLogic.this.mFeedData, -1000, 0, businessFeedData != null ? businessFeedData.getOperationInfo().feedReportCookie : null, null, true);
            EventCenter.getInstance().post("Feed", 32, Integer.valueOf(this.f45297d), QZoneFeedOperateLogic.this.mFeedData);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f45306d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45307e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45308f;

        e(String str, String str2, String str3) {
            this.f45306d = str;
            this.f45307e = str2;
            this.f45308f = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.qzone.business.share.f.b().e(QZoneFeedOperateLogic.this.mFeedData, this.f45306d).a(QZoneFeedOperateLogic.this.owner, this.f45307e, this.f45308f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "share to QQ canceled");
            QZoneFeedOperateLogic.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f45311d;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements Consumer<Boolean> {
            a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                QZLog.d(QZoneFeedOperateLogic.TAG, 1, "shareToWx result: " + bool);
                if (bool.booleanValue()) {
                    return;
                }
                QZLog.d(QZoneFeedOperateLogic.TAG, 1, "shareToWx result fail, ex", new Throwable());
            }
        }

        g(String str) {
            this.f45311d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFeedOperateLogic.this.shareToXhsWithQRCode(this.f45311d, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "share to XHS canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45317f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45318h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f45319i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f45320m;

        i(boolean z16, String str, String str2, String str3, String str4, String str5) {
            this.f45315d = z16;
            this.f45316e = str;
            this.f45317f = str2;
            this.f45318h = str3;
            this.f45319i = str4;
            this.f45320m = str5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFeedOperateLogic.this.shareToWx(this.f45315d, this.f45316e, this.f45317f, this.f45318h, this.f45319i, this.f45320m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "share to WeChat canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements Consumer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45322d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45323e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45324f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45325h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f45326i;

        k(boolean z16, String str, String str2, String str3, String str4) {
            this.f45322d = z16;
            this.f45323e = str;
            this.f45324f = str2;
            this.f45325h = str3;
            this.f45326i = str4;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            QZLog.d(QZoneFeedOperateLogic.TAG, 1, "shareToWx result: " + bool);
            if (bool.booleanValue()) {
                return;
            }
            QZLog.d(QZoneFeedOperateLogic.TAG, 1, "shareToWx result fail, ex", new Throwable());
            if (this.f45322d) {
                QZoneFeedOperateLogic.this.doShareToWeixinUnchecked(this.f45323e, this.f45324f, this.f45325h, this.f45326i);
            } else {
                QZoneFeedOperateLogic.this.doShareToWeixinUnchecked(this.f45323e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f45328d;

        l(int i3) {
            this.f45328d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFeedOperateLogic.this.doHideOneFeed(this.f45328d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f45330d;

        m(BusinessFeedData businessFeedData) {
            this.f45330d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            long j3 = this.f45330d.getUser().uin;
            z5.a f16 = z5.a.f();
            x6.a g16 = f16 != null ? f16.g(j3) : null;
            if (g16 == null) {
                str = "";
            } else {
                str = g16.name;
            }
            a8.b.O().H(LoginData.getInstance().getUin(), new a8.a(j3, str), QZoneFeedOperateLogic.this.mHandler);
            if (QZoneFeedOperateLogic.this.mFeedData.getFeedCommInfo() != null) {
                QZLog.i(QZoneFeedOperateLogic.TAG, "isLikeRecommFamousFeed = true, getFeedCommInfo feedsAttr = " + QZoneFeedOperateLogic.this.mFeedData.getFeedCommInfo().feedsAttr + ", exclude uin=" + j3 + ",login uin=" + LoginData.getInstance().getUin());
            }
        }
    }

    public QZoneFeedOperateLogic(Handler handler, Activity activity, String str) {
        this.mHandler = handler;
        this.refer = str;
        this.owner = activity;
    }

    private boolean checkOpmask(int i3) {
        if (this.mFeedData == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(r0.getFeedCommInfo().operatemask, i3);
    }

    private boolean checkOpmask3(int i3) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask3, i3);
    }

    private boolean doShareToQQ() {
        BusinessFeedData businessFeedData;
        String str;
        Map<String, String> map;
        if (canShare() && (businessFeedData = this.mFeedData) != null) {
            if (businessFeedData.isRegisterAnniversaryFeed()) {
                CellGuiding cellGuiding = this.mFeedData.getCellGuiding();
                if (cellGuiding == null || (map = cellGuiding.extendInfo) == null) {
                    str = null;
                } else {
                    str = map.get("mqq_share_url");
                    if (!TextUtils.isEmpty(str)) {
                        com.qzone.business.share.f.b().d(this.mFeedData).a(this.owner, str, QZoneShareManager.QQ_SHARE_APPID);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    QZLog.e(TAG, "shareToQQ failed! mqq_share_url is null!");
                }
                return true;
            }
            if (this.mFeedData.getOperationInfo() != null) {
                com.qzone.business.share.f.b().d(this.mFeedData).a(this.owner, this.mFeedData.getOperationInfo().qqUrl, QZoneShareManager.QQ_SHARE_APPID);
                return true;
            }
        }
        return false;
    }

    private boolean doShareToWeixin() {
        BusinessFeedData businessFeedData;
        String str;
        Map<String, String> map;
        if (canShare() && (businessFeedData = this.mFeedData) != null) {
            if (businessFeedData.isRegisterAnniversaryFeed()) {
                CellGuiding cellGuiding = this.mFeedData.getCellGuiding();
                if (cellGuiding == null || (map = cellGuiding.extendInfo) == null) {
                    str = null;
                } else {
                    str = map.get("weixin_share_url");
                    if (!TextUtils.isEmpty(str)) {
                        doShareToWeixinUnchecked(str);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    QZLog.e(TAG, "doShareToWeixin failed! weixin_share_url is null!");
                }
                return true;
            }
            if (this.mFeedData.getOperationInfo() != null) {
                doShareToWeixinUnchecked(this.mFeedData.getOperationInfo().weixinUrl);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        Activity activity;
        if (!FROM_GONGZHONGHAO.equals(this.refer) || (activity = this.owner) == null || activity.isFinishing()) {
            return;
        }
        this.owner.finish();
    }

    private boolean isGuest() {
        return this.mFeedData.getUser().uin != LoginData.getInstance().getUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doShareToXHSCheckedPermission$0(Boolean bool) {
        QZLog.d(TAG, 1, "shareToXHS result: " + bool);
        bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToWxMoment$3(Consumer consumer, k.QZoneQrcodeResult qZoneQrcodeResult) {
        if (qZoneQrcodeResult.getIsSuccess()) {
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), qZoneQrcodeResult.getFilePath(), com.qzone.util.image.c.i(qZoneQrcodeResult.getFilePath()), this.itemTag == 9 ? 0 : 1);
        }
        consumer.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToWxNew$2(Consumer consumer, q.QZoneQrcodeResult qZoneQrcodeResult) {
        if (qZoneQrcodeResult.getIsSuccess()) {
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), qZoneQrcodeResult.getFilePath(), com.qzone.util.image.c.i(qZoneQrcodeResult.getFilePath()), this.itemTag == 9 ? 0 : 1);
        }
        consumer.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToXhsWithQRCode$1(Consumer consumer, q.QZoneQrcodeResult qZoneQrcodeResult) {
        if (qZoneQrcodeResult.getIsSuccess()) {
            com.qzone.business.share.d.f44790a.i(this.owner, qZoneQrcodeResult.getFilePath(), com.qzone.reborn.configx.g.f53821a.b().R0(), "");
        }
        consumer.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
    }

    private void reportShareToQQ() {
        ClickReport.m("302", "60", "2");
    }

    private void reportShareToWeChat() {
        ClickReport.m("302", "60", "3");
    }

    private void reportShareToWxMoments() {
        ClickReport.m("302", "60", "4");
    }

    private void reportShow() {
        ClickReport.m("302", "60", "1");
    }

    private void shareQQbyArk() {
        String str = this.mFeedData.getOperationInfo().shareData.view_id;
        String str2 = this.mFeedData.getOperationInfo().shareData.ark_content;
        ArkFullScreenAppActivity.L2(this.owner, str, this.mFeedData.getOperationInfo().shareData.ark_id, "", str2, "", this.owner.getResources().getDisplayMetrics().scaledDensity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareToWx(boolean z16, String str, String str2, String str3, String str4, String str5) {
        if (oo.b.k() && shareToWxNew(str5, new k(z16, str, str2, str3, str4))) {
            QZLog.d(TAG, 1, "shareToWx use need feed share");
        } else if (z16) {
            doShareToWeixinUnchecked(str, str2, str3, str4);
        } else {
            doShareToWeixinUnchecked(str);
        }
    }

    private Dialog showCustomAlertDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (this.owner == null) {
            return null;
        }
        return new com.qzone.component.e().f(this.owner, 230, str, str2, str3, str4, onClickListener, onClickListener2);
    }

    private void startShuoshuoEditActivity() {
        yo.d.l(this.owner, QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MOOD_EDIT, "https://h5.qzone.qq.com/mood/editor/{tid}/moodEditor?tid={tid}&uin={uin}&hostuin={hostuin}&_wv=3").replace("{tid}", this.mFeedData.getIdInfo().cellId).replace("{uin}", LoginData.getInstance().getUinString()).replace("{hostuin}", LoginData.getInstance().getUinString()), 21, "");
    }

    public boolean canShare() {
        if (this.mFeedData == null) {
            return false;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return false;
        }
        if (CacheManager.isExternalAvailable()) {
            return true;
        }
        ToastUtil.n(R.string.h_6);
        return false;
    }

    protected void closeWaittingDialog() {
        try {
            Dialog dialog = this.viewWattingDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.viewWattingDialog.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected void doHideOneFeed(int i3) {
        long j3 = this.mFeedData.getFeedCommInfo().time;
        if (j3 > 0) {
            j3 /= 1000;
        }
        QZoneTask qZoneTask = new QZoneTask(new QZonehideSingleFeedRequest(this.mFeedData.getFeedCommInfo().feedskey, this.mFeedData.getUser().uin, j3), this.mHandler, this, 1);
        qZoneTask.addParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_KEY, this.mFeedData.getFeedCommInfo().feedskey);
        if (i3 != -1) {
            qZoneTask.addParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_POSITION, Integer.valueOf(i3));
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    protected void doShareToQQNew() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getVideoInfo() != null) {
            this.mFeedData.getLocalInfo();
        }
        getOutShareUrl(1);
        showWaittingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    public void doShareToWeixinUnchecked(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String firstPictureUrl;
        String videoCoverPictureUrl;
        ArrayList<PictureItem> arrayList;
        ShareUtils.g gVar = new ShareUtils.g();
        ch.a(this.mFeedData);
        DetailDataOutShare detailDataOutShare = this.mFeedData.getOperationInfo().shareData;
        if (detailDataOutShare != null) {
            str5 = TextCellParser.toPlainText(detailDataOutShare.sTitle);
            str6 = TextCellParser.toPlainText(detailDataOutShare.sSummary);
            Map<Integer, PictureUrl> map = detailDataOutShare.mapPhotoUrl;
            if (map != null && map.size() > 0) {
                gVar.f44743d = ch.c(detailDataOutShare.mapPhotoUrl);
            }
        } else {
            str5 = "";
            str6 = str5;
        }
        if (this.mFeedData.isDynamicAlbumFeed() && this.mFeedData.getPictureInfo() != null && this.mFeedData.getPictureInfo().pics != null && this.mFeedData.getPictureInfo().pics.size() > 0) {
            gVar.f44743d = this.mFeedData.getPictureInfo().pics.get(0).currentUrl.url;
        }
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SHARE_TO_WX, QzoneConfig.SECONDARY_MINI_APP_PIC_URL, QzoneConfig.SECONDARY_MINI_APP_PIC_URL_DEFAULT);
        if (this.mFeedData.isForwardFeed()) {
            firstPictureUrl = getFirstPictureUrl(this.mFeedData.getOriginalInfo());
            videoCoverPictureUrl = getVideoCoverPictureUrl(this.mFeedData.getOriginalInfo());
        } else {
            firstPictureUrl = getFirstPictureUrl(this.mFeedData);
            videoCoverPictureUrl = getVideoCoverPictureUrl(this.mFeedData);
        }
        if (TextUtils.isEmpty(firstPictureUrl) && TextUtils.isEmpty(videoCoverPictureUrl)) {
            gVar.f44743d = config;
        }
        if (TextUtils.isEmpty(gVar.f44743d)) {
            if (!TextUtils.isEmpty(firstPictureUrl)) {
                gVar.f44743d = firstPictureUrl;
            } else if (!TextUtils.isEmpty(videoCoverPictureUrl)) {
                gVar.f44743d = videoCoverPictureUrl;
            } else {
                gVar.f44743d = config;
            }
        }
        if (TextUtils.isEmpty(str6)) {
            str6 = "m.qzone.com";
        }
        if (TextUtils.isEmpty(str4)) {
            CellPictureInfo pictureInfo = this.mFeedData.getPictureInfo();
            VideoInfo videoInfo = this.mFeedData.getVideoInfo();
            if (pictureInfo != null) {
                String str7 = com.qzone.util.l.a(R.string.rv_) + pictureInfo.uploadnum + com.qzone.util.l.a(R.string.rv5);
                if (this.mFeedData.isForwardFeed() && (arrayList = pictureInfo.pics) != null && arrayList.size() > 0) {
                    gVar.f44743d = pictureInfo.pics.get(0).currentUrl.url;
                }
                str4 = str7;
            } else {
                if (this.mFeedData.isForwardFeed()) {
                    BusinessFeedData originalInfo = this.mFeedData.getOriginalInfo();
                    if (originalInfo != null) {
                        CellPictureInfo pictureInfo2 = originalInfo.getPictureInfo();
                        VideoInfo videoInfo2 = originalInfo.getVideoInfo();
                        if (pictureInfo2 != null) {
                            str5 = com.qzone.util.l.a(R.string.f172541rw0) + pictureInfo2.uploadnum + com.qzone.util.l.a(R.string.f172542rw1);
                            ArrayList<PictureItem> arrayList2 = pictureInfo2.pics;
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                gVar.f44743d = pictureInfo2.pics.get(0).currentUrl.url;
                            }
                        } else if (videoInfo2 != null) {
                            str5 = "\u5206\u4eab\u7ed9\u4f601\u4e2a\u89c6\u9891";
                        }
                    }
                } else if (videoInfo != null) {
                    str4 = "\u5206\u4eab\u7ed9\u4f601\u4e2a\u89c6\u9891";
                }
                str4 = str5;
            }
        }
        gVar.f44741b = str4;
        gVar.f44742c = str6;
        gVar.f44740a = str;
        gVar.f44744e = str2;
        gVar.f44745f = str3;
        gVar.f44746g = "";
        ShareUtils.r(this.owner, this.itemTag, gVar, 1);
    }

    protected void doShareToXHSCheckedPermission(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        if (i3 == 3) {
            com.qzone.business.share.g.a(this.owner, str2, new g(str6), new h());
        } else if (i3 == 1) {
            showPermissionTips(str2);
        } else {
            shareToXhsWithQRCode(str6, new Consumer() { // from class: com.qzone.common.activities.base.av
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QZoneFeedOperateLogic.lambda$doShareToXHSCheckedPermission$0((Boolean) obj);
                }
            });
        }
    }

    public ai getResHelper() {
        if (this.mResHelper == null) {
            this.mResHelper = new c();
        }
        return this.mResHelper;
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void handleGetShareUrl(QZoneResult qZoneResult) {
        handleGetShareUrl(qZoneResult != null && qZoneResult.getSucceed(), qZoneResult == null ? null : qZoneResult.getBundle());
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void hideNewUserRecommendFeeds(int i3) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(getResHelper().getString(3));
            return;
        }
        Activity activity = this.owner;
        if (activity == null) {
            return;
        }
        ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
        reportDialog.getWindow().setWindowAnimations(R.style.f173401cf);
        reportDialog.setContentView(R.layout.custom_dialog);
        ((TextView) reportDialog.findViewById(R.id.dialogTitle)).setVisibility(8);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogText);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        int i16 = layoutParams.topMargin;
        int i17 = AreaConst.dp15;
        layoutParams.topMargin = i16 + i17;
        layoutParams.bottomMargin += i17;
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        textView.setText(R.string.gfu);
        textView2.setText(getResHelper().getString(2));
        textView3.setText(getResHelper().getString(1));
        textView2.setOnClickListener(new a(reportDialog));
        textView3.setOnClickListener(new b(i3));
        reportDialog.show();
        this.hideFeedDialog = reportDialog;
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public boolean isFavorite() {
        if (this.mFeedData != null) {
            return QzoneFavoriteService.M().R(this.mFeedData.getFeedCommInfo().ugckey);
        }
        return false;
    }

    public boolean isPermissionShareByType(int i3) {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return false;
        }
        boolean k3 = QZoneFeedUtil.k(businessFeedData, i3);
        if (k3 || isGuest()) {
            return k3;
        }
        return true;
    }

    public void onFeedEdit() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if ((i3 == 311 || i3 == 6100) && com.qzone.proxy.feedcomponent.util.d.j(this.mFeedData.getFeedCommInfo().operatemask, 9)) {
            startShuoshuoEditActivity();
        } else {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToEdit", "\u8be5\u8bf4\u8bf4\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u7f16\u8f91"));
        }
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onHideFeeds(boolean z16, int i3) {
        if (this.mFeedData == null || this.owner == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(getResHelper().getString(3));
            return;
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (!z16) {
            this.hideFeedDialog = showCustomAlertDialog(null, getResHelper().getString(4), getResHelper().getString(1), getResHelper().getString(2), new l(i3), null);
            return;
        }
        showCustomAlertDialog("\u4e0d\u770bTA\u7684\u52a8\u6001", "\u786e\u8ba4\u9690\u85cfTA\u6240\u6709\u52a8\u6001\u5417\uff1f", R.layout.custom_dialog, getResHelper().getString(1), getResHelper().getString(2), new m(businessFeedData), null);
        if (this.mFeedData.getFeedCommInfo() == null || !this.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            return;
        }
        ClickReport.c(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER, 3, "", true, new String[0]);
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onInform() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        QZoneFeedUtil.u(businessFeedData);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1) {
            return;
        }
        handleHideSignleFeedRespone(qZoneTask);
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setHander(Handler handler) {
        this.mHandler = handler;
    }

    public boolean shareToWxMoment(final Consumer<Boolean> consumer) {
        return new lg.k().f(BaseApplication.getContext(), this.mFeedData, new Consumer() { // from class: com.qzone.common.activities.base.au
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QZoneFeedOperateLogic.this.lambda$shareToWxMoment$3(consumer, (k.QZoneQrcodeResult) obj);
            }
        });
    }

    public boolean shareToWxNew(String str, final Consumer<Boolean> consumer) {
        return new lg.q().j(BaseApplication.getContext(), this.mFeedData, str, new Consumer() { // from class: com.qzone.common.activities.base.ax
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QZoneFeedOperateLogic.this.lambda$shareToWxNew$2(consumer, (q.QZoneQrcodeResult) obj);
            }
        });
    }

    public void shareToXhsWithQRCode(String str, final Consumer<Boolean> consumer) {
        new lg.q().k(BaseApplication.getContext(), this.mFeedData, str, new Consumer() { // from class: com.qzone.common.activities.base.aw
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QZoneFeedOperateLogic.this.lambda$shareToXhsWithQRCode$1(consumer, (q.QZoneQrcodeResult) obj);
            }
        }, false);
    }

    protected void showPermissionTips(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.r(str);
    }

    protected void showWaittingDialog(String str) {
        Dialog dialog = this.viewWattingDialog;
        if (dialog == null || !dialog.isShowing()) {
            if (this.viewWattingDialog == null) {
                ReportDialog reportDialog = new ReportDialog(this.owner, R.style.f174269ui);
                this.viewWattingDialog = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.viewWattingDialogMsg = (TextView) this.viewWattingDialog.findViewById(R.id.dialogText);
                this.viewWattingDialog.findViewById(R.id.kja).setVisibility(8);
                this.viewWattingDialog.findViewById(R.id.cib).setVisibility(0);
            }
            this.viewWattingDialogMsg.setText(str);
            this.viewWattingDialog.show();
        }
    }

    private void doShareToWeixinNew() {
        getOutShareUrl(0);
        showWaittingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private void doShareToXHS() {
        getOutShareUrl(4);
        showWaittingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u52a0\u8f7d\u4e2d"));
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void handleGetShareUrl(boolean z16, Bundle bundle) {
        closeWaittingDialog();
        if (!z16) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25"), 4);
            finish();
            return;
        }
        if (bundle == null) {
            QZLog.e("[PhotoAlbum]shareOutSide", "QZoneFeedOperateLogic data == null");
            return;
        }
        QZLog.d("[PhotoAlbum]shareOutSide", 1, TAG, " handleGetShareUrl rsp:", bundle.toString());
        String string = bundle.getString("url");
        String string2 = bundle.getString("msg");
        String string3 = bundle.getString("mini_id");
        String string4 = bundle.getString("mini_path");
        String string5 = bundle.getString("mini_title");
        String string6 = bundle.getString("ark_content", "");
        Integer valueOf = Integer.valueOf(bundle.getInt("iShareOutType"));
        String string7 = bundle.getString("short_url");
        boolean z17 = bundle.getBoolean("isShareToQQFriendDirect", false);
        long j3 = bundle.getLong("shareToQQFriendDirectUIN", 0L);
        int i3 = bundle.getInt("shareToQQFriendDirectType", 0);
        String string8 = bundle.getString("shareToQQFriendDirectNick", null);
        int i16 = this.itemTag;
        if (i16 == 2) {
            doShareToQQCheckedPermission(valueOf.intValue(), string, QZoneShareManager.QQ_SHARE_APPID, string2, z17, j3, i3, string8, string6);
            return;
        }
        if (i16 == 9 || i16 == 10) {
            doShareToWeixinCheckedPermission(valueOf.intValue(), string, string2, string3, string4, string5, string7);
        } else if (i16 == 218) {
            doShareToXHSCheckedPermission(valueOf.intValue(), string, string2, string3, string4, string5, string7);
        }
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onShareToQQ() {
        this.itemTag = 2;
        ShareUtils.l();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.isSecretFeed()) {
                if (checkOpmask(14)) {
                    doShareToQQ();
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToShare", "\u6b64\u79d8\u5bc6\u6682\u4e0d\u652f\u6301\u5206\u4eab\u54e6"));
                }
            } else if (!this.mFeedData.isAdFeeds() && !this.mFeedData.isGDTAdvFeed()) {
                if (this.mFeedData.isRegisterAnniversaryFeed()) {
                    if (checkOpmask(14)) {
                        doShareToQQ();
                    } else {
                        QZLog.e(TAG, "onShareToQQ failed! operatemask is wrong ");
                    }
                } else {
                    doShareToQQNew();
                }
            } else if (QZoneAdFeedDataExtKt.isNativeAd(this.mFeedData)) {
                QZoneAdFeedUtils.f55717a.g0(this.mFeedData, this.owner);
            } else {
                doShareToQQ();
            }
        }
        reportShareToQQ();
    }

    private static String getFirstPictureUrl(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() > 0 && businessFeedData.getPictureInfo().pics.get(0).currentUrl != null) {
            return businessFeedData.getPictureInfo().pics.get(0).currentUrl.url;
        }
        return "";
    }

    private static String getVideoCoverPictureUrl(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().currentUrl != null) {
            return businessFeedData.getVideoInfo().currentUrl.url;
        }
        return "";
    }

    public void dismissHideFeedDialog(BusinessFeedData businessFeedData) {
        Dialog dialog;
        if (businessFeedData == null || businessFeedData != this.mFeedData || (dialog = this.hideFeedDialog) == null || !dialog.isShowing()) {
            return;
        }
        this.hideFeedDialog.dismiss();
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void handleFavorRespone(boolean z16, String str, boolean z17) {
        if (z17) {
            QfavHelper.B(BaseApplication.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), z16, str, false);
            return;
        }
        if (z16) {
            ToastUtil.s(com.qzone.util.l.a(R.string.rvc), 5);
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.r(com.qzone.util.l.a(R.string.rve));
        } else {
            ToastUtil.r(str);
        }
    }

    public void onForword(d.g gVar) {
        ArrayList<PictureItem> arrayList;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if (i3 == 2) {
            QZoneFeedUtil.q(this.mFeedData, "", 7, null, null, this.mHandler, false);
            return;
        }
        if (i3 == 4 || i3 == 311) {
            CellPictureInfo pictureInfo = this.mFeedData.getPictureInfo();
            if (pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() == 0) {
                pictureInfo = this.mFeedData.getOriginalInfoSafe().getPictureInfo();
            }
            CellPictureInfo cellPictureInfo = pictureInfo;
            if (cellPictureInfo != null) {
                cellPictureInfo.allow_share = 1;
                QZoneFeedUtil.c0(this.owner, cellPictureInfo, this.mFeedData.getUser(), this.mFeedData.getFeedCommInfo().appid, this.mFeedData.getIdInfo(), gVar, 2);
            }
        }
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onShareToWeixin() {
        this.itemTag = 9;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.isSecretFeed()) {
                if (checkOpmask(13)) {
                    doShareToWeixin();
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToShare", "\u6b64\u79d8\u5bc6\u6682\u4e0d\u652f\u6301\u5206\u4eab\u54e6"));
                }
            } else if (!this.mFeedData.isAdFeeds() && !this.mFeedData.isGDTAdvFeed()) {
                if (this.mFeedData.isRegisterAnniversaryFeed()) {
                    if (checkOpmask(13)) {
                        doShareToWeixin();
                    } else {
                        QZLog.e(TAG, "onShareToWeixin failed! operatemask is wrong ");
                    }
                } else {
                    doShareToWeixinNew();
                }
            }
        }
        reportShareToWeChat();
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onShareToWxMoments() {
        this.itemTag = 10;
        ShareUtils.u();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.isSecretFeed()) {
                if (checkOpmask(13)) {
                    doShareToWeixin();
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToShare", "\u6b64\u79d8\u5bc6\u6682\u4e0d\u652f\u6301\u5206\u4eab\u54e6"));
                }
            } else if (!this.mFeedData.isAdFeeds() && !this.mFeedData.isGDTAdvFeed()) {
                if (this.mFeedData.isRegisterAnniversaryFeed()) {
                    if (checkOpmask(13)) {
                        doShareToWeixin();
                    } else {
                        QZLog.e(TAG, "onShareToWeixin failed! operatemask is wrong ");
                    }
                } else {
                    doShareToWeixinNew();
                }
            }
        }
        reportShareToWxMoments();
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void onShareToXHS() {
        this.itemTag = 218;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.isSecretFeed()) {
                if (checkOpmask3(9)) {
                    doShareToXHS();
                    return;
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToShare", "\u6b64\u79d8\u5bc6\u6682\u4e0d\u652f\u6301\u5206\u4eab\u54e6"));
                    return;
                }
            }
            if (this.mFeedData.isAdFeeds() || this.mFeedData.isGDTAdvFeed()) {
                return;
            }
            doShareToXHS();
        }
    }

    private Dialog showCustomAlertDialog(String str, String str2, int i3, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (this.owner == null) {
            return null;
        }
        return new com.qzone.component.e().d(this.owner, 230, i3, str, str2, str3, str4, onClickListener, onClickListener2);
    }

    protected void doShareToWeixinCheckedPermission(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        boolean a16 = ShareUtils.a(str3, str4);
        if (i3 == 3) {
            com.qzone.business.share.g.a(this.owner, str2, new i(a16, str, str3, str4, str5, str6), new j());
        } else if (i3 == 1) {
            showPermissionTips(str2);
        } else {
            shareToWx(a16, str, str3, str4, str5, str6);
        }
    }

    protected void handleHideSignleFeedRespone(QZoneTask qZoneTask) {
        String str;
        QZoneResult result = qZoneTask.getResult(1000108);
        try {
            try {
                operation_hide_feeds_rsp operation_hide_feeds_rspVar = (operation_hide_feeds_rsp) qZoneTask.mRequest.rsp;
                if (operation_hide_feeds_rspVar != null) {
                    result.setSucceed(operation_hide_feeds_rspVar.ret == 0);
                    if (operation_hide_feeds_rspVar.ret == 0) {
                        Object parameter = qZoneTask.getParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_KEY);
                        Object parameter2 = qZoneTask.getParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_POSITION);
                        if (parameter == null) {
                            str = "";
                        } else {
                            str = (String) parameter;
                        }
                        EventCenter.getInstance().post("WriteOperation", 38, str, parameter2);
                    } else {
                        QZLog.e(TAG, "handleHideSignleFeedRespone fail, ret=" + operation_hide_feeds_rspVar.ret);
                    }
                } else {
                    result.setSucceed(false);
                    ToastUtil.s(result.getMessage(), 4);
                }
            } catch (Exception e16) {
                result.setSucceed(false);
                QZLog.w("handleHideSignleFeedRespone", e16.toString());
            }
        } finally {
            qZoneTask.sendResultMsg(result);
        }
    }

    protected void getOutShareUrl(int i3) {
        String str;
        String str2;
        String str3;
        int i16;
        int i17;
        BusinessFeedData originalInfo;
        Map<Integer, String> map;
        String str4;
        int i18 = i3;
        if (this.mFeedData == null) {
            QZLog.w(TAG, "mFeedData is null when call getOutShareUrl!");
            return;
        }
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHARE_BATCH_PHOTO_TO_MINIPROGRAM, 1) == 1;
        BusinessFeedData originalInfo2 = this.mFeedData.getOriginalInfo();
        if (originalInfo2 == null || !originalInfo2.isDynamicAlbumFeed() || originalInfo2.getUser() == null || originalInfo2.getUser().uin <= 0) {
            originalInfo2 = this.mFeedData;
        }
        int i19 = originalInfo2.getFeedCommInfo().appid;
        CellIdInfo idInfo = originalInfo2.getIdInfo();
        User user = originalInfo2.getUser();
        String str5 = idInfo != null ? idInfo.cellId : null;
        CellPictureInfo pictureInfo = originalInfo2.getPictureInfo();
        VideoInfo videoInfo = originalInfo2.getVideoInfo();
        if (pictureInfo != null) {
            String str6 = pictureInfo.albumid;
            ArrayList<PictureItem> arrayList = pictureInfo.pics;
            if (arrayList != null && arrayList.size() == 1) {
                if (!originalInfo2.isDynamicAlbumFeed()) {
                    str4 = pictureInfo.pics.get(0).lloc;
                } else {
                    str4 = pictureInfo.actionurl;
                }
                if (i19 == 311) {
                    r16 = 1;
                }
            } else {
                ArrayList<PictureItem> arrayList2 = pictureInfo.pics;
                if (arrayList2 == null || arrayList2.size() <= 1) {
                    r16 = i19 == 311 ? 0 : -1;
                    str = str6;
                    str2 = null;
                } else {
                    str4 = originalInfo2.isDynamicAlbumFeed() ? pictureInfo.actionurl : null;
                    if (i19 == 311) {
                        str2 = str4;
                        str = str6;
                        r16 = 2;
                    }
                }
            }
            str2 = str4;
            str = str6;
        } else {
            if (videoInfo != null) {
                if (originalInfo2.getOperationInfoV2() != null && originalInfo2.getOperationInfoV2().busiParam != null) {
                    str = originalInfo2.getOperationInfoV2().busiParam.get(12);
                    str2 = originalInfo2.getOperationInfoV2().busiParam.get(2);
                }
            } else if (i19 == 311) {
                r16 = 0;
            }
            str = null;
            str2 = null;
        }
        if ((i18 == 1 && !checkOpmask(14)) || ((i18 == 0 && !checkOpmask(13)) || (i18 == 4 && !checkOpmask3(9)))) {
            str3 = "1";
        } else {
            str3 = "";
        }
        if ((i19 == 4 || (i19 == 311 && originalInfo2.isDynamicAlbumFeed())) && i18 == 0 && z16) {
            i18 = 3;
        }
        CellOperationInfo operationInfo = originalInfo2.getOperationInfo();
        String str7 = (operationInfo == null || (map = operationInfo.busiParam) == null) ? null : map.get(21);
        long j3 = user != null ? user.uin : 0L;
        if (originalInfo2.isDynamicAlbumFeed()) {
            r16 = 4;
        }
        if (pictureInfo != null && pictureInfo.pics != null) {
            i16 = 0;
            i17 = 0;
            for (int i26 = 0; i26 < pictureInfo.pics.size(); i26++) {
                if (pictureInfo.pics.get(i26).videoflag == 1) {
                    i16++;
                } else {
                    i17++;
                }
            }
        } else if (!this.mFeedData.isForwardFeed() || (originalInfo = this.mFeedData.getOriginalInfo()) == null || originalInfo.getPictureInfo() == null || originalInfo.getPictureInfo().pics == null) {
            i16 = 0;
            i17 = 0;
        } else {
            CellPictureInfo pictureInfo2 = originalInfo.getPictureInfo();
            i16 = 0;
            i17 = 0;
            for (int i27 = 0; i27 < pictureInfo2.pics.size(); i27++) {
                if (pictureInfo2.pics.get(i27).videoflag == 1) {
                    i16++;
                } else {
                    i17++;
                }
            }
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(11, String.valueOf(i16));
        hashMap.put(10, String.valueOf(i17));
        hashMap.put(14, str3);
        DetailDataOutShare detailDataOutShare = originalInfo2.getOperationInfo().shareData;
        if (detailDataOutShare != null && ShareUtils.k()) {
            String str8 = detailDataOutShare.ark_content;
            if (!TextUtils.isEmpty(str8)) {
                hashMap.put(13, str8);
            }
        }
        OutSiteShareService.a().g(this.mHandler, i19, r16, str5, str, str2, str7, j3, i18, hashMap);
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void toggleFavorite(boolean z16) {
        QZoneFeedUtil.f0(z16 ? 3585 : 3586, this.mFeedData, this.mHandler, new d());
    }

    protected void doShareToQQCheckedPermission(int i3, String str, String str2, String str3, boolean z16, long j3, int i16, String str4, String str5) {
        if (OutSiteShareService.j(i3)) {
            if (!TextUtils.isEmpty(str3)) {
                showPermissionTips(str3);
            } else {
                showPermissionTips(BaseApplication.getContext().getString(R.string.gjn));
            }
            finish();
            return;
        }
        if (i3 != 3) {
            if (i3 == 1) {
                showPermissionTips(str3);
                finish();
                return;
            } else {
                com.qzone.business.share.f.b().g(this.mFeedData, z16, j3, i16, str4, str5).a(this.owner, str, str2);
                return;
            }
        }
        Activity activity = this.owner;
        if (activity != null && !activity.isFinishing()) {
            com.qzone.business.share.g.a(this.owner, str3, new e(str5, str, str2), new f());
        } else {
            QZLog.e(TAG, "owner == null or owner.isFinishing()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements ai {
        c() {
        }

        @Override // com.qzone.common.activities.base.ai
        public String getString(int i3) {
            if (i3 == 1) {
                return BaseApplication.getContext().getString(R.string.f170648xe);
            }
            if (i3 == 2) {
                return BaseApplication.getContext().getString(R.string.f170647xd);
            }
            if (i3 == 3) {
                return BaseApplication.getContext().getString(R.string.ghi);
            }
            if (i3 != 4) {
                return com.qzone.util.l.a(R.string.ruq);
            }
            return BaseApplication.getContext().getString(R.string.gfs);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements com.qzone.feed.utils.e {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements QzoneFavoriteService.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f45301a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f45302b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f45303c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f45304d;

            a(long j3, String str, long j16, long j17) {
                this.f45301a = j3;
                this.f45302b = str;
                this.f45303c = j16;
                this.f45304d = j17;
            }

            @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
            public void a(String str, boolean z16) {
                QzoneFavoriteService.M().I(this.f45301a, str, this.f45302b, this.f45303c, this.f45304d, QZoneFeedOperateLogic.this.mHandler);
            }
        }

        d() {
        }

        @Override // d5.n
        public boolean Lc() {
            return true;
        }

        @Override // d5.n
        public void b9(d5.k<BusinessFeedData> kVar) {
            long a16 = kVar.a();
            String d16 = kVar.d();
            QzoneFavoriteService.M().Q(new a(a16, d16, kVar.getAppId(), kVar.c()), d16);
        }

        @Override // d5.n
        public void F7() {
        }

        @Override // com.qzone.feed.utils.e
        public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
        }
    }

    @Override // com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface
    public void handleHidePersonFeedsCallback(QZoneResult qZoneResult) {
    }

    public void doShareToWeixinUnchecked(String str) {
        String str2;
        String str3;
        ShareUtils.g gVar = new ShareUtils.g();
        ch.a(this.mFeedData);
        DetailDataOutShare detailDataOutShare = this.mFeedData.getOperationInfo().shareData;
        if (detailDataOutShare != null) {
            str2 = TextCellParser.toPlainText(detailDataOutShare.sTitle);
            str3 = TextCellParser.toPlainText(detailDataOutShare.sSummary);
            Map<Integer, PictureUrl> map = detailDataOutShare.mapPhotoUrl;
            if (map != null && map.size() > 0) {
                gVar.f44743d = ch.c(detailDataOutShare.mapPhotoUrl);
            }
        } else {
            str2 = "";
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "m.qzone.com";
        }
        gVar.f44741b = str2;
        gVar.f44742c = str3;
        gVar.f44740a = str;
        ShareUtils.q(this.owner, this.itemTag, gVar);
        if (this.mFeedData.getVideoInfo() != null) {
            if (this.itemTag == 10) {
                ClickReport.r(null, null, null, true, "350", "3", "3");
            } else {
                ClickReport.r(null, null, null, true, "350", "3", "2");
            }
        }
    }

    public void onNewDropMenuClick(int i3, BusinessFeedData businessFeedData, f.a aVar) {
    }
}
