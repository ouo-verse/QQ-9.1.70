package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasQzoneCardViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("qzone_card_fans_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_fans_desc = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_left_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_left_container = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_card_avatar", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_avatar = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasQzoneCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_card_fans", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_fans = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_divider", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_divider = dittoArea;
                }
            });
            hashMap.put("qzone_card_visitor", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_visitor = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_follow_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_follow_button = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasQzoneCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_card_right_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_right_container = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_card_root_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_root_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.9.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasQzoneCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_card_avatar_bg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_avatar_bg = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_desc = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.11.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasQzoneCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_card_nickname", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_nickname = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.12.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasQzoneCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_card_bg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_bg = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_famousspace_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_famousspace_icon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("qzone_card_center_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_center_container = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_card_visitor_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardViewIdFuncPoly.Holder.16
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasQzoneCardView) dittoAreaView).qzone_card_visitor_desc = (DittoTextArea) dittoArea;
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
