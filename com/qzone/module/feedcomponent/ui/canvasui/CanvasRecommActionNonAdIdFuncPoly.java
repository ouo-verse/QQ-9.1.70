package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasRecommActionNonAdIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("text_mini_app", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).text_mini_app = (DittoTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommActionNonAd) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("text_mini_app_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).text_mini_app_desc = (DittoTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommActionNonAd) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("right_button_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).right_button_area = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommActionNonAd) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("mini_app_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).mini_app_icon = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommActionNonAd) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_recomm_action_root_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).qzone_recomm_action_root_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommActionNonAd) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("full_height_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).full_height_icon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("layout_mini_app_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionNonAdIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommActionNonAd) dittoAreaView).layout_mini_app_text = (LinearAreaLayout) dittoArea;
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
