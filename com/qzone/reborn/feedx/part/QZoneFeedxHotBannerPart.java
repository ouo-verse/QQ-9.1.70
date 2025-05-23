package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.banner.SwipeOpeationBannerChild;
import com.qzone.component.banner.WebViewBanner;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.loginregister.impl.LoginFailedCommonSceneHandlerApiImpl;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes37.dex */
public class QZoneFeedxHotBannerPart extends g implements IObserver.main {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f54897h;

    /* renamed from: d, reason: collision with root package name */
    private gf.g f54898d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f54899e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.f f54900f;

    /* loaded from: classes37.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            QZoneFeedxHotBannerPart.this.f54898d.onScrollStateChanged(com.qzone.reborn.feedx.util.ah.a(recyclerView), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements IPrePullListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f54903a;

        b(String str) {
            this.f54903a = str;
        }

        @Override // com.tencent.mobileqq.mini.api.IPrePullListener
        public void onPrePullCallback(boolean z16, JSONObject jSONObject) {
            QZLog.i("QZoneFeedxHotBannerPart", "checkAndPreloadMiniApp,url:" + this.f54903a + ", isSuc: " + z16);
        }
    }

    private void N9(String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(str, false, new b(str));
    }

    private void O9(Map<Integer, String> map) {
        TTTReportManager.s().q(12, 203, 19, System.currentTimeMillis(), null, map, -1000, 0, true);
    }

    private int P9() {
        return this.f54899e.A2();
    }

    private void Q9(BusinessADBannerData businessADBannerData) {
        final QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
        qZoneCountInfo.uCount = 1L;
        qZoneCountInfo.iControl = 2;
        qZoneCountInfo.trace_info = businessADBannerData.strTraceInfo;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxHotBannerPart.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedAlertService.getInstance().setSingleUnReadItem(12, qZoneCountInfo);
            }
        });
        if (TextUtils.isEmpty(businessADBannerData.strTraceInfo)) {
            return;
        }
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(businessADBannerData.strTraceInfo, null);
    }

    private void T9(final Message message) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.part.af
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHotBannerPart.this.W9(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(com.qzone.feed.business.model.a aVar) {
        this.f54898d.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W9(Message message) {
        this.f54898d.j(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9(Integer num) {
        this.f54898d.f(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(String str, String str2, int i3, Map map) {
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 19;
        aVar.f47130n = str;
        aVar.f47127k = str2;
        aVar.f47131o = i3;
        aVar.f47132p = map;
        R9(aVar);
    }

    private void aa() {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(12);
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(48);
        if (this.f54899e.getMNeedRefresh()) {
            return;
        }
        this.f54898d.i(17);
        this.f54898d.a();
    }

    public void R9(final com.qzone.feed.business.model.a aVar) {
        runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.ae
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHotBannerPart.this.V9(aVar);
            }
        });
    }

    public void ba(final String str, final String str2, final int i3, final Map<Integer, String> map) {
        String str3;
        if (!CoverEnv.isBestPerformanceDevice()) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str2, null);
            if (map == null || map.size() == 0) {
                return;
            }
            O9(map);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QZLog.e("QZoneFeedxHotBannerPart", "showWebBanner dynBannerJsonData\u4e3a\u7a7a");
            return;
        }
        try {
            str3 = new JSONObject(str).optString("h5url");
        } catch (JSONException e16) {
            QZLog.e("QZoneFeedxHotBannerPart", 1, e16, "showWebBanner dynBannerJsonData illegal");
            str3 = null;
        }
        if (!HttpUtil.isValidUrl(str3)) {
            QZLog.e("QZoneFeedxHotBannerPart", 1, "h5url illegal, h5url=", str3);
            return;
        }
        if (WebViewBanner.E()) {
            CoverEnv.Webso.startWebSoRequestWithCheck(str3, null);
        }
        WebViewBanner.B(new IWebviewOnClassLoaded() { // from class: com.qzone.reborn.feedx.part.ah
            @Override // cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded
            public final void onLoadClassFinish() {
                QZoneFeedxHotBannerPart.this.Y9(str, str2, i3, map);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxHotBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        this.f54898d.l(f54897h);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.f54898d.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        gf.g gVar = this.f54898d;
        if (gVar != null) {
            gVar.d(configuration);
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event.what != 27) {
            return;
        }
        this.f54898d.g();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        int i3 = message.what;
        if (i3 != 1193) {
            if (i3 == 1000101 || i3 == 1000109) {
                R9(unpack != null ? (com.qzone.feed.business.model.a) unpack.getData() : null);
                return;
            }
            return;
        }
        Message message2 = new Message();
        message2.arg1 = P9();
        message2.what = QzoneCoverConst.MSG_SET_SUPER_COVER;
        T9(message2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f54898d = (gf.g) getIocInterface(gf.g.class);
        com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        this.f54899e = qVar;
        qVar.F2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxHotBannerPart.this.S9((ArrayList) obj);
            }
        });
        com.qzone.reborn.feedx.viewmodel.f fVar = (com.qzone.reborn.feedx.viewmodel.f) getViewModel(com.qzone.reborn.feedx.viewmodel.f.class);
        this.f54900f = fVar;
        fVar.M1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxHotBannerPart.this.X9((Integer) obj);
            }
        });
        ((com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).N1(new a());
        EventCenter.getInstance().addUIObserver(this, "Feed", 27);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f54898d.c();
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.f54898d.onPause();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f54898d.h();
        this.f54898d.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M9, reason: merged with bridge method [inline-methods] */
    public void U9(com.qzone.feed.business.model.a aVar) {
        try {
            ArrayList<SwipeOpeationBannerChild.i> a16 = SwipeOpeationBannerChild.i.a(aVar.f47123g.dynBannerJsonData);
            int min = Math.min(a16.size(), 10);
            for (int i3 = 0; i3 < min; i3++) {
                String str = a16.get(i3).f46542o;
                if (str.contains(LoginFailedCommonSceneHandlerApiImpl.KEY_MINIAPP_PREFIX)) {
                    N9(str);
                }
            }
        } catch (Throwable th5) {
            QLog.d(getTAG(), 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(ArrayList<BusinessADBannerData> arrayList) {
        f54897h = false;
        if (arrayList != null && arrayList.size() > 0) {
            Z9(arrayList);
        } else {
            aa();
        }
    }

    private void Z9(ArrayList<BusinessADBannerData> arrayList) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.qzone.feed.business.model.a K9 = K9(arrayList.get(i3));
            if (K9 != null) {
                R9(K9);
                L9(K9);
            }
        }
    }

    private void L9(final com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        if (aVar == null || aVar.f47117a != 21 || (businessADBannerData = aVar.f47123g) == null || businessADBannerData.dynBannerJsonData == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.ag
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxHotBannerPart.this.U9(aVar);
            }
        });
    }

    private com.qzone.feed.business.model.a K9(BusinessADBannerData businessADBannerData) {
        if (businessADBannerData == null) {
            return null;
        }
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47123g = businessADBannerData;
        aVar.f47132p = businessADBannerData.newRepoertInfoList;
        aVar.f47124h = P9();
        QLog.d(QZLog.TO_DEVICE_TAG, 1, "onFeedSubsidiaryRefreshFinish: banner data type is " + businessADBannerData.eAdType);
        int i3 = businessADBannerData.eAdType;
        if (i3 == 0) {
            aVar.f47117a = 5;
            f54897h = true;
        } else {
            if (i3 == 4) {
                return null;
            }
            if (i3 != 12) {
                switch (i3) {
                    case 8:
                        aVar.f47117a = 18;
                        aVar.f47124h = P9();
                        f54897h = true;
                        break;
                    case 9:
                        Q9(businessADBannerData);
                        return null;
                    case 10:
                        ba(businessADBannerData.dynBannerJsonData, businessADBannerData.strTraceInfo, businessADBannerData.patternId, businessADBannerData.newRepoertInfoList);
                        return null;
                    default:
                        switch (i3) {
                            case 17:
                                if (com.qzone.component.banner.a.b(businessADBannerData)) {
                                    aVar.f47117a = 26;
                                }
                                aVar.f47124h = P9();
                                aVar.f47131o = businessADBannerData.patternId;
                                f54897h = true;
                                break;
                            case 18:
                                aVar.f47117a = 28;
                                break;
                            case 19:
                                aVar.f47117a = 29;
                                break;
                            case 20:
                                aVar.f47117a = 30;
                                break;
                            case 21:
                                aVar.f47117a = 31;
                                break;
                        }
                }
            } else {
                aVar.f47117a = 21;
            }
        }
        return aVar;
    }
}
