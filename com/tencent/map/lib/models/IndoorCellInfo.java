package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public final class IndoorCellInfo {
    private List<String> areaIds = new ArrayList();
    private Style style;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Style {
        private int color;

        public Style(int i3) {
            this.color = i3;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i3) {
            this.color = i3;
        }

        public String toString() {
            return "Style{color=" + Integer.toHexString(this.color) + '}';
        }
    }

    public IndoorCellInfo(@NonNull Style style) {
        this.style = style;
    }

    public final void addAreaId(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.areaIds.add(str);
        }
    }

    @NonNull
    public final List<String> getAreaIds() {
        return this.areaIds;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(Style style) {
        this.style = style;
    }

    public final String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder("IndoorCellInfo{areaIds=");
        sb5.append(this.areaIds);
        sb5.append(", style=");
        Style style = this.style;
        if (style != null) {
            str = style.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
