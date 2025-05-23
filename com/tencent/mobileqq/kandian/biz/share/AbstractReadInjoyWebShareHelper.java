package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.realname.RealNameSource;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class AbstractReadInjoyWebShareHelper {

    /* renamed from: a, reason: collision with root package name */
    private ReadInJoyShareHelperV2 f239418a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.tencent.mobileqq.kandian.biz.share.a> f239419b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.tencent.mobileqq.kandian.biz.share.a> f239420c;

    /* renamed from: d, reason: collision with root package name */
    protected String f239421d;

    /* renamed from: e, reason: collision with root package name */
    String f239422e;

    /* renamed from: f, reason: collision with root package name */
    IWxShareHelperFromReadInjoy.a f239423f;

    /* renamed from: g, reason: collision with root package name */
    private String f239424g;

    /* renamed from: h, reason: collision with root package name */
    private d f239425h;

    /* renamed from: i, reason: collision with root package name */
    private long f239426i = -1;

    /* renamed from: j, reason: collision with root package name */
    private long f239427j = -1;

    /* renamed from: k, reason: collision with root package name */
    private String f239428k;

    /* renamed from: l, reason: collision with root package name */
    QQProgressDialog f239429l;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AbstractReadInjoyWebShareHelper.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f239461d;

        b(Intent intent) {
            this.f239461d = intent;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
            String str;
            String str2;
            AbstractReadInjoyWebShareHelper.this.q();
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                        getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0 && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null) {
                            String k3 = Share.k(getAppInfoProto$GetAppinfoResponse.iconsURL, 16);
                            Intent intent = this.f239461d;
                            PBStringField pBStringField = getAppInfoProto$AndroidInfo.sourceUrl;
                            String str3 = "";
                            if (pBStringField == null) {
                                str = "";
                            } else {
                                str = pBStringField.get();
                            }
                            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, str);
                            Intent intent2 = this.f239461d;
                            if (k3 == null) {
                                k3 = "";
                            }
                            intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, k3);
                            Intent intent3 = this.f239461d;
                            PBStringField pBStringField2 = getAppInfoProto$AndroidInfo.messagetail;
                            if (pBStringField2 == null) {
                                str2 = "";
                            } else {
                                str2 = pBStringField2.get();
                            }
                            intent3.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, str2);
                            Intent intent4 = this.f239461d;
                            PBStringField pBStringField3 = getAppInfoProto$AndroidInfo.packName;
                            if (pBStringField3 != null) {
                                str3 = pBStringField3.get();
                            }
                            intent4.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, str3);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AbstractReadInjoyWebShareHelper", 2, e16.getMessage());
                    }
                }
            }
            if (i.e(this.f239461d.getExtras()) == null && QLog.isColorLevel()) {
                QLog.d("AbstractReadInjoyWebShareHelper", 2, "build struct msg fail");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c extends ReadInJoyShareHelperV2.a {

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements ITroopMemberApiClientApi.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.kandian.biz.share.a f239464d;

            a(com.tencent.mobileqq.kandian.biz.share.a aVar) {
                this.f239464d = aVar;
            }

            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public void callback(Bundle bundle) {
                AbstractReadInjoyWebShareHelper.this.A(this.f239464d.name, bundle.getBoolean("isSuccess"));
            }
        }

        c() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.a
        public boolean a(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            com.tencent.mobileqq.kandian.biz.share.a g16 = AbstractReadInjoyWebShareHelper.this.f239418a.g(AbstractReadInjoyWebShareHelper.this.f239419b, AbstractReadInjoyWebShareHelper.this.f239420c, i3);
            if (g16 == null) {
                return false;
            }
            AbstractReadInjoyWebShareHelper abstractReadInjoyWebShareHelper = AbstractReadInjoyWebShareHelper.this;
            abstractReadInjoyWebShareHelper.H(i3, true, abstractReadInjoyWebShareHelper.f239428k);
            if (g16.webHandle) {
                AbstractReadInjoyWebShareHelper.this.n(g16.name);
                return true;
            }
            if (i3 == 21) {
                AbstractReadInjoyWebShareHelper.this.f239418a.e();
                AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
            } else if (i3 != 26) {
                if (i3 == 35) {
                    if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.this.f239425h.f239470e)) {
                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(AbstractReadInjoyWebShareHelper.this.r(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(AbstractReadInjoyWebShareHelper.this.r(), 1, AbstractReadInjoyWebShareHelper.this.f239425h.f239470e + "", null, 3096, 1, AbstractReadInjoyWebShareHelper.this.f239425h.f239471f, null, null, null, null));
                    }
                    AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                } else if (i3 != 68) {
                    if (i3 != 31) {
                        if (i3 == 32) {
                            AbstractReadInjoyWebShareHelper.this.n(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
                        } else if (i3 != 37) {
                            if (i3 != 38) {
                                if (i3 != 72 && i3 != 73) {
                                    switch (i3) {
                                        case 1:
                                            AbstractReadInjoyWebShareHelper.this.f239418a.d(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c);
                                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                            break;
                                        case 2:
                                        case 3:
                                            break;
                                        case 4:
                                            AbstractReadInjoyWebShareHelper.this.f239418a.q(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c);
                                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                            break;
                                        case 5:
                                            AbstractReadInjoyWebShareHelper.this.f239418a.p(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c);
                                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                            break;
                                        case 6:
                                            AbstractReadInjoyWebShareHelper.this.l();
                                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                            break;
                                        case 7:
                                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                            break;
                                        default:
                                            switch (i3) {
                                                case 9:
                                                case 10:
                                                case 12:
                                                    break;
                                                case 11:
                                                    AbstractReadInjoyWebShareHelper.this.k();
                                                    AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                                                    break;
                                                case 13:
                                                    AbstractReadInjoyWebShareHelper.this.n(g16.name);
                                                    break;
                                                default:
                                                    AbstractReadInjoyWebShareHelper.this.n(g16.name);
                                                    break;
                                            }
                                    }
                                }
                                AbstractReadInjoyWebShareHelper.this.I(actionSheetItem);
                            } else {
                                AbstractReadInjoyWebShareHelper.this.n("not_care");
                            }
                        } else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.this.f239425h.f239470e)) {
                            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(AbstractReadInjoyWebShareHelper.this.r()), null);
                            m3.putExtra("uin", AbstractReadInjoyWebShareHelper.this.f239425h.f239470e);
                            m3.putExtra("uintype", 0);
                            AbstractReadInjoyWebShareHelper.this.r().startActivity(m3);
                            AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                        }
                    } else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.this.f239425h.f239470e)) {
                        ActivityURIRequest activityURIRequest = new ActivityURIRequest(AbstractReadInjoyWebShareHelper.this.r(), IPublicAccountDetailActivity.ROUTE_NAME);
                        activityURIRequest.extra().putString("uin", AbstractReadInjoyWebShareHelper.this.f239425h.f239470e);
                        activityURIRequest.extra().putBoolean(IPublicAccountDetailActivity.FROM_JS, true);
                        QRoute.startUri(activityURIRequest, (o) null);
                        AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                    }
                } else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c)) {
                    u.q(1, 3);
                    u.f(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c, AbstractReadInjoyWebShareHelper.this.f239425h.f239466a);
                    AbstractReadInjoyWebShareHelper.this.A(g16.name, true);
                }
            } else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.this.f239425h.f239468c)) {
                AbstractReadInjoyWebShareHelper abstractReadInjoyWebShareHelper2 = AbstractReadInjoyWebShareHelper.this;
                abstractReadInjoyWebShareHelper2.B(abstractReadInjoyWebShareHelper2.f239425h.f239468c, new a(g16));
            }
            return super.a(i3, actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        String f239466a;

        /* renamed from: b, reason: collision with root package name */
        String f239467b;

        /* renamed from: c, reason: collision with root package name */
        String f239468c;

        /* renamed from: d, reason: collision with root package name */
        String f239469d;

        /* renamed from: e, reason: collision with root package name */
        String f239470e;

        /* renamed from: f, reason: collision with root package name */
        String f239471f;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        try {
            JSONObject jSONObject = new JSONObject(this.f239424g);
            String optString = jSONObject.optString(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "0");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("desc");
            String optString4 = jSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
            String optString5 = jSONObject.optString("image_url");
            String optString6 = jSONObject.optString("shareElement");
            String optString7 = jSONObject.optString("weibo_title");
            boolean optBoolean = jSONObject.optBoolean("keepShareUrl", false);
            int i3 = actionSheetItem.action;
            if (i3 != 2) {
                if (i3 == 3) {
                    E(jSONObject, optString, optString2, optString3, optString4, optString5);
                    return;
                }
                if (i3 == 9) {
                    G(jSONObject, true, optString2, optString3, optString4, optString5, optString6);
                    return;
                }
                if (i3 == 10) {
                    G(jSONObject, false, optString2, optString3, optString4, optString5, optString6);
                    return;
                }
                if (i3 == 12) {
                    if (!TextUtils.isEmpty(optString7)) {
                        optString2 = optString7;
                    }
                    F(optString2, optString3, optString4, optString5);
                    return;
                } else if (i3 == 72) {
                    jSONObject.put("toUin", actionSheetItem.uin);
                    jSONObject.put("uinType", actionSheetItem.uinType);
                    jSONObject.put("uinname", actionSheetItem.label);
                } else if (i3 != 73) {
                    return;
                }
            }
            p(jSONObject, optString, optString2, optString3, optString4, optString5, optString6, 13, optBoolean);
        } catch (Exception unused) {
        }
    }

    private void K() {
        if (this.f239429l == null) {
            this.f239429l = new QQProgressDialog(r(), r().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (this.f239429l.isShowing()) {
            return;
        }
        this.f239429l.setMessage(R.string.c7z);
        this.f239429l.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String str;
        String str2;
        boolean matches = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.f239425h.f239468c).matches();
        try {
            str = URLEncoder.encode(this.f239425h.f239468c, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("AbstractReadInjoyWebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
            }
            str = null;
        }
        String uin = getUin();
        if (matches) {
            String valueOf = String.valueOf(NetConnInfoCenter.getServerTime());
            String encodeHexStr = MD5Utils.encodeHexStr(str + 200 + valueOf + "jubao@article@123");
            if (encodeHexStr != null && !encodeHexStr.isEmpty()) {
                encodeHexStr = encodeHexStr.toLowerCase();
            }
            str2 = "https://post.mp.qq.com/jubao/index?qq=" + uin + "&mp_uin=" + getPublicUin() + "&scene=200&sub_appname=article_webview&timestamp=" + valueOf + "&sign=" + encodeHexStr + "&article_url=" + str + "&_wv=3";
        } else {
            str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str + "&qq=" + uin + "&_wv=7";
        }
        Intent intent = new Intent(r(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        intent.putExtra("hide_more_button", true);
        r().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        d dVar = this.f239425h;
        String str = dVar.f239466a;
        String str2 = dVar.f239467b;
        String str3 = dVar.f239469d;
        String uin = getUin();
        d dVar2 = this.f239425h;
        QfavBuilder.Z(0, str, dVar2.f239468c, dVar2.f239471f, str2, str3, null, null, false, -1L).T("lCategory", 8L).F(uin).h(r(), uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", str);
            m(jSONObject.toString());
            z();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void p(final JSONObject jSONObject, String str, final String str2, final String str3, final String str4, final String str5, final String str6, int i3, boolean z16) {
        final HashMap hashMap = new HashMap();
        if (!z16 && str4 != null && str4.length() > 140 && !"3".equals(str)) {
            hashMap.put(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, str4);
        }
        if (str5 != null && str5.length() > 80 && !"2".equals(str) && !"3".equals(str) && !"4".equals(str)) {
            hashMap.put("image_url", str5);
        }
        K();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> shortenUrlBatch = HttpUtil.shortenUrlBatch(hashMap);
                final String str7 = shortenUrlBatch.get(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
                if (str7 == null) {
                    str7 = str4;
                }
                final String str8 = shortenUrlBatch.get("image_url");
                if (str8 == null) {
                    str8 = str5;
                }
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity r16 = AbstractReadInjoyWebShareHelper.this.r();
                        if (r16 == null || r16.isFinishing()) {
                            return;
                        }
                        try {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AbstractReadInjoyWebShareHelper.this.D(jSONObject, str2, str3, str7, str8, str6, 13);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                };
                if (AbstractReadInjoyWebShareHelper.this.r().getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                    AbstractReadInjoyWebShareHelper.this.r().runOnUiThread(runnable);
                } else {
                    AbstractReadInjoyWebShareHelper.this.s().runOnUiThread(runnable);
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        QQProgressDialog qQProgressDialog = this.f239429l;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.f239429l.dismiss();
    }

    private List<Integer>[] t() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.mobileqq.kandian.biz.share.a> it = this.f239419b.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().action));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.mobileqq.kandian.biz.share.a> it5 = this.f239420c.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Integer.valueOf(it5.next().action));
        }
        if (arrayList2.contains(68)) {
            d dVar = this.f239425h;
            if (u.n(dVar == null ? null : dVar.f239468c)) {
                u.q(0, 3);
            } else {
                arrayList2.remove((Object) 68);
            }
        }
        return new List[]{arrayList, arrayList2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(String str, boolean z16) {
        String str2;
        if (this.f239421d != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", str);
                if (z16) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                jSONObject.put("retCode", str2);
                m(jSONObject.toString());
                z();
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        x62.a.f447299a.c(z16);
    }

    abstract void B(String str, ITroopMemberApiClientApi.a aVar);

    void C(String str, String str2, String str3, String str4) {
        Activity r16 = r();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
            }
            try {
                try {
                    String str5 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str, "UTF-8")) + "&url=" + URLEncoder.encode(str3, "UTF-8")) + "&pic=" + URLEncoder.encode(str4, "UTF-8")) + "&_wv=3";
                    Intent intent = new Intent(r16, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str5);
                    r16.startActivity(intent);
                    if (QLog.isColorLevel()) {
                        QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina start webview!");
                    }
                } catch (Exception e16) {
                    QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    e16.printStackTrace();
                }
                q();
                if (QLog.isColorLevel()) {
                    QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina end!");
                    return;
                }
                return;
            } catch (Throwable th5) {
                q();
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina empty title or share_url");
        }
        q();
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0339, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x033f, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0345, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0348, code lost:
    
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x034f, code lost:
    
        if ("web".equals(r3) == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0351, code lost:
    
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, r4);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.SHARE_SOURCE_URL, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0362, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0364, code lost:
    
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x036e, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0370, code lost:
    
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0377, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0379, code lost:
    
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x032d, code lost:
    
        r19 = com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x037d, code lost:
    
        r19 = com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0296, code lost:
    
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0294, code lost:
    
        if (android.text.TextUtils.isEmpty(r15) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0276, code lost:
    
        if (android.text.TextUtils.isEmpty(r15) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02a8, code lost:
    
        if (r15.equalsIgnoreCase(r4.getString(com.tencent.mobileqq.R.string.fwb)) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02aa, code lost:
    
        r1 = r15.equalsIgnoreCase(r4.getString(com.tencent.mobileqq.R.string.fwb));
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02b5, code lost:
    
        if (r1 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02b7, code lost:
    
        r3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02be, code lost:
    
        if (r1 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02c0, code lost:
    
        r4 = "mqqapi://readinjoy/open?src_type=internal&version=1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02c7, code lost:
    
        if (r1 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02c9, code lost:
    
        r1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02d0, code lost:
    
        r5.putExtra("source_puin", r2);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r3);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r4);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_A_ACTION_DATA, r3);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, r1);
        r5.putExtra("app_name", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02cd, code lost:
    
        r1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02c4, code lost:
    
        r4 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02bb, code lost:
    
        r3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02f0, code lost:
    
        r4 = r18.optString("src_webActionUrl", "");
        r10 = r18.optString("src_actionData", "");
        r9 = r18.optString("src_a_actionData", "");
        r13 = r18.optString("src_i_actionData", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0310, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0319, code lost:
    
        if ("web".equals(r3) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x031f, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0321, code lost:
    
        r19 = com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x032a, code lost:
    
        if (r4.contains("webcard.mp.qq.com") != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x037f, code lost:
    
        r3 = java.lang.String.format(com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, r2);
        r0 = java.lang.String.format(com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL, r2);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r3);
        r5.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03a3, code lost:
    
        r5.putExtra("source_puin", r2);
        r5.putExtra("app_name", r15);
        r0 = r18.optString("src_iconUrl", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03b7, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03b9, code lost:
    
        r5.putExtra(r19, com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SHARE_SRC_ICON);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03c2, code lost:
    
        r5.putExtra(r19, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0333, code lost:
    
        if ("web".equals(r3) != false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void D(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, int i3) throws JSONException {
        String optString;
        int i16;
        String str6 = str;
        String str7 = str2;
        Activity r16 = r();
        Intent intent = new Intent();
        String optString2 = jSONObject.optString("toUin");
        int optInt = jSONObject.optInt("uinType", 0);
        String optString3 = jSONObject.optString("uinname");
        if (optString2 != null && optString2.length() >= 5) {
            intent.setClass(r16, DirectForwardActivity.class);
            intent.putExtra("toUin", optString2);
            intent.putExtra("uinType", optInt);
            intent.putExtra("uinname", optString3);
        } else {
            intent.putExtra("isWebCompShare", true);
            intent.setClass(r16, ForwardRecentActivity.class);
        }
        intent.putExtra("key_flag_from_plugin", true);
        if (str6 != null && str.length() > 45) {
            str6 = str6.substring(0, 45) + "\u2026";
        }
        if (str7 != null && str2.length() > 60) {
            str7 = str7.substring(0, 60) + "\u2026";
        }
        int i17 = i3 <= 0 ? 13 : i3;
        intent.putExtra("pluginName", "web_share");
        intent.putExtra("title", str6);
        intent.putExtra("desc", str7);
        intent.putExtra("detail_url", str3);
        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i17);
        intent.putExtra("forward_type", 1001);
        intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str4);
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, str6));
        intent.putExtra("flag", jSONObject.optInt("flag", 0));
        if (jSONObject.has("contentAction")) {
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, jSONObject.getString("contentAction"));
        }
        if (jSONObject.has(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA)) {
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA, jSONObject.getString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA));
        }
        if (jSONObject.has("sourceAction")) {
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, jSONObject.getString("sourceAction"));
        }
        if (jSONObject.has("isShareFlag")) {
            intent.putExtra(AppConstants.Key.SHARE_FLAG, Integer.parseInt(jSONObject.getString("isShareFlag")));
        }
        if (jSONObject.has("srcActionData")) {
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, jSONObject.getString("srcActionData"));
        }
        if (jSONObject.has("appName")) {
            intent.putExtra("app_name", jSONObject.getString("appName"));
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 144);
        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        intent.putExtra("k_back", jSONObject.optBoolean("back", false));
        if (jSONObject.has("serviceID")) {
            intent.putExtra(AppConstants.Key.KEY_NEW_SHARE_SERVICE_ID, jSONObject.getString("serviceID"));
        }
        if (jSONObject.has("serviceID") && ((i16 = jSONObject.getInt("serviceID")) == 116 || i16 == 123)) {
            intent.putExtra(AppConstants.Key.KEY_STRUCT_MSG_COMPATIBLE_TEXT, ConfessMsgUtil.f202125b);
        }
        long optLong = jSONObject.optLong("appid", 0L);
        if (optLong > 0) {
            AppInterface s16 = s();
            if (s16 != null) {
                K();
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, Long.toString(optLong));
                Share.o(s16, r16, s16.getAccount(), optLong, 3000L, new b(intent));
            }
            return;
        }
        q();
        String optString4 = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN, null);
        if (optString4 == null) {
            optString4 = jSONObject.optString("oaUin");
        }
        if (!TextUtils.isEmpty(optString4)) {
            EntityManager createEntityManager = s().getEntityManagerFactory(s().getAccount()).createEntityManager();
            IPublicAccountDetail iPublicAccountDetail = (IPublicAccountDetail) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), optString4);
            createEntityManager.close();
            String optString5 = jSONObject.optString("src_action", "");
            if (TextUtils.isEmpty(optString5)) {
                optString = iPublicAccountDetail != null ? iPublicAccountDetail.getName() : null;
                if (TextUtils.isEmpty(optString) && jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                    optString = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
                }
            } else {
                optString = jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME) ? jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME) : null;
                if (TextUtils.isEmpty(optString) && iPublicAccountDetail != null) {
                    optString = iPublicAccountDetail.getName();
                }
            }
        } else if (jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
            String optString6 = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            intent.putExtra("app_name", optString6);
            if ("\u624bQ\u9605\u8bfb".equals(optString6) && jSONObject.has("srcIconUrl")) {
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, jSONObject.optString("srcIconUrl"));
            }
        } else {
            intent.putExtra("app_name", r16.getString(R.string.dyf));
        }
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, i.e(intent.getExtras()).getBytes());
        L(intent, (byte) 1);
    }

    void E(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5) {
        q();
        Bundle bundle = new Bundle();
        bundle.putString("title", str2);
        bundle.putString("desc", str3);
        bundle.putString("detail_url", str4);
        bundle.putString("from", "qq");
        if (jSONObject != null) {
            bundle.putString(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, jSONObject.optString(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT));
        }
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str5);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putLong("req_share_id", 0L);
        bundle.putInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, 1);
        bundle.putLong(AppConstants.Key.SHARE_BEGIN_TIME, SwiftBrowserShareMenuHandler.f314290n0);
        if (getCurrentUrl() != null) {
            bundle.putString("struct_url", getCurrentUrl());
            bundle.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
        }
        QZoneShareManager.jumpToQzoneShare(s(), r(), bundle, (DialogInterface.OnDismissListener) null, M((byte) 2));
    }

    void F(final String str, String str2, final String str3, final String str4) {
        if (QLog.isColorLevel()) {
            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina start!");
        }
        try {
            Uri parse = Uri.parse(str3);
            if (parse != null) {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && (PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host))) {
                    C(str, str2, str3, str4);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        final Activity r16 = r();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                final ApplicationInfo applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo("com.sina.weibo", 8192);
                if (QLog.isColorLevel()) {
                    QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina download image:" + str4);
                        }
                        String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), str4, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina path:" + e16);
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setFlags(268435456);
                        intent.setType("image/*");
                        intent.putExtra("android.intent.extra.TEXT", str + str3);
                        if (!TextUtils.isEmpty(e16)) {
                            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(e16)));
                        }
                        intent.setPackage(applicationInfo.packageName);
                        r16.startActivity(intent);
                        r16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractReadInjoyWebShareHelper.this.q();
                            }
                        });
                        if (QLog.isColorLevel()) {
                            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina start weibo!");
                        }
                    }
                }, 64, null, true);
            } catch (PackageManager.NameNotFoundException unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
                }
                try {
                    try {
                        String str5 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str, "UTF-8")) + "&url=" + URLEncoder.encode(str3, "UTF-8")) + "&pic=" + URLEncoder.encode(str4, "UTF-8")) + "&_wv=3";
                        Intent intent = new Intent(r16, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", str5);
                        r16.startActivity(intent);
                        if (QLog.isColorLevel()) {
                            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina start webview!");
                        }
                    } catch (Exception e16) {
                        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        e16.printStackTrace();
                    }
                } finally {
                    q();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina end!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbstractReadInjoyWebShareHelper", 2, "shareMsgToSina empty title or share_url");
        }
        q();
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public abstract void H(int i3, boolean z16, String str);

    public void J(String str) {
        if (this.f239418a == null) {
            this.f239418a = new ReadInJoyShareHelperV2(r(), s(), new c());
        }
        this.f239418a.getShareActionSheet().setActionSheetTitle("biu\u51fa\u53bb\u8ba9\u66f4\u591a\u597d\u53cb\u770b\u5230");
        this.f239418a.getShareActionSheet().setCancelListener(new a());
        try {
            this.f239424g = str;
            JSONObject jSONObject = new JSONObject(this.f239424g);
            JSONArray optJSONArray = jSONObject.optJSONArray("upline");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("belowline");
            if (optJSONArray == null) {
                this.f239419b = ReadInJoyShareHelperV2.i();
            } else {
                this.f239419b = ReadInJoyShareHelperV2.r(optJSONArray, null);
            }
            if (optJSONArray2 == null) {
                this.f239420c = ReadInJoyShareHelperV2.j();
            } else {
                this.f239420c = ReadInJoyShareHelperV2.r(optJSONArray2, null);
            }
            o();
            d dVar = new d();
            this.f239425h = dVar;
            dVar.f239468c = jSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
            this.f239425h.f239467b = jSONObject.optString("desc");
            this.f239425h.f239466a = jSONObject.optString("title");
            this.f239425h.f239469d = jSONObject.optString("image_url");
            this.f239425h.f239470e = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN);
            this.f239425h.f239471f = jSONObject.optString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (TextUtils.isEmpty(this.f239425h.f239471f)) {
                this.f239425h.f239471f = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            }
            this.f239421d = jSONObject.optString("callback");
            this.f239428k = jSONObject.optString("rowkey");
            this.f239418a.s(t(), jSONObject.optInt("report_from"), this.f239428k);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    abstract void L(Intent intent, Byte b16);

    public abstract int M(Byte b16);

    public abstract void m(String str);

    public abstract Activity r();

    public abstract AppInterface s();

    /* renamed from: u */
    abstract String getCurrentUrl();

    /* renamed from: v */
    public abstract String getPublicUin();

    abstract void w(ITroopMemberApiClientApi.a aVar);

    /* renamed from: x */
    public abstract String getUin();

    public void y() {
        q();
        if (this.f239423f != null) {
            WxShareHelperFromReadInjoy.getInstance().removeObserver(this.f239423f);
        }
    }

    public abstract void z();

    void G(JSONObject jSONObject, final boolean z16, final String str, final String str2, final String str3, final String str4, String str5) {
        int i3;
        r();
        if (WXShareHelper.b0().e0()) {
            i3 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
        } else {
            i3 = R.string.f173257ih1;
        }
        if (i3 != -1) {
            h.T(0, i3);
            q();
            return;
        }
        boolean z17 = jSONObject.optInt("WXShareToMiniProgram") == 1;
        final String optString = jSONObject.optString("WXSharePath");
        final HashMap hashMap = new HashMap(1);
        final boolean z18 = z17;
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.4

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper$4$a */
            /* loaded from: classes33.dex */
            class a implements IWxShareHelperFromReadInjoy.a {
                a() {
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
                @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onWXShareResp(BaseResp baseResp) {
                    boolean z16;
                    AnonymousClass4 anonymousClass4;
                    String str = AbstractReadInjoyWebShareHelper.this.f239422e;
                    if (str == null || !str.equals(baseResp.transaction)) {
                        return;
                    }
                    int i3 = baseResp.errCode;
                    if (i3 != -2) {
                        z16 = true;
                        if (i3 != 0) {
                            h.T(1, R.string.hit);
                        } else {
                            h.T(2, R.string.hj9);
                            anonymousClass4 = AnonymousClass4.this;
                            if (!z16) {
                                AbstractReadInjoyWebShareHelper.this.A("we_chat", z16);
                                return;
                            } else {
                                AbstractReadInjoyWebShareHelper.this.A("we_chat_circle", z16);
                                return;
                            }
                        }
                    }
                    z16 = false;
                    anonymousClass4 = AnonymousClass4.this;
                    if (!z16) {
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity r16 = AbstractReadInjoyWebShareHelper.this.r();
                if (r16 == null || r16.isFinishing()) {
                    return;
                }
                AbstractReadInjoyWebShareHelper.this.q();
                AbstractReadInjoyWebShareHelper abstractReadInjoyWebShareHelper = AbstractReadInjoyWebShareHelper.this;
                if (abstractReadInjoyWebShareHelper.f239423f == null) {
                    abstractReadInjoyWebShareHelper.f239423f = new a();
                    WxShareHelperFromReadInjoy.getInstance().addObserver(AbstractReadInjoyWebShareHelper.this.f239423f);
                }
                AbstractReadInjoyWebShareHelper.this.f239422e = String.valueOf(System.currentTimeMillis());
                Bitmap bitmap = (Bitmap) hashMap.remove("image");
                if (z18 && z16) {
                    WxShareHelperFromReadInjoy.getInstance().shareToMiniProgramWithPath(AbstractReadInjoyWebShareHelper.this.f239422e, str, bitmap, str2, str3, optString);
                } else {
                    AbstractReadInjoyWebShareHelper.this.w(new b(bitmap));
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper$4$b */
            /* loaded from: classes33.dex */
            class b implements ITroopMemberApiClientApi.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f239446d;

                b(Bitmap bitmap) {
                    this.f239446d = bitmap;
                }

                @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
                public void callback(Bundle bundle) {
                    int i3 = bundle.getInt("readinjoy_to_wx_config");
                    if (QLog.isColorLevel()) {
                        QLog.d("AbstractReadInjoyWebShareHelper", 2, "config = " + i3);
                    }
                    if (i3 == 0) {
                        WxShareHelperFromReadInjoy wxShareHelperFromReadInjoy = WxShareHelperFromReadInjoy.getInstance();
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        wxShareHelperFromReadInjoy.shareWebPage(AbstractReadInjoyWebShareHelper.this.f239422e, str, this.f239446d, str2, str3, !z16 ? 1 : 0);
                    } else {
                        WXShareHelper b06 = WXShareHelper.b0();
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        b06.L0(AbstractReadInjoyWebShareHelper.this.f239422e, str, this.f239446d, str2, str3, !z16 ? 1 : 0);
                    }
                }
            }
        };
        K();
        final boolean z19 = z17;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.5
            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeByteArray;
                try {
                    byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", str4), "GET", null, null);
                    if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        double d16 = width * height;
                        if (d16 > 8000.0d && !z19) {
                            double sqrt = Math.sqrt(8000.0d / d16);
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                            decodeByteArray.recycle();
                            decodeByteArray = createScaledBitmap;
                        }
                        hashMap.put("image", decodeByteArray);
                    }
                } catch (IOException | OutOfMemoryError unused) {
                }
                if (AbstractReadInjoyWebShareHelper.this.r().getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity")) {
                    AbstractReadInjoyWebShareHelper.this.r().runOnUiThread(runnable);
                } else {
                    AbstractReadInjoyWebShareHelper.this.s().runOnUiThread(runnable);
                }
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "96");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(hashMap.get("image") != null ? 0 : 1);
                bundle.putString("intext_1", sb5.toString());
                bundle.putString("intext_4", "0");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(com.tencent.open.agent.report.e.a(z16 ? 3 : 4));
                bundle.putString("intext_3", sb6.toString());
                bundle.putString("stringext_1", str3);
                ReportCenter.f().l(bundle, "", AbstractReadInjoyWebShareHelper.this.s().getAccount(), false);
            }
        }, 8, null, false);
    }

    private void o() {
        this.f239426i = -1L;
        this.f239427j = -1L;
        Intent intent = r().getIntent();
        if (intent == null || !intent.getBooleanExtra(QQBrowserActivity.KEY_FROM_FAV, false)) {
            return;
        }
        this.f239426i = intent.getLongExtra(QQBrowserActivity.KEY_FAV_ID, -1L);
        this.f239427j = intent.getLongExtra(QQBrowserActivity.KEY_FAV_GROUP_ID, -1L);
    }
}
