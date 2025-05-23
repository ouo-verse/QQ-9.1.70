package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QZoneHelper;
import hd0.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeQRCodeShareHelper {

    /* renamed from: l, reason: collision with root package name */
    public static final String f96413l = AppConstants.SDCARD_PATH + "subscribe_shared_card/";

    /* renamed from: c, reason: collision with root package name */
    private Activity f96416c;

    /* renamed from: d, reason: collision with root package name */
    private ve0.b f96417d;

    /* renamed from: e, reason: collision with root package name */
    private bc f96418e;

    /* renamed from: f, reason: collision with root package name */
    private AbsSubscribeShareCardView f96419f;

    /* renamed from: g, reason: collision with root package name */
    private WXShareHelper.a f96420g;

    /* renamed from: h, reason: collision with root package name */
    private String f96421h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.subscribe.widget.a f96422i;

    /* renamed from: j, reason: collision with root package name */
    private ShareActionSheet f96423j;

    /* renamed from: a, reason: collision with root package name */
    private final String f96414a = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";

    /* renamed from: b, reason: collision with root package name */
    private final String f96415b = AppConstants.SDCARD_PATH + "subscribe_card/";

    /* renamed from: k, reason: collision with root package name */
    private ShareActionSheet.OnItemClickListener f96424k = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final Bitmap e16 = SubscribeUtils.e(SubscribeQRCodeShareHelper.this.I(), ScreenUtil.dip2px(50.0f), -16777216, -1, Bitmap.Config.ARGB_8888);
            if (e16 != null && !e16.isRecycled()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper$2$1$a */
                    /* loaded from: classes5.dex */
                    class a extends AbsSubscribeShareCardView.a {
                        a() {
                        }

                        @Override // com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.a, com.tencent.image.URLDrawable.URLDrawableListener
                        public void onLoadSuccessed(URLDrawable uRLDrawable) {
                            SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                            subscribeQRCodeShareHelper.Q(subscribeQRCodeShareHelper.f96419f);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (SubscribeQRCodeShareHelper.this.f96416c != null && !SubscribeQRCodeShareHelper.this.f96416c.isFinishing()) {
                            SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                            subscribeQRCodeShareHelper.f96419f = subscribeQRCodeShareHelper.C();
                            if (SubscribeQRCodeShareHelper.this.f96419f != null) {
                                SubscribeQRCodeShareHelper.this.f96419f.e(SubscribeQRCodeShareHelper.this.f96417d, e16, new a());
                            }
                        }
                    }
                });
                QLog.d("SubscribeQRCodeShareHelper", 4, " create card code success");
            } else {
                QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ShareActionSheet.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3 = actionSheetItem.action;
            if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96416c != null) {
                if (i3 == 2) {
                    SubscribeQRCodeShareHelper.this.N();
                    if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96417d.a() != null) {
                        VSReporter.n(SubscribeQRCodeShareHelper.this.f96417d.a().poster.f24929id.get(), "auth_pic_share", "clk_friends", 0, 0, null, null, SubscribeQRCodeShareHelper.this.f96417d.f(), SubscribeQRCodeShareHelper.this.f96417d.h());
                        return;
                    }
                    return;
                }
                if (i3 == 3) {
                    SubscribeQRCodeShareHelper.this.O();
                    if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96417d.a() != null) {
                        VSReporter.n(SubscribeQRCodeShareHelper.this.f96417d.a().poster.f24929id.get(), "auth_pic_share", "clk_qzone", 0, 0, null, null, SubscribeQRCodeShareHelper.this.f96417d.f(), SubscribeQRCodeShareHelper.this.f96417d.h());
                        return;
                    }
                    return;
                }
                if (i3 == 9) {
                    SubscribeQRCodeShareHelper.this.P(0);
                    if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96417d.a() != null) {
                        VSReporter.n(SubscribeQRCodeShareHelper.this.f96417d.a().poster.f24929id.get(), "auth_pic_share", "clk_wechat", 0, 0, null, null, SubscribeQRCodeShareHelper.this.f96417d.f(), SubscribeQRCodeShareHelper.this.f96417d.h());
                        return;
                    }
                    return;
                }
                if (i3 == 10) {
                    SubscribeQRCodeShareHelper.this.P(1);
                    if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96417d.a() != null) {
                        VSReporter.n(SubscribeQRCodeShareHelper.this.f96417d.a().poster.f24929id.get(), "auth_pic_share", "clk_moments", 0, 0, null, null, SubscribeQRCodeShareHelper.this.f96417d.f(), SubscribeQRCodeShareHelper.this.f96417d.h());
                        return;
                    }
                    return;
                }
                if (i3 == 39) {
                    SubscribeQRCodeShareHelper.this.M();
                    if (SubscribeQRCodeShareHelper.this.f96417d != null && SubscribeQRCodeShareHelper.this.f96417d.a() != null) {
                        VSReporter.n(SubscribeQRCodeShareHelper.this.f96417d.a().poster.f24929id.get(), "auth_pic_share", "clk_save_local", 0, 0, null, null, SubscribeQRCodeShareHelper.this.f96417d.f(), SubscribeQRCodeShareHelper.this.f96417d.h());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements WXShareHelper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3;
            if (SubscribeQRCodeShareHelper.this.f96421h != null && SubscribeQRCodeShareHelper.this.f96421h.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
                if (i3 != 0) {
                    QQToast.makeText(SubscribeQRCodeShareHelper.this.f96416c, 1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 0).show();
                } else {
                    QQToast.makeText(SubscribeQRCodeShareHelper.this.f96416c, 2, "\u5206\u4eab\u6210\u529f", 0).show();
                }
            }
        }
    }

    public SubscribeQRCodeShareHelper(Activity activity) {
        this.f96416c = activity;
        bc b16 = ThreadManagerV2.newHandlerRecycleThread("subscribe_create_card", 0).b();
        this.f96418e = b16;
        b16.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.delete(SubscribeQRCodeShareHelper.this.f96415b, true);
                FileUtils.createFileIfNotExits(SubscribeQRCodeShareHelper.this.f96415b + ".nomedia");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (this.f96419f != null) {
            String E = E(this.f96415b);
            if (!TextUtils.isEmpty(E)) {
                if (new File(E).exists()) {
                    QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
                    return true;
                }
                Bitmap h16 = this.f96419f.h();
                if (h16 != null) {
                    return z81.b.a(h16, E, Bitmap.CompressFormat.JPEG, 80, true);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsSubscribeShareCardView C() {
        ExtraTypeInfo extraTypeInfo;
        ve0.b bVar = this.f96417d;
        if (bVar != null && (extraTypeInfo = bVar.f441505e) != null) {
            int i3 = extraTypeInfo.pageType;
            if (i3 != 7005) {
                switch (i3) {
                    case 7000:
                        return new SubscribeVideoSharedCardView(this.f96416c);
                    case 7001:
                        return new SubscribeMultiPicSharedCardView(this.f96416c);
                }
            }
            int i16 = bVar.f441501a;
            if (i16 == 1) {
                return new SubScribePersonalSharedCardView(this.f96416c);
            }
            if (i16 == 3) {
                return new SubscribeVideoSharedCardView(this.f96416c);
            }
            if (i16 == 4) {
                return new SubscribeMultiPicSharedCardView(this.f96416c);
            }
        }
        return null;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> D(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(it.next().intValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String E(String str) {
        boolean equals = AppConstants.SDCARD_IMG_SAVE.equals(str);
        FileUtils.createFileIfNotExits(str + ".nomedia");
        ve0.b bVar = this.f96417d;
        Object obj = "";
        if (bVar == null || bVar.f441505e == null || bVar.a() == null) {
            return "";
        }
        int i3 = this.f96417d.f441505e.pageType;
        if (i3 != 7005) {
            switch (i3) {
                case 7000:
                case 7001:
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append(this.f96417d.a().get().f24925id.get());
                    if (equals) {
                        obj = Long.valueOf(System.currentTimeMillis());
                    }
                    sb5.append(obj);
                    sb5.append(".png");
                    return sb5.toString();
                case 7002:
                    break;
                default:
                    return "";
            }
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        sb6.append(g.d(this.f96417d.a().poster.f24929id.get()));
        if (equals) {
            obj = Long.valueOf(System.currentTimeMillis());
        }
        sb6.append(obj);
        sb6.append(".png");
        return sb6.toString();
    }

    private String F() {
        if (TextUtils.isEmpty(this.f96417d.g())) {
            try {
                return "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=" + URLEncoder.encode(SubscribeShareHelper.A(this.f96417d.a()), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return this.f96417d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String G(Context context, String str) {
        File file = new File(str);
        Uri uri = null;
        if (!file.exists()) {
            return null;
        }
        try {
            uri = FileProvider.getUriForFile(context, "com.tencent.mobileqq.fileprovider", file);
            context.grantUriPermission("com.tencent.mm", uri, 1);
        } catch (Exception e16) {
            c.g("SubscribeQRCodeShareHelper", e16.getMessage());
            e16.printStackTrace();
        }
        if (uri != null) {
            return uri.toString();
        }
        return str;
    }

    private String H() {
        String str;
        CertifiedAccountMeta$StShare certifiedAccountMeta$StShare;
        CertifiedAccountRead$StGetMainPageRsp b16 = com.tencent.biz.subscribe.c.b();
        if (b16 != null && (certifiedAccountMeta$StShare = b16.share) != null) {
            str = certifiedAccountMeta$StShare.shorturl.get();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=" + URLEncoder.encode(SubscribeShareHelper.B(this.f96417d.f441502b.poster.f24929id.get(), this.f96417d.f441502b.poster.nick.get(), this.f96417d.f441502b.poster.icon.get()), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I() {
        ExtraTypeInfo extraTypeInfo;
        ve0.b bVar = this.f96417d;
        if (bVar == null || (extraTypeInfo = bVar.f441505e) == null) {
            return "";
        }
        int i3 = extraTypeInfo.pageType;
        if (i3 != 7005) {
            switch (i3) {
                case 7000:
                case 7001:
                    return F();
                case 7002:
                    break;
                default:
                    return "";
            }
        }
        return H();
    }

    private void J() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        this.f96416c.getIntent().putExtra("big_brother_source_key", "dingyuehao");
        param.context = this.f96416c;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.f96423j = create;
        create.setItemClickListenerV2(this.f96424k);
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(10);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(39);
        this.f96423j.setActionSheetItems(D(arrayList), D(arrayList2));
        this.f96423j.setRowVisibility(8, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.f96420g != null) {
            return;
        }
        this.f96420g = new b();
        WXShareHelper.b0().A(this.f96420g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (!PermissionUtils.isStorePermissionEnable(this.f96416c)) {
            DialogUtil.showPermissionDialogForStorage(this.f96416c);
        } else {
            this.f96419f.d();
            this.f96418e.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SubscribeQRCodeShareHelper.this.A() && !SubscribeQRCodeShareHelper.this.f96416c.isFinishing()) {
                        SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                        String E = subscribeQRCodeShareHelper.E(subscribeQRCodeShareHelper.f96415b);
                        String E2 = SubscribeQRCodeShareHelper.this.E(AppConstants.SDCARD_IMG_SAVE);
                        if (!FileUtils.copyFile(E, E2)) {
                            QQToast.makeText(SubscribeQRCodeShareHelper.this.f96416c, "save failed", 0).show();
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(new File(E2)));
                        SubscribeQRCodeShareHelper.this.f96416c.sendBroadcast(intent);
                        MobileQQ.sMobileQQ.onSendBroadcast(SubscribeQRCodeShareHelper.this.f96416c, intent);
                        QQToast.makeText(SubscribeQRCodeShareHelper.this.f96416c, "save:" + E2, 0).show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f96419f.d();
        this.f96418e.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribeQRCodeShareHelper.this.A()) {
                    SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                    String E = subscribeQRCodeShareHelper.E(subscribeQRCodeShareHelper.f96415b);
                    File file = new File(E);
                    Intent intent = new Intent();
                    intent.putExtra("forward_type", 1);
                    intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, E);
                    intent.putExtra(AppConstants.Key.FORWARD_THUMB, E);
                    intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, true);
                    intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, file.toURI().toString());
                    intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, file.toURI().toString());
                    intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                    intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
                    intent.putExtra(ForwardRecentActivity.FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
                    intent.putExtra("filePath", E);
                    intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13);
                    intent.putExtra("reqType", 1);
                    ForwardBaseOption.startForwardActivityForResult(SubscribeQRCodeShareHelper.this.f96416c, intent, 21);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.f96419f.d();
        this.f96418e.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribeQRCodeShareHelper.this.A()) {
                    SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                    QZoneHelper.forwardToPublishMood(SubscribeQRCodeShareHelper.this.f96416c, QZoneHelper.UserInfo.getInstance(), subscribeQRCodeShareHelper.E(subscribeQRCodeShareHelper.f96415b), "\u5199\u8bf4\u8bf4", SubscribeShareHelper.x(SubscribeQRCodeShareHelper.this.f96417d), 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final int i3) {
        if (z()) {
            this.f96419f.d();
            this.f96418e.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
                @Override // java.lang.Runnable
                public void run() {
                    SubscribeQRCodeShareHelper.this.K();
                    if (SubscribeQRCodeShareHelper.this.f96416c != null && !SubscribeQRCodeShareHelper.this.f96416c.isFinishing() && SubscribeQRCodeShareHelper.this.A()) {
                        SubscribeQRCodeShareHelper subscribeQRCodeShareHelper = SubscribeQRCodeShareHelper.this;
                        String E = subscribeQRCodeShareHelper.E(subscribeQRCodeShareHelper.f96415b);
                        Bitmap h16 = SubscribeQRCodeShareHelper.this.f96419f.h();
                        SubscribeQRCodeShareHelper.this.f96421h = String.valueOf(System.currentTimeMillis());
                        QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + E);
                        if (SubscribeQRCodeShareHelper.this.x() && SubscribeQRCodeShareHelper.this.y()) {
                            SubscribeQRCodeShareHelper subscribeQRCodeShareHelper2 = SubscribeQRCodeShareHelper.this;
                            E = subscribeQRCodeShareHelper2.G(subscribeQRCodeShareHelper2.f96416c, E);
                        }
                        QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + E);
                        WXShareHelper.b0().v0(E, h16, ScreenUtil.dip2px(270.0f) / 2, i3, SubscribeQRCodeShareHelper.this.f96421h);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(final AbsSubscribeShareCardView absSubscribeShareCardView) {
        if (this.f96423j == null) {
            J();
        }
        ShareActionSheet shareActionSheet = this.f96423j;
        if (shareActionSheet != null && !shareActionSheet.isShowing()) {
            this.f96423j.show();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3

                /* compiled from: P */
                /* renamed from: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper$3$a */
                /* loaded from: classes5.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        SubscribeQRCodeShareHelper.this.f96423j.dismiss();
                        SubscribeQRCodeShareHelper.this.f96423j = null;
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    SubscribeQRCodeShareHelper.this.R(false);
                    int actionSheetPanelViewHeight = SubscribeQRCodeShareHelper.this.f96423j.getActionSheetPanelViewHeight();
                    if (!ScreenUtil.checkDeviceHasNavigationBar(SubscribeQRCodeShareHelper.this.f96416c)) {
                        i3 = ScreenUtil.getRealHeight(SubscribeQRCodeShareHelper.this.f96416c);
                    } else {
                        i3 = ScreenUtil.SCREEN_HIGHT;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (i3 - LiuHaiUtils.getStatusBarHeight(SubscribeQRCodeShareHelper.this.f96416c)) - actionSheetPanelViewHeight);
                    SubscribeQRCodeShareHelper.this.f96423j.setAdvBgColor(0);
                    RelativeLayout relativeLayout = new RelativeLayout(SubscribeQRCodeShareHelper.this.f96416c);
                    relativeLayout.setLayoutParams(layoutParams);
                    relativeLayout.setBackgroundColor(0);
                    relativeLayout.setOnClickListener(new a());
                    ImageView imageView = new ImageView(SubscribeQRCodeShareHelper.this.f96416c);
                    imageView.setOnClickListener(new b());
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(225.0f), ScreenUtil.dip2px(420.0f));
                    layoutParams2.addRule(13);
                    relativeLayout.addView(imageView, layoutParams2);
                    imageView.setImageBitmap(absSubscribeShareCardView.h());
                    SubscribeQRCodeShareHelper.this.f96423j.setAdvView(relativeLayout, layoutParams);
                }

                /* compiled from: P */
                /* renamed from: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper$3$b */
                /* loaded from: classes5.dex */
                class b implements View.OnClickListener {
                    b() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z16) {
        if (this.f96416c != null) {
            if (z16) {
                if (this.f96422i == null) {
                    this.f96422i = new com.tencent.biz.subscribe.widget.a(this.f96416c, "\u5361\u7247\u751f\u6210\u4e2d...");
                }
                if (!this.f96422i.isShowing() && !this.f96416c.isFinishing()) {
                    this.f96422i.show();
                    return;
                }
                return;
            }
            com.tencent.biz.subscribe.widget.a aVar = this.f96422i;
            if (aVar != null && aVar.isShowing() && !this.f96416c.isFinishing()) {
                this.f96422i.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        if (WXShareHelper.b0().Z() != null && WXShareHelper.b0().Z().getWXAppSupportAPI() >= 654314752) {
            return true;
        }
        return false;
    }

    private boolean z() {
        int i3;
        if (!WXShareHelper.b0().e0()) {
            i3 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i3 = R.string.f173258ih2;
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            h.T(0, i3);
            return false;
        }
        return true;
    }

    public void B(ve0.b bVar) {
        if (!PermissionUtils.isStorePermissionEnable(this.f96416c)) {
            DialogUtil.showPermissionDialogForStorage(this.f96416c);
            return;
        }
        if (bVar != null && NetworkUtil.isNetworkAvailable(this.f96416c)) {
            this.f96417d = bVar;
            R(true);
            this.f96418e.post(new AnonymousClass2());
        } else {
            QQToast.makeText(this.f96416c, 1, R.string.g8_, 1).show();
            QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        }
    }

    public void L() {
        WXShareHelper.b0().q0(this.f96420g);
        this.f96418e.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.10
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.delete(SubscribeQRCodeShareHelper.f96413l, true);
            }
        });
        R(false);
    }
}
