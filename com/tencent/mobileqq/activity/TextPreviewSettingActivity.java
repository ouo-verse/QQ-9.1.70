package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class TextPreviewSettingActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private View f177245a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f177246b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f177247c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f177248d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f177249e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f177250f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f177251g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f177252h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f177253i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f177254j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f177255k0;

    /* renamed from: l0, reason: collision with root package name */
    ExtensionInfo f177256l0;

    /* renamed from: m0, reason: collision with root package name */
    private Handler f177257m0;

    /* renamed from: n0, reason: collision with root package name */
    private IFontManagerService f177258n0;

    /* renamed from: o0, reason: collision with root package name */
    com.tencent.mobileqq.vip.f f177259o0;

    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextPreviewSettingActivity.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            ImageView imageView = (ImageView) TextPreviewSettingActivity.this.findViewById(R.id.f165264ci3);
            int i3 = message.what;
            if (i3 != 16) {
                if (i3 != 18) {
                    if (i3 == 19) {
                        Object obj = message.obj;
                        if (obj instanceof Bitmap) {
                            imageView.setImageBitmap((Bitmap) obj);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof Drawable) {
                    imageView.setImageDrawable((Drawable) obj2);
                    return;
                }
                return;
            }
            imageView.setImageDrawable(TextPreviewSettingActivity.this.f177258n0.getFontNameDrawable(TextPreviewSettingActivity.this.f177252h0));
        }
    }

    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        b(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TextPreviewSettingActivity.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + gVar);
            }
            super.onCancel(gVar);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            if (QLog.isColorLevel()) {
                QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + gVar);
            }
            if (gVar.j()) {
                return;
            }
            if (gVar.i() == -1) {
                Message message = new Message();
                message.what = 17;
                TextPreviewSettingActivity.this.f177257m0.sendMessage(message);
                return;
            }
            Drawable fontNameDrawable = TextPreviewSettingActivity.this.f177258n0.getFontNameDrawable(TextPreviewSettingActivity.this.f177252h0);
            if (fontNameDrawable != null) {
                Message message2 = new Message();
                message2.what = 18;
                message2.obj = fontNameDrawable;
                TextPreviewSettingActivity.this.f177257m0.sendMessage(message2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + gVar);
            }
            return super.onStart(gVar);
        }
    }

    public TextPreviewSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177251g0 = 0;
        this.f177252h0 = 0;
        this.f177253i0 = 0;
        this.f177255k0 = null;
        this.f177256l0 = null;
        this.f177259o0 = new b(AppConstants.FlowStatPram.PARAM_WIFIBUBBLE_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGBUBBLE_DOWNLOAD_FLOW);
    }

    private void J2() {
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        TextView textView;
        BubbleManager bubbleManager = (BubbleManager) this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        com.tencent.mobileqq.bubble.c F = bubbleManager.F(this.f177249e0, true);
        if (F == null) {
            F = com.tencent.mobileqq.bubble.f.f200742a;
        }
        String str2 = this.f177255k0;
        if (str2 != null && !str2.equals(this.app.getAccount())) {
            z16 = false;
        } else {
            z16 = true;
        }
        TextView textView2 = (TextView) findViewById(R.id.alk);
        if (this.f177250f0 > 0 && F != com.tencent.mobileqq.bubble.f.f200742a) {
            HashMap<String, com.tencent.mobileqq.bubble.g> hashMap = BubbleDiyFetcher.m().f200571i.get(Integer.valueOf(this.f177249e0));
            if (hashMap != null && hashMap.size() > 0) {
                Iterator<com.tencent.mobileqq.bubble.g> it = hashMap.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().f200749d.equalsIgnoreCase("static")) {
                            z18 = true;
                            break;
                        }
                    } else {
                        z18 = false;
                        break;
                    }
                }
                if (!z18 && (textView = (TextView) super.findViewById(R.id.alh)) != null) {
                    textView.setText(getResources().getText(R.string.f170288lg));
                }
            }
            F.c(this.app, z16, true, false, textView2, this.f177255k0, this.f177250f0);
        } else {
            F.d(this.app, z16, true, false, textView2, false);
        }
        com.tencent.mobileqq.bubble.b z19 = bubbleManager.z(F.f200668a, true);
        String qqStr = HardCodeUtil.qqStr(R.string.u3e);
        if (z16) {
            str = "#FFFFFF";
        } else {
            str = "#808080";
        }
        int parseColor = Color.parseColor(str);
        File file = new File(F.f200669b);
        if (z19 != null && file.exists()) {
            qqStr = z19.f200645b;
            parseColor = z19.f200646c;
        }
        TextView textView3 = (TextView) findViewById(R.id.ali);
        textView3.setText(qqStr);
        textView3.setTextColor(parseColor);
        IFontManagerService iFontManagerService = (IFontManagerService) this.app.getRuntimeService(IFontManagerService.class, "");
        this.f177258n0 = iFontManagerService;
        if (iFontManagerService != null) {
            z17 = iFontManagerService.isSupportFont();
        } else {
            z17 = false;
        }
        ImageView imageView = (ImageView) findViewById(R.id.f165264ci3);
        if (z17) {
            if (this.f177252h0 == -1) {
                ExtensionInfo extensionInfo = this.f177256l0;
                if (extensionInfo != null) {
                    this.f177252h0 = (int) extensionInfo.uVipFont;
                    this.f177253i0 = extensionInfo.vipFontType;
                } else {
                    this.f177252h0 = 0;
                }
            }
            Drawable drawable = getResources().getDrawable(R.drawable.btv);
            if (this.f177252h0 != 0) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.TextPreviewSettingActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextPreviewSettingActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        Drawable fontNameDrawable = TextPreviewSettingActivity.this.f177258n0.getFontNameDrawable(TextPreviewSettingActivity.this.f177252h0);
                        if (fontNameDrawable == null) {
                            int i3 = TextPreviewSettingActivity.this.f177252h0;
                            TextPreviewSettingActivity textPreviewSettingActivity = TextPreviewSettingActivity.this;
                            TextPreviewSettingActivity.K2(i3, textPreviewSettingActivity.app, textPreviewSettingActivity.f177259o0);
                        } else {
                            Message obtainMessage = TextPreviewSettingActivity.this.f177257m0.obtainMessage(18);
                            obtainMessage.obj = fontNameDrawable;
                            TextPreviewSettingActivity.this.f177257m0.sendMessage(obtainMessage);
                        }
                    }
                }, 8, null, true);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void K2(int i3, QQAppInterface qQAppInterface, com.tencent.mobileqq.vip.f fVar) {
        File file = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH + File.separatorChar + i3 + File.separatorChar + "fontname.png");
        String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.FONT_AIO_IMG);
        if (!TextUtils.isEmpty(url)) {
            url = url.replace("[id]", Integer.toString(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("TextPreviewSettingActivity", 2, "getFontInfo fontId=" + i3 + " will down ,file path=" + file.getAbsolutePath());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("font_id", i3);
        ((DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(new com.tencent.mobileqq.vip.g(url, file), fVar, bundle);
    }

    private void L2() {
        Intent intent = getIntent();
        this.f177249e0 = intent.getIntExtra("bubbleId", 0);
        int intExtra = intent.getIntExtra("bubbleDiyId", 0);
        this.f177250f0 = intExtra;
        if (intExtra == 0) {
            this.f177250f0 = SVIPHandlerConstants.resolveDiyBubbleTextId(intent.getLongExtra("bubbleId", 0L));
        }
        this.f177251g0 = intent.getIntExtra("HiBoomId", 0);
        this.f177252h0 = intent.getIntExtra(MessageForRichState.SIGN_MSG_FONT_ID, 0);
        this.f177254j0 = intent.getIntExtra("fontEffectId", 0);
        this.f177255k0 = intent.getStringExtra("real_msg_sender_uin");
        this.f177254j0 = intent.getIntExtra("fontEffectId", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v2 */
    private void M2() {
        ?? r112;
        boolean z16;
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (eVar != null) {
            if (eVar.a("100005.100003") != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            r112 = z16;
        } else {
            r112 = 0;
        }
        intent.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, (boolean) r112);
        intent.putExtra("scrollToBubble", true);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
        String marketDetailUrl = IndividuationUrlHelper.getMarketDetailUrl(this, IndividuationUrlHelper.UrlId.BUBBLE_DETAIL, String.valueOf(this.f177249e0), IndividuationUrlHelper.AdTag.INDIVIDUATION_BUBBLE_ADTAG);
        BubbleDiyFetcher m3 = BubbleDiyFetcher.m();
        String str = this.f177255k0 + "_" + this.f177250f0;
        if (this.f177250f0 > 0) {
            String str2 = m3.f200564b.get(str);
            HashMap<String, String> hashMap = m3.f200565c.get(str);
            if (hashMap != null && hashMap.size() > 0) {
                String str3 = hashMap.get("TL");
                if (!TextUtils.isEmpty(str3)) {
                    marketDetailUrl = HtmlOffline.b(marketDetailUrl, "tl=" + str3);
                }
                String str4 = hashMap.get("TR");
                if (!TextUtils.isEmpty(str4)) {
                    marketDetailUrl = HtmlOffline.b(marketDetailUrl, "tr=" + str4);
                }
                String str5 = hashMap.get("BL");
                if (!TextUtils.isEmpty(str5)) {
                    marketDetailUrl = HtmlOffline.b(marketDetailUrl, "bl=" + str5);
                }
                String str6 = hashMap.get("BR");
                if (!TextUtils.isEmpty(str6)) {
                    marketDetailUrl = HtmlOffline.b(marketDetailUrl, "br=" + str6);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    marketDetailUrl = HtmlOffline.b(marketDetailUrl, "diyText=" + URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("TextPreviewSettingActivity", 1, "URLEncoder.encode error!", e16);
                }
            }
        }
        String str7 = marketDetailUrl;
        if (QLog.isColorLevel()) {
            QLog.i("TextPreviewSettingActivity", 2, "TextPreviewActivity bubble url: " + com.tencent.biz.common.util.k.f(str7, new String[0]));
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this, str7, 64L, intent, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.f177255k0, "bigtextpage", "bubble_enter", "", 1, 0, r112, "", String.valueOf(this.f177249e0), "");
    }

    private void N2() {
        if (this.f177251g0 > 0) {
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, this.f177251g0);
            intent.putExtra(EmotionConstants.FROM_AIO, true);
            intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
            VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.getMarketDetailUrl(this, IndividuationUrlHelper.UrlId.FONT_DETAIL, String.valueOf(this.f177251g0), IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG), 4096L, intent, false, -1);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.f177251g0, "");
            return;
        }
        com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        boolean z16 = false;
        if (eVar != null && eVar.a("100005.100011") != -1) {
            z16 = true;
        }
        Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent2.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, z16);
        intent2.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, this.f177252h0);
        intent2.putExtra(EmotionConstants.FROM_AIO, true);
        intent2.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.getMarketDetailUrl(this, IndividuationUrlHelper.UrlId.FONT_DETAIL, String.valueOf(this.f177252h0), IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG), 4096L, intent2, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.f177255k0, "bigtextpage", "font_enter", "", 1, 0, z16 ? 1 : 0, "", String.valueOf(this.f177252h0), "");
    }

    private void P2() {
        String marketUrl;
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
        if (this.f177254j0 == 0) {
            marketUrl = IndividuationUrlHelper.getMarketUrl(this, IndividuationUrlHelper.UrlId.FONT_EFFECT_NONE, null);
            if (TextUtils.isEmpty(marketUrl)) {
                marketUrl = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
            }
        } else {
            marketUrl = IndividuationUrlHelper.getMarketUrl(this, IndividuationUrlHelper.UrlId.FONT_EFFECT, null);
            if (TextUtils.isEmpty(marketUrl)) {
                marketUrl = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
            }
        }
        if (!TextUtils.isEmpty(marketUrl)) {
            String replace = marketUrl.replace("[id]", this.f177254j0 + "");
            if (QLog.isColorLevel()) {
                QLog.i("TextPreviewSettingActivity", 2, "mFontEffectId=" + this.f177254j0 + " url=" + replace);
            }
            VasWebviewUtil.openQQBrowserWithoutAD(this, replace, 0L, intent, false, -1);
        } else {
            QLog.e("TextPreviewSettingActivity", 2, "url is empty.");
        }
        VasWebviewUtil.reportCommercialDrainage(this.f177255k0, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.f177254j0), "");
    }

    private void Q2() {
        int i3;
        long j3;
        Object obj;
        String str;
        int i16;
        com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (eVar != null) {
            if (eVar.a("100005.100006") != -1) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            i3 = i16;
        } else {
            i3 = 0;
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("show_right_close_button", false);
        ExtensionInfo extensionInfo = this.f177256l0;
        if (extensionInfo != null) {
            j3 = extensionInfo.pendantId;
        } else {
            j3 = 0;
        }
        long j16 = j3;
        String marketDetailUrl = IndividuationUrlHelper.getMarketDetailUrl(this, IndividuationUrlHelper.UrlId.PENDANT_DETAIL, String.valueOf(j16), IndividuationUrlHelper.AdTag.DETAIL_PENDANT_ADTAG);
        LRULinkedHashMap<String, DiyPendantEntity> diyPendantCache = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().getDiyPendantCache();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f177255k0);
        sb5.append("_");
        ExtensionInfo extensionInfo2 = this.f177256l0;
        if (extensionInfo2 != null) {
            obj = Integer.valueOf(extensionInfo2.pendantDiyId);
        } else {
            obj = "";
        }
        sb5.append(obj);
        DiyPendantEntity diyPendantEntity = diyPendantCache.get(sb5.toString());
        if (diyPendantEntity != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<DiyPendantSticker> it = diyPendantEntity.getStickerInfoList().iterator();
            while (it.hasNext()) {
                DiyPendantSticker next = it.next();
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(next.type);
                objArr[1] = Integer.valueOf(next.stickerId);
                objArr[2] = Integer.valueOf(next.angle);
                String str2 = "0";
                if (TextUtils.isEmpty(next.text)) {
                    str = "0";
                } else {
                    str = next.text;
                }
                objArr[3] = str;
                objArr[4] = Integer.valueOf(next.fontId);
                if (!TextUtils.isEmpty(next.fontColor)) {
                    str2 = next.fontColor;
                }
                objArr[5] = str2;
                objArr[6] = Integer.valueOf(next.fontType);
                arrayList.add(String.format("%d,%d,%d,%s,%d,%s,%d", objArr));
            }
            String join = TextUtils.join(";", arrayList);
            if (!TextUtils.isEmpty(join)) {
                marketDetailUrl = HtmlOffline.b(marketDetailUrl, "stickerInfo=" + URLEncoder.encode(join));
            }
        }
        String str3 = marketDetailUrl;
        intent.putExtra("url", str3);
        intent.putExtra("business", 512L);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
        intent.putExtra("isShowAd", false);
        VasWebviewUtil.openQQBrowserWithoutAD(this, str3, 512L, intent, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.f177255k0, "bigtextpage", "pendant_enter", "", 1, 0, i3, "", String.valueOf(j16), "");
    }

    private void R2(AppInterface appInterface) {
        Drawable drawable;
        if (appInterface != null) {
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, 4, this.f177255k0);
            ExtensionInfo extensionInfo = this.f177256l0;
            if (extensionInfo != null && extensionInfo.isPendantValid()) {
                drawable = ((com.tencent.mobileqq.vas.b) appInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).getPendantInfo(this.f177256l0.pendantId).getDrawable(2, PendantConstant.PENDANT_TARGET_ID_ALL, this.f177255k0, this.f177256l0.pendantDiyId, true);
            } else {
                drawable = null;
            }
            ((ImageView) findViewById(R.id.head)).setImageDrawable(faceDrawable);
            ((ImageView) findViewById(R.id.f166495fl1)).setImageDrawable(drawable);
        }
    }

    void S2(int i3) {
        IFontManagerService iFontManagerService = (IFontManagerService) this.app.getRuntimeService(IFontManagerService.class, "");
        if (i3 == 0) {
            i3 = iFontManagerService.getFontEffectPrefer();
        }
        Drawable drawable = getResources().getDrawable(R.drawable.h_h);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable2 = getResources().getDrawable(R.drawable.h_h);
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = drawable2;
        if (i3 != 2000) {
            drawable = getResources().getDrawable(R.drawable.foo);
        } else {
            iFontManagerService.getEnlargeFontDesc();
            try {
                drawable = URLDrawable.getDrawable(iFontManagerService.getEnlargeFontImgURL(), obtain);
            } catch (Exception e16) {
                QLog.e("TextPreviewSettingActivity", 1, "font effect exception, " + e16.getMessage());
            }
        }
        ((ImageView) findViewById(R.id.elb)).setImageDrawable(drawable);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (intent != null) {
            ForwardUtils.V(this.app, intent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.c6m);
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TextPreviewSettingActivity", 2, "get AppInterface failed in TextPreviewSettingActivity#doOnCreate");
            }
            return false;
        }
        VasCommonReporter.getHistoryFeature("text_preview").setValue2(OperateCustomButton.OPERATE_CREATE).report(false);
        L2();
        this.f177256l0 = ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(this.f177255k0);
        setTitle(HardCodeUtil.qqStr(R.string.u36));
        setContentBackgroundResource(R.drawable.bg_texture);
        this.f177245a0 = findViewById(R.id.fkj);
        this.f177246b0 = findViewById(R.id.alc);
        this.f177247c0 = findViewById(R.id.chl);
        this.f177248d0 = findViewById(R.id.el_);
        R2(appInterface);
        this.f177245a0.setOnClickListener(this);
        this.f177246b0.setOnClickListener(this);
        this.f177247c0.setOnClickListener(this);
        this.f177248d0.setOnClickListener(this);
        this.f177257m0 = new a(Looper.getMainLooper());
        this.f177258n0 = (IFontManagerService) appInterface.getRuntimeService(IFontManagerService.class, "");
        S2(this.f177254j0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        J2();
        IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) this.app.getRuntimeService(IWebProcessManagerService.class, "");
        if (iWebProcessManagerService != null) {
            iWebProcessManagerService.startWebProcess(24, null);
        }
        BubbleDiyFetcher m3 = BubbleDiyFetcher.m();
        String str = this.f177255k0 + "_" + this.f177250f0;
        if (this.f177250f0 > 0) {
            if (!m3.f200564b.containsKey(str) || !m3.f200565c.containsKey(str)) {
                ThreadManagerV2.post(new Runnable(m3, str) { // from class: com.tencent.mobileqq.activity.TextPreviewSettingActivity.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ BubbleDiyFetcher f177260d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f177261e;

                    {
                        this.f177260d = m3;
                        this.f177261e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TextPreviewSettingActivity.this, m3, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f177260d.h(TextPreviewSettingActivity.this.app, this.f177261e, null);
                        }
                    }
                }, 5, null, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.fkj && id5 != R.id.fkp) {
                if (id5 != R.id.alc && id5 != R.id.alh) {
                    if (id5 != R.id.chl && id5 != R.id.chw) {
                        if (id5 == R.id.el_ || id5 == R.id.ela) {
                            P2();
                        }
                    } else {
                        N2();
                    }
                } else {
                    M2();
                }
            } else {
                Q2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
