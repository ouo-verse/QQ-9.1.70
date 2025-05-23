package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAttachArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.CanvasFeedRecommendListArea;
import com.qzone.canvasui.widget.CanvasGifArea;
import com.qzone.canvasui.widget.CanvasNicknameArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TimeCountDownArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.FlexLinearAreaLayout;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasTitleViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("passive_comment_btn", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).passive_comment_btn = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("upper_banner_close_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).upper_banner_close_button = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("upper_banner_background_image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).upper_banner_background_image = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("icon_YellowVip_gif", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_YellowVip_gif = (CanvasGifArea) dittoArea;
                }
            });
            hashMap.put("line_1_2", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).line_1_2 = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("friendlike_play_count_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).friendlike_play_count_area = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("line_1_1", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).line_1_1 = (FlexLinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("feed_title_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).feed_title_root = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_vip_signature", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).qzone_vip_signature = (DittoImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.9.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_qq_union_vip", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_qq_union_vip = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("passive_comment_like_btn_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).passive_comment_like_btn_container = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.11.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzonedesc_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).qzonedesc_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.12.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("original_flag", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).original_flag = dittoArea;
                }
            });
            hashMap.put("high_five_count_first_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).high_five_count_first_area = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("avatar_bottom_bar_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).avatar_bottom_bar_container = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("time_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.16
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).time_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.16.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("title_upper_banner", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.17
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).title_upper_banner = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.17.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("del_time_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.18
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).del_time_area = (TimeCountDownArea) dittoArea;
                }
            });
            hashMap.put("high_five_count_second_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.19
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).high_five_count_second_area = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("icon_familyMedal", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.20
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_familyMedal = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.20.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("campus_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.21
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).campus_area = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("name_plate_layout", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.22
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).name_plate_layout = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.22.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_famous", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.23
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_famous = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("icon_LoverZone", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.24
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_LoverZone = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.24.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_YellowVip_staticpic", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.25
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_YellowVip_staticpic = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("action_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.26
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).action_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.26.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("permission_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.27
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).permission_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.27.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("avatar_bottom_bar", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.28
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).avatar_bottom_bar = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("recommend_list_header", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.29
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).recommend_list_header = (CanvasFeedRecommendListArea) dittoArea;
                }
            });
            hashMap.put("icon_LiveMedal", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.30
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_LiveMedal = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.30.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_starvip", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.31
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_starvip = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.31.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("yellowdiamond_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.32
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).yellowdiamond_container = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.32.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_skin_animation_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.33
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).feed_skin_animation_container = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("nickname", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.34
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).nickname = (CanvasNicknameArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.34.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("follow_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.35
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).follow_button = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.35.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("refer_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.36
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).refer_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.36.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("avatar_decoration", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.37
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).avatar_decoration = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.37.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("recommend_list_header_split_line", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.38
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).recommend_list_header_split_line = dittoArea;
                }
            });
            hashMap.put("upper_banner_close_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.39
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).upper_banner_close_container = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.39.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("line_1", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.40
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).line_1 = (RelativeAreaLayout) dittoArea;
                }
            });
            hashMap.put("line_2", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.41
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).line_2 = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("passive_comment_like_btn", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.42
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).passive_comment_like_btn = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("passive_comment_btn_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.43
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).passive_comment_btn_container = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.43.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("attach_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.44
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).attach_area = (CanvasAttachArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.44.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.44.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("avatar", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.45
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).avatar = (CanvasAvatarArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.45.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_Standalone", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.46
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).icon_Standalone = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.46.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("upper_banner_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.47
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).upper_banner_title = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("btn_menu_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.48
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).btn_menu_area = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.48.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("high_five_count_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.49
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).high_five_count_container = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("add_friend_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.50
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).add_friend_button = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.50.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("count_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.51
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).count_area = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("upper_banner_summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.52
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).upper_banner_summary = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("feed_skin", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.53
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasTitleView) dittoAreaView).feed_skin = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleViewIdFuncPoly.Holder.53.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasTitleView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
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
