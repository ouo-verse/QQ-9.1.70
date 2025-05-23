package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewParent;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.xweb.FileReaderHelper;
import com.tenpay.realname.RealNameSource;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ShareMsgImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    QQProgressDialog f238638a;

    /* renamed from: b, reason: collision with root package name */
    String f238639b;

    /* renamed from: c, reason: collision with root package name */
    WXShareHelper.a f238640c;

    /* renamed from: d, reason: collision with root package name */
    IWxShareHelperFromReadInjoy.a f238641d;

    /* renamed from: e, reason: collision with root package name */
    String f238642e;

    /* renamed from: f, reason: collision with root package name */
    Context f238643f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.webviewplugin.r f238644g;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.webviewplugin.f f238645h;

    /* renamed from: i, reason: collision with root package name */
    com.tencent.mobileqq.webviewplugin.o f238646i;

    /* renamed from: j, reason: collision with root package name */
    com.tencent.mobileqq.webviewplugin.n f238647j;

    /* renamed from: k, reason: collision with root package name */
    com.tencent.biz.troop.b f238648k;

    /* renamed from: l, reason: collision with root package name */
    WebViewPlugin.b f238649l;

    /* renamed from: m, reason: collision with root package name */
    WebViewPlugin f238650m;

    /* renamed from: n, reason: collision with root package name */
    Activity f238651n;

    /* renamed from: o, reason: collision with root package name */
    AppInterface f238652o;

    /* renamed from: p, reason: collision with root package name */
    b f238653p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements com.tencent.open.appcommon.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f238687d;

        a(Intent intent) {
            this.f238687d = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareMsgImpl.this, (Object) intent);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            ShareMsgImpl.this.f238638a.dismiss();
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                        getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0 && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null) {
                            String k3 = Share.k(getAppInfoProto$GetAppinfoResponse.iconsURL, 16);
                            Intent intent = this.f238687d;
                            PBStringField pBStringField = getAppInfoProto$AndroidInfo.sourceUrl;
                            String str3 = "";
                            if (pBStringField == null) {
                                str = "";
                            } else {
                                str = pBStringField.get();
                            }
                            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, str);
                            Intent intent2 = this.f238687d;
                            if (k3 == null) {
                                k3 = "";
                            }
                            intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, k3);
                            Intent intent3 = this.f238687d;
                            PBStringField pBStringField2 = getAppInfoProto$AndroidInfo.messagetail;
                            if (pBStringField2 == null) {
                                str2 = "";
                            } else {
                                str2 = pBStringField2.get();
                            }
                            intent3.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, str2);
                            Intent intent4 = this.f238687d;
                            PBStringField pBStringField3 = getAppInfoProto$AndroidInfo.packName;
                            if (pBStringField3 != null) {
                                str3 = pBStringField3.get();
                            }
                            intent4.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, str3);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareMsgImpl", 2, e16.getMessage());
                    }
                }
            }
            AbsStructMsg e17 = com.tencent.mobileqq.structmsg.i.e(this.f238687d.getExtras());
            if (e17 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareMsgImpl", 2, "build struct msg fail");
                }
            } else {
                this.f238687d.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e17.getBytes());
                ShareMsgImpl.this.f238653p.startActivityForResult(this.f238687d, (byte) 1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void onSharMsgcallback(String str, String str2);

        void startActivityForResult(Intent intent, byte b16);
    }

    public ShareMsgImpl(Context context, Activity activity, AppInterface appInterface, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, appInterface, bVar);
            return;
        }
        this.f238644g = null;
        this.f238645h = null;
        this.f238646i = null;
        this.f238647j = null;
        this.f238648k = null;
        this.f238643f = context;
        this.f238651n = activity;
        this.f238652o = appInterface;
        this.f238653p = bVar;
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f238648k = A;
        A.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Bitmap bitmap, Map<String, Object> map) {
        String str2;
        if (bitmap == null) {
            return;
        }
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (str != null && str.endsWith("png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
            str2 = ".png";
        } else {
            str2 = ".jpg";
        }
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "qq_share").getAbsolutePath()));
        file.mkdirs();
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), "temp_qq_share_" + System.currentTimeMillis() + str2);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            ae2.a.a(bitmap, absolutePath, compressFormat, 100, false);
            map.put("imageLocalPath", file2.getAbsolutePath());
        }
    }

    private String d(Intent intent, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (z16) {
                jSONObject.put("result", 0);
            } else {
                jSONObject.put("result", 4);
            }
        } catch (Exception e16) {
            QLog.d("ShareMsgImpl", 2, "getResultJson error =" + e16);
        }
        if (intent != null && intent.getExtras() != null) {
            jSONObject.put("userUin", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    int i3 = resultRecord.uinType;
                    if (i3 == 0) {
                        arrayList.add(resultRecord.uin);
                    } else if (i3 == 1) {
                        arrayList2.add(resultRecord.uin);
                    } else if (i3 == 10014) {
                        arrayList3.add(resultRecord.uin);
                    }
                }
            } else {
                String string = intent.getExtras().getString("uin");
                int i16 = intent.getExtras().getInt("uintype");
                if (i16 == 0) {
                    arrayList.add(string);
                } else if (i16 == 1) {
                    arrayList2.add(string);
                } else if (i16 == 10014) {
                    arrayList3.add(string);
                }
            }
            JSONArray jSONArray = new JSONArray((Collection) arrayList);
            JSONArray jSONArray2 = new JSONArray((Collection) arrayList2);
            JSONArray jSONArray3 = new JSONArray((Collection) arrayList3);
            jSONObject.put("uin", jSONArray);
            jSONObject.put("group_id", jSONArray2);
            jSONObject.put("channel_id", jSONArray3);
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "getResultJson" + jSONObject);
            }
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void c(Activity activity) {
        com.tencent.mobileqq.webview.swift.y yVar;
        if (this.f238638a == null) {
            com.tencent.mobileqq.webviewplugin.n nVar = this.f238647j;
            if (nVar != null) {
                this.f238638a = ((Share) nVar.getShare()).getSharePD();
                return;
            }
            WebViewPlugin.b bVar = this.f238649l;
            if (bVar != null) {
                yVar = bVar.d(this.f238651n);
            } else {
                yVar = null;
            }
            if (activity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
                if (activity instanceof com.tencent.mobileqq.webviewplugin.n) {
                    this.f238638a = ((Share) ((com.tencent.mobileqq.webviewplugin.n) activity).getShare()).getSharePD();
                    return;
                } else {
                    this.f238638a = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                }
            }
            if (yVar instanceof com.tencent.mobileqq.webviewplugin.n) {
                this.f238638a = ((Share) ((com.tencent.mobileqq.webviewplugin.n) activity).getShare()).getSharePD();
                return;
            }
            if (bVar != null && bVar.e() != null) {
                ViewParent parent = bVar.e().getParent();
                if (parent instanceof com.tencent.comic.api.a) {
                    com.tencent.comic.api.a aVar = (com.tencent.comic.api.a) parent;
                    if (aVar.getShareHelper() instanceof com.tencent.share.a) {
                        com.tencent.share.a aVar2 = (com.tencent.share.a) aVar.getShareHelper();
                        if (aVar2.j() != null) {
                            this.f238638a = aVar2.j().b();
                            return;
                        } else {
                            this.f238638a = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            return;
                        }
                    }
                }
                this.f238638a = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            this.f238638a = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    public void e(WebViewPlugin webViewPlugin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) webViewPlugin);
            return;
        }
        this.f238650m = webViewPlugin;
        WebViewPlugin.b bVar = webViewPlugin.mRuntime;
        this.f238649l = bVar;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.r)) {
            this.f238644g = (com.tencent.mobileqq.webviewplugin.r) d16;
        }
        WebViewPlugin.b bVar2 = this.f238649l;
        com.tencent.mobileqq.webview.swift.y d17 = bVar2.d(bVar2.a());
        if (d17 != null && (d17 instanceof com.tencent.mobileqq.webviewplugin.f)) {
            this.f238645h = (com.tencent.mobileqq.webviewplugin.f) d17;
        }
        WebViewPlugin.b bVar3 = this.f238649l;
        com.tencent.mobileqq.webview.swift.y d18 = bVar3.d(bVar3.a());
        if (d18 != null && (d18 instanceof com.tencent.mobileqq.webviewplugin.n)) {
            this.f238647j = (com.tencent.mobileqq.webviewplugin.n) d18;
        }
        j(this.f238650m);
    }

    public void f(Intent intent, byte b16, int i3) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (b16 == 1) {
            b bVar = this.f238653p;
            String str3 = this.f238639b;
            if (i3 == -1) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            bVar.onSharMsgcallback(str3, str2);
            return;
        }
        if (b16 == 2) {
            b bVar2 = this.f238653p;
            String str4 = this.f238639b;
            if (i3 == -1) {
                str = "{\"result\":1}";
            } else {
                str = "{\"result\":0}";
            }
            bVar2.onSharMsgcallback(str4, str);
            return;
        }
        if (b16 == 3) {
            if (i3 == -1) {
                z16 = true;
            }
            this.f238653p.onSharMsgcallback(this.f238639b, d(intent, z16));
        } else if (b16 == 4) {
            Activity activity = this.f238651n;
            if (i3 == -1 && activity != null && !activity.isFinishing() && intent != null) {
                this.f238648k.H0(new Bundle(intent.getExtras()));
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f238638a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f238638a.dismiss();
        }
        if (this.f238640c != null) {
            WXShareHelper.b0().q0(this.f238640c);
        }
        com.tencent.biz.troop.b bVar = this.f238648k;
        if (bVar != null) {
            bVar.q();
        }
        if (this.f238641d != null) {
            ((IWxShareHelperFromReadInjoy) QRoute.api(IWxShareHelperFromReadInjoy.class)).removeObserver(this.f238641d);
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        try {
            this.f238639b = null;
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            String optString = jSONObject.optString("toUin");
            if (optString != null && optString.length() >= 5) {
                this.f238639b = jSONObject.optString("callback");
                intent.setClass(this.f238643f, DirectForwardActivity.class);
                intent.putExtra("toUin", optString);
                intent.putExtra("key_flag_from_plugin", true);
                intent.putExtra("pluginName", "web_share");
                intent.putExtra("forward_type", 30);
                intent.putExtra("k_back", true);
                this.f238653p.startActivityForResult(intent, (byte) 2);
                return;
            }
            if (!TextUtils.isEmpty(this.f238639b)) {
                this.f238653p.onSharMsgcallback(this.f238639b, "{\"result\":0}");
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "toUin invalide: " + optString);
            }
        } catch (JSONException e16) {
            this.f238653p.onSharMsgcallback(this.f238639b, "{\"result\":0}");
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareMsg error: " + e16.toString());
            }
        }
    }

    public boolean i(String str) {
        String str2;
        com.tencent.mobileqq.webview.swift.y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "setShareInfo been called");
        }
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
            String optString4 = jSONObject.optString("image_url");
            String optString5 = jSONObject.optString("type");
            str2 = "ShareMsgImpl";
            try {
                String optString6 = jSONObject.optString("miniprogram_image_url");
                String optString7 = jSONObject.optString("cover_url");
                String optString8 = jSONObject.optString("source_name");
                String optString9 = jSONObject.optString(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                boolean optBoolean = jSONObject.optBoolean("editable", true);
                String optString10 = jSONObject.optString("policy");
                boolean optBoolean2 = jSONObject.optBoolean("isCreator", false);
                String optString11 = jSONObject.optString("singleLineTitle");
                boolean optBoolean3 = jSONObject.optBoolean("contentEdited");
                boolean optBoolean4 = jSONObject.optBoolean("isNewCreate");
                String optString12 = jSONObject.optString("groupCode");
                String optString13 = jSONObject.optString("domainId");
                String optString14 = jSONObject.optString("localPadId");
                if (!TextUtils.isEmpty(optString7)) {
                    bundle.putString("cover_url", optString7);
                }
                if (!TextUtils.isEmpty(optString5)) {
                    bundle.putString("type", optString5);
                }
                if (!TextUtils.isEmpty(optString6)) {
                    bundle.putString("miniprogram_image_url", optString6);
                }
                if (!TextUtils.isEmpty(optString8)) {
                    bundle.putString("source_name", optString8);
                }
                if (!TextUtils.isEmpty(optString9)) {
                    bundle.putString(AppConstants.Key.SHARE_REQ_ARTICLE_ID, optString9);
                }
                if (!TextUtils.isEmpty(optString11)) {
                    bundle.putString("singleLineTitle", optString11);
                }
                bundle.putBoolean("editable", optBoolean);
                bundle.putBoolean("isCreator", optBoolean2);
                if (!TextUtils.isEmpty(optString10)) {
                    bundle.putString("policy", optString10);
                }
                bundle.putBoolean("contentEdited", optBoolean3);
                bundle.putBoolean("isNewCreate", optBoolean4);
                if (!TextUtils.isEmpty(optString12)) {
                    bundle.putString("groupCode", optString12);
                }
                if (!TextUtils.isEmpty(optString13)) {
                    bundle.putString("domainId", optString13);
                }
                if (!TextUtils.isEmpty(optString14)) {
                    bundle.putString("localPadId", optString14);
                }
                Activity activity = this.f238651n;
                if (activity != null && (activity instanceof TeamWorkDocEditBrowserActivity)) {
                    String optString15 = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString15)) {
                        if (FileReaderHelper.DOCX_EXT.equals(optString15)) {
                            ((TeamWorkDocEditBrowserActivity) activity).N2(1);
                        } else if ("sheet".equals(optString15)) {
                            ((TeamWorkDocEditBrowserActivity) activity).N2(2);
                        }
                    }
                }
                WebViewPlugin.b bVar = this.f238649l;
                if (bVar != null) {
                    yVar = bVar.d(this.f238651n);
                } else {
                    yVar = null;
                }
                if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.n)) {
                    bundle.putInt("extra_url_info_from", 1);
                    return ((com.tencent.mobileqq.webviewplugin.n) yVar).setSummary(optString, optString2, optString3, optString4, bundle);
                }
                return false;
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(str2, 2, "setShareInfo param error");
                    return false;
                }
                return false;
            }
        } catch (JSONException unused2) {
            str2 = "ShareMsgImpl";
        }
    }

    public void j(WebViewPlugin webViewPlugin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) webViewPlugin);
            return;
        }
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) webViewPlugin.getBrowserComponent(4);
        if (swiftBrowserShareMenuHandler instanceof com.tencent.mobileqq.webviewplugin.o) {
            this.f238646i = swiftBrowserShareMenuHandler;
        }
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.mobileqq.webviewplugin.n nVar = this.f238647j;
        if (nVar != null && nVar.setShareUrl(str)) {
            return true;
        }
        return false;
    }

    public void l(com.tencent.mobileqq.webview.swift.y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yVar);
            return;
        }
        if (this.f238644g == null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r)) {
            this.f238644g = (com.tencent.mobileqq.webviewplugin.r) yVar;
        }
        if (this.f238645h == null && (yVar instanceof com.tencent.mobileqq.webviewplugin.f)) {
            this.f238645h = (com.tencent.mobileqq.webviewplugin.f) yVar;
        }
        if (this.f238647j == null && (yVar instanceof com.tencent.mobileqq.webviewplugin.n)) {
            this.f238647j = (com.tencent.mobileqq.webviewplugin.n) yVar;
        }
    }

    void m(JSONObject jSONObject) {
        boolean z16;
        Intent M2;
        String str = "";
        try {
            WebViewPlugin.b bVar = this.f238649l;
            if (bVar != null) {
                z16 = bVar.e().getPluginEngine().i().F(this.f238649l.f().getCurrentUrl(), "QQApi.shareArkMessage");
            } else {
                z16 = true;
            }
            if (!z16) {
                QLog.e("ShareMsgImpl", 1, "shareArkMessage permission deny!");
                QQProgressDialog qQProgressDialog = this.f238638a;
                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                    this.f238638a.dismiss();
                    return;
                }
                return;
            }
            String string = jSONObject.getString("view");
            String string2 = jSONObject.getString("app");
            String optString = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            String string3 = jSONObject.getString(PublicAccountMessageUtilImpl.META_NAME);
            String string4 = jSONObject.getString("desc");
            String optString2 = jSONObject.optString("version", Constants.DEFAULT_MIN_APP_VERSION);
            try {
                str = new JSONObject(jSONObject.optString(DownloadInfo.spKey_Config, "")).getString("type");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("version", optString2);
            hashMap.put("type", str);
            hashMap.put("desc", string4);
            Activity activity = this.f238651n;
            if (activity != null && (M2 = ArkFullScreenAppActivity.M2(activity, string, string2, optString, string3, "", activity.getResources().getDisplayMetrics().scaledDensity, hashMap)) != null) {
                ForwardBaseOption.startForwardActivity(activity, M2);
            }
            QQProgressDialog qQProgressDialog2 = this.f238638a;
            if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                this.f238638a.dismiss();
            }
        } catch (Exception e17) {
            QLog.e("ShareMsgImpl", 1, "shareArkMsg error:", e17);
        }
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            o(str, true);
        }
    }

    public void o(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
        } else {
            p(str, z16, 27);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0131 A[Catch: JSONException -> 0x02a8, TryCatch #1 {JSONException -> 0x02a8, blocks: (B:10:0x0049, B:12:0x004d, B:14:0x005b, B:16:0x0061, B:17:0x0066, B:18:0x006c, B:20:0x0085, B:22:0x0092, B:24:0x009a, B:27:0x00a5, B:29:0x00b9, B:31:0x00c4, B:32:0x00ea, B:34:0x0131, B:35:0x0138, B:37:0x015e, B:39:0x0164, B:45:0x01db, B:48:0x01f3, B:50:0x01fb, B:52:0x0205, B:55:0x027e, B:56:0x0283, B:58:0x0290, B:59:0x029d, B:61:0x020a, B:63:0x0210, B:65:0x021c, B:66:0x0220, B:68:0x0224, B:70:0x022a, B:72:0x0234, B:73:0x0238, B:75:0x023c, B:77:0x0246, B:79:0x0252, B:80:0x0256, B:82:0x025e, B:84:0x0275, B:90:0x0170, B:93:0x00dc), top: B:9:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f3 A[Catch: JSONException -> 0x02a8, TRY_ENTER, TryCatch #1 {JSONException -> 0x02a8, blocks: (B:10:0x0049, B:12:0x004d, B:14:0x005b, B:16:0x0061, B:17:0x0066, B:18:0x006c, B:20:0x0085, B:22:0x0092, B:24:0x009a, B:27:0x00a5, B:29:0x00b9, B:31:0x00c4, B:32:0x00ea, B:34:0x0131, B:35:0x0138, B:37:0x015e, B:39:0x0164, B:45:0x01db, B:48:0x01f3, B:50:0x01fb, B:52:0x0205, B:55:0x027e, B:56:0x0283, B:58:0x0290, B:59:0x029d, B:61:0x020a, B:63:0x0210, B:65:0x021c, B:66:0x0220, B:68:0x0224, B:70:0x022a, B:72:0x0234, B:73:0x0238, B:75:0x023c, B:77:0x0246, B:79:0x0252, B:80:0x0256, B:82:0x025e, B:84:0x0275, B:90:0x0170, B:93:0x00dc), top: B:9:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027e A[Catch: JSONException -> 0x02a8, TryCatch #1 {JSONException -> 0x02a8, blocks: (B:10:0x0049, B:12:0x004d, B:14:0x005b, B:16:0x0061, B:17:0x0066, B:18:0x006c, B:20:0x0085, B:22:0x0092, B:24:0x009a, B:27:0x00a5, B:29:0x00b9, B:31:0x00c4, B:32:0x00ea, B:34:0x0131, B:35:0x0138, B:37:0x015e, B:39:0x0164, B:45:0x01db, B:48:0x01f3, B:50:0x01fb, B:52:0x0205, B:55:0x027e, B:56:0x0283, B:58:0x0290, B:59:0x029d, B:61:0x020a, B:63:0x0210, B:65:0x021c, B:66:0x0220, B:68:0x0224, B:70:0x022a, B:72:0x0234, B:73:0x0238, B:75:0x023c, B:77:0x0246, B:79:0x0252, B:80:0x0256, B:82:0x025e, B:84:0x0275, B:90:0x0170, B:93:0x00dc), top: B:9:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0290 A[Catch: JSONException -> 0x02a8, TryCatch #1 {JSONException -> 0x02a8, blocks: (B:10:0x0049, B:12:0x004d, B:14:0x005b, B:16:0x0061, B:17:0x0066, B:18:0x006c, B:20:0x0085, B:22:0x0092, B:24:0x009a, B:27:0x00a5, B:29:0x00b9, B:31:0x00c4, B:32:0x00ea, B:34:0x0131, B:35:0x0138, B:37:0x015e, B:39:0x0164, B:45:0x01db, B:48:0x01f3, B:50:0x01fb, B:52:0x0205, B:55:0x027e, B:56:0x0283, B:58:0x0290, B:59:0x029d, B:61:0x020a, B:63:0x0210, B:65:0x021c, B:66:0x0220, B:68:0x0224, B:70:0x022a, B:72:0x0234, B:73:0x0238, B:75:0x023c, B:77:0x0246, B:79:0x0252, B:80:0x0256, B:82:0x025e, B:84:0x0275, B:90:0x0170, B:93:0x00dc), top: B:9:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0220 A[Catch: JSONException -> 0x02a8, TryCatch #1 {JSONException -> 0x02a8, blocks: (B:10:0x0049, B:12:0x004d, B:14:0x005b, B:16:0x0061, B:17:0x0066, B:18:0x006c, B:20:0x0085, B:22:0x0092, B:24:0x009a, B:27:0x00a5, B:29:0x00b9, B:31:0x00c4, B:32:0x00ea, B:34:0x0131, B:35:0x0138, B:37:0x015e, B:39:0x0164, B:45:0x01db, B:48:0x01f3, B:50:0x01fb, B:52:0x0205, B:55:0x027e, B:56:0x0283, B:58:0x0290, B:59:0x029d, B:61:0x020a, B:63:0x0210, B:65:0x021c, B:66:0x0220, B:68:0x0224, B:70:0x022a, B:72:0x0234, B:73:0x0238, B:75:0x023c, B:77:0x0246, B:79:0x0252, B:80:0x0256, B:82:0x025e, B:84:0x0275, B:90:0x0170, B:93:0x00dc), top: B:9:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(String str, boolean z16, int i3) {
        int i16;
        String str2;
        String str3;
        String optString;
        JSONObject jSONObject;
        String str4;
        Context context;
        JSONObject jSONObject2;
        ShareMsgImpl shareMsgImpl = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, shareMsgImpl, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        shareMsgImpl.f238639b = null;
        try {
            com.tencent.mobileqq.webviewplugin.n nVar = shareMsgImpl.f238647j;
            if (nVar != null) {
                Share share = (Share) nVar.getShare();
                QQProgressDialog sharePD = share.getSharePD();
                shareMsgImpl.f238638a = sharePD;
                if (sharePD != null && sharePD.isShowing()) {
                    shareMsgImpl.f238638a.dismiss();
                }
                i16 = share.C();
            } else {
                i16 = 0;
            }
            Intent intent = new Intent();
            JSONObject jSONObject3 = new JSONObject(str);
            shareMsgImpl.f238639b = jSONObject3.optString("callback");
            String optString2 = jSONObject3.optString("appName");
            if (z16 && !AuthorizeConfig.y().O("ark_authorize_config", optString2)) {
                if (!TextUtils.isEmpty(shareMsgImpl.f238639b)) {
                    shareMsgImpl.f238653p.onSharMsgcallback(shareMsgImpl.f238639b, "{\"result\":2}");
                    return;
                }
                return;
            }
            String optString3 = jSONObject3.optString("toUin");
            int i17 = i16;
            int optInt = jSONObject3.optInt("uinType", 0);
            String optString4 = jSONObject3.optString("toNickName");
            try {
                if (optString3 != null) {
                    str3 = "appName";
                    str2 = optString2;
                    if (optString3.length() >= 5) {
                        intent.setClass(shareMsgImpl.f238643f, DirectForwardActivity.class);
                        intent.putExtra("toUin", optString3);
                        intent.putExtra("uinType", optInt);
                        intent.putExtra("nickName", optString4);
                        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, jSONObject3.optInt(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13));
                        intent.putExtra("forward_type", i3);
                        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                        intent.putExtra("k_back", jSONObject3.optBoolean("k_back", jSONObject3.optBoolean("back", false)));
                        String optString5 = jSONObject3.optString("appDesc");
                        String optString6 = jSONObject3.optString(QQCustomArkDialogUtil.APP_MIN_VERSION);
                        String optString7 = jSONObject3.optString(QQCustomArkDialogUtil.APP_VIEW);
                        optString = jSONObject3.optString(QQCustomArkDialogUtil.BIZ_SRC);
                        if (TextUtils.isEmpty(optString)) {
                            optString = jSONObject3.optString(ark.APP_SPECIFIC_BIZSRC);
                        }
                        String optString8 = jSONObject3.optString("appConfig");
                        String optString9 = jSONObject3.optString(QQCustomArkDialogUtil.META_DATA);
                        String optString10 = jSONObject3.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT);
                        String optString11 = jSONObject3.optString(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
                        String optString12 = jSONObject3.optString("addtionalMsg");
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString9)) {
                            str4 = QQCustomArkDialogUtil.META_DATA;
                            jSONObject = jSONObject3;
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, optString12);
                            String str5 = str2;
                            intent.putExtra("forward_ark_app_name", str5);
                            intent.putExtra("forward_ark_app_view", optString7);
                            intent.putExtra("forward_ark_biz_src", optString);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString5);
                            intent.putExtra("forward_ark_app_ver", optString6);
                            intent.putExtra("forward_ark_app_prompt", optString10);
                            intent.putExtra("forward_ark_app_meta", optString9);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString8);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString11);
                            intent.putExtra("is_ark_display_share", true);
                            intent.putExtra(str3, str5);
                            intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString7);
                            intent.putExtra(QQCustomArkDialogUtil.BIZ_SRC, optString);
                            intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString6);
                            intent.putExtra(str4, optString9);
                            intent.putExtra("scale", this.f238643f.getResources().getDisplayMetrics().scaledDensity);
                            context = this.f238643f;
                            if (!(context instanceof QQBrowserActivity)) {
                                WebViewProvider webViewProvider = ((QQBrowserActivity) context).getWebViewProvider();
                                if (webViewProvider != null) {
                                    String currentUrl = webViewProvider.getCurrentUrl();
                                    if (!TextUtils.isEmpty(currentUrl)) {
                                        intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, currentUrl);
                                    }
                                } else {
                                    Context context2 = this.f238643f;
                                    if (context2 instanceof QQTranslucentBrowserActivity) {
                                        String currentUrl2 = ((QQTranslucentBrowserActivity) context2).getCurrentUrl();
                                        if (!TextUtils.isEmpty(currentUrl2)) {
                                            intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, currentUrl2);
                                        }
                                    }
                                }
                            } else {
                                WebViewPlugin.b bVar = this.f238649l;
                                if (bVar != null) {
                                    WebViewProvider f16 = bVar.f();
                                    if (f16 != null) {
                                        String currentUrl3 = f16.getCurrentUrl();
                                        if (!TextUtils.isEmpty(currentUrl3)) {
                                            intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, currentUrl3);
                                        }
                                    } else {
                                        Activity activity = this.f238651n;
                                        if (activity != null) {
                                            com.tencent.mobileqq.webview.swift.y d16 = this.f238649l.d(activity);
                                            if (d16 instanceof com.tencent.mobileqq.webviewplugin.r) {
                                                String currentUrl4 = ((com.tencent.mobileqq.webviewplugin.r) d16).getCurrentUrl();
                                                if (!TextUtils.isEmpty(currentUrl4)) {
                                                    intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, currentUrl4);
                                                }
                                            } else if (this.f238649l.e() != null) {
                                                String g16 = com.tencent.biz.common.util.k.g(this.f238649l.e().getUrl(), new String[0]);
                                                if (!TextUtils.isEmpty(g16)) {
                                                    intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, g16);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (11 == i17) {
                                ForwardUtils.r0(this.f238643f, intent);
                            }
                            jSONObject2 = jSONObject;
                            if (jSONObject2.optInt("share_to_biz", 0) == 1) {
                                ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).setShareArkMsgToGuildIntent(this.f238643f, jSONObject2, intent);
                            }
                            this.f238653p.startActivityForResult(intent, (byte) 3);
                            return;
                        }
                        jSONObject = jSONObject3;
                        b bVar2 = shareMsgImpl.f238653p;
                        str4 = QQCustomArkDialogUtil.META_DATA;
                        bVar2.onSharMsgcallback(shareMsgImpl.f238639b, "{\"result\":1}");
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, optString12);
                        String str52 = str2;
                        intent.putExtra("forward_ark_app_name", str52);
                        intent.putExtra("forward_ark_app_view", optString7);
                        intent.putExtra("forward_ark_biz_src", optString);
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString5);
                        intent.putExtra("forward_ark_app_ver", optString6);
                        intent.putExtra("forward_ark_app_prompt", optString10);
                        intent.putExtra("forward_ark_app_meta", optString9);
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString8);
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString11);
                        intent.putExtra("is_ark_display_share", true);
                        intent.putExtra(str3, str52);
                        intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString7);
                        intent.putExtra(QQCustomArkDialogUtil.BIZ_SRC, optString);
                        intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString6);
                        intent.putExtra(str4, optString9);
                        intent.putExtra("scale", this.f238643f.getResources().getDisplayMetrics().scaledDensity);
                        context = this.f238643f;
                        if (!(context instanceof QQBrowserActivity)) {
                        }
                        if (11 == i17) {
                        }
                        jSONObject2 = jSONObject;
                        if (jSONObject2.optInt("share_to_biz", 0) == 1) {
                        }
                        this.f238653p.startActivityForResult(intent, (byte) 3);
                        return;
                    }
                } else {
                    str2 = optString2;
                    str3 = "appName";
                }
                if (!TextUtils.isEmpty(str2)) {
                    str4 = QQCustomArkDialogUtil.META_DATA;
                    jSONObject = jSONObject3;
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, optString12);
                    String str522 = str2;
                    intent.putExtra("forward_ark_app_name", str522);
                    intent.putExtra("forward_ark_app_view", optString7);
                    intent.putExtra("forward_ark_biz_src", optString);
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString5);
                    intent.putExtra("forward_ark_app_ver", optString6);
                    intent.putExtra("forward_ark_app_prompt", optString10);
                    intent.putExtra("forward_ark_app_meta", optString9);
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString8);
                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString11);
                    intent.putExtra("is_ark_display_share", true);
                    intent.putExtra(str3, str522);
                    intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString7);
                    intent.putExtra(QQCustomArkDialogUtil.BIZ_SRC, optString);
                    intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString6);
                    intent.putExtra(str4, optString9);
                    intent.putExtra("scale", this.f238643f.getResources().getDisplayMetrics().scaledDensity);
                    context = this.f238643f;
                    if (!(context instanceof QQBrowserActivity)) {
                    }
                    if (11 == i17) {
                    }
                    jSONObject2 = jSONObject;
                    if (jSONObject2.optInt("share_to_biz", 0) == 1) {
                    }
                    this.f238653p.startActivityForResult(intent, (byte) 3);
                    return;
                }
                bVar2.onSharMsgcallback(shareMsgImpl.f238639b, "{\"result\":1}");
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, optString12);
                String str5222 = str2;
                intent.putExtra("forward_ark_app_name", str5222);
                intent.putExtra("forward_ark_app_view", optString7);
                intent.putExtra("forward_ark_biz_src", optString);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString5);
                intent.putExtra("forward_ark_app_ver", optString6);
                intent.putExtra("forward_ark_app_prompt", optString10);
                intent.putExtra("forward_ark_app_meta", optString9);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString8);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString11);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra(str3, str5222);
                intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString7);
                intent.putExtra(QQCustomArkDialogUtil.BIZ_SRC, optString);
                intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString6);
                intent.putExtra(str4, optString9);
                intent.putExtra("scale", this.f238643f.getResources().getDisplayMetrics().scaledDensity);
                context = this.f238643f;
                if (!(context instanceof QQBrowserActivity)) {
                }
                if (11 == i17) {
                }
                jSONObject2 = jSONObject;
                if (jSONObject2.optInt("share_to_biz", 0) == 1) {
                }
                this.f238653p.startActivityForResult(intent, (byte) 3);
                return;
            } catch (JSONException e16) {
                e = e16;
                shareMsgImpl = this;
                shareMsgImpl.f238653p.onSharMsgcallback(shareMsgImpl.f238639b, "{\"result\":3}");
                QLog.e("ShareMsgImpl", 1, "shareArkMsg error: " + e.toString());
                return;
            }
            intent.putExtra("isWebCompShare", true);
            intent.setClass(shareMsgImpl.f238643f, ForwardRecentActivity.class);
            intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, jSONObject3.optInt(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13));
            intent.putExtra("forward_type", i3);
            intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
            intent.putExtra("k_back", jSONObject3.optBoolean("k_back", jSONObject3.optBoolean("back", false)));
            String optString52 = jSONObject3.optString("appDesc");
            String optString62 = jSONObject3.optString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            String optString72 = jSONObject3.optString(QQCustomArkDialogUtil.APP_VIEW);
            optString = jSONObject3.optString(QQCustomArkDialogUtil.BIZ_SRC);
            if (TextUtils.isEmpty(optString)) {
            }
            String optString82 = jSONObject3.optString("appConfig");
            String optString92 = jSONObject3.optString(QQCustomArkDialogUtil.META_DATA);
            String optString102 = jSONObject3.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT);
            String optString112 = jSONObject3.optString(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
            String optString122 = jSONObject3.optString("addtionalMsg");
            jSONObject = jSONObject3;
            b bVar22 = shareMsgImpl.f238653p;
            str4 = QQCustomArkDialogUtil.META_DATA;
        } catch (JSONException e17) {
            e = e17;
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("0".equals(jSONObject.optString(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "0"))) {
                Intent intent = new Intent(this.f238643f, (Class<?>) ForwardRecentActivity.class);
                intent.putExtra("pluginName", "web_share");
                intent.putExtra("forward_type", -4);
                intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 3);
                intent.putExtra("k_back", false);
                intent.putExtra("key_flag_from_plugin", true);
                intent.putExtra(AppConstants.Key.FORWARD_TEXT, jSONObject.optString("text"));
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, jSONObject.optString("srcName"));
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, jSONObject.optString("srcIconUrl"));
                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, jSONObject.optString("srcUrl"));
                AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
                if (e16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareMsgImpl", 2, "build struct msg fail");
                    }
                } else {
                    intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
                }
                this.f238653p.startActivityForResult(intent, (byte) 1);
            }
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareHyperText error: " + e17.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    public void r(String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        Activity activity;
        String str5;
        int i3;
        String str6;
        String str7;
        Activity activity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "dialog get web js time :" + currentTimeMillis);
        }
        this.f238639b = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Activity activity3 = this.f238651n;
            if (z16) {
                str3 = "shareType";
            } else {
                str3 = AskAnonymouslyApiPlugin.KEY_SHARE_TYPE;
            }
            String optString = jSONObject.optString(str3, "0");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("desc");
            if (z16) {
                str4 = "shareUrl";
            } else {
                str4 = GetGuildJoinUrlServlet.BUNDLE_KEY_URL;
            }
            String optString4 = jSONObject.optString(str4);
            if (z16) {
                activity = activity3;
                str5 = "imageUrl";
            } else {
                activity = activity3;
                str5 = "image_url";
            }
            try {
                String optString5 = jSONObject.optString(str5);
                String optString6 = jSONObject.optString("shareElement");
                String optString7 = jSONObject.optString("flash_url");
                String optString8 = jSONObject.optString(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                String optString9 = jSONObject.optString("rowkey");
                String optString10 = jSONObject.optString("isfan");
                int optInt = jSONObject.optInt("WXShareFromQQKandian");
                String optString11 = jSONObject.optString("short_video_vid");
                String optString12 = jSONObject.optString("short_video_url");
                String optString13 = jSONObject.optString("short_video_cover_url");
                String optString14 = jSONObject.optString("short_video_theme_name");
                String optString15 = jSONObject.optString(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO);
                String optString16 = jSONObject.optString("busiParams");
                boolean isEmpty = TextUtils.isEmpty(optString5);
                boolean z17 = isEmpty;
                if (TextUtils.isEmpty(optString3)) {
                    z17 = (isEmpty ? 1 : 0) | 2;
                }
                ?? r65 = z17;
                if (TextUtils.isEmpty(optString2)) {
                    r65 = (z17 ? 1 : 0) | 4;
                }
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "94");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                if (r65 == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                sb5.append(i3);
                bundle.putString("intext_1", sb5.toString());
                bundle.putString("intext_2", "" + r65);
                bundle.putString("stringext_1", "" + optString4);
                ReportCenter.f().l(bundle, "", this.f238652o.getAccount(), false);
                int optInt2 = jSONObject.optInt(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13);
                this.f238639b = jSONObject.optString("callback");
                boolean optBoolean = jSONObject.optBoolean("keepShareUrl", false);
                HashMap hashMap = new HashMap();
                if (!optBoolean && optString4 != null && optString4.length() > 140 && !"3".equals(optString)) {
                    hashMap.put(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, optString4);
                }
                if (optString5 != null && optString5.length() > 80 && !"2".equals(optString) && !"3".equals(optString) && !"4".equals(optString)) {
                    hashMap.put("image_url", optString5);
                }
                if (optString7 != null && optString7.length() > 30) {
                    hashMap.put("flash_url", optString7);
                }
                if (!TextUtils.isEmpty(optString11)) {
                    hashMap.put("short_video_vid", optString11);
                }
                if (!TextUtils.isEmpty(optString13)) {
                    hashMap.put("short_video_cover_url", optString13);
                }
                if (!TextUtils.isEmpty(optString12)) {
                    str6 = optString12;
                    hashMap.put("short_video_url", str6);
                } else {
                    str6 = optString12;
                }
                if (!TextUtils.isEmpty(optString14)) {
                    hashMap.put("short_video_theme_name", str6);
                }
                if (!TextUtils.isEmpty(optString15)) {
                    str7 = optString15;
                    hashMap.put(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO, str7);
                } else {
                    str7 = optString15;
                }
                try {
                    if (hashMap.isEmpty() || "1".equals(optString)) {
                        str2 = "ShareMsgImpl";
                        if ("1".equals(optString)) {
                            w(jSONObject, optString, optString2, optString3, optString4, optString5, optString6, optString7);
                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, optString4, optString8, optString9, optString10);
                            return;
                        }
                        if (!"2".equals(optString)) {
                            try {
                                if (!"3".equals(optString)) {
                                    if ("4".equals(optString)) {
                                        x(optString2, optString3, optString4, optString5);
                                        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, optString4, optString8, optString9, optString10);
                                        return;
                                    }
                                    if ("5".equals(optString)) {
                                        v(optString2, optString3, optString4, optString5, 6);
                                        return;
                                    }
                                    if ("6".equals(optString)) {
                                        v(optString2, optString3, optString4, optString5, 7);
                                        return;
                                    }
                                    if (!TextUtils.isEmpty(str7) && jSONObject.has(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO) && str7.equals("true")) {
                                        t(jSONObject, optString, optString2, optString3, optString4, optString5, optString6, optString7, optInt2);
                                        return;
                                    } else {
                                        u(jSONObject, optString, optString2, optString3, optString4, optString5, optString6, optString7, optInt2, optString16);
                                        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, optString4, optString8, optString9, optString10);
                                        return;
                                    }
                                }
                            } catch (JSONException e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    QLog.d(str2, 2, "shareMsg error: " + e.toString());
                                    return;
                                }
                                return;
                            }
                        }
                        y(jSONObject, optString, optString2, optString3, optString4, optString5, optString6, optString7, optInt);
                        if ("2".equals(optString)) {
                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, optString4, optString8, optString9, optString10);
                        }
                        if ("3".equals(optString)) {
                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, optString4, optString8, optString9, optString10);
                            return;
                        }
                        return;
                    }
                    if (this.f238638a == null) {
                        activity2 = activity;
                        c(activity2);
                    } else {
                        activity2 = activity;
                    }
                    if (!this.f238638a.isShowing()) {
                        this.f238638a.setMessage(R.string.c7z);
                        this.f238638a.show();
                    }
                    ThreadManagerV2.post(new Runnable(hashMap, optString4, optString5, optString7, optString, jSONObject, optString2, optString3, optString6, optString8, optString9, optString10, optInt, str7, optInt2, optString16, activity2) { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String C;
                        final /* synthetic */ String D;
                        final /* synthetic */ String E;
                        final /* synthetic */ String F;
                        final /* synthetic */ String G;
                        final /* synthetic */ String H;
                        final /* synthetic */ int I;
                        final /* synthetic */ String J;
                        final /* synthetic */ int K;
                        final /* synthetic */ String L;
                        final /* synthetic */ Activity M;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ HashMap f238654d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f238655e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f238656f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ String f238657h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ String f238658i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ JSONObject f238659m;

                        {
                            this.f238654d = hashMap;
                            this.f238655e = optString4;
                            this.f238656f = optString5;
                            this.f238657h = optString7;
                            this.f238658i = optString;
                            this.f238659m = jSONObject;
                            this.C = optString2;
                            this.D = optString3;
                            this.E = optString6;
                            this.F = optString8;
                            this.G = optString9;
                            this.H = optString10;
                            this.I = optInt;
                            this.J = str7;
                            this.K = optInt2;
                            this.L = optString16;
                            this.M = activity2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                                return;
                            }
                            iPatchRedirector2.redirect((short) 1, this, ShareMsgImpl.this, hashMap, optString4, optString5, optString7, optString, jSONObject, optString2, optString3, optString6, optString8, optString9, optString10, Integer.valueOf(optInt), str7, Integer.valueOf(optInt2), optString16, activity2);
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            HashMap<String, String> shortenUrlBatch = HttpUtil.shortenUrlBatch(this.f238654d);
                            String str8 = shortenUrlBatch.get(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
                            if (str8 == null) {
                                str8 = this.f238655e;
                            }
                            String str9 = shortenUrlBatch.get("image_url");
                            if (str9 == null) {
                                str9 = this.f238656f;
                            }
                            String str10 = shortenUrlBatch.get("flash_url");
                            if (str10 == null) {
                                str10 = this.f238657h;
                            }
                            Runnable runnable = new Runnable(str8, str9, str10) { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f238660d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ String f238661e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f238662f;

                                {
                                    this.f238660d = str8;
                                    this.f238661e = str9;
                                    this.f238662f = str10;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, str8, str9, str10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    Activity activity4 = ShareMsgImpl.this.f238651n;
                                    if (activity4 != null && !activity4.isFinishing()) {
                                        try {
                                            if ("1".equals(AnonymousClass1.this.f238658i)) {
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                ShareMsgImpl.this.w(anonymousClass1.f238659m, anonymousClass1.f238658i, anonymousClass1.C, anonymousClass1.D, this.f238660d, this.f238661e, anonymousClass1.E, this.f238662f);
                                                IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                                iPublicAccountUtil.reportPAShareItemEvent(1002, anonymousClass12.f238655e, anonymousClass12.F, anonymousClass12.G, anonymousClass12.H);
                                                return;
                                            }
                                            if (!"2".equals(AnonymousClass1.this.f238658i) && !"3".equals(AnonymousClass1.this.f238658i)) {
                                                if ("4".equals(AnonymousClass1.this.f238658i)) {
                                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                                    ShareMsgImpl.this.x(anonymousClass13.C, anonymousClass13.D, this.f238660d, this.f238661e);
                                                    IPublicAccountUtil iPublicAccountUtil2 = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                                    AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                                    iPublicAccountUtil2.reportPAShareItemEvent(1005, anonymousClass14.f238655e, anonymousClass14.F, anonymousClass14.G, anonymousClass14.H);
                                                    return;
                                                }
                                                if ("5".equals(AnonymousClass1.this.f238658i)) {
                                                    AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                                    ShareMsgImpl.this.v(anonymousClass15.C, anonymousClass15.D, this.f238660d, this.f238661e, 6);
                                                    return;
                                                }
                                                if ("6".equals(AnonymousClass1.this.f238658i)) {
                                                    AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                                                    ShareMsgImpl.this.v(anonymousClass16.C, anonymousClass16.D, this.f238660d, this.f238661e, 7);
                                                    return;
                                                }
                                                if (!TextUtils.isEmpty(AnonymousClass1.this.J) && AnonymousClass1.this.f238659m.has(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO) && AnonymousClass1.this.J.equals("true")) {
                                                    AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                                                    ShareMsgImpl.this.t(anonymousClass17.f238659m, anonymousClass17.f238658i, anonymousClass17.C, anonymousClass17.D, anonymousClass17.f238655e, anonymousClass17.f238656f, anonymousClass17.E, anonymousClass17.f238657h, anonymousClass17.K);
                                                    return;
                                                }
                                                AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                                                ShareMsgImpl.this.u(anonymousClass18.f238659m, anonymousClass18.f238658i, anonymousClass18.C, anonymousClass18.D, this.f238660d, this.f238661e, anonymousClass18.E, this.f238662f, anonymousClass18.K, anonymousClass18.L);
                                                IPublicAccountUtil iPublicAccountUtil3 = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                                AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                                iPublicAccountUtil3.reportPAShareItemEvent(1001, anonymousClass19.f238655e, anonymousClass19.F, anonymousClass19.G, anonymousClass19.H);
                                                return;
                                            }
                                            AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                            ShareMsgImpl.this.y(anonymousClass110.f238659m, anonymousClass110.f238658i, anonymousClass110.C, anonymousClass110.D, this.f238660d, this.f238661e, anonymousClass110.E, this.f238662f, anonymousClass110.I);
                                            if ("2".equals(AnonymousClass1.this.f238658i)) {
                                                IPublicAccountUtil iPublicAccountUtil4 = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                                AnonymousClass1 anonymousClass111 = AnonymousClass1.this;
                                                iPublicAccountUtil4.reportPAShareItemEvent(1003, anonymousClass111.f238655e, anonymousClass111.F, anonymousClass111.G, anonymousClass111.H);
                                            }
                                            if ("3".equals(AnonymousClass1.this.f238658i)) {
                                                IPublicAccountUtil iPublicAccountUtil5 = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                                AnonymousClass1 anonymousClass112 = AnonymousClass1.this;
                                                iPublicAccountUtil5.reportPAShareItemEvent(1004, anonymousClass112.f238655e, anonymousClass112.F, anonymousClass112.G, anonymousClass112.H);
                                            }
                                        } catch (JSONException e17) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("ShareMsgImpl", 2, "shareMsg error: " + e17.toString());
                                            }
                                        }
                                    }
                                }
                            };
                            if (this.M.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
                                this.M.runOnUiThread(runnable);
                            } else {
                                ShareMsgImpl.this.f238652o.runOnUiThread(runnable);
                            }
                        }
                    }, 8, null, true);
                } catch (JSONException e17) {
                    e = e17;
                }
            } catch (JSONException e18) {
                e = e18;
                str2 = "ShareMsgImpl";
            }
        } catch (JSONException e19) {
            e = e19;
            str2 = "ShareMsgImpl";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
    
        if (r9.isShowing() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
    
        r8.f238638a.dismiss();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00dd, code lost:
    
        if (r9.isShowing() != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void s(String str, String str2, String str3, String str4) {
        Activity activity = this.f238651n;
        if (this.f238638a == null) {
            c(activity);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:false");
            }
            try {
                try {
                    String str5 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str, "UTF-8")) + "&url=" + URLEncoder.encode(str3, "UTF-8")) + "&pic=" + URLEncoder.encode(str4, "UTF-8")) + "&_wv=3";
                    Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str5);
                    activity.startActivity(intent);
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareMsgImpl", 2, "shareMsgToSina start webview!");
                    }
                    QQProgressDialog qQProgressDialog = this.f238638a;
                    if (qQProgressDialog != null) {
                    }
                } catch (Exception e16) {
                    QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    e16.printStackTrace();
                    QQProgressDialog qQProgressDialog2 = this.f238638a;
                    if (qQProgressDialog2 != null) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShareMsgImpl", 2, "shareMsgToSina end!");
                    return;
                }
                return;
            } catch (Throwable th5) {
                QQProgressDialog qQProgressDialog3 = this.f238638a;
                if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                    this.f238638a.dismiss();
                }
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina empty title or share_url");
        }
        QQProgressDialog qQProgressDialog4 = this.f238638a;
        if (qQProgressDialog4 != null && qQProgressDialog4.isShowing()) {
            this.f238638a.dismiss();
        }
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void t(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3) throws JSONException {
        int i16;
        int i17;
        Activity activity;
        String str8;
        int i18;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONObject jSONObject2;
        QQProgressDialog qQProgressDialog;
        String optString;
        String str13;
        String jSONObject3;
        String str14;
        String str15;
        String str16;
        String str17;
        int i19;
        int i26;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22 = str2;
        Activity activity2 = this.f238651n;
        Intent intent = new Intent();
        String optString2 = jSONObject.optString("toUin");
        int optInt = jSONObject.optInt("uinType", 0);
        if (optString2 != null && optString2.length() >= 5) {
            intent.setClass(this.f238643f, DirectForwardActivity.class);
            intent.putExtra("toUin", optString2);
            intent.putExtra("uinType", optInt);
        } else {
            intent.putExtra("isWebCompShare", true);
            intent.setClass(this.f238643f, ForwardRecentActivity.class);
        }
        com.tencent.mobileqq.webviewplugin.n nVar = this.f238647j;
        if (nVar != null) {
            i16 = ((Share) nVar.getShare()).C();
        } else {
            i16 = 0;
        }
        if (11 == i16) {
            ForwardUtils.r0(this.f238643f, intent);
        }
        intent.putExtra("key_flag_from_plugin", true);
        if (str22 != null && str2.length() > 45) {
            str22 = str22.substring(0, 45) + "\u2026";
        }
        String str23 = str22;
        if (i3 <= 0) {
            i17 = 13;
        } else {
            i17 = i3;
        }
        if (jSONObject.has(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO) && jSONObject.getString(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO).equals("true")) {
            if (!jSONObject.has("tribe_video_vid")) {
                str14 = "";
            } else {
                str14 = jSONObject.getString("tribe_video_vid");
            }
            if (!jSONObject.has("tribe_video_url")) {
                str15 = "";
            } else {
                str15 = jSONObject.getString("tribe_video_url");
            }
            if (!jSONObject.has("tribe_video_theme")) {
                str16 = "";
            } else {
                str16 = jSONObject.getString("tribe_video_theme");
            }
            if (!jSONObject.has(AppConstants.Key.FORWARD_TRIBE_VIDEO_COVER_URL)) {
                str17 = "";
            } else {
                str17 = jSONObject.getString(AppConstants.Key.FORWARD_TRIBE_VIDEO_COVER_URL);
            }
            if (jSONObject.has("tribe_video_width")) {
                str11 = "";
                i19 = jSONObject.getInt("tribe_video_width");
                activity = activity2;
            } else {
                activity = activity2;
                str11 = "";
                i19 = 0;
            }
            if (jSONObject.has("tribe_video_height")) {
                i26 = jSONObject.getInt("tribe_video_height");
                i18 = i17;
            } else {
                i18 = i17;
                i26 = 0;
            }
            if (jSONObject.has("tribe_name")) {
                str18 = "ShareMsgImpl";
                str8 = str23;
                str19 = jSONObject.getString("tribe_name");
            } else {
                str8 = str23;
                str18 = "ShareMsgImpl";
                str19 = str11;
            }
            if (jSONObject.has("tribe_bid")) {
                str20 = jSONObject.getString("tribe_bid");
            } else {
                str20 = str11;
            }
            if (jSONObject.has("tribe_pid")) {
                str21 = jSONObject.getString("tribe_pid");
            } else {
                str21 = str11;
            }
            intent.putExtra("forward_type", 36);
            try {
                jSONObject2 = new JSONObject();
                str9 = "forward_type";
                try {
                    jSONObject2.put(AppConstants.Key.FORWARD_IS_TRIBE_SHORT_VIDEO, 1);
                    jSONObject2.put("tribe_name", str19);
                    jSONObject2.put("tribe_video_vid", str14);
                    jSONObject2.put("tribe_video_url", str15);
                    jSONObject2.put("tribe_video_theme", str16);
                    jSONObject2.put("tribe_video_width", i19);
                    jSONObject2.put("tribe_video_height", i26);
                    jSONObject2.put("tribe_bid", str20);
                    jSONObject2.put("tribe_pid", str21);
                    intent.putExtra(AppConstants.Key.FORWARD_TRIBE_VIDEO_EXTRA, jSONObject2.toString());
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        str10 = str18;
                        QLog.d(str10, 2, QLog.getStackTraceString(e));
                        str12 = str17;
                        intent.putExtra("pluginName", "web_share");
                        intent.putExtra("title", str8);
                        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i18);
                        intent.putExtra(str9, 36);
                        intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
                        intent.putExtra("pkg_name", "com.tencent.mobileqq");
                        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str12);
                        intent.putExtra(AppConstants.Key.SHARE_BRIEF, jSONObject.optString("desc"));
                        intent.putExtra("flag", jSONObject.optInt("flag", 0));
                        intent.putExtra("detail_url", str4);
                        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 118);
                        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                        boolean optBoolean = jSONObject.optBoolean("back", false);
                        if (jSONObject.has("k_back")) {
                        }
                        intent.putExtra("k_back", optBoolean);
                        if (this.f238638a == null) {
                        }
                        qQProgressDialog = this.f238638a;
                        if (qQProgressDialog != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (QLog.isColorLevel()) {
                            }
                            this.f238638a.dismiss();
                        }
                        optString = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN, null);
                        if (optString == null) {
                        }
                        if (!TextUtils.isEmpty(optString)) {
                        }
                    }
                    str10 = str18;
                    str12 = str17;
                    intent.putExtra("pluginName", "web_share");
                    intent.putExtra("title", str8);
                    intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i18);
                    intent.putExtra(str9, 36);
                    intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
                    intent.putExtra("pkg_name", "com.tencent.mobileqq");
                    intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str12);
                    intent.putExtra(AppConstants.Key.SHARE_BRIEF, jSONObject.optString("desc"));
                    intent.putExtra("flag", jSONObject.optInt("flag", 0));
                    intent.putExtra("detail_url", str4);
                    intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 118);
                    intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                    boolean optBoolean2 = jSONObject.optBoolean("back", false);
                    if (jSONObject.has("k_back")) {
                    }
                    intent.putExtra("k_back", optBoolean2);
                    if (this.f238638a == null) {
                    }
                    qQProgressDialog = this.f238638a;
                    if (qQProgressDialog != null) {
                    }
                    optString = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN, null);
                    if (optString == null) {
                    }
                    if (!TextUtils.isEmpty(optString)) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str9 = "forward_type";
                jSONObject2 = null;
            }
            str10 = str18;
            str12 = str17;
        } else {
            activity = activity2;
            str8 = str23;
            i18 = i17;
            str9 = "forward_type";
            str10 = "ShareMsgImpl";
            str11 = "";
            if (QLog.isColorLevel()) {
                QLog.w(str10, 2, "forward short video is false");
            }
            str12 = str11;
            jSONObject2 = null;
        }
        intent.putExtra("pluginName", "web_share");
        intent.putExtra("title", str8);
        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i18);
        intent.putExtra(str9, 36);
        intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str12);
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, jSONObject.optString("desc"));
        intent.putExtra("flag", jSONObject.optInt("flag", 0));
        intent.putExtra("detail_url", str4);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 118);
        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        boolean optBoolean22 = jSONObject.optBoolean("back", false);
        if (jSONObject.has("k_back")) {
            optBoolean22 = jSONObject.getBoolean("k_back");
        }
        intent.putExtra("k_back", optBoolean22);
        if (this.f238638a == null) {
            c(activity);
        }
        qQProgressDialog = this.f238638a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(str10, 2, "dialog dimiss time :" + currentTimeMillis2);
            }
            this.f238638a.dismiss();
        }
        optString = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN, null);
        if (optString == null) {
            optString = jSONObject.optString("oaUin");
        }
        if (!TextUtils.isEmpty(optString)) {
            AppInterface appInterface = this.f238652o;
            EntityManager createEntityManager = appInterface.getEntityManagerFactory(appInterface.getAccount()).createEntityManager();
            IPublicAccountDetail iPublicAccountDetail = (IPublicAccountDetail) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), optString);
            createEntityManager.close();
            if (iPublicAccountDetail != null) {
                str13 = iPublicAccountDetail.getName();
            } else {
                str13 = null;
            }
            if (TextUtils.isEmpty(str13) && jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                str13 = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            }
            if (TextUtils.isEmpty(str13)) {
                str13 = optString;
            }
            String str24 = str11;
            intent.putExtra(AppConstants.Key.SHARE_SOURCE_URL, jSONObject.optString(AppConstants.Key.SHARE_SOURCE_URL, str24));
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
            intent.putExtra("source_puin", optString);
            intent.putExtra("app_name", str13);
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 118);
            AbsStructMsg e18 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
            if (e18 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(str10, 2, "build struct msg fail");
                }
                this.f238653p.onSharMsgcallback(this.f238639b, "false");
                return;
            }
            e18.mMsgServiceID = 118;
            if (jSONObject2 == null) {
                jSONObject3 = str24;
            } else {
                jSONObject3 = jSONObject2.toString();
            }
            e18.mTribeShortVideoExtra = jSONObject3;
            e18.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e18.getBytes());
            this.f238653p.startActivityForResult(intent, (byte) 4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x0546, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0579, code lost:
    
        if (r5.equalsIgnoreCase(r24.f238643f.getString(com.tencent.mobileqq.R.string.fwb)) == false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x057b, code lost:
    
        r2 = r5.equalsIgnoreCase(r24.f238643f.getString(com.tencent.mobileqq.R.string.fwb));
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0588, code lost:
    
        if (r2 == false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x058a, code lost:
    
        r6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0591, code lost:
    
        if (r2 == false) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0593, code lost:
    
        r10 = "mqqapi://readinjoy/open?src_type=internal&version=1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x059a, code lost:
    
        if (r2 == false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x059c, code lost:
    
        r2 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x05a3, code lost:
    
        r8.putExtra("source_puin", r0);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r6);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r10);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_A_ACTION_DATA, r6);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, r2);
        r8.putExtra("app_name", r5);
        r16 = "ShareMsgImpl";
        r26 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05a0, code lost:
    
        r2 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0597, code lost:
    
        r10 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x058e, code lost:
    
        r6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x05c4, code lost:
    
        r10 = r25.optString("src_webActionUrl", r12);
        r26 = r15;
        r15 = r25.optString("src_actionData", r12);
        r16 = "ShareMsgImpl";
        r13 = r25.optString("src_a_actionData", r12);
        r1 = r25.optString("src_i_actionData", r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x05ea, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05f3, code lost:
    
        if ("web".equals(r6) == false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x05f9, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0602, code lost:
    
        if (r10.contains("webcard.mp.qq.com") != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0608, code lost:
    
        if ("web".equals(r6) != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x060e, code lost:
    
        if (android.text.TextUtils.isEmpty(r15) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0614, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) != false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x061a, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x061d, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0624, code lost:
    
        if ("web".equals(r6) == false) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0626, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, r10);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.SHARE_SOURCE_URL, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0676, code lost:
    
        r8.putExtra("source_puin", r0);
        r8.putExtra("app_name", r5);
        r0 = r25.optString("src_iconUrl", r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0689, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x068b, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SHARE_SRC_ICON);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0694, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0637, code lost:
    
        if (android.text.TextUtils.isEmpty(r15) != false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0639, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0643, code lost:
    
        if (android.text.TextUtils.isEmpty(r13) != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0645, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x064c, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x064e, code lost:
    
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0652, code lost:
    
        r2 = java.lang.String.format(com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, r0);
        r1 = java.lang.String.format(com.tencent.biz.pubaccount.api.IPublicAccountBrowser.SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL, r0);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, r2);
        r8.putExtra(com.tencent.mobileqq.app.AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0565, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0563, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L200;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void u(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, String str8) throws JSONException {
        Bundle bundle;
        Activity activity;
        com.tencent.mobileqq.webviewplugin.n nVar;
        int i16;
        int i17;
        int i18;
        JSONObject jSONObject2;
        int optInt;
        long optLong;
        Bundle bundle2;
        String str9;
        String str10;
        ShareMsgImpl shareMsgImpl;
        com.tencent.mobileqq.webviewplugin.o oVar;
        AbsStructMsg e16;
        String optString;
        int i19;
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler;
        Share share;
        String str11 = str2;
        String str12 = str3;
        if (jSONObject.has("isArkMessage") && jSONObject.getBoolean("isArkMessage")) {
            m(jSONObject);
            return;
        }
        Activity activity2 = this.f238651n;
        Intent intent = new Intent();
        String optString2 = jSONObject.optString("toUin");
        int optInt2 = jSONObject.optInt("uinType", 0);
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        WebViewPlugin.b bVar = this.f238649l;
        if (bVar != null && bVar.f() != null) {
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler2 = (SwiftBrowserShareMenuHandler) this.f238649l.f().getComponentProvider().a(4);
            bundle = swiftBrowserShareMenuHandler2.u();
            intent.putExtra("forward_source_sub_business_type", TextUtils.isEmpty(swiftBrowserShareMenuHandler2.f314303i0) ? "" : swiftBrowserShareMenuHandler2.f314303i0);
        } else {
            WebViewPlugin.b bVar2 = this.f238649l;
            if (bVar2 != null && bVar2.e() != null) {
                ViewParent parent = this.f238649l.e().getParent();
                if (parent instanceof com.tencent.comic.api.a) {
                    com.tencent.comic.api.a aVar = (com.tencent.comic.api.a) parent;
                    if (aVar.getShareHelper() instanceof com.tencent.share.a) {
                        com.tencent.share.a aVar2 = (com.tencent.share.a) aVar.getShareHelper();
                        bundle = aVar2.g();
                        intent.putExtra("forward_source_sub_business_type", TextUtils.isEmpty(aVar2.i()) ? "" : aVar2.i());
                    }
                }
            }
            bundle = null;
        }
        if (TextUtils.isEmpty(optString2) && optInt2 == 0 && bundle != null && !bundle.isEmpty()) {
            optString2 = bundle.getString("to_qq");
            optInt2 = bundle.getInt(ShortVideoConstants.TO_UIN_TYPE);
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareMsgToQQ() called : toUin = " + optString2 + ", uinType = " + optInt2);
            }
        }
        String optString3 = jSONObject.optString("toNickName");
        int optInt3 = jSONObject.optInt("isEncryptUin", 0);
        if (optString2 != null) {
            activity = activity2;
            if (optString2.length() >= 5) {
                intent.setClass(this.f238643f, DirectForwardActivity.class);
                intent.putExtra("toUin", optString2);
                intent.putExtra("uinType", optInt2);
                if (optInt3 == 1) {
                    intent.putExtra("isEncryptUin", optInt3);
                    intent.putExtra("vfwebqq", jSONObject.optString("vfwebqq"));
                    intent.putExtra("tok", jSONObject.optString("tok"));
                }
                if (TextUtils.isEmpty(optString3) && bundle != null && !bundle.isEmpty()) {
                    optString3 = bundle.getString("to_uin_name");
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareMsgImpl", 2, "shareMsgToQQ() called : nickName = " + optString3);
                    }
                    intent.putExtra("nickName", optString3);
                }
                if (this.f238650m == null && !TextUtils.isEmpty(optString3)) {
                    intent.putExtra("nickName", optString3);
                }
                nVar = this.f238647j;
                if (11 == (nVar == null ? ((Share) nVar.getShare()).C() : 0)) {
                    ForwardUtils.r0(this.f238643f, intent);
                }
                intent.putExtra("key_flag_from_plugin", true);
                WebViewPlugin.b bVar3 = this.f238649l;
                WebViewProvider f16 = bVar3 == null ? bVar3.f() : null;
                int i26 = (f16 != null || (swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) f16.getComponentProvider().a(4)) == null || (share = swiftBrowserShareMenuHandler.f314302i) == null || !share.g0(intent)) ? 1001 : 38;
                if ("aniSticker".equals(str6)) {
                    try {
                        jSONObject2 = new JSONObject(str8);
                        i16 = jSONObject2.getInt("QSid");
                    } catch (JSONException e17) {
                        e = e17;
                        i16 = 0;
                    }
                    try {
                        i18 = jSONObject2.getInt("hideInput");
                        i17 = 1;
                    } catch (JSONException e18) {
                        e = e18;
                        i17 = 1;
                        QLog.e("ShareMsgImpl", 1, "parse error, busiParams:" + str8, e);
                        i18 = 0;
                        intent.putExtra(AppConstants.Key.FORWARD_EXTRA, i16);
                        intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((IQQTextApi) QRoute.api(IQQTextApi.class)).getQQText(((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).convertEmoServerIdToEmoCode(i16, i17), 3, 16, null, null));
                        if (i18 == 1) {
                        }
                        i26 = 48;
                        if (str11 != null) {
                        }
                        if (str12 != null) {
                        }
                        if (i3 <= 0) {
                        }
                        intent.putExtra("pluginName", "web_share");
                        intent.putExtra("title", str11);
                        intent.putExtra("desc", str12);
                        intent.putExtra("detail_url", str4);
                        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, r6);
                        intent.putExtra("forward_type", i26);
                        intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
                        intent.putExtra("pkg_name", "com.tencent.mobileqq");
                        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str5);
                        intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, str11));
                        intent.putExtra("flag", jSONObject.optInt("flag", 0));
                        if (jSONObject.has("contentAction")) {
                        }
                        if (jSONObject.has(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA)) {
                        }
                        if (jSONObject.has("sourceAction")) {
                        }
                        if (jSONObject.has("isShareFlag")) {
                        }
                        if (jSONObject.has("srcActionData")) {
                        }
                        if (jSONObject.has("appName")) {
                        }
                        if ("audio".equals(str6)) {
                        }
                        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, optInt);
                        if (jSONObject.has("report")) {
                        }
                        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                        boolean optBoolean = jSONObject.optBoolean("back", false);
                        if (jSONObject.has("k_back")) {
                        }
                        intent.putExtra("forward _key_nojump", optBoolean);
                        intent.putExtra("k_back", optBoolean);
                        if (jSONObject.has("serviceID")) {
                        }
                        if (jSONObject.has("serviceID")) {
                        }
                        if (jSONObject.has(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED)) {
                        }
                        optLong = jSONObject.optLong("appid", 0L);
                        if (optLong > 0) {
                        }
                        if (bundle2 != null) {
                        }
                    }
                    intent.putExtra(AppConstants.Key.FORWARD_EXTRA, i16);
                    intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((IQQTextApi) QRoute.api(IQQTextApi.class)).getQQText(((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).convertEmoServerIdToEmoCode(i16, i17), 3, 16, null, null));
                    if (i18 == 1) {
                        intent.putExtra(ForwardBaseOption.FORWARD_INPUT_VIEW_HIDE, true);
                    }
                    i26 = 48;
                }
                if (str11 != null && str2.length() > 45) {
                    str11 = str11.substring(0, 45) + "\u2026";
                }
                if (str12 != null && str3.length() > 60) {
                    str12 = str12.substring(0, 60) + "\u2026";
                }
                int i27 = i3 <= 0 ? 13 : i3;
                intent.putExtra("pluginName", "web_share");
                intent.putExtra("title", str11);
                intent.putExtra("desc", str12);
                intent.putExtra("detail_url", str4);
                intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i27);
                intent.putExtra("forward_type", i26);
                intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
                intent.putExtra("pkg_name", "com.tencent.mobileqq");
                intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str5);
                intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, str11));
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
                if ("audio".equals(str6)) {
                    intent.putExtra(AppConstants.Key.SHARE_REQ_AUDIO_URL, str7);
                    optInt = 2;
                } else {
                    optInt = jSONObject.optInt(AppConstants.Key.SHARE_REQ_TYPE, 146);
                    if (optInt == 2) {
                        intent.putExtra(AppConstants.Key.SHARE_REQ_AUDIO_URL, jSONObject.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL));
                    }
                }
                intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, optInt);
                if (jSONObject.has("report")) {
                    intent.putExtra("report", jSONObject.getString("report"));
                }
                intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                boolean optBoolean2 = jSONObject.optBoolean("back", false);
                if (jSONObject.has("k_back")) {
                    optBoolean2 = jSONObject.getBoolean("k_back");
                }
                intent.putExtra("forward _key_nojump", optBoolean2);
                intent.putExtra("k_back", optBoolean2);
                if (jSONObject.has("serviceID")) {
                    intent.putExtra(AppConstants.Key.KEY_NEW_SHARE_SERVICE_ID, jSONObject.getString("serviceID"));
                }
                if (jSONObject.has("serviceID") && ((i19 = jSONObject.getInt("serviceID")) == 116 || i19 == 123)) {
                    intent.putExtra(AppConstants.Key.KEY_STRUCT_MSG_COMPATIBLE_TEXT, ConfessMsgUtil.f202125b);
                }
                if (jSONObject.has(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED)) {
                    intent.putExtra(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED, jSONObject.optBoolean(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED));
                }
                optLong = jSONObject.optLong("appid", 0L);
                if (optLong > 0) {
                    AppInterface appInterface = this.f238652o;
                    if (appInterface != null) {
                        if (this.f238638a == null) {
                            c(activity);
                        }
                        if (!this.f238638a.isShowing()) {
                            this.f238638a.setMessage(R.string.c7z);
                            this.f238638a.show();
                        }
                        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, Long.toString(optLong));
                        Share.o(appInterface, this.f238643f, appInterface.getAccount(), optLong, 3000L, new a(intent));
                    }
                    bundle2 = bundle;
                } else {
                    Activity activity3 = activity;
                    if (this.f238638a == null) {
                        c(activity3);
                    }
                    QQProgressDialog qQProgressDialog = this.f238638a;
                    if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareMsgImpl", 2, "dialog dimiss time :" + currentTimeMillis);
                        }
                        this.f238638a.dismiss();
                    }
                    String optString4 = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN, null);
                    if (optString4 == null) {
                        optString4 = jSONObject.optString("oaUin");
                    }
                    if (!TextUtils.isEmpty(optString4)) {
                        AppInterface appInterface2 = this.f238652o;
                        EntityManager createEntityManager = appInterface2.getEntityManagerFactory(appInterface2.getAccount()).createEntityManager();
                        IPublicAccountDetail iPublicAccountDetail = (IPublicAccountDetail) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), optString4);
                        createEntityManager.close();
                        str9 = "";
                        String optString5 = jSONObject.optString("src_action", str9);
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
                        oVar = shareMsgImpl.f238646i;
                        if (oVar != null && shareMsgImpl.f238644g != null) {
                            intent.putExtra("strurt_msgid", oVar.getMsgid());
                            intent.putExtra("struct_uin", shareMsgImpl.f238646i.f1());
                            intent.putExtra("struct_url", shareMsgImpl.f238644g.getCurrentUrl());
                            intent.putExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
                            if (shareMsgImpl.f238646i.A4() != null && !str9.equals(shareMsgImpl.f238646i.A4())) {
                                intent.putExtra("source_puin", shareMsgImpl.f238646i.A4());
                            }
                        }
                        e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
                        if (e16 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(str10, 2, "build struct msg fail");
                            }
                            shareMsgImpl.f238653p.onSharMsgcallback(shareMsgImpl.f238639b, "false");
                            return;
                        }
                        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
                        shareMsgImpl.f238653p.startActivityForResult(intent, (byte) 1);
                    } else {
                        bundle2 = bundle;
                        str9 = "";
                        str10 = "ShareMsgImpl";
                        if (jSONObject.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                            String optString6 = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
                            intent.putExtra("app_name", optString6);
                            if ("\u624bQ\u9605\u8bfb".equals(optString6) && jSONObject.has("srcIconUrl")) {
                                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, jSONObject.optString("srcIconUrl"));
                            }
                            if ("QQ\u52a8\u6f2b".equals(optString6) && jSONObject.has("srcIconUrl")) {
                                intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, jSONObject.optString("srcIconUrl"));
                            }
                        } else {
                            shareMsgImpl = this;
                            intent.putExtra("app_name", shareMsgImpl.f238643f.getString(R.string.dyf));
                            oVar = shareMsgImpl.f238646i;
                            if (oVar != null) {
                                intent.putExtra("strurt_msgid", oVar.getMsgid());
                                intent.putExtra("struct_uin", shareMsgImpl.f238646i.f1());
                                intent.putExtra("struct_url", shareMsgImpl.f238644g.getCurrentUrl());
                                intent.putExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
                                if (shareMsgImpl.f238646i.A4() != null) {
                                    intent.putExtra("source_puin", shareMsgImpl.f238646i.A4());
                                }
                            }
                            e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
                            if (e16 == null) {
                            }
                        }
                    }
                    shareMsgImpl = this;
                    oVar = shareMsgImpl.f238646i;
                    if (oVar != null) {
                    }
                    e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
                    if (e16 == null) {
                    }
                }
                if (bundle2 != null) {
                    bundle2.clear();
                    return;
                }
                return;
            }
        } else {
            activity = activity2;
        }
        intent.putExtra("isWebCompShare", true);
        intent.setClass(this.f238643f, ForwardRecentActivity.class);
        nVar = this.f238647j;
        if (11 == (nVar == null ? ((Share) nVar.getShare()).C() : 0)) {
        }
        intent.putExtra("key_flag_from_plugin", true);
        WebViewPlugin.b bVar32 = this.f238649l;
        if (bVar32 == null) {
        }
        if (f16 != null) {
        }
        if ("aniSticker".equals(str6)) {
        }
        if (str11 != null) {
            str11 = str11.substring(0, 45) + "\u2026";
        }
        if (str12 != null) {
            str12 = str12.substring(0, 60) + "\u2026";
        }
        if (i3 <= 0) {
        }
        intent.putExtra("pluginName", "web_share");
        intent.putExtra("title", str11);
        intent.putExtra("desc", str12);
        intent.putExtra("detail_url", str4);
        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, i27);
        intent.putExtra("forward_type", i26);
        intent.putExtra("req_share_id", jSONObject.optLong("appid", -1L));
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str5);
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, BaseApplication.getContext().getString(R.string.f171308dy0, str11));
        intent.putExtra("flag", jSONObject.optInt("flag", 0));
        if (jSONObject.has("contentAction")) {
        }
        if (jSONObject.has(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA)) {
        }
        if (jSONObject.has("sourceAction")) {
        }
        if (jSONObject.has("isShareFlag")) {
        }
        if (jSONObject.has("srcActionData")) {
        }
        if (jSONObject.has("appName")) {
        }
        if ("audio".equals(str6)) {
        }
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, optInt);
        if (jSONObject.has("report")) {
        }
        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        boolean optBoolean22 = jSONObject.optBoolean("back", false);
        if (jSONObject.has("k_back")) {
        }
        intent.putExtra("forward _key_nojump", optBoolean22);
        intent.putExtra("k_back", optBoolean22);
        if (jSONObject.has("serviceID")) {
        }
        if (jSONObject.has("serviceID")) {
            intent.putExtra(AppConstants.Key.KEY_STRUCT_MSG_COMPATIBLE_TEXT, ConfessMsgUtil.f202125b);
        }
        if (jSONObject.has(AppConstants.Key.NEED_SEND_LONG_MSG_WHEN_FAILED)) {
        }
        optLong = jSONObject.optLong("appid", 0L);
        if (optLong > 0) {
        }
        if (bundle2 != null) {
        }
    }

    void v(String str, String str2, String str3, String str4, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToQidianOrQiye start: " + i3);
        }
        Activity activity = this.f238651n;
        if (this.f238638a == null) {
            c(activity);
        }
        QQProgressDialog qQProgressDialog = this.f238638a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f238638a.dismiss();
        }
        QidianManager.i0(activity, i3, str, str2, str3, str4, "", 0, false);
    }

    void w(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i3;
        WebViewPlugin webViewPlugin;
        Activity activity = this.f238651n;
        if (this.f238638a == null) {
            c(activity);
        }
        QQProgressDialog qQProgressDialog = this.f238638a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f238638a.dismiss();
        }
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
        com.tencent.mobileqq.webviewplugin.o oVar = this.f238646i;
        if (oVar != null && this.f238644g != null) {
            bundle.putString("strurt_msgid", oVar.getMsgid());
            bundle.putString("struct_uin", this.f238646i.f1());
            bundle.putString("struct_url", this.f238644g.getCurrentUrl());
            bundle.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
            if (this.f238646i.A4() != null && !"".equals(this.f238646i.A4())) {
                bundle.putString("source_puin", this.f238646i.A4());
            }
        }
        com.tencent.mobileqq.webviewplugin.f fVar = this.f238645h;
        if (fVar != null && (webViewPlugin = this.f238650m) != null) {
            i3 = fVar.switchRequestCode(webViewPlugin, (byte) 1, true);
        } else {
            i3 = 1;
        }
        if (activity.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
            i3 = 15001;
        }
        if (!QZoneShareManager.jumpToQzoneShare(this.f238652o, this.f238643f, bundle, (DialogInterface.OnDismissListener) null, i3)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
            this.f238653p.onSharMsgcallback(this.f238639b, "false");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
    
        if (r0.isShowing() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014d, code lost:
    
        r17.f238638a.dismiss();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014b, code lost:
    
        if (r0.isShowing() != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina start!");
        }
        try {
            Uri parse = Uri.parse(str3);
            if (parse != null) {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && (PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host))) {
                    s(str, str2, str3, str4);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        Activity activity = this.f238651n;
        if (this.f238638a == null) {
            c(activity);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                ApplicationInfo applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo("com.sina.weibo", 8192);
                if (QLog.isColorLevel()) {
                    QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:true");
                }
                ThreadManagerV2.executeOnSubThread(new Runnable(str4, activity, str, str2, str3, applicationInfo) { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f238664d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Activity f238665e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f238666f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f238667h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f238668i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ ApplicationInfo f238669m;

                    {
                        this.f238664d = str4;
                        this.f238665e = activity;
                        this.f238666f = str;
                        this.f238667h = str2;
                        this.f238668i = str3;
                        this.f238669m = applicationInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ShareMsgImpl.this, str4, activity, str, str2, str3, applicationInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareMsgImpl", 2, "shareMsgToSina download image:" + this.f238664d);
                        }
                        String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), this.f238664d, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareMsgImpl", 2, "shareMsgToSina path:" + e16);
                        }
                        if (WBShareHelper.u(this.f238665e)) {
                            WBShareHelper.h(2).s((Activity) ShareMsgImpl.this.f238643f, this.f238666f, this.f238667h, this.f238668i, "text", BitmapFactory.decodeFile(e16));
                            QLog.d("ShareMsgImpl", 1, "shareMsgToSina use weibo sdk!");
                        } else {
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setFlags(268435456);
                            intent.setType("image/*");
                            intent.putExtra("android.intent.extra.TEXT", this.f238666f + this.f238668i);
                            if (!TextUtils.isEmpty(e16)) {
                                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(e16)));
                            }
                            FileProvider7Helper.intentCompatForN(this.f238665e, intent);
                            intent.setPackage(this.f238669m.packageName);
                            this.f238665e.startActivity(intent);
                        }
                        this.f238665e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QQProgressDialog qQProgressDialog = ShareMsgImpl.this.f238638a;
                                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                                    ShareMsgImpl.this.f238638a.dismiss();
                                }
                            }
                        });
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareMsgImpl", 2, "shareMsgToSina start weibo!");
                        }
                    }
                });
            } catch (PackageManager.NameNotFoundException unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:false");
                }
                try {
                    try {
                        String str5 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str, "UTF-8")) + "&url=" + URLEncoder.encode(str3, "UTF-8")) + "&pic=" + URLEncoder.encode(str4, "UTF-8")) + "&_wv=3";
                        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", str5);
                        activity.startActivity(intent);
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareMsgImpl", 2, "shareMsgToSina start webview!");
                        }
                        QQProgressDialog qQProgressDialog = this.f238638a;
                        if (qQProgressDialog != null) {
                        }
                    } catch (Exception e16) {
                        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        e16.printStackTrace();
                        QQProgressDialog qQProgressDialog2 = this.f238638a;
                        if (qQProgressDialog2 != null) {
                        }
                    }
                } catch (Throwable th5) {
                    QQProgressDialog qQProgressDialog3 = this.f238638a;
                    if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                        this.f238638a.dismiss();
                    }
                    throw th5;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareMsgToSina end!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina empty title or share_url");
        }
        QQProgressDialog qQProgressDialog4 = this.f238638a;
        if (qQProgressDialog4 != null && qQProgressDialog4.isShowing()) {
            this.f238638a.dismiss();
        }
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.hit, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    void y(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3) {
        int i16;
        Activity activity = this.f238651n;
        if (!WXShareHelper.b0().e0()) {
            i16 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i16 = R.string.f173258ih2;
        } else {
            i16 = -1;
        }
        if (i16 != -1) {
            com.tencent.biz.qrcode.util.h.T(0, i16);
            if (this.f238638a == null) {
                c(activity);
            }
            QQProgressDialog qQProgressDialog = this.f238638a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f238638a.dismiss();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap(1);
        Runnable runnable = new Runnable(str, str4, i3, hashMap, str6, str2, str3, str7) { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String C;
            final /* synthetic */ String D;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f238671d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f238672e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f238673f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Map f238674h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f238675i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f238676m;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.jsp.ShareMsgImpl$3$a */
            /* loaded from: classes15.dex */
            class a implements WXShareHelper.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public void onWXShareResp(BaseResp baseResp) {
                    boolean z16;
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                        return;
                    }
                    String str = ShareMsgImpl.this.f238642e;
                    if (str != null && str.equals(baseResp.transaction)) {
                        int i16 = baseResp.errCode;
                        if (i16 != -2) {
                            z16 = true;
                            if (i16 != 0) {
                                com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                            } else {
                                com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                ShareMsgImpl shareMsgImpl = ShareMsgImpl.this;
                                if (shareMsgImpl.f238646i != null && shareMsgImpl.f238644g != null) {
                                    if ("2".equals(anonymousClass3.f238671d)) {
                                        i3 = 1009;
                                    } else {
                                        i3 = 1004;
                                    }
                                    int i17 = i3;
                                    String msgid = ShareMsgImpl.this.f238646i.getMsgid();
                                    String f16 = ShareMsgImpl.this.f238646i.f1();
                                    String str2 = AnonymousClass3.this.f238672e;
                                    String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(ShareMsgImpl.this.f238644g.getCurrentUrl());
                                    String A4 = ShareMsgImpl.this.f238646i.A4();
                                    if (A4 != null && !"".equals(A4)) {
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", i17, 0, A4, msgid, ShareMsgImpl.this.f238644g.getCurrentUrl(), articleId, false);
                                    } else {
                                        if ("2".equals(AnonymousClass3.this.f238671d)) {
                                            i17 = 1003;
                                        }
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80059DC", "0X80059DC", i17, 0, f16, msgid, str2, articleId, false);
                                    }
                                }
                                ShareMsgImpl shareMsgImpl2 = ShareMsgImpl.this;
                                shareMsgImpl2.f238653p.onSharMsgcallback(shareMsgImpl2.f238639b, String.valueOf(z16));
                            }
                        }
                        z16 = false;
                        ShareMsgImpl shareMsgImpl22 = ShareMsgImpl.this;
                        shareMsgImpl22.f238653p.onSharMsgcallback(shareMsgImpl22.f238639b, String.valueOf(z16));
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.jsp.ShareMsgImpl$3$b */
            /* loaded from: classes15.dex */
            class b implements IWxShareHelperFromReadInjoy.a {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.a
                public void onWXShareResp(BaseResp baseResp) {
                    boolean z16;
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                        return;
                    }
                    String str = ShareMsgImpl.this.f238642e;
                    if (str != null && str.equals(baseResp.transaction)) {
                        int i16 = baseResp.errCode;
                        if (i16 != -2) {
                            z16 = true;
                            if (i16 != 0) {
                                com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                            } else {
                                com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                ShareMsgImpl shareMsgImpl = ShareMsgImpl.this;
                                if (shareMsgImpl.f238646i != null && shareMsgImpl.f238644g != null) {
                                    if ("2".equals(anonymousClass3.f238671d)) {
                                        i3 = 1009;
                                    } else {
                                        i3 = 1004;
                                    }
                                    int i17 = i3;
                                    String msgid = ShareMsgImpl.this.f238646i.getMsgid();
                                    String f16 = ShareMsgImpl.this.f238646i.f1();
                                    String str2 = AnonymousClass3.this.f238672e;
                                    String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(ShareMsgImpl.this.f238644g.getCurrentUrl());
                                    String A4 = ShareMsgImpl.this.f238646i.A4();
                                    if (A4 != null && !"".equals(A4)) {
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", i17, 0, A4, msgid, ShareMsgImpl.this.f238644g.getCurrentUrl(), articleId, false);
                                    } else {
                                        if ("2".equals(AnonymousClass3.this.f238671d)) {
                                            i17 = 1003;
                                        }
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80059DC", "0X80059DC", i17, 0, f16, msgid, str2, articleId, false);
                                    }
                                }
                                ShareMsgImpl shareMsgImpl2 = ShareMsgImpl.this;
                                shareMsgImpl2.f238653p.onSharMsgcallback(shareMsgImpl2.f238639b, String.valueOf(z16));
                            }
                        }
                        z16 = false;
                        ShareMsgImpl shareMsgImpl22 = ShareMsgImpl.this;
                        shareMsgImpl22.f238653p.onSharMsgcallback(shareMsgImpl22.f238639b, String.valueOf(z16));
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.jsp.ShareMsgImpl$3$c */
            /* loaded from: classes15.dex */
            class c implements ITroopMemberApiClientApi.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f238679d;

                c(Bitmap bitmap) {
                    this.f238679d = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) bitmap);
                    }
                }

                @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
                public void callback(Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                        return;
                    }
                    if (bundle.getInt("readinjoy_to_wx_config") == 0) {
                        IWxShareHelperFromReadInjoy iWxShareHelperFromReadInjoy = (IWxShareHelperFromReadInjoy) QRoute.api(IWxShareHelperFromReadInjoy.class);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        iWxShareHelperFromReadInjoy.shareWebPage(ShareMsgImpl.this.f238642e, anonymousClass3.f238676m, this.f238679d, anonymousClass3.C, anonymousClass3.f238672e, !"2".equals(anonymousClass3.f238671d) ? 1 : 0);
                    } else {
                        WXShareHelper b06 = WXShareHelper.b0();
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        b06.L0(ShareMsgImpl.this.f238642e, anonymousClass32.f238676m, this.f238679d, anonymousClass32.C, anonymousClass32.f238672e, !"2".equals(anonymousClass32.f238671d) ? 1 : 0);
                    }
                }
            }

            {
                this.f238671d = str;
                this.f238672e = str4;
                this.f238673f = i3;
                this.f238674h = hashMap;
                this.f238675i = str6;
                this.f238676m = str2;
                this.C = str3;
                this.D = str7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ShareMsgImpl.this, str, str4, Integer.valueOf(i3), hashMap, str6, str2, str3, str7);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = ShareMsgImpl.this.f238651n;
                if (activity2 != null && !activity2.isFinishing()) {
                    ShareMsgImpl shareMsgImpl = ShareMsgImpl.this;
                    if (shareMsgImpl.f238638a == null) {
                        shareMsgImpl.c(activity2);
                    }
                    QQProgressDialog qQProgressDialog2 = ShareMsgImpl.this.f238638a;
                    if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                        ShareMsgImpl.this.f238638a.dismiss();
                    }
                    ShareMsgImpl shareMsgImpl2 = ShareMsgImpl.this;
                    if (shareMsgImpl2.f238640c == null) {
                        shareMsgImpl2.f238640c = new a();
                        WXShareHelper.b0().A(ShareMsgImpl.this.f238640c);
                    }
                    if (this.f238673f == 1) {
                        ShareMsgImpl shareMsgImpl3 = ShareMsgImpl.this;
                        if (shareMsgImpl3.f238641d == null) {
                            shareMsgImpl3.f238641d = new b();
                            ((IWxShareHelperFromReadInjoy) QRoute.api(IWxShareHelperFromReadInjoy.class)).addObserver(ShareMsgImpl.this.f238641d);
                        }
                    }
                    if (!TextUtils.isEmpty(this.f238672e) && this.f238672e.contains("weather.mp.qq.com")) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    ShareMsgImpl.this.f238642e = String.valueOf(System.currentTimeMillis());
                    Bitmap bitmap = (Bitmap) this.f238674h.remove("image");
                    String str8 = (String) this.f238674h.remove("imageLocalPath");
                    if ("audio".equals(this.f238675i)) {
                        WXShareHelper.b0().A0(ShareMsgImpl.this.f238642e, this.f238676m, bitmap, this.C, this.f238672e, !"2".equals(this.f238671d) ? 1 : 0, this.D);
                        return;
                    }
                    if ("picture".equals(this.f238675i)) {
                        WXShareHelper.b0().v0(str8, bitmap, 200, !"2".equals(this.f238671d) ? 1 : 0, ShareMsgImpl.this.f238642e);
                        return;
                    }
                    if (this.f238673f == 1) {
                        ShareMsgImpl.this.f238648k.F(new c(bitmap));
                    } else if (z16) {
                        WXShareHelper.b0().C0(ShareMsgImpl.this.f238642e, this.f238676m, bitmap, this.C, this.f238672e, !"2".equals(this.f238671d) ? 1 : 0);
                    } else {
                        WXShareHelper.b0().L0(ShareMsgImpl.this.f238642e, this.f238676m, bitmap, this.C, this.f238672e, !"2".equals(this.f238671d) ? 1 : 0);
                    }
                }
            }
        };
        if (TextUtils.isEmpty(str5)) {
            runnable.run();
            return;
        }
        if (this.f238638a == null) {
            c(activity);
        }
        if (!this.f238638a.isShowing()) {
            this.f238638a.setMessage(R.string.c7z);
            this.f238638a.show();
        }
        ThreadManagerV2.post(new Runnable(str5, str6, hashMap, runnable, str, str4) { // from class: com.tencent.mobileqq.jsp.ShareMsgImpl.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f238681d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f238682e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Map f238683f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Runnable f238684h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f238685i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f238686m;

            {
                this.f238681d = str5;
                this.f238682e = str6;
                this.f238683f = hashMap;
                this.f238684h = runnable;
                this.f238685i = str;
                this.f238686m = str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ShareMsgImpl.this, str5, str6, hashMap, runnable, str, str4);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i17;
                Bitmap decodeByteArray;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i18 = 1;
                try {
                    byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.f238681d), "GET", null, null);
                    if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                        if ("picture".equals(this.f238682e)) {
                            ShareMsgImpl.this.b(this.f238681d, decodeByteArray, this.f238683f);
                        } else {
                            int width = decodeByteArray.getWidth();
                            int height = decodeByteArray.getHeight();
                            int i19 = width * height;
                            if (i19 > 8000) {
                                double sqrt = Math.sqrt(8000.0d / i19);
                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (width * sqrt), (int) (height * sqrt), true);
                                decodeByteArray.recycle();
                                decodeByteArray = createScaledBitmap;
                            }
                        }
                        this.f238683f.put("image", decodeByteArray);
                    }
                } catch (IOException | OutOfMemoryError unused) {
                }
                if (ShareMsgImpl.this.f238651n.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity")) {
                    ShareMsgImpl.this.f238651n.runOnUiThread(this.f238684h);
                } else {
                    ShareMsgImpl.this.f238652o.runOnUiThread(this.f238684h);
                }
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "96");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                if (this.f238683f.get("image") != null) {
                    i18 = 0;
                }
                sb5.append(i18);
                bundle.putString("intext_1", sb5.toString());
                bundle.putString("intext_4", "0");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                if ("2".equals(this.f238685i)) {
                    i17 = 3;
                } else {
                    i17 = 4;
                }
                sb6.append(com.tencent.open.agent.report.e.a(i17));
                bundle.putString("intext_3", sb6.toString());
                bundle.putString("stringext_1", this.f238686m);
                ReportCenter.f().l(bundle, "", ShareMsgImpl.this.f238652o.getAccount(), false);
            }
        }, 8, null, false);
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f238639b = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent(this.f238643f, (Class<?>) ForwardRecentActivity.class);
            intent.putExtra("isFromShare", true);
            String optString = jSONObject.optString("toUin");
            int optInt = jSONObject.optInt("uinType", 0);
            if (optString != null && optString.length() >= 5) {
                intent.setClass(this.f238643f, DirectForwardActivity.class);
                intent.putExtra("toUin", optString);
                intent.putExtra("uinType", optInt);
            }
            intent.putExtra("forward_type", -1);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, jSONObject.optString("text"));
            this.f238639b = jSONObject.optString("callback");
            if (jSONObject.has("report")) {
                intent.putExtra("report", jSONObject.getString("report"));
            }
            intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
            this.f238653p.startActivityForResult(intent, (byte) 1);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "shareText error: " + e16.getMessage());
            }
        }
    }
}
