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
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasRecomFollowListItemViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("feed_recommend_follow_nickname", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommend_follow_nickname = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("feed_recommmend_follow_divider", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommmend_follow_divider = dittoArea;
                }
            });
            hashMap.put("feed_recommend_follow_description", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommend_follow_description = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("recommend_follow_add_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).recommend_follow_add_button = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecomFollowListItemView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_recommend_follow_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommend_follow_icon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("feed_recommend_follow_contentview", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommend_follow_contentview = (RelativeAreaLayout) dittoArea;
                }
            });
            hashMap.put("feed_recommend_follow_item_layout", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowListItemView) dittoAreaView).feed_recommend_follow_item_layout = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemViewIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecomFollowListItemView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
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
