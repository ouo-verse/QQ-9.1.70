package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasLogoViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("logo_attach_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLogoView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("logo_img", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLogoView) dittoAreaView).logo_img = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLogoView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("logo_name", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLogoView) dittoAreaView).logo_name = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLogoView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("logo_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLogoView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("logo_jump_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLogoView) dittoAreaView).logo_jump_button = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLogoView) dittoAreaView).onJump(dittoArea2, motionEvent, obj);
                        }
                    };
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
