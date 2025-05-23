package com.tencent.mobileqq.teamworkforgroup;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.be;
import com.tencent.mobileqq.teamwork.k;
import com.tencent.mobileqq.teamwork.o;
import com.tencent.mobileqq.teamwork.s;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkTransparentShareActivity extends BaseActivity implements k.a, Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    public String f292509a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f292510b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f292511c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f292512d0;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<s.b> f292513e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.mobileqq.teamwork.k f292514f0;

    /* renamed from: g0, reason: collision with root package name */
    private ITeamWorkHandler f292515g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f292516h0;

    /* renamed from: k0, reason: collision with root package name */
    private String f292519k0;

    /* renamed from: m0, reason: collision with root package name */
    public long f292521m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f292522n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f292523o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f292524p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f292525q0;

    /* renamed from: u0, reason: collision with root package name */
    WXShareHelper.a f292529u0;

    /* renamed from: v0, reason: collision with root package name */
    MqqHandler f292530v0;

    /* renamed from: w0, reason: collision with root package name */
    private o f292531w0;

    /* renamed from: y0, reason: collision with root package name */
    private ResultReceiver f292533y0;

    /* renamed from: i0, reason: collision with root package name */
    Map<String, s.b> f292517i0 = new HashMap();

    /* renamed from: j0, reason: collision with root package name */
    private boolean f292518j0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private int f292520l0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    protected String f292526r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    protected String f292527s0 = null;

    /* renamed from: t0, reason: collision with root package name */
    protected String f292528t0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private final MqqHandler f292532x0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f292534d;

        a(String str) {
            this.f292534d = str;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            if (!this.f292534d.equals(baseResp.transaction)) {
                return;
            }
            BaseApplication.getContext();
            int i3 = baseResp.errCode;
            if (i3 != -2) {
                if (i3 != 0) {
                    com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                } else {
                    com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                }
            }
            WXShareHelper.b0().q0(TeamWorkTransparentShareActivity.this.f292529u0);
        }
    }

    private void F2() {
        Intent intent = getIntent();
        this.f292516h0 = intent.getStringExtra(t.f292396a);
        this.f292526r0 = intent.getStringExtra(t.f292397b);
        this.f292527s0 = intent.getStringExtra(t.f292398c);
        this.f292528t0 = intent.getStringExtra(t.f292399d);
        this.f292509a0 = intent.getStringExtra("team_work_pad_url");
        this.f292510b0 = intent.getIntExtra("team_work_pad_list_type", -1);
        this.f292511c0 = intent.getIntExtra("team_work_pad_type", -1);
        this.f292512d0 = intent.getIntExtra("team_policy", -1);
        this.f292521m0 = intent.getLongExtra(ITeamWorkDocEditBrowserProxy.KEY_GROUP_TEAM_WORK_DOC_GROUP_UIN, 0L);
        this.f292522n0 = intent.getIntExtra(ITeamWorkDocEditBrowserProxy.KEY_GROUP_TEAM_WORK_DOC_DOMAIN_ID, 0);
        this.f292523o0 = intent.getStringExtra(ITeamWorkDocEditBrowserProxy.KEY_GROUP_TEAM_WORK_DOC_PAD_ID);
        this.f292524p0 = intent.getStringExtra(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_TITLE);
        this.f292525q0 = intent.getStringExtra("troop_name");
        this.f292513e0 = new ArrayList<>();
        this.f292518j0 = intent.getBooleanExtra("team_is_my_document", false);
        this.f292519k0 = intent.getStringExtra("from_activity");
        this.f292520l0 = intent.getIntExtra("select_type", -1);
        this.f292531w0 = (o) getIntent().getParcelableExtra("team_work_auth_info");
        if (this.f292512d0 == -1 && QLog.isColorLevel()) {
            QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo policy cannot be -1");
        }
        if (this.f292510b0 == -1 && QLog.isColorLevel()) {
            QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mPadListType cannot be -1");
        }
        this.f292533y0 = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
    }

    private void initUI() {
        this.f292530v0 = new MqqHandler();
        this.app.setHandler(getClass(), this.f292532x0);
        if (this.f292514f0 == null) {
            this.f292514f0 = ((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getShareUtils(this, this.app);
        }
        if (!TextUtils.isEmpty(this.f292509a0)) {
            if (TextUtils.isEmpty(this.f292526r0)) {
                this.f292526r0 = getString(R.string.f173203hz3);
                if (this.f292511c0 == 2) {
                    this.f292526r0 = getString(R.string.hz4);
                }
            }
            if (TextUtils.isEmpty(this.f292527s0)) {
                this.f292527s0 = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
                String c16 = be.c();
                if (!TextUtils.isEmpty(c16)) {
                    this.f292527s0 = c16;
                }
                if (this.f292511c0 == 2) {
                    this.f292527s0 = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
                    String d16 = be.d();
                    if (!TextUtils.isEmpty(d16)) {
                        this.f292527s0 = d16;
                    }
                }
            }
            if (TextUtils.isEmpty(this.f292528t0)) {
                this.f292528t0 = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
                String a16 = be.a();
                if (!TextUtils.isEmpty(a16)) {
                    this.f292528t0 = a16;
                }
                if (this.f292511c0 == 2) {
                    this.f292528t0 = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
                    String b16 = be.b();
                    if (!TextUtils.isEmpty(b16)) {
                        this.f292528t0 = b16;
                    }
                }
            }
            this.f292514f0.d(this.f292509a0, this.f292516h0, this.f292526r0, "", this.f292511c0);
            if (this.f292518j0) {
                this.f292514f0.c(false);
            } else {
                this.f292514f0.c(true);
            }
            this.f292514f0.a(this);
            this.f292514f0.showActionSheet();
            return;
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        setContentView(R.layout.c0m);
        F2();
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.f292514f0.destroy();
        if (this.f292529u0 != null) {
            WXShareHelper.b0().q0(this.f292529u0);
            this.f292529u0 = null;
        }
        MqqHandler mqqHandler = this.f292530v0;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        o oVar = this.f292531w0;
        if (oVar != null && oVar.f292298d) {
            this.f292515g0 = (ITeamWorkHandler) this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
            return;
        }
        com.tencent.mobileqq.teamwork.k kVar = this.f292514f0;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.k.a
    public void onClosePanel() {
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.teamwork.k.a
    public void onItemClick(int i3) {
        int i16;
        String str;
        String str2;
        String str3;
        String noParamUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(this.f292509a0);
        String str4 = null;
        int i17 = 0;
        if (i3 == 2) {
            String string = getString(R.string.hz5);
            if (TextUtils.isEmpty(this.f292527s0)) {
                str2 = null;
            } else {
                str2 = this.f292527s0;
            }
            String str5 = this.f292516h0;
            if (TextUtils.isEmpty(this.f292526r0)) {
                str3 = noParamUrl;
            } else {
                str3 = this.f292526r0;
            }
            ShareMsgHelper.f(this, 1001, 95, "web_share", "", str2, str5, str3, getString(R.string.f171308dy0, this.f292516h0), noParamUrl, "web", null, null, null, "web", null, null, null, ITeamWorkUtils.DOCS_SOURCE_ICON_URL, string, "", null, -1, ITeamWorkUtils.DOCS_LIST_URL, -1L);
            finish();
            return;
        }
        if (i3 != 9 && i3 != 10) {
            if (i3 == 12) {
                String str6 = this.f292516h0;
                String str7 = this.f292527s0;
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(this.f292509a0) && !TextUtils.isEmpty(str6)) {
                    try {
                        String str8 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str6 + " (\u5206\u4eab\u81ea#\u817e\u8baf\u6587\u6863#) ", "UTF-8")) + "&url=" + URLEncoder.encode(noParamUrl, "UTF-8")) + "&pic=" + URLEncoder.encode(str7, "UTF-8")) + "&_wv=0";
                        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", str8);
                        startActivity(intent);
                    } catch (Exception e16) {
                        QQToast.makeText(getApplicationContext(), 1, R.string.hij, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        QLog.e("TeamWorkTransparentShareActivity", 1, " ==== share to weibo exp: " + e16.toString());
                    }
                } else {
                    QQToast.makeText(getApplicationContext(), 1, R.string.hij, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
                finish();
                return;
            }
            if (i3 == 11) {
                String currentAccountUin = this.app.getCurrentAccountUin();
                try {
                    str4 = URLEncoder.encode(this.f292509a0, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TeamWorkTransparentShareActivity", 2, "encode shareUrl failed, because UTF-8 is unknown");
                    }
                }
                Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str4 + "&qq=" + currentAccountUin + "&_wv=7");
                intent2.putExtra("hide_more_button", true);
                startActivity(intent2);
                finish();
                return;
            }
            if (i3 == 1) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u6211\u5206\u4eab\u4e86\u817e\u8baf\u6587\u6863 \u201c");
                sb5.append(this.f292516h0);
                sb5.append("\u201d\uff0c\u70b9\u51fb\u67e5\u770b\uff1a\n");
                sb5.append(noParamUrl);
                sb5.append(" ");
                clipboardManager.setText(sb5);
                com.tencent.biz.qrcode.util.h.T(2, R.string.aev);
                finish();
                return;
            }
            if (i3 == 26) {
                Intent intent3 = new Intent(this, (Class<?>) DirectForwardActivity.class);
                intent3.putExtra("isFromShare", true);
                intent3.putExtra("isFromTeamWork", true);
                intent3.putExtra("toUin", AppConstants.DATALINE_PC_UIN);
                intent3.putExtra("uinType", 6000);
                intent3.putExtra("forward_type", -1);
                intent3.putExtra(AppConstants.Key.FORWARD_TEXT, noParamUrl);
                intent3.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                startActivity(intent3);
                finish();
                return;
            }
            return;
        }
        if (!WXShareHelper.b0().e0()) {
            i16 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i16 = R.string.f173258ih2;
        } else {
            i16 = -1;
        }
        if (i16 != -1) {
            com.tencent.biz.qrcode.util.h.T(0, i16);
        } else {
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (this.f292529u0 == null) {
                this.f292529u0 = new a(valueOf);
            }
            if (i3 == 9) {
                WXShareHelper.b0().A(this.f292529u0);
                String str9 = "pages/detail/detail?url=" + noParamUrl;
                if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isBase64ImgFormatData(this.f292528t0)) {
                    Bitmap shareBitMapBase64 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getShareBitMapBase64(this.f292528t0);
                    if (shareBitMapBase64 != null) {
                        WXShareHelper.b0().y0(str9, "gh_252c5f06840b", shareBitMapBase64, this.f292516h0, this.f292526r0, noParamUrl);
                    } else {
                        WXShareHelper.b0().y0(str9, "gh_252c5f06840b", ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.f292511c0), this.f292516h0, this.f292526r0, noParamUrl);
                    }
                } else {
                    WXShareHelper.b0().y0(str9, "gh_252c5f06840b", ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.f292511c0), this.f292516h0, this.f292526r0, noParamUrl);
                }
            } else if (i3 == 10) {
                WXShareHelper.b0().A(this.f292529u0);
                WXShareHelper b06 = WXShareHelper.b0();
                String str10 = this.f292516h0;
                Bitmap teamWorkForShareBitMap = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(this.f292511c0);
                if (TextUtils.isEmpty(this.f292526r0)) {
                    str = noParamUrl;
                } else {
                    str = this.f292526r0;
                }
                if (i3 != 9) {
                    i17 = 1;
                }
                b06.L0(valueOf, str10, teamWorkForShareBitMap, str, noParamUrl, i17);
            }
        }
        finish();
    }
}
