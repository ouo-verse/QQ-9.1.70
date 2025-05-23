package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.gdtui.CanvasRecommActionButton;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.CanvasFeedEventTagSmallTailArea;
import com.qzone.canvasui.widget.CanvasFlexPicAreaGroup;
import com.qzone.canvasui.widget.CanvasMultiGifArea;
import com.qzone.canvasui.widget.FeedDynamicAlbumCanvasArea;
import com.qzone.canvasui.widget.FeedSinglePicCanvasArea;
import com.qzone.canvasui.widget.LineArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TagImageArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasFeedContentViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("gdt_addGroup_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).gdt_addGroup_container = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_addGroup_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).gdt_addGroup_button = (CanvasRecommActionButton) dittoArea;
                }
            });
            hashMap.put("feed_content_normal_summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_normal_summary = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.3.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_addGroup_logo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).gdt_addGroup_logo = (CanvasAvatarArea) dittoArea;
                }
            });
            hashMap.put("feed_content_comment_pic", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_comment_pic = (CanvasMultiGifArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_flex_pic_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_flex_pic_area = (CanvasFlexPicAreaGroup) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.6.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_bizRecom_summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_bizRecom_summary = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.7.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_logo_attach_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_logo_attach_text = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_blog_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_blog_title = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("feed_content_picInfo_display", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_picInfo_display = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.10.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_no_photo_mode", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_no_photo_mode = (DittoImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.11.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.11.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("gdt_addGroup", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).gdt_addGroup = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("gdt_addGroup_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).gdt_addGroup_desc = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("feed_content_blog_normal_tag_img", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_blog_normal_tag_img = (TagImageArea) dittoArea;
                }
            });
            hashMap.put("gdt_bubble_danmaku_presenter_bridge_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.15.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_singal_pic", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.16
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_singal_pic = (FeedSinglePicCanvasArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.16.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.16.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_blog_normal_summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.17
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_blog_normal_summary = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("feed_content_blog_forward_nickname", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.18
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_blog_forward_nickname = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("feed_content_blog_normal_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.19
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_blog_normal_title = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("feed_content_dynamic_album", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.20
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_dynamic_album = (FeedDynamicAlbumCanvasArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.20.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.20.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_bizReco_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.21
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_bizReco_title = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.21.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.21.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("blog_line_area", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.22
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).blog_line_area = (LineArea) dittoArea;
                }
            });
            hashMap.put("canvas_feed_content_view", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.23
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).canvas_feed_content_view = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.23.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_multi_pic", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.24
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_multi_pic = (CanvasMultiGifArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.24.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.24.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_superlike_summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.25
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_superlike_summary = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.25.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.25.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_event_tag", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.26
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_event_tag = (CanvasFeedEventTagSmallTailArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.26.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_content_normal_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.27
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFeedContentView) dittoAreaView).feed_content_normal_title = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.27.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaOtherClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                    dittoArea.longClickListener = new DittoArea.LongClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentViewIdFuncPoly.Holder.27.2
                        @Override // com.tencent.ditto.area.DittoArea.LongClickListener
                        public void onLongClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFeedContentView) dittoAreaView).onCanvasAreaLongClick(dittoArea2, motionEvent, obj);
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
