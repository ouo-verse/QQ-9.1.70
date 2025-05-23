package com.qzone.proxy.personalitycomponent.manager;

import NS_MOBILE_COMM.yellow_info;
import NS_MOBILE_WIDGET.ConstellationWidgetInfo;
import NS_MOBILE_WIDGET.FlowerWidgetInfo;
import NS_MOBILE_WIDGET.GetWidgetRsp;
import NS_MOBILE_WIDGET.LunarWidgetInfo;
import NS_MOBILE_WIDGET.VisitorWidgetInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.qq.taf.jce.JceInputStream;
import com.qzone.business.lbsv2.business.e;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.a;
import com.qzone.component.cache.database.c;
import com.qzone.cover.business.protocol.QzoneGetWidgetInfoRequest;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.model.KapuEventDbCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheVisitorData;
import com.qzone.proxy.personalitycomponent.model.WidgetConstellationData;
import com.qzone.proxy.personalitycomponent.model.WidgetFlowerData;
import com.qzone.proxy.personalitycomponent.model.WidgetLunarData;
import com.qzone.proxy.personalitycomponent.model.WidgetPublicCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetQzoneVipData;
import com.qzone.proxy.personalitycomponent.model.WidgetVisitorsData;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import com.qzone.proxy.personalitycomponent.util.QzoneVipDataMMKVUtil;
import com.qzone.util.al;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashMap;
import n7.a;
import u5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneWidgetService implements IQZoneServiceListener, IObserver.background {
    private static final al<QzoneWidgetService, Void> F = new al<QzoneWidgetService, Void>() { // from class: com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneWidgetService a(Void r16) {
            return new QzoneWidgetService();
        }
    };
    public static final String WIDGET_BELOW_ZERO = "WidgetBelowZero";
    public static final String WIDGET_DISABLE_CACHE = "WidgetDisableCache";
    public static final String WIDGET_GPS_LATITUDE = "WidgetGpsLatitude";
    public static final String WIDGET_GPS_LONGTITUDE = "WidgetGpsLongtitude";
    public static final String WIDGET_PM25_SHOW = "WidgetPm25Show";
    public static final String WIDGET_USE_CUSTOM_GPS = "WidgetUseCustomGps";

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Handler> f50973d = null;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f50974e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final CacheHolder f50975f = new CacheHolder("table_constellation", WidgetCacheConstellationData.class);

    /* renamed from: h, reason: collision with root package name */
    private final CacheHolder f50976h = new CacheHolder("table_lunar", WidgetCacheLunarData.class);

    /* renamed from: i, reason: collision with root package name */
    private final CacheHolder f50977i = new CacheHolder("table_qzonevip", WidgetCacheQzoneVipData.class);

    /* renamed from: m, reason: collision with root package name */
    private final CacheHolder f50978m = new CacheHolder("table_visitor", WidgetCacheVisitorData.class);
    private final CacheHolder C = new CacheHolder("table_flower", WidgetCacheFlowerData.class);
    private final CacheHolder D = new CacheHolder("table_widget_public", WidgetPublicCacheData.class);
    private final CacheHolder E = new CacheHolder("table_kapu_event", KapuEventDbCacheData.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class CacheHolder {

        /* renamed from: a, reason: collision with root package name */
        long f50982a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f50983b;

        /* renamed from: c, reason: collision with root package name */
        String f50984c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends a> f50985d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f50986e = new a.InterfaceC10828a() { // from class: com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService.CacheHolder.1
            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                CacheHolder cacheHolder = CacheHolder.this;
                cacheHolder.f50982a = 0L;
                cacheHolder.f50983b = null;
            }
        };

        public CacheHolder(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f50984c = str;
            this.f50985d = cls;
        }
    }

    QzoneWidgetService() {
        a();
    }

    private String e(int i3) {
        return "Widget_AttachInfo_" + LoginData.getInstance().getUin() + "_" + i3;
    }

    private String f(int i3) {
        String e16 = e(i3);
        String str = this.f50974e.get(e16);
        return str == null ? b.h0(e16, "") : str;
    }

    private Object g(boolean z16) {
        WidgetPublicCacheData widgetPublicCacheData;
        synchronized (this.D) {
            d(this.D, false);
            widgetPublicCacheData = (WidgetPublicCacheData) this.D.f50983b.k0(null, null);
        }
        WidgetPublicCacheData widgetPublicCacheData2 = (widgetPublicCacheData == null || !z16 || b(widgetPublicCacheData.updatetime)) ? widgetPublicCacheData : null;
        if (widgetPublicCacheData2 != null) {
            QZLog.i("QzoneWidgetService", 1, "getWidgetInfoFromCache - getPublicWidgetData data = " + widgetPublicCacheData2.toString());
        }
        return widgetPublicCacheData2;
    }

    public static boolean getBoolean(Context context, String str, boolean z16) {
        return LocalMultiProcConfig.getBool(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX, str, z16);
    }

    public static QzoneWidgetService getInstance() {
        return F.get(null);
    }

    public static int getInteger(Context context, String str) {
        return LocalMultiProcConfig.getInt(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX, str, 0);
    }

    public static int getWeatherCacheTimeFromConfig() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_WEATHER_CACHE_TIME, 300);
    }

    public static int getWidgetType(Context context, long j3) {
        return LocalMultiProcConfig.getInt(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + j3, "WidgetID", -1);
    }

    private void h(Handler handler, int i3) {
        QZoneTask qZoneTask = new QZoneTask(new QzoneGetWidgetInfoRequest(i3, f(i3)), handler, this, 0);
        qZoneTask.addParameter("Widget_Type", Integer.valueOf(i3));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    private void i(QZoneTask qZoneTask) {
        int widgetType = getWidgetType(BaseApplication.getContext(), LoginData.getInstance().getUin());
        GetWidgetRsp resp = ((QzoneGetWidgetInfoRequest) qZoneTask.mRequest).getResp();
        int i3 = resp != null ? resp.stored_widget_id : widgetType;
        QZoneResult result = qZoneTask.getResult(1000015);
        if (resp != null) {
            if (resp.no_update == 1) {
                if (QZLog.isColorLevel()) {
                    QZLog.d(QZLog.TO_DEVICE_TAG, 2, "onGetWidgetInfoFinish succeed: type = " + i3 + ", no_update = 1");
                }
                Object widgetInfoFromCache = getWidgetInfoFromCache(i3, false, 0L);
                o(resp, widgetInfoFromCache);
                j(resp.attach_info, i3);
                result.setData(widgetInfoFromCache);
                if (widgetInfoFromCache != null) {
                    result.setSucceed(true);
                } else {
                    result.setSucceed(false);
                }
            } else {
                Object c16 = c(resp, i3);
                result.setData(c16);
                if (i3 != -1 && c16 == null) {
                    result.setSucceed(false);
                } else {
                    result.setSucceed(true);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetWidgetInfoFinish succeed: type = ");
                sb5.append(i3);
                sb5.append(", widgetData == null ? ");
                sb5.append(c16 == null);
                QZLog.i("QzoneWidgetService", 1, sb5.toString());
                j(resp.attach_info, i3);
                if (widgetType == -1 || i3 != widgetType) {
                    setWidgetType(BaseApplication.getContext(), i3, LoginData.getInstance().getUin());
                }
            }
        } else {
            QZLog.w("QzoneWidgetService", "onGetWidgetInfoFinish failed: type = " + i3 + ", code = " + qZoneTask.mResultCode);
            result.setSucceed(false);
        }
        if (widgetType != -1 && i3 == widgetType) {
            if (result.getSucceed() && result.getData() != null) {
                sendMessageTo(result.getData(), PersonalityConfig.MSG_REFRESH_WIDGET);
                sendMessageTo(resp, PersonalityConfig.MSG_REFRESH_WIDGET_VISITOR_NUM);
                return;
            } else {
                sendMessageTo(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WidgetGetInformationFail", "\u83b7\u53d6\u6302\u4ef6\u4fe1\u606f\u5931\u8d25"), PersonalityConfig.MSG_REFRESH_WIDGET_FAILED);
                return;
            }
        }
        sendMessageTo(result.getData(), 1000032);
    }

    public static void setBoolean(Context context, String str, boolean z16) {
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX, str, z16);
    }

    public static void setShowWidget(Context context, boolean z16, long j3) {
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + j3, "WidgetShow", z16);
    }

    public static void setWidgetType(Context context, int i3, long j3) {
        LocalMultiProcConfig.putInt(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + j3, "WidgetID", i3);
    }

    public static boolean shouldShowWidget(Context context, long j3) {
        return LocalMultiProcConfig.getBool(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + j3, "WidgetShow", true);
    }

    protected void a() {
        EventCenter.getInstance().addObserver(this, 3, "Lbs", 4, 2);
    }

    public WidgetConstellationData getConstellationFromCache(boolean z16) {
        WidgetCacheConstellationData widgetCacheConstellationData;
        synchronized (this.f50975f) {
            d(this.f50975f, false);
            widgetCacheConstellationData = (WidgetCacheConstellationData) this.f50975f.f50983b.k0(null, null);
        }
        if (widgetCacheConstellationData != null && z16 && !b(widgetCacheConstellationData.updatetime)) {
            widgetCacheConstellationData = null;
        }
        WidgetConstellationData convertToBusinessData = widgetCacheConstellationData != null ? WidgetCacheConstellationData.convertToBusinessData(widgetCacheConstellationData) : null;
        if (convertToBusinessData != null) {
            QZLog.i("QzoneWidgetService", 1, "getWidgetInfoFromCache - getConstellation data = " + convertToBusinessData.toString());
        }
        return convertToBusinessData;
    }

    public WidgetFlowerData getFlowerFromCache() {
        WidgetCacheFlowerData widgetCacheFlowerData;
        synchronized (this.C) {
            d(this.C, false);
            widgetCacheFlowerData = (WidgetCacheFlowerData) this.C.f50983b.k0(null, null);
        }
        WidgetFlowerData convertToBusinessData = widgetCacheFlowerData != null ? WidgetCacheFlowerData.convertToBusinessData(widgetCacheFlowerData) : null;
        if (convertToBusinessData != null) {
            QZLog.i("QzoneWidgetService", 1, "getWidgetInfoFromCache - getFlower data = " + convertToBusinessData.toString());
        }
        return convertToBusinessData;
    }

    public KapuEventDbCacheData getKapuEventFromCache(long j3) {
        KapuEventDbCacheData kapuEventDbCacheData;
        synchronized (this.E) {
            d(this.E, true);
            kapuEventDbCacheData = (KapuEventDbCacheData) this.E.f50983b.k0("uin=?", new String[]{"" + j3});
        }
        return kapuEventDbCacheData;
    }

    public WidgetLunarData getLunarFromCache(boolean z16) {
        WidgetCacheLunarData widgetCacheLunarData;
        synchronized (this.f50976h) {
            d(this.f50976h, true);
            widgetCacheLunarData = (WidgetCacheLunarData) this.f50976h.f50983b.k0(null, null);
        }
        if (widgetCacheLunarData != null && z16 && !b(widgetCacheLunarData.updatetime)) {
            widgetCacheLunarData = null;
        }
        WidgetLunarData convertToBusinessData = widgetCacheLunarData != null ? WidgetCacheLunarData.convertToBusinessData(widgetCacheLunarData) : null;
        if (convertToBusinessData != null) {
            QZLog.i("QzoneWidgetService", 1, "getWidgetInfoFromCache - getLunar data = " + convertToBusinessData.toString());
        }
        return convertToBusinessData;
    }

    public WidgetQzoneVipData getQzoneVipFromCache(long j3) {
        WidgetCacheQzoneVipData widgetCacheQzoneVipData;
        WidgetQzoneVipData convertToBusinessData;
        synchronized (this.f50977i) {
            if (VasNormalToggle.QZONE_SP_MOVE_SWITCH.isEnable(true)) {
                widgetCacheQzoneVipData = QzoneVipDataMMKVUtil.INSTANCE.getWidgetVipDataFromCache(j3);
            } else {
                d(this.f50977i, true);
                this.f50977i.f50983b.r0("uin='" + j3 + "'");
                widgetCacheQzoneVipData = (WidgetCacheQzoneVipData) this.f50977i.f50983b.k0("uin=?", new String[]{"" + j3});
            }
            convertToBusinessData = widgetCacheQzoneVipData != null ? WidgetCacheQzoneVipData.convertToBusinessData(widgetCacheQzoneVipData) : null;
        }
        return convertToBusinessData;
    }

    public WidgetVisitorsData getVistorFromCache(boolean z16) {
        WidgetCacheVisitorData widgetCacheVisitorData;
        synchronized (this.f50978m) {
            d(this.f50978m, false);
            widgetCacheVisitorData = (WidgetCacheVisitorData) this.f50978m.f50983b.k0(null, null);
        }
        if (widgetCacheVisitorData != null && z16 && !b(widgetCacheVisitorData.updatetime)) {
            widgetCacheVisitorData = null;
        }
        WidgetVisitorsData convertToBusinessData = widgetCacheVisitorData != null ? WidgetCacheVisitorData.convertToBusinessData(widgetCacheVisitorData) : null;
        if (convertToBusinessData != null) {
            QZLog.i("QzoneWidgetService", 1, "getWidgetInfoFromCache - getVistor data = " + convertToBusinessData.toString());
        }
        return convertToBusinessData;
    }

    public WidgetCacheQzoneVipData getWidgetVipDataFromCache(long j3) {
        WidgetCacheQzoneVipData widgetCacheQzoneVipData;
        if (VasNormalToggle.QZONE_SP_MOVE_SWITCH.isEnable(true)) {
            return QzoneVipDataMMKVUtil.INSTANCE.getWidgetVipDataFromCache(j3);
        }
        synchronized (this.f50977i) {
            d(this.f50977i, true);
            widgetCacheQzoneVipData = (WidgetCacheQzoneVipData) this.f50977i.f50983b.k0("uin=?", new String[]{"" + j3});
        }
        return widgetCacheQzoneVipData;
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        WidgetWeatherData widgetWeatherData;
        Object[] objArr = (Object[]) event.params;
        if ("Lbs".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 != 2) {
                if (i3 == 4 && objArr != null && objArr.length > 0 && (widgetWeatherData = (WidgetWeatherData) objArr[0]) != null) {
                    sendMessageTo(widgetWeatherData, PersonalityConfig.MSG_REFRESH_WIDGET);
                    return;
                }
                return;
            }
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            sendMessageTo((String) objArr[0], PersonalityConfig.MSG_REFRESH_WIDGET_FAILED);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 0) {
            return;
        }
        i(qZoneTask);
    }

    public void sendMessageTo(Object obj, int i3) {
        Handler handler;
        WeakReference<Handler> weakReference = this.f50973d;
        if (weakReference == null || (handler = weakReference.get()) == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = obj;
        obtain.what = i3;
        handler.sendMessage(obtain);
    }

    public void refreshWidgetInfo(Handler handler, int i3) {
        h(handler, -1);
    }

    private void j(String str, int i3) {
        if (str != null) {
            this.f50974e.put(e(i3), str);
            b.v0(e(i3), str);
        }
    }

    private void k(WidgetConstellationData widgetConstellationData) {
        if (widgetConstellationData != null) {
            QZLog.i("QzoneWidgetService", 1, "saveConstellationCacheData - data = " + widgetConstellationData.toString());
            synchronized (this.f50975f) {
                d(this.f50975f, false);
                this.f50975f.f50983b.o0(WidgetCacheConstellationData.createFromBusinessData(widgetConstellationData), 2);
            }
        }
    }

    private void l(WidgetFlowerData widgetFlowerData) {
        if (widgetFlowerData != null) {
            QZLog.i("QzoneWidgetService", 1, "saveFlowerCacheData - data = " + widgetFlowerData.toString());
            synchronized (this.C) {
                d(this.C, false);
                this.C.f50983b.o0(WidgetCacheFlowerData.createFromBusinessData(widgetFlowerData), 2);
            }
        }
    }

    private void m(WidgetLunarData widgetLunarData) {
        if (widgetLunarData != null) {
            QZLog.i("QzoneWidgetService", 1, "saveLunarCacheData - data = " + widgetLunarData.toString());
            synchronized (this.f50976h) {
                d(this.f50976h, true);
                this.f50976h.f50983b.o0(WidgetCacheLunarData.createFromBusinessData(widgetLunarData), 2);
            }
        }
    }

    private void n(WidgetPublicCacheData widgetPublicCacheData) {
        if (widgetPublicCacheData != null) {
            QZLog.i("QzoneWidgetService", 1, "savePublicWidgetCacheData - data = " + widgetPublicCacheData.toString());
            synchronized (this.D) {
                d(this.D, false);
                this.D.f50983b.o0(widgetPublicCacheData, 2);
            }
        }
    }

    public Object getWidgetInfoFromCache(int i3, boolean z16, long j3) {
        if (i3 == 0) {
            return e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_WEATHER).q(z16);
        }
        if (i3 == 2) {
            return getConstellationFromCache(z16);
        }
        if (i3 == 1) {
            return getLunarFromCache(z16);
        }
        if (i3 == 1000) {
            VasCommonReporter.getHistoryFeature().setValue1("qzoneVipWidget").setValue2("service").report();
            return getQzoneVipFromCache(j3);
        }
        if (i3 == 4) {
            return getVistorFromCache(z16);
        }
        if (i3 == 3) {
            return getFlowerFromCache();
        }
        if (i3 != -1) {
            return g(z16);
        }
        return null;
    }

    public void saveKapuEventCacheData(KapuEventDbCacheData kapuEventDbCacheData) {
        if (kapuEventDbCacheData != null) {
            synchronized (this.E) {
                d(this.E, true);
                this.E.f50983b.r0("uin=?");
                this.E.f50983b.t0(new String[]{kapuEventDbCacheData.uin + ""});
                this.E.f50983b.o0(kapuEventDbCacheData, 2);
            }
        }
    }

    public void saveQzoneVipCacheData(WidgetCacheQzoneVipData widgetCacheQzoneVipData) {
        if (widgetCacheQzoneVipData != null) {
            if (VasNormalToggle.QZONE_SP_MOVE_SWITCH.isEnable(true)) {
                QzoneVipDataMMKVUtil.INSTANCE.saveQzoneVipCacheData(widgetCacheQzoneVipData);
                return;
            }
            synchronized (this.f50977i) {
                d(this.f50977i, true);
                this.f50977i.f50983b.r0("uin=?");
                this.f50977i.f50983b.t0(new String[]{widgetCacheQzoneVipData.uin + ""});
                this.f50977i.f50983b.o0(widgetCacheQzoneVipData, 2);
            }
        }
    }

    public void saveVisitorCacheData(WidgetVisitorsData widgetVisitorsData) {
        if (widgetVisitorsData != null) {
            QZLog.i("QzoneWidgetService", 1, "saveVisitorCacheData - data = " + widgetVisitorsData.toString());
            synchronized (this.f50978m) {
                d(this.f50978m, false);
                WidgetCacheVisitorData createFromBusinessData = WidgetCacheVisitorData.createFromBusinessData(widgetVisitorsData);
                this.f50978m.f50983b.r0("uin=?");
                this.f50978m.f50983b.t0(new String[]{"" + createFromBusinessData.uin});
                this.f50978m.f50983b.o0(createFromBusinessData, 2);
            }
        }
    }

    private boolean b(int i3) {
        if (i3 <= 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(i3 * 1000);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private Object c(GetWidgetRsp getWidgetRsp, int i3) {
        if (getWidgetRsp == null || getWidgetRsp.widget == null) {
            return null;
        }
        if (i3 == 0) {
            return new Object();
        }
        if (i3 == 2) {
            ConstellationWidgetInfo constellationWidgetInfo = new ConstellationWidgetInfo();
            JceInputStream jceInputStream = new JceInputStream(getWidgetRsp.widget);
            jceInputStream.setServerEncoding("utf-8");
            constellationWidgetInfo.readFrom(jceInputStream);
            WidgetConstellationData createFromResponse = WidgetCacheConstellationData.createFromResponse(constellationWidgetInfo, getWidgetRsp.expire);
            k(createFromResponse);
            return createFromResponse;
        }
        if (i3 == 1) {
            LunarWidgetInfo lunarWidgetInfo = new LunarWidgetInfo();
            JceInputStream jceInputStream2 = new JceInputStream(getWidgetRsp.widget);
            jceInputStream2.setServerEncoding("utf-8");
            lunarWidgetInfo.readFrom(jceInputStream2);
            WidgetLunarData createFromResponse2 = WidgetCacheLunarData.createFromResponse(lunarWidgetInfo, getWidgetRsp.expire);
            m(createFromResponse2);
            return createFromResponse2;
        }
        if (i3 == 4) {
            VisitorWidgetInfo visitorWidgetInfo = new VisitorWidgetInfo();
            JceInputStream jceInputStream3 = new JceInputStream(getWidgetRsp.widget);
            jceInputStream3.setServerEncoding("utf-8");
            visitorWidgetInfo.readFrom(jceInputStream3);
            yellow_info yellow_infoVar = visitorWidgetInfo.yellow_flag;
            if (yellow_infoVar != null) {
                LoginData.getInstance().updateVipInfos(yellow_infoVar.iYellowType, yellow_infoVar.iYellowLevel, yellow_infoVar.isAnnualVip);
            }
            WidgetVisitorsData createFromResponse3 = WidgetCacheVisitorData.createFromResponse(visitorWidgetInfo, getWidgetRsp.iNameplateFlag, LoginData.getInstance().getUin(), getWidgetRsp.expire, getWidgetRsp.iNeedRedPacket);
            saveVisitorCacheData(createFromResponse3);
            return createFromResponse3;
        }
        if (i3 != 3) {
            if (i3 == -1) {
                return null;
            }
            WidgetPublicCacheData createFromResponse4 = WidgetPublicCacheData.createFromResponse(getWidgetRsp);
            n(createFromResponse4);
            return createFromResponse4;
        }
        FlowerWidgetInfo flowerWidgetInfo = new FlowerWidgetInfo();
        JceInputStream jceInputStream4 = new JceInputStream(getWidgetRsp.widget);
        jceInputStream4.setServerEncoding("utf-8");
        flowerWidgetInfo.readFrom(jceInputStream4);
        WidgetFlowerData createFromResponse5 = WidgetCacheFlowerData.createFromResponse(flowerWidgetInfo);
        l(createFromResponse5);
        return createFromResponse5;
    }

    private void o(GetWidgetRsp getWidgetRsp, Object obj) {
        if (obj != null && (obj instanceof WidgetConstellationData)) {
            WidgetConstellationData widgetConstellationData = (WidgetConstellationData) obj;
            widgetConstellationData.updatetime = (int) (System.currentTimeMillis() / 1000);
            widgetConstellationData.cachetime = getWidgetRsp.expire;
            k(widgetConstellationData);
            return;
        }
        if (obj != null && (obj instanceof WidgetLunarData)) {
            WidgetLunarData widgetLunarData = (WidgetLunarData) obj;
            widgetLunarData.updatetime = (int) (System.currentTimeMillis() / 1000);
            widgetLunarData.cachetime = getWidgetRsp.expire;
            m(widgetLunarData);
            return;
        }
        if (obj != null && (obj instanceof WidgetVisitorsData)) {
            WidgetVisitorsData widgetVisitorsData = (WidgetVisitorsData) obj;
            widgetVisitorsData.updatetime = (int) (System.currentTimeMillis() / 1000);
            widgetVisitorsData.cachetime = getWidgetRsp.expire;
            saveVisitorCacheData(widgetVisitorsData);
            return;
        }
        if (obj == null || !(obj instanceof WidgetFlowerData)) {
            return;
        }
        WidgetFlowerData widgetFlowerData = (WidgetFlowerData) obj;
        widgetFlowerData.updatetime = (int) (System.currentTimeMillis() / 1000);
        widgetFlowerData.cachetime = 0;
        l(widgetFlowerData);
    }

    private void d(CacheHolder cacheHolder, boolean z16) {
        DbCacheManager dbCacheManager;
        if (cacheHolder == null) {
            return;
        }
        long uin = !z16 ? LoginData.getInstance().getUin() : 0L;
        if (uin != cacheHolder.f50982a || (dbCacheManager = cacheHolder.f50983b) == null || dbCacheManager.isClosed()) {
            cacheHolder.f50982a = uin;
            DbCacheManager e16 = c.g().e(cacheHolder.f50985d, uin, cacheHolder.f50984c);
            cacheHolder.f50983b = e16;
            e16.U(cacheHolder.f50986e);
        }
    }

    public void getWidgetData(Context context, final long j3, boolean z16, final boolean z17, Handler handler) {
        if (context == null || handler == null) {
            return;
        }
        this.f50973d = new WeakReference<>(handler);
        final WeakReference weakReference = new WeakReference(context);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService.2
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                WeakReference weakReference2 = weakReference;
                if (weakReference2 == null || (context2 = (Context) weakReference2.get()) == null) {
                    return;
                }
                int widgetType = QzoneWidgetService.getWidgetType(context2, j3);
                Object widgetInfoFromCache = QzoneWidgetService.this.getWidgetInfoFromCache(widgetType, true, j3);
                if (z17) {
                    if (widgetType == 0) {
                        e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_WEATHER).b(null, WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FILE);
                    }
                    QzoneWidgetService.getInstance().refreshWidgetInfo(null, widgetType);
                    return;
                }
                QzoneWidgetService.this.sendMessageTo(widgetInfoFromCache, PersonalityConfig.MSG_REFRESH_WIDGET);
            }
        });
    }

    public static boolean needUpdateWidget(int i3, Object obj, boolean z16) {
        int i16;
        int i17;
        if (obj == null) {
            return true;
        }
        if (i3 == 0 && (obj instanceof WidgetWeatherData)) {
            WidgetWeatherData widgetWeatherData = (WidgetWeatherData) obj;
            i16 = widgetWeatherData.iUpdateTime;
            if (z16) {
                i17 = getWeatherCacheTimeFromConfig();
            } else {
                i17 = (int) widgetWeatherData.iCacheTime;
            }
        } else if (i3 == 2 && (obj instanceof WidgetConstellationData)) {
            WidgetConstellationData widgetConstellationData = (WidgetConstellationData) obj;
            i16 = widgetConstellationData.updatetime;
            i17 = widgetConstellationData.cachetime;
        } else if (i3 == 1 && (obj instanceof WidgetLunarData)) {
            WidgetLunarData widgetLunarData = (WidgetLunarData) obj;
            i16 = widgetLunarData.updatetime;
            i17 = widgetLunarData.cachetime;
        } else if (i3 == 4 && (obj instanceof WidgetVisitorsData)) {
            WidgetVisitorsData widgetVisitorsData = (WidgetVisitorsData) obj;
            i16 = widgetVisitorsData.updatetime;
            i17 = widgetVisitorsData.cachetime;
        } else if (i3 == 3 && (obj instanceof WidgetFlowerData)) {
            WidgetFlowerData widgetFlowerData = (WidgetFlowerData) obj;
            i16 = widgetFlowerData.updatetime;
            i17 = widgetFlowerData.cachetime;
        } else {
            if (i3 == -1 || !(obj instanceof WidgetPublicCacheData)) {
                return true;
            }
            WidgetPublicCacheData widgetPublicCacheData = (WidgetPublicCacheData) obj;
            i16 = widgetPublicCacheData.updatetime;
            i17 = widgetPublicCacheData.cachetime;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneWidgetService", 2, "\t needUpdateWidget: type: " + i3 + ", lastUpdateTime: " + i16 + ", cacheTime: " + i17 + ", now: " + currentTimeMillis);
        }
        return currentTimeMillis - i16 > i17;
    }
}
