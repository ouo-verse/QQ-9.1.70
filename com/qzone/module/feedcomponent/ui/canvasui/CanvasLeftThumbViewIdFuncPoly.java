package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TagImageArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasLeftThumbViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("root_bg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).root_bg = (DittoAreaGroup) dittoArea;
                }
            });
            hashMap.put("left_thumb_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).left_thumb_root = (DittoAreaGroup) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLeftThumbView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("left_thumb_image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).left_thumb_image = (TagImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLeftThumbView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("left_thumb_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).left_thumb_title = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLeftThumbView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("shadow", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).shadow = dittoArea;
                }
            });
            hashMap.put("left_thumb_right_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).left_thumb_right_root = (DittoAreaGroup) dittoArea;
                }
            });
            hashMap.put("tag_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).tag_container = dittoArea;
                }
            });
            hashMap.put("left_thumb_content", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasLeftThumbView) dittoAreaView).left_thumb_content = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbViewIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasLeftThumbView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
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
