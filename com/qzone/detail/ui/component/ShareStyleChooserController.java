package com.qzone.detail.ui.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.detail.ui.component.QRCodeShareViewBuilder;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShareStyleChooserController {

    /* renamed from: a, reason: collision with root package name */
    private final b f47021a;

    /* renamed from: b, reason: collision with root package name */
    private int f47022b = 1;

    /* renamed from: c, reason: collision with root package name */
    public Context f47023c;

    /* renamed from: d, reason: collision with root package name */
    public FrameLayout f47024d;

    /* renamed from: e, reason: collision with root package name */
    private View f47025e;

    /* renamed from: f, reason: collision with root package name */
    private QRCodeShareViewBuilder f47026f;

    /* renamed from: g, reason: collision with root package name */
    private a f47027g;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f47030a;

        /* renamed from: b, reason: collision with root package name */
        public String f47031b;

        /* renamed from: c, reason: collision with root package name */
        public String f47032c;

        /* renamed from: d, reason: collision with root package name */
        public String f47033d;

        /* renamed from: e, reason: collision with root package name */
        public long f47034e;

        /* renamed from: f, reason: collision with root package name */
        public long f47035f;

        /* renamed from: g, reason: collision with root package name */
        public String f47036g;

        /* renamed from: h, reason: collision with root package name */
        public String f47037h;

        /* renamed from: i, reason: collision with root package name */
        public int f47038i;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(View view);

        void b();
    }

    public ShareStyleChooserController(Context context, Intent intent, b bVar) {
        this.f47021a = bVar;
        i(context);
        h(intent);
    }

    private void k() {
        this.f47026f = new QRCodeShareViewBuilder(this.f47023c, this.f47027g, new QRCodeShareViewBuilder.b() { // from class: com.qzone.detail.ui.component.ShareStyleChooserController.1
            @Override // com.qzone.detail.ui.component.QRCodeShareViewBuilder.b
            public void a(View view) {
                if (view != null) {
                    ShareStyleChooserController.this.f47025e = view;
                    Context context = ShareStyleChooserController.this.f47023c;
                    if (context == null || !(context instanceof Activity)) {
                        return;
                    }
                    ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qzone.detail.ui.component.ShareStyleChooserController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ShareStyleChooserController shareStyleChooserController = ShareStyleChooserController.this;
                            if (shareStyleChooserController.f47024d != null && shareStyleChooserController.f47025e != null) {
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ar.e(100.0f), ar.e(178.5f));
                                layoutParams.gravity = 1;
                                ShareStyleChooserController shareStyleChooserController2 = ShareStyleChooserController.this;
                                shareStyleChooserController2.f47024d.addView(shareStyleChooserController2.f47025e, layoutParams);
                            }
                            if (ShareStyleChooserController.this.f47021a != null) {
                                ShareStyleChooserController.this.f47022b = 1;
                                ShareStyleChooserController.this.f47021a.a(ShareStyleChooserController.this.e());
                            }
                        }
                    });
                    return;
                }
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGenerateQRCodeFail", "\u751f\u6210\u4e8c\u7ef4\u7801\u56fe\u7247\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"), 3);
                if (ShareStyleChooserController.this.f47021a != null) {
                    ShareStyleChooserController.this.f47021a.b();
                }
            }
        });
    }

    public View e() {
        return this.f47024d;
    }

    public void f(Handler handler) {
        QRCodeShareViewBuilder qRCodeShareViewBuilder = this.f47026f;
        if (qRCodeShareViewBuilder != null) {
            qRCodeShareViewBuilder.i(handler);
        }
    }

    public int g() {
        return this.f47022b;
    }

    private void h(Intent intent) {
        if (intent != null) {
            this.f47027g = new a();
            String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_UIN);
            this.f47027g.f47030a = Long.parseLong(stringExtra);
            this.f47027g.f47031b = intent.getStringExtra("title");
            this.f47027g.f47032c = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            this.f47027g.f47033d = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_DESCPTION);
            this.f47027g.f47038i = intent.getIntExtra("brand_flag", 0);
            if (TextUtils.isEmpty(this.f47027g.f47033d)) {
                this.f47027g.f47033d = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_USERHOME_MORE_MENU_SHARE_DESCRIPTION, com.qzone.util.l.a(R.string.tes));
            }
            this.f47027g.f47034e = intent.getLongExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, 0L);
            this.f47027g.f47035f = com.qzone.reborn.util.a.b(intent.getIntExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_VISITOR_COUNT, 0));
            this.f47027g.f47037h = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL);
            a aVar = this.f47027g;
            if (aVar.f47037h == null) {
                aVar.f47037h = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_USERHOME_MORE_MENU_SHARE_BACKGROUND_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20170808105528_mupoTSBZ1C.png");
            }
            this.f47027g.f47036g = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL);
            if (this.f47027g.f47036g == null) {
                String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_FAMOUS_HOME_SHARE_QRCODE, "https://mp.qzone.qq.com/u/{uin}?uin={uin}&is_famous_space={is_famous_space}&brand_flag={brand_flag}");
                config.replace("{uin}", String.valueOf(this.f47027g.f47030a));
                config.replace("{brand_flag}", String.valueOf(this.f47027g.f47038i));
                config.replace("{is_famous_space}", String.valueOf(1));
                this.f47027g.f47036g = config;
            }
            k();
        }
    }

    private void i(Context context) {
        if (context != null) {
            this.f47023c = context;
            this.f47024d = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.f169041hm4, (ViewGroup) null);
        }
    }

    public static String j(long j3) {
        if (j3 < 0) {
            return String.valueOf(0);
        }
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 10000000) {
            return String.valueOf(j3 / 10000) + com.qzone.util.l.a(R.string.tet);
        }
        return String.valueOf(j3 / 10000) + com.qzone.util.l.a(R.string.teu);
    }
}
