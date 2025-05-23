package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class PolygonOptions {
    private static final int COLOR_DEFAULT_POLYGON = Color.argb(200, 0, 163, 255);
    private List<Integer> pattern;
    private BitmapDescriptor texture;
    private int textureSpacing;
    private int iLevel = 2;
    private float fStrokeWidth = 1.0f;
    private int iStrokeColor = -16777216;
    private boolean mClickable = true;
    private int iFillColor = COLOR_DEFAULT_POLYGON;
    private int iZindex = 0;
    private boolean boIsVisble = true;
    private final List<LatLng> listPts = new ArrayList();
    private final List<List<LatLng>> holePts = new ArrayList();

    public PolygonOptions add(LatLng latLng) {
        if (latLng != null) {
            this.listPts.add(latLng);
        }
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            Iterator<LatLng> it = iterable.iterator();
            while (it.hasNext()) {
                this.listPts.add(it.next());
            }
        }
        return this;
    }

    public PolygonOptions clickable(boolean z16) {
        this.mClickable = z16;
        return this;
    }

    public PolygonOptions fillColor(int i3) {
        this.iFillColor = i3;
        return this;
    }

    public int getFillColor() {
        return this.iFillColor;
    }

    public List<List<LatLng>> getHolePoints() {
        return this.holePts;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public List<LatLng> getPoints() {
        return this.listPts;
    }

    public int getStrokeColor() {
        return this.iStrokeColor;
    }

    public float getStrokeWidth() {
        return this.fStrokeWidth;
    }

    public BitmapDescriptor getTexture() {
        return this.texture;
    }

    public int getTextureSpacing() {
        return this.textureSpacing;
    }

    public float getZIndex() {
        return this.iZindex;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isValid() {
        List<LatLng> list = this.listPts;
        if (list != null && list.size() > 2) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        return this.boIsVisble;
    }

    public PolygonOptions level(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            this.iLevel = i3;
        }
        return this;
    }

    public PolygonOptions pattern(List<Integer> list) {
        this.pattern = list;
        this.texture = null;
        return this;
    }

    public PolygonOptions setHolePoints(List<List<LatLng>> list) {
        this.holePts.clear();
        if (list == null) {
            return this;
        }
        this.holePts.addAll(list);
        return this;
    }

    public void setPoints(Iterable<LatLng> iterable) {
        this.listPts.clear();
        if (iterable == null) {
            return;
        }
        addAll(iterable);
    }

    public PolygonOptions strokeColor(int i3) {
        this.iStrokeColor = i3;
        this.texture = null;
        return this;
    }

    public PolygonOptions strokeWidth(float f16) {
        if (f16 < 0.0f) {
            this.fStrokeWidth = 1.0f;
        } else {
            this.fStrokeWidth = f16;
        }
        return this;
    }

    public PolygonOptions texture(BitmapDescriptor bitmapDescriptor) {
        this.texture = bitmapDescriptor;
        return this;
    }

    public PolygonOptions textureSpacing(int i3) {
        this.textureSpacing = i3;
        return this;
    }

    public String toString() {
        return "PolygonOptions{listPts=" + this.listPts + ", iFillColor=" + this.iFillColor + ", iZindex=" + this.iZindex + ", boIsVisble=" + this.boIsVisble + ", mClickable=" + this.mClickable + ", holePts=" + this.holePts + ", fStrokeWidth=" + this.fStrokeWidth + ", iStrokeColor=" + this.iStrokeColor + ", pattern=" + this.pattern + ", texture=" + this.texture + ", textureSpacing=" + this.textureSpacing + ", iLevel=" + this.iLevel + '}';
    }

    public PolygonOptions visible(boolean z16) {
        this.boIsVisble = z16;
        return this;
    }

    public PolygonOptions zIndex(int i3) {
        this.iZindex = i3;
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            this.listPts.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        if (list != null) {
            this.listPts.addAll(list);
        }
        return this;
    }
}
