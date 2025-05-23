package k4;

import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.publish_active_album_rsp;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import PHOTO_OPENID_TO_QQ.GetShareKeyRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.base.Service.e;
import com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.ch;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.util.ToastUtil;
import com.qzone.util.am;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends b5.a {

    /* renamed from: d, reason: collision with root package name */
    protected Context f411605d;

    /* renamed from: e, reason: collision with root package name */
    private BaseActivity f411606e;

    /* renamed from: f, reason: collision with root package name */
    private AlbumDataOutShare f411607f;

    /* renamed from: i, reason: collision with root package name */
    private String f411610i;

    /* renamed from: j, reason: collision with root package name */
    private s_arkshare f411611j;

    /* renamed from: k, reason: collision with root package name */
    private int f411612k;

    /* renamed from: l, reason: collision with root package name */
    private String f411613l;

    /* renamed from: m, reason: collision with root package name */
    private String f411614m;

    /* renamed from: n, reason: collision with root package name */
    private String f411615n;

    /* renamed from: o, reason: collision with root package name */
    private AlbumCacheData f411616o;

    /* renamed from: p, reason: collision with root package name */
    public com.qzone.detail.ui.component.a f411617p;

    /* renamed from: q, reason: collision with root package name */
    public com.qzone.detail.ui.component.c f411618q;

    /* renamed from: r, reason: collision with root package name */
    private int f411619r;

    /* renamed from: s, reason: collision with root package name */
    private h f411620s;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<String> f411621t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<active_photo> f411622u;

    /* renamed from: c, reason: collision with root package name */
    private final String f411604c = "ShareMenu";

    /* renamed from: g, reason: collision with root package name */
    private String f411608g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f411609h = true;

    /* renamed from: v, reason: collision with root package name */
    private int f411623v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f411624w = 0;

    /* renamed from: x, reason: collision with root package name */
    private View.OnClickListener f411625x = new a();

    /* renamed from: y, reason: collision with root package name */
    public String f411626y = "";

    /* renamed from: z, reason: collision with root package name */
    public String f411627z = "";
    private boolean A = false;
    private boolean B = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements com.qzone.common.business.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f411629d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f411630e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f411631f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f411632h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f411633i;

        b(int i3, String str, String str2, int i16, String str3) {
            this.f411629d = i3;
            this.f411630e = str;
            this.f411631f = str2;
            this.f411632h = i16;
            this.f411633i = str3;
        }

        @Override // com.qzone.adapter.feedcomponent.IServiceCallback
        public void onResult(IResult iResult) {
            if (iResult.getSucceed()) {
                GetShareKeyRsp getShareKeyRsp = (GetShareKeyRsp) iResult.getBundle().getSerializable("OutSiteShareServiceBundleKey");
                g.this.f411608g = getShareKeyRsp.share_key;
                g.this.A(this.f411629d, this.f411630e, this.f411631f, this.f411632h);
                return;
            }
            ToastUtil.s(this.f411633i, 4);
        }
    }

    public g(Context context, BaseActivity baseActivity, int i3, int i16, String str, AlbumCacheData albumCacheData) {
        this.f411605d = context;
        this.f411606e = baseActivity;
        this.f411612k = i3;
        this.f411613l = str;
        this.f411616o = albumCacheData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3, final String str, String str2, final int i16) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        h hVar = this.f411620s;
        if (hVar != null && hVar.f() == 2 && u()) {
            str = u5.b.h0("key_dynamic_share_url", "null");
            if (t(str)) {
                return;
            }
        }
        if (i3 == 1) {
            e0(str2);
            return;
        }
        if (i3 == 2) {
            g0(i16, str);
            return;
        }
        if (i3 == 3) {
            if (this.f411606e == null) {
                QZLog.d("ShareMenu", 2, "activity is recycled");
                return;
            }
            QQCustomDialog qQCustomDialog = new QQCustomDialog(this.f411606e, R.style.qZoneInputDialog);
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleAttention", "\u6ce8\u610f");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogSharing", "\u7ee7\u7eed\u5206\u4eab");
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88");
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            qQCustomDialog.setTitle(config);
            if (str2 == null) {
                str2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPermision", "\u4f60\u7684\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u5206\u4eab\u540e\u7684\u9875\u9762\u6240\u6709\u4eba\u53ef\u89c1\uff0c\u662f\u5426\u7ee7\u7eed\u5206\u4eab\uff1f");
            }
            qQCustomDialog.setMessage(new StringBuilder(str2));
            qQCustomDialog.setPositiveButton(config2, new DialogInterface.OnClickListener() { // from class: k4.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    g.this.S(i16, str, dialogInterface, i17);
                }
            });
            qQCustomDialog.setNegativeButton(config3, new DialogInterface.OnClickListener() { // from class: k4.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
                }
            });
            qQCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f411606e == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return;
        }
        if (this.f411616o != null) {
            Intent intent = new Intent(this.f411606e, (Class<?>) FeedActionPanelActivity.class);
            intent.putExtra("extraRequestCode", 25);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
            intent.putExtra("extrauserapidcomment", false);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
            Bundle bundle = new Bundle();
            bundle.putString("forwardAlbumBundleKeyAlbumId", this.f411613l);
            intent.putExtra("extra_key_bundle_within_intent", bundle);
            com.qzone.feed.utils.b.e(this.f411606e, intent, 25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f411606e == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return;
        }
        if (this.f411616o != null) {
            Intent intent = new Intent(this.f411606e, (Class<?>) FeedActionPanelActivity.class);
            intent.putExtra("extraRequestCode", 10);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
            intent.putExtra("extrauserapidcomment", false);
            intent.putExtra("input_text_allow_empty", true);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SHARE, true);
            Bundle bundle = new Bundle();
            bundle.putString("forwardAlbumBundleKeyAlbumId", this.f411613l);
            intent.putExtra("extra_key_bundle_within_intent", bundle);
            com.qzone.feed.utils.b.e(this.f411606e, intent, 10);
        }
    }

    private Handler F() {
        BaseActivity baseActivity = this.f411606e;
        if (baseActivity == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return null;
        }
        return ((QZonePersonalPhotoListActivity) baseActivity).getHandler();
    }

    private String I() {
        s_arkshare s_arkshareVar;
        AlbumCacheData albumCacheData;
        h hVar = this.f411620s;
        int f16 = hVar != null ? hVar.f() : 1;
        if (f16 == 1 && (albumCacheData = this.f411616o) != null) {
            return albumCacheData.ark_content;
        }
        if (f16 != 2 || (s_arkshareVar = this.f411611j) == null) {
            return null;
        }
        return s_arkshareVar.ark_content;
    }

    private boolean M() {
        BaseActivity baseActivity = this.f411606e;
        if (baseActivity == null || !(baseActivity instanceof QZonePersonalPhotoListActivity)) {
            return false;
        }
        return ((QZonePersonalPhotoListActivity) baseActivity).K0.P2();
    }

    private static boolean N() {
        return 1 == QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_SHARE_ALBUM_TO_WEIXIN_MINI_PROGRAM_NEED_SK, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        return this.f411624w == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(String str, String str2, String str3, DialogInterface dialogInterface, int i3) {
        d0(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i3, String str, DialogInterface dialogInterface, int i16) {
        g0(i3, str);
    }

    private void V() {
        if (this.f411606e == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return;
        }
        if (P()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u5206\u4eab\u94fe\u63a5\u6709\u6548\u671f\u4e3a3\u5929"));
        }
        if (this.f411616o != null) {
            Intent intent = new Intent(this.f411606e, (Class<?>) FeedActionPanelActivity.class);
            intent.putExtra("extraRequestCode", 29);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
            intent.putExtra("extrauserapidcomment", false);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
            Bundle bundle = new Bundle();
            bundle.putString("forwardAlbumBundleKeyAlbumId", this.f411613l);
            intent.putExtra("extra_key_bundle_within_intent", bundle);
            com.qzone.feed.utils.b.e(this.f411606e, intent, 29);
        }
    }

    private void d0(String str, String str2, String str3) {
        h hVar;
        h hVar2;
        if (this.f411606e == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (P()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u5206\u4eab\u94fe\u63a5\u6709\u6548\u671f\u4e3a3\u5929"));
        }
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44740a = str + "&theme=" + this.f411612k;
        eVar.f44711h = 2;
        eVar.f44743d = ch.c(this.f411607f.mapPhotoUrl);
        eVar.f44712i = str2;
        eVar.f44713j = 1;
        AlbumDataOutShare albumDataOutShare = this.f411607f;
        eVar.f44742c = albumDataOutShare.summary;
        eVar.f44741b = albumDataOutShare.title;
        eVar.f44715l = true;
        if (!TextUtils.isEmpty(this.f411616o.ark_content) && (((hVar2 = this.f411620s) == null || (hVar2 != null && hVar2.f() != 2)) && !P())) {
            if (!TextUtils.isEmpty(str3)) {
                AlbumCacheData albumCacheData = this.f411616o;
                eVar.b(str3, albumCacheData.ark_id, albumCacheData.view_id);
            } else {
                AlbumCacheData albumCacheData2 = this.f411616o;
                eVar.c(albumCacheData2.ark_content, albumCacheData2.ark_id, albumCacheData2.view_id, str);
            }
        }
        if (this.f411611j != null && (hVar = this.f411620s) != null && hVar.f() == 2) {
            if (!TextUtils.isEmpty(str3)) {
                s_arkshare s_arkshareVar = this.f411611j;
                eVar.b(str3, s_arkshareVar.ark_id, s_arkshareVar.view_id);
            } else {
                s_arkshare s_arkshareVar2 = this.f411611j;
                eVar.c(s_arkshareVar2.ark_content, s_arkshareVar2.ark_id, s_arkshareVar2.view_id, str);
            }
        }
        ShareUtils.n(this.f411606e, eVar, 293);
    }

    private void e0(String str) {
        ToastUtil.r(str);
    }

    private void g0(int i3, String str) {
        if (this.f411607f == null) {
            QZLog.w("ShareMenu", 1, "showToWixinUncheck: mAlbumDataOutShare=null,just return");
            return;
        }
        int config = P() ? 0 : QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHARE_ALBUM_TO_MINIPROGRAM, 1);
        AlbumDataOutShare albumDataOutShare = this.f411607f;
        String str2 = albumDataOutShare.xcx_name;
        String str3 = albumDataOutShare.xcx_share_path;
        h hVar = this.f411620s;
        if (hVar != null && hVar.f() == 2) {
            str2 = this.f411627z;
            str3 = this.f411626y;
        }
        if (this.f411606e == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return;
        }
        if (P()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u5206\u4eab\u94fe\u63a5\u6709\u6548\u671f\u4e3a3\u5929"));
        }
        ShareUtils.g gVar = new ShareUtils.g();
        AlbumDataOutShare albumDataOutShare2 = this.f411607f;
        gVar.f44741b = albumDataOutShare2.title;
        gVar.f44742c = albumDataOutShare2.summary;
        gVar.f44743d = ch.d(albumDataOutShare2.mapPhotoUrl, (config == 1 && i3 == 9) ? 1 : -1);
        gVar.f44740a = str;
        QZLog.d("ShareMenu", 1, "yuki sharePhotoUrl\uff1a" + gVar.f44743d + " detailUrl\uff1a" + gVar.f44740a + " iShareToWxMiniProgram:" + config);
        gVar.f44744e = str2;
        gVar.f44745f = str3;
        gVar.f44746g = this.f411608g;
        ShareUtils.r(this.f411606e, i3, gVar, config);
    }

    private void s() {
        this.f411618q.b(2).g(true, this.f411617p);
        this.f411618q.b(9).g(true, this.f411617p);
        this.f411618q.b(10).g(true, this.f411617p);
        if (P()) {
            return;
        }
        if (!w(14)) {
            this.f411618q.b(2).g(false, this.f411617p);
        }
        if (w(13)) {
            return;
        }
        this.f411618q.b(9).g(false, this.f411617p);
        this.f411618q.b(10).g(false, this.f411617p);
    }

    private boolean t(String str) {
        if (!str.equals("null")) {
            return false;
        }
        ToastUtil.n(R.string.gax);
        if (this.f27876b) {
            return true;
        }
        E(false);
        return true;
    }

    private boolean u() {
        if (!this.f27875a || u5.b.h0("key_dynamicalbum_has_checked_preview", "0").equals("1")) {
            return true;
        }
        ToastUtil.n(R.string.gax);
        if (!this.f27876b) {
            E(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        BaseActivity baseActivity = this.f411606e;
        if (baseActivity == null) {
            QZLog.d("ShareMenu", 2, "activity is recycled");
            return false;
        }
        return ((QZonePersonalPhotoListActivity) baseActivity).checkNetworkConnect();
    }

    private void y(int i3, final String str, final String str2, String str3, final String str4) {
        if (OutSiteShareService.j(i3)) {
            return;
        }
        h hVar = this.f411620s;
        if (hVar != null && hVar.f() == 2 && u()) {
            str = u5.b.h0("key_dynamic_share_url", "null");
            if (t(str)) {
                return;
            }
        }
        if (i3 == 1) {
            e0(str3);
            return;
        }
        if (i3 == 2) {
            d0(str, str2, str4);
            return;
        }
        if (i3 == 3) {
            if (this.f411606e == null) {
                QZLog.d("ShareMenu", 2, "activity is recycled");
                return;
            }
            QQCustomDialog qQCustomDialog = new QQCustomDialog(this.f411606e, R.style.qZoneInputDialog);
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleAttention", "\u6ce8\u610f");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogSharing", "\u7ee7\u7eed\u5206\u4eab");
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88");
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            qQCustomDialog.setTitle(config);
            if (str3 == null) {
                str3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPermision", "\u4f60\u7684\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u5206\u4eab\u540e\u7684\u9875\u9762\u6240\u6709\u4eba\u53ef\u89c1\uff0c\u662f\u5426\u7ee7\u7eed\u5206\u4eab\uff1f");
            }
            qQCustomDialog.setMessage(new StringBuilder(str3));
            qQCustomDialog.setPositiveButton(config2, new DialogInterface.OnClickListener() { // from class: k4.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    g.this.Q(str, str2, str4, dialogInterface, i16);
                }
            });
            qQCustomDialog.setNegativeButton(config3, new DialogInterface.OnClickListener() { // from class: k4.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
                }
            });
            qQCustomDialog.show();
        }
    }

    public boolean G() {
        return this.A;
    }

    public boolean H() {
        return this.B;
    }

    public void K(s sVar) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25");
        if (sVar != null && sVar.getSucceed()) {
            Bundle bundle = sVar.getBundle();
            String string = bundle.getString("url");
            String string2 = bundle.getString("ark_content", "");
            String string3 = bundle.getString("msg");
            int i3 = bundle.getInt("iShareOutType");
            if (P() && this.f411607f != null) {
                Uri parse = Uri.parse(string);
                String queryParameter = parse.getQueryParameter("sharetag");
                if (am.h(queryParameter)) {
                    queryParameter = parse.getQueryParameter(QZoneHelper.CIPHERTEXT);
                }
                if (!am.h(queryParameter)) {
                    Uri.Builder buildUpon = Uri.parse(this.f411607f.qqUrl).buildUpon();
                    buildUpon.appendQueryParameter(QZoneHelper.CIPHERTEXT, queryParameter);
                    string = buildUpon.toString();
                }
            }
            this.f411610i = string;
            int i16 = this.f411619r;
            if (i16 == 3) {
                V();
                return;
            }
            if (i16 == 2) {
                if (this.f411607f == null) {
                    return;
                }
                y(i3, string, QZoneShareManager.QQ_SHARE_APPID, string3, string2);
                return;
            }
            if (this.f411607f == null) {
                return;
            }
            if (i16 != 9) {
                if (i16 == 10) {
                    A(i3, string, string3, i16);
                    return;
                }
                return;
            }
            h hVar = this.f411620s;
            if (hVar != null && hVar.f() == 2) {
                A(i3, string, string3, i16);
                return;
            } else if (!N()) {
                A(i3, string, string3, i16);
                return;
            } else {
                OutSiteShareService.a().b(new b(i3, string, string3, i16, config), this.f411613l, this.f411616o.ownerUin);
                return;
            }
        }
        ToastUtil.s(config, 4);
    }

    public void L(boolean z16) {
        BaseActivity baseActivity;
        if ((this.f411617p == null || z16) && (baseActivity = this.f411606e) != null) {
            com.qzone.detail.ui.component.a aVar = new com.qzone.detail.ui.component.a(baseActivity, true);
            this.f411617p = aVar;
            aVar.o(this.f411625x);
            com.qzone.detail.ui.component.c a16 = com.qzone.detail.ui.component.c.a();
            this.f411618q = a16;
            s6.a b16 = a16.b(3);
            b16.h(R.drawable.qzone_icon_action_sheet_share_to_qzone, this.f411617p);
            this.f411617p.a(b16, 1);
            s6.a b17 = this.f411618q.b(2);
            b17.h(R.drawable.qzone_icon_action_sheet_share_to_qq, this.f411617p);
            this.f411617p.a(b17, 1);
            s6.a b18 = this.f411618q.b(9);
            b18.h(R.drawable.qzone_icon_action_sheet_share_to_wx, this.f411617p);
            this.f411617p.a(b18, 1);
            s6.a b19 = this.f411618q.b(10);
            b19.h(R.drawable.qzone_icon_action_sheet_share_to_wx_circle, this.f411617p);
            this.f411617p.a(b19, 1);
            s();
            h hVar = this.f411620s;
            if (hVar != null) {
                this.f411617p.b(hVar.e());
            }
        }
    }

    public boolean O(int i3) {
        return i3 != this.f411623v;
    }

    public void W(boolean z16) {
        this.A = z16;
    }

    public void X(boolean z16) {
        this.B = z16;
    }

    public void Y(ArrayList<PhotoCacheData> arrayList) {
        PictureItem pictureItem;
        ArrayList<String> arrayList2 = this.f411621t;
        if (arrayList2 == null) {
            this.f411621t = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        ArrayList<active_photo> arrayList3 = this.f411622u;
        if (arrayList3 == null) {
            this.f411622u = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        if (arrayList != null) {
            this.f411623v = arrayList.size();
            int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ALBUM_SHARE_DYNAMIC_MAX_PHOTO_NUM, 30);
            for (int i3 = 0; i3 < this.f411623v; i3++) {
                PhotoCacheData photoCacheData = arrayList.get(i3);
                if (photoCacheData != null && !photoCacheData.isGif() && !photoCacheData.isVideo() && (pictureItem = photoCacheData.picItem) != null && pictureItem.bigUrl != null) {
                    if (TextUtils.isEmpty(this.f411614m)) {
                        this.f411614m = photoCacheData.lloc;
                    }
                    if (TextUtils.isEmpty(this.f411615n)) {
                        this.f411615n = photoCacheData.picItem.bigUrl.url;
                    }
                    this.f411621t.add(photoCacheData.picItem.bigUrl.url);
                    this.f411622u.add(new active_photo(this.f411616o.albumid, photoCacheData.lloc, "", ""));
                    if (this.f411622u.size() >= config) {
                        break;
                    }
                }
            }
            if (this.f411622u.size() >= 3 && !P() && !M()) {
                Context context = this.f411605d;
                AlbumCacheData albumCacheData = this.f411616o;
                this.f411620s = new h(context, this, albumCacheData, this.f411621t, albumCacheData.coverUrl.url);
            } else {
                this.f411620s = null;
            }
        } else {
            this.f411620s = null;
        }
        a();
    }

    public void Z(int i3) {
        this.f411624w = i3;
    }

    public void a0(AlbumDataOutShare albumDataOutShare) {
        this.f411607f = albumDataOutShare;
        h hVar = this.f411620s;
        if (hVar != null) {
            hVar.i(albumDataOutShare);
        }
    }

    public void b0(String str) {
        QZoneShareData qZoneShareData = new QZoneShareData();
        AlbumDataOutShare albumDataOutShare = this.f411607f;
        if (albumDataOutShare != null) {
            qZoneShareData.mTitle = albumDataOutShare.title;
            qZoneShareData.mSummary = albumDataOutShare.summary;
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(ch.c(this.f411607f.mapPhotoUrl));
            qZoneShareData.mImageUrls = arrayList;
        }
        qZoneShareData.targetUrl = this.f411610i;
        qZoneShareData.iUrlInfoFrm = -1;
        qZoneShareData.mShareBeginTime = System.currentTimeMillis();
        qZoneShareData.from = 0;
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).startShareServlet(this.f411605d, str, LoginData.getInstance().getUin(), qZoneShareData);
        ToastUtil.r(l.a(R.string.jcr));
    }

    public void c0(String str) {
        if (u()) {
            QZoneShareData qZoneShareData = new QZoneShareData();
            qZoneShareData.mTitle = TextUtils.isEmpty(this.f411616o.albumname) ? null : this.f411616o.albumname;
            qZoneShareData.mSummary = l.a(R.string.jcs) + this.f411622u.size() + l.a(R.string.jcu);
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(this.f411616o.coverUrl.url);
            qZoneShareData.mImageUrls = arrayList;
            String h06 = u5.b.h0("key_dynamic_share_url", "null");
            qZoneShareData.targetUrl = h06;
            if (h06.equals("null")) {
                ToastUtil.n(R.string.gax);
                if (this.f27876b) {
                    return;
                }
                E(false);
                return;
            }
            qZoneShareData.iUrlInfoFrm = -1;
            qZoneShareData.mShareBeginTime = System.currentTimeMillis();
            qZoneShareData.from = 0;
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).startShareServlet(this.f411605d, str, LoginData.getInstance().getUin(), qZoneShareData);
            ToastUtil.r(l.a(R.string.jct));
        }
    }

    public void f0(AlbumCacheData albumCacheData) {
        h hVar = this.f411620s;
        if (hVar != null) {
            hVar.j(albumCacheData);
        }
        ClickReport.q("368", "14", "", true);
        if (!v()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        if (this.f411607f == null) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDataFetching", "\u6570\u636e\u83b7\u53d6\u4e2d..."));
            return;
        }
        if (this.f411617p == null) {
            L(false);
        }
        if (this.f411617p != null) {
            s();
            if (this.f411617p.i()) {
                this.f411617p.d();
                return;
            } else {
                this.f411617p.p();
                return;
            }
        }
        QZLog.e("ShareMenu", "showShareMenue() error! mShareMenue inited but failed!");
    }

    public boolean w(int i3) {
        AlbumCacheData albumCacheData = this.f411616o;
        if (albumCacheData != null) {
            return ((1 << i3) & albumCacheData.operatemask) != 0;
        }
        return false;
    }

    public void x() {
        com.qzone.detail.ui.component.a aVar = this.f411617p;
        if (aVar == null || !aVar.i()) {
            return;
        }
        this.f411617p.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        J(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        J(1);
    }

    private void J(int i3) {
        String str;
        int i16;
        AlbumDataOutShare albumDataOutShare;
        if (this.f411616o != null) {
            if (!P() || (albumDataOutShare = this.f411607f) == null) {
                str = null;
                i16 = 0;
            } else {
                str = albumDataOutShare.md5;
                i16 = 1;
            }
            String str2 = str;
            int i17 = i16;
            String I = I();
            if (!TextUtils.isEmpty(I) && ShareUtils.k()) {
                HashMap hashMap = new HashMap(2);
                hashMap.put(13, I);
                OutSiteShareService.a().f(F(), 4, -1, null, this.f411613l, null, null, this.f411616o.ownerUin, i3, str2, i17, hashMap);
                return;
            }
            OutSiteShareService.a().e(F(), 4, -1, null, this.f411613l, null, null, this.f411616o.ownerUin, i3, str2, i17);
        }
    }

    public void E(boolean z16) {
        String str;
        if ((z16 || !this.f27876b) && this.f411616o != null) {
            this.A = false;
            this.f27876b = true;
            HashMap hashMap = new HashMap();
            AlbumCacheData albumCacheData = this.f411616o;
            String str2 = albumCacheData.albumname;
            if (TextUtils.isEmpty(albumCacheData.albumOwner)) {
                str = s8.f.f().g(String.valueOf(this.f411616o.ownerUin));
            } else {
                str = this.f411616o.albumOwner;
            }
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_AID, this.f411613l);
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_PIC, this.f411614m);
            hashMap.put("cover_url", this.f411615n);
            if (TextUtils.isEmpty(str2)) {
                str2 = QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_NAME;
            }
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_NAME, str2);
            if (TextUtils.isEmpty(str)) {
                str = QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_DESC;
            }
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_DESC, str);
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID, QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE);
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, "1");
            hashMap.put("music_id", u5.b.h0("key_dynamicalbum_music_id", ""));
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID, u5.b.h0("key_dynamicalbum_lrc_id", ""));
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START, u5.b.h0("key_dynamicalbum_climax_start", ""));
            hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE, u5.b.h0("key_dynamicalbum_climax_endure", ""));
            shuoshuo_privacy shuoshuo_privacyVar = new shuoshuo_privacy();
            shuoshuo_privacyVar.mood_permission = String.valueOf(1);
            com.qzone.album.base.Service.e.e().u(new e.b() { // from class: k4.b
                @Override // com.qzone.album.base.Service.e.b
                public final void a(boolean z17, publish_active_album_rsp publish_active_album_rspVar) {
                    g.this.U(z17, publish_active_album_rspVar);
                }
            });
            com.qzone.album.base.Service.e.e().d(this.f411622u, hashMap, shuoshuo_privacyVar, r1.size(), this.f27875a, this.f411616o.ownerUin);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.qzone.detail.ui.component.a aVar = g.this.f411617p;
            if (aVar != null && aVar.i()) {
                try {
                    g.this.f411617p.d();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (view != null) {
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = ((ShareActionSheetBuilder.c) view.getTag()).f307311e;
                int i3 = actionSheetItem == null ? 0 : actionSheetItem.action;
                g.this.f411619r = i3;
                if (g.this.v()) {
                    if (!g.this.f411609h) {
                        ToastUtil.n(R.string.gjm);
                    } else if (i3 == 2) {
                        if (!g.this.P()) {
                            if (g.this.f411620s != null) {
                                if (g.this.f411620s.f() == 1) {
                                    com.qzone.album.env.common.a.m().P(724, 4, "1", true, null);
                                } else {
                                    com.qzone.album.env.common.a.m().P(724, 4, "2", true, null);
                                }
                            }
                        } else {
                            LpReportInfo_pf00064.allReport(95, 8, 2);
                        }
                        g.this.z();
                        ShareUtils.l();
                    } else if (i3 != 3) {
                        if (i3 == 9) {
                            if (!g.this.P()) {
                                if (g.this.f411620s != null) {
                                    if (g.this.f411620s.f() == 1) {
                                        com.qzone.album.env.common.a.m().P(724, 5, "1", true, null);
                                    } else {
                                        com.qzone.album.env.common.a.m().P(724, 5, "2", true, null);
                                    }
                                }
                            } else {
                                LpReportInfo_pf00064.allReport(95, 8, 3);
                            }
                            ShareUtils.u();
                            g.this.B();
                        } else if (i3 == 10) {
                            if (!g.this.P()) {
                                if (g.this.f411620s != null) {
                                    if (g.this.f411620s.f() == 1) {
                                        com.qzone.album.env.common.a.m().P(724, 6, "1", true, null);
                                    } else {
                                        com.qzone.album.env.common.a.m().P(724, 6, "2", true, null);
                                    }
                                }
                            } else {
                                LpReportInfo_pf00064.allReport(95, 8, 4);
                            }
                            g.this.B();
                        }
                    } else if (g.this.P()) {
                        g.this.z();
                        LpReportInfo_pf00064.allReport(95, 8, 1);
                    } else if (g.this.f411620s == null) {
                        g.this.D();
                    } else if (g.this.f411620s.f() == 1) {
                        g.this.D();
                        com.qzone.album.env.common.a.m().P(724, 3, "1", true, null);
                    } else {
                        g.this.C();
                        com.qzone.album.env.common.a.m().P(724, 3, "2", true, null);
                    }
                } else {
                    ToastUtil.n(R.string.ghi);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(boolean z16, publish_active_album_rsp publish_active_album_rspVar) {
        s_arkshare s_arkshareVar;
        if (z16 && publish_active_album_rspVar != null && (s_arkshareVar = publish_active_album_rspVar.ark_sharedata) != null) {
            this.f411611j = s_arkshareVar;
        }
        if (!z16 || publish_active_album_rspVar == null) {
            return;
        }
        this.f411627z = publish_active_album_rspVar.xcx_name;
        this.f411626y = publish_active_album_rspVar.xcx_share_path;
    }
}
