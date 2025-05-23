package com.qzone.proxy.personalitycomponent.canvasui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasPersonalityDownLoader;
import com.qzone.proxy.personalitycomponent.model.WidgetPublicCacheData;
import com.tencent.ditto.area.DittoArea;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loverzone.a;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import fo.c;
import java.util.HashMap;
import java.util.Map;
import yo.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCanvasWidgetView extends QzoneCanvasAreaView {

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f50969d;

    public QZoneCanvasWidgetView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        onRecycled();
        setContentAreaForJsonFile(str, true);
        updateViewModel(this.f50969d);
        QZoneCanvasPersonalityUtil.reportBeacon(QZoneCanvasPersonalityUtil.MTA_EVENT_KEY_CANVAS_PERSONALITY, QZoneCanvasPersonalityUtil.MTA_SUB_KEY_VIEW_SHOW, "success");
        Map<String, Object> map = this.f50969d;
        if (map == null || !map.containsKey("jump_url")) {
            return;
        }
        Object obj = this.f50969d.get("jump_url");
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2) || !obj2.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP)) {
                return;
            }
            a.a("4", "1", "1", "");
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", 3);
            c.g("em_qz_pendant", "pg_bas_social_updates", this, hashMap);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, com.tencent.ditto.area.DittoHost
    public void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", 3);
            c.e("em_qz_pendant", "pg_bas_social_updates", this, hashMap);
            d.d(str, BaseApplication.getContext(), null);
            return;
        }
        QZLog.e("QZoneCanvasWidgetView", "handleUri = null");
    }

    public void refreshFailed(String str) {
        QZLog.e("QZoneCanvasWidgetView", "refreshFailed = " + str);
        QZoneCanvasPersonalityUtil.reportBeacon(QZoneCanvasPersonalityUtil.MTA_EVENT_KEY_CANVAS_PERSONALITY, QZoneCanvasPersonalityUtil.MTA_SUB_KEY_GET_WIDGET_FAIL, str);
    }

    public QZoneCanvasWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void update(Object obj) {
        if (obj != null && (obj instanceof WidgetPublicCacheData)) {
            WidgetPublicCacheData widgetPublicCacheData = (WidgetPublicCacheData) obj;
            this.f50969d = widgetPublicCacheData.dataMap;
            QZoneCanvasPersonalityDownLoader.getInstance().loadPersonalityFile(widgetPublicCacheData.tmpUrl, new QZoneCanvasPersonalityDownLoader.OnPersonalityLoadListener() { // from class: com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasWidgetView.1
                @Override // com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasPersonalityDownLoader.OnPersonalityLoadListener
                public void onLoadFail(String str) {
                    QZLog.e("QZoneCanvasWidgetView", "onLoadFail: " + str);
                    QZoneCanvasPersonalityUtil.reportBeacon(QZoneCanvasPersonalityUtil.MTA_EVENT_KEY_CANVAS_PERSONALITY, QZoneCanvasPersonalityUtil.MTA_SUB_KEY_JSON_DOWN_LOAD, str);
                }

                @Override // com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasPersonalityDownLoader.OnPersonalityLoadListener
                public void onLoadSuccess(final String str) {
                    if (QZLog.isColorLevel()) {
                        QZLog.i("QZoneCanvasWidgetView", "onLoadSuccess: " + str);
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasWidgetView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneCanvasWidgetView.this.b(str);
                        }
                    });
                }
            });
        }
    }
}
