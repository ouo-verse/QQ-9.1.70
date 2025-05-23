package com.tencent.qqmini.map.proxyImpl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.map.CoverMapView;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

@ProxyService(proxy = MapProxy.class)
/* loaded from: classes23.dex */
public class MapProxyImplDefault extends MapProxy {
    public static final String TAG = "MapProxyImplDefault";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBuildBitmapFromViewSuccess(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy
    public void captureImage(IMiniAppContext iMiniAppContext, final View view, ViewGroup viewGroup, final MapProxy.MapSnapshotCallback mapSnapshotCallback) {
        SaveCaptureImageUtil.e(iMiniAppContext.getAttachedActivity(), view, new SaveCaptureImageUtil.b() { // from class: com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1
            @Override // com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil.b
            public void onScreenShotFinished(int i3, final Bitmap bitmap) {
                MapProxy.MapSnapshotCallback mapSnapshotCallback2;
                View view2 = view;
                if ((view2 instanceof CoverMapView) && ((CoverMapView) view2).getLoadMapState()) {
                    ((CoverMapView) view).captureImage(new TencentMap.SnapshotReadyCallback() { // from class: com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1.1
                        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
                        public void onSnapshotReady(Bitmap bitmap2) {
                            MapProxy.MapSnapshotCallback mapSnapshotCallback3;
                            if (bitmap2 != null) {
                                QMLog.d(MapProxyImplDefault.TAG, "onCaptureImageSucceed " + bitmap2.getWidth() + HippyTKDListViewAdapter.X + bitmap2.getHeight());
                                if (MapProxyImplDefault.this.isBuildBitmapFromViewSuccess(bitmap2) && mapSnapshotCallback != null) {
                                    Canvas canvas = new Canvas(bitmap2);
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                                    canvas.drawBitmap(bitmap2, marginLayoutParams.leftMargin, marginLayoutParams.topMargin, (Paint) null);
                                    mapSnapshotCallback.onSnapshotReady(bitmap);
                                    return;
                                }
                                MapProxy.MapSnapshotCallback mapSnapshotCallback4 = mapSnapshotCallback;
                                if (mapSnapshotCallback4 != null) {
                                    mapSnapshotCallback4.onSnapshotReady(null);
                                    return;
                                }
                                return;
                            }
                            if (MapProxyImplDefault.this.isBuildBitmapFromViewSuccess(bitmap) && (mapSnapshotCallback3 = mapSnapshotCallback) != null) {
                                mapSnapshotCallback3.onSnapshotReady(bitmap);
                                return;
                            }
                            MapProxy.MapSnapshotCallback mapSnapshotCallback5 = mapSnapshotCallback;
                            if (mapSnapshotCallback5 != null) {
                                mapSnapshotCallback5.onSnapshotReady(null);
                            }
                        }
                    });
                    return;
                }
                if (MapProxyImplDefault.this.isBuildBitmapFromViewSuccess(bitmap) && (mapSnapshotCallback2 = mapSnapshotCallback) != null) {
                    mapSnapshotCallback2.onSnapshotReady(bitmap);
                    return;
                }
                MapProxy.MapSnapshotCallback mapSnapshotCallback3 = mapSnapshotCallback;
                if (mapSnapshotCallback3 != null) {
                    mapSnapshotCallback3.onSnapshotReady(null);
                }
            }
        });
    }
}
