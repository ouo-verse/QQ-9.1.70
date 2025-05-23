package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClientFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EmbeddedWidgetClientFactory implements IEmbeddedWidgetClientFactory {
    private static final String TAG = "miniapp-embedded";
    private ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> embeddedWidgetClientHolderMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Long> mappingTableMap = new ConcurrentHashMap<>();

    private boolean doEventByWidgetId(String str, IMiniAppContext iMiniAppContext, int i3, JSONObject jSONObject, long j3, IJsService iJsService) {
        ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> concurrentHashMap = this.embeddedWidgetClientHolderMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j3))) {
            EmbeddedWidgetClientHolder embeddedWidgetClientHolder = this.embeddedWidgetClientHolderMap.get(Long.valueOf(j3));
            if (embeddedWidgetClientHolder == null) {
                return false;
            }
            embeddedWidgetClientHolder.handleEmbeddedWidgetEvent(str, iMiniAppContext, jSONObject, i3, iJsService);
            return true;
        }
        QMLog.e(TAG, "doEventByWidgetId x5WidgetId is not exist");
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClientFactory
    public IEmbeddedWidgetClient createWidgetClient(String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        try {
            QMLog.i(TAG, "createWidgetClient, tagName:" + str + ", attributes:" + map.toString());
            if (str.equalsIgnoreCase("VIDEO")) {
                EmbeddedWidgetClientHolder embeddedWidgetClientHolder = new EmbeddedWidgetClientHolder(str, map, iEmbeddedWidget);
                this.embeddedWidgetClientHolderMap.put(Long.valueOf(iEmbeddedWidget.getWidgetId()), embeddedWidgetClientHolder);
                return embeddedWidgetClientHolder;
            }
            return null;
        } catch (Throwable th5) {
            QMLog.e(TAG, "createWidgetClient error.", th5);
            return null;
        }
    }

    public void destroy() {
        QMLog.i(TAG, "destroy!");
        Collection<EmbeddedWidgetClientHolder> values = this.embeddedWidgetClientHolderMap.values();
        this.embeddedWidgetClientHolderMap.clear();
        this.mappingTableMap.clear();
        Iterator<EmbeddedWidgetClientHolder> it = values.iterator();
        while (it.hasNext()) {
            it.next().nativeDestroy();
        }
    }

    public Map<Long, EmbeddedWidgetClientHolder> getEmbeddedWidgetClientHolderMap() {
        return this.embeddedWidgetClientHolderMap;
    }

    public boolean handleEmbeddedWidgetDestory(long j3) {
        ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> concurrentHashMap = this.embeddedWidgetClientHolderMap;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j3))) {
            QMLog.d(TAG, "embeddedWidgetClientHolderMap remove " + j3);
            EmbeddedWidgetClientHolder embeddedWidgetClientHolder = this.embeddedWidgetClientHolderMap.get(Long.valueOf(j3));
            if (embeddedWidgetClientHolder != null) {
                this.mappingTableMap.remove(Integer.valueOf(embeddedWidgetClientHolder.getViewId()));
                QMLog.i(TAG, "mappingTableMap remove " + embeddedWidgetClientHolder.getViewId());
            }
            this.embeddedWidgetClientHolderMap.remove(Long.valueOf(j3));
            return true;
        }
        return true;
    }

    public boolean handleEmbeddedWidgetEvent(String str, IMiniAppContext iMiniAppContext, String str2, int i3, IJsService iJsService) {
        ConcurrentHashMap<Integer, Long> concurrentHashMap;
        try {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "handleEmbeddedWidgetEvent event : " + str + "; jsonParams : " + str2);
            }
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("viewId", -1);
            long optLong = jSONObject.optLong("x5WidgetId", -1L);
            if (optLong != -1) {
                if (optInt != -1 && (concurrentHashMap = this.mappingTableMap) != null) {
                    concurrentHashMap.put(Integer.valueOf(optInt), Long.valueOf(optLong));
                    QMLog.i(TAG, "handleEmbeddedWidgetEvent viewId " + optInt + " x5WidgetId:" + optLong);
                }
                return doEventByWidgetId(str, iMiniAppContext, i3, jSONObject, optLong, iJsService);
            }
            ConcurrentHashMap<Integer, Long> concurrentHashMap2 = this.mappingTableMap;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(Integer.valueOf(optInt))) {
                return doEventByWidgetId(str, iMiniAppContext, i3, jSONObject, this.mappingTableMap.get(Integer.valueOf(optInt)).longValue(), iJsService);
            }
            if (this.mappingTableMap != null) {
                QMLog.e(TAG, "handleInsertEmbeddedWidgetEvent view is not exist mappingTableMap:" + this.mappingTableMap + " viewId:" + optInt);
                return false;
            }
            QMLog.e(TAG, "handleInsertEmbeddedWidgetEvent view is not exist viewId:" + optInt);
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleEmbeddedWidgetEvent error.", th5);
            return false;
        }
    }

    public boolean handleInsertEmbeddedWidgetEvent(String str, IMiniAppContext iMiniAppContext, String str2, IJsService iJsService) {
        JSONObject jSONObject;
        long optLong;
        ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> concurrentHashMap;
        ConcurrentHashMap<Integer, Long> concurrentHashMap2;
        try {
            jSONObject = new JSONObject(str2);
            optLong = jSONObject.optLong("x5WidgetId", 0L);
            concurrentHashMap = this.embeddedWidgetClientHolderMap;
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleInsertEmbeddedWidgetEvent error.", th5);
        }
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(optLong))) {
            int optInt = jSONObject.optInt("viewId", -1);
            if (optInt != -1 && (concurrentHashMap2 = this.mappingTableMap) != null) {
                concurrentHashMap2.put(Integer.valueOf(optInt), Long.valueOf(optLong));
                QMLog.i(TAG, "handleInsertEmbeddedWidgetEvent viewId " + optInt + " x5WidgetId:" + optLong);
            }
            EmbeddedWidgetClientHolder embeddedWidgetClientHolder = this.embeddedWidgetClientHolderMap.get(Long.valueOf(optLong));
            if (embeddedWidgetClientHolder != null) {
                embeddedWidgetClientHolder.handleInsertEmbeddedWidgetEvent(str, iMiniAppContext, jSONObject, iJsService);
                return true;
            }
            return false;
        }
        QMLog.e(TAG, "handleInsertEmbeddedWidgetEvent x5WidgetId is not exist");
        return false;
    }

    public void pause() {
        Iterator<EmbeddedWidgetClientHolder> it = this.embeddedWidgetClientHolderMap.values().iterator();
        while (it.hasNext()) {
            it.next().nativePause();
        }
    }

    public void resume() {
        Iterator<EmbeddedWidgetClientHolder> it = this.embeddedWidgetClientHolderMap.values().iterator();
        while (it.hasNext()) {
            it.next().nativeResume();
        }
    }
}
