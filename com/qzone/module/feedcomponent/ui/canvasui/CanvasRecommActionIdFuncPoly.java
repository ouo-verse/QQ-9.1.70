package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.gdtui.CanvasRecommActionButton;
import com.qzone.canvasui.gdtui.asynarea.CanvasRecommFriends;
import com.qzone.canvasui.gdtui.asynarea.CanvasRecommStars;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasCountDownArea;
import com.qzone.canvasui.widget.CanvasGifArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasRecommActionIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("gdt_good_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_desc = (DittoTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("text_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).text_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("count_down_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).count_down_area = (CanvasCountDownArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("text_mini_app", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).text_mini_app = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("gdt_good_image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_image = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_good_desc_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_desc_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.6.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("right_button_gif_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).right_button_gif_area = (CanvasGifArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("friend_chain_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).friend_chain_area = (CanvasRecommFriends) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_label_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_label_container = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.9.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_label1", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_label1 = (CanvasRecommActionButton) dittoArea;
                }
            });
            hashMap.put("stars_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).stars_area = (CanvasRecommStars) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.11.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_dynamic_tag_gif", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_dynamic_tag_gif = (CanvasGifArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.12.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_label2", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_label2 = (CanvasRecommActionButton) dittoArea;
                }
            });
            hashMap.put("gdt_dynamic_tag_img", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_dynamic_tag_img = (DittoImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.14.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_label3", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_label3 = (CanvasRecommActionButton) dittoArea;
                }
            });
            hashMap.put("gdt_adv_animation_end_image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.16
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_adv_animation_end_image = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("gdt_good_bg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.17
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_bg = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.17.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_good_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.18
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_button = (CanvasRecommActionButton) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.18.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("right_button_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.19
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).right_button_area = (CanvasRecommActionButton) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.19.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_adv_animation_begin_image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.20
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_adv_animation_begin_image = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("gdt_good_prise", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.21
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_prise = (DittoTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.21.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("text_mini_app_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.22
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).text_mini_app_desc = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("mini_app_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.23
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).mini_app_icon = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("qzone_recomm_action_root_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.24
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).qzone_recomm_action_root_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.24.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_good_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.25
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).gdt_good_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.25.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecommAction) dittoAreaView).onAreaClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("layout_mini_app_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommActionIdFuncPoly.Holder.26
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecommAction) dittoAreaView).layout_mini_app_text = (LinearAreaLayout) dittoArea;
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
