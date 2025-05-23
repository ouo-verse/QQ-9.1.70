package com.tencent.mobileqq.vas.hippy.api.module;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.vas.hippy.api.data.ZPlanParadiseHippyCacheEntity;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.webview.JSEventDelegate;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.TabBackFrom;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@HippyNativeModule(name = "ZPlanHippyModule")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001LB\u0011\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0007J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010+\u001a\u00020\u0002H\u0007J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010/\u001a\u00020\u001aH\u0007J\b\u00100\u001a\u00020\u001aH\u0007J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u00103\u001a\u00020\u001aH\u0007J\b\u00104\u001a\u00020\u001aH\u0007J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u00106\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u00107\u001a\u00020\u0007H\u0007J\u0018\u00108\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010<\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010=\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010?\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/module/ZPlanParadiseHippyModule;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "", "jsonStr", "Lorg/json/JSONObject;", "safeGenerateGson", "key", "", "deleteDBCache", "deleteMemCache", "readMemCache", "readDBCache", "cache", "saveCacheInMem", "data", "saveCacheInDB", "readCacheData", "", "writeCacheData", "deleteCacheData", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "requestServer", "openRechargePanel", "getRootSourceId", "", "openDetailPage", "queryDownloadInfo", "batchQueryDownloadInfo", "startMapDownload", "mapId", "pauseMapDownload", "openPortalPage", "enterSence", "showMapFloatWindow", "queryFloatingPermission", "startResourceDownload", "queryResourceDownloadInfo", "openSameStylePage", "openSameStylePreviewPage", "isSupportZplan", "launchScheme", "getMaintenanceInfo", "showWheelPicker", "getDesignerDraft", "callN2LEvent", "getStatusBarHeight", "getBottomTabHeight", "updateQQLiveStreamMediaInfo", "handleH5Data", "refreshSilenceDownloadList", "refreshReserveList", "getCurrentUserInfo", IZplanHandleApi.METHOD_REFRESH_DRESS_INFO, "tabBack", "ueFusionAction", "notifyEvent", "setOpenScheme", "cancelMapDownload", "queryStorageSpace", "notifyH5MediaStatusUpdated", "dispatchEvent", "gotoGuild", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vas/hippy/api/data/ZPlanParadiseHippyCacheEntity;", "mDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zootopia/webview/JSEventDelegate;", "mDelegate", "Lcom/tencent/mobileqq/zootopia/webview/JSEventDelegate;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanParadiseHippyModule extends HippyNativeModuleBase {
    public static final String MODULE_NAME = "ZPlanHippyModule";
    public static final String TAG = "ZPlanParadiseHippyModule";
    private final ConcurrentHashMap<String, ZPlanParadiseHippyCacheEntity> mDataCache;
    private final JSEventDelegate mDelegate;

    public ZPlanParadiseHippyModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        HippyEngineContext hippyEngineContext2 = this.mContext;
        QLog.i(TAG, 1, this + " engine:" + hippyEngineContext + ", engineId:" + (hippyEngineContext2 != null ? Integer.valueOf(hippyEngineContext2.getEngineId()) : null));
        this.mDataCache = new ConcurrentHashMap<>();
        this.mDelegate = new JSEventDelegate();
    }

    private final void deleteDBCache(String key) {
        this.mDataCache.remove(key);
    }

    private final void deleteMemCache(String key) {
        ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = new ZPlanParadiseHippyCacheEntity();
        zPlanParadiseHippyCacheEntity.cacheKey = key;
        ZplanDataBaseHelper.h().n(zPlanParadiseHippyCacheEntity);
    }

    private final String readDBCache(String key) {
        Entity entity;
        Object obj;
        List<? extends Entity> k3 = ZplanDataBaseHelper.h().k(ZPlanParadiseHippyCacheEntity.class);
        if (k3 != null) {
            Iterator<T> it = k3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Entity entity2 = (Entity) obj;
                Intrinsics.checkNotNull(entity2, "null cannot be cast to non-null type com.tencent.mobileqq.vas.hippy.api.data.ZPlanParadiseHippyCacheEntity");
                if (Intrinsics.areEqual(key, ((ZPlanParadiseHippyCacheEntity) entity2).cacheKey)) {
                    break;
                }
            }
            entity = (Entity) obj;
        } else {
            entity = null;
        }
        ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = entity instanceof ZPlanParadiseHippyCacheEntity ? (ZPlanParadiseHippyCacheEntity) entity : null;
        if (zPlanParadiseHippyCacheEntity != null) {
            return zPlanParadiseHippyCacheEntity.cacheData;
        }
        return null;
    }

    private final String readMemCache(String key) {
        ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = this.mDataCache.get(key);
        if (zPlanParadiseHippyCacheEntity != null) {
            return zPlanParadiseHippyCacheEntity.cacheData;
        }
        return null;
    }

    private final JSONObject safeGenerateGson(String jsonStr) {
        try {
            return new JSONObject(jsonStr);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "generate gson error " + e16);
            return new JSONObject();
        }
    }

    private final void saveCacheInDB(String key, String data) {
        QLog.i(TAG, 1, "saveCacheInMem key:" + key + ", data.length:" + data.length());
        ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = new ZPlanParadiseHippyCacheEntity();
        zPlanParadiseHippyCacheEntity.cacheKey = key;
        zPlanParadiseHippyCacheEntity.cacheData = data;
        ZplanDataBaseHelper.h().i(zPlanParadiseHippyCacheEntity);
    }

    private final void saveCacheInMem(String key, String cache) {
        QLog.i(TAG, 1, "saveCacheInMem key:" + key + ", cache.length:" + cache.length());
        ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = new ZPlanParadiseHippyCacheEntity();
        zPlanParadiseHippyCacheEntity.cacheKey = key;
        zPlanParadiseHippyCacheEntity.cacheData = cache;
        this.mDataCache.put(key, zPlanParadiseHippyCacheEntity);
    }

    @HippyMethod(name = "batchQueryDownloadInfo")
    public final void batchQueryDownloadInfo(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.g(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(name = "callN2LEvent")
    public final void callN2LEvent(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.h(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(name = "cancelMapDownload")
    public final void cancelMapDownload(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.i(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "deleteCacheData")
    public final boolean deleteCacheData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i(TAG, 1, "deleteCacheData key:" + key);
        deleteMemCache(key);
        deleteDBCache(key);
        return true;
    }

    @HippyMethod(name = "dispatchEvent")
    public final void dispatchEvent(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.l(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(name = "enterSence")
    public final void enterSence(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.A(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "getBottomTabHeight")
    public final int getBottomTabHeight() {
        return this.mDelegate.m();
    }

    @HippyMethod(name = "getCurrentUserInfo")
    public final void getCurrentUserInfo(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.n(promise);
    }

    @HippyMethod(isSync = true, name = "getDesignerDraft")
    public final String getDesignerDraft(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        String jSONArray = this.mDelegate.o(safeGenerateGson(jsonStr)).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "mDelegate.getDesignerDra\u2026Gson(jsonStr)).toString()");
        return jSONArray;
    }

    @HippyMethod(isSync = true, name = "getMaintenanceInfo")
    public final String getMaintenanceInfo() {
        return this.mDelegate.p();
    }

    @HippyMethod(isSync = true, name = "getRootSourceId")
    public final String getRootSourceId() {
        String str;
        ZootopiaSource e16 = ag.f373258a.e();
        if (e16 == null || (str = ah.b(e16)) == null) {
            str = "";
        }
        QLog.d(TAG, 1, "getRootSourceId " + str);
        return str;
    }

    @HippyMethod(isSync = true, name = "getStatusBarHeight")
    public final int getStatusBarHeight() {
        return this.mDelegate.r();
    }

    @HippyMethod(name = "qqChannelButtonClicked")
    public final void gotoGuild(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.s(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "handleH5Data")
    public final int handleH5Data(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.t(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "isSupportZplan")
    public final void isSupportZplan(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.u(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "launchScheme")
    public final int launchScheme(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.w(safeGenerateGson(jsonStr));
    }

    @HippyMethod(isSync = true, name = "notifyEvent")
    public final int notifyEvent(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.x(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "notifyH5MediaStatusUpdated")
    public final void notifyH5MediaStatusUpdated(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.y(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "openDetailPage")
    public final int openDetailPage(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.z(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "openPortalPage")
    public final void openPortalPage(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.B(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(name = "openRechargePanel")
    public final void openRechargePanel(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.D(jsonStr, promise);
    }

    @HippyMethod(isSync = true, name = "openSameStylePage")
    public final int openSameStylePage(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.E(safeGenerateGson(jsonStr));
    }

    @HippyMethod(isSync = true, name = "openSameStylePreviewPage")
    public final int openSameStylePreviewPage(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.F(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "pauseMapDownload")
    public final void pauseMapDownload(String mapId, Promise promise) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.G(mapId, promise);
    }

    @HippyMethod(name = "queryDownloadInfo")
    public final void queryDownloadInfo(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.H(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(name = "queryFloatingPermission")
    public final void queryFloatingPermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.I(promise);
    }

    @HippyMethod(name = "queryResourceDownloadInfo")
    public final void queryResourceDownloadInfo(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.J(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(name = "queryStorageSpace")
    public final void queryStorageSpace(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.L(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "readCacheData")
    public final String readCacheData(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i(TAG, 1, "readCacheData key:" + key);
        String readMemCache = readMemCache(key);
        if (readMemCache != null) {
            QLog.i(TAG, 1, "readCacheData key:" + key + " memCache:" + readMemCache);
            return readMemCache;
        }
        String readDBCache = readDBCache(key);
        if (readDBCache != null) {
            QLog.i(TAG, 1, "readCacheData key:" + key + " dbCache:" + readDBCache);
            saveCacheInMem(key, readDBCache);
            return readDBCache;
        }
        QLog.i(TAG, 1, "readCacheData key:" + key + " empty");
        return "";
    }

    @HippyMethod(isSync = true, name = IZplanHandleApi.METHOD_REFRESH_DRESS_INFO)
    public final int refreshDressInfo(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.M(safeGenerateGson(jsonStr));
    }

    @HippyMethod(isSync = true, name = "refreshReserveList")
    public final int refreshReserveList() {
        return this.mDelegate.O();
    }

    @HippyMethod(isSync = true, name = "refreshSilenceDownloadList")
    public final int refreshSilenceDownloadList() {
        return this.mDelegate.P();
    }

    @HippyMethod(name = "requestServer")
    public final void requestServer(String request, Promise promise) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.Q(safeGenerateGson(request), promise);
    }

    @HippyMethod(isSync = true, name = "setOpenScheme")
    public final int setOpenScheme(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.R(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "showMapFloatWindow")
    public final void showMapFloatWindow(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.S(safeGenerateGson(jsonStr), promise, System.currentTimeMillis());
    }

    @HippyMethod(name = "showWheelPicker")
    public final void showWheelPicker(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        JSEventDelegate.U(this.mDelegate, safeGenerateGson(jsonStr), promise, null, 4, null);
    }

    @HippyMethod(name = "startMapDownload")
    public final void startMapDownload(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.mDelegate.V(safeGenerateGson(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "startResourceDownload")
    public final int startResourceDownload(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.X(safeGenerateGson(jsonStr));
    }

    @HippyMethod(name = "tabBack")
    public final void tabBack() {
        this.mDelegate.Y(TabBackFrom.HIPPY);
    }

    @HippyMethod(name = "ueFusionAction")
    public final void ueFusionAction(String jsonStr, Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.e(TAG, 1, "ueFusionAction jsonStr:" + jsonStr);
        this.mDelegate.b0(CommonExKt.A(jsonStr), promise);
    }

    @HippyMethod(isSync = true, name = "updateQQLiveStreamMediaInfo")
    public final int updateQQLiveStreamMediaInfo(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        return this.mDelegate.c0(safeGenerateGson(jsonStr));
    }

    @HippyMethod(isSync = true, name = "writeCacheData")
    public final boolean writeCacheData(String data, String key) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i(TAG, 1, "writeCacheData key:" + key + ", data.length:" + data.length());
        saveCacheInMem(key, data);
        saveCacheInDB(key, data);
        return true;
    }
}
