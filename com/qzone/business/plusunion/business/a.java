package com.qzone.business.plusunion.business;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_EXTRA.get_app_info_list;
import NS_MOBILE_EXTRA.s_app_info;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.plusunion.business.model.AppInfo;
import com.qzone.business.plusunion.business.protocol.QzoneGetAppListRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.al;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import n7.a;
import org.json.JSONObject;
import yo.d;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: i, reason: collision with root package name */
    private static final al<a, Void> f44626i = new C0357a();

    /* renamed from: d, reason: collision with root package name */
    private final b f44627d = new b("allListTableName", AppInfo.class);

    /* renamed from: e, reason: collision with root package name */
    private final b f44628e = new b("allListTableName", l5.a.class);

    /* renamed from: f, reason: collision with root package name */
    private boolean f44629f = false;

    /* renamed from: h, reason: collision with root package name */
    private long f44630h;

    /* compiled from: P */
    /* renamed from: com.qzone.business.plusunion.business.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0357a extends al<a, Void> {
        C0357a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f44631a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f44632b;

        /* renamed from: c, reason: collision with root package name */
        String f44633c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f44634d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f44635e = new C0358a();

        /* compiled from: P */
        /* renamed from: com.qzone.business.plusunion.business.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0358a implements a.InterfaceC10828a {
            C0358a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                b bVar = b.this;
                bVar.f44631a = 0L;
                bVar.f44632b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f44633c = str;
            this.f44634d = cls;
        }
    }

    private boolean c(String str) {
        return q(BaseApplication.getContext(), str);
    }

    public static a h() {
        return f44626i.get(null);
    }

    public static boolean q(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(String.format("tencent%s.data://", str)));
        return InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 0).size() != 0;
    }

    private static boolean r(int i3) {
        if ((i3 & 4) > 0) {
            return true;
        }
        return false;
    }

    private boolean v(Context context, String str) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(String.format("tencent%s.data://", str)));
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public AppInfo e(int i3) {
        AppInfo appInfo;
        ArrayList<AppInfo> f16 = f();
        if (f16 == null) {
            return null;
        }
        for (int i16 = 0; i16 < f16.size(); i16++) {
            if ((f16.get(i16) instanceof AppInfo) && (appInfo = f16.get(i16)) != null && appInfo.appid == i3) {
                return appInfo;
            }
        }
        return null;
    }

    public ArrayList<AppInfo> f() {
        ArrayList g06;
        synchronized (this.f44627d) {
            d(this.f44627d);
            g06 = this.f44627d.f44632b.g0();
        }
        return g06;
    }

    public void g(Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetAppListRequest(new HashMap(), 0), handler, this, 3841));
    }

    public void i(Handler handler, Map<String, String> map) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 100, 100, map, true), handler, this, 1000109));
    }

    public void j(Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2344, true), handler, this, 1000094));
    }

    public l5.a k() {
        synchronized (this.f44628e) {
            d(this.f44628e);
            ArrayList<? extends IDBCacheDataWrapper> g06 = this.f44628e.f44632b.g0();
            if (g06 == null || g06.isEmpty()) {
                return null;
            }
            return (l5.a) g06.get(0);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 3841) {
            l(qZoneTask);
            return;
        }
        if (i3 == 3842) {
            n(qZoneTask);
            return;
        }
        if (i3 == 1000094) {
            m(qZoneTask);
        } else if (i3 == 1000101) {
            o(qZoneTask);
        } else {
            if (i3 != 1000109) {
                return;
            }
            p(qZoneTask);
        }
    }

    public boolean s() {
        if (this.f44629f) {
            return true;
        }
        return u5.b.K(WadlProxyConsts.LAST_UPDATE_TIME, 0L, this.f44630h) + (((long) u5.b.H("OpAppListUpdateMin", 1440, this.f44630h)) * 60000) < System.currentTimeMillis();
    }

    public void t(Map<String, String> map) {
        EventCenter.getInstance().post("Qboss", 1, map);
    }

    public boolean x(Context context, AppInfo appInfo) {
        if (this.f44629f) {
            d.d("https://ttest.m.qzone.com/index.jsp?sid=AS28wvrmdvtIgQ9EnRqqbpBR&times=0&dir=chunxiao&env_imagecache=ttest&B_UID=615631840#funnypic?add=true", context, null);
            return true;
        }
        if (!URLUtil.isNetworkUrl(appInfo.h5_url)) {
            return false;
        }
        f.d(context, appInfo.h5_url, new boolean[0]);
        return true;
    }

    public void y() {
        synchronized (this.f44627d) {
            d(this.f44627d);
            ArrayList<? extends IDBCacheDataWrapper> g06 = this.f44627d.f44632b.g0();
            if (g06 == null) {
                return;
            }
            for (int i3 = 0; i3 < g06.size(); i3++) {
                if (g06.get(i3) instanceof AppInfo) {
                    AppInfo appInfo = (AppInfo) g06.get(i3);
                    if (appInfo.installTime == 0) {
                        appInfo.installTime = b(appInfo) ? System.currentTimeMillis() : 0L;
                    } else {
                        appInfo.installTime = b(appInfo) ? appInfo.installTime : 0L;
                    }
                }
            }
            this.f44627d.f44632b.p0(g06, 2);
        }
    }

    private void l(QZoneTask qZoneTask) {
        AppInfo createFrom;
        QZoneResult result = qZoneTask.getResult(3841);
        get_app_info_list get_app_info_listVar = (get_app_info_list) ((QzoneGetAppListRequest) qZoneTask.mRequest).rsp;
        ArrayList arrayList = new ArrayList();
        if (get_app_info_listVar != null) {
            ArrayList<s_app_info> arrayList2 = get_app_info_listVar.applist;
            if (arrayList2 != null) {
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    s_app_info s_app_infoVar = arrayList2.get(i3);
                    if (s_app_infoVar != null && (createFrom = AppInfo.createFrom(s_app_infoVar)) != null) {
                        arrayList.add(createFrom);
                    }
                }
                u5.b.u0(WadlProxyConsts.LAST_UPDATE_TIME, System.currentTimeMillis(), this.f44630h);
            }
        } else {
            result.setSucceed(false);
        }
        if (arrayList.size() > 0) {
            synchronized (this.f44627d) {
                d(this.f44627d);
                this.f44627d.f44632b.p0(arrayList, 2);
                ArrayList<? extends IDBCacheDataWrapper> g06 = this.f44627d.f44632b.g0();
                if (g06 == null) {
                    return;
                }
                for (int i16 = 0; i16 < g06.size(); i16++) {
                    if (g06.get(i16) instanceof AppInfo) {
                        AppInfo appInfo = (AppInfo) g06.get(i16);
                        if (appInfo.installTime == 0) {
                            appInfo.installTime = b(appInfo) ? System.currentTimeMillis() : 0L;
                        } else {
                            appInfo.installTime = b(appInfo) ? appInfo.installTime : 0L;
                        }
                    }
                }
                this.f44627d.f44632b.p0(g06, 2);
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    public void w(Context context, String str) throws Exception {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    private void d(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f44631a || (dbCacheManager = bVar.f44632b) == null || dbCacheManager.isClosed()) {
            DbCacheManager e16 = c.g().e(bVar.f44634d, uin, bVar.f44633c);
            bVar.f44632b = e16;
            e16.U(bVar.f44635e);
        }
    }

    private void m(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000094);
        if (result != null && result.getReturnCode() == 0) {
            MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) ((QzoneQBossAdvRequest) qZoneTask.mRequest).rsp;
            if (mobileQbossAdvRsp != null && mobileQbossAdvRsp.iRet == 0) {
                l5.a aVar = new l5.a();
                Map<Integer, ArrayList<tAdvDesc>> map = mobileQbossAdvRsp.mapAdv;
                if (map != null && !map.isEmpty()) {
                    ArrayList<tAdvDesc> value = mobileQbossAdvRsp.mapAdv.entrySet().iterator().next().getValue();
                    if (value != null && !value.isEmpty()) {
                        tAdvDesc tadvdesc = value.get(0);
                        try {
                            JSONObject jSONObject = new JSONObject(tadvdesc.res_data);
                            aVar.textShuoshuo = jSONObject.optString("text_shuoshuo");
                            aVar.textPhoto = jSONObject.optString("text_photo");
                            aVar.textVideo = jSONObject.optString("text_video");
                            aVar.cacheTime = Integer.valueOf(jSONObject.optString("cachtime")).intValue();
                            aVar.openBusiness = Integer.valueOf(jSONObject.optString("toolbar_other_showicon")).intValue();
                            aVar.businessURL = jSONObject.optString("toolbar-icon1-url");
                            aVar.imageUrl = jSONObject.optString("toolbar-icon1-pic");
                            aVar.openPhotoCarousel = jSONObject.optInt("lunbo");
                            Map<String, String> map2 = tadvdesc.adv_config_info;
                            if (map2 != null && !map2.isEmpty()) {
                                aVar.startTime = Long.valueOf(tadvdesc.adv_config_info.get("l_start_time")).longValue();
                                aVar.endTime = Long.valueOf(tadvdesc.adv_config_info.get("l_end_time")).longValue();
                            }
                        } catch (Exception e16) {
                            QZLog.e("QBossAdv", "parse tAdvDesc Json Error: ", e16);
                        }
                        d(this.f44628e);
                        this.f44628e.f44632b.o0(aVar, 2);
                        result.setData(aVar);
                        result.setSucceed(true);
                    }
                } else {
                    QZLog.w("QBossAdv", "resp.mapAdv map is null");
                    result.setSucceed(false);
                }
                qZoneTask.sendResultMsg(result);
                return;
            }
            QZLog.w("QBossAdv", "MobileQbossAdvRsp is null or ret!=0");
            return;
        }
        QZLog.w("QBossAdv", "handleGetQBossAdvInfo failed");
    }

    private void o(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000101);
        Object parameter = qZoneTask.getParameter("key_banner_struct");
        if (parameter != null && (parameter instanceof com.qzone.feed.business.model.a)) {
            com.qzone.feed.business.model.a aVar = (com.qzone.feed.business.model.a) parameter;
            if (result != null && result.getReturnCode() == 0) {
                MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) ((QzoneQBossAdvRequest) qZoneTask.mRequest).rsp;
                if (mobileQbossAdvRsp != null && mobileQbossAdvRsp.iRet == 0) {
                    Map<Integer, ArrayList<tAdvDesc>> map = mobileQbossAdvRsp.mapAdv;
                    if (map != null && !map.isEmpty()) {
                        ArrayList<tAdvDesc> value = mobileQbossAdvRsp.mapAdv.entrySet().iterator().next().getValue();
                        if (value != null && !value.isEmpty()) {
                            tAdvDesc tadvdesc = value.get(0);
                            if (tadvdesc != null) {
                                String str = tadvdesc.res_data;
                                String str2 = tadvdesc.res_traceinfo;
                                try {
                                    String optString = new JSONObject(str).optString("text");
                                    if (!TextUtils.isEmpty(optString)) {
                                        aVar.f47119c = optString;
                                        aVar.f47127k = str2;
                                        if (QZLog.isDevelopLevel()) {
                                            QZLog.d("QBossAdv", 4, "handleGetQBossPhotoGuideText | text:" + optString);
                                        }
                                    }
                                } catch (Exception e16) {
                                    QZLog.e("QBossAdv", "handleGetQBossPhotoGuideText | parse tAdvDesc Json Error: ", e16);
                                }
                                result.setSucceed(true);
                            } else {
                                result.setSucceed(false);
                            }
                        }
                    } else {
                        QZLog.w("QBossAdv", "handleGetQBossPhotoGuideText | resp.mapAdv map is null");
                        result.setSucceed(false);
                    }
                    result.setData(aVar);
                    qZoneTask.sendResultMsg(result);
                    return;
                }
                QZLog.w("QBossAdv", "handleGetQBossPhotoGuideText | MobileQbossAdvRsp is null or ret!=0");
                result.setData(aVar);
                result.setSucceed(false);
                qZoneTask.sendResultMsg(result);
                return;
            }
            QZLog.w("QBossAdv", "handleGetQBossPhotoGuideText failed");
            result.setData(aVar);
            result.setSucceed(false);
            qZoneTask.sendResultMsg(result);
            return;
        }
        QZLog.w("QBossAdv", "handleGetQBossPhotoGuideText failed");
        result.setSucceed(false);
        qZoneTask.sendResultMsg(result);
    }

    private void p(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000109);
        if (result != null && result.getReturnCode() == 0) {
            MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) ((QzoneQBossAdvRequest) qZoneTask.mRequest).rsp;
            if (mobileQbossAdvRsp != null && mobileQbossAdvRsp.iRet == 0) {
                Map<Integer, ArrayList<tAdvDesc>> map = mobileQbossAdvRsp.mapAdv;
                if (map != null && !map.isEmpty()) {
                    ArrayList<tAdvDesc> value = mobileQbossAdvRsp.mapAdv.entrySet().iterator().next().getValue();
                    if (value != null && !value.isEmpty()) {
                        String str = value.get(0).res_data;
                        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
                        try {
                            BusinessADBannerData businessADBannerData = new BusinessADBannerData();
                            JSONObject jSONObject = new JSONObject(str);
                            businessADBannerData.strPicUrl = jSONObject.optString("img");
                            businessADBannerData.strPicMD5 = jSONObject.optString("img_md5");
                            businessADBannerData.strJmpUrl = jSONObject.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                            businessADBannerData.hasCloseButton = true;
                            aVar.f47123g = businessADBannerData;
                            aVar.f47117a = 5;
                        } catch (Exception e16) {
                            QZLog.e("QBossAdv", "parse tAdvDesc Json Error: ", e16);
                        }
                        if (QZLog.isColorLevel()) {
                            QZLog.d("QBossAdv", 2, "handleGetQBossShuoShuoKeywordsAdv data:" + str);
                        }
                        result.setData(aVar);
                        result.setSucceed(true);
                    }
                } else {
                    QZLog.w("QBossAdv", "handleGetQBossShuoShuoKeywordsAdv resp.mapAdv map is null");
                    result.setSucceed(false);
                }
                qZoneTask.sendResultMsg(result);
                return;
            }
            QZLog.w("QBossAdv", "handleGetQBossShuoShuoKeywordsAdv MobileQbossAdvRsp is null or ret!=0");
            return;
        }
        QZLog.w("QBossAdv", "handleGetQBossShuoShuoKeywordsAdv failed");
    }

    public boolean b(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return this.f44629f ? appInfo.appid == 222222 : appInfo.appType != 11 || r(appInfo.maskAppType) || c(String.valueOf(appInfo.appid));
    }

    private void n(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        ArrayList<tAdvDesc> arrayList;
        tAdvDesc tadvdesc;
        String str;
        if (qZoneTask != null) {
            QZoneResult result = qZoneTask.getResult(1000104);
            if (result.getReturnCode() != 0) {
                return;
            }
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null && (arrayList = map.get(2393)) != null && arrayList.size() > 0 && (str = (tadvdesc = arrayList.get(0)).res_data) != null && !TextUtils.isEmpty(str.trim())) {
                com.qzone.feed.business.model.b bVar = new com.qzone.feed.business.model.b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    bVar.f47137a = jSONObject.optString("title");
                    bVar.f47138b = jSONObject.optString("msg");
                    bVar.f47139c = jSONObject.optString(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    bVar.f47140d = jSONObject.optString("cancel");
                    bVar.f47141e = jSONObject.optString("url");
                    bVar.f47142f = jSONObject.optString("picurl");
                    bVar.f47143g = tadvdesc.res_traceinfo;
                    result.setData(bVar);
                    qZoneTask.sendResultMsg(result);
                    return;
                } catch (Throwable th5) {
                    QZLog.w(th5);
                }
            }
            result.setSucceed(false);
            qZoneTask.sendResultMsg(result);
        }
    }

    public boolean u(Context context, AppInfo appInfo) {
        boolean v3;
        if (context == null || appInfo == null) {
            return false;
        }
        if ((appInfo.maskAppType & 4) > 0) {
            v3 = x(context, appInfo);
        } else {
            v3 = v(context, String.valueOf(appInfo.appid));
        }
        if (v3) {
            ClickReport.s(String.valueOf(appInfo.appid), appInfo.appname, "qzone3rdapp", 302, 8, 0);
        }
        return v3;
    }
}
