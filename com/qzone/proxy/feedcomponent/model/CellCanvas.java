package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_canvas;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasAdInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCanvas implements SmartParcelable {

    @NeedParcel
    public CanvasAdInfo canvasAdInfo;

    @NeedParcel
    public String canvasData;

    @NeedParcel
    public String guideText;

    @NeedParcel
    public int jumpType;

    @NeedParcel
    public boolean showBreathLight;

    @NeedParcel
    public boolean showGuideBar;

    private static CanvasAdInfo getCanvasAdInfo(String str) {
        return v8.a.l(str);
    }

    public boolean jsonDataParseError() {
        return getCanvasAdInfo() == null;
    }

    public CanvasAdInfo getCanvasAdInfo() {
        CanvasAdInfo canvasAdInfo = this.canvasAdInfo;
        return canvasAdInfo == null ? getCanvasAdInfo(this.canvasData) : canvasAdInfo;
    }

    public static CellCanvas create(l lVar) {
        if (lVar == null || lVar.f50351f0 == null) {
            return null;
        }
        CellCanvas cellCanvas = new CellCanvas();
        cell_canvas cell_canvasVar = lVar.f50351f0;
        cellCanvas.guideText = cell_canvasVar.guide_text;
        String str = cell_canvasVar.canvas_data;
        cellCanvas.canvasData = str;
        cellCanvas.jumpType = cell_canvasVar.jump_type;
        cellCanvas.showBreathLight = cell_canvasVar.show_breath_light;
        cellCanvas.showGuideBar = cell_canvasVar.show_guide_bar;
        cellCanvas.canvasAdInfo = getCanvasAdInfo(str);
        return cellCanvas;
    }
}
