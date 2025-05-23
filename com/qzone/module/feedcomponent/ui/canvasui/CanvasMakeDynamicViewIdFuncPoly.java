package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasMakeDynamicViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("big_small_tail_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).big_small_tail_root = (DittoAreaGroup) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasMakeDynamicView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("big_small_tail_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).big_small_tail_icon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("dynamic_hint", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).dynamic_hint = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("make_dynamic_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).make_dynamic_button = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasMakeDynamicView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("dynamic_img", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).dynamic_img = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("dynamic_root_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).dynamic_root_container = (DittoAreaGroup) dittoArea;
                }
            });
            hashMap.put("big_small_tail_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasMakeDynamicView) dittoAreaView).big_small_tail_text = (RichCanvasTextArea) dittoArea;
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
