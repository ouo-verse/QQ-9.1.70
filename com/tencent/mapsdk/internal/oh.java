package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class oh extends ScatterPlotInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    ScatterPlotOverlayProvider f149477a;

    public oh(Context context, ScatterPlotOverlayProvider scatterPlotOverlayProvider) {
        this.f149477a = scatterPlotOverlayProvider;
        ArrayList arrayList = new ArrayList();
        arrayList.add(scatterPlotOverlayProvider.getData());
        setDataList(arrayList);
        this.visible = scatterPlotOverlayProvider.isVisibility();
        this.opacity = scatterPlotOverlayProvider.getOpacity();
        this.maxZoom = scatterPlotOverlayProvider.getMaxZoom();
        this.minZoom = scatterPlotOverlayProvider.getMinZoom();
        this.draw3D = scatterPlotOverlayProvider.isEnable3D();
        this.level = scatterPlotOverlayProvider.getDisplayLevel();
        this.mType = scatterPlotOverlayProvider.getType();
        this.zIndex = scatterPlotOverlayProvider.getZIndex();
        this.outterVectorOverlayLoadListener = scatterPlotOverlayProvider.getVectorOverlayLoadedListener();
        if (scatterPlotOverlayProvider instanceof DotScatterPlotOverlayProvider) {
            DotScatterPlotOverlayProvider dotScatterPlotOverlayProvider = (DotScatterPlotOverlayProvider) scatterPlotOverlayProvider;
            this.radius = dotScatterPlotOverlayProvider.getRadius();
            this.colors = dotScatterPlotOverlayProvider.getColors();
            this.mAnimate = dotScatterPlotOverlayProvider.isAnimate();
            return;
        }
        if (scatterPlotOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
            BitmapScatterPlotOverlayProvider bitmapScatterPlotOverlayProvider = (BitmapScatterPlotOverlayProvider) scatterPlotOverlayProvider;
            this.mBitmapWidth = bitmapScatterPlotOverlayProvider.getWidth();
            this.mBitmapHeight = bitmapScatterPlotOverlayProvider.getHeight();
            if (bitmapScatterPlotOverlayProvider.getBitmaps() != null && bitmapScatterPlotOverlayProvider.getBitmaps().length > 0) {
                this.mBitmaps = new Bitmap[bitmapScatterPlotOverlayProvider.getBitmaps().length];
                for (int i3 = 0; i3 < bitmapScatterPlotOverlayProvider.getBitmaps().length; i3++) {
                    BitmapDescriptor bitmapDescriptor = bitmapScatterPlotOverlayProvider.getBitmaps()[i3];
                    if (bitmapDescriptor != null) {
                        Bitmap bitmap = bitmapDescriptor.getBitmap(context);
                        if (bitmap != null && (this.mBitmapWidth != bitmap.getWidth() || this.mBitmapHeight != bitmap.getHeight())) {
                            int i16 = this.mBitmapWidth;
                            int i17 = this.mBitmapHeight;
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.postScale(i16 / width, i17 / height);
                            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                        }
                        this.mBitmaps[i3] = bitmap;
                    } else {
                        this.mBitmaps[i3] = null;
                    }
                }
            }
        }
    }

    private static Bitmap a(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private ScatterPlotOverlayProvider a() {
        return this.f149477a;
    }
}
