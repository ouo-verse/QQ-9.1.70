package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_theme;
import NS_MOBILE_FEEDS.s_picurl;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ProgressTracer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellTheme implements SmartParcelable {

    @NeedParcel
    public boolean isDeepColor;

    @NeedParcel
    public boolean isOptPalette;

    @NeedParcel
    public Map<Integer, PictureUrl> mapPhotoUrl;

    @NeedParcel
    public int majorForeColor = -1;

    @NeedParcel
    public int minorForeColor = Color.argb(51, 255, 255, 255);

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellTheme{");
        sb5.append("majorForeColor: ");
        sb5.append(this.majorForeColor);
        sb5.append(", ");
        sb5.append("minorForeColor: ");
        sb5.append(this.minorForeColor);
        sb5.append("\n");
        sb5.append("isDeepColor:");
        sb5.append(this.isDeepColor);
        sb5.append("\n");
        sb5.append("isOptPalette:");
        sb5.append(this.isOptPalette);
        sb5.append("\n");
        Map<Integer, PictureUrl> map = this.mapPhotoUrl;
        if (map != null) {
            sb5.append("mapPhotoUrl {");
            sb5.append("\n");
            for (Map.Entry<Integer, PictureUrl> entry : map.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellTheme create(l lVar) {
        if (lVar == null || lVar.M == null) {
            return null;
        }
        CellTheme cellTheme = new CellTheme();
        try {
            if (!TextUtils.isEmpty(lVar.M.major_forecolor)) {
                cellTheme.majorForeColor = Color.parseColor(lVar.M.major_forecolor);
            } else {
                cellTheme.majorForeColor = -16777216;
            }
            if (!TextUtils.isEmpty(lVar.M.minor_forecolor)) {
                cellTheme.minorForeColor = Color.parseColor(lVar.M.minor_forecolor);
            } else {
                cellTheme.minorForeColor = -16777216;
            }
        } catch (Exception unused) {
            cellTheme.majorForeColor = -16777216;
            cellTheme.minorForeColor = -16777216;
        }
        cell_theme cell_themeVar = lVar.M;
        cellTheme.isDeepColor = cell_themeVar.is_deepcolor;
        cellTheme.isOptPalette = cell_themeVar.is_optpalette;
        Map<Integer, s_picurl> map = cell_themeVar.photourl;
        if (map != null && map.size() > 0) {
            cellTheme.mapPhotoUrl = new HashMap();
            for (Map.Entry<Integer, s_picurl> entry : lVar.M.photourl.entrySet()) {
                cellTheme.mapPhotoUrl.put(entry.getKey(), com.qzone.proxy.feedcomponent.util.e.n(entry.getValue()));
            }
        }
        return cellTheme;
    }
}
