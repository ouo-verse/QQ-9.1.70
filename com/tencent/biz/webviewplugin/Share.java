package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ark.Constants;
import com.tencent.av.utils.ba;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto$MsgIconsurl;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.Pair;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Share implements View.OnClickListener, com.tencent.mobileqq.webviewplugin.n, com.tencent.mobileqq.webviewplugin.i {
    static String E0 = "share";
    public static boolean F0 = false;
    boolean K;
    int L;
    Activity U;
    public CustomWebView W;
    QQProgressDialog X;

    /* renamed from: c0, reason: collision with root package name */
    protected AppRuntime f97444c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f97446d0;

    /* renamed from: e0, reason: collision with root package name */
    WXShareHelper.a f97448e0;

    /* renamed from: f0, reason: collision with root package name */
    String f97450f0;

    /* renamed from: g0, reason: collision with root package name */
    protected float f97451g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f97453h0;

    /* renamed from: i0, reason: collision with root package name */
    protected LinearLayout f97455i0;

    /* renamed from: j0, reason: collision with root package name */
    protected LinearLayout f97456j0;

    /* renamed from: k0, reason: collision with root package name */
    protected ImageView f97457k0;

    /* renamed from: l0, reason: collision with root package name */
    protected ImageView f97458l0;

    /* renamed from: m0, reason: collision with root package name */
    protected TextView f97460m0;

    /* renamed from: n0, reason: collision with root package name */
    protected TextView f97461n0;

    /* renamed from: o0, reason: collision with root package name */
    protected Context f97462o0;

    /* renamed from: x0, reason: collision with root package name */
    public com.tencent.mobileqq.teamwork.o f97471x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f97472y0;

    /* renamed from: z0, reason: collision with root package name */
    WeakReference<com.tencent.mobileqq.webview.swift.y> f97473z0;

    /* renamed from: d, reason: collision with root package name */
    protected String f97445d = null;

    /* renamed from: e, reason: collision with root package name */
    protected String f97447e = null;

    /* renamed from: f, reason: collision with root package name */
    protected String f97449f = null;

    /* renamed from: h, reason: collision with root package name */
    protected String f97452h = null;

    /* renamed from: i, reason: collision with root package name */
    protected String f97454i = null;

    /* renamed from: m, reason: collision with root package name */
    protected String f97459m = null;
    protected String C = null;
    protected String D = null;
    protected boolean E = true;
    protected int F = -1;
    protected boolean G = false;
    protected String H = null;
    protected boolean I = false;
    protected boolean J = false;
    com.tencent.open.agent.report.f M = new com.tencent.open.agent.report.f();
    protected String N = null;
    protected String P = null;
    protected String Q = null;
    protected int R = -1;
    protected int S = -1;
    protected SoftReference<Bitmap> T = null;
    Activity V = null;
    protected View Y = null;
    protected ImageView Z = null;

    /* renamed from: a0, reason: collision with root package name */
    protected long f97442a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    protected GetAppInfoProto$GetAppinfoResponse f97443b0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public String f97463p0 = null;

    /* renamed from: q0, reason: collision with root package name */
    public com.tencent.mobileqq.Doraemon.a f97464q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    public String f97465r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    public String f97466s0 = null;

    /* renamed from: t0, reason: collision with root package name */
    public String f97467t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public String f97468u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public String f97469v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    public String f97470w0 = null;
    private WeakReference<com.tencent.mobileqq.webviewplugin.q> A0 = null;
    volatile int B0 = 0;
    protected com.tencent.open.appcommon.d C0 = new com.tencent.open.appcommon.d() { // from class: com.tencent.biz.webviewplugin.Share.8
        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray;
            if (!z16 || (byteArray = bundle.getByteArray("data")) == null) {
                return;
            }
            final GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
            try {
                getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(Share.E0, 2, e16.getMessage());
                }
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.8.1
                @Override // java.lang.Runnable
                public void run() {
                    Share share = Share.this;
                    share.g(share.U.getApplicationContext(), getAppInfoProto$GetAppinfoResponse);
                }
            }, 5, null, true);
        }
    };
    protected Handler D0 = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.webviewplugin.Share$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f97474d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f97475e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f97476f;

        AnonymousClass1(String str, int i3, boolean z16) {
            this.f97474d = str;
            this.f97475e = i3;
            this.f97476f = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01eb  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x02ab  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x02dc  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x02e8  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x02fd  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0370 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x02b3  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0226  */
        /* JADX WARN: Type inference failed for: r0v52 */
        /* JADX WARN: Type inference failed for: r0v53 */
        /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r15v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r3v10, types: [int] */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Type inference failed for: r3v53 */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.StringBuilder] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            String str2;
            Exception exc;
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            long j3;
            String str3;
            ?? r36;
            int i26;
            String str4;
            if (QLog.isColorLevel()) {
                QLog.e("shareWebPage", 2, "QConnect rich START. title=" + Share.this.f97452h + ", desc=" + Share.this.C + ", thumb=" + Share.this.D + ", shareURL=" + this.f97474d);
            }
            boolean isEmpty = TextUtils.isEmpty(Share.this.D);
            boolean z16 = isEmpty;
            if (TextUtils.isEmpty(Share.this.C)) {
                z16 = (isEmpty ? 1 : 0) | 2;
            }
            boolean z17 = z16;
            if (TextUtils.isEmpty(Share.this.f97452h)) {
                z17 = (z16 ? 1 : 0) | 4;
            }
            ?? r152 = z17;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "53");
                bundle.putString("intext_3", "1");
                bundle.putString("intext_2", "" + r152);
                bundle.putString("stringext_1", this.f97474d);
                str = "stringext_1";
                try {
                    str2 = "intext_2";
                    try {
                        ReportCenter.f().l(bundle, "", Share.this.f97444c0.getAccount(), false);
                        String format = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", Share.this.f97444c0.getAccount(), URLEncoder.encode(this.f97474d));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        HttpResponse openRequest = HttpUtil.openRequest(Share.this.U, format, null, "GET", null, null, 5000, 5000);
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        if (openRequest == null || openRequest.getStatusLine().getStatusCode() != 200) {
                            str4 = "";
                        } else {
                            str4 = HttpUtil.readHttpResponse(openRequest);
                        }
                        JSONObject jSONObject = new JSONObject(str4);
                        int parseInt = Integer.parseInt(jSONObject.getString("ret"));
                        if (parseInt == 0) {
                            try {
                                Share.this.S = 0;
                                try {
                                    String string = jSONObject.getString("title");
                                    if (!TextUtils.isEmpty(string)) {
                                        try {
                                            if (TextUtils.isEmpty(Share.this.f97452h)) {
                                                Share.this.f97452h = string;
                                            }
                                            i16 = 4;
                                        } catch (Exception e16) {
                                            exc = e16;
                                            i17 = parseInt;
                                            i3 = 0;
                                            i16 = 4;
                                            exc.printStackTrace();
                                            i18 = i16;
                                            int i27 = i17;
                                            long j16 = currentTimeMillis;
                                            if (QLog.isColorLevel()) {
                                            }
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                            bundle2.putString("act_type", "13");
                                            bundle2.putString("intext_3", "1");
                                            bundle2.putString("intext_1", "" + i3);
                                            bundle2.putString("stringext_2", "" + i27);
                                            bundle2.putString("intext_5", "" + j3);
                                            String str5 = str2;
                                            bundle2.putString(str5, "" + r152);
                                            bundle2.putString("intext_4", "" + i19);
                                            if (i3 > 0) {
                                            }
                                            ReportCenter.f().l(bundle2, "", Share.this.f97444c0.getAccount(), false);
                                            Bundle bundle3 = new Bundle();
                                            boolean isEmpty2 = TextUtils.isEmpty(Share.this.D);
                                            boolean z18 = isEmpty2;
                                            if (TextUtils.isEmpty(Share.this.C)) {
                                            }
                                            r36 = z18;
                                            if (TextUtils.isEmpty(Share.this.f97452h)) {
                                            }
                                            bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                            bundle3.putString("act_type", "92");
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("");
                                            if (r36 == 0) {
                                            }
                                            sb5.append(i26);
                                            bundle3.putString("intext_1", sb5.toString());
                                            bundle3.putString("intext_4", "" + i27);
                                            bundle3.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                                            bundle3.putString(str5, "" + r36);
                                            bundle3.putString(str3, this.f97474d);
                                            ReportCenter.f().l(bundle3, "", Share.this.f97444c0.getAccount(), false);
                                            final b.f F = Share.this.F(this.f97474d, this.f97475e);
                                            if (TextUtils.isEmpty(Share.this.D)) {
                                            }
                                            Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                                        }
                                    } else {
                                        i16 = 0;
                                    }
                                    try {
                                        String string2 = jSONObject.getString("abstract");
                                        if (!TextUtils.isEmpty(string2)) {
                                            int i28 = i16 | 2;
                                            i17 = parseInt;
                                            try {
                                                if (TextUtils.isEmpty(Share.this.C)) {
                                                    Share.this.C = string2;
                                                }
                                                i16 = i28;
                                            } catch (Exception e17) {
                                                exc = e17;
                                                i16 = i28;
                                                i3 = 0;
                                                exc.printStackTrace();
                                                i18 = i16;
                                                int i272 = i17;
                                                long j162 = currentTimeMillis;
                                                if (QLog.isColorLevel()) {
                                                }
                                                Bundle bundle22 = new Bundle();
                                                bundle22.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                bundle22.putString("act_type", "13");
                                                bundle22.putString("intext_3", "1");
                                                bundle22.putString("intext_1", "" + i3);
                                                bundle22.putString("stringext_2", "" + i272);
                                                bundle22.putString("intext_5", "" + j3);
                                                String str52 = str2;
                                                bundle22.putString(str52, "" + r152);
                                                bundle22.putString("intext_4", "" + i19);
                                                if (i3 > 0) {
                                                }
                                                ReportCenter.f().l(bundle22, "", Share.this.f97444c0.getAccount(), false);
                                                Bundle bundle32 = new Bundle();
                                                boolean isEmpty22 = TextUtils.isEmpty(Share.this.D);
                                                boolean z182 = isEmpty22;
                                                if (TextUtils.isEmpty(Share.this.C)) {
                                                }
                                                r36 = z182;
                                                if (TextUtils.isEmpty(Share.this.f97452h)) {
                                                }
                                                bundle32.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                bundle32.putString("act_type", "92");
                                                StringBuilder sb52 = new StringBuilder();
                                                sb52.append("");
                                                if (r36 == 0) {
                                                }
                                                sb52.append(i26);
                                                bundle32.putString("intext_1", sb52.toString());
                                                bundle32.putString("intext_4", "" + i272);
                                                bundle32.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                                                bundle32.putString(str52, "" + r36);
                                                bundle32.putString(str3, this.f97474d);
                                                ReportCenter.f().l(bundle32, "", Share.this.f97444c0.getAccount(), false);
                                                final b.f F2 = Share.this.F(this.f97474d, this.f97475e);
                                                if (TextUtils.isEmpty(Share.this.D)) {
                                                }
                                                Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                                            }
                                        } else {
                                            i17 = parseInt;
                                        }
                                        try {
                                            String string3 = jSONObject.getString("thumbUrl");
                                            if (!TextUtils.isEmpty(string3)) {
                                                i18 = i16 | 1;
                                                try {
                                                    if (TextUtils.isEmpty(Share.this.D)) {
                                                        Share share = Share.this;
                                                        share.D = string3;
                                                        share.K = false;
                                                        share.L = 0;
                                                    }
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    i16 = i18;
                                                    exc = e;
                                                    i3 = 0;
                                                    exc.printStackTrace();
                                                    i18 = i16;
                                                    int i2722 = i17;
                                                    long j1622 = currentTimeMillis;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    Bundle bundle222 = new Bundle();
                                                    bundle222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                    bundle222.putString("act_type", "13");
                                                    bundle222.putString("intext_3", "1");
                                                    bundle222.putString("intext_1", "" + i3);
                                                    bundle222.putString("stringext_2", "" + i2722);
                                                    bundle222.putString("intext_5", "" + j3);
                                                    String str522 = str2;
                                                    bundle222.putString(str522, "" + r152);
                                                    bundle222.putString("intext_4", "" + i19);
                                                    if (i3 > 0) {
                                                    }
                                                    ReportCenter.f().l(bundle222, "", Share.this.f97444c0.getAccount(), false);
                                                    Bundle bundle322 = new Bundle();
                                                    boolean isEmpty222 = TextUtils.isEmpty(Share.this.D);
                                                    boolean z1822 = isEmpty222;
                                                    if (TextUtils.isEmpty(Share.this.C)) {
                                                    }
                                                    r36 = z1822;
                                                    if (TextUtils.isEmpty(Share.this.f97452h)) {
                                                    }
                                                    bundle322.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                    bundle322.putString("act_type", "92");
                                                    StringBuilder sb522 = new StringBuilder();
                                                    sb522.append("");
                                                    if (r36 == 0) {
                                                    }
                                                    sb522.append(i26);
                                                    bundle322.putString("intext_1", sb522.toString());
                                                    bundle322.putString("intext_4", "" + i2722);
                                                    bundle322.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                                                    bundle322.putString(str522, "" + r36);
                                                    bundle322.putString(str3, this.f97474d);
                                                    ReportCenter.f().l(bundle322, "", Share.this.f97444c0.getAccount(), false);
                                                    final b.f F22 = Share.this.F(this.f97474d, this.f97475e);
                                                    if (TextUtils.isEmpty(Share.this.D)) {
                                                    }
                                                    Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                                                }
                                            } else {
                                                i18 = i16;
                                            }
                                            i3 = 0;
                                        } catch (Exception e19) {
                                            e = e19;
                                        }
                                    } catch (Exception e26) {
                                        e = e26;
                                        i17 = parseInt;
                                    }
                                } catch (Exception e27) {
                                    i17 = parseInt;
                                    exc = e27;
                                    i3 = 0;
                                    i16 = 0;
                                    exc.printStackTrace();
                                    i18 = i16;
                                    int i27222 = i17;
                                    long j16222 = currentTimeMillis;
                                    if (QLog.isColorLevel()) {
                                    }
                                    Bundle bundle2222 = new Bundle();
                                    bundle2222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    bundle2222.putString("act_type", "13");
                                    bundle2222.putString("intext_3", "1");
                                    bundle2222.putString("intext_1", "" + i3);
                                    bundle2222.putString("stringext_2", "" + i27222);
                                    bundle2222.putString("intext_5", "" + j3);
                                    String str5222 = str2;
                                    bundle2222.putString(str5222, "" + r152);
                                    bundle2222.putString("intext_4", "" + i19);
                                    if (i3 > 0) {
                                    }
                                    ReportCenter.f().l(bundle2222, "", Share.this.f97444c0.getAccount(), false);
                                    Bundle bundle3222 = new Bundle();
                                    boolean isEmpty2222 = TextUtils.isEmpty(Share.this.D);
                                    boolean z18222 = isEmpty2222;
                                    if (TextUtils.isEmpty(Share.this.C)) {
                                    }
                                    r36 = z18222;
                                    if (TextUtils.isEmpty(Share.this.f97452h)) {
                                    }
                                    bundle3222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    bundle3222.putString("act_type", "92");
                                    StringBuilder sb5222 = new StringBuilder();
                                    sb5222.append("");
                                    if (r36 == 0) {
                                    }
                                    sb5222.append(i26);
                                    bundle3222.putString("intext_1", sb5222.toString());
                                    bundle3222.putString("intext_4", "" + i27222);
                                    bundle3222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                                    bundle3222.putString(str5222, "" + r36);
                                    bundle3222.putString(str3, this.f97474d);
                                    ReportCenter.f().l(bundle3222, "", Share.this.f97444c0.getAccount(), false);
                                    final b.f F222 = Share.this.F(this.f97474d, this.f97475e);
                                    if (TextUtils.isEmpty(Share.this.D)) {
                                    }
                                    Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                                }
                            } catch (Exception e28) {
                                i17 = parseInt;
                                exc = e28;
                                i3 = 1;
                            }
                        } else {
                            i17 = parseInt;
                            i3 = 1;
                            i18 = 0;
                        }
                    } catch (Exception e29) {
                        e = e29;
                        exc = e;
                        i3 = 1;
                        i16 = 0;
                        i17 = 0;
                        exc.printStackTrace();
                        i18 = i16;
                        int i272222 = i17;
                        long j162222 = currentTimeMillis;
                        if (QLog.isColorLevel()) {
                        }
                        Bundle bundle22222 = new Bundle();
                        bundle22222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                        bundle22222.putString("act_type", "13");
                        bundle22222.putString("intext_3", "1");
                        bundle22222.putString("intext_1", "" + i3);
                        bundle22222.putString("stringext_2", "" + i272222);
                        bundle22222.putString("intext_5", "" + j3);
                        String str52222 = str2;
                        bundle22222.putString(str52222, "" + r152);
                        bundle22222.putString("intext_4", "" + i19);
                        if (i3 > 0) {
                        }
                        ReportCenter.f().l(bundle22222, "", Share.this.f97444c0.getAccount(), false);
                        Bundle bundle32222 = new Bundle();
                        boolean isEmpty22222 = TextUtils.isEmpty(Share.this.D);
                        boolean z182222 = isEmpty22222;
                        if (TextUtils.isEmpty(Share.this.C)) {
                        }
                        r36 = z182222;
                        if (TextUtils.isEmpty(Share.this.f97452h)) {
                        }
                        bundle32222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                        bundle32222.putString("act_type", "92");
                        StringBuilder sb52222 = new StringBuilder();
                        sb52222.append("");
                        if (r36 == 0) {
                        }
                        sb52222.append(i26);
                        bundle32222.putString("intext_1", sb52222.toString());
                        bundle32222.putString("intext_4", "" + i272222);
                        bundle32222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                        bundle32222.putString(str52222, "" + r36);
                        bundle32222.putString(str3, this.f97474d);
                        ReportCenter.f().l(bundle32222, "", Share.this.f97444c0.getAccount(), false);
                        final b.f F2222 = Share.this.F(this.f97474d, this.f97475e);
                        if (TextUtils.isEmpty(Share.this.D)) {
                        }
                        Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                    }
                } catch (Exception e36) {
                    e = e36;
                    str2 = "intext_2";
                    exc = e;
                    i3 = 1;
                    i16 = 0;
                    i17 = 0;
                    exc.printStackTrace();
                    i18 = i16;
                    int i2722222 = i17;
                    long j1622222 = currentTimeMillis;
                    if (QLog.isColorLevel()) {
                    }
                    Bundle bundle222222 = new Bundle();
                    bundle222222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                    bundle222222.putString("act_type", "13");
                    bundle222222.putString("intext_3", "1");
                    bundle222222.putString("intext_1", "" + i3);
                    bundle222222.putString("stringext_2", "" + i2722222);
                    bundle222222.putString("intext_5", "" + j3);
                    String str522222 = str2;
                    bundle222222.putString(str522222, "" + r152);
                    bundle222222.putString("intext_4", "" + i19);
                    if (i3 > 0) {
                    }
                    ReportCenter.f().l(bundle222222, "", Share.this.f97444c0.getAccount(), false);
                    Bundle bundle322222 = new Bundle();
                    boolean isEmpty222222 = TextUtils.isEmpty(Share.this.D);
                    boolean z1822222 = isEmpty222222;
                    if (TextUtils.isEmpty(Share.this.C)) {
                    }
                    r36 = z1822222;
                    if (TextUtils.isEmpty(Share.this.f97452h)) {
                    }
                    bundle322222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                    bundle322222.putString("act_type", "92");
                    StringBuilder sb522222 = new StringBuilder();
                    sb522222.append("");
                    if (r36 == 0) {
                    }
                    sb522222.append(i26);
                    bundle322222.putString("intext_1", sb522222.toString());
                    bundle322222.putString("intext_4", "" + i2722222);
                    bundle322222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
                    bundle322222.putString(str522222, "" + r36);
                    bundle322222.putString(str3, this.f97474d);
                    ReportCenter.f().l(bundle322222, "", Share.this.f97444c0.getAccount(), false);
                    final b.f F22222 = Share.this.F(this.f97474d, this.f97475e);
                    if (TextUtils.isEmpty(Share.this.D)) {
                    }
                    Share.this.i(this.f97474d, this.f97475e, this.f97476f);
                }
            } catch (Exception e37) {
                e = e37;
                str = "stringext_1";
            }
            int i27222222 = i17;
            long j16222222 = currentTimeMillis;
            if (QLog.isColorLevel()) {
                i19 = i18;
                StringBuilder sb6 = new StringBuilder();
                j3 = j16222222;
                sb6.append("QConnect rich END. title=");
                sb6.append(Share.this.f97452h);
                sb6.append(", desc=");
                sb6.append(Share.this.C);
                sb6.append(", thumb=");
                sb6.append(Share.this.D);
                sb6.append(", shareURL=");
                sb6.append(this.f97474d);
                QLog.e("shareWebPage", 2, sb6.toString());
            } else {
                i19 = i18;
                j3 = j16222222;
            }
            Bundle bundle2222222 = new Bundle();
            bundle2222222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle2222222.putString("act_type", "13");
            bundle2222222.putString("intext_3", "1");
            bundle2222222.putString("intext_1", "" + i3);
            bundle2222222.putString("stringext_2", "" + i27222222);
            bundle2222222.putString("intext_5", "" + j3);
            String str5222222 = str2;
            bundle2222222.putString(str5222222, "" + r152);
            bundle2222222.putString("intext_4", "" + i19);
            if (i3 > 0) {
                str3 = str;
                bundle2222222.putString(str3, this.f97474d);
            } else {
                str3 = str;
            }
            ReportCenter.f().l(bundle2222222, "", Share.this.f97444c0.getAccount(), false);
            Bundle bundle3222222 = new Bundle();
            boolean isEmpty2222222 = TextUtils.isEmpty(Share.this.D);
            boolean z18222222 = isEmpty2222222;
            if (TextUtils.isEmpty(Share.this.C)) {
                z18222222 = (isEmpty2222222 ? 1 : 0) | 2;
            }
            r36 = z18222222;
            if (TextUtils.isEmpty(Share.this.f97452h)) {
                r36 = (z18222222 ? 1 : 0) | 4;
            }
            bundle3222222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle3222222.putString("act_type", "92");
            StringBuilder sb5222222 = new StringBuilder();
            sb5222222.append("");
            if (r36 == 0) {
                i26 = 0;
            } else {
                i26 = 1;
            }
            sb5222222.append(i26);
            bundle3222222.putString("intext_1", sb5222222.toString());
            bundle3222222.putString("intext_4", "" + i27222222);
            bundle3222222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(this.f97475e));
            bundle3222222.putString(str5222222, "" + r36);
            bundle3222222.putString(str3, this.f97474d);
            ReportCenter.f().l(bundle3222222, "", Share.this.f97444c0.getAccount(), false);
            final b.f F222222 = Share.this.F(this.f97474d, this.f97475e);
            if (TextUtils.isEmpty(Share.this.D) || F222222 == null) {
                Share.this.i(this.f97474d, this.f97475e, this.f97476f);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.1.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.biz.webviewplugin.Share$1$1$a */
                    /* loaded from: classes5.dex */
                    class a implements SwiftBrowserMiscHandler.b {
                        a() {
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x03f0  */
                        /* JADX WARN: Removed duplicated region for block: B:15:0x0409  */
                        /* JADX WARN: Removed duplicated region for block: B:18:0x0467  */
                        /* JADX WARN: Removed duplicated region for block: B:22:0x040b  */
                        /* JADX WARN: Removed duplicated region for block: B:47:0x0363  */
                        /* JADX WARN: Removed duplicated region for block: B:48:0x03b5  */
                        /* JADX WARN: Removed duplicated region for block: B:65:0x034c  */
                        /* JADX WARN: Removed duplicated region for block: B:9:0x03e0  */
                        /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.StringBuilder] */
                        /* JADX WARN: Type inference failed for: r4v18, types: [int] */
                        /* JADX WARN: Type inference failed for: r4v26 */
                        /* JADX WARN: Type inference failed for: r4v31 */
                        /* JADX WARN: Type inference failed for: r4v32 */
                        @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.b
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void a(String str) {
                            long j3;
                            String str2;
                            String str3;
                            Pair<Integer, String> pair;
                            int intValue;
                            String str4;
                            String str5;
                            String str6;
                            int i3;
                            int i16;
                            String str7;
                            String str8;
                            String str9;
                            int i17;
                            String str10;
                            ?? r46;
                            int i18;
                            if (QLog.isColorLevel()) {
                                QLog.e("shareWebPage", 2, "WebView screenshot CALLBACK. imgUrl=" + str);
                            }
                            if (TextUtils.isEmpty(str)) {
                                str10 = "shareWebPage";
                                str5 = "stringext_1";
                                str8 = "act_type";
                                str7 = "102";
                                i17 = 1;
                                str9 = "intext_1";
                                str4 = "intext_3";
                            } else {
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inSampleSize = 1;
                                    Share.this.T = new SoftReference<>(BitmapFactory.decodeFile(str, options));
                                } catch (OutOfMemoryError unused) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("shareWebPage", 2, "WebView screenshot OutOfMemoryError.");
                                    }
                                }
                                String account = Share.this.f97444c0.getAccount();
                                long currentTimeMillis = System.currentTimeMillis();
                                File file = new File(str);
                                if (file.exists()) {
                                    j3 = file.length();
                                } else {
                                    j3 = 0;
                                }
                                String calcMd5 = FileUtils.calcMd5(str);
                                if (j3 <= 0 || TextUtils.isEmpty(calcMd5)) {
                                    str2 = "stringext_1";
                                    str3 = "intext_3";
                                    pair = null;
                                } else {
                                    str2 = "stringext_1";
                                    str3 = "intext_3";
                                    pair = HttpUtil.queryImageByIP(com.tencent.biz.common.util.g.c(String.format(Locale.getDefault(), HttpUtil.LOCAL_IMAGE_QUERY_URL, calcMd5, Long.valueOf(j3)), 1007), account);
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (pair == null) {
                                    pair = new Pair<>(-1, "");
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(Share.E0, 2, "queryImage, ret=" + pair.first + ",cost=" + currentTimeMillis2 + JefsClass.INDEX_URL + pair.second);
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                bundle.putString("act_type", "16");
                                bundle.putString("intext_1", "" + pair.first);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("");
                                if (pair.first.intValue() == -1) {
                                    intValue = 0;
                                } else {
                                    intValue = pair.first.intValue();
                                }
                                sb5.append(intValue);
                                bundle.putString("intext_2", sb5.toString());
                                bundle.putString("intext_5", "" + currentTimeMillis2);
                                ReportCenter.f().l(bundle, "", account, false);
                                if (!TextUtils.isEmpty(pair.second)) {
                                    Share share = Share.this;
                                    share.D = pair.second;
                                    share.K = false;
                                    share.L = 0;
                                    str8 = "act_type";
                                    str7 = "102";
                                    str5 = str2;
                                    str4 = str3;
                                    str9 = "intext_1";
                                    i17 = 1;
                                    str6 = "shareWebPage";
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("shareWebPage", 2, "WebView screenshot UPLOAD. length=" + new File(str).length());
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("Connection", "keep-alive");
                                    hashMap.put("Referer", "https://www.qq.com");
                                    hashMap.put("Host", HttpUtil.LOCAL_IMAGE_UPLOAD_HOST);
                                    String s16 = Share.this.s(account, "connect.qq.com");
                                    if (QLog.isColorLevel()) {
                                        QLog.i("shareWebPage", 1, "getPsKeySync success:" + TextUtils.isEmpty(s16));
                                    }
                                    if (!TextUtils.isEmpty(s16)) {
                                        hashMap.put("Cookie", "p_uin=" + account + ";p_skey=" + s16);
                                    }
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("share_image", str);
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    bundle2.putString("act_type", "51");
                                    str4 = str3;
                                    bundle2.putString(str4, "1");
                                    str5 = str2;
                                    bundle2.putString(str5, AnonymousClass1.this.f97474d);
                                    str6 = "shareWebPage";
                                    ReportCenter.f().l(bundle2, "", account, false);
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    String uploadImageWithHttps = HttpUtil.uploadImageWithHttps(com.tencent.biz.common.util.g.c(HttpUtil.LOCAL_IMAGE_UPLOAD_URL, 1007), HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, account, null, hashMap2, hashMap, false);
                                    if (uploadImageWithHttps == null) {
                                        uploadImageWithHttps = HttpUtil.uploadImageWithHttps(HttpUtil.LOCAL_IMAGE_UPLOAD_URL, HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, account, null, hashMap2, hashMap, true);
                                    }
                                    if (uploadImageWithHttps != null) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(uploadImageWithHttps);
                                            i3 = jSONObject.getInt("retcode");
                                            if (i3 == 0) {
                                                try {
                                                    if (jSONObject.has("result")) {
                                                        String string = jSONObject.getJSONObject("result").getString("url");
                                                        if (!TextUtils.isEmpty(string)) {
                                                            Share share2 = Share.this;
                                                            share2.D = string;
                                                            share2.K = false;
                                                            share2.L = 0;
                                                            i16 = 0;
                                                        }
                                                    }
                                                } catch (JSONException e16) {
                                                    e = e16;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d(Share.E0, 2, e.getMessage());
                                                    }
                                                    i16 = 1;
                                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                    Bundle bundle3 = new Bundle();
                                                    bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                    str7 = "102";
                                                    bundle3.putString("act_type", "11");
                                                    str8 = "act_type";
                                                    str9 = "intext_1";
                                                    bundle3.putString(str9, "" + i16);
                                                    bundle3.putString("intext_2", "" + i3);
                                                    bundle3.putString(str4, "1");
                                                    bundle3.putString("intext_5", "" + currentTimeMillis4);
                                                    i17 = 1;
                                                    if (i16 == 1) {
                                                    }
                                                    ReportCenter.f().l(bundle3, "", account, false);
                                                    if (!QLog.isColorLevel()) {
                                                    }
                                                    Bundle bundle4 = new Bundle();
                                                    boolean isEmpty = TextUtils.isEmpty(Share.this.D);
                                                    boolean z16 = isEmpty;
                                                    if (TextUtils.isEmpty(Share.this.C)) {
                                                    }
                                                    r46 = z16;
                                                    if (TextUtils.isEmpty(Share.this.f97452h)) {
                                                    }
                                                    bundle4.putString(TVKDataBinder.KEY_REPORT_TYPE, str7);
                                                    bundle4.putString(str8, "93");
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append("");
                                                    if (r46 != 0) {
                                                    }
                                                    sb6.append(i18);
                                                    bundle4.putString(str9, sb6.toString());
                                                    bundle4.putString(str4, "" + com.tencent.open.agent.report.e.a(AnonymousClass1.this.f97475e));
                                                    bundle4.putString("intext_2", "" + r46);
                                                    bundle4.putString(str5, AnonymousClass1.this.f97474d);
                                                    ReportCenter.f().l(bundle4, "", Share.this.f97444c0.getAccount(), false);
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                    Share.this.i(anonymousClass1.f97474d, anonymousClass1.f97475e, anonymousClass1.f97476f);
                                                }
                                            }
                                        } catch (JSONException e17) {
                                            e = e17;
                                            i3 = 0;
                                        }
                                        i16 = 1;
                                    } else {
                                        i16 = 1;
                                        i3 = 0;
                                    }
                                    long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis3;
                                    Bundle bundle32 = new Bundle();
                                    bundle32.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    str7 = "102";
                                    bundle32.putString("act_type", "11");
                                    str8 = "act_type";
                                    str9 = "intext_1";
                                    bundle32.putString(str9, "" + i16);
                                    bundle32.putString("intext_2", "" + i3);
                                    bundle32.putString(str4, "1");
                                    bundle32.putString("intext_5", "" + currentTimeMillis42);
                                    i17 = 1;
                                    if (i16 == 1) {
                                        bundle32.putString(str5, AnonymousClass1.this.f97474d);
                                    }
                                    ReportCenter.f().l(bundle32, "", account, false);
                                }
                                if (!QLog.isColorLevel()) {
                                    str10 = str6;
                                    QLog.e(str10, 2, "Share info after WebView screenshot: title=" + Share.this.f97452h + ", summary=" + Share.this.C + ", thumb=" + Share.this.D + ", shareURL=" + AnonymousClass1.this.f97474d);
                                } else {
                                    str10 = str6;
                                }
                            }
                            Bundle bundle42 = new Bundle();
                            boolean isEmpty2 = TextUtils.isEmpty(Share.this.D);
                            boolean z162 = isEmpty2;
                            if (TextUtils.isEmpty(Share.this.C)) {
                                z162 = (isEmpty2 ? 1 : 0) | 2;
                            }
                            r46 = z162;
                            if (TextUtils.isEmpty(Share.this.f97452h)) {
                                r46 = (z162 ? 1 : 0) | 4;
                            }
                            bundle42.putString(TVKDataBinder.KEY_REPORT_TYPE, str7);
                            bundle42.putString(str8, "93");
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("");
                            if (r46 != 0) {
                                i18 = 0;
                            } else {
                                i18 = i17;
                            }
                            sb62.append(i18);
                            bundle42.putString(str9, sb62.toString());
                            bundle42.putString(str4, "" + com.tencent.open.agent.report.e.a(AnonymousClass1.this.f97475e));
                            bundle42.putString("intext_2", "" + r46);
                            bundle42.putString(str5, AnonymousClass1.this.f97474d);
                            ReportCenter.f().l(bundle42, "", Share.this.f97444c0.getAccount(), false);
                            if (QLog.isColorLevel()) {
                                QLog.e(str10, 2, "WebView screenshot END. thumb=" + Share.this.D);
                            }
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            Share.this.i(anonymousClass12.f97474d, anonymousClass12.f97475e, anonymousClass12.f97476f);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.e("shareWebPage", 2, "WebView screenshot START. shareUrl=" + AnonymousClass1.this.f97474d);
                        }
                        ((SwiftBrowserMiscHandler) F222222.getComponentProvider().a(32)).g(270, 270, new a());
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        boolean f97499a;

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WebViewFragment currentWebViewFragment;
            GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse;
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1001) {
                if (i3 == 1002 && (message.obj instanceof Bitmap) && !this.f97499a && (getAppInfoProto$GetAppinfoResponse = Share.this.f97443b0) != null && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null && !TextUtils.isEmpty(getAppInfoProto$AndroidInfo.packName.get())) {
                    Share share = Share.this;
                    GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo2 = share.f97443b0.androidInfo;
                    if (PackageUtil.isAppInstalled(share.f97462o0, getAppInfoProto$AndroidInfo2.packName.get())) {
                        Share share2 = Share.this;
                        share2.f97461n0.setText(share2.f97462o0.getResources().getString(R.string.f170381p9));
                    } else {
                        Share share3 = Share.this;
                        share3.f97461n0.setText(share3.f97462o0.getResources().getString(R.string.f170380p8));
                    }
                    Share share4 = Share.this;
                    share4.f97460m0.setText(String.format(share4.f97462o0.getResources().getString(R.string.p_), getAppInfoProto$AndroidInfo2.messagetail.get()));
                    Bitmap bitmap = (Bitmap) message.obj;
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    Bitmap f16 = com.tencent.biz.common.util.e.f(bitmap, (int) (Share.this.f97451g0 * 30.0f));
                    Share.this.f97455i0.setVisibility(0);
                    Share.this.f97458l0.setImageBitmap(f16);
                    com.tencent.open.business.viareport.c a16 = com.tencent.open.business.viareport.c.a();
                    Share share5 = Share.this;
                    a16.e(share5.f97446d0, String.valueOf(com.tencent.mobileqq.utils.h.f(share5.f97442a0)), "ANDROIDQQ.SHAREBAR", "100", false);
                    if (QLog.isColorLevel()) {
                        QLog.d(Share.E0, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
                        return;
                    }
                    return;
                }
                return;
            }
            Object obj = message.obj;
            if ((obj instanceof Bitmap) && !this.f97499a) {
                Bitmap bitmap2 = (Bitmap) obj;
                if (bitmap2.isRecycled()) {
                    return;
                }
                Bitmap f17 = com.tencent.biz.common.util.e.f(bitmap2, (int) (Share.this.f97451g0 * 34.0f));
                WeakReference<com.tencent.mobileqq.webview.swift.y> weakReference = Share.this.f97473z0;
                if (weakReference != null) {
                    weakReference.get();
                    Share.this.Y.setVisibility(0);
                    Share.this.Z.setImageBitmap(f17);
                    ComponentCallbacks2 componentCallbacks2 = Share.this.U;
                    if ((componentCallbacks2 instanceof com.tencent.mobileqq.webview.swift.u) && (currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks2).getCurrentWebViewFragment()) != null && currentWebViewFragment.getUIStyleHandler().Q != null) {
                        currentWebViewFragment.getUIStyleHandler().Q.findViewById(R.id.f165141c34).setVisibility(8);
                        currentWebViewFragment.getUIStyleHandler().Q.findViewById(R.id.f165142c35).setVisibility(0);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(Share.E0, 2, "QQBrowserActivity VISIBLE -----------------------");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f97501a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f97502b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f97503c;

        b(String[] strArr, String str, Object obj) {
            this.f97501a = strArr;
            this.f97502b = str;
            this.f97503c = obj;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("shareWebPage", 1, "getPsKey onFail, errMsg=" + str);
            synchronized (this.f97503c) {
                this.f97503c.notifyAll();
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            this.f97501a[0] = map.get(this.f97502b);
            synchronized (this.f97503c) {
                this.f97503c.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements WXShareHelper.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str = Share.this.f97450f0;
            if (str != null && str.equals(baseResp.transaction)) {
                BaseApplication.getContext();
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                        return;
                    }
                    com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                    ComponentCallbacks2 componentCallbacks2 = Share.this.U;
                    if (componentCallbacks2 instanceof com.tencent.mobileqq.webview.swift.u) {
                        WebViewFragment currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks2).getCurrentWebViewFragment();
                        int i16 = Share.this.B0;
                        if (currentWebViewFragment != null) {
                            String str2 = ((SwiftBrowserShareMenuHandler) currentWebViewFragment.getComponentProvider().a(4)).L;
                            if (str2 != null && !"".equals(str2)) {
                                Share.this.f97446d0 = str2;
                            } else {
                                int i17 = Share.this.B0;
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public PBStringField f97506a;

        /* renamed from: b, reason: collision with root package name */
        public PBStringField f97507b;

        public d(PBStringField pBStringField, PBStringField pBStringField2) {
            this.f97506a = pBStringField;
            this.f97507b = pBStringField2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Share(AppRuntime appRuntime, Activity activity) {
        List<Fragment> fragments;
        this.f97473z0 = null;
        if (QLog.isColorLevel()) {
            QLog.d(E0, 2, "Share secret init share");
        }
        this.f97444c0 = appRuntime;
        this.f97446d0 = appRuntime.getAccount();
        this.U = activity;
        this.f97451g0 = activity.getResources().getDisplayMetrics().density;
        if (activity instanceof com.tencent.mobileqq.webview.swift.y) {
            this.f97473z0 = new WeakReference<>((com.tencent.mobileqq.webview.swift.y) activity);
        } else if (activity instanceof com.tencent.mobileqq.webview.swift.u) {
            WebViewFragment currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) activity).getCurrentWebViewFragment();
            if (currentWebViewFragment != null) {
                this.f97473z0 = new WeakReference<>(currentWebViewFragment);
            } else if (activity instanceof QQBrowserActivity) {
                QLog.w(E0, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
                QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) activity;
                FragmentManager supportFragmentManager = qQBrowserActivity.getSupportFragmentManager();
                if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                    int i3 = qQBrowserActivity.currentTabIndex;
                    i3 = (i3 < 0 || i3 >= fragments.size()) ? 0 : i3;
                    QLog.w(E0, 2, "cast Fragment (index: " + i3 + ") to WebViewFragment");
                    if (fragments.get(i3) instanceof WebViewFragment) {
                        this.f97473z0 = new WeakReference<>((WebViewFragment) fragments.get(i3));
                    } else {
                        QLog.e(E0, 2, "cast Fragment (index: " + i3 + ") is null!");
                    }
                }
            }
        }
        WeakReference<com.tencent.mobileqq.webview.swift.y> weakReference = this.f97473z0;
        if (weakReference == null) {
            QLog.e(E0, 2, "Error! mWebUiUtils still null! " + activity.toString());
            return;
        }
        com.tencent.mobileqq.webview.swift.y yVar = weakReference.get();
        if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r)) {
            CustomWebView webView = ((com.tencent.mobileqq.webviewplugin.r) yVar).getWebView();
            this.W = webView;
            if (webView == null) {
                QLog.e(E0, 1, " Share webview is null", new Throwable());
            }
        } else if (QLog.isColorLevel()) {
            String str = E0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" Share baseInterface is null?");
            sb5.append(yVar == null);
            QLog.d(str, 2, sb5.toString());
        }
        this.f97462o0 = activity.getApplicationContext();
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.f F(String str, int i3) {
        if (i3 == 9) {
            return null;
        }
        ComponentCallbacks2 componentCallbacks2 = this.U;
        if (componentCallbacks2 instanceof b.f) {
            return (b.f) componentCallbacks2;
        }
        if (!(componentCallbacks2 instanceof com.tencent.mobileqq.webview.swift.u)) {
            return null;
        }
        return ((com.tencent.mobileqq.webview.swift.u) componentCallbacks2).getCurrentWebViewFragment();
    }

    private boolean G(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("app") && str.contains("view")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        QQProgressDialog qQProgressDialog = this.X;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.X.dismiss();
        }
    }

    private static boolean L(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                if (parse.isHierarchical()) {
                    str2 = parse.getQueryParameter("_pflag");
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host) || "url.cn".equalsIgnoreCase(host)) {
                        if (((Integer.parseInt(str2) >> 4) & 1) == 1) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    private boolean M(String str) {
        try {
            return true ^ "1".equals(Uri.parse(str).getQueryParameter("not_short"));
        } catch (Throwable th5) {
            QLog.d(E0, 1, th5, new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0466  */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.app.Activity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Y(int i3, final String str, String str2, final String str3, final String str4, Bitmap bitmap) {
        String str5;
        boolean z16;
        String str6;
        String str7;
        Bundle bundle;
        String str8;
        String str9;
        String str10;
        int i16;
        boolean z17;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        long j3;
        int i17;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        WebViewFragment currentWebViewFragment;
        String str25;
        boolean z18;
        String string;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        Bundle bundle2;
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler;
        int i18;
        int i19;
        String str36;
        WebViewFragment currentWebViewFragment2;
        int i26;
        boolean z19;
        String str37 = str;
        if (QLog.isColorLevel()) {
            QLog.d(E0, 2, "onGetSummary. forWhat = " + i3 + ", title=" + this.f97452h + ", desc=" + this.C + ", thumb=" + this.D + ", bitmap=" + bitmap);
        }
        if (this.V == null) {
            this.V = this.U;
        }
        final String str38 = "";
        if (i3 == 2 || i3 == 1 || i3 == 3 || i3 == 4) {
            Bundle bundle3 = new Bundle();
            boolean isEmpty = TextUtils.isEmpty(str4);
            if (TextUtils.isEmpty(str2)) {
                str5 = this.f97447e;
                z16 = isEmpty;
                if (TextUtils.isEmpty(str5)) {
                    z16 = (isEmpty ? 1 : 0) | 2;
                }
            } else {
                str5 = str2;
                z16 = isEmpty;
            }
            boolean z26 = z16;
            if (TextUtils.isEmpty(str)) {
                z26 = (z16 ? 1 : 0) | 4;
            }
            ?? r36 = z26;
            bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            str2 = str5;
            bundle3.putString("act_type", "94");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            str6 = "act_type";
            sb5.append(r36 == 0 ? 0 : 1);
            bundle3.putString("intext_1", sb5.toString());
            bundle3.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
            bundle3.putString("intext_2", "" + r36);
            bundle3.putString("stringext_1", str3);
            ReportCenter.f().l(bundle3, "", this.f97444c0.getAccount(), false);
        } else {
            str6 = "act_type";
        }
        final String str39 = str2;
        if (i3 == 2) {
            Bundle bundle4 = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str37 = str3;
            }
            bundle4.putString("title", str37);
            if (TextUtils.isEmpty(str39)) {
                str39 = str3;
            }
            bundle4.putString("desc", str39);
            bundle4.putString("detail_url", str3);
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str4);
            bundle4.putStringArrayList("image_url", arrayList);
            bundle4.putLong("req_share_id", 0L);
            int i27 = this.S;
            if (i27 != -1) {
                bundle4.putInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, i27);
            }
            bundle4.putLong(AppConstants.Key.SHARE_BEGIN_TIME, SwiftBrowserShareMenuHandler.f314290n0);
            ComponentCallbacks2 componentCallbacks2 = this.U;
            if (componentCallbacks2 instanceof com.tencent.mobileqq.webview.swift.u) {
                WebViewFragment currentWebViewFragment3 = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks2).getCurrentWebViewFragment();
                if (currentWebViewFragment3 != null) {
                    SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler2 = (SwiftBrowserShareMenuHandler) currentWebViewFragment3.getComponentProvider().a(4);
                    bundle4.putString("strurt_msgid", swiftBrowserShareMenuHandler2.K);
                    bundle4.putString("struct_uin", swiftBrowserShareMenuHandler2.J);
                    bundle4.putString("struct_url", currentWebViewFragment3.getUrl());
                    bundle4.putBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
                    String str40 = swiftBrowserShareMenuHandler2.L;
                    if (str40 != null && !"".equals(str40)) {
                        bundle4.putString("source_puin", swiftBrowserShareMenuHandler2.L);
                    }
                } else {
                    z19 = true;
                    if (z19 && QZoneShareManager.jumpToQzoneShare(this.f97444c0.getCurrentUin(), this.V, bundle4, (DialogInterface.OnDismissListener) null, -1)) {
                        return;
                    }
                    com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
                    return;
                }
            }
            z19 = false;
            if (z19) {
            }
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
            return;
        }
        if (i3 != 1 && i3 != 11) {
            if (i3 == 3) {
                i18 = 3;
            } else {
                if (i3 != 4) {
                    if (i3 == 5) {
                        if (this.R != -1 && !TextUtils.isEmpty(this.N)) {
                            Bundle bundle5 = new Bundle();
                            if (TextUtils.isEmpty(str)) {
                                str37 = str3;
                            }
                            bundle5.putString("title", str37);
                            if (TextUtils.isEmpty(str39)) {
                                str39 = str3;
                            }
                            bundle5.putString("desc", str39);
                            bundle5.putString("detail_url", str3);
                            bundle5.putString("cover_url", this.N);
                            bundle5.putString("source_name", this.P);
                            bundle5.putInt(AppConstants.Key.SHARE_REQ_ARTICLE_ID, this.R);
                            ArrayList<String> arrayList2 = new ArrayList<>(1);
                            arrayList2.add(str4);
                            bundle5.putStringArrayList("image_url", arrayList2);
                            bundle5.putLong("req_share_id", 0L);
                            if (this.V == null) {
                                this.V = this.U;
                                return;
                            }
                            return;
                        }
                        ReportController.o(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
                        QLog.w(E0, 1, "onGetSummary invalid shareInfo");
                        return;
                    }
                    if (i3 == 6 || i3 == 7) {
                        QidianManager.i0(this.U, i3, str, str39, str3, str4, "", 0, false);
                        return;
                    }
                    if (i3 != 8) {
                        if (i3 == 9) {
                            AppRuntime appRuntime = ((AppActivity) this.U).getAppRuntime();
                            ComponentCallbacks2 componentCallbacks22 = this.U;
                            if ((componentCallbacks22 instanceof com.tencent.mobileqq.webview.swift.u) && (currentWebViewFragment2 = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks22).getCurrentWebViewFragment()) != null) {
                                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler3 = (SwiftBrowserShareMenuHandler) currentWebViewFragment2.getComponentProvider().a(4);
                                str38 = TextUtils.isEmpty(swiftBrowserShareMenuHandler3.L) ? swiftBrowserShareMenuHandler3.J : swiftBrowserShareMenuHandler3.L;
                            }
                            ComponentCallbacks2 componentCallbacks23 = this.U;
                            if (componentCallbacks23 instanceof IPublicAccountBrowser) {
                                str38 = ((IPublicAccountBrowser) componentCallbacks23).getPubUin();
                            }
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (!TextUtils.isEmpty(str38)) {
                                            Share share = Share.this;
                                            QfavBuilder.Z(0, share.f97452h, share.f97445d, null, share.C, share.D, null, null, false, -1L).F(str38).T("lCategory", 10L).h(Share.this.U, str38);
                                        } else {
                                            Share share2 = Share.this;
                                            QfavBuilder F = QfavBuilder.Z(0, share2.f97452h, share2.f97445d, null, share2.C, share2.D, null, null, false, -1L).F(Share.this.f97446d0);
                                            Share share3 = Share.this;
                                            F.h(share3.U, share3.f97446d0);
                                        }
                                    } catch (Exception e16) {
                                        QLog.e(Share.E0, 1, "QfavBuilder.newLink error:" + e16.toString());
                                    }
                                }
                            });
                            cooperation.qqfav.d.e(appRuntime, 42, 2);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(E0, 2, "shareMsgToSina start!");
                    }
                    try {
                        final ApplicationInfo applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo("com.sina.weibo", 8192);
                        if (QLog.isColorLevel()) {
                            QLog.d(E0, 2, "shareMsgToSina installSinaWeibo:true");
                        }
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QLog.isColorLevel()) {
                                    QLog.d(Share.E0, 2, "shareMsgToSina download image:" + str4);
                                }
                                String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), str4, null);
                                if (QLog.isColorLevel()) {
                                    QLog.d(Share.E0, 2, "shareMsgToSina path:" + e16);
                                }
                                if (WBShareHelper.u(Share.this.U)) {
                                    WBShareHelper.h(2).s(Share.this.U, str, str39, str3, " ", BitmapFactory.decodeFile(e16));
                                    QLog.d(Share.E0, 1, "shareMsgToSina use weibo sdk!");
                                } else {
                                    Intent intent = new Intent("android.intent.action.SEND");
                                    intent.setFlags(268435456);
                                    intent.setType("image/*");
                                    intent.putExtra("android.intent.extra.TEXT", str + str3);
                                    if (!TextUtils.isEmpty(e16)) {
                                        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(e16)));
                                    }
                                    FileProvider7Helper.intentCompatForN(Share.this.U, intent);
                                    intent.setPackage(applicationInfo.packageName);
                                    Share.this.U.startActivity(intent);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(Share.E0, 2, "shareMsgToSina start weibo!");
                                }
                            }
                        });
                    } catch (PackageManager.NameNotFoundException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d(E0, 2, "shareMsgToSina installSinaWeibo:false");
                        }
                        try {
                            String str41 = ((("https://service.weibo.com/share/share.php?title=" + URLEncoder.encode(str37, "UTF-8")) + "&url=" + URLEncoder.encode(str3, "UTF-8")) + "&pic=" + URLEncoder.encode(str4, "UTF-8")) + "&_wv=3";
                            Intent intent = new Intent(this.U, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", str41);
                            this.U.startActivity(intent);
                            if (QLog.isColorLevel()) {
                                QLog.d(E0, 2, "shareMsgToSina start webview!");
                            }
                        } catch (Exception e16) {
                            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.tcc), 1).show();
                            i26 = 2;
                            QLog.e(E0, 1, "error:", e16.toString());
                        }
                    }
                    i26 = 2;
                    if (QLog.isColorLevel()) {
                        QLog.d(E0, i26, "shareMsgToSina end!");
                        return;
                    }
                    return;
                }
                i18 = 3;
            }
            if (i3 == i18) {
                this.B0 = 1;
            } else {
                this.B0 = 2;
            }
            if (this.f97448e0 == null) {
                this.f97448e0 = new c();
                WXShareHelper.b0().A(this.f97448e0);
            }
            this.f97450f0 = String.valueOf(System.currentTimeMillis());
            if (!TextUtils.isEmpty(this.f97454i)) {
                Map<String, Integer> map = TeamWorkUtils.f291564e;
                if (map.containsKey(this.f97454i)) {
                    Integer num = map.get(this.f97454i);
                    if (num != null) {
                        i19 = num.intValue();
                        if (str3 != null || !str3.contains("docs.qq.com/")) {
                            WXShareHelper.b0().L0(this.f97450f0, str, bitmap, !TextUtils.isEmpty(str39) ? str3 : str39, str3, i3 != 3 ? 0 : 1);
                            return;
                        }
                        if (i3 != 3) {
                            if (i3 == 4) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(E0, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
                                }
                                WXShareHelper.b0().A(this.f97448e0);
                                WXShareHelper.b0().L0(this.f97450f0, this.f97452h, ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForH5ShareBitMap(i19), TextUtils.isEmpty(this.C) ? str3 : this.C, str3, i3 == 3 ? 0 : 1);
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(E0, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
                        }
                        WXShareHelper.b0().A(this.f97448e0);
                        if (y() != null && y().f292311q != null) {
                            str36 = "pages/detail/detail?scene=" + y().f292311q;
                        } else {
                            str36 = "pages/detail/detail?url=" + str3;
                        }
                        String str42 = str36;
                        if (QLog.isColorLevel()) {
                            QLog.d(E0, 2, "curFilePath=" + str42);
                        }
                        Bitmap shareBitMapBase64 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getShareBitMapBase64(this.f97459m);
                        if (TextUtils.isEmpty(this.f97459m) || !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isBase64ImgFormatData(this.f97459m)) {
                            shareBitMapBase64 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i19);
                        } else if (shareBitMapBase64 == null) {
                            shareBitMapBase64 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTeamWorkForShareBitMap(i19);
                        }
                        Bitmap bitmap2 = shareBitMapBase64;
                        if (bitmap2 != null) {
                            WXShareHelper.b0().y0(str42, "gh_252c5f06840b", bitmap2, this.f97452h, this.C, str3);
                            return;
                        }
                        return;
                    }
                    i19 = 1;
                    if (str3 != null) {
                    }
                    WXShareHelper.b0().L0(this.f97450f0, str, bitmap, !TextUtils.isEmpty(str39) ? str3 : str39, str3, i3 != 3 ? 0 : 1);
                    return;
                }
            }
            if ((str3 == null || !str3.contains("doc/")) && str3 != null && str3.contains("sheet/")) {
                i19 = 2;
                if (str3 != null) {
                }
                WXShareHelper.b0().L0(this.f97450f0, str, bitmap, !TextUtils.isEmpty(str39) ? str3 : str39, str3, i3 != 3 ? 0 : 1);
                return;
            }
            i19 = 1;
            if (str3 != null) {
            }
            WXShareHelper.b0().L0(this.f97450f0, str, bitmap, !TextUtils.isEmpty(str39) ? str3 : str39, str3, i3 != 3 ? 0 : 1);
            return;
        }
        Intent intent2 = new Intent(this.V, (Class<?>) ForwardRecentActivity.class);
        ComponentCallbacks2 componentCallbacks24 = this.U;
        if (componentCallbacks24 instanceof com.tencent.mobileqq.webview.swift.u) {
            WebViewFragment currentWebViewFragment4 = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks24).getCurrentWebViewFragment();
            if (currentWebViewFragment4 == null || currentWebViewFragment4.getComponentProvider() == null || (swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) currentWebViewFragment4.getComponentProvider().a(4)) == null) {
                str35 = "";
                bundle2 = null;
            } else {
                Bundle u16 = swiftBrowserShareMenuHandler.u();
                str35 = swiftBrowserShareMenuHandler.f314303i0;
                bundle2 = u16;
            }
            str7 = "";
            intent2.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
            if (TextUtils.isEmpty(str35)) {
                str35 = str7;
            }
            intent2.putExtra("forward_source_sub_business_type", str35);
            bundle = bundle2;
        } else {
            str7 = "";
            bundle = null;
        }
        if (bundle == null || bundle.isEmpty()) {
            str8 = "stringext_1";
            str9 = "intext_2";
            str10 = str7;
            i16 = 0;
        } else {
            str10 = bundle.getString("to_qq");
            i16 = bundle.getInt(ShortVideoConstants.TO_UIN_TYPE);
            if (QLog.isColorLevel()) {
                String str43 = E0;
                str8 = "stringext_1";
                StringBuilder sb6 = new StringBuilder();
                str9 = "intext_2";
                sb6.append("onGetSummary() called : toUin = ");
                sb6.append(str10);
                sb6.append(", uinType = ");
                sb6.append(i16);
                QLog.d(str43, 2, sb6.toString());
            } else {
                str8 = "stringext_1";
                str9 = "intext_2";
            }
        }
        if ((str10 != null && str10.length() >= 5) || AppConstants.DATALINE_PC_UIN.equals(str10)) {
            intent2.setClass(this.f97462o0, DirectForwardActivity.class);
            intent2.putExtra("toUin", str10);
            intent2.putExtra("uinType", i16);
            if (bundle != null && !bundle.isEmpty()) {
                String string2 = bundle.getString("to_uin_name");
                if (QLog.isColorLevel()) {
                    QLog.d(E0, 2, "onGetSummary() called : nickName = " + string2);
                }
                intent2.putExtra("nickName", string2);
                intent2.putExtra("guild_id", bundle.getString("guild_id"));
            }
            z17 = true;
        } else {
            z17 = true;
            intent2.putExtra("isWebCompShare", true);
            intent2.setClass(this.f97462o0, ForwardRecentActivity.class);
        }
        if (i3 == 11) {
            ForwardUtils.r0(this.U, intent2);
        }
        intent2.putExtra("key_flag_from_plugin", z17);
        intent2.putExtra("isWebCompShare", z17);
        boolean a06 = a0(intent2);
        boolean Z = Z(intent2);
        boolean L = L(this.f97447e);
        ?? r95 = this.U;
        String str44 = "plugin";
        if (r95 instanceof IPublicAccountBrowser) {
            String pubUin = ((IPublicAccountBrowser) r95).getPubUin();
            Resources resources = this.U.getResources();
            String stringExtra = this.U.getIntent().getStringExtra("source_name");
            if (!TextUtils.isEmpty(pubUin) && !TextUtils.isEmpty(stringExtra)) {
                z18 = false;
                String format = String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, pubUin);
                String format2 = String.format(IPublicAccountBrowser.SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL, pubUin);
                str29 = IPublicAccountBrowser.SHARE_SRC_ICON;
                str26 = format;
                str27 = format2;
                str28 = "plugin";
                string = stringExtra;
            } else {
                z18 = false;
                if (F0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("share_tool_trace", 2, "QQ kandian");
                    }
                    string = "QQ\u770b\u70b9";
                    str29 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
                    str28 = "plugin";
                    str26 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                    str27 = str26;
                } else {
                    string = resources.getString(R.string.dyf);
                    str26 = null;
                    str27 = null;
                    str28 = " ";
                    str29 = "https://url.cn/PWkhNu";
                }
            }
            if (L) {
                str30 = this.V.getString(R.string.dyj);
                str31 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
                str32 = "plugin";
                str33 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                str34 = str33;
            } else {
                str30 = string;
                str31 = str29;
                str32 = str28;
                str33 = str26;
                str34 = str27;
            }
            Activity activity = this.U;
            String string3 = resources.getString(R.string.f171308dy0);
            Object[] objArr = new Object[1];
            objArr[z18 ? 1 : 0] = str37;
            ShareMsgHelper.f(activity, 1001, 146, "web_share", pubUin, str4, str, str39, String.format(string3, objArr), str3, "web", null, null, null, str32, null, str33, str34, str31, str30, "", intent2, -1, null, -1L);
            str23 = str7;
            str24 = str3;
        } else {
            String str45 = str7;
            String stringExtra2 = r95.getIntent().getStringExtra("source_name");
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = this.P;
                str11 = this.Q;
            } else {
                str11 = null;
            }
            if (!TextUtils.isEmpty(stringExtra2) || F0) {
                str12 = " ";
                str13 = null;
                str14 = null;
            } else {
                String string4 = this.V.getString(R.string.dyf);
                MttLoader.BrowserInfo browserInfo = MttLoader.getBrowserInfo(this.U.getApplicationContext());
                if (browserInfo != null && !TextUtils.isEmpty(browserInfo.packageName)) {
                    str25 = browserInfo.packageName + QzoneWebViewOfflinePlugin.STR_DEVIDER + str3;
                } else {
                    str25 = "com.tencent.mtt://" + str3;
                }
                str12 = "app";
                str13 = str25;
                str11 = "https://url.cn/PWkhNu";
                str14 = "tencent100446242://" + str3;
                stringExtra2 = string4;
            }
            if (L) {
                stringExtra2 = this.V.getString(R.string.dyj);
                str17 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
                str15 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                str16 = str15;
            } else {
                str15 = str13;
                str16 = str14;
                str44 = str12;
                str17 = str11;
            }
            if ("QQ\u7a7a\u95f4".equals(stringExtra2)) {
                str17 = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";
            }
            ComponentCallbacks2 componentCallbacks25 = this.U;
            if (!(componentCallbacks25 instanceof com.tencent.mobileqq.webview.swift.u) || (currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks25).getCurrentWebViewFragment()) == null) {
                str18 = str45;
            } else {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler4 = (SwiftBrowserShareMenuHandler) currentWebViewFragment.getComponentProvider().a(4);
                if (!str45.equals(swiftBrowserShareMenuHandler4.L)) {
                    str18 = swiftBrowserShareMenuHandler4.L;
                } else {
                    str18 = swiftBrowserShareMenuHandler4.J;
                }
            }
            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str3)) {
                String qqStr = HardCodeUtil.qqStr(R.string.tcb);
                String e17 = TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e()) ? ITeamWorkUtils.DOCS_LIST_WEB_URL : TencentDocConvertConfigProcessor.a().e();
                i17 = 95;
                j3 = ITeamWorkUtils.DOCS_APPID;
                str19 = qqStr;
                str20 = e17;
                str22 = "web";
                str21 = ITeamWorkUtils.DOCS_SOURCE_ICON_URL;
            } else {
                j3 = 801097412;
                i17 = 146;
                str19 = stringExtra2;
                str20 = "https://url.cn/UQoBHn";
                str21 = str17;
                str22 = str44;
            }
            long j16 = j3;
            int i28 = (Z || a06) ? 38 : 1001;
            intent2.putExtra("k_action_web_default_share", true);
            Activity activity2 = this.V;
            Object[] objArr2 = new Object[1];
            objArr2[0] = str != null ? str : str45;
            String str46 = str18;
            str23 = str45;
            str24 = str3;
            ShareMsgHelper.f(activity2, i28, i17, "web_share", str46, str4, str, str39, activity2.getString(R.string.f171308dy0, objArr2), str3, "web", null, null, null, str22, null, str15, str16, str21, str19, "", intent2, this.f97471x0 == null ? -1 : 1001, str20, j16);
        }
        boolean isEmpty2 = TextUtils.isEmpty(str4);
        boolean z27 = isEmpty2;
        if (TextUtils.isEmpty(str39)) {
            z27 = (isEmpty2 ? 1 : 0) | 2;
        }
        ?? r06 = z27;
        if (TextUtils.isEmpty(str)) {
            r06 = (z27 ? 1 : 0) | 4;
        }
        Bundle bundle6 = new Bundle();
        bundle6.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
        bundle6.putString(str6, "14");
        bundle6.putString("intext_3", "1");
        bundle6.putString(str9, str23 + r06);
        bundle6.putString(str8, str23 + str24);
        ReportCenter.f().l(bundle6, str23, this.f97444c0.getAccount(), false);
    }

    private boolean Z(Intent intent) {
        int i3;
        String str;
        String str2;
        try {
            String t16 = t(getShareUrl(), this.f97449f, this.f97447e);
            HashMap<String, String> q16 = q(t16);
            if (!q16.isEmpty() && q16.containsKey("app") && q16.containsKey("view")) {
                String str3 = q16.get("app");
                String str4 = q16.get("view");
                if (!q16.containsKey(QQCustomArkDialogUtil.BIZ_SRC)) {
                    str = "";
                } else {
                    str = q16.get(QQCustomArkDialogUtil.BIZ_SRC);
                }
                if (!q16.containsKey(PublicAccountMessageUtilImpl.META_NAME)) {
                    str2 = "{}";
                } else {
                    str2 = q16.get(PublicAccountMessageUtilImpl.META_NAME);
                }
                String str5 = q16.get(DownloadInfo.spKey_Config);
                String str6 = q16.get("ver");
                if (!TextUtils.isEmpty(str3)) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            f(intent, t16, "", str3, str4, str, "", str2, str5, str6, "", "", "", "", "");
                            return true;
                        } catch (Exception e16) {
                            e = e16;
                            i3 = 1;
                            String str7 = E0;
                            Object[] objArr = new Object[i3];
                            objArr[0] = e.getMessage();
                            com.tencent.mobileqq.ark.d.d(str7, String.format("shareArkFromUrl, parse json failed, err=%s", objArr));
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 1;
        }
        return false;
    }

    private boolean a0(Intent intent) {
        Bundle extras = this.U.getIntent().getExtras();
        String string = extras.getString("forward_ark_app_name");
        String string2 = extras.getString("forward_ark_app_view");
        String string3 = extras.getString("forward_ark_biz_src", "");
        if (this.f97472y0 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            String t16 = t(getShareUrl(), this.f97449f, this.f97447e);
            String string4 = extras.getString("forward_ark_app_meta");
            String string5 = extras.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
            f(intent, t16, extras.getString("forward_ark_app_prompt"), string, string2, string3, extras.getString(AppConstants.Key.FORWARD_ARK_APP_DESC), string4, string5, "", extras.getString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK), extras.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME), extras.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA), extras.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA), extras.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL));
            return true;
        }
        return false;
    }

    private void f(Intent intent, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Bundle a16 = QQCustomArkDialog.b.a(str3, str4, str5, Constants.DEFAULT_MIN_APP_VERSION, str7, this.f97462o0.getResources().getDisplayMetrics().scaledDensity, null, null);
        a16.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
        a16.putString("forward_ark_app_name", str3);
        a16.putString("forward_ark_app_view", str4);
        a16.putString("forward_ark_biz_src", str5);
        a16.putString("forward_ark_app_meta", str7);
        a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, str6);
        a16.putString("forward_ark_app_prompt", str2);
        a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
        if (!TextUtils.isEmpty(str9)) {
            a16.putString("forward_ark_app_ver", str9);
        }
        a16.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5, true);
        a16.putString(AppConstants.Key.FORWARD_ARK_H5_FROM_NORMAL, str);
        a16.putBoolean("is_ark_display_share", true);
        a16.putString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK, str10);
        a16.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, str11);
        a16.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, str12);
        a16.putString("struct_share_key_source_a_action_data_from_h5", str13);
        a16.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, str14);
        if (QLog.isColorLevel()) {
            QLog.d(E0, 2, "ShareArkFromH5 buildArkShareIntent bundle = ", a16.toString());
        }
        intent.putExtras(a16);
    }

    public static List<d> h(PBRepeatMessageField<GetAppInfoProto$MsgIconsurl> pBRepeatMessageField) {
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            List<GetAppInfoProto$MsgIconsurl> list = pBRepeatMessageField.get();
            ArrayList arrayList = new ArrayList(list.size());
            for (GetAppInfoProto$MsgIconsurl getAppInfoProto$MsgIconsurl : list) {
                arrayList.add(new d(getAppInfoProto$MsgIconsurl.url, getAppInfoProto$MsgIconsurl.size));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final int i3, boolean z16) {
        Bitmap bitmap;
        Bitmap bitmap2;
        final HashMap hashMap = new HashMap();
        boolean z17 = true;
        if (i3 == 1 && M(str)) {
            if ((str.length() > 180 || (!(this.U instanceof IPublicAccountBrowser) && str.length() > 60)) && !(this.U instanceof TeamWorkDocEditBrowserActivity) && !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str)) {
                hashMap.put("url", str);
            }
            String str2 = this.D;
            if (str2 != null && str2.length() > 40) {
                hashMap.put("thumb", this.D);
            }
        }
        SoftReference<Bitmap> softReference = this.T;
        if (softReference == null) {
            bitmap = null;
        } else {
            bitmap = softReference.get();
        }
        if (!z16 || ((i3 != 3 && i3 != 4) || bitmap != null || TextUtils.isEmpty(this.D))) {
            z17 = false;
        }
        final boolean z18 = z17;
        if ((this.K || hashMap.size() > 0 || z18) && i3 != 2 && i3 != 9) {
            i0(R.string.yh6);
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3
                /* JADX WARN: Removed duplicated region for block: B:122:0x01ba  */
                /* JADX WARN: Removed duplicated region for block: B:123:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x011e  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x019d  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x0312  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x0320  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x0439  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0454  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0432  */
                /* JADX WARN: Removed duplicated region for block: B:67:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0285  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x02b7  */
                /* JADX WARN: Removed duplicated region for block: B:86:0x02b9  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Object obj;
                    String str3;
                    String str4;
                    String str5;
                    String str6;
                    Object obj2;
                    String str7;
                    Bitmap bitmap3;
                    int i16;
                    String str8;
                    byte[] openUrlForByte;
                    Bitmap bitmap4;
                    HashMap<String, String> hashMap2;
                    String str9;
                    String str10;
                    int i17;
                    String str11;
                    String str12;
                    String str13;
                    int i18;
                    int i19;
                    String openUrl;
                    JSONObject jSONObject;
                    Object[] objArr;
                    String str14 = "intext_1";
                    if (!Share.this.K) {
                        obj = "thumb";
                        str3 = "shareWebPage";
                        str4 = "stringext_1";
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("shareWebPage", 2, "CGI_ChangeQPicThumb START thumb=" + Share.this.D);
                        }
                        Share share = Share.this;
                        share.K = false;
                        try {
                        } catch (UnsupportedEncodingException e16) {
                            e = e16;
                            str11 = "stringext_1";
                            str12 = "shareWebPage";
                        } catch (NullPointerException e17) {
                            e = e17;
                            str11 = "stringext_1";
                            str12 = "shareWebPage";
                        }
                        if (TextUtils.isEmpty(share.D)) {
                            str11 = "stringext_1";
                            str12 = "shareWebPage";
                            str13 = null;
                            if (QLog.isColorLevel()) {
                            }
                            i18 = 0;
                            openUrl = HttpUtil.openUrl(BaseApplication.getContext(), str13, "GET", null, null);
                            if (openUrl == null) {
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle.putString("act_type", "95");
                            bundle.putString("intext_1", "" + i19);
                            bundle.putString("intext_4", "" + i18);
                            bundle.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                            str4 = str11;
                            bundle.putString(str4, str);
                            obj = "thumb";
                            ReportCenter.f().l(bundle, "", Share.this.f97444c0.getAccount(), false);
                            if (QLog.isColorLevel()) {
                            }
                        } else {
                            str12 = "shareWebPage";
                            try {
                                objArr = new Object[2];
                                objArr[0] = Share.this.f97444c0.getAccount();
                                str11 = "stringext_1";
                            } catch (UnsupportedEncodingException e18) {
                                e = e18;
                                str11 = "stringext_1";
                            } catch (NullPointerException e19) {
                                e = e19;
                                str11 = "stringext_1";
                            }
                            try {
                                objArr[1] = URLEncoder.encode(Share.this.D, "UTF-8");
                                str13 = String.format("https://cgi.connect.qq.com/qqconnectopen/openapi/change_image_url?url=%2$s&userhttps=0&uin=%1$s", objArr);
                            } catch (UnsupportedEncodingException e26) {
                                e = e26;
                                e.printStackTrace();
                                str13 = null;
                                if (QLog.isColorLevel()) {
                                }
                                i18 = 0;
                                openUrl = HttpUtil.openUrl(BaseApplication.getContext(), str13, "GET", null, null);
                                try {
                                    if (openUrl == null) {
                                    }
                                } catch (IOException e27) {
                                    e = e27;
                                    e.printStackTrace();
                                    i19 = 1;
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    bundle2.putString("act_type", "95");
                                    bundle2.putString("intext_1", "" + i19);
                                    bundle2.putString("intext_4", "" + i18);
                                    bundle2.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                    str4 = str11;
                                    bundle2.putString(str4, str);
                                    obj = "thumb";
                                    ReportCenter.f().l(bundle2, "", Share.this.f97444c0.getAccount(), false);
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (z18) {
                                    }
                                    if (hashMap.size() > 0) {
                                    }
                                    Share share2 = Share.this;
                                    if (hashMap2 != null) {
                                    }
                                    str9 = str;
                                    share2.f97445d = str9;
                                    Share share3 = Share.this;
                                    share3.f97447e = str;
                                    if (hashMap2 != null) {
                                    }
                                    str10 = Share.this.D;
                                    share3.D = str10;
                                    final Bitmap bitmap5 = bitmap4;
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                            if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                Share.this.H();
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                Share share4 = Share.this;
                                                share4.Y(i3, share4.f97452h, share4.C, share4.f97445d, share4.D, bitmap5);
                                            }
                                        }
                                    });
                                } catch (NullPointerException e28) {
                                    e = e28;
                                    QLog.e(Share.E0, 1, e.toString());
                                    i19 = 1;
                                    Bundle bundle22 = new Bundle();
                                    bundle22.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                    bundle22.putString("act_type", "95");
                                    bundle22.putString("intext_1", "" + i19);
                                    bundle22.putString("intext_4", "" + i18);
                                    bundle22.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                    str4 = str11;
                                    bundle22.putString(str4, str);
                                    obj = "thumb";
                                    ReportCenter.f().l(bundle22, "", Share.this.f97444c0.getAccount(), false);
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (z18) {
                                    }
                                    if (hashMap.size() > 0) {
                                    }
                                    Share share22 = Share.this;
                                    if (hashMap2 != null) {
                                    }
                                    str9 = str;
                                    share22.f97445d = str9;
                                    Share share32 = Share.this;
                                    share32.f97447e = str;
                                    if (hashMap2 != null) {
                                    }
                                    str10 = Share.this.D;
                                    share32.D = str10;
                                    final Bitmap bitmap52 = bitmap4;
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                            if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                Share.this.H();
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                Share share4 = Share.this;
                                                share4.Y(i3, share4.f97452h, share4.C, share4.f97445d, share4.D, bitmap52);
                                            }
                                        }
                                    });
                                }
                                Bundle bundle222 = new Bundle();
                                bundle222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                bundle222.putString("act_type", "95");
                                bundle222.putString("intext_1", "" + i19);
                                bundle222.putString("intext_4", "" + i18);
                                bundle222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                str4 = str11;
                                bundle222.putString(str4, str);
                                obj = "thumb";
                                ReportCenter.f().l(bundle222, "", Share.this.f97444c0.getAccount(), false);
                                if (QLog.isColorLevel()) {
                                }
                                if (z18) {
                                }
                                if (hashMap.size() > 0) {
                                }
                                Share share222 = Share.this;
                                if (hashMap2 != null) {
                                }
                                str9 = str;
                                share222.f97445d = str9;
                                Share share322 = Share.this;
                                share322.f97447e = str;
                                if (hashMap2 != null) {
                                }
                                str10 = Share.this.D;
                                share322.D = str10;
                                final Bitmap bitmap522 = bitmap4;
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                        if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                            Share.this.H();
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            Share share4 = Share.this;
                                            share4.Y(i3, share4.f97452h, share4.C, share4.f97445d, share4.D, bitmap522);
                                        }
                                    }
                                });
                            } catch (NullPointerException e29) {
                                e = e29;
                                QLog.e(Share.E0, 1, e.toString());
                                str13 = null;
                                if (QLog.isColorLevel()) {
                                }
                                i18 = 0;
                                openUrl = HttpUtil.openUrl(BaseApplication.getContext(), str13, "GET", null, null);
                                if (openUrl == null) {
                                }
                                Bundle bundle2222 = new Bundle();
                                bundle2222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                bundle2222.putString("act_type", "95");
                                bundle2222.putString("intext_1", "" + i19);
                                bundle2222.putString("intext_4", "" + i18);
                                bundle2222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                str4 = str11;
                                bundle2222.putString(str4, str);
                                obj = "thumb";
                                ReportCenter.f().l(bundle2222, "", Share.this.f97444c0.getAccount(), false);
                                if (QLog.isColorLevel()) {
                                }
                                if (z18) {
                                }
                                if (hashMap.size() > 0) {
                                }
                                Share share2222 = Share.this;
                                if (hashMap2 != null) {
                                }
                                str9 = str;
                                share2222.f97445d = str9;
                                Share share3222 = Share.this;
                                share3222.f97447e = str;
                                if (hashMap2 != null) {
                                }
                                str10 = Share.this.D;
                                share3222.D = str10;
                                final Bitmap bitmap5222 = bitmap4;
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                        if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                            Share.this.H();
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            Share share4 = Share.this;
                                            share4.Y(i3, share4.f97452h, share4.C, share4.f97445d, share4.D, bitmap5222);
                                        }
                                    }
                                });
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(Share.E0, 1, "cgi:", str13);
                            }
                            try {
                                i18 = 0;
                                openUrl = HttpUtil.openUrl(BaseApplication.getContext(), str13, "GET", null, null);
                            } catch (IOException e36) {
                                e = e36;
                                i18 = 0;
                            } catch (NullPointerException e37) {
                                e = e37;
                                i18 = 0;
                            }
                            if (openUrl == null) {
                                try {
                                    jSONObject = new JSONObject(openUrl);
                                    i18 = jSONObject.getInt("retcode");
                                } catch (JSONException e38) {
                                    e = e38;
                                    i18 = 0;
                                }
                                if (i18 == 0) {
                                    try {
                                    } catch (JSONException e39) {
                                        e = e39;
                                        if (QLog.isColorLevel()) {
                                            QLog.d(Share.E0, 2, e.getMessage());
                                        }
                                        i19 = 1;
                                        Bundle bundle22222 = new Bundle();
                                        bundle22222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                        bundle22222.putString("act_type", "95");
                                        bundle22222.putString("intext_1", "" + i19);
                                        bundle22222.putString("intext_4", "" + i18);
                                        bundle22222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                        str4 = str11;
                                        bundle22222.putString(str4, str);
                                        obj = "thumb";
                                        ReportCenter.f().l(bundle22222, "", Share.this.f97444c0.getAccount(), false);
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (z18) {
                                        }
                                        if (hashMap.size() > 0) {
                                        }
                                        Share share22222 = Share.this;
                                        if (hashMap2 != null) {
                                        }
                                        str9 = str;
                                        share22222.f97445d = str9;
                                        Share share32222 = Share.this;
                                        share32222.f97447e = str;
                                        if (hashMap2 != null) {
                                        }
                                        str10 = Share.this.D;
                                        share32222.D = str10;
                                        final Bitmap bitmap52222 = bitmap4;
                                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                                if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                    Share.this.H();
                                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                    Share share4 = Share.this;
                                                    share4.Y(i3, share4.f97452h, share4.C, share4.f97445d, share4.D, bitmap52222);
                                                }
                                            }
                                        });
                                    }
                                    if (jSONObject.has("url")) {
                                        String string = jSONObject.getString("url");
                                        if (!TextUtils.isEmpty(string)) {
                                            Share share4 = Share.this;
                                            share4.D = string;
                                            share4.L = 1;
                                            i19 = 0;
                                        }
                                        i19 = 1;
                                    }
                                }
                                if (i18 == 10702) {
                                    Share.this.D = null;
                                    hashMap.remove("thumb");
                                }
                                i19 = 1;
                            } else {
                                i19 = 1;
                                i18 = 0;
                            }
                            Bundle bundle222222 = new Bundle();
                            bundle222222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle222222.putString("act_type", "95");
                            bundle222222.putString("intext_1", "" + i19);
                            bundle222222.putString("intext_4", "" + i18);
                            bundle222222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                            str4 = str11;
                            bundle222222.putString(str4, str);
                            obj = "thumb";
                            ReportCenter.f().l(bundle222222, "", Share.this.f97444c0.getAccount(), false);
                            if (QLog.isColorLevel()) {
                                str3 = str12;
                                QLog.e(str3, 2, "CGI_ChangeQPicThumb END thumb=" + Share.this.D);
                            } else {
                                str3 = str12;
                            }
                        }
                    }
                    if (z18) {
                        str5 = "retcode";
                        obj2 = "url";
                        str8 = "intext_5";
                        bitmap3 = null;
                    } else {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e(str3, 2, "Download thumb START. " + Share.this.D);
                            }
                            obj2 = "url";
                        } catch (IOException | OutOfMemoryError unused) {
                            str5 = "retcode";
                            str6 = "intext_1";
                            obj2 = "url";
                        } catch (IllegalArgumentException e46) {
                            e = e46;
                            str5 = "retcode";
                            str6 = "intext_1";
                            obj2 = "url";
                        }
                        try {
                            openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), Share.this.D, "GET", null, null);
                        } catch (IOException | OutOfMemoryError unused2) {
                        } catch (IllegalArgumentException e47) {
                            e = e47;
                            str5 = "retcode";
                            str6 = "intext_1";
                            str7 = "intext_5";
                            bitmap3 = null;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            Bundle bundle3 = new Bundle();
                            bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle3.putString("act_type", "96");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("");
                            if (bitmap3 != null) {
                            }
                            sb5.append(i16);
                            str14 = str6;
                            bundle3.putString(str14, sb5.toString());
                            bundle3.putString("intext_4", "0");
                            bundle3.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                            str8 = str7;
                            bundle3.putString(str8, "" + Share.this.L);
                            bundle3.putString(str4, str);
                            ReportCenter.f().l(bundle3, "", Share.this.f97444c0.getAccount(), false);
                            if (hashMap.size() > 0) {
                            }
                            Share share222222 = Share.this;
                            if (hashMap2 != null) {
                            }
                            str9 = str;
                            share222222.f97445d = str9;
                            Share share322222 = Share.this;
                            share322222.f97447e = str;
                            if (hashMap2 != null) {
                            }
                            str10 = Share.this.D;
                            share322222.D = str10;
                            final Bitmap bitmap522222 = bitmap4;
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                    if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                        Share.this.H();
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        Share share42 = Share.this;
                                        share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap522222);
                                    }
                                }
                            });
                        }
                        if (openUrlForByte != null) {
                            bitmap3 = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length);
                            if (bitmap3 != null) {
                                try {
                                    int width = bitmap3.getWidth();
                                    int height = bitmap3.getHeight();
                                    int i26 = width * height;
                                    str5 = "retcode";
                                    if (i26 <= 8000) {
                                        str6 = "intext_1";
                                        str7 = "intext_5";
                                    } else {
                                        try {
                                            double sqrt = Math.sqrt(8000.0d / i26);
                                            str7 = "intext_5";
                                            str6 = "intext_1";
                                            try {
                                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, (int) (width * sqrt), (int) (height * sqrt), true);
                                                bitmap3.recycle();
                                                bitmap3 = createScaledBitmap;
                                            } catch (IOException | OutOfMemoryError unused3) {
                                            } catch (IllegalArgumentException e48) {
                                                e = e48;
                                                e.printStackTrace();
                                                if (QLog.isColorLevel()) {
                                                }
                                                Bundle bundle32 = new Bundle();
                                                bundle32.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                                bundle32.putString("act_type", "96");
                                                StringBuilder sb52 = new StringBuilder();
                                                sb52.append("");
                                                if (bitmap3 != null) {
                                                }
                                                sb52.append(i16);
                                                str14 = str6;
                                                bundle32.putString(str14, sb52.toString());
                                                bundle32.putString("intext_4", "0");
                                                bundle32.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                                str8 = str7;
                                                bundle32.putString(str8, "" + Share.this.L);
                                                bundle32.putString(str4, str);
                                                ReportCenter.f().l(bundle32, "", Share.this.f97444c0.getAccount(), false);
                                                if (hashMap.size() > 0) {
                                                }
                                                Share share2222222 = Share.this;
                                                if (hashMap2 != null) {
                                                }
                                                str9 = str;
                                                share2222222.f97445d = str9;
                                                Share share3222222 = Share.this;
                                                share3222222.f97447e = str;
                                                if (hashMap2 != null) {
                                                }
                                                str10 = Share.this.D;
                                                share3222222.D = str10;
                                                final Bitmap bitmap5222222 = bitmap4;
                                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                                        if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                            Share.this.H();
                                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                            Share share42 = Share.this;
                                                            share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap5222222);
                                                        }
                                                    }
                                                });
                                            }
                                        } catch (IOException | OutOfMemoryError unused4) {
                                            str7 = "intext_5";
                                            str6 = "intext_1";
                                        } catch (IllegalArgumentException e49) {
                                            e = e49;
                                            str7 = "intext_5";
                                            str6 = "intext_1";
                                            e.printStackTrace();
                                            if (QLog.isColorLevel()) {
                                            }
                                            Bundle bundle322 = new Bundle();
                                            bundle322.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                            bundle322.putString("act_type", "96");
                                            StringBuilder sb522 = new StringBuilder();
                                            sb522.append("");
                                            if (bitmap3 != null) {
                                            }
                                            sb522.append(i16);
                                            str14 = str6;
                                            bundle322.putString(str14, sb522.toString());
                                            bundle322.putString("intext_4", "0");
                                            bundle322.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                            str8 = str7;
                                            bundle322.putString(str8, "" + Share.this.L);
                                            bundle322.putString(str4, str);
                                            ReportCenter.f().l(bundle322, "", Share.this.f97444c0.getAccount(), false);
                                            if (hashMap.size() > 0) {
                                            }
                                            Share share22222222 = Share.this;
                                            if (hashMap2 != null) {
                                            }
                                            str9 = str;
                                            share22222222.f97445d = str9;
                                            Share share32222222 = Share.this;
                                            share32222222.f97447e = str;
                                            if (hashMap2 != null) {
                                            }
                                            str10 = Share.this.D;
                                            share32222222.D = str10;
                                            final Bitmap bitmap52222222 = bitmap4;
                                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                                    if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                        Share.this.H();
                                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                        Share share42 = Share.this;
                                                        share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap52222222);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                    Share.this.T = new SoftReference<>(bitmap3);
                                } catch (IOException | OutOfMemoryError unused5) {
                                } catch (IllegalArgumentException e56) {
                                    e = e56;
                                    str5 = "retcode";
                                    str6 = "intext_1";
                                    str7 = "intext_5";
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.e(str3, 2, "Download thumb END. " + Share.this.D);
                                }
                                Bundle bundle3222 = new Bundle();
                                bundle3222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                bundle3222.putString("act_type", "96");
                                StringBuilder sb5222 = new StringBuilder();
                                sb5222.append("");
                                if (bitmap3 != null) {
                                    i16 = 1;
                                } else {
                                    i16 = 0;
                                }
                                sb5222.append(i16);
                                str14 = str6;
                                bundle3222.putString(str14, sb5222.toString());
                                bundle3222.putString("intext_4", "0");
                                bundle3222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                                str8 = str7;
                                bundle3222.putString(str8, "" + Share.this.L);
                                bundle3222.putString(str4, str);
                                ReportCenter.f().l(bundle3222, "", Share.this.f97444c0.getAccount(), false);
                            }
                            str5 = "retcode";
                            str6 = "intext_1";
                            str7 = "intext_5";
                            if (QLog.isColorLevel()) {
                            }
                            Bundle bundle32222 = new Bundle();
                            bundle32222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle32222.putString("act_type", "96");
                            StringBuilder sb52222 = new StringBuilder();
                            sb52222.append("");
                            if (bitmap3 != null) {
                            }
                            sb52222.append(i16);
                            str14 = str6;
                            bundle32222.putString(str14, sb52222.toString());
                            bundle32222.putString("intext_4", "0");
                            bundle32222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                            str8 = str7;
                            bundle32222.putString(str8, "" + Share.this.L);
                            bundle32222.putString(str4, str);
                            ReportCenter.f().l(bundle32222, "", Share.this.f97444c0.getAccount(), false);
                        }
                        str5 = "retcode";
                        str6 = "intext_1";
                        str7 = "intext_5";
                        bitmap3 = null;
                        if (QLog.isColorLevel()) {
                        }
                        Bundle bundle322222 = new Bundle();
                        bundle322222.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                        bundle322222.putString("act_type", "96");
                        StringBuilder sb522222 = new StringBuilder();
                        sb522222.append("");
                        if (bitmap3 != null) {
                        }
                        sb522222.append(i16);
                        str14 = str6;
                        bundle322222.putString(str14, sb522222.toString());
                        bundle322222.putString("intext_4", "0");
                        bundle322222.putString("intext_3", "" + com.tencent.open.agent.report.e.a(i3));
                        str8 = str7;
                        bundle322222.putString(str8, "" + Share.this.L);
                        bundle322222.putString(str4, str);
                        ReportCenter.f().l(bundle322222, "", Share.this.f97444c0.getAccount(), false);
                    }
                    if (hashMap.size() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Bundle bundle4 = new Bundle();
                        Bundle bundle5 = new Bundle();
                        bundle5.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                        bundle5.putString("act_type", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
                        bundle5.putString("intext_3", "1");
                        bitmap4 = bitmap3;
                        bundle5.putString(str4, str);
                        String str15 = str4;
                        String str16 = str8;
                        ReportCenter.f().l(bundle5, "", Share.this.f97444c0.getAccount(), false);
                        if (QLog.isColorLevel()) {
                            QLog.e(str3, 2, "shortenUrlBatch START. " + hashMap);
                        }
                        HashMap<String, String> shortenUrlBatch = HttpUtil.shortenUrlBatch(hashMap, bundle4);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (shortenUrlBatch != null && shortenUrlBatch.size() > 0 && shortenUrlBatch.get(shortenUrlBatch.keySet().iterator().next()).contains("url.cn")) {
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e(str3, 2, "shortenUrlBatch END. " + shortenUrlBatch);
                        }
                        Bundle bundle6 = new Bundle();
                        bundle6.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                        bundle6.putString("act_type", "12");
                        bundle6.putString("intext_3", "1");
                        bundle6.putString(str14, "" + i17);
                        bundle6.putString("intext_2", "" + bundle4.getInt(str5, 0));
                        bundle6.putString(str16, "" + currentTimeMillis2);
                        if (i17 == 1) {
                            bundle6.putString(str15, str);
                        }
                        ReportCenter.f().l(bundle6, "", Share.this.f97444c0.getAccount(), false);
                        hashMap2 = shortenUrlBatch;
                    } else {
                        bitmap4 = bitmap3;
                        hashMap2 = null;
                    }
                    Share share222222222 = Share.this;
                    if (hashMap2 != null) {
                        Object obj3 = obj2;
                        if (hashMap2.containsKey(obj3)) {
                            str9 = hashMap2.get(obj3);
                            share222222222.f97445d = str9;
                            Share share322222222 = Share.this;
                            share322222222.f97447e = str;
                            if (hashMap2 != null) {
                                Object obj4 = obj;
                                if (hashMap2.containsKey(obj4)) {
                                    str10 = hashMap2.get(obj4);
                                    share322222222.D = str10;
                                    final Bitmap bitmap522222222 = bitmap4;
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                            if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                                Share.this.H();
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                Share share42 = Share.this;
                                                share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap522222222);
                                            }
                                        }
                                    });
                                }
                            }
                            str10 = Share.this.D;
                            share322222222.D = str10;
                            final Bitmap bitmap5222222222 = bitmap4;
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                                    if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                        Share.this.H();
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        Share share42 = Share.this;
                                        share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap5222222222);
                                    }
                                }
                            });
                        }
                    }
                    str9 = str;
                    share222222222.f97445d = str9;
                    Share share3222222222 = Share.this;
                    share3222222222.f97447e = str;
                    if (hashMap2 != null) {
                    }
                    str10 = Share.this.D;
                    share3222222222.D = str10;
                    final Bitmap bitmap52222222222 = bitmap4;
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.webview.swift.y yVar = Share.this.f97473z0.get();
                            if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar).isActivityResume() && !Share.this.U.isFinishing()) {
                                Share.this.H();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                Share share42 = Share.this;
                                share42.Y(i3, share42.f97452h, share42.C, share42.f97445d, share42.D, bitmap52222222222);
                            }
                        }
                    });
                }
            });
            return;
        }
        H();
        String str3 = this.f97452h;
        String str4 = this.C;
        String str5 = this.D;
        if (z16) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = null;
        }
        Y(i3, str3, str4, str, str5, bitmap2);
    }

    private void i0(final int i3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.9
            @Override // java.lang.Runnable
            public void run() {
                Share.this.getSharePD().setMessage(i3);
                if (!Share.this.X.isShowing() && !Share.this.U.isFinishing()) {
                    Share.this.X.show();
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    public static final String k(PBRepeatMessageField<GetAppInfoProto$MsgIconsurl> pBRepeatMessageField, int i3) {
        List<d> h16 = h(pBRepeatMessageField);
        if (h16 != null && !h16.isEmpty()) {
            return l(h16, i3);
        }
        return null;
    }

    public static final String l(List<d> list, int i3) {
        String str = null;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = list.get(i16);
                try {
                    if (Integer.valueOf(dVar.f97507b.get()).intValue() >= i3) {
                        str = dVar.f97506a.get();
                        if (!TextUtils.isEmpty(str)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(E0, 2, e16.getMessage());
                    }
                }
            }
            if (str == null) {
                for (int i17 = size - 1; i17 >= 0; i17--) {
                    d dVar2 = list.get(i17);
                    try {
                        if (Integer.valueOf(dVar2.f97507b.get()).intValue() < i3) {
                            str = dVar2.f97506a.get();
                            if (!TextUtils.isEmpty(str)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (NumberFormatException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(E0, 2, e17.getMessage());
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(E0, 2, "QQBrowserActivity findAppIcon() iconUrl = " + str);
        }
        return str;
    }

    public static final void m(AppInterface appInterface, Context context, String str, long j3, String str2, long j16, long j17, com.tencent.open.appcommon.d dVar, String str3, long j18, boolean z16) {
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(j3);
        getAppInfoProto$GetAppinfoRequest.sdkp.set("android");
        getAppInfoProto$GetAppinfoRequest.f342196os.set(Build.VERSION.RELEASE);
        getAppInfoProto$GetAppinfoRequest.qqv.set(AppSetting.f99551k);
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        getAppInfoProto$GetAppinfoRequest.md5time.set(j17);
        getAppInfoProto$GetAppinfoRequest.signature.set(str2);
        getAppInfoProto$GetAppinfoRequest.channel_source.set(j16);
        if (!TextUtils.isEmpty(str3)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(str3);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(2);
        NewIntent newIntent = new NewIntent(context, OpensdkServlet.class);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("data", getAppInfoProto$GetAppinfoRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_app_info");
        newIntent.putExtra("timeout", j18);
        newIntent.putExtra("key_support_retry", z16);
        newIntent.setObserver(dVar);
        appInterface.startServlet(newIntent);
    }

    public static final void n(AppInterface appInterface, Context context, String str, long j3, String str2, long j16, com.tencent.open.appcommon.d dVar, String str3) {
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(j3);
        getAppInfoProto$GetAppinfoRequest.sdkp.set("android");
        getAppInfoProto$GetAppinfoRequest.f342196os.set(Build.VERSION.RELEASE);
        getAppInfoProto$GetAppinfoRequest.qqv.set(AppSetting.f99551k);
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        getAppInfoProto$GetAppinfoRequest.md5time.set(j16);
        getAppInfoProto$GetAppinfoRequest.signature.set(str2);
        if (!TextUtils.isEmpty(str3)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(str3);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(2);
        NewIntent newIntent = new NewIntent(context, OpensdkServlet.class);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("data", getAppInfoProto$GetAppinfoRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_app_info");
        newIntent.putExtra("timeout", 15000L);
        newIntent.setObserver(dVar);
        appInterface.startServlet(newIntent);
    }

    public static final void o(AppRuntime appRuntime, Context context, String str, long j3, long j16, com.tencent.open.appcommon.d dVar) {
        p(appRuntime, context, str, j3, j16, dVar, BaseApplication.getContext().getPackageName());
    }

    public static final void p(AppRuntime appRuntime, Context context, String str, long j3, long j16, com.tencent.open.appcommon.d dVar, String str2) {
        GetAppInfoProto$GetAppinfoRequest getAppInfoProto$GetAppinfoRequest = new GetAppInfoProto$GetAppinfoRequest();
        getAppInfoProto$GetAppinfoRequest.client_id.set(j3);
        getAppInfoProto$GetAppinfoRequest.sdkp.set("android");
        getAppInfoProto$GetAppinfoRequest.f342196os.set(Build.VERSION.RELEASE);
        getAppInfoProto$GetAppinfoRequest.qqv.set(AppSetting.f99551k);
        getAppInfoProto$GetAppinfoRequest.setHasFlag(true);
        if (!TextUtils.isEmpty(str2)) {
            getAppInfoProto$GetAppinfoRequest.appUniqueIdentifier.set(str2);
        }
        getAppInfoProto$GetAppinfoRequest.referer.set(2);
        NewIntent newIntent = new NewIntent(context, OpensdkServlet.class);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("data", getAppInfoProto$GetAppinfoRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_app_info");
        if (j16 > 0) {
            newIntent.putExtra("timeout", j16);
        }
        newIntent.setObserver(dVar);
        appRuntime.startServlet(newIntent);
    }

    private HashMap<String, String> q(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                for (String str2 : parse.getQueryParameterNames()) {
                    if (!TextUtils.isEmpty(str2)) {
                        String queryParameter = parse.getQueryParameter(str2);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            hashMap.put(str2, queryParameter);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.ark.d.d(E0, String.format("getArkInfo, parse param failed, err=%s", e16.getMessage()));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public String s(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            AppRuntime appRuntime = this.f97444c0;
            if (appRuntime == null) {
                QLog.e("shareWebPage", 1, "getPsKeySync but runtime is null.");
                return "";
            }
            Object obj = new Object();
            String[] strArr = {null};
            ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{str2}, new b(strArr, str2, obj));
            if (strArr[0] == null) {
                synchronized (obj) {
                    try {
                        obj.wait(5000L);
                    } finally {
                    }
                }
            }
            String str3 = strArr[0];
            if (str3 != null) {
                return str3;
            }
            return "";
        }
        return "";
    }

    private String t(String str, String str2, String str3) {
        if (G(str)) {
            return str;
        }
        if (G(str2)) {
            return str2;
        }
        if (G(str3)) {
            return str3;
        }
        return str;
    }

    public String A() {
        return this.D;
    }

    public String B() {
        return this.f97452h;
    }

    public int C() {
        return this.f97453h0;
    }

    public String D() {
        return this.H;
    }

    public boolean E(String str, int i3, boolean z16) {
        String str2;
        int i16;
        if (TextUtils.isEmpty(str)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169960a5);
            return false;
        }
        com.tencent.open.agent.report.f fVar = this.M;
        if (fVar.f340536a) {
            fVar.f340538c = com.tencent.open.agent.report.e.a(i3);
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "90");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            if (this.M.f340537b == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            sb5.append(i16);
            bundle.putString("intext_1", sb5.toString());
            bundle.putString("intext_3", "" + this.M.f340538c);
            bundle.putString("intext_2", "" + this.M.f340537b);
            bundle.putString("stringext_1", "" + str);
            ReportCenter.f().l(bundle, "", this.f97444c0.getAccount(), false);
            this.M.f340536a = false;
        }
        if (!NetworkUtil.isNetSupport(this.U)) {
            if (QLog.isColorLevel()) {
                QLog.d(E0, 2, "getSummary Fail_Network. title=" + this.f97452h + ", desc=" + this.C + ", thumb=" + this.D);
            }
            com.tencent.biz.qrcode.util.h.T(1, R.string.f171139ci4);
            Bundle bundle2 = new Bundle();
            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle2.putString("act_type", "84");
            bundle2.putString("intext_1", "" + com.tencent.open.agent.report.e.b(1));
            bundle2.putString("intext_3", "1");
            bundle2.putString("intext_4", "0");
            ReportCenter.f().l(bundle2, "", this.f97444c0.getAccount(), false);
            return false;
        }
        F0 = false;
        if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(str).find()) {
            F0 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("share_tool_trace", 2, "url is " + str);
            QLog.d("share_tool_trace", 2, "readInjoy JS work=" + F0);
        }
        if (!TextUtils.isEmpty(this.f97452h) && this.f97452h.length() > 30) {
            this.f97452h = this.f97452h.substring(0, 29);
        }
        if (!TextUtils.isEmpty(this.C) && (str2 = this.C) != null && str2.length() > 40) {
            this.C = this.C.substring(0, 39);
        }
        if (!TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(this.f97452h) && !TextUtils.isEmpty(this.C)) {
            i(str, i3, z16);
            return true;
        }
        ThreadManagerV2.executeOnNetWorkThread(new AnonymousClass1(str, i3, z16));
        return true;
    }

    void I() {
        WebViewFragment currentWebViewFragment;
        long longExtra = this.U.getIntent().getLongExtra(AppConstants.Key.SHARE_REQ_APP_ID, 146L);
        this.f97442a0 = longExtra;
        if (longExtra > 0) {
            ImageView imageView = (ImageView) this.U.findViewById(R.id.dzl);
            this.Z = imageView;
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(this);
            View findViewById = this.U.findViewById(R.id.dzm);
            this.Y = findViewById;
            findViewById.setOnClickListener(this);
            o(this.f97444c0, this.U, this.f97446d0, com.tencent.mobileqq.utils.h.f(this.f97442a0), 0L, this.C0);
            LinearLayout linearLayout = new LinearLayout(this.f97462o0);
            this.f97455i0 = linearLayout;
            linearLayout.setBackgroundColor(this.f97462o0.getResources().getColor(R.color.f156747an));
            this.f97455i0.setOrientation(0);
            this.f97455i0.setVisibility(8);
            ImageView imageView2 = new ImageView(this.f97462o0);
            this.f97457k0 = imageView2;
            imageView2.setImageResource(R.drawable.dap);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) ba.dp2px(this.f97462o0, 19.0f), (int) ba.dp2px(this.f97462o0, 19.0f));
            this.f97456j0 = new LinearLayout(this.f97462o0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            this.f97456j0.setPadding((int) ba.dp2px(this.f97462o0, 10.0f), 0, (int) ba.dp2px(this.f97462o0, 10.0f), 0);
            this.f97456j0.setOnClickListener(this);
            this.f97456j0.addView(this.f97457k0, layoutParams);
            this.f97455i0.addView(this.f97456j0, layoutParams2);
            ImageView imageView3 = new ImageView(this.f97462o0);
            this.f97458l0 = imageView3;
            imageView3.setImageResource(R.drawable.ic_launcher);
            this.f97455i0.addView(this.f97458l0, new LinearLayout.LayoutParams((int) ba.dp2px(this.f97462o0, 30.0f), (int) ba.dp2px(this.f97462o0, 30.0f)));
            TextView textView = new TextView(this.f97462o0);
            this.f97460m0 = textView;
            textView.setPadding((int) ba.dp2px(this.f97462o0, 8.0f), 0, (int) ba.dp2px(this.f97462o0, 8.0f), 0);
            this.f97460m0.setSingleLine(true);
            this.f97460m0.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.weight = 1.0f;
            this.f97460m0.setText(R.string.p_);
            this.f97460m0.setTextSize(2, 13.75f);
            this.f97460m0.setGravity(16);
            this.f97460m0.setTextColor(this.f97462o0.getResources().getColor(R.color.f156748ao));
            this.f97455i0.addView(this.f97460m0, layoutParams3);
            TextView textView2 = new TextView(this.f97462o0);
            this.f97461n0 = textView2;
            textView2.setTextSize(2, 14.75f);
            this.f97461n0.setOnClickListener(this);
            this.f97461n0.setBackgroundResource(R.drawable.f161275tl);
            this.f97461n0.setGravity(17);
            this.f97461n0.setTextColor(this.f97462o0.getResources().getColor(R.color.f156748ao));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((int) ba.dp2px(this.f97462o0, 56.0f), (int) ba.dp2px(this.f97462o0, 30.0f));
            layoutParams4.rightMargin = (int) ba.dp2px(this.f97462o0, 10.0f);
            this.f97455i0.addView(this.f97461n0, layoutParams4);
            this.f97455i0.setGravity(16);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, (int) ba.dp2px(this.f97462o0, 44.0f));
            layoutParams5.gravity = 80;
            layoutParams5.bottomMargin = (int) ba.dp2px(this.f97462o0, 50.0f);
            ComponentCallbacks2 componentCallbacks2 = this.U;
            if ((componentCallbacks2 instanceof com.tencent.mobileqq.webview.swift.u) && (currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) componentCallbacks2).getCurrentWebViewFragment()) != null && currentWebViewFragment.getUIStyleHandler().W != null) {
                currentWebViewFragment.getUIStyleHandler().W.addView(this.f97455i0, layoutParams5);
            }
        }
    }

    public boolean J() {
        return this.G;
    }

    public boolean K() {
        return this.E;
    }

    public void N(int i3, int i16) {
        if (this.W != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", i3);
                jSONObject.put("fontScale", i16);
                if (QLog.isColorLevel()) {
                    QLog.d(E0, 2, "QQWebviewSetFontSize: " + jSONObject.toString());
                }
                this.W.callJs(WebViewPlugin.toJsScript("QQWebviewSetFontSize", jSONObject, null));
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(E0, 2, "QQWebviewSetFontSize jason error");
                }
            }
        }
    }

    public void O() {
        String str = this.f97463p0;
        if (str != null) {
            this.W.callJs(str, "9");
        }
    }

    public void P() {
        String str = this.f97463p0;
        if (str != null) {
            this.W.callJs(str, "8");
        }
    }

    public void R(String str, int i3, boolean z16) {
        String str2;
        if (i3 == 1) {
            str2 = "0";
        } else if (i3 == 2) {
            str2 = "1";
        } else if (i3 == 3) {
            str2 = "2";
        } else if (i3 == 4) {
            str2 = "3";
        } else if (i3 == 8) {
            str2 = "4";
        } else if (i3 == 6) {
            str2 = "5";
        } else if (i3 == 7) {
            str2 = "6";
        } else {
            str2 = "-1";
        }
        if (i3 == 11) {
            str2 = "11";
        }
        e0(i3);
        if (!z16) {
            getSharePD().show();
        }
        CustomWebView customWebView = this.W;
        if (customWebView != null) {
            customWebView.callJs(this.f97463p0, str2);
        } else {
            QLog.w(E0, 1, "notifyOnShare webview is null");
        }
    }

    public void S() {
        String str = this.f97463p0;
        if (str != null) {
            this.W.callJs(str, "7");
        }
    }

    public void T() {
        String str = this.f97465r0;
        if (str != null) {
            CustomWebView customWebView = this.W;
            if (customWebView == null) {
                QLog.w("shareWebPage", 1, "notifyOnShareQQFriend webview is null");
            } else {
                customWebView.callJs(str, "0");
            }
        }
    }

    public void U(int i3, String str, String str2) {
        if (this.f97466s0 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("targetUinType", i3);
                jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, str);
                jSONObject.put("targetNickname", str2);
            } catch (JSONException e16) {
                QLog.e(E0, 1, "notifyOnShareQQSpecifiedFriend process data error!", e16);
            }
            CustomWebView customWebView = this.W;
            if (customWebView == null) {
                QLog.w("shareWebPage", 1, "notifyOnShareQQSpecifiedFriend webview is null");
            } else {
                customWebView.callJs(this.f97466s0, jSONObject.toString());
            }
        }
    }

    public void V() {
        String str = this.f97467t0;
        if (str != null) {
            this.W.callJs(str, "1");
        }
    }

    public void W() {
        String str = this.f97468u0;
        if (str != null) {
            this.W.callJs(str, "2");
        }
    }

    public void X() {
        String str = this.f97469v0;
        if (str != null) {
            this.W.callJs(str, "3");
        }
    }

    public void b0(String str) {
        this.f97463p0 = str;
    }

    public void c0(com.tencent.mobileqq.Doraemon.a aVar) {
        this.f97464q0 = aVar;
    }

    public void d0(com.tencent.mobileqq.teamwork.o oVar) {
        this.f97471x0 = oVar;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void destroy() {
        Handler handler = this.D0;
        if (handler != null) {
            handler.removeMessages(1001);
            this.D0.removeMessages(1002);
        }
        if (this.f97448e0 != null) {
            WXShareHelper.b0().q0(this.f97448e0);
            this.f97448e0 = null;
        }
    }

    public void e0(int i3) {
        this.f97453h0 = i3;
    }

    public boolean f0() {
        String str;
        String str2;
        if (this.V == null) {
            this.V = this.U;
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        if (TextUtils.isEmpty(this.f97452h)) {
            str = null;
        } else {
            str = this.f97452h;
        }
        qZoneShareData.mTitle = str;
        if (TextUtils.isEmpty(this.C)) {
            str2 = null;
        } else {
            str2 = this.C;
        }
        qZoneShareData.mSummary = str2;
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(this.D);
        qZoneShareData.mImageUrls = arrayList;
        qZoneShareData.targetUrl = getShareUrl();
        int i3 = this.S;
        if (i3 != -1) {
            qZoneShareData.iUrlInfoFrm = i3;
        }
        qZoneShareData.mShareBeginTime = SwiftBrowserShareMenuHandler.f314290n0;
        qZoneShareData.from = 2;
        CustomWebView customWebView = this.W;
        if (customWebView != null) {
            qZoneShareData.mWebUrl = customWebView.getUrl();
        }
        AppRuntime appRuntime = this.f97444c0;
        if (appRuntime != null) {
            QZoneShareManager.shareToQzone(this.V, appRuntime.getCurrentAccountUin(), qZoneShareData, null, -1);
        } else {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169964ab);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #2 {Exception -> 0x0165, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0015, B:11:0x002e, B:14:0x0034, B:16:0x003b, B:18:0x0041, B:22:0x005c, B:25:0x0065, B:28:0x006a, B:29:0x007e, B:31:0x008c, B:33:0x0092, B:36:0x009b, B:38:0x00a1, B:41:0x00a8, B:43:0x00c8, B:45:0x00ce, B:48:0x00d7, B:50:0x00e5, B:52:0x00eb, B:55:0x00f4, B:57:0x00fd, B:59:0x0106, B:61:0x010f, B:63:0x011f, B:65:0x0125, B:67:0x012b, B:70:0x0138, B:72:0x013e, B:82:0x0073, B:84:0x0079, B:86:0x0144, B:88:0x014a), top: B:2:0x0007, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8 A[Catch: Exception -> 0x0165, TryCatch #2 {Exception -> 0x0165, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0015, B:11:0x002e, B:14:0x0034, B:16:0x003b, B:18:0x0041, B:22:0x005c, B:25:0x0065, B:28:0x006a, B:29:0x007e, B:31:0x008c, B:33:0x0092, B:36:0x009b, B:38:0x00a1, B:41:0x00a8, B:43:0x00c8, B:45:0x00ce, B:48:0x00d7, B:50:0x00e5, B:52:0x00eb, B:55:0x00f4, B:57:0x00fd, B:59:0x0106, B:61:0x010f, B:63:0x011f, B:65:0x0125, B:67:0x012b, B:70:0x0138, B:72:0x013e, B:82:0x0073, B:84:0x0079, B:86:0x0144, B:88:0x014a), top: B:2:0x0007, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void g(Context context, GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse) {
        Bitmap bitmap;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
            }
        }
        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0) {
            this.f97443b0 = getAppInfoProto$GetAppinfoResponse;
            String k3 = k(getAppInfoProto$GetAppinfoResponse.iconsURL, 64);
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo = this.f97443b0.androidInfo;
            if (!TextUtils.isEmpty(k3) && getAppInfoProto$AndroidInfo != null && getAppInfoProto$AndroidInfo.packName != null) {
                byte[] openUrlForByte = HttpUtil.openUrlForByte(context, k3, "GET", null, null);
                if (openUrlForByte == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e(E0, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + k3 + ", imageBytes is NULL!!!!!!!!");
                        return;
                    }
                    return;
                }
                Message obtainMessage = this.D0.obtainMessage(1002);
                try {
                    bitmap = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length);
                    try {
                        obtainMessage.obj = bitmap;
                        this.D0.sendMessage(obtainMessage);
                    } catch (OutOfMemoryError unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(E0, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
                        }
                        if (!PackageUtil.isAppInstalled(context, getAppInfoProto$AndroidInfo.packName.get())) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (OutOfMemoryError unused2) {
                    bitmap = null;
                }
                if (!PackageUtil.isAppInstalled(context, getAppInfoProto$AndroidInfo.packName.get())) {
                    Message obtainMessage2 = this.D0.obtainMessage(1001);
                    try {
                        obtainMessage2.obj = bitmap;
                        this.D0.sendMessage(obtainMessage2);
                        return;
                    } catch (OutOfMemoryError unused3) {
                        if (QLog.isColorLevel()) {
                            QLog.e(E0, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
                            return;
                        }
                        return;
                    }
                }
                String openUrl = HttpUtil.openUrl(context, String.format("https://openmobile.qq.com/api/get_app_info_by_id?appid=%d", Long.valueOf(com.tencent.mobileqq.utils.h.f(this.f97442a0))), "GET", null, null);
                if (TextUtils.isEmpty(openUrl)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(E0, 2, "QQBrowserActivity urlResponse is null");
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(openUrl);
                if (jSONObject3.getInt("retcode") != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(E0, 2, "QQBrowserActivity retcode is -1");
                        return;
                    }
                    return;
                }
                JSONObject jSONObject4 = jSONObject3.getJSONObject("result");
                if (jSONObject4 != null && (jSONObject = jSONObject4.getJSONObject(DeviceType.DeviceCategory.MOBILE)) != null && (jSONObject2 = jSONObject.getJSONObject("android")) != null) {
                    String string = jSONObject2.getString("yyb_url");
                    if (jSONObject2.getInt("AppState") == 1 && !TextUtils.isEmpty(string)) {
                        Message obtainMessage3 = this.D0.obtainMessage(1001);
                        try {
                            obtainMessage3.obj = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length);
                            this.D0.sendMessage(obtainMessage3);
                            return;
                        } catch (OutOfMemoryError unused4) {
                            if (QLog.isColorLevel()) {
                                QLog.e(E0, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
                if (QLog.isColorLevel()) {
                    QLog.d(E0, 2, e16.getMessage());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e(E0, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + k3 + ", androidInfo is null, OR androidInfo.packName is null !!!");
            }
        }
    }

    public boolean g0(Intent intent) {
        boolean a06 = a0(intent);
        boolean Z = Z(intent);
        QLog.d(E0, 1, "ShareArkFromH5 shouldShareArkMsgToQQ bShareArkOpenApp=", Boolean.valueOf(a06), ", bShareArkFromNormal=", Boolean.valueOf(Z), " ,isShareArk=", Boolean.valueOf(this.f97472y0));
        if ((!this.f97472y0 || !a06) && !Z) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public QQProgressDialog getSharePD() {
        com.tencent.mobileqq.webview.swift.y yVar;
        int i3;
        Activity activity;
        if (this.X == null) {
            WeakReference<com.tencent.mobileqq.webview.swift.y> weakReference = this.f97473z0;
            if (weakReference != null) {
                yVar = weakReference.get();
            } else {
                yVar = null;
            }
            if ((yVar instanceof com.tencent.mobileqq.webviewplugin.s) && (activity = this.U) != null && !activity.isFinishing()) {
                i3 = ((com.tencent.mobileqq.webviewplugin.s) yVar).getWebTitleBarInterface().getTitleBarHeight();
            } else {
                Activity activity2 = this.U;
                if (activity2 != null) {
                    i3 = activity2.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                } else {
                    i3 = (int) ((this.f97451g0 * 50.0f) + 0.5f);
                    QLog.e(E0, 1, "use default yOffset when getting share progress dialog.");
                }
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.U, i3);
            this.X = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.f169961a6);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(E0, 2, "dialog show time :" + currentTimeMillis);
            }
        }
        return this.X;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public String getShareUrl() {
        String str;
        com.tencent.mobileqq.webview.swift.y yVar;
        if (!TextUtils.isEmpty(this.f97445d)) {
            str = this.f97445d;
        } else {
            WeakReference<com.tencent.mobileqq.webview.swift.y> weakReference = this.f97473z0;
            if (weakReference == null || (yVar = weakReference.get()) == null || !(yVar instanceof com.tencent.mobileqq.webviewplugin.r)) {
                str = "";
            } else {
                str = ((com.tencent.mobileqq.webviewplugin.r) yVar).getCurrentUrl();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.tencent.biz.common.util.k.g(str, new String[0]);
    }

    public void j(int i3, int i16, int i17, boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("policy", i3);
            jSONObject.put("result", z16);
            jSONObject.put("shareSource", i17);
            jSONObject.put("prePolicy", i16);
            final String jsScript = WebViewPlugin.toJsScript("didFinishShare", jSONObject, null);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.W.callJs(jsScript);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Share.this.W.callJs(jsScript);
                    }
                });
            }
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(E0, 2, "share finished jason error");
            }
        }
        if (i17 == 1) {
            if ((i16 == 0 || i16 == 1) && this.f97471x0 != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Share share = Share.this;
                        TeamWorkHandlerUtils.r(share.f97446d0, share.f97471x0);
                    }
                }, 128, null, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
        String str;
        LinearLayout linearLayout;
        EventCollector.getInstance().onViewClickedBefore(view);
        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = this.f97443b0;
        if (getAppInfoProto$GetAppinfoResponse != null && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null) {
            if (view != this.Z && view != this.Y) {
                if (view == this.f97461n0) {
                    if (PackageUtil.isAppInstalled(this.U, getAppInfoProto$AndroidInfo.packName.get())) {
                        PackageUtil.startAppWithPkgName(this.U, getAppInfoProto$AndroidInfo.packName.get(), null);
                        com.tencent.open.business.viareport.c.a().e(this.f97446d0, String.valueOf(com.tencent.mobileqq.utils.h.f(this.f97442a0)), "ANDROIDQQ.SHAREBAR", ThemeReporter.FROM_WEEKLOOP, false);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", this.f97446d0);
                        bundle.putString("sid", this.U.getIntent().getStringExtra("vkey"));
                        bundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
                        bundle.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, true);
                        bundle.putString("packageName", getAppInfoProto$AndroidInfo.packName.get());
                        bundle.putString("appId", String.valueOf(com.tencent.mobileqq.utils.h.f(this.f97442a0)));
                        AppClient.l(this.U, bundle);
                        com.tencent.open.business.viareport.c.a().e(this.f97446d0, String.valueOf(com.tencent.mobileqq.utils.h.f(this.f97442a0)), "ANDROIDQQ.SHAREBAR", ThemeReporter.FROM_NIGHT, false);
                    }
                    LinearLayout linearLayout2 = this.f97455i0;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                } else if (view == this.f97456j0 && (linearLayout = this.f97455i0) != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                if (PackageUtil.isAppInstalled(this.U, getAppInfoProto$AndroidInfo.packName.get())) {
                    PackageUtil.startAppWithPkgName(this.U, getAppInfoProto$AndroidInfo.packName.get(), null);
                    str = TencentLocation.RUN_MODE;
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("uin", this.f97446d0);
                    bundle2.putString("sid", this.U.getIntent().getStringExtra("vkey"));
                    bundle2.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
                    bundle2.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, true);
                    bundle2.putString("packageName", getAppInfoProto$AndroidInfo.packName.get());
                    AppClient.j(this.U, String.valueOf(com.tencent.mobileqq.utils.h.f(this.f97442a0)), 2470, bundle2);
                    str = ColorRingJsPlugin.Method_SetUp;
                }
                com.tencent.biz.common.util.k.i(null, "", "webviewsourceclick", com.tencent.mobileqq.utils.h.f(this.f97442a0), 0L, str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.webviewplugin.i
    public void onRuntimeUpdate(AppRuntime appRuntime) {
        this.f97444c0 = appRuntime;
        this.f97446d0 = appRuntime.getAccount();
        QLog.d(E0, 1, "onRuntimeUpdate runtime:" + appRuntime);
    }

    public int r() {
        return this.F;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void reset() {
        this.f97445d = null;
        this.f97452h = null;
        this.f97454i = null;
        this.f97459m = null;
        this.C = null;
        this.D = null;
        this.P = null;
        this.Q = null;
        this.f97463p0 = null;
        this.f97464q0 = null;
        this.f97465r0 = null;
        this.f97466s0 = null;
        this.f97467t0 = null;
        this.f97468u0 = null;
        this.f97469v0 = null;
        this.E = false;
        this.F = -1;
        this.H = null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setShareUrl(String str) {
        if (this.W == null) {
            return false;
        }
        String trim = str.trim();
        String url = this.W.getUrl();
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(trim)) {
            Uri parse = Uri.parse(url);
            Uri parse2 = Uri.parse(trim);
            if (!parse.isOpaque() && !parse2.isOpaque() && parse.getScheme().equals(parse2.getScheme()) && parse.getHost().equals(parse2.getHost())) {
                this.f97445d = trim;
                this.T = null;
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle) {
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment;
        if (!TextUtils.isEmpty(str3) && !setShareUrl(str3)) {
            QLog.w(E0, 1, "setSummary shareUrl not valid return. url:" + com.tencent.biz.common.util.k.f(str3, new String[0]));
            return false;
        }
        this.f97452h = str;
        this.C = str2;
        this.D = str4;
        if (str4 != null && str4.startsWith("//")) {
            this.D = "http:" + this.D;
        }
        this.K = true;
        if (bundle != null && bundle.getInt("extra_url_info_from") == 1) {
            if (QLog.isColorLevel()) {
                QLog.e("shareWebPage", 2, "Share info after JS capture: title=" + this.f97452h + ", summary=" + this.C + ", thumb=" + this.D + ", shareURL=" + str3);
            }
            com.tencent.open.agent.report.f fVar = this.M;
            fVar.f340536a = true;
            fVar.f340537b = 0;
            if (TextUtils.isEmpty(str4)) {
                this.M.f340537b |= 1;
            } else {
                this.L = 2;
            }
            if (TextUtils.isEmpty(str2)) {
                this.M.f340537b |= 2;
            }
            if (TextUtils.isEmpty(str)) {
                this.M.f340537b |= 4;
            }
        }
        this.T = null;
        if (bundle != null) {
            try {
                QLog.d(E0, 1, "setSummary need parse extraData");
                this.f97454i = bundle.getString("type");
                this.f97459m = bundle.getString("miniprogram_image_url");
                this.S = bundle.getInt("extra_url_info_from", -1);
                this.N = bundle.getString("cover_url");
                this.P = bundle.getString("source_name");
                this.Q = bundle.getString("source_icon");
                this.R = Integer.parseInt(bundle.getString(AppConstants.Key.SHARE_REQ_ARTICLE_ID));
            } catch (NumberFormatException unused) {
                QLog.w(E0, 1, "setSummary extraData parse articleId exception");
                this.R = -1;
            } catch (Exception unused2) {
                QLog.w(E0, 1, "setSummary extraData parse unknown exception");
            }
            this.E = bundle.getBoolean("editable");
            this.G = bundle.getBoolean("isCreator");
            if (!this.J) {
                this.J = bundle.getBoolean("isNewCreate");
            }
            try {
                this.H = bundle.getString("singleLineTitle");
            } catch (Exception unused3) {
                this.H = null;
                QLog.w(E0, 1, "setSummary extraData parse singleLineTitle exception");
            }
            try {
                this.F = Integer.parseInt(bundle.getString("policy"));
            } catch (Exception unused4) {
                this.F = -1;
            }
            this.I = bundle.getBoolean("contentEdited");
            Activity activity = this.U;
            if (activity != null && (activity instanceof TeamWorkDocEditBrowserActivity) && (teamWorkDocEditBrowserFragment = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) activity).getCurrentWebViewFragment()) != null) {
                teamWorkDocEditBrowserFragment.ri(this.E, this.F);
                teamWorkDocEditBrowserFragment.oi(this.J);
                teamWorkDocEditBrowserFragment.xi();
                teamWorkDocEditBrowserFragment.si(true, this.H, null);
                if (this.I) {
                    teamWorkDocEditBrowserFragment.di();
                }
            }
        }
        LocalMultiProcConfig.putString("msharetitle", this.f97452h);
        LocalMultiProcConfig.putString("msharedesc", this.C);
        LocalMultiProcConfig.putString("msharethumb", this.D);
        LocalMultiProcConfig.putString("mshareurl", str3);
        LocalMultiProcConfig.putInt("msharefrom", this.S);
        CustomWebView customWebView = this.W;
        if (customWebView != null) {
            LocalMultiProcConfig.putString("msharecururl", customWebView.getUrl());
        }
        Intent intent = new Intent("com.tencent.qq.shareupdate");
        Activity activity2 = this.U;
        if (activity2 != null) {
            activity2.sendBroadcast(intent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean shareStructMsgForH5(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, String str8) {
        final boolean z16;
        boolean z17;
        int i3;
        if (!NetworkUtil.isNetSupport(this.U)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f171139ci4);
            return false;
        }
        if (TextUtils.isEmpty(str4)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.f169960a5);
            return false;
        }
        if (this.X == null) {
            com.tencent.mobileqq.webview.swift.y yVar = this.f97473z0.get();
            if (yVar != null && (yVar instanceof com.tencent.mobileqq.webviewplugin.s)) {
                i3 = ((com.tencent.mobileqq.webviewplugin.s) yVar).getWebTitleBarInterface().getTitleBarHeight();
            } else {
                i3 = 0;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.U, i3);
            this.X = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.f169961a6);
        }
        if (str4.length() > 180) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (str5 != null && str5.length() > 40) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            ShareMsgHelper.d(this.U, 1001, 146, "struct_msg_from_h5", str, str5, str2, str3, String.format(this.U.getResources().getString(R.string.f171308dy0), str2), str4, "web", null, null, null, "plugin", null, String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, str), String.format(IPublicAccountBrowser.SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL, str), IPublicAccountBrowser.SHARE_SRC_ICON, str6, null);
            boolean isEmpty = TextUtils.isEmpty(str5);
            boolean z18 = isEmpty;
            if (TextUtils.isEmpty(str3)) {
                z18 = (isEmpty ? 1 : 0) | 2;
            }
            int i16 = z18;
            if (TextUtils.isEmpty(str2)) {
                i16 = (z18 ? 1 : 0) | 4;
            }
            Bundle bundle = new Bundle();
            bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle.putString("act_type", "14");
            bundle.putString("intext_3", "1");
            bundle.putString("intext_2", "" + i16);
            bundle.putString("stringext_1", "" + str4);
            ReportCenter.f().l(bundle, "", this.f97444c0.getAccount(), false);
            return true;
        }
        this.X.show();
        new BaseThread() { // from class: com.tencent.biz.webviewplugin.Share.7
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                final String str9;
                HashMap hashMap = new HashMap();
                if (z16) {
                    hashMap.put("url", str5);
                }
                HashMap<String, String> shortenUrlBatch = HttpUtil.shortenUrlBatch(hashMap);
                if (z16) {
                    str9 = shortenUrlBatch.get("url");
                } else {
                    str9 = str5;
                }
                Share.this.U.runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.Share.7.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        String str10;
                        com.tencent.mobileqq.webview.swift.y yVar2 = Share.this.f97473z0.get();
                        if (yVar2 != null && (yVar2 instanceof com.tencent.mobileqq.webviewplugin.r) && ((com.tencent.mobileqq.webviewplugin.r) yVar2).isActivityResume() && !Share.this.U.isFinishing()) {
                            Share.this.H();
                            String format = String.format(IPublicAccountBrowser.SCHEME_ANDROID_PUBLIC_ACCOUNT_DETAIL, str);
                            String format2 = String.format(IPublicAccountBrowser.SCHEME_IOS_PUBLIC_ACCOUNT_DETAIL, str);
                            if (TextUtils.isEmpty(str9)) {
                                str10 = str5;
                            } else {
                                str10 = str9;
                            }
                            String format3 = String.format(Share.this.U.getResources().getString(R.string.f171308dy0), str2);
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            ShareMsgHelper.d(Share.this.U, 1001, 146, "struct_msg_from_h5", str, str10, str2, str3, format3, str4, "web", null, null, null, "plugin", null, format, format2, IPublicAccountBrowser.SHARE_SRC_ICON, str6, null);
                            boolean isEmpty2 = TextUtils.isEmpty(str10);
                            boolean z19 = isEmpty2;
                            if (TextUtils.isEmpty(str3)) {
                                z19 = (isEmpty2 ? 1 : 0) | 2;
                            }
                            int i17 = z19;
                            if (TextUtils.isEmpty(str2)) {
                                i17 = (z19 ? 1 : 0) | 4;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                            bundle2.putString("act_type", "14");
                            bundle2.putString("intext_3", "1");
                            bundle2.putString("intext_2", "" + i17);
                            bundle2.putString("stringext_1", "" + str4);
                            ReportCenter.f().l(bundle2, "", Share.this.f97444c0.getAccount(), false);
                        }
                    }
                });
            }
        }.start();
        return true;
    }

    public int u() {
        return this.R;
    }

    public String v() {
        return this.N;
    }

    public String x() {
        return this.C;
    }

    public com.tencent.mobileqq.teamwork.o y() {
        return this.f97471x0;
    }

    public String z() {
        return this.P;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.webviewplugin.n
    public <T> T getShare() {
        return this;
    }
}
