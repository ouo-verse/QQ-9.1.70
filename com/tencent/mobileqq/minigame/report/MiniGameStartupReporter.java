package com.tencent.mobileqq.minigame.report;

import android.content.ContentValues;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.entity.MiniGameStartupReportEntity;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.ReportLaunchEventRequest;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u0010\u001e\u001a\u00020\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012H\u0002J$\u0010%\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014H\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameStartupReporter;", "", "()V", "ID_WHERE_CLAUSE", "", "MAX_RETENTION_TIME", "", "TAG", "directReportSet", "", "entityManagerRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/mini/apkgEntity/MiniAppEntityManager;", "lastCheckTime", "", "convertData2Entity", "Lcom/tencent/mobileqq/mini/entity/MiniGameStartupReportEntity;", "reportData", "Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", "convertData2Map", "", "qqUin", "convertEntity2Map", "entity", "getEntityManager", "getTableName", "handleDirtyData", "", "entityManager", "processReportData", "realReport", "reportMap", AdMetricTag.EVENT_NAME, "versionType", "report", "reportLoadingData", "loadingData", "reportStartUpEventForAudit", "map", "updateReportData2DB", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameStartupReporter {
    private static final String ID_WHERE_CLAUSE = "startupId=?";
    public static final MiniGameStartupReporter INSTANCE = new MiniGameStartupReporter();
    private static final int MAX_RETENTION_TIME = 1800000;
    private static final String TAG = "MiniGameStartupReporter";
    private static final Set<String> directReportSet;
    private static WeakReference<MiniAppEntityManager> entityManagerRef;
    private static long lastCheckTime;

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{StartupReportUtil.EVENT_AD_SHOW, StartupReportUtil.EVENT_APKG_DOWNLOAD, StartupReportUtil.EVENT_ENGINE_LOAD, StartupReportUtil.EVENT_INIT_ENV, StartupReportUtil.EVENT_SHOW, StartupReportUtil.EVENT_UNITY_SHOW, StartupReportUtil.EVENT_CAN_PLAY, StartupReportUtil.EVENT_PRIVACY_SHOW, StartupReportUtil.EVENT_PRIVACY_AGREE, StartupReportUtil.EVENT_PRIVACY_REJECT, StartupReportUtil.EVENT_PRIVACY_HAS_AGREED, StartupReportUtil.EVENT_CREATED_ROLE, StartupReportUtil.EVENT_REPORT_CUSTOM_EVENT});
        directReportSet = of5;
    }

    MiniGameStartupReporter() {
    }

    private final MiniGameStartupReportEntity convertData2Entity(StartupReportData reportData) {
        MiniGameStartupReportEntity miniGameStartupReportEntity = new MiniGameStartupReportEntity();
        miniGameStartupReportEntity.startupId = reportData.getStartupId();
        miniGameStartupReportEntity.appId = reportData.getAppId();
        miniGameStartupReportEntity.startupScene = reportData.getStartupScene();
        miniGameStartupReportEntity.occurredTime = reportData.getEventTime();
        miniGameStartupReportEntity.eventName = reportData.getEventName();
        miniGameStartupReportEntity.relativeTime = reportData.getRelativeTime();
        miniGameStartupReportEntity.appInfoFlag = reportData.getAppInfoFlag();
        miniGameStartupReportEntity.gameEngineFlag = String.valueOf(reportData.getGameEngineFlag());
        miniGameStartupReportEntity.startupFlag = String.valueOf(reportData.getStartupFlag());
        miniGameStartupReportEntity.preloadFlag = String.valueOf(reportData.getPreloadFlag());
        miniGameStartupReportEntity.adFlag = String.valueOf(reportData.getAdFlag());
        miniGameStartupReportEntity.apkgState = String.valueOf(reportData.getApkgState());
        miniGameStartupReportEntity.apkgSize = reportData.getApkgSize();
        miniGameStartupReportEntity.appType = reportData.getAppType();
        miniGameStartupReportEntity.versionType = reportData.getVersionType();
        miniGameStartupReportEntity.versionId = reportData.getVersionId();
        miniGameStartupReportEntity.via = reportData.getVia();
        miniGameStartupReportEntity.mode = reportData.getMode();
        miniGameStartupReportEntity.extReportData = reportData.getExtReportData();
        return miniGameStartupReportEntity;
    }

    private final Map<String, String> convertData2Map(String qqUin, StartupReportData reportData) {
        String str = reportData.getStartupId() + "_" + qqUin;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appid", reportData.getAppId());
        linkedHashMap.put(StartupReportKey.STARTUP_ID, str);
        linkedHashMap.put(StartupReportKey.APPINFO_FLAG, String.valueOf(reportData.getAppInfoFlag()));
        linkedHashMap.put(StartupReportKey.GAME_ENGINE_FLAG, String.valueOf(reportData.getGameEngineFlag()));
        linkedHashMap.put(StartupReportKey.STARTUP_FLAG, String.valueOf(reportData.getStartupFlag()));
        linkedHashMap.put("preload_flag", String.valueOf(reportData.getPreloadFlag()));
        linkedHashMap.put(StartupReportKey.AD_FLAG, String.valueOf(reportData.getAdFlag()));
        String str2 = "0";
        linkedHashMap.put(StartupReportKey.PLATFORM_ID, "0");
        linkedHashMap.put(StartupReportKey.APKG_STATE, String.valueOf(reportData.getApkgState()));
        linkedHashMap.put(StartupReportKey.APKG_SIZE, String.valueOf(reportData.getApkgSize()));
        linkedHashMap.put(StartupReportKey.STARTUP_SCENE, String.valueOf(reportData.getStartupScene()));
        linkedHashMap.put(StartupReportKey.ENGINE_TYPE, "0");
        linkedHashMap.put(StartupReportKey.EVENT_TIME, String.valueOf(reportData.getEventTime()));
        linkedHashMap.put(StartupReportKey.RELATIVE_TIME, String.valueOf(reportData.getRelativeTime()));
        linkedHashMap.put("device_level", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        linkedHashMap.put(StartupReportKey.USER_UIN, qqUin);
        linkedHashMap.put(StartupReportKey.DEBUG_FLAG, "0");
        linkedHashMap.put("version_type", String.valueOf(reportData.getVersionType()));
        linkedHashMap.put(StartupReportKey.VERSION_ID, reportData.getVersionId());
        linkedHashMap.put("via", reportData.getVia());
        linkedHashMap.put("mode", reportData.getMode());
        linkedHashMap.put(StartupReportKey.EXT_REPORT_DATA, reportData.getExtReportData());
        if (reportData.getReportEventKey().length() > 0) {
            linkedHashMap.put(StartupReportKey.CUSTOM_REPORT_KEY, reportData.getReportEventKey());
        }
        if (reportData.getReportEventValue().length() > 0) {
            linkedHashMap.put(StartupReportKey.CUSTOM_REPORT_VALUE, reportData.getReportEventValue());
        }
        if (reportData.getJsLibVersion().length() > 0) {
            linkedHashMap.put(StartupReportKey.JSLIB_VERSION, reportData.getJsLibVersion());
        }
        if (reportData.getTritonVersion().length() > 0) {
            linkedHashMap.put("triton_version", reportData.getTritonVersion());
        }
        if (reportData.getHasPaused()) {
            str2 = "1";
        }
        linkedHashMap.put(StartupReportKey.PAUSED_FLAG, str2);
        return linkedHashMap;
    }

    private final Map<String, String> convertEntity2Map(String qqUin, MiniGameStartupReportEntity entity) {
        String str = entity.startupId + "_" + qqUin;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str2 = entity.appId;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.appId");
        linkedHashMap.put("appid", str2);
        linkedHashMap.put(StartupReportKey.STARTUP_ID, str);
        linkedHashMap.put(StartupReportKey.APPINFO_FLAG, String.valueOf(entity.appInfoFlag));
        String str3 = entity.gameEngineFlag;
        Intrinsics.checkNotNullExpressionValue(str3, "entity.gameEngineFlag");
        linkedHashMap.put(StartupReportKey.GAME_ENGINE_FLAG, str3);
        String str4 = entity.startupFlag;
        Intrinsics.checkNotNullExpressionValue(str4, "entity.startupFlag");
        linkedHashMap.put(StartupReportKey.STARTUP_FLAG, str4);
        String str5 = entity.preloadFlag;
        Intrinsics.checkNotNullExpressionValue(str5, "entity.preloadFlag");
        linkedHashMap.put("preload_flag", str5);
        String str6 = entity.adFlag;
        Intrinsics.checkNotNullExpressionValue(str6, "entity.adFlag");
        linkedHashMap.put(StartupReportKey.AD_FLAG, str6);
        linkedHashMap.put(StartupReportKey.PLATFORM_ID, "0");
        String str7 = entity.apkgState;
        Intrinsics.checkNotNullExpressionValue(str7, "entity.apkgState");
        linkedHashMap.put(StartupReportKey.APKG_STATE, str7);
        linkedHashMap.put(StartupReportKey.APKG_SIZE, String.valueOf(entity.apkgSize));
        linkedHashMap.put(StartupReportKey.STARTUP_SCENE, String.valueOf(entity.startupScene));
        linkedHashMap.put(StartupReportKey.ENGINE_TYPE, "0");
        linkedHashMap.put(StartupReportKey.EVENT_TIME, String.valueOf(entity.occurredTime));
        linkedHashMap.put(StartupReportKey.RELATIVE_TIME, String.valueOf(entity.relativeTime));
        linkedHashMap.put("device_level", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        linkedHashMap.put(StartupReportKey.USER_UIN, qqUin);
        linkedHashMap.put(StartupReportKey.DEBUG_FLAG, "0");
        linkedHashMap.put("version_type", String.valueOf(entity.versionType));
        String str8 = entity.versionId;
        Intrinsics.checkNotNullExpressionValue(str8, "entity.versionId");
        linkedHashMap.put(StartupReportKey.VERSION_ID, str8);
        String str9 = entity.via;
        Intrinsics.checkNotNullExpressionValue(str9, "entity.via");
        linkedHashMap.put("via", str9);
        String str10 = entity.mode;
        Intrinsics.checkNotNullExpressionValue(str10, "entity.mode");
        linkedHashMap.put("mode", str10);
        String str11 = entity.extReportData;
        Intrinsics.checkNotNullExpressionValue(str11, "entity.extReportData");
        linkedHashMap.put(StartupReportKey.EXT_REPORT_DATA, str11);
        return linkedHashMap;
    }

    private final MiniAppEntityManager getEntityManager() {
        WeakReference<MiniAppEntityManager> weakReference = entityManagerRef;
        MiniAppEntityManager miniAppEntityManager = weakReference != null ? weakReference.get() : null;
        if (miniAppEntityManager != null) {
            return miniAppEntityManager;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            Manager manager = runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
            if (manager instanceof MiniAppEntityManager) {
                entityManagerRef = new WeakReference<>(manager);
                return (MiniAppEntityManager) manager;
            }
        }
        return null;
    }

    private final String getTableName() {
        String simpleName = MiniGameStartupReportEntity.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "MiniGameStartupReportEntity::class.java.simpleName");
        return simpleName;
    }

    private final void handleDirtyData(MiniAppEntityManager entityManager) {
        AppRuntime runtime;
        if (System.currentTimeMillis() - lastCheckTime < 1800000) {
            return;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String currentUin = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getCurrentUin();
        if (currentUin == null) {
            return;
        }
        List<? extends Entity> queryEntity = entityManager.queryEntity(MiniGameStartupReportEntity.class, false, null, null, null, null, null, null);
        if (queryEntity != null && queryEntity.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (queryEntity != null) {
            for (Entity entity : queryEntity) {
                if (entity instanceof MiniGameStartupReportEntity) {
                    MiniGameStartupReportEntity miniGameStartupReportEntity = (MiniGameStartupReportEntity) entity;
                    boolean z16 = System.currentTimeMillis() - miniGameStartupReportEntity.occurredTime >= 1800000;
                    if (QLog.isDebugVersion()) {
                        QLog.i(TAG, 2, "handleDirtyData needHandle=" + z16 + ", entity=" + entity);
                    }
                    if (z16) {
                        arrayList.add(new RemoveTransaction(entity));
                        if (miniGameStartupReportEntity.appType == 1) {
                            MiniGameStartupReporter miniGameStartupReporter = INSTANCE;
                            Map<String, String> convertEntity2Map = miniGameStartupReporter.convertEntity2Map(currentUin, miniGameStartupReportEntity);
                            String str = miniGameStartupReportEntity.eventName;
                            Intrinsics.checkNotNullExpressionValue(str, "entity.eventName");
                            miniGameStartupReporter.realReport(convertEntity2Map, str, miniGameStartupReportEntity.versionType);
                        }
                    }
                }
            }
        }
        entityManager.doMultiDBOperateByTransaction(arrayList);
        lastCheckTime = System.currentTimeMillis();
    }

    private final void processReportData(MiniAppEntityManager entityManager, StartupReportData reportData) {
        AppRuntime runtime;
        if (Intrinsics.areEqual(StartupReportUtil.EVENT_DELETE, reportData.getEventName())) {
            QLog.i(TAG, 4, "deleteDataByID count=" + entityManager.delete(MiniGameStartupReportEntity.class.getSimpleName(), ID_WHERE_CLAUSE, new String[]{reportData.getStartupId()}));
            return;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String currentUin = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getCurrentUin();
        if (currentUin == null) {
            return;
        }
        if (directReportSet.contains(reportData.getEventName())) {
            realReport(convertData2Map(currentUin, reportData), reportData.getEventName(), reportData.getVersionType());
        } else if (Intrinsics.areEqual(StartupReportUtil.EVENT_LOADING_BEGIN, reportData.getEventName())) {
            reportLoadingData(entityManager, currentUin, reportData);
        } else {
            updateReportData2DB(entityManager, reportData);
        }
    }

    private final void realReport(Map<String, String> reportMap, String eventName, int versionType) {
        MiniGameBeaconReport.reportSync(eventName, reportMap);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "realReport eventName=" + eventName + ", reportMap=" + reportMap);
        }
        if (versionType == 2) {
            reportStartUpEventForAudit(eventName, reportMap);
        }
    }

    @JvmStatic
    public static final void report(StartupReportData reportData) {
        MiniGameStartupReporter miniGameStartupReporter;
        MiniAppEntityManager entityManager;
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if ((reportData.getStartupId().length() == 0) || (entityManager = (miniGameStartupReporter = INSTANCE).getEntityManager()) == null) {
            return;
        }
        miniGameStartupReporter.processReportData(entityManager, reportData);
        miniGameStartupReporter.handleDirtyData(entityManager);
    }

    private final void reportLoadingData(MiniAppEntityManager entityManager, String qqUin, StartupReportData loadingData) {
        Map<String, String> convertData2Map = convertData2Map(qqUin, loadingData);
        realReport(convertData2Map, loadingData.getEventName(), loadingData.getVersionType());
        List<? extends Entity> queryEntity = entityManager.queryEntity(MiniGameStartupReportEntity.class, false, ID_WHERE_CLAUSE, new String[]{loadingData.getStartupId()}, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (queryEntity != null) {
            for (Entity entity : queryEntity) {
                if (entity instanceof MiniGameStartupReportEntity) {
                    MiniGameStartupReportEntity miniGameStartupReportEntity = (MiniGameStartupReportEntity) entity;
                    convertData2Map.put(StartupReportKey.EVENT_TIME, String.valueOf(miniGameStartupReportEntity.occurredTime));
                    convertData2Map.put(StartupReportKey.RELATIVE_TIME, String.valueOf(miniGameStartupReportEntity.relativeTime));
                    String str = miniGameStartupReportEntity.eventName;
                    Intrinsics.checkNotNullExpressionValue(str, "entity.eventName");
                    realReport(convertData2Map, str, loadingData.getVersionType());
                }
                arrayList.add(new RemoveTransaction(entity));
            }
        }
        entityManager.doMultiDBOperateByTransaction(arrayList);
    }

    private final void reportStartUpEventForAudit(String eventName, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put("event_name", eventName);
        MiniAppSSORequestClient miniAppSSORequestClient = MiniAppSSORequestClient.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
        miniAppSSORequestClient.sendReq(new ReportLaunchEventRequest(jSONObject2), new MiniAppSSOReqCallback() { // from class: com.tencent.mobileqq.minigame.report.MiniGameStartupReporter$reportStartUpEventForAudit$2
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public void onResponse(MiniAppSSOResponse response) {
                if (response != null && QLog.isColorLevel()) {
                    QLog.d("MiniGameStartupReporter", 2, "reportStartUpEventForAudit code=" + response.getRetCode() + ", msg=" + response.getErrMsg());
                }
            }
        });
    }

    private final void updateReportData2DB(MiniAppEntityManager entityManager, StartupReportData reportData) {
        MiniGameStartupReportEntity convertData2Entity = convertData2Entity(reportData);
        convertData2Entity.setStatus(1000);
        entityManager.insertOrReplaceEntity(convertData2Entity);
        if (Intrinsics.areEqual(StartupReportUtil.EVENT_APP_INFO, reportData.getEventName()) || Intrinsics.areEqual(StartupReportUtil.EVENT_START_UI, reportData.getEventName())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gameEngineFlag", String.valueOf(reportData.getGameEngineFlag()));
            contentValues.put("appType", Integer.valueOf(reportData.getAppType()));
            entityManager.update(getTableName(), contentValues, ID_WHERE_CLAUSE, new String[]{reportData.getStartupId()});
        }
    }
}
