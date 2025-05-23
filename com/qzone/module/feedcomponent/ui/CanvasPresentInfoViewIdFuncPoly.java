package com.qzone.module.feedcomponent.ui;

import android.view.MotionEvent;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasPresentInfoViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("presentRoot", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPresentInfoView) dittoAreaView).presentRoot = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasPresentInfoView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("presentAvatarList", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPresentInfoView) dittoAreaView).presentAvatarList = (DittoListArea) dittoArea;
                }
            });
            hashMap.put("presentCount", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPresentInfoView) dittoAreaView).presentCount = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("arrowIndicator", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPresentInfoView) dittoAreaView).arrowIndicator = (DittoImageArea) dittoArea;
                }
            });
            ID_FUNC_POLY = new DittoIdFuncPoly(hashMap);
        }

        Holder() {
        }
    }

    @Override // com.tencent.ditto.func.DittoIdFuncPolyProxy
    protected DittoIdFuncPoly getIdFuncPoly() {
        return Holder.ID_FUNC_POLY;
    }
}
