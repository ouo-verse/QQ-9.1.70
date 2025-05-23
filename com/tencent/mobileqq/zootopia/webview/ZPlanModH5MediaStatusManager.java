package com.tencent.mobileqq.zootopia.webview;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebPageLoadFinishedEvent;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
import t74.u;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010 \u001a\u00020\u001e\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J(\u0010\u001d\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b\u0018\u00010\u001aj\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b\u0018\u0001`\u001cH\u0016R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusManager;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "g", "", "mediaUrl", "mediaUrlLowQuality", "", "width", "height", "c", "a", "Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusData;", "mediaStatusData", "e", "b", "url", "", "mapId", "f", "Lorg/json/JSONObject;", "h5DataJson", "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "ueActivityViewManager", "Ljava/lang/String;", "I", "curActionType", h.F, "curMediaH5Status", "", "i", "Z", "hasCalledPlayJs", "<init>", "(Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModH5MediaStatusManager implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager ueActivityViewManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mediaUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curActionType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curMediaH5Status;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasCalledPlayJs;

    public ZPlanModH5MediaStatusManager(UEActivityViewManager ueActivityViewManager) {
        Intrinsics.checkNotNullParameter(ueActivityViewManager, "ueActivityViewManager");
        this.ueActivityViewManager = ueActivityViewManager;
        this.mediaUrl = "";
        QLog.i("ZPlanModH5MediaStatusManager", 1, "init - " + this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void a() {
        if (this.curActionType == 2) {
            int i3 = this.curMediaH5Status;
            if (i3 == 1 || i3 == 2) {
                QLog.i("ZPlanModH5MediaStatusManager", 1, "checkNeedNotifyH5Play callJs, " + this.hasCalledPlayJs);
                if (this.hasCalledPlayJs) {
                    return;
                }
                this.ueActivityViewManager.g("zplan_playH5MediaSource", null);
                this.hasCalledPlayJs = true;
            }
        }
    }

    private final void e(ZPlanModH5MediaStatusData mediaStatusData) {
        com.tencent.zplan.luabridge.a aVar;
        int status = mediaStatusData.getStatus();
        int stopReason = mediaStatusData.getStopReason();
        double stopPlayPosition = mediaStatusData.getStopPlayPosition();
        this.curMediaH5Status = status;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("MediaURL", this.mediaUrl);
        jSONObject.put("Status", status);
        if (stopReason != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("StopReason", stopReason);
            jSONObject2.put("MediaPosition", stopPlayPosition);
            jSONObject.put("ExtraParams", jSONObject2);
        }
        if (this.curActionType != 0) {
            QLog.i("ZPlanModH5MediaStatusManager", 1, "N2L_OnH5MediaSourceStatusChanged - " + jSONObject);
            if (t74.h.b()) {
                aVar = ZPlanServiceHelper.I.S();
            } else {
                aVar = ZPlanLuaBridge.INSTANCE;
            }
            com.tencent.zplan.luabridge.a aVar2 = aVar;
            if (aVar2 != null) {
                a.C10063a.d(aVar2, "N2L_OnH5MediaSourceStatusChanged", jSONObject, null, false, 12, null);
            }
            a();
        } else {
            QLog.i("ZPlanModH5MediaStatusManager", 1, "notifyH5MediaStatusToUE skipped - " + jSONObject);
        }
        if (status == 4) {
            this.ueActivityViewManager.j();
            g();
        }
    }

    private final void g() {
        this.mediaUrl = "";
        this.curMediaH5Status = 0;
        this.curActionType = 0;
        this.hasCalledPlayJs = false;
    }

    public final void b() {
        QLog.i("ZPlanModH5MediaStatusManager", 1, "destroy - " + this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        g();
    }

    public final void d(JSONObject h5DataJson) {
        Intrinsics.checkNotNullParameter(h5DataJson, "h5DataJson");
        int optInt = h5DataJson.optInt("ActionType");
        JSONObject optJSONObject = h5DataJson.optJSONObject("MediaInfo");
        String optString = optJSONObject != null ? optJSONObject.optString("MediaURL") : null;
        String str = optString == null ? "" : optString;
        String optString2 = optJSONObject != null ? optJSONObject.optString("MediaURLLowQuality") : null;
        String str2 = optString2 == null ? "" : optString2;
        double optDouble = optJSONObject != null ? optJSONObject.optDouble("Width", 0.0d) : 0.0d;
        double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("Height", 0.0d) : 0.0d;
        if (!Intrinsics.areEqual(this.mediaUrl, str)) {
            g();
        }
        this.mediaUrl = str;
        int i3 = this.curActionType;
        this.curActionType = optInt;
        if (optInt != 1 && optInt != 2) {
            if (optInt != 3) {
                return;
            }
            this.ueActivityViewManager.j();
            return;
        }
        if (i3 != 1 && i3 != 2) {
            this.ueActivityViewManager.a(c(str, str2, optDouble, optDouble2), true, true);
        } else {
            QLog.i("ZPlanModH5MediaStatusManager", 1, "lastActionType = " + i3);
        }
        a();
    }

    public final void f(String url, int mapId) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String str = "preload_mod_guide_" + w.f373306a.b() + "_" + mapId;
        if (!((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(str, false)) {
            QLog.i("ZPlanModH5MediaStatusManager", 1, mapId + " preloadWebViewIfNeeded - " + url);
            this.ueActivityViewManager.a(url, true, true);
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(str, true);
            return;
        }
        QLog.i("ZPlanModH5MediaStatusManager", 1, mapId + " already loaded");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanNotifyH5MediaStatusEvent.class);
        arrayList.add(ZplanWebPageLoadFinishedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof ZPlanNotifyH5MediaStatusEvent) {
            ZPlanNotifyH5MediaStatusEvent zPlanNotifyH5MediaStatusEvent = (ZPlanNotifyH5MediaStatusEvent) event;
            QLog.i("ZPlanModH5MediaStatusManager", 1, "ZPlanNotifyH5MediaStatusEvent - " + zPlanNotifyH5MediaStatusEvent.getMediaStatusData());
            e(zPlanNotifyH5MediaStatusEvent.getMediaStatusData());
            return;
        }
        if (event instanceof ZplanWebPageLoadFinishedEvent) {
            QLog.i("ZPlanModH5MediaStatusManager", 1, "ZplanWebPageLoadFinishedEvent- " + ((ZplanWebPageLoadFinishedEvent) event).getCompleteData());
        }
    }

    private final String c(String mediaUrl, String mediaUrlLowQuality, double width, double height) {
        String str;
        Map mutableMapOf;
        boolean contains$default;
        String str2;
        String joinToString$default;
        FragmentActivity fragmentActivity = this.ueActivityViewManager.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        ZootopiaUEActivity zootopiaUEActivity = fragmentActivity instanceof ZootopiaUEActivity ? (ZootopiaUEActivity) fragmentActivity : null;
        if (zootopiaUEActivity == null || (str = zootopiaUEActivity.getNewGuideUrl()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ISchemeApi.Companion companion = ISchemeApi.INSTANCE;
        u.Companion companion2 = u.INSTANCE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("mediaUrl", companion.b(mediaUrl)), TuplesKt.to("MediaURLLowQuality", companion.b(mediaUrlLowQuality)), TuplesKt.to("mediaWidth", Double.valueOf(width)), TuplesKt.to("mediaHeight", Double.valueOf(height)), TuplesKt.to("clientWidth", Integer.valueOf(companion2.c(this.ueActivityViewManager.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String()))), TuplesKt.to("clientHeight", Integer.valueOf(companion2.b(this.ueActivityViewManager.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String()))));
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str2 = str;
        } else {
            str2 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mutableMapOf.entrySet(), ContainerUtils.FIELD_DELIMITER, str2, null, 0, null, new Function1<Map.Entry<String, Object>, CharSequence>() { // from class: com.tencent.mobileqq.zootopia.webview.ZPlanModH5MediaStatusManager$generateFullH5Url$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + it.getValue();
            }
        }, 28, null);
        QLog.i("ZPlanModH5MediaStatusManager", 1, "generateFullH5Url, newGuideUrlPrefix= " + str + ", fullUrl= " + joinToString$default);
        return joinToString$default;
    }
}
