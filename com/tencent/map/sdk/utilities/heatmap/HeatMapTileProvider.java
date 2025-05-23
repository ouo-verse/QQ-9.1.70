package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes9.dex */
public abstract class HeatMapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 40;
    private static final int MAX_RADIUS = 50;
    private static final int MIN_RADIUS = 10;
    static final double WORLD_WIDTH = 1.0d;

    /* loaded from: classes9.dex */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private HeatTileGenerator heatTileGenerator;
        private OnHeatMapReadyListener readyListener;
        private int radius = 40;
        private Gradient gradient = HeatMapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatMapTileProvider build(TencentMap tencentMap) {
            if (tencentMap != null) {
                return tencentMap.getMapContext().createHeatMapTileProvider(this);
            }
            return null;
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatMapTileProvider.wrapData(collection));
        }

        public Collection<WeightedLatLng> getData() {
            return this.data;
        }

        public Gradient getGradient() {
            return this.gradient;
        }

        public HeatTileGenerator getHeatTileGenerator() {
            return this.heatTileGenerator;
        }

        public double getOpacity() {
            return this.opacity;
        }

        public int getRadius() {
            return this.radius;
        }

        public OnHeatMapReadyListener getReadyListener() {
            return this.readyListener;
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder opacity(double d16) {
            if (d16 >= 0.0d && d16 <= 1.0d) {
                this.opacity = d16;
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public Builder radius(int i3) {
            if (i3 >= 10 && i3 <= 50) {
                this.radius = i3;
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder readyListener(OnHeatMapReadyListener onHeatMapReadyListener) {
            this.readyListener = onHeatMapReadyListener;
            return this;
        }

        public Builder tileGenerator(HeatTileGenerator heatTileGenerator) {
            this.heatTileGenerator = heatTileGenerator;
            return this;
        }

        public <T extends com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng> Builder weightedData(Collection<T> collection) {
            if (!collection.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (T t16 : collection) {
                    arrayList.add(new WeightedLatLng(t16.getPoint(), t16.getIntensity()));
                }
                this.data = arrayList;
                return this;
            }
            throw new IllegalArgumentException("No input points.");
        }
    }

    /* loaded from: classes9.dex */
    public interface HeatTileGenerator {
        int[] generateColorMap(double d16);

        double[] generateKernel(int i3);
    }

    /* loaded from: classes9.dex */
    public interface OnHeatMapReadyListener {
        void onHeatMapReady();
    }

    static {
        int[] iArr = {Color.argb(0, 25, 0, 255), Color.argb(170, 30, 0, 255), Color.rgb(0, 191, 255), Color.rgb(0, 255, 0), Color.rgb(255, 255, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.0f, 0.4f, 0.6f, 0.75f, 0.8f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public abstract void setData(Collection<LatLng> collection);

    public abstract void setGradient(Gradient gradient);

    public abstract void setHeatTileGenerator(HeatTileGenerator heatTileGenerator);

    public abstract void setOpacity(double d16);

    public abstract void setRadius(int i3);

    public abstract <T extends com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng> void setWeightedData(Collection<T> collection);
}
