package com.tencent.mobileqq.vas.transit;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;", "Ljava/io/Serializable;", "", "toString", "", ISchemeApi.KEY_TRANSIT_TYPE, "I", "getTransitType", "()I", "setTransitType", "(I)V", "needTransitPageWhenReady", "getNeedTransitPageWhenReady", "setNeedTransitPageWhenReady", "uiStyle", "getUiStyle", "setUiStyle", "", "singlePageMode", "Z", "getSinglePageMode", "()Z", "setSinglePageMode", "(Z)V", "showGoldEntry", "getShowGoldEntry", "setShowGoldEntry", "<init>", "()V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TransitPageConfig implements Serializable {
    public static final int NEED_TRANSIT = 1;
    public static final int NO_NEED_TRANSIT = 0;
    public static final int TRANSIT_TYPE_CHANNEL = 1;
    public static final int TRANSIT_TYPE_UIN = 0;
    public static final int UI_STYLE_DEFAULT = 0;
    public static final int UI_STYLE_FULL_SCREEN = 1;
    private int needTransitPageWhenReady;
    private boolean showGoldEntry;
    private boolean singlePageMode;
    private int transitType;
    private int uiStyle;

    public final int getNeedTransitPageWhenReady() {
        return this.needTransitPageWhenReady;
    }

    public final boolean getShowGoldEntry() {
        return this.showGoldEntry;
    }

    public final boolean getSinglePageMode() {
        return this.singlePageMode;
    }

    public final int getTransitType() {
        return this.transitType;
    }

    public final int getUiStyle() {
        return this.uiStyle;
    }

    public final void setNeedTransitPageWhenReady(int i3) {
        this.needTransitPageWhenReady = i3;
    }

    public final void setShowGoldEntry(boolean z16) {
        this.showGoldEntry = z16;
    }

    public final void setSinglePageMode(boolean z16) {
        this.singlePageMode = z16;
    }

    public final void setTransitType(int i3) {
        this.transitType = i3;
    }

    public final void setUiStyle(int i3) {
        this.uiStyle = i3;
    }

    @NotNull
    public String toString() {
        return "TransitPageConfig(transitType=" + this.transitType + ", needTransitPageWhenReady=" + this.needTransitPageWhenReady + ", uiStyle=" + this.uiStyle + ", singlePageMode=" + this.singlePageMode + ", showGoldEntry=" + this.showGoldEntry + ')';
    }
}
