package com.qzone.misc.web;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.detail.ui.component.ShareStyleChooserController;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.ToastUtil;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFamousShareHandler {

    /* renamed from: a, reason: collision with root package name */
    private com.qzone.detail.ui.component.a f48592a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f48593b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f48594c;

    /* renamed from: d, reason: collision with root package name */
    private String f48595d;

    /* renamed from: e, reason: collision with root package name */
    private ShareStyleChooserController f48596e;

    /* renamed from: f, reason: collision with root package name */
    private int f48597f = -1;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f48598g = new a();

    /* renamed from: h, reason: collision with root package name */
    private int f48599h = 1;

    /* renamed from: i, reason: collision with root package name */
    private Handler f48600i = new f();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFamousShareHandler.this.f48592a != null && QZoneFamousShareHandler.this.f48592a.i()) {
                try {
                    QZoneFamousShareHandler.this.f48592a.d();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            QZoneFamousShareHandler.this.f48597f = -1;
            if (view != null) {
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = ((ShareActionSheetBuilder.c) view.getTag()).f307311e;
                int i3 = actionSheetItem == null ? 0 : actionSheetItem.action;
                QZoneFamousShareHandler.this.f48597f = i3;
                if (i3 == 2) {
                    LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(308, 78, 3);
                    if (QZoneFamousShareHandler.this.f48596e == null || QZoneFamousShareHandler.this.f48596e.g() != 1) {
                        QZoneFamousShareHandler.D(QZoneFamousShareHandler.this.f48593b, QZoneFamousShareHandler.this.f48594c);
                        lpReportInfo_pf00064.reserves3 = "1";
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
                    } else {
                        QZoneFamousShareHandler.this.z();
                        lpReportInfo_pf00064.reserves3 = "2";
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
                    }
                } else if (i3 != 3) {
                    switch (i3) {
                        case 9:
                            LpReportInfo_pf00064 lpReportInfo_pf000642 = new LpReportInfo_pf00064(308, 78, 4);
                            if (QZoneFamousShareHandler.this.f48596e == null || QZoneFamousShareHandler.this.f48596e.g() != 1) {
                                QZoneFamousShareHandler.F(QZoneFamousShareHandler.this.f48593b, QZoneFamousShareHandler.this.f48594c);
                                lpReportInfo_pf000642.reserves3 = "1";
                                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000642, false, false);
                                break;
                            } else {
                                QZoneFamousShareHandler.this.B();
                                lpReportInfo_pf000642.reserves3 = "2";
                                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000642, false, false);
                                break;
                            }
                        case 10:
                            LpReportInfo_pf00064 lpReportInfo_pf000643 = new LpReportInfo_pf00064(308, 78, 5);
                            if (QZoneFamousShareHandler.this.f48596e == null || QZoneFamousShareHandler.this.f48596e.g() != 1) {
                                QZoneFamousShareHandler.G(QZoneFamousShareHandler.this.f48593b, QZoneFamousShareHandler.this.f48594c);
                                lpReportInfo_pf000643.reserves3 = "1";
                                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000643, false, false);
                                break;
                            } else {
                                QZoneFamousShareHandler.this.C();
                                lpReportInfo_pf000643.reserves3 = "2";
                                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000643, false, false);
                                break;
                            }
                        case 11:
                            QZoneFamousShareHandler.y(QZoneFamousShareHandler.this.f48593b, QZoneFamousShareHandler.this.f48594c);
                            break;
                    }
                } else {
                    LpReportInfo_pf00064 lpReportInfo_pf000644 = new LpReportInfo_pf00064(308, 78, 2);
                    if (QZoneFamousShareHandler.this.f48596e == null || QZoneFamousShareHandler.this.f48596e.g() != 1) {
                        QZoneFamousShareHandler.E(QZoneFamousShareHandler.this.f48593b, QZoneFamousShareHandler.this.f48594c);
                        lpReportInfo_pf000644.reserves3 = "1";
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000644, false, false);
                    } else {
                        QZoneFamousShareHandler.this.A();
                        lpReportInfo_pf000644.reserves3 = "2";
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000644, false, false);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (QZoneFamousShareHandler.this.f48597f == 9 || QZoneFamousShareHandler.this.f48597f == 10) {
                return;
            }
            QZoneFamousShareHandler.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements IQzoneShareApi.WXShareListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f48607a;

        d(Activity activity) {
            this.f48607a = activity;
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            if (!this.f48607a.isFinishing()) {
                this.f48607a.finish();
            }
            QZLog.i("QZoneFamousShareHandler", 4, "------share to wx over,finish QZoneTranslucentActivity");
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements IQzoneShareApi.WXShareListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f48608a;

        e(Activity activity) {
            this.f48608a = activity;
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            if (!this.f48608a.isFinishing()) {
                this.f48608a.finish();
            }
            QZLog.i("QZoneFamousShareHandler", 4, "-----share to wx pengyouquan over,finish QZoneTranslucentActivity");
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGenerateQrCodeFail", "\u751f\u6210\u4e8c\u7ef4\u7801\u56fe\u7247\u5931\u8d25\uff0c\u6682\u65f6\u4e0d\u80fd\u5206\u4eab"), 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotSdCardToShare", "\u672a\u68c0\u6d4b\u5230SD\u5361\uff0c\u4e0d\u80fd\u5206\u4eab\u4e8c\u7ef4\u7801\u56fe\u7247\u7ed9\u597d\u53cb"), 4);
            } else {
                Object obj = message.obj;
                if (obj == null || !(obj instanceof String)) {
                    return;
                }
                QZoneFamousShareHandler qZoneFamousShareHandler = QZoneFamousShareHandler.this;
                qZoneFamousShareHandler.t((String) obj, qZoneFamousShareHandler.f48599h);
            }
        }
    }

    public QZoneFamousShareHandler(Activity activity, Intent intent) {
        this.f48595d = QZoneHelper.KEY_FROM_NATIVE_USER_HOME;
        this.f48593b = activity;
        this.f48594c = intent;
        intent.putExtra(QZoneHelper.bNEEDCALLBACK, true);
        this.f48595d = intent.getStringExtra("key_jump_from");
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f48593b.isFinishing()) {
            return;
        }
        this.f48593b.finish();
    }

    private void v() {
        if (this.f48596e != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.misc.web.QZoneFamousShareHandler.8
                @Override // java.lang.Runnable
                public void run() {
                    QZoneFamousShareHandler.this.f48596e.f(QZoneFamousShareHandler.this.f48600i);
                }
            });
        }
    }

    private void w() {
        if (this.f48592a == null) {
            com.qzone.detail.ui.component.a aVar = new com.qzone.detail.ui.component.a(this.f48593b, true);
            this.f48592a = aVar;
            aVar.o(this.f48598g);
            this.f48592a.n(new b());
            com.qzone.detail.ui.component.c a16 = com.qzone.detail.ui.component.c.a();
            s6.a b16 = a16.b(3);
            b16.g(true, this.f48592a);
            b16.h(R.drawable.qzone_icon_action_sheet_share_to_qzone, this.f48592a);
            this.f48592a.a(b16, 1);
            s6.a b17 = a16.b(2);
            b17.g(true, this.f48592a);
            b17.h(R.drawable.qzone_icon_action_sheet_share_to_qq, this.f48592a);
            this.f48592a.a(b17, 1);
            s6.a b18 = a16.b(9);
            b18.g(true, this.f48592a);
            b18.h(R.drawable.qzone_icon_action_sheet_share_to_wx, this.f48592a);
            this.f48592a.a(b18, 1);
            s6.a b19 = a16.b(10);
            b19.g(true, this.f48592a);
            b19.h(R.drawable.qzone_icon_action_sheet_share_to_wx_circle, this.f48592a);
            this.f48592a.a(b19, 1);
        }
        if (this.f48596e == null) {
            this.f48596e = new ShareStyleChooserController(this.f48593b, this.f48594c, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_UIN);
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.getCellUserInfo().getUser().uin = Long.parseLong(stringExtra);
        businessFeedData.getFeedCommInfo().appid = 1;
        QZoneFeedUtil.u(businessFeedData);
    }

    public void H() {
        if (this.f48592a == null) {
            w();
        }
        if (this.f48592a.i()) {
            this.f48592a.d();
        } else {
            this.f48592a.p();
        }
    }

    protected void I(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        Activity activity = this.f48593b;
        if (activity instanceof BasePluginActivity) {
            intent.setClass(((BasePluginActivity) activity).getOutActivity(), ForwardRecentActivity.class);
        } else {
            intent.setClass(activity, ForwardRecentActivity.class);
        }
        if (QZoneConfigHelper.v()) {
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        }
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        this.f48593b.startActivityForResult(intent, 1000);
    }

    protected void x() {
        if (TextUtils.isEmpty(this.f48595d) || !this.f48595d.equals(QZoneHelper.KEY_FROM_NATIVE_USER_HOME)) {
            return;
        }
        LpReportInfo_pf00064.allReport(308, 78, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.f48599h = 2;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f48599h = 3;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f48599h = 4;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.f48599h = 1;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Activity activity, Intent intent) {
        LpReportInfo_pf00064.allReport(308, 78, 3);
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44741b = intent.getStringExtra("title");
        eVar.f44742c = intent.getStringExtra("summary");
        eVar.f44743d = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL);
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("detail_url");
        }
        eVar.f44740a = stringExtra;
        eVar.f44711h = 2;
        eVar.f44712i = QZoneShareManager.QQ_SHARE_APPID;
        eVar.f44713j = 1;
        eVar.f44714k = activity.getString(R.string.gg_);
        eVar.f44715l = false;
        ShareUtils.n(activity, eVar, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Activity activity, Intent intent) {
        LpReportInfo_pf00064.allReport(308, 78, 2);
        QZoneShareData qZoneShareData = new QZoneShareData();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL));
        qZoneShareData.mImageUrls = arrayList;
        qZoneShareData.mTitle = intent.getStringExtra("title");
        qZoneShareData.mSummary = intent.getStringExtra("summary");
        qZoneShareData.from = 0;
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("detail_url");
        }
        qZoneShareData.targetUrl = stringExtra;
        qZoneShareData.showShareOtherPlat = 0;
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareToQzone(activity, QZoneHelper.UserInfo.getInstance().qzone_uin, qZoneShareData, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Activity activity, Intent intent) {
        LpReportInfo_pf00064.allReport(308, 78, 4);
        ShareUtils.g gVar = new ShareUtils.g();
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL);
        if (stringExtra != null) {
            if (stringExtra.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                stringExtra = stringExtra + "&famous_share_timestamp=" + System.currentTimeMillis();
            } else {
                stringExtra = stringExtra + "?famous_share_timestamp=" + System.currentTimeMillis();
            }
        }
        gVar.f44741b = intent.getStringExtra("title");
        gVar.f44742c = intent.getStringExtra("summary");
        gVar.f44743d = stringExtra;
        String stringExtra2 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_H5_DETAIL_URL);
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = intent.getStringExtra("detail_url");
        }
        gVar.f44740a = stringExtra2;
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(new d(activity));
        ShareUtils.q((BaseActivity) activity, 9, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Activity activity, Intent intent) {
        LpReportInfo_pf00064.allReport(308, 78, 5);
        ShareUtils.g gVar = new ShareUtils.g();
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL);
        if (stringExtra != null) {
            if (stringExtra.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                stringExtra = stringExtra + "&famous_share_timestamp=" + System.currentTimeMillis();
            } else {
                stringExtra = stringExtra + "?famous_share_timestamp=" + System.currentTimeMillis();
            }
        }
        gVar.f44741b = intent.getStringExtra("title");
        gVar.f44742c = intent.getStringExtra("summary");
        gVar.f44743d = stringExtra;
        String stringExtra2 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_H5_DETAIL_URL);
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = intent.getStringExtra("detail_url");
        }
        gVar.f44740a = stringExtra2;
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(new e(activity));
        ShareUtils.q((BaseActivity) activity, 10, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final String str, int i3) {
        if (i3 == 1) {
            I(str);
            return;
        }
        if (i3 == 2) {
            QZoneHelper.forwardToPublishMood(this.f48593b, QZoneHelper.UserInfo.getInstance(), str, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, QzoneConfig.MAIN_KEY_PUBLISH_MOOD, "\u5199\u8bf4\u8bf4"), "", -1);
            return;
        }
        if (i3 == 3 || i3 == 4) {
            final int i16 = i3 != 4 ? 0 : 1;
            if (((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled()) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.misc.web.QZoneFamousShareHandler.7

                    /* compiled from: P */
                    /* renamed from: com.qzone.misc.web.QZoneFamousShareHandler$7$a */
                    /* loaded from: classes39.dex */
                    class a implements IQzoneShareApi.WXShareListener {
                        a() {
                        }

                        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
                        public void onWXShareResp(BaseResp baseResp) {
                            if (!QZoneFamousShareHandler.this.f48593b.isFinishing()) {
                                QZoneFamousShareHandler.this.f48593b.finish();
                            }
                            QZLog.i("QZoneFamousShareHandler", 4, "------share to wx over,finish QZoneTranslucentActivity");
                            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(new a());
                        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, com.qzone.util.image.c.i(str), i16);
                    }
                });
                return;
            }
            if (!((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled()) {
                ToastUtil.n(R.string.gjp);
                u();
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(this.f48593b);
            } else {
                if (((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWxSupportTimeLine()) {
                    return;
                }
                ToastUtil.n(R.string.gjq);
                u();
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(this.f48593b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements ShareStyleChooserController.b {
        c() {
        }

        @Override // com.qzone.detail.ui.component.ShareStyleChooserController.b
        public void a(View view) {
            QZoneFamousShareHandler.this.f48592a.b(view);
        }

        @Override // com.qzone.detail.ui.component.ShareStyleChooserController.b
        public void b() {
        }
    }
}
