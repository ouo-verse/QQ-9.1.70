package com.qzone.module.feedcomponent.util;

import android.text.TextUtils;
import com.qzone.canvasui.gdtui.IGdtCanvasUi;
import com.qzone.canvasui.gdtui.asynarea.IGdtAsynArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtCanvasUiUtil {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface GDtCanvasUiAction {
        void doAction(IGdtCanvasUi iGdtCanvasUi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface GdtAsynAreaAction {
        void doAction(IGdtAsynArea iGdtAsynArea);
    }

    public static <T> T checkNotNull(T t16) {
        t16.getClass();
        return t16;
    }

    private static void doForEachSubView(GdtAsynAreaAction gdtAsynAreaAction, GDtCanvasUiAction gDtCanvasUiAction, DittoAreaView dittoAreaView) {
        try {
            DittoArea canvasArea = dittoAreaView.getCanvasArea();
            if (canvasArea instanceof DittoAreaGroup) {
                for (int i3 = 0; i3 < ((DittoAreaGroup) canvasArea).getChildCount(); i3++) {
                    doForOne(gdtAsynAreaAction, gDtCanvasUiAction, ((DittoAreaGroup) canvasArea).getChildAt(i3));
                }
                return;
            }
            doForOne(gdtAsynAreaAction, gDtCanvasUiAction, canvasArea);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void doForOne(GdtAsynAreaAction gdtAsynAreaAction, GDtCanvasUiAction gDtCanvasUiAction, DittoArea dittoArea) {
        if (dittoArea instanceof IGdtAsynArea) {
            gdtAsynAreaAction.doAction((IGdtAsynArea) dittoArea);
        } else if (dittoArea instanceof IGdtCanvasUi) {
            gDtCanvasUiAction.doAction((IGdtCanvasUi) dittoArea);
        }
    }

    public static LayoutAttrSet getHorizontalMarginAttr(int i3, int i16, int i17) {
        float density = DittoUIEngine.g().getDensity();
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.leftMargin = Math.round((i16 + ((i3 + i16) * i17)) * density);
        layoutAttrSet.centerVertical = true;
        float f16 = i3 * density;
        layoutAttrSet.width = Math.round(f16);
        layoutAttrSet.height = Math.round(f16);
        return layoutAttrSet;
    }

    public static void resetSubView(DittoAreaView dittoAreaView) {
        doForEachSubView(new GdtAsynAreaAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.1
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GdtAsynAreaAction
            public void doAction(IGdtAsynArea iGdtAsynArea) {
                iGdtAsynArea.getCore().reset();
            }
        }, new GDtCanvasUiAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.2
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GDtCanvasUiAction
            public void doAction(IGdtCanvasUi iGdtCanvasUi) {
                iGdtCanvasUi.reset();
            }
        }, dittoAreaView);
    }

    public static void setSubViewData(final BusinessFeedData businessFeedData, DittoAreaView dittoAreaView) {
        doForEachSubView(new GdtAsynAreaAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.3
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GdtAsynAreaAction
            public void doAction(IGdtAsynArea iGdtAsynArea) {
                iGdtAsynArea.getCore().setFeedData(BusinessFeedData.this);
            }
        }, new GDtCanvasUiAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.4
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GDtCanvasUiAction
            public void doAction(IGdtCanvasUi iGdtCanvasUi) {
                iGdtCanvasUi.setFeedData(BusinessFeedData.this);
            }
        }, dittoAreaView);
    }

    public static void updateSubView(DittoAreaView dittoAreaView) {
        doForEachSubView(new GdtAsynAreaAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.5
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GdtAsynAreaAction
            public void doAction(IGdtAsynArea iGdtAsynArea) {
                iGdtAsynArea.getCore().update();
            }
        }, new GDtCanvasUiAction() { // from class: com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.6
            @Override // com.qzone.module.feedcomponent.util.GdtCanvasUiUtil.GDtCanvasUiAction
            public void doAction(IGdtCanvasUi iGdtCanvasUi) {
                iGdtCanvasUi.update();
            }
        }, dittoAreaView);
    }

    public static String getUrlFromCells(ArrayList<TextCell> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<TextCell> it = arrayList.iterator();
        while (it.hasNext()) {
            TextCell next = it.next();
            if (!TextUtils.isEmpty(next.getUrl())) {
                return next.getUrl();
            }
        }
        return null;
    }
}
