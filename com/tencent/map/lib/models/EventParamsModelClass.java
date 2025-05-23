package com.tencent.map.lib.models;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes9.dex */
public class EventParamsModelClass {

    /* loaded from: classes9.dex */
    public static class ClickEventParams extends EventParams {

        @Json(name = "clickedPosition")
        public float[] clickedPosition;

        @Json(name = IECDtReport.ACTION_IDENTIFIER)
        public String identifier;

        @Json(name = "name")
        public String name;

        public ClickEventParams(String str, LatLng latLng, String str2, String str3) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_CLICK;
            this.layerId = str;
            this.clickedPosition = r3;
            float[] fArr = {(float) latLng.getLatitude()};
            this.clickedPosition[1] = (float) latLng.getLongitude();
            this.identifier = str2;
            this.name = str3;
        }
    }

    /* loaded from: classes9.dex */
    public static class EventParams extends JsonComposer {

        @Json(name = "eventType")
        public String eventType;

        @Json(name = "layerId")
        public String layerId;
    }

    /* loaded from: classes9.dex */
    public static class LoadFinishEventParams extends EventParams {
        public int errorCode;
        public String errorMsg;

        /* loaded from: classes9.dex */
        public enum LoadFinishInfo {
            ok(0, ""),
            errNetwork(1, "network error"),
            errAuth(2, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_AUTH),
            errDataDecode(3, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_DATA_DECODE),
            errDataAvailable(4, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_DATA_AVAILABLE),
            errInternal(20, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR);

            private int errorCode;
            private String errorMsg;

            LoadFinishInfo(int i3, String str) {
                this.errorCode = i3;
                this.errorMsg = str;
            }

            public static LoadFinishInfo getById(int i3) {
                for (LoadFinishInfo loadFinishInfo : values()) {
                    if (loadFinishInfo.checkStatus(i3)) {
                        return loadFinishInfo;
                    }
                }
                return ok;
            }

            public final boolean checkStatus(int i3) {
                if (this.errorCode == i3) {
                    return true;
                }
                return false;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMsg() {
                return this.errorMsg;
            }
        }

        public LoadFinishEventParams(String str, LoadFinishInfo loadFinishInfo) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_LAYER_LOAD_FINISH;
            this.layerId = str;
            this.errorCode = loadFinishInfo.errorCode;
            this.errorMsg = loadFinishInfo.errorMsg;
        }
    }

    /* loaded from: classes9.dex */
    public static class TranslateAnimationCompleteEventParams extends EventParams {
        public TranslateAnimationCompleteEventParams(String str) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_TRANSLATEANIMATION_COMPLETE;
            this.layerId = str;
        }
    }
}
