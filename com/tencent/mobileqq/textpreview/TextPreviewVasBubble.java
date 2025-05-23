package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.e;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.util.LRULinkedHashMap;
import g33.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class TextPreviewVasBubble implements com.tencent.qqnt.textpreview.inject.b, View.OnClickListener {

    /* renamed from: k0, reason: collision with root package name */
    private static final int f292757k0 = ViewUtils.dpToPx(16.0f);

    /* renamed from: l0, reason: collision with root package name */
    public static final String f292758l0 = HardCodeUtil.qqStr(R.string.u3l);

    /* renamed from: m0, reason: collision with root package name */
    private static final String f292759m0 = HardCodeUtil.qqStr(R.string.u3g);
    protected int E;
    protected View G;
    protected View H;
    protected View I;
    public View J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private ImageView N;
    private TextView P;
    public RelativeLayout Q;
    protected View R;
    int S;
    URLImageView T;
    TextView U;
    Activity V;
    AppRuntime W;
    private qcUserinfoServer.UserItemDetail X;
    protected ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f292760a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f292761b0;

    /* renamed from: d, reason: collision with root package name */
    protected int f292763d;

    /* renamed from: e, reason: collision with root package name */
    protected int f292765e;

    /* renamed from: e0, reason: collision with root package name */
    public int f292766e0;

    /* renamed from: f, reason: collision with root package name */
    protected View f292767f;

    /* renamed from: f0, reason: collision with root package name */
    String f292768f0;

    /* renamed from: g0, reason: collision with root package name */
    protected URLImageView f292769g0;

    /* renamed from: h, reason: collision with root package name */
    protected View f292770h;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f292771h0;

    /* renamed from: i, reason: collision with root package name */
    protected View f292772i;

    /* renamed from: i0, reason: collision with root package name */
    Handler f292773i0;

    /* renamed from: m, reason: collision with root package name */
    int f292775m = 0;
    int C = 0;
    int D = 0;
    ExtensionInfo F = null;
    protected IFontManagerService Y = null;

    /* renamed from: c0, reason: collision with root package name */
    public String f292762c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public String f292764d0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected long f292774j0 = 0;

    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 16) {
                TextPreviewVasBubble textPreviewVasBubble = TextPreviewVasBubble.this;
                textPreviewVasBubble.Z.setImageDrawable(textPreviewVasBubble.Y.getFontNameDrawable(textPreviewVasBubble.C));
                return;
            }
            if (i3 == 18) {
                Object obj = message.obj;
                if (obj instanceof Drawable) {
                    TextPreviewVasBubble.this.Z.setImageDrawable((Drawable) obj);
                    return;
                }
                return;
            }
            if (i3 != 19) {
                return;
            }
            Object obj2 = message.obj;
            if (obj2 instanceof Bitmap) {
                TextPreviewVasBubble.this.Z.setImageBitmap((Bitmap) obj2);
            }
        }
    }

    private void f() {
        this.R.setVisibility(8);
    }

    private void h(Activity activity) {
        this.Q = (RelativeLayout) activity.findViewById(R.id.ti5);
        this.K = (ImageView) activity.findViewById(R.id.f164691ti2);
        this.L = (ImageView) activity.findViewById(R.id.ale);
        this.M = (TextView) activity.findViewById(R.id.tib);
        this.J = activity.findViewById(R.id.acz);
        this.N = (ImageView) activity.findViewById(R.id.f85324on);
        this.P = (TextView) activity.findViewById(R.id.ugp);
        if (this.E <= 0) {
            IConfigProxy iConfigProxy = VasLongToggle.TEXT_PREVIEW_CONFIG;
            if (iConfigProxy.isEnable(false) && (this.f292763d > 0 || this.C > 0)) {
                this.Q.setVisibility(0);
                this.M.setTextColor(activity.getResources().getColorStateList(R.color.qui_common_text_primary));
                this.P.setTextColor(activity.getResources().getColorStateList(R.color.qui_common_text_primary));
                Drawable drawable = activity.getResources().getDrawable(R.drawable.qui_chevron_right_selector);
                int i3 = f292757k0;
                drawable.setBounds(0, 0, i3, i3);
                this.P.setCompoundDrawables(null, null, drawable, null);
                if (QQTheme.isNowThemeIsNight()) {
                    Drawable[] compoundDrawables = this.P.getCompoundDrawables();
                    if (compoundDrawables.length > 2) {
                        Drawable drawable2 = compoundDrawables[2];
                        drawable2.mutate();
                        drawable2.setColorFilter(new LightingColorFilter(-16777216, Color.parseColor("#FFFFFF")));
                    }
                } else {
                    Drawable[] compoundDrawables2 = this.P.getCompoundDrawables();
                    if (compoundDrawables2.length > 2) {
                        Drawable drawable3 = compoundDrawables2[2];
                        drawable3.mutate();
                        drawable3.setColorFilter(new LightingColorFilter(-16777216, Color.parseColor("#000000")));
                    }
                }
                com.tencent.qqnt.utils.a.f363000a.b(this.K, "#d3d3d3");
                try {
                    JSONObject json = iConfigProxy.getJson();
                    if (json.has("detail_text")) {
                        this.P.setText(json.getString("detail_text"));
                    } else {
                        this.P.setText("\u70b9\u51fb\u67e5\u770b");
                    }
                } catch (Exception unused) {
                    this.P.setText("\u70b9\u51fb\u67e5\u770b");
                }
                this.M.setText("\u4e2a\u6027\u88c5\u626e");
                qcUserinfoServer.LoginInfo loginInfo = new qcUserinfoServer.LoginInfo();
                loginInfo.opplat.set(2);
                loginInfo.qqVer.set(BaseApplication.reportVersionName);
                qcUserinfoServer.GetUserOrFriendUsingReq getUserOrFriendUsingReq = new qcUserinfoServer.GetUserOrFriendUsingReq();
                getUserOrFriendUsingReq.isFriend.set(TextUtils.equals(this.f292768f0, this.W.getCurrentAccountUin()));
                getUserOrFriendUsingReq.stLogin.set(loginInfo);
                getUserOrFriendUsingReq.resource_from.set(1);
                getUserOrFriendUsingReq.bubbleItemID.set(this.f292763d);
                getUserOrFriendUsingReq.fontItemID.set(this.C);
                getUserOrFriendUsingReq.uid.set(Long.parseLong(this.W.getCurrentAccountUin()));
                getUserOrFriendUsingReq.appid_from.set(((AppInterface) this.W).getAppid());
                g33.b.f401206a.b(getUserOrFriendUsingReq, new b.a() { // from class: com.tencent.mobileqq.textpreview.TextPreviewVasBubble.3
                    @Override // g33.b.a
                    public void a(final qcUserinfoServer.GetUserOrFriendUsingRsp getUserOrFriendUsingRsp) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewVasBubble.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TextPreviewVasBubble.this.j(getUserOrFriendUsingRsp);
                            }
                        });
                    }
                });
                this.J.getLayoutParams().height = ViewUtils.dpToPx(16.0f);
                this.J.invalidate();
                return;
            }
        }
        this.Q.getLayoutParams().height = 0;
        this.Q.invalidate();
        ReportController.o(null, "dc00898", "", "", "0X800C4FC", "0X800C4FC", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(qcUserinfoServer.GetUserOrFriendUsingRsp getUserOrFriendUsingRsp) {
        for (qcUserinfoServer.UserItemDetail userItemDetail : getUserOrFriendUsingRsp.usingItemList.get()) {
            if ((userItemDetail.appId.get() == 2 && this.f292763d > 0) || (userItemDetail.appId.get() == 5 && this.C > 0)) {
                this.X = userItemDetail;
                ReportController.o(null, "dc00898", "", "", "0X800C4FE", "0X800C4FE", 0, userItemDetail.feeType.get(), "", "", String.valueOf(userItemDetail.appId.get()), "");
                this.M.setText(userItemDetail.name.get());
                String str = userItemDetail.image.get();
                if (!TextUtils.isEmpty(str)) {
                    this.L.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable(TextPreviewVasBubble.class.getName(), str));
                }
                com.tencent.qqnt.utils.a.f363000a.b(this.K, userItemDetail.itemBgColor.get());
                this.N.setImageDrawable(g(userItemDetail.feeType.get()));
                return;
            }
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public boolean b(MotionEvent motionEvent) {
        com.tencent.qqnt.utils.a aVar = com.tencent.qqnt.utils.a.f363000a;
        return aVar.a(this.R, (int) motionEvent.getRawY(), (int) motionEvent.getRawY()) || aVar.a(this.Q, (int) motionEvent.getRawY(), (int) motionEvent.getRawY());
    }

    void i(int i3) {
        String enlargeFontDesc;
        IFontManagerService iFontManagerService = (IFontManagerService) this.W.getRuntimeService(IFontManagerService.class, "");
        if (i3 == 0) {
            i3 = iFontManagerService.getFontEffectPrefer();
        }
        Drawable drawable = this.V.getResources().getDrawable(R.drawable.h_h);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable2 = this.V.getResources().getDrawable(R.drawable.h_h);
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = drawable2;
        if (i3 != 2000) {
            enlargeFontDesc = (String) this.V.getResources().getText(R.string.f170290li);
            drawable = this.V.getResources().getDrawable(R.drawable.foo);
        } else {
            enlargeFontDesc = iFontManagerService.getEnlargeFontDesc();
            try {
                drawable = URLDrawable.getDrawable(iFontManagerService.getEnlargeFontImgURL(), obtain);
            } catch (Exception e16) {
                QLog.e("TextPreviewVasBubble", 1, "font effect exception, " + e16.getMessage());
            }
        }
        this.U.setText(enlargeFontDesc);
        this.T.setImageDrawable(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x031b  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        String str;
        Object obj;
        boolean z16;
        String str2;
        boolean z17;
        boolean z18;
        boolean z19;
        Object obj2;
        String marketUrl;
        String str3;
        Object obj3;
        String str4;
        String str5;
        boolean z26;
        Object obj4;
        String str6;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f292774j0 <= 500) {
            return;
        }
        this.f292774j0 = currentTimeMillis;
        int id5 = view.getId();
        if (id5 == R.id.alc || id5 == R.id.alk) {
            e eVar = (e) this.W.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (eVar != null) {
                str = "100005.100003";
                z16 = eVar.a("100005.100003") != -1;
                obj = IRedTouchManager.class;
            } else {
                str = "100005.100003";
                obj = IRedTouchManager.class;
                z16 = false;
            }
            Intent intent = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
            intent.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, z16);
            intent.putExtra("scrollToBubble", true);
            intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
            String marketDetailUrl = IndividuationUrlHelper.getMarketDetailUrl(this.V, IndividuationUrlHelper.UrlId.BUBBLE_DETAIL, String.valueOf(this.f292763d), IndividuationUrlHelper.AdTag.INDIVIDUATION_BUBBLE_ADTAG);
            BubbleDiyFetcher m3 = BubbleDiyFetcher.m();
            String str7 = this.f292768f0 + "_" + this.f292765e;
            if (this.f292765e > 0) {
                String str8 = m3.f200564b.get(str7);
                HashMap<String, String> hashMap = m3.f200565c.get(str7);
                if (hashMap == null || hashMap.size() <= 0) {
                    str2 = "100005";
                } else {
                    String str9 = hashMap.get("TL");
                    if (TextUtils.isEmpty(str9)) {
                        str2 = "100005";
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        str2 = "100005";
                        sb5.append("tl=");
                        sb5.append(str9);
                        marketDetailUrl = HtmlOffline.b(marketDetailUrl, sb5.toString());
                    }
                    String str10 = hashMap.get("TR");
                    if (!TextUtils.isEmpty(str10)) {
                        marketDetailUrl = HtmlOffline.b(marketDetailUrl, "tr=" + str10);
                    }
                    String str11 = hashMap.get("BL");
                    if (!TextUtils.isEmpty(str11)) {
                        marketDetailUrl = HtmlOffline.b(marketDetailUrl, "bl=" + str11);
                    }
                    String str12 = hashMap.get("BR");
                    if (!TextUtils.isEmpty(str12)) {
                        marketDetailUrl = HtmlOffline.b(marketDetailUrl, "br=" + str12);
                    }
                }
                String str13 = marketDetailUrl;
                if (TextUtils.isEmpty(str8)) {
                    z17 = true;
                } else {
                    try {
                        marketDetailUrl = HtmlOffline.b(str13, "diyText=" + URLEncoder.encode(str8, "UTF-8"));
                    } catch (UnsupportedEncodingException e16) {
                        z17 = true;
                        QLog.e("TextPreviewVasBubble", 1, "URLEncoder.encode error!", e16);
                    }
                }
                marketDetailUrl = str13;
                if (QLog.isColorLevel()) {
                    z18 = false;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("TextPreviewActivity bubble url: ");
                    z18 = false;
                    sb6.append(s.d(marketDetailUrl, new String[0]));
                    QLog.i("TextPreviewVasBubble", 2, sb6.toString());
                }
                VasWebviewUtil.openQQBrowserWithoutAD(this.V, marketDetailUrl, 64L, intent, false, -1);
                VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "bubble_enter", "", 1, 0, z16 ? 1 : 0, "", String.valueOf(this.f292763d), "");
                if (z16) {
                    return;
                }
                boolean z27 = eVar.a("100005.100001") != -1 ? z17 : z18;
                boolean z28 = eVar.a("100005.100002") != -1 ? z17 : z18;
                boolean z29 = eVar.a("100005.100006") != -1 ? z17 : z18;
                boolean z36 = eVar.a("100005.100018") != -1 ? z17 : z18;
                boolean z37 = eVar.a("100005.100020") != -1 ? z17 : z18;
                boolean z38 = eVar.a("100005.100021") != -1 ? z17 : z18;
                boolean isSupportFont = ((IFontManagerService) this.W.getRuntimeService(IFontManagerService.class, "")).isSupportFont();
                if (isSupportFont) {
                    z19 = eVar.a("100005.100011") != -1 ? z17 : z18;
                } else {
                    z19 = z18;
                }
                if ((isSupportFont && !z27 && !z28 && !z29 && !z19 && !z36 && !z37 && !z38) || (!isSupportFont && !z27 && !z28 && !z29 && !z36 && !z37 && !z38)) {
                    String str14 = str2;
                    if (eVar.a(str14) != -1) {
                        z18 = z17;
                    }
                    if (z18) {
                        Object obj5 = obj;
                        ((IRedTouchManager) this.W.getRuntimeService(obj5, "")).onRedTouchItemClick(str14);
                        obj2 = obj5;
                        ((IRedTouchManager) this.W.getRuntimeService(obj2, "")).onRedTouchItemClick(str);
                        return;
                    }
                }
                obj2 = obj;
                ((IRedTouchManager) this.W.getRuntimeService(obj2, "")).onRedTouchItemClick(str);
                return;
            }
            str2 = "100005";
            z17 = true;
            if (QLog.isColorLevel()) {
            }
            VasWebviewUtil.openQQBrowserWithoutAD(this.V, marketDetailUrl, 64L, intent, false, -1);
            VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "bubble_enter", "", 1, 0, z16 ? 1 : 0, "", String.valueOf(this.f292763d), "");
            if (z16) {
            }
        } else if (id5 == R.id.chl) {
            if (this.f292775m > 0) {
                Intent intent2 = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, this.f292775m);
                intent2.putExtra(EmotionConstants.FROM_AIO, true);
                intent2.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
                Activity activity = this.V;
                VasWebviewUtil.openQQBrowserWithoutAD(activity, IndividuationUrlHelper.getMarketDetailUrl(activity, IndividuationUrlHelper.UrlId.FONT_DETAIL, String.valueOf(this.f292775m), IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG), 4096L, intent2, false, -1);
                VasWebviewUtil.reportCommercialDrainage(this.W.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.f292775m, "");
                return;
            }
            e eVar2 = (e) this.W.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (eVar2 != null) {
                str5 = "100005.100011";
                if (eVar2.a("100005.100011") != -1) {
                    z26 = true;
                    Intent intent3 = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
                    intent3.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, z26);
                    intent3.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, this.C);
                    intent3.putExtra(EmotionConstants.FROM_AIO, true);
                    intent3.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
                    Activity activity2 = this.V;
                    VasWebviewUtil.openQQBrowserWithoutAD(activity2, IndividuationUrlHelper.getMarketDetailUrl(activity2, IndividuationUrlHelper.UrlId.FONT_DETAIL, String.valueOf(this.C), IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG), 4096L, intent3, false, -1);
                    VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "font_enter", "", 1, 0, z26 ? 1 : 0, "", String.valueOf(this.C), "");
                    if (z26) {
                        return;
                    }
                    boolean z39 = eVar2.a("100005.100001") != -1;
                    boolean z46 = eVar2.a("100005.100002") != -1;
                    boolean z47 = eVar2.a("100005.100006") != -1;
                    boolean z48 = eVar2.a("100005.100003") != -1;
                    if (!z39 && !z46 && !z47 && !z48) {
                        if (eVar2.a("100005") != -1) {
                            Object obj6 = IRedTouchManager.class;
                            str6 = "";
                            ((IRedTouchManager) this.W.getRuntimeService(obj6, str6)).onRedTouchItemClick("100005");
                            obj4 = obj6;
                            ((IRedTouchManager) this.W.getRuntimeService(obj4, str6)).onRedTouchItemClick(str5);
                            return;
                        }
                    }
                    obj4 = IRedTouchManager.class;
                    str6 = "";
                    ((IRedTouchManager) this.W.getRuntimeService(obj4, str6)).onRedTouchItemClick(str5);
                    return;
                }
            } else {
                str5 = "100005.100011";
            }
            z26 = false;
            Intent intent32 = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
            intent32.putExtra(VasWebviewConstants.KEY_UPDATE_FLAG, z26);
            intent32.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, this.C);
            intent32.putExtra(EmotionConstants.FROM_AIO, true);
            intent32.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
            Activity activity22 = this.V;
            VasWebviewUtil.openQQBrowserWithoutAD(activity22, IndividuationUrlHelper.getMarketDetailUrl(activity22, IndividuationUrlHelper.UrlId.FONT_DETAIL, String.valueOf(this.C), IndividuationUrlHelper.AdTag.DETAIL_FONT_ADTAG), 4096L, intent32, false, -1);
            VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "font_enter", "", 1, 0, z26 ? 1 : 0, "", String.valueOf(this.C), "");
            if (z26) {
            }
        } else {
            if (id5 != R.id.fkj) {
                if (id5 == R.id.el_) {
                    Intent intent4 = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
                    intent4.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
                    if (this.S == 0) {
                        marketUrl = IndividuationUrlHelper.getMarketUrl(this.V, IndividuationUrlHelper.UrlId.FONT_EFFECT_NONE, null);
                        if (TextUtils.isEmpty(marketUrl)) {
                            marketUrl = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
                        }
                    } else {
                        marketUrl = IndividuationUrlHelper.getMarketUrl(this.V, IndividuationUrlHelper.UrlId.FONT_EFFECT, null);
                        if (TextUtils.isEmpty(marketUrl)) {
                            marketUrl = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
                        }
                    }
                    if (!TextUtils.isEmpty(marketUrl)) {
                        String replace = marketUrl.replace("[id]", this.S + "");
                        if (QLog.isColorLevel()) {
                            QLog.i("TextPreviewVasBubble", 2, "mFontEffectId=" + this.S + " url=" + replace);
                        }
                        VasWebviewUtil.openQQBrowserWithoutAD(this.V, replace, 0L, intent4, false, -1);
                    } else if (QLog.isColorLevel()) {
                        QLog.e("TextPreviewVasBubble", 2, "url is empty.");
                    }
                    VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.S), "");
                    return;
                }
                return;
            }
            e eVar3 = (e) this.W.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            int i3 = (eVar3 == null || eVar3.a("100005.100006") == -1) ? 0 : 1;
            Intent intent5 = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
            intent5.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent5.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent5.putExtra("show_right_close_button", false);
            ExtensionInfo extensionInfo = this.F;
            long j3 = extensionInfo != null ? extensionInfo.pendantId : 0L;
            String marketDetailUrl2 = IndividuationUrlHelper.getMarketDetailUrl(this.V, IndividuationUrlHelper.UrlId.PENDANT_DETAIL, String.valueOf(j3), IndividuationUrlHelper.AdTag.DETAIL_PENDANT_ADTAG);
            LRULinkedHashMap<String, DiyPendantEntity> diyPendantCache = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().getDiyPendantCache();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.f292768f0);
            sb7.append("_");
            ExtensionInfo extensionInfo2 = this.F;
            sb7.append(extensionInfo2 != null ? Integer.valueOf(extensionInfo2.pendantDiyId) : "");
            DiyPendantEntity diyPendantEntity = diyPendantCache.get(sb7.toString());
            if (diyPendantEntity != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<DiyPendantSticker> it = diyPendantEntity.getStickerInfoList().iterator();
                while (it.hasNext()) {
                    DiyPendantSticker next = it.next();
                    Object[] objArr = new Object[7];
                    Iterator<DiyPendantSticker> it5 = it;
                    objArr[0] = Integer.valueOf(next.type);
                    objArr[1] = Integer.valueOf(next.stickerId);
                    objArr[2] = Integer.valueOf(next.angle);
                    objArr[3] = TextUtils.isEmpty(next.text) ? "0" : next.text;
                    objArr[4] = Integer.valueOf(next.fontId);
                    objArr[5] = TextUtils.isEmpty(next.fontColor) ? "0" : next.fontColor;
                    objArr[6] = Integer.valueOf(next.fontType);
                    arrayList.add(String.format("%d,%d,%d,%s,%d,%s,%d", objArr));
                    it = it5;
                }
                String join = TextUtils.join(";", arrayList);
                if (!TextUtils.isEmpty(join)) {
                    str3 = HtmlOffline.b(marketDetailUrl2, "stickerInfo=" + URLEncoder.encode(join));
                    intent5.putExtra("url", str3);
                    intent5.putExtra("business", 512L);
                    intent5.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
                    intent5.putExtra("isShowAd", false);
                    VasWebviewUtil.openQQBrowserWithoutAD(this.V, str3, 512L, intent5, false, -1);
                    VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "pendant_enter", "", 1, 0, i3, "", String.valueOf(j3), "");
                    if (i3 == 0) {
                        boolean z49 = eVar3.a("100005.100001") != -1;
                        boolean z55 = eVar3.a("100005.100002") != -1;
                        boolean z56 = eVar3.a("100005.100006") != -1;
                        boolean z57 = eVar3.a("100005.100003") != -1;
                        if (!z49 && !z55 && !z56 && !z57) {
                            if (eVar3.a("100005") != -1) {
                                Object obj7 = IRedTouchManager.class;
                                str4 = "";
                                ((IRedTouchManager) this.W.getRuntimeService(obj7, str4)).onRedTouchItemClick("100005");
                                obj3 = obj7;
                                ((IRedTouchManager) this.W.getRuntimeService(obj3, str4)).onRedTouchItemClick("100005.100011");
                                return;
                            }
                        }
                        obj3 = IRedTouchManager.class;
                        str4 = "";
                        ((IRedTouchManager) this.W.getRuntimeService(obj3, str4)).onRedTouchItemClick("100005.100011");
                        return;
                    }
                    return;
                }
            }
            str3 = marketDetailUrl2;
            intent5.putExtra("url", str3);
            intent5.putExtra("business", 512L);
            intent5.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_DOUBLE_CLICK);
            intent5.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this.V, str3, 512L, intent5, false, -1);
            VasWebviewUtil.reportCommercialDrainage(this.f292768f0, "bigtextpage", "pendant_enter", "", 1, 0, i3, "", String.valueOf(j3), "");
            if (i3 == 0) {
            }
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onResume() {
        final BubbleDiyFetcher m3 = BubbleDiyFetcher.m();
        final String str = this.f292768f0 + "_" + this.f292765e;
        if (this.f292765e > 0 && (!m3.f200564b.containsKey(str) || !m3.f200565c.containsKey(str))) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewVasBubble.4
                @Override // java.lang.Runnable
                public void run() {
                    m3.h((QQAppInterface) TextPreviewVasBubble.this.W, str, null);
                }
            }, 5, null, false);
        }
        f();
    }

    private Drawable g(int i3) {
        if (i3 == 4) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeVip.png");
        }
        if (i3 == 5) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeSvip.png");
        }
        if (i3 == 21) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://tianquan.gtimg.cn/shoal/vaclient/6a4ec335-07a5-4873-8337-d1c56b308d50.png");
        }
        if (i3 == 22) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://tianquan.gtimg.cn/assets/cubePriceAndTypeIcon/cubeTypeYearSvip.png");
        }
        return null;
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void a(Activity activity) {
        LayoutInflater.from(activity).inflate(R.layout.dwi, (ViewGroup) activity.findViewById(R.id.acj), true);
        LayoutInflater.from(activity).inflate(R.layout.dwh, (ViewGroup) activity.findViewById(R.id.ti5), true);
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public boolean d(int i3, Bundle bundle) {
        String str;
        String str2;
        int i16;
        String str3;
        if (i3 != R.id.ti5 && i3 != R.id.lif) {
            return false;
        }
        if (i3 == R.id.lif) {
            str = "0X800C4FB";
        } else {
            str = "0X800C4FD";
        }
        String str4 = str;
        try {
            i16 = this.X.feeType.get();
            str2 = String.valueOf(this.X.appId.get());
        } catch (Exception unused) {
            str2 = "0";
            i16 = 0;
        }
        ReportController.o(null, "dc00898", "", "", str4, str4, 0, i16, "", "", str2, "");
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            Toast.makeText(this.V, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee", 1).show();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f292774j0) > 2000) {
            this.f292774j0 = currentTimeMillis;
            String n3 = ((ChatBackgroundManager) this.W.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).n(this.W.getCurrentAccountUin(), this.f292768f0);
            String str5 = "null".equals(n3) ? "0" : n3;
            ExtensionInfo extensionInfo = this.F;
            long j3 = extensionInfo != null ? extensionInfo.pendantId : 0L;
            Object[] objArr = new Object[8];
            objArr[0] = this.f292768f0;
            objArr[1] = Long.valueOf(j3);
            objArr[2] = Integer.valueOf(this.f292763d);
            objArr[3] = Integer.valueOf(this.C);
            objArr[4] = Integer.valueOf(this.S);
            objArr[5] = str5;
            String str6 = this.f292762c0;
            if (str6 == null) {
                str6 = this.f292768f0;
            }
            objArr[6] = str6;
            objArr[7] = Integer.valueOf(this.f292766e0);
            String addEntryParamToUrl = VasWebviewUtil.addEntryParamToUrl(String.format("https://zb.vip.qq.com/v2/pages/aioDressPage?fromPage=1&targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", objArr), TextUtils.equals(this.f292768f0, this.W.getCurrentAccountUin()) ? 38 : 37, VasWebConstants.REPORT_ORIGIN_TO_AIO);
            if (VasUtil.getTempApi().isCanOpenHippyPage(HippyQQConstants.ModuleName.QQ_GXH_AIO_DRESS_PAGE)) {
                VasUtil.getTempApi().openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_GXH_AIO_DRESS_PAGE, addEntryParamToUrl);
            } else if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.V, addEntryParamToUrl);
            } else {
                Intent intent = new Intent(this.V, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", addEntryParamToUrl);
                this.V.startActivity(intent);
            }
            String currentAccountUin = this.W.getCurrentAccountUin();
            if (TextUtils.equals(this.f292768f0, this.W.getCurrentAccountUin())) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "aio", "icon_click", "", 0, 0, 0, "", "", str3, "", "", "", "", 0, 0, 0, 0);
        }
        return true;
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void c(Activity activity, Intent intent, AppRuntime appRuntime) {
        String str;
        this.V = activity;
        this.W = appRuntime;
        this.f292763d = (int) intent.getLongExtra("bubbleId", 0L);
        int intExtra = intent.getIntExtra("bubbleDiyId", 0);
        this.f292765e = intExtra;
        if (intExtra == 0) {
            this.f292765e = SVIPHandlerConstants.resolveDiyBubbleTextId(intent.getLongExtra("bubbleId", 0L));
        }
        this.f292767f = activity.findViewById(R.id.f166494fl0);
        this.f292770h = activity.findViewById(R.id.alj);
        this.f292772i = activity.findViewById(R.id.f165263ci1);
        this.E = intent.getIntExtra("anistickerLocID", 0);
        this.f292775m = intent.getIntExtra("HiBoomId", 0);
        String stringExtra = intent.getStringExtra(MessageForRichState.SIGN_MSG_FONT_ID);
        if (!TextUtils.isEmpty(stringExtra) && TextUtils.isDigitsOnly(stringExtra)) {
            if (FontManagerConstants.parseFontType(Long.parseLong(stringExtra)) == 0) {
                this.C = -1;
            } else {
                this.C = (int) FontManagerConstants.parseFontId(Long.parseLong(stringExtra));
                this.D = FontManagerConstants.parseFontType(Long.parseLong(stringExtra));
            }
        } else {
            this.C = -1;
        }
        View findViewById = activity.findViewById(R.id.lif);
        if (this.E <= 0 && findViewById != null) {
            if (VasLongToggle.TEXT_PREVIEW_CONFIG.isEnable(false) && (this.f292763d > 0 || this.C > 0)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        this.f292762c0 = intent.getStringExtra("peeruin");
        this.f292764d0 = intent.getStringExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
        this.f292766e0 = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, -2);
        this.T = (URLImageView) activity.findViewById(R.id.elb);
        this.U = (TextView) activity.findViewById(R.id.ela);
        this.f292769g0 = (URLImageView) activity.findViewById(R.id.f166495fl1);
        this.S = intent.getIntExtra("fontEffectId", 0);
        this.f292768f0 = intent.getStringExtra("real_msg_sender_uin");
        this.F = ((FriendsManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER)).H(this.f292768f0);
        View findViewById2 = activity.findViewById(R.id.fkj);
        this.G = findViewById2;
        findViewById2.setOnClickListener(this);
        this.H = activity.findViewById(R.id.chl);
        View findViewById3 = activity.findViewById(R.id.alc);
        this.I = findViewById3;
        findViewById3.setOnClickListener(this);
        h(activity);
        i(this.S);
        TextView textView = (TextView) activity.findViewById(R.id.kkz);
        if (TextUtils.isEmpty(this.f292768f0)) {
            return;
        }
        if (!this.f292768f0.equals(this.W.getAccount())) {
            textView.setText("TA\u6b63\u5728\u4f7f\u7528\u7684\u88c5\u626e");
        } else {
            textView.setText(f292759m0);
        }
        this.f292760a0 = (TextView) activity.findViewById(R.id.alk);
        this.f292761b0 = (TextView) activity.findViewById(R.id.ali);
        View findViewById4 = activity.findViewById(R.id.acj);
        this.R = findViewById4;
        findViewById4.setVisibility(8);
        this.f292773i0 = new a(Looper.getMainLooper());
        this.f292771h0 = intent.getBooleanExtra(com.tencent.mobileqq.activity.aio.qim.a.f179779m, true);
        this.f292771h0 = intent.getBooleanExtra(com.tencent.mobileqq.activity.aio.tim.a.f180005m, true) | this.f292771h0;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            this.f292771h0 = false;
        }
        if (findViewById != null) {
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            if (TextUtils.equals(this.f292768f0, appRuntime.getCurrentAccountUin())) {
                str = "1";
            } else {
                str = "2";
            }
            VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "aio", "icon_show", "", 0, 0, 0, "", "", str, "", "", "", "", 0, 0, 0, 0);
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onDestroy() {
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onPause() {
    }
}
