package com.qzone.common.activities.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.detail.ui.component.g;
import com.qzone.feed.utils.AdsFeedbackReporter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lg.q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class cb implements com.qzone.feed.utils.e {
    private static final int P = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_BLOG_SHARE_SHOW_EVERNOTE, 1);
    String C;
    public com.qzone.detail.ui.component.c D;
    public com.qzone.detail.ui.component.g E;
    private long I;
    private int J;
    private String K;
    private String M;

    /* renamed from: d, reason: collision with root package name */
    protected BusinessFeedData f45477d;

    /* renamed from: e, reason: collision with root package name */
    Handler f45478e;

    /* renamed from: f, reason: collision with root package name */
    gf.f f45479f;

    /* renamed from: h, reason: collision with root package name */
    Context f45480h;

    /* renamed from: i, reason: collision with root package name */
    Fragment f45481i;

    /* renamed from: m, reason: collision with root package name */
    boolean f45482m;
    private Dialog F = null;
    private TextView G = null;
    private int H = 0;
    public View L = null;
    private ShareActionSheet.c N = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "share to XHS canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            cb.this.f45479f.U3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements ShareActionSheet.c {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (cb.this.Q(actionSheetItem, view)) {
                shareActionSheet.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            gf.f fVar = cb.this.f45479f;
            if (fVar == null || fVar.X3() == null) {
                return;
            }
            QZoneDetailService X3 = cb.this.f45479f.X3();
            cb cbVar = cb.this;
            X3.l0(cbVar.f45478e, cbVar.f45479f.S6());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45487d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45488e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45489f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45490h;

        e(boolean z16, String str, String str2, String str3) {
            this.f45487d = z16;
            this.f45488e = str;
            this.f45489f = str2;
            this.f45490h = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.qzone.business.share.f c16 = com.qzone.business.share.f.c();
            cb cbVar = cb.this;
            c16.g(cbVar.f45477d, this.f45487d, cbVar.I, cb.this.J, cb.this.K, this.f45488e).a(cb.this.f45479f.getActivity(), this.f45489f, this.f45490h);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45493d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45494e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45495f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45496h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f45497i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f45498m;

        g(boolean z16, String str, String str2, String str3, String str4, String str5) {
            this.f45493d = z16;
            this.f45494e = str;
            this.f45495f = str2;
            this.f45496h = str3;
            this.f45497i = str4;
            this.f45498m = str5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            cb.this.r0(this.f45493d, this.f45494e, this.f45495f, this.f45496h, this.f45497i, this.f45498m);
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
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "share to WeChat canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements Consumer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45500d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45501e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f45502f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f45503h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f45504i;

        i(boolean z16, String str, String str2, String str3, String str4) {
            this.f45500d = z16;
            this.f45501e = str;
            this.f45502f = str2;
            this.f45503h = str3;
            this.f45504i = str4;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            QZLog.d("QZoneSharePanel", 1, "shareToWx result: " + bool);
            if (bool.booleanValue()) {
                return;
            }
            QZLog.d("QZoneSharePanel", 1, "shareToWx result fail, ex", new Throwable());
            if (!this.f45500d) {
                cb.this.A(this.f45501e);
            } else {
                cb.this.B(this.f45501e, this.f45502f, this.f45503h, this.f45504i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements Consumer<q.QZoneQrcodeResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Consumer f45506d;

        j(Consumer consumer) {
            this.f45506d = consumer;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(q.QZoneQrcodeResult qZoneQrcodeResult) {
            if (qZoneQrcodeResult.getIsSuccess()) {
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), qZoneQrcodeResult.getFilePath(), com.qzone.util.image.c.i(qZoneQrcodeResult.getFilePath()), cb.this.H == 9 ? 0 : 1);
            }
            this.f45506d.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f45508d;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements Consumer<Boolean> {
            a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                QZLog.d("QZoneSharePanel", 1, "shareToXHS result: " + bool);
                if (bool.booleanValue()) {
                    return;
                }
                QZLog.d("QZoneSharePanel", 1, "shareToXHS result fail, ex", new Throwable());
            }
        }

        k(String str) {
            this.f45508d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            cb.this.t0(this.f45508d, new a());
        }
    }

    public cb(Context context, Handler handler, gf.f fVar, String str) {
        g.a aVar = new g.a();
        context = context instanceof BasePluginActivity ? ((BasePluginActivity) context).getOutActivity() : context;
        HashMap hashMap = new HashMap();
        aVar.deReportParams = hashMap;
        hashMap.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(GuildSharePageSource.QZONE_FEED_SHARE.ordinal()));
        aVar.context = context;
        com.qzone.detail.ui.component.g gVar = new com.qzone.detail.ui.component.g(aVar);
        this.E = gVar;
        gVar.setActionSheetTitle(context.getString(R.string.hja));
        Intent intent = new Intent();
        intent.putExtra("forward_type", 39);
        this.E.setIntentForStartForwardRecentActivity(intent);
        this.f45478e = handler;
        this.f45479f = fVar;
        J();
        this.M = str;
        try {
            this.D = com.qzone.detail.ui.component.c.a();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f45480h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        String str2;
        String str3;
        ShareUtils.g gVar = new ShareUtils.g();
        ch.a(this.f45477d);
        DetailDataOutShare detailDataOutShare = this.f45477d.getOperationInfo().shareData;
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
        gVar.f44741b = str2;
        gVar.f44742c = str3;
        gVar.f44740a = str;
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneSharePanel", 2, "itemTag: " + this.H);
        }
        ShareUtils.q(this.f45479f.getActivity(), this.H, gVar);
        if (this.f45477d.getVideoInfo() != null) {
            if (this.H == 10) {
                ClickReport.r(null, null, null, true, "350", "3", "3");
            } else {
                ClickReport.r(null, null, null, true, "350", "3", "2");
            }
        }
    }

    private void E() {
        String config;
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData == null) {
            return;
        }
        CellIdInfo idInfo = businessFeedData.getIdInfo();
        if (businessFeedData.isNewHandBlogFeed()) {
            config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_HAND_BLOG_EDIT, "https://h5.qzone.qq.com/platform/picdiary/{cellid}?_wv=16781313&_proxy=1&_wwv=133");
        } else {
            config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BLOG_EDIT, "https://h5.qzone.qq.com/blog/editor2/{cellid}?_wv=4099&_proxy=1&blogid={cellid}");
        }
        yo.d.d(config.replace("{cellid}", idInfo.cellId), this.f45480h, null);
    }

    private boolean K() {
        BusinessFeedData businessFeedData = this.f45477d;
        return businessFeedData != null && businessFeedData.isQCircleShareCardFeed();
    }

    private boolean N() {
        gf.f fVar = this.f45479f;
        if (fVar == null) {
            return false;
        }
        return fVar.j6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(Boolean bool) {
        QZLog.d("QZoneSharePanel", 1, "shareToXHS result: " + bool);
        bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Consumer consumer, q.QZoneQrcodeResult qZoneQrcodeResult) {
        if (qZoneQrcodeResult.getIsSuccess()) {
            com.qzone.business.share.d.f44790a.h(this.f45479f.getActivity(), qZoneQrcodeResult.getFilePath());
        }
        consumer.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
    }

    private void T(String str) {
        if (u(str)) {
            ToastUtil.r(this.f45479f.getResources().getString(R.string.f170930b53));
        }
    }

    private void V() {
        gf.f fVar = this.f45479f;
        if (fVar == null || fVar.X3() == null || this.f45479f.X3().R() == null || this.f45479f.X3().R().getFeedCommInfo() == null) {
            return;
        }
        if (Boolean.valueOf(this.f45479f.X3().R().getFeedCommInfo().isFollowed).booleanValue()) {
            W();
        } else {
            S();
        }
    }

    private void X() {
        gf.f fVar = this.f45479f;
        if (fVar == null || fVar.getWebView() == null) {
            return;
        }
        try {
            this.f45479f.getWebView().callJs(WebViewPlugin.toJsScript("mqq.blogdetail.saveToAlbum", null, null));
            BusinessFeedData businessFeedData = this.f45477d;
            if (businessFeedData != null && businessFeedData.isNewHandBlogFeed()) {
                LpReportInfo_pf00064.allReport(305, 9, 0, "1");
            } else {
                LpReportInfo_pf00064.allReport(305, 9);
            }
        } catch (Exception e16) {
            QZLog.e("QZoneSharePanel", "forward to evernote catch an exception.", e16);
        }
    }

    private void Y() {
        gf.f fVar = this.f45479f;
        if (fVar == null || fVar.getWebView() == null) {
            return;
        }
        try {
            this.f45479f.getWebView().callJs(WebViewPlugin.toJsScript("mqq.blogdetail.shareToEvernote", null, null));
        } catch (Exception e16) {
            QZLog.e("QZoneSharePanel", "forward to evernote catch an exception.", e16);
        }
    }

    private void Z() {
        if (TextUtils.equals("feed", this.M)) {
            ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "3");
        } else if (TextUtils.equals("detail", this.M)) {
            ClickReport.m("302", "53", "3");
        }
        this.H = 2;
        ShareUtils.l();
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData != null) {
            if (businessFeedData.isAdFeeds()) {
                com.qzone.business.share.f.c().d(this.f45477d).a(this.f45479f.getActivity(), this.f45477d.getOperationInfo().qqUrl, QZoneShareManager.QQ_SHARE_APPID);
            } else {
                x();
            }
        }
        h0();
        BusinessFeedData businessFeedData2 = this.f45477d;
        if (businessFeedData2 == null || !businessFeedData2.isAdFeeds()) {
            return;
        }
        t(33);
    }

    private void a0(long j3, int i3, String str) {
        this.I = j3;
        this.J = i3;
        this.K = str;
        if (TextUtils.equals("feed", this.M)) {
            ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "3");
        } else if (TextUtils.equals("detail", this.M)) {
            ClickReport.m("302", "53", "3");
        }
        this.H = 72;
        ShareUtils.l();
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData != null) {
            if (businessFeedData.isAdFeeds()) {
                com.qzone.business.share.f.c().f(this.f45477d, true, j3, i3, str).a(this.f45479f.getActivity(), this.f45477d.getOperationInfo().qqUrl, QZoneShareManager.QQ_SHARE_APPID);
            } else {
                x();
            }
        }
        h0();
        BusinessFeedData businessFeedData2 = this.f45477d;
        if (businessFeedData2 == null || !businessFeedData2.isAdFeeds()) {
            return;
        }
        t(33);
    }

    private void b0() {
        if (this.f45479f != null) {
            QZoneFeedUtil.X(this.f45477d, this.f45481i, this.f45482m, this.C);
        }
        if (TextUtils.equals("feed", this.M)) {
            ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "2");
        } else if (TextUtils.equals("detail", this.M)) {
            ClickReport.m("302", "53", "2");
        }
    }

    private void c0() {
        if (TextUtils.equals("feed", this.M)) {
            ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "4");
        } else if (TextUtils.equals("detail", this.M)) {
            int H = H(this.f45477d);
            if (H != -1) {
                LpReportInfo_pf00064.allReport(302, 53, 4, H + "");
            } else {
                LpReportInfo_pf00064.allReport(302, 53, 4);
            }
        }
        this.H = 9;
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData != null) {
            if (businessFeedData.isAdFeeds()) {
                A(this.f45477d.getOperationInfo().weixinUrl);
            } else {
                z();
            }
        }
        i0();
        BusinessFeedData businessFeedData2 = this.f45477d;
        if (businessFeedData2 == null || !businessFeedData2.isAdFeeds()) {
            return;
        }
        t(34);
    }

    private void d0() {
        if (TextUtils.equals("feed", this.M)) {
            ClickReport.m("302", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "5");
        } else if (TextUtils.equals("detail", this.M)) {
            ClickReport.m("302", "53", "5");
        }
        this.H = 10;
        ShareUtils.u();
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData != null) {
            if (businessFeedData.isAdFeeds()) {
                A(this.f45477d.getOperationInfo().weixinUrl);
            } else {
                z();
            }
        }
        j0();
        BusinessFeedData businessFeedData2 = this.f45477d;
        if (businessFeedData2 == null || !businessFeedData2.isAdFeeds()) {
            return;
        }
        t(35);
    }

    private void f0() {
        ClickReport.m("302", "60", "5");
    }

    private void g0() {
        ClickReport.q("302", "60", "17", true);
    }

    private void h0() {
        ClickReport.m("302", "60", "2");
    }

    private void i(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, View view, boolean z16) {
        int i3 = actionSheetItem.action;
        int i16 = 2;
        if (i3 == 2) {
            i16 = 1;
        } else if (i3 != 3) {
            i16 = i3 != 9 ? i3 != 10 ? i3 != 92 ? i3 != 171 ? i3 != 218 ? 6 : 8 : 7 : 5 : 4 : 3;
        }
        HashMap hashMap = new HashMap();
        VideoReport.setPageId(view.getParent(), "pg_qdesign_shareview");
        hashMap.put("share_source", Integer.valueOf(i16));
        VideoReport.setElementId(view, "em_share_item");
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        if (z16) {
            VideoReport.reportEvent("dt_clck", view, null);
        } else {
            VideoReport.reportEvent("dt_imp", view, null);
        }
    }

    private void i0() {
        ClickReport.m("302", "60", "3");
    }

    private void j0() {
        ClickReport.m("302", "60", "4");
    }

    private void k0() {
        ClickReport.m("302", "60", "6");
    }

    private boolean l(int i3, int i16) {
        int i17;
        BusinessFeedData businessFeedData = this.f45477d;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        if (i16 == 1) {
            i17 = this.f45477d.getFeedCommInfo().operatemask;
        } else {
            i17 = this.f45477d.getFeedCommInfo().operatemask2;
        }
        return ((1 << i3) & i17) != 0;
    }

    private boolean m(int i3, int i16) {
        int i17;
        gf.f fVar = this.f45479f;
        if (fVar == null || fVar.X3() == null || this.f45479f.X3().R() == null || this.f45479f.X3().R().getFeedCommInfo() == null) {
            return false;
        }
        if (i16 == 1) {
            i17 = this.f45479f.X3().R().getFeedCommInfo().operatemask;
        } else {
            i17 = this.f45479f.X3().R().getFeedCommInfo().operatemask2;
        }
        return ((1 << i3) & i17) != 0;
    }

    private boolean o(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.f45477d.getFeedCommInfo().operatemask3, i3);
    }

    private void p() {
        try {
            Dialog dialog = this.F;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.F.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(boolean z16, String str, String str2, String str3, String str4, String str5) {
        if (oo.b.k() && s0(str5, new i(z16, str, str2, str3, str4))) {
            QZLog.d("QZoneSharePanel", 1, "shareToWx use need feed share");
        } else if (z16) {
            B(str, str2, str3, str4);
        } else {
            A(str);
        }
    }

    private boolean s0(String str, Consumer<Boolean> consumer) {
        return new lg.q().j(BaseApplication.getContext(), this.f45477d, str, new j(consumer));
    }

    private boolean u(String str) {
        BusinessFeedData R;
        String str2;
        gf.f fVar = this.f45479f;
        if (fVar == null || fVar.X3() == null || this.f45479f.X3().R() == null || (R = this.f45479f.X3().R()) == null) {
            return false;
        }
        if (R.getRecommAction() != null && R.getRecommAction().reportUrl != null) {
            str2 = R.getRecommAction().reportUrl;
        } else {
            str2 = "";
        }
        if (R.getActiveAdv() != null && R.getActiveAdv().reportUrl != null) {
            str2 = R.getActiveAdv().reportUrl;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        AdsFeedbackReporter.report(str2 + str);
        return true;
    }

    private void v0(String str) {
        ToastUtil.r(str);
    }

    private void w(int i3, String str, String str2, String str3, boolean z16, String str4) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        if (i3 == 3) {
            com.qzone.business.share.g.a(this.f45479f.getActivity(), str3, new e(z16, str4, str, str2), new f());
        } else if (i3 == 1) {
            v0(str3);
        } else {
            com.qzone.business.share.f.c().g(this.f45477d, z16, this.I, this.J, this.K, str4).a(this.f45479f.getActivity(), str, str2);
        }
    }

    private void w0(String str) {
        Dialog dialog = this.F;
        if (dialog == null || !dialog.isShowing()) {
            if (this.F == null) {
                ReportDialog reportDialog = new ReportDialog(this.f45480h, R.style.f174269ui);
                this.F = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.G = (TextView) this.F.findViewById(R.id.dialogText);
                this.F.findViewById(R.id.kja).setVisibility(8);
                this.F.findViewById(R.id.cib).setVisibility(0);
            }
            this.G.setText(str);
            this.F.show();
        }
    }

    private void x() {
        if (K()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotToShare", "\u6682\u4e0d\u53ef\u5206\u4eab"), 3);
        } else {
            G(1);
            w0(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
        }
    }

    private void y0() {
        yo.d.l(this.f45479f.getActivity(), QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MOOD_EDIT, "https://h5.qzone.qq.com/mood/editor/{tid}/moodEditor?tid={tid}&uin={uin}&hostuin={hostuin}&_wv=3").replace("{tid}", this.f45479f.X3().R().getIdInfo().cellId).replace("{uin}", LoginData.getInstance().getUinString()).replace("{hostuin}", LoginData.getInstance().getUinString()), 21, "");
    }

    public void A0() {
        ShareActionSheetBuilder.ActionSheetItem build;
        SpannableString spannableString = new SpannableString(this.f45479f.getString(F()));
        Drawable drawable = this.f45479f.getResources().getDrawable(R.drawable.gjz);
        drawable.setBounds(0, 0, ScreenUtil.dip2px(12.0f), ScreenUtil.dip2px(12.0f));
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        if (spannableString.length() >= 1 && spannableString.charAt(spannableString.length() - 1) == '@') {
            spannableString.setSpan(imageSpan, spannableString.length() - 1, spannableString.length(), 33);
        }
        if (N()) {
            build = ShareActionSheetBuilder.ActionSheetItem.build(97);
            this.E.r0(96, build);
        } else {
            build = ShareActionSheetBuilder.ActionSheetItem.build(96);
            this.E.q0(97, 96);
        }
        if (build != null) {
            build.label = spannableString.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0128, code lost:
    
        if (r1 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012d, code lost:
    
        r3 = "\u5206\u4eab\u7ed9\u4f601\u4e2a\u89c6\u9891";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012b, code lost:
    
        if (r6 != null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        ArrayList<PictureItem> arrayList;
        ShareUtils.g gVar = new ShareUtils.g();
        ch.a(this.f45477d);
        DetailDataOutShare detailDataOutShare = this.f45477d.getOperationInfo().shareData;
        if (detailDataOutShare == null) {
            str5 = "";
            str6 = str5;
        } else {
            str5 = TextCellParser.toPlainText(detailDataOutShare.sTitle);
            str6 = TextCellParser.toPlainText(detailDataOutShare.sSummary);
            Map<Integer, PictureUrl> map = detailDataOutShare.mapPhotoUrl;
            if (map != null && map.size() > 0) {
                gVar.f44743d = ch.c(detailDataOutShare.mapPhotoUrl);
            }
        }
        if (this.f45477d.isDynamicAlbumFeed() && this.f45477d.getPictureInfo() != null && this.f45477d.getPictureInfo().pics != null && this.f45477d.getPictureInfo().pics.size() > 0) {
            gVar.f44743d = this.f45477d.getPictureInfo().pics.get(0).currentUrl.url;
        }
        if (TextUtils.isEmpty(str6)) {
            str6 = "m.qzone.com";
        }
        CellPictureInfo pictureInfo = this.f45477d.getPictureInfo();
        VideoInfo videoInfo = this.f45477d.getVideoInfo();
        if (pictureInfo != null) {
            str5 = com.qzone.util.l.a(R.string.s89) + pictureInfo.uploadnum + com.qzone.util.l.a(R.string.s95);
            if (this.f45477d.isForwardFeed() && (arrayList = pictureInfo.pics) != null && arrayList.size() > 0) {
                gVar.f44743d = pictureInfo.pics.get(0).currentUrl.url;
            }
        } else if (this.f45477d.isForwardFeed()) {
            BusinessFeedData originalInfo = this.f45477d.getOriginalInfo();
            if (originalInfo != null) {
                CellPictureInfo pictureInfo2 = originalInfo.getPictureInfo();
                VideoInfo videoInfo2 = originalInfo.getVideoInfo();
                if (pictureInfo2 != null) {
                    String str7 = com.qzone.util.l.a(R.string.s8r) + pictureInfo2.uploadnum + com.qzone.util.l.a(R.string.f172578s91);
                    ArrayList<PictureItem> arrayList2 = pictureInfo2.pics;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        gVar.f44743d = pictureInfo2.pics.get(0).currentUrl.url;
                    }
                    str5 = str7;
                }
            }
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = str5;
        }
        gVar.f44741b = str4;
        gVar.f44742c = str6;
        gVar.f44740a = str;
        gVar.f44744e = str2;
        gVar.f44745f = str3;
        gVar.f44746g = "";
        ShareUtils.r(this.f45479f.getActivity(), this.H, gVar, 1);
    }

    protected void D(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        if (i3 == 3) {
            com.qzone.business.share.g.a(this.f45479f.getActivity(), str2, new k(str6), new a());
        } else if (i3 == 1) {
            v0(str2);
        } else {
            t0(str6, new Consumer() { // from class: com.qzone.common.activities.base.bz
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    cb.O((Boolean) obj);
                }
            });
        }
    }

    public int F() {
        return N() ? R.string.ga8 : R.string.f172985ga4;
    }

    @Override // d5.n
    public void F7() {
        if (this.E != null) {
            z0();
        }
    }

    public void I(QZoneResult qZoneResult) {
        p();
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                QZLog.e("[PhotoAlbum]shareOutSide", "QZoneSharePanel data == null");
                return;
            }
            String string = bundle.getString("url");
            String string2 = bundle.getString("msg");
            String string3 = bundle.getString("mini_id");
            String string4 = bundle.getString("mini_path");
            String string5 = bundle.getString("mini_title", "");
            String string6 = bundle.getString("ark_content", "");
            String string7 = bundle.getString("short_url");
            Integer valueOf = Integer.valueOf(bundle.getInt("iShareOutType"));
            QZLog.d("[PhotoAlbum]shareOutSide", 1, "QZoneSharePanel", " handleGetShareUrl rsp:", bundle.toString());
            int i3 = this.H;
            if (i3 == 2) {
                v(valueOf.intValue(), string, QZoneShareManager.QQ_SHARE_APPID, string2, string6);
                return;
            }
            if (i3 == 72) {
                w(valueOf.intValue(), string, QZoneShareManager.QQ_SHARE_APPID, string2, true, string6);
                return;
            }
            if (i3 == 9 || i3 == 10) {
                y(valueOf.intValue(), string, string2, string3, string4, string5, string7);
                return;
            } else {
                if (i3 == 218) {
                    D(valueOf.intValue(), string, string2, string3, string4, string5, string7);
                    return;
                }
                return;
            }
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25"), 4);
    }

    public void J() {
        com.qzone.detail.ui.component.g gVar = this.E;
        if (gVar != null) {
            gVar.setItemClickListenerV3(this.N);
        }
    }

    protected boolean L() {
        BusinessFeedData businessFeedData = this.f45477d;
        return businessFeedData == null || businessFeedData.getUser() == null || this.f45477d.getUser().uin != LoginData.getInstance().getUin();
    }

    @Override // d5.n
    public boolean Lc() {
        return false;
    }

    public boolean M() {
        com.qzone.detail.ui.component.g gVar = this.E;
        return gVar != null && gVar.isShowing();
    }

    protected boolean Q(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, View view) {
        BusinessFeedData businessFeedData;
        if (com.qzone.util.h.a()) {
            return false;
        }
        if (actionSheetItem == null) {
            RFWLog.d("QZoneSharePanel", RFWLog.USR, "onHandleMenuItemClick: item is null, return");
            return false;
        }
        if (!actionSheetItem.enable) {
            RFWLog.d("QZoneSharePanel", RFWLog.USR, "onHandleMenuItemClick: item is disable, return");
            return false;
        }
        int i3 = actionSheetItem.action;
        gf.f fVar = this.f45479f;
        if (fVar != null) {
            fVar.w9(i3);
        }
        i(actionSheetItem, view, true);
        if ((i3 == 2 || i3 == 73 || i3 == 9 || i3 == 10) && (businessFeedData = this.f45477d) != null && businessFeedData.getVideoInfo() != null && (this.f45477d.getVideoInfo().videoStatus == 7 || this.f45477d.getVideoInfo().videoStatus == 4)) {
            if (this.f45477d.getPermissionInfoV2() != null && !com.qzone.util.am.h(this.f45477d.getPermissionInfoV2().permission_tips)) {
                ToastUtil.s(this.f45477d.getPermissionInfoV2().permission_tips, 4);
            } else {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotToShare", "\u6682\u4e0d\u53ef\u5206\u4eab"));
            }
            return true;
        }
        this.I = 0L;
        this.J = 0;
        this.K = null;
        if (i3 != 2) {
            if (i3 == 3) {
                b0();
            } else if (i3 == 9) {
                c0();
            } else if (i3 != 10) {
                if (i3 == 26) {
                    actionSheetItem.uin = AppConstants.DATALINE_NEW_VERSION_UIN;
                    actionSheetItem.label = BaseApplication.getContext().getString(R.string.f187533u9);
                } else if (i3 == 39) {
                    X();
                } else if (i3 == 91) {
                    Y();
                } else if (i3 != 72) {
                    if (i3 != 73) {
                        R(i3);
                    }
                }
                a0(Long.parseLong(actionSheetItem.uin), actionSheetItem.uinType, actionSheetItem.label);
            } else {
                d0();
            }
            return true;
        }
        Z();
        return true;
    }

    public void S() {
        if (this.f45479f.T0() == null || this.f45479f.T0().R() == null) {
            return;
        }
        s(this.f45479f.T0().R(), false);
    }

    public void U() {
        String S6;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(this.f45479f.getString(R.string.ci5));
        }
        if (!N() && !LoginData.getInstance().isQzoneVip()) {
            new com.qzone.component.e().f(this.f45479f.getActivity(), 230, null, this.f45479f.getString(R.string.gg5), this.f45479f.getString(R.string.gi_), this.f45479f.getString(R.string.cancel), new b(), null);
            return;
        }
        QZoneDetailService U = QZoneDetailService.U();
        if (!TextUtils.isEmpty(this.f45479f.getFeedId())) {
            S6 = this.f45479f.getFeedId();
        } else {
            S6 = this.f45479f.S6();
        }
        U.D0(S6, N(), !TextUtils.isEmpty(this.f45479f.getFeedId()) ? 2 : 0, this.f45479f.getHandler());
    }

    public void W() {
        if (this.f45479f.T0() == null || this.f45479f.T0().R() == null) {
            return;
        }
        s(this.f45479f.T0().R(), false);
    }

    public void j() {
        ShareActionSheetBuilder.ActionSheetItem build;
        if (this.f45479f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        boolean z16 = false;
        if (!n(1) && !n(2)) {
            build2.enable = false;
        } else {
            build2.enable = true;
        }
        arrayList.add(build2);
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(2);
        if (n(14)) {
            build3.enable = true;
        } else {
            build3.enable = false;
        }
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        if (n(13)) {
            build4.enable = true;
            build5.enable = true;
        } else {
            build4.enable = false;
            build5.enable = false;
        }
        arrayList.add(build4);
        arrayList.add(build5);
        gf.f fVar = this.f45479f;
        if (fVar != null && fVar.I1() && P == 1 && k(29, 2)) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(91));
        }
        if (k(7, 1) && L()) {
            if (this.f45477d.getFeedCommInfo().appid == 2) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(101));
            } else {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(100));
            }
        }
        if (com.qzone.reborn.configx.g.f53821a.b().p1()) {
            ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(218);
            if (o(9)) {
                build6.enable = true;
            } else {
                build6.enable = false;
            }
            arrayList.add(build6);
        }
        if (o(2)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(92));
        }
        if (!this.f45477d.isAdFeeds() && ((this.f45477d.getVideoInfo() == null || this.f45477d.getVideoInfo().isVideoUrlIntact()) && QZoneFeedUtil.k(this.f45477d, 17))) {
            if (this.f45479f.isFavorite()) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(84));
            } else {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
            }
        }
        if (this.f45477d.isNewHandBlogFeed() && k(30, 2)) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        } else {
            gf.f fVar2 = this.f45479f;
            if (fVar2 != null && fVar2.I1()) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
            }
        }
        if (this.f45477d.isAdFeeds()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
        } else if (!L()) {
            if (k(10, 1)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
            }
            if ((this.f45479f.getAppid() == 311 || this.f45479f.I1()) && k(9, 1)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(94));
            }
            if ((this.f45479f.getAppid() == 311 || this.f45479f.I1()) && k(27, 2) && this.f45477d.getPermissionInfo().permission_visit != 3) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(95));
            }
            if (lg.r.f414520a.d(this.f45477d) && (this.f45479f.getRefer() == 2 || this.f45479f.getRefer() == 0)) {
                if (N()) {
                    build = ShareActionSheetBuilder.ActionSheetItem.build(97);
                } else {
                    build = ShareActionSheetBuilder.ActionSheetItem.build(96);
                }
                String str = build.label;
                SpannableString spannableString = new SpannableString(str);
                Drawable drawable = this.f45479f.getResources().getDrawable(R.drawable.gjz);
                drawable.setBounds(0, 0, ScreenUtil.dip2px(12.0f), ScreenUtil.dip2px(12.0f));
                ImageSpan imageSpan = new ImageSpan(drawable, 1);
                if (spannableString.length() >= 1 && spannableString.charAt(spannableString.length() - 1) == '@') {
                    spannableString.setSpan(imageSpan, spannableString.length() - 1, spannableString.length(), 33);
                }
                build.label = str;
                arrayList2.add(build);
            }
            if (k(4, 2) && !this.f45479f.I1()) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(98));
            }
        } else {
            boolean z17 = this.f45479f.getRefer() == 0 && k(24, 1) && !this.f45477d.isBrandUgcAdvFeeds();
            if (k(5, 2) && !this.f45479f.I1()) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(99));
            }
            if (z17) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(141));
            }
            if (this.f45479f.getRefer() == 0 && k(25, 1) && !this.f45477d.isBrandUgcAdvFeeds()) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(86));
            }
            if (k(20, 1) || k(27, 1)) {
                gf.f fVar3 = this.f45479f;
                if (fVar3 != null && fVar3.X3() != null && this.f45479f.X3().R() != null) {
                    z16 = this.f45479f.X3().R().getFeedCommInfo().isFollowed;
                }
                if (z16) {
                    arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(32));
                } else {
                    arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(87));
                }
            }
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        this.E.setActionSheetItems(arrayList, arrayList2);
    }

    public boolean k(int i3, int i16) {
        gf.f fVar = this.f45479f;
        if (fVar != null && fVar.I1()) {
            return l(i3, i16);
        }
        return m(i3, i16);
    }

    public void l0(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            BusinessFeedData businessFeedData = this.f45477d;
            if (businessFeedData == null || businessFeedData.getOperationInfo() == null || this.f45477d.getOperationInfo().shareData == null) {
                return;
            }
            if (jSONObject.has("jce_ark_content")) {
                if (jSONObject.getJSONObject("jce_ark_content").has(PublicAccountMessageUtilImpl.META_NAME)) {
                    this.f45477d.getOperationInfo().shareData.ark_content = jSONObject.getJSONObject("jce_ark_content").getJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString();
                } else {
                    this.f45477d.getOperationInfo().shareData.ark_content = jSONObject.getJSONObject("jce_ark_content").toString();
                }
            }
            if (jSONObject.has("jce_view_id")) {
                this.f45477d.getOperationInfo().shareData.view_id = jSONObject.getString("jce_view_id");
            }
            if (jSONObject.has("jce_ark_id")) {
                this.f45477d.getOperationInfo().shareData.ark_id = jSONObject.getString("jce_ark_id");
            }
        } catch (JSONException e16) {
            QZLog.e("viewId", "update ark share data", e16);
        }
    }

    public void m0(BusinessFeedData businessFeedData) {
        this.f45477d = businessFeedData;
    }

    public void n0(Boolean bool) {
        if (bool.booleanValue()) {
            this.E.q0(87, 32);
        } else {
            this.E.q0(32, 87);
        }
    }

    public void o0(Fragment fragment) {
        this.f45481i = fragment;
    }

    public void p0(String str) {
        this.C = str;
    }

    public void q() {
        com.qzone.detail.ui.component.g gVar = this.E;
        if (gVar != null) {
            gVar.setItemClickListenerV2(null);
            this.E = null;
        }
    }

    public void q0(boolean z16) {
        this.f45482m = z16;
    }

    public void r() {
        com.qzone.detail.ui.component.g gVar = this.E;
        if (gVar == null || !gVar.isShowing()) {
            return;
        }
        try {
            this.E.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void t0(String str, final Consumer<Boolean> consumer) {
        new lg.q().k(BaseApplication.getContext(), this.f45477d, str, new Consumer() { // from class: com.qzone.common.activities.base.ca
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                cb.this.P(consumer, (q.QZoneQrcodeResult) obj);
            }
        }, false);
    }

    public void u0(BusinessFeedData businessFeedData) {
        try {
            if (this.E.isShowing()) {
                return;
            }
            if (businessFeedData != null) {
                this.E.setRowVisibility(0, 0, 0);
            }
            this.E.show();
        } catch (Exception e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "QZoneShareActionSheet show error", e16);
        }
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
        gf.f fVar = this.f45479f;
        if (fVar != null) {
            fVar.x0(aVar, serializable, parcelable, map);
        }
    }

    public void z0() {
        if (this.f45479f.isFavorite()) {
            this.E.q0(6, 84);
        } else {
            this.E.q0(84, 6);
        }
    }

    private void C() {
        G(4);
        w0(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u52a0\u8f7d\u4e2d"));
    }

    private void z() {
        G(0);
        w0(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private void G(int i3) {
        String str;
        CellOperationInfo operationInfoV2;
        Map<Integer, String> map;
        String str2;
        String str3;
        String str4;
        Map<Integer, String> map2;
        int i16;
        int i17;
        BusinessFeedData originalInfo;
        Map<Integer, String> map3;
        String str5;
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHARE_BATCH_PHOTO_TO_MINIPROGRAM, 1) == 1;
        BusinessFeedData originalInfo2 = this.f45477d.getOriginalInfo();
        BusinessFeedData businessFeedData = (originalInfo2 == null || !originalInfo2.isDynamicAlbumFeed() || originalInfo2.getUser() == null || originalInfo2.getUser().uin <= 0) ? this.f45477d : originalInfo2;
        if (businessFeedData == null) {
            RFWLog.e("QZoneSharePanel", RFWLog.USR, "[getOutShareUrl] feedData is null, return");
            return;
        }
        int i18 = businessFeedData.getFeedCommInfo().appid;
        CellIdInfo idInfo = businessFeedData.getIdInfo();
        String str6 = idInfo != null ? idInfo.cellId : null;
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (pictureInfo == null && originalInfo2 != null && originalInfo2.getPictureInfo() != null && i3 == 0) {
            pictureInfo = originalInfo2.getPictureInfo();
        }
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        VideoInfo videoInfo2 = (businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getVideoInfo() == null) ? null : businessFeedData.getOriginalInfo().getVideoInfo();
        if (pictureInfo != null) {
            str = pictureInfo.albumid;
            ArrayList<PictureItem> arrayList = pictureInfo.pics;
            if (arrayList != null && arrayList.size() == 1) {
                if (!businessFeedData.isDynamicAlbumFeed()) {
                    str5 = pictureInfo.pics.get(0).lloc;
                } else {
                    str5 = pictureInfo.actionurl;
                }
                if (i18 == 311) {
                    r2 = 1;
                    str2 = str5;
                }
            } else {
                ArrayList<PictureItem> arrayList2 = pictureInfo.pics;
                if (arrayList2 == null || arrayList2.size() <= 1) {
                    r2 = i18 != 311 ? -1 : 0;
                    str2 = null;
                } else {
                    str5 = businessFeedData.isDynamicAlbumFeed() ? pictureInfo.actionurl : null;
                    if (i18 == 311) {
                        str2 = str5;
                        r2 = 2;
                    }
                }
            }
            r2 = -1;
            str2 = str5;
        } else {
            if (i18 == 311) {
                str = null;
            } else if (videoInfo != null) {
                CellOperationInfo operationInfoV22 = businessFeedData.getOperationInfoV2();
                if (operationInfoV22 == null || (map2 = operationInfoV22.busiParam) == null) {
                    str3 = null;
                    str4 = null;
                } else {
                    str3 = map2.get(12);
                    str4 = operationInfoV22.busiParam.get(2);
                }
                String str7 = str4;
                str = str3;
                r2 = -1;
                str2 = str7;
            } else if (videoInfo2 == null || (operationInfoV2 = businessFeedData.getOriginalInfo().getOperationInfoV2()) == null || (map = operationInfoV2.busiParam) == null) {
                str = null;
                r2 = -1;
            } else {
                str = map.get(12);
                str2 = operationInfoV2.busiParam.get(2);
                r2 = -1;
            }
            str2 = str;
        }
        int i19 = ((i18 == 4 || (i18 == 311 && businessFeedData.isDynamicAlbumFeed())) && i3 == 0 && z16) ? 3 : i3;
        CellOperationInfo operationInfo = businessFeedData.getOperationInfo();
        String str8 = (operationInfo == null || (map3 = operationInfo.busiParam) == null) ? null : map3.get(21);
        User user = businessFeedData.getUser();
        long j3 = user != null ? user.uin : 0L;
        if (businessFeedData.isDynamicAlbumFeed()) {
            r2 = 4;
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
        } else if (!this.f45477d.isForwardFeed() || (originalInfo = this.f45477d.getOriginalInfo()) == null || originalInfo.getPictureInfo() == null || originalInfo.getPictureInfo().pics == null) {
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
        DetailDataOutShare detailDataOutShare = businessFeedData.getOperationInfo() != null ? businessFeedData.getOperationInfo().shareData : null;
        if (detailDataOutShare != null && ShareUtils.k()) {
            String str9 = detailDataOutShare.ark_content;
            if (!TextUtils.isEmpty(str9)) {
                hashMap.put(13, str9);
            }
        }
        OutSiteShareService.a().g(this.f45478e, i18, r2, str6, str, str2, str8, j3, i19, hashMap);
    }

    private void e0() {
        this.H = 218;
        if (this.f45477d != null) {
            C();
        }
    }

    private void t(int i3) {
        if (this.f45477d == null) {
            return;
        }
        QZoneWriteOperationService.v0().L(this.f45477d.getOperationInfo().cookie, i3, 0, 0, 0, 0, true, false, null, null, 0L, false, false, null, false, this.f45477d);
    }

    private int H(BusinessFeedData businessFeedData) {
        BusinessFeedData originalInfo;
        int i3 = -1;
        if (businessFeedData == null) {
            return -1;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 4) {
            i3 = businessFeedData.isForwardFeed() ? 3 : 1;
        }
        if (businessFeedData.isForwardFeed() && businessFeedData.getPictureInfo() == null && (originalInfo = businessFeedData.getOriginalInfo()) != null && originalInfo.getFeedCommInfo() != null && originalInfo.getFeedCommInfo().appid == 4) {
            return 2;
        }
        return i3;
    }

    private void y(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        boolean a16 = ShareUtils.a(str3, str4);
        if (i3 == 3) {
            com.qzone.business.share.g.a(this.f45479f.getActivity(), str2, new g(a16, str, str3, str4, str5, str6), new h());
        } else if (i3 == 1) {
            v0(str2);
        } else {
            r0(a16, str, str3, str4, str5, str6);
        }
    }

    private void R(int i3) {
        User user;
        long uin;
        String str;
        if (94 == i3) {
            if (this.f45479f.I1()) {
                if (com.qzone.proxy.feedcomponent.util.d.j(this.f45477d.getFeedCommInfo().operatemask, 9)) {
                    E();
                    return;
                } else {
                    ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotToEdit", "\u8be5\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u7f16\u8f91"));
                    return;
                }
            }
            if ((this.f45479f.getAppid() == 311 || this.f45479f.getAppid() == 6100 || this.f45479f.I1()) && com.qzone.proxy.feedcomponent.util.d.j(this.f45479f.X3().R().getFeedCommInfo().operatemask, 9)) {
                y0();
                return;
            } else {
                ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToEdit", "\u8be5\u8bf4\u8bf4\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u7f16\u8f91"));
                return;
            }
        }
        if (40 == i3) {
            if (this.f45479f.getAppid() == 2) {
                this.f45479f.a7();
                return;
            } else {
                this.f45479f.m1();
                return;
            }
        }
        if (141 == i3) {
            if (!NetworkState.isNetSupport()) {
                ToastUtil.n(R.string.ghi);
                return;
            }
            gf.f fVar = this.f45479f;
            if (fVar == null || fVar.X3() == null) {
                return;
            }
            this.f45479f.X3().R();
            new com.qzone.component.e().f(this.f45480h, 230, BaseApplication.getContext().getString(R.string.gfs), "", this.f45479f.getString(R.string.f170648xe), this.f45479f.getString(R.string.f170647xd), new d(), null);
            return;
        }
        if (86 == i3) {
            if (!NetworkState.isNetSupport()) {
                ToastUtil.n(R.string.ghi);
                return;
            }
            gf.f fVar2 = this.f45479f;
            if (fVar2 != null) {
                uin = fVar2.getUin();
            } else {
                uin = LoginData.getInstance().getUin();
            }
            z5.a f16 = z5.a.f();
            x6.a g16 = f16 != null ? f16.g(uin) : null;
            if (g16 == null) {
                str = "";
            } else {
                str = g16.name;
            }
            a8.b.O().H(LoginData.getInstance().getUin(), new a8.a(uin, str), this.f45478e);
            if (this.f45477d.getFeedCommInfo() == null || !this.f45477d.getFeedCommInfo().isLikeRecommFamousFeed()) {
                return;
            }
            ClickReport.c(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER, 3, "", true, new String[0]);
            return;
        }
        if (101 == i3 || 100 == i3) {
            gf.f fVar3 = this.f45479f;
            if (fVar3 != null) {
                int appid = fVar3.getAppid();
                if (appid != 2) {
                    if (appid == 4 || appid == 311) {
                        BusinessFeedData S = this.f45479f.X3().S();
                        QZoneFeedUtil.c0(this.f45480h, (CellPictureInfo) com.qzone.proxy.feedcomponent.util.d.m(S).first, S.getUser(), this.f45479f.getAppid(), S.getIdInfo(), this.f45479f.Z4(), 3);
                        return;
                    }
                    return;
                }
                if (this.f45479f.X3() != null) {
                    BusinessFeedData businessFeedData = this.f45477d;
                    if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                        QZoneDetailService X3 = this.f45479f.X3();
                        BusinessFeedData businessFeedData2 = this.f45477d;
                        X3.A0(businessFeedData2, businessFeedData2.getFeedCommInfo().ugckey);
                    }
                    QZoneFeedUtil.q(this.f45479f.X3().S(), "", 7, null, null, this.f45478e, false);
                    return;
                }
                return;
            }
            return;
        }
        if (11 == i3) {
            BusinessFeedData businessFeedData3 = this.f45477d;
            if (businessFeedData3 != null && businessFeedData3.isAdFeeds()) {
                u("2207");
            }
            BusinessFeedData R = this.f45479f.X3().R();
            com.tencent.mobileqq.dt.api.b c16 = com.qzone.feed.utils.f.c();
            com.qzone.feed.utils.f.b(c16, R);
            com.qzone.feed.utils.f.a(this.f45479f.getActivity(), c16);
            return;
        }
        if (92 == i3) {
            BusinessFeedData businessFeedData4 = this.f45477d;
            if (businessFeedData4 == null || (user = businessFeedData4.getUser()) == null) {
                return;
            }
            MiniChatActivity.S2(this.f45479f.getActivity(), 0, String.valueOf(user.uin), user.nickName, false, 1);
            return;
        }
        if (32 == i3 || 87 == i3) {
            V();
            return;
        }
        if (97 == i3 || 96 == i3) {
            U();
            return;
        }
        if (44 == i3) {
            T("2001");
            return;
        }
        if (6 == i3 || 84 == i3) {
            if (!QZoneFeedUtil.k(this.f45477d, 17)) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupportToCollect", "\u8be5\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u6536\u85cf"), 4);
                return;
            }
            gf.f fVar4 = this.f45479f;
            if (fVar4 != null) {
                if (fVar4.isFavorite()) {
                    k0();
                    this.f45479f.m7(3586);
                    return;
                } else {
                    f0();
                    this.f45479f.m7(3585);
                    return;
                }
            }
            return;
        }
        if (98 == i3) {
            g0();
            vo.c.q(this.f45479f.getActivity(), "feedsdetails", LoginData.getInstance().getUin());
            return;
        }
        if (99 == i3) {
            LpReportInfo_pf00064.report(129, 5);
            vo.c.E(this.f45479f.getActivity(), this.f45477d.getUser().uin, "default");
            return;
        }
        if (218 == i3) {
            e0();
            return;
        }
        if (87 != i3 && 95 == i3) {
            if (!NetworkState.isNetSupport()) {
                ToastUtil.n(R.string.ghi);
                return;
            }
            gf.f fVar5 = this.f45479f;
            if (fVar5 != null) {
                fVar5.n1(this.f45477d);
            }
        }
    }

    protected void s(BusinessFeedData businessFeedData, boolean z16) {
        String str;
        String str2;
        if (businessFeedData == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        try {
            if (z16) {
                BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
                QZoneWriteOperationService.v0().p0(originalInfo.getUser().uin, !originalInfo.getFeedCommInfo().isFollowed, 10, this.f45479f.getHandler(), originalInfo.getFeedCommInfo().feedskey, 0, originalInfo.getFeedCommInfo().needAdvReport(), originalInfo.getOperationInfo().cookie, originalInfo.getFeedCommInfo().isInstalled, businessFeedData, z16, 2);
                if (!originalInfo.getFeedCommInfo().isFollowed) {
                    str2 = "2";
                } else {
                    str2 = "3";
                }
                ClickReport.q("462", str2, "1", true);
            } else {
                QZoneWriteOperationService.v0().p0(businessFeedData.getUser().uin, !businessFeedData.getFeedCommInfo().isFollowed, 2, this.f45479f.getHandler(), businessFeedData.getFeedCommInfo().feedskey, 0, businessFeedData.getFeedCommInfo().needAdvReport(), businessFeedData.getOperationInfo().cookie, businessFeedData.getFeedCommInfo().isInstalled, businessFeedData, z16, 2);
                if (businessFeedData.getFeedCommInfo().isFollowed) {
                    str = "4";
                } else {
                    str = "5";
                }
                ClickReport.d(1002, "2", "2", str, true);
            }
        } catch (Exception e16) {
            ToastUtil.n(R.string.bbd);
            QZLog.e("QZoneSharePanel", "\u5173\u6ce8/\u53d6\u6d88\u5173\u6ce8\u5931\u8d25", e16);
            ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(e16, "doFollowFamous failue");
        }
    }

    private boolean n(int i3) {
        if (i3 == 25) {
            return true;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(this.f45477d.getFeedCommInfo().operatemask, i3);
    }

    private void v(int i3, String str, String str2, String str3, String str4) {
        w(i3, str, str2, str3, false, str4);
    }

    @Override // d5.n
    public void b9(d5.k<BusinessFeedData> kVar) {
    }
}
